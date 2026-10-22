package w;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lw/M;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(I)I", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Ljava/lang/String;", "f", "other", "", "c", "(ILjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", "getValue", "()I", "e", "name", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class M {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int value;

    public /* synthetic */ M(int i10) {
        this.value = i10;
    }

    public static final /* synthetic */ M a(int i10) {
        return new M(i10);
    }

    public static int b(int i10) {
        return i10;
    }

    public static boolean c(int i10, Object obj) {
        return (obj instanceof M) && i10 == ((M) obj).getValue();
    }

    public static final boolean d(int i10, int i11) {
        return i10 == i11;
    }

    public static final String e(int i10) {
        switch (i10) {
            case 1:
                return "TEMPLATE_PREVIEW";
            case 2:
                return "TEMPLATE_STILL_CAPTURE";
            case 3:
                return "TEMPLATE_RECORD";
            case 4:
                return "TEMPLATE_VIDEO_SNAPSHOT";
            case 5:
                return "TEMPLATE_ZERO_SHUTTER_LAG";
            case 6:
                return "TEMPLATE_MANUAL";
            default:
                return "UNKNOWN-" + i10;
        }
    }

    public static int f(int i10) {
        return Integer.hashCode(i10);
    }

    public static String g(int i10) {
        return "RequestTemplate(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.value, obj);
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
