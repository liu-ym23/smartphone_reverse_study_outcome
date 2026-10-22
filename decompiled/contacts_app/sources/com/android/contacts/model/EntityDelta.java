package com.android.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.Collapser;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsUtils;
import com.android.contacts.GroupMetaData;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.NameConverter;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes2.dex */
public class EntityDelta implements Parcelable {
    public static final Parcelable.Creator<EntityDelta> CREATOR = null;
    private static final boolean LOGV = false;
    private static final String TAG = "EntityDelta";
    private Uri mContactsQueryUri;
    private HashMap<String, ArrayList<ValuesDelta>> mEntries;
    private HashMap<Long, AccountWithDataSet> mRefRawContacts;
    public ValuesDelta mValues;

    public static class ValuesDelta implements Parcelable, Collapser.Collapsible<ValuesDelta> {
        public static final Parcelable.Creator<ValuesDelta> CREATOR = null;
        protected static int sNextInsertId = -1;
        protected ContentValues mAfter;
        protected ContentValues mBefore;
        private boolean mFromTemplate;
        protected String mIdColumn;
        public boolean mIsTextBoldAndBlue;
        protected ArrayList<ValuesDelta> mRefValuesDelta;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean collapseWith(ValuesDelta r1) {
            return collapseWith2(r1);
        }

        @Override // com.android.contacts.Collapser.Collapsible
        public /* bridge */ /* synthetic */ boolean shouldCollapseWith(ValuesDelta r1) {
            return shouldCollapseWith2(r1);
        }

        public void addRefValuesDelta(ValuesDelta r2) {
            if (this.mRefValuesDelta != null) goto L5;
            this.mRefValuesDelta = new ArrayList();
        L5:
            this.mRefValuesDelta.add(r2);
        }

        public void updateRefValuesDelta(String r2, String r3) {
            ArrayList<ValuesDelta> r1 = this.mRefValuesDelta;
            if (r1 != null) goto L5;
            return;
        L5:
            Iterator<ValuesDelta> r4 = r1.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            r4.next().put(r2, r3);
            goto L7
        }

        public void updateRefValuesDelta(String r2, byte[] r3) {
            ArrayList<ValuesDelta> r1 = this.mRefValuesDelta;
            if (r1 != null) goto L5;
            return;
        L5:
            Iterator<ValuesDelta> r4 = r1.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            r4.next().put(r2, r3);
            goto L7
        }

        public void setRefFromTemplate(boolean r2) {
            ArrayList<ValuesDelta> r1 = this.mRefValuesDelta;
            if (r1 != null) goto L5;
            return;
        L5:
            Iterator<ValuesDelta> r3 = r1.iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            r3.next().setFromTemplate(r2);
            goto L7
        }

        protected ValuesDelta() {
            this.mIdColumn = "_id";
            this.mIsTextBoldAndBlue = false;
        }

        public static ValuesDelta fromBefore(ContentValues r1) {
            ValuesDelta r0 = new ValuesDelta();
            r0.mBefore = r1;
            r0.mAfter = new ContentValues();
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

        public ContentValues getBefore() {
            return this.mBefore;
        }

        public ContentValues getAfter() {
            return this.mAfter;
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

        public void revertInsert() {
            if (this.mAfter.containsKey("mimetype") == false) goto L5;
            String r0 = this.mAfter.getAsString("mimetype");
        L7:
            if (this.mAfter.containsKey(this.mIdColumn) == false) goto L9;
            int r2 = this.mAfter.getAsInteger(this.mIdColumn).intValue();
        L10:
            this.mAfter.clear();
            this.mAfter.put("mimetype", r0);
            this.mAfter.put(this.mIdColumn, Integer.valueOf(r2));
            return;
        L9:
            r2 = sNextInsertId;
            sNextInsertId = r2 - 1;
            goto L10
        L5:
            r0 = "";
            goto L7
        }

        public void revertUpdate() {
            if (beforeExists() == false) goto L11;
            ContentValues r0 = this.mAfter;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.size() == 0) goto L13;
            this.mAfter.clear();
            this.mAfter.putAll(this.mBefore);
            return;
        L13:
            return;
        }

        public void revertRemove() {
            ContentValues r0 = new ContentValues();
            this.mAfter = r0;
            r0.putAll(this.mBefore);
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

        public void markRefDeleted() {
            ArrayList<ValuesDelta> r1 = this.mRefValuesDelta;
            if (r1 != null) goto L5;
            return;
        L5:
            Iterator<ValuesDelta> r2 = r1.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            r2.next().markDeleted();
            goto L7
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

        public void toString(StringBuilder r4) {
            r4.append("{ ");
            Iterator<String> r0 = keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            String r1 = r0.next();
            r4.append(r1);
            r4.append("=");
            r4.append(getAsString(r1));
            r4.append(", ");
            goto L4
        L6:
            r4.append("}");
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

        public ContentProviderOperation.Builder buildDiff(Uri r5) {
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

        public void setTextBoldAndBlue(boolean r1) {
            this.mIsTextBoldAndBlue = r1;
        }

        public void setSuperPrimary(boolean r2) {
            if (r2 == false) goto L5;
            put("is_super_primary", 1);
            return;
        L5:
            put("is_super_primary", 0);
        }

        public void setPhoto(byte[] r2) {
            put(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, r2);
        }

        /* JADX INFO: renamed from: collapseWith, reason: avoid collision after fix types in other method */
        public boolean collapseWith2(ValuesDelta r2) {
            if (this.mBefore != null) goto L6;
            return false;
        L6:
            addRefValuesDelta(r2);
            return true;
        }

        /* JADX INFO: renamed from: shouldCollapseWith, reason: avoid collision after fix types in other method */
        public boolean shouldCollapseWith2(ValuesDelta r11) {
            if (r11 != null) goto L5;
            return false;
        L5:
            ContentValues r1 = this.mBefore;
            ContentValues r2 = r11.mBefore;
            if (r1 != r2) goto L8;
            return true;
        L8:
            if (r1 == null) goto L22;
            if (r2 == null) goto L22;
            String r4 = r1.getAsString("mimetype");
            String r6 = r11.mBefore.getAsString("mimetype");
            String r5 = this.mBefore.getAsString("data1");
            String r7 = r11.mBefore.getAsString("data1");
            boolean r9 = TextUtils.equals(this.mBefore.getAsString(DBHelper.COL_DATA2), r11.mBefore.getAsString(DBHelper.COL_DATA2));
            if (TextUtils.equals(r6, r4) == false) goto L21;
            if (TextUtils.equals(r6, "vnd.android.cursor.item/contact_event") == false) goto L21;
            if (TextUtils.equals(r5, r7) == false) goto L23;
            if (r9 == true) goto L19;
            return false;
        L19:
            return true;
        L23:
            return false;
        L21:
            return ContactsUtils.shouldCollapse(r4, r5, r6, r7, true, r9);
        L22:
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        LOGV = ContactsUtils.DEBUG;
        CREATOR = new AnonymousClass1();
    }

    public HashMap<String, ArrayList<ValuesDelta>> getmEntries() {
        return this.mEntries;
    }

    public EntityDelta() {
        this.mContactsQueryUri = ContactsContract.RawContacts.CONTENT_URI;
        this.mEntries = Maps.newHashMap();
    }

    public EntityDelta(ValuesDelta r2) {
        this.mContactsQueryUri = ContactsContract.RawContacts.CONTENT_URI;
        this.mEntries = Maps.newHashMap();
        this.mValues = r2;
    }

    public void addRefRawContacts(Map<Long, AccountWithDataSet> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mRefRawContacts != null) goto L9;
        this.mRefRawContacts = new HashMap();
    L9:
        this.mRefRawContacts.putAll(r2);
    }

    public boolean isRefAccount(AccountWithDataSet r1) {
        HashMap<Long, AccountWithDataSet> r0 = this.mRefRawContacts;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.values().contains(r1);
    }

    public Set<Long> getRefRawContactsId() {
        HashMap<Long, AccountWithDataSet> r0 = this.mRefRawContacts;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.keySet();
    }

    public Set<AccountWithDataSet> getRefAccounts() {
        if (this.mRefRawContacts != null) goto L6;
        return null;
    L6:
        HashSet r0 = new HashSet();
        Iterator<AccountWithDataSet> r2 = this.mRefRawContacts.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.add(r2.next());
        goto L8
    L10:
        return r0;
    }

    public static EntityDelta fromBefore(Entity r3) {
        EntityDelta r0 = new EntityDelta();
        ValuesDelta r1 = ValuesDelta.fromBefore(r3.getEntityValues());
        r0.mValues = r1;
        r1.setIdColumn("_id");
        Iterator<Entity.NamedContentValues> r4 = r3.getSubValues().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.addEntry(ValuesDelta.fromBefore(r4.next().values));
        goto L4
    L6:
        return r0;
    }

    public static EntityDelta mergeAfter(EntityDelta r4, EntityDelta r5) {
        ValuesDelta r0 = r5.mValues;
        Long r1 = null;
        if (r4 == null) goto L5;
    L9:
        if (r4 != null) goto L12;
        r4 = new EntityDelta();
    L12:
        if (LOGV == false) goto L18;
        ValuesDelta r2 = r4.mValues;
        if (r2 == null) goto L17;
        r1 = r2.getAsLong(GloableSearchConfig.KEY_VERSION);
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Re-parenting from original version " + r5.mValues.getAsLong(GloableSearchConfig.KEY_VERSION) + " to " + r1);
    L18:
        r4.mValues = ValuesDelta.mergeAfter(r4.mValues, r5.mValues);
        Iterator<ArrayList<ValuesDelta>> r6 = r5.mEntries.values().iterator();
    L20:
        if (r6.hasNext() == false) goto L28;
        Iterator<ValuesDelta> r3 = r6.next().iterator();
    L23:
        if (r3.hasNext() == false) goto L20;
        ValuesDelta r7 = r3.next();
        ValuesDelta r8 = r4.getEntry(r7.getId());
        ValuesDelta r9 = ValuesDelta.mergeAfter(r8, r7);
        if (r8 != null) goto L23;
        if (r9 == null) goto L23;
        r4.addEntry(r9);
        goto L23
    L28:
        return r4;
    L5:
        if (r0.isDelete() == false) goto L7;
    L8:
        return null;
    L7:
        if (r0.isTransient() == false) goto L9;
        goto L8
    }

    public HashMap<String, ArrayList<ValuesDelta>> getEntries() {
        return this.mEntries;
    }

    public ValuesDelta getValues() {
        return this.mValues;
    }

    public boolean isContactInsert() {
        return this.mValues.isInsert();
    }

    public ValuesDelta getPrimaryEntry(String r5) {
        ArrayList<ValuesDelta> r4 = getMimeEntries(r5, false);
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator<ValuesDelta> r1 = r4.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        ValuesDelta r2 = r1.next();
        if (r2.isPrimary() == false) goto L7;
        return r2;
    L12:
        if (r4.size() > 0) goto L14;
        return null;
    L14:
        return r4.get(0);
    }

    public ValuesDelta getSuperPrimaryEntry(String r2) {
        return getSuperPrimaryEntry(r2, true);
    }

    public ValuesDelta getSuperPrimaryEntry(String r6, boolean r7) {
        ArrayList<ValuesDelta> r5 = getMimeEntries(r6, false);
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<ValuesDelta> r1 = r5.iterator();
        ValuesDelta r2 = null;
    L7:
        if (r1.hasNext() == false) goto L14;
        ValuesDelta r3 = r1.next();
        if (r3.isSuperPrimary() == true) goto L10;
        if (r3.isPrimary() == false) goto L7;
        r2 = r3;
        goto L7
    L10:
        return r3;
    L14:
        if (r7 == true) goto L16;
        return null;
    L16:
        if (r2 == null) goto L19;
        return r2;
    L19:
        if (r5.size() > 0) goto L21;
        return null;
    L21:
        return r5.get(0);
    }

    private ArrayList<ValuesDelta> getMimeEntries(String r2, boolean r3) {
        ArrayList<ValuesDelta> r0 = this.mEntries.get(r2);
        if (r0 != null) goto L7;
        if (r3 == false) goto L8;
        ArrayList<ValuesDelta> r1 = Lists.newArrayList();
        this.mEntries.put(r2, r1);
        return r1;
    L8:
        return r0;
    L7:
        return r0;
    }

    public ArrayList<ValuesDelta> getMimeEntries(String r2) {
        return getMimeEntries(r2, false);
    }

    public int getMimeEntriesCount(String r2, boolean r3) {
        ArrayList<ValuesDelta> r1 = getMimeEntries(r2);
        int r4 = 0;
        if (r1 != null) goto L5;
        return 0;
    L5:
        Iterator<ValuesDelta> r5 = r1.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        ValuesDelta r0 = r5.next();
        if (r3 == false) goto L13;
        if (r0.isVisible() == false) goto L7;
    L13:
        r4 = r4 + 1;
        goto L7
    L14:
        return r4;
    }

    public boolean hasMimeEntries(String r1) {
        return this.mEntries.containsKey(r1);
    }

    public ValuesDelta addEntry(ValuesDelta r3) {
        getMimeEntries(r3.getMimetype(), true).add(r3);
        return r3;
    }

    public ArrayList<ContentValues> getContentValues() {
        ArrayList<ContentValues> r0 = Lists.newArrayList();
        Iterator<ArrayList<ValuesDelta>> r4 = this.mEntries.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Iterator<ValuesDelta> r1 = r4.next().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ValuesDelta r2 = r1.next();
        if (r2.isDelete() == true) goto L7;
        r0.add(r2.getCompleteValues());
        goto L7
    L11:
        return r0;
    }

    public ValuesDelta getEntry(Long r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<ArrayList<ValuesDelta>> r4 = this.mEntries.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Iterator<ValuesDelta> r1 = r4.next().iterator();
    L10:
        if (r1.hasNext() == false) goto L7;
        ValuesDelta r2 = r1.next();
        if (r5.equals(r2.getId()) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    public int getEntryCount(boolean r4) {
        Iterator<String> r0 = this.mEntries.keySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + getMimeEntriesCount(r0.next(), r4);
        goto L4
    L6:
        return r1;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof EntityDelta) == false) goto L18;
        EntityDelta r5 = (EntityDelta) r4;
        if (r5.mValues.equals(this.mValues) == true) goto L7;
        return false;
    L7:
        Iterator<ArrayList<ValuesDelta>> r3 = this.mEntries.values().iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        Iterator<ValuesDelta> r0 = r3.next().iterator();
    L12:
        if (r0.hasNext() == false) goto L9;
        if (r5.containsEntry(r0.next()) == true) goto L12;
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    private boolean containsEntry(ValuesDelta r3) {
        Iterator<ArrayList<ValuesDelta>> r2 = this.mEntries.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        Iterator<ValuesDelta> r0 = r2.next().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        if (r0.next().equals(r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void markDeleted() {
        this.mValues.markDeleted();
        Iterator<ArrayList<ValuesDelta>> r2 = this.mEntries.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Iterator<ValuesDelta> r0 = r2.next().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        r0.next().markDeleted();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("\n(");
        ValuesDelta r1 = this.mValues;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append(") = {");
        Iterator<ArrayList<ValuesDelta>> r4 = this.mEntries.values().iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Iterator<ValuesDelta> r3 = r4.next().iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        ValuesDelta r5 = r3.next();
        r0.append("\n\t");
        r5.toString(r0);
        goto L11
    L13:
        r0.append("\n}\n");
        return r0.toString();
    L5:
        r2 = "null";
        goto L6
    }

    private void possibleAdd(ArrayList<ContentProviderOperation> r1, ContentProviderOperation.Builder r2) {
        if (r2 == null) goto L5;
        r1.add(r2.build());
        return;
    }

    public void buildAssert(ArrayList<ContentProviderOperation> r6) {
        if (this.mValues.isInsert() == true) goto L10;
        Long r0 = this.mValues.getId();
        Long r1 = this.mValues.getAsLong(GloableSearchConfig.KEY_VERSION);
        if (r0 == null) goto L11;
        if (r1 == null) goto L12;
        ContentProviderOperation.Builder r5 = ContentProviderOperation.newAssertQuery(this.mContactsQueryUri);
        r5.withSelection("_id=" + r0, null);
        r5.withValue(GloableSearchConfig.KEY_VERSION, r1);
        r6.add(r5.build());
        return;
    L12:
        return;
    L11:
        return;
    }

    public ContentValues buildSimDiff() {
        ContentValues r1 = new ContentValues();
        ArrayList<ValuesDelta> r2 = getMimeEntries("vnd.android.cursor.item/name");
        ArrayList<ValuesDelta> r3 = getMimeEntries("vnd.android.cursor.item/phone_v2");
        ArrayList<ValuesDelta> r4 = getMimeEntries("vnd.android.cursor.item/email_v2");
        if (r2 != null) goto L5;
    L7:
        ValuesDelta r5 = null;
    L8:
        if (r4 != null) goto L10;
    L12:
        ValuesDelta r6 = null;
    L14:
        if (r5 != null) goto L16;
        String r7 = null;
    L32:
        String r8 = null;
    L34:
        if (isContactInsert() == false) goto L50;
        if (r3 == null) goto L50;
        Iterator<ValuesDelta> r9 = r3.iterator();
        String r10 = null;
        String r12 = null;
    L38:
        if (r9.hasNext() == false) goto L85;
        ValuesDelta r13 = r9.next();
        if (r13.getAfter() == null) goto L38;
        if (r13.getAfter().size() == 0) goto L38;
        if (2 == r13.getAfter().getAsLong(DBHelper.COL_DATA2).longValue()) goto L46;
        r12 = r13.getAfter().getAsString("data1");
        goto L38
    L46:
        if (TextUtils.isEmpty(r10) == true) goto L47;
        r12 = r13.getAfter().getAsString("data1");
        goto L38
    L47:
        r10 = r13.getAfter().getAsString("data1");
    L85:
        String r14 = null;
        String r15 = null;
    L86:
        if (r6 != null) goto L88;
        String r11 = null;
    L103:
        String r16 = null;
    L105:
        if (r7 != null) goto L107;
        r7 = "";
    L107:
        if (r10 != null) goto L109;
        r10 = "";
    L109:
        if (r11 != null) goto L111;
        r11 = "";
    L111:
        if (r12 != null) goto L113;
        r12 = "";
    L113:
        if (r8 != null) goto L115;
        r8 = "";
    L115:
        if (r14 != null) goto L117;
        r14 = "";
    L117:
        if (r16 != null) goto L119;
        String r17 = "";
    L120:
        if (r15 != null) goto L123;
        r15 = "";
    L123:
        if (isContactInsert() == false) goto L125;
        r1.put(SimContactsConstants.STR_TAG, r7);
        r1.put("number", r10);
        r1.put(SimContactsConstants.STR_EMAILS, r11);
        r1.put(SimContactsConstants.STR_ANRS, r12);
    L126:
        return r1;
    L125:
        r1.put(SimContactsConstants.STR_TAG, r7);
        r1.put("number", r10);
        r1.put(SimContactsConstants.STR_EMAILS, r11);
        r1.put(SimContactsConstants.STR_ANRS, r12);
        r1.put(SimContactsConstants.STR_NEW_TAG, r8);
        r1.put(SimContactsConstants.STR_NEW_NUMBER, r14);
        r1.put(SimContactsConstants.STR_NEW_EMAILS, r17);
        r1.put(SimContactsConstants.STR_NEW_ANRS, r15);
        goto L126
    L119:
        r17 = r16;
        goto L120
    L88:
        if (isContactInsert() == false) goto L91;
        r11 = r6.getAsString("data1");
        goto L103
    L91:
        if (r6.mBefore == null) goto L93;
        String r18 = r6.mBefore.getAsString("data1");
    L95:
        if (r6.mAfter != null) goto L97;
    L99:
        r11 = r18;
        if (r6.isDelete() == true) goto L103;
        r16 = r11;
        goto L105
    L97:
        if (r6.mAfter.size() == 0) goto L99;
        r16 = r6.mAfter.getAsString("data1");
        r11 = r18;
        goto L105
    L93:
        r18 = null;
    L50:
        if (r3 == null) goto L84;
        Iterator<ValuesDelta> r19 = r3.iterator();
        r10 = null;
        r12 = null;
        r14 = null;
        r15 = null;
    L53:
        if (r19.hasNext() == false) goto L86;
        ValuesDelta r110 = r19.next();
        if (r110.mBefore == null) goto L66;
        if (r110.mBefore.size() == 0) goto L66;
        if (2 == r110.mBefore.getAsLong(DBHelper.COL_DATA2).longValue()) goto L61;
        r12 = r110.mBefore.getAsString("data1");
        goto L66
    L61:
        if (TextUtils.isEmpty(r10) == false) goto L63;
        r10 = r110.mBefore.getAsString("data1");
        goto L66
    L63:
        r12 = r110.mBefore.getAsString("data1");
    L66:
        if (r110.getAfter() == null) goto L77;
        if (r110.getAfter().size() == 0) goto L77;
        if (2 == r110.getAsLong(DBHelper.COL_DATA2).longValue()) goto L72;
        r15 = r110.getAfter().getAsString("data1");
        goto L53
    L72:
        if (TextUtils.isEmpty(r14) == true) goto L73;
        r15 = r110.getAfter().getAsString("data1");
        goto L53
    L73:
        r14 = r110.getAfter().getAsString("data1");
    L77:
        if (r110.isDelete() == true) goto L53;
        if (r110.mBefore == null) goto L53;
        if (2 == r110.mBefore.getAsLong(DBHelper.COL_DATA2).longValue()) goto L82;
        r15 = r12;
        goto L53
    L82:
        r14 = r10;
        goto L53
    L84:
        r10 = null;
        r12 = null;
        goto L85
    L16:
        if (isContactInsert() == false) goto L19;
        r7 = r5.getAsString("data1");
        goto L32
    L19:
        if (r5.mBefore == null) goto L21;
        r8 = r5.mBefore.getAsString("data1");
    L23:
        if (r5.mAfter == null) goto L28;
        if (r5.mAfter.size() == 0) goto L28;
        String r111 = r8;
        r8 = r5.mAfter.getAsString("data1");
        r7 = r111;
    L28:
        if (r5.isDelete() == true) goto L30;
        r7 = r8;
        goto L34
    L30:
        r7 = r8;
        goto L32
    L21:
        r8 = null;
        goto L23
    L10:
        if (r4.size() <= 0) goto L12;
        r6 = r4.get(0);
        goto L14
    L5:
        if (r2.size() <= 0) goto L7;
        r5 = r2.get(0);
        goto L8
    }

    public void buildDiff(ArrayList<ContentProviderOperation> r17) {
        int r2 = r17.size();
        boolean r3 = this.mValues.isInsert();
        boolean r4 = this.mValues.isDelete();
        if (r3 == true) goto L6;
        if (r4 == true) goto L6;
        boolean r5 = true;
    L7:
        Long r7 = this.mValues.getId();
        if (r3 == false) goto L10;
        this.mValues.put("aggregation_mode", 2);
    L10:
        possibleAdd(r17, this.mValues.buildDiff(this.mContactsQueryUri));
        Iterator<ArrayList<ValuesDelta>> r10 = this.mEntries.values().iterator();
    L12:
        if (r10.hasNext() == false) goto L50;
        Iterator<ValuesDelta> r11 = r10.next().iterator();
    L15:
        if (r11.hasNext() == false) goto L12;
        ValuesDelta r12 = r11.next();
        if (this.mContactsQueryUri.equals(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI) == false) goto L20;
        ContentProviderOperation.Builder r13 = r12.buildDiff(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"));
    L31:
        if (r12.isInsert() == false) goto L37;
        if (r13 != null) goto L34;
    L42:
        if (r13 == null) goto L48;
        if (r12.isUpdate() == false) goto L48;
        if ("vnd.android.cursor.item/organization".equals(r12.getAsString("mimetype")) == false) goto L48;
        r13.withValue(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "");
    L48:
        possibleAdd(r17, r13);
        goto L15
    L34:
        if (r3 == false) goto L36;
        r13.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r2);
        goto L42
    L36:
        r13.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r7);
        goto L42
    L37:
        if (r3 == false) goto L42;
        if (r13 == null) goto L42;
        throw new IllegalArgumentException("When parent insert, child must be also");
    L20:
        if ("vnd.android.cursor.item/name".equals(r12.getAsString("mimetype")) == true) goto L22;
    L29:
        r13 = r12.buildDiff(ContactsContract.Data.CONTENT_URI);
        goto L31
    L22:
        if (r12.isUpdate() == false) goto L29;
        String[] r14 = NameConverter.STRUCTURED_NAME_FIELDS;
        int r15 = r14.length;
        int r6 = 0;
    L24:
        if (r6 >= r15) goto L29;
        String r8 = r14[r6];
        if (r12.mAfter.containsKey(r8) == true) goto L28;
        r12.put(r8, r12.mBefore.getAsString(r8));
    L28:
        r6 = r6 + 1;
        goto L24
    L50:
        if (r17.size() <= r2) goto L52;
        boolean r9 = true;
    L53:
        if (r9 == false) goto L57;
        if (r5 == false) goto L57;
        r17.add(r2, buildSetAggregationMode(r7, 2).build());
        r17.add(buildSetAggregationMode(r7, 0).build());
        return;
    L57:
        if (r3 == false) goto L71;
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newUpdate(this.mContactsQueryUri);
        r0.withValue("aggregation_mode", 0);
        r0.withSelection("_id=?", new String[1]);
        r0.withSelectionBackReference(0, r2);
        r17.add(r0.build());
        return;
    L71:
        return;
    L52:
        r9 = false;
    L6:
        r5 = false;
        goto L7
    }

    public void buildNameSyncCache(Map<Long, List<NameConverter.NameHolder>> r12) {
        ArrayList r0 = Lists.newArrayList();
        boolean r1 = this.mValues.isInsert();
        if (this.mValues.isDelete() == true) goto L55;
        if (r1 == true) goto L57;
        Long r2 = this.mValues.getId();
        Iterator<ArrayList<ValuesDelta>> r11 = this.mEntries.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L38;
        Iterator<ValuesDelta> r3 = r11.next().iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        ValuesDelta r4 = r3.next();
        if ("vnd.android.cursor.item/name".equals(r4.getAsString("mimetype")) == false) goto L11;
        if (r4.isUpdate() == false) goto L11;
        NameConverter.NameHolder r5 = new NameConverter.NameHolder();
        String[] r6 = NameConverter.FULL_STRUCTURED_NAME_FIELDS;
        int r7 = r6.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L36;
        String r9 = r6[r8];
        String r10 = null;
        if (r4.mAfter == null) goto L21;
        String r13 = r4.mAfter.getAsString(r9);
    L23:
        if (r4.mBefore == null) goto L25;
        r10 = r4.mBefore.getAsString(r9);
    L25:
        if (r13 != null) goto L28;
        if (r10 != null) goto L28;
    L35:
        r8 = r8 + 1;
    L28:
        if (r13 == null) goto L31;
        if (r10 != null) goto L31;
        r5.setNameByTag(r9, r13);
    L31:
        if (r13 != null) goto L34;
        if (r10 == null) goto L34;
        r5.setNameByTag(r9, r10);
    L34:
        r5.setNameByTag(r9, r13);
        goto L35
    L21:
        r13 = null;
        goto L23
    L36:
        r5.id = r2;
        r0.add(r5);
        goto L8
    L38:
        if (r0.size() <= 0) goto L56;
        r12.put(r2, r0);
        return;
    L56:
        return;
    L57:
        return;
    }

    public void syncNameByHolder(NameConverter.NameHolder r10) {
        if (this.mValues.getId().equals(r10.id) == true) goto L38;
        HashMap<String, ArrayList<ValuesDelta>> r0 = this.mEntries;
        if (r0 == null) goto L39;
        Iterator<ArrayList<ValuesDelta>> r1 = r0.values().iterator();
        int r2 = 0;
        boolean r3 = false;
    L8:
        if (r1.hasNext() == false) goto L21;
        Iterator<ValuesDelta> r4 = r1.next().iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        ValuesDelta r6 = r4.next();
        if ("vnd.android.cursor.item/name".equals(r6.getAsString("mimetype")) == false) goto L11;
        String[] r5 = NameConverter.FULL_STRUCTURED_NAME_FIELDS;
        int r7 = r5.length;
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L20;
        String r9 = r5[r8];
        if (r6.mAfter != null) goto L19;
        r6.mAfter = new ContentValues();
    L19:
        r6.mAfter.put(r9, r10.getNameByTag(r9));
        r8 = r8 + 1;
        goto L15
    L20:
        r3 = true;
        goto L8
    L21:
        if (r3 == false) goto L23;
        return;
    L23:
        ArrayList<ValuesDelta> r11 = new ArrayList();
        ContentValues r12 = new ContentValues();
        String[] r13 = NameConverter.FULL_STRUCTURED_NAME_FIELDS;
        int r14 = r13.length;
    L24:
        if (r2 >= r14) goto L26;
        String r15 = r13[r2];
        r12.put(r15, r10.getNameByTag(r15));
        r2 = r2 + 1;
        goto L24
    L26:
        r12.put("mimetype", "vnd.android.cursor.item/name");
        r11.add(ValuesDelta.fromAfter(r12));
        this.mEntries.put("vnd.android.cursor.item/name", r11);
        return;
    L39:
        return;
    }

    public ContactLoader.Result buildToResult() {
        ContactLoader.Result r0 = ContactLoader.Result.fromDummy();
        if (this.mValues.isInsert() == true) goto L6;
        return null;
    L6:
        Iterator<ArrayList<ValuesDelta>> r6 = this.mEntries.values().iterator();
    L8:
        if (r6.hasNext() == false) goto L29;
        Iterator<ValuesDelta> r1 = r6.next().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        ValuesDelta r2 = r1.next();
        if (r2.mAfter == null) goto L11;
        String r3 = r2.getAsString("mimetype");
        if ("vnd.android.cursor.item/name".equals(r3) == false) goto L19;
        r0.mDisplayName = r2.getAsString("data1");
        r0.mAltDisplayName = r0.mDisplayName;
    L28:
        Entity r4 = new Entity(r2.mAfter);
        r4.addSubValue(ContactsContract.Data.CONTENT_URI, r2.mAfter);
        r0.mEntities.add(r4);
        goto L11
    L19:
        if ("vnd.android.cursor.item/group_membership".equals(r3) == false) goto L26;
        if (r2.getAsLong("data1") == null) goto L28;
        long r5 = r2.getAsLong("data1").longValue();
        GroupMetaData r7 = ContactDetailCacheManager.getInstance().getGroupMetaDataByID(r5);
        if (r7 == null) goto L28;
        r0.addGroupMetaData(r7);
        goto L28
    L26:
        if ("vnd.android.cursor.item/photo".equals(r3) == false) goto L28;
        r0.mPhotoBinaryData = r2.getAsByteArray(BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG);
        goto L28
    L29:
        return r0;
    }

    protected ContentProviderOperation.Builder buildSetAggregationMode(Long r2, int r3) {
        ContentProviderOperation.Builder r1 = ContentProviderOperation.newUpdate(this.mContactsQueryUri);
        r1.withValue("aggregation_mode", Integer.valueOf(r3));
        r1.withSelection("_id=" + r2, null);
        return r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(getEntryCount(false));
        r3.writeParcelable(this.mValues, r4);
        r3.writeParcelable(this.mContactsQueryUri, r4);
        r3.writeMap(this.mRefRawContacts);
        Iterator<ArrayList<ValuesDelta>> r2 = this.mEntries.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Iterator<ValuesDelta> r0 = r2.next().iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        r3.writeParcelable(r0.next(), r4);
        goto L7
    }

    public void readFromParcel(Parcel r5) {
        ClassLoader r0 = getClass().getClassLoader();
        int r1 = r5.readInt();
        this.mValues = (ValuesDelta) r5.readParcelable(r0);
        this.mContactsQueryUri = (Uri) r5.readParcelable(r0);
        HashMap<Long, AccountWithDataSet> r2 = new HashMap();
        this.mRefRawContacts = r2;
        r5.readMap(r2, r0);
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        addEntry((ValuesDelta) r5.readParcelable(r0));
        r3 = r3 + 1;
        goto L3
    }

    public void setProfileQueryUri() {
        this.mContactsQueryUri = ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI;
    }

    public AccountType getRawContactAccountType(Context r3) {
        ContentValues r2 = getValues().getCompleteValues();
        String r0 = r2.getAsString("account_type");
        String r4 = r2.getAsString("data_set");
        return AccountTypeManager.getInstance(r3).getAccountType(r0, r4);
    }

    public Long getRawContactId() {
        return getValues().getAsLong("_id");
    }

    public ArrayList<ValuesDelta> getInsertValues() {
        ArrayList<ValuesDelta> r0 = new ArrayList();
        Iterator<String> r1 = this.mEntries.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        String r2 = r1.next();
        if ("vnd.android.cursor.item/group_membership".equals(r2) == true) goto L4;
        ArrayList<ValuesDelta> r3 = this.mEntries.get(r2);
        if (r3 == null) goto L4;
        Iterator<ValuesDelta> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L4;
        ValuesDelta r5 = r4.next();
        if (r5.isInsert() == false) goto L13;
        r0.add(r5);
        goto L13
    L17:
        return r0;
    }
}
