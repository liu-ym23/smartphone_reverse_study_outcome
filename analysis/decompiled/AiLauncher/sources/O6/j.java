package O6;

import La.D;
import Z8.C1173v;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"LO6/j;", "", "<init>", "()V", "", "url", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "HTTP_PREFIX", "Ljava/lang/String;", "", "HTTPS_UPGRADE_SUFFIXES", "Ljava/util/List;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    private static final String HTTP_PREFIX = "http://";
    public static final j INSTANCE = new j();
    private static final List<String> HTTPS_UPGRADE_SUFFIXES = C1173v.p("smzdm.com", "alicdn.com", "360buyimg.com", "pddpic.com", "pddugc.com", "yangkeduo.com", "vpimg2.com", "vpimg3.com", "vpimg4.com");

    public static final String a(String url) {
        Object objB;
        if (url != null && url.length() != 0 && D.V(url, HTTP_PREFIX, true)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Uri.parse(url).getHost());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            String str = (String) objB;
            if (str != null) {
                List<String> list = HTTPS_UPGRADE_SUFFIXES;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return url;
                }
                for (String str2 : list) {
                    if (!kotlin.jvm.internal.p.d(str, str2)) {
                        if (D.K(str, "." + str2, false, 2, null)) {
                        }
                    }
                    String strSubstring = url.substring(7);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    return "https://" + strSubstring;
                }
                return url;
            }
        }
        return url;
    }
}
