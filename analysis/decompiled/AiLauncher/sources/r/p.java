package r;

import androidx.camera.camera2.compat.quirk.AfRegionFlipHorizontallyQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lr/p;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface p {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lr/p$a;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lr/p$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lr/p;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/compat/quirk/a;)Lr/p;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: r.p$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final p a(androidx.camera.camera2.compat.quirk.a cameraQuirks) {
                kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
                return cameraQuirks.b().a(AfRegionFlipHorizontallyQuirk.class) ? r.f38712a : u.f38715a;
            }

            public Companion() {
            }
        }
    }
}
