package com.bytedance.android.livesdk;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class p8 {
    public static final boolean a(LiveDialogFragment r100, Context r101) {
        if (r101 == null) goto L8;
        if (r100 == null) goto L10;
        FragmentActivity r102 = ContextUtil.contextToFragmentActivity(r101);
        if (r102 == null) goto L11;
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r102, r100);
        return true;
    L11:
        return false;
    L10:
        return false;
    L8:
        return false;
    }
}
