package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class de extends CancellationException implements ag<de> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ca f39257a;

    @Override // kotlinx.coroutines.ag
    public /* synthetic */ Throwable a() {
        return (Throwable) ZeusTransformUtils.preCheckCast(b(), Throwable.class, "com.obric.aiagent.plugin");
    }

    public de(String r3, ca r4) {
        ca r5 = (ca) ZeusTransformUtils.wrapperContextForParams(r4, ca.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f39257a = r5;
    }

    public de(String r2) {
        this(r2, null);
    }

    public de b() {
        String r1 = getMessage();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        de r0 = new de(r1, this.f39257a);
        r0.initCause((Throwable) ZeusTransformUtils.preCheckCast(this, Throwable.class, "com.obric.aiagent.plugin"));
        return r0;
    }
}
