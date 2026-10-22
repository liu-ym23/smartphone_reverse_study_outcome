package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/BaseLyricView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/a;", "", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getDisplayConfig", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "getMultiScenePreviewStatistics", "()Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "setMultiScenePreviewStatistics", "(Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;)V", "multiScenePreviewStatistics", "b", "Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "getConfig", "()Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;", "setConfig", "(Lcom/bytedance/component/lyric/model/LyricsDisplayConfig;)V", "config", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseLyricView extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMultiScenePreviewStatistics f143062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LyricsDisplayConfig f143063b;

    public BaseLyricView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseLyricView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ int getCurrentIndex();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ ArrayList<com.bytedance.component.lyric.model.b> getCurrentLyrics();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public abstract /* synthetic */ Paint.Align getTextAlign();

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void resetCurrMusicProcess() {
    }

    public void setHideFirstLineLyric(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricOneLineMaxWidth(float r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public void setLyricVisible(int r100) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public final void updateCurrentState(KtvRoomLyricsStateMachineConfig.d r100) {
    }

    public final LyricsDisplayConfig getConfig() {
        return this.f143063b;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.lyrics.a
    public LyricsDisplayConfig getDisplayConfig() {
        return this.f143063b;
    }

    public final IMultiScenePreviewStatistics getMultiScenePreviewStatistics() {
        return this.f143062a;
    }

    public final float a(Paint.FontMetrics r100) {
        Intrinsics.checkNotNullParameter(r100, "fontMetrics");
        float r101 = r100.descent;
        return ((r101 - r100.ascent) / 2) - r101;
    }

    public final void setConfig(LyricsDisplayConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f143063b = r100;
    }

    public void setLyricAlignStyle(Paint.Align r100) {
        Intrinsics.checkNotNullParameter(r100, "align");
        Intrinsics.checkNotNullParameter(r100, "align");
    }

    public final void setMultiScenePreviewStatistics(IMultiScenePreviewStatistics r100) {
        this.f143062a = r100;
    }

    public BaseLyricView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f143063b = new LyricsDisplayConfig();
    }

    public /* synthetic */ BaseLyricView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        LyricsDisplayConfig r104 = this.f143063b;
        if (r104.f203009d != 0.0f) goto L5;
        r104.f(r100 - r104.f203016k.measureText("   "));
    L5:
        LyricsDisplayConfig r105 = this.f143063b;
        if (r105.f203009d > 0) goto L9;
        float r106 = LyricsDisplayConfig.f203005u;
        r105.f(LyricsDisplayConfig.f203005u);
        return;
    }
}
