package com.obric.autogui.agents.a;

import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectPipeline.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScreenshotResult f26349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ViewHierarchyDump> f26350b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26349a, r6.f26349a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26350b, r6.f26350b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ScreenshotResult r0 = this.f26349a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ViewHierarchyDump> r4 = this.f26350b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectModelScreenshot(screenshot=" + this.f26349a + ", viewTree=" + this.f26350b + ')';
    }

    public d(ScreenshotResult r3, List<ViewHierarchyDump> r4) {
        List<ViewHierarchyDump> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f26349a = r3;
        this.f26350b = r5;
    }

    public final ScreenshotResult a() {
        return this.f26349a;
    }

    public final List<ViewHierarchyDump> b() {
        return this.f26350b;
    }
}
