package com.stepos.digitalwellbeing.server.data;

import android.os.Parcel;
import android.os.Parcelable;
import f2.C0711p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Category implements Parcelable {
    public static final Parcelable.Creator<Category> CREATOR = new a();
    private int mId;
    private final int mNameResourceId;
    private final ArrayList<String> mPackages;
    private long mUpdateTime;

    class a implements Parcelable.Creator<Category> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Category createFromParcel(Parcel parcel) {
            return new Category(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Category[] newArray(int i5) {
            return new Category[i5];
        }
    }

    public Category(int i5, int i6, long j5) {
        this.mPackages = new ArrayList<>();
        this.mId = i5;
        this.mNameResourceId = i6;
        this.mUpdateTime = j5;
    }

    public void add(String str) {
        if (this.mPackages.contains(str)) {
            return;
        }
        this.mPackages.add(str);
    }

    public void addAll(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clear() {
        this.mPackages.clear();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public int getNameResourceId() {
        return this.mNameResourceId;
    }

    public List<String> getPackages() {
        return new ArrayList(this.mPackages);
    }

    public void remove(String str) {
        this.mPackages.remove(str);
    }

    public void removeAll(Collection<String> collection) {
        this.mPackages.removeAll(collection);
    }

    public void setId(int i5) {
        this.mId = i5;
    }

    public void setUpdateTime(long j5) {
        this.mUpdateTime = j5;
    }

    public String toString() {
        return "Category{mId=" + P1.a.a().getString(this.mNameResourceId) + ", mUpdateTime=" + C0711p.j(this.mUpdateTime) + ", mPackages=" + this.mPackages + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mNameResourceId);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeStringList(this.mPackages);
    }

    protected Category(Parcel parcel) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.mPackages = arrayList;
        setId(parcel.readInt());
        this.mNameResourceId = parcel.readInt();
        this.mUpdateTime = parcel.readLong();
        parcel.readStringList(arrayList);
    }
}
