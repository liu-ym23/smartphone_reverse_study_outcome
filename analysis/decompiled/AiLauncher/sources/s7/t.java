package s7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Ls7/t;", "", "<init>", "()V", "Lcom/stepos/motionkit/SurfaceRendererType;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/motionkit/SurfaceRendererType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/motionkit/SurfaceRendererType;", Const.INTENT_KEY_UMID, "(Lcom/stepos/motionkit/SurfaceRendererType;)V", "renderer", "Lcom/stepos/motionkit/SurfacePresentation;", "Lcom/stepos/motionkit/SurfacePresentation;", "()Lcom/stepos/motionkit/SurfacePresentation;", "c", "(Lcom/stepos/motionkit/SurfacePresentation;)V", "presentation", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public SurfaceRendererType renderer = SurfaceRendererType.AGSL;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public SurfacePresentation presentation = SurfacePresentation.SURFACE_VIEW;

    /* renamed from: a, reason: from getter */
    public final SurfacePresentation getPresentation() {
        return this.presentation;
    }

    /* renamed from: b, reason: from getter */
    public final SurfaceRendererType getRenderer() {
        return this.renderer;
    }

    public final void c(SurfacePresentation surfacePresentation) {
        kotlin.jvm.internal.p.i(surfacePresentation, "<set-?>");
        this.presentation = surfacePresentation;
    }

    public final void d(SurfaceRendererType surfaceRendererType) {
        kotlin.jvm.internal.p.i(surfaceRendererType, "<set-?>");
        this.renderer = surfaceRendererType;
    }
}
