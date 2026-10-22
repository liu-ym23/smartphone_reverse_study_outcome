package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.IResultReceiver;

/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final boolean f7336a = false;

    /* renamed from: b, reason: collision with root package name */
    final Handler f7337b = null;

    /* renamed from: c, reason: collision with root package name */
    IResultReceiver f7338c;

    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i5, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f7337b;
            if (handler != null) {
                handler.post(resultReceiver.new b(i5, bundle));
            } else {
                resultReceiver.a(i5, bundle);
            }
        }
    }

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i5) {
            return new ResultReceiver[i5];
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f7339a;

        /* renamed from: b, reason: collision with root package name */
        final Bundle f7340b;

        b(int i5, Bundle bundle) {
            this.f7339a = i5;
            this.f7340b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f7339a, this.f7340b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f7338c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    protected void a(int i5, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        synchronized (this) {
            try {
                if (this.f7338c == null) {
                    this.f7338c = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.f7338c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
