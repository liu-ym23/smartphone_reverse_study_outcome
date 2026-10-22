package com.obric.oui.common.style;

import android.content.Context;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OUIDisplayHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static DisplayMetrics a(Context r2) {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics();
    }
}
