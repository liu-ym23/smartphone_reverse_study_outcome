package A7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LA7/z;", "Ly7/F;", "<init>", "()V", "", "c", "F", Const.INTENT_KEY_BACKGROUND_COMMAND, "()F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)V", "sdfScale", Const.INTENT_KEY_UMID, "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "erode", "", "e", "Z", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "blendOnly", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0757z extends y7.F {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float sdfScale = 96.0f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float erode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean blendOnly;

    /* renamed from: e, reason: from getter */
    public final boolean getBlendOnly() {
        return this.blendOnly;
    }

    /* renamed from: f, reason: from getter */
    public final float getErode() {
        return this.erode;
    }

    /* renamed from: g, reason: from getter */
    public final float getSdfScale() {
        return this.sdfScale;
    }

    public final void h(boolean z10) {
        this.blendOnly = z10;
    }

    public final void i(float f10) {
        this.erode = f10;
    }

    public final void j(float f10) {
        this.sdfScale = f10;
    }
}
