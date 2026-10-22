package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkChangeNotifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37803a = true;
    private static NetworkChangeNotifier g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Long> f37804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.ttnet.org.chromium.base.m<a> f37805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NetworkChangeNotifierAutoDetect f37806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37807e;
    private int f;

    public interface a {
        void a(int r1);
    }

    interface b {
        void a(long r1, NetworkChangeNotifier r3, int r4);

        void a(long r1, NetworkChangeNotifier r3, int r4, long r5);

        void a(long r1, NetworkChangeNotifier r3, long r4);

        void a(long r1, NetworkChangeNotifier r3, long r4, boolean r6, int r7);

        void a(long r1, NetworkChangeNotifier r3, boolean r4, long r5);

        void a(long r1, NetworkChangeNotifier r3, long[] r4);

        void b(long r1, NetworkChangeNotifier r3, int r4);
    }

    static {
    }

    static /* synthetic */ int a(NetworkChangeNotifier r0) {
        return r0.f37807e;
    }

    static /* synthetic */ void a(NetworkChangeNotifier r0, int r1) {
        r0.d(r1);
    }

    public NetworkChangeNotifier() {
        this.f37807e = 0;
        this.f = 0;
        this.f37804b = new ArrayList();
        this.f37805c = new com.ttnet.org.chromium.base.m();
    }

    public static NetworkChangeNotifier init() {
        if (g != null) goto L6;
        g = new NetworkChangeNotifier();
    L6:
        return g;
    }

    public int getCurrentConnectionType() {
        return this.f37807e;
    }

    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect r0 = this.f37806d;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.d().h();
    }

    public int getCurrentConnectionCost() {
        return this.f;
    }

    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r2 = this.f37806d;
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.f();
    }

    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r0 = this.f37806d;
        if (r0 != null) goto L6;
        return new long[0];
    L6:
        return r0.e();
    }

    public void addNativeObserver(long r1) {
        this.f37804b.add(Long.valueOf(r1));
    }

    public void removeNativeObserver(long r1) {
        this.f37804b.remove(Long.valueOf(r1));
    }

    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r0 = this.f37806d;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.h();
    }

    public static NetworkChangeNotifier a() {
        if (f37803a == true) goto L10;
        if (g != null) goto L10;
        throw new AssertionError();
    L10:
        return g;
    }

    public static void setAutoDetectConnectivityState(boolean r2) {
        a().a(r2, new v());
    }

    public static void b() {
        a().a(true, new u());
    }

    private void c() {
        NetworkChangeNotifierAutoDetect r0 = this.f37806d;
        if (r0 == null) goto L6;
        r0.a();
        this.f37806d = null;
        return;
    }

    private void a(boolean r2, NetworkChangeNotifierAutoDetect.d r3) {
        if (r2 == true) goto L4;
        c();
        return;
    L4:
        if (this.f37806d != null) goto L8;
        NetworkChangeNotifierAutoDetect r4 = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), r3);
        this.f37806d = r4;
        NetworkChangeNotifierAutoDetect.b r5 = r4.d();
        d(r5.f());
        e(r5.g());
        c(r5.h());
        return;
    }

    public static void forceUpdateNetworkTypeInfo() {
        a().d();
    }

    private void d() {
        NetworkChangeNotifierAutoDetect r0 = this.f37806d;
        if (r0 == null) goto L8;
        NetworkChangeNotifierAutoDetect.b r1 = r0.d();
        if (this.f37807e == r1.f()) goto L9;
        this.f37807e = r1.f();
        this.f37806d.a(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    public long getCurrentVpnNetId() {
        NetworkChangeNotifierAutoDetect r2 = this.f37806d;
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.g();
    }

    public static void forceConnectivityState(boolean r1) {
        setAutoDetectConnectivityState(false);
        a().a(r1);
    }

    private void a(boolean r5) {
        int r2 = 0;
        if (this.f37807e == 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == r5) goto L12;
        if (r5 == true) goto L10;
        r2 = 6;
    L10:
        d(r2);
        c(!r5 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void fakeNetworkConnected(long r2, int r4) {
        setAutoDetectConnectivityState(false);
        a().a(r2, r4, false);
    }

    public static void fakeNetworkSoonToBeDisconnected(long r1) {
        setAutoDetectConnectivityState(false);
        a().a(r1);
    }

    public static void fakeNetworkDisconnected(long r2) {
        setAutoDetectConnectivityState(false);
        a().a(r2, false);
    }

    public static void fakePurgeActiveNetworkList(long[] r1) {
        setAutoDetectConnectivityState(false);
        a().a(r1);
    }

    public static void fakeDefaultNetwork(long r1, int r3) {
        setAutoDetectConnectivityState(false);
        a().a(r3, r1);
    }

    public static void fakeConnectionCostChanged(int r1) {
        setAutoDetectConnectivityState(false);
        a().b(r1);
    }

    public static void fakeConnectionSubtypeChanged(int r1) {
        setAutoDetectConnectivityState(false);
        a().c(r1);
    }

    private void d(int r1) {
        this.f37807e = r1;
        a(r1);
    }

    void a(int r3) {
        a(r3, getCurrentDefaultNetId());
    }

    private void a(int r10, long r11) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r10, r11);
        goto L4
    L6:
        Iterator<a> r9 = this.f37805c.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.aiagent.plugin")).a(r10);
        goto L8
    }

    private void e(int r1) {
        this.f = r1;
        b(r1);
    }

    void b(int r6) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r6);
        goto L4
    }

    void c(int r6) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().b(r1.longValue(), this, r6);
        goto L4
    }

    void a(long r11, int r13, boolean r14) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r11, r14, r13);
        goto L4
    }

    void a(long r9) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r9);
        goto L4
    }

    void a(long r10, boolean r12) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r12, r10);
        goto L4
    }

    void a(long[] r6) {
        Iterator<Long> r0 = this.f37804b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.aiagent.plugin");
        n.a().a(r1.longValue(), this, r6);
        goto L4
    }
}
