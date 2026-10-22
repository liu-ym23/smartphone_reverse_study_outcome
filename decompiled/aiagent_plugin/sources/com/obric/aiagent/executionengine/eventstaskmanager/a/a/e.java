package com.obric.aiagent.executionengine.eventstaskmanager.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f16665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16666d;

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final <T> e<T> a(T r7) {
            return new e(true, r7, null, 4, null);
        }

        public final <T> e<T> a(String r7) {
            return new e(false, null, r7, 2, null);
        }
    }

    static {
        f16663a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f16664b == r6.f16664b) goto L12;
        return false;
    L12:
        if (o.a(this.f16665c, r6.f16665c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16666d, r6.f16666d) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f16664b) * 31;
        T r1 = this.f16665c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f16666d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "KnowledgeStatusData(ok=" + this.f16664b + ", payload=" + this.f16665c + ", message=" + this.f16666d + ')';
    }

    public e(boolean r1, T r2, String r3) {
        this.f16664b = r1;
        this.f16665c = r2;
        this.f16666d = r3;
    }

    public /* synthetic */ e(boolean r2, Object r3, String r4, int r5, h r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public final boolean a() {
        return this.f16664b;
    }

    public final T b() {
        return this.f16665c;
    }

    public final String c() {
        return this.f16666d;
    }
}
