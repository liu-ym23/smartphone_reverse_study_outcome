package z8;

import com.stepos.account.oauth.OAuthConstants;
import java.io.IOException;

/* loaded from: classes.dex */
public final class s extends f9.l {

    /* renamed from: l, reason: collision with root package name */
    public static final s f12355l;

    /* renamed from: m, reason: collision with root package name */
    public static final c9.a f12356m = new c9.a(12);

    /* renamed from: g, reason: collision with root package name */
    public final f9.d f12357g;

    /* renamed from: h, reason: collision with root package name */
    public int f12358h;

    /* renamed from: i, reason: collision with root package name */
    public int f12359i;

    /* renamed from: j, reason: collision with root package name */
    public byte f12360j;

    /* renamed from: k, reason: collision with root package name */
    public int f12361k;

    static {
        s sVar = new s();
        f12355l = sVar;
        sVar.f12359i = 0;
    }

    public s(r rVar) {
        super(rVar);
        this.f12360j = (byte) -1;
        this.f12361k = -1;
        this.f12357g = rVar.f3565f;
    }

    @Override // f9.a
    public final int a() {
        int i2 = this.f12361k;
        if (i2 != -1) {
            return i2;
        }
        int size = this.f12357g.size() + h() + ((this.f12358h & 1) == 1 ? f9.f.b(1, this.f12359i) : 0);
        this.f12361k = size;
        return size;
    }

    @Override // f9.a
    public final f9.j b() {
        return new r();
    }

    @Override // f9.a
    public final f9.j c() {
        r rVar = new r();
        rVar.e(this);
        return rVar;
    }

    @Override // f9.a
    public final void d(f9.f fVar) throws IOException {
        a();
        q6.b bVar = new q6.b((f9.l) this);
        if ((this.f12358h & 1) == 1) {
            fVar.m(1, this.f12359i);
        }
        bVar.Q0(OAuthConstants.RESPONSE_CODE_OK, fVar);
        fVar.r(this.f12357g);
    }

    @Override // f9.v
    public final f9.a getDefaultInstanceForType() {
        return f12355l;
    }

    @Override // f9.v
    public final boolean isInitialized() {
        byte b10 = this.f12360j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (g()) {
            this.f12360j = (byte) 1;
            return true;
        }
        this.f12360j = (byte) 0;
        return false;
    }

    public s() {
        this.f12360j = (byte) -1;
        this.f12361k = -1;
        this.f12357g = f9.d.f3536f;
    }

    public s(f9.e eVar, f9.h hVar) {
        this.f12360j = (byte) -1;
        this.f12361k = -1;
        boolean z4 = false;
        this.f12359i = 0;
        f9.c cVar = new f9.c();
        f9.f fVarJ = f9.f.j(cVar, 1);
        while (!z4) {
            try {
                try {
                    int iN = eVar.n();
                    if (iN != 0) {
                        if (iN != 8) {
                            if (!l(eVar, fVarJ, hVar, iN)) {
                            }
                        } else {
                            this.f12358h |= 1;
                            this.f12359i = eVar.k();
                        }
                    }
                    z4 = true;
                } catch (f9.r e10) {
                    e10.f3597f = this;
                    throw e10;
                } catch (IOException e11) {
                    f9.r rVar = new f9.r(e11.getMessage());
                    rVar.f3597f = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                try {
                    fVarJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f12357g = cVar.d();
                    throw th2;
                }
                this.f12357g = cVar.d();
                k();
                throw th;
            }
        }
        try {
            fVarJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f12357g = cVar.d();
            throw th3;
        }
        this.f12357g = cVar.d();
        k();
    }
}
