package com.bytedance.android.live.liveinteract.interactivesong.impl;

import android.view.View;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongGoldMicrophoneState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongSingState;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fd2.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u007f2\u00020\u00012\u00020\u0002:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b}\u0010~J\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\u0017R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u001fR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\u0017R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0017R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0017R'\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\u0017R'\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\u0017R'\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\u0017R'\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\u0017R!\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\u0017R!\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\u0017R!\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\u0017R!\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\u001fR!\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\u0017R!\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\u0017R'\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020H0G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR'\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020N0G8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010LR#\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030G8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010LR!\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\u0017R!\u0010Y\u001a\b\u0012\u0004\u0012\u00020\t0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u000b\u001a\u0004\bY\u0010\u0017R$\u0010Z\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010a\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010m\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR!\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\b{\u0010\u001f¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/impl/InteractiveSongContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "getSelfSingingState", "", "userId", "getSingStateByUserId", "Lcom/bytedance/live/datacontext/i;", "", "isFeed$delegate", "Lcom/bytedance/live/datacontext/p;", "isFeed", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/j;", "Lof0/b;", "interactiveSongWidget$delegate", "getInteractiveSongWidget", "()Lcom/bytedance/live/datacontext/j;", "interactiveSongWidget", "Lcom/bytedance/live/datacontext/m;", "isShowPlayer$delegate", "isShowPlayer", "()Lcom/bytedance/live/datacontext/m;", "showOrderSingStage$delegate", "getShowOrderSingStage", "showOrderSingStage", "Lcom/bytedance/live/datacontext/n;", "Lfd2/v;", "lyricsRecognizer$delegate", "getLyricsRecognizer", "()Lcom/bytedance/live/datacontext/n;", "lyricsRecognizer", "isOpenInteractiveSong$delegate", "isOpenInteractiveSong", "currentPlayMode$delegate", "getCurrentPlayMode", "currentPlayMode", "isHaveCurrentPlayMode$delegate", "isHaveCurrentPlayMode", "", "", "currentGiftIdList$delegate", "getCurrentGiftIdList", "currentGiftIdList", "currentGiftNumList$delegate", "getCurrentGiftNumList", "currentGiftNumList", "currentTestGiftIdList$delegate", "getCurrentTestGiftIdList", "currentTestGiftIdList", "currentTestGiftNumList$delegate", "getCurrentTestGiftNumList", "currentTestGiftNumList", "showGiftInfo$delegate", "getShowGiftInfo", "showGiftInfo", "isAIMVStage$delegate", "isAIMVStage", "isAiLyricsSwitchOn$delegate", "isAiLyricsSwitchOn", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/c;", "aiMVPlayService$delegate", "getAiMVPlayService", "aiMVPlayService", "currentMvEmoTag$delegate", "getCurrentMvEmoTag", "currentMvEmoTag", "currentIsInSongRefrain$delegate", "getCurrentIsInSongRefrain", "currentIsInSongRefrain", "Ljava/util/concurrent/ConcurrentHashMap;", "Lpf0/a;", "guestListInteractiveSongInfo$delegate", "Lkotlin/Lazy;", "getGuestListInteractiveSongInfo", "()Ljava/util/concurrent/ConcurrentHashMap;", "guestListInteractiveSongInfo", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/interactivesong/RequestSongGoldMicrophoneState;", "micSeatStates$delegate", "getMicSeatStates", "micSeatStates", "singingStates", "Ljava/util/concurrent/ConcurrentHashMap;", "getSingingStates", "singingGuestId$delegate", "getSingingGuestId", "singingGuestId", "isSeatEnlarge$delegate", "isSeatEnlarge", "curOrderSongItemId", "Ljava/lang/String;", "getCurOrderSongItemId", "()Ljava/lang/String;", "setCurOrderSongItemId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/h;", "curMvDialogSelectedMv", "Lcom/bytedance/android/live/liveinteract/interactivesong/panel/h;", "getCurMvDialogSelectedMv", "()Lcom/bytedance/android/live/liveinteract/interactivesong/panel/h;", "setCurMvDialogSelectedMv", "(Lcom/bytedance/android/live/liveinteract/interactivesong/panel/h;)V", "mvWatchDuration", "J", "getMvWatchDuration", "()J", "setMvWatchDuration", "(J)V", "curHasMvIsPlaying", "Z", "getCurHasMvIsPlaying", "()Z", "setCurHasMvIsPlaying", "(Z)V", "Lcom/google/gson/JsonObject;", "recordeLastSpeechRhythmBeats", "Lcom/google/gson/JsonObject;", "getRecordeLastSpeechRhythmBeats", "()Lcom/google/gson/JsonObject;", "setRecordeLastSpeechRhythmBeats", "(Lcom/google/gson/JsonObject;)V", "stageLyricFontStyle$delegate", "getStageLyricFontStyle", "stageLyricFontStyle", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int STAGE_EFFECTS_AIMV = 2;
    public static final int STAGE_EFFECTS_NORMAL = 1;
    public static final String TAG_FOR_FEED = "InteractiveSongFeedContext";
    public static final String TAG_FOR_LIVE = "InteractiveSongContext";
    private static final ConcurrentHashMap<String, com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.a> micSeatTaskExecutors = null;
    private final p aiMVPlayService$delegate;
    private boolean curHasMvIsPlaying;
    private com.bytedance.android.live.liveinteract.interactivesong.panel.h curMvDialogSelectedMv;
    private String curOrderSongItemId;
    private final p currentGiftIdList$delegate;
    private final p currentGiftNumList$delegate;
    private final p currentIsInSongRefrain$delegate;
    private final p currentMvEmoTag$delegate;
    private final p currentPlayMode$delegate;
    private final p currentTestGiftIdList$delegate;
    private final p currentTestGiftNumList$delegate;
    private final Lazy guestListInteractiveSongInfo$delegate;
    private final p interactiveSongWidget$delegate;
    private final p isAIMVStage$delegate;
    private final p isAiLyricsSwitchOn$delegate;
    private final p isFeed$delegate;
    private final p isHaveCurrentPlayMode$delegate;
    private final p isOpenInteractiveSong$delegate;
    private final p isSeatEnlarge$delegate;
    private final p isShowPlayer$delegate;
    private final p lyricsRecognizer$delegate;
    private final Lazy micSeatStates$delegate;
    private long mvWatchDuration;
    private JsonObject recordeLastSpeechRhythmBeats;
    private final p showGiftInfo$delegate;
    private final p showOrderSingStage$delegate;
    private final p singingGuestId$delegate;
    private final ConcurrentHashMap<String, Integer> singingStates;
    private final p stageLyricFontStyle$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final InteractiveSongContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(InteractiveSongContext.TAG_FOR_LIVE);
            if ((r100 instanceof InteractiveSongContext) == true) goto L5;
            r100 = null;
        L5:
            InteractiveSongContext r101 = (InteractiveSongContext) r100;
            DataContext r102 = com.bytedance.live.datacontext.d.d(InteractiveSongContext.TAG_FOR_FEED);
            if ((r102 instanceof InteractiveSongContext) == true) goto L8;
            r102 = null;
        L8:
            InteractiveSongContext r103 = (InteractiveSongContext) r102;
            if (r101 != null) goto L11;
        L13:
            if (r103 != null) goto L15;
        L24:
            return null;
        L15:
            if (r103.isFeed().getValue().booleanValue() != true) goto L24;
            o r104 = IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3);
            if (r104 == null) goto L21;
            n<IRoom> r105 = r104.getInteractionDataPrepared();
            if (r105 == null) goto L21;
            IRoom r106 = r105.getValue();
        L22:
            if (r106 != null) goto L24;
            return r103;
        L21:
            r106 = null;
            goto L22
        L11:
            if (r101.isFeed().getValue().booleanValue() == true) goto L13;
            return r101;
        }

        @JvmStatic
        public final of0.b c() {
            InteractiveSongContext r100 = getContext();
            if (r100 == null) goto L7;
            com.bytedance.live.datacontext.j<of0.b> r101 = r100.getInteractiveSongWidget();
            if (r101 == null) goto L7;
            return r101.getValue();
        L7:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final boolean f() {
            InteractiveSongContext r100 = getContext();
            if (r100 == null) goto L8;
            m<Boolean> r101 = r100.m8177isOpenInteractiveSong();
            if (r101 == null) goto L8;
            if (r101.getValue().booleanValue() != true) goto L8;
            return true;
        L8:
            InteractiveSongContext r102 = getContext();
            if (r102 == null) goto L14;
            m r103 = InteractiveSongContext.access$isHaveCurrentPlayMode$p(r102);
            if (r103 == null) goto L14;
            if (((Boolean) r103.getValue()).booleanValue() != true) goto L14;
            return true;
        L14:
            InteractiveSongContext r104 = getContext();
            if (r104 == null) goto L19;
            m r105 = InteractiveSongContext.access$getCurrentPlayMode$p(r104);
            if (r105 == null) goto L19;
            String r106 = (String) r105.getValue();
        L21:
            if (Intrinsics.areEqual(r106, String.valueOf(19)) == true) goto L27;
            return false;
        L27:
            return true;
        L19:
            r106 = null;
            goto L21
        }

        @JvmStatic
        public final void a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "userId");
            InteractiveSongContext r100 = getContext();
            pf0.a r101 = null;
            if (r100 == null) goto L5;
            ConcurrentHashMap<String, pf0.a> r102 = r100.getGuestListInteractiveSongInfo();
        L7:
            if (r2.a(r110) == false) goto L14;
            if (r102 == null) goto L10;
            r101 = r102.get(r110);
        L10:
            if (r101 != null) goto L15;
            if (r102 == null) goto L16;
            pf0.a r111 = r102.put(r110, new pf0.a(r110, 0, null, null, null, 28));
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r102 = null;
            goto L7
        }

        public final void b(boolean r100) {
            InteractiveSongContext r101 = getContext();
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.getLyricsRecognizer().getValue() != null) goto L13;
            n<v> r102 = r101.getLyricsRecognizer();
            IKtvService r103 = (IKtvService) jc1.k.f(IKtvService.class);
            if (r103 == null) goto L9;
            v r104 = r103.createSpeechRecognizer(r100);
        L10:
            r102.setValue(r104);
            return;
        L9:
            r104 = null;
            goto L10
        }

        public final boolean e(IRoom r100, Integer r101) {
            if (s0.g(r100) == false) goto L19;
            if (r101 == null) goto L19;
            if (r101.intValue() != 27) goto L19;
            if (f() == false) goto L17;
            InteractiveSongContext r102 = getContext();
            if (r102 == null) goto L17;
            m<Boolean> r103 = r102.getShowOrderSingStage();
            if (r103 == null) goto L17;
            if (r103.getValue().booleanValue() != true) goto L17;
            boolean r104 = true;
        L18:
            if (r104 == false) goto L19;
        L23:
            return true;
        L17:
            r104 = false;
        L19:
            if (r101 != null) goto L22;
            return false;
        L22:
            if (r101.intValue() == 30) goto L23;
            return false;
        }

        @JvmStatic
        public final void g(boolean r100, boolean r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "currentPlayMode");
            InteractiveSongContext r104 = getContext();
            if (r104 == null) goto L7;
            m r105 = InteractiveSongContext.access$isHaveCurrentPlayMode$p(r104);
            if (r105 == null) goto L7;
            r105.setValue(Boolean.valueOf(r100));
        L7:
            InteractiveSongContext r106 = getContext();
            if (r106 == null) goto L12;
            m<Boolean> r107 = r106.m8177isOpenInteractiveSong();
            if (r107 == null) goto L12;
            Boolean r108 = r107.getValue();
        L13:
            InteractiveSongContext r109 = getContext();
            if (r109 == null) goto L18;
            m<Boolean> r110 = r109.m8177isOpenInteractiveSong();
            if (r110 == null) goto L18;
            r110.setValue(Boolean.valueOf(r101));
        L18:
            InteractiveSongContext r111 = getContext();
            if (r111 == null) goto L24;
            m r112 = InteractiveSongContext.access$getCurrentPlayMode$p(r111);
            if (r112 == null) goto L24;
            r112.setValue(r103);
        L24:
            if (r103.length() != 0) goto L26;
            boolean r113 = true;
        L28:
            if (r113 == false) goto L34;
            com.bytedance.live.datacontext.j<LivePlayModeLogContext> r114 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
            if (r114 == null) goto L40;
            LivePlayModeLogContext r115 = r114.getValue();
            if (r115 == null) goto L40;
            r115.removePlayMode(19);
        L40:
            if ((!Intrinsics.areEqual(r108, Boolean.valueOf(r101))) == false) goto L43;
            b(r102);
            return;
        L43:
            return;
        L34:
            com.bytedance.live.datacontext.j<LivePlayModeLogContext> r116 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
            if (r116 == null) goto L40;
            LivePlayModeLogContext r117 = r116.getValue();
            if (r117 == null) goto L40;
            r117.addPlayMode(19);
            goto L40
        L26:
            r113 = false;
        L12:
            r108 = null;
            goto L13
        }

        public static boolean d(a r100, ch0.e r101, int r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = false;
        L8:
            r100.getClass();
            if (vm2.h.h0().g() == true) goto L12;
            return false;
        L12:
            if (vm2.h.h0().c() == false) goto L17;
            if (r103 == true) goto L17;
            if (vm2.h.h0().b().contains(String.valueOf(r102)) == true) goto L17;
            return false;
        L17:
            if (r101 == null) goto L63;
            InteractiveSongContext r105 = r100.getContext();
            if (r105 == null) goto L64;
            ILinkPlayerInfoBridge r106 = r101.f23724a;
            CustomizeStreamContext r107 = CustomizeStreamContext.Companion.getContext();
            if (r107 == null) goto L29;
            m<Boolean> r108 = r107.getCustomizeStreamStarted();
            if (r108 == null) goto L29;
            if (r108.getValue().booleanValue() != true) goto L29;
            boolean r109 = true;
        L31:
            if (je0.d.q() == false) goto L41;
            ch0.j r110 = r101.f23726c;
            if (r105.isShowPlayer().getValue().booleanValue() == false) goto L52;
            if (r110 != null) goto L36;
            return false;
        L36:
            if (r110.f23746c == 1) goto L38;
            return false;
        L38:
            if (r106.getMLinkType() != 1) goto L55;
            if (r109 == true) goto L56;
        L50:
            return true;
        L56:
            return false;
        L55:
            return false;
        L52:
            return false;
        L41:
            ch0.h r111 = r101.f23725b;
            if (r106.getMLinkType() == 1) goto L44;
            return false;
        L44:
            if (ch0.f.d(r101) == false) goto L58;
            if (r111 == null) goto L47;
            View r112 = r111.f23734b;
        L48:
            if (r112 == null) goto L59;
            if (r109 == false) goto L50;
            return false;
        L59:
            return false;
        L47:
            r112 = null;
            goto L48
        L58:
            return false;
        L29:
            r109 = false;
            goto L31
        L64:
            return false;
        L63:
            return false;
        }
    }

    @JvmStatic
    public static final void addGuestRequestSongInfoIfNeed(String r100) {
        Companion.a(r100);
    }

    @JvmStatic
    public static final InteractiveSongContext getContext() {
        return Companion.getContext();
    }

    private final m<String> getCurrentPlayMode() {
        return (m) this.currentPlayMode$delegate.a(this, $$delegatedProperties[6]);
    }

    @JvmStatic
    public static final of0.b getWidget() {
        return Companion.c();
    }

    private final m<Boolean> isHaveCurrentPlayMode() {
        return (m) this.isHaveCurrentPlayMode$delegate.a(this, $$delegatedProperties[7]);
    }

    @JvmStatic
    public static final boolean isOpenInteractiveSong() {
        return Companion.f();
    }

    @JvmStatic
    public static final void updateInteractiveSongStatus(boolean r100, boolean r101, boolean r102, String r103) {
        Companion.g(r100, r101, r102, r103);
    }

    public final n<com.bytedance.android.livesdk.ktvapi.model.mv.c> getAiMVPlayService() {
        return (n) this.aiMVPlayService$delegate.a(this, $$delegatedProperties[15]);
    }

    public final m<List<Long>> getCurrentGiftIdList() {
        return (m) this.currentGiftIdList$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<List<Long>> getCurrentGiftNumList() {
        return (m) this.currentGiftNumList$delegate.a(this, $$delegatedProperties[9]);
    }

    public final m<Integer> getCurrentIsInSongRefrain() {
        return (m) this.currentIsInSongRefrain$delegate.a(this, $$delegatedProperties[17]);
    }

    public final m<String> getCurrentMvEmoTag() {
        return (m) this.currentMvEmoTag$delegate.a(this, $$delegatedProperties[16]);
    }

    public final m<List<Long>> getCurrentTestGiftIdList() {
        return (m) this.currentTestGiftIdList$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<List<Long>> getCurrentTestGiftNumList() {
        return (m) this.currentTestGiftNumList$delegate.a(this, $$delegatedProperties[11]);
    }

    public final ConcurrentHashMap<String, pf0.a> getGuestListInteractiveSongInfo() {
        return (ConcurrentHashMap) this.guestListInteractiveSongInfo$delegate.getValue();
    }

    public final com.bytedance.live.datacontext.j<of0.b> getInteractiveSongWidget() {
        return (com.bytedance.live.datacontext.j) this.interactiveSongWidget$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<v> getLyricsRecognizer() {
        return (n) this.lyricsRecognizer$delegate.a(this, $$delegatedProperties[4]);
    }

    public final ConcurrentHashMap<String, RequestSongGoldMicrophoneState> getMicSeatStates() {
        return (ConcurrentHashMap) this.micSeatStates$delegate.getValue();
    }

    public final m<Boolean> getShowGiftInfo() {
        return (m) this.showGiftInfo$delegate.a(this, $$delegatedProperties[12]);
    }

    public final m<Boolean> getShowOrderSingStage() {
        return (m) this.showOrderSingStage$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<String> getSingingGuestId() {
        return (m) this.singingGuestId$delegate.a(this, $$delegatedProperties[18]);
    }

    public final n<Object> getStageLyricFontStyle() {
        return (n) this.stageLyricFontStyle$delegate.a(this, $$delegatedProperties[20]);
    }

    public final m<Boolean> isAIMVStage() {
        return (m) this.isAIMVStage$delegate.a(this, $$delegatedProperties[13]);
    }

    public final m<Boolean> isAiLyricsSwitchOn() {
        return (m) this.isAiLyricsSwitchOn$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isFeed() {
        return (com.bytedance.live.datacontext.i) this.isFeed$delegate.a(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: renamed from: isOpenInteractiveSong, reason: collision with other method in class */
    public final m<Boolean> m8177isOpenInteractiveSong() {
        return (m) this.isOpenInteractiveSong$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> isSeatEnlarge() {
        return (m) this.isSeatEnlarge$delegate.a(this, $$delegatedProperties[19]);
    }

    public final m<Boolean> isShowPlayer() {
        return (m) this.isShowPlayer$delegate.a(this, $$delegatedProperties[2]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isFeed", "isFeed()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "interactiveSongWidget", "getInteractiveSongWidget()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isShowPlayer", "isShowPlayer()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "showOrderSingStage", "getShowOrderSingStage()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "lyricsRecognizer", "getLyricsRecognizer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isOpenInteractiveSong", "isOpenInteractiveSong()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentPlayMode", "getCurrentPlayMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isHaveCurrentPlayMode", "isHaveCurrentPlayMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentGiftIdList", "getCurrentGiftIdList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentGiftNumList", "getCurrentGiftNumList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentTestGiftIdList", "getCurrentTestGiftIdList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentTestGiftNumList", "getCurrentTestGiftNumList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "showGiftInfo", "getShowGiftInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isAIMVStage", "isAIMVStage()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isAiLyricsSwitchOn", "isAiLyricsSwitchOn()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "aiMVPlayService", "getAiMVPlayService()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentMvEmoTag", "getCurrentMvEmoTag()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "currentIsInSongRefrain", "getCurrentIsInSongRefrain()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "singingGuestId", "getSingingGuestId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "isSeatEnlarge", "isSeatEnlarge()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractiveSongContext.class, "stageLyricFontStyle", "getStageLyricFontStyle()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
        micSeatTaskExecutors = new ConcurrentHashMap();
    }

    public final int getSelfSingingState() {
        Integer r100 = this.singingStates.get(((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return RequestSongSingState.STATE_NOSING.getValue();
    }

    public InteractiveSongContext() {
        Boolean r100 = Boolean.FALSE;
        this.isFeed$delegate = ConstantKt.d(this, r100);
        this.interactiveSongWidget$delegate = ConstantKt.c(this);
        this.isShowPlayer$delegate = q.d(this, r100);
        this.showOrderSingStage$delegate = q.d(this, r100);
        this.lyricsRecognizer$delegate = q.c(this);
        this.isOpenInteractiveSong$delegate = q.d(this, r100);
        this.currentPlayMode$delegate = q.d(this, "");
        this.isHaveCurrentPlayMode$delegate = q.d(this, r100);
        this.currentGiftIdList$delegate = q.d(this, new ArrayList());
        this.currentGiftNumList$delegate = q.d(this, new ArrayList());
        this.currentTestGiftIdList$delegate = q.d(this, new ArrayList());
        this.currentTestGiftNumList$delegate = q.d(this, new ArrayList());
        this.showGiftInfo$delegate = q.d(this, r100);
        this.isAIMVStage$delegate = q.d(this, r100);
        this.isAiLyricsSwitchOn$delegate = q.d(this, r100);
        this.aiMVPlayService$delegate = q.c(this);
        this.currentMvEmoTag$delegate = q.d(this, "");
        this.currentIsInSongRefrain$delegate = q.d(this, 0);
        this.guestListInteractiveSongInfo$delegate = LazyKt.lazy(InteractiveSongContext$guestListInteractiveSongInfo$2.INSTANCE);
        this.micSeatStates$delegate = LazyKt.lazy(InteractiveSongContext$micSeatStates$2.INSTANCE);
        this.singingStates = new ConcurrentHashMap();
        this.singingGuestId$delegate = q.d(this, "");
        this.isSeatEnlarge$delegate = q.d(this, r100);
        this.stageLyricFontStyle$delegate = q.c(this);
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMicSeatTaskExecutors$cp() {
        return micSeatTaskExecutors;
    }

    public final boolean getCurHasMvIsPlaying() {
        return this.curHasMvIsPlaying;
    }

    public final com.bytedance.android.live.liveinteract.interactivesong.panel.h getCurMvDialogSelectedMv() {
        return this.curMvDialogSelectedMv;
    }

    public final String getCurOrderSongItemId() {
        return this.curOrderSongItemId;
    }

    public final long getMvWatchDuration() {
        return this.mvWatchDuration;
    }

    public final JsonObject getRecordeLastSpeechRhythmBeats() {
        return this.recordeLastSpeechRhythmBeats;
    }

    public final ConcurrentHashMap<String, Integer> getSingingStates() {
        return this.singingStates;
    }

    public static final /* synthetic */ m access$getCurrentPlayMode$p(InteractiveSongContext r100) {
        return r100.getCurrentPlayMode();
    }

    public static final /* synthetic */ m access$isHaveCurrentPlayMode$p(InteractiveSongContext r100) {
        return r100.isHaveCurrentPlayMode();
    }

    public final int getSingStateByUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Integer r101 = this.singingStates.get(r100);
        if (r101 != null) goto L5;
        this.singingStates.put(r100, Integer.valueOf(RequestSongSingState.STATE_NOSING.getValue()));
    L5:
        if (r101 == null) goto L8;
        return r101.intValue();
    L8:
        return RequestSongSingState.STATE_NOSING.getValue();
    }

    public final void setCurHasMvIsPlaying(boolean r100) {
        this.curHasMvIsPlaying = r100;
    }

    public final void setCurMvDialogSelectedMv(com.bytedance.android.live.liveinteract.interactivesong.panel.h r100) {
        this.curMvDialogSelectedMv = r100;
    }

    public final void setCurOrderSongItemId(String r100) {
        this.curOrderSongItemId = r100;
    }

    public final void setMvWatchDuration(long r100) {
        this.mvWatchDuration = r100;
    }

    public final void setRecordeLastSpeechRhythmBeats(JsonObject r100) {
        this.recordeLastSpeechRhythmBeats = r100;
    }
}
