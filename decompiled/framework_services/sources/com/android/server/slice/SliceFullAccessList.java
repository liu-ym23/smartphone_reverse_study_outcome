package com.android.server.slice;

import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserManager;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class SliceFullAccessList {
    static final int DB_VERSION = 1;
    private static final String TAG = "SliceFullAccessList";
    private static final String TAG_LIST = "slice-access-list";
    private static final String TAG_PKG = "pkg";
    private static final String TAG_USER = "user";
    private final String ATT_USER_ID;
    private final String ATT_VERSION;
    private final Context mContext;
    private final SparseArray<ArraySet<String>> mFullAccessPkgs;

    public SliceFullAccessList(Context context) {
        this.ATT_USER_ID = TAG_USER;
        this.ATT_VERSION = "version";
        this.mFullAccessPkgs = new SparseArray();
        this.mContext = context;
    }

    public boolean hasFullAccess(String pkg, int userId) {
        ArraySet<String> pkgs = this.mFullAccessPkgs.get(userId, null);
        if (pkgs != null) goto L5;
    L7:
        return false;
    L5:
        if (pkgs.contains(pkg) == false) goto L7;
        return true;
    }

    public void grantFullAccess(String pkg, int userId) {
        ArraySet<String> pkgs = this.mFullAccessPkgs.get(userId, null);
        if (pkgs != null) goto L5;
        pkgs = new ArraySet();
        this.mFullAccessPkgs.put(userId, pkgs);
    L5:
        pkgs.add(pkg);
    }

    public void removeGrant(String pkg, int userId) {
        ArraySet<String> pkgs = this.mFullAccessPkgs.get(userId, null);
        if (pkgs != null) goto L5;
        pkgs = new ArraySet();
        this.mFullAccessPkgs.put(userId, pkgs);
    L5:
        pkgs.remove(pkg);
    }

    public void writeXml(XmlSerializer out, int user) throws IOException {
        out.startTag(null, TAG_LIST);
        out.attribute(null, "version", String.valueOf(1));
        int N = this.mFullAccessPkgs.size();
        int i = 0;
    L3:
        if (i >= N) goto L15;
        int userId = this.mFullAccessPkgs.keyAt(i);
        ArraySet<String> pkgs = this.mFullAccessPkgs.valueAt(i);
        if (user == (-1)) goto L8;
        if (user == userId) goto L8;
    L14:
        i = i + 1;
    L8:
        out.startTag(null, TAG_USER);
        out.attribute(null, TAG_USER, Integer.toString(userId));
        if (pkgs == null) goto L13;
        int M = pkgs.size();
        int j = 0;
    L11:
        if (j >= M) goto L13;
        out.startTag(null, "pkg");
        out.text(pkgs.valueAt(j));
        out.endTag(null, "pkg");
        j = j + 1;
    L13:
        out.endTag(null, TAG_USER);
        goto L14
    L15:
        out.endTag(null, TAG_LIST);
    }

    public void readXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        int xmlVersion = XmlUtils.readIntAttribute(parser, "version", 0);
        List<UserInfo> activeUsers = UserManager.get(this.mContext).getAliveUsers();
        Iterator<UserInfo> r3 = activeUsers.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        UserInfo userInfo = r3.next();
        upgradeXml(xmlVersion, userInfo.getUserHandle().getIdentifier());
        goto L4
    L6:
        this.mFullAccessPkgs.clear();
    L7:
        int type = parser.next();
        if (type == 1) goto L33;
        String tag = parser.getName();
        if (type != 3) goto L15;
        if (TAG_LIST.equals(tag) == false) goto L15;
        return;
    L15:
        if (type != 2) goto L7;
        if (TAG_USER.equals(tag) == false) goto L7;
        int userId = XmlUtils.readIntAttribute(parser, TAG_USER, 0);
        ArraySet<String> pkgs = new ArraySet();
    L19:
        int type2 = parser.next();
        if (type2 == 1) goto L31;
        String userTag = parser.getName();
        if (type2 == 3) goto L24;
    L26:
        if (type2 != 2) goto L19;
        if ("pkg".equals(userTag) == false) goto L19;
        String pkg = parser.nextText();
        pkgs.add(pkg);
        goto L19
    L24:
        if (TAG_USER.equals(userTag) == false) goto L26;
    L31:
        this.mFullAccessPkgs.put(userId, pkgs);
        goto L7
    }

    protected void upgradeXml(int xmlVersion, int userId) {
    }
}
