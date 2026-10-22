package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningvolume/view/TuningVolumeContentArea;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningVolumeContentArea extends LinearLayout implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f70564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<TuningVolumeType, View> f70565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleRegistry f70566c;

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f70566c.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f70566c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f70566c;
    }

    public final View b(TuningVolumeType r100) {
        Intrinsics.checkNotNullParameter(r100, "volumeType");
        return getChildAt(indexOfChild((View) ((LinkedHashMap) this.f70565b).get(r100)));
    }

    public TuningVolumeContentArea(ac0.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r102 = r100.f2544k;
        this.f70564a = r102;
        this.f70565b = new LinkedHashMap();
        LifecycleRegistry r103 = new LifecycleRegistry(this);
        this.f70566c = r103;
        r103.setCurrentState(Lifecycle.State.CREATED);
        gc0.d r104 = r100.f2540g;
        if (r104 == null) goto L5;
        r104.b(this);
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setVisibility(0);
        gc0.d r105 = r100.f2540g;
        if (r105 == null) goto L8;
        r105.c(this, new WeakReference(r101));
    L9:
        gc0.d r106 = r100.f2540g;
        if (r106 == null) goto L12;
        r106.a(this);
        return;
    L12:
        if (r102 == null) goto L16;
        MutableLiveData<Boolean> r107 = r102.F();
        if (r107 == null) goto L16;
        r107.observe(this, new d(this));
    L16:
        if (r102 == null) goto L20;
        r102.L();
        return;
    L20:
        return;
    L8:
        removeAllViews();
        a(TuningVolumeType.EAR_BACK_VOLUME, new j(new e(this), getContext(), r100.f2546m, 12));
        a(TuningVolumeType.VOCAL_VOLUME, new j(new f(this), getContext(), r100.f2546m, 12));
        a(TuningVolumeType.ACCOMPANIMENT_VOLUME, new j(new g(this), getContext(), r100.f2546m, 12));
        a(TuningVolumeType.TONE_VOLUME, new c(new h(this), getContext(), r100.f2546m, 12));
        goto L9
    }

    public final void a(TuningVolumeType r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "volumeType");
        Intrinsics.checkNotNullParameter(r101, "customView");
        removeView(r101);
        addView(r101);
        this.f70565b.put(r100, r101);
    }
}
