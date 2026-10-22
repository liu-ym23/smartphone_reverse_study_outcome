package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftListFilterService implements dy0.c, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yz0.k f130538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f130539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f130540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f130541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f130542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Long> f130543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v1 f130544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f130545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AssetsService f130546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ResourceRecordService f130547j;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final boolean a(h1 r110) {
        com.bytedance.android.live.core.resources.e r100 = this.f130546i.G1(r110.getPrimaryEffectId());
        int r101 = 4;
        if (r110.getType() != 4) goto L28;
        if (((Boolean) this.f130541d.getValue()).booleanValue() == false) goto L7;
        boolean r102 = this.f130540c;
    L8:
        if (r102 == false) goto L28;
        if (this.f130546i.g1(r110.getPrimaryEffectId()) == true) goto L28;
        if (r110.getGiftSource() == 1) goto L28;
        int r103 = r110.getType();
        if (r100 == null) goto L16;
        int r104 = r100.getResourceType();
    L18:
        if (h(r103, r104, r110.getId()) == false) goto L20;
    L26:
        return true;
    L20:
        if (this.f130539b == true) goto L26;
        if (((ArrayList) this.f130543f).contains(Long.valueOf(r110.getPrimaryEffectId())) == true) goto L25;
        ((ArrayList) this.f130543f).add(Long.valueOf(r110.getPrimaryEffectId()));
    L25:
        return false;
    L16:
        r104 = 0;
        goto L18
    L7:
        r102 = g02.a.e();
    L28:
        if (this.f130539b == false) goto L32;
        r110.setFreeDisplay(true);
        return true;
    L32:
        if (r110.getType() != 2) goto L34;
    L41:
        Iterator<Long> r105 = r110.getAssetIds().iterator();
    L43:
        if (r105.hasNext() == false) goto L59;
        long r106 = r105.next().longValue();
        com.bytedance.android.live.core.resources.e r107 = this.f130546i.G1(r106);
        if (r107 != null) goto L47;
    L51:
        List<Long> r108 = r110.getOptionalAssetIds();
        if (r108 == null) goto L57;
        if (r108.contains(Long.valueOf(r106)) == true) goto L43;
    L57:
        if (this.f130546i.g1(r106) == true) goto L43;
        boolean r109 = false;
    L60:
        if (r109 == true) goto L79;
        int r111 = r110.getType();
        if (r100 == null) goto L65;
        r101 = r100.getResourceType();
    L65:
        if (h(r111, r101, r110.getId()) == false) goto L68;
        r110.setFreeDisplay(true);
        return true;
    L68:
        Iterator<Long> r112 = r110.getAssetIds().iterator();
    L70:
        if (r112.hasNext() == false) goto L77;
        long r113 = r112.next().longValue();
        String r114 = this.f130546i.D1(r113);
        if (r114 == null) goto L70;
        this.f130547j.x(r114, true, r113);
        if (((ArrayList) this.f130543f).contains(Long.valueOf(r113)) == true) goto L70;
        ((ArrayList) this.f130543f).add(Long.valueOf(r113));
        goto L70
    L77:
        this.f130542e++;
        return false;
    L79:
        return true;
    L47:
        if (r107.getDownloadType() != 3) goto L51;
        jy0.b.a("GiftListFilterHelper", "打开礼物面板直接展示懒下载礼物，资源id：" + r106);
        if (this.f130546i.g1(r106) == true) goto L59;
        r110.setFreeDisplay(true);
    L59:
        r109 = true;
        goto L60
    L34:
        if (r110.getType() == 8) goto L41;
        if (r110.getType() == 11) goto L41;
        if (r110.getType() == 13) goto L41;
        if (r110.getType() != 15) goto L79;
        goto L41
    }

    public final boolean f(h1 r100) {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.f127396g.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.f127395f == true) goto L5;
    L7:
        yz0.k r101 = this.f130538a;
        if (r101 == null) goto L10;
        IRoom r102 = r101.getRoom();
    L11:
        if (r102 != null) goto L49;
        AssetsService r103 = this.f130546i;
        Intrinsics.checkNotNullParameter(r100, "$this$isValidEffectGift");
        Intrinsics.checkNotNullParameter(r103, "assetsService");
        if (r100.getType() != 2) goto L15;
    L20:
        GiftPanelBizBoostUtils.E.getClass();
        boolean r104 = GiftPanelBizBoostUtils.e();
        Iterator<Long> r105 = r100.getAssetIds().iterator();
    L22:
        if (r105.hasNext() == false) goto L37;
        long r106 = r105.next().longValue();
        if (r104 == false) goto L26;
        AssetsService r107 = r103;
    L28:
        if (r107.g1(r106) == false) goto L37;
        if (r104 == false) goto L32;
        com.bytedance.android.live.core.resources.e r108 = r103.G1(r106);
    L33:
        if (r108 == null) goto L22;
        if (r108.getResourceType() != 8) goto L22;
        boolean r109 = true;
    L38:
        if (r109 == false) goto L50;
        return false;
    L50:
        return true;
    L32:
        r108 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r106);
        goto L33
    L26:
        r107 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
    L37:
        r109 = false;
        goto L38
    L15:
        if (r100.getType() == 8) goto L20;
        if (r100.getType() == 11) goto L20;
        if (r100.getType() != 13) goto L37;
    L49:
        return true;
    L10:
        r102 = null;
        goto L11
    L5:
        if (this.f130545h == null) goto L7;
        return true;
    }

    public GiftListFilterService(AssetsService r100, ResourceRecordService r101) {
        Intrinsics.checkNotNullParameter(r100, "assetsService");
        Intrinsics.checkNotNullParameter(r101, "resourceRecordService");
        this.f130546i = r100;
        this.f130547j = r101;
        yz0.k r102 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        this.f130538a = r102;
        boolean r103 = AssetsUtils.f129072b;
        if (r102 == null) goto L5;
        boolean r104 = r102.isAnchor();
    L6:
        this.f130539b = AssetsUtils.b(r104);
        this.f130541d = LazyKt.lazy(GiftListFilterService$newListOpt$2.INSTANCE);
        this.f130543f = new ArrayList();
        this.f130544g = com.bytedance.android.livesdk.gift.platform.business.i.m();
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final boolean g(h1 r100, ReceiverType r101) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r101 == null) goto L13;
        int r102 = c.f130587a[r101.ordinal()];
        if (r102 == 1) goto L24;
        if (r102 != 2) goto L13;
    L24:
        if (r100.isDisplayedOnPanel() == true) goto L26;
    L30:
        return false;
    L26:
        if (f(r100) == false) goto L30;
        if (a(r100) == false) goto L30;
        return true;
    L13:
        if (r100.isDisplayedOnPanel() == true) goto L15;
    L21:
        return false;
    L15:
        if (f(r100) == false) goto L21;
        if (a(r100) == false) goto L21;
        if (r100.isForLinkMic() == false) goto L21;
        return true;
    }

    public final boolean h(int r100, int r101, long r102) {
        if (this.f130544g.getEnable() == true) goto L5;
        return false;
    L5:
        List<Long> r103 = this.f130544g.f2();
        if (r103 == null) goto L11;
        if (r103.contains(Long.valueOf(r102)) != true) goto L11;
        return false;
    L11:
        if (this.f130544g.s3().contains(Integer.valueOf(r100)) == false) goto L14;
        return false;
    L14:
        if (this.f130544g.z5().contains(Integer.valueOf(r101)) == false) goto L16;
        return false;
    L16:
        return true;
    }
}
