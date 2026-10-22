package w;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Lw/H;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "other", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class H {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f42899c = g(0);

    /* renamed from: d, reason: collision with root package name */
    public static final int f42900d = g(1);

    /* renamed from: e, reason: collision with root package name */
    public static final int f42901e = g(2);

    /* renamed from: f, reason: collision with root package name */
    public static final int f42902f = g(10);

    /* renamed from: g, reason: collision with root package name */
    public static final int f42903g = g(11);

    /* renamed from: h, reason: collision with root package name */
    public static final int f42904h = g(12);

    /* renamed from: i, reason: collision with root package name */
    public static final int f42905i = g(13);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lw/H$a;", "", "<init>", "()V", "Lw/H;", "AVAILABLE", "I", Const.INTENT_KEY_APIKEY, "()I", ModelFlowMeta.PLAN_UNAVAILABLE, "e", "ERROR_OUTPUT_FAILED", "c", "ERROR_OUTPUT_ABORTED", Const.INTENT_KEY_PKGNAME, "ERROR_OUTPUT_MISSING", Const.INTENT_KEY_UMID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.H$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a() {
            return H.f42900d;
        }

        public final int b() {
            return H.f42903g;
        }

        public final int c() {
            return H.f42902f;
        }

        public final int d() {
            return H.f42904h;
        }

        public final int e() {
            return H.f42901e;
        }

        public Companion() {
        }
    }

    public /* synthetic */ H(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ H f(int i10) {
        return new H(i10);
    }

    public static int g(int i10) {
        return i10;
    }

    public static boolean h(int i10, Object obj) {
        return (obj instanceof H) && i10 == ((H) obj).getValue();
    }

    public static int i(int i10) {
        return Integer.hashCode(i10);
    }

    public static String j(int i10) {
        if (i10 == 0) {
            return "PENDING";
        }
        if (i10 == 1) {
            return "AVAILABLE";
        }
        if (i10 == 2) {
            return ModelFlowMeta.PLAN_UNAVAILABLE;
        }
        switch (i10) {
            case 10:
                return "ERROR_OUTPUT_FAILED";
            case 11:
                return "ERROR_OUTPUT_ABORTED";
            case 12:
                return "ERROR_OUTPUT_MISSING";
            case 13:
                return "ERROR_OUTPUT_DROPPED";
            default:
                return "OutputStatus(value=" + i10 + ')';
        }
    }

    public boolean equals(Object obj) {
        return h(this.value, obj);
    }

    public int hashCode() {
        return i(this.value);
    }

    /* renamed from: k, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public String toString() {
        return j(this.value);
    }
}
