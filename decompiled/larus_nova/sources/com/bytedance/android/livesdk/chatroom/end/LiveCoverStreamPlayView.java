package com.bytedance.android.livesdk.chatroom.end;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.connect.common.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/LiveCoverStreamPlayView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "h", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", RXScreenCaptureService.KEY_INDEX, "I", "getRoomIndex", "()I", "roomIndex", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCoverStreamPlayView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerClient f105912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LivePlayerView f105913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f105914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f105915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HSImageView f105916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f105917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f105918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Room f105919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f105920i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCoverStreamPlayView f105921a;

        public a(LiveCoverStreamPlayView r100) {
            this.f105921a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            final LiveCoverStreamPlayView r102 = this.f105921a;
            if (r102.f105914c == true) goto L57;
            LivePlayerView r103 = new LivePlayerView(r102.getContext(), LivePlayerConfig.Companion.buildWith(ILivePlayerScene.Companion.scene("end_page"), r102.f105919h.getIdStr()));
            r102.f105913b = r103;
            r102.f105912a = r103.getClient();
            FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
            r104.gravity = 17;
            LivePlayerView r105 = r102.f105913b;
            if (r105 == null) goto L10;
            r105.setLayoutParams(r104);
            r105.getRenderView().setLayoutParams(r104);
            r105.setVisibility(0);
            r105.setScaleType(2);
            FrameLayout r106 = r102.f105917f;
            if (r106 == null) goto L10;
            r106.addView(r105);
        L10:
            Room r107 = r102.f105919h;
            Map<String, String> r108 = com.bytedance.android.livesdk.chatroom.end.a.f106029a;
            Intrinsics.checkNotNullParameter(r107, "room");
            if (com.bytedance.android.livesdk.chatroom.end.a.a(false) == true) goto L26;
            List<IQuality> r109 = r107.getPullQualityList();
            if (r109 != null) goto L15;
            r109 = new ArrayList();
        L15:
            String r110 = ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r107, false, true);
            if (ListUtils.isEmpty(r109) == true) goto L46;
            IQuality r111 = (IQuality) ListProtector.get(r109, 0);
            if (r111 == null) goto L46;
            Iterator<IQuality> r112 = r109.iterator();
        L21:
            if (r112.hasNext() == false) goto L25;
            IQuality r113 = r112.next();
            if (r113 == null) goto L21;
            r113.getLevel();
            r111.getLevel();
            goto L21
        L25:
            r110 = r111.getSdkKey();
        L46:
            LiveRequest r114 = com.bytedance.android.livesdk.performance.a.a(new LiveRequest.Builder().streamData(r102.f105919h.getMultiStreamData()).resolution(r110).preview(true).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r102.f105919h.getStreamType())).enableAdaptiveGrading(t9.f121279a.getValue().getEnableDraw())).mute(true).build();     // Catch: Exception -> L45
            ILivePlayerClient r115 = r102.f105912a;     // Catch: Exception -> L45
            if (r115 == null) goto L56;
            r115.stream(r114, new LiveCoverStreamPlayView$streamPlay$2(r102));     // Catch: Exception -> L45
            return;
        L56:
            return;
        L58:
            return;
        L26:
            String r116 = com.bytedance.android.livesdk.chatroom.end.a.f106029a.get("resolution");
            if (r116 == null) goto L40;
            List<IQuality> r117 = r107.getPullQualityList();
            Object r118 = null;
            if (r117 == null) goto L37;
            Iterator<T> r119 = r117.iterator();
        L32:
            if (r119.hasNext() == false) goto L36;
            Object r120 = r119.next();
            if (Intrinsics.areEqual(((IQuality) r120).getSdkKey(), r116) == false) goto L32;
            r118 = r120;
        L36:
            r118 = (IQuality) r118;
        L37:
            if (r118 == null) goto L40;
            r110 = r116;
        L40:
            r110 = ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r107, false, true);
            goto L46
        }
    }

    public final void S5() {
        if (com.bytedance.android.livesdk.chatroom.end.a.a(false) == true) goto L8;
        if (this.f105920i == 0) goto L8;
        return;
    L8:
        if (this.f105919h.getStreamType() != LiveMode.AUDIO) goto L10;
        return;
    L10:
        if (this.f105919h.isPaidRoom() == true) goto L22;
        R5();
        if (com.bytedance.android.livesdk.chatroom.end.a.f106029a.isEmpty() == true) goto L18;
        String r100 = com.bytedance.android.livesdk.chatroom.end.a.f106029a.get("delay_time");
        if (r100 == null) goto L18;
        long r101 = CastLongProtector.parseLong(r100);
    L19:
        this.f105915d = Observable.timer(r101, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    L18:
        r101 = 2000;
        goto L19
    }

    public final void R5() {
        ILivePlayerClient r100 = this.f105912a;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        LivePlayerView r101 = this.f105913b;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        FrameLayout r102 = this.f105917f;
        if (r102 == null) goto L11;
        r102.removeAllViews();
    L11:
        Disposable r103 = this.f105915d;
        if (r103 == null) goto L14;
        r103.dispose();
    L14:
        this.f105914c = false;
    }

    public final Room getRoom() {
        return this.f105919h;
    }

    public final int getRoomIndex() {
        return this.f105920i;
    }

    public LiveCoverStreamPlayView(Context r100, Room r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        super(r100);
        this.f105919h = r101;
        this.f105920i = r102;
        this.f105918g = CollectionsKt.mutableListOf(new String[]{"1", "2", "6", Constants.VIA_REPORT_TYPE_WPA_STATE});
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_end_live_item_v2, this, true);
        this.f105916e = (HSImageView) findViewById(R.id.live_cover_dynamic_mask);
        this.f105917f = (FrameLayout) findViewById(R.id.texture);
    }
}
