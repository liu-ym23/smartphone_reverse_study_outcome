package com.obric.autogui.api;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DisplayedAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f28921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f28922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentName f28923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ComponentName f28924e;
    private final String f;
    private final CharSequence g;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f28920a == r6.f28920a) goto L12;
        return false;
    L12:
        if (this.f28921b == r6.f28921b) goto L15;
        return false;
    L15:
        if (o.a(this.f28922c, r6.f28922c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f28923d, r6.f28923d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f28924e, r6.f28924e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.f28920a) * 31) + Boolean.hashCode(this.f28921b)) * 31;
        ComponentName r1 = this.f28922c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ComponentName r5 = this.f28923d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ComponentName r8 = this.f28924e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        CharSequence r14 = this.g;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "DisplayedAppInfo(taskId=" + this.f28920a + ", isVisible=" + this.f28921b + ", topActivity=" + this.f28922c + ", baseActivity=" + this.f28923d + ", realActivity=" + this.f28924e + ", data=" + this.f + ", taskLabel=" + this.g + ')';
    }

    public a(int r3, boolean r4, ComponentName r5, ComponentName r6, ComponentName r7, String r8, CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
        this.f28920a = r3;
        this.f28921b = r4;
        this.f28922c = r5;
        this.f28923d = r6;
        this.f28924e = r7;
        this.f = r8;
        this.g = r10;
    }

    public final ComponentName a() {
        return this.f28922c;
    }
}
