package com.bytedance.android.live.soloktv.midi;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bef.effectsdk.RequirementDefine;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.model.api.q0;
import com.bytedance.android.live.ktv.common.util.p;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.record.SoloKtvRecordManager;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytedance.ies.audiorecord.api.IMidiService;
import com.ss.bytedance.ies.audiorecord.api.model.KtvMidiData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001bB\u0007¢\u0006\u0004\b_\u0010`J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\fH\u0016J \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016J&\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0018\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0004\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b!\u0010 J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\"J\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\b\u0010&\u001a\u00020\nH\u0014R\"\u0010'\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u00109\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010(\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R$\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00058\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b=\u0010>\"\u0004\b?\u0010@R \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020B0A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010(R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010(R\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR#\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00180L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR(\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010N\u001a\u0004\bS\u0010P\"\u0004\bT\u0010UR(\u0010V\u001a\b\u0012\u0004\u0012\u00020-0L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010N\u001a\u0004\bW\u0010P\"\u0004\bX\u0010UR+\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\"0L8\u0006¢\u0006\f\n\u0004\b\u001d\u0010N\u001a\u0004\b\u0004\u0010PR\u0014\u0010Y\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010>R$\u0010Z\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\bZ\u0010\\\"\u0004\b]\u0010^¨\u0006c"}, d2 = {"Lcom/bytedance/android/live/soloktv/midi/SoloKtvMidiViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldb0/a;", "Lcom/bytedance/android/live/ktv/common/midi/k;", "getScoreInfo", "", RequirementDefine.REQUIREMENT_AUDIO_SENTENCE_SCORE_TAG, "", "index", "calScore", "", "clearScore", "", "id", "", "midiPath", "lyricsPath", "initMidiRes", "curPlayTime", "Lio/reactivex/Observable;", "Lcb0/c;", "findMidiSegment", DyPayConstant.KEY_START_TIME, "endTime", "", "findMidiSegmentsNew", "Lio/reactivex/Single;", "findMidiSegments", "", "scoreInfo", "progress", "tryGetScoreInfo", "(Ljava/lang/Long;)V", "seek", "Lkotlin/Pair;", "calcToneRange", BasicTestActionHandler.TEST_ACTION_RESET, "onDetach", "onCleared", "totalScore", "I", "getTotalScore", "()I", "setTotalScore", "(I)V", "", "userOpenScore", "Z", "getUserOpenScore", "()Z", "setUserOpenScore", "(Z)V", "Lio/reactivex/disposables/Disposable;", "midiDisposable", "Lio/reactivex/disposables/Disposable;", "scoreInfoArr", "[D", "curTotalScore", "getCurTotalScore", "setCurTotalScore", "value", "curScore", FaceService.girlLabel, "setCurScore", "(F)V", "", "Ldb1/a;", "lyricScoreInfo", "Ljava/util/Map;", "lyricsCount", "curMidiProgress", "J", "lastMidiIndex", "Lcom/bytedance/android/live/ktv/common/midi/b;", "mHitComboCalculator", "Lcom/bytedance/android/live/ktv/common/midi/b;", "Landroidx/lifecycle/MutableLiveData;", "midiData", "Landroidx/lifecycle/MutableLiveData;", "getMidiData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig", "getMidiConfig", "setMidiConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "showNoMidiHint", "getShowNoMidiHint", "setShowNoMidiHint", "calFactorSetting", "isForwardSeek", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setForwardSeek", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvMidiViewModel extends ViewModel implements db0.a {
    public static final a Companion = null;
    public static final String TAG = "SoloKtvMidiViewModel";
    private final float calFactorSetting;
    private long curMidiProgress;
    private float curScore;
    private int curTotalScore;
    private Boolean isForwardSeek;
    private int lastMidiIndex;
    private final Map<Integer, db1.a> lyricScoreInfo;
    private int lyricsCount;
    private com.bytedance.android.live.ktv.common.midi.b mHitComboCalculator;
    private MutableLiveData<g0> midiConfig;
    private final MutableLiveData<List<cb0.c>> midiData;
    private Disposable midiDisposable;
    private final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> scoreInfo;
    private double[] scoreInfoArr;
    private MutableLiveData<Boolean> showNoMidiHint;
    private int totalScore;
    private boolean userOpenScore;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f101363a = null;

        static {
            f101363a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return !r101.isEmpty();
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f101364a = null;

        static {
            f101364a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Observable.fromIterable(r101);
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f101365a;

        public d(long r100) {
            this.f101365a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            cb0.c r101 = (cb0.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            cb0.a r102 = r101.f22991a;
            long r103 = r102.f22988a;
            long r104 = this.f101365a;
            if (r103 < r104) goto L5;
        L7:
            return false;
        L5:
            if (r102.f22989b < r104) goto L7;
            return true;
        }
    }

    public static final class e<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f101366a = null;

        static {
            f101366a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return !r101.isEmpty();
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f101367a = null;

        static {
            f101367a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return Observable.fromIterable(r101);
        }
    }

    public static final class g<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f101368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f101369b;

        public g(long r100, long r101) {
            this.f101368a = r100;
            this.f101369b = r101;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            cb0.c r101 = (cb0.c) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            cb0.a r102 = r101.f22991a;
            if (r102.f22988a < this.f101368a) goto L5;
        L7:
            return false;
        L5:
            if (r102.f22989b <= this.f101369b) goto L7;
            return true;
        }
    }

    public static final class h<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f101370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f101371b;

        public h(String r100, String r101) {
            this.f101370a = r100;
            this.f101371b = r101;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Integer r101 = 0;
            if (this.f101370a != null) goto L5;
        L10:
            SoloKtvContext.Companion.getClass();
            com.bytedance.android.live.soloktv.record.c r102 = SoloKtvContext.a.a().getDataStore();
            if (r102 == null) goto L19;
            com.bytedance.android.live.soloktv.model.k r103 = r102.f101453a;
            if (r103 == null) goto L19;
            eb1.f r104 = r103.b();
            if (r104 == null) goto L19;
            eb1.e r105 = r104.f();
            if (r105 == null) goto L19;
            r105.f471794a = null;
        L19:
            if (r101 != null) goto L22;
        L23:
            r100.onError(new Exception("init midi error"));
            return;
        L22:
            if (r101.intValue() != 0) goto L23;
            r100.onSuccess(r101);
            return;
        L5:
            if (this.f101371b == null) goto L10;
            SoloKtvContext.Companion.getClass();
            if (SoloKtvContext.a.a().getSoloKtvRecordManager() != null) goto L19;
            r101 = null;
            goto L19
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f101372a;

        public i(String r100) {
            this.f101372a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            Intrinsics.checkNotNullParameter((Integer) r110, "it");
            IHostPlugin r111 = (IHostPlugin) jc1.k.f(IHostPlugin.class);
            if (r111 == null) goto L5;
            IMidiService r112 = (IMidiService) r111.getOrNull(IMidiService.class);
        L6:
            if (r112 == null) goto L16;
            List<KtvMidiData> r113 = r112.getMidiDrawingData(this.f101372a);
            if (r113 == null) goto L17;
            List<KtvMidiData> r114 = r113;
            CollectionsKt.sortedWith(r114, db1.b.f467795a);
            ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator<T> r115 = r114.iterator();
        L11:
            if (r115.hasNext() == false) goto L14;
            KtvMidiData r101 = (KtvMidiData) r115.next();
            r100.add(new cb0.c(new cb0.a(r101.getStartMs(), r101.getStartMs() + r101.getDurationMs()), r101.getPitch(), null));
            goto L11
        L14:
            return r100;
        L17:
            return null;
        L16:
            return null;
        L5:
            r112 = null;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvMidiViewModel f101373a;

        public j(SoloKtvMidiViewModel r100) {
            this.f101373a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List<cb0.c> r101 = (List) r100;
            ALogger.i(bb0.b.b(), "initMidiRes success, invoke class :SoloKtvMidiViewModel");
            this.f101373a.getMidiData().setValue(r101);
            SoloKtvContext.Companion.getClass();
            com.bytedance.android.live.soloktv.record.c r102 = SoloKtvContext.a.a().getDataStore();
            if (r102 == null) goto L11;
            com.bytedance.android.live.soloktv.model.k r103 = r102.f101453a;
            if (r103 == null) goto L11;
            eb1.f r104 = r103.b();
            if (r104 == null) goto L11;
            eb1.e r105 = r104.f();
            if (r105 == null) goto L11;
            r105.f471794a = r101;
        L11:
            this.f101373a.getShowNoMidiHint().setValue(Boolean.FALSE);
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvMidiViewModel f101374a;

        public k(SoloKtvMidiViewModel r100, long r101) {
            this.f101374a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.i(bb0.b.b(), "initMidiRes fail, invoke class :SoloKtvMidiViewModel");
            ((Throwable) r100).printStackTrace();
            ya1.a.f567014a.getClass();
            this.f101374a.getShowNoMidiHint().setValue(Boolean.TRUE);
            SoloKtvContext.Companion.getClass();
            com.bytedance.android.live.soloktv.record.c r101 = SoloKtvContext.a.a().getDataStore();
            if (r101 == null) goto L12;
            com.bytedance.android.live.soloktv.model.k r102 = r101.f101453a;
            if (r102 == null) goto L13;
            eb1.f r103 = r102.b();
            if (r103 == null) goto L14;
            eb1.e r104 = r103.f();
            if (r104 == null) goto L15;
            r104.f471794a = null;
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final void clearScore() {
        setCurScore(0.0f);
    }

    @Override // db0.a
    public cb0.c findMidiSegmentOpt(long r100) {
        return null;
    }

    @Override // db0.a
    public List<cb0.c> findMidiSegmentsOpt(long r100, long r101) {
        return null;
    }

    public void getScoreInfo(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
    }

    private final com.bytedance.android.live.ktv.common.midi.k getScoreInfo() {
        SoloKtvContext.Companion.getClass();
        SoloKtvRecordManager r100 = SoloKtvContext.a.a().getSoloKtvRecordManager();
        if (r100 == null) goto L16;
        double[] r101 = this.scoreInfoArr;
        long r110 = this.curMidiProgress;
        Intrinsics.checkNotNullParameter(r101, "info");
        double[] r102 = Arrays.copyOf(r101, r101.length);
        long r111 = System.currentTimeMillis();
        long r103 = r100.C;
        if (r103 == 0) goto L9;
        if ((r111 - r103) < SoloKtvRecordManager.H) goto L16;
    L9:
        if (r100.f101450y != null) goto L11;
        r100.f101450y = new CopyOnWriteArrayList();
    L11:
        CopyOnWriteArrayList<eb1.d> r112 = r100.f101450y;
        if (r112 == null) goto L14;
        int r104 = com.bytedance.android.live.soloktv.util.g.f101604a;
        Intrinsics.checkNotNullParameter(r102, "$this$toMidiRecordItem");
        r112.add(new eb1.d(r102[0], r102[1], r102[2], r102[3], r102[4], r102[5], r102[7], r102[8], r102[9], r102[11], r102[12], r110));
        long r105 = r111;
    L15:
        r100.C = r105;
        goto L16
    L14:
        r105 = r111;
    L16:
        double[] r106 = this.scoreInfoArr;
        float r107 = (float) r106[3];
        float r108 = (float) r106[7];
        int r113 = (int) r106[11];
        float r109 = ((float) r106[0]) * this.calFactorSetting;
        if (r109 <= 100.0f) goto L20;
        r109 = 100.0f;
    L20:
        if (vm2.h.y() == false) goto L22;
        float r114 = r108;
        float r115 = 90.0f;
    L24:
        if (r113 <= this.lastMidiIndex) goto L26;
        boolean r116 = true;
    L27:
        Map<String, q0> r117 = null;
        if (r116 == false) goto L30;
        setCurScore(calScore(r115, r113));
        String r118 = "getScoreInfo: currentTone: " + r114 + "  midiTone: " + r108 + "    curScore: " + this.curScore + "    index: " + r113 + "    lastMidiIndex: " + this.lastMidiIndex;
        ALogger.i(bb0.b.b(), "SoloKtvMidiViewModel :" + r118 + ", invoke class :SoloKtvMidiViewModel");
        this.lyricScoreInfo.put(Integer.valueOf(r113), new db1.a(this.curMidiProgress, this.curScore));
        com.bytedance.android.live.ktv.common.midi.b r119 = this.mHitComboCalculator;
        int r120 = com.bytedance.android.live.ktv.common.midi.b.f69834e;
        int r121 = r119.b(r115, r113, null);
        this.lastMidiIndex = r113;
        int r122 = r121;
    L31:
        float r123 = this.curScore;
        if (r113 < 0) goto L38;
        if (r116 == false) goto L38;
        g0 r124 = this.midiConfig.getValue();
        if (r124 == null) goto L37;
        r117 = r124.b();
    L37:
        int r125 = p.a(r117, r115);
    L40:
        return new com.bytedance.android.live.ktv.common.midi.k(r114, r108, r115, r123, r113, Integer.valueOf(r125), r122, false, 128);
    L38:
        r125 = -1;
        goto L40
    L30:
        r122 = 0;
        goto L31
    L26:
        r116 = false;
        goto L27
    L22:
        r115 = r109;
        r114 = r107;
        goto L24
    }

    public final Pair<Integer, Integer> calcToneRange() {
        List<cb0.c> r100 = this.midiData.getValue();
        int r101 = 0;
        int r102 = 100;
        if (r100 == null) goto L9;
        Iterator<T> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        cb0.c r104 = (cb0.c) r103.next();
        r102 = Math.min(r102, r104.f22992b);
        r101 = Math.max(r101, r104.f22992b);
    L9:
        return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r101));
    }

    public final void onDetach() {
        Disposable r100 = this.midiDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        setCurScore(0.0f);
        this.curMidiProgress = 0;
        this.lastMidiIndex = 0;
        this.mHitComboCalculator.a();
        this.midiData.setValue(null);
        clearScore();
    }

    public final void reset() {
        this.lyricScoreInfo.clear();
        Disposable r100 = this.midiDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.curMidiProgress = 0;
        clearScore();
    }

    public SoloKtvMidiViewModel() {
        this.userOpenScore = true;
        this.scoreInfoArr = new double[13];
        this.lyricScoreInfo = new LinkedHashMap();
        this.lastMidiIndex = -1;
        this.mHitComboCalculator = new com.bytedance.android.live.ktv.common.midi.b();
        this.midiData = new MutableLiveData();
        this.midiConfig = new MutableLiveData();
        this.showNoMidiHint = new MutableLiveData();
        this.scoreInfo = new MutableLiveData();
        this.calFactorSetting = vm2.h.C();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        onDetach();
    }

    public int getCurTotalScore() {
        return this.curTotalScore;
    }

    public final MutableLiveData<g0> getMidiConfig() {
        return this.midiConfig;
    }

    public final MutableLiveData<List<cb0.c>> getMidiData() {
        return this.midiData;
    }

    public final MutableLiveData<Boolean> getShowNoMidiHint() {
        return this.showNoMidiHint;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public boolean getUserOpenScore() {
        return this.userOpenScore;
    }

    public final Boolean isForwardSeek() {
        return this.isForwardSeek;
    }

    /* JADX INFO: renamed from: getScoreInfo, reason: collision with other method in class */
    public final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> m8222getScoreInfo() {
        return this.scoreInfo;
    }

    private final void setCurScore(float r100) {
        this.curScore = r100;
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.model.d r101 = SoloKtvContext.a.a().getModel();
        if ((r101 instanceof com.bytedance.android.live.soloktv.model.i) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.live.soloktv.model.i r102 = (com.bytedance.android.live.soloktv.model.i) r101;
        if (r102 == null) goto L9;
        r102.f101379c = r100;
        return;
    }

    @Override // db0.a
    public Observable<cb0.c> findMidiSegment(long r100) {
        List<cb0.c> r101 = this.midiData.getValue();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegment midiData is null, invoke class :SoloKtvMidiViewModel");
        return Observable.empty();
    L13:
        return Observable.just(this.midiData.getValue()).filter(b.f101363a).flatMap(c.f101364a).filter(new d(r100));
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void seek(Long r110) {
        if (r110 == null) goto L52;
        r110.longValue();
        if (r110.longValue() >= this.curMidiProgress) goto L6;
        boolean r100 = true;
    L7:
        this.isForwardSeek = Boolean.valueOf(r100);
        Iterator<Map.Entry<Integer, db1.a>> r101 = this.lyricScoreInfo.entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        if (r101.next().getValue().f467793a <= r110.longValue()) goto L9;
        r101.remove();
        goto L9
    L13:
        List<cb0.c> r102 = this.midiData.getValue();
        if (r102 == null) goto L23;
        Iterator<T> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L23;
        cb0.c r104 = (cb0.c) r103.next();
        if (r104.f22991a.f22988a < r110.longValue()) goto L17;
        List<cb0.a> r105 = r104.f22993c;
        if (r105 == null) goto L17;
        r105.clear();
    L23:
        this.lyricsCount = 0;
        this.lastMidiIndex = -1;
        setCurTotalScore(0);
        Iterator<Map.Entry<Integer, db1.a>> r106 = this.lyricScoreInfo.entrySet().iterator();
    L25:
        if (r106.hasNext() == false) goto L29;
        Map.Entry<Integer, db1.a> r107 = r106.next();
        this.lyricsCount++;
        setCurTotalScore(getCurTotalScore() + ((int) r107.getValue().f467794b));
        if (r107.getKey().intValue() <= this.lastMidiIndex) goto L25;
        this.lastMidiIndex = r107.getKey().intValue();
        goto L25
    L29:
        db1.a r108 = this.lyricScoreInfo.get(Integer.valueOf(this.lastMidiIndex));
        if (r108 == null) goto L32;
        float r109 = r108.f467794b;
    L33:
        setCurScore(r109);
        String r111 = "seek: progress: " + r110 + "   lyricsCount: " + this.lyricsCount + "  lastMidiIndex: " + this.lastMidiIndex + "  curScore: " + this.curScore + "  curTotalScore: " + getCurTotalScore() + "    isForwardSeek: " + this.isForwardSeek;
        ALogger.i(bb0.b.b(), "SoloKtvMidiViewModel :" + r111 + ", invoke class :SoloKtvMidiViewModel");
        long r112 = r110.longValue();
        this.curMidiProgress = r112;
        this.scoreInfo.setValue(new Pair(Long.valueOf(r112), new com.bytedance.android.live.ktv.common.midi.k(0.0f, 0.0f, 0.0f, this.curScore, this.lastMidiIndex, null, 0, true, 96)));
        return;
    L32:
        r109 = 0.0f;
        goto L33
    L6:
        r100 = false;
        goto L7
    }

    public void setCurTotalScore(int r100) {
        this.curTotalScore = r100;
    }

    public final void setForwardSeek(Boolean r100) {
        this.isForwardSeek = r100;
    }

    public final void setMidiConfig(MutableLiveData<g0> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.midiConfig = r100;
    }

    public final void setShowNoMidiHint(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showNoMidiHint = r100;
    }

    public void setTotalScore(int r100) {
        this.totalScore = r100;
    }

    public void setUserOpenScore(boolean r100) {
        this.userOpenScore = r100;
    }

    public final void tryGetScoreInfo(Long r100) {
        List<cb0.c> r101 = this.midiData.getValue();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L14;
        if (r100 == null) goto L14;
        this.curMidiProgress = r100.longValue();
        this.scoreInfo.setValue(new Pair(r100, getScoreInfo()));
        return;
    L14:
        String r103 = "tryStartGetScoreInfoTimer return, midiData: " + this.midiData.getValue() + " progress: " + r100;
        ALogger.i(bb0.b.b(), "SoloKtvMidiViewModel :" + r103 + ", invoke class :SoloKtvMidiViewModel");
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    private final float calScore(float r100, int r101) {
        if (r101 >= 0) goto L4;
        getCurTotalScore();
    L4:
        this.lyricsCount++;
        setCurTotalScore(getCurTotalScore() + ((int) r100));
        float r102 = getCurTotalScore() / this.lyricsCount;
        if (r102 <= 100.0f) goto L8;
        return 100.0f;
    L8:
        return r102;
    }

    @Override // db0.a
    public Single<List<cb0.c>> findMidiSegments(long r100, long r101) {
        List<cb0.c> r102 = this.midiData.getValue();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegments midiData is null, invoke class :SoloKtvMidiViewModel");
        return null;
    L13:
        return Observable.just(this.midiData.getValue()).filter(e.f101366a).flatMap(f.f101367a).filter(new g(r101, r100)).toList();
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public List<cb0.c> findMidiSegmentsNew(long r110, long r111) {
        List<cb0.c> r100 = this.midiData.getValue();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        ArrayList r102 = null;
        if (r101 == false) goto L13;
        ALogger.i(bb0.b.b(), "findMidiSegmentsNew midiData is null, invoke class :SoloKtvMidiViewModel");
        return null;
    L13:
        List<cb0.c> r103 = this.midiData.getValue();
        if (r103 == null) goto L26;
        r102 = new ArrayList();
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L26;
        Object r105 = r104.next();
        cb0.a r106 = ((cb0.c) r105).f22991a;
        if (r106.f22988a < r111) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == false) goto L17;
        r102.add(r105);
        goto L17
    L21:
        if (r106.f22989b <= r110) goto L23;
        r107 = true;
    L26:
        return r102;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void initMidiRes(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "midiPath");
        ALogger.i(bb0.b.b(), "initMidiRes, invoke class :SoloKtvMidiViewModel");
        if (TextUtils.isEmpty(r101) == false) goto L15;
        ALogger.i(bb0.b.b(), "initMidiRes fail, midiPath == null, invoke class :SoloKtvMidiViewModel");
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.record.c r103 = SoloKtvContext.a.a().getDataStore();
        if (r103 == null) goto L13;
        com.bytedance.android.live.soloktv.model.k r104 = r103.f101453a;
        if (r104 == null) goto L13;
        eb1.f r105 = r104.b();
        if (r105 == null) goto L13;
        eb1.e r106 = r105.f();
        if (r106 == null) goto L13;
        r106.f471794a = null;
    L13:
        this.showNoMidiHint.setValue(Boolean.TRUE);
        return;
    L15:
        Disposable r107 = this.midiDisposable;
        if (r107 == null) goto L20;
        if (r107.isDisposed() == true) goto L20;
        return;
    L20:
        if (this.midiData.getValue() != null) goto L24;
        this.midiDisposable = Single.create(new h(r102, r101)).map(new i(r101)).subscribe(new j(this), new k(this, r100));
        return;
    }
}
