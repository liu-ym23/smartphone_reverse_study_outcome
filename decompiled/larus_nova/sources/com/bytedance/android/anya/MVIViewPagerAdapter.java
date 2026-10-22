package com.bytedance.android.anya;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIViewPagerAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Landroidx/viewpager/widget/PagerAdapter;", "runtime_release"}, k = 1, mv = {1, 4, 0})
public class MVIViewPagerAdapter<STATE extends MVIState<?>, ACTION extends p> extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends STATE> f41573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<STATE, DelegatingMVIBindingImpl<STATE, ACTION, c<STATE, ACTION>>> f41574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseMVIView<?, ?> f41575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<ViewGroup, Integer, Integer, c<STATE, ACTION>> f41576d;

    public int f(int r100) {
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f41573a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(r0 r100) {
        return ((com.bytedance.android.anya.internal.c) r100).c();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r100) {
        h0 r101 = (h0) r100;
        Integer r102 = Integer.valueOf(CollectionsKt.indexOf(this.f41573a, r101.f41623e));
        if (r102.intValue() < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L15;
        int r104 = r102.intValue();
        if (f(r104) == r101.f41617g) goto L14;
        return -2;
    L14:
        return r104;
    L15:
        return -2;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MVIViewPagerAdapter(BaseMVIView<?, ?> r100, Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends c<STATE, ACTION>> r101) {
        this.f41575c = r100;
        this.f41576d = r101;
        this.f41573a = CollectionsKt.emptyList();
        this.f41574b = new LinkedHashMap();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(final ViewGroup r110, final int r111) {
        final MVIState r100 = (MVIState) ListProtector.get(this.f41573a, r111);
        com.bytedance.android.anya.internal.m<?, ACTION> r101 = this.f41575c.f41537b;
        if (r101 == null) goto L7;
        c<STATE, ACTION> r102 = this.f41576d.invoke(r110, Integer.valueOf(r111), Integer.valueOf(f(r111)));
        h0 r103 = new h0(r101, r102, r100, f(r111), new AnonymousClass1(r100, r111, r110));
        this.f41574b.put((STATE) r100, r103);
        r103.a();
        r102.q(true);
        return r103;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIBindingExt<*, ACTION>");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r100, Object r101) {
        VIEW r102 = ((DelegatingMVIBindingImpl) r101).f41622d;
        if (r102 == 0) goto L10;
        if (((c) r102).f41583k != r100) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIPagerItem<*, *>");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        DelegatingMVIBindingImpl r103 = (DelegatingMVIBindingImpl) r102;
        STATE r104 = r103.f41623e;
        r103.unbind();
        Map<STATE, DelegatingMVIBindingImpl<STATE, ACTION, c<STATE, ACTION>>> r105 = this.f41574b;
        if (r105 == null) goto L11;
        TypeIntrinsics.asMutableMap(r105).remove(r104);
        VIEW r106 = r103.f41622d;
        if (r106 == 0) goto L9;
        r100.removeView(((c) r106).f41583k);
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIPagerItem<*, *>");
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
