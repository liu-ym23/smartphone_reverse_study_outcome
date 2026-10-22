package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\"\u0010#\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u0006$"}, d2 = {"LA7/L;", "Ly7/F;", "<init>", "()V", "", "c", "Z", "f", "()Z", "l", "(Z)V", x5.d.EXTRA_ENABLED, "", Const.INTENT_KEY_UMID, "I", "e", "()I", "k", "(I)V", "color", "", "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()F", "p", "(F)V", "radius", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "n", "offsetX", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "o", "offsetY", "m", "intensity", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class L extends y7.F {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float offsetX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float offsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean enabled = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int color = 1711276032;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float radius = 14.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public float intensity = 1.0f;

    /* renamed from: e, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: g, reason: from getter */
    public final float getIntensity() {
        return this.intensity;
    }

    /* renamed from: h, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* renamed from: i, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* renamed from: j, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    public final void k(int i10) {
        this.color = i10;
    }

    public final void l(boolean z10) {
        this.enabled = z10;
    }

    public final void m(float f10) {
        this.intensity = f10;
    }

    public final void n(float f10) {
        this.offsetX = f10;
    }

    public final void o(float f10) {
        this.offsetY = f10;
    }

    public final void p(float f10) {
        this.radius = f10;
    }
}
