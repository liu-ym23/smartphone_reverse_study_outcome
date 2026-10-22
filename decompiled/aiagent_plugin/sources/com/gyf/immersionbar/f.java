package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GestureUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: compiled from: GestureUtils.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j f13846c;

        a() {
            this.f13844a = false;
            this.f13845b = false;
        }

        public String toString() {
            return "GestureBean{isGesture=" + this.f13844a + ", checkNavigation=" + this.f13845b + ", type=" + this.f13846c + '}';
        }
    }

    public static a a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        a r0 = new a();
        if (Build.VERSION.SDK_INT < 17) goto L94;
        if (r10 == null) goto L94;
        if (r10.getContentResolver() == null) goto L94;
        ContentResolver r11 = r10.getContentResolver();
        j r1 = j.f13865e;
        boolean r4 = false;
        boolean r6 = true;
        if (OSUtils.isHuaWei() == true) goto L70;
        if (OSUtils.isEMUI() == true) goto L70;
        if (OSUtils.isXiaoMi() == false) goto L15;
    L62:
        int r2 = Settings.Global.getInt(r11, "force_fsg_nav_bar", -1);
        if (r2 != 0) goto L65;
        r1 = j.f13861a;
    L82:
        boolean r7 = false;
        boolean r8 = false;
    L83:
        if (r2 != (-1)) goto L92;
        int r12 = Settings.Secure.getInt(r11, "navigation_mode", -1);
        if (r12 != 0) goto L88;
        r1 = j.f13861a;
    L87:
        r6 = r7;
    L93:
        r0.f13844a = r4;
        r0.f13845b = r6;
        r0.f13846c = r1;
        goto L94
    L88:
        if (r12 != 1) goto L90;
        r1 = j.f13864d;
        goto L87
    L90:
        if (r12 != 2) goto L92;
        r1 = j.f13862b;
        r4 = true;
    L92:
        r6 = r7;
        r4 = r8;
        goto L93
    L65:
        if (r2 != 1) goto L82;
        r1 = j.f13862b;
        if (Settings.Global.getInt(r11, "hide_gesture_line", -1) != 1) goto L40;
    L80:
        r7 = false;
    L81:
        r8 = true;
    L40:
        r7 = true;
        goto L81
    L15:
        if (OSUtils.isMIUI() == true) goto L62;
        if (OSUtils.isVivo() == false) goto L20;
    L55:
        r2 = Settings.Secure.getInt(r11, "navigation_gesture_on", -1);
        if (r2 != 0) goto L58;
        r1 = j.f13861a;
        goto L82
    L58:
        if (r2 != 1) goto L60;
        r1 = j.f13863c;
        goto L80
    L60:
        if (r2 != 2) goto L82;
        r1 = j.f13862b;
        goto L80
    L20:
        if (OSUtils.isFuntouchOrOriginOs() == true) goto L55;
        if (OSUtils.isOppo() == false) goto L25;
    L47:
        r2 = Settings.Secure.getInt(r11, "hide_navigationbar_enable", -1);
        if (r2 != 0) goto L50;
        r1 = j.f13861a;
        goto L82
    L50:
        if (r2 == 1) goto L54;
        if (r2 == 2) goto L54;
        if (r2 != 3) goto L82;
    L54:
        r1 = j.f13862b;
        goto L80
    L25:
        if (OSUtils.isColorOs() == true) goto L47;
        if (OSUtils.isSamsung() == false) goto L46;
        r2 = Settings.Global.getInt(r11, "navigation_bar_gesture_while_hidden", -1);
        if (r2 == (-1)) goto L41;
        if (r2 != 0) goto L33;
        r1 = j.f13861a;
        goto L82
    L33:
        if (r2 != 1) goto L82;
        if (Settings.Global.getInt(r11, "navigation_bar_gesture_detail_type", 1) != 1) goto L37;
        r1 = j.f13862b;
    L39:
        if (Settings.Global.getInt(r11, "navigation_bar_gesture_hint", 1) != 1) goto L80;
    L37:
        r1 = j.f13863c;
        goto L39
    L41:
        r2 = Settings.Global.getInt(r11, "navigationbar_hide_bar_enabled", -1);
        if (r2 != 0) goto L44;
        r1 = j.f13861a;
        goto L82
    L44:
        if (r2 != 1) goto L82;
        r1 = j.f13862b;
        goto L80
    L46:
        r7 = false;
        r8 = false;
        r2 = -1;
    L70:
        if (OSUtils.isEMUI3_x() == false) goto L72;
    L75:
        r2 = Settings.System.getInt(r11, "navigationbar_is_min", -1);
    L76:
        if (r2 != 0) goto L78;
        r1 = j.f13861a;
        goto L82
    L78:
        if (r2 != 1) goto L82;
        r1 = j.f13862b;
        goto L80
    L72:
        if (Build.VERSION.SDK_INT < 21) goto L75;
        r2 = Settings.Global.getInt(r11, "navigationbar_is_min", -1);
    L94:
        return r0;
    }
}
