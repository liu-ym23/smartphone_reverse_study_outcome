package B;

import Xa.o;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.C5708n;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"LB/f;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "LXa/t;", "LB/f$a;", "b0", "()LXa/t;", "cameraAvailability", "LXa/o;", "LY8/t;", "O", "()LXa/o;", "cameraPriorities", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface f extends AutoCloseable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"LB/f$a;", "", "<init>", "()V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class a {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"LB/f$a$a;", "LB/f$a;", "Lw/n;", "cameraId", "<init>", "(Ljava/lang/String;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: B.f$a$a, reason: collision with other inner class name and from toString */
        public static final class CameraAvailable extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String camera;

            public /* synthetic */ CameraAvailable(String str, kotlin.jvm.internal.i iVar) {
                this(str);
            }

            /* renamed from: a, reason: from getter */
            public final String getCamera() {
                return this.camera;
            }

            public String toString() {
                return "CameraAvailable(camera=" + ((Object) C5708n.f(this.camera)) + ')';
            }

            public CameraAvailable(String cameraId) {
                p.i(cameraId, "cameraId");
                this.camera = cameraId;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LB/f$a$b;", "LB/f$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b extends a {

            /* renamed from: a, reason: collision with root package name */
            public static final b f1400a = new b();

            public String toString() {
                return "CameraPrioritiesChanged";
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"LB/f$a$c;", "LB/f$a;", "Lw/n;", "cameraId", "<init>", "(Ljava/lang/String;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: B.f$a$c, reason: from toString */
        public static final class CameraUnavailable extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String camera;

            public /* synthetic */ CameraUnavailable(String str, kotlin.jvm.internal.i iVar) {
                this(str);
            }

            /* renamed from: a, reason: from getter */
            public final String getCamera() {
                return this.camera;
            }

            public String toString() {
                return "CameraUnavailable(camera=" + ((Object) C5708n.f(this.camera)) + ')';
            }

            public CameraUnavailable(String cameraId) {
                p.i(cameraId, "cameraId");
                this.camera = cameraId;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LB/f$a$d;", "LB/f$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class d extends a {

            /* renamed from: a, reason: collision with root package name */
            public static final d f1402a = new d();

            public String toString() {
                return "UnknownCameraStatus";
            }
        }
    }

    o<t> O();

    Xa.t<a> b0();
}
