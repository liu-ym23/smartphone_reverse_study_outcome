package com.android.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Entity;
import android.content.EntityIterator;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsUtils;
import com.android.contacts.util.NameConverter;
import com.google.android.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EntityDeltaList extends ArrayList<EntityDelta> implements Parcelable {
    public static final Parcelable.Creator<EntityDeltaList> CREATOR = null;
    private static final String TAG = "EntityDeltaList";
    private long[] mJoinWithRawContactIds;
    private boolean mSplitRawContacts;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ EntityDeltaList(AnonymousClass1 r1) {
        this();
    }

    private EntityDeltaList() {
    }

    public static EntityDeltaList fromSingle(EntityDelta r1) {
        EntityDeltaList r0 = new EntityDeltaList();
        r0.add(r1);
        return r0;
    }

    public static EntityDeltaList fromQuery(Uri r6, ContentResolver r7, String r8, String[] r9, String r10) {
        EntityIterator r11 = ContactsContract.RawContacts.newEntityIterator(r7.query(r6, null, r8, r9, r10));
        EntityDeltaList r12 = fromIterator(r11);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();
        throw th;
    }

    public static EntityDeltaList fromIterator(Iterator<Entity> r2) {
        EntityDeltaList r0 = new EntityDeltaList();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(EntityDelta.fromBefore(r2.next()));
        goto L4
    L6:
        return r0;
    }

    public static EntityDeltaList mergeAfter(EntityDeltaList r2, EntityDeltaList r3) {
        if (r2 != null) goto L4;
        r2 = new EntityDeltaList();
    L4:
        Iterator<EntityDelta> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        EntityDelta r0 = r4.next();
        EntityDelta r1 = r2.getByRawContactId(r0.getValues().getId());
        EntityDelta r5 = EntityDelta.mergeAfter(r1, r0);
        if (r1 != null) goto L6;
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L11:
        return r2;
    }

    public ArrayList<ContentProviderOperation> buildDiff() {
        ArrayList<ContentProviderOperation> r1 = Lists.newArrayList();
        long r2 = findRawContactId();
        if (ContactsUtils.DEBUG == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "buildDiff before rawContactId " + r2 + " entity delta size " + size());
        Iterator<EntityDelta> r4 = iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "delta " + r4.next().toString());
    L8:
        Iterator<EntityDelta> r5 = iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r5.next().buildAssert(r1);
        goto L10
    L12:
        int r6 = r1.size();
        int[] r7 = new int[size()];
        HashMap r8 = new HashMap();
        Iterator<EntityDelta> r9 = iterator();
    L14:
        if (r9.hasNext() == false) goto L17;
        r9.next().buildNameSyncCache(r8);
        goto L14
    L17:
        if (r8.size() <= 0) goto L28;
        List r10 = (List) r8.values().iterator().next();
        if (r10 == null) goto L28;
        if (r10.size() <= 0) goto L28;
        NameConverter.NameHolder r11 = (NameConverter.NameHolder) r10.get(0);
        if (r11.isAvailable() == false) goto L28;
        Iterator<EntityDelta> r12 = iterator();
    L26:
        if (r12.hasNext() == false) goto L28;
        r12.next().syncNameByHolder(r11);
    L28:
        Iterator<EntityDelta> r13 = iterator();
        int r14 = 0;
        int r15 = -1;
    L30:
        if (r13.hasNext() == false) goto L58;
        EntityDelta r16 = r13.next();
        int r17 = r1.size();
        boolean r18 = r16.isContactInsert();
        int r19 = r14 + 1;
        if (r18 == false) goto L34;
        int r110 = r17;
    L35:
        r7[r14] = r110;
        r16.buildDiff(r1);
        long[] r20 = this.mJoinWithRawContactIds;
        if (r20 == null) goto L44;
        int r21 = r20.length;
        int r111 = 0;
    L38:
        if (r111 >= r21) goto L44;
        Iterator<EntityDelta> r112 = r13;
        Long r22 = Long.valueOf(r20[r111]);
        int r113 = r21;
        ContentProviderOperation.Builder r23 = beginKeepTogether();
        r23.withValue("raw_contact_id1", r22);
        if (r2 == (-1)) goto L42;
        r23.withValue("raw_contact_id2", Long.valueOf(r2));
    L43:
        r1.add(r23.build());
        r111 = r111 + 1;
        r13 = r112;
        r21 = r113;
        goto L38
    L42:
        r23.withValueBackReference("raw_contact_id2", r17);
    L44:
        Iterator<EntityDelta> r114 = r13;
        if (r18 == false) goto L49;
        if (this.mSplitRawContacts == true) goto L49;
        if (r2 == (-1)) goto L54;
        ContentProviderOperation.Builder r24 = beginKeepTogether();
        r24.withValue("raw_contact_id1", Long.valueOf(r2));
        r24.withValueBackReference("raw_contact_id2", r17);
        r1.add(r24.build());
        goto L49
    L54:
        if (r15 != (-1)) goto L56;
        r15 = r17;
        goto L49
    L56:
        ContentProviderOperation.Builder r25 = beginKeepTogether();
        r25.withValueBackReference("raw_contact_id1", r15);
        r25.withValueBackReference("raw_contact_id2", r17);
        r1.add(r25.build());
    L49:
        r14 = r19;
        r13 = r114;
        goto L30
    L34:
        r110 = -1;
        goto L35
    L58:
        if (this.mSplitRawContacts == false) goto L61;
        buildSplitContactDiff(r1, r7);
    L61:
        if (r1.size() != r6) goto L63;
        r1.clear();
    L63:
        return r1;
    }

    protected ContentProviderOperation.Builder beginKeepTogether() {
        ContentProviderOperation.Builder r2 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r2.withValue("type", 1);
        return r2;
    }

    private void buildSplitContactDiff(ArrayList<ContentProviderOperation> r5, int[] r6) {
        int r0 = size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L9;
        if (r2 == r3) goto L8;
        buildSplitContactDiff(r5, r2, r3, r6);
    L8:
        r3 = r3 + 1;
        goto L5
    L9:
        r2 = r2 + 1;
        goto L3
    }

    private void buildSplitContactDiff(ArrayList<ContentProviderOperation> r9, int r10, int r11, int[] r12) {
        ContentProviderOperation.Builder r0 = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        r0.withValue("type", 2);
        Long r1 = get(r10).getValues().getAsLong("_id");
        int r13 = r12[r10];
        if (r1 != null) goto L5;
    L7:
        if (r13 < 0) goto L18;
        r0.withValueBackReference("raw_contact_id1", r13);
    L9:
        Long r8 = get(r11).getValues().getAsLong("_id");
        int r14 = r12[r11];
        if (r8 != null) goto L12;
    L14:
        if (r14 < 0) goto L19;
        r0.withValueBackReference("raw_contact_id2", r14);
    L16:
        r9.add(r0.build());
        return;
    L19:
        return;
    L12:
        if (r8.longValue() < 0) goto L14;
        r0.withValue("raw_contact_id2", r8);
        goto L16
    L18:
        return;
    L5:
        if (r1.longValue() < 0) goto L7;
        r0.withValue("raw_contact_id1", r1);
        goto L9
    }

    public long findRawContactId() {
        Iterator<EntityDelta> r5 = iterator();
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
        EntityDelta.ValuesDelta r1 = get(r2).getValues();
        if (r1.isVisible() == true) goto L8;
        return null;
    L8:
        return r1.getAsLong("_id");
    L11:
        return null;
    }

    public EntityDelta getByRawContactId(Long r2) {
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
        Iterator<EntityDelta> r2 = iterator();
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

    public EntityDelta getFirstWritableRawContact(Context r2) {
        int r3 = indexOfFirstWritableRawContact(r2);
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        return get(r3);
    }

    public EntityDelta.ValuesDelta getSuperPrimaryEntry(String r7) {
        Iterator<EntityDelta> r6 = iterator();
        EntityDelta.ValuesDelta r1 = null;
        EntityDelta.ValuesDelta r2 = null;
    L4:
        if (r6.hasNext() == false) goto L20;
        ArrayList<EntityDelta.ValuesDelta> r3 = r6.next().getMimeEntries(r7);
        if (r3 == null) goto L7;
        Iterator<EntityDelta.ValuesDelta> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L4;
        EntityDelta.ValuesDelta r5 = r4.next();
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
        Iterator<EntityDelta> r0 = iterator();
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
        add((EntityDelta) r6.readParcelable(r0));
        r3 = r3 + 1;
        goto L3
    L5:
        this.mJoinWithRawContactIds = r6.createLongArray();
        if (r6.readInt() == 0) goto L8;
        r2 = true;
    L8:
        this.mSplitRawContacts = r2;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ContactLoader.Result buildContactResult() {
        Iterator<EntityDelta> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ContactLoader.Result r0 = r1.next().buildToResult();
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }
}
