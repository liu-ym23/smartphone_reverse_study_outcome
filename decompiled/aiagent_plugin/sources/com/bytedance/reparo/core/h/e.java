package com.bytedance.reparo.core.h;

import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.g;
import com.bytedance.reparo.core.g.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SoPatch.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f9265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f9266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f9267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<k.a> f9268e;
    private g f;
    private com.bytedance.reparo.core.g.a g;

    public e(File r3, File r4, g r5, com.bytedance.reparo.core.g.a r6) {
        com.bytedance.reparo.core.g.a r7 = (com.bytedance.reparo.core.g.a) ZeusTransformUtils.wrapperContextForParams(r6, com.bytedance.reparo.core.g.a.class, "com.obric.aiagent.plugin");
        this.f9267d = r3;
        this.f9265b = r4;
        this.f = r5;
        this.g = r7;
    }

    @Override // com.bytedance.reparo.core.h.a
    public boolean e() {
        if (h().size() > 0) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.reparo.core.a.b.b.d(g()) == true) goto L7;
        return true;
    }

    public File f() {
        return this.f9265b;
    }

    public File g() {
        if (this.f9266c != null) goto L6;
        this.f9266c = this.f.b(this.f9267d, j());
    L6:
        return this.f9266c;
    }

    public List<k.a> h() {
        if (this.f9268e != null) goto L6;
        this.f9268e = k.a(f());
    L6:
        if (this.f9268e != null) goto L9;
        this.f9268e = new ArrayList();
    L9:
        return this.f9268e;
    }

    public boolean i() {
        Iterator<k.a> r3 = h().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (WandTrick.a(((k.a) ZeusTransformUtils.preCheckCast(r3.next(), k.a.class, "com.obric.aiagent.plugin")).f9248a) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String j() {
        return this.g.a();
    }
}
