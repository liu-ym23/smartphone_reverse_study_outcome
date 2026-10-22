package com.obric.autogui.common.api.platform.packages.appinfo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LauncherEntryInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LauncherEntryInfo extends LauncherItemInfo {
    private final Intent intent;

    public final Intent getIntent() {
        return this.intent;
    }

    public LauncherEntryInfo(String r3, CharSequence r4, Drawable r5, Intent r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r3, "appPackageName");
        o.e(r6, MemorySourceLinkType.INTENT);
        super(r3, r7, r5);
        this.intent = r6;
    }
}
