package r;

import K.w0;
import androidx.camera.camera2.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.impl.DeferrableSurface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lr/l;", "", "Lw/Q;", "streamId", "Landroidx/camera/core/impl/DeferrableSurface;", "deferrableSurface", "Landroidx/camera/camera2/pipe/CameraGraph;", "graph", "LY8/t;", "c", "(ILandroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/camera2/pipe/CameraGraph;)V", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/DeferrableSurface;)V", Const.INTENT_KEY_PKGNAME, "()V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5194l {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lr/l$a;", "", Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: r.l$a */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lr/l$a$a;", "", "<init>", "()V", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lr/l;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/compat/quirk/a;)Lr/l;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: r.l$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final InterfaceC5194l a(androidx.camera.camera2.compat.quirk.a cameraQuirks) {
                kotlin.jvm.internal.p.i(cameraQuirks, "cameraQuirks");
                w0 w0VarB = cameraQuirks.b();
                return (w0VarB.a(ConfigureSurfaceToSecondarySessionFailQuirk.class) || w0VarB.a(PreviewOrientationIncorrectQuirk.class) || w0VarB.a(TextureViewIsClosedQuirk.class)) ? new C5195m() : t.f38714a;
            }

            public Companion() {
            }
        }
    }

    void a(DeferrableSurface deferrableSurface);

    void b();

    void c(int streamId, DeferrableSurface deferrableSurface, CameraGraph graph);
}
