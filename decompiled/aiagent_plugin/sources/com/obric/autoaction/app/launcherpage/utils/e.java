package com.obric.autoaction.app.launcherpage.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.app.IAutoActionHostResProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LauncherIconHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "LauncherIconHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24474a = null;

    /* JADX INFO: compiled from: LauncherIconHelper.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24475a = null;

        static {
            int[] r0 = new int[g.a.values().length];
            r0[g.a.f24486b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[g.a.f24487c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f24475a = r0;
        }
    }

    static {
        f24474a = new e();
    }

    public final boolean a(Context r2) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        return false;
    }

    private e() {
    }

    public final boolean b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        return g.f24481a.a(r1, "launcher_page_icon_shortcut");
    }

    public final boolean a(Context r3, PendingIntent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        com.obric.event.task.base.report.m.f32868a.a();
        return a(r5, true, r4);
    }

    public final boolean c(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        com.obric.event.task.base.report.m.f32868a.b();
        return a(this, r1, false, null, 4, null);
    }

    static /* synthetic */ boolean a(e r1, Context r2, boolean r3, PendingIntent r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r1.a(r7, r3, r4);
    }

    private final boolean a(Context r3, boolean r4, PendingIntent r5) {
        return b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public final int a() {
        IAutoActionHostResProvider r2 = (IAutoActionHostResProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionHostResProvider.class), IAutoActionHostResProvider.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.getAppIconRes());
    L6:
        if (r3 != null) goto L9;
        r3 = Integer.valueOf(ZeusTransformUtils.mapRes(R.mipmap.ic_pin_short_cut, "mipmap", "ic_pin_short_cut"));
    L9:
        return r3.intValue();
    L5:
        r3 = null;
        goto L6
    }

    public final void d(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        if (Build.VERSION.SDK_INT >= 25) goto L16;
        return;
    L16:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L10
        e r3 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        ShortcutManager r1 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return;
    L8:
        ShortcutInfo r6 = new ShortcutInfo.Builder(r5, "launcher_page_icon_shortcut").setIntent(r3.e(r5)).build();     // Catch: Throwable -> L10
        d.h.b.o.c(r6, "build(...)");     // Catch: Throwable -> L10
        Object r7 = d.n.f(Boolean.valueOf(r1.updateShortcuts(d.a.p.a(r6))));     // Catch: Throwable -> L10
    L12:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L18;
        ILogDepend.Companion.e(TAG, "updatePinnedLauncherShortcutIntent failed", r8);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L12
    }

    private final Intent e(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Intent r3 = new Intent("android.intent.action.VIEW");
        r3.setClassName(r1.getPackageName(), "com.obric.autoaction.app.launcherpage.LauncherPageActivityForLauncher");
        r3.addCategory("android.intent.category.DEFAULT");
        r3.putExtra("launcher_page_enter_from", "launcher_icon");
        return r3;
    }

    private final boolean b(Context r8, boolean r9, PendingIntent r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.string.launcher_page_main_fragment_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "launcher_page_main_fragment_title"));
        d.h.b.o.c(r0, "getString(...)");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        ShortcutManager r3 = (ShortcutManager) ZeusTransformUtils.preCheckCast(r11.getSystemService(ShortcutManager.class), ShortcutManager.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r9 == true) goto L16;
        r3.disableShortcuts(d.a.p.a("launcher_page_icon_shortcut"));     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "changeLauncherStateViaShortcut disable failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    L16:
        if (r3.isRequestPinShortcutSupported() == true) goto L18;
        return false;
    L18:
        Intent r12 = e(r11);
        Drawable r7 = androidx.appcompat.a.a.a.b(r11, a());
        if (r7 == null) goto L21;
        Bitmap r13 = com.obric.oui.common.util.c.a(r7);
    L22:
        Icon r14 = Icon.createWithBitmap(r13);
        d.h.b.o.c(r14, "createWithBitmap(...)");
        ShortcutInfo r15 = new ShortcutInfo.Builder(r11, "launcher_page_icon_shortcut").setShortLabel((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).setIcon(r14).setIntent(r12).build();
        d.h.b.o.c(r15, "build(...)");
        g.a r16 = g.f24481a.a(r11, r15, r10);
        int r17 = a.f24475a[r16.ordinal()];
        if (r17 != 1) goto L25;
        Toast.makeText(r11, ZeusTransformUtils.mapRes(R.string.main_menu_show_launcher_icon_not_supported, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_menu_show_launcher_icon_not_supported"), 0).show();
        return false;
    L25:
        if (r17 == 2) goto L27;
        return false;
    L27:
        return true;
    L21:
        r13 = null;
        goto L22
    }
}
