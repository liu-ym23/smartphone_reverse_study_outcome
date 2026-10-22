package w;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Lw/t;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(I)I", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Ljava/lang/String;", "f", "other", "", "e", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", Const.INTENT_KEY_PKGNAME, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5713t {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f43036c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f43037d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f43038e;

    /* renamed from: f, reason: collision with root package name */
    public static final List<C5713t> f43039f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lw/t$a;", "", "<init>", "()V", "Lw/t;", "OFF", "I", Const.INTENT_KEY_APIKEY, "()I", "TORCH", Const.INTENT_KEY_PKGNAME, "", "values", "Ljava/util/List;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: w.t$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a() {
            return C5713t.f43036c;
        }

        public final int b() {
            return C5713t.f43038e;
        }

        public Companion() {
        }
    }

    static {
        int iD = d(0);
        f43036c = iD;
        int iD2 = d(1);
        f43037d = iD2;
        int iD3 = d(2);
        f43038e = iD3;
        f43039f = C1173v.p(c(iD), c(iD2), c(iD3));
    }

    public /* synthetic */ C5713t(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ C5713t c(int i10) {
        return new C5713t(i10);
    }

    public static int d(int i10) {
        return i10;
    }

    public static boolean e(int i10, Object obj) {
        return (obj instanceof C5713t) && i10 == ((C5713t) obj).getValue();
    }

    public static int f(int i10) {
        return Integer.hashCode(i10);
    }

    public static String g(int i10) {
        return "FlashMode(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return e(this.value, obj);
    }

    /* renamed from: h, reason: from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    public int hashCode() {
        return f(this.value);
    }

    public String toString() {
        return g(this.value);
    }
}
