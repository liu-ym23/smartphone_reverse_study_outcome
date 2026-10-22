package androidx.camera.camera2.pipe.compat;

import Ua.InterfaceC1083u;
import Ua.M;
import Ua.Q;
import Z8.F;
import android.util.Log;
import androidx.camera.camera2.pipe.core.PruningProcessingQueue;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;
import w.AbstractC5689A;
import w.C5706l;
import w.C5708n;
import x.AbstractC5822j0;
import x.C0;
import x.C5806b0;
import x.G0;
import x.K0;
import x.RequestClose;
import x.RequestCloseById;
import x.RequestOpen;
import x.W;
import x.X;
import z.z;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0003GDJB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b \u0010!J \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b&\u0010'JB\u00100\u001a\u00020/2\u0006\u0010#\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0(2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+0*2\u0006\u0010.\u001a\u00020-H\u0082@¢\u0006\u0004\b0\u00101J\u001e\u00104\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\"02H\u0082@¢\u0006\u0004\b4\u00105J\u001e\u00108\u001a\u00020\u000f2\f\u00107\u001a\b\u0012\u0004\u0012\u0002060(H\u0082@¢\u0006\u0004\b8\u00109J3\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000(\"\u0004\b\u0000\u0010:*\b\u0012\u0004\u0012\u00028\u00000;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<02H\u0002¢\u0006\u0004\b>\u0010?JK\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010#\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0(2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+0*H\u0016¢\u0006\u0004\bD\u0010EJ\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0F2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bG\u0010HJ\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0F2\u0006\u0010I\u001a\u00020+H\u0016¢\u0006\u0004\bJ\u0010KJ\u001d\u0010M\u001a\u00020\u000f2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000e0;H\u0001¢\u0006\u0004\bM\u0010NR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010OR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010PR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010QR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000e0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020_0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u0002060;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager;", "Lx/X;", "Lz/m;", "permissions", "Lx/G0;", "retryingCameraStateOpener", "Lx/W;", "camera2DeviceCloser", "Lx/b0;", "camera2ErrorProcessor", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(Lz/m;Lx/G0;Lx/W;Lx/b0;Landroidx/camera/camera2/pipe/core/Threads;)V", "Lx/j0;", "LY8/t;", "q", "(Lx/j0;)V", "request", "t", "(Lx/j0;Le9/c;)Ljava/lang/Object;", "Lx/E0;", "x", "(Lx/E0;Le9/c;)Ljava/lang/Object;", "Lx/B0;", "u", "(Lx/B0;Le9/c;)Ljava/lang/Object;", "Lx/D0;", "w", "(Lx/D0;Le9/c;)Ljava/lang/Object;", "Lx/C0;", "requestCloseAll", "v", "(Lx/C0;Le9/c;)Ljava/lang/Object;", "Lw/n;", "cameraId", "requestOpen", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c;", "C", "(Ljava/lang/String;Lx/E0;Le9/c;)Ljava/lang/Object;", "", "sharedCameraIds", "Lkotlin/Function1;", "", "isForegroundObserver", "LUa/M;", "scope", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a;", "r", "(Ljava/lang/String;Ljava/util/List;Lp9/l;LUa/M;Le9/c;)Ljava/lang/Object;", "", "cameraIds", "o", "(Ljava/util/Set;Le9/c;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$b;", "pendingRequestOpensToDisconnect", "p", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "indices", "B", "(Ljava/util/List;Ljava/util/Set;)Ljava/util/List;", "LA/e;", "graphListener", "isPrewarm", "Lx/K0;", "c", "(Ljava/lang/String;Ljava/util/List;LA/e;ZLp9/l;)Lx/K0;", "LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LUa/Q;", "forceCancelOpen", Const.INTENT_KEY_APIKEY, "(Z)LUa/Q;", "requests", "y", "(Ljava/util/List;)V", "Lz/m;", "Lx/G0;", "Lx/W;", Const.INTENT_KEY_UMID, "Lx/b0;", "e", "Landroidx/camera/camera2/pipe/core/Threads;", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "f", "LUa/M;", "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/core/PruningProcessingQueue;", "queue", "", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Set;", "activeCameras", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/List;", "pendingRequestOpens", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PruningCamera2DeviceManager implements X {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z.m permissions;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final G0 retryingCameraStateOpener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final W camera2DeviceCloser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5806b0 camera2ErrorProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final PruningProcessingQueue<AbstractC5822j0> queue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Set<ActiveCamera> activeCameras;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final List<b> pendingRequestOpens;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a$a;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a$a;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a;", "Lw/l;", "lastCameraError", "<init>", "(Lw/l;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lw/l;", "()Lw/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$a, reason: collision with other inner class name and from toString */
        public static final /* data */ class Error implements a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final C5706l lastCameraError;

            public /* synthetic */ Error(C5706l c5706l, kotlin.jvm.internal.i iVar) {
                this(c5706l);
            }

            /* renamed from: a, reason: from getter */
            public final C5706l getLastCameraError() {
                return this.lastCameraError;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && kotlin.jvm.internal.p.d(this.lastCameraError, ((Error) other).lastCameraError);
            }

            public int hashCode() {
                C5706l c5706l = this.lastCameraError;
                if (c5706l == null) {
                    return 0;
                }
                return C5706l.s(c5706l.getValue());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }

            public Error(C5706l c5706l) {
                this.lastCameraError = c5706l;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a$b;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$a;", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "activeCamera", "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$b, reason: from toString */
        public static final /* data */ class Success implements a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final ActiveCamera activeCamera;

            public Success(ActiveCamera activeCamera) {
                kotlin.jvm.internal.p.i(activeCamera, "activeCamera");
                this.activeCamera = activeCamera;
            }

            /* renamed from: a, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && kotlin.jvm.internal.p.d(this.activeCamera, ((Success) other).activeCamera);
            }

            public int hashCode() {
                return this.activeCamera.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ')';
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\n\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$b;", "", "Lx/E0;", "request", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "activeCamera", "Lz/z;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Lx/E0;Landroidx/camera/camera2/pipe/compat/ActiveCamera;Lz/z;)V", Const.INTENT_KEY_APIKEY, "Lx/E0;", Const.INTENT_KEY_PKGNAME, "()Lx/E0;", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "c", "Lz/z;", "()Lz/z;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final RequestOpen request;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final ActiveCamera activeCamera;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final z token;

        public b(RequestOpen request, ActiveCamera activeCamera, z token) {
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(activeCamera, "activeCamera");
            kotlin.jvm.internal.p.i(token, "token");
            this.request = request;
            this.activeCamera = activeCamera;
            this.token = token;
        }

        /* renamed from: a, reason: from getter */
        public final ActiveCamera getActiveCamera() {
            return this.activeCamera;
        }

        /* renamed from: b, reason: from getter */
        public final RequestOpen getRequest() {
            return this.request;
        }

        /* renamed from: c, reason: from getter */
        public final z getToken() {
            return this.token;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c$a;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface c {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c$a;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c;", "Lw/l;", "lastCameraError", "<init>", "(Lw/l;Lkotlin/jvm/internal/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lw/l;", "()Lw/l;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$c$a, reason: from toString */
        public static final /* data */ class Error implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final C5706l lastCameraError;

            public /* synthetic */ Error(C5706l c5706l, kotlin.jvm.internal.i iVar) {
                this(c5706l);
            }

            /* renamed from: a, reason: from getter */
            public final C5706l getLastCameraError() {
                return this.lastCameraError;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && kotlin.jvm.internal.p.d(this.lastCameraError, ((Error) other).lastCameraError);
            }

            public int hashCode() {
                C5706l c5706l = this.lastCameraError;
                if (c5706l == null) {
                    return 0;
                }
                return C5706l.s(c5706l.getValue());
            }

            public String toString() {
                return "Error(lastCameraError=" + this.lastCameraError + ')';
            }

            public Error(C5706l c5706l) {
                this.lastCameraError = c5706l;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c$b;", "Landroidx/camera/camera2/pipe/compat/PruningCamera2DeviceManager$c;", "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "activeCamera", "Lz/z;", M5.b.CREDENTIAL_TOKEN, "<init>", "(Landroidx/camera/camera2/pipe/compat/ActiveCamera;Lz/z;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/ActiveCamera;", "()Landroidx/camera/camera2/pipe/compat/ActiveCamera;", Const.INTENT_KEY_PKGNAME, "Lz/z;", "()Lz/z;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$c$b, reason: from toString */
        public static final /* data */ class Success implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final ActiveCamera activeCamera;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            public final z token;

            public Success(ActiveCamera activeCamera, z token) {
                kotlin.jvm.internal.p.i(activeCamera, "activeCamera");
                kotlin.jvm.internal.p.i(token, "token");
                this.activeCamera = activeCamera;
                this.token = token;
            }

            /* renamed from: a, reason: from getter */
            public final ActiveCamera getActiveCamera() {
                return this.activeCamera;
            }

            /* renamed from: b, reason: from getter */
            public final z getToken() {
                return this.token;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return kotlin.jvm.internal.p.d(this.activeCamera, success.activeCamera) && kotlin.jvm.internal.p.d(this.token, success.token);
            }

            public int hashCode() {
                return (this.activeCamera.hashCode() * 31) + this.token.hashCode();
            }

            public String toString() {
                return "Success(activeCamera=" + this.activeCamera + ", token=" + this.token + ')';
            }
        }
    }

    public PruningCamera2DeviceManager(z.m permissions, G0 retryingCameraStateOpener, W camera2DeviceCloser, C5806b0 camera2ErrorProcessor, Threads threads) {
        kotlin.jvm.internal.p.i(permissions, "permissions");
        kotlin.jvm.internal.p.i(retryingCameraStateOpener, "retryingCameraStateOpener");
        kotlin.jvm.internal.p.i(camera2DeviceCloser, "camera2DeviceCloser");
        kotlin.jvm.internal.p.i(camera2ErrorProcessor, "camera2ErrorProcessor");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.permissions = permissions;
        this.retryingCameraStateOpener = retryingCameraStateOpener;
        this.camera2DeviceCloser = camera2DeviceCloser;
        this.camera2ErrorProcessor = camera2ErrorProcessor;
        this.threads = threads;
        M cameraPipeScope = threads.getCameraPipeScope();
        this.scope = cameraPipeScope;
        this.queue = PruningProcessingQueue.INSTANCE.a(new PruningProcessingQueue(0, new PruningCamera2DeviceManager$queue$1(this), null, new PruningCamera2DeviceManager$queue$2(this, null), 5, null), cameraPipeScope);
        this.activeCameras = new LinkedHashSet();
        this.pendingRequestOpens = new ArrayList();
    }

    public static final Y8.t A(AbstractC5822j0 abstractC5822j0, Throwable th) {
        InterfaceC1083u<Y8.t> interfaceC1083uB = ((RequestCloseById) abstractC5822j0).b();
        Y8.t tVar = Y8.t.f7040a;
        interfaceC1083uB.complete(tVar);
        return tVar;
    }

    public static final Y8.t s(PruningCamera2DeviceManager pruningCamera2DeviceManager, ActiveCamera activeCamera) {
        kotlin.jvm.internal.p.i(activeCamera, "activeCamera");
        pruningCamera2DeviceManager.queue.p(new RequestClose(activeCamera));
        return Y8.t.f7040a;
    }

    public static final Y8.t z(InterfaceC1083u interfaceC1083u, Throwable th) {
        Y8.t tVar = Y8.t.f7040a;
        interfaceC1083u.complete(tVar);
        return tVar;
    }

    public final <T> List<T> B(List<T> list, Set<Integer> set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = F.b1(set).iterator();
        while (it.hasNext()) {
            arrayList.add(list.remove(((Number) it.next()).intValue() - arrayList.size()));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        r0 = r15.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        r15.f();
        r11.f10566a = r7;
        r11.f10567b = r13;
        r11.f10568c = r14;
        r11.f10569d = r15;
        r11.f10572g = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        if (r15.e(r11) != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        r2 = r13;
        r13 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0093 -> B:28:0x0095). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r13, x.RequestOpen r14, e9.InterfaceC4014c<? super androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.c> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.C(java.lang.String, x.E0, e9.c):java.lang.Object");
    }

    @Override // x.X
    public Q<Y8.t> a(boolean forceCancelOpen) {
        if (forceCancelOpen) {
            this.retryingCameraStateOpener.c();
        }
        C0 c02 = new C0();
        if (!this.queue.p(c02)) {
            if (z.k.f44508a.b()) {
                Log.e("CXCP", "Camera close all request failed!");
            }
            c02.a().complete(Y8.t.f7040a);
        }
        return c02.a();
    }

    @Override // x.X
    public Q<Y8.t> b(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        RequestCloseById requestCloseById = new RequestCloseById(cameraId, null);
        if (!this.queue.p(requestCloseById)) {
            if (z.k.f44508a.b()) {
                Log.e("CXCP", "Camera close by ID request failed for " + ((Object) C5708n.f(cameraId)) + '!');
            }
            requestCloseById.b().complete(Y8.t.f7040a);
        }
        return requestCloseById.b();
    }

    @Override // x.X
    public K0 c(String cameraId, List<C5708n> sharedCameraIds, A.e graphListener, boolean isPrewarm, InterfaceC5074l<? super Y8.t, Boolean> isForegroundObserver) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(sharedCameraIds, "sharedCameraIds");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(isForegroundObserver, "isForegroundObserver");
        VirtualCameraState virtualCameraState = new VirtualCameraState(cameraId, graphListener, this.scope, null);
        if (this.queue.p(new RequestOpen(virtualCameraState, sharedCameraIds, graphListener, isPrewarm, isForegroundObserver))) {
            return virtualCameraState;
        }
        if (z.k.f44508a.b()) {
            Log.e("CXCP", "Camera open request failed for " + ((Object) C5708n.f(cameraId)) + '!');
        }
        graphListener.c(new AbstractC5689A.a(C5706l.INSTANCE.i(), false, null));
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        throw new java.lang.IllegalStateException("Check failed.");
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0110 -> B:46:0x0113). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.util.Set<w.C5708n> r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.o(java.util.Set, e9.c):java.lang.Object");
    }

    public final Object p(List<b> list, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        for (b bVar : list) {
            bVar.getToken().release();
            this.pendingRequestOpens.remove(bVar);
        }
        return Y8.t.f7040a;
    }

    public final void q(AbstractC5822j0 abstractC5822j0) {
        if (abstractC5822j0 instanceof RequestOpen) {
            K0.a(((RequestOpen) abstractC5822j0).getVirtualCamera(), null, 1, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r5, java.util.List<w.C5708n> r6, p9.InterfaceC5074l<? super Y8.t, java.lang.Boolean> r7, Ua.M r8, e9.InterfaceC4014c<? super androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.a> r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$openCameraWithRetry$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$openCameraWithRetry$1 r0 = (androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$openCameraWithRetry$1) r0
            int r1 = r0.f10542f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10542f = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$openCameraWithRetry$1 r0 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$openCameraWithRetry$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.f10540d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10542f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f10539c
            r8 = r5
            Ua.M r8 = (Ua.M) r8
            java.lang.Object r5 = r0.f10538b
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = r0.f10537a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)
            goto L7c
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.C4849c.b(r9)
            z.k r9 = z.k.f44508a
            boolean r9 = r9.a()
            if (r9 == 0) goto L69
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "Opening "
            r9.append(r2)
            java.lang.String r2 = w.C5708n.f(r5)
            r9.append(r2)
            java.lang.String r2 = " with retries..."
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            java.lang.String r2 = "CXCP"
            android.util.Log.d(r2, r9)
        L69:
            x.G0 r9 = r4.retryingCameraStateOpener
            x.W r2 = r4.camera2DeviceCloser
            r0.f10537a = r5
            r0.f10538b = r6
            r0.f10539c = r8
            r0.f10542f = r3
            java.lang.Object r9 = r9.f(r5, r2, r7, r0)
            if (r9 != r1) goto L7c
            return r1
        L7c:
            x.v0 r9 = (x.OpenCameraResult) r9
            androidx.camera.camera2.pipe.compat.AndroidCameraState r7 = r9.getCameraState()
            if (r7 != 0) goto L8f
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$a r4 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$a
            w.l r5 = r9.getErrorCode()
            r6 = 0
            r4.<init>(r5, r6)
            return r4
        L8f:
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$b r7 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$a$b
            androidx.camera.camera2.pipe.compat.ActiveCamera r0 = new androidx.camera.camera2.pipe.compat.ActiveCamera
            androidx.camera.camera2.pipe.compat.AndroidCameraState r9 = r9.getCameraState()
            java.util.Collection r6 = (java.util.Collection) r6
            w.n r5 = w.C5708n.a(r5)
            java.util.List r5 = Z8.F.T0(r6, r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r5 = Z8.F.r1(r5)
            x.A0 r6 = new x.A0
            r6.<init>()
            r0.<init>(r9, r5, r8, r6)
            r7.<init>(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.r(java.lang.String, java.util.List, p9.l, Ua.M, e9.c):java.lang.Object");
    }

    public final Object t(AbstractC5822j0 abstractC5822j0, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        if (abstractC5822j0 instanceof RequestOpen) {
            Object objX = x((RequestOpen) abstractC5822j0, interfaceC4014c);
            return objX == C4063a.g() ? objX : Y8.t.f7040a;
        }
        if (abstractC5822j0 instanceof RequestClose) {
            Object objU = u((RequestClose) abstractC5822j0, interfaceC4014c);
            return objU == C4063a.g() ? objU : Y8.t.f7040a;
        }
        if (abstractC5822j0 instanceof RequestCloseById) {
            Object objW = w((RequestCloseById) abstractC5822j0, interfaceC4014c);
            return objW == C4063a.g() ? objW : Y8.t.f7040a;
        }
        if (!(abstractC5822j0 instanceof C0)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objV = v((C0) abstractC5822j0, interfaceC4014c);
        return objV == C4063a.g() ? objV : Y8.t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d1, code lost:
    
        if (r8.e(r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(x.RequestClose r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1 r0 = (androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1) r0
            int r1 = r0.f10546d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10546d = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1 r0 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestClose$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f10544b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10546d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.C4849c.b(r10)
            goto Ld4
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.f10543a
            r9 = r8
            x.B0 r9 = (x.RequestClose) r9
            kotlin.C4849c.b(r10)
            goto Lbd
        L3f:
            kotlin.C4849c.b(r10)
            androidx.camera.camera2.pipe.compat.ActiveCamera r10 = r9.getActiveCamera()
            java.lang.String r10 = r10.i()
            z.k r2 = z.k.f44508a
            boolean r2 = r2.c()
            if (r2 == 0) goto L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "PruningCamera2DeviceManager#processRequestClose("
            r2.append(r5)
            java.lang.String r10 = w.C5708n.f(r10)
            r2.append(r10)
            r10 = 41
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            java.lang.String r2 = "CXCP"
            android.util.Log.i(r2, r10)
        L71:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r10 = r8.activeCameras
            androidx.camera.camera2.pipe.compat.ActiveCamera r2 = r9.getActiveCamera()
            boolean r10 = r10.contains(r2)
            if (r10 == 0) goto L86
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r10 = r8.activeCameras
            androidx.camera.camera2.pipe.compat.ActiveCamera r2 = r9.getActiveCamera()
            r10.remove(r2)
        L86:
            java.util.List<androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$b> r10 = r8.pendingRequestOpens
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r10 = r10.iterator()
        L93:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto Lb2
            java.lang.Object r5 = r10.next()
            r6 = r5
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$b r6 = (androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.b) r6
            androidx.camera.camera2.pipe.compat.ActiveCamera r6 = r6.getActiveCamera()
            androidx.camera.camera2.pipe.compat.ActiveCamera r7 = r9.getActiveCamera()
            boolean r6 = kotlin.jvm.internal.p.d(r6, r7)
            if (r6 == 0) goto L93
            r2.add(r5)
            goto L93
        Lb2:
            r0.f10543a = r9
            r0.f10546d = r4
            java.lang.Object r8 = r8.p(r2, r0)
            if (r8 != r1) goto Lbd
            goto Ld3
        Lbd:
            androidx.camera.camera2.pipe.compat.ActiveCamera r8 = r9.getActiveCamera()
            r8.f()
            androidx.camera.camera2.pipe.compat.ActiveCamera r8 = r9.getActiveCamera()
            r9 = 0
            r0.f10543a = r9
            r0.f10546d = r3
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r1) goto Ld4
        Ld3:
            return r1
        Ld4:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.u(x.B0, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (p(r7, r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(x.C0 r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1 r0 = (androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1) r0
            int r1 = r0.f10551e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10551e = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1 r0 = new androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$processRequestCloseAll$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f10549c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10551e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f10548b
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.f10547a
            x.C0 r2 = (x.C0) r2
            kotlin.C4849c.b(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            java.lang.Object r6 = r0.f10547a
            x.C0 r6 = (x.C0) r6
            kotlin.C4849c.b(r7)
            goto L63
        L44:
            kotlin.C4849c.b(r7)
            z.k r7 = z.k.f44508a
            boolean r7 = r7.c()
            if (r7 == 0) goto L56
            java.lang.String r7 = "CXCP"
            java.lang.String r2 = "PruningCamera2DeviceManager#processRequestCloseAll()"
            android.util.Log.i(r7, r2)
        L56:
            java.util.List<androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$b> r7 = r5.pendingRequestOpens
            r0.f10547a = r6
            r0.f10551e = r4
            java.lang.Object r7 = r5.p(r7, r0)
            if (r7 != r1) goto L63
            goto L99
        L63:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r7 = r5.activeCameras
            java.util.Iterator r7 = r7.iterator()
        L69:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r7.next()
            androidx.camera.camera2.pipe.compat.ActiveCamera r2 = (androidx.camera.camera2.pipe.compat.ActiveCamera) r2
            r2.f()
            goto L69
        L79:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r7 = r5.activeCameras
            java.util.Iterator r7 = r7.iterator()
            r2 = r6
            r6 = r7
        L81:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L9a
            java.lang.Object r7 = r6.next()
            androidx.camera.camera2.pipe.compat.ActiveCamera r7 = (androidx.camera.camera2.pipe.compat.ActiveCamera) r7
            r0.f10547a = r2
            r0.f10548b = r6
            r0.f10551e = r3
            java.lang.Object r7 = r7.e(r0)
            if (r7 != r1) goto L81
        L99:
            return r1
        L9a:
            java.util.Set<androidx.camera.camera2.pipe.compat.ActiveCamera> r5 = r5.activeCameras
            r5.clear()
            Ua.u r5 = r2.a()
            Y8.t r6 = Y8.t.f7040a
            r5.complete(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.v(x.C0, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(x.RequestCloseById r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.w(x.D0, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02cf, code lost:
    
        if (o(r11, r0) != r1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02f0, code lost:
    
        if (r12.g(r10, r0, r2) == r1) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016d A[LOOP:3: B:49:0x0167->B:51:0x016d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(x.RequestOpen r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.x(x.E0, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.util.List<x.AbstractC5822j0> r18) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager.y(java.util.List):void");
    }
}
