package com.bytedance.android.livesdk.chatroom.progressbar.service;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.d;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.e;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeOnlyTaSegmentScope;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeOnlyTaSegments;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.dex.maindexslimming.annotation.MainDexIgnore;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes7.dex */
public final class PlayerProgressService implements IPlayerProgressService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayerProgressServiceContext f107816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f107817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f107818c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressService f107819a;

        public b(PlayerProgressService r100) {
            this.f107819a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            PlayerProgressServiceContext r102 = this.f107819a.f107816a;
            if (r102 == null) goto L7;
            m<Integer> r103 = r102.getThumbProcessVisibility();
            if (r103 == null) goto L7;
            r103.setValue(0);
        L7:
            Disposable r104 = this.f107819a.f107818c;
            if (r104 == null) goto L10;
            r104.dispose();
        L10:
            this.f107819a.f107818c = null;
        }
    }

    public static final class c implements com.bytedance.android.live.core.log.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerProgressServiceContext f107820a;

        public c(PlayerProgressServiceContext r100) {
            this.f107820a = r100;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "updateHighLightTotalTime info: totalTime = " + this.f107820a.getTotalTime().getValue().longValue() + ",startLimit = " + this.f107820a.getLimitStartTime().getValue().longValue();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final Long getCurrentDisplayTimeInContext() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L7;
        m<Long> r101 = r100.getCurrentDisplayTime();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final Long getCurrentTimeInContext() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L7;
        m<Long> r101 = r100.getCurrentTime();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final boolean getHighLightDisplayStatus() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L9;
        VSSeekBarMarkRepelStack r101 = r100.getProgressMarkStack();
        if (r101 == null) goto L9;
        Pair<String, List<e>> r102 = r101.a();
        if (r102 == null) goto L9;
        String r103 = r102.getFirst();
    L11:
        return Intrinsics.areEqual(r103, "VS_HIGH_LIGHT");
    L9:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final boolean getOnlyTaDisplayStatus() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L9;
        VSSeekBarMarkRepelStack r101 = r100.getProgressMarkStack();
        if (r101 == null) goto L9;
        Pair<String, List<e>> r102 = r101.a();
        if (r102 == null) goto L9;
        String r103 = r102.getFirst();
    L11:
        return Intrinsics.areEqual(r103, "VS_ONLY_TA");
    L9:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final Long getTotalTimeInContext() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L7;
        m<Long> r101 = r100.getTotalTime();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void hideThumbProcessView() {
        Disposable r100 = this.f107818c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f107818c = null;
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L11;
        m<Integer> r102 = r101.getThumbProcessVisibility();
        if (r102 == null) goto L12;
        r102.setValue(8);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final boolean isAtLatest() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L9;
        m<Boolean> r101 = r100.getAtLatest();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void onProgressGestureEndTouch() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L8;
        k<com.bytedance.android.livesdk.chatroom.vsplayer.model.d> r101 = r100.getProgressGestureEvent();
        if (r101 == null) goto L9;
        r101.post(new com.bytedance.android.livesdk.chatroom.vsplayer.model.d(1));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void onProgressGestureStartTouch() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L8;
        k<com.bytedance.android.livesdk.chatroom.vsplayer.model.d> r101 = r100.getProgressGestureEvent();
        if (r101 == null) goto L9;
        r101.post(new com.bytedance.android.livesdk.chatroom.vsplayer.model.d(0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void pause() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L8;
        k<Boolean> r101 = r100.getPlayOrPauseEvent();
        if (r101 == null) goto L9;
        r101.post(Boolean.FALSE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void removeHighLightList() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L6;
        r100.getProgressMarkStack().delete("VS_HIGH_LIGHT");
        r100.getHighLightList().setValue(CollectionsKt.emptyList());
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void removeOnlyTaSegment() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L8;
        VSSeekBarMarkRepelStack r101 = r100.getProgressMarkStack();
        if (r101 == null) goto L9;
        r101.delete("VS_ONLY_TA");
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void resume() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L8;
        k<Boolean> r101 = r100.getPlayOrPauseEvent();
        if (r101 == null) goto L9;
        r101.post(Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final boolean seekToNearestOnlyTaSegment() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L7;
        m<Long> r101 = r100.getCurrentTime();
        if (r101 == null) goto L7;
        Long r102 = r101.getValue();
    L9:
        return seekToNextOnlyTaSegment(r102);
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final IQuality seekWithForceResolution() {
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getForceSeekResolution();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void updateHighLightTotalTime() {
        final PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getProgressMarkStack().a() == null) goto L15;
        Pair<String, List<e>> r101 = r100.getProgressMarkStack().a();
        if (r101 == null) goto L9;
        String r102 = r101.getFirst();
    L11:
        if (Intrinsics.areEqual(r102, "VS_HIGH_LIGHT") == false) goto L16;
        r100.getProgressMarkStack().update("VS_HIGH_LIGHT", new PlayerProgressService$updateHighLightTotalTime$1$1(r100));
        ALogger.v("IVSProgressService", new c(r100));
        return;
    L16:
        return;
    L9:
        r102 = null;
        goto L11
    }

    public PlayerProgressService() {
        this.f107817b = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekToFirstHighLight() {
        if (getHighLightDisplayStatus() == false) goto L14;
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L15;
        n<List<EpisodeHighLight>> r101 = r100.getHighLightList();
        if (r101 == null) goto L16;
        List<EpisodeHighLight> r102 = r101.getValue();
        if (r102 == null) goto L17;
        EpisodeHighLight r103 = (EpisodeHighLight) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L18;
        seekTo(r103.getLocation());
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekToFirstOnlyTaSegment() {
        if (getOnlyTaDisplayStatus() == false) goto L16;
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L17;
        n<EpisodeOnlyTaSegments> r101 = r100.getSelectedOnlyTaSegment();
        if (r101 == null) goto L18;
        EpisodeOnlyTaSegments r102 = r101.getValue();
        if (r102 == null) goto L19;
        List<EpisodeOnlyTaSegmentScope> r103 = r102.scopes;
        if (r103 != null) goto L13;
        return;
    L13:
        if ((!r103.isEmpty()) == false) goto L21;
        seekTo(((long) ((EpisodeOnlyTaSegmentScope) ListProtector.get(r102.scopes, 0)).startOffset) * 1000);
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekToRandomHighLight() {
        if (getHighLightDisplayStatus() == false) goto L16;
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L17;
        n<List<EpisodeHighLight>> r101 = r100.getHighLightList();
        if (r101 == null) goto L18;
        List<EpisodeHighLight> r102 = r101.getValue();
        if (r102 == null) goto L19;
        List r103 = CollectionsKt.shuffled(r102);
        if (r103 == null) goto L20;
        EpisodeHighLight r104 = (EpisodeHighLight) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L21;
        seekTo(r104.getLocation());
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void addProgressChangeListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f107817b).add(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void handleProgressListener(KFunction<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Iterator<T> r101 = this.f107817b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Function1 r102 = (Function1) r100;
        r102.invoke((d) r101.next());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final PlayerProgressServiceContext provideContext(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        PlayerProgressServiceContext.Companion.getClass();
        PlayerProgressServiceContext r101 = PlayerProgressServiceContext.a.a(r100);
        ALogger.d("IVSProgressService", "provide context:".concat(String.valueOf(r101)));
        if (r101 != null) goto L5;
    L24:
        ALogger.e("IVSProgressService", "provide cleared context:" + String.valueOf(r101) + ",skip refresh");
    L25:
        return r101;
    L5:
        if (r101.isCleared() == true) goto L24;
        PlayerProgressServiceContext r102 = this.f107816a;
        if (r102 != null) goto L9;
    L12:
        StringBuilder r103 = new StringBuilder("refresh context:from ");
        PlayerProgressServiceContext r104 = this.f107816a;
        if (r104 == null) goto L15;
        String r105 = r104.toString();
    L16:
        r103.append(r105);
        r103.append(" to ");
        r103.append(r101);
        ALogger.w("IVSProgressService", r103.toString());
        this.f107816a = r101;
        Boolean r106 = Boolean.TRUE;
        Boolean r107 = (Boolean) r100.get("cmd_first_show_at_latest", r106);
        Boolean r108 = Boolean.FALSE;
        if (Intrinsics.areEqual(r107, r108) == false) goto L25;
        PlayerProgressServiceContext r109 = this.f107816a;
        if (r109 == null) goto L23;
        m<Boolean> r110 = r109.getAtLatest();
        if (r110 == null) goto L23;
        r110.setValue(r108);
    L23:
        r100.put("cmd_first_show_at_latest", r106);
        goto L25
    L15:
        r105 = null;
        goto L16
    L9:
        if (r102.hashCode() != r101.hashCode()) goto L12;
        ALogger.d("IVSProgressService", "provide same context ,skip refresh");
        goto L25
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void removeProgressChangeListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f107817b).remove(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekTo(long r100) {
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L8;
        k<Long> r102 = r101.getSeekEvent();
        if (r102 == null) goto L9;
        r102.post(Long.valueOf(r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final boolean seekToNextOnlyTaSegment(Long r110) {
        if (getOnlyTaDisplayStatus() == false) goto L25;
        if (r110 == null) goto L25;
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L25;
        EpisodeOnlyTaSegments r101 = r100.getSelectedOnlyTaSegment().getValue();
        if (r101 == null) goto L25;
        List<EpisodeOnlyTaSegmentScope> r102 = r101.scopes;
        if (r102 == null) goto L25;
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        if ((((long) ((EpisodeOnlyTaSegmentScope) r104).startOffset) * 1000) <= r110.longValue()) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L13;
    L21:
        EpisodeOnlyTaSegmentScope r106 = (EpisodeOnlyTaSegmentScope) r104;
        if (r106 == null) goto L25;
        seekTo(((long) r106.startOffset) * 1000);
        return true;
    L17:
        r105 = false;
        goto L18
    L20:
        r104 = null;
    L25:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void setAtLatest(boolean r100) {
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L8;
        m<Boolean> r102 = r101.getAtLatest();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.valueOf(r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void setHighLightList(List<? extends EpisodeHighLight> r210) {
        Intrinsics.checkNotNullParameter(r210, "list");
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L29;
        r100.getHighLightList().setValue(r210);
        List<? extends EpisodeHighLight> r101 = r210;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L24;
        EpisodeHighLight r104 = (EpisodeHighLight) r103.next();
        long r110 = r104.getLocation() * 1000;
        String r105 = r104.getDescription();
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        String r111 = r105;
        int r106 = 2;
        if (r104.getSmallImage() != null) goto L13;
    L15:
        long r112 = r100.getTotalTime().getValue().longValue();
        long r113 = r100.getLimitStartTime().getValue().longValue();
        int r114 = s1.h(R.color.ttlive_vs_progress_highlight_tint_color);
        s1.h(R.color.ttlive_vs_progress_highlight_tint_passed_color);
        if (r106 != 3) goto L18;
        py.k r107 = r104.getSmallImage();
    L19:
        py.k r211 = r107;
        boolean r212 = r104.getHot();
        if (r104.getLocationEnd() > 0) goto L22;
        long r115 = r110;
    L23:
        r102.add(new e(r111, r112, r110, r115, r113, r114, r211, r106, true, r212, true, MainDexIgnore.IGNORE_METHODS));
        goto L6
    L22:
        r115 = r104.getLocationEnd() * 1000;
        goto L23
    L18:
        r107 = null;
        goto L19
    L13:
        if (r104.getType() != 2) goto L15;
        r106 = 3;
        goto L15
    L24:
        r100.getProgressMarkStack().b(new Pair("VS_HIGH_LIGHT", r102));
        ALogger.d("IVSProgressService", "setHighLightList:push mark size:" + r102.size() + ", context: " + this.f107816a);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void setOnlyTaSegment(EpisodeOnlyTaSegments r210) {
        Intrinsics.checkNotNullParameter(r210, DBDefinition.SEGMENT_TABLE_NAME);
        PlayerProgressServiceContext r100 = this.f107816a;
        if (r100 == null) goto L16;
        r100.getSelectedOnlyTaSegment().setValue(r210);
        List<EpisodeOnlyTaSegmentScope> r101 = r210.scopes;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        EpisodeOnlyTaSegmentScope r104 = (EpisodeOnlyTaSegmentScope) r103.next();
        long r110 = ((long) r104.startOffset) * 1000;
        long r111 = ((long) r104.stopOffset) * 1000;
        String r105 = r210.taNickname;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        r102.add(new e(r105, r100.getTotalTime().getValue().longValue(), r110, r111, 0, s1.h(R.color.ttlive_vs_only_ta_progress_tint_color), null, 0, false, false, false, 15824));
        goto L6
    L11:
        r100.getProgressMarkStack().b(new Pair("VS_ONLY_TA", r102));
        ALogger.d("IVSProgressService", "setOnlyTaSegment:push mark size:" + r102.size());
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void setThumbProcessViewEnable(boolean r100) {
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L8;
        m<Boolean> r102 = r101.getThumbProcessEnable();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.valueOf(r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void showThumbProcessViewDelay(long r100) {
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L10;
        m<Integer> r102 = r101.getThumbProcessVisibility();
        if (r102 == null) goto L10;
        if (r102.getValue().intValue() != 0) goto L10;
        return;
    L10:
        if (this.f107818c != null) goto L13;
        this.f107818c = Observable.timer(r100, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final <T> void handleProgressListener2(KFunction<Unit> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "param");
        Iterator<T> r102 = this.f107817b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Function2 r103 = (Function2) r100;
        r103.invoke((d) r102.next(), r101);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void onProgressGestureTracking(long r100, long r110) {
        PlayerProgressServiceContext r101 = this.f107816a;
        if (r101 == null) goto L8;
        k<com.bytedance.android.livesdk.chatroom.vsplayer.model.d> r102 = r101.getProgressGestureEvent();
        if (r102 == null) goto L9;
        r102.post(new com.bytedance.android.livesdk.chatroom.vsplayer.model.d(2, r100, r110));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekToHighLight(Context r100, EpisodeHighLight r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "highLight");
        VideoContext r102 = VideoContext.n0(r100);
        long r103 = r101.getLocation();
        LayerHostMediaLayout r104 = r102.f455949c;
        if (r104 != null) goto L5;
    L9:
        ALogger.w("IVSProgressService", "start to do seekToHighLight:" + r101.getDescription());
        return;
    L5:
        if (r103 < 0) goto L9;
        qic.a r105 = r104.f456048j;
        if (r105 == null) goto L9;
        r105.seekTo(r103);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final void seekToOnlyTaByScope(Context r100, EpisodeOnlyTaSegmentScope r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        VideoContext r102 = VideoContext.n0(r100);
        long r103 = r101.startOffset;
        LayerHostMediaLayout r104 = r102.f455949c;
        if (r104 != null) goto L5;
    L9:
        ALogger.w("IVSProgressService", "start to do seekToOnlyTaByScope:" + r101.startOffset);
        return;
    L5:
        if (r103 < 0) goto L9;
        qic.a r105 = r104.f456048j;
        if (r105 == null) goto L9;
        r105.seekTo(r103);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService
    public final <T, R> void handleProgressListener3(KFunction<Unit> r100, T r101, R r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "param1");
        Intrinsics.checkNotNullParameter(r102, "param2");
        Iterator<T> r103 = this.f107817b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Function3 r104 = (Function3) r100;
        r104.invoke((d) r103.next(), r101, r102);
        goto L4
    }
}
