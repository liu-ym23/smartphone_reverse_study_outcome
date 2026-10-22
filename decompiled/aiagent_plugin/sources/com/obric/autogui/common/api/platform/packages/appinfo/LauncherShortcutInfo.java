package com.obric.autogui.common.api.platform.packages.appinfo;

import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LauncherShortcutInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LauncherShortcutInfo extends LauncherItemInfo {
    private final String shortcutId;

    public final String getShortcutId() {
        return this.shortcutId;
    }

    public LauncherShortcutInfo(String r3, CharSequence r4, Drawable r5, String r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r3, "appPackageName");
        o.e(r6, "shortcutId");
        super(r3, r7, r5);
        this.shortcutId = r6;
    }
}
