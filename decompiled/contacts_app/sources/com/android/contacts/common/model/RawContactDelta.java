package com.android.contacts.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.group.GroupSelectionActivity;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes.dex */
public class RawContactDelta implements Parcelable {
    public static final Parcelable.Creator<RawContactDelta> CREATOR = null;
    private static final boolean LOGV = false;
    private static final String TAG = "EntityDelta";
    private Uri mContactsQueryUri;
    private final HashMap<String, ArrayList<ValuesDelta>> mEntries;
    private ValuesDelta mValues;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RawContactDelta() {
        this.mContactsQueryUri = ContactsContract.RawContacts.CONTENT_URI;
        this.mEntries = Maps.newHashMap();
    }

    public RawContactDelta(ValuesDelta r2) {
        this.mContactsQueryUri = ContactsContract.RawContacts.CONTENT_URI;
        this.mEntries = Maps.newHashMap();
        this.mValues = r2;
    }

    public static RawContactDelta fromBefore(RawContact r3) {
        RawContactDelta r0 = new RawContactDelta();
        ValuesDelta r1 = ValuesDelta.fromBefore(r3.getValues());
        r0.mValues = r1;
        r1.setIdColumn("_id");
        Iterator<ContentValues> r4 = r3.getContentValues().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.addEntry(ValuesDelta.fromBefore(r4.next()));
        goto L4
    L6:
        return r0;
    }

    public static RawContactDelta mergeAfter(RawContactDelta r3, RawContactDelta r4) {
        ValuesDelta r0 = r4.mValues;
        if (r3 == null) goto L5;
    L10:
        if (r3 != null) goto L12;
        r3 = new RawContactDelta();
    L12:
        r3.mValues = ValuesDelta.mergeAfter(r3.mValues, r4.mValues);
        Iterator<ArrayList<ValuesDelta>> r5 = r4.mEntries.values().iterator();
    L14:
        if (r5.hasNext() == false) goto L22;
        Iterator<ValuesDelta> r1 = r5.next().iterator();
    L17:
        if (r1.hasNext() == false) goto L14;
        ValuesDelta r2 = r1.next();
        ValuesDelta r6 = r3.getEntry(r2.getId());
        ValuesDelta r7 = ValuesDelta.mergeAfter(r6, r2);
        if (r6 != null) goto L17;
        if (r7 == null) goto L17;
        r3.addEntry(r7);
        goto L17
    L22:
        return r3;
    L5:
        if (r0.isDelete() == false) goto L7;
        return null;
    L7:
        if (r0.isTransient() == false) goto L10;
        return null;
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

    public AccountType getRawContactAccountType(Context r3) {
        ContentValues r2 = getValues().getCompleteValues();
        String r0 = r2.getAsString("account_type");
        String r4 = r2.getAsString("data_set");
        return AccountTypeManager.getInstance(r3).getAccountType(r0, r4);
    }

    public Long getRawContactId() {
        return getValues().getAsLong("_id");
    }

    public String getAccountName() {
        return getValues().getAsString("account_name");
    }

    public String getAccountType() {
        return getValues().getAsString("account_type");
    }

    public String getDataSet() {
        return getValues().getAsString("data_set");
    }

    public AccountType getAccountType(AccountTypeManager r2) {
        return r2.getAccountType(getAccountType(), getDataSet());
    }

    public boolean isVisible() {
        return getValues().isVisible();
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
        if ((r4 instanceof RawContactDelta) == false) goto L18;
        RawContactDelta r5 = (RawContactDelta) r4;
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
        r0.append("\n(Uri=");
        r0.append(this.mContactsQueryUri);
        r0.append(", Values=");
        ValuesDelta r1 = this.mValues;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append(", Entries={");
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
        r0.append("\n})\n");
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

    private void possibleAddWrapper(ArrayList<CPOWrapper> r2, BuilderWrapper r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getBuilder() == null) goto L8;
        r2.add(new CPOWrapper(r3.getBuilder().build(), r3.getType()));
        return;
    }

    public void buildAssert(ArrayList<ContentProviderOperation> r1) {
        ContentProviderOperation.Builder r0 = buildAssertHelper();
        if (r0 == null) goto L6;
        r1.add(r0.build());
        return;
    }

    public void buildAssertWrapper(ArrayList<CPOWrapper> r3) {
        ContentProviderOperation.Builder r2 = buildAssertHelper();
        if (r2 == null) goto L6;
        r3.add(new CPOWrapper(r2.build(), 4));
        return;
    }

    private ContentProviderOperation.Builder buildAssertHelper() {
        if (this.mValues.isInsert() == true) goto L10;
        Long r0 = this.mValues.getId();
        Long r2 = this.mValues.getAsLong(GloableSearchConfig.KEY_VERSION);
        if (r0 == null) goto L11;
        if (r2 == null) goto L12;
        ContentProviderOperation.Builder r6 = ContentProviderOperation.newAssertQuery(this.mContactsQueryUri);
        r6.withSelection("_id=" + r0, null);
        r6.withValue(GloableSearchConfig.KEY_VERSION, r2);
        return r6;
    L12:
        return null;
    L11:
        return null;
    L10:
        return null;
    }

    public ContentValues buildSimDiff() {
        ContentValues r1 = new ContentValues();
        ArrayList<ValuesDelta> r3 = getMimeEntries("vnd.android.cursor.item/name");
        ArrayList<ValuesDelta> r4 = getMimeEntries("vnd.android.cursor.item/phone_v2");
        ArrayList<ValuesDelta> r5 = getMimeEntries("vnd.android.cursor.item/email_v2");
        if (getMimeEntriesCount("vnd.android.cursor.item/name", true) <= 0) goto L5;
        ValuesDelta r6 = r3.get(0);
        r3.get(0).putNull(DBHelper.COL_DATA2);
        r3.get(0).putNull(DBHelper.COL_DATA3);
        r3.get(0).putNull("data4");
        r3.get(0).putNull("data5");
        r3.get(0).putNull("data6");
        r3.get(0).put("mimetype", "vnd.android.cursor.item/name");
    L6:
        if (r5 != null) goto L8;
    L10:
        StringBuilder r2 = new StringBuilder();
        StringBuilder r7 = new StringBuilder();
        StringBuilder r8 = new StringBuilder();
        StringBuilder r10 = new StringBuilder();
        if (r6 != null) goto L13;
        String r9 = null;
    L24:
        String r12 = null;
    L26:
        if (isContactInsert() == false) goto L43;
        if (r4 == null) goto L43;
        Iterator<ValuesDelta> r11 = r4.iterator();
        String r13 = null;
    L30:
        if (r11.hasNext() == false) goto L42;
        ValuesDelta r18 = r11.next();
        if (r18.getAfter() == null) goto L30;
        if (r18.getAfter().size() == 0) goto L30;
        if (2 == r18.getAfter().getAsLong(DBHelper.COL_DATA2).longValue()) goto L38;
        r7.append(r18.getAfter().getAsString("data1"));
        r7.append(SimContactsConstants.ANR_SEP);
        goto L30
    L38:
        if (TextUtils.isEmpty(r13) == true) goto L39;
        r13 = SimContactsConstants.STR_ANRS;
        goto L30
    L39:
        r13 = r18.getAfter().getAsString("data1");
        goto L30
    L42:
        String r0 = null;
    L71:
        if (isContactInsert() == false) goto L81;
        if (r5 == null) goto L81;
        Iterator<ValuesDelta> r14 = r5.iterator();
    L75:
        if (r14.hasNext() == false) goto L96;
        ValuesDelta r15 = r14.next();
        if (r15.getAfter() == null) goto L75;
        if (r15.getAfter().size() == 0) goto L75;
        r2.append(r15.getAfter().getAsString("data1"));
        r2.append(SimContactsConstants.EMAIL_SEP);
    L96:
        if (isContactInsert() == false) goto L101;
        if (r9 != null) goto L99;
        if (r13 != null) goto L99;
    L100:
        r1.put(SimContactsConstants.STR_EMAILS, r2.toString());
        r1.put(SimContactsConstants.STR_ANRS, r7.toString());
    L102:
        return r1;
    L99:
        r1.put(SimContactsConstants.STR_TAG, r9);
        r1.put("number", r13);
        goto L100
    L101:
        r1.put(SimContactsConstants.STR_TAG, r9);
        r1.put("number", r13);
        r1.put(SimContactsConstants.STR_EMAILS, r2.toString());
        r1.put(SimContactsConstants.STR_ANRS, r7.toString());
        r1.put(SimContactsConstants.STR_NEW_TAG, r12);
        r1.put(SimContactsConstants.STR_NEW_NUMBER, r0);
        r1.put(SimContactsConstants.STR_NEW_EMAILS, r8.toString());
        r1.put(SimContactsConstants.STR_NEW_ANRS, r10.toString());
    L81:
        if (r5 == null) goto L96;
        Iterator<ValuesDelta> r16 = r5.iterator();
    L84:
        if (r16.hasNext() == false) goto L96;
        ValuesDelta r17 = r16.next();
        if (r17.getBefore() == null) goto L91;
        if (r17.getBefore().size() == 0) goto L91;
        r2.append(r17.getBefore().getAsString("data1"));
        r2.append(SimContactsConstants.EMAIL_SEP);
    L91:
        if (r17.getAfter() == null) goto L84;
        if (r17.getAfter().size() == 0) goto L84;
        r8.append(r17.getAfter().getAsString("data1"));
        r8.append(SimContactsConstants.EMAIL_SEP);
    L43:
        if (r4 == null) goto L69;
        Iterator<ValuesDelta> r19 = r4.iterator();
        String r110 = null;
        String r111 = null;
    L46:
        if (r19.hasNext() == false) goto L68;
        ValuesDelta r112 = r19.next();
        if (r112.getBefore() == null) goto L56;
        if (r112.getBefore().size() == 0) goto L56;
        if (2 != r112.getBefore().getAsLong(DBHelper.COL_DATA2).longValue()) goto L54;
        r111 = r112.getBefore().getAsString("data1");
        goto L56
    L54:
        r7.append(r112.getBefore().getAsString("data1"));
        r7.append(SimContactsConstants.ANR_SEP);
    L56:
        if (r112.getAfter() == null) goto L46;
        if (r112.getAfter().size() == 0) goto L46;
        if (2 == r112.getAsLong(DBHelper.COL_DATA2).longValue()) goto L62;
        r10.append(r112.getAfter().getAsString("data1"));
        r10.append(SimContactsConstants.ANR_SEP);
        goto L46
    L62:
        if (TextUtils.isEmpty(r110) == false) goto L64;
        r110 = r112.getAfter().getAsString("data1");
        goto L46
    L64:
        r110 = SimContactsConstants.STR_ANRS;
        goto L46
    L68:
        r0 = r110;
        r13 = r111;
        goto L71
    L69:
        r0 = null;
        r13 = null;
        goto L71
    L13:
        if (isContactInsert() == false) goto L16;
        r9 = r6.getAsString("data1");
        goto L24
    L16:
        if (r6.getBefore() == null) goto L18;
        String r113 = r6.getBefore().getAsString("data1");
    L20:
        if (r6.getAfter() == null) goto L22;
        String r23 = r113;
        r12 = r6.getAfter().getAsString("data1");
        r9 = r23;
        goto L26
    L22:
        r9 = r113;
        goto L24
    L18:
        r113 = null;
        goto L20
    L8:
        if (r5.size() <= 0) goto L10;
        ValuesDelta r20 = r5.get(0);
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public void buildDiff(ArrayList<ContentProviderOperation> r15) {
        int r0 = r15.size();
        boolean r1 = this.mValues.isInsert();
        boolean r2 = this.mValues.isDelete();
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        boolean r5 = true;
    L7:
        Long r6 = this.mValues.getId();
        if (r1 == false) goto L10;
        this.mValues.put("aggregation_mode", 2);
    L10:
        possibleAdd(r15, this.mValues.buildDiff(this.mContactsQueryUri));
        Iterator<ArrayList<ValuesDelta>> r9 = this.mEntries.values().iterator();
    L12:
        if (r9.hasNext() == false) goto L36;
        Iterator<ValuesDelta> r10 = r9.next().iterator();
    L15:
        if (r10.hasNext() == false) goto L12;
        ValuesDelta r11 = r10.next();
        if (r2 == true) goto L15;
        if (this.mContactsQueryUri.equals(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI) == false) goto L22;
        ContentProviderOperation.Builder r12 = r11.buildDiff(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"));
    L24:
        if (r11.isInsert() == true) goto L26;
        if (r1 == false) goto L34;
        if (r12 == null) goto L34;
        throw new IllegalArgumentException("When parent insert, child must be also");
    L34:
        possibleAdd(r15, r12);
        goto L15
    L26:
        if (r1 == false) goto L28;
        r12.withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r0);
        goto L34
    L28:
        r12.withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r6);
        goto L34
    L22:
        r12 = r11.buildDiff(ContactsContract.Data.CONTENT_URI);
        goto L24
    L36:
        if (r15.size() <= r0) goto L38;
        boolean r3 = true;
    L39:
        if (r3 == false) goto L42;
        if (r5 == false) goto L42;
        r15.add(r0, buildSetAggregationMode(r6, 2).build());
        r15.add(buildSetAggregationMode(r6, 0).build());
        return;
    L42:
        if (r1 == false) goto L53;
        ContentProviderOperation.Builder r14 = ContentProviderOperation.newUpdate(this.mContactsQueryUri);
        r14.withValue("aggregation_mode", 0);
        r14.withSelection("_id=?", new String[1]);
        r14.withSelectionBackReference(0, r0);
        r15.add(r14.build());
        return;
    L53:
        return;
    L38:
        r3 = false;
    L6:
        r5 = false;
        goto L7
    }

    public void buildDiffWrapper(ArrayList<CPOWrapper> r15) {
        int r0 = r15.size();
        boolean r1 = this.mValues.isInsert();
        boolean r2 = this.mValues.isDelete();
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
        boolean r5 = true;
    L7:
        Long r6 = this.mValues.getId();
        if (r1 == false) goto L10;
        this.mValues.put("aggregation_mode", 2);
    L10:
        possibleAddWrapper(r15, this.mValues.buildDiffWrapper(this.mContactsQueryUri));
        Iterator<ArrayList<ValuesDelta>> r9 = this.mEntries.values().iterator();
    L12:
        if (r9.hasNext() == false) goto L38;
        Iterator<ValuesDelta> r10 = r9.next().iterator();
    L15:
        if (r10.hasNext() == false) goto L12;
        ValuesDelta r11 = r10.next();
        if (r2 == true) goto L15;
        if (this.mContactsQueryUri.equals(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI) == false) goto L22;
        BuilderWrapper r12 = r11.buildDiffWrapper(Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"));
    L24:
        if (r11.isInsert() == true) goto L26;
        if (r1 == false) goto L36;
        if (r12 == null) goto L36;
        if (r12.getBuilder() == null) goto L36;
        throw new IllegalArgumentException("When parent insert, child must be also");
    L36:
        possibleAddWrapper(r15, r12);
        goto L15
    L26:
        if (r1 == false) goto L28;
        r12.getBuilder().withValueBackReference(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r0);
        goto L36
    L28:
        r12.getBuilder().withValue(GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, r6);
        goto L36
    L22:
        r12 = r11.buildDiffWrapper(ContactsContract.Data.CONTENT_URI);
        goto L24
    L38:
        if (r15.size() <= r0) goto L40;
        boolean r3 = true;
    L41:
        if (r3 == false) goto L44;
        if (r5 == false) goto L44;
        r15.add(r0, new CPOWrapper(buildSetAggregationMode(r6, 2).build(), 2));
        r15.add(new CPOWrapper(buildSetAggregationMode(r6, 0).build(), 2));
        return;
    L44:
        if (r1 == false) goto L55;
        ContentProviderOperation.Builder r14 = ContentProviderOperation.newUpdate(this.mContactsQueryUri);
        r14.withValue("aggregation_mode", 0);
        r14.withSelection("_id=?", new String[1]);
        r14.withSelectionBackReference(0, r0);
        r15.add(new CPOWrapper(r14.build(), 2));
        return;
    L55:
        return;
    L40:
        r3 = false;
    L6:
        r5 = false;
        goto L7
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
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        addEntry((ValuesDelta) r5.readParcelable(r0));
        r2 = r2 + 1;
        goto L3
    }

    public void setProfileQueryUri() {
        this.mContactsQueryUri = ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
