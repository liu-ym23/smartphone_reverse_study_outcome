package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECLoadMoreView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "statusTextView", "Landroid/widget/TextView;", "initLayoutParams", "", "initViews", "setLoadMoreText", "loadMoreText", "", "setLoadMoreTextColor", "color", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadMoreView extends LinearLayout {
    private TextView statusTextView;

    public ECLoadMoreView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECLoadMoreView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private final void initViews() {
        addView(new ECDuxLoadingAnimationView(getContext(), null, 0, 6, null));
        TextView r100 = new TextView(getContext());
        r100.setTextSize(1, 12.0f);
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), R.color.ec_dux_black_161823_60));
        Unit r101 = Unit.INSTANCE;
        this.statusTextView = r100;
        addView(r100);
        setLoadMoreText(getContext().getString(R.string.ec_is_loading));
    }

    private final void initLayoutParams() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L5;
        r100.width = -2;
        r100.height = -2;
        setLayoutParams(r100);
    L5:
        setOrientation(0);
    }

    public final void setLoadMoreText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "loadMoreText");
        TextView r101 = this.statusTextView;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setLoadMoreTextColor(int r100) {
        TextView r101 = this.statusTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public ECLoadMoreView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        initLayoutParams();
        setGravity(17);
        initViews();
    }

    public /* synthetic */ ECLoadMoreView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
