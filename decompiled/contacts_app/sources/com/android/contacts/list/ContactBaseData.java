package com.android.contacts.list;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ContactBaseData implements Comparable<ContactBaseData>, Parcelable {
    public static final Parcelable.Creator<ContactBaseData> CREATOR = null;
    public String group;
    public boolean hasname;
    public int index;
    public String name;
    public String phoneBookLabel;
    public String section;
    public String sortkey;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ContactBaseData r1) {
        return compareTo2(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ContactBaseData r1) {
        String r0 = this.section;
        if (r0 == null) goto L9;
        String r2 = r1.section;
        if (r2 != null) goto L8;
        return 0;
    L8:
        return r0.compareTo(r2);
    L9:
        return 0;
    }

    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.name);
        r1.writeInt(this.hasname ? 1 : 0);
        r1.writeString(this.sortkey);
        r1.writeString(this.section);
        r1.writeString(this.group);
        r1.writeInt(this.index);
    }

    protected ContactBaseData(Parcel r4) {
        this.name = "";
        boolean r1 = false;
        this.hasname = false;
        this.sortkey = "";
        this.section = "";
        this.group = "";
        this.index = 0;
        this.phoneBookLabel = "";
        this.name = r4.readString();
        if (r4.readInt() != 1) goto L5;
        r1 = true;
    L5:
        this.hasname = r1;
        this.sortkey = r4.readString();
        this.section = r4.readString();
        this.group = r4.readString();
        this.index = r4.readInt();
    }

    public ContactBaseData() {
        this.name = "";
        this.hasname = false;
        this.sortkey = "";
        this.section = "";
        this.group = "";
        this.index = 0;
        this.phoneBookLabel = "";
    }
}
