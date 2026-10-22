package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i12.e;
import i12.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import py.k;
import qz1.u;
import qz1.v;
import rz1.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleSweepGiftViewHolder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleGiftViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SimpleSweepGiftViewHolder extends SimpleGiftViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f126737e;

    public abstract b V3();

    public abstract GiftIconMaskView W3();

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean Y3() {
        AbsPanel r100 = this.f126733b;
        V3().b();
        this.f126737e.clear();
        if (r100 != null) goto L5;
    L99:
        return false;
    L5:
        if (r100.h() == true) goto L99;
        long r101 = r100.c();
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L24;
        GiftContext r102 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r102);
        if (r102.getLastSendGiftId() == null) goto L24;
        GiftContext r103 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r103);
        if (r103.getLastSendGiftId().getValue() == null) goto L24;
        GiftContext r104 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r104);
        long r105 = r104.getLastSendGiftId().getValue().f130417a;
        if (r105 == 0) goto L18;
    L20:
        if (r105 == 0) goto L24;
        if (r105 != r101) goto L24;
    L23:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L99;
        T r107 = r100.f126620h;
        if ((r107 instanceof h1) == true) goto L31;
        return false;
    L31:
        if (r107 == 0) goto L98;
        h1 r108 = (h1) r107;
        if (r108.getSweepLightCount() != 0) goto L35;
    L96:
        return false;
    L35:
        if (r108.isHasSweepLight() == true) goto L96;
        long r109 = r108.getId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r110 = ay1.b.f16705p;
        KProperty<?>[] r111 = ay1.b.f16675a;
        if (((HashSet) r110.getValue(null, r111[18])).contains(String.valueOf(r109)) == false) goto L40;
        return false;
    L40:
        T r112 = this.f126733b.f126620h;
        if ((r112 instanceof h1) == false) goto L71;
        if (r112 == 0) goto L70;
        h1 r113 = (h1) r112;
        e r114 = o.b();
        if (r114 == null) goto L46;
        Object r115 = m.f163449e.d(r114, GiftExtraRepo.class);
    L47:
        GiftExtraRepo r116 = (GiftExtraRepo) r115;
        if (r116 == null) goto L50;
        g0 r117 = r116.q(r113.getId());
    L51:
        if (r117 == null) goto L71;
        k0 r118 = r113.getGiftPreviewInfo();
        if (r118 != null) goto L55;
    L57:
        boolean r119 = false;
    L59:
        if (r117.getSubscribeGiftPackInfo() == null) goto L65;
        q3 r120 = r117.getSubscribeGiftPackInfo();
        Intrinsics.checkNotNull(r120);
        if (r120.getRelatedGiftId() == 0) goto L65;
        if (r119 == false) goto L65;
    L68:
        boolean r121 = true;
    L72:
        if (r121 == false) goto L74;
        return false;
    L74:
        String r122 = ay1.b.l().get(String.valueOf(this.f126733b.c()));
        if (r122 == null) goto L77;
        int r123 = CastIntegerProtector.parseInt(r122);
    L79:
        if (r123 < r108.getSweepLightCount()) goto L81;
        return false;
    L81:
        HashMap<String, String> r124 = ay1.b.l();
        r124.put(String.valueOf(this.f126733b.c()), String.valueOf(r123 + 1));
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        ay1.b.f16707q.setValue(null, r111[19], r124);
        T r125 = r100.f126620h;
        if (r125 == 0) goto L95;
        ((h1) r125).setHasSweepLight(true);
        AbsPanel r126 = this.f126733b;
        T r127 = r126.f126620h;
        if ((r127 instanceof h1) == false) goto L91;
        if (r127 == 0) goto L90;
        h2 r128 = rz1.a.b(Long.valueOf(((h1) r127).getId()));
        if (r128 == null) goto L91;
        k r129 = r128.getImage();
    L92:
        a1.k(r129).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(this), new v(this));
        return true;
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L91:
        r129 = r126.d();
        goto L92
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L77:
        r123 = 0;
    L65:
        if (r117.getGiftBuffInfos().isEmpty() == true) goto L71;
        if (ay1.b.j().contains(String.valueOf(r113.getId())) == false) goto L71;
    L55:
        if (r118.getLockStatus() != k0.UNLOCKED) goto L57;
        r119 = true;
        goto L59
    L50:
        r117 = null;
        goto L51
    L46:
        r115 = null;
        goto L47
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L71:
        r121 = false;
        goto L72
    L98:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L18:
        if (this.f126629a != 0) goto L20;
    L24:
        r106 = false;
        goto L25
    }

    public SimpleSweepGiftViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f126737e = new CompositeDisposable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void X3(long r100) {
        com.bytedance.tools.kcp.spongepreference.runtime.a r101 = ay1.b.f16705p;
        KProperty<?>[] r102 = ay1.b.f16675a;
        HashSet r103 = (HashSet) r101.getValue(null, r102[18]);
        r103.add(String.valueOf(r100));
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.setValue(null, r102[18], r103);
    }
}
