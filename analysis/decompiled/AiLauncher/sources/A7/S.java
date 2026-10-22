package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001d"}, d2 = {"LA7/S;", "Ly7/F;", "<init>", "()V", "", "c", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "l", "(Z)V", x5.d.EXTRA_ENABLED, "", Const.INTENT_KEY_UMID, "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()F", "m", "(F)V", "strength", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "n", "width", "f", "k", "dispersion", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "depthEffect", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class S extends y7.F {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float dispersion;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean enabled = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float strength = 20.0f;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float width = 40.0f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float depthEffect = 0.4f;

    /* renamed from: e, reason: from getter */
    public final float getDepthEffect() {
        return this.depthEffect;
    }

    /* renamed from: f, reason: from getter */
    public final float getDispersion() {
        return this.dispersion;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: h, reason: from getter */
    public final float getStrength() {
        return this.strength;
    }

    /* renamed from: i, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void j(float f10) {
        this.depthEffect = f10;
    }

    public final void k(float f10) {
        this.dispersion = f10;
    }

    public final void l(boolean z10) {
        this.enabled = z10;
    }

    public final void m(float f10) {
        this.strength = f10;
    }

    public final void n(float f10) {
        this.width = f10;
    }
}
