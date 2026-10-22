package androidx.camera.camera2.pipe;

import Z8.C1173v;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.pipe.q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.InputRequest;
import w.J;
import w.K;
import w.M;
import w.Q;
import w.w;
import w.x;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014Bq\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 R'\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R'\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010\u00058\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b!\u0010$R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b&\u0010 R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b#\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b%\u0010+¨\u0006,"}, d2 = {"Landroidx/camera/camera2/pipe/t;", "", "", "Lw/Q;", "streams", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "parameters", "Landroidx/camera/camera2/pipe/q$a;", "extras", "Landroidx/camera/camera2/pipe/t$a;", "listeners", "Lw/M;", M5.e.FAIL_TEMPLATE, "Lw/D;", "inputRequest", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Lw/M;Lw/D;Lkotlin/jvm/internal/i;)V", ExifInterface.GPS_DIRECTION_TRUE, "key", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "verbose", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Z)Ljava/lang/String;", "Ljava/util/List;", "f", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "e", "()Ljava/util/Map;", "c", Const.INTENT_KEY_UMID, "Lw/M;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lw/M;", "Lw/D;", "()Lw/D;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<Q> streams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<CaptureRequest.Key<?>, Object> parameters;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<q.a<?>, Object> extras;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<a> listeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final M template;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final InputRequest inputRequest;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J'\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\nJ'\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0017¢\u0006\u0004\b!\u0010\"J/\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010-J\u0017\u0010/\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010-J\u001f\u00100\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u00101ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00062À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/t$a;", "", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/r;", "timestamp", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lw/K;JJ)V", "Lw/x;", "captureResult", "D0", "(Lw/K;JLw/x;)V", "", "progress", "v0", "(Lw/K;I)V", "Lw/w;", "totalCaptureResult", "N0", "(Lw/K;JLw/w;)V", "result", "g0", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "Lw/O;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lw/Q;", "stream", "e", "(Lw/K;JI)V", "streamId", "Lw/G;", "outputId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/K;JII)V", "Landroidx/camera/camera2/pipe/t;", "request", "G", "(Landroidx/camera/camera2/pipe/t;)V", "k0", "(Lw/K;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "I0", "m", "(Lw/K;J)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        default void A(K requestMetadata, long frameNumber, long timestamp) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void D0(K requestMetadata, long frameNumber, x captureResult) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(captureResult, "captureResult");
        }

        default void G(t request) {
            kotlin.jvm.internal.p.i(request, "request");
        }

        default void I0(K requestMetadata) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void N0(K requestMetadata, long frameNumber, w totalCaptureResult) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
        }

        default void V(K requestMetadata) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void Y(K requestMetadata, long frameNumber, J requestFailure) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(requestFailure, "requestFailure");
        }

        default void e(K requestMetadata, long frameNumber, int stream) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void g(K requestMetadata, long frameNumber, long timestamp) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void g0(K requestMetadata, long frameNumber, w result) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(result, "result");
        }

        default void i(K requestMetadata, long frameNumber, int streamId, int outputId) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void k0(K requestMetadata) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void m(K requestMetadata, long frameNumber) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }

        default void v0(K requestMetadata, int progress) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        }
    }

    public /* synthetic */ t(List list, Map map, Map map2, List list2, M m10, InputRequest inputRequest, kotlin.jvm.internal.i iVar) {
        this(list, map, map2, list2, m10, inputRequest);
    }

    public final <T> T a(CaptureRequest.Key<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        return (T) h(key);
    }

    public final Map<q.a<?>, Object> b() {
        return this.extras;
    }

    /* renamed from: c, reason: from getter */
    public final InputRequest getInputRequest() {
        return this.inputRequest;
    }

    public final List<a> d() {
        return this.listeners;
    }

    public final Map<CaptureRequest.Key<?>, Object> e() {
        return this.parameters;
    }

    public final List<Q> f() {
        return this.streams;
    }

    /* renamed from: g, reason: from getter */
    public final M getTemplate() {
        return this.template;
    }

    public final <T> T h(CaptureRequest.Key<T> key) {
        return (T) this.parameters.get(key);
    }

    public final String i(boolean verbose) {
        String str;
        String str2;
        String str3 = "";
        if (this.template == null) {
            str = "";
        } else {
            str = ", template=" + ((Object) M.g(this.template.getValue()));
        }
        if (!verbose || this.parameters.isEmpty()) {
            str2 = "";
        } else {
            str2 = ", parameters=" + z.h.f44503a.e(this.parameters, 5);
        }
        if (verbose && !this.extras.isEmpty()) {
            str3 = ", extras=" + z.h.f44503a.e(this.extras, 5);
        }
        return "Request(streams=" + this.streams + str + str2 + str3 + ")@" + Integer.toHexString(hashCode());
    }

    public String toString() {
        return i(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(List<Q> streams, Map<CaptureRequest.Key<?>, ? extends Object> parameters, Map<q.a<?>, ? extends Object> extras, List<? extends a> listeners, M m10, InputRequest inputRequest) {
        kotlin.jvm.internal.p.i(streams, "streams");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(extras, "extras");
        kotlin.jvm.internal.p.i(listeners, "listeners");
        this.streams = streams;
        this.parameters = parameters;
        this.extras = extras;
        this.listeners = listeners;
        this.template = m10;
        this.inputRequest = inputRequest;
    }

    public /* synthetic */ t(List list, Map map, Map map2, List list2, M m10, InputRequest inputRequest, int i10, kotlin.jvm.internal.i iVar) {
        this(list, (i10 & 2) != 0 ? kotlin.collections.a.i() : map, (i10 & 4) != 0 ? kotlin.collections.a.i() : map2, (i10 & 8) != 0 ? C1173v.m() : list2, (i10 & 16) != 0 ? null : m10, (i10 & 32) != 0 ? null : inputRequest, null);
    }
}
