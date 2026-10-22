package y7;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Ly7/F;", "", "<init>", "()V", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "()Z", Const.INTENT_KEY_UMID, "(Z)V", "crossWindow", "", "F", "()F", "c", "(F)V", "cornerRadius", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class F {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean crossWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float cornerRadius;

    /* renamed from: a, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCrossWindow() {
        return this.crossWindow;
    }

    public final void c(float f10) {
        this.cornerRadius = f10;
    }

    public final void d(boolean z10) {
        this.crossWindow = z10;
    }
}
