package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSlideTabItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSlideTabItemView extends LinearLayout {
    public StickerSlideTabItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerSlideTabItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public StickerSlideTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(1);
        SimpleDraweeView r103 = new SimpleDraweeView(r100);
        r103.setId(R.id.icon);
        int r104 = (int) t6.a(r100, 13.0f);
        int r105 = (int) t6.a(r100, 3.0f);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(r104, r104);
        r106.gravity = 1;
        r106.rightMargin = r105;
        r103.setVisibility(8);
        addView(r103, r106);
        TextView r107 = new TextView(r100);
        r107.setId(R.id.text);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.gravity = 17;
        addView(r107, r108);
        View r109 = new View(r100);
        r109.setId(R.id.tab_dot);
        int r110 = (int) t6.a(r100, 6.0f);
        int r111 = (int) t6.a(r100, 9.0f);
        int r112 = (int) t6.a(r100, 5.0f);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(r110, r110);
        r113.topMargin = r111;
        r113.rightMargin = r112;
        addView(r109, r113);
    }

    public /* synthetic */ StickerSlideTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
