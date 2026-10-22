package com.bytedance.ttnet.diagnosis;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TTNetDiagnosisRequest.java */
/* JADX INFO: loaded from: classes.dex */
class a implements IDiagnosisRequest {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDiagnosisCallback f11415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f11417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11419e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;
    private com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a j;
    private com.bytedance.frameworks.baselib.network.http.cronet.a.a k;

    /* JADX INFO: renamed from: com.bytedance.ttnet.diagnosis.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTNetDiagnosisRequest.java */
    class C0258a implements com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11420a;

        C0258a(a r1) {
            this.f11420a = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a
        public void a(String r2) {
            if (a.a(this.f11420a) == null) goto L6;
            a.a(this.f11420a).onDiagnosisComplete(r2);
            return;
        }
    }

    static {
    }

    static /* synthetic */ IDiagnosisCallback a(a r0) {
        return r0.f11415a;
    }

    public a(int r3, List<String> r4, int r5, int r6, int r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.j = new C0258a(this);
        this.g = false;
        this.h = false;
        this.f11416b = r3;
        this.f11417c = r8;
        this.f11418d = r5;
        this.f11419e = r6;
        this.f = r7;
        a();
    }

    private void a() {
        if (this.k != null) goto L11;
        Class<?> r0 = a("org.chromium.diagnosis.CronetDiagnosisRequestImpl");
        if (r0 == null) goto L10;
        Object r1 = r0.getDeclaredConstructor(new Class[]{com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a.class, Integer.TYPE, List.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{this.j, Integer.valueOf(this.f11416b), this.f11417c, Integer.valueOf(this.f11418d), Integer.valueOf(this.f11419e), Integer.valueOf(this.f)});
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.frameworks.baselib.network.http.cronet.a.a.class) == false) goto L12;
        this.k = (com.bytedance.frameworks.baselib.network.http.cronet.a.a) ZeusTransformUtils.preCheckCast(r1, com.bytedance.frameworks.baselib.network.http.cronet.a.a.class, "com.obric.aiagent.plugin");
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    private Class<?> a(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r3) {
        IDiagnosisCallback r4 = (IDiagnosisCallback) ZeusTransformUtils.wrapperContextForParams(r3, IDiagnosisCallback.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L8:
        this.f11415a = r4;     // Catch: Throwable -> L15
        this.k.start();     // Catch: Throwable -> L15
        this.g = true;     // Catch: Throwable -> L15
        String r5 = this.i;     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L11:
        if (r5.isEmpty() == true) goto L13;
        doExtraCommand("extra_info", this.i);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.h == true) goto L11;
        this.k.cancel();     // Catch: Throwable -> L13
        this.h = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.k.doExtraCommand(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r2) {
        monitor-enter(this);
        this.i = r2;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
