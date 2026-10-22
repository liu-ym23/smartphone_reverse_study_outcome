package o6;

import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.bytedance.ttnet.diagnosis.IDiagnosisCallback;
import com.bytedance.ttnet.diagnosis.IDiagnosisRequest;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements IDiagnosisRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDiagnosisCallback f22532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f22534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ICronetDiagnosisRequest.Callback f22540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ICronetDiagnosisRequest f22541j;

    /* JADX INFO: renamed from: o6.a$a, reason: collision with other inner class name */
    public class C0326a implements ICronetDiagnosisRequest.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22542a;

        public C0326a(a r10) {
            this.f22542a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(String r10) {
            if (a.a(this.f22542a) == null) goto L6;
            a.a(this.f22542a).onDiagnosisComplete(r10);
            return;
        }
    }

    static {
    }

    public a(int r10, List r11, int r12, int r13) {
        this.f22540i = new C0326a(this);
        this.f22537f = false;
        this.f22538g = false;
        this.f22533b = r10;
        this.f22534c = r11;
        this.f22535d = r12;
        this.f22536e = r13;
        c();
    }

    public static /* synthetic */ IDiagnosisCallback a(a r10) {
        return r10.f22532a;
    }

    public final Class b(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    public final void c() {
        if (this.f22541j != null) goto L11;
        Class r10 = b("org.chromium.diagnosis.CronetDiagnosisRequestImpl");
        if (r10 == null) goto L10;
        Class r11 = Integer.TYPE;
        Object r12 = r10.getDeclaredConstructor(new Class[]{ICronetDiagnosisRequest.Callback.class, r11, List.class, r11, r11}).newInstance(new Object[]{this.f22540i, Integer.valueOf(this.f22533b), this.f22534c, Integer.valueOf(this.f22535d), Integer.valueOf(this.f22536e)});
        if ((r12 instanceof ICronetDiagnosisRequest) == false) goto L12;
        this.f22541j = (ICronetDiagnosisRequest) r12;
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f22537f == true) goto L6;
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.f22538g == true) goto L13;
        this.f22541j.cancel();     // Catch: Throwable -> L11
        this.f22538g = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r10, String r11) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f22537f == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f22541j.doExtraCommand(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r10) {
        monitor-enter(this);
        this.f22539h = r10;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f22537f == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f22532a = r10;     // Catch: Throwable -> L7
        this.f22541j.start();     // Catch: Throwable -> L7
        this.f22537f = true;     // Catch: Throwable -> L7
        String r11 = this.f22539h;     // Catch: Throwable -> L7
        if (r11 != null) goto L12;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        if (r11.isEmpty() == true) goto L14;
        doExtraCommand("extra_info", this.f22539h);     // Catch: Throwable -> L7
        goto L14
    }
}
