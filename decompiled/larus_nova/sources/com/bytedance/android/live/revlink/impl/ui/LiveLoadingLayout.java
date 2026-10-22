package com.bytedance.android.live.revlink.impl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/ui/LiveLoadingLayout;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLoadingLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f97634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f97635b;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_layout_douyin_loading_view, this, true);
        this.f97635b = (LiveDoubleColorBallAnimationView) findViewById(R.id.double_loading_view);
        this.f97634a = (TextView) findViewById(R.id.double_loading_text);
    }

    public LiveLoadingLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L10;
        LiveDoubleColorBallAnimationView r101 = this.f97635b;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        TextView r102 = this.f97634a;
        if (r102 == null) goto L14;
        r102.setVisibility(0);
        return;
    L14:
        return;
    L10:
        LiveDoubleColorBallAnimationView r103 = this.f97635b;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
        return;
    }

    public LiveLoadingLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a();
    }

    public LiveLoadingLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a();
    }
}
