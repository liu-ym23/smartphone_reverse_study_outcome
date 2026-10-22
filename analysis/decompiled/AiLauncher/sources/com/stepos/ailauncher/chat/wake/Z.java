package com.stepos.ailauncher.chat.wake;

import android.view.AttachedSurfaceControl;
import android.view.SurfaceControl;
import android.view.View;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import h8.C4148a;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010JE\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0011\u0010)\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/Z;", "", "Landroid/view/View;", "anchorView", "<init>", "(Landroid/view/View;)V", "", "", "regions", "", "diagnostic", "immediate", "LY8/t;", Const.INTENT_KEY_APIKEY, "([[FZZ)V", Const.INTENT_KEY_UMID, "()V", "e", "", "blurRadiusPx", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "cornerRadiusPx", "left", "top", "right", "bottom", "c", "(IFFIIII)[F", "f", "Landroid/view/View;", "Ljava/lang/reflect/Method;", "setBlurRegionsMethod", "Ljava/lang/reflect/Method;", "getViewRootImplMethod", "getSurfaceControlMethod", "initialized", "Z", "supported", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "isSupported", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    private static final String TAG = "WakeBlurController";
    private final View anchorView;
    private Method getSurfaceControlMethod;
    private Method getViewRootImplMethod;
    private boolean initialized;
    private Method setBlurRegionsMethod;
    private boolean supported;

    public Z(View anchorView) {
        kotlin.jvm.internal.p.i(anchorView, "anchorView");
        this.anchorView = anchorView;
    }

    public static /* synthetic */ void b(Z z10, float[][] fArr, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            z12 = false;
        }
        z10.a(fArr, z11, z12);
    }

    public final void a(float[][] regions, boolean diagnostic, boolean immediate) {
        int i10;
        boolean z10;
        Object[] objArr;
        Object objInvoke;
        Throwable th;
        boolean z11;
        boolean z12;
        String string;
        String string2;
        kotlin.jvm.internal.p.i(regions, "regions");
        if (diagnostic) {
            Object systemService = this.anchorView.getContext().getSystemService("window");
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            Boolean boolValueOf = windowManager != null ? Boolean.valueOf(windowManager.isCrossWindowBlurEnabled()) : null;
            int iIdentityHashCode = System.identityHashCode(this.anchorView.getRootView());
            boolean zG = g();
            boolean z13 = this.supported;
            boolean zIsAttachedToWindow = this.anchorView.isAttachedToWindow();
            int width = this.anchorView.getWidth();
            int height = this.anchorView.getHeight();
            int length = regions.length;
            float[] fArr = (float[]) Z8.r.Z(regions);
            if (fArr != null) {
                string = Arrays.toString(fArr);
                kotlin.jvm.internal.p.h(string, "toString(...)");
            } else {
                string = null;
            }
            float[] fArr2 = (float[]) Z8.r.B0(regions);
            if (fArr2 != null) {
                string2 = Arrays.toString(fArr2);
                kotlin.jvm.internal.p.h(string2, "toString(...)");
            } else {
                string2 = null;
            }
            i10 = 4;
            z10 = false;
            objArr = null;
            C4148a.k(TAG, "ListeningBlur apply root=" + iIdentityHashCode + " supported=" + zG + " reflection=" + z13 + " systemEnabled=" + boolValueOf + " attached=" + zIsAttachedToWindow + " size=" + width + "x" + height + " regions=" + length + " immediate=" + immediate + " first=" + string + " last=" + string2, false, 4, null);
        } else {
            i10 = 4;
            z10 = false;
            objArr = null;
        }
        if (!g()) {
            C4148a.d(TAG, "applyRegions skipped: not supported", z10, i10, objArr);
            return;
        }
        if (!this.anchorView.isAttachedToWindow()) {
            C4148a.d(TAG, "applyRegions skipped: anchorView not attached", z10, i10, objArr);
            return;
        }
        try {
            Method method = this.getViewRootImplMethod;
            if (method == null || (objInvoke = method.invoke(this.anchorView, objArr)) == null) {
                C4148a.u(TAG, "applyRegions: getViewRootImpl returned null", false, 4, null);
                return;
            }
            try {
                Method method2 = this.getSurfaceControlMethod;
                Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, objArr) : null;
                SurfaceControl surfaceControl = objInvoke2 instanceof SurfaceControl ? (SurfaceControl) objInvoke2 : null;
                if (surfaceControl == null) {
                    C4148a.u(TAG, "applyRegions: ViewRootImpl.getSurfaceControl returned null", false, 4, null);
                    return;
                }
                if (!surfaceControl.isValid()) {
                    C4148a.u(TAG, "applyRegions: SurfaceControl invalid", false, 4, null);
                    return;
                }
                SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
                try {
                    Method method3 = this.setBlurRegionsMethod;
                    if (method3 != null) {
                        method3.invoke(transaction, surfaceControl, regions);
                    }
                    if (immediate) {
                        transaction.apply();
                        if (diagnostic) {
                            C4148a.k(TAG, "ListeningBlur applied immediately surface=" + surfaceControl, false, 4, null);
                        }
                        z12 = false;
                    } else {
                        AttachedSurfaceControl rootSurfaceControl = this.anchorView.getRootSurfaceControl();
                        if (rootSurfaceControl == null) {
                            C4148a.u(TAG, "applyRegions: rootSurfaceControl null", false, 4, null);
                            transaction.close();
                            return;
                        }
                        boolean zApplyTransactionOnDraw = rootSurfaceControl.applyTransactionOnDraw(transaction);
                        z12 = true;
                        if (diagnostic) {
                            try {
                                C4148a.k(TAG, "ListeningBlur submitted surface=" + surfaceControl + " valid=" + surfaceControl.isValid() + " queued=" + zApplyTransactionOnDraw + " root=" + System.identityHashCode(this.anchorView.getRootView()) + " (submission is not visual confirmation)", false, 4, null);
                            } catch (Throwable th2) {
                                th = th2;
                                z11 = z12;
                                try {
                                    C4148a.t(TAG, "applyRegions invoke failed", th, false, 8, null);
                                    if (z11) {
                                        return;
                                    } else {
                                        return;
                                    }
                                } finally {
                                    if (!z11) {
                                        transaction.close();
                                    }
                                }
                            }
                        }
                    }
                    kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
                    String str = String.format("applyRegions: dispatched %d region(s) immediate=%s", Arrays.copyOf(new Object[]{Integer.valueOf(regions.length), Boolean.valueOf(immediate)}, 2));
                    kotlin.jvm.internal.p.h(str, "format(...)");
                    C4148a.d(TAG, str, false, 4, null);
                    if (z12) {
                        return;
                    }
                    transaction.close();
                } catch (Throwable th3) {
                    th = th3;
                    z11 = false;
                }
            } catch (Throwable th4) {
                C4148a.t(TAG, "ViewRootImpl.getSurfaceControl invoke failed", th4, false, 8, null);
            }
        } catch (Throwable th5) {
            C4148a.t(TAG, "getViewRootImpl invoke failed", th5, false, 8, null);
        }
    }

    public final float[] c(int blurRadiusPx, float alpha, float cornerRadiusPx, int left, int top, int right, int bottom) {
        return new float[]{blurRadiusPx, C5685n.m(alpha, 0.0f, 1.0f), left, top, right, bottom, cornerRadiusPx, cornerRadiusPx, cornerRadiusPx, cornerRadiusPx};
    }

    public final void d() {
        b(this, new float[0][], false, false, 6, null);
    }

    public final void e() {
        b(this, new float[0][], false, true, 2, null);
    }

    public final void f() {
        if (this.initialized) {
            return;
        }
        this.initialized = true;
        C4148a.d(TAG, "ensureInit: begin", false, 4, null);
        try {
            Method declaredMethod = SurfaceControl.Transaction.class.getDeclaredMethod("setBlurRegions", SurfaceControl.class, float[][].class);
            this.setBlurRegionsMethod = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            C4148a.d(TAG, "ensureInit: SurfaceControl.Transaction#setBlurRegions ok", false, 4, null);
            Method declaredMethod2 = View.class.getDeclaredMethod("getViewRootImpl", null);
            this.getViewRootImplMethod = declaredMethod2;
            if (declaredMethod2 != null) {
                declaredMethod2.setAccessible(true);
            }
            C4148a.d(TAG, "ensureInit: View#getViewRootImpl ok", false, 4, null);
            Method method = Class.forName("android.view.ViewRootImpl").getMethod("getSurfaceControl", null);
            this.getSurfaceControlMethod = method;
            if (method != null) {
                method.setAccessible(true);
            }
            C4148a.d(TAG, "ensureInit: ViewRootImpl#getSurfaceControl ok", false, 4, null);
            this.supported = true;
            C4148a.k(TAG, "WakeBlurController init ok", false, 4, null);
        } catch (Throwable th) {
            C4148a.t(TAG, "init failed,blur regions unsupported on this build", th, false, 8, null);
        }
    }

    public final boolean g() {
        f();
        if (!this.supported) {
            return false;
        }
        Object systemService = this.anchorView.getContext().getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return false;
        }
        return windowManager.isCrossWindowBlurEnabled();
    }
}
