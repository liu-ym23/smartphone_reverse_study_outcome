package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.c0;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.id;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import pd2.d;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0006J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0016\u001a\u00020\u000fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\bJ\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u0006H\u0014R4\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00140#j\b\u0012\u0004\u0012\u00020\u0014`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvChallengeSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "calculateCustomTargetResult", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "option", "", "updateDefaultConfigIndex", "Lkotlin/Pair;", "", "getCurrentChallengeConfigIndex", "index", "type", "updateChallengeConfigIndex", "challengeType", "", PickerReporterConstants.KEY.TARGET, "updateChallengeTargetValue", "getSingingChallengeOption", "", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/a;", "getChallengeTypeList", "getChallengeDuration", "getChallengeTargetList", "currentTargetRange", "currentChallengeType", "currentChallengeTarget", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "challengeConfigIndexPair", "Landroidx/lifecycle/MutableLiveData;", "getChallengeConfigIndexPair", "()Landroidx/lifecycle/MutableLiveData;", "setChallengeConfigIndexPair", "(Landroidx/lifecycle/MutableLiveData;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "challengeTypeList", "Ljava/util/ArrayList;", "challengeCustomTarget", "Lkotlin/Pair;", "challengeOption", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeSettingViewModel extends ViewModel {
    public static final int CHALLENGE_TARGET = 2;
    public static final int CHALLENGE_TYPE = 1;
    public static final int CUSTOM_POSITION = 3;
    public static final a Companion = null;
    public static final long DURATION_DEFAULT = 90;
    public static final String TAG = "KtvChallengeSettingViewModel";
    private MutableLiveData<Pair<Integer, Integer>> challengeConfigIndexPair;
    private Pair<Integer, Long> challengeCustomTarget;
    private c0 challengeOption;
    private final ArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> challengeTypeList;
    private final CompositeDisposable compositeDispose;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvChallengeSettingViewModel f144639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f144640b;

        public b(KtvChallengeSettingViewModel r100, long r101) {
            this.f144639a = r100;
            this.f144640b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            e r101 = (e) r100;
            c0 r102 = (c0) r101.data;
            KtvChallengeSettingViewModel.access$setChallengeOption$p(this.f144639a, r102);
            KtvChallengeSettingViewModel r103 = this.f144639a;
            KtvChallengeSettingViewModel.access$updateDefaultConfigIndex(r103, KtvChallengeSettingViewModel.access$getChallengeOption$p(r103));
            mb0.c.a.b(d.f528658n, LinkMonitorData.ApiGetSingingChallengeOption, System.currentTimeMillis() - this.f144640b, r101.logId);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f144641a;

        public c(long r100) {
            this.f144641a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            d r101 = d.f528658n;
            LinkMonitorData r102 = LinkMonitorData.ApiGetSingingChallengeOption;
            long r103 = System.currentTimeMillis() - this.f144641a;
            mb0.c.a.a(r101, r102, r103, (Throwable) r100);
        }
    }

    static {
        Companion = new a();
    }

    public final int currentChallengeType() {
        Pair<Integer, Integer> r100 = this.challengeConfigIndexPair.getValue();
        int r101 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
        if (r100 == null) goto L5;
        Integer r102 = r100.getFirst();
    L6:
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r100.getFirst().intValue() >= 0) goto L10;
        return r101;
    L10:
        if (r100.getFirst().intValue() >= this.challengeTypeList.size()) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r103 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a) CollectionsKt.getOrNull(this.challengeTypeList, r100.getFirst().intValue());
        if (r103 == null) goto L15;
        return r103.f144685a;
    L15:
        return 0;
    L18:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public final long getChallengeDuration() {
        c0 r100 = this.challengeOption;
        if (r100 == null) goto L7;
        Long r101 = r100.c();
        if (r101 == null) goto L7;
        return r101.longValue();
    L7:
        return 90;
    }

    public final List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> getChallengeTargetList() {
        ArrayList r100 = new ArrayList();
        int r101 = currentChallengeType();
        c0 r102 = this.challengeOption;
        if (r102 == null) goto L20;
        List<id> r103 = r102.a();
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        id r105 = (id) r104.next();
        Integer r106 = r105.b();
        if (r106 == null) goto L8;
        if (r106.intValue() != r101) goto L8;
        List<Long> r107 = r105.a();
        if (r107 == null) goto L8;
        Iterator<T> r108 = r107.iterator();
    L18:
        if (r108.hasNext() == false) goto L8;
        r100.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(r101, String.valueOf(((Number) r108.next()).longValue()), 2, false));
    L20:
        Pair<Integer, Long> r109 = this.challengeCustomTarget;
        if (r109 != null) goto L23;
    L29:
        String r110 = s1.B(R.string.ttlive_ktv_challenge_custom_target_text);
    L30:
        r100.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(r101, r110, 2, true));
        return r100;
    L23:
        if (r109.getFirst().intValue() != r101) goto L29;
        Pair<Integer, Integer> r111 = this.challengeConfigIndexPair.getValue();
        if (r111 == null) goto L29;
        if (3 != r111.getSecond().intValue()) goto L29;
        r110 = calculateCustomTargetResult();
        goto L30
    }

    public final Pair<Integer, Integer> getCurrentChallengeConfigIndex() {
        return this.challengeConfigIndexPair.getValue();
    }

    public KtvChallengeSettingViewModel() {
        this.challengeConfigIndexPair = new MutableLiveData(new Pair(0, 0));
        ArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> r100 = new ArrayList();
        this.challengeTypeList = r100;
        this.compositeDispose = new CompositeDisposable();
        r100.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue(), s1.B(R.string.ttlive_ktv_challenge_gift_type), 1, false));
        r100.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue(), s1.B(R.string.ttlive_ktv_challenge_score_type), 1, false));
        r100.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue(), s1.B(R.string.ttlive_ktv_challenge_like_type), 1, false));
    }

    private final String calculateCustomTargetResult() {
        String r100 = s1.B(R.string.ttlive_ktv_challenge_custom_target_text);
        Pair<Integer, Long> r101 = this.challengeCustomTarget;
        if (r101 == null) goto L11;
        Long r102 = r101.getSecond();
        if (r102 == null) goto L12;
        long r103 = r102.longValue();
        if (r103 < 10000) goto L10;
        StringBuilder r104 = new StringBuilder();
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r104.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r103 / 10000.0f)}, 1)));
        r104.append(19975);
        return r104.toString();
    L10:
        return String.valueOf(r103);
    L12:
        return r100;
    L11:
        return r100;
    }

    public final long currentChallengeTarget() {
        int r100 = currentChallengeType();
        Pair<Integer, Integer> r101 = this.challengeConfigIndexPair.getValue();
        if (r101 != null) goto L5;
    L16:
        c0 r102 = this.challengeOption;
        if (r102 == null) goto L65;
        List<id> r103 = r102.a();
        if (r103 == null) goto L66;
        Iterator<T> r104 = r103.iterator();
    L21:
        long r105 = 100;
    L23:
        if (r104.hasNext() == false) goto L46;
        id r106 = (id) r104.next();
        if (r106.b() == null) goto L23;
        Integer r107 = r106.b();
        if (r107 == null) goto L23;
        if (r100 != r107.intValue()) goto L23;
        if (r101 == null) goto L33;
        Integer r108 = r101.getSecond();
    L34:
        if (r108 == null) goto L23;
        int r109 = r101.getSecond().intValue();
        List<Long> r110 = r106.a();
        if (r110 == null) goto L38;
        int r111 = r110.size();
    L39:
        if (r109 >= r111) goto L23;
        List<Long> r112 = r106.a();
        if (r112 == null) goto L21;
        Long r113 = (Long) ListProtector.get(r112, r101.getSecond().intValue());
        if (r113 == null) goto L21;
        r105 = r113.longValue();
        goto L23
    L38:
        r111 = 0;
        goto L39
    L33:
        r108 = null;
        goto L34
    L46:
        return r105;
    L66:
        return 100;
    L65:
        return 100;
    L5:
        if (r101.getSecond().intValue() != 3) goto L16;
        Pair<Integer, Long> r114 = this.challengeCustomTarget;
        if (r114 == null) goto L16;
        if (r114.getFirst().intValue() != r100) goto L16;
        Pair<Integer, Long> r115 = this.challengeCustomTarget;
        if (r115 == null) goto L63;
        Long r116 = r115.getSecond();
        if (r116 != null) goto L15;
        return 100;
    L15:
        return r116.longValue();
    L63:
        return 100;
    }

    public final Pair<Long, Long> currentTargetRange() {
        int r100 = currentChallengeType();
        Pair<Long, Long> r101 = TuplesKt.to(1L, 100L);
        c0 r102 = this.challengeOption;
        if (r102 == null) goto L23;
        List<id> r103 = r102.a();
        if (r103 == null) goto L23;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L23;
        id r105 = (id) r104.next();
        Integer r106 = r105.b();
        if (r106 == null) goto L8;
        if (r106.intValue() != r100) goto L8;
        Long r107 = r105.c();
        if (r107 == null) goto L17;
        long r108 = r107.longValue();
    L18:
        Long r109 = Long.valueOf(r108);
        Long r110 = r105.d();
        if (r110 == null) goto L21;
        long r111 = r110.longValue();
    L22:
        r101 = TuplesKt.to(r109, Long.valueOf(r111));
        goto L8
    L21:
        r111 = 100;
        goto L22
    L17:
        r108 = 1;
    L23:
        return r101;
    }

    public final void getSingingChallengeOption() {
        long r100 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getSingingChallengeOptionParams(com.bytedance.android.live.ktv.common.util.a.c().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r100), new c(r100)), this.compositeDispose);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDispose.clear();
        ALogger.i(TAG, "onCleared");
    }

    public final MutableLiveData<Pair<Integer, Integer>> getChallengeConfigIndexPair() {
        return this.challengeConfigIndexPair;
    }

    public final List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> getChallengeTypeList() {
        return this.challengeTypeList;
    }

    public static final /* synthetic */ c0 access$getChallengeOption$p(KtvChallengeSettingViewModel r100) {
        return r100.challengeOption;
    }

    private final void updateDefaultConfigIndex(c0 r110) {
        Long r100 = null;
        if (r110 == null) goto L7;
        id r101 = r110.b();
        if (r101 == null) goto L7;
        Integer r102 = r101.b();
    L8:
        if (r110 == null) goto L14;
        id r103 = r110.b();
        if (r103 == null) goto L14;
        List<Long> r104 = r103.a();
        if (r104 == null) goto L14;
        r100 = (Long) CollectionsKt.firstOrNull(r104);
    L14:
        Iterator<T> r105 = this.challengeTypeList.iterator();
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
    L16:
        if (r105.hasNext() == false) goto L27;
        Object r109 = r105.next();
        int r111 = r107 + 1;
        if (r107 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r112 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a) r109;
        if (r102 == null) goto L25;
        if (r112.f144685a != r102.intValue()) goto L25;
        r108 = r107;
    L25:
        r107 = r111;
        goto L16
    L27:
        if (r110 == null) goto L46;
        id r113 = r110.b();
        if (r113 == null) goto L46;
        List<Long> r114 = r113.a();
        if (r114 == null) goto L46;
        Iterator<T> r115 = r114.iterator();
        int r116 = -1;
    L34:
        if (r115.hasNext() == false) goto L47;
        Object r117 = r115.next();
        int r118 = r106 + 1;
        if (r106 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        long r119 = ((Number) r117).longValue();
        if (r102 == null) goto L45;
        if (r100 == null) goto L45;
        if (r119 != r100.longValue()) goto L45;
        r116 = r106;
    L45:
        r106 = r118;
    L47:
        if (r116 != (-1)) goto L52;
        if (r102 == null) goto L51;
        if (r100 == null) goto L51;
        this.challengeCustomTarget = TuplesKt.to(Integer.valueOf(r102.intValue()), Long.valueOf(r100.longValue()));
    L51:
        r116 = 3;
    L52:
        this.challengeConfigIndexPair.setValue(TuplesKt.to(Integer.valueOf(r108), Integer.valueOf(r116)));
        return;
    L46:
        r116 = -1;
    L7:
        r102 = null;
        goto L8
    }

    public final void setChallengeConfigIndexPair(MutableLiveData<Pair<Integer, Integer>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.challengeConfigIndexPair = r100;
    }

    public static final /* synthetic */ void access$setChallengeOption$p(KtvChallengeSettingViewModel r100, c0 r101) {
        r100.challengeOption = r101;
    }

    public static final /* synthetic */ void access$updateDefaultConfigIndex(KtvChallengeSettingViewModel r100, c0 r101) {
        r100.updateDefaultConfigIndex(r101);
    }

    public final void updateChallengeConfigIndex(int r100, int r101) {
        int r102 = 0;
        if (r101 != 1) goto L6;
        this.challengeConfigIndexPair.setValue(new Pair(Integer.valueOf(r100), 0));
        return;
    L6:
        if (r101 != 2) goto L15;
        MutableLiveData<Pair<Integer, Integer>> r103 = this.challengeConfigIndexPair;
        Pair<Integer, Integer> r104 = r103.getValue();
        if (r104 == null) goto L12;
        Integer r105 = r104.getFirst();
        if (r105 == null) goto L12;
        r102 = r105.intValue();
    L12:
        r103.setValue(new Pair(Integer.valueOf(r102), Integer.valueOf(r100)));
        return;
    }

    public final void updateChallengeTargetValue(int r100, long r101) {
        this.challengeCustomTarget = TuplesKt.to(Integer.valueOf(r100), Long.valueOf(r101));
        updateChallengeConfigIndex(3, 2);
    }
}
