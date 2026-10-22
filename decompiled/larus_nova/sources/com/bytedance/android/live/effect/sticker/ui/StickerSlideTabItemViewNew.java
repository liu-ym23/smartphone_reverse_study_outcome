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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSlideTabItemViewNew;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSlideTabItemViewNew extends LinearLayout {
    public StickerSlideTabItemViewNew(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerSlideTabItemViewNew(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public StickerSlideTabItemViewNew(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(1);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setId(R.id.tab_container);
        SimpleDraweeView r104 = new SimpleDraweeView(r100);
        r104.setId(R.id.icon);
        int r105 = (int) t6.a(r100, 13.0f);
        int r106 = (int) t6.a(r100, 3.0f);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r105, r105);
        r107.gravity = 1;
        r107.rightMargin = r106;
        r104.setVisibility(8);
        r103.addView(r104, r107);
        TextView r108 = new TextView(r100);
        r108.setId(R.id.text);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -2);
        r109.gravity = 17;
        r103.addView(r108, r109);
        View r110 = new View(r100);
        r110.setId(R.id.tab_dot);
        int r111 = (int) t6.a(r100, 6.0f);
        int r112 = (int) t6.a(r100, 9.0f);
        int r113 = (int) t6.a(r100, 5.0f);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(r111, r111);
        r114.topMargin = r112;
        r114.rightMargin = r113;
        r103.addView(r110, r114);
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -1);
        r115.gravity = 16;
        addView(r103, r115);
    }

    public /* synthetic */ StickerSlideTabItemViewNew(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
