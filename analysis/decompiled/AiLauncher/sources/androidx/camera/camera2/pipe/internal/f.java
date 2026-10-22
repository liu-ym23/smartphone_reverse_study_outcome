package androidx.camera.camera2.pipe.internal;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import w.H;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081@\u0018\u0000 \u0017*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006\u0018"}, d2 = {"Landroidx/camera/camera2/pipe/internal/f;", ExifInterface.GPS_DIRECTION_TRUE, "", "result", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)I", "other", "", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Z", "available", "f", "failure", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object result;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/pipe/internal/f$a;", "", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.f$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public Companion() {
        }
    }

    public /* synthetic */ f(Object obj) {
        this.result = obj;
    }

    public static final /* synthetic */ f b(Object obj) {
        return new f(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof f) && p.d(obj, ((f) obj2).getResult());
    }

    public static final boolean e(Object obj) {
        return (f(obj) || obj == null) ? false : true;
    }

    public static final boolean f(Object obj) {
        return obj instanceof H;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String h(Object obj) {
        return "OutputResult(result=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.result, obj);
    }

    public int hashCode() {
        return g(this.result);
    }

    /* renamed from: i, reason: from getter */
    public final /* synthetic */ Object getResult() {
        return this.result;
    }

    public String toString() {
        return h(this.result);
    }
}
