package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/NewTalkbackKeyboardView;", "Lcom/android/ttcjpaysdk/base/ui/widget/TalkbackKeyboardNoiseReductionView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NewTalkbackKeyboardView extends TalkbackKeyboardNoiseReductionView {
    private final Context mContext;

    public NewTalkbackKeyboardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, null, 0, 6, null);
    }

    public NewTalkbackKeyboardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this(r100, r101, 0, 4, null);
    }

    @Override // com.android.ttcjpaysdk.base.ui.widget.TalkbackKeyboardNoiseReductionView, com.android.ttcjpaysdk.base.ui.widget.CJPayTalkbackKeyboardView
    public int getLayoutId() {
        return R.layout.cj_pay_view_keyboard_new;
    }

    public NewTalkbackKeyboardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
        this.mContext = r100;
    }

    public /* synthetic */ NewTalkbackKeyboardView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
