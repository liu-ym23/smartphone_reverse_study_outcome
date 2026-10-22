package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return R.layout.ttlive_new_portrait_section_frequent_comment;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r100, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "bridges");
        super.t(r100, r101);
        if (r101.Q() != InputSectionType.FREQUENT_CHAT) goto L5;
        r101.D0();
        return;
    L5:
        r101.z0();
    }

    public h(InputFunctionEnum r100, Context r101, InputSectionType r102) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sectionType");
        super(r100, r101, r102);
    }
}
