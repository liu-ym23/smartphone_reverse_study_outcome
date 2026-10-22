package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/topbar/RecommendFastGiftConfirmView;", "Landroid/widget/FrameLayout;", "", "mainTextStr", "", "setMainText", "checkedStr", "setCheckedText", "leftButtonStr", "setLeftButtonText", "Landroid/view/View$OnClickListener;", "listener", "setOnClickLeftButtonListener", "rightButtonStr", "setRightButtonText", "setOnClickRightButtonListener", "", "getIsChecked", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendFastGiftConfirmView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f126964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckBox f126965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f126966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f126967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f126968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f126969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f126970g;

    public RecommendFastGiftConfirmView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecommendFastGiftConfirmView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final boolean getIsChecked() {
        CheckBox r100 = this.f126965b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isChecked() != true) goto L7;
        return true;
    }

    public final void setCheckedText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "checkedStr");
        TextView r101 = this.f126966c;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setLeftButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "leftButtonStr");
        TextView r101 = this.f126968e;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setMainText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mainTextStr");
        TextView r101 = this.f126964a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setOnClickLeftButtonListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        View r101 = this.f126967d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setOnClickRightButtonListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        View r101 = this.f126969f;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public final void setRightButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rightButtonStr");
        TextView r101 = this.f126970g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public RecommendFastGiftConfirmView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_recommend_fast_gift_confirm_dialog, this);
        this.f126964a = (TextView) r103.findViewById(R.id.main_text);
        this.f126965b = (CheckBox) r103.findViewById(R.id.center_checkbox);
        this.f126966c = (TextView) r103.findViewById(R.id.center_checked_text);
        this.f126967d = r103.findViewById(R.id.left_button);
        this.f126968e = (TextView) r103.findViewById(R.id.left_button_text);
        this.f126969f = r103.findViewById(R.id.right_button);
        this.f126970g = (TextView) r103.findViewById(R.id.right_button_text);
    }

    public /* synthetic */ RecommendFastGiftConfirmView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
