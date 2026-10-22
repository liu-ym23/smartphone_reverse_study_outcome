package androidx.activity.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ContextAwareHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b> f143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f144b;

    public a() {
        this.f143a = new CopyOnWriteArraySet();
    }

    public Context a() {
        return this.f144b;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (this.f144b == null) goto L5;
        r4.onContextAvailable(this.f144b);
    L5:
        this.f143a.add(r4);
    }

    public void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f143a.remove(r4);
    }

    public void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f144b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        Iterator<b> r3 = this.f143a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin")).onContextAvailable(r5);
        goto L4
    }

    public void b() {
        this.f144b = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
    }
}
