package com.bytedance.bdinstall.j;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.ag;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.as;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TimeoutInstallListener.java */
/* JADX INFO: loaded from: classes.dex */
public class w implements ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private as f6347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f6348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private an f6349d;

    static /* synthetic */ as a(w r0) {
        return r0.f6347b;
    }

    static /* synthetic */ as a(w r2, as r3) {
        as r4 = (as) ZeusTransformUtils.wrapperContextForParams(r3, as.class, "com.obric.aiagent.plugin");
        r2.f6347b = r4;
        return r4;
    }

    static /* synthetic */ void b(w r0) {
        r0.b();
    }

    public w(long r3, as r5, an r6) {
        as r7 = (as) ZeusTransformUtils.wrapperContextForParams(r5, as.class, "com.obric.aiagent.plugin");
        this.f6348c = new Handler(Looper.getMainLooper());
        this.f6346a = r3;
        this.f6347b = r7;
        this.f6349d = r6;
    }

    @Override // com.bytedance.bdinstall.ag
    public void a(final am r3) {
        this.f6348c.post(new AnonymousClass1(this, r3));
    }

    public void a() {
        this.f6348c.postDelayed(new AnonymousClass2(this), this.f6346a);
    }

    private void b() {
        an r0 = this.f6349d;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.bdinstall.i.a(this);
        return;
    L5:
        if (r0.o() == true) goto L8;
        com.bytedance.bdinstall.i.a(String.valueOf(this.f6349d.a())).a(this);
    }
}
