package com.obric.autogui.agents.a.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectSnapshotModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0668a f26531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f26534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f26535e;

    /* JADX INFO: renamed from: com.obric.autogui.agents.a.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionEffectSnapshotModels.kt */
    public static final class C0668a {
        public /* synthetic */ C0668a(h r1) {
            this();
        }

        private C0668a() {
        }

        public final a a(List<? extends com.obric.autogui.agents.a.f.c> r7) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            o.e(r6, "detectors");
            Set r8 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin"));
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            boolean r2 = true;
            if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L5;
        L7:
            Iterator r10 = r9.iterator();
        L9:
            if (r10.hasNext() == false) goto L6;
            com.obric.autogui.agents.a.f.c r1 = (com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin");
            if (r1 != com.obric.autogui.agents.a.f.c.f26402a) goto L13;
        L16:
            boolean r3 = true;
        L17:
            if (r3 == false) goto L9;
            boolean r11 = true;
        L19:
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L22;
        L24:
            Iterator r5 = r4.iterator();
        L26:
            if (r5.hasNext() == false) goto L23;
            com.obric.autogui.agents.a.f.c r12 = (com.obric.autogui.agents.a.f.c) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.autogui.agents.a.f.c.class, "com.obric.aiagent.plugin");
            if (r12 != com.obric.autogui.agents.a.f.c.f26403b) goto L30;
        L39:
            boolean r13 = true;
        L40:
            if (r13 == false) goto L26;
        L42:
            return new a(r11, r2, r8.contains(com.obric.autogui.agents.a.f.c.f26405d), r8.contains(com.obric.autogui.agents.a.f.c.g));
        L30:
            if (r12 == com.obric.autogui.agents.a.f.c.f26404c) goto L39;
            if (r12 == com.obric.autogui.agents.a.f.c.f26406e) goto L39;
            if (r12 == com.obric.autogui.agents.a.f.c.f) goto L39;
            if (r12 == com.obric.autogui.agents.a.f.c.f26405d) goto L39;
            r13 = false;
        L23:
            r2 = false;
            goto L42
        L22:
            if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L24;
        L13:
            if (r1 == com.obric.autogui.agents.a.f.c.g) goto L16;
            r3 = false;
        L6:
            r11 = false;
            goto L19
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
            goto L6
        }
    }

    static {
        f26531a = new C0668a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f26532b == r6.f26532b) goto L12;
        return false;
    L12:
        if (this.f26533c == r6.f26533c) goto L15;
        return false;
    L15:
        if (this.f26534d == r6.f26534d) goto L18;
        return false;
    L18:
        if (this.f26535e == r6.f26535e) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f26532b) * 31) + Boolean.hashCode(this.f26533c)) * 31) + Boolean.hashCode(this.f26534d)) * 31) + Boolean.hashCode(this.f26535e);
    }

    public String toString() {
        return "ActionEffectCaptureRequirements(component=" + this.f26532b + ", viewTree=" + this.f26533c + ", image=" + this.f26534d + ", foregroundTask=" + this.f26535e + ')';
    }

    public a(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.f26532b = r1;
        this.f26533c = r2;
        this.f26534d = r3;
        this.f26535e = r4;
    }

    public /* synthetic */ a(boolean r1, boolean r2, boolean r3, boolean r4, int r5, h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public final boolean a() {
        return this.f26532b;
    }

    public final boolean b() {
        return this.f26533c;
    }

    public final boolean c() {
        return this.f26534d;
    }

    public final boolean d() {
        return this.f26535e;
    }
}
