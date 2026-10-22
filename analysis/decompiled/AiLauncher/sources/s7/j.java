package s7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.BackendHint;
import com.stepos.motionkit.EndBehavior;
import com.stepos.motionkit.PlayMode;
import com.stepos.motionkit.SurfacePresentation;
import com.stepos.motionkit.SurfaceRendererType;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010/\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010+\u001a\u0004\b\u0013\u0010,\"\u0004\b-\u0010.R\"\u00105\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00101\u001a\u0004\b\u001b\u00102\"\u0004\b3\u00104R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00107\u001a\u0004\b#\u00108\"\u0004\b9\u0010:¨\u0006<"}, d2 = {"Ls7/j;", "", "<init>", "()V", "Lkotlin/Function1;", "Ls7/t;", "LY8/t;", "block", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lcom/stepos/motionkit/BackendHint;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/motionkit/BackendHint;", "()Lcom/stepos/motionkit/BackendHint;", "setBackend", "(Lcom/stepos/motionkit/BackendHint;)V", "backend", "Lcom/stepos/motionkit/SurfaceRendererType;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/motionkit/SurfaceRendererType;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/motionkit/SurfaceRendererType;", "setSurfaceRenderer", "(Lcom/stepos/motionkit/SurfaceRendererType;)V", "surfaceRenderer", "Lcom/stepos/motionkit/SurfacePresentation;", "c", "Lcom/stepos/motionkit/SurfacePresentation;", "f", "()Lcom/stepos/motionkit/SurfacePresentation;", "setSurfacePresentation", "(Lcom/stepos/motionkit/SurfacePresentation;)V", "surfacePresentation", "Lcom/stepos/motionkit/PlayMode;", Const.INTENT_KEY_UMID, "Lcom/stepos/motionkit/PlayMode;", "e", "()Lcom/stepos/motionkit/PlayMode;", "setPlayMode", "(Lcom/stepos/motionkit/PlayMode;)V", "playMode", "", "J", "()J", "setDurationMs", "(J)V", "durationMs", "Lcom/stepos/motionkit/EndBehavior;", "Lcom/stepos/motionkit/EndBehavior;", "()Lcom/stepos/motionkit/EndBehavior;", "setEndBehavior", "(Lcom/stepos/motionkit/EndBehavior;)V", "endBehavior", "Lkotlin/Function0;", "Lp9/a;", "()Lp9/a;", "setOnComplete", "(Lp9/a;)V", "onComplete", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long durationMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public InterfaceC5063a<Y8.t> onComplete;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public BackendHint backend = BackendHint.AUTO;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public SurfaceRendererType surfaceRenderer = SurfaceRendererType.AGSL;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public SurfacePresentation surfacePresentation = SurfacePresentation.SURFACE_VIEW;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public PlayMode playMode = PlayMode.LOOP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public EndBehavior endBehavior = EndBehavior.FREEZE;

    /* renamed from: a, reason: from getter */
    public final BackendHint getBackend() {
        return this.backend;
    }

    /* renamed from: b, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: c, reason: from getter */
    public final EndBehavior getEndBehavior() {
        return this.endBehavior;
    }

    public final InterfaceC5063a<Y8.t> d() {
        return this.onComplete;
    }

    /* renamed from: e, reason: from getter */
    public final PlayMode getPlayMode() {
        return this.playMode;
    }

    /* renamed from: f, reason: from getter */
    public final SurfacePresentation getSurfacePresentation() {
        return this.surfacePresentation;
    }

    /* renamed from: g, reason: from getter */
    public final SurfaceRendererType getSurfaceRenderer() {
        return this.surfaceRenderer;
    }

    public final void h() {
        this.backend = BackendHint.SF;
    }

    public final void i(InterfaceC5074l<? super t, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.backend = BackendHint.SURFACE;
        t tVar = new t();
        block.invoke(tVar);
        this.surfaceRenderer = tVar.getRenderer();
        this.surfacePresentation = tVar.getPresentation();
    }
}
