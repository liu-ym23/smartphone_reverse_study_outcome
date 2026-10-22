package ad;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.lifecycle.l0;
import androidx.work.impl.WorkDatabase;
import com.stepos.agentsafetycenter.R;
import g9.l1;
import g9.w0;
import g9.z0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k0.k1;
import m.d2;
import m.l2;
import u.u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z implements u0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f636a;

    /* renamed from: b, reason: collision with root package name */
    public Object f637b;

    /* renamed from: c, reason: collision with root package name */
    public Object f638c;

    /* renamed from: d, reason: collision with root package name */
    public Object f639d;

    /* renamed from: e, reason: collision with root package name */
    public Object f640e;

    /* renamed from: f, reason: collision with root package name */
    public Object f641f;

    /* renamed from: g, reason: collision with root package name */
    public Object f642g;

    public z(Context context, g5.a aVar, p5.i iVar, h5.d dVar, WorkDatabase workDatabase, p5.p pVar, ArrayList arrayList) {
        this.f636a = 2;
        context.getClass();
        this.f637b = aVar;
        this.f638c = iVar;
        this.f639d = workDatabase;
        this.f640e = pVar;
        this.f641f = arrayList;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.f642g = applicationContext;
        new n6.a();
    }

    public static boolean f(int[] iArr, int i) {
        for (int i3 : iArr) {
            if (i3 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList i(int i, Context context) {
        int iC = l2.c(R.attr.colorControlHighlight, context);
        int iB = l2.b(R.attr.colorButtonNormal, context);
        int[] iArr = l2.f7990b;
        int[] iArr2 = l2.f7992d;
        int iB2 = f3.a.b(iC, i);
        return new ColorStateList(new int[][]{iArr, iArr2, l2.f7991c, l2.f7994f}, new int[]{iB, iB2, f3.a.b(iC, i), i});
    }

    public static LayerDrawable l(d2 d2Var, Context context, int i) throws Resources.NotFoundException {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableD = d2Var.d(R.drawable.abc_star_black_48dp, context);
        Drawable drawableD2 = d2Var.d(R.drawable.abc_star_half_black_48dp, context);
        if ((drawableD instanceof BitmapDrawable) && drawableD.getIntrinsicWidth() == dimensionPixelSize && drawableD.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableD;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableD.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableD.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableD2 instanceof BitmapDrawable) && drawableD2.getIntrinsicWidth() == dimensionPixelSize && drawableD2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableD2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableD2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableD2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void t(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterF;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = m.s.f8060b;
        }
        PorterDuff.Mode mode2 = m.s.f8060b;
        synchronized (m.s.class) {
            porterDuffColorFilterF = d2.f(i, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterF);
    }

    @Override // u.u0
    public boolean a() {
        return ((Boolean) ((k1) this.f640e).getValue()).booleanValue();
    }

    @Override // u.u0
    public Object c(t.u0 u0Var, xb.p pVar, pb.c cVar) {
        Object objF = kc.w.f(new l0(this, u0Var, pVar, null, 21), cVar);
        return objF == ob.a.f9351c ? objF : jb.v.f6774a;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [xb.l, yb.l] */
    @Override // u.u0
    public float e(float f5) {
        return ((Number) ((yb.l) this.f637b).invoke(Float.valueOf(f5))).floatValue();
    }

    public h5.d0 g() {
        h5.d0 d0Var = new h5.d0();
        p5.p pVar = (p5.p) this.f640e;
        d0Var.f5325a = pVar;
        d0Var.f5326b = (Context) this.f642g;
        String str = pVar.f9764a;
        d0Var.f5327c = str;
        d0Var.f5328d = (p5.i) this.f638c;
        g5.a aVar = (g5.a) this.f637b;
        d0Var.f5329e = aVar;
        d0Var.f5330f = aVar.f4271d;
        WorkDatabase workDatabase = (WorkDatabase) this.f639d;
        d0Var.f5331g = workDatabase;
        d0Var.f5332h = workDatabase.C();
        d0Var.i = workDatabase.x();
        ArrayList arrayList = (ArrayList) this.f641f;
        d0Var.f5333j = arrayList;
        d0Var.f5334k = androidx.activity.b.n(androidx.activity.b.o("Work [ id=", str, ", tags={ "), kb.l.B0(arrayList, ",", null, null, null, 62), " } ]");
        d0Var.f5335l = kc.w.b();
        VarHandle.storeStoreFence();
        return d0Var;
    }

    public c h() {
        c cVar = (c) this.f642g;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = c.f439n;
        c cVarN = a.a.N((n) this.f639d);
        this.f642g = cVarN;
        return cVarN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d9, code lost:
    
        if (r9 == r2) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[Catch: all -> 0x00a8, TryCatch #3 {all -> 0x00a8, blocks: (B:31:0x009a, B:33:0x00a0, B:36:0x00ab), top: B:106:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #3 {all -> 0x00a8, blocks: (B:31:0x009a, B:33:0x00a0, B:36:0x00ab), top: B:106:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2 A[Catch: all -> 0x0077, TRY_ENTER, TryCatch #2 {all -> 0x0077, blocks: (B:53:0x011f, B:21:0x0072, B:47:0x00f5, B:50:0x0119, B:44:0x00e2), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119 A[Catch: all -> 0x0077, TryCatch #2 {all -> 0x0077, blocks: (B:53:0x011f, B:21:0x0072, B:47:0x00f5, B:50:0x0119, B:44:0x00e2), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011f A[Catch: all -> 0x0077, PHI: r3 r4 r9
      0x011f: PHI (r3v12 ??) = (r3v10 ??), (r3v14 ??) binds: [B:51:0x011b, B:17:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x011f: PHI (r4v10 ??) = (r4v7 ??), (r4v14 ??) binds: [B:51:0x011b, B:17:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x011f: PHI (r9v25 g9.p) = (r9v24 g9.p), (r9v27 g9.p) binds: [B:51:0x011b, B:17:0x0064] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x0077, blocks: (B:53:0x011f, B:21:0x0072, B:47:0x00f5, B:50:0x0119, B:44:0x00e2), top: B:104:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0140 A[Catch: all -> 0x0143, TRY_LEAVE, TryCatch #0 {all -> 0x0143, blocks: (B:58:0x013a, B:60:0x0140), top: B:100:0x013a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0172 A[Catch: all -> 0x0175, TRY_LEAVE, TryCatch #1 {all -> 0x0175, blocks: (B:73:0x016c, B:75:0x0172), top: B:102:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object, kc.e1] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, kc.e1] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(pb.c r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.z.j(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r12, boolean r13, pb.c r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.z.k(java.lang.String, boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(boolean r11, pb.c r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof g9.g
            if (r0 == 0) goto L13
            r0 = r12
            g9.g r0 = (g9.g) r0
            int r1 = r0.f4458g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4458g = r1
            goto L18
        L13:
            g9.g r0 = new g9.g
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f4456c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f4458g
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            id.c.I(r12)     // Catch: java.lang.Throwable -> L81
            goto L3a
        L27:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L2e:
            id.c.I(r12)
            r0.f4458g = r3     // Catch: java.lang.Throwable -> L81
            java.lang.Object r12 = r10.r(r11, r0)     // Catch: java.lang.Throwable -> L81
            if (r12 != r1) goto L3a
            return r1
        L3a:
            g9.d r12 = (g9.d) r12     // Catch: java.lang.Throwable -> L81
            boolean r10 = r12 instanceof g9.b     // Catch: java.lang.Throwable -> L81
            if (r10 == 0) goto L56
            g9.j r0 = new g9.j     // Catch: java.lang.Throwable -> L81
            r10 = r12
            g9.b r10 = (g9.b) r10     // Catch: java.lang.Throwable -> L81
            int r1 = r10.f4406a     // Catch: java.lang.Throwable -> L81
            g9.b r12 = (g9.b) r12     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = r12.f4407b     // Catch: java.lang.Throwable -> L81
            r7 = 0
            r8 = 124(0x7c, float:1.74E-43)
            r3 = 0
            r5 = 0
            r6 = 0
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L81
            goto L87
        L56:
            boolean r10 = r12 instanceof g9.c     // Catch: java.lang.Throwable -> L81
            if (r10 == 0) goto L7b
            g9.j r0 = new g9.j     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = ""
            r10 = r12
            g9.c r10 = (g9.c) r10     // Catch: java.lang.Throwable -> L81
            long r3 = r10.f4415b     // Catch: java.lang.Throwable -> L81
            r10 = r12
            g9.c r10 = (g9.c) r10     // Catch: java.lang.Throwable -> L81
            boolean r5 = r10.f4416c     // Catch: java.lang.Throwable -> L81
            r10 = r12
            g9.c r10 = (g9.c) r10     // Catch: java.lang.Throwable -> L81
            boolean r6 = r10.f4417d     // Catch: java.lang.Throwable -> L81
            g9.c r12 = (g9.c) r12     // Catch: java.lang.Throwable -> L81
            g9.p r10 = r12.f4414a     // Catch: java.lang.Throwable -> L81
            java.lang.String r7 = a.a.Z(r10)     // Catch: java.lang.Throwable -> L81
            r8 = 4
            r1 = 0
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L81
            goto L87
        L7b:
            androidx.fragment.app.d r10 = new androidx.fragment.app.d     // Catch: java.lang.Throwable -> L81
            r10.<init>()     // Catch: java.lang.Throwable -> L81
            throw r10     // Catch: java.lang.Throwable -> L81
        L81:
            r0 = move-exception
            r10 = r0
            jb.h r0 = id.c.l(r10)
        L87:
            java.lang.Throwable r10 = jb.i.b(r0)
            if (r10 != 0) goto L8e
            goto La5
        L8e:
            g9.j r1 = new g9.j
            java.lang.String r10 = r10.getMessage()
            if (r10 != 0) goto L98
            java.lang.String r10 = ""
        L98:
            r3 = r10
            r8 = 0
            r9 = 124(0x7c, float:1.74E-43)
            r2 = 6
            r4 = 0
            r6 = 0
            r7 = 0
            r1.<init>(r2, r3, r4, r6, r7, r8, r9)
            r0 = r1
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.z.m(boolean, pb.c):java.lang.Object");
    }

    public ColorStateList n(int i, Context context) {
        if (i == R.drawable.abc_edit_text_material) {
            return id.k.u(R.color.abc_tint_edittext, context);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return id.k.u(R.color.abc_tint_switch_track, context);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return i(l2.c(R.attr.colorButtonNormal, context), context);
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return i(0, context);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return i(l2.c(R.attr.colorAccent, context), context);
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return id.k.u(R.color.abc_tint_spinner, context);
            }
            if (f((int[]) this.f638c, i)) {
                return l2.d(R.attr.colorControlNormal, context);
            }
            if (f((int[]) this.f641f, i)) {
                return id.k.u(R.color.abc_tint_default, context);
            }
            if (f((int[]) this.f642g, i)) {
                return id.k.u(R.color.abc_tint_btn_checkable, context);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return id.k.u(R.color.abc_tint_seek_thumb, context);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = l2.d(R.attr.colorSwitchThumbNormal, context);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = l2.f7990b;
            iArr2[0] = l2.b(R.attr.colorSwitchThumbNormal, context);
            iArr[1] = l2.f7993e;
            iArr2[1] = l2.c(R.attr.colorControlActivated, context);
            iArr[2] = l2.f7994f;
            iArr2[2] = l2.c(R.attr.colorSwitchThumbNormal, context);
        } else {
            int[] iArr3 = l2.f7990b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = l2.f7993e;
            iArr2[1] = l2.c(R.attr.colorControlActivated, context);
            iArr[2] = l2.f7994f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void o(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b8.x xVar = (b8.x) it.next();
            ((HashMap) this.f640e).put(xVar.getValue(), xVar);
        }
    }

    public y p() {
        y yVar = new y();
        yVar.f635e = new LinkedHashMap();
        yVar.f631a = (q) this.f637b;
        yVar.f632b = (String) this.f638c;
        yVar.f634d = (c0) this.f640e;
        Map map = (Map) this.f641f;
        yVar.f635e = map.isEmpty() ? new LinkedHashMap() : new LinkedHashMap(map);
        yVar.f633c = ((n) this.f639d).c();
        return yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r8 == r3) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(pb.c r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f637b
            p5.c r0 = (p5.c) r0
            java.lang.Object r1 = r0.f9717f
            g9.g0 r1 = (g9.g0) r1
            boolean r2 = r8 instanceof g9.h
            if (r2 == 0) goto L1b
            r2 = r8
            g9.h r2 = (g9.h) r2
            int r3 = r2.f4470h
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L1b
            int r3 = r3 - r4
            r2.f4470h = r3
            goto L20
        L1b:
            g9.h r2 = new g9.h
            r2.<init>(r7, r8)
        L20:
            java.lang.Object r8 = r2.f4468f
            ob.a r3 = ob.a.f9351c
            int r4 = r2.f4470h
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L3f
            if (r4 == r6) goto L3b
            if (r4 != r5) goto L34
            g9.p r0 = r2.f4467c
            id.c.I(r8)
            goto L63
        L34:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L3b:
            id.c.I(r8)
            goto L55
        L3f:
            id.c.I(r8)
            r2.f4470h = r6
            java.lang.Object r8 = r0.f9718g
            g9.k r8 = (g9.k) r8
            java.lang.Object r8 = r8.invoke()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r1.b(r8, r2)
            if (r8 != r3) goto L55
            goto L62
        L55:
            r0 = r8
            g9.p r0 = (g9.p) r0
            r2.f4467c = r0
            r2.f4470h = r5
            java.lang.Object r8 = r1.a(r2)
            if (r8 != r3) goto L63
        L62:
            return r3
        L63:
            java.lang.Number r8 = (java.lang.Number) r8
            long r1 = r8.longValue()
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L7f
            java.lang.Object r7 = r7.f640e
            xb.a r7 = (xb.a) r7
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            long r3 = r7.longValue()
            long r3 = r3 - r1
            goto L84
        L7f:
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L84:
            if (r0 == 0) goto L90
            if (r8 <= 0) goto L90
            r7 = 300000(0x493e0, double:1.482197E-318)
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 > 0) goto L90
            goto L91
        L90:
            r6 = 0
        L91:
            g9.a r7 = new g9.a
            r7.<init>()
            r7.f4395a = r0
            r7.f4396b = r1
            r7.f4397c = r6
            java.lang.invoke.VarHandle.storeStoreFence()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.z.q(pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
    
        if (r14 != r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(boolean r13, pb.c r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.z.r(boolean, pb.c):java.lang.Object");
    }

    public g9.d s(String str) {
        Object obj;
        Object obj2;
        List list = g9.t.f4612c;
        list.getClass();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj3 : list) {
            int i3 = i + 1;
            if (i < 0) {
                ac.a.a0();
                throw null;
            }
            List list2 = ((l1) obj3).f4524b;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj4 : list2) {
                if (((w0) obj4).i) {
                    arrayList2.add(obj4);
                }
            }
            int i10 = 10;
            ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList2, 10));
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj5 = arrayList2.get(i11);
                i11++;
                w0 w0Var = (w0) obj5;
                int iOrdinal = w0Var.f4644h.ordinal();
                String str2 = "ask_always";
                if (iOrdinal == 0) {
                    obj = "ask_always";
                    str2 = "allow";
                } else if (iOrdinal == 1) {
                    obj = "ask_always";
                    str2 = "ask_on_sensitive";
                } else if (iOrdinal == 2) {
                    obj = "ask_always";
                } else {
                    if (iOrdinal != 3) {
                        g5.f.a();
                        return null;
                    }
                    obj = "ask_always";
                    str2 = "off";
                }
                String str3 = w0Var.f4638b;
                List<z0> list3 = w0Var.f4643g;
                ArrayList arrayList4 = new ArrayList(kb.m.m0(list3, i10));
                for (z0 z0Var : list3) {
                    z0Var.getClass();
                    int iOrdinal2 = z0Var.ordinal();
                    if (iOrdinal2 == 0) {
                        obj2 = "allow";
                    } else if (iOrdinal2 == 1) {
                        obj2 = "ask_on_sensitive";
                    } else if (iOrdinal2 == 2) {
                        obj2 = obj;
                    } else {
                        if (iOrdinal2 != 3) {
                            g5.f.a();
                            return null;
                        }
                        obj2 = "off";
                    }
                    arrayList4.add(obj2);
                }
                arrayList3.add(new g9.o(str3, "", "", arrayList4, str2, str2, false));
                i10 = 10;
            }
            g9.n nVar = arrayList3.isEmpty() ? null : new g9.n(k0.a.j(i, "catalog_"), "", arrayList3);
            if (nVar != null) {
                arrayList.add(nVar);
            }
            i = i3;
        }
        g9.p pVar = new g9.p();
        pVar.f4572a = arrayList;
        return new g9.c(pVar, 0L, true, true);
    }

    public String toString() {
        switch (this.f636a) {
            case 0:
                Map map = (Map) this.f641f;
                StringBuilder sb2 = new StringBuilder("Request{method=");
                sb2.append((String) this.f638c);
                sb2.append(", url=");
                sb2.append((q) this.f637b);
                n nVar = (n) this.f639d;
                if (nVar.size() != 0) {
                    sb2.append(", headers=[");
                    Iterator it = nVar.iterator();
                    int i = 0;
                    while (true) {
                        kb.b bVar = (kb.b) it;
                        if (bVar.hasNext()) {
                            Object next = bVar.next();
                            int i3 = i + 1;
                            if (i < 0) {
                                ac.a.a0();
                                throw null;
                            }
                            jb.g gVar = (jb.g) next;
                            String str = (String) gVar.f6759c;
                            String str2 = (String) gVar.f6760f;
                            if (i > 0) {
                                sb2.append(", ");
                            }
                            sb2.append(str);
                            sb2.append(':');
                            sb2.append(str2);
                            i = i3;
                        } else {
                            sb2.append(']');
                        }
                    }
                }
                if (!map.isEmpty()) {
                    sb2.append(", tags=");
                    sb2.append(map);
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ z(int i) {
        this.f636a = i;
    }
}
