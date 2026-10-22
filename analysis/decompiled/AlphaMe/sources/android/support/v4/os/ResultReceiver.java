package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.IResultReceiver;
import androidx.annotation.RestrictTo;
import b.C0354a;
import e.EnumC0546d;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new C0354a(10);

    /* renamed from: a, reason: collision with root package name */
    public IResultReceiver f2367a;

    public class MyResultReceiver extends IResultReceiver.Stub {
        public MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i4, Bundle bundle) {
            ResultReceiver.this.getClass();
            ResultReceiver.this.c(i4, bundle);
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f2367a = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    public void c(int i4, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        synchronized (this) {
            try {
                if (this.f2367a == null) {
                    this.f2367a = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.f2367a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
