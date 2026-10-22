package t;

import J.InterfaceC0857l;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lt/i0;", "", "LY8/t;", "start", "()V", "", "captureMode", "flashMode", "flashType", "LJ/l;", Const.INTENT_KEY_APIKEY, "(IIILe9/c;)Ljava/lang/Object;", "", x5.d.EXTRA_ENABLED, Const.INTENT_KEY_UMID, "(Z)V", "isPrimary", "", "Landroidx/camera/core/UseCase;", "runningUseCases", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Collection;)Lkotlinx/coroutines/g;", "close", "()Lkotlinx/coroutines/g;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "c", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface i0 {
    Object a(int i10, int i11, int i12, InterfaceC4014c<? super InterfaceC0857l> interfaceC4014c);

    kotlinx.coroutines.g b(boolean isPrimary, Collection<? extends UseCase> runningUseCases);

    UseCaseCameraRequestControl c();

    kotlinx.coroutines.g close();

    default void d(boolean enabled) {
    }

    void start();
}
