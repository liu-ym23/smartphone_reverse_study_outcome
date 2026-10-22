package com.obric.aiagent.executionengine.eventstaskmanager.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16667a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f16668d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16670c;

    /* JADX INFO: compiled from: KnowledgeRepository.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final f a() {
            return f.c();
        }

        public final f a(String r2) {
            return new f(false, r2);
        }
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f16669b == r6.f16669b) goto L12;
        return false;
    L12:
        if (o.a(this.f16670c, r6.f16670c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f16669b) * 31;
        String r1 = this.f16670c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "KnowledgeStatusMessage(ok=" + this.f16669b + ", message=" + this.f16670c + ')';
    }

    public f(boolean r1, String r2) {
        this.f16669b = r1;
        this.f16670c = r2;
    }

    public /* synthetic */ f(boolean r1, String r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ f c() {
        return f16668d;
    }

    public final boolean a() {
        return this.f16669b;
    }

    public final String b() {
        return this.f16670c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f16667a = new a(null);
        Object[] r1 = 0 == true ? 1 : 0;
        f16668d = new f(true, r1, 2, 0 == true ? 1 : 0);
    }
}
