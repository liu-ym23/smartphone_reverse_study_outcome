package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonSingleAvatarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonSingleAvatarView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f144133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f144134b;

    public KtvCommonSingleAvatarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvCommonSingleAvatarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public KtvCommonSingleAvatarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_user_info_layout, this, true);
        if (r103 == null) goto L5;
        LinearLayout r104 = (LinearLayout) r103.findViewById(R.id.user_info_ll);
    L5:
        TextView r105 = null;
        if (r103 == null) goto L8;
        HSImageView r106 = (HSImageView) r103.findViewById(R.id.user_avatar_iv);
    L9:
        this.f144133a = r106;
        if (r103 == null) goto L12;
        r105 = (TextView) r103.findViewById(R.id.user_name_tv);
    L12:
        this.f144134b = r105;
        return;
    L8:
        r106 = null;
        goto L9
    }

    public /* synthetic */ KtvCommonSingleAvatarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
