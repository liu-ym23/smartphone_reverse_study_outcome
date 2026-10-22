package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.internal.al;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final al f39332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f39333b = null;

    public static final /* synthetic */ al a() {
        return f39332a;
    }

    public static /* synthetic */ a a(boolean r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = false;
    L6:
        return a(r0);
    }

    public static final a a(boolean r2) {
        return (a) ZeusTransformUtils.preCheckCast(new b(r2), a.class, "com.obric.aiagent.plugin");
    }

    static {
        f39332a = new al("NO_OWNER");
        f39333b = new al("ALREADY_LOCKED_BY_OWNER");
    }
}
