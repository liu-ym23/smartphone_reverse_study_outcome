package com.google.android.gms.common.api.internal;

import K.InterfaceC0088u;
import K.S;
import K.z0;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.InterfaceC0176b;
import androidx.core.widget.NestedScrollView;
import ch.qos.logback.classic.spi.CallerData;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.stepos.alphame.utils.Property;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.widget.ScrollTextView;
import com.stepos.common.widget.SimpleAdaptiveTextView;
import com.stepos.renderfilter.functor.DrawGlInfo;
import f1.AbstractC0557a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import s2.C0855a;
import stepos.support.v7.app.AbstractC0870o;
import stepos.support.v7.app.C0864i;
import stepos.support.v7.app.DialogInterfaceC0865j;
import stepos.support.v7.app.InterfaceC0863h;
import t2.InterfaceC0934c;
import w2.C0975b;
import x2.C0981a;

/* loaded from: classes.dex */
public final class p implements InterfaceC0088u, L.r, com.google.android.material.button.a, G1.p, androidx.core.widget.i, m2.n, InterfaceC0934c, t3.d, InterfaceC0863h, InterfaceC0176b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9663a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9664b;

    public /* synthetic */ p(int i4, int i5) {
        this.f9663a = i4;
    }

    @Override // L.r
    public final boolean a(View view) {
        if (!((SwipeDismissBehavior) this.f9664b).c(view)) {
            return false;
        }
        boolean z4 = view.getLayoutDirection() == 1;
        int i4 = ((SwipeDismissBehavior) this.f9664b).f10397d;
        int width = (!(i4 == 0 && z4) && (i4 != 1 || z4)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = S.f939a;
        view.offsetLeftAndRight(width);
        view.setAlpha(Property.DEFAULT_FLOAT_VALUE);
        ((SwipeDismissBehavior) this.f9664b).getClass();
        return true;
    }

    @Override // t2.InterfaceC0934c
    public final void b() {
    }

    @Override // t3.d
    public final void c(long j4) {
        long j5;
        long j6;
        if (j4 > 0) {
            AtomicLong atomicLong = ((y3.i) this.f9664b).f16375l;
            do {
                j5 = atomicLong.get();
                j6 = j5 + j4;
                if (j6 < 0) {
                    j6 = LongCompanionObject.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j5, j6));
            ((y3.i) this.f9664b).k();
        }
    }

    @Override // t2.InterfaceC0934c
    public final void d(DrawGlInfo drawGlInfo) {
        String hexString;
        r2.d dVar = (r2.d) this.f9664b;
        A2.a aVar = dVar.f14083c;
        Rect bounds = dVar.f14082b.getBounds();
        aVar.getClass();
        if (drawGlInfo == null) {
            return;
        }
        drawGlInfo.adjustBounds(bounds);
        if (drawGlInfo.width <= 0 || drawGlInfo.height <= 0 || drawGlInfo.getTransformWidth() <= 0 || drawGlInfo.getTransformHeight() <= 0) {
            return;
        }
        Trace.beginSection("begin");
        int[] iArr = aVar.f69n;
        GLES20.glGetIntegerv(36006, iArr, 0);
        aVar.f59d = iArr[0];
        int[] iArr2 = aVar.f60e;
        GLES20.glGetIntegerv(2978, iArr2, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        GLES30.glBindVertexArray(0);
        aVar.f61f = GLES20.glIsEnabled(3089);
        GLES20.glDisable(3089);
        aVar.f62g = GLES20.glIsEnabled(3042);
        GLES20.glGetIntegerv(32969, iArr, 0);
        aVar.f63h = iArr[0];
        GLES20.glGetIntegerv(32971, iArr, 0);
        aVar.f64i = iArr[0];
        GLES20.glGetIntegerv(32968, iArr, 0);
        aVar.f65j = iArr[0];
        GLES20.glGetIntegerv(32970, iArr, 0);
        aVar.f66k = iArr[0];
        GLES20.glGetIntegerv(32777, iArr, 0);
        aVar.f67l = iArr[0];
        GLES20.glGetIntegerv(34877, iArr, 0);
        aVar.f68m = iArr[0];
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(1, 771, 1, 771);
        GLES20.glBlendEquationSeparate(32774, 32774);
        Trace.endSection();
        u2.c cVarA = aVar.f56a.a(null, drawGlInfo);
        Iterator it = aVar.f57b.iterator();
        while (it.hasNext()) {
            cVarA = ((s2.c) it.next()).a(cVarA, drawGlInfo);
        }
        Trace.beginSection("end");
        GLES20.glBindFramebuffer(36160, aVar.f59d);
        GLES20.glViewport(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        Trace.endSection();
        if (cVarA == null) {
            return;
        }
        drawGlInfo.getTransformWidth();
        drawGlInfo.getTransformHeight();
        Matrix matrix = C0855a.f14227g;
        s2.b bVar = aVar.f58c;
        bVar.getClass();
        Trace.beginSection("DecorFilter");
        bVar.a(cVarA, drawGlInfo);
        Trace.beginSection("decor");
        int i4 = bVar.f14237m;
        int i5 = drawGlInfo.width;
        if (i4 != i5 || bVar.f14238n != drawGlInfo.height) {
            bVar.f14237m = i5;
            int i6 = drawGlInfo.height;
            bVar.f14238n = i6;
            C0981a c0981a = new C0981a(i5, i6);
            bVar.f14231g = c0981a;
            c0981a.f15901a.c(drawGlInfo.width / 2.0f, drawGlInfo.height / 2.0f, 1.0f);
            bVar.f14231g.a(new y2.g(drawGlInfo.width / 2.0f, drawGlInfo.height / 2.0f, Property.DEFAULT_FLOAT_VALUE));
            C0981a c0981a2 = bVar.f14231g;
            c0981a2.f15908h = Property.DEFAULT_FLOAT_VALUE;
            c0981a2.f15909i = 2.0f;
            c0981a2.b();
        }
        GLES20.glUseProgram(bVar.f14230f.f15846k);
        GLES20.glEnable(3089);
        GLES20.glScissor(drawGlInfo.clipLeft, drawGlInfo.height - drawGlInfo.clipBottom, drawGlInfo.getClipWidth(), drawGlInfo.getClipHeight());
        GLES20.glUniformMatrix4fv(bVar.f14230f.b("u_projectionViewMatrix"), 1, false, bVar.f14231g.f15906f.f16337a, 0);
        C2.c cVar = bVar.f14239o;
        android.opengl.Matrix.setIdentityM(cVar.f340a, 0);
        float transformWidth = drawGlInfo.getTransformWidth();
        float transformHeight = drawGlInfo.getTransformHeight();
        float[] fArr = C2.c.f338b;
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, transformWidth, transformHeight, 1.0f);
        float[] fArr2 = cVar.f340a;
        android.opengl.Matrix.multiplyMM(fArr2, 0, fArr, 0, fArr2, 0);
        float f4 = drawGlInfo.mLeft;
        float f5 = drawGlInfo.height - drawGlInfo.mBottom;
        android.opengl.Matrix.setIdentityM(fArr, 0);
        float[] fArr3 = C2.c.f339c;
        android.opengl.Matrix.translateM(fArr3, 0, fArr, 0, f4, f5, Property.DEFAULT_FLOAT_VALUE);
        float[] fArr4 = cVar.f340a;
        android.opengl.Matrix.multiplyMM(fArr4, 0, fArr3, 0, fArr4, 0);
        GLES20.glUniformMatrix4fv(bVar.f14230f.b("u_modelMatrix"), 1, false, cVar.f340a, 0);
        cVarA.b(33648);
        GLES20.glUniform1i(bVar.f14230f.b("u_texture"), 0);
        float[] fArr5 = s2.b.f14229p;
        matrix.getValues(fArr5);
        GLES20.glUniformMatrix3fv(bVar.f14230f.b("u_texture_transform"), 1, true, fArr5, 0);
        GLES20.glUniform1i(bVar.f14230f.b("u_has_corner"), ((double) bVar.f14234j) > 1.0E-4d ? 1 : 0);
        GLES20.glUniform1f(bVar.f14230f.b("u_alpha"), bVar.f14235k / 255.0f);
        GLES20.glUniform1f(bVar.f14230f.b("u_saturation"), bVar.f14236l);
        C0975b c0975b = bVar.f14230f;
        c0975b.getClass();
        GLES20.glUniform4f(c0975b.b("u_colorFilter"), Color.red(bVar.f14233i) / 255.0f, Color.green(bVar.f14233i) / 255.0f, Color.blue(bVar.f14233i) / 255.0f, Color.alpha(bVar.f14233i) / 255.0f);
        GLES20.glUniform2f(bVar.f14230f.b("u_crop_center"), drawGlInfo.getTransformWidth() / 2.0f, drawGlInfo.getTransformHeight() / 2.0f);
        GLES20.glUniform2f(bVar.f14230f.b("u_left_top"), drawGlInfo.mLeft, drawGlInfo.height - drawGlInfo.mBottom);
        GLES20.glUniform1f(bVar.f14230f.b("u_corner_radius"), Math.min(Math.min(drawGlInfo.getTransformWidth(), drawGlInfo.getTransformHeight()) / 2.0f, bVar.f14234j));
        bVar.f14232h.a(bVar.f14230f);
        bVar.f14230f.getClass();
        GLES20.glDisable(3089);
        Trace.endSection();
        Trace.endSection();
        Trace.beginSection("restore");
        if (aVar.f61f) {
            GLES20.glEnable(3089);
        } else {
            GLES20.glDisable(3089);
        }
        if (aVar.f62g) {
            GLES20.glEnable(3042);
        } else {
            GLES20.glDisable(3042);
        }
        GLES20.glBlendFuncSeparate(aVar.f63h, aVar.f65j, aVar.f64i, aVar.f66k);
        GLES20.glBlendEquationSeparate(aVar.f67l, aVar.f68m);
        Trace.endSection();
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            switch (iGlGetError) {
                case 1280:
                    hexString = "GL_INVALID_ENUM";
                    break;
                case 1281:
                    hexString = "GL_INVALID_VALUE";
                    break;
                case 1282:
                    hexString = "GL_INVALID_OPERATION";
                    break;
                case 1283:
                case 1284:
                default:
                    hexString = Integer.toHexString(iGlGetError);
                    break;
                case 1285:
                    hexString = "GL_OUT_OF_MEMORY";
                    break;
                case 1286:
                    hexString = "GL_INVALID_FRAMEBUFFER_OPERATION";
                    break;
            }
            Log.e("RenderFilter", B0.g.m("glError: ", hexString), new Exception());
            throw new IllegalStateException(B0.g.m("glError: ", hexString));
        }
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        com.google.android.material.appbar.h hVar = (com.google.android.material.appbar.h) this.f9664b;
        z0 z0Var2 = hVar.getFitsSystemWindows() ? z0Var : null;
        if (!Objects.equals(hVar.f10301g, z0Var2)) {
            hVar.f10301g = z0Var2;
            hVar.setWillNotDraw(!(hVar.f10318x != null && hVar.getTopInset() > 0));
            hVar.requestLayout();
        }
        return z0Var;
    }

    @Override // m2.n
    public final void f(TextView textView, float f4) {
        SimpleAdaptiveTextView.b((SimpleAdaptiveTextView) this.f9664b, f4);
    }

    @Override // t2.InterfaceC0934c
    public final void g() {
        com.airbnb.lottie.h.k(((r2.d) this.f9664b).f14083c);
    }

    @Override // m2.n
    public final void h(TextView textView, int i4, int i5) {
        SimpleAdaptiveTextView.a((SimpleAdaptiveTextView) this.f9664b, i4, i5);
    }

    @Override // G1.p
    public final Object i() {
        try {
            return ((Constructor) this.f9664b).newInstance(new Object[0]);
        } catch (IllegalAccessException e4) {
            AbstractC0557a abstractC0557a = J1.c.f880a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + J1.c.b((Constructor) this.f9664b) + "' with no args", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("Failed to invoke constructor '" + J1.c.b((Constructor) this.f9664b) + "' with no args", e6.getCause());
        }
    }

    @Override // t2.InterfaceC0934c
    public final void j(boolean z4) {
        com.airbnb.lottie.h.k(((r2.d) this.f9664b).f14083c);
    }

    @Override // androidx.core.widget.i
    public final void k(NestedScrollView nestedScrollView) {
        ((StepOSScrollBarView) this.f9664b).a(true);
    }

    public final void l(String str, String str2) {
        if (str2 == null) {
            return;
        }
        char[] charArray = str2.toCharArray();
        if (charArray.length < 1) {
            return;
        }
        P1.b bVar = (P1.b) this.f9664b;
        for (int i4 = 0; i4 < charArray.length; i4++) {
            P1.b bVar2 = (P1.b) bVar.f1571c.get(Character.valueOf(charArray[i4]));
            if (bVar2 == null) {
                char c4 = charArray[i4];
                P1.b bVar3 = new P1.b(c4);
                bVar3.f1569a = bVar.f1569a + 1;
                bVar.f1571c.put(Character.valueOf(c4), bVar3);
                bVar = bVar3;
            } else {
                bVar = bVar2;
            }
        }
        bVar.f1572d = true;
        bVar.f1573e = str;
    }

    public final String m(Context context) {
        if (((S2.a) this.f9664b) == null) {
            this.f9664b = new S2.a(context, "com.stepos.statsapp.v3.umid");
        }
        String string = ((S2.a) this.f9664b).f1791a.getString("UMID", "");
        T2.d.a("UmidFetcher", "getLocalUmId umId:" + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196 A[Catch: JSONException -> 0x01db, TryCatch #1 {JSONException -> 0x01db, blocks: (B:54:0x0188, B:57:0x0196, B:60:0x01ae, B:62:0x01c8, B:63:0x01d1), top: B:70:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n(android.content.Context r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.p.n(android.content.Context):java.lang.String");
    }

    @Override // stepos.support.v7.app.InterfaceC0863h
    public final DialogInterfaceC0865j newDialog(Context context, int i4) {
        C0864i c0864i = (C0864i) this.f9664b;
        return new DialogInterfaceC0865j(c0864i.f14506a.f14449a, c0864i.f14507b);
    }

    public final void o(int i4) {
        ScrollTextView.c((ScrollTextView) this.f9664b, i4);
        int height = ((ScrollTextView) this.f9664b).getHeight();
        ScrollTextView scrollTextView = (ScrollTextView) this.f9664b;
        int i5 = scrollTextView.f11759l;
        if (i5 > height) {
            scrollTextView.f11759l = height;
            scrollTextView.f11757j.f11514d.forceFinished(true);
            return;
        }
        int i6 = -height;
        if (i5 < i6) {
            scrollTextView.f11759l = i6;
            scrollTextView.f11757j.f11514d.forceFinished(true);
        }
    }

    public final String toString() {
        switch (this.f9663a) {
            case 11:
                return ((Field) this.f9664b).toString();
            case 26:
                long[] jArr = (long[]) this.f9664b;
                return jArr == null ? "<unknown>" : Arrays.toString(jArr).replace("-1", CallerData.NA);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ p(int i4, Object obj) {
        this.f9663a = i4;
        this.f9664b = obj;
    }

    public p(LocationSettingsResult locationSettingsResult) {
        this.f9663a = 3;
        this.f9664b = locationSettingsResult;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p() {
        this(22, 0);
        this.f9663a = 22;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Object obj) {
        this(23);
        this.f9663a = 23;
    }

    public p(int i4) {
        this.f9663a = i4;
        if (i4 == 15) {
            com.stepos.common.animator.c cVar = new com.stepos.common.animator.c();
            cVar.f11283h = 1;
            this.f9664b = cVar;
        } else if (i4 != 23) {
            this.f9664b = new P1.b(' ');
        } else {
            this.f9664b = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new com.stepos.alphame.dailyusage.a(8));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(AbstractC0870o abstractC0870o) {
        this(29, abstractC0870o);
        this.f9663a = 29;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this(7, materialButtonToggleGroup);
        this.f9663a = 7;
    }

    public p(SwipeDismissBehavior swipeDismissBehavior) {
        this.f9663a = 10;
        swipeDismissBehavior.getClass();
        swipeDismissBehavior.f10399f = Math.min(Math.max(Property.DEFAULT_FLOAT_VALUE, 0.1f), 1.0f);
        swipeDismissBehavior.f10400g = Math.min(Math.max(Property.DEFAULT_FLOAT_VALUE, 0.6f), 1.0f);
        swipeDismissBehavior.f10397d = 0;
    }
}
