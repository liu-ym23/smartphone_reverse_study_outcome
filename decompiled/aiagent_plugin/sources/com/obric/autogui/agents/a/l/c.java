package com.obric.autogui.agents.a.l;

import android.content.ComponentName;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectSnapshotModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f26542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ViewHierarchyDump> f26543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.a.d.c f26544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f26545e;
    private final boolean f;
    private final int g;

    /* JADX INFO: compiled from: ActionEffectSnapshotModels.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final c a() {
            return new c(null, null, null, null, false, 0, 56, null);
        }

        public final c b() {
            return new c(null, null, null, null, true, 0, 40, null);
        }
    }

    static {
        f26541a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26542b, r6.f26542b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26543c, r6.f26543c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f26544d, r6.f26544d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26545e, r6.f26545e) == true) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L24;
        return false;
    L24:
        if (this.g == r6.g) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        ComponentName r0 = this.f26542b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ViewHierarchyDump> r4 = this.f26543c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.obric.autogui.agents.a.d.c r7 = this.f26544d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        b r10 = this.f26545e;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((((r9 + r1) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g);
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectSnapshot(topComponent=" + this.f26542b + ", viewTree=" + this.f26543c + ", imageFingerprint=" + this.f26544d + ", foregroundTaskFacts=" + this.f26545e + ", isSecure=" + this.f + ", errorCount=" + this.g + ')';
    }

    public c(ComponentName r3, List<ViewHierarchyDump> r4, com.obric.autogui.agents.a.d.c r5, b r6, boolean r7, int r8) {
        List<ViewHierarchyDump> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f26542b = r3;
        this.f26543c = r9;
        this.f26544d = r5;
        this.f26545e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ c(ComponentName r8, List r9, com.obric.autogui.agents.a.d.c r10, b r11, boolean r12, int r13, int r14, h r15) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        b r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        boolean r5 = false;
    L10:
        if ((r14 & 32) == 0) goto L12;
        int r6 = 0;
    L13:
        this(r8, r2, r10, r4, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }

    public final ComponentName a() {
        return this.f26542b;
    }

    public final List<ViewHierarchyDump> b() {
        return this.f26543c;
    }

    public final com.obric.autogui.agents.a.d.c c() {
        return this.f26544d;
    }

    public final b d() {
        return this.f26545e;
    }

    public final boolean e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }
}
