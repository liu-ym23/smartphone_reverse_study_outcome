package com.obric.autogui.agents.vlm.models.impl.f;

import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: SpeculativeViewTreePrefetcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewHierarchyDump> f27885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27887c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f27885a, r10.f27885a) == true) goto L12;
        return false;
    L12:
        if (this.f27886b == r10.f27886b) goto L15;
        return false;
    L15:
        if (this.f27887c == r10.f27887c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f27885a.hashCode() * 31) + Long.hashCode(this.f27886b)) * 31) + Long.hashCode(this.f27887c);
    }

    public String toString() {
        return "PreExecViewTreeCache(viewTree=" + this.f27885a + ", capturedAt=" + this.f27886b + ", expireMs=" + this.f27887c + ')';
    }

    public a(List<ViewHierarchyDump> r3, long r4, long r6) {
        List<ViewHierarchyDump> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "viewTree");
        this.f27885a = r5;
        this.f27886b = r4;
        this.f27887c = r6;
    }

    public final List<ViewHierarchyDump> a() {
        return this.f27885a;
    }

    public final boolean a(long r5) {
        long r0 = this.f27887c;
        long r6 = r5 - this.f27886b;
        if (0 <= r6) goto L5;
        return false;
    L5:
        if (r6 > r0) goto L9;
        return true;
    L9:
        return false;
    }
}
