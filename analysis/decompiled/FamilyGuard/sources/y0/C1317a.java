package y0;

import A0.d;
import C4.D;
import C4.F;
import C4.G;
import C4.InterfaceC0275e;
import C4.InterfaceC0276f;
import H0.g;
import X0.c;
import X0.j;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import z0.C1339e;
import z0.EnumC1335a;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1317a implements d<InputStream>, InterfaceC0276f {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0275e.a f23906a;

    /* renamed from: b, reason: collision with root package name */
    private final g f23907b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f23908c;

    /* renamed from: d, reason: collision with root package name */
    private G f23909d;

    /* renamed from: e, reason: collision with root package name */
    private d.a<? super InputStream> f23910e;

    /* renamed from: f, reason: collision with root package name */
    private volatile InterfaceC0275e f23911f;

    public C1317a(InterfaceC0275e.a aVar, g gVar) {
        this.f23906a = aVar;
        this.f23907b = gVar;
    }

    @Override // A0.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // A0.d
    public void b() throws IOException {
        try {
            InputStream inputStream = this.f23908c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        G g5 = this.f23909d;
        if (g5 != null) {
            g5.close();
        }
        this.f23910e = null;
    }

    @Override // C4.InterfaceC0276f
    public void c(InterfaceC0275e interfaceC0275e, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f23910e.c(iOException);
    }

    @Override // A0.d
    public void cancel() {
        InterfaceC0275e interfaceC0275e = this.f23911f;
        if (interfaceC0275e != null) {
            interfaceC0275e.cancel();
        }
    }

    @Override // A0.d
    public EnumC1335a d() {
        return EnumC1335a.REMOTE;
    }

    @Override // A0.d
    public void e(v0.g gVar, d.a<? super InputStream> aVar) {
        D.a aVarI = new D.a().i(this.f23907b.h());
        for (Map.Entry<String, String> entry : this.f23907b.e().entrySet()) {
            aVarI.a(entry.getKey(), entry.getValue());
        }
        D dB = aVarI.b();
        this.f23910e = aVar;
        this.f23911f = this.f23906a.b(dB);
        this.f23911f.m(this);
    }

    @Override // C4.InterfaceC0276f
    public void f(InterfaceC0275e interfaceC0275e, F f5) {
        this.f23909d = f5.a();
        if (!f5.w()) {
            this.f23910e.c(new C1339e(f5.x(), f5.m()));
            return;
        }
        InputStream inputStreamC = c.c(this.f23909d.c(), ((G) j.d(this.f23909d)).o());
        this.f23908c = inputStreamC;
        this.f23910e.f(inputStreamC);
    }
}
