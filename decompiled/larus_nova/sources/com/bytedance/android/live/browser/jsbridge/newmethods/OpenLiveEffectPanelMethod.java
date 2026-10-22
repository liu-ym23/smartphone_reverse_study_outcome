package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.OpenLiveEffectPanelResultModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.InsertEffectType;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener;
import com.ss.android.ugc.effectmanager.effect.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveEffectPanel")
public final class OpenLiveEffectPanelMethod extends w20.l4<w20.kc, OpenLiveEffectPanelResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f63259a;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod$invoke$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"openStickerDialog", "", "isCampaign", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ String $effectID;
        final /* synthetic */ boolean $shouldSelectEffect;
        final /* synthetic */ String $subCategoryTabKey;
        final /* synthetic */ String $tabKey;
        final /* synthetic */ OpenLiveEffectPanelMethod this$0;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.OpenLiveEffectPanelMethod$invoke$1$a */
        public static final class a implements IFetchEffectListByIdsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AnonymousClass1 f63260a;

            public a(AnonymousClass1 r100) {
                this.f63260a = r100;
            }

            @Override // com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListByIdsListener
            public final void onFail(ExceptionResult r100) {
                OpenLiveEffectPanelMethod r101 = this.f63260a.this$0;
                if (r100 == null) goto L5;
                String r102 = r100.getMsg();
            L6:
                r101.finishWithFailure(new Throwable(r102));
                return;
            L5:
                r102 = null;
                goto L6
            }

            @Override // com.ss.android.ugc.effectmanager.common.task.IEffectPlatformBaseListener
            public final void onSuccess(EffectListResponse r100) {
                EffectListResponse r101 = r100;
                OpenLiveEffectPanelMethod r102 = this.f63260a.this$0;
                if (r101 == null) goto L9;
                List<Effect> r103 = r101.getEffect_list();
                if (r103 == null) goto L9;
                Effect r104 = (Effect) CollectionsKt.firstOrNull(r103);
                if (r104 == null) goto L9;
                com.ss.android.ugc.effectmanager.effect.model.Effect r105 = new com.ss.android.ugc.effectmanager.effect.model.Effect(r104);
            L10:
                AnonymousClass1 r106 = this.f63260a;
                r102.j(r105, r106.$effectID, r106.$shouldSelectEffect, r106.$tabKey, r106.$subCategoryTabKey);
                return;
            L9:
                r105 = null;
                goto L10
            }
        }

        public AnonymousClass1(OpenLiveEffectPanelMethod r100, String r101, String r102, String r103, boolean r104) {
            this.this$0 = r100;
            this.$effectID = r101;
            this.$tabKey = r102;
            this.$subCategoryTabKey = r103;
            this.$shouldSelectEffect = r104;
            super(1);
        }

        public final void invoke(boolean r110) {
            if (r110 == false) goto L4;
            InsertEffectType r100 = InsertEffectType.Campaign;
        L5:
            InsertEffectType r101 = r100;
            if (this.$effectID.length() != 0) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L12;
            xs2.b.a().post(new zg1.c2(new InsertStickerInfo(r101, null, null, this.$tabKey, false, true, false, this.$subCategoryTabKey, false, 320, null)));
            this.this$0.finishWithFailure(new Throwable("effectID is Empty"));
            return;
        L12:
            com.ss.android.ugc.effectmanager.effect.model.Effect r103 = null;
            if (r110 == false) goto L25;
            List<String> r111 = LiveEffectContext.f66734h;
            Iterator<T> r112 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d().c(com.bytedance.android.live.effect.api.d0.f66753c).iterator();
        L16:
            if (r112.hasNext() == false) goto L20;
            Object r104 = r112.next();
            if (Intrinsics.areEqual(((com.ss.android.ugc.effectmanager.effect.model.Effect) r104).getEffect_id(), this.$effectID) == false) goto L16;
        L21:
            com.ss.android.ugc.effectmanager.effect.model.Effect r105 = (com.ss.android.ugc.effectmanager.effect.model.Effect) r104;
            if (r105 == null) goto L24;
            r103 = new com.ss.android.ugc.effectmanager.effect.model.Effect(r105);
        L24:
            this.this$0.j(r103, this.$effectID, this.$shouldSelectEffect, this.$tabKey, this.$subCategoryTabKey);
            return;
        L20:
            r104 = null;
            goto L21
        L25:
            List<String> r113 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffectList2(CollectionsKt.mutableListOf(new String[]{this.$effectID}), null, new a(this));
            return;
        L8:
            r102 = false;
            goto L9
        L4:
            r100 = InsertEffectType.Other;
            goto L5
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public OpenLiveEffectPanelMethod() {
        this.f63259a = LazyKt.lazy(OpenLiveEffectPanelMethod$stickerDataManager$2.INSTANCE);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.kc r112 = (w20.kc) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        RoomContext.a r113 = RoomContext.Companion;
        LiveMode r100 = null;
        if (RoomContext.a.c(r113, null, 0, 3) == null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L44:
        com.bytedance.android.live.core.utils.f2.c("请在视频开播时使用特效", 0);
        return;
    L10:
        if (RoomContext.a.c(r113, null, 0, 3) == null) goto L19;
        RoomContext r114 = RoomContext.a.c(r113, null, 0, 3);
        if (r114 == null) goto L17;
        com.bytedance.live.datacontext.i<LiveMode> r115 = r114.getLiveMode();
        if (r115 == null) goto L17;
        r100 = r115.getValue();
    L17:
        if (r100 != LiveMode.VIDEO) goto L44;
    L19:
        String r116 = r112.a();
        if (r116 != null) goto L22;
        r116 = "";
    L22:
        String r102 = r112.e();
        if (r102 != null) goto L25;
        String r117 = "";
    L26:
        String r103 = r112.b();
        if (r103 != null) goto L29;
        String r104 = "";
    L30:
        Boolean r105 = r112.c();
        if (r105 == null) goto L33;
        r105.booleanValue();
    L33:
        Boolean r118 = r112.d();
        if (r118 == null) goto L36;
        boolean r119 = r118.booleanValue();
    L37:
        AnonymousClass1 r120 = new AnonymousClass1(this, r104, r116, r117, r119);
        if (Intrinsics.areEqual(r116, "campaign") == false) goto L43;
        com.bytedance.android.live.effect.sticker.presenter.o r106 = (com.bytedance.android.live.effect.sticker.presenter.o) this.f63259a.getValue();
        String r107 = com.bytedance.android.live.effect.api.d0.f66753c;
        if (r106.b(r107) == true) goto L42;
        com.bytedance.android.live.effect.sticker.presenter.o.a.b((com.bytedance.android.live.effect.sticker.presenter.o) this.f63259a.getValue(), r107, r116, new u8(r120));
        return;
    L42:
        r120.invoke(true);
        return;
    L43:
        r120.invoke(false);
        return;
    L36:
        r119 = false;
        goto L37
    L29:
        r104 = r103;
        goto L30
    L25:
        r117 = r102;
        goto L26
    L5:
        if (((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).getPreviewLiveMode() == LiveMode.VIDEO) goto L7;
        r101 = true;
        goto L8
    }

    public final void j(com.ss.android.ugc.effectmanager.effect.model.Effect r110, String r111, boolean r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r111, "effectID");
        Intrinsics.checkNotNullParameter(r211, "tabKey");
        Intrinsics.checkNotNullParameter(r212, "subCategoryTabKey");
        if (r210 == false) goto L6;
        if (r110 == null) goto L6;
        InsertStickerInfo r100 = new InsertStickerInfo(InsertEffectType.Other, com.bytedance.android.live.effect.sticker.d.b(r110), new com.ss.android.ugc.effectmanager.effect.model.Effect(r110), r211, false, true, true, r212, false, 256, null);
    L7:
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_OPEN_STICKER_DIALOG_JSB, null, null, 14);
        r101.l(0);
        r101.c(r211);
        if (r110 == null) goto L10;
        String r102 = "1";
    L11:
        r101.d(r102);
        r101.i("effectID", r111);
        r101.a().report();
        xs2.b.a().post(new zg1.c2(r100));
        finishWithSuccess();
        return;
    L10:
        r102 = "0";
    L6:
        r100 = new InsertStickerInfo(InsertEffectType.Other, null, null, r211, false, true, false, r212, false, 320, null);
        goto L7
    }
}
