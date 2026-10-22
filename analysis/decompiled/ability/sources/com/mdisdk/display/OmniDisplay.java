package com.mdisdk.display;

import C7.r;
import H7.c;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.display.VirtualDisplayFactory;
import com.mdisdk.gles.EglRenderPipeline;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import r3.C1875a;
import r3.C1876b;
import r3.C1877c;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b \u0010\u0012J\u0010\u0010\"\u001a\u00020!H\u0086@¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\u001dJ\r\u0010%\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010*R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/mdisdk/display/OmniDisplay;", "", "Landroid/view/Display;", "targetDisplay", "Landroid/hardware/display/VirtualDisplay;", "virtualDisplay", "Lcom/mdisdk/gles/EglRenderPipeline;", "renderPipeline", "Landroid/hardware/display/DisplayManager;", "displayManager", "", "useEgl", AppAgent.CONSTRUCT, "(Landroid/view/Display;Landroid/hardware/display/VirtualDisplay;Lcom/mdisdk/gles/EglRenderPipeline;Landroid/hardware/display/DisplayManager;Z)V", "Landroid/view/Surface;", "surface", "LC7/r;", "setOutputSurfaceWithEgl", "(Landroid/view/Surface;)V", "setOutputSurfaceWithoutEgl", "outputSurface", "createVirtualDisplayForOutput", "createVirtualDisplayForOutputWithoutEgl", "", "getDisplayId", "()I", "getDisplay", "()Landroid/view/Display;", "isUsingEgl", "()Z", "getCurrentOutputSurface", "()Landroid/view/Surface;", "setOutputSurface", "Landroid/graphics/Bitmap;", "capture", "(LH7/c;)Ljava/lang/Object;", "isCaptureSupported", "release", "()V", "Landroid/view/Display;", "Landroid/hardware/display/VirtualDisplay;", "Lcom/mdisdk/gles/EglRenderPipeline;", "Landroid/hardware/display/DisplayManager;", "Z", "directOutputSurface", "Landroid/view/Surface;", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OmniDisplay {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MIRROR_FLAGS = 15575;
    private static final int OMNI_FLAGS = 163535;
    private static final String TAG = "OmniDisplay";
    private Surface directOutputSurface;
    private final DisplayManager displayManager;
    private EglRenderPipeline renderPipeline;
    private final Display targetDisplay;
    private final boolean useEgl;
    private VirtualDisplay virtualDisplay;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J,\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J,\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J,\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J*\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J*\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/mdisdk/display/OmniDisplay$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "OMNI_FLAGS", "", "MIRROR_FLAGS", "create", "Lcom/mdisdk/display/OmniDisplay;", "displayManager", "Landroid/hardware/display/DisplayManager;", "initialSurface", "Landroid/view/Surface;", "useEgl", "", "createWithEgl", "display", "Landroid/view/Display;", "dm", "Landroid/util/DisplayMetrics;", "createWithoutEgl", "createForDisplay", WindowStateInfo.KEY_DISPLAY_ID, "outputSurface", "createForDisplayWithEgl", "targetDisplay", "createForDisplayWithoutEgl", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ OmniDisplay create$default(Companion companion, DisplayManager displayManager, Surface surface, boolean z10, int i, Object obj) {
            if ((i & 4) != 0) {
                z10 = true;
            }
            return companion.create(displayManager, surface, z10);
        }

        public static /* synthetic */ OmniDisplay createForDisplay$default(Companion companion, DisplayManager displayManager, int i, Surface surface, boolean z10, int i6, Object obj) {
            if ((i6 & 8) != 0) {
                z10 = true;
            }
            return companion.createForDisplay(displayManager, i, surface, z10);
        }

        private final OmniDisplay createForDisplayWithEgl(Display targetDisplay, DisplayMetrics dm, DisplayManager displayManager, Surface outputSurface) {
            VirtualDisplay virtualDisplayCreateVirtualDisplay;
            EglRenderPipeline eglRenderPipeline = new EglRenderPipeline(dm.widthPixels, dm.heightPixels);
            eglRenderPipeline.start();
            Surface surfaceAwaitInputSurface$default = EglRenderPipeline.awaitInputSurface$default(eglRenderPipeline, 0L, 1, null);
            if (surfaceAwaitInputSurface$default == null || (virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(displayManager, new C1877c(targetDisplay, dm, surfaceAwaitInputSurface$default, 1))) == null) {
                return null;
            }
            eglRenderPipeline.setOutputSurface(outputSurface);
            return new OmniDisplay(targetDisplay, virtualDisplayCreateVirtualDisplay, eglRenderPipeline, displayManager, true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r createForDisplayWithEgl$lambda$3(Display display, DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
            k.f(createVirtualDisplay, "$this$createVirtualDisplay");
            createVirtualDisplay.setName("mirror_" + display.getDisplayId());
            createVirtualDisplay.setWidth(displayMetrics.widthPixels);
            createVirtualDisplay.setHeight(displayMetrics.heightPixels);
            createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
            createVirtualDisplay.setFlags(OmniDisplay.OMNI_FLAGS);
            createVirtualDisplay.setSurface(surface);
            return r.f317a;
        }

        private final OmniDisplay createForDisplayWithoutEgl(Display targetDisplay, DisplayMetrics dm, DisplayManager displayManager, Surface outputSurface) {
            VirtualDisplay virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(displayManager, new C1877c(targetDisplay, dm, outputSurface, 0));
            if (virtualDisplayCreateVirtualDisplay == null) {
                return null;
            }
            ALog.d$default(OmniDisplay.TAG, "Created OmniDisplay for display " + targetDisplay.getDisplayId() + " without EGL", null, 4, null);
            return new OmniDisplay(targetDisplay, virtualDisplayCreateVirtualDisplay, null, displayManager, false, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r createForDisplayWithoutEgl$lambda$4(Display display, DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
            k.f(createVirtualDisplay, "$this$createVirtualDisplay");
            createVirtualDisplay.setName("mirror_no_egl_" + display.getDisplayId());
            createVirtualDisplay.setWidth(displayMetrics.widthPixels);
            createVirtualDisplay.setHeight(displayMetrics.heightPixels);
            createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
            createVirtualDisplay.setFlags(OmniDisplay.OMNI_FLAGS);
            createVirtualDisplay.setSurface(surface);
            return r.f317a;
        }

        private final OmniDisplay createWithEgl(Display display, DisplayMetrics dm, DisplayManager displayManager, Surface initialSurface) {
            VirtualDisplay virtualDisplayCreateVirtualDisplay;
            EglRenderPipeline eglRenderPipeline = new EglRenderPipeline(dm.widthPixels, dm.heightPixels);
            eglRenderPipeline.start();
            Surface surfaceAwaitInputSurface$default = EglRenderPipeline.awaitInputSurface$default(eglRenderPipeline, 0L, 1, null);
            if (surfaceAwaitInputSurface$default == null || (virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(displayManager, new C1876b(dm, surfaceAwaitInputSurface$default, 0))) == null) {
                return null;
            }
            if (initialSurface != null) {
                eglRenderPipeline.setOutputSurface(initialSurface);
            }
            Display display2 = virtualDisplayCreateVirtualDisplay.getDisplay();
            k.e(display2, "getDisplay(...)");
            return new OmniDisplay(display2, virtualDisplayCreateVirtualDisplay, eglRenderPipeline, displayManager, true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r createWithEgl$lambda$0(DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
            k.f(createVirtualDisplay, "$this$createVirtualDisplay");
            createVirtualDisplay.setName("omni");
            createVirtualDisplay.setWidth(displayMetrics.widthPixels);
            createVirtualDisplay.setHeight(displayMetrics.heightPixels);
            createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
            createVirtualDisplay.setFlags(OmniDisplay.OMNI_FLAGS);
            createVirtualDisplay.setSurface(surface);
            return r.f317a;
        }

        private final OmniDisplay createWithoutEgl(Display display, DisplayMetrics dm, DisplayManager displayManager, Surface initialSurface) {
            VirtualDisplay virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(displayManager, new C1876b(dm, initialSurface, 1));
            if (virtualDisplayCreateVirtualDisplay == null) {
                return null;
            }
            Display display2 = virtualDisplayCreateVirtualDisplay.getDisplay();
            k.e(display2, "getDisplay(...)");
            return new OmniDisplay(display2, virtualDisplayCreateVirtualDisplay, null, displayManager, false, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r createWithoutEgl$lambda$2(DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
            k.f(createVirtualDisplay, "$this$createVirtualDisplay");
            createVirtualDisplay.setName("omni");
            createVirtualDisplay.setWidth(displayMetrics.widthPixels);
            createVirtualDisplay.setHeight(displayMetrics.heightPixels);
            createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
            createVirtualDisplay.setFlags(OmniDisplay.OMNI_FLAGS);
            createVirtualDisplay.setSurface(surface);
            return r.f317a;
        }

        public final OmniDisplay create(DisplayManager displayManager, Surface initialSurface, boolean useEgl) {
            k.f(displayManager, "displayManager");
            Display display = displayManager.getDisplay(0);
            if (display == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getRealMetrics(displayMetrics);
            return useEgl ? createWithEgl(display, displayMetrics, displayManager, initialSurface) : createWithoutEgl(display, displayMetrics, displayManager, initialSurface);
        }

        public final OmniDisplay createForDisplay(DisplayManager displayManager, int displayId, Surface outputSurface, boolean useEgl) {
            k.f(displayManager, "displayManager");
            Display display = displayManager.getDisplay(displayId);
            if (display == null) {
                return null;
            }
            if (outputSurface == null) {
                return new OmniDisplay(display, null, null, displayManager, false, null);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getRealMetrics(displayMetrics);
            return useEgl ? createForDisplayWithEgl(display, displayMetrics, displayManager, outputSurface) : createForDisplayWithoutEgl(display, displayMetrics, displayManager, outputSurface);
        }

        private Companion() {
        }
    }

    public /* synthetic */ OmniDisplay(Display display, VirtualDisplay virtualDisplay, EglRenderPipeline eglRenderPipeline, DisplayManager displayManager, boolean z10, e eVar) {
        this(display, virtualDisplay, eglRenderPipeline, displayManager, z10);
    }

    private final void createVirtualDisplayForOutput(Surface outputSurface) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.targetDisplay.getRealMetrics(displayMetrics);
        EglRenderPipeline eglRenderPipeline = new EglRenderPipeline(displayMetrics.widthPixels, displayMetrics.heightPixels);
        eglRenderPipeline.start();
        Surface surfaceAwaitInputSurface$default = EglRenderPipeline.awaitInputSurface$default(eglRenderPipeline, 0L, 1, null);
        if (surfaceAwaitInputSurface$default == null) {
            eglRenderPipeline.release();
            return;
        }
        VirtualDisplay virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(this.displayManager, new C1875a(this, displayMetrics, surfaceAwaitInputSurface$default, 0));
        if (virtualDisplayCreateVirtualDisplay == null) {
            eglRenderPipeline.release();
            return;
        }
        eglRenderPipeline.setOutputSurface(outputSurface);
        this.virtualDisplay = virtualDisplayCreateVirtualDisplay;
        this.renderPipeline = eglRenderPipeline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createVirtualDisplayForOutput$lambda$0(OmniDisplay omniDisplay, DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
        k.f(createVirtualDisplay, "$this$createVirtualDisplay");
        createVirtualDisplay.setName("omni_" + omniDisplay.targetDisplay.getDisplayId());
        createVirtualDisplay.setWidth(displayMetrics.widthPixels);
        createVirtualDisplay.setHeight(displayMetrics.heightPixels);
        createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
        createVirtualDisplay.setFlags(OMNI_FLAGS);
        createVirtualDisplay.setSurface(surface);
        return r.f317a;
    }

    private final void createVirtualDisplayForOutputWithoutEgl(Surface outputSurface) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.targetDisplay.getRealMetrics(displayMetrics);
        VirtualDisplay virtualDisplayCreateVirtualDisplay = VirtualDisplayFactory.INSTANCE.createVirtualDisplay(this.displayManager, new C1875a(this, displayMetrics, outputSurface, 1));
        if (virtualDisplayCreateVirtualDisplay == null) {
            ALog.e$default(TAG, "Failed to create VirtualDisplay without EGL", null, 4, null);
            return;
        }
        this.virtualDisplay = virtualDisplayCreateVirtualDisplay;
        this.directOutputSurface = outputSurface;
        ALog.d$default(TAG, "Created VirtualDisplay without EGL for display " + this.targetDisplay.getDisplayId(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r createVirtualDisplayForOutputWithoutEgl$lambda$1(OmniDisplay omniDisplay, DisplayMetrics displayMetrics, Surface surface, VirtualDisplayFactory.VirtualDisplayBuilder createVirtualDisplay) {
        k.f(createVirtualDisplay, "$this$createVirtualDisplay");
        createVirtualDisplay.setName("omni_" + omniDisplay.targetDisplay.getDisplayId());
        createVirtualDisplay.setWidth(displayMetrics.widthPixels);
        createVirtualDisplay.setHeight(displayMetrics.heightPixels);
        createVirtualDisplay.setDensityDpi(displayMetrics.densityDpi);
        createVirtualDisplay.setFlags(OMNI_FLAGS);
        createVirtualDisplay.setSurface(surface);
        return r.f317a;
    }

    private final void setOutputSurfaceWithEgl(Surface surface) {
        EglRenderPipeline eglRenderPipeline = this.renderPipeline;
        if (eglRenderPipeline != null) {
            if (eglRenderPipeline != null) {
                eglRenderPipeline.setOutputSurface(surface);
            }
        } else if (surface != null) {
            createVirtualDisplayForOutput(surface);
        }
    }

    private final void setOutputSurfaceWithoutEgl(Surface surface) {
        this.directOutputSurface = surface;
        VirtualDisplay virtualDisplay = this.virtualDisplay;
        if (virtualDisplay != null) {
            if (virtualDisplay != null) {
                virtualDisplay.setSurface(surface);
            }
            ALog.d$default(TAG, "Updated VirtualDisplay surface directly (no EGL)", null, 4, null);
        } else if (surface != null) {
            createVirtualDisplayForOutputWithoutEgl(surface);
        }
    }

    public final Object capture(c<? super Bitmap> cVar) {
        Bitmap bitmapTakeScreenShot = FrameworkBridgeFactory.get().takeScreenShot(getDisplayId(), null);
        k.e(bitmapTakeScreenShot, "takeScreenShot(...)");
        return bitmapTakeScreenShot;
    }

    public final Surface getCurrentOutputSurface() {
        if (!this.useEgl) {
            return this.directOutputSurface;
        }
        EglRenderPipeline eglRenderPipeline = this.renderPipeline;
        if (eglRenderPipeline != null) {
            return eglRenderPipeline.getCurrentOutputSurface();
        }
        return null;
    }

    /* renamed from: getDisplay, reason: from getter */
    public final Display getTargetDisplay() {
        return this.targetDisplay;
    }

    public final int getDisplayId() {
        return this.targetDisplay.getDisplayId();
    }

    public final boolean isCaptureSupported() {
        return this.useEgl && this.renderPipeline != null;
    }

    /* renamed from: isUsingEgl, reason: from getter */
    public final boolean getUseEgl() {
        return this.useEgl;
    }

    public final void release() {
        EglRenderPipeline eglRenderPipeline = this.renderPipeline;
        if (eglRenderPipeline != null) {
            eglRenderPipeline.release();
        }
        VirtualDisplay virtualDisplay = this.virtualDisplay;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
        this.directOutputSurface = null;
    }

    public final void setOutputSurface(Surface surface) {
        if (this.useEgl) {
            setOutputSurfaceWithEgl(surface);
        } else {
            setOutputSurfaceWithoutEgl(surface);
        }
    }

    private OmniDisplay(Display display, VirtualDisplay virtualDisplay, EglRenderPipeline eglRenderPipeline, DisplayManager displayManager, boolean z10) {
        this.targetDisplay = display;
        this.virtualDisplay = virtualDisplay;
        this.renderPipeline = eglRenderPipeline;
        this.displayManager = displayManager;
        this.useEgl = z10;
    }
}
