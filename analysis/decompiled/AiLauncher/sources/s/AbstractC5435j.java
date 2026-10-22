package s;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ls/j;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: s.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5435j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ls/j$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "Lw/k;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/h;)Lw/k;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: s.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final InterfaceC5705k a(androidx.camera.camera2.pipe.h cameraPipe) {
            kotlin.jvm.internal.p.i(cameraPipe, "cameraPipe");
            return cameraPipe.a();
        }

        public Companion() {
        }
    }
}
