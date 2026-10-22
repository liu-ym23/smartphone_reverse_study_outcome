package androidx.camera.core.impl;

import D.C0777n;
import K.N;
import android.content.Context;
import androidx.camera.core.CameraSelector;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/camera/core/impl/CameraValidator;", "", "LK/N;", "cameraRepository", "LY8/t;", "c", "(LK/N;)V", "", "Landroidx/camera/core/impl/CameraInternal;", "currentCameras", "LD/n;", "removedCameras", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;Ljava/util/Set;)Z", Const.INTENT_KEY_APIKEY, "CameraIdListIncorrectException", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CameraValidator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f11319a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/core/impl/CameraValidator$CameraIdListIncorrectException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "message", "", "availableCameraCount", "", "cause", "<init>", "(Ljava/lang/String;ILjava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "I", "()I", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraIdListIncorrectException extends Exception {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int availableCameraCount;

        public CameraIdListIncorrectException(String str, int i10, Throwable th) {
            super(str, th);
            this.availableCameraCount = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getAvailableCameraCount() {
            return this.availableCameraCount;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/camera/core/impl/CameraValidator$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/camera/core/CameraSelector;", "availableCamerasSelector", "Landroidx/camera/core/impl/CameraValidator;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroidx/camera/core/CameraSelector;)Landroidx/camera/core/impl/CameraValidator;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.core.impl.CameraValidator$a, reason: from kotlin metadata */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f11319a = new Companion();

        public final CameraValidator a(Context context, CameraSelector availableCamerasSelector) {
            kotlin.jvm.internal.p.i(context, "context");
            return new k(context, availableCamerasSelector);
        }
    }

    static CameraValidator a(Context context, CameraSelector cameraSelector) {
        return INSTANCE.a(context, cameraSelector);
    }

    boolean b(Set<? extends CameraInternal> currentCameras, Set<C0777n> removedCameras);

    void c(N cameraRepository) throws CameraIdListIncorrectException;
}
