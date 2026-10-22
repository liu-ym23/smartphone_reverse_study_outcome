package com.obric.autogui.common.api.platform.packages.appinfo;

import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LauncherItemInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LauncherItemInfo {
    private final String appPackageName;
    private final Drawable icon;
    private final CharSequence label;

    public LauncherItemInfo(String r3, CharSequence r4, Drawable r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r3, "appPackageName");
        this.appPackageName = r3;
        this.label = r6;
        this.icon = r5;
    }

    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final Drawable getIcon() {
        return this.icon;
    }
}
