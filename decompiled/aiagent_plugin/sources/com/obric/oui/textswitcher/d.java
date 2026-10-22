package com.obric.oui.textswitcher;

import android.widget.ViewSwitcher;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f36483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f36484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f36485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f36486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewSwitcher.ViewFactory f36487e;
    private final boolean f;

    public d() {
        this(null, null, null, null, null, false, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36483a, r6.f36483a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36484b, r6.f36484b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36485c, r6.f36485c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f36486d, r6.f36486d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f36487e, r6.f36487e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((((this.f36483a.hashCode() * 31) + this.f36484b.hashCode()) * 31) + this.f36485c.hashCode()) * 31;
        c r1 = this.f36486d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ViewSwitcher.ViewFactory r5 = this.f36487e;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        boolean r7 = this.f;
        ?? r8 = r7;
        if (r7 == false) goto L14;
        r8 = 1;
    L14:
        return r6 + r8;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TextSwitcherSpec(textSpec=" + this.f36483a + ", animationSpec=" + this.f36484b + ", triggerSpec=" + this.f36485c + ", dataSpec=" + this.f36486d + ", viewFactory=" + this.f36487e + ", isSupportMarquee=" + this.f + ')';
    }

    public d(b r3, a r4, e r5, c r6, ViewSwitcher.ViewFactory r7, boolean r8) {
        ViewSwitcher.ViewFactory r9 = (ViewSwitcher.ViewFactory) ZeusTransformUtils.wrapperContextForParams(r7, ViewSwitcher.ViewFactory.class, "com.obric.aiagent.plugin");
        o.e(r3, "textSpec");
        o.e(r4, "animationSpec");
        o.e(r5, "triggerSpec");
        this.f36483a = r3;
        this.f36484b = r4;
        this.f36485c = r5;
        this.f36486d = r6;
        this.f36487e = r9;
        this.f = r8;
    }

    public /* synthetic */ d(b r14, a r15, e r16, c r17, ViewSwitcher.ViewFactory r18, boolean r19, int r20, h r21) {
        ViewSwitcher.ViewFactory r0 = (ViewSwitcher.ViewFactory) ZeusTransformUtils.wrapperContextForParams(r18, ViewSwitcher.ViewFactory.class, "com.obric.aiagent.plugin");
        if ((r20 & 1) == 0) goto L5;
        b r1 = new b(null, null, null, 7, null);
    L7:
        if ((r20 & 2) == 0) goto L9;
        a r2 = new a(null, null, 3, null);
    L11:
        if ((r20 & 4) == 0) goto L13;
        e r4 = new e(0, 0, false, 7, null);
    L15:
        if ((r20 & 8) == 0) goto L17;
        c r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L22;
        r0 = null;
    L22:
        if ((r20 & 32) == 0) goto L24;
        boolean r3 = false;
    L25:
        this(r1, r2, r4, r5, r0, r3);
        return;
    L24:
        r3 = r19;
        goto L25
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }

    public final b a() {
        return this.f36483a;
    }

    public final e b() {
        return this.f36485c;
    }

    public final c c() {
        return this.f36486d;
    }

    public final ViewSwitcher.ViewFactory d() {
        return this.f36487e;
    }

    public final boolean e() {
        return this.f;
    }
}
