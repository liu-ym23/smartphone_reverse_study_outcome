package bb1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f18527a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18528b = 0;

    static {
        s1.f(14.0f);
        f18527a = s1.f(5.0f);
        f18528b = s1.f(12.0f);
    }

    public static final String a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
        Intrinsics.checkNotNullParameter(r101, "params");
        UrlBuilder r102 = new UrlBuilder(r100);
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.addParam((String) r104.getKey(), (String) r104.getValue());
        goto L4
    L7:
        return r102.build();
    }
}
