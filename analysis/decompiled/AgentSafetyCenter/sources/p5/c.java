package p5;

import ad.e0;
import ad.z;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.room.a0;
import androidx.room.x;
import androidx.work.impl.WorkDatabase_Impl;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n3.k0;
import n3.o0;
import t.c1;
import u1.c0;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements n3.s, x4.b, h5.k, se.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9716c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9717f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9718g;

    public c(androidx.room.q qVar, x4.b bVar) {
        this.f9716c = 2;
        bVar.getClass();
        this.f9718g = qVar;
        this.f9717f = bVar;
    }

    public static String g(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static void i(g0 g0Var) {
        if (g0Var.R > 0) {
            if (g0Var.I.f13846d == c0.i && !g0Var.p() && !g0Var.q() && !g0Var.S && g0Var.H()) {
                w0.l lVar = g0Var.H.f13746f;
                if ((lVar.f15117h & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0) {
                    while (lVar != null) {
                        if ((lVar.f15116g & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0) {
                            u1.m mVarE = lVar;
                            ?? eVar = 0;
                            while (mVarE != 0) {
                                if (mVarE instanceof u1.o) {
                                    u1.o oVar = (u1.o) mVarE;
                                    oVar.z(u1.f.s(oVar, ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH));
                                } else if ((mVarE.f15116g & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 && (mVarE instanceof u1.m)) {
                                    w0.l lVar2 = mVarE.f13866t;
                                    int i = 0;
                                    mVarE = mVarE;
                                    eVar = eVar;
                                    while (lVar2 != null) {
                                        if ((lVar2.f15116g & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0) {
                                            i++;
                                            eVar = eVar;
                                            if (i == 1) {
                                                mVarE = lVar2;
                                            } else {
                                                if (eVar == 0) {
                                                    eVar = new m0.e(new w0.l[16]);
                                                }
                                                if (mVarE != 0) {
                                                    eVar.b(mVarE);
                                                    mVarE = 0;
                                                }
                                                eVar.b(lVar2);
                                            }
                                        }
                                        lVar2 = lVar2.f15118j;
                                        mVarE = mVarE;
                                        eVar = eVar;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                mVarE = u1.f.e(eVar);
                            }
                        }
                        if ((lVar.f15117h & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) == 0) {
                            break;
                        } else {
                            lVar = lVar.f15118j;
                        }
                    }
                }
            }
            g0Var.Q = false;
            m0.e eVarX = g0Var.x();
            Object[] objArr = eVarX.f8158c;
            int i3 = eVarX.f8160g;
            for (int i10 = 0; i10 < i3; i10++) {
                i((g0) objArr[i10]);
            }
        }
    }

    @Override // se.a
    public boolean b(se.b bVar, Menu menu) {
        return ((se.a) this.f9717f).b(bVar, menu);
    }

    @Override // se.a
    public boolean c(se.b bVar, Menu menu) {
        return ((se.a) this.f9717f).c(bVar, menu);
    }

    @Override // se.a
    public boolean d(se.b bVar, MenuItem menuItem) {
        return ((se.a) this.f9717f).d(bVar, menuItem);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, stepos.support.v7.app.k] */
    @Override // se.a
    public void e(se.b bVar) {
        ((se.a) this.f9717f).e(bVar);
        stepos.support.v7.app.o oVar = (stepos.support.v7.app.o) this.f9718g;
        if (oVar.f12407z != null) {
            oVar.f12388f.getDecorView().removeCallbacks(oVar.A);
        }
        if (oVar.f12406y != null) {
            oVar.p();
            o0 o0VarA = k0.a(oVar.f12406y);
            o0VarA.a(0.0f);
            oVar.B = o0VarA;
            h.u uVar = new h.u(5);
            uVar.f4896h = this;
            VarHandle.storeStoreFence();
            o0VarA.e(uVar);
        }
        ?? r32 = oVar.i;
        if (r32 != 0) {
            r32.onSupportActionModeFinished(oVar.f12405x);
        }
        oVar.f12405x = null;
    }

    public boolean f() {
        synchronized (this) {
            if (((AtomicBoolean) this.f9718g).get()) {
                return false;
            }
            ((AtomicInteger) this.f9717f).incrementAndGet();
            return true;
        }
    }

    public boolean h(j jVar) {
        boolean zContainsKey;
        synchronized (this.f9718g) {
            zContainsKey = ((e6.n) this.f9717f).f3587c.containsKey(jVar);
        }
        return zContainsKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #4 {all -> 0x00d7, blocks: (B:32:0x007d, B:34:0x0081, B:37:0x0092, B:41:0x0099, B:43:0x00a3, B:45:0x00ae, B:44:0x00a9, B:39:0x0096, B:40:0x0098, B:57:0x00cf, B:58:0x00d6, B:36:0x008d), top: B:88:0x007d, outer: #6, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cf A[Catch: all -> 0x00d7, TRY_ENTER, TryCatch #4 {all -> 0x00d7, blocks: (B:32:0x007d, B:34:0x0081, B:37:0x0092, B:41:0x0099, B:43:0x00a3, B:45:0x00ae, B:44:0x00a9, B:39:0x0096, B:40:0x0098, B:57:0x00cf, B:58:0x00d6, B:36:0x008d), top: B:88:0x007d, outer: #6, inners: #1 }] */
    @Override // x4.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x4.a j(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.c.j(java.lang.String):x4.a");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o7.o k(t7.a r8, boolean r9) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.c.k(t7.a, boolean):o7.o");
    }

    public ArrayList l(String str) {
        x xVarD = x.d(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        xVarD.h(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f9717f;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                arrayList.add(cursorD.getString(0));
            }
            return arrayList;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public AutofillId m(long j10) {
        return ((ContentCaptureSession) this.f9717f).newAutofillId((AutofillId) c1.h((View) this.f9718g).f12170f, j10);
    }

    public void n(xb.l lVar) {
        ((z9.e) this.f9717f).a(lVar);
        View view = (View) ((WeakReference) this.f9718g).get();
        if (view == null) {
            return;
        }
        z9.f fVar = z9.f.f16523a;
        z9.e eVar = (z9.e) this.f9717f;
        synchronized (fVar) {
            try {
                int i = eVar.f16518b - 1;
                eVar.f16518b = i;
                if (i <= 0) {
                    if (view.isAttachedToWindow()) {
                        a0 a0Var = new a0(11);
                        a0Var.f1506f = eVar;
                        a0Var.f1507g = view;
                        VarHandle.storeStoreFence();
                        view.post(a0Var);
                    } else {
                        eVar.d();
                        z9.f.f16527e.remove(view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public h5.j o(j jVar) {
        h5.j jVarB;
        jVar.getClass();
        synchronized (this.f9718g) {
            jVarB = ((e6.n) this.f9717f).b(jVar);
        }
        return jVarB;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    @Override // n3.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n3.m1 p(android.view.View r18, n3.m1 r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r3 = r0.f9717f
            l3.d r3 = (l3.d) r3
            java.lang.Object r0 = r0.f9718g
            a7.c r0 = (a7.c) r0
            int r4 = r0.f228a
            int r5 = r0.f229b
            int r0 = r0.f230c
            n3.j1 r6 = r2.f8737a
            r7 = 519(0x207, float:7.27E-43)
            f3.b r7 = r6.i(r7)
            r8 = 32
            f3.b r6 = r6.i(r8)
            java.lang.Object r8 = r3.f7721f
            com.google.android.material.bottomsheet.BottomSheetBehavior r8 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r8
            int r9 = r7.f3901b
            int r10 = r7.f3902c
            int r11 = r7.f3900a
            r8.f2435w = r9
            int r9 = r1.getLayoutDirection()
            r13 = 1
            if (r9 != r13) goto L37
            r9 = r13
            goto L38
        L37:
            r9 = 0
        L38:
            int r14 = r1.getPaddingBottom()
            int r15 = r1.getPaddingLeft()
            int r16 = r1.getPaddingRight()
            boolean r12 = r8.f2427o
            if (r12 == 0) goto L4f
            int r14 = r2.a()
            r8.f2434v = r14
            int r14 = r14 + r0
        L4f:
            boolean r0 = r8.f2428p
            if (r0 == 0) goto L5a
            if (r9 == 0) goto L57
            r0 = r5
            goto L58
        L57:
            r0 = r4
        L58:
            int r15 = r0 + r11
        L5a:
            boolean r0 = r8.f2429q
            if (r0 == 0) goto L64
            if (r9 == 0) goto L61
            goto L62
        L61:
            r4 = r5
        L62:
            int r16 = r4 + r10
        L64:
            r0 = r16
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            boolean r5 = r8.f2431s
            if (r5 == 0) goto L78
            int r5 = r4.leftMargin
            if (r5 == r11) goto L78
            r4.leftMargin = r11
            r5 = r13
            goto L79
        L78:
            r5 = 0
        L79:
            boolean r9 = r8.f2432t
            if (r9 == 0) goto L84
            int r9 = r4.rightMargin
            if (r9 == r10) goto L84
            r4.rightMargin = r10
            r5 = r13
        L84:
            boolean r9 = r8.f2433u
            if (r9 == 0) goto L91
            int r9 = r4.topMargin
            int r7 = r7.f3901b
            if (r9 == r7) goto L91
            r4.topMargin = r7
            goto L92
        L91:
            r13 = r5
        L92:
            if (r13 == 0) goto L97
            r1.setLayoutParams(r4)
        L97:
            int r4 = r1.getPaddingTop()
            r1.setPadding(r15, r4, r0, r14)
            boolean r0 = r3.f7720c
            if (r0 == 0) goto La6
            int r1 = r6.f3903d
            r8.f2425m = r1
        La6:
            if (r12 != 0) goto Lac
            if (r0 == 0) goto Lab
            goto Lac
        Lab:
            return r2
        Lac:
            r8.t()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.c.p(android.view.View, n3.m1):n3.m1");
    }

    public List q(String str) {
        List listC;
        str.getClass();
        synchronized (this.f9718g) {
            listC = ((e6.n) this.f9717f).c(str);
        }
        return listC;
    }

    public h5.j r(j jVar) {
        h5.j jVarD;
        synchronized (this.f9718g) {
            jVarD = ((e6.n) this.f9717f).d(jVar);
        }
        return jVarD;
    }

    public void s() {
        synchronized (this) {
            ((AtomicInteger) this.f9717f).decrementAndGet();
            if (((AtomicInteger) this.f9717f).get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
        }
    }

    public String toString() {
        switch (this.f9716c) {
            case 9:
                return ((Map) this.f9717f).toString();
            default:
                return super.toString();
        }
    }

    public c(z zVar, e0 e0Var) {
        this.f9716c = 3;
        this.f9717f = zVar;
        this.f9718g = e0Var;
    }

    public /* synthetic */ c(int i) {
        this.f9716c = i;
    }

    public c(stepos.support.v7.app.o oVar, se.a aVar) {
        this.f9716c = 10;
        this.f9718g = oVar;
        this.f9717f = aVar;
    }
}
