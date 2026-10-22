package com.obric.autoaction.app.launcherpage.utils;

import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SelectionAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f24506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f24507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f24508e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f24504a, r6.f24504a) == true) goto L12;
        return false;
    L12:
        if (this.f24505b == r6.f24505b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f24506c, r6.f24506c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f24507d, r6.f24507d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f24508e, r6.f24508e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f24504a.hashCode() * 31) + Boolean.hashCode(this.f24505b)) * 31;
        T r1 = this.f24506c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Drawable r5 = this.f24507d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f24508e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SelectionItemData(title=" + this.f24504a + ", isChecked=" + this.f24505b + ", tag=" + this.f24506c + ", icon=" + this.f24507d + ", subTitle=" + this.f24508e + ')';
    }

    public j(String r2, boolean r3, T r4, Drawable r5, String r6) {
        d.h.b.o.e(r2, DBDefinition.TITLE);
        this.f24504a = r2;
        this.f24505b = r3;
        this.f24506c = r4;
        this.f24507d = r5;
        this.f24508e = r6;
    }

    public /* synthetic */ j(String r7, boolean r8, Object r9, Drawable r10, String r11, int r12, d.h.b.h r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = false;
    L5:
        boolean r2 = r8;
        if ((r12 & 8) == 0) goto L8;
        Drawable r4 = null;
    L10:
        if ((r12 & 16) == 0) goto L12;
        String r5 = null;
    L13:
        this(r7, r2, r9, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public final String a() {
        return this.f24504a;
    }

    public final void a(boolean r1) {
        this.f24505b = r1;
    }

    public final boolean b() {
        return this.f24505b;
    }

    public final T c() {
        return this.f24506c;
    }

    public final String d() {
        return this.f24508e;
    }
}
