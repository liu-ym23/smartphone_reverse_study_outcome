package com.bytedance.android.live.effect.view;

import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.livesdk.config.mb;
import com.bytedance.android.livesdk.config.qb;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy;", "Lcom/bytedance/android/live/effect/view/LiveEffectActivityProxy;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EffectLivePreviewActivityProxy extends LiveEffectActivityProxy implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f68885b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Effect f68886a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<String> r100 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().c(d0.f66753c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (LiveEffectSettings.LIVE_ANCHOR_ENABLE_EFFECT_SECONDARY_CLASSIFICATION_FOR_ANCHOR.getValue().booleanValue() == false) goto L5;
            List<String> r100 = LiveEffectContext.f66734h;
            o.a.c(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d(), d0.f66753c, null, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().c(), false, null, true, 118);
            return;
        L5:
            List<String> r101 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().a(d0.f66753c, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().c());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.view.EffectLivePreviewActivityProxy$onCreate$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<String> r100 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().k(d0.f66753c, LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().a());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onCreate() {
        ALogger.i("ttlive_anchor_merged_stream", "preview effect proxy create");
        if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L7;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r100 = ILiveWrappedEffectSDKService.a.a();
        if (r100 == null) goto L7;
        r100.getMessageCenter();
    L7:
        super.onCreate();
        ALogger.d("ttlive_anchor_effect_EffectLivePreviewActivityProxy", "COMPOSER INIT : initializing config");
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContextFactoryDelegate$Type r102 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        LiveEffectContext.a.a(r102).e().c().a();
        List r103 = CollectionsKt.mutableListOf(new String[]{d0.f66759i, "beauty", d0.f66751a, d0.f66753c, d0.f66761k, "livebody"});
        Integer r104 = qb.f121041a.getValue();
        if (r104 != null) goto L11;
    L12:
        r103.add("live_adjustment");
    L14:
        if (mb.f120741a.getValue().booleanValue() == false) goto L17;
        r103.add(d0.f66752b);
    L17:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_INDEPENDENT_CAMERA_MOVEMENT_PANEL.getValue().booleanValue() == false) goto L19;
        r103.add("live_camera_move");
    L19:
        LiveEffectContext.a.a(r102).a();
        CollectionsKt.listOf("effect_gift");
        Intrinsics.throwUninitializedPropertyAccessException("startLiveParamsListener");
        Intrinsics.checkNotNullParameter(null, "startLiveParamsListener");
        Intrinsics.checkNotNullParameter(r102, "type");
        throw null;
    L11:
        if (r104.intValue() == 0) goto L14;
        goto L12
    }

    @Override // com.bytedance.android.live.effect.view.LiveEffectActivityProxy
    public final void onDestroy() {
        super.onDestroy();
        ALogger.e("ttlive_anchor_merged_stream", "video audio core onDestroy");
        if (LiveEffectSettings.LIVE_EFFECT_REPORT_FIRST_FRAME_RENDER_LOG.getValue().booleanValue() == false) goto L7;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r100 = ILiveWrappedEffectSDKService.a.a();
        if (r100 == null) goto L7;
        r100.getMessageCenter();
    L7:
        ALogger.i("ttlive_anchor_effect_EffectLivePreviewActivityProxy", "onDestroy release");
        throw null;
    }
}
