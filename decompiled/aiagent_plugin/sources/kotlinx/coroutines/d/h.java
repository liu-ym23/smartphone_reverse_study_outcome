package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h implements Runnable {
    public long f;
    public i g;

    public h(long r3, i r5) {
        i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r5, i.class, "com.obric.aiagent.plugin");
        this.f = r3;
        this.g = r6;
    }

    public h() {
        this(0, l.g);
    }
}
