package oc;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    public d[] f9362c;

    /* renamed from: f, reason: collision with root package name */
    public int f9363f;

    /* renamed from: g, reason: collision with root package name */
    public int f9364g;

    /* renamed from: h, reason: collision with root package name */
    public z f9365h;

    public final d b() {
        d dVarC;
        z zVar;
        synchronized (this) {
            try {
                d[] dVarArrD = this.f9362c;
                if (dVarArrD == null) {
                    dVarArrD = d();
                    this.f9362c = dVarArrD;
                } else if (this.f9363f >= dVarArrD.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrD, dVarArrD.length * 2);
                    this.f9362c = (d[]) objArrCopyOf;
                    dVarArrD = (d[]) objArrCopyOf;
                }
                int i = this.f9364g;
                do {
                    dVarC = dVarArrD[i];
                    if (dVarC == null) {
                        dVarC = c();
                        dVarArrD[i] = dVarC;
                    }
                    i++;
                    if (i >= dVarArrD.length) {
                        i = 0;
                    }
                } while (!dVarC.a(this));
                this.f9364g = i;
                this.f9363f++;
                zVar = this.f9365h;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zVar != null) {
            zVar.u(1);
        }
        return dVarC;
    }

    public abstract d c();

    public abstract d[] d();

    public final void e(d dVar) {
        z zVar;
        int i;
        nb.c[] cVarArrB;
        synchronized (this) {
            try {
                int i3 = this.f9363f - 1;
                this.f9363f = i3;
                zVar = this.f9365h;
                if (i3 == 0) {
                    this.f9364g = 0;
                }
                dVar.getClass();
                cVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (nb.c cVar : cVarArrB) {
            if (cVar != null) {
                cVar.resumeWith(jb.v.f6774a);
            }
        }
        if (zVar != null) {
            zVar.u(-1);
        }
    }

    public final z f() {
        z zVar;
        synchronized (this) {
            zVar = this.f9365h;
            if (zVar == null) {
                int i = this.f9363f;
                zVar = new z(1, Reader.READ_DONE, mc.a.f8551f);
                zVar.o(Integer.valueOf(i));
                this.f9365h = zVar;
            }
        }
        return zVar;
    }
}
