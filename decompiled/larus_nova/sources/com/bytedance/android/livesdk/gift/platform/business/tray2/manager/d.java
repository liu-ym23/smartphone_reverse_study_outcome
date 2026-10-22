package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import android.os.Message;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.k;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.w;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.scope.m;
import com.tencent.open.SocialConstants;
import defpackage.l0;
import i12.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends a<EffectMessage> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f130397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f130398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f130399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f130400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f130401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IAssetsManager f130402n;

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a
    public final y02.f<EffectMessage> f() {
        return new y02.c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a, com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final /* bridge */ /* synthetic */ Object c() {
        return p();
    }

    public final EffectMessage p() {
        EffectMessage r100 = (EffectMessage) super.c();
        if (r100 == null) goto L5;
        r100.a(9, com.bytedance.live.kmp.util.e.b());
        return r100;
    L5:
        return null;
    }

    public d(AssetsService r100) {
        Intrinsics.checkNotNullParameter(r100, "mAssetsManager");
        this.f130402n = r100;
        this.f130397i = 200;
        this.f130398j = 500;
        this.f130399k = 400;
        Intrinsics.checkNotNullParameter("EffectMsgManager", "<set-?>");
        this.f130384a = "EffectMsgManager";
        i12.e r101 = o.b();
        if (r101 == null) goto L5;
        Object r102 = m.f163449e.d(r101, w.class);
    L6:
        this.f130400l = (w) r102;
        this.f130401m = LazyKt.lazy(EffectMsgManager$assetFindFailReport$2.INSTANCE);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.a
    public final void h(Message r100) {
        String r101 = this.f130384a;
        StringBuilder r102 = new StringBuilder("WARNING: consume timeout ");
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.arg1);
    L6:
        r102.append(r103);
        r102.append(", force trigger consume next EffectMessage!");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r101, r102.toString());
        super.h(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final int n(EffectMessage r110) {
        boolean r100 = true;
        if (r110 != null) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "onMessageReceived: effectMessage is null");
        return 1;
    L6:
        int r101 = 4;
        r110.a(4, com.bytedance.live.kmp.util.e.b());
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.d(Long.valueOf(r110.f126017a), "onMessageRecived");
        h2 r102 = u.e(r110);
        if (r102 != null) goto L10;
        m("找不到该礼物", r110);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "onMessageReceived: 找不到该礼物 " + r110);
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.a() == true) goto L12;
    L14:
        boolean r103 = false;
    L15:
        List<Long> r104 = null;
        long[] r105 = (long[]) com.bytedance.android.livesdk.gift.platform.business.effect.a.O.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a[39]);
        if (r102 == null) goto L18;
        long r111 = r102.getId();
    L20:
        if (ArraysKt.contains(r105, r111) == false) goto L22;
        if (r103 == false) goto L47;
        List r106 = CollectionsKt.toMutableList(r110.M);
    L54:
        if (r106.contains(Long.valueOf(r110.f126018b)) == true) goto L56;
        r106.add(Long.valueOf(r110.f126018b));
    L56:
        Iterator r107 = r106.iterator();
    L58:
        if (r107.hasNext() == false) goto L78;
        long r108 = ((Number) r107.next()).longValue();
        com.bytedance.android.live.core.resources.e r109 = this.f130402n.G1(r108);
        if (r109 == null) goto L61;
        if (this.f130402n.O9(r109) == false) goto L68;
        if (r109.getResourceType() == 9) goto L72;
        if (r109.getId() != r110.f126018b) goto L58;
        r110.f126022f = r109.getResourceType();
        goto L58
    L72:
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.b(Long.valueOf(r110.f126017a), "is multi effect");
        return 4;
    L68:
        m("assets 有效性校验失败", r110);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.a(Long.valueOf(r110.f126017a), "is not valid " + r109.getId(), new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, this.f130384a + " onMsgReceived asset not valid"));
        return 3;
    L61:
        m("特效列表找不到该Id", r110);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "onMessageReceived: 特效列表找不到该 Id " + r110);
        if (((Boolean) this.f130401m.getValue()).booleanValue() == false) goto L151;
        h.u(r108, -2, "-2", -2, -2, -2);
        return 2;
    L151:
        return 2;
    L78:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().b() == false) goto L92;
        if (r103 == true) goto L92;
        String r112 = r110.f126020d;
        if (r112 == null) goto L92;
        if (r112.length() <= 0) goto L85;
        boolean r113 = true;
    L86:
        if (r113 != true) goto L92;
        if (r110.f126022f != 11) goto L92;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.b(Long.valueOf(r110.f126017a), "resource ready, skip download");
        o(r110, this.f130397i);
        return 0;
    L85:
        r113 = false;
    L92:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.d().a() == false) goto L104;
        if (r103 == true) goto L104;
        String r114 = r110.f126020d;
        if (r114 == null) goto L104;
        if (r114.length() <= 0) goto L99;
        boolean r115 = true;
    L100:
        if (r115 != true) goto L104;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.b(Long.valueOf(r110.f126017a), "resource ready, skip download");
        o(r110, this.f130397i);
        return 0;
    L99:
        r115 = false;
    L104:
        if (r110.f126039w == false) goto L106;
        AssetDownloadPriority r116 = AssetDownloadPriority.LOCAL;
    L107:
        AssetDownloadPriority r117 = r116;
        Iterator<Map.Entry<Long, iy1.a>> r118 = r110.f126021e.entrySet().iterator();
    L109:
        if (r118.hasNext() == false) goto L116;
        Long r119 = r118.next().getKey();
        String r120 = this.f130402n.D1(r119.longValue());
        if (r120 == null) goto L109;
        w r121 = this.f130400l;
        if (r121 == null) goto L115;
        r121.a(r120);
    L115:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftAssetClean", "资源ID：" + r119 + ", md5: " + r120 + ", 最近使用时间：" + (com.bytedance.live.kmp.util.e.b() / ((long) 1000)));
        goto L109
    L116:
        r110.a(6, com.bytedance.live.kmp.util.e.b());
        if (r106.contains(Long.valueOf(r110.f126018b)) == true) goto L119;
        r100 = true ^ r106.isEmpty();
    L123:
        if (r100 == false) goto L131;
        com.bytedance.android.live.core.resources.e r122 = this.f130402n.G1(r110.f126018b);
        Intrinsics.checkNotNull(r122);
        ArrayList r123 = new ArrayList();
        r123.addAll(r106);
        if (r110.f126039w == true) goto L127;
    L129:
        k.a(this.f130402n, r123, new c(this, r110, r122), r101, r117);
    L137:
        return 0;
    L127:
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().b() == false) goto L129;
        r101 = 1000;
        goto L129
    L131:
        if (r110.f126039w == true) goto L133;
    L135:
        int r124 = 4;
    L136:
        this.f130402n.r0(r110.f126018b, new b(this, r110), r124, r117);
        goto L137
    L133:
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().b() == false) goto L135;
        r124 = 1000;
        goto L136
    L119:
        if (r106.size() > 1) goto L123;
        r100 = false;
        goto L123
    L106:
        r116 = AssetDownloadPriority.OTHER_SEND;
        goto L107
    L47:
        if (r102 == null) goto L52;
        List<Long> r125 = r102.getAssetIds();
        if (r125 == null) goto L52;
        r106 = CollectionsKt.toMutableList(r125);
        if (r106 != null) goto L54;
    L52:
        r106 = new ArrayList();
        goto L54
    L22:
        if (v.a() == false) goto L27;
        String r126 = this.f130384a;
        StringBuilder r127 = new StringBuilder("EffectMsgManager [AssetsInterceptor]  use requiredAssets ");
        if (r102 == null) goto L26;
        r104 = l0.c(r102);
    L26:
        r127.append(r104);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r126, r127.toString());
    L27:
        if (r102 != null) goto L29;
    L44:
        r106 = CollectionsKt.arrayListOf(new Long[]{Long.valueOf(r110.f126018b)});
        goto L54
    L29:
        if (r102.getType() != 13) goto L44;
        List<Long> r128 = l0.c(r102);
        if (r128 == null) goto L34;
        int r129 = r128.size();
    L35:
        if (r129 <= 0) goto L41;
        List<Long> r130 = l0.c(r102);
        if (r130 == null) goto L40;
        r106 = CollectionsKt.toMutableList(r130);
        if (r106 != null) goto L54;
    L40:
        r106 = new ArrayList();
        goto L54
    L41:
        r106 = CollectionsKt.toMutableList(r102.getAssetIds());
        if (r106 != null) goto L54;
        r106 = new ArrayList();
        goto L54
    L34:
        r129 = 0;
        goto L35
    L18:
        r111 = 0;
        goto L20
    L12:
        if ((!r110.M.isEmpty()) == false) goto L14;
        r103 = true;
        goto L15
    }

    public static void m(String r100, EffectMessage r101) {
        HashMap r102 = new HashMap();
        r102.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r101.f126028l));
        r102.put("msg_id", Long.valueOf(r101.f126017a));
        r102.put("asset_id", Long.valueOf(r101.f126018b));
        r102.put("log_id", r101.f126030n);
        if (r100.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102.put(SocialConstants.PARAM_APP_DESC, r100);
    L8:
        jy0.b.c("ttlive_gift", r102.toString(), null, 4);
        return;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void o(EffectMessage r100, int r101) {
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e.f132073c.d(Long.valueOf(r100.f126017a), "onMsgLoadEffectOnce isSuccess:" + r101);
        String r102 = v12.f.f552411a;
        v12.f.y(r100, this.f130389f.size(), r101);
        r100.a(8, com.bytedance.live.kmp.util.e.b());
        r100.a(14, this.f130389f.size());
        if (r100.f126023g == true) goto L5;
    L7:
        this.f130389f.put((T) r100);
        if (r101 == this.f130397i) goto L12;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "onMsgLoadEffectOnce not success, eId:" + r100.f126018b + " resCode:" + r101);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a(Long.valueOf(r100.f126017a), "effectLoad failed eid:" + r100.f126018b + " path:" + r100.f126020d, "", new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.RESOURCE_ERROR, "effectLoad failed"));
        return;
    L12:
        return;
    L5:
        if (r101 != this.f130397i) goto L7;
        this.f130389f.putFirst((T) r100);
    }
}
