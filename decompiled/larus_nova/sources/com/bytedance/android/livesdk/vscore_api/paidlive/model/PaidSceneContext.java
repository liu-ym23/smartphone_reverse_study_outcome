package com.bytedance.android.livesdk.vscore_api.paidlive.model;

import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.ability.r;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveBusiness;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R3\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R!\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R!\u0010'\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007R!\u0010*\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R!\u0010-\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007R!\u00101\u001a\b\u0012\u0004\u0012\u00020.0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u0010\u0011R!\u00104\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R!\u00107\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u0010\u0007R!\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\u0007R!\u0010@\u001a\b\u0012\u0004\u0012\u00020!0<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR0\u0010H\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0014\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR#\u0010O\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002080N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0017\u0010T\u001a\u00020S8\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0005\u001a\u0004\bY\u0010\u0007R!\u0010\\\u001a\b\u0012\u0004\u0012\u00020!0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0005\u001a\u0004\b\\\u0010\u0007R\"\u0010]\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010B\u001a\u0004\b^\u0010D\"\u0004\b_\u0010F¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paidlive/model/PaidSceneContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/n;", "sceneStateMachine$delegate", "Lcom/bytedance/live/datacontext/p;", "getSceneStateMachine", "()Lcom/bytedance/live/datacontext/m;", "sceneStateMachine", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/l;", "currentState$delegate", "getCurrentState", "currentState", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/vscore_api/paidlive/ability/r;", "paidTempWatchEndViewState$delegate", "getPaidTempWatchEndViewState", "()Lcom/bytedance/live/datacontext/n;", "paidTempWatchEndViewState", "Lkotlin/Triple;", "", "paidTempWatchRemainTime$delegate", "getPaidTempWatchRemainTime", "paidTempWatchRemainTime", "mTempWatchStartTime$delegate", "getMTempWatchStartTime", "mTempWatchStartTime", "mTempWatchEndTime$delegate", "getMTempWatchEndTime", "mTempWatchEndTime", "tempWatchMaskShowDuration$delegate", "getTempWatchMaskShowDuration", "tempWatchMaskShowDuration", "", "hasLogPreviewMaskDuration$delegate", "getHasLogPreviewMaskDuration", "hasLogPreviewMaskDuration", "needDeliveryNotice$delegate", "getNeedDeliveryNotice", "needDeliveryNotice", "needRefreshStreamMask$delegate", "getNeedRefreshStreamMask", "needRefreshStreamMask", "hasRoomEnter$delegate", "getHasRoomEnter", "hasRoomEnter", "Lcom/bytedance/android/livesdkapi/roomplayer/IPaidLiveBusiness$ShareTicketResponse;", "shareTicketInfo$delegate", "getShareTicketInfo", "shareTicketInfo", "shareTicketAutoGrab$delegate", "getShareTicketAutoGrab", "shareTicketAutoGrab", "tempWatchCardForceVisible$delegate", "getTempWatchCardForceVisible", "tempWatchCardForceVisible", "", "cacheTicketIds$delegate", "getCacheTicketIds", "cacheTicketIds", "Lcom/bytedance/live/datacontext/k;", "shareTicketDialogClose$delegate", "getShareTicketDialogClose", "()Lcom/bytedance/live/datacontext/k;", "shareTicketDialogClose", "needChangeMuteStatus", "Z", "getNeedChangeMuteStatus", "()Z", "setNeedChangeMuteStatus", "(Z)V", "Lkotlin/Pair;", "switchStreamActionInRoom", "Lkotlin/Pair;", "getSwitchStreamActionInRoom", "()Lkotlin/Pair;", "setSwitchStreamActionInRoom", "(Lkotlin/Pair;)V", "", "commonExtraMap", "Ljava/util/Map;", "getCommonExtraMap", "()Ljava/util/Map;", "Lorg/json/JSONObject;", "feTrackParamMap", "Lorg/json/JSONObject;", "getFeTrackParamMap", "()Lorg/json/JSONObject;", "debugMode$delegate", "getDebugMode", "debugMode", "isEntBillFloatWindowShow$delegate", "isEntBillFloatWindowShow", "adaptLargeFont", "getAdaptLargeFont", "setAdaptLargeFont", "<init>", "()V", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidSceneContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private boolean adaptLargeFont;
    private final p cacheTicketIds$delegate;
    private final Map<String, String> commonExtraMap;
    private final p currentState$delegate;
    private final p debugMode$delegate;
    private final JSONObject feTrackParamMap;
    private final p hasLogPreviewMaskDuration$delegate;
    private final p hasRoomEnter$delegate;
    private final p isEntBillFloatWindowShow$delegate;
    private final p mTempWatchEndTime$delegate;
    private final p mTempWatchStartTime$delegate;
    private boolean needChangeMuteStatus;
    private final p needDeliveryNotice$delegate;
    private final p needRefreshStreamMask$delegate;
    private final p paidTempWatchEndViewState$delegate;
    private final p paidTempWatchRemainTime$delegate;
    private final p sceneStateMachine$delegate;
    private final p shareTicketAutoGrab$delegate;
    private final p shareTicketDialogClose$delegate;
    private final p shareTicketInfo$delegate;
    private Pair<String, Long> switchStreamActionInRoom;
    private final p tempWatchCardForceVisible$delegate;
    private final p tempWatchMaskShowDuration$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "sceneStateMachine", "getSceneStateMachine()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "currentState", "getCurrentState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "paidTempWatchEndViewState", "getPaidTempWatchEndViewState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "paidTempWatchRemainTime", "getPaidTempWatchRemainTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "mTempWatchStartTime", "getMTempWatchStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "mTempWatchEndTime", "getMTempWatchEndTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "tempWatchMaskShowDuration", "getTempWatchMaskShowDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "hasLogPreviewMaskDuration", "getHasLogPreviewMaskDuration()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "needDeliveryNotice", "getNeedDeliveryNotice()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "needRefreshStreamMask", "getNeedRefreshStreamMask()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "hasRoomEnter", "getHasRoomEnter()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "shareTicketInfo", "getShareTicketInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "shareTicketAutoGrab", "getShareTicketAutoGrab()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "tempWatchCardForceVisible", "getTempWatchCardForceVisible()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "cacheTicketIds", "getCacheTicketIds()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "shareTicketDialogClose", "getShareTicketDialogClose()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "debugMode", "getDebugMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PaidSceneContext.class, "isEntBillFloatWindowShow", "isEntBillFloatWindowShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<String> getCacheTicketIds() {
        return (m) this.cacheTicketIds$delegate.a(this, $$delegatedProperties[14]);
    }

    public final m<l> getCurrentState() {
        return (m) this.currentState$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> getDebugMode() {
        return (m) this.debugMode$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<Boolean> getHasLogPreviewMaskDuration() {
        return (m) this.hasLogPreviewMaskDuration$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getHasRoomEnter() {
        return (m) this.hasRoomEnter$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Long> getMTempWatchEndTime() {
        return (m) this.mTempWatchEndTime$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Long> getMTempWatchStartTime() {
        return (m) this.mTempWatchStartTime$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getNeedDeliveryNotice() {
        return (m) this.needDeliveryNotice$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<Boolean> getNeedRefreshStreamMask() {
        return (m) this.needRefreshStreamMask$delegate.a(this, $$delegatedProperties[9]);
    }

    public final n<r> getPaidTempWatchEndViewState() {
        return (n) this.paidTempWatchEndViewState$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Triple<Long, Long, Long>> getPaidTempWatchRemainTime() {
        return (m) this.paidTempWatchRemainTime$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<com.bytedance.android.livesdk.vscore_api.paidlive.n> getSceneStateMachine() {
        return (m) this.sceneStateMachine$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> getShareTicketAutoGrab() {
        return (m) this.shareTicketAutoGrab$delegate.a(this, $$delegatedProperties[12]);
    }

    public final k<Boolean> getShareTicketDialogClose() {
        return (k) this.shareTicketDialogClose$delegate.a(this, $$delegatedProperties[15]);
    }

    public final n<IPaidLiveBusiness.ShareTicketResponse> getShareTicketInfo() {
        return (n) this.shareTicketInfo$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<Boolean> getTempWatchCardForceVisible() {
        return (m) this.tempWatchCardForceVisible$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Long> getTempWatchMaskShowDuration() {
        return (m) this.tempWatchMaskShowDuration$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> isEntBillFloatWindowShow() {
        return (m) this.isEntBillFloatWindowShow$delegate.a(this, $$delegatedProperties[17]);
    }

    public PaidSceneContext() {
        this.sceneStateMachine$delegate = q.d(this, new com.bytedance.android.livesdk.vscore_api.paidlive.n(PaidSceneEnum.ALL, PaidSceneViewEntry.UNKNOWN));
        this.currentState$delegate = q.d(this, l.c.f159462b);
        this.paidTempWatchEndViewState$delegate = q.c(this);
        this.paidTempWatchRemainTime$delegate = q.d(this, new Triple(-1L, -1L, -1L));
        this.mTempWatchStartTime$delegate = q.d(this, -1L);
        this.mTempWatchEndTime$delegate = q.d(this, -1L);
        this.tempWatchMaskShowDuration$delegate = q.d(this, 0L);
        Boolean r100 = Boolean.FALSE;
        this.hasLogPreviewMaskDuration$delegate = q.d(this, r100);
        this.needDeliveryNotice$delegate = q.d(this, r100);
        this.needRefreshStreamMask$delegate = q.d(this, r100);
        this.hasRoomEnter$delegate = q.d(this, r100);
        this.shareTicketInfo$delegate = q.c(this);
        this.shareTicketAutoGrab$delegate = q.d(this, r100);
        this.tempWatchCardForceVisible$delegate = q.d(this, r100);
        this.cacheTicketIds$delegate = q.d(this, "");
        this.shareTicketDialogClose$delegate = e.b(this);
        this.needChangeMuteStatus = true;
        this.commonExtraMap = new LinkedHashMap();
        this.feTrackParamMap = new JSONObject();
        this.debugMode$delegate = q.d(this, r100);
        this.isEntBillFloatWindowShow$delegate = q.d(this, r100);
    }

    public final boolean getAdaptLargeFont() {
        return this.adaptLargeFont;
    }

    public final Map<String, String> getCommonExtraMap() {
        return this.commonExtraMap;
    }

    public final JSONObject getFeTrackParamMap() {
        return this.feTrackParamMap;
    }

    public final boolean getNeedChangeMuteStatus() {
        return this.needChangeMuteStatus;
    }

    public final Pair<String, Long> getSwitchStreamActionInRoom() {
        return this.switchStreamActionInRoom;
    }

    public final void setAdaptLargeFont(boolean r100) {
        this.adaptLargeFont = r100;
    }

    public final void setNeedChangeMuteStatus(boolean r100) {
        this.needChangeMuteStatus = r100;
    }

    public final void setSwitchStreamActionInRoom(Pair<String, Long> r100) {
        this.switchStreamActionInRoom = r100;
    }
}
