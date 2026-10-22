package com.bytedance.android.live.ktv.common.ordersong.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvMusicTagsView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMusicTagsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f70220a = 0;

    public KtvMusicTagsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMusicTagsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(List<String> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, PromotionProductPrivilegesStruct.TAGS);
        if (r110.isEmpty() == false) goto L6;
        setVisibility(8);
        return;
    L6:
        setVisibility(0);
        int r100 = r110.size();
        if (getChildCount() <= r100) goto L12;
        int r112 = getChildCount() - r100;
        int r101 = 0;
    L9:
        if (r101 >= r112) goto L30;
        getChildAt((getChildCount() - r101) - 1).setVisibility(8);
        r101 = r101 + 1;
    L30:
        Iterator<T> r113 = r110.iterator();
        int r114 = 0;
    L32:
        if (r113.hasNext() == false) goto L41;
        Object r102 = r113.next();
        int r103 = r114 + 1;
        if (r114 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        String r104 = (String) r102;
        View r115 = getChildAt(r114);
        if (r115 == null) goto L40;
        TextView r116 = (TextView) r115;
        r116.setVisibility(0);
        r116.setText(r104);
        r114 = r103;
        goto L32
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L41:
        return;
    L12:
        if (getChildCount() >= r100) goto L30;
        int r105 = s1.f(2.0f);
        int r106 = r100 - getChildCount();
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L30;
        if (getChildCount() != 0) goto L20;
        if (r107 != 0) goto L20;
        boolean r108 = false;
    L21:
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -2);
        if (r108 == false) goto L24;
        int r117 = s1.f(3.0f);
    L25:
        r109.leftMargin = r117;
        TextView r118 = new TextView(getContext());
        r118.setGravity(17);
        r118.setBackground(s1.m(KtvOrderSongThemeManager.a(104)));
        KtvOrderSongThemeManager.d(r118, 105);
        r118.setPadding(r105, 0, r105, 0);
        if (r111 == false) goto L28;
        r118.setTextSize(2, 9.0f);
    L29:
        addView(r118, r109);
        r107 = r107 + 1;
        goto L14
    L28:
        r118.setTextSize(1, 9.0f);
        goto L29
    L24:
        r117 = 0;
    L20:
        r108 = true;
        goto L21
    }

    public KtvMusicTagsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ KtvMusicTagsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
