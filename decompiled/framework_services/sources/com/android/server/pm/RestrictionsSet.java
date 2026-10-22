package com.android.server.pm;

import android.os.Bundle;
import android.os.UserManager;
import android.util.IntArray;
import android.util.SparseArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.BundleUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictionsSet {
    private static final String TAG_RESTRICTIONS = "restrictions";
    private static final String TAG_RESTRICTIONS_USER = "restrictions_user";
    private static final String USER_ID = "user_id";
    private final SparseArray<Bundle> mUserRestrictions;

    public RestrictionsSet() {
        this.mUserRestrictions = new SparseArray(0);
    }

    public RestrictionsSet(int userId, Bundle restrictions) {
        this.mUserRestrictions = new SparseArray(0);
        if (restrictions.isEmpty() == true) goto L7;
        this.mUserRestrictions.put(userId, restrictions);
        UserManager.invalidateUserRestriction();
        return;
    L7:
        throw new IllegalArgumentException("empty restriction bundle cannot be added.");
    }

    public boolean updateRestrictions(int userId, Bundle restrictions) {
        boolean changed = !UserRestrictionsUtils.areEqual(this.mUserRestrictions.get(userId), restrictions);
        if (changed == true) goto L7;
        return false;
    L7:
        if (BundleUtils.isEmpty(restrictions) == true) goto L9;
        this.mUserRestrictions.put(userId, restrictions);
    L10:
        UserManager.invalidateUserRestriction();
        return true;
    L9:
        this.mUserRestrictions.delete(userId);
        goto L10
    }

    public boolean removeRestrictionsForAllUsers(String restriction) {
        boolean removed = false;
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L10;
        Bundle restrictions = this.mUserRestrictions.valueAt(i);
        if (UserRestrictionsUtils.contains(restrictions, restriction) == false) goto L8;
        restrictions.remove(restriction);
        removed = true;
    L8:
        i = i + 1;
        goto L4
    L10:
        if (removed == false) goto L12;
        UserManager.invalidateUserRestriction();
    L12:
        return removed;
    }

    public void moveRestriction(RestrictionsSet destRestrictions, String restriction) {
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L16;
        int userId = this.mUserRestrictions.keyAt(i);
        Bundle from = this.mUserRestrictions.valueAt(i);
        if (UserRestrictionsUtils.contains(from, restriction) == false) goto L14;
        from.remove(restriction);
        Bundle to = destRestrictions.getRestrictions(userId);
        if (to != null) goto L10;
        Bundle to2 = new Bundle();
        to2.putBoolean(restriction, true);
        destRestrictions.updateRestrictions(userId, to2);
    L12:
        if (from.isEmpty() == false) goto L14;
        this.mUserRestrictions.removeAt(i);
        i = i - 1;
        goto L14
    L10:
        to.putBoolean(restriction, true);
    L14:
        UserManager.invalidateUserRestriction();
        i = i + 1;
        goto L4
    }

    public boolean isEmpty() {
        if (this.mUserRestrictions.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Bundle mergeAll() {
        Bundle result = new Bundle();
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L7;
        UserRestrictionsUtils.merge(result, this.mUserRestrictions.valueAt(i));
        i = i + 1;
        goto L4
    L7:
        return result;
    }

    public List<UserManager.EnforcingUser> getEnforcingUsers(String restriction, int userId) {
        List<UserManager.EnforcingUser> result = new ArrayList();
        if (getRestrictionsNonNull(userId).containsKey(restriction) == false) goto L6;
        result.add(new UserManager.EnforcingUser(userId, 4));
    L6:
        if (getRestrictionsNonNull(-1).containsKey(restriction) == false) goto L8;
        result.add(new UserManager.EnforcingUser(-1, 2));
    L8:
        return result;
    }

    public Bundle getRestrictions(int userId) {
        return this.mUserRestrictions.get(userId);
    }

    public Bundle getRestrictionsNonNull(int userId) {
        return UserRestrictionsUtils.nonNull(this.mUserRestrictions.get(userId));
    }

    public boolean remove(int userId) {
        boolean hasUserRestriction = this.mUserRestrictions.contains(userId);
        this.mUserRestrictions.remove(userId);
        UserManager.invalidateUserRestriction();
        return hasUserRestriction;
    }

    public void removeAllRestrictions() {
        this.mUserRestrictions.clear();
        UserManager.invalidateUserRestriction();
    }

    public void writeRestrictions(TypedXmlSerializer serializer, String outerTag) throws IOException {
        serializer.startTag(null, outerTag);
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L6;
        serializer.startTag(null, TAG_RESTRICTIONS_USER);
        serializer.attributeInt(null, USER_ID, this.mUserRestrictions.keyAt(i));
        UserRestrictionsUtils.writeRestrictions(serializer, this.mUserRestrictions.valueAt(i), TAG_RESTRICTIONS);
        serializer.endTag(null, TAG_RESTRICTIONS_USER);
        i = i + 1;
        goto L4
    L6:
        serializer.endTag(null, outerTag);
    }

    public static RestrictionsSet readRestrictions(TypedXmlPullParser parser, String outerTag) throws IOException, XmlPullParserException {
        RestrictionsSet restrictionsSet = new RestrictionsSet();
        int userId = 0;
    L3:
        int type = parser.next();
        if (type == 1) goto L21;
        String tag = parser.getName();
        if (type != 3) goto L11;
        if (outerTag.equals(tag) == false) goto L11;
        return restrictionsSet;
    L11:
        if (type != 2) goto L15;
        if (TAG_RESTRICTIONS_USER.equals(tag) == false) goto L15;
        userId = parser.getAttributeInt(null, USER_ID);
    L15:
        if (type != 2) goto L3;
        if (TAG_RESTRICTIONS.equals(tag) == false) goto L3;
        Bundle restrictions = UserRestrictionsUtils.readRestrictions(parser);
        restrictionsSet.updateRestrictions(userId, restrictions);
        goto L3
    L21:
        throw new XmlPullParserException("restrictions cannot be read as xml is malformed.");
    }

    public void dumpRestrictions(PrintWriter pw, String prefix) {
        boolean noneSet = true;
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L7;
        pw.println(prefix + "User Id: " + this.mUserRestrictions.keyAt(i));
        StringBuilder r2 = new StringBuilder();
        r2.append(prefix);
        r2.append("  ");
        UserRestrictionsUtils.dumpRestrictions(pw, r2.toString(), this.mUserRestrictions.valueAt(i));
        noneSet = false;
        i = i + 1;
        goto L4
    L7:
        if (noneSet == false) goto L11;
        pw.println(prefix + "none");
        return;
    }

    public IntArray getUserIds() {
        IntArray userIds = new IntArray(this.mUserRestrictions.size());
        int i = 0;
    L4:
        if (i >= this.mUserRestrictions.size()) goto L7;
        userIds.add(this.mUserRestrictions.keyAt(i));
        i = i + 1;
        goto L4
    L7:
        return userIds;
    }

    public boolean containsKey(int userId) {
        return this.mUserRestrictions.contains(userId);
    }

    public int size() {
        return this.mUserRestrictions.size();
    }

    public int keyAt(int index) {
        return this.mUserRestrictions.keyAt(index);
    }

    public Bundle valueAt(int index) {
        return this.mUserRestrictions.valueAt(index);
    }
}
