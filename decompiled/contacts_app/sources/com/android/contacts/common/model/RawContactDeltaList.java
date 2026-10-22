package com.android.contacts.common.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import com.GlobalProxyLancet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class RawContactDeltaList extends ArrayList<RawContactDelta> implements Parcelable {
    public static final Parcelable.Creator<RawContactDeltaList> CREATOR = null;
    private static final String TAG = "RawContactDeltaList";
    private static final boolean VERBOSE_LOGGING = false;
    private long[] mJoinWithRawContactIds;
    private boolean mSplitRawContacts;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        VERBOSE_LOGGING = Log.isLoggable("RawContactDeltaList", 2);
        CREATOR = new AnonymousClass1();
    }

    public RawContactDeltaList() {
    }

    public static RawContactDeltaList fromQuery(Uri r6, ContentResolver r7, String r8, String[] r9, String r10) {
        EntityIterator r11 = ContactsContract.RawContacts.newEntityIterator(r7.query(r6, null, r8, r9, r10));
        RawContactDeltaList r12 = fromIterator(r11);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static RawContactDeltaList fromIterator(Iterator<?> r1) {
        RawContactDeltaList r0 = new RawContactDeltaList();
        r0.addAll(r1);
        return r0;
    }

    public void addAll(Iterator<?> r3) {
    L3:
        if (r3.hasNext() == false) goto L9;
        Object r0 = r3.next();
        if ((r0 instanceof Entity) == false) goto L7;
        RawContact r1 = RawContact.createFrom((Entity) r0);
    L8:
        add(RawContactDelta.fromBefore(r1));
        goto L3
    L7:
        r1 = (RawContact) r0;
        goto L8
    }

    public static RawContactDeltaList mergeAfter(RawContactDeltaList r2, RawContactDeltaList r3) {
        if (r2 != null) goto L4;
        r2 = new RawContactDeltaList();
    L4:
        Iterator<RawContactDelta> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        RawContactDelta r0 = r4.next();
        RawContactDelta r1 = r2.getByRawContactId(r0.getValues().getId());
        RawContactDelta r5 = RawContactDelta.mergeAfter(r1, r0);
        if (r1 != null) goto L6;
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L11:
        return r2;
    }

    public ArrayList<ContentProviderOperation> buildDiff() {
        if (VERBOSE_LOGGING == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "buildDiff: list=" + toString());
    L5:
        ArrayList<ContentProviderOperation> r1 = Lists.newArrayList();
        long r2 = findRawContactId();
        Iterator<RawContactDelta> r4 = iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().buildAssert(r1);
        goto L7
    L9:
        int r5 = r1.size();
        int[] r6 = new int[size()];
        Iterator<RawContactDelta> r7 = iterator();
        int r9 = 0;
        int r10 = -1;
    L11:
        if (r7.hasNext() == false) goto L39;
        RawContactDelta r11 = r7.next();
        int r12 = r1.size();
        boolean r13 = r11.isContactInsert();
        int r14 = r9 + 1;
        if (r13 == false) goto L15;
        int r15 = r12;
    L16:
        r6[r9] = r15;
        r11.buildDiff(r1);
        long[] r16 = this.mJoinWithRawContactIds;
        if (r16 == null) goto L25;
        int r8 = r16.length;
        int r17 = 0;
    L19:
        if (r17 >= r8) goto L25;
        Iterator<RawContactDelta> r18 = r7;
        Long r19 = Long.valueOf(r16[r17]);
        int r110 = r8;
        ContentProviderOperation.Builder r20 = beginKeepTogether();
        r20.withValue("raw_contact_id1", r19);
        if (r2 == (-1)) goto L23;
        r20.withValue("raw_contact_id2", Long.valueOf(r2));
    L24:
        r1.add(r20.build());
        r17 = r17 + 1;
        r7 = r18;
        r8 = r110;
        goto L19
    L23:
        r20.withValueBackReference("raw_contact_id2", r12);
    L25:
        Iterator<RawContactDelta> r111 = r7;
        if (r13 == false) goto L30;
        if (this.mSplitRawContacts == true) goto L30;
        if (r2 == (-1)) goto L35;
        ContentProviderOperation.Builder r21 = beginKeepTogether();
        r21.withValue("raw_contact_id1", Long.valueOf(r2));
        r21.withValueBackReference("raw_contact_id2", r12);
        r1.add(r21.build());
        goto L30
    L35:
        if (r10 != (-1)) goto L37;
        r10 = r12;
        goto L30
    L37:
        ContentProviderOperation.Builder r22 = beginKeepTogether();
        r22.withValueBackReference("raw_contact_id1", r10);
        r22.withValueBackReference("raw_contact_id2", r12);
        r1.add(r22.build());
    L30:
        r9 = r14;
        r7 = r111;
        goto L11
    L15:
        r15 = -1;
        goto L16
    L39:
        if (this.mSplitRawContacts == false) goto L42;
        buildSplitContactDiff(r1, r6);
    L42:
        if (r1.size() != r5) goto L45;
        r1.clear();
    L45:
        if (VERBOSE_LOGGING == false) goto L47;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "buildDiff: ops=" + diffToString(r1));
    L47:
        return r1;
    }

    public ArrayList<CPOWrapper> buildDiffWrapper() {
        if (VERBOSE_LOGGING == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "buildDiffWrapper: list=" + toString());
    L5:
        ArrayList<CPOWrapper> r1 = Lists.newArrayList();
        long r2 = findRawContactId();
        Iterator<RawContactDelta> r4 = iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r4.next().buildAssertWrapper(r1);
        goto L7
    L9:
        int r5 = r1.size();
        int[] r6 = new int[size()];
        Iterator<RawContactDelta> r7 = iterator();
        int r9 = 0;
        int r10 = -1;
    L11:
        if (r7.hasNext() == false) goto L39;
        RawContactDelta r11 = r7.next();
        int r12 = r1.size();
        boolean r13 = r11.isContactInsert();
        int r14 = r9 + 1;
        if (r13 == false) goto L15;
        int r15 = r12;
    L16:
        r6[r9] = r15;
        r11.buildDiffWrapper(r1);
        long[] r16 = this.mJoinWithRawContactIds;
        if (r16 == null) goto L25;
        int r17 = r16.length;
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L25;
        Iterator<RawContactDelta> r19 = r7;
        Long r8 = Long.valueOf(r16[r18]);
        long[] r110 = r16;
        ContentProviderOperation.Builder r20 = beginKeepTogether();
        r20.withValue("raw_contact_id1", r8);
        if (r2 == (-1)) goto L23;
        r20.withValue("raw_contact_id2", Long.valueOf(r2));
    L24:
        r1.add(new CPOWrapper(r20.build(), 2));
        r18 = r18 + 1;
        r7 = r19;
        r16 = r110;
        r17 = r17;
        goto L19
    L23:
        r20.withValueBackReference("raw_contact_id2", r12);
    L25:
        Iterator<RawContactDelta> r111 = r7;
        if (r13 == false) goto L30;
        if (this.mSplitRawContacts == true) goto L30;
        if (r2 == (-1)) goto L35;
        ContentProviderOperation.Builder r21 = beginKeepTogether();
        r21.withValue("raw_contact_id1", Long.valueOf(r2));
        r21.withValueBackReference("raw_contact_id2", r12);
        r1.add(new CPOWrapper(r21.build(), 2));
        goto L30
    L35:
        if (r10 != (-1)) goto L37;
        r10 = r12;
        goto L30
    L37:
        ContentProviderOperation.Builder r112 = beginKeepTogether();
        r112.withValueBackReference("raw_contact_id1", r10);
        r112.withValueBackReference("raw_contact_id2", r12);
        r1.add(new CPOWrapper(r112.build(), 2));
    L30:
        r9 = r14;
        r7 = r111;
        goto L11
    L15:
        r15 = -1;
        goto L16
    L39:
        if (this.mSplitRawContacts == false) goto L42;
        buildSplitContactDiffWrapper(r1, r6);
    L42:
        if (r1.size() != r5) goto L45;
        r1.clear();
    L45:
        if (VERBOSE_LOGGING == false) goto L47;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "buildDiff: ops=" + diffToStringWrapper(r1));
    L47:
        return r1;
    }

    private static String diffToString(ArrayList<ContentProviderOperation> r2) {
        StringBuilder r0 = new StringBuilder("[\n");
        Iterator<ContentProviderOperation> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.append(r3.next().toString());
        r0.append(",\n");
        goto L4
    L6:
        r0.append("]\n");
        return r0.toString();
    }

    private static String diffToStringWrapper(ArrayList<CPOWrapper> r2) {
        ArrayList r0 = Lists.newArrayList();
        Iterator<CPOWrapper> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.add(r3.next().getOperation());
        goto L4
    L7:
        return diffToString(r0);
    }

    protected ContentProviderOperation.Builder beginKeepTogether() {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r2.withValue("type", 1);
        return r2;
    }

    private void buildSplitContactDiff(ArrayList<ContentProviderOperation> r6, int[] r7) {
        int r0 = size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L12;
        if (r2 == r3) goto L11;
        ContentProviderOperation.Builder r4 = buildSplitContactDiffHelper(r2, r3, r7);
        if (r4 == null) goto L11;
        r6.add(r4.build());
    L11:
        r3 = r3 + 1;
        goto L5
    L12:
        r2 = r2 + 1;
        goto L3
    }

    private void buildSplitContactDiffWrapper(ArrayList<CPOWrapper> r8, int[] r9) {
        int r0 = size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L12;
        if (r2 == r3) goto L11;
        ContentProviderOperation.Builder r4 = buildSplitContactDiffHelper(r2, r3, r9);
        if (r4 == null) goto L11;
        r8.add(new CPOWrapper(r4.build(), 2));
    L11:
        r3 = r3 + 1;
        goto L5
    L12:
        r2 = r2 + 1;
        goto L3
    }

    private ContentProviderOperation.Builder buildSplitContactDiffHelper(int r10, int r11, int[] r12) {
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r0.withValue("type", 2);
        Long r1 = get(r10).getValues().getAsLong("_id");
        int r13 = r12[r10];
        if (r1 != null) goto L5;
    L7:
        if (r13 < 0) goto L17;
        r0.withValueBackReference("raw_contact_id1", r13);
    L9:
        Long r9 = get(r11).getValues().getAsLong("_id");
        int r14 = r12[r11];
        if (r9 != null) goto L12;
    L14:
        if (r14 < 0) goto L17;
        r0.withValueBackReference("raw_contact_id2", r14);
    L16:
        return r0;
    L12:
        if (r9.longValue() < 0) goto L14;
        r0.withValue("raw_contact_id2", r9);
    L17:
        return null;
    L5:
        if (r1.longValue() < 0) goto L7;
        r0.withValue("raw_contact_id1", r1);
        goto L9
    }

    public long findRawContactId() {
        Iterator<RawContactDelta> r5 = iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Long r0 = r5.next().getValues().getAsLong("_id");
        if (r0 == null) goto L4;
        if (r0.longValue() < 0) goto L4;
        return r0.longValue();
    L11:
        return -1;
    }

    public Long getRawContactId(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 >= size()) goto L11;
        ValuesDelta r1 = get(r2).getValues();
        if (r1.isVisible() == true) goto L8;
        return null;
    L8:
        return r1.getAsLong("_id");
    L11:
        return null;
    }

    public RawContactDelta getByRawContactId(Long r2) {
        int r3 = indexOfRawContactId(r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return get(r3);
    }

    public int indexOfRawContactId(Long r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        int r1 = size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        if (r5.equals(getRawContactId(r2)) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r2;
    L11:
        return -1;
    }

    public int indexOfFirstWritableRawContact(Context r3) {
        Iterator<RawContactDelta> r2 = iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r2.next().getRawContactAccountType(r3).areContactsWritable() == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public RawContactDelta getFirstWritableRawContact(Context r2) {
        int r3 = indexOfFirstWritableRawContact(r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return get(r3);
    }

    public ValuesDelta getSuperPrimaryEntry(String r7) {
        Iterator<RawContactDelta> r6 = iterator();
        ValuesDelta r1 = null;
        ValuesDelta r2 = null;
    L4:
        if (r6.hasNext() == false) goto L20;
        ArrayList<ValuesDelta> r3 = r6.next().getMimeEntries(r7);
        if (r3 == null) goto L7;
        Iterator<ValuesDelta> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        ValuesDelta r5 = r4.next();
        if (r5.isSuperPrimary() == true) goto L13;
        if (r1 != null) goto L18;
        if (r5.isPrimary() == false) goto L18;
        r1 = r5;
    L18:
        if (r2 != null) goto L10;
        r2 = r5;
        goto L10
    L13:
        return r5;
    L7:
        return null;
    L20:
        if (r1 == null) goto L22;
        return r1;
    L22:
        return r2;
    }

    public void markRawContactsForSplitting() {
        this.mSplitRawContacts = true;
    }

    public boolean isMarkedForSplitting() {
        return this.mSplitRawContacts;
    }

    public void setJoinWithRawContacts(long[] r1) {
        this.mJoinWithRawContactIds = r1;
    }

    public boolean isMarkedForJoining() {
        long[] r0 = this.mJoinWithRawContactIds;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.length <= 0) goto L7;
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(size());
        Iterator<RawContactDelta> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.writeParcelable(r0.next(), r4);
        goto L4
    L6:
        r3.writeLongArray(this.mJoinWithRawContactIds);
        r3.writeInt(this.mSplitRawContacts ? 1 : 0);
    }

    public void readFromParcel(Parcel r6) {
        ClassLoader r0 = getClass().getClassLoader();
        int r1 = r6.readInt();
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        add((RawContactDelta) r6.readParcelable(r0));
        r3 = r3 + 1;
        goto L3
    L5:
        this.mJoinWithRawContactIds = r6.createLongArray();
        if (r6.readInt() == 0) goto L8;
        r2 = true;
    L8:
        this.mSplitRawContacts = r2;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "(Split=" + this.mSplitRawContacts + ", Join=[" + Arrays.toString(this.mJoinWithRawContactIds) + "], Values=" + super.toString() + ")";
    }
}
