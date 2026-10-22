package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAudienceLyricsDisplayView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub0.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00178\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvRoomLyricView;", "Landroid/widget/FrameLayout;", "Lub0/b;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lub0/b;", "getCustomOtherConfig", "()Lub0/b;", "setCustomOtherConfig", "(Lub0/b;)V", "customOtherConfig", "b", "getCustomSingerConfig", "setCustomSingerConfig", "customSingerConfig", "", "c", "J", "getLastPlayTime", "()J", "setLastPlayTime", "(J)V", "lastPlayTime", "", "f", "Z", "getSmallWindow", "()Z", "setSmallWindow", "(Z)V", "smallWindow", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", ce.f26391f, "Lkotlin/Lazy;", "getSingerLyricsView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", "singerLyricsView", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "h", "getKtvCountDownView", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "ktvCountDownView", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", RXScreenCaptureService.KEY_INDEX, "getOtherLyricsView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAudienceLyricsDisplayView;", "otherLyricsView", "", ce.f26395j, FaceService.girlLabel, "getLast", "()F", "setLast", "(F)V", "last", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomLyricView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f145289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f145290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f145291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint.Align f145292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint.Align f145293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f145294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f145295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f145296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f145297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f145298j;

    public static final class a {
    }

    static {
    }

    public KtvRoomLyricView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvRoomLyricView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final KtvComponentCountDownView getKtvCountDownView() {
        return (KtvComponentCountDownView) this.f145296h.getValue();
    }

    private final KtvAudienceLyricsDisplayView getOtherLyricsView() {
        return (KtvAudienceLyricsDisplayView) this.f145297i.getValue();
    }

    private final KtvAnchorLyricsDisplayView getSingerLyricsView() {
        return (KtvAnchorLyricsDisplayView) this.f145295g.getValue();
    }

    public final b getCustomOtherConfig() {
        return this.f145289a;
    }

    public final b getCustomSingerConfig() {
        return this.f145290b;
    }

    public final float getLast() {
        return this.f145298j;
    }

    public final long getLastPlayTime() {
        return this.f145291c;
    }

    public final boolean getSmallWindow() {
        return this.f145294f;
    }

    public final void setCustomOtherConfig(final b r100) {
        this.f145289a = r100;
        if (r100 == null) goto L6;
        getOtherLyricsView().c(new KtvRoomLyricView$customOtherConfig$$inlined$let$lambda$1(r100, this));
        return;
    }

    public final void setCustomSingerConfig(final b r100) {
        this.f145290b = r100;
        if (r100 == null) goto L6;
        getSingerLyricsView().c(new KtvRoomLyricView$customSingerConfig$$inlined$let$lambda$1(r100, this));
        return;
    }

    public final void setLast(float r100) {
        this.f145298j = r100;
    }

    public final void setLastPlayTime(long r100) {
        this.f145291c = r100;
    }

    public final void setSmallWindow(final boolean r100) {
        getSingerLyricsView().c(new KtvRoomLyricView$smallWindow$1(r100));
        getOtherLyricsView().c(new KtvRoomLyricView$smallWindow$2(r100));
        this.f145294f = r100;
    }

    public KtvRoomLyricView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint.Align r103 = Paint.Align.CENTER;
        this.f145292d = r103;
        this.f145293e = r103;
        this.f145295g = LazyKt.lazy(new KtvRoomLyricView$singerLyricsView$2(this, r100));
        this.f145296h = LazyKt.lazy(new KtvRoomLyricView$ktvCountDownView$2(r100));
        this.f145297i = LazyKt.lazy(new KtvRoomLyricView$otherLyricsView$2(this, r100));
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.guest_lyric_text_align, R.attr.singer_lyric_text_align});
        int r105 = r104.getInt(1, 1);
        if (r105 == 0) goto L7;
        if (r105 == 2) goto L6;
        Paint.Align r106 = Paint.Align.CENTER;
    L8:
        this.f145292d = r106;
        r104.recycle();
        removeAllViews();
        addView(getOtherLyricsView());
        return;
    L6:
        r106 = Paint.Align.RIGHT;
        goto L8
    L7:
        r106 = Paint.Align.LEFT;
        goto L8
    }

    public static final void a(KtvRoomLyricView r100, b r101, b r102) {
        r100.getClass();
        r101.f549308a = r102.f549308a;
        r101.f549309b = r102.f549309b;
        r101.f549310c = r102.f549310c;
        r101.f549312e = r102.f549312e;
        Paint.Align r103 = r102.f549313f;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f549313f = r103;
        r101.f549314g = r102.f549314g;
        r101.f549311d = r102.f549311d;
        r101.f549315h = r102.f549315h;
        r101.f549316i = r102.f549316i;
        r101.f549317j = r102.f549317j;
        r101.f549318k = r102.f549318k;
        r101.f549319l = r102.f549319l;
        r101.f549320m = r102.f549320m;
        r101.f549321n = r102.f549321n;
        r101.f549322o = r102.f549322o;
        r101.f549323p = r102.f549323p;
    }

    public /* synthetic */ KtvRoomLyricView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
