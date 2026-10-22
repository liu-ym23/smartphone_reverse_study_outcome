package androidx.activity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: OnBackPressedCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<b> f146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.core.util.a<Boolean> f147c;

    public abstract void c();

    public c(boolean r2) {
        this.f146b = new CopyOnWriteArrayList();
        this.f145a = r2;
    }

    public final void a(boolean r1) {
        this.f145a = r1;
        androidx.core.util.a<Boolean> r0 = this.f147c;
        if (r0 == null) goto L6;
        r0.accept(Boolean.valueOf(r1));
        return;
    }

    public final boolean a() {
        return this.f145a;
    }

    public final void b() {
        Iterator<b> r3 = this.f146b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin")).a();
        goto L4
    }

    void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f146b.add(r4);
    }

    void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f146b.remove(r4);
    }

    void a(androidx.core.util.a<Boolean> r3) {
        this.f147c = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.util.a.class, "com.obric.aiagent.plugin");
    }
}
