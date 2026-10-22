package defpackage;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: ActivityResultHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f0a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, n<?>> f1b = null;

    private a() {
    }

    static {
        f0a = new a();
        f1b = new ConcurrentHashMap();
    }

    public final <T> void a(String r6, T r7) {
        o.e(r6, "key");
        n r5 = (n) ZeusTransformUtils.preCheckCast(f1b.remove(r6), n.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d("ActivityResultHolder", "complete key " + r6);
        if (r5 != null) goto L5;
        Loog.INSTANCE.d("ActivityResultHolder", "complete key not found: " + r6);
    L5:
        n r8 = null;
        if (r5 != null) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.a() == false) goto L12;
        r8 = r5;
    L12:
        if (r8 == null) goto L16;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(r7));
        return;
    }
}
