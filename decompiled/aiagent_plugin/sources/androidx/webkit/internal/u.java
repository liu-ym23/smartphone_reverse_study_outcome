package androidx.webkit.internal;

import android.webkit.WebViewRenderProcess;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: WebViewRenderProcessImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends androidx.webkit.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<WebViewRenderProcess, u> f3011b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<WebViewRenderProcess> f3012a;

    static {
        f3011b = new WeakHashMap();
    }

    public u(WebViewRenderProcess r2) {
        this.f3012a = new WeakReference(r2);
    }

    public static u a(WebViewRenderProcess r4) {
        WeakHashMap<WebViewRenderProcess, u> r0 = f3011b;
        u r1 = (u) ZeusTransformUtils.preCheckCast(r0.get(r4), u.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        u r2 = new u(r4);
        r0.put(r4, r2);
        return r2;
    }
}
