package com.obric.common.oea.style.scene.alpha.alphaplayer.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: DataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f32488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f32491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f32492e;
    private boolean f;

    public c() {
    }

    public final boolean a() {
        return this.f;
    }

    public final c a(String r5) {
        o.e(r5, "baseDir");
        String r0 = File.separator;
        o.c(r0, "File.separator");
        if (d.o.o.c(r5, r0, false, 2, null) == true) goto L6;
        r5 = r5 + File.separator;
    L6:
        this.f32488a = r5;
        return this;
    }

    public final c a(String r2, d r3) {
        o.e(r2, "portraitPath");
        o.e(r3, "portraitScaleType");
        this.f32489b = r2;
        this.f32491d = r3;
        return this;
    }

    public final c b(String r2, d r3) {
        o.e(r2, "landscapePath");
        o.e(r3, "landscapeScaleType");
        this.f32490c = r2;
        this.f32492e = r3;
        return this;
    }

    public final c a(boolean r1) {
        this.f = r1;
        return this;
    }

    public final String a(int r4) {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.f32488a;
        if (r1 != null) goto L5;
        o.c("baseDir");
    L5:
        StringBuilder r2 = r0.append(r1);
        if (1 != r4) goto L11;
        String r3 = this.f32489b;
        if (r3 != null) goto L15;
        String r5 = "portPath";
    L10:
        o.c(r5);
    L15:
        return r2.append(r3).toString();
    L11:
        r3 = this.f32490c;
        if (r3 != null) goto L15;
        r5 = "landPath";
        goto L10
    }

    public final d b(int r2) {
        if (1 != r2) goto L6;
        return this.f32491d;
    L6:
        return this.f32492e;
    }

    public final boolean b() {
        String r0 = this.f32489b;
        if (r0 != null) goto L6;
        o.c("portPath");
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        String r1 = this.f32490c;
        if (r1 != null) goto L11;
        o.c("landPath");
    L11:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L17;
        if (this.f32491d == null) goto L17;
        if (this.f32492e == null) goto L17;
        return true;
    L17:
        return false;
    }
}
