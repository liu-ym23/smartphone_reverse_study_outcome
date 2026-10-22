package com.bytedance.android.live.ui;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IVoiceLiveTheme f102084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f102085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f102086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f102087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f102088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f102089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f102090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f102091h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f102092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l f102093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f102094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f102095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f102096e;

        public a() {
        }

        public q b() {
            return new q();
        }

        public final q a() {
            q r100 = b();
            r100.f102085b = this.f102092a;
            r100.f102087d = null;
            r100.f102089f = this.f102093b;
            r100.f102086c = this.f102095d;
            r100.f102088e = null;
            r100.f102090g = this.f102096e;
            r100.f102091h = this.f102094c;
            return r100;
        }

        public static void c(a r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "element");
            r100.f102092a = r101;
            r100.f102095d = null;
        }
    }

    public q() {
    }

    public IVoiceLiveTheme b() {
        return com.bytedance.android.livesdk.model.k.a();
    }

    public final void a(IVoiceLiveTheme r100) {
        p r101 = this.f102091h;
        if (r101 == null) goto L5;
        r101.onThemeChanged(r100);
    L5:
        j r102 = this.f102086c;
        if (r102 != null) goto L8;
    L9:
        l r103 = this.f102085b;
        if (r103 == null) goto L13;
        r103.onThemeChanged(r100);
    L13:
        if (Intrinsics.areEqual(r100, this.f102084a) == false) goto L15;
        return;
    L15:
        this.f102084a = r100;
        j r104 = this.f102088e;
        if (r104 != null) goto L18;
    L19:
        l r105 = this.f102087d;
        if (r105 == null) goto L22;
        r105.onThemeChanged(r100);
    L22:
        j r106 = this.f102090g;
        if (r106 != null) goto L25;
    L26:
        l r107 = this.f102089f;
        if (r107 == null) goto L31;
        r107.onThemeChanged(r100);
        return;
    L31:
        return;
    L25:
        if (r106.b(r100, this.f102089f) != true) goto L26;
        return;
    L18:
        if (r104.b(r100, this.f102087d) == true) goto L22;
    L8:
        if (r102.b(r100, this.f102085b) == true) goto L13;
        goto L9
    }

    public final void c(IVoiceLiveTheme r100) {
        if (r100 != null) goto L4;
        IVoiceLiveTheme r101 = b();
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        this.f102084a = r101;
        j r102 = this.f102086c;
        if (r102 != null) goto L10;
    L11:
        l r103 = this.f102085b;
        if (r103 == null) goto L14;
        r103.b(r101);
    L14:
        j r104 = this.f102088e;
        if (r104 != null) goto L17;
    L18:
        l r105 = this.f102087d;
        if (r105 == null) goto L21;
        r105.b(r101);
    L21:
        j r106 = this.f102090g;
        if (r106 != null) goto L24;
    L25:
        l r107 = this.f102089f;
        if (r107 == null) goto L28;
        r107.b(r101);
    L28:
        p r108 = this.f102091h;
        if (r108 == null) goto L32;
        r108.onThemeStart(r100);
        return;
    L32:
        return;
    L24:
        if (r106.a(r101, this.f102089f) == true) goto L28;
    L17:
        if (r104.a(r101, this.f102087d) == true) goto L21;
    L10:
        if (r102.a(r101, this.f102085b) == true) goto L14;
    L4:
        r101 = r100;
        goto L5
    }

    public final void d(IVoiceLiveTheme r100) {
        j r101 = this.f102086c;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        l r102 = this.f102085b;
        if (r102 == null) goto L8;
        r102.c(r100);
    L8:
        j r103 = this.f102088e;
        if (r103 == null) goto L11;
        r103.c();
    L11:
        l r104 = this.f102087d;
        if (r104 == null) goto L14;
        r104.c(r100);
    L14:
        j r105 = this.f102090g;
        if (r105 == null) goto L17;
        r105.c();
    L17:
        l r106 = this.f102089f;
        if (r106 == null) goto L20;
        r106.c(r100);
    L20:
        p r107 = this.f102091h;
        if (r107 == null) goto L23;
        r107.onThemeEnd(this.f102084a);
    L23:
        this.f102084a = null;
    }
}
