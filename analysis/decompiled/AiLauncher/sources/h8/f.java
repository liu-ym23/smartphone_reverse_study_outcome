package h8;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\b\u0010\f¨\u0006\u000e"}, d2 = {"Lh8/f;", "", "<init>", "()V", "", "businessTag", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getBaseTag", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "baseTag", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f32973a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static volatile String baseTag = "";

    public final String a(String businessTag) {
        String string = businessTag != null ? H.D1(businessTag).toString() : null;
        if (string == null) {
            string = "";
        }
        String str = baseTag;
        if (str.length() == 0) {
            return string.length() == 0 ? "logbox" : string;
        }
        if (string.length() == 0) {
            return str;
        }
        return str + "/" + string;
    }

    public final void b(String str) {
        p.i(str, "<set-?>");
        baseTag = str;
    }
}
