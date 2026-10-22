package com.bytedance.android.ec.core.widget;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.common.util.UriUtil;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final void a(ECDraweeView r100, String r101, Integer r102) {
        if (r101 == null) goto L4;
        com.bytedance.android.ec.core.utils.y.d(r100, r101);
        return;
    L4:
        if (r102 == null) goto L8;
        com.bytedance.android.ec.core.utils.y.d(r100, UriUtil.getUriForResourceId(r102.intValue()).toString());
        return;
    }
}
