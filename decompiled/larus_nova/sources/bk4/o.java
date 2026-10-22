package bk4;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements BluetoothProfile.ServiceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BluetoothProfile[] f19349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f19350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean[] f19351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f19352d;

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int r100) {
    }

    public final void a(BluetoothA2dp r100, BluetoothDevice r101) {
        Method r102 = r100.getClass().getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});     // Catch: Throwable -> L5 Exception -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L5 Exception -> L7
        this.f19351c[0] = ((Boolean) r102.invoke(r100, new Object[]{r101})).booleanValue();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        this.f19352d.countDown();
        return;
    L7:
        e = move-exception;
        pk4.j.d("DoraSppLink@8321b42", "connectA2DP: failed caused by error : " + e.getMessage());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.f19352d.countDown();
        throw th;
    }

    public final void b(BluetoothHeadset r100, BluetoothDevice r101) {
        Method r102 = r100.getClass().getDeclaredMethod("connect", new Class[]{BluetoothDevice.class});     // Catch: Throwable -> L5 Exception -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L5 Exception -> L7
        this.f19351c[0] = ((Boolean) r102.invoke(r100, new Object[]{r101})).booleanValue();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        this.f19352d.countDown();
        return;
    L7:
        e = move-exception;
        pk4.j.d("DoraSppLink@8321b42", "connectHfp: failed caused by error : " + e.getMessage());     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        this.f19352d.countDown();
        throw th;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceConnected(int r100, BluetoothProfile r101) {
        if (r100 != 2) goto L17;
        this.f19349a[0] = r101;     // Catch: Throwable -> L13 Exception -> L15
        if ((r101 instanceof BluetoothA2dp) == false) goto L12;
        BluetoothA2dp r102 = (BluetoothA2dp) r101;     // Catch: Throwable -> L13 Exception -> L15
        if (r102.getConnectionState(this.f19350b) != 2) goto L10;
        this.f19351c[0] = true;     // Catch: Throwable -> L13 Exception -> L15
        goto L12
    L10:
        if (this.f19350b.getBondState() != 12) goto L12;
        a(r102, this.f19350b);     // Catch: Throwable -> L13 Exception -> L15
    L12:
        this.f19352d.countDown();     // Catch: Throwable -> L13 Exception -> L15
    L32:
        this.f19352d.countDown();
        return;
    L17:
        if (r100 != 1) goto L32;
        this.f19349a[0] = r101;     // Catch: Throwable -> L13 Exception -> L15
        if ((r101 instanceof BluetoothHeadset) == false) goto L26;
        BluetoothHeadset r103 = (BluetoothHeadset) r101;     // Catch: Throwable -> L13 Exception -> L15
        if (r103.getConnectionState(this.f19350b) != 2) goto L24;
        this.f19351c[0] = true;     // Catch: Throwable -> L13 Exception -> L15
        goto L26
    L24:
        if (this.f19350b.getBondState() != 12) goto L26;
        b(r103, this.f19350b);     // Catch: Throwable -> L13 Exception -> L15
    L26:
        this.f19352d.countDown();     // Catch: Throwable -> L13 Exception -> L15
    L13:
        th = move-exception;
        this.f19352d.countDown();
        throw th;
    L15:
        e = move-exception;
        pk4.j.d("DoraSppLink@8321b42", "onServiceConnected: failed caused by error : " + e.getMessage());     // Catch: Throwable -> L13
        goto L32
    }

    public o(BluetoothProfile[] r100, BluetoothDevice r101, boolean[] r102, CountDownLatch r103) {
        this.f19349a = r100;
        this.f19350b = r101;
        this.f19351c = r102;
        this.f19352d = r103;
    }
}
