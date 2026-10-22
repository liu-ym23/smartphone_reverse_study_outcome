package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/common/GameNetStateView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameNetStateView extends LinearLayout {
    public GameNetStateView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameNetStateView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public GameNetStateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setBackground(s1.m(R.drawable.ttlive_bg_pk_game_net_state));
        setPadding(UtilityKotlinExtentionsKt.i(8), 0, UtilityKotlinExtentionsKt.i(8), 0);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -1);
        r103.gravity = 16;
        TextView r104 = new TextView(r100);
        r104.setGravity(17);
        r104.setTextSize(10.0f);
        r104.setTextColor(s1.h(R.color.white));
        r104.setLayoutParams(r103);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(s1.f(16.0f), s1.f(16.0f));
        r105.gravity = 16;
        ImageView r106 = new ImageView(r100);
        r106.setLayoutParams(r105);
        r106.setImageResource(R.drawable.ttlive_revlink_game_net_recover);
        addView(r106);
        addView(r104);
    }

    public /* synthetic */ GameNetStateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
