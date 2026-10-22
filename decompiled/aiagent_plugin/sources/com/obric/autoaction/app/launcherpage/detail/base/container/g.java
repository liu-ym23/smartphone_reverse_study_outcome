package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DetailInstructInfoViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<? extends AutoCondition> f23317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23319e;
    private String f;
    private boolean g;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f23315a == r6.f23315a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23316b, r6.f23316b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23317c, r6.f23317c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23318d, r6.f23318d) == true) goto L21;
        return false;
    L21:
        if (this.f23319e == r6.f23319e) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.f23315a) * 31) + this.f23316b.hashCode()) * 31) + this.f23317c.hashCode()) * 31;
        String r1 = this.f23318d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + Boolean.hashCode(this.f23319e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailInstructInfoDataV2(taskType=" + this.f23315a + ", query=" + this.f23316b + ", conditions=" + this.f23317c + ", shortcutInstruct=" + this.f23318d + ", enable=" + this.f23319e + ", oldQuery=" + this.f + ", showTip=" + this.g + ')';
    }

    public g(int r3, String r4, List<? extends AutoCondition> r5, String r6, boolean r7, String r8, boolean r9) {
        List<? extends AutoCondition> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, DownloadConstants.QUERY_KEY);
        d.h.b.o.e(r10, "conditions");
        d.h.b.o.e(r8, "oldQuery");
        this.f23315a = r3;
        this.f23316b = r4;
        this.f23317c = r10;
        this.f23318d = r6;
        this.f23319e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final int a() {
        return this.f23315a;
    }

    public final String b() {
        return this.f23316b;
    }

    public /* synthetic */ g(int r8, String r9, List r10, String r11, boolean r12, String r13, boolean r14, int r15, d.h.b.h r16) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        String r2 = "";
        if ((r15 & 2) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r15 & 4) == 0) goto L10;
        r0 = d.a.p.b();
    L10:
        if ((r15 & 8) != 0) goto L13;
        r2 = r11;
    L13:
        boolean r4 = false;
        if ((r15 & 16) == 0) goto L16;
        boolean r3 = false;
    L18:
        if ((r15 & 32) == 0) goto L20;
        String r5 = r1;
    L22:
        if ((r15 & 64) != 0) goto L25;
        r4 = r14;
    L25:
        this(r8, r1, r0, r2, r3, r5, r4);
        return;
    L20:
        r5 = r13;
        goto L22
    L16:
        r3 = r12;
        goto L18
    L5:
        r1 = r9;
        goto L7
    }

    public final List<AutoCondition> c() {
        return this.f23317c;
    }

    public final String d() {
        return this.f23318d;
    }

    public final boolean e() {
        return this.f23319e;
    }
}
