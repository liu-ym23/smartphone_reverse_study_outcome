package x;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.C5708n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001JK\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\b\b\u0002\u0010\u0013\u001a\u00020\bH&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lx/X;", "", "Lw/n;", "cameraId", "", "sharedCameraIds", "LA/e;", "graphListener", "", "isPrewarm", "Lkotlin/Function1;", "LY8/t;", "isForegroundObserver", "Lx/K0;", "c", "(Ljava/lang/String;Ljava/util/List;LA/e;ZLp9/l;)Lx/K0;", "LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LUa/Q;", "forceCancelOpen", Const.INTENT_KEY_APIKEY, "(Z)LUa/Q;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface X {
    Ua.Q<Y8.t> a(boolean forceCancelOpen);

    Ua.Q<Y8.t> b(String cameraId);

    K0 c(String cameraId, List<C5708n> sharedCameraIds, A.e graphListener, boolean isPrewarm, InterfaceC5074l<? super Y8.t, Boolean> isForegroundObserver);
}
