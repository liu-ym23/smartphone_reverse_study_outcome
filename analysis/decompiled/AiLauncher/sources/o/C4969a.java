package o;

import android.annotation.SuppressLint;
import androidx.camera.camera2.impl.LowLightBoostControl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.C0;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lo/a;", "", "Lt/C0;", "zoomControl", "Lt/S;", "evCompControl", "Landroidx/camera/camera2/impl/f;", "torchControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "lowLightBoostControl", "<init>", "(Lt/C0;Lt/S;Landroidx/camera/camera2/impl/f;Landroidx/camera/camera2/impl/LowLightBoostControl;)V", Const.INTENT_KEY_APIKEY, "Lt/C0;", Const.INTENT_KEY_PKGNAME, "Lt/S;", "c", "Landroidx/camera/camera2/impl/f;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/impl/LowLightBoostControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"UnsafeOptInUsageError"})
/* renamed from: o.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4969a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C0 zoomControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final t.S evCompControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.impl.f torchControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final LowLightBoostControl lowLightBoostControl;

    public C4969a(C0 zoomControl, t.S evCompControl, androidx.camera.camera2.impl.f torchControl, LowLightBoostControl lowLightBoostControl) {
        kotlin.jvm.internal.p.i(zoomControl, "zoomControl");
        kotlin.jvm.internal.p.i(evCompControl, "evCompControl");
        kotlin.jvm.internal.p.i(torchControl, "torchControl");
        kotlin.jvm.internal.p.i(lowLightBoostControl, "lowLightBoostControl");
        this.zoomControl = zoomControl;
        this.evCompControl = evCompControl;
        this.torchControl = torchControl;
        this.lowLightBoostControl = lowLightBoostControl;
    }
}
