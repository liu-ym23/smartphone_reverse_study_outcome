package ak4;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.util.Pair;
import bk4.q;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLink;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.link.spp.DoraSppLink;
import com.bytelink.syswrapper.ble.BTJniBridge;
import hk4.c;
import java.nio.ByteBuffer;
import java.util.List;
import pk4.d;
import pk4.j;
import pk4.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IDoraLink, c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f3999b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraSppLink f4000a;

    public static a d() {
        if (f3999b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3999b != null) goto L9;
        f3999b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3999b;
    }

    @Override // hk4.c
    public final Pair<Long, Long> c() {
        return this.f4000a.c();
    }

    @Override // hk4.c
    public final DoraDevice current() {
        return this.f4000a.A;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDeviceList() {
        return this.f4000a.getDeviceList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDoraBindList() {
        return this.f4000a.getDoraBindList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final long getDoraBondCount() {
        return this.f4000a.f204474z;
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final List<DoraDevice> getDoraList() {
        return this.f4000a.getDoraList();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getDoraState() {
        return this.f4000a.getDoraState();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final boolean hasDoraDevice() {
        return this.f4000a.hasDoraDevice();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int isReady() {
        return this.f4000a.isReady();
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int stopScan() {
        return this.f4000a.stopScan();
    }

    public a() {
        DoraSppLink r100 = new DoraSppLink();
        this.f4000a = r100;
        j.d("DoraSppLink", "DoraSppLink_Create_Instance : " + r100);
    }

    @Override // hk4.c
    public final void b(byte[] r100) {
        this.f4000a.b(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice convertScanResultToDoraDevice(ScanResult r100) {
        return this.f4000a.convertScanResultToDoraDevice(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice convertScanResultToDoraDeviceV2(ScanResult r100) {
        return this.f4000a.convertScanResultToDoraDeviceV2(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getBtConnectState(DoraDevice r100) {
        return this.f4000a.getBtConnectState(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final DoraDevice getDoraDevice(String r100) {
        return this.f4000a.getDoraDevice(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int getDoraLinkState(DoraDevice r100) {
        return this.f4000a.getDoraLinkState(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final boolean hasAppBound(int r100) {
        return this.f4000a.hasAppBound(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void initDoraSettingsConfig(String r100) {
        this.f4000a.initDoraSettingsConfig(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerDoraLinkCallback(IDoraLinkCallback r100) {
        this.f4000a.registerDoraLinkCallback(r100, false);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerETPProcessor(q r100) {
        this.f4000a.registerETPProcessor(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerHighPriorityDoraLinkCallback(IDoraLinkCallback r100) {
        this.f4000a.registerHighPriorityDoraLinkCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBindDevice(DoraDevice r100) {
        return this.f4000a.removeBindDevice(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBond(DoraDevice r100) {
        return this.f4000a.removeBond(r100, 1);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int scan(List<String> r100) {
        return this.f4000a.scan(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int sendETPPayload(byte[] r100) {
        return this.f4000a.sendETPPayload(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int stopScan(ScanCallback r100) {
        return this.f4000a.stopScan(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int unBond(DoraDevice r100) {
        return this.f4000a.unBond(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void unregisterDoraLinkCallback(IDoraLinkCallback r100) {
        this.f4000a.unregisterDoraLinkCallback(r100);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void unregisterETPProcessor(q r100) {
        this.f4000a.unregisterETPProcessor(r100);
    }

    @Override // hk4.c
    public final void a(byte[] r100, int r101) {
        this.f4000a.a(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int connect(DoraDevice r100, String r101) {
        return this.f4000a.connect(r100, r101, null);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int disConnect(DoraDevice r100, int r101) {
        return this.f4000a.disConnect(r100, r101);
    }

    public final int e(int r110, byte[] r111) {
        this.f4000a.getClass();
        if (r111 != null) goto L5;
    L8:
        j.f("DoraSppLink@8321b42", "sendRtcMessage failed: data is null or empty");
        return -1;
    L5:
        if (r111.length == 0) goto L8;
        j.a("DoraSppLink@8321b42", "sendRtcMessage: dst_session_id=48, dst_link_id=0, dst_channel_id=" + r110 + ", len=[" + r111.length + "] data=[" + d.a(r111) + "]");
        return BTJniBridge.sendMessageWithId(2, 0, 0, 48, 0, r110, r111, r111.length, false);
    }

    public final int f(byte r100, int r110) {
        DoraSppLink r101 = this.f4000a;
        r101.getClass();
        int r102 = 0;
        if (r100 != 0) goto L5;
        int r103 = 0;
    L6:
        byte r104 = (byte) r103;
        if (r104 == 0) goto L10;
        r102 = r110;
    L10:
        if (r102 >= 0) goto L12;
    L18:
        byte[] r105 = null;
    L19:
        byte[] r106 = r105;
        if (r106 != null) goto L22;
        j.b("DoraSppLink@8321b42", "syncP2PRTCConfig failed: invalid useP2P=" + r100 + ", port=" + r110);
        return -5;
    L22:
        j.d("DoraSppLink@8321b42", "syncP2PRTCConfig payload: useP2P=" + r100 + ", port=" + r110 + ", payload=[" + d.a(r106) + "]");
        int r107 = r101.G(32, 7, r106, 2000);
        StringBuilder r111 = new StringBuilder("syncP2PRTCConfig ret=");
        r111.append(r107);
        r111.append(", payloadSize=");
        r111.append(r106.length);
        j.d("DoraSppLink@8321b42", r111.toString());
        return r107;
    L12:
        if (r102 > 65535) goto L18;
        if (r104 == 0) goto L17;
        if (r102 == 0) goto L18;
    L17:
        ByteBuffer r108 = ByteBuffer.allocate(9);
        r108.put((byte) -127);
        r108.put((byte) 7);
        r108.put((byte) 1);
        r108.put((byte) 2);
        r108.putShort((short) r102);
        r108.put((byte) 2);
        r108.put((byte) 1);
        r108.put(r104);
        r105 = r108.array();
        goto L19
    L5:
        r103 = 1;
        goto L6
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final void registerDoraLinkCallback(IDoraLinkCallback r100, boolean r101) {
        this.f4000a.registerDoraLinkCallback(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int removeBond(DoraDevice r100, int r101) {
        return this.f4000a.removeBond(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int scan(List<String> r100, ScanCallback r101) {
        return this.f4000a.scan(r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int connect(DoraDevice r100, String r101, b r102) {
        return this.f4000a.connect(r100, r101, r102);
    }

    public final void g(int r100, int r101, byte[] r102) {
        this.f4000a.D(r100, r101, r102);
    }

    public final int i(int r100, int r101, byte[] r102) {
        DoraSppLink r103 = this.f4000a;
        r103.getClass();
        return r103.E(r100, r101, n.c(r100, r101, r102), 0, r102);
    }

    @Override // com.bytedance.dora.link.IDoraLink
    public final int startScan(List<ScanFilter> r100, ScanSettings r101, ScanCallback r102) {
        return this.f4000a.startScan(r100, r101, r102);
    }

    public final int h(int r100, int r101, int r102, byte[] r110) {
        return this.f4000a.E(r100, r101, r102, 0, r110);
    }

    public final int j(int r100, int r101, byte[] r102, long r110) {
        return this.f4000a.G(r100, r101, r102, r110);
    }
}
