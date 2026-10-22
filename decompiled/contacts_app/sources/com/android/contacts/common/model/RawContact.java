package com.android.contacts.common.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.model.account.AccountType;
import com.android.contacts.common.model.account.AccountWithDataSet;
import com.android.contacts.common.model.dataitem.DataItem;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RawContact implements Parcelable {
    public static final Parcelable.Creator<RawContact> CREATOR = null;
    private AccountTypeManager mAccountTypeManager;
    private final ArrayList<NamedDataItem> mDataItems;
    private final ContentValues mValues;

    public static final class NamedDataItem implements Parcelable {
        public static final Parcelable.Creator<NamedDataItem> CREATOR = null;
        public final ContentValues mContentValues;
        public final Uri mUri;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public NamedDataItem(Uri r1, ContentValues r2) {
            this.mUri = r1;
            this.mContentValues = r2;
        }

        public NamedDataItem(Parcel r2) {
            this.mUri = (Uri) r2.readParcelable(Uri.class.getClassLoader());
            this.mContentValues = (ContentValues) r2.readParcelable(ContentValues.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeParcelable(this.mUri, r3);
            r2.writeParcelable(this.mContentValues, r3);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.mUri, this.mContentValues});
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if (getClass() == r4.getClass()) goto L8;
            return false;
        L8:
            NamedDataItem r5 = (NamedDataItem) r4;
            if (Objects.equal(this.mUri, r5.mUri) == true) goto L11;
            return false;
        L11:
            if (Objects.equal(this.mContentValues, r5.mContentValues) == false) goto L15;
            return true;
        L15:
            return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ RawContact(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static RawContact createFrom(Entity r3) {
        ContentValues r0 = r3.getEntityValues();
        ArrayList<Entity.NamedContentValues> r4 = r3.getSubValues();
        RawContact r1 = new RawContact(r0);
        Iterator<Entity.NamedContentValues> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Entity.NamedContentValues r2 = r5.next();
        r1.addNamedDataItemValues(r2.uri, r2.values);
        goto L4
    L6:
        return r1;
    }

    public RawContact() {
        this(new ContentValues());
    }

    public RawContact(ContentValues r1) {
        this.mValues = r1;
        this.mDataItems = new ArrayList();
    }

    private RawContact(Parcel r2) {
        this.mValues = (ContentValues) r2.readParcelable(ContentValues.class.getClassLoader());
        ArrayList<NamedDataItem> r0 = Lists.newArrayList();
        this.mDataItems = r0;
        r2.readTypedList(r0, NamedDataItem.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mValues, r3);
        r2.writeTypedList(this.mDataItems);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public AccountTypeManager getAccountTypeManager(Context r2) {
        if (this.mAccountTypeManager != null) goto L6;
        this.mAccountTypeManager = AccountTypeManager.getInstance(r2);
    L6:
        return this.mAccountTypeManager;
    }

    public ContentValues getValues() {
        return this.mValues;
    }

    public Long getId() {
        return getValues().getAsLong("_id");
    }

    public String getAccountName() {
        return getValues().getAsString("account_name");
    }

    public String getAccountTypeString() {
        return getValues().getAsString("account_type");
    }

    public String getDataSet() {
        return getValues().getAsString("data_set");
    }

    public boolean isDirty() {
        return getValues().getAsBoolean("dirty").booleanValue();
    }

    public String getSourceId() {
        return getValues().getAsString("sourceid");
    }

    public String getSync1() {
        return getValues().getAsString("sync1");
    }

    public String getSync2() {
        return getValues().getAsString("sync2");
    }

    public String getSync3() {
        return getValues().getAsString("sync3");
    }

    public String getSync4() {
        return getValues().getAsString("sync4");
    }

    public boolean isDeleted() {
        return getValues().getAsBoolean("deleted").booleanValue();
    }

    public long getContactId() {
        return getValues().getAsLong("contact_id").longValue();
    }

    public boolean isStarred() {
        return getValues().getAsBoolean(ContactSaveService.EXTRA_STARRED_FLAG).booleanValue();
    }

    public AccountType getAccountType(Context r2) {
        return getAccountTypeManager(r2).getAccountType(getAccountTypeString(), getDataSet());
    }

    private void setAccount(String r4, String r5, String r6) {
        ContentValues r3 = getValues();
        if (r4 != null) goto L8;
        if (r5 != null) goto L15;
        if (r6 != null) goto L15;
        r3.putNull("account_name");
        r3.putNull("account_type");
        r3.putNull("data_set");
        return;
    L15:
        throw new IllegalArgumentException("Not a valid combination of account name, type, and data set.");
    L8:
        if (r5 == null) goto L15;
        r3.put("account_name", r4);
        r3.put("account_type", r5);
        if (r6 != null) goto L12;
        r3.putNull("data_set");
        return;
    L12:
        r3.put("data_set", r6);
    }

    public void setAccount(AccountWithDataSet r3) {
        if (r3 == null) goto L4;
        setAccount(r3.name, r3.type, r3.dataSet);
        return;
    L4:
        setAccount(null, null, null);
    }

    public void setAccountToLocal() {
        setAccount(null, null, null);
    }

    public void addDataItemValues(ContentValues r2) {
        addNamedDataItemValues(ContactsContract.Data.CONTENT_URI, r2);
    }

    public NamedDataItem addNamedDataItemValues(Uri r2, ContentValues r3) {
        NamedDataItem r0 = new NamedDataItem(r2, r3);
        this.mDataItems.add(r0);
        return r0;
    }

    public ArrayList<ContentValues> getContentValues() {
        ArrayList<ContentValues> r0 = Lists.newArrayListWithCapacity(this.mDataItems.size());
        Iterator<NamedDataItem> r4 = this.mDataItems.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        NamedDataItem r1 = r4.next();
        if (ContactsContract.Data.CONTENT_URI.equals(r1.mUri) == false) goto L4;
        r0.add(r1.mContentValues);
        goto L4
    L8:
        return r0;
    }

    public List<DataItem> getDataItems() {
        ArrayList r0 = Lists.newArrayListWithCapacity(this.mDataItems.size());
        Iterator<NamedDataItem> r4 = this.mDataItems.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        NamedDataItem r1 = r4.next();
        if (ContactsContract.Data.CONTENT_URI.equals(r1.mUri) == false) goto L4;
        r0.add(DataItem.createFrom(r1.mContentValues));
        goto L4
    L8:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("RawContact: ");
        r0.append(this.mValues);
        Iterator<NamedDataItem> r4 = this.mDataItems.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        NamedDataItem r1 = r4.next();
        r0.append("\n  ").append(r1.mUri);
        r0.append("\n  -> ").append(r1.mContentValues);
        goto L4
    L7:
        return r0.toString();
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mValues, this.mDataItems});
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (getClass() == r4.getClass()) goto L8;
        return false;
    L8:
        RawContact r5 = (RawContact) r4;
        if (Objects.equal(this.mValues, r5.mValues) == true) goto L11;
        return false;
    L11:
        if (Objects.equal(this.mDataItems, r5.mDataItems) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
