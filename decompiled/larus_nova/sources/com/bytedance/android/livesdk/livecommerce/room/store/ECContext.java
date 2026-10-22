package com.bytedance.android.livesdk.livecommerce.room.store;

import android.os.Bundle;
import bk2.b;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.model.ShortTouchCouponMsgEvent;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010q\u001a\u00020\u0003¢\u0006\u0004\bt\u0010uR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0012R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR-\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0!0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u001fR!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0012R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u001fR!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007R-\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0!0\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0012R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0012R!\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0012R!\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u0010\u0012R!\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\u0012R!\u0010>\u001a\b\u0012\u0004\u0012\u00020;0\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010\u0012R!\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010\u0012R!\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u0010\u0012R!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0012R!\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010\u0007R!\u0010L\u001a\b\u0012\u0004\u0012\u00020I0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010\u001fR!\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\u0012R!\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0005\u001a\u0004\bP\u0010\u0012R!\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0005\u001a\u0004\bS\u0010\u0007R!\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0005\u001a\u0004\bW\u0010\u001fR!\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0005\u001a\u0004\b[\u0010\u001fR!\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0005\u001a\u0004\b_\u0010\u001fR!\u0010d\u001a\b\u0012\u0004\u0012\u00020a0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0005\u001a\u0004\bc\u0010\u0007R!\u0010h\u001a\b\u0012\u0004\u0012\u00020e0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0005\u001a\u0004\bg\u0010\u0007R!\u0010l\u001a\b\u0012\u0004\u0012\u00020i0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0005\u001a\u0004\bk\u0010\u0007R!\u0010p\u001a\b\u0012\u0004\u0012\u00020m0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0005\u001a\u0004\bo\u0010\u0007R\u0017\u0010q\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bq\u0010s¨\u0006v"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/store/ECContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/i;", "", "isAnchor$delegate", "Lcom/bytedance/live/datacontext/p;", "isAnchor", "()Lcom/bytedance/live/datacontext/i;", "", "roomId$delegate", "getRoomId", "roomId", "roomUniqueKey$delegate", "getRoomUniqueKey", "roomUniqueKey", "Lcom/bytedance/live/datacontext/m;", "isPortrait$delegate", "isPortrait", "()Lcom/bytedance/live/datacontext/m;", "anchorId$delegate", "getAnchorId", "anchorId", "anchorSecId$delegate", "getAnchorSecId", "anchorSecId", "isLogin$delegate", Keys.API_RETURN_KEY_IS_LOGIN, "Lcom/bytedance/live/datacontext/n;", "", "streamType$delegate", "getStreamType", "()Lcom/bytedance/live/datacontext/n;", "streamType", "", "reportParams$delegate", "getReportParams", "reportParams", "hasCouponEntryShown$delegate", "getHasCouponEntryShown", "hasCouponEntryShown", "Lcom/bytedance/android/livesdk/livecommerce/room/model/ShortTouchCouponMsgEvent;", "shortTouchCouponInfo$delegate", "getShortTouchCouponInfo", "shortTouchCouponInfo", "liveSDKVersion$delegate", "getLiveSDKVersion", "liveSDKVersion", "enterRoomParams$delegate", "getEnterRoomParams", "enterRoomParams", "isInKtv$delegate", "isInKtv", "isInDrawGuessGame$delegate", "isInDrawGuessGame", "hasFlashAuth$delegate", "getHasFlashAuth", "hasFlashAuth", "isFlashOpen$delegate", "isFlashOpen", "Landroid/os/Bundle;", "extras$delegate", "getExtras", "extras", "isReplayOpen$delegate", "isReplayOpen", "isBottomCardVisible$delegate", "isBottomCardVisible", "isIntroCardVisible$delegate", "isIntroCardVisible", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/anim/CartCardLinkedAnimController;", "linkedAnimController$delegate", "getLinkedAnimController", "linkedAnimController", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/shoppingcart/a;", "cartConfig$delegate", "getCartConfig", "cartConfig", "isCartShow$delegate", "isCartShow", "isPromotionListShow$delegate", "isPromotionListShow", "Lcom/bytedance/android/livesdk/livecommerce/room/quick/LiveRoomLifecycleOwner;", "lifecycleOwner$delegate", "getLifecycleOwner", "lifecycleOwner", "Lcom/bytedance/android/ec/model/promotion/ECUIPromotion;", "explainPromotion$delegate", "getExplainPromotion", "explainPromotion", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/vo/IntroPromotionVO;", "introCardState$delegate", "getIntroCardState", "introCardState", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/c;", "floatWindowVO$delegate", "getFloatWindowVO", "floatWindowVO", "Lbk2/b;", "disposableContext$delegate", "getDisposableContext", "disposableContext", "Lcom/bytedance/android/livesdk/livecommerce/opt/ECLivePerformanceMonitor;", "ecLivePerformanceMonitor$delegate", "getEcLivePerformanceMonitor", "ecLivePerformanceMonitor", "Lfk2/b;", "ecLiveRoomDurationMonitor$delegate", "getEcLiveRoomDurationMonitor", "ecLiveRoomDurationMonitor", "Lyg2/a;", "ecLiveActionRecordService$delegate", "getEcLiveActionRecordService", "ecLiveActionRecordService", "isPreview", "Z", "()Z", "<init>", "(Z)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p anchorId$delegate;
    private final p anchorSecId$delegate;
    private final p cartConfig$delegate;
    private final p disposableContext$delegate;
    private final p ecLiveActionRecordService$delegate;
    private final p ecLivePerformanceMonitor$delegate;
    private final p ecLiveRoomDurationMonitor$delegate;
    private final p enterRoomParams$delegate;
    private final p explainPromotion$delegate;
    private final p extras$delegate;
    private final p floatWindowVO$delegate;
    private final p hasCouponEntryShown$delegate;
    private final p hasFlashAuth$delegate;
    private final p introCardState$delegate;
    private final p isAnchor$delegate;
    private final p isBottomCardVisible$delegate;
    private final p isCartShow$delegate;
    private final p isFlashOpen$delegate;
    private final p isInDrawGuessGame$delegate;
    private final p isInKtv$delegate;
    private final p isIntroCardVisible$delegate;
    private final p isLogin$delegate;
    private final p isPortrait$delegate;
    private final boolean isPreview;
    private final p isPromotionListShow$delegate;
    private final p isReplayOpen$delegate;
    private final p lifecycleOwner$delegate;
    private final p linkedAnimController$delegate;
    private final p liveSDKVersion$delegate;
    private final p reportParams$delegate;
    private final p roomId$delegate;
    private final p roomUniqueKey$delegate;
    private final p shortTouchCouponInfo$delegate;
    private final p streamType$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECContext.class, "isAnchor", "isAnchor()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "roomId", "getRoomId()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "roomUniqueKey", "getRoomUniqueKey()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isPortrait", "isPortrait()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "anchorId", "getAnchorId()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "anchorSecId", "getAnchorSecId()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, Keys.API_RETURN_KEY_IS_LOGIN, "isLogin()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "streamType", "getStreamType()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "reportParams", "getReportParams()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "hasCouponEntryShown", "getHasCouponEntryShown()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "shortTouchCouponInfo", "getShortTouchCouponInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "liveSDKVersion", "getLiveSDKVersion()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "enterRoomParams", "getEnterRoomParams()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isInKtv", "isInKtv()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isInDrawGuessGame", "isInDrawGuessGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "hasFlashAuth", "getHasFlashAuth()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isFlashOpen", "isFlashOpen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "extras", "getExtras()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isReplayOpen", "isReplayOpen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isBottomCardVisible", "isBottomCardVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isIntroCardVisible", "isIntroCardVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "linkedAnimController", "getLinkedAnimController()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "cartConfig", "getCartConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isCartShow", "isCartShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "isPromotionListShow", "isPromotionListShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "lifecycleOwner", "getLifecycleOwner()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "explainPromotion", "getExplainPromotion()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "introCardState", "getIntroCardState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "floatWindowVO", "getFloatWindowVO()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "disposableContext", "getDisposableContext()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "ecLivePerformanceMonitor", "getEcLivePerformanceMonitor()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "ecLiveRoomDurationMonitor", "getEcLiveRoomDurationMonitor()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ECContext.class, "ecLiveActionRecordService", "getEcLiveActionRecordService()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0))};
    }

    public final i<String> getAnchorId() {
        return (i) this.anchorId$delegate.a(this, $$delegatedProperties[4]);
    }

    public final i<String> getAnchorSecId() {
        return (i) this.anchorSecId$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<a> getCartConfig() {
        return (n) this.cartConfig$delegate.a(this, $$delegatedProperties[22]);
    }

    public final i<b> getDisposableContext() {
        return (i) this.disposableContext$delegate.a(this, $$delegatedProperties[29]);
    }

    public final i<yg2.a> getEcLiveActionRecordService() {
        return (i) this.ecLiveActionRecordService$delegate.a(this, $$delegatedProperties[32]);
    }

    public final i<ECLivePerformanceMonitor> getEcLivePerformanceMonitor() {
        return (i) this.ecLivePerformanceMonitor$delegate.a(this, $$delegatedProperties[30]);
    }

    public final i<fk2.b> getEcLiveRoomDurationMonitor() {
        return (i) this.ecLiveRoomDurationMonitor$delegate.a(this, $$delegatedProperties[31]);
    }

    public final m<Map<String, String>> getEnterRoomParams() {
        return (m) this.enterRoomParams$delegate.a(this, $$delegatedProperties[12]);
    }

    public final n<ECUIPromotion> getExplainPromotion() {
        return (n) this.explainPromotion$delegate.a(this, $$delegatedProperties[26]);
    }

    public final m<Bundle> getExtras() {
        return (m) this.extras$delegate.a(this, $$delegatedProperties[17]);
    }

    public final n<c> getFloatWindowVO() {
        return (n) this.floatWindowVO$delegate.a(this, $$delegatedProperties[28]);
    }

    public final m<Boolean> getHasCouponEntryShown() {
        return (m) this.hasCouponEntryShown$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> getHasFlashAuth() {
        return (m) this.hasFlashAuth$delegate.a(this, $$delegatedProperties[15]);
    }

    public final n<IntroPromotionVO> getIntroCardState() {
        return (n) this.introCardState$delegate.a(this, $$delegatedProperties[27]);
    }

    public final i<LiveRoomLifecycleOwner> getLifecycleOwner() {
        return (i) this.lifecycleOwner$delegate.a(this, $$delegatedProperties[25]);
    }

    public final i<CartCardLinkedAnimController> getLinkedAnimController() {
        return (i) this.linkedAnimController$delegate.a(this, $$delegatedProperties[21]);
    }

    public final i<Integer> getLiveSDKVersion() {
        return (i) this.liveSDKVersion$delegate.a(this, $$delegatedProperties[11]);
    }

    public final n<Map<String, String>> getReportParams() {
        return (n) this.reportParams$delegate.a(this, $$delegatedProperties[8]);
    }

    public final i<String> getRoomId() {
        return (i) this.roomId$delegate.a(this, $$delegatedProperties[1]);
    }

    public final i<String> getRoomUniqueKey() {
        return (i) this.roomUniqueKey$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<ShortTouchCouponMsgEvent> getShortTouchCouponInfo() {
        return (n) this.shortTouchCouponInfo$delegate.a(this, $$delegatedProperties[10]);
    }

    public final n<Integer> getStreamType() {
        return (n) this.streamType$delegate.a(this, $$delegatedProperties[7]);
    }

    public final i<Boolean> isAnchor() {
        return (i) this.isAnchor$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isBottomCardVisible() {
        return (m) this.isBottomCardVisible$delegate.a(this, $$delegatedProperties[19]);
    }

    public final m<Boolean> isCartShow() {
        return (m) this.isCartShow$delegate.a(this, $$delegatedProperties[23]);
    }

    public final m<Boolean> isFlashOpen() {
        return (m) this.isFlashOpen$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<Boolean> isInDrawGuessGame() {
        return (m) this.isInDrawGuessGame$delegate.a(this, $$delegatedProperties[14]);
    }

    public final m<Boolean> isInKtv() {
        return (m) this.isInKtv$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Boolean> isIntroCardVisible() {
        return (m) this.isIntroCardVisible$delegate.a(this, $$delegatedProperties[20]);
    }

    public final m<Boolean> isLogin() {
        return (m) this.isLogin$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> isPortrait() {
        return (m) this.isPortrait$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> isPromotionListShow() {
        return (m) this.isPromotionListShow$delegate.a(this, $$delegatedProperties[24]);
    }

    public final m<Boolean> isReplayOpen() {
        return (m) this.isReplayOpen$delegate.a(this, $$delegatedProperties[18]);
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public ECContext(boolean r100) {
        this.isPreview = r100;
        Boolean r101 = Boolean.FALSE;
        this.isAnchor$delegate = ConstantKt.d(this, r101);
        this.roomId$delegate = ConstantKt.d(this, "");
        this.roomUniqueKey$delegate = ConstantKt.d(this, "");
        this.isPortrait$delegate = q.d(this, Boolean.TRUE);
        this.anchorId$delegate = ConstantKt.d(this, "");
        this.anchorSecId$delegate = ConstantKt.d(this, "");
        this.isLogin$delegate = q.d(this, r101);
        this.streamType$delegate = q.c(this);
        this.reportParams$delegate = q.c(this);
        this.hasCouponEntryShown$delegate = q.d(this, r101);
        this.shortTouchCouponInfo$delegate = q.c(this);
        this.liveSDKVersion$delegate = ConstantKt.d(this, -1);
        this.enterRoomParams$delegate = q.d(this, new HashMap());
        this.isInKtv$delegate = q.d(this, r101);
        this.isInDrawGuessGame$delegate = q.d(this, r101);
        this.hasFlashAuth$delegate = q.d(this, r101);
        this.isFlashOpen$delegate = q.d(this, r101);
        this.extras$delegate = q.d(this, new Bundle());
        this.isReplayOpen$delegate = q.d(this, r101);
        this.isBottomCardVisible$delegate = q.d(this, r101);
        this.isIntroCardVisible$delegate = q.d(this, r101);
        this.linkedAnimController$delegate = ConstantKt.d(this, new CartCardLinkedAnimController(r100, hashCode()));
        this.cartConfig$delegate = q.c(this);
        this.isCartShow$delegate = q.d(this, r101);
        this.isPromotionListShow$delegate = q.d(this, r101);
        this.lifecycleOwner$delegate = ConstantKt.d(this, new LiveRoomLifecycleOwner());
        this.explainPromotion$delegate = q.c(this);
        this.introCardState$delegate = q.c(this);
        this.floatWindowVO$delegate = q.c(this);
        this.disposableContext$delegate = ConstantKt.d(this, new b());
        this.ecLivePerformanceMonitor$delegate = ConstantKt.d(this, new ECLivePerformanceMonitor());
        this.ecLiveRoomDurationMonitor$delegate = ConstantKt.d(this, new fk2.b());
        this.ecLiveActionRecordService$delegate = ConstantKt.d(this, new yg2.a());
    }
}
