package com.obric.autoaction.common.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.obric.autoaction.common.base.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityExtension<C extends b> extends BaseExtension<C, AppCompatActivity> {
    public ActivityExtension(C r3, AppCompatActivity r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        AppCompatActivity r6 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r4, AppCompatActivity.class, "com.obric.aiagent.plugin");
        o.e(r5, "config");
        o.e(r6, "host");
        super(r5, (p) ZeusTransformUtils.preCheckCast(r6, p.class, "com.obric.aiagent.plugin"));
    }
}
