package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.View;
import com.bytedance.android.livesdk.config.as0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f106646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f106647b = null;

    static {
        f106646a = (Map) as0.f119816a.getValue();
        f106647b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.Unknown.getTypeId()), "短触"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.CNYALuckyBox.getTypeId()), "红包"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.DTaskLuckyBox.getTypeId()), "红包"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.OfficialInteractiveLuckyBox.getTypeId()), "红包"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.RegularLuckyBox.getTypeId()), "红包"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.GiftVote.getTypeId()), "礼物投票"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.Lottery.getTypeId()), "福袋"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.CommerceRaffleTicket.getTypeId()), "优惠券"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.PopularCard.getTypeId()), "人气卡"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.LiveTC.getTypeId()), "红包"), TuplesKt.to(Integer.valueOf(ShortTermIndicatorConfig.ElementType.CommerceLottery.getTypeId()), "福袋")});
    }

    @JvmStatic
    public static final String b(int r100) {
        String r101 = f106646a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = f106647b.get(Integer.valueOf(r100));
    L5:
        if (r101 != null) goto L8;
        return "短触";
    L8:
        return r101;
    }

    @JvmStatic
    public static final void a(int r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "view");
        if (ShortTermIndicatorConfig.ElementType.Companion.getByTypeId(r100) == null) goto L16;
        r101.setFocusable(true);
        if (r102 > 0) goto L7;
        String r103 = b(r100);
    L13:
        if (r100 == ShortTermIndicatorConfig.ElementType.CommerceRaffleTicket.getTypeId()) goto L17;
        r3.c(r101, r103, true);
        return;
    L17:
        return;
    L7:
        long r104 = 60;
        long r105 = r102 / r104;
        long r106 = r102 % r104;
        if (r105 <= 0) goto L10;
        StringBuilder r107 = new StringBuilder();
        r107.append(r105);
        r107.append(20998);
        r107.append(r106);
        r107.append(31186);
        String r108 = r107.toString();
    L11:
        r103 = b(r100) + 65292 + r108;
        goto L13
    L10:
        StringBuilder r109 = new StringBuilder();
        r109.append(r106);
        r109.append(31186);
        r108 = r109.toString();
        goto L11
    }
}
