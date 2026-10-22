package P;

import K.InterfaceC0896t;
import K.InterfaceC0898v;
import android.util.Range;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006Ju\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H&¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"LP/i;", "", "LK/t;", "cameraDeviceSurfaceManager", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LK/t;)V", "", "cameraMode", "LK/v;", "cameraInfoInternal", "", "Landroidx/camera/core/UseCase;", "newUseCases", "attachedUseCases", "Landroidx/camera/core/impl/g;", "cameraConfig", "sessionType", "Landroid/util/Range;", "targetFrameRate", "", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "LP/h;", Const.INTENT_KEY_PKGNAME, "(ILK/v;Ljava/util/List;Ljava/util/List;Landroidx/camera/core/impl/g;ILandroid/util/Range;ZZ)LP/h;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f5341a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f5340b = new a();

    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Ji\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"P/i$a", "LP/i;", "", "cameraMode", "LK/v;", "cameraInfoInternal", "", "Landroidx/camera/core/UseCase;", "newUseCases", "attachedUseCases", "Landroidx/camera/core/impl/g;", "cameraConfig", "sessionType", "Landroid/util/Range;", "targetFrameRate", "", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "LP/h;", Const.INTENT_KEY_PKGNAME, "(ILK/v;Ljava/util/List;Ljava/util/List;Landroidx/camera/core/impl/g;ILandroid/util/Range;ZZ)LP/h;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements i {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // P.i
        public StreamSpecQueryResult b(int cameraMode, InterfaceC0898v cameraInfoInternal, List<? extends UseCase> newUseCases, List<? extends UseCase> attachedUseCases, androidx.camera.core.impl.g cameraConfig, int sessionType, Range<Integer> targetFrameRate, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) {
            p.i(cameraInfoInternal, "cameraInfoInternal");
            p.i(newUseCases, "newUseCases");
            p.i(attachedUseCases, "attachedUseCases");
            p.i(cameraConfig, "cameraConfig");
            p.i(targetFrameRate, "targetFrameRate");
            return new StreamSpecQueryResult(null, 0, 3, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0001¨\u0006\u0007"}, d2 = {"LP/i$b;", "", "<init>", "()V", "LP/i;", "NO_OP_STREAM_SPECS_CALCULATOR", "LP/i;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: P.i$b, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f5341a = new Companion();
    }

    default void a(InterfaceC0896t cameraDeviceSurfaceManager) {
        p.i(cameraDeviceSurfaceManager, "cameraDeviceSurfaceManager");
    }

    StreamSpecQueryResult b(int cameraMode, InterfaceC0898v cameraInfoInternal, List<? extends UseCase> newUseCases, List<? extends UseCase> attachedUseCases, androidx.camera.core.impl.g cameraConfig, int sessionType, Range<Integer> targetFrameRate, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate);
}
