package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.effect.sticker.ui.StickerItemView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements f {
    public e() {
    }

    @Override // com.bytedance.android.live.effect.common.f
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new StickerItemView(r100, null, 6, 0);
    }
}
