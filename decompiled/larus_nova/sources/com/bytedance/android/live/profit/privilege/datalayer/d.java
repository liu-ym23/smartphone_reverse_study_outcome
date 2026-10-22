package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.profit.privilege.model.touch.GrowthTouchData$Position;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.live.profit.privilege.model.touch.s;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f88382l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f88391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final yz0.g f88392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.i f88393k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final IBaseUser b() {
        IBaseUser r100 = this.f88392j.getUser();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUserKt /* = com.bytedance.android.live.base.model.user.IBaseUser */");
    }

    public final String c() {
        IBaseUser r100 = this.f88392j.getRoom().getOwnerKt();
        if (r100 == null) goto L6;
        String r101 = r100.getIdString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final long d() {
        return IRoomKtKt.getId(this.f88392j.getRoom());
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f88383a.dispose();
    }

    public final String f() {
        return b().getIdString();
    }

    public d(yz0.g r510, com.bytedance.android.live.recharge.i r511) {
        Intrinsics.checkNotNullParameter(r510, "roomDataService");
        Intrinsics.checkNotNullParameter(r511, "walletService");
        this.f88392j = r510;
        this.f88393k = r511;
        this.f88383a = new CompositeDisposable();
        com.bytedance.android.live.revenue.common.reactive.c r100 = new com.bytedance.android.live.revenue.common.reactive.c(new DanmakuTabList(null, false, false, 0, 0, null, 63, null));
        this.f88384b = r100;
        Intrinsics.checkNotNullParameter(r100, "$this$asReadonly");
        this.f88385c = r100;
        com.bytedance.android.live.revenue.common.reactive.c r101 = new com.bytedance.android.live.revenue.common.reactive.c(new TouchPositionData(null, false, null, 7, null));
        this.f88386d = r101;
        Intrinsics.checkNotNullParameter(r101, "$this$asReadonly");
        this.f88387e = r101;
        py.d r102 = b().getUserHonor();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "$this$toPayGrade");
        long r103 = r102.getScore();
        Intrinsics.checkNotNullParameter(r102, "$this$levelKt");
        long r104 = r102.getLevel();
        long r110 = r102.getThisGradeMaxDiamond();
        PayGrade r105 = new PayGrade(r103, r104, r102.getThisGradeMinDiamond(), r110, r102.getGradeDescribe(), r102.getNewImIconWithLevel(), r102.getNewLiveIcon(), r102.getBuffInfo(), r102.getGradeDescribeShining(), 0, null, 0, null, null, null, null, 0, 0, r102.getRecentConsumeBadge(), 261120, null);
    L6:
        com.bytedance.android.live.revenue.common.reactive.c r106 = new com.bytedance.android.live.revenue.common.reactive.c(r105);
        this.f88388f = r106;
        Intrinsics.checkNotNullParameter(r106, "$this$asReadonly");
        this.f88389g = r106;
        com.bytedance.android.live.revenue.common.reactive.c r107 = new com.bytedance.android.live.revenue.common.reactive.c(new GiftPanelTouchData(null, 1, null));
        this.f88390h = r107;
        Intrinsics.checkNotNullParameter(r107, "$this$asReadonly");
        this.f88391i = r107;
        return;
    L5:
        r105 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(d r210, Map r211) {
        boolean r100 = true;
        PrivilegeEntranceInfo r101 = null;
        a5 r102 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        r101 = null;
        if (r211 == null) goto L127;
        r210.getClass();
        if (r211.isEmpty() == true) goto L127;
        s r103 = (s) r211.get(Long.valueOf(GrowthTouchData$Position.PositionGiftPanelTop.getValue()));
        if (r103 == null) goto L79;
        List<com.bytedance.android.live.profit.privilege.model.touch.p> r104 = r103.getData();
        if (r104 == null) goto L79;
        com.bytedance.android.live.profit.privilege.model.touch.p r105 = (com.bytedance.android.live.profit.privilege.model.touch.p) ListProtector.get(r104, 0);
        if (r105 == null) goto L79;
        com.bytedance.android.live.profit.privilege.model.touch.q r106 = r105.getDetail();
        if (r106 == null) goto L20;
        com.bytedance.android.live.profit.privilege.model.touch.f r107 = r106.getGiftPanelTopDetail();
        if (r107 == null) goto L20;
        com.bytedance.android.live.profit.privilege.model.touch.o r108 = r107.getButton();
        if (r108 == null) goto L20;
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r109 = r108.getText();
    L21:
        if (r109 != null) goto L23;
        boolean r110 = true;
    L24:
        Intrinsics.checkNotNullParameter(r105, "$this$toTouchPositionsStr");
        if (r105.getMeta() != null) goto L27;
        c.f88381d.setValue(null, c.f88378a[2], null);
        boolean r111 = r110;
    L77:
        String r112 = null;
    L78:
        r100 = r111;
    L80:
        s r113 = (s) r211.get(Long.valueOf(GrowthTouchData$Position.PositionGiftPanelEntrance.getValue()));
        if (r113 == null) goto L126;
        List<com.bytedance.android.live.profit.privilege.model.touch.p> r114 = r113.getData();
        if (r114 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.p r115 = (com.bytedance.android.live.profit.privilege.model.touch.p) ListProtector.get(r114, 0);
        if (r115 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.q r116 = r115.getDetail();
        if (r116 == null) goto L126;
        GiftPanelEntranceDetail r117 = r116.getGiftPanelPrivilegeEntranceInfo();
        if (r117 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.r r118 = r115.getMeta();
        if (r118 == null) goto L93;
        Long r119 = r118.getMetaId();
    L94:
        Intrinsics.checkNotNullParameter(r117, "$this$toPrivilegeEntranceInfo");
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r120 = r117.getPanelDetail();
        if (r120 == null) goto L97;
        a5 r121 = b.a(r120);
    L98:
        String r122 = r117.getPanelUrl();
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r123 = r117.getBubbleText();
        if (r123 == null) goto L101;
        a5 r124 = b.a(r123);
    L102:
        py.k r125 = r117.getBubbleBackgroundImg();
        String r126 = r117.getBubbleUrl();
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r127 = r117.getAwardTips();
        if (r127 == null) goto L105;
        a5 r212 = b.a(r127);
    L106:
        com.bytedance.android.live.profit.privilege.model.touch.h r128 = r117.getLightInfo();
        if (r128 == null) goto L109;
        com.bytedance.android.live.profit.privilege.model.touch.i r213 = new com.bytedance.android.live.profit.privilege.model.touch.i(r128.isOn(), r128.getImage());
    L110:
        com.bytedance.android.live.profit.privilege.model.touch.b r129 = r117.getDynamicInfo();
        if (r129 == null) goto L124;
        Long r130 = r129.getShowAfterTimeMs();
        if (r130 == null) goto L115;
        long r214 = r130.longValue();
        int r131 = 0;
    L116:
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r132 = r129.getText();
        if (r132 == null) goto L119;
        r102 = b.a(r132);
    L119:
        a5 r215 = r102;
        Long r133 = r129.getDurationMs();
        if (r133 == null) goto L122;
        long r134 = r133.longValue();
    L123:
        com.bytedance.android.live.profit.privilege.model.touch.c r216 = new com.bytedance.android.live.profit.privilege.model.touch.c(r214, r215, r134);
    L125:
        r101 = new PrivilegeEntranceInfo(r119, r121, r122, r124, r125, r126, r212, r213, r216, r117.getExtra());
        goto L126
    L122:
        r134 = r131;
        goto L123
    L115:
        r131 = 0;
        r214 = 0;
        goto L116
    L124:
        r216 = null;
        goto L125
    L109:
        r213 = null;
        goto L110
    L105:
        r212 = null;
        goto L106
    L101:
        r124 = null;
        goto L102
    L97:
        r121 = null;
        goto L98
    L93:
        r119 = null;
    L126:
        r210.f88386d.setValue(new TouchPositionData(r112, r100, r101));
        return;
    L27:
        com.bytedance.android.live.profit.privilege.model.touch.r r135 = r105.getMeta();
        if (r135 == null) goto L57;
        List<com.bytedance.android.live.profit.privilege.model.touch.d> r136 = r135.getFreqCtrlParamsList();
        if (r136 == null) goto L57;
        HashMap r137 = (HashMap) c.f88380c.getValue(null, c.f88378a[1]);
        ArrayList r138 = new ArrayList();
        Iterator r139 = r137.entrySet().iterator();
    L33:
        if (r139.hasNext() == false) goto L45;
        Map.Entry r140 = (Map.Entry) r139.next();
        com.bytedance.live.kmp.util.c r141 = com.bytedance.live.kmp.util.c.f255167a;
        long r142 = System.currentTimeMillis();
        Long r143 = com.bytedance.android.live.profit.privilege.model.touch.e.a((com.bytedance.android.live.profit.privilege.model.touch.d) GsonProtectorUtils.fromJson(l97.a.f508113a, (String) r140.getValue(), TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.touch.d.class))));
        if (r143 == null) goto L37;
        long r144 = r143.longValue();
    L39:
        if (r144 <= 0) goto L33;
        boolean r145 = r110;
        if ((r142 / ((long) 1000)) <= r144) goto L43;
        r139.remove();
    L43:
        r110 = r145;
        goto L33
    L37:
        r144 = 0;
        goto L39
    L45:
        r111 = r110;
        Intrinsics.checkNotNullParameter(r137, "<set-?>");
        c.f88380c.setValue(null, c.f88378a[1], r137);
        Iterator<T> r146 = r136.iterator();
    L47:
        if (r146.hasNext() == false) goto L55;
        com.bytedance.android.live.profit.privilege.model.touch.d r147 = (com.bytedance.android.live.profit.privilege.model.touch.d) r146.next();
        if (r137.containsKey(r147.getKey()) == true) goto L50;
        r138.add(r147);
        goto L47
    L50:
        String r148 = (String) r137.get(r147.getKey());
        if (r148 == null) goto L47;
        r138.add((com.bytedance.android.live.profit.privilege.model.touch.d) GsonProtectorUtils.fromJson(l97.a.f508113a, r148, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.touch.d.class))));
        goto L47
    L55:
        if ((!r138.isEmpty()) != true) goto L58;
        com.bytedance.android.live.profit.privilege.model.touch.r r149 = r105.getMeta();
        Intrinsics.checkNotNull(r149);
        r149.setFreqCtrlParamsList(r138);
    L58:
        if (r138 == null) goto L73;
        Iterator r150 = r138.iterator();
    L61:
        if (r150.hasNext() == false) goto L73;
        com.bytedance.android.live.profit.privilege.model.touch.d r151 = (com.bytedance.android.live.profit.privilege.model.touch.d) r150.next();
        Long r152 = r151.getCur();
        if (r152 == null) goto L65;
        long r153 = r152.longValue();
        int r154 = 0;
    L66:
        Long r155 = r151.getLimit();
        if (r155 == null) goto L69;
        long r156 = r155.longValue();
    L71:
        if (r153 < r156) goto L61;
        boolean r157 = false;
    L74:
        if (r157 == false) goto L76;
        com.bytedance.android.live.profit.privilege.model.touch.p[] r158 = new com.bytedance.android.live.profit.privilege.model.touch.p[1];
        r158[r154] = r105;
        r112 = GsonProtectorUtils.toJson(l97.a.f508113a, CollectionsKt.mutableListOf(r158));
        goto L78
    L76:
        c.f88381d.setValue(null, c.f88378a[2], null);
        goto L77
    L69:
        r156 = r154;
        goto L71
    L65:
        r154 = 0;
        r153 = 0;
    L73:
        r154 = 0;
        r157 = true;
    L57:
        r111 = r110;
        r138 = null;
        goto L58
    L23:
        r110 = false;
    L20:
        r109 = null;
    L79:
        r112 = null;
    L127:
        r210.f88386d.setValue(new TouchPositionData(null, true, null));
        c.f88381d.setValue(null, c.f88378a[2], null);
    }
}
