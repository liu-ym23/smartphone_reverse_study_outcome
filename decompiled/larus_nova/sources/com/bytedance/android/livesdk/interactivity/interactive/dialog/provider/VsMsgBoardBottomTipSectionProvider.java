package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class VsMsgBoardBottomTipSectionProvider implements k82.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VSInputSectionType f137236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k82.a f137237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f137238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f137239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Interpolator f137240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f137241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public VSInputSectionType f137242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VsMsgBoardBottomTipSectionProvider$sectionBridge$1 f137243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f137244i;

    public static final class a {
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final k82.c c() {
        return null;
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.f137236a;
    }

    public final Context getContext() {
        return this.f137244i;
    }

    public VsMsgBoardBottomTipSectionProvider(Context r100) {
        this.f137244i = r100;
        this.f137236a = VSInputSectionType.BOTTOM_TIP;
        this.f137240e = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        this.f137242g = VSInputSectionType.KEYBOARD;
        this.f137243h = new VsMsgBoardBottomTipSectionProvider$sectionBridge$1(this);
    }

    @Override // k82.d
    public final View g(h82.b r100) {
        Intrinsics.checkNotNullParameter(r100, "panelBridge");
        this.f137237b = r100;
        LayoutInflater r101 = LayoutInflater.from(this.f137244i);
        t9 r102 = r100.f484061h.f137180d;
        if (r102 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
    L11:
        int r103 = R.layout.ttlive_section_vs_msg_board_bottom_tip_landscape;
    L12:
        ViewGroup.LayoutParams r104 = null;
        View r105 = r101.inflate(r103, null);
        this.f137238c = r105;
        if (r105 == null) goto L15;
        TextView r106 = (TextView) r105.findViewById(R.id.btn_buy);
    L16:
        this.f137239d = r106;
        t9 r107 = r100.f484061h.f137180d;
        if (r107 != null) goto L19;
    L27:
        TextView r108 = this.f137239d;
        if (r108 == null) goto L30;
        r104 = r108.getLayoutParams();
    L30:
        t9 r109 = r100.f484061h.f137180d;
        if (r109 != null) goto L33;
    L35:
        double r110 = 0.42d;
    L36:
        if (r104 == null) goto L38;
        r104.width = (int) (((double) com.bytedance.android.annie.util.p.f40070a.e()) * r110);
    L38:
        TextView r111 = this.f137239d;
        if (r111 == null) goto L42;
        r111.setLayoutParams(r104);
    L42:
        return this.f137238c;
    L33:
        if (r109.f114224h != true) goto L35;
        r110 = 0.5d;
        goto L36
    L19:
        if (r107.f114223g != true) goto L27;
        if (r107 == null) goto L24;
        if (r107.f114224h == true) goto L27;
    L24:
        if (FoldScreenUtils.f() == false) goto L42;
        if (FoldScreenUtils.e() == false) goto L42;
    L15:
        r106 = null;
        goto L16
    L9:
        if (r102.f114223g != true) goto L11;
        r103 = R.layout.ttlive_section_vs_msg_board_bottom_tip;
        goto L12
    L5:
        if (r102.f114224h != true) goto L7;
        r103 = R.layout.ttlive_section_vs_msg_board_bottom_tip_pad;
        goto L12
    }

    @Override // k82.d
    public final void h(VSInputSectionType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionType");
        Intrinsics.checkNotNullParameter(r101, "view");
        k82.d.a.a(r100, r101);
    }

    public static final void f(VsMsgBoardBottomTipSectionProvider r100, boolean r101, SkinSelection r102) {
        if (r101 == false) goto L21;
        r100.getClass();
        int r103 = l82.a.f507909a;
        String r104 = "";
        if (r102 == null) goto L7;
        String r105 = r102.f137175a;
        if (r105 == null) goto L7;
    L8:
        if (r102 == null) goto L13;
        String r106 = r102.f137176b;
        if (r106 == null) goto L13;
        r104 = r106;
    L13:
        k82.a r107 = r100.f137237b;
        if (r107 == null) goto L16;
        Map<String, String> r108 = r107.o();
    L17:
        Intrinsics.checkNotNullParameter(r105, "skinId");
        Intrinsics.checkNotNullParameter(r104, "badgeId");
        LinkedHashMap r109 = new LinkedHashMap();
        if (r108 == null) goto L20;
        r109.putAll(r108);
    L20:
        r109.put("vs_medal_id", r104);
        r109.put("vs_skin_id", r105);
        Unit r110 = Unit.INSTANCE;
        l82.a.e("livesdk_vs_guest_book_skin_buy_icon_show", r109);
        goto L21
    L16:
        r108 = null;
    L7:
        r105 = "";
    L21:
        k82.a r111 = r100.f137237b;
        if (r111 == null) goto L25;
        r111.w(r101);
    L25:
        if (r101 == r100.f137241f) goto L54;
        r100.f137241f = r101;
        if (r100.f137242g != VSInputSectionType.KEYBOARD) goto L46;
        if (r101 == false) goto L38;
        View r112 = r100.f137238c;
        if (r112 == null) goto L33;
        UtilityKotlinExtentionsKt.z(r112, true);
    L33:
        View r113 = r100.f137238c;
        if (r113 == null) goto L48;
        ViewGroup r114 = UtilityKotlinExtentionsKt.p(r113);
        if (r114 == null) goto L49;
        UtilityKotlinExtentionsKt.z(r114, true);
        return;
    L49:
        return;
    L48:
        return;
    L38:
        View r115 = r100.f137238c;
        if (r115 == null) goto L41;
        UtilityKotlinExtentionsKt.z(r115, false);
    L41:
        View r116 = r100.f137238c;
        if (r116 == null) goto L51;
        ViewGroup r117 = UtilityKotlinExtentionsKt.p(r116);
        if (r117 == null) goto L52;
        UtilityKotlinExtentionsKt.z(r117, false);
        return;
    L52:
        return;
    L51:
        return;
    L46:
        ValueAnimator r118 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(300);
        r118.addUpdateListener(new u(r100, r101, r118));
        r118.setInterpolator(r100.f137240e);
        r118.start();
        return;
    }
}
