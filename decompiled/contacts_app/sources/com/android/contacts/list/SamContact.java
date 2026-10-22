package com.android.contacts.list;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SamContact extends ContactBaseData {
    public static final Parcelable.Creator<SamContact> CREATOR = null;
    public static final String HEADER_SPECIAL_SECTION = "~";
    public static final int TYPE_CONTACT = 0;
    public static final int TYPE_COUNT = 2;
    public static final int TYPE_IMPORT = 3;
    public static final int TYPE_PROFILE = 1;
    public String LookKey;
    public String accountName;
    public String accountType;
    public String addedTime;
    public long contactId;
    public int count;
    public long date;
    public String formattedNumber;
    public CharSequence groupType;
    public boolean hasAddedTime;
    public String headerData;
    public String headerSectionData;
    public String headerSortData;
    public String headerSortSection;
    public boolean isOwner;
    public boolean isSuperPrimary;
    public String label;
    public int labelType;
    public int labelres;
    public Uri lookupUri;
    public String normalized_number;
    public String number;
    public HashMap<Long, String> numbersMap;
    public String phone;
    public long phoneId;
    public long photoId;
    public int presentation;
    public long raw_contactid;
    public String selectedFlag;
    public int simSlot;
    public Map<String, Integer> statisticMap;
    public int timesContacted;
    private int type;

    public SamContact(int r5) {
        this.count = 0;
        this.phone = "";
        this.label = null;
        this.labelType = 0;
        this.number = "";
        this.LookKey = "";
        this.normalized_number = "";
        this.formattedNumber = "";
        this.photoId = -1;
        this.raw_contactid = -1;
        this.contactId = 0;
        this.phoneId = 0;
        this.isOwner = false;
        this.addedTime = "";
        this.accountType = "";
        this.accountName = "";
        this.hasAddedTime = false;
        this.selectedFlag = "";
        this.presentation = 1;
        this.headerData = "";
        this.headerSortData = "";
        this.headerSectionData = HEADER_SPECIAL_SECTION;
        this.simSlot = -1;
        this.type = r5;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return this.name;
    }

    public SamContact getCopy() {
        SamContact r0 = new SamContact(this.type);
        r0.name = this.name;
        r0.hasname = this.hasname;
        r0.sortkey = this.sortkey;
        r0.section = this.section;
        r0.phoneBookLabel = this.phoneBookLabel;
        r0.phone = this.phone;
        r0.labelType = this.labelType;
        r0.labelres = this.labelres;
        r0.number = this.number;
        r0.LookKey = this.LookKey;
        r0.normalized_number = this.normalized_number;
        r0.photoId = this.photoId;
        r0.raw_contactid = this.raw_contactid;
        r0.timesContacted = this.timesContacted;
        r0.groupType = this.groupType;
        r0.isSuperPrimary = this.isSuperPrimary;
        r0.contactId = this.contactId;
        r0.phoneId = this.phoneId;
        r0.isOwner = this.isOwner;
        r0.addedTime = this.addedTime;
        r0.accountType = this.accountType;
        r0.accountName = this.accountName;
        r0.count = this.count;
        r0.headerData = this.headerData;
        r0.headerSortData = this.headerSortData;
        r0.headerSectionData = this.headerSectionData;
        r0.headerSortSection = this.headerSortSection;
        return r0;
    }

    @Override // com.android.contacts.list.ContactBaseData, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        super.writeToParcel(r3, r4);
        r3.writeInt(this.type);
        r3.writeLong(this.contactId);
        r3.writeLong(this.photoId);
        r3.writeString(this.LookKey);
        r3.writeByte(this.hasAddedTime ? 1 : 0);
    }

    protected SamContact(Parcel r6) {
        super(r6);
        boolean r0 = false;
        this.count = 0;
        this.type = 0;
        this.phone = "";
        this.label = null;
        this.labelType = 0;
        this.number = "";
        this.LookKey = "";
        this.normalized_number = "";
        this.formattedNumber = "";
        this.photoId = -1;
        this.raw_contactid = -1;
        this.contactId = 0;
        this.phoneId = 0;
        this.isOwner = false;
        this.addedTime = "";
        this.accountType = "";
        this.accountName = "";
        this.hasAddedTime = false;
        this.selectedFlag = "";
        this.presentation = 1;
        this.headerData = "";
        this.headerSortData = "";
        this.headerSectionData = HEADER_SPECIAL_SECTION;
        this.simSlot = -1;
        this.type = r6.readInt();
        this.contactId = r6.readLong();
        this.photoId = r6.readLong();
        this.LookKey = r6.readString();
        if (r6.readByte() <= 0) goto L5;
        r0 = true;
    L5:
        this.hasAddedTime = r0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
