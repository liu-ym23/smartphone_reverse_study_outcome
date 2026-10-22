package com.bytedance.android.livesdk.ktvimpl.mv.opus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.view.CommomKtvButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/view/OpusPreviewErrorView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function0;", "getRetryCallback", "()Lkotlin/jvm/functions/Function0;", "setRetryCallback", "(Lkotlin/jvm/functions/Function0;)V", "retryCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewErrorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f146193a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpusPreviewErrorView f146194a;

        public a(OpusPreviewErrorView r100) {
            this.f146194a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f146194a.getRetryCallback();
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke();
            return;
        }
    }

    public final Function0<Unit> getRetryCallback() {
        return this.f146193a;
    }

    public final void setRetryCallback(Function0<Unit> r100) {
        this.f146193a = r100;
    }

    public OpusPreviewErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.layout_ktv_opus_preview_error_view, this);
        setBackgroundColor(-1);
        CommomKtvButton r102 = (CommomKtvButton) findViewById(R.id.retry_btn);
        if (r102 == null) goto L6;
        r102.setTextColor(-16777216);
        r102.setBackgroundResource(R.drawable.ttlive_bg_gray_ktv_bt_corner_4);
        r102.setOnClickListener(new a(this));
        return;
    }
}
