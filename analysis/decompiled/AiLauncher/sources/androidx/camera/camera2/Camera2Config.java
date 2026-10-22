package androidx.camera.camera2;

import K.InterfaceC0896t;
import K.O;
import android.content.Context;
import androidx.camera.camera2.pipe.h;
import androidx.camera.core.f;
import androidx.camera.core.impl.UseCaseConfigFactory;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4974f;
import o.C4982n;
import o.C4983o;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/Camera2Config;", "", Const.INTENT_KEY_APIKEY, "DefaultProvider", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2Config {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/Camera2Config$DefaultProvider;", "Landroidx/camera/core/f$b;", "<init>", "()V", "Landroidx/camera/core/f;", "getCameraXConfig", "()Landroidx/camera/core/f;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultProvider implements f.b {
        @Override // androidx.camera.core.f.b
        public f getCameraXConfig() {
            return Camera2Config.INSTANCE.a();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/Camera2Config$a;", "", "<init>", "()V", "Landroidx/camera/core/f;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/core/f;", "Landroidx/camera/camera2/pipe/h;", "sharedCameraPipe", "Landroid/content/Context;", "sharedAppContext", "LK/O;", "sharedThreadConfig", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/h;Landroid/content/Context;LK/O;)Landroidx/camera/core/f;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.Camera2Config$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ f c(Companion companion, h hVar, Context context, O o10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                hVar = null;
            }
            if ((i10 & 2) != 0) {
                context = null;
            }
            if ((i10 & 4) != 0) {
                o10 = null;
            }
            return companion.b(hVar, context, o10);
        }

        public final f a() {
            return c(this, null, null, null, 7, null);
        }

        public final f b(h sharedCameraPipe, Context sharedAppContext, O sharedThreadConfig) {
            f fVarA = new f.a().c(new C4974f(sharedCameraPipe, sharedAppContext, sharedThreadConfig)).d(new InterfaceC0896t.a() { // from class: n.a
                @Override // K.InterfaceC0896t.a
                public final InterfaceC0896t a(Context context, Object obj, Set set) {
                    return new C4982n(context, obj, set);
                }
            }).h(new UseCaseConfigFactory.b() { // from class: n.b
                @Override // androidx.camera.core.impl.UseCaseConfigFactory.b
                public final UseCaseConfigFactory a(Context context) {
                    return new C4983o(context);
                }
            }).e(true).a();
            p.h(fVarA, "build(...)");
            return fVarA;
        }

        public Companion() {
        }
    }
}
