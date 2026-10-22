package r;

import androidx.camera.camera2.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lr/a;", "", "", "aeMode", Const.INTENT_KEY_APIKEY, "(I)I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5183a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lr/a$a;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: r.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0510a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lr/a$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lr/a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/compat/quirk/a;)Lr/a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: r.a$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final InterfaceC5183a a(androidx.camera.camera2.compat.quirk.a cameraQuirks) {
                kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
                return (q.f.f38470a.c(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class) == null && !cameraQuirks.b().a(ImageCaptureFailWithAutoFlashQuirk.class)) ? s.f38713a : C5184b.f38698a;
            }

            public Companion() {
            }
        }
    }

    int a(int aeMode);
}
