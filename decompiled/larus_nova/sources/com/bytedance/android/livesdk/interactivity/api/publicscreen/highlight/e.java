package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements m.b {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m.b
    public final TopicDismissTrigger a(DataCenter r100, b6.b r101) {
        Intrinsics.checkNotNullParameter(r101, "trigger");
        gb2.a.a(r100, false);
        Long r102 = r101.a();
        long r103 = TriggerKey.TopicDismiss.getId();
        if (r102 != null) goto L6;
    L8:
        return null;
    L6:
        if (r102.longValue() != r103) goto L8;
        return new TopicDismissTrigger(r100);
    }
}
