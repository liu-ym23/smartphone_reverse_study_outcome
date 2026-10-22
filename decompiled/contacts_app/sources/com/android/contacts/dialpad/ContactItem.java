package com.android.contacts.dialpad;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.contacts.list.ContactBaseData;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ContactItem extends ContactBaseData implements Parcelable {
    public static final Parcelable.Creator<ContactItem> CREATOR = null;
    int callType;
    String countryIso;
    long dataId;
    long date;
    String geoLocation;
    CharSequence groupType;
    long id;
    boolean isMutilPinyinName;
    boolean isSuperPrimary;
    String label;
    String language;
    long lastConnectTime;
    Uri lookupUri;
    String lookupkey;
    int nameMatchId;
    float nameRate;
    String normalName;
    String normalNumber;
    String number;
    int numberMatchId;
    Uri photoUri;
    ArrayList<String> pinyinNameList;
    Boolean[] position;
    ArrayList<Integer> positionLength;
    ArrayList<Integer> remainingLengthList;
    ArrayList<Integer> remainingLengthListInit;
    int simId;
    String sortKeyPrimary;
    String sortname;
    int timesContacted;

    /* synthetic */ ContactItem(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public ContactItem() {
        this.lookupkey = "";
        this.sortname = "";
        this.sortKeyPrimary = "";
        this.isMutilPinyinName = false;
        this.language = Locale.ENGLISH.getLanguage();
        this.position = null;
        this.timesContacted = 0;
        this.lastConnectTime = 0;
        this.nameRate = 0.0f;
        this.pinyinNameList = new ArrayList();
        this.remainingLengthList = new ArrayList();
        this.remainingLengthListInit = new ArrayList();
        this.positionLength = new ArrayList();
    }

    private ContactItem(Parcel r6) {
        super(r6);
        this.lookupkey = "";
        this.sortname = "";
        this.sortKeyPrimary = "";
        boolean r0 = false;
        this.isMutilPinyinName = false;
        this.language = Locale.ENGLISH.getLanguage();
        this.position = null;
        this.timesContacted = 0;
        this.lastConnectTime = 0;
        this.nameRate = 0.0f;
        this.pinyinNameList = new ArrayList();
        this.remainingLengthList = new ArrayList();
        this.remainingLengthListInit = new ArrayList();
        this.positionLength = new ArrayList();
        this.photoUri = readUri(r6);
        this.number = r6.readString();
        this.normalNumber = r6.readString();
        this.normalName = r6.readString();
        this.lookupkey = r6.readString();
        this.sortname = r6.readString();
        this.lookupUri = readUri(r6);
        this.sortKeyPrimary = r6.readString();
        if (r6.readInt() != 1) goto L5;
        boolean r1 = true;
    L6:
        this.isMutilPinyinName = r1;
        this.language = r6.readString();
        this.timesContacted = r6.readInt();
        this.lastConnectTime = r6.readLong();
        this.nameMatchId = r6.readInt();
        this.numberMatchId = r6.readInt();
        this.nameRate = r6.readFloat();
        this.groupType = r6.readCharSequence();
        this.id = r6.readLong();
        this.dataId = r6.readLong();
        if (r6.readInt() != 1) goto L9;
        r0 = true;
    L9:
        this.isSuperPrimary = r0;
        this.callType = r6.readInt();
        this.geoLocation = r6.readString();
        this.date = r6.readLong();
        this.label = r6.readString();
        r6.readStringList(this.pinyinNameList);
        this.remainingLengthList = readIntegerList(r6);
        this.remainingLengthListInit = readIntegerList(r6);
        this.positionLength = readIntegerList(r6);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private ArrayList<Integer> readIntegerList(Parcel r2) {
        ArrayList<Integer> r0 = new ArrayList(r2.readInt());
        r2.readList(r0, null);
        return r0;
    }

    private void writeIntegerList(Parcel r1, ArrayList<Integer> r2) {
        r1.writeInt(r2.size());
        r1.writeList(r2);
    }

    @Override // com.android.contacts.list.ContactBaseData, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        super.writeToParcel(r3, r4);
        writeUri(r3, this.photoUri);
        r3.writeString(this.number);
        r3.writeString(this.normalNumber);
        r3.writeString(this.normalName);
        r3.writeString(this.lookupkey);
        r3.writeString(this.sortname);
        writeUri(r3, this.lookupUri);
        r3.writeString(this.sortKeyPrimary);
        r3.writeInt(this.isMutilPinyinName ? 1 : 0);
        r3.writeString(this.language);
        r3.writeInt(this.timesContacted);
        r3.writeLong(this.lastConnectTime);
        r3.writeInt(this.nameMatchId);
        r3.writeInt(this.numberMatchId);
        r3.writeFloat(this.nameRate);
        r3.writeCharSequence(this.groupType);
        r3.writeLong(this.id);
        r3.writeLong(this.dataId);
        r3.writeInt(this.isSuperPrimary ? 1 : 0);
        r3.writeInt(this.callType);
        r3.writeString(this.geoLocation);
        r3.writeLong(this.date);
        r3.writeString(this.label);
        r3.writeStringList(this.pinyinNameList);
        writeIntegerList(r3, this.remainingLengthList);
        writeIntegerList(r3, this.remainingLengthListInit);
        writeIntegerList(r3, this.positionLength);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    private Uri readUri(Parcel r1) {
        String r0 = r1.readString();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return null;
    L6:
        return Uri.parse(r0);
    }

    private void writeUri(Parcel r1, Uri r2) {
        if (r2 != null) goto L4;
        String r0 = "";
    L5:
        r1.writeString(r0);
        return;
    L4:
        r0 = r2.toString();
        goto L5
    }

    public Uri getLookupUri() {
        return this.lookupUri;
    }

    public String getNumber() {
        return this.number;
    }

    public long getContactId() {
        return this.id;
    }

    public long getDataId() {
        return this.dataId;
    }
}
