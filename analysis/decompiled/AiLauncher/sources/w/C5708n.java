package w;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00042\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0012"}, d2 = {"Lw/n;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "f", "", "e", "(Ljava/lang/String;)I", "other", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5708n {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw/n$a;", "", "<init>", "()V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public Companion() {
        }
    }

    public /* synthetic */ C5708n(String str) {
        this.value = str;
    }

    public static final /* synthetic */ C5708n a(String str) {
        return new C5708n(str);
    }

    public static String b(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        if (La.H.x0(value)) {
            throw new IllegalArgumentException("CameraId cannot be null or blank!");
        }
        return value;
    }

    public static boolean c(String str, Object obj) {
        return (obj instanceof C5708n) && kotlin.jvm.internal.p.d(str, ((C5708n) obj).getValue());
    }

    public static final boolean d(String str, String str2) {
        return kotlin.jvm.internal.p.d(str, str2);
    }

    public static int e(String str) {
        return str.hashCode();
    }

    public static String f(String str) {
        return "CameraId-" + str;
    }

    public boolean equals(Object obj) {
        return c(this.value, obj);
    }

    /* renamed from: g, reason: from getter */
    public final /* synthetic */ String getValue() {
        return this.value;
    }

    public int hashCode() {
        return e(this.value);
    }

    public String toString() {
        return f(this.value);
    }
}
