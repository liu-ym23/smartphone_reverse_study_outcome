package com.bytedance.android.livesdk.chatroom.progress.context;

import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.b;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeOnlyTaSegments;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 z2\u00020\u0001:\u0001{B\u0007¢\u0006\u0004\bx\u0010yR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\rR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010,R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010,R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b2\u0010,R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR!\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR!\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\rR!\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\rR!\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00100\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000b\u001a\u0004\bD\u0010\rR!\u0010K\u001a\b\u0012\u0004\u0012\u00020G0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u000b\u001a\u0004\bI\u0010JR!\u0010O\u001a\b\u0012\u0004\u0012\u00020L0)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010,R!\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u000b\u001a\u0004\bQ\u0010\rR!\u0010V\u001a\b\u0012\u0004\u0012\u00020S0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u000b\u001a\u0004\bU\u0010\rR!\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u000b\u001a\u0004\bX\u0010\rR!\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u000b\u001a\u0004\b[\u0010\rR!\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u000b\u001a\u0004\b^\u0010\rR\u0017\u0010a\u001a\u00020`8\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR'\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0e0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\u000b\u001a\u0004\bh\u0010JR!\u0010m\u001a\b\u0012\u0004\u0012\u00020j0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u000b\u001a\u0004\bl\u0010JR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR!\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\u000b\u001a\u0004\bv\u0010\r¨\u0006|"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/progress/context/PlayerProgressServiceContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "isPlaying", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setPlaying", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/live/datacontext/m;", "Ltic/a;", "playEntity$delegate", "Lcom/bytedance/live/datacontext/p;", "getPlayEntity", "()Lcom/bytedance/live/datacontext/m;", "playEntity", "Lcom/bytedance/live/datacontext/i;", "", "initSeekTime$delegate", "getInitSeekTime", "()Lcom/bytedance/live/datacontext/i;", "initSeekTime", "atLatest$delegate", "getAtLatest", "atLatest", "", "progress$delegate", "getProgress", "progress", "currentTime$delegate", "getCurrentTime", "currentTime", "currentDisplayTime$delegate", "getCurrentDisplayTime", "currentDisplayTime", "isSeekbarOnTracking$delegate", "isSeekbarOnTracking", "isSeekBarTracking", "Z", "()Z", "setSeekBarTracking", "(Z)V", "Lcom/bytedance/live/datacontext/k;", "seekEvent$delegate", "getSeekEvent", "()Lcom/bytedance/live/datacontext/k;", "seekEvent", "playOrPauseEvent$delegate", "getPlayOrPauseEvent", "playOrPauseEvent", "showLatestEvent$delegate", "getShowLatestEvent", "showLatestEvent", "showSeekToNow$delegate", "getShowSeekToNow", "showSeekToNow", "disableSeek$delegate", "getDisableSeek", "disableSeek", "xVelocity$delegate", "getXVelocity", "xVelocity", "totalTime$delegate", "getTotalTime", "totalTime", "limitTimeLength$delegate", "getLimitTimeLength", "limitTimeLength", "limitStartTime$delegate", "getLimitStartTime", "limitStartTime", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/b;", "playTimeInfo$delegate", "getPlayTimeInfo", "()Lcom/bytedance/live/datacontext/n;", "playTimeInfo", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/d;", "progressGestureEvent$delegate", "getProgressGestureEvent", "progressGestureEvent", "thumbProcessEnable$delegate", "getThumbProcessEnable", "thumbProcessEnable", "", "thumbProcessVisibility$delegate", "getThumbProcessVisibility", "thumbProcessVisibility", "isTouchProgressBar$delegate", "isTouchProgressBar", "", "thumbTitle$delegate", "getThumbTitle", "thumbTitle", "thumbHotLabel$delegate", "getThumbHotLabel", "thumbHotLabel", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSSeekBarMarkRepelStack;", "progressMarkStack", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSSeekBarMarkRepelStack;", "getProgressMarkStack", "()Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSSeekBarMarkRepelStack;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "highLightList$delegate", "getHighLightList", "highLightList", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeOnlyTaSegments;", "selectedOnlyTaSegment$delegate", "getSelectedOnlyTaSegment", "selectedOnlyTaSegment", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "forceSeekResolution", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getForceSeekResolution", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "setForceSeekResolution", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;)V", "vsRoomEnableSeek$delegate", "getVsRoomEnableSeek", "vsRoomEnableSeek", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerProgressServiceContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "VSProgressServiceContext";
    private final p atLatest$delegate;
    private final p currentDisplayTime$delegate;
    private final p currentTime$delegate;
    private final p disableSeek$delegate;
    private IQuality forceSeekResolution;
    private final p highLightList$delegate;
    private final p initSeekTime$delegate;
    private Boolean isPlaying;
    private boolean isSeekBarTracking;
    private final p isSeekbarOnTracking$delegate;
    private final p isTouchProgressBar$delegate;
    private final p limitStartTime$delegate;
    private final p limitTimeLength$delegate;
    private final p playEntity$delegate;
    private final p playOrPauseEvent$delegate;
    private final p playTimeInfo$delegate;
    private final p progress$delegate;
    private final p progressGestureEvent$delegate;
    private final VSSeekBarMarkRepelStack progressMarkStack;
    private final p seekEvent$delegate;
    private final p selectedOnlyTaSegment$delegate;
    private final p showLatestEvent$delegate;
    private final p showSeekToNow$delegate;
    private final p thumbHotLabel$delegate;
    private final p thumbProcessEnable$delegate;
    private final p thumbProcessVisibility$delegate;
    private final p thumbTitle$delegate;
    private final p totalTime$delegate;
    private final p vsRoomEnableSeek$delegate;
    private final p xVelocity$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PlayerProgressServiceContext a(DataCenter r100) {
            Intrinsics.checkNotNullParameter(r100, "dataCenter");
            DataContext r101 = d.d(Integer.valueOf(r100.hashCode() + 483071972));
            if ((r101 instanceof PlayerProgressServiceContext) == true) goto L6;
            r101 = null;
        L6:
            return (PlayerProgressServiceContext) r101;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "playEntity", "getPlayEntity()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "initSeekTime", "getInitSeekTime()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "atLatest", "getAtLatest()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "progress", "getProgress()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "currentTime", "getCurrentTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "currentDisplayTime", "getCurrentDisplayTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "isSeekbarOnTracking", "isSeekbarOnTracking()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "seekEvent", "getSeekEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "playOrPauseEvent", "getPlayOrPauseEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "showLatestEvent", "getShowLatestEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "showSeekToNow", "getShowSeekToNow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "disableSeek", "getDisableSeek()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "xVelocity", "getXVelocity()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "totalTime", "getTotalTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "limitTimeLength", "getLimitTimeLength()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "limitStartTime", "getLimitStartTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "playTimeInfo", "getPlayTimeInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "progressGestureEvent", "getProgressGestureEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "thumbProcessEnable", "getThumbProcessEnable()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "thumbProcessVisibility", "getThumbProcessVisibility()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "isTouchProgressBar", "isTouchProgressBar()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "thumbTitle", "getThumbTitle()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "thumbHotLabel", "getThumbHotLabel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "highLightList", "getHighLightList()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "selectedOnlyTaSegment", "getSelectedOnlyTaSegment()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PlayerProgressServiceContext.class, "vsRoomEnableSeek", "getVsRoomEnableSeek()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final PlayerProgressServiceContext getShared(DataCenter r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public final m<Boolean> getAtLatest() {
        return (m) this.atLatest$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Long> getCurrentDisplayTime() {
        return (m) this.currentDisplayTime$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Long> getCurrentTime() {
        return (m) this.currentTime$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getDisableSeek() {
        return (m) this.disableSeek$delegate.a(this, $$delegatedProperties[11]);
    }

    public final n<List<EpisodeHighLight>> getHighLightList() {
        return (n) this.highLightList$delegate.a(this, $$delegatedProperties[23]);
    }

    public final i<Long> getInitSeekTime() {
        return (i) this.initSeekTime$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Long> getLimitStartTime() {
        return (m) this.limitStartTime$delegate.a(this, $$delegatedProperties[15]);
    }

    public final m<Long> getLimitTimeLength() {
        return (m) this.limitTimeLength$delegate.a(this, $$delegatedProperties[14]);
    }

    public final m<tic.a> getPlayEntity() {
        return (m) this.playEntity$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Boolean> getPlayOrPauseEvent() {
        return (k) this.playOrPauseEvent$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<b> getPlayTimeInfo() {
        return (n) this.playTimeInfo$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<Float> getProgress() {
        return (m) this.progress$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<com.bytedance.android.livesdk.chatroom.vsplayer.model.d> getProgressGestureEvent() {
        return (k) this.progressGestureEvent$delegate.a(this, $$delegatedProperties[17]);
    }

    public final k<Long> getSeekEvent() {
        return (k) this.seekEvent$delegate.a(this, $$delegatedProperties[7]);
    }

    public final n<EpisodeOnlyTaSegments> getSelectedOnlyTaSegment() {
        return (n) this.selectedOnlyTaSegment$delegate.a(this, $$delegatedProperties[24]);
    }

    public final k<Boolean> getShowLatestEvent() {
        return (k) this.showLatestEvent$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Boolean> getShowSeekToNow() {
        return (m) this.showSeekToNow$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> getThumbHotLabel() {
        return (m) this.thumbHotLabel$delegate.a(this, $$delegatedProperties[22]);
    }

    public final m<Boolean> getThumbProcessEnable() {
        return (m) this.thumbProcessEnable$delegate.a(this, $$delegatedProperties[18]);
    }

    public final m<Integer> getThumbProcessVisibility() {
        return (m) this.thumbProcessVisibility$delegate.a(this, $$delegatedProperties[19]);
    }

    public final m<String> getThumbTitle() {
        return (m) this.thumbTitle$delegate.a(this, $$delegatedProperties[21]);
    }

    public final m<Long> getTotalTime() {
        return (m) this.totalTime$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Boolean> getVsRoomEnableSeek() {
        return (m) this.vsRoomEnableSeek$delegate.a(this, $$delegatedProperties[25]);
    }

    public final m<Float> getXVelocity() {
        return (m) this.xVelocity$delegate.a(this, $$delegatedProperties[12]);
    }

    public final m<Boolean> isSeekbarOnTracking() {
        return (m) this.isSeekbarOnTracking$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Boolean> isTouchProgressBar() {
        return (m) this.isTouchProgressBar$delegate.a(this, $$delegatedProperties[20]);
    }

    public PlayerProgressServiceContext() {
        this.playEntity$delegate = q.d(this, new tic.a());
        this.initSeekTime$delegate = ConstantKt.d(this, -1L);
        this.atLatest$delegate = q.d(this, Boolean.TRUE);
        Float r100 = Float.valueOf(0.0f);
        this.progress$delegate = q.d(this, r100);
        this.currentTime$delegate = q.d(this, 0L);
        this.currentDisplayTime$delegate = q.d(this, 0L);
        Boolean r101 = Boolean.FALSE;
        this.isSeekbarOnTracking$delegate = q.d(this, r101);
        this.seekEvent$delegate = e.b(this);
        this.playOrPauseEvent$delegate = e.b(this);
        this.showLatestEvent$delegate = e.b(this);
        this.showSeekToNow$delegate = q.d(this, r101);
        this.disableSeek$delegate = q.d(this, r101);
        this.xVelocity$delegate = q.d(this, r100);
        this.totalTime$delegate = q.d(this, 0L);
        this.limitTimeLength$delegate = q.d(this, 0L);
        this.limitStartTime$delegate = q.d(this, 0L);
        this.playTimeInfo$delegate = q.c(this);
        this.progressGestureEvent$delegate = e.b(this);
        this.thumbProcessEnable$delegate = q.d(this, r101);
        this.thumbProcessVisibility$delegate = q.d(this, 8);
        this.isTouchProgressBar$delegate = q.d(this, r101);
        this.thumbTitle$delegate = q.d(this, "");
        this.thumbHotLabel$delegate = q.d(this, r101);
        this.progressMarkStack = new VSSeekBarMarkRepelStack();
        this.highLightList$delegate = q.c(this);
        this.selectedOnlyTaSegment$delegate = q.c(this);
        this.vsRoomEnableSeek$delegate = q.d(this, r101);
        com.bytedance.live.datacontext.b.a(this, TAG);
        com.bytedance.live.datacontext.b.a(this, PlayerProgressServiceContext.class.getName());
    }

    public final IQuality getForceSeekResolution() {
        return this.forceSeekResolution;
    }

    public final VSSeekBarMarkRepelStack getProgressMarkStack() {
        return this.progressMarkStack;
    }

    public final Boolean isPlaying() {
        return this.isPlaying;
    }

    public final boolean isSeekBarTracking() {
        return this.isSeekBarTracking;
    }

    public final void setForceSeekResolution(IQuality r100) {
        this.forceSeekResolution = r100;
    }

    public final void setPlaying(Boolean r100) {
        this.isPlaying = r100;
    }

    public final void setSeekBarTracking(boolean r100) {
        this.isSeekBarTracking = r100;
    }
}
