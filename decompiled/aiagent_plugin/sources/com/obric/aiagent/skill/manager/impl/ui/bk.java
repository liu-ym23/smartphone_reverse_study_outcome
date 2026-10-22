package com.obric.aiagent.skill.manager.impl.ui;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillGlassBars.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentActivity f20645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f20647c;

    /* JADX INFO: compiled from: SkillGlassBars.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f20648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f20649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Boolean f20650c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f20648a == r6.f20648a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20649b, r6.f20649b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20650c, r6.f20650c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f20648a) * 31;
            Integer r1 = this.f20649b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.f20650c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "NavigationBarState(systemUiVisibility=" + this.f20648a + ", dividerColor=" + this.f20649b + ", contrastEnforced=" + this.f20650c + ')';
        }

        public a(int r1, Integer r2, Boolean r3) {
            this.f20648a = r1;
            this.f20649b = r2;
            this.f20650c = r3;
        }

        public final int a() {
            return this.f20648a;
        }

        public final Integer b() {
            return this.f20649b;
        }

        public final Boolean c() {
            return this.f20650c;
        }
    }

    public bk(FragmentActivity r3, boolean r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        this.f20645a = r5;
        this.f20646b = r4;
    }

    public final void a() {
        if (this.f20647c == null) goto L5;
        return;
    L5:
        Window r0 = this.f20645a.getWindow();
        View r1 = r0.getDecorView();
        d.h.b.o.c(r1, "getDecorView(...)");
        int r3 = r1.getSystemUiVisibility();
        Boolean r5 = null;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        Integer r4 = Integer.valueOf(r0.getNavigationBarDividerColor());
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r5 = Boolean.valueOf(r0.isNavigationBarContrastEnforced());
    L12:
        this.f20647c = new a(r3, r4, r5);
        r1.setSystemUiVisibility((r1.getSystemUiVisibility() | 256) | 512);
        if (Build.VERSION.SDK_INT < 28) goto L16;
        r0.setNavigationBarDividerColor(0);
    L16:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        r0.setNavigationBarContrastEnforced(this.f20646b);
    L19:
        if (Build.VERSION.SDK_INT < 20) goto L22;
        r1.requestApplyInsets();
        return;
    L22:
        return;
    L8:
        r4 = null;
        goto L10
    }

    public final void b() {
        a r0 = this.f20647c;
        if (r0 != null) goto L5;
        return;
    L5:
        this.f20647c = null;
        Window r5 = this.f20645a.getWindow();
        View r1 = r5.getDecorView();
        d.h.b.o.c(r1, "getDecorView(...)");
        r1.setSystemUiVisibility(r0.a());
        if (Build.VERSION.SDK_INT < 28) goto L11;
        Integer r2 = r0.b();
        if (r2 == null) goto L11;
        r5.setNavigationBarDividerColor(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
    L11:
        if (Build.VERSION.SDK_INT < 29) goto L16;
        Boolean r3 = r0.c();
        if (r3 == null) goto L16;
        r5.setNavigationBarContrastEnforced(r3.booleanValue());
    L16:
        if (Build.VERSION.SDK_INT < 20) goto L19;
        r1.requestApplyInsets();
        return;
    }
}
