package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/LynxVideoView;", "Landroid/widget/FrameLayout;", "getVideoContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f129336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GiftSwitchImageView f129337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NewGiftSwitchImageView f129338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f129339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f129340e;

    public LynxVideoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxVideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final FrameLayout getVideoContainer() {
        return this.f129336a;
    }

    public LynxVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_gift_lynx_video_view, this, true);
        this.f129336a = (FrameLayout) findViewById(R.id.lynx_video_view);
        this.f129337b = (GiftSwitchImageView) findViewById(R.id.switch_button);
        this.f129338c = (NewGiftSwitchImageView) findViewById(R.id.switch_button_new);
    }

    public /* synthetic */ LynxVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
