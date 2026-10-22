package com.bytedance.android.live.soloktv.viewmodel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.soloktv.floatwindow.SaveProgressFloatWindowManager;
import com.bytedance.android.live.soloktv.model.k;
import com.bytedance.android.live.soloktv.timeline.SoloKtvTimelineManager;
import com.bytedance.android.live.soloktv.util.l;
import com.bytedance.android.live.soloktv.view.FakeViewRoot;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytedance.ies.audiorecord.api.IAudioEffectService;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import com.ss.bytedance.ies.videoclip.api.timeline.ITimeLine;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nb1.i;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001pB\u0007¢\u0006\u0004\bm\u0010nJ8\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tH\u0002J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J&\u0010'\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J&\u0010(\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J$\u0010)\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u001c\u0010*\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\tH\u0002J\n\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0018\u00103\u001a\u00020\r2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\b\u00104\u001a\u00020\rH\u0002J\u001a\u00107\u001a\u00020\r2\u0006\u00105\u001a\u0002012\b\b\u0002\u00106\u001a\u00020\u0010H\u0002J\u000e\u0010:\u001a\u00020\r2\u0006\u00109\u001a\u000208J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020\u0010J\u0016\u0010?\u001a\u00020\r2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u0010@\u001a\u00020\rH\u0016J\u0016\u0010A\u001a\u00020\r2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\b\u0010B\u001a\u00020\rH\u0016J\b\u0010C\u001a\u0004\u0018\u00010\u0005J\b\u0010D\u001a\u00020\rH\u0014R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010RR\u0014\u0010S\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010UR\u0016\u0010V\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010TR\u0018\u0010W\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010Y\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR*\u0010d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006q"}, d2 = {"Lcom/bytedance/android/live/soloktv/viewmodel/SoloKtvEditViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcc0/b;", "Landroid/app/Activity;", "activity", "Lcom/bytedance/android/live/soloktv/model/k;", "compositionModel", "Lcom/bytedance/android/live/soloktv/view/FakeViewRoot;", "rootContainer", "", "timelineType", "Lnb1/i;", "templateModel", "", "init", "align", "", "realUpdate", "updateVoiceAlign", "increaseVoiceAlign", "decreaseVoiceAlign", ITTVideoEngineEventSource.KEY_VOLUME, "updateVoiceVolume", "updateMusicVolume", "Landroid/view/Surface;", "surface", "width", "height", "bindSurface", "", "time", "seekTo", "togglePausePlay", "pausePlay", "resumePlay", "stopPlay", "releasePlayer", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "saveToDraft", "publish", "export", "iniExportTimelineManagerAndShowProgressWindow", "getDefaultVoiceVolumeValueFromRecord", "getDefaultBGMVolumeValueFromRecord", "getDefaultVoiceAlign", "", "getDefaultVoiceTuningEffectFile", "", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "newList", "findSelected", "chooseDefaultOrLastTuningEffect", "targetEffect", "updateUserManual", "changeTuningEffect", "Lcom/bytedance/android/live/soloktv/viewmodel/f;", "action", "doAction", "", "geDuration", "isPlaying", "newEffectList", "onLocalTuningEffectsSuccess", "onLocalTuningEffectsFailed", "onSyncTuningEffectsSuccess", "onSyncTuningEffectsFailed", "getEditRecordData", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/soloktv/viewmodel/g;", "UIState", "Landroidx/lifecycle/MutableLiveData;", "getUIState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/soloktv/timeline/SoloKtvTimelineManager;", "previewTimelineManager", "Lcom/bytedance/android/live/soloktv/timeline/SoloKtvTimelineManager;", "exportTimelineManager", "Lcom/bytedance/android/live/soloktv/tuningpanel/ability/d;", "tuningEffectManager", "Lcom/bytedance/android/live/soloktv/tuningpanel/ability/d;", "Landroid/app/Activity;", "VOICE_ALIGN_UNIT", "I", "Lcom/bytedance/android/live/soloktv/model/k;", "voiceAlign", "curSelectedTuningEffect", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "tuningEffectList", "Ljava/util/List;", "currentTuningEffectFile", "Ljava/lang/String;", "currentBgmVolume", FaceService.girlLabel, "currentVoiceVolume", "Lcom/bytedance/android/live/soloktv/floatwindow/SaveProgressFloatWindowManager;", "saveProgressWindow", "Lcom/bytedance/android/live/soloktv/floatwindow/SaveProgressFloatWindowManager;", "Lkotlin/Function0;", "updateVoiceAlignCallback", "Lkotlin/jvm/functions/Function0;", "getUpdateVoiceAlignCallback", "()Lkotlin/jvm/functions/Function0;", "setUpdateVoiceAlignCallback", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvEditViewModel extends ViewModel implements cc0.b {
    public static final a Companion = null;
    private static final float PROGRESS_MAX_VALUE = 100.0f;
    private final MutableLiveData<g> UIState;
    private final int VOICE_ALIGN_UNIT;
    private Activity activity;
    private final CompositeDisposable compositeDisposable;
    private k compositionModel;
    private h curSelectedTuningEffect;
    private float currentBgmVolume;
    private String currentTuningEffectFile;
    private float currentVoiceVolume;
    private SoloKtvTimelineManager exportTimelineManager;
    private SoloKtvTimelineManager previewTimelineManager;
    private SaveProgressFloatWindowManager saveProgressWindow;
    private List<h> tuningEffectList;
    private com.bytedance.android.live.soloktv.tuningpanel.ability.d tuningEffectManager;
    private Function0<Unit> updateVoiceAlignCallback;
    private int voiceAlign;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel$changeTuningEffect$1, reason: invalid class name */
    public static final class AnonymousClass1 implements cc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvEditViewModel f101869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f101870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f101871c;

        @Override // cc0.c
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            SoloKtvEditViewModel.access$getTuningEffectManager$p(this.f101869a).a(this.f101870b, this.f101871c);
            h r101 = SoloKtvEditViewModel.access$getCurSelectedTuningEffect$p(this.f101869a);
            if (r101 == null) goto L5;
            r101.f69999a = false;
        L5:
            h r102 = this.f101870b;
            r102.f69999a = true;
            SoloKtvEditViewModel.access$setCurSelectedTuningEffect$p(this.f101869a, r102);
            SoloKtvEditViewModel r103 = this.f101869a;
            if ((true ^ Intrinsics.areEqual(r100, "")) == true) goto L9;
            r100 = null;
        L9:
            SoloKtvEditViewModel.access$setCurrentTuningEffectFile$p(r103, r100);
            com.bytedance.android.livesdk.ktvapi.util.d.b(this.f101869a.getUIState(), new SoloKtvEditViewModel$changeTuningEffect$1$onTuningEffectDownloadSuccess$1(this));
            SoloKtvTimelineManager r104 = SoloKtvEditViewModel.access$getPreviewTimelineManager$p(this.f101869a);
            if (r104 == null) goto L16;
            String r105 = SoloKtvEditViewModel.access$getCurrentTuningEffectFile$p(this.f101869a);
            if (r104.f101485m == true) goto L16;
            IAudioEffectService r106 = r104.f101482j.f528408a.f528407a;
            if (r106 == null) goto L16;
            r106.setTuningEffect(r105);
        L16:
            k r107 = SoloKtvEditViewModel.access$getCompositionModel$p(this.f101869a);
            if (r107 == null) goto L22;
            eb1.f r108 = r107.b();
            if (r108 == null) goto L23;
            r108.w(SoloKtvEditViewModel.access$getCurrentTuningEffectFile$p(this.f101869a));
            return;
        L23:
            return;
        }

        public AnonymousClass1(SoloKtvEditViewModel r100, h r101, boolean r102) {
            this.f101869a = r100;
            this.f101870b = r101;
            this.f101871c = r102;
        }
    }

    static {
        Companion = new a();
    }

    private final void chooseDefaultOrLastTuningEffect() {
        h r100 = this.tuningEffectManager.c();
        if (r100 == null) goto L6;
        changeTuningEffect(r100, false);
        return;
    }

    private final void decreaseVoiceAlign() {
        int r100 = this.voiceAlign;
        int r101 = this.VOICE_ALIGN_UNIT;
        int r102 = -300;
        if ((r100 - r101) < (-300)) goto L6;
        r102 = r100 - r101;
    L6:
        updateVoiceAlign(r102, true);
    }

    private final float getDefaultBGMVolumeValueFromRecord() {
        k r100 = this.compositionModel;
        if (r100 == null) goto L7;
        eb1.f r101 = r100.b();
        if (r101 == null) goto L7;
        return r101.e();
    L7:
        return 0.5f;
    }

    private final int getDefaultVoiceAlign() {
        Integer r100 = com.bytedance.android.livesdk.sharedpref.c.f158285m0.getValue();
        if (r100 == null) goto L8;
        if (r100.intValue() != 0) goto L8;
        int r101 = ((Number) vm2.h.O.getValue(null, vm2.h.f556082a[39])).intValue();
        if (r101 <= 0) goto L12;
        return r101;
    L12:
        return 0;
    L8:
        return r100.intValue();
    }

    private final String getDefaultVoiceTuningEffectFile() {
        k r100 = this.compositionModel;
        if (r100 == null) goto L7;
        eb1.f r101 = r100.b();
        if (r101 == null) goto L7;
        return r101.k();
    L7:
        return null;
    }

    private final float getDefaultVoiceVolumeValueFromRecord() {
        k r100 = this.compositionModel;
        if (r100 == null) goto L7;
        eb1.f r101 = r100.b();
        if (r101 == null) goto L7;
        return r101.l();
    L7:
        return 0.5f;
    }

    private final void increaseVoiceAlign() {
        int r100 = this.voiceAlign;
        int r101 = this.VOICE_ALIGN_UNIT;
        int r102 = 300;
        if ((r100 + r101) > 300) goto L6;
        r102 = r100 + r101;
    L6:
        updateVoiceAlign(r102, true);
    }

    private final void pausePlay() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L8;
        IPlayer r101 = r100.f101474b;
        if (r101 == null) goto L9;
        r101.pause();
        return;
    L9:
        return;
    }

    private final void releasePlayer() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L8;
        r100.f101485m = true;
        ITimeLine r101 = r100.f101473a;
        if (r101 == null) goto L9;
        r101.release();
        return;
    L9:
        return;
    }

    private final void resumePlay() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    private final void stopPlay() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L11;
        com.bytedance.android.live.soloktv.timeline.resource.midi.v2.d r101 = r100.f101475c;
        if (r101 == null) goto L7;
        r101.a();
    L7:
        IPlayer r102 = r100.f101474b;
        if (r102 == null) goto L12;
        r102.stop();
        return;
    L12:
        return;
    }

    private final void togglePausePlay() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public final long geDuration() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.g();
    }

    public final boolean isPlaying() {
        SoloKtvTimelineManager r100 = this.previewTimelineManager;
        if (r100 == null) goto L10;
        IPlayer r101 = r100.f101474b;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isPlaying() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // cc0.b
    public void onLocalTuningEffectsFailed() {
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, C99831.INSTANCE);
    }

    @Override // cc0.b
    public void onSyncTuningEffectsFailed() {
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, C99851.INSTANCE);
        chooseDefaultOrLastTuningEffect();
    }

    public SoloKtvEditViewModel() {
        this.UIState = new MutableLiveData();
        this.tuningEffectManager = new com.bytedance.android.live.soloktv.tuningpanel.ability.d();
        this.VOICE_ALIGN_UNIT = 20;
        this.currentBgmVolume = 1.0f;
        this.currentVoiceVolume = 1.0f;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final k getEditRecordData() {
        return this.compositionModel;
    }

    public final MutableLiveData<g> getUIState() {
        return this.UIState;
    }

    public final Function0<Unit> getUpdateVoiceAlignCallback() {
        return this.updateVoiceAlignCallback;
    }

    public static final /* synthetic */ k access$getCompositionModel$p(SoloKtvEditViewModel r100) {
        return r100.compositionModel;
    }

    public static final /* synthetic */ h access$getCurSelectedTuningEffect$p(SoloKtvEditViewModel r100) {
        return r100.curSelectedTuningEffect;
    }

    public static final /* synthetic */ String access$getCurrentTuningEffectFile$p(SoloKtvEditViewModel r100) {
        return r100.currentTuningEffectFile;
    }

    public static final /* synthetic */ SoloKtvTimelineManager access$getPreviewTimelineManager$p(SoloKtvEditViewModel r100) {
        return r100.previewTimelineManager;
    }

    public static final /* synthetic */ com.bytedance.android.live.soloktv.tuningpanel.ability.d access$getTuningEffectManager$p(SoloKtvEditViewModel r100) {
        return r100.tuningEffectManager;
    }

    private final void findSelected(List<h> r100) {
        h r101 = this.curSelectedTuningEffect;
        if (r101 == null) goto L19;
        if (r100 == null) goto L20;
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(r101, (h) r103) == false) goto L7;
    L12:
        h r104 = (h) r103;
        if (r104 == null) goto L21;
        r104.f69999a = r101.f69999a;
        return;
    L21:
        return;
    L11:
        r103 = null;
        goto L12
    L20:
        return;
    }

    private final void seekTo(float r100) {
        SoloKtvTimelineManager r101 = this.previewTimelineManager;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    private final void updateMusicVolume(final int r100) {
        k r101 = this.compositionModel;
        if (r101 == null) goto L7;
        eb1.f r102 = r101.b();
        if (r102 == null) goto L7;
        r102.q(r100 / PROGRESS_MAX_VALUE);
    L7:
        float r103 = r100 / PROGRESS_MAX_VALUE;
        int r104 = SoloKtvTimelineManager.f101467u;
        if (vm2.h.c0().d() <= 0) goto L10;
        float r105 = vm2.h.c0().b();
    L11:
        this.currentBgmVolume = r103 * r105;
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, new C99871(r100));
        SoloKtvTimelineManager r106 = this.previewTimelineManager;
        if (r106 == null) goto L17;
        float r107 = this.currentBgmVolume;
        ITimeLine r108 = r106.f101473a;
        if (r108 == null) goto L18;
        r108.updateTrackVolume(SoloKtvTimelineManager.f101469w, r107);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        r105 = ((Number) vm2.h.A.getValue(null, vm2.h.f556082a[25])).floatValue();
        goto L11
    }

    private final void updateVoiceVolume(final int r100) {
        k r101 = this.compositionModel;
        if (r101 == null) goto L7;
        eb1.f r102 = r101.b();
        if (r102 == null) goto L7;
        r102.x(r100 / PROGRESS_MAX_VALUE);
    L7:
        float r103 = r100 / PROGRESS_MAX_VALUE;
        int r104 = SoloKtvTimelineManager.f101467u;
        if (vm2.h.c0().d() <= 0) goto L10;
        float r105 = vm2.h.c0().c();
    L11:
        this.currentVoiceVolume = r103 * r105;
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, new C99891(r100));
        SoloKtvTimelineManager r106 = this.previewTimelineManager;
        if (r106 == null) goto L17;
        float r107 = this.currentVoiceVolume;
        ITimeLine r108 = r106.f101473a;
        if (r108 == null) goto L18;
        r108.updateTrackVolume(SoloKtvTimelineManager.f101470x, r107);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        r105 = ((Number) vm2.h.A.getValue(null, vm2.h.f556082a[25])).floatValue();
        goto L11
    }

    public final void doAction(f r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof f.C1547f) == false) goto L6;
        f.C1547f r101 = (f.C1547f) r100;
        init(r101.getActivity(), r101.f101888b, r101.f101889c, r101.f101890d, r101.f101891e);
        return;
    L6:
        if ((r100 instanceof f.q) == false) goto L9;
        updateVoiceVolume(((f.q) r100).f101907a);
        return;
    L9:
        if ((r100 instanceof f.o) == false) goto L12;
        updateMusicVolume(((f.o) r100).f101904a);
        return;
    L12:
        if ((r100 instanceof f.e) == false) goto L15;
        increaseVoiceAlign();
        return;
    L15:
        if ((r100 instanceof f.c) == false) goto L18;
        decreaseVoiceAlign();
        return;
    L18:
        if ((r100 instanceof f.p) == false) goto L21;
        f.p r102 = (f.p) r100;
        updateVoiceAlign(r102.f101905a, r102.f101906b);
        return;
    L21:
        if ((r100 instanceof f.k) == false) goto L24;
        f.k r103 = (f.k) r100;
        saveToDraft(r103.f101898a, r103.f101899b, r103.f101900c);
        return;
    L24:
        if ((r100 instanceof f.h) == false) goto L27;
        f.h r104 = (f.h) r100;
        publish(r104.f101893a, r104.f101894b, r104.f101895c);
        return;
    L27:
        if ((r100 instanceof f.d) == false) goto L30;
        f.d r105 = (f.d) r100;
        r105.getClass();
        r105.getClass();
        r105.getClass();
        export(null, null, null);
        return;
    L30:
        if ((r100 instanceof f.a) == false) goto L33;
        f.a r106 = (f.a) r100;
        bindSurface(r106.f101881a, r106.f101882b, r106.f101883c);
        return;
    L33:
        if ((r100 instanceof f.l) == false) goto L36;
        seekTo(((f.l) r100).f101901a);
        return;
    L36:
        if ((r100 instanceof f.n) == false) goto L39;
        togglePausePlay();
        return;
    L39:
        if ((r100 instanceof f.g) == false) goto L42;
        pausePlay();
        return;
    L42:
        if ((r100 instanceof f.j) == false) goto L45;
        resumePlay();
        return;
    L45:
        if ((r100 instanceof f.m) == false) goto L48;
        stopPlay();
        return;
    L48:
        if ((r100 instanceof f.i) == false) goto L51;
        releasePlayer();
        return;
    L51:
        if ((r100 instanceof f.b) == false) goto L70;
        changeTuningEffect(((f.b) r100).f101884a, true);
        return;
    }

    @Override // cc0.b
    public void onLocalTuningEffectsSuccess(final List<h> r100) {
        Intrinsics.checkNotNullParameter(r100, "newEffectList");
        findSelected(r100);
        this.tuningEffectList = r100;
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, new C99841(r100));
        if (r100.size() <= 1) goto L6;
        chooseDefaultOrLastTuningEffect();
        return;
    }

    @Override // cc0.b
    public void onSyncTuningEffectsSuccess(final List<h> r100) {
        Intrinsics.checkNotNullParameter(r100, "newEffectList");
        findSelected(r100);
        this.tuningEffectList = r100;
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, new C99861(r100));
        chooseDefaultOrLastTuningEffect();
    }

    public final void setUpdateVoiceAlignCallback(Function0<Unit> r100) {
        this.updateVoiceAlignCallback = r100;
    }

    public static final /* synthetic */ void access$setCompositionModel$p(SoloKtvEditViewModel r100, k r101) {
        r100.compositionModel = r101;
    }

    public static final /* synthetic */ void access$setCurSelectedTuningEffect$p(SoloKtvEditViewModel r100, h r101) {
        r100.curSelectedTuningEffect = r101;
    }

    public static final /* synthetic */ void access$setCurrentTuningEffectFile$p(SoloKtvEditViewModel r100, String r101) {
        r100.currentTuningEffectFile = r101;
    }

    public static final /* synthetic */ void access$setPreviewTimelineManager$p(SoloKtvEditViewModel r100, SoloKtvTimelineManager r101) {
        r100.previewTimelineManager = r101;
    }

    public static final /* synthetic */ void access$setTuningEffectManager$p(SoloKtvEditViewModel r100, com.bytedance.android.live.soloktv.tuningpanel.ability.d r101) {
        r100.tuningEffectManager = r101;
    }

    private final void changeTuningEffect(h r100, boolean r101) {
        ya1.a r102 = ya1.a.f567014a;
        String r103 = r100.d();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "name");
        this.tuningEffectManager.b(r100, new AnonymousClass1(this, r100, r101));
    }

    private final void iniExportTimelineManagerAndShowProgressWindow(k r110, FakeViewRoot r111) {
        float r100 = this.currentBgmVolume;
        float r101 = this.currentVoiceVolume;
        int r102 = -this.voiceAlign;
        String r103 = this.currentTuningEffectFile;
        if (r110 == null) goto L7;
        eb1.f r104 = r110.b();
        if (r104 == null) goto L7;
        i r105 = r104.i();
    L8:
        this.exportTimelineManager = new SoloKtvTimelineManager(r110, r111, r100, r101, r103, r102, r105, 0, SoloKtvTimelineManager.I, false, 640);
        SaveProgressFloatWindowManager.a r112 = SaveProgressFloatWindowManager.f101076k;
        SaveProgressFloatWindowManager r113 = SaveProgressFloatWindowManager.b.a();
        r113.f101082e = this.exportTimelineManager;
        r113.d(this.activity);
        Unit r114 = Unit.INSTANCE;
        this.saveProgressWindow = r113;
        return;
    L7:
        r105 = null;
        goto L8
    }

    private final void updateVoiceAlign(final int r100, boolean r101) {
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.UIState, new C99881(r100));
        if (r101 == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.c.f158285m0;
        Integer r103 = Integer.valueOf(r100);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        this.voiceAlign = r100;
        SoloKtvTimelineManager r104 = this.previewTimelineManager;
        if (r104 == null) goto L9;
        long r105 = -r100;
        ITimeLine r106 = r104.f101473a;
        if (r106 == null) goto L9;
        r106.updateTrackAlign(SoloKtvTimelineManager.f101470x, r105, r104.f101480h);
    L9:
        Function0<Unit> r107 = this.updateVoiceAlignCallback;
        if (r107 == null) goto L14;
        Unit r108 = r107.invoke();
        return;
    L14:
        return;
    }

    private final void bindSurface(Surface r100, int r101, int r102) {
        SoloKtvTimelineManager r103 = this.previewTimelineManager;
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    private final void export(k r100, FakeViewRoot r101, Bitmap r102) {
        iniExportTimelineManagerAndShowProgressWindow(r100, r101);
        SaveProgressFloatWindowManager r103 = this.saveProgressWindow;
        if (r103 == null) goto L6;
        r103.a(this.activity, r102);
        return;
    }

    private final void publish(k r100, FakeViewRoot r101, Bitmap r102) {
        iniExportTimelineManagerAndShowProgressWindow(r100, r101);
        SaveProgressFloatWindowManager r103 = this.saveProgressWindow;
        if (r103 == null) goto L6;
        r103.b(this.activity, r102, l.b.a.f101628a);
        return;
    }

    private final void saveToDraft(k r100, FakeViewRoot r101, Bitmap r102) {
        iniExportTimelineManagerAndShowProgressWindow(r100, r101);
        SaveProgressFloatWindowManager r103 = this.saveProgressWindow;
        if (r103 == null) goto L6;
        r103.b(this.activity, r102, l.b.C1546b.f101629a);
        return;
    }

    public static /* synthetic */ void changeTuningEffect$default(SoloKtvEditViewModel r100, h r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.changeTuningEffect(r101, r102);
    }

    private final void init(Activity r110, k r111, FakeViewRoot r112, int r210, i r211) {
        this.activity = r110;
        this.compositionModel = r111;
        this.voiceAlign = getDefaultVoiceAlign();
        this.currentTuningEffectFile = getDefaultVoiceTuningEffectFile();
        float r100 = getDefaultVoiceVolumeValueFromRecord();
        int r101 = SoloKtvTimelineManager.f101467u;
        if (vm2.h.c0().d() <= 0) goto L5;
        float r102 = vm2.h.c0().c();
    L6:
        this.currentVoiceVolume = r100 * r102;
        float r103 = getDefaultBGMVolumeValueFromRecord();
        if (vm2.h.c0().d() <= 0) goto L9;
        float r104 = vm2.h.c0().b();
    L10:
        this.currentBgmVolume = r103 * r104;
        this.UIState.setValue(new g((int) (getDefaultVoiceVolumeValueFromRecord() * PROGRESS_MAX_VALUE), (int) (getDefaultBGMVolumeValueFromRecord() * PROGRESS_MAX_VALUE), this.voiceAlign, 0.0f, 0, IPlayer.PlayerStatus.PLAYING, true, null, null));
        float r105 = this.currentBgmVolume;
        float r106 = this.currentVoiceVolume;
        int r107 = -this.voiceAlign;
        SoloKtvTimelineManager r113 = new SoloKtvTimelineManager(r111, r112, r105, r106, this.currentTuningEffectFile, r107, r211, r210, 0, false, ISmModel.VERSION_0300);
        this.previewTimelineManager = r113;
        String r108 = getDefaultVoiceTuningEffectFile();
        if (r113.f101485m == true) goto L16;
        IAudioEffectService r109 = r113.f101482j.f528408a.f528407a;
        if (r109 == null) goto L16;
        r109.setTuningEffect(r108);
    L16:
        if (this.previewTimelineManager == null) goto L18;
        Intrinsics.checkNotNullParameter(new b(), "listener");
    L18:
        this.compositeDisposable.add(this.tuningEffectManager.g(this));
        Disposable r114 = this.tuningEffectManager.k(this);
        if (r114 == null) goto L22;
        this.compositeDisposable.add(r114);
        return;
    L22:
        return;
    L9:
        r104 = ((Number) vm2.h.A.getValue(null, vm2.h.f556082a[25])).floatValue();
        goto L10
    L5:
        r102 = ((Number) vm2.h.A.getValue(null, vm2.h.f556082a[25])).floatValue();
        goto L6
    }
}
