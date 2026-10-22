package A7;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006."}, d2 = {"LA7/B;", "LA7/n;", "<init>", "()V", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "s", "()Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "z", "(Lcom/stepos/motionkit/fx/material/capability/BlurGradient;)V", "direction", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "I", "u", "()I", "B", "(I)V", "gradientScale", "k", "w", "D", "startColor", "l", "v", "C", "middleColor", "m", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "endColor", "", "n", "F", "r", "()F", "y", "(F)V", "colorMidpoint", "o", "q", "x", "colorDirection", "p", Const.INTENT_KEY_APIKEY, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class B extends C0746n {

    /* renamed from: q, reason: collision with root package name */
    public static final BlurGradient f1129q = BlurGradient.BOTTOM_TO_TOP;

    /* renamed from: r, reason: collision with root package name */
    public static final BlurGradient f1130r = BlurGradient.TOP_TO_BOTTOM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public BlurGradient direction;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int gradientScale;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int startColor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int middleColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public int endColor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public float colorMidpoint;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public BlurGradient colorDirection;

    public B() {
        n(40.0f);
        k(0.0f);
        this.direction = f1129q;
        this.colorMidpoint = 0.5f;
        this.colorDirection = f1130r;
    }

    public final void A(int i10) {
        this.endColor = i10;
    }

    public final void B(int i10) {
        this.gradientScale = i10;
    }

    public final void C(int i10) {
        this.middleColor = i10;
    }

    public final void D(int i10) {
        this.startColor = i10;
    }

    /* renamed from: q, reason: from getter */
    public final BlurGradient getColorDirection() {
        return this.colorDirection;
    }

    /* renamed from: r, reason: from getter */
    public final float getColorMidpoint() {
        return this.colorMidpoint;
    }

    /* renamed from: s, reason: from getter */
    public final BlurGradient getDirection() {
        return this.direction;
    }

    /* renamed from: t, reason: from getter */
    public final int getEndColor() {
        return this.endColor;
    }

    /* renamed from: u, reason: from getter */
    public final int getGradientScale() {
        return this.gradientScale;
    }

    /* renamed from: v, reason: from getter */
    public final int getMiddleColor() {
        return this.middleColor;
    }

    /* renamed from: w, reason: from getter */
    public final int getStartColor() {
        return this.startColor;
    }

    public final void x(BlurGradient blurGradient) {
        this.colorDirection = blurGradient;
    }

    public final void y(float f10) {
        this.colorMidpoint = f10;
    }

    public final void z(BlurGradient blurGradient) {
        kotlin.jvm.internal.p.i(blurGradient, "<set-?>");
        this.direction = blurGradient;
    }
}
