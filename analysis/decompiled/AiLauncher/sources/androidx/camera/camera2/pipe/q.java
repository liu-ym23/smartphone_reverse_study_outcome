package androidx.camera.camera2.pipe;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001\u0005J&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/q;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/camera/camera2/pipe/q$a;", "key", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/q$a;)Ljava/lang/Object;", "default", "c", "(Landroidx/camera/camera2/pipe/q$a;Ljava/lang/Object;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface q {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u001d\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/q$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "name", "Lw9/d;", "type", "<init>", "(Ljava/lang/String;Lw9/d;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lw9/d;", "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        public static final Map<String, a<?>> f11069d = new HashMap();

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5745d<?> type;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\b\b\u0001\u0010\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR0\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/q$a$a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "name", "Lw9/d;", "type", "Landroidx/camera/camera2/pipe/q$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lw9/d;)Landroidx/camera/camera2/pipe/q$a;", "", "keys", "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "getKeys$camera_camera2_pipe$annotations", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.camera.camera2.pipe.q$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final <T> a<T> a(String name, InterfaceC5745d<T> type) {
                a<T> aVar;
                kotlin.jvm.internal.p.i(name, "name");
                kotlin.jvm.internal.p.i(type, "type");
                synchronized (b()) {
                    try {
                        Map<String, a<?>> mapB = a.INSTANCE.b();
                        Object aVar2 = mapB.get(name);
                        if (aVar2 == null) {
                            aVar2 = new a(name, type, null);
                            mapB.put(name, aVar2);
                        }
                        aVar = (a) aVar2;
                        if (!kotlin.jvm.internal.p.d(aVar.type, type)) {
                            throw new IllegalStateException("Check failed.");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return aVar;
            }

            public final Map<String, a<?>> b() {
                return a.f11069d;
            }

            public Companion() {
            }
        }

        public /* synthetic */ a(String str, InterfaceC5745d interfaceC5745d, kotlin.jvm.internal.i iVar) {
            this(str, interfaceC5745d);
        }

        public String toString() {
            return "Metadata.Key(" + this.name + ')';
        }

        public a(String str, InterfaceC5745d<?> interfaceC5745d) {
            this.name = str;
            this.type = interfaceC5745d;
        }
    }

    <T> T a(a<T> key);

    <T> T c(a<T> key, T t10);
}
