package com.bytedance.android.shopping.anchorv4.containers;

import android.content.Context;
import com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o extends ImmersiveAppCompatDialog {
    public o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.Commerce_Dialog_Immersive_FullScreen);
    }
}
