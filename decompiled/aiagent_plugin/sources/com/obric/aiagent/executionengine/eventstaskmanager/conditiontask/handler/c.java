package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConditionRegisterTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17055d;

    /* JADX INFO: compiled from: ConditionRegisterTrace.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ c a(a r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            return r0.a(r1);
        }

        public final c a(int r7) {
            return new c(0, null, r7, 2, null);
        }

        public static /* synthetic */ c a(a r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = 0;
        L6:
            return r0.a(r1, r2);
        }

        public final c a(String r2, int r3) {
            return new c(1, r2, r3);
        }
    }

    static {
        f17052a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f17053b == r6.f17053b) goto L12;
        return false;
    L12:
        if (o.a(this.f17054c, r6.f17054c) == true) goto L15;
        return false;
    L15:
        if (this.f17055d == r6.f17055d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f17053b) * 31;
        String r1 = this.f17054c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Integer.hashCode(this.f17055d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ConditionRegisterTrace(resultCode=" + this.f17053b + ", errorMessage=" + this.f17054c + ", retryCount=" + this.f17055d + ')';
    }

    public c(int r1, String r2, int r3) {
        this.f17053b = r1;
        this.f17054c = r2;
        this.f17055d = r3;
    }

    public /* synthetic */ c(int r1, String r2, int r3, int r4, h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public final int a() {
        return this.f17053b;
    }

    public final String b() {
        return this.f17054c;
    }

    public final int c() {
        return this.f17055d;
    }

    public final boolean d() {
        if (this.f17053b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final c a(c r15) {
        o.e(r15, "other");
        int r2 = 0;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(p.e(new String[]{this.f17054c, r15.f17054c}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r5 = r3.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r1.add(r5);
        goto L4
    L8:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(p.a((Iterable) ZeusTransformUtils.preCheckCast(p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("; ", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r4) == false) goto L11;
        r4 = null;
    L11:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        if (d() == true) goto L14;
    L16:
        r2 = 1;
    L18:
        return new c(r2, r6, this.f17055d + r15.f17055d);
    L14:
        if (r15.d() == false) goto L16;
        goto L16
    }
}
