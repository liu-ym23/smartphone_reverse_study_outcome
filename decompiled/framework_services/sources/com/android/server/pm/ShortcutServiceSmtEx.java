package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Icon;
import android.os.Binder;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutServiceSmtEx {
    public ShortcutServiceSmtEx() {
    }

    protected void broadcastShortcutInstalled(Context context, ShortcutInfo si) {
        if (context == null) goto L34;
        if (si == null) goto L35;
        Intent intent = new Intent("bytedanceos.intent.action.INSTALL_SHORTCUT");
        if (si.getIntent() == null) goto L8;
        intent.putExtra("android.intent.extra.shortcut.INTENT", si.getIntent());
    L14:
        if (TextUtils.isEmpty(si.getShortLabel()) == false) goto L16;
        CharSequence name = si.getLongLabel();
    L18:
        if (TextUtils.isEmpty(name) == true) goto L20;
        intent.putExtra("android.intent.extra.shortcut.NAME", name);
    L20:
        Icon icon = si.getIcon();
        if (icon != null) goto L23;
    L30:
        intent.putExtra("extra_uid", Binder.getCallingUid());
        context.sendBroadcast(intent);
        return;
    L23:
        switch(icon.getType()) {
            case 1: goto L29;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L30;
            case 5: goto L29;
            default: goto L30;
        };
    L29:
        intent.putExtra("android.intent.extra.shortcut.ICON", icon.getBitmap());
        goto L30
    L32:
        Intent.ShortcutIconResource sir = new Intent.ShortcutIconResource();     // Catch: PackageManager.NameNotFoundException -> L27
        sir.packageName = icon.getResPackage();     // Catch: PackageManager.NameNotFoundException -> L27
        sir.resourceName = context.getPackageManager().getResourcesForApplication(icon.getResPackage()).getResourceName(icon.getResId());     // Catch: PackageManager.NameNotFoundException -> L27
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", sir);     // Catch: PackageManager.NameNotFoundException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L16:
        name = si.getShortLabel();
        goto L18
    L8:
        if (si.getActivity() == null) goto L14;
        Intent target = new Intent();
        target.setComponent(si.getActivity());
        if (si.getPackage() == null) goto L12;
        target.setPackage(si.getPackage());
    L12:
        intent.putExtra("android.intent.extra.shortcut.INTENT", target);
        goto L14
    L35:
        return;
    }
}
