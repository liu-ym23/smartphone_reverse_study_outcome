package com.obric.eventkit;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f33220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33221c;

    /* JADX INFO: compiled from: TaskKnowledgeApiModels.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f33219a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f33220b == r6.f33220b) goto L12;
        return false;
    L12:
        if (o.a(this.f33221c, r6.f33221c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f33220b) * 31;
        String r1 = this.f33221c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TaskKnowledgeStatusMessage(ok=" + this.f33220b + ", message=" + this.f33221c + ')';
    }

    public g(boolean r1, String r2) {
        this.f33220b = r1;
        this.f33221c = r2;
    }

    public final boolean a() {
        return this.f33220b;
    }

    public final String b() {
        return this.f33221c;
    }
}
