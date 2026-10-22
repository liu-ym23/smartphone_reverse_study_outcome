package com.android.contacts.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.common.model.account.ExchangeAccountType;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ValuesDelta implements Parcelable {
    public static final Parcelable.Creator<ValuesDelta> CREATOR = null;
    protected static int sNextInsertId = -1;
    protected ContentValues mAfter;
    protected ContentValues mBefore;
    private boolean mFromTemplate;
    protected String mIdColumn;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ValuesDelta() {
        this.mIdColumn = "_id";
    }

    public static ValuesDelta fromBefore(ContentValues r4) {
        ValuesDelta r0 = new ValuesDelta();
        r0.mBefore = r4;
        r0.mAfter = new ContentValues();
        String r1 = r4.getAsString("account_type");
        if (r4.containsKey("data1") == false) goto L13;
        if (r1 == null) goto L8;
        if (r1 == null) goto L13;
        if (ExchangeAccountType.isExchangeType(r1) == true) goto L13;
    L8:
        String r5 = r4.getAsString("data1");
        if (r5 == null) goto L13;
        if ("".equals(r5) == true) goto L13;
        r0.mAfter.put("data1", r5);
    L13:
        return r0;
    }

    public static ValuesDelta fromAfter(ContentValues r4) {
        ValuesDelta r0 = new ValuesDelta();
        r0.mBefore = null;
        r0.mAfter = r4;
        String r1 = r0.mIdColumn;
        int r2 = sNextInsertId;
        sNextInsertId = r2 - 1;
        r4.put(r1, Integer.valueOf(r2));
        return r0;
    }

    public ContentValues getAfter() {
        return this.mAfter;
    }

    public ContentValues getBefore() {
        return this.mBefore;
    }

    public boolean containsKey(String r2) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L6:
        ContentValues r1 = this.mBefore;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.containsKey(r2) == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.containsKey(r2) == true) goto L10;
        goto L6
    }

    public String getAsString(String r2) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L8:
        ContentValues r1 = this.mBefore;
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r1.containsKey(r2) == true) goto L13;
        return null;
    L13:
        return this.mBefore.getAsString(r2);
    L5:
        if (r0.containsKey(r2) == false) goto L8;
        return this.mAfter.getAsString(r2);
    }

    public byte[] getAsByteArray(String r2) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L8:
        ContentValues r1 = this.mBefore;
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r1.containsKey(r2) == true) goto L13;
        return null;
    L13:
        return this.mBefore.getAsByteArray(r2);
    L5:
        if (r0.containsKey(r2) == false) goto L8;
        return this.mAfter.getAsByteArray(r2);
    }

    public Long getAsLong(String r2) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L8:
        ContentValues r1 = this.mBefore;
        if (r1 != null) goto L11;
        return null;
    L11:
        if (r1.containsKey(r2) == true) goto L13;
        return null;
    L13:
        return this.mBefore.getAsLong(r2);
    L5:
        if (r0.containsKey(r2) == false) goto L8;
        return this.mAfter.getAsLong(r2);
    }

    public Integer getAsInteger(String r2) {
        return getAsInteger(r2, null);
    }

    public Integer getAsInteger(String r2, Integer r3) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L8:
        ContentValues r1 = this.mBefore;
        if (r1 != null) goto L11;
    L14:
        return r3;
    L11:
        if (r1.containsKey(r2) == false) goto L14;
        return this.mBefore.getAsInteger(r2);
    L5:
        if (r0.containsKey(r2) == false) goto L8;
        return this.mAfter.getAsInteger(r2);
    }

    public boolean isChanged(String r3) {
        ContentValues r0 = this.mAfter;
        if (r0 != null) goto L5;
    L14:
        return false;
    L5:
        if (r0.containsKey(r3) == false) goto L14;
        Object r1 = this.mAfter.get(r3);
        Object r2 = this.mBefore.get(r3);
        if (r2 != null) goto L13;
        if (r1 != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        return !r2.equals(r1);
    }

    public String getMimetype() {
        return getAsString("mimetype");
    }

    public Long getId() {
        return getAsLong(this.mIdColumn);
    }

    public void setIdColumn(String r1) {
        this.mIdColumn = r1;
    }

    public boolean isPrimary() {
        Long r5 = getAsLong("is_primary");
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.longValue() == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void setFromTemplate(boolean r1) {
        this.mFromTemplate = r1;
    }

    public boolean isFromTemplate() {
        return this.mFromTemplate;
    }

    public boolean isSuperPrimary() {
        Long r5 = getAsLong("is_super_primary");
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.longValue() == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean beforeExists() {
        ContentValues r0 = this.mBefore;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.containsKey(this.mIdColumn) == false) goto L7;
        return true;
    }

    public boolean isVisible() {
        if (this.mAfter == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDelete() {
        if (beforeExists() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAfter != null) goto L7;
        return true;
    }

    public boolean isTransient() {
        if (this.mBefore == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAfter != null) goto L7;
        return true;
    }

    public boolean isUpdate() {
        if (beforeExists() == false) goto L19;
        ContentValues r0 = this.mAfter;
        if (r0 == null) goto L19;
        if (r0.size() == 0) goto L19;
        Iterator<String> r1 = this.mAfter.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L19;
        String r2 = r1.next();
        Object r3 = this.mAfter.get(r2);
        Object r4 = this.mBefore.get(r2);
        if (r4 == null) goto L14;
        if (r4.equals(r3) == true) goto L11;
        return true;
    L14:
        if (r3 == null) goto L11;
        return true;
    L19:
        return false;
    }

    public boolean isNoop() {
        if (beforeExists() == false) goto L9;
        ContentValues r1 = this.mAfter;
        if (r1 == null) goto L9;
        if (r1.size() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isInsert() {
        if (beforeExists() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mAfter == null) goto L7;
        return true;
    }

    public void markDeleted() {
        this.mAfter = null;
    }

    private void ensureUpdate() {
        if (this.mAfter != null) goto L6;
        this.mAfter = new ContentValues();
        return;
    }

    public void put(String r1, String r2) {
        ensureUpdate();
        this.mAfter.put(r1, r2);
    }

    public void put(String r1, byte[] r2) {
        ensureUpdate();
        this.mAfter.put(r1, r2);
    }

    public void put(String r1, int r2) {
        ensureUpdate();
        this.mAfter.put(r1, Integer.valueOf(r2));
    }

    public void put(String r1, long r2) {
        ensureUpdate();
        this.mAfter.put(r1, Long.valueOf(r2));
    }

    public void putNull(String r1) {
        ensureUpdate();
        this.mAfter.putNull(r1);
    }

    public void copyStringFrom(ValuesDelta r2, String r3) {
        ensureUpdate();
        if (containsKey(r3) == false) goto L5;
    L6:
        put(r3, r2.getAsString(r3));
        return;
    L5:
        if (r2.containsKey(r3) == true) goto L6;
    }

    public Set<String> keySet() {
        HashSet r0 = Sets.newHashSet();
        ContentValues r1 = this.mBefore;
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r2 = r1.valueSet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.add(r2.next().getKey());
    L8:
        ContentValues r3 = this.mAfter;
        if (r3 == null) goto L14;
        Iterator<Map.Entry<String, Object>> r4 = r3.valueSet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r0.add(r4.next().getKey());
    L14:
        return r0;
    }

    public ContentValues getCompleteValues() {
        ContentValues r0 = new ContentValues();
        ContentValues r1 = this.mBefore;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        ContentValues r2 = this.mAfter;
        if (r2 == null) goto L9;
        r0.putAll(r2);
    L9:
        if (r0.containsKey("data1") == false) goto L11;
        r0.remove("group_sourceid");
    L11:
        return r0;
    }

    public static ValuesDelta mergeAfter(ValuesDelta r1, ValuesDelta r2) {
        if (r1 == null) goto L4;
    L9:
        if (r1 != null) goto L12;
        r1 = new ValuesDelta();
    L12:
        if (r1.beforeExists() == true) goto L14;
        r1.mAfter = r2.getCompleteValues();
    L15:
        return r1;
    L14:
        r1.mAfter = r2.mAfter;
        goto L15
    L4:
        if (r2.isDelete() == false) goto L6;
        return null;
    L6:
        if (r2.isTransient() == false) goto L9;
        return null;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof ValuesDelta) == false) goto L10;
        ValuesDelta r4 = (ValuesDelta) r3;
        if (subsetEquals(r4) == true) goto L7;
        return false;
    L7:
        if (r4.subsetEquals(this) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        toString(r0);
        return r0.toString();
    }

    public void toString(StringBuilder r5) {
        r5.append("{ ");
        r5.append("IdColumn=");
        r5.append(this.mIdColumn);
        r5.append(", FromTemplate=");
        r5.append(this.mFromTemplate);
        r5.append(", ");
        Iterator<String> r1 = keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r5.append(r2);
        r5.append("=");
        r5.append(getAsString(r2));
        r5.append(", ");
        goto L4
    L6:
        r5.append("}");
    }

    public boolean subsetEquals(ValuesDelta r5) {
        Iterator<String> r0 = keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        String r2 = getAsString(r1);
        String r3 = r5.getAsString(r1);
        if (r2 == null) goto L7;
        if (r2.equals(r3) == true) goto L4;
        return false;
    L7:
        if (r3 == null) goto L4;
        return false;
    L12:
        return true;
    }

    public ContentProviderOperation.Builder buildDiff(Uri r1) {
        return buildDiffHelper(r1);
    }

    public BuilderWrapper buildDiffWrapper(Uri r2) {
        ContentProviderOperation.Builder r3 = buildDiffHelper(r2);
        if (isInsert() == false) goto L6;
        return new BuilderWrapper(r3, 1);
    L6:
        if (isDelete() == false) goto L9;
        return new BuilderWrapper(r3, 3);
    L9:
        if (isUpdate() == true) goto L15;
        return null;
    L15:
        return new BuilderWrapper(r3, 2);
    }

    private ContentProviderOperation.Builder buildDiffHelper(Uri r5) {
        if (isInsert() == false) goto L6;
        this.mAfter.remove(this.mIdColumn);
        ContentProviderOperation.Builder r6 = ContentProviderOperation.newInsert(r5);
        r6.withValues(this.mAfter);
        return r6;
    L6:
        if (isDelete() == false) goto L9;
        ContentProviderOperation.Builder r7 = ContentProviderOperation.newDelete(r5);
        r7.withSelection(this.mIdColumn + "=" + getId(), null);
        return r7;
    L9:
        if (isUpdate() == false) goto L12;
        ContentProviderOperation.Builder r8 = ContentProviderOperation.newUpdate(r5);
        r8.withSelection(this.mIdColumn + "=" + getId(), null);
        r8.withValues(this.mAfter);
        return r8;
    L12:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mBefore, r3);
        r2.writeParcelable(this.mAfter, r3);
        r2.writeString(this.mIdColumn);
    }

    public void readFromParcel(Parcel r3) {
        ClassLoader r0 = getClass().getClassLoader();
        this.mBefore = (ContentValues) r3.readParcelable(r0);
        this.mAfter = (ContentValues) r3.readParcelable(r0);
        this.mIdColumn = r3.readString();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public void setGroupRowId(long r2) {
        put("data1", r2);
    }

    public Long getGroupRowId() {
        return getAsLong("data1");
    }

    public void setPhoto(byte[] r2) {
        put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, r2);
    }

    public byte[] getPhoto() {
        return getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
    }

    public void setSuperPrimary(boolean r2) {
        if (r2 == false) goto L5;
        put("is_super_primary", 1);
        return;
    L5:
        put("is_super_primary", 0);
    }

    public void setPhoneticFamilyName(String r2) {
        put("data9", r2);
    }

    public void setPhoneticMiddleName(String r2) {
        put("data8", r2);
    }

    public void setPhoneticGivenName(String r2) {
        put("data7", r2);
    }

    public String getPhoneticFamilyName() {
        return getAsString("data9");
    }

    public String getPhoneticMiddleName() {
        return getAsString("data8");
    }

    public String getPhoneticGivenName() {
        return getAsString("data7");
    }

    public String getDisplayName() {
        return getAsString("data1");
    }

    public void setDisplayName(String r2) {
        if (r2 != null) goto L5;
        putNull("data1");
        return;
    L5:
        put("data1", r2);
    }

    public void copyStructuredNameFieldsFrom(ValuesDelta r2) {
        copyStringFrom(r2, "data1");
        copyStringFrom(r2, DBHelper.COL_DATA2);
        copyStringFrom(r2, DBHelper.COL_DATA3);
        copyStringFrom(r2, "data4");
        copyStringFrom(r2, "data5");
        copyStringFrom(r2, "data6");
        copyStringFrom(r2, "data7");
        copyStringFrom(r2, "data8");
        copyStringFrom(r2, "data9");
        copyStringFrom(r2, "data10");
        copyStringFrom(r2, "data11");
    }

    public String getPhoneNumber() {
        return getAsString("data1");
    }

    public String getPhoneNormalizedNumber() {
        return getAsString("data4");
    }

    public boolean hasPhoneType() {
        if (getPhoneType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Integer getPhoneType() {
        return getAsInteger(DBHelper.COL_DATA2);
    }

    public String getPhoneLabel() {
        return getAsString(DBHelper.COL_DATA3);
    }

    public String getEmailData() {
        return getAsString("data1");
    }

    public boolean hasEmailType() {
        if (getEmailType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Integer getEmailType() {
        return getAsInteger(DBHelper.COL_DATA2);
    }

    public String getEmailLabel() {
        return getAsString(DBHelper.COL_DATA3);
    }
}
