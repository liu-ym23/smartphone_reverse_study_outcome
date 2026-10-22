package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/GoodTitleComponentView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/InlineLongTitleComponentView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoodTitleComponentView extends InlineLongTitleComponentView {
    public GoodTitleComponentView(Context r100) {
        this(r100, null);
    }

    public GoodTitleComponentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setTypeface(Typeface.DEFAULT_BOLD);
        setResizeBitmap(true);
        setLineSpace(com.bytedance.android.shopping.extensions.b.b(0));
        setResizeToLineHeight(true);
    }
}
