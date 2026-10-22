package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    public class MyResultReceiver extends IResultReceiver.Stub {
        final /* synthetic */ ResultReceiver this$0;

        public MyResultReceiver(ResultReceiver r10) {
            this.this$0 = r10;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int r10, Bundle r11) {
            ResultReceiver r12 = this.this$0;
            Handler r13 = r12.mHandler;
            if (r13 == null) goto L5;
            r13.post(new MyRunnable(r12, r10, r11));
            return;
        L5:
            r12.onReceiveResult(r10, r11);
        }
    }

    public class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;
        final /* synthetic */ ResultReceiver this$0;

        public MyRunnable(ResultReceiver r10, int r11, Bundle r12) {
            this.this$0 = r10;
            this.mResultCode = r11;
            this.mResultData = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ResultReceiver(Handler r10) {
        this.mLocal = true;
        this.mHandler = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int r10, Bundle r11) {
    }

    public void send(int r10, Bundle r11) {
        if (this.mLocal == false) goto L9;
        Handler r12 = this.mHandler;
        if (r12 == null) goto L7;
        r12.post(new MyRunnable(this, r10, r11));
        return;
    L7:
        onReceiveResult(r10, r11);
        return;
    L9:
        IResultReceiver r13 = this.mReceiver;
        if (r13 == null) goto L17;
        r13.send(r10, r11);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mReceiver != null) goto L8;
        this.mReceiver = new MyResultReceiver(this);     // Catch: Throwable -> L6
    L8:
        r10.writeStrongBinder(this.mReceiver.asBinder());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public ResultReceiver(Parcel r10) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver.Stub.asInterface(r10.readStrongBinder());
    }
}
