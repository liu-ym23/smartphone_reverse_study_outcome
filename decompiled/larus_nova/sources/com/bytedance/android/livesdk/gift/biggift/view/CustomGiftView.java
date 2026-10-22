package com.bytedance.android.livesdk.gift.biggift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.gift.model.q3;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/gift/biggift/view/CustomGiftHintDialog$a;", "onCustomGiftDialogListener", "", "setOnCustomGiftDialogListener", "Lcom/bytedance/android/livesdk/gift/model/q3;", "info", "setDialogData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomGiftView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f125964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CustomGiftHintDialog f125965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f125966c;

    public CustomGiftView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_custom_gift, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f125964a = (FrameLayout) findViewById(R.id.custom_gift_left_count_layout);
        this.f125965b = (CustomGiftHintDialog) findViewById(R.id.custom_gift_hint_dialog_view);
        this.f125966c = (TextView) findViewById(R.id.custom_gift_left_count);
        FrameLayout r101 = this.f125964a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L5:
        ViewUtilsKt.f(r101);
    }

    public final void setDialogData(q3 r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        CustomGiftHintDialog r101 = this.f125965b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftHintDialog");
    L5:
        r101.setData(r100);
        FrameLayout r102 = this.f125964a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftLeftLayout");
    L8:
        ViewUtilsKt.e(r102);
    }

    public final void setOnCustomGiftDialogListener(CustomGiftHintDialog.a r100) {
        Intrinsics.checkNotNullParameter(r100, "onCustomGiftDialogListener");
        CustomGiftHintDialog r101 = this.f125965b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCustomGiftHintDialog");
    L5:
        r101.setOnCustomGiftDialogListener(r100);
    }

    public CustomGiftView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a(r100);
    }
}
