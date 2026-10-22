package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/LiveMessageLoaderTip;", "Landroid/widget/FrameLayout;", "", "getResourceLayout", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMessageLoaderTip extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f140173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f140174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q4.b f140175c;

    public LiveMessageLoaderTip(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveMessageLoaderTip(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getResourceLayout() {
        return R.layout.ttlive_live_message_tip;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L9;
        TextView r101 = this.f140173a;
        if (r101 == null) goto L7;
        r101.setAlpha(0.0f);
    L7:
        this.f140175c.c();
        return;
    L9:
        if (this.f140175c.b() == false) goto L13;
        this.f140175c.a();
        return;
    }

    public LiveMessageLoaderTip(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f140174b = LayoutInflater.from(r100).inflate(getResourceLayout(), this, true);
        TextView r103 = (TextView) findViewById(R.id.text);
        this.f140173a = r103;
        if (r103 == null) goto L5;
        r103.setText(R.string.ttlive_live_message_tips);
        r103.setTextColor(-1);
        r103.setMinHeight((int) UtilityKotlinExtentionsKt.h(28));
    L5:
        this.f140175c = u4.c(new LiveMessageLoaderTip$animController$1(this));
    }

    public /* synthetic */ LiveMessageLoaderTip(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
