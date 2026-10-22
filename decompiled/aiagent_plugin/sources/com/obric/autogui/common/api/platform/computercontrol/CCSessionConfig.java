package com.obric.autogui.common.api.platform.computercontrol;

import android.view.Surface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCSessionConfig {
    private final Integer displayDpi;
    private final Integer displayHeightPx;
    private final Integer displayWidthPx;
    private final Surface initialSurface;
    private final String name;
    private final List<String> targetPackageNames;

    public static /* synthetic */ CCSessionConfig copy$default(CCSessionConfig r7, String r8, List r9, Integer r10, Integer r11, Integer r12, Surface r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.name;
    L5:
        String r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r16 = r7.targetPackageNames;
    L8:
        List<String> r2 = r16;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.displayWidthPx;
    L11:
        Integer r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.displayHeightPx;
    L14:
        Integer r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.displayDpi;
    L17:
        Integer r5 = r12;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.initialSurface;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final List<String> component2() {
        return this.targetPackageNames;
    }

    public final Integer component3() {
        return this.displayWidthPx;
    }

    public final Integer component4() {
        return this.displayHeightPx;
    }

    public final Integer component5() {
        return this.displayDpi;
    }

    public final Surface component6() {
        return this.initialSurface;
    }

    public final CCSessionConfig copy(String r8, List<String> r9, Integer r10, Integer r11, Integer r12, Surface r13) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "name");
        o.e(r2, "targetPackageNames");
        return new CCSessionConfig(r8, r2, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CCSessionConfig.class) == true) goto L8;
        return false;
    L8:
        CCSessionConfig r6 = (CCSessionConfig) ZeusTransformUtils.preCheckCast(r5, CCSessionConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.targetPackageNames, r6.targetPackageNames) == true) goto L15;
        return false;
    L15:
        if (o.a(this.displayWidthPx, r6.displayWidthPx) == true) goto L18;
        return false;
    L18:
        if (o.a(this.displayHeightPx, r6.displayHeightPx) == true) goto L21;
        return false;
    L21:
        if (o.a(this.displayDpi, r6.displayDpi) == true) goto L24;
        return false;
    L24:
        if (o.a(this.initialSurface, r6.initialSurface) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.targetPackageNames.hashCode()) * 31;
        Integer r1 = this.displayWidthPx;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.displayHeightPx;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.displayDpi;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Surface r11 = this.initialSurface;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CCSessionConfig(name=" + this.name + ", targetPackageNames=" + this.targetPackageNames + ", displayWidthPx=" + this.displayWidthPx + ", displayHeightPx=" + this.displayHeightPx + ", displayDpi=" + this.displayDpi + ", initialSurface=" + this.initialSurface + ')';
    }

    public CCSessionConfig(String r3, List<String> r4, Integer r5, Integer r6, Integer r7, Surface r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "name");
        o.e(r9, "targetPackageNames");
        this.name = r3;
        this.targetPackageNames = r9;
        this.displayWidthPx = r5;
        this.displayHeightPx = r6;
        this.displayDpi = r7;
        this.initialSurface = r8;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ CCSessionConfig(String r8, List r9, Integer r10, Integer r11, Integer r12, Surface r13, int r14, h r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 2) == 0) goto L5;
        r16 = p.b();
    L5:
        List r2 = r16;
        if ((r14 & 4) == 0) goto L8;
        Integer r3 = null;
    L10:
        if ((r14 & 8) == 0) goto L12;
        Integer r4 = null;
    L14:
        if ((r14 & 16) == 0) goto L16;
        Integer r5 = null;
    L18:
        if ((r14 & 32) == 0) goto L20;
        Surface r6 = null;
    L21:
        this(r8, r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r13;
        goto L21
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public final List<String> getTargetPackageNames() {
        return this.targetPackageNames;
    }

    public final Integer getDisplayWidthPx() {
        return this.displayWidthPx;
    }

    public final Integer getDisplayHeightPx() {
        return this.displayHeightPx;
    }

    public final Integer getDisplayDpi() {
        return this.displayDpi;
    }

    public final Surface getInitialSurface() {
        return this.initialSurface;
    }
}
