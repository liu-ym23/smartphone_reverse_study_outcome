package f3;

import a4.u;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.concurrent.Executor;
import n7.o;

/* loaded from: classes.dex */
public final class b implements va.c, va.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3361a;

    /* renamed from: b, reason: collision with root package name */
    public String f3362b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3363c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3364d;

    /* renamed from: e, reason: collision with root package name */
    public final Serializable f3365e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3366f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3367g;

    /* renamed from: h, reason: collision with root package name */
    public Serializable f3368h;

    public b(a7.c cVar, xa.c cVar2, ya.i iVar, b[] bVarArr) {
        q7.k.e(cVar, "composer");
        this.f3363c = cVar;
        this.f3364d = cVar2;
        this.f3365e = iVar;
        this.f3366f = bVarArr;
        this.f3367g = cVar2.f11332a;
        int iOrdinal = iVar.ordinal();
        if (bVarArr != null) {
            b bVar = bVarArr[iOrdinal];
            if (bVar == null && bVar == this) {
                return;
            }
            bVarArr[iOrdinal] = this;
        }
    }

    @Override // va.c
    public va.a a(ua.d dVar) {
        b bVar;
        b[] bVarArr = (b[]) this.f3366f;
        q7.k.e(dVar, "descriptor");
        xa.c cVar = (xa.c) this.f3364d;
        ya.i iVarH = ya.f.h(dVar, cVar);
        char c10 = iVarH.f11746f;
        a7.c cVar2 = (a7.c) this.f3363c;
        cVar2.b(c10);
        cVar2.f408b = true;
        String str = this.f3362b;
        if (str != null) {
            String strB = (String) this.f3368h;
            if (strB == null) {
                strB = dVar.b();
            }
            cVar2.a();
            i(str);
            cVar2.b(':');
            i(strB);
            this.f3362b = null;
            this.f3368h = null;
        }
        return ((ya.i) this.f3365e) == iVarH ? this : (bVarArr == null || (bVar = bVarArr[iVarH.ordinal()]) == null) ? new b(cVar2, cVar, iVarH, bVarArr) : bVar;
    }

    @Override // va.a
    public void b(ua.d dVar, int i2, sa.a aVar, Object obj) {
        q7.k.e(dVar, "descriptor");
        if (obj != null || ((xa.f) this.f3367g).f11341d) {
            q7.k.e(dVar, "descriptor");
            j(dVar, i2);
            if (aVar.a().g()) {
                h(aVar, obj);
            } else if (obj == null) {
                c();
            } else {
                h(aVar, obj);
            }
        }
    }

    @Override // va.c
    public void c() {
        a7.c cVar = (a7.c) this.f3363c;
        cVar.getClass();
        q7.k.e("null", "v");
        ((d1.b) cVar.f409c).j("null");
    }

    @Override // va.a
    public void d(ua.d dVar) {
        q7.k.e(dVar, "descriptor");
        ya.i iVar = (ya.i) this.f3365e;
        a7.c cVar = (a7.c) this.f3363c;
        cVar.getClass();
        cVar.f408b = false;
        cVar.b(iVar.f11747g);
    }

    @Override // va.c
    public void e(int i2) {
        if (this.f3361a) {
            i(String.valueOf(i2));
        } else {
            ((d1.b) ((a7.c) this.f3363c).f409c).j(String.valueOf(i2));
        }
    }

    @Override // va.a
    public boolean f(ua.d dVar) {
        q7.k.e(dVar, "descriptor");
        return ((xa.f) this.f3367g).f11338a;
    }

    @Override // va.c
    public void g(long j2) {
        if (this.f3361a) {
            i(String.valueOf(j2));
        } else {
            ((d1.b) ((a7.c) this.f3363c).f409c).j(String.valueOf(j2));
        }
    }

    @Override // va.c
    public void h(sa.a aVar, Object obj) {
        String strDiscriminator;
        q7.k.e(aVar, "serializer");
        xa.f fVar = ((xa.c) this.f3364d).f11332a;
        int iOrdinal = fVar.f11345h.ordinal();
        if (iOrdinal == 0) {
            strDiscriminator = null;
        } else {
            if (iOrdinal == 1) {
                o kind = aVar.a().getKind();
                if (q7.k.a(kind, ua.f.f10216b) || q7.k.a(kind, ua.f.f10219e)) {
                    ua.d dVarA = aVar.a();
                    q7.k.e(dVarA, "<this>");
                    Iterator it = dVarA.getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strDiscriminator = fVar.f11343f;
                            break;
                        }
                        Annotation annotation = (Annotation) it.next();
                        if (annotation instanceof xa.e) {
                            strDiscriminator = ((xa.e) annotation).discriminator();
                            break;
                        }
                    }
                }
            } else if (iOrdinal != 2) {
                throw new u();
            }
            strDiscriminator = null;
        }
        if (strDiscriminator != null) {
            String strB = aVar.a().b();
            this.f3362b = strDiscriminator;
            this.f3368h = strB;
        }
        aVar.serialize(this, obj);
    }

    @Override // va.c
    public void i(String str) {
        byte b10;
        q7.k.e(str, "value");
        a7.c cVar = (a7.c) this.f3363c;
        cVar.getClass();
        q7.k.e(str, "value");
        d1.b bVar = (d1.b) cVar.f409c;
        bVar.f(bVar.f2767g, str.length() + 2);
        char[] cArr = (char[]) bVar.f2768h;
        int i2 = bVar.f2767g;
        int i10 = i2 + 1;
        cArr[i2] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i10);
        int i11 = length + i10;
        int i12 = i10;
        while (i12 < i11) {
            char c10 = cArr[i12];
            byte[] bArr = ya.h.f11739b;
            if (c10 < bArr.length && bArr[c10] != 0) {
                int length2 = str.length();
                for (int i13 = i12 - i10; i13 < length2; i13++) {
                    bVar.f(i12, 2);
                    char cCharAt = str.charAt(i13);
                    byte[] bArr2 = ya.h.f11739b;
                    if (cCharAt >= bArr2.length || (b10 = bArr2[cCharAt]) == 0) {
                        int i14 = i12 + 1;
                        ((char[]) bVar.f2768h)[i12] = cCharAt;
                        i12 = i14;
                    } else {
                        if (b10 == 1) {
                            String str2 = ya.h.f11738a[cCharAt];
                            q7.k.b(str2);
                            bVar.f(i12, str2.length());
                            str2.getChars(0, str2.length(), (char[]) bVar.f2768h, i12);
                            int length3 = str2.length() + i12;
                            bVar.f2767g = length3;
                            i12 = length3;
                        } else {
                            char[] cArr2 = (char[]) bVar.f2768h;
                            cArr2[i12] = '\\';
                            cArr2[i12 + 1] = (char) b10;
                            i12 += 2;
                            bVar.f2767g = i12;
                        }
                    }
                }
                bVar.f(i12, 1);
                ((char[]) bVar.f2768h)[i12] = '\"';
                bVar.f2767g = i12 + 1;
                return;
            }
            i12++;
        }
        cArr[i11] = '\"';
        bVar.f2767g = i11 + 1;
    }

    public void j(ua.d dVar, int i2) {
        a7.c cVar = (a7.c) this.f3363c;
        q7.k.e(dVar, "descriptor");
        int iOrdinal = ((ya.i) this.f3365e).ordinal();
        boolean z4 = true;
        if (iOrdinal == 1) {
            if (!cVar.f408b) {
                cVar.b(',');
            }
            cVar.a();
            return;
        }
        if (iOrdinal == 2) {
            if (cVar.f408b) {
                this.f3361a = true;
                cVar.a();
                return;
            }
            if (i2 % 2 == 0) {
                cVar.b(',');
                cVar.a();
            } else {
                cVar.b(':');
                cVar.c();
                z4 = false;
            }
            this.f3361a = z4;
            return;
        }
        if (iOrdinal != 3) {
            if (!cVar.f408b) {
                cVar.b(',');
            }
            cVar.a();
            ya.f.g(dVar, (xa.c) this.f3364d);
            i(dVar.d(i2));
            cVar.b(':');
            cVar.c();
            return;
        }
        if (i2 == 0) {
            this.f3361a = true;
        }
        if (i2 == 1) {
            cVar.b(',');
            cVar.c();
            this.f3361a = false;
        }
    }

    public void k(ua.d dVar, int i2, String str) {
        q7.k.e(dVar, "descriptor");
        q7.k.e(str, "value");
        j(dVar, i2);
        i(str);
    }

    public FileInputStream l(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((e) this.f3364d).d();
            return null;
        }
    }

    public void m(final int i2, final Serializable serializable) {
        ((Executor) this.f3363c).execute(new Runnable() { // from class: f3.a
            @Override // java.lang.Runnable
            public final void run() {
                ((e) this.f3358f.f3364d).g(i2, serializable);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public b(AssetManager assetManager, Executor executor, e eVar, String str, File file) {
        ?? r12;
        this.f3361a = false;
        this.f3363c = executor;
        this.f3364d = eVar;
        this.f3362b = str;
        this.f3367g = file;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            r12 = f.f3382d;
        } else {
            r12 = i2 != 30 ? 0 : f.f3383e;
        }
        this.f3365e = r12;
    }
}
