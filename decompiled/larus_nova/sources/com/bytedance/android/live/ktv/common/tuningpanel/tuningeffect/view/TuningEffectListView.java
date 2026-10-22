package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "tuningList", "", "setDataAndNotify", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroidx/lifecycle/LifecycleRegistry;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "com/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView$tuningEffectCallback$2$a", "c", "getTuningEffectCallback", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView$tuningEffectCallback$2$a;", "tuningEffectCallback", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "d", "getTuningEffectAdapter", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "tuningEffectAdapter", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectListView extends RecyclerView implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f70532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70534d;

    public static final class a {
    }

    static {
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.f70531a.getValue();
    }

    private final TuningEffectAdapter getTuningEffectAdapter() {
        return (TuningEffectAdapter) this.f70534d.getValue();
    }

    private final TuningEffectListView$tuningEffectCallback$2.a getTuningEffectCallback() {
        return (TuningEffectListView$tuningEffectCallback$2.a) this.f70533c.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
    }

    public static final /* synthetic */ TuningEffectAdapter r(TuningEffectListView r100) {
        return r100.getTuningEffectAdapter();
    }

    public static final /* synthetic */ TuningEffectListView$tuningEffectCallback$2.a t(TuningEffectListView r100) {
        return r100.getTuningEffectCallback();
    }

    public final void setDataAndNotify(List<h> r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningList");
        TuningEffectAdapter r101 = getTuningEffectAdapter();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tuningList");
        if (((Boolean) KtvSettingHelper.f70668v0.getValue()).booleanValue() == false) goto L13;
        ((ArrayList) r101.f70526b).clear();
        List<h> r102 = r101.f70526b;
        List<h> r103 = r101.f70525a;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = ((ArrayList) r103).iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r104.add(h.a((h) r105.next()));
        goto L6
    L8:
        ((ArrayList) r102).addAll(r104);
        ((ArrayList) r101.f70525a).clear();
        List<h> r106 = r101.f70525a;
        List<h> r107 = r100;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L10:
        if (r109.hasNext() == false) goto L12;
        r108.add(h.a((h) r109.next()));
        goto L10
    L12:
        ((ArrayList) r106).addAll(r108);
        Single.create(new com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.a(r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101), c.f70543a);
        return;
    L13:
        ((ArrayList) r101.f70525a).clear();
        ArrayList r110 = (ArrayList) r101.f70525a;
        r110.addAll(r100);
        r101.notifyDataSetChanged();
    }

    public TuningEffectListView(final ac0.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101);
        this.f70531a = LazyKt.lazy(new TuningEffectListView$lifecycleRegistry$2(this));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r102 = r100.f2544k;
        this.f70532b = r102;
        this.f70533c = LazyKt.lazy(new TuningEffectListView$tuningEffectCallback$2(this, r100));
        this.f70534d = LazyKt.lazy(new TuningEffectListView$tuningEffectAdapter$2(this, r100));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(s1.f(16.0f), s1.f(14.0f), s1.f(0.0f), s1.f(10.0f));
        getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        setItemAnimator(null);
        setAdapter(getTuningEffectAdapter());
        setLayoutManager(new SSLinearLayoutManager(r101, 0));
        setItemViewCacheSize(8);
        if (r102 == null) goto L5;
        r102.t(this, new d(this));
    L5:
        if (r102 == null) goto L8;
        r102.x(this, new e(this));
        return;
    }
}
