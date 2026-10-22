package com.android.contacts.recommend;

import android.content.ContentUris;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.contacts.calllog.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendContact extends BaseFlowAdapter.FlowEntry {
    public static final Parcelable.Creator<RecommendContact> CREATOR = null;
    public static RecommendContact EMPTY;
    public int callTimes;
    public long contactId;
    public long date;
    public int features;
    public String formattedNumber;
    public String label;
    public int lastCallType;
    public String lastContactSlotId;
    public int lastContactSubId;
    public Uri lookupUri;
    public String name;
    public String normalizedNumber;
    public String number;
    public Set<String> numbers;
    public long photoId;
    public Uri photoUri;
    public int type;
    public float weight;

    static {
        EMPTY = new RecommendContact();
        CREATOR = new AnonymousClass1();
    }

    public RecommendContact() {
        super(1);
        this.lastCallType = -1;
        this.lastContactSubId = -1;
        this.numbers = new HashSet();
    }

    public RecommendContact(ContactInfo r3) {
        super(1);
        this.lastCallType = -1;
        this.lastContactSubId = -1;
        this.name = r3.name;
        this.number = r3.number;
        this.type = r3.type;
        this.label = r3.label;
        this.normalizedNumber = r3.normalizedNumber;
        this.formattedNumber = r3.formattedNumber;
        this.photoId = r3.photoId;
        this.photoUri = r3.photoUri;
        this.lookupUri = r3.lookupUri;
        this.numbers = new HashSet();
        if (r3.lookupUri != null) goto L6;
        long r0 = 0;
    L7:
        this.contactId = r0;     // Catch: Exception -> L9
        return;
    L6:
        r0 = ContentUris.parseId(r3.lookupUri);     // Catch: Exception -> L9
    }

    public RecommendContact(RecommendContact r3) {
        super(1);
        this.lastCallType = -1;
        this.lastContactSubId = -1;
        this.name = r3.name;
        this.number = r3.number;
        this.type = r3.type;
        this.label = r3.label;
        this.normalizedNumber = r3.normalizedNumber;
        this.formattedNumber = r3.formattedNumber;
        this.photoId = r3.photoId;
        this.photoUri = r3.photoUri;
        this.lookupUri = r3.lookupUri;
        this.numbers = new HashSet();
        this.contactId = r3.contactId;
    }

    public RecommendContact(Parcel r4) {
        super(r4);
        this.lastCallType = -1;
        this.lastContactSubId = -1;
        this.name = r4.readString();
        this.number = r4.readString();
        this.normalizedNumber = r4.readString();
        this.photoId = r4.readLong();
        String r0 = r4.readString();
        Uri r2 = null;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        Uri r1 = null;
    L6:
        this.photoUri = r1;
        String r3 = r4.readString();
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r2 = Uri.parse(r3);
    L10:
        this.lookupUri = r2;
        this.features = r4.readInt();
        this.lastCallType = r4.readInt();
        this.lastContactSlotId = r4.readString();
        this.lastContactSubId = r4.readInt();
        this.contactId = r4.readLong();
        this.callTimes = r4.readInt();
        this.date = r4.readLong();
        this.weight = r4.readFloat();
        ArrayList r5 = new ArrayList();
        r4.readStringList(r5);
        this.numbers = new HashSet(r5);
        return;
    L5:
        r1 = Uri.parse(r0);
        goto L6
    }

    public boolean isMissCallLog() {
        if (this.lastCallType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCallLog() {
        int r2 = this.lastCallType;
        if (r2 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 6) goto L7;
        return true;
    }

    public boolean isValid() {
        if (getItemType() == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.contactId <= 0) goto L7;
        return true;
    }

    public boolean isSameContactWith(RecommendContact r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (this.contactId != r4.contactId) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean matchesWith(RecommendContact r5) {
        if (TextUtils.equals(this.name, r5.name) == true) goto L5;
    L19:
        return false;
    L5:
        if (this.type != r5.type) goto L19;
        if (TextUtils.equals(this.label, r5.label) == false) goto L19;
        if (TextUtils.equals(this.normalizedNumber, r5.normalizedNumber) == false) goto L19;
        if (TextUtils.equals(this.formattedNumber, r5.formattedNumber) == false) goto L19;
        if (this.photoId != r5.photoId) goto L19;
        if (Objects.equals(this.photoUri, r5.photoUri) == false) goto L19;
        if (Objects.equals(this.lookupUri, r5.lookupUri) == false) goto L19;
        return true;
    }

    public boolean equals(Object r4) {
        if (r4 == null) goto L5;
    L7:
        RecommendContact r5 = (RecommendContact) r4;
        if (TextUtils.equals(this.number, r5.number) == true) goto L10;
        return false;
    L10:
        if (this.callTimes != r5.callTimes) goto L14;
        return true;
    L14:
        return false;
    L5:
        if ((r4 instanceof RecommendContact) == true) goto L7;
        return false;
    }

    public int hashCode() {
        return (this.number.hashCode() + this.name.hashCode()) + super.hashCode();
    }

    public String toString() {
        return "[RecommnedContact: itemType=" + getItemType() + ", contactId=" + this.contactId + ", name=" + this.name + ", number=" + this.number + ", weight=" + this.weight + "]";
    }

    public static RecommendContact copy(Parcelable r2) {
        Parcel r0 = Parcel.obtain();     // Catch: Throwable -> L9
        r0.writeParcelable(r2, 0);     // Catch: Throwable -> L7
        r0.setDataPosition(0);     // Catch: Throwable -> L7
        RecommendContact r3 = (RecommendContact) r0.readParcelable(r2.getClass().getClassLoader());     // Catch: Throwable -> L7
        r0.recycle();
        return r3;
    L7:
        th = th;
    L11:
        r0.recycle();
        throw th;
    L9:
        th = th;
        r0 = null;
        goto L11
    }

    @Override // com.android.contacts.recommend.BaseFlowAdapter.FlowEntry, android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        super.writeToParcel(r4, r5);
        String r6 = this.name;
        String r0 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r4.writeString(r6);
        r4.writeString(this.number);
        String r7 = this.normalizedNumber;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r4.writeString(r7);
        r4.writeLong(this.photoId);
        Uri r8 = this.photoUri;
        if (r8 != null) goto L11;
        String r9 = "";
    L12:
        r4.writeString(r9);
        Uri r10 = this.lookupUri;
        if (r10 != null) goto L15;
        String r11 = "";
    L16:
        r4.writeString(r11);
        r4.writeInt(this.features);
        r4.writeInt(this.lastCallType);
        String r12 = this.lastContactSlotId;
        if (r12 == null) goto L20;
        r0 = r12;
    L20:
        r4.writeString(r0);
        r4.writeInt(this.lastContactSubId);
        r4.writeLong(this.contactId);
        r4.writeInt(this.callTimes);
        r4.writeLong(this.date);
        r4.writeFloat(this.weight);
        ArrayList r13 = new ArrayList();
        Iterator<String> r3 = this.numbers.iterator();
    L22:
        if (r3.hasNext() == false) goto L24;
        r13.add(r3.next());
        goto L22
    L24:
        r4.writeStringList(r13);
        return;
    L15:
        r11 = r10.toString();
        goto L16
    L11:
        r9 = r8.toString();
        goto L12
    }
}
