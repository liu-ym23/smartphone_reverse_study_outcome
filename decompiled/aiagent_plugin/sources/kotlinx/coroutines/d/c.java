package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.internal.u;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f39236d = null;

    static {
        f39236d = new c();
    }

    @Override // kotlinx.coroutines.ai
    public String toString() {
        return "Dispatchers.Default";
    }

    private c() {
        super(l.f39244c, l.f39245d, l.f39246e, l.f39242a);
    }

    @Override // kotlinx.coroutines.ai
    public ai a(int r2) {
        u.a(r2);
        if (r2 < l.f39244c) goto L7;
        return (ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin");
    L7:
        return super.a(r2);
    }

    @Override // kotlinx.coroutines.d.f, kotlinx.coroutines.bp, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }
}
