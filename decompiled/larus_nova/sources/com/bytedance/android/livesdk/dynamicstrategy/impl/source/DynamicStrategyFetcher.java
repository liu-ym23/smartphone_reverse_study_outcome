package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.p;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.z;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J&\u0010\u001b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00100\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0018\u0010\u001d\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J \u0010\u001e\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/source/DynamicStrategyFetcher;", "", "", "requestScene", "", "forceFetchFull", "Lkotlin/Function0;", "", "callback", "fetchStrategy", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/z;", "data", "", "globalVersion", "updateStrategy", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "originList", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/p;", "incrementStrategies", "mergeStrategy", "leftList", "rightList", "checkEqualStrategy", "", "Lkotlin/Function1;", "filter", "safeRemoveIf", "updateStrategyWhenLaunch", "updateStrategyWhenMessageNotify", "updateStrategyWhenUserChanged", "UPDATE_TYPE_FULL", "I", "UPDATE_TYPE_INCREMENT", "UPDATE_TYPE_INCREMENT_WITH_CHECK", "REQUEST_SCENE_LAUNCH", "REQUEST_SCENE_MESSAGE", "REQUEST_SCENE_ENTER", "REQUEST_SCENE_USER_CHANGE", "Lio/reactivex/disposables/Disposable;", "fetchDisposable", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicStrategyFetcher {
    public static final DynamicStrategyFetcher INSTANCE = null;
    private static final int REQUEST_SCENE_ENTER = 3;
    private static final int REQUEST_SCENE_LAUNCH = 1;
    private static final int REQUEST_SCENE_MESSAGE = 2;
    private static final int REQUEST_SCENE_USER_CHANGE = 4;
    private static final int UPDATE_TYPE_FULL = 1;
    private static final int UPDATE_TYPE_INCREMENT = 2;
    private static final int UPDATE_TYPE_INCREMENT_WITH_CHECK = 3;
    private static Disposable fetchDisposable;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f123256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f123257b;

        public a(int r100, String r101) {
            this.f123256a = r100;
            this.f123257b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            BaseResponse r111 = (BaseResponse) r110;
            z r100 = (z) r111.data;
            x r101 = (x) r111.extra;
            if (r101 == null) goto L5;
            String r102 = r101.a();
        L6:
            z r112 = (z) r111.data;
            if (r112 == null) goto L9;
            Integer r113 = Integer.valueOf(r112.responseType);
        L10:
            if (r100 == null) goto L28;
            if (r102 == null) goto L28;
            if (r113 != null) goto L17;
        L18:
            if (r113 != null) goto L21;
        L22:
            if (r113 != null) goto L25;
        L26:
            int r103 = k.f510820a;
            k.i(this.f123256a, this.f123257b, "unknown update type " + r113, null);
            int r104 = DynamicStrategyMonitor.f123031a;
            DynamicStrategyMonitor.e(this.f123256a, this.f123257b, 998, "unknown update type " + r113);
            return;
        L25:
            if (r113.intValue() != 3) goto L26;
        L27:
            int r114 = k.f510820a;
            int r115 = this.f123256a;
            String r105 = this.f123257b;
            Intrinsics.checkNotNullParameter(r105, "version");
            k.g("DynamicStrategy_fetch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "success"), TuplesKt.to("result_type", Integer.valueOf(r115)), TuplesKt.to("version", r105)}));
            int r116 = DynamicStrategyMonitor.f123031a;
            int r117 = this.f123256a;
            String r106 = this.f123257b;
            Intrinsics.checkNotNullParameter(r106, "version");
            JSONObject r107 = new JSONObject();
            r107.put("requestScene", r117);
            r107.put("is_success", true);
            LiveMonitor.a r108 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyFetchAll);
            r108.b(r107);
            r108.i("requestScene", Integer.valueOf(r117));
            r108.i("version", r106);
            r108.a().report();
            DynamicStrategyFetcher.access$updateStrategy(DynamicStrategyFetcher.INSTANCE, this.f123256a, r100, r102);
            return;
        L21:
            if (r113.intValue() == 2) goto L27;
        L17:
            if (r113.intValue() == 1) goto L27;
        L28:
            int r118 = k.f510820a;
            k.i(this.f123256a, this.f123257b, "data or version is null", null);
            int r119 = DynamicStrategyMonitor.f123031a;
            DynamicStrategyMonitor.e(this.f123256a, this.f123257b, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_UPGRADE_TIME_THRESHOLD, "data or version is null");
            return;
        L9:
            r113 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f123258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f123259b;

        public b(int r100, String r101) {
            this.f123258a = r100;
            this.f123259b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            int r102 = k.f510820a;
            int r103 = this.f123258a;
            String r104 = this.f123259b;
            String r105 = r101.getMessage();
            String r106 = "api error";
            if (r105 != null) goto L5;
            r105 = "api error";
        L5:
            k.i(r103, r104, r105, r101);
            int r107 = DynamicStrategyMonitor.f123031a;
            int r108 = this.f123258a;
            String r109 = this.f123259b;
            if ((r101 instanceof ApiServerException) == true) goto L8;
            Throwable r110 = null;
        L9:
            ApiServerException r111 = (ApiServerException) r110;
            if (r111 == null) goto L12;
            int r112 = r111.getErrorCode();
        L13:
            String r113 = r101.getMessage();
            if (r113 == null) goto L17;
            r106 = r113;
        L17:
            DynamicStrategyMonitor.e(r108, r109, r112, r106);
            return;
        L12:
            r112 = 999;
            goto L13
        L8:
            r110 = r101;
            goto L9
        }
    }

    public static final class c extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public c() {
        }
    }

    private DynamicStrategyFetcher() {
    }

    static {
        INSTANCE = new DynamicStrategyFetcher();
    }

    public final void updateStrategyWhenLaunch(Function0<Unit> r100) {
        ku1.c r101 = ku1.c.f506181a;
        if (r101.getValue().b() == true) goto L5;
        return;
    L5:
        fetchStrategy(1, r101.getValue().c(), r100);
    }

    public final void updateStrategyWhenMessageNotify(Function0<Unit> r100) {
        if (ku1.c.f506181a.getValue().b() == true) goto L5;
        return;
    L5:
        fetchStrategy(2, false, r100);
    }

    private final boolean checkEqualStrategy(List<? extends a0> r100, List<? extends a0> r101) {
        List<? extends a0> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L3:
        String r105 = "";
        if (r104.hasNext() == false) goto L10;
        String r106 = ((a0) r104.next()).strategyName;
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r103.add(r105);
        goto L3
    L10:
        List r107 = CollectionsKt.toMutableList(r103);
        List<? extends a0> r108 = r101;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L12:
        if (r110.hasNext() == false) goto L17;
        String r111 = ((a0) r110.next()).strategyName;
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r109.add(r111);
        goto L12
    L17:
        List r112 = CollectionsKt.toList(r109);
        if (r107.size() == r112.size()) goto L20;
        return false;
    L20:
        r107.removeAll(r112);
        if (r107.size() == 0) goto L23;
        return false;
    L23:
        return true;
    }

    private final List<a0> mergeStrategy(List<? extends a0> r100, p r101) {
        ArrayList r102 = new ArrayList();
        r102.addAll(r100);
        List<a0> r103 = r101.incrementStrategies;
        if (r103 == null) goto L8;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        final a0 r105 = (a0) r104.next();
        INSTANCE.safeRemoveIf(r102, new DynamicStrategyFetcher$mergeStrategy$1$1(r105));
        r102.add(r105);
    L8:
        List<a0> r106 = r101.deleteStrategies;
        if (r106 == null) goto L14;
        Iterator<T> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        final a0 r108 = (a0) r107.next();
        INSTANCE.safeRemoveIf(r102, new DynamicStrategyFetcher$mergeStrategy$2$1(r108));
    L14:
        return r102;
    }

    private final boolean safeRemoveIf(Collection<a0> r100, Function1<? super a0, Boolean> r101) {
        Iterator<a0> r102 = r100.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L8;
        if (r101.invoke(r102.next()).booleanValue() == false) goto L4;
        r102.remove();
        r103 = true;
        goto L4
    L8:
        return r103;
    }

    public final void updateStrategyWhenUserChanged(Function0<Unit> r100, boolean r101) {
        if (ku1.c.f506181a.getValue().b() == true) goto L5;
        return;
    L5:
        fetchStrategy(4, r101, r100);
    }

    private final void fetchStrategy(int r100, boolean r101, Function0<Unit> r102) {
        Disposable r103 = fetchDisposable;
        if (r103 == null) goto L5;
        r103.dispose();
    L5:
        String r104 = "";
        if (r101 == false) goto L8;
        String r105 = "";
    L9:
        DynamicStrategyApi r106 = (DynamicStrategyApi) com.bytedance.android.live.network.c.b().e(DynamicStrategyApi.class);
        if (r106 != null) goto L12;
        return;
    L12:
        String r107 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new c()).second;
        if (r107 == null) goto L16;
        r104 = r107;
    L16:
        int r108 = k.f510820a;
        Intrinsics.checkNotNullParameter(r105, "version");
        k.g("DynamicStrategy_fetch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "start"), TuplesKt.to("request_scene", Integer.valueOf(r100)), TuplesKt.to("version", r105)}));
        fetchDisposable = r106.fetchStrategy(r100, r105, r104).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r100, r105), new b(r100, r105));
        return;
    L8:
        boolean r109 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123260a;
        r105 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_strategy_info").j("strategy_version", "");
        goto L9
    }

    private final void updateStrategy(int r100, z r101, String r102) {
        int r103 = r101.responseType;
        boolean r104 = true;
        if (r103 != 1) goto L5;
        List<a0> r105 = r101.fullStrategies;
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123262c.update(r102, r105);
        return;
    L5:
        if (r103 != 2) goto L7;
        p r106 = r101.incrementStrategies;
        List<a0> r107 = r106.incrementStrategies;
        if (r107 != null) goto L33;
    L34:
        List<a0> r108 = r106.deleteStrategies;
        if (r108 != null) goto L37;
    L41:
        if (Boolean.valueOf(r104).booleanValue() == true) goto L56;
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123262c.update(r102, mergeStrategy(com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a(), r101.incrementStrategies));
        return;
    L56:
        return;
    L37:
        if (r108.size() == 0) goto L41;
    L39:
        r104 = false;
        goto L41
    L33:
        if (r107.size() != 0) goto L39;
    L7:
        if (r103 != 3) goto L58;
        boolean r109 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123260a;
        List<a0> r110 = mergeStrategy(com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a(), r101.incrementStrategies);
        List<a0> r111 = r101.fullStrategies;
        if (checkEqualStrategy(r110, r111) == true) goto L29;
        int r112 = DynamicStrategyMonitor.f123031a;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r110.iterator();
    L13:
        if (r114.hasNext() == false) goto L17;
        String r115 = ((a0) r114.next()).strategyName;
        if (r115 == null) goto L13;
        r113.add(r115);
        goto L13
    L17:
        List r116 = CollectionsKt.toList(r113);
        List<a0> r117 = r101.fullStrategies;
        if (r117 == null) goto L27;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L21:
        if (r119.hasNext() == false) goto L25;
        String r120 = ((a0) r119.next()).strategyName;
        if (r120 == null) goto L21;
        r118.add(r120);
        goto L21
    L25:
        List r121 = CollectionsKt.toList(r118);
        if (r121 == null) goto L27;
    L28:
        Intrinsics.checkNotNullParameter(r102, "version");
        Intrinsics.checkNotNullParameter(r116, "merge");
        Intrinsics.checkNotNullParameter(r121, "full");
        JSONObject r122 = new JSONObject();
        r122.put("requestScene", r100);
        LiveMonitor.a r123 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyCheckError);
        r123.b(r122);
        r123.i("requestScene", Integer.valueOf(r100));
        r123.i("version", r102);
        r123.i("mergeList", r116);
        r123.i("fullList", r121);
        r123.a().report();
    L27:
        r121 = CollectionsKt.emptyList();
    L29:
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.f123262c.update(r102, r111);
        return;
    }

    public static final /* synthetic */ void access$updateStrategy(DynamicStrategyFetcher r100, int r101, z r102, String r103) {
        r100.updateStrategy(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenLaunch$default(DynamicStrategyFetcher r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.updateStrategyWhenLaunch(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenMessageNotify$default(DynamicStrategyFetcher r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.updateStrategyWhenMessageNotify(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenUserChanged$default(DynamicStrategyFetcher r100, Function0 r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.updateStrategyWhenUserChanged(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchStrategy$default(DynamicStrategyFetcher r100, int r101, boolean r102, Function0 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.fetchStrategy(r101, r102, r103);
    }
}
