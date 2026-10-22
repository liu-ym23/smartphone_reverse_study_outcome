package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.text.TextUtils;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.VideoGiftView;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.f;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.m;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeature;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m02.i;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidgetOrigin;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidget;", "<init>", "()V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseVideoGiftWidgetOrigin extends BaseVideoGiftWidget {
    public static final int L = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final i02.c<EffectMessage> f129597J;
    public final List<EffectMessage> K;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseVideoGiftWidgetOrigin f129598a;

        public a(BaseVideoGiftWidgetOrigin r100) {
            this.f129598a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            BaseVideoGiftWidgetOrigin r102 = this.f129598a;
            if (r102.f129566l == false) goto L14;
            if (r101 == false) goto L15;
            VideoGiftView r103 = r102.f129559e;
            if (r103 == null) goto L12;
            f r104 = r103.f129349h;
            if (r104 == null) goto L12;
            ILiveGiftPlayController r105 = r104.f129438f;
            if (r105 == null) goto L12;
            r105.cancel();
        L12:
            r102.f129566l = false;
            return;
        L15:
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseVideoGiftWidgetOrigin f129599a;

        public c(BaseVideoGiftWidgetOrigin r100) {
            this.f129599a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.f.a
        public final boolean a() {
            List<EffectMessage> r100 = this.f129599a.K;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (((ArrayList) r100).isEmpty() == true) goto L7;
            return true;
        }
    }

    public static final class d<E> implements i02.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseVideoGiftWidgetOrigin f129600a;

        public d(BaseVideoGiftWidgetOrigin r100) {
            this.f129600a = r100;
        }

        @Override // i02.c.a
        public final boolean compare(Object r100, Object r101) {
            EffectMessage r102 = (EffectMessage) r100;
            EffectMessage r103 = (EffectMessage) r101;
            int r104 = r102.f126019c;
            int r105 = r103.f126019c;
            if (r104 != r105) goto L7;
            List<EffectMessage> r106 = this.f129600a.K;
            Intrinsics.checkNotNull(r106);
            if (((ArrayList) r106).indexOf(r102) > ((ArrayList) this.f129600a.K).indexOf(r103)) goto L8;
        L9:
            return false;
        L8:
            return true;
        L7:
            if (r104 >= r105) goto L9;
            goto L8
        }
    }

    static {
        L = ((Number) com.bytedance.android.livesdk.gift.platform.business.a.f126501n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.f126488a[12])).intValue();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final f.a Gq() {
        return new c(this);
    }

    public BaseVideoGiftWidgetOrigin() {
        this.K = new ArrayList();
        d r100 = new d(this);
        this.f129597J = new i02.c(L + 1, r100);
        GiftContext r101 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r101 == null) goto L12;
        k<Boolean> r102 = r101.getNeedStopEffect();
        if (r102 == null) goto L13;
        PublishSubject r103 = r102.onEvent();
        if (r103 == null) goto L14;
        ObservableSubscribeProxy r104 = (ObservableSubscribeProxy) r103.as(AutoDispose.bind(this));
        if (r104 == null) goto L15;
        r104.subscribe(new a(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final boolean jr(EffectMessage r100) {
        if (r100 != null) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f129556b, "loadEffectResource: effectMessage is null");
        return false;
    L6:
        e r101 = this.f129557c.G1(r100.f126018b);
        if (this.f129557c.O9(r101) == true) goto L14;
        String r102 = this.f129556b;
        StringBuilder r103 = new StringBuilder("loadEffectResource: assets is not valid ; assets = ");
        if (r101 == null) goto L11;
        Object r104 = Long.valueOf(r101.getId());
    L12:
        r103.append(r104);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r102, r103.toString());
        return false;
    L11:
        r104 = "null";
        goto L12
    L14:
        if (r101 != null) goto L16;
    L18:
        this.f129557c.j4(r100.f126018b, new com.bytedance.android.livesdk.gift.platform.business.effect.widget.b(this, r100), 4);
        return true;
    L16:
        if (r101.getResourceType() != 9) goto L18;
        return false;
    }

    public static final void hr(BaseVideoGiftWidgetOrigin r110, EffectMessage r111) {
        if (r110.isViewValid() == false) goto L99;
        if (r111 == null) goto L99;
        boolean r100 = true;
        if (r111.f126023g == false) goto L9;
        List<EffectMessage> r101 = r110.K;
        Intrinsics.checkNotNull(r101);
        ListProtector.add(r101, 0, r111);
    L20:
        List<EffectMessage> r112 = r110.K;
        Intrinsics.checkNotNull(r112);
        if (((ArrayList) r112).isEmpty() == false) goto L23;
    L90:
        String r113 = r110.f129556b;
        StringBuilder r102 = new StringBuilder("[tryConsumeEffectMessage] not consume, mEffectMessageList:");
        r102.append(((ArrayList) r110.K).size());
        r102.append(" mIsPlayingSpecialGift:");
        r102.append(r110.f129566l);
        r102.append(" mVideoGiftView(null?):");
        if (r110.f129559e != null) goto L93;
        boolean r103 = true;
    L94:
        r102.append(r103);
        r102.append(" mRoom(null?):");
        if (r110.f129558d == null) goto L98;
        r100 = false;
    L98:
        r102.append(r100);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r113, r102.toString());
        int r114 = i02.b.f487857e;
        i02.b.a.a(-1);
        return;
    L93:
        r103 = false;
        goto L94
    L23:
        if (r110.f129566l == true) goto L90;
        if (r110.f129559e == null) goto L90;
        if (r110.f129558d == null) goto L90;
        EffectMessage r115 = (EffectMessage) ListProtector.remove(r110.K, 0);
        if (r115 != null) goto L32;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r110.f129556b, "msg from EffectMessageList is null");
        int r116 = i02.b.f487857e;
        i02.b.a.a(-1);
        return;
    L32:
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.consume_effect_message, r115.f126017a, r115.f126028l, r115.f126018b);
        r110.f129569o = r115;
        i02.c<EffectMessage> r104 = r110.f129597J;
        int r105 = 0;
    L34:
        if (r105 >= r104.f487864c) goto L38;
        r105 = r105 + 1;
        if (r104.f487862a[r105].equals(r115) == false) goto L34;
        Object[] r106 = r104.f487862a;
        int r107 = r104.f487864c;
        r104.f487864c = r107 - 1;
        r106[r105] = r106[r107];
        r104.a();
    L38:
        e r108 = r110.f129557c.G1(r115.f126018b);
        if (r108 != null) goto L45;
        String r109 = String.valueOf(r115.f126028l);
        String r117 = String.valueOf(r115.f126017a);
        EffectMessage r118 = r110.f129569o;
        if (r118 == null) goto L43;
        Intrinsics.checkNotNull(r118);
        String r119 = r118.f126030n;
    L44:
        h.x("特效列表找不到该Id", r109, r117, "", r119);
        r110.Fq();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r110.f129556b, "assets not found consume next one, effectId:" + r115.f126018b);
        int r120 = i02.b.f487857e;
        i02.b.a.a(-1);
        return;
    L43:
        r119 = "";
        goto L44
    L45:
        Intrinsics.checkNotNullParameter(r115, "msg");
        int r121 = g02.a.a(r115);
        if (r121 != 0) goto L48;
        boolean r122 = false;
    L60:
        if (r122 == false) goto L62;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r110.f129556b, "resource type not match" + r115.f126018b);
        r110.Fq();
        int r123 = i02.b.f487857e;
        i02.b.a.a(-1);
        return;
    L62:
        Intrinsics.checkNotNullParameter(r115, "msg");
        Intrinsics.checkNotNullParameter(r108, ChameleonAssertResManager.ASSET_FOLDER);
        if (r108.getResourceType() != 4) goto L65;
    L68:
        Intrinsics.checkNotNullParameter(r115, "msg");
        Intrinsics.checkNotNullParameter(r108, ChameleonAssertResManager.ASSET_FOLDER);
        if (TextUtils.isEmpty(r115.f126020d) == false) goto L71;
        r110.fr(r115);
        r110.Fq();
        int r124 = i02.b.f487857e;
        i02.b.a.a(-1);
    L89:
        int r125 = i02.b.f487857e;
        return;
    L71:
        r110.f129566l = true;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(r110.f129556b, "ConsumeEffectMessage(), giftId = " + r115.f126028l);
        i r126 = r110.f129567m;
        long r127 = r115.f126018b;
        r126.getClass();
        r126.f511480a = ((IGiftService) jc1.k.n(IGiftService.class)).getAssets(KFFeature.EFFECT_JSON_FIELD, r127);
        boolean r128 = u.s();
        if (x.b() == false) goto L74;
    L82:
        if (r100 == false) goto L84;
        r110.Iq(r115);
    L88:
        h.x("播放视频礼物", String.valueOf(r115.f126028l), String.valueOf(r115.f126017a), "", r115.f126030n);
        int r129 = i02.b.f487857e;
        goto L89
    L84:
        VideoGiftView r130 = r110.f129559e;
        Intrinsics.checkNotNull(r130);
        r130.d(r110.f129564j);
        int r131 = m02.f.a(Long.valueOf(r115.f126018b), r115.f126020d);
        SuperResolutionModel r132 = new SuperResolutionModel(m02.f.d(r115.f126020d), m02.f.c(r115.f126020d), r110.Kq(r131), r115.f126018b, r131);
        VideoGiftView r133 = r110.f129559e;
        Intrinsics.checkNotNull(r133);
        IRoom r134 = r110.f129558d;
        Intrinsics.checkNotNull(r134);
        r134.getOwner();
        r133.g(r115, r132);
        n02.a r135 = r110.f129563i;
        if (r135 == null) goto L87;
        Intrinsics.checkNotNull(r135);
        n02.a.a(r115);
    L87:
        r110.Bq(r115, r131);
        goto L88
    L74:
        if (r110.f129571q == true) goto L78;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, Boolean.FALSE)).booleanValue() == false) goto L82;
    L78:
        if (r115.f126031o == true) goto L82;
        if (r128 == true) goto L82;
        r100 = false;
        goto L82
    L65:
        if (r108.getResourceType() == 15) goto L68;
        BaseVideoGiftWidget.cr(r115, r108);
        r110.Fq();
        goto L89
    L48:
        if (r121 == 1) goto L56;
        if (r121 == 2) goto L53;
    L58:
        r122 = true;
        goto L60
    L53:
        if (m.h(r115) == false) goto L58;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r110.f129556b, "recycle resource" + r115.f126018b);
        r110.jr(r115);
        goto L58
    L56:
        if (m.g(r115) == false) goto L58;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b(r110.f129556b, "recycle resource" + r115.f126018b);
        r110.jr(r115);
        goto L58
    L9:
        List<EffectMessage> r136 = r110.K;
        Intrinsics.checkNotNull(r136);
        ((ArrayList) r136).add(r111);
        i02.c<EffectMessage> r137 = r110.f129597J;
        int r138 = r137.f487864c;
        if (r138 == r137.f487863b) goto L12;
        int r139 = r138 + 1;
        r137.f487864c = r139;
        r137.f487862a[r139] = r111;
        int r140 = r139 / 2;
    L16:
        if (r140 <= 0) goto L20;
        i02.c.a r141 = r137.f487865d;
        Object[] r142 = r137.f487862a;
        if (r141.compare(r142[r139], r142[r140]) == false) goto L20;
        Object[] r143 = r137.f487862a;
        Object r144 = r143[r140];
        r143[r140] = r143[r139];
        r143[r139] = r144;
        r139 = r140;
        r140 = r140 / 2;
        goto L16
    L12:
        if (r137.f487865d.compare(r111, r137.f487862a[1]) == true) goto L20;
        r137.f487862a[1] = r111;
        r137.a();
    L99:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r110.f129556b, "addSpecialMessage failed: message" + r111);
    }
}
