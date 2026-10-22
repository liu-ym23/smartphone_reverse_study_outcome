package com.bytedance.android.livesdk.utils.landscape;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import j40.c1;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J4\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0011j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001aRF\u0010(\u001a2\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0011j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/utils/landscape/LandscapeLiveMonitor;", "Lcom/bytedance/live/datacontext/DataContext;", "", "onStartShowUI", "onEndShowUI", "Lcom/bytedance/android/livesdk/utils/landscape/FeedAction;", "feedAction", "reportFeedAction", "", "getCurLandscapeScene", "duration", "", "name", "reportMethodDuration", "Lcom/bytedance/android/livesdk/utils/landscape/a;", "fluencyInfo", "reportFluency", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "report", "onStartFeed", "", "roomId", "onEndFeed", "startUITime", "J", "startRequestTime", "curRoomId", "curOrientation", "I", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/utils/landscape/LandscapeScene;", "curRoomInfo", "Lkotlin/Pair;", "curFeedAction", "Lcom/bytedance/android/livesdk/utils/landscape/FeedAction;", "feedScene", "feedFirstRoomId", "Lkotlin/Function2;", "mLogger", "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeLiveMonitor extends DataContext {
    public static final a Companion = null;
    private static final String TAG = "LandscapeLiveMonitor";
    private FeedAction curFeedAction;
    private int curOrientation;
    private long curRoomId;
    private Pair<Long, ? extends LandscapeScene> curRoomInfo;
    private long feedFirstRoomId;
    private int feedScene;
    private Function2<? super String, ? super HashMap<String, String>, Unit> mLogger;
    private long startRequestTime;
    private long startUITime;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            if (c1.f497177a.getValue().intValue() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static LandscapeLiveMonitor b() {
            DataContext r100 = null;
            if (a() == true) goto L5;
            return null;
        L5:
            DataContext r101 = com.bytedance.live.datacontext.d.d(LandscapeLiveMonitor.TAG);
            if ((r101 instanceof LandscapeLiveMonitor) == false) goto L10;
            r100 = r101;
        L10:
            return (LandscapeLiveMonitor) r100;
        }

        @JvmStatic
        public static void d(Pair r100) {
            Intrinsics.checkNotNullParameter(r100, "pair");
            LandscapeLiveMonitor r101 = b();
            if (r101 == null) goto L6;
            LandscapeLiveMonitor.access$setCurRoomInfo$p(r101, r100);
            return;
        }

        @JvmStatic
        public static void c(FragmentActivity r100, Function2 r101) {
            Intrinsics.checkNotNullParameter(r101, "logger");
            if (a() == true) goto L6;
            return;
        L6:
            if (b() != null) goto L13;
            if (r100 == null) goto L15;
            int r102 = com.bytedance.live.datacontext.d.f255080a;
            Intrinsics.checkNotNullParameter(r100, "owner");
            Intrinsics.checkNotNullParameter(r100, "owner");
            ViewModelProvider r103 = ViewModelProviders.of(r100);
            Intrinsics.checkNotNullParameter(LandscapeLiveMonitor.class, "cls");
            com.bytedance.live.datacontext.d.c((DataContext) r103.get(LandscapeLiveMonitor.class), LandscapeLiveMonitor.TAG);
            LandscapeLiveMonitor r104 = b();
            if (r104 == null) goto L14;
            LandscapeLiveMonitor.access$setMLogger$p(r104, r101);
            return;
        L14:
            return;
        L15:
            return;
        }
    }

    @JvmStatic
    public static final void init(FragmentActivity r100, Function2<? super String, ? super HashMap<String, String>, Unit> r101) {
        Companion.getClass();
        a.c(r100, r101);
    }

    @JvmStatic
    public static final void setCurRoomInfo(Pair<Long, ? extends LandscapeScene> r100) {
        Companion.getClass();
        a.d(r100);
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final void endShowUI() {
        Companion.getClass();
        LandscapeLiveMonitor r100 = a.b();
        if (r100 == null) goto L6;
        access$onEndShowUI(r100);
        return;
    }

    private final int getCurLandscapeScene() {
        long r100 = this.curRoomId;
        if (r100 == 0) goto L11;
        if (this.curOrientation != 1) goto L11;
        if (r100 != this.curRoomInfo.getFirst().longValue()) goto L11;
        return this.curRoomInfo.getSecond().getValue();
    L11:
        return LandscapeScene.NONE.getValue();
    }

    @JvmStatic
    public static final int getLandscapeScene() {
        Companion.getClass();
        LandscapeLiveMonitor r100 = a.b();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return access$getCurLandscapeScene(r100);
    }

    @JvmStatic
    private static final LandscapeLiveMonitor getShared() {
        Companion.getClass();
        return a.b();
    }

    private final void onEndShowUI() {
        if (this.startUITime != 0) goto L5;
        return;
    L5:
        int r100 = (int) (System.currentTimeMillis() - this.startUITime);
        this.startUITime = 0;
        reportMethodDuration(r100, "ui_show_interaction");
    }

    @JvmStatic
    public static final int sampleInterval() {
        Companion.getClass();
        return c1.f497177a.getValue().intValue();
    }

    @JvmStatic
    public static final void startFeed() {
        Companion.getClass();
        LandscapeLiveMonitor r100 = a.b();
        if (r100 == null) goto L5;
        r100.onStartFeed();
    L5:
        FeedAction r101 = FeedAction.PRODUCE;
        Intrinsics.checkNotNullParameter(r101, "action");
        LandscapeLiveMonitor r102 = a.b();
        if (r102 == null) goto L9;
        access$reportFeedAction(r102, r101);
        return;
    }

    @JvmStatic
    public static final void startShowUI() {
        Companion.getClass();
        LandscapeLiveMonitor r100 = a.b();
        if (r100 == null) goto L6;
        access$onStartShowUI(r100);
        return;
    }

    public LandscapeLiveMonitor() {
        this.curRoomInfo = new Pair(0L, LandscapeScene.NONE);
        this.curFeedAction = FeedAction.NONE;
    }

    private final void onStartShowUI() {
        this.startUITime = System.currentTimeMillis();
    }

    public final void onStartFeed() {
        this.startRequestTime = System.currentTimeMillis();
    }

    public static final /* synthetic */ int access$getCurLandscapeScene(LandscapeLiveMonitor r100) {
        return r100.getCurLandscapeScene();
    }

    public static final /* synthetic */ int access$getCurOrientation$p(LandscapeLiveMonitor r100) {
        return r100.curOrientation;
    }

    public static final /* synthetic */ long access$getCurRoomId$p(LandscapeLiveMonitor r100) {
        return r100.curRoomId;
    }

    public static final /* synthetic */ Pair access$getCurRoomInfo$p(LandscapeLiveMonitor r100) {
        return r100.curRoomInfo;
    }

    public static final /* synthetic */ long access$getFeedFirstRoomId$p(LandscapeLiveMonitor r100) {
        return r100.feedFirstRoomId;
    }

    public static final /* synthetic */ Function2 access$getMLogger$p(LandscapeLiveMonitor r100) {
        return r100.mLogger;
    }

    public static final /* synthetic */ void access$onEndShowUI(LandscapeLiveMonitor r100) {
        r100.onEndShowUI();
    }

    public static final /* synthetic */ void access$onStartShowUI(LandscapeLiveMonitor r100) {
        r100.onStartShowUI();
    }

    @JvmStatic
    public static final void endFeed(long r100) {
        Companion.getClass();
        LandscapeLiveMonitor r101 = a.b();
        if (r101 == null) goto L6;
        r101.onEndFeed(r100);
        return;
    }

    @JvmStatic
    public static final void feedAction(FeedAction r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        LandscapeLiveMonitor r101 = a.b();
        if (r101 == null) goto L6;
        access$reportFeedAction(r101, r100);
        return;
    }

    private final void reportFeedAction(FeedAction r100) {
        int r101 = LandscapeScene.NONE.getValue();
        int r102 = c.f159072a[r100.ordinal()];
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L6;
    L5:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
        return;
    L16:
        report("livesdk_landscape_live_feed_action", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(IPerformanceManager.Params.landscape_scene, String.valueOf(r101)), TuplesKt.to("action", String.valueOf(r100.getValue()))}));
        this.curFeedAction = r100;
        return;
    L6:
        r101 = this.feedScene;
        if (this.curFeedAction != FeedAction.PRODUCE) goto L5;
    L13:
        r103 = true;
        goto L14
    L9:
        r101 = getCurLandscapeScene();
        FeedAction r104 = this.curFeedAction;
        if (r104 == FeedAction.CONSUME) goto L13;
        if (r104 != FeedAction.NONE) goto L5;
        goto L5
    }

    private final void reportFluency(com.bytedance.android.livesdk.utils.landscape.a r100) {
        report("livesdk_landscape_live_fluency", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("drop_x_count", String.valueOf(r100.f159061a)), TuplesKt.to("ui_fps", String.valueOf(r100.f159062b)), TuplesKt.to("duration", String.valueOf(r100.f159063c)), TuplesKt.to("all_frame", String.valueOf(r100.f159064d)), TuplesKt.to("drop_max", String.valueOf(r100.f159065e)), TuplesKt.to("level_1", String.valueOf(r100.f159066f)), TuplesKt.to("level_2", String.valueOf(r100.f159067g)), TuplesKt.to("level_3", String.valueOf(r100.f159068h)), TuplesKt.to("level_4", String.valueOf(r100.f159069i)), TuplesKt.to("block_duration", String.valueOf(r100.f159070j)), TuplesKt.to("orientation", String.valueOf(r100.f159071k))}));
    }

    @JvmStatic
    public static final void setCurOrientation(int r100) {
        Companion.getClass();
        LandscapeLiveMonitor r101 = a.b();
        if (r101 == null) goto L6;
        access$setCurOrientation$p(r101, r100);
        return;
    }

    @JvmStatic
    public static final void setCurRoomId(long r100) {
        Companion.getClass();
        LandscapeLiveMonitor r101 = a.b();
        if (r101 == null) goto L5;
        access$setCurRoomId$p(r101, r100);
    L5:
        LandscapeLiveMonitor r102 = a.b();
        if (r102 == null) goto L8;
        long r103 = access$getFeedFirstRoomId$p(r102);
    L10:
        if (r100 != 0) goto L12;
        return;
    L12:
        if (r103 != 0) goto L14;
        return;
    L14:
        if (r100 != r103) goto L21;
        FeedAction r104 = FeedAction.CONSUME;
        Intrinsics.checkNotNullParameter(r104, "action");
        LandscapeLiveMonitor r105 = a.b();
        if (r105 == null) goto L22;
        access$reportFeedAction(r105, r104);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r103 = 0;
        goto L10
    }

    @JvmStatic
    public static final void slideFluency(com.bytedance.android.livesdk.utils.landscape.a r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "fluencyInfo");
        LandscapeLiveMonitor r101 = a.b();
        if (r101 == null) goto L6;
        access$reportFluency(r101, r100);
        return;
    }

    public final void onEndFeed(long r100) {
        if (this.startRequestTime != 0) goto L5;
        return;
    L5:
        int r101 = (int) (System.currentTimeMillis() - this.startRequestTime);
        this.startRequestTime = 0;
        this.feedFirstRoomId = r100;
        this.feedScene = getCurLandscapeScene();
        reportMethodDuration(r101, "request_feed");
    }

    public static final /* synthetic */ void access$reportFeedAction(LandscapeLiveMonitor r100, FeedAction r101) {
        r100.reportFeedAction(r101);
    }

    public static final /* synthetic */ void access$reportFluency(LandscapeLiveMonitor r100, com.bytedance.android.livesdk.utils.landscape.a r101) {
        r100.reportFluency(r101);
    }

    public static final /* synthetic */ void access$setCurOrientation$p(LandscapeLiveMonitor r100, int r101) {
        r100.curOrientation = r101;
    }

    public static final /* synthetic */ void access$setCurRoomId$p(LandscapeLiveMonitor r100, long r101) {
        r100.curRoomId = r101;
    }

    public static final /* synthetic */ void access$setCurRoomInfo$p(LandscapeLiveMonitor r100, Pair r101) {
        r100.curRoomInfo = r101;
    }

    public static final /* synthetic */ void access$setFeedFirstRoomId$p(LandscapeLiveMonitor r100, long r101) {
        r100.feedFirstRoomId = r101;
    }

    public static final /* synthetic */ void access$setMLogger$p(LandscapeLiveMonitor r100, Function2 r101) {
        r100.mLogger = r101;
    }

    @JvmStatic
    public static final void methodCost(int r100, String r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        LandscapeLiveMonitor r102 = a.b();
        if (r102 == null) goto L6;
        access$reportMethodDuration(r102, r100, r101);
        return;
    }

    private final void report(String r100, HashMap<String, String> r101) {
        Function2<? super String, ? super HashMap<String, String>, Unit> r102 = this.mLogger;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r100, r101);
        return;
    }

    private final void reportMethodDuration(int r100, String r101) {
        if (f.a() == false) goto L5;
    L7:
        report("livesdk_landscape_live_duration", MapsKt.hashMapOf(new Pair[]{TuplesKt.to(IPerformanceManager.Params.landscape_scene, String.valueOf(getCurLandscapeScene())), TuplesKt.to("duration", String.valueOf(r100)), TuplesKt.to(com.alipay.sdk.m.p.e.f25671s, r101)}));
        return;
    L5:
        if (b.a() == true) goto L7;
    }

    public static final /* synthetic */ void access$reportMethodDuration(LandscapeLiveMonitor r100, int r101, String r102) {
        r100.reportMethodDuration(r101, r102);
    }
}
