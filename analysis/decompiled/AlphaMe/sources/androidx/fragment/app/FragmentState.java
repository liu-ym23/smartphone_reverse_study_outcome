package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0280b(4);

    /* renamed from: a, reason: collision with root package name */
    public final String f3603a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3604b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3605c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3606d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3607e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3608f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3609g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3610h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3611i;

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f3612j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3613k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3614l;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f3615m;

    public FragmentState(D d4) {
        this.f3603a = d4.getClass().getName();
        this.f3604b = d4.mWho;
        this.f3605c = d4.mFromLayout;
        this.f3606d = d4.mFragmentId;
        this.f3607e = d4.mContainerId;
        this.f3608f = d4.mTag;
        this.f3609g = d4.mRetainInstance;
        this.f3610h = d4.mRemoving;
        this.f3611i = d4.mDetached;
        this.f3612j = d4.mArguments;
        this.f3613k = d4.mHidden;
        this.f3614l = d4.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3603a);
        sb.append(" (");
        sb.append(this.f3604b);
        sb.append(")}:");
        if (this.f3605c) {
            sb.append(" fromLayout");
        }
        int i4 = this.f3607e;
        if (i4 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i4));
        }
        String str = this.f3608f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f3609g) {
            sb.append(" retainInstance");
        }
        if (this.f3610h) {
            sb.append(" removing");
        }
        if (this.f3611i) {
            sb.append(" detached");
        }
        if (this.f3613k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f3603a);
        parcel.writeString(this.f3604b);
        parcel.writeInt(this.f3605c ? 1 : 0);
        parcel.writeInt(this.f3606d);
        parcel.writeInt(this.f3607e);
        parcel.writeString(this.f3608f);
        parcel.writeInt(this.f3609g ? 1 : 0);
        parcel.writeInt(this.f3610h ? 1 : 0);
        parcel.writeInt(this.f3611i ? 1 : 0);
        parcel.writeBundle(this.f3612j);
        parcel.writeInt(this.f3613k ? 1 : 0);
        parcel.writeBundle(this.f3615m);
        parcel.writeInt(this.f3614l);
    }

    public FragmentState(Parcel parcel) {
        this.f3603a = parcel.readString();
        this.f3604b = parcel.readString();
        this.f3605c = parcel.readInt() != 0;
        this.f3606d = parcel.readInt();
        this.f3607e = parcel.readInt();
        this.f3608f = parcel.readString();
        this.f3609g = parcel.readInt() != 0;
        this.f3610h = parcel.readInt() != 0;
        this.f3611i = parcel.readInt() != 0;
        this.f3612j = parcel.readBundle();
        this.f3613k = parcel.readInt() != 0;
        this.f3615m = parcel.readBundle();
        this.f3614l = parcel.readInt();
    }
}
