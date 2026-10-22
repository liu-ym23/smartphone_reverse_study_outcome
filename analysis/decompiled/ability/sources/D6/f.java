package D6;

import C7.r;
import D7.v;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.motionkit.fx.material.MaterialBuilder;
import com.stepos.motionkit.fx.material.MaterialHandle;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.MotionMaterialExtKt;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.collections.EmptySet;

/* loaded from: classes3.dex */
public final class f {
    public static int f;
    public static long g;

    /* renamed from: a, reason: collision with root package name */
    public final View f383a;
    public MaterialHandle b;
    public final b c;
    public boolean d;
    public Set e;

    public f(View view) {
        kotlin.jvm.internal.k.f(view, "view");
        this.f383a = view;
        new Paint(1).setStyle(Paint.Style.FILL);
        this.c = new b(this, 0);
        view.addOnAttachStateChangeListener(new e(this, 0));
        this.e = EmptySet.f4895a;
    }

    public final void a(float f7, int i, GlassEffect effect) {
        Object objA;
        Set setJ1;
        List<String> activeIds;
        View view = this.f383a;
        kotlin.jvm.internal.k.f(effect, "effect");
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            d();
            Object obj = null;
            try {
                MaterialBuilder materialBuilderCornerRadius = MotionMaterialExtKt.material(MotionKit.INSTANCE, view).crossWindow(i == 1).cornerRadius(f7);
                o oVar = o.f391a;
                float f9 = view.getResources().getDisplayMetrics().density;
                GlassEffect.Companion companion = GlassEffect.INSTANCE;
                l lVarA = effect.equals(companion.getLIGHT_SMALL()) ? oVar.a(f9) : effect.equals(companion.getDARK_SMALL()) ? o.b(oVar, companion.getDARK_SMALL(), f9, 60) : null;
                objA = (lVarA != null ? lVarA.a(materialBuilderCornerRadius) : materialBuilderCornerRadius.apply(effect)).commit();
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA == null) {
                obj = objA;
            } else {
                Log.w("StepOSGlass", "glass commit failed on ".concat(view.getClass().getSimpleName()), thA);
            }
            MaterialHandle materialHandle = (MaterialHandle) obj;
            this.b = materialHandle;
            this.d = (materialHandle != null ? materialHandle.getActiveCount() : 0) > 0;
            if (materialHandle == null || (activeIds = materialHandle.getActiveIds()) == null || (setJ1 = v.j1(activeIds)) == null) {
                setJ1 = EmptySet.f4895a;
            }
            this.e = setJ1;
            String simpleName = view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(view);
            boolean z10 = this.d;
            int activeCount = materialHandle != null ? materialHandle.getActiveCount() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z10 + " count=" + activeCount + " ids=" + this.e + " live=" + f + " size=" + view.getWidth() + "x" + view.getHeight());
            if (materialHandle != null) {
                int i6 = f + 1;
                f = i6;
                Trace.setCounter("StepOS:".concat("glass.liveHandles"), i6);
                long j5 = g + 1;
                g = j5;
                Trace.setCounter("StepOS:".concat("glass.applyCount"), j5);
            }
            if (!this.d) {
                Log.i("StepOSGlass", "glass inactive on " + view.getClass().getSimpleName() + "（scope=" + i + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
        } finally {
            Trace.endSection();
        }
    }

    public final boolean b(float f7, final float f9, final int i) {
        Object objA;
        Set setJ1;
        List<String> activeIds;
        View view = this.f383a;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            d();
            try {
                MaterialBuilder materialBuilderCornerRadius = MotionMaterialExtKt.material(MotionKit.INSTANCE, view).crossWindow(true).cornerRadius(f7);
                final int iAlpha = Color.alpha(i);
                Materials materials = Materials.INSTANCE;
                MaterialBuilder materialBuilderApply = materialBuilderCornerRadius.apply(materials.getBlur(), new S7.k() { // from class: D6.c
                    @Override // S7.k
                    public final Object invoke(Object obj) {
                        BlurParams apply = (BlurParams) obj;
                        kotlin.jvm.internal.k.f(apply, "$this$apply");
                        apply.setRadius(f9);
                        int i6 = iAlpha;
                        if (1 <= i6 && i6 < 255) {
                            apply.setTintColor(i);
                        }
                        return r.f317a;
                    }
                });
                if (iAlpha == 255) {
                    materialBuilderApply = materialBuilderApply.apply(materials.getBlend(), new d(i, 0));
                }
                objA = materialBuilderApply.commit();
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("StepOSGlass", "glass commit failed on ".concat(view.getClass().getSimpleName()), thA);
                objA = null;
            }
            MaterialHandle materialHandle = (MaterialHandle) objA;
            this.b = materialHandle;
            this.d = (materialHandle != null ? materialHandle.getActiveCount() : 0) > 0;
            if (materialHandle == null || (activeIds = materialHandle.getActiveIds()) == null || (setJ1 = v.j1(activeIds)) == null) {
                setJ1 = EmptySet.f4895a;
            }
            this.e = setJ1;
            String simpleName = view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(view);
            boolean z10 = this.d;
            int activeCount = materialHandle != null ? materialHandle.getActiveCount() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z10 + " count=" + activeCount + " ids=" + this.e + " live=" + f + " size=" + view.getWidth() + "x" + view.getHeight());
            if (materialHandle != null) {
                int i6 = f + 1;
                f = i6;
                Trace.setCounter("StepOS:".concat("glass.liveHandles"), i6);
                long j5 = g + 1;
                g = j5;
                Trace.setCounter("StepOS:".concat("glass.applyCount"), j5);
            }
            if (!this.d) {
                Log.i("StepOSGlass", "glass inactive on " + view.getClass().getSimpleName() + "（scope=1）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.d;
        } finally {
            Trace.endSection();
        }
    }

    public final boolean c(int i, float f7, S7.k kVar) {
        Object objA;
        Set setJ1;
        List<String> activeIds;
        View view = this.f383a;
        Trace.beginSection("StepOS:GlassDelegate.apply");
        try {
            d();
            try {
                objA = ((MaterialBuilder) kVar.invoke(MotionMaterialExtKt.material(MotionKit.INSTANCE, view).crossWindow(i == 1).cornerRadius(f7))).commit();
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.w("StepOSGlass", "glass commit failed on ".concat(view.getClass().getSimpleName()), thA);
                objA = null;
            }
            MaterialHandle materialHandle = (MaterialHandle) objA;
            this.b = materialHandle;
            this.d = (materialHandle != null ? materialHandle.getActiveCount() : 0) > 0;
            if (materialHandle == null || (activeIds = materialHandle.getActiveIds()) == null || (setJ1 = v.j1(activeIds)) == null) {
                setJ1 = EmptySet.f4895a;
            }
            this.e = setJ1;
            String simpleName = view.getClass().getSimpleName();
            int iIdentityHashCode = System.identityHashCode(view);
            boolean z10 = this.d;
            int activeCount = materialHandle != null ? materialHandle.getActiveCount() : 0;
            Log.i("StepOSGlass", "commit " + simpleName + "#" + iIdentityHashCode + " active=" + z10 + " count=" + activeCount + " ids=" + this.e + " live=" + f + " size=" + view.getWidth() + "x" + view.getHeight());
            if (materialHandle != null) {
                int i6 = f + 1;
                f = i6;
                Trace.setCounter("StepOS:".concat("glass.liveHandles"), i6);
                long j5 = g + 1;
                g = j5;
                Trace.setCounter("StepOS:".concat("glass.applyCount"), j5);
            }
            if (!this.d) {
                Log.i("StepOSGlass", "glass inactive on " + view.getClass().getSimpleName() + "（scope=" + i + "）—— 已降级，改用兜底背景。排障见 MotionKit 文档第 5、6 章");
            }
            return this.d;
        } finally {
            Trace.endSection();
        }
    }

    public final void d() {
        View view = this.f383a;
        MaterialHandle materialHandle = this.b;
        if (materialHandle == null) {
            this.d = false;
            this.e = EmptySet.f4895a;
            return;
        }
        Trace.beginSection("StepOS:GlassDelegate.release");
        try {
            Log.i("StepOSGlass", "release " + view.getClass().getSimpleName() + "#" + System.identityHashCode(view) + " live=" + f + " size=" + view.getWidth() + "x" + view.getHeight());
            try {
                materialHandle.release();
            } catch (Throwable th) {
                kotlin.b.a(th);
            }
            this.b = null;
            this.d = false;
            this.e = EmptySet.f4895a;
            int i = f - 1;
            f = i;
            Trace.setCounter("StepOS:".concat("glass.liveHandles"), i);
        } finally {
            Trace.endSection();
        }
    }
}
