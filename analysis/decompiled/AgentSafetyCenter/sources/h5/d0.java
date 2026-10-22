package h5;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import kc.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public p5.p f5325a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5326b;

    /* renamed from: c, reason: collision with root package name */
    public String f5327c;

    /* renamed from: d, reason: collision with root package name */
    public p5.i f5328d;

    /* renamed from: e, reason: collision with root package name */
    public g5.a f5329e;

    /* renamed from: f, reason: collision with root package name */
    public g5.j f5330f;

    /* renamed from: g, reason: collision with root package name */
    public WorkDatabase f5331g;

    /* renamed from: h, reason: collision with root package name */
    public p5.s f5332h;
    public p5.c i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f5333j;

    /* renamed from: k, reason: collision with root package name */
    public String f5334k;

    /* renamed from: l, reason: collision with root package name */
    public z0 f5335l;

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(h5.d0 r16, pb.c r17) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.d0.a(h5.d0, pb.c):java.lang.Object");
    }

    public final void b(int i) {
        p5.s sVar = this.f5332h;
        String str = this.f5327c;
        sVar.p(1, str);
        this.f5330f.getClass();
        sVar.n(str, System.currentTimeMillis());
        sVar.m(this.f5325a.f9784v, str);
        sVar.l(str, -1L);
        sVar.q(i, str);
    }

    public final void c() {
        p5.s sVar = this.f5332h;
        String str = this.f5327c;
        this.f5330f.getClass();
        sVar.n(str, System.currentTimeMillis());
        sVar.p(1, str);
        WorkDatabase_Impl workDatabase_Impl = sVar.f9791a;
        workDatabase_Impl.b();
        p5.h hVar = sVar.f9799j;
        z4.j jVarA = hVar.a();
        jVarA.h(1, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
                hVar.c(jVarA);
                sVar.m(this.f5325a.f9784v, str);
                workDatabase_Impl.b();
                p5.h hVar2 = sVar.f9796f;
                z4.j jVarA2 = hVar2.a();
                jVarA2.h(1, str);
                try {
                    workDatabase_Impl.c();
                    try {
                        jVarA2.d();
                        workDatabase_Impl.v();
                        hVar2.c(jVarA2);
                        sVar.l(str, -1L);
                    } finally {
                    }
                } catch (Throwable th) {
                    hVar2.c(jVarA2);
                    throw th;
                }
            } finally {
            }
        } catch (Throwable th2) {
            hVar.c(jVarA);
            throw th2;
        }
    }

    public final void d(g5.s sVar) {
        sVar.getClass();
        String str = this.f5327c;
        p5.s sVar2 = this.f5332h;
        ArrayList arrayListI = ac.a.I(str);
        while (!arrayListI.isEmpty()) {
            String str2 = (String) kb.q.q0(arrayListI);
            if (sVar2.i(str2) != 6) {
                sVar2.p(4, str2);
            }
            arrayListI.addAll(this.i.l(str2));
        }
        g5.h hVar = ((g5.p) sVar).f4336a;
        hVar.getClass();
        sVar2.m(this.f5325a.f9784v, str);
        sVar2.o(str, hVar);
    }
}
