package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = null;
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

    public class MyResultReceiver extends IResultReceiver.Stub {
        final /* synthetic */ ResultReceiver this$0;

        public MyResultReceiver(ResultReceiver r100) {
            this.this$0 = r100;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int r100, Bundle r101) {
            ResultReceiver r102 = this.this$0;
            Handler r103 = r102.mHandler;
            if (r103 == null) goto L5;
            r103.post(new MyRunnable(r102, r100, r101));
            return;
        L5:
            r102.onReceiveResult(r100, r101);
        }
    }

    public class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;
        final /* synthetic */ ResultReceiver this$0;

        @Override // java.lang.Runnable
        public void run() {
            android_support_v4_os_ResultReceiver$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void android_support_v4_os_ResultReceiver$MyRunnable__run$___twin___() {
            this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void android_support_v4_os_ResultReceiver$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r100) {
            r100.android_support_v4_os_ResultReceiver$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public MyRunnable(ResultReceiver r100, int r101, Bundle r102) {
            this.this$0 = r100;
            this.mResultCode = r101;
            this.mResultData = r102;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onReceiveResult(int r100, Bundle r101) {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ResultReceiver(Parcel r100) {
        this.mLocal = false;
        this.mHandler = null;
        this.mReceiver = IResultReceiver.Stub.asInterface(r100.readStrongBinder());
    }

    public ResultReceiver(Handler r100) {
        this.mLocal = true;
        this.mHandler = r100;
    }

    public void send(int r100, Bundle r101) {
        if (this.mLocal == false) goto L9;
        Handler r102 = this.mHandler;
        if (r102 == null) goto L7;
        r102.post(new MyRunnable(this, r100, r101));
        return;
    L7:
        onReceiveResult(r100, r101);
        return;
    L9:
        IResultReceiver r103 = this.mReceiver;
        if (r103 == null) goto L17;
        r103.send(r100, r101);     // Catch: RemoteException -> L13
        return;
    L18:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mReceiver != null) goto L6;
        this.mReceiver = new MyResultReceiver(this);     // Catch: Throwable -> L9
    L6:
        r100.writeStrongBinder(this.mReceiver.asBinder());     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
