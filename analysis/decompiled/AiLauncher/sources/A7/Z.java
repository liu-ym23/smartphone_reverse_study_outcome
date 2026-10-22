package A7;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001e\u001a\u0004\b\u001c\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u0012R\"\u0010-\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b/\u0010\u0010\"\u0004\b\u000e\u0010\u0012R\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R\"\u00105\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b4\u0010\u0012R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b6\u0010\nR\"\u00109\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b*\u0010\"\"\u0004\b8\u0010$R\"\u0010;\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001e\u001a\u0004\b!\u0010\"\"\u0004\b:\u0010$R\"\u0010=\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b&\u0010\u0010\"\u0004\b<\u0010\u0012R\"\u0010?\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b>\u0010\u0012¨\u0006@"}, d2 = {"LA7/Z;", "Ly7/F;", "<init>", "()V", "", "c", "Z", "l", "()Z", "B", "(Z)V", x5.d.EXTRA_ENABLED, "", Const.INTENT_KEY_UMID, "F", "t", "()F", "J", "(F)V", "width", "e", "r", "H", "softness", "f", "m", "C", "intensity", Const.INTENT_KEY_BACKGROUND_COMMAND, "s", "I", "spread", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()I", "w", "(I)V", "color", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "n", "D", "light0X", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "o", ExifInterface.LONGITUDE_EAST, "light0Y", "k", "p", "light1X", "q", "G", "light1Y", "u", "ambient", "v", "anisotropicRim", "z", "edgeColor", "x", "darkColor", "y", "darkWidth", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "edgeWidth", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Z extends y7.F {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float width;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public float light0X;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public float light1X;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public float ambient;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean anisotropicRim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean enabled = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public float softness = 6.0f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public float intensity = 0.7f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float spread = 2.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int color = -1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public float light0Y = -1.0f;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public float light1Y = 1.0f;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public int edgeColor = -3355444;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public int darkColor = -3092272;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public float darkWidth = 1.0f;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public float edgeWidth = 1.0f;

    public final void A(float f10) {
        this.edgeWidth = f10;
    }

    public final void B(boolean z10) {
        this.enabled = z10;
    }

    public final void C(float f10) {
        this.intensity = f10;
    }

    public final void D(float f10) {
        this.light0X = f10;
    }

    public final void E(float f10) {
        this.light0Y = f10;
    }

    public final void F(float f10) {
        this.light1X = f10;
    }

    public final void G(float f10) {
        this.light1Y = f10;
    }

    public final void H(float f10) {
        this.softness = f10;
    }

    public final void I(float f10) {
        this.spread = f10;
    }

    public final void J(float f10) {
        this.width = f10;
    }

    /* renamed from: e, reason: from getter */
    public final float getAmbient() {
        return this.ambient;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getAnisotropicRim() {
        return this.anisotropicRim;
    }

    /* renamed from: g, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: h, reason: from getter */
    public final int getDarkColor() {
        return this.darkColor;
    }

    /* renamed from: i, reason: from getter */
    public final float getDarkWidth() {
        return this.darkWidth;
    }

    /* renamed from: j, reason: from getter */
    public final int getEdgeColor() {
        return this.edgeColor;
    }

    /* renamed from: k, reason: from getter */
    public final float getEdgeWidth() {
        return this.edgeWidth;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: m, reason: from getter */
    public final float getIntensity() {
        return this.intensity;
    }

    /* renamed from: n, reason: from getter */
    public final float getLight0X() {
        return this.light0X;
    }

    /* renamed from: o, reason: from getter */
    public final float getLight0Y() {
        return this.light0Y;
    }

    /* renamed from: p, reason: from getter */
    public final float getLight1X() {
        return this.light1X;
    }

    /* renamed from: q, reason: from getter */
    public final float getLight1Y() {
        return this.light1Y;
    }

    /* renamed from: r, reason: from getter */
    public final float getSoftness() {
        return this.softness;
    }

    /* renamed from: s, reason: from getter */
    public final float getSpread() {
        return this.spread;
    }

    /* renamed from: t, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void u(float f10) {
        this.ambient = f10;
    }

    public final void v(boolean z10) {
        this.anisotropicRim = z10;
    }

    public final void w(int i10) {
        this.color = i10;
    }

    public final void x(int i10) {
        this.darkColor = i10;
    }

    public final void y(float f10) {
        this.darkWidth = f10;
    }

    public final void z(int i10) {
        this.edgeColor = i10;
    }
}
