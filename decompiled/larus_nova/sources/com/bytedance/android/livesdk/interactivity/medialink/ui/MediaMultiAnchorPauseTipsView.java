package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MediaMultiAnchorPauseTipsView;", "Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/WindowLayoutType;", "windowLayoutType", "", "setWindowLayoutType", "", "getLayoutResource", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "f", "getContent", "content", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorPauseTipsView extends AnchorPauseTipsView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f138227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f138228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WindowLayoutType f138229g;

    public static final class a {
    }

    static {
    }

    public MediaMultiAnchorPauseTipsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MediaMultiAnchorPauseTipsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.common.AnchorPauseTipsView
    public int getLayoutResource() {
        return R.layout.ttlive_media_multi_anchor_pause_tips_view;
    }

    public final TextView getContent() {
        return this.f138228f;
    }

    public final TextView getTitle() {
        return this.f138227e;
    }

    public final void setWindowLayoutType(WindowLayoutType r100) {
        Intrinsics.checkNotNullParameter(r100, "windowLayoutType");
        if (this.f138229g != r100) goto L5;
        return;
    L5:
        this.f138229g = r100;
        if (r100 != WindowLayoutType.EnlargeSmall) goto L8;
        this.f138227e.setTextSize(1, 11.0f);
        this.f138228f.setTextSize(1, 8.0f);
        return;
    L8:
        this.f138227e.setTextSize(1, 15.0f);
        this.f138228f.setTextSize(1, 11.0f);
    }

    public MediaMultiAnchorPauseTipsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138227e = (TextView) findViewById(R.id.title_tv);
        this.f138228f = (TextView) findViewById(R.id.content_tv);
        this.f138229g = WindowLayoutType.Normal;
    }

    public /* synthetic */ MediaMultiAnchorPauseTipsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
