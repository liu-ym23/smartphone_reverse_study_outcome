package com.bytedance.android.uicomponent.input.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/uicomponent/input/view/MultiLineInputView;", "Lcom/bytedance/android/uicomponent/input/view/InputView;", "", "getLayoutID", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uicomponent_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLineInputView extends InputView {
    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void b() {
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void c() {
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void d(TypedArray r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public int getLayoutID() {
        return R.layout.uicomponent_inputview_type_area;
    }

    @Override // com.bytedance.android.uicomponent.input.view.InputView
    public final void e() {
        getMEditText().setInputType(131072);
        getMEditText().setSingleLine(false);
        getMEditText().setHorizontallyScrolling(false);
    }

    public MultiLineInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
    }
}
