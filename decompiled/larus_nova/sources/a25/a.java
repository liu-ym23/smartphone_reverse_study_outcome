package a25;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import du5.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f1412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f1413b = null;

    static {
        f1412a = Collections.synchronizedSet(new HashSet());
        f1413b = Collections.synchronizedSet(new HashSet());
    }

    public static void a(Context r100, String r101, RouteBean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        String r103 = null;
    L6:
        ((h) org.koin.java.a.a(h.class)).R3(r100, r103, r102);
        tt5.a.h("MinutesThreeInOneRedirector", "openRedirectUrl, url: " + b.h(r103));
        return;
    L5:
        r103 = "https://www.doubao.com/docx/" + r101;
        goto L6
    }
}
