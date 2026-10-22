package com.bytedance.android.livesdk.interactivity.square.common;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class j extends i52.a {
    public j(MessageModelType r100, MessageBinderType r101, MessagePluginType r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "modelType");
        Intrinsics.checkNotNullParameter(r101, "binderType");
        Intrinsics.checkNotNullParameter(r102, "pluginType");
        super(r100, r101, r102, r103);
    }
}
