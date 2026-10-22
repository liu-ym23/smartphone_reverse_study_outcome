package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006$"}, d2 = {"LA7/n;", "Ly7/F;", "<init>", "()V", "", "c", "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()F", "n", "(F)V", "radius", "", Const.INTENT_KEY_UMID, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", "o", "(I)V", "tintColor", "e", "k", "blendColor", "f", "l", "frost", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Z", "()Z", "m", "(Z)V", "overlay", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "p", "useAospBlur", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0746n extends y7.F {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float radius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int tintColor = 16777215;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float blendColor = 0.1f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float frost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean overlay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean useAospBlur;

    /* renamed from: e, reason: from getter */
    public final float getBlendColor() {
        return this.blendColor;
    }

    /* renamed from: f, reason: from getter */
    public final float getFrost() {
        return this.frost;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getOverlay() {
        return this.overlay;
    }

    /* renamed from: h, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* renamed from: i, reason: from getter */
    public final int getTintColor() {
        return this.tintColor;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getUseAospBlur() {
        return this.useAospBlur;
    }

    public final void k(float f10) {
        this.blendColor = f10;
    }

    public final void l(float f10) {
        this.frost = f10;
    }

    public final void m(boolean z10) {
        this.overlay = z10;
    }

    public final void n(float f10) {
        this.radius = f10;
    }

    public final void o(int i10) {
        this.tintColor = i10;
    }

    public final void p(boolean z10) {
        this.useAospBlur = z10;
    }
}
