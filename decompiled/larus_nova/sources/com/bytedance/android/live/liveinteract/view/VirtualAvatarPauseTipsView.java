package com.bytedance.android.live.liveinteract.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/VirtualAvatarPauseTipsView;", "Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "", "getLayoutResource", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VirtualAvatarPauseTipsView extends AnchorPauseTipsView {

    public static final class a {
    }

    static {
    }

    public VirtualAvatarPauseTipsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VirtualAvatarPauseTipsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.common.AnchorPauseTipsView
    public int getLayoutResource() {
        return R.layout.ttlive_virtual_avatar_pause_tips_view;
    }

    public VirtualAvatarPauseTipsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.common.AnchorPauseTipsView
    public final void T5(int r100, float r101, boolean r102) {
        getWebpAnimView().setActualImageResource(r100);
        getWebpAnimView().setPadding(0, 0, 0, 0);
    }

    public /* synthetic */ VirtualAvatarPauseTipsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
