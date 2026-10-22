package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class cm extends ai {
    public abstract cm a();

    public cm() {
    }

    @Override // kotlinx.coroutines.ai
    public String toString() {
        String r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ar.b(this) + '@' + ar.a(this);
    }

    @Override // kotlinx.coroutines.ai
    public ai a(int r2) {
        kotlinx.coroutines.internal.u.a(r2);
        return (ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin");
    }

    public final String b() {
        cm r0 = bd.b();
        if (this != r0) goto L14;
        return "Dispatchers.Main";
    L14:
        cm r1 = r0.a();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r1) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r1 = null;
        goto L10
    }
}
