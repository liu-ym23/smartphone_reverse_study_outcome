package com.bytedance.android.livesdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/LongPressGuideView;", "Landroid/widget/RelativeLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "", "cb", "setClickCallback", "", SocialConstants.PARAM_APP_DESC, "setDesc", "", "resId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressGuideView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f122012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super View, Unit> f122013b;

    public LongPressGuideView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LongPressGuideView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setClickCallback(Function1<? super View, Unit> r100) {
        this.f122013b = r100;
    }

    public final void setDesc(int r100) {
        TextView r101 = this.f122012a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
    L5:
        r101.setText(r100);
    }

    public final void setDesc(CharSequence r100) {
        TextView r101 = this.f122012a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
    L5:
        r101.setText(r100);
    }

    public LongPressGuideView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RelativeLayout.inflate(r100, R.layout.ttlive_layout_long_press_guide, this);
        this.f122012a = (TextView) findViewById(R.id.tv_desc);
        setOnClickListener(new s(this));
    }

    public /* synthetic */ LongPressGuideView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
