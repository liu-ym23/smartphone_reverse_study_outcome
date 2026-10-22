package com.bytedance.android.live.effect.avadjust.lens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLensFragment extends BaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f66869k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f66870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Sticker f66871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f66873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<LensTabItemView> f66874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f66876j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        LiveLensAdapter r100 = (LiveLensAdapter) this.f66873g.getValue();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f66866h).b().g().e(r100.f66864f);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f66870d.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveLensAdapter r100 = (LiveLensAdapter) this.f66873g.getValue();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f66866h).b().g().a(r100.f66864f);
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f66875i;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    public LiveLensFragment(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(null, "eventPage");
        this.f66875i = r100;
        this.f66876j = null;
        this.f66870d = new LinkedHashMap();
        this.f66872f = R.layout.ttlive_effect_item_av_adjust_small_item;
        this.f66873g = LazyKt.lazy(new LiveLensFragment$lensAdapter$2(this));
        this.f66874h = new ArrayList();
    }

    public final View S90(int r100) {
        if (this.f66870d != null) goto L5;
        this.f66870d = new LinkedHashMap();
    L5:
        View r101 = this.f66870d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f66870d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).c(s1.h(R.color.ttlive_effect_broadcast_preview_beauty_item_text_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
        ((AdjustPercentBar) S90(R.id.color_adjust_seek_bar)).setOnLevelChangeListener(new c(this));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAdapter((LiveLensAdapter) this.f66873g.getValue());
    }

    public final void T90(String r100, String r101, HashMap<String, String> r102) {
        List<String> r103 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.api.c r104 = LiveEffectContext.a.a(this.f66875i).e();
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, this.f66876j);
        r102.put(MobConstants.EFFECT_NAME, r101);
        Unit r105 = Unit.INSTANCE;
        r104.sendLog(r100, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_fragment_lens_adjust_small_item, r101, false);
    }
}
