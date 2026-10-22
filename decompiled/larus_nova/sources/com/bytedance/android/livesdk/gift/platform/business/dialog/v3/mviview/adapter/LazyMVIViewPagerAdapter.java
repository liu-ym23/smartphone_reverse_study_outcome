package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.anya.p;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.GiftMVIVerticalListView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/LazyMVIViewPagerAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Lcom/bytedance/android/anya/MVIViewPagerAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LazyMVIViewPagerAdapter<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> extends MVIViewPagerAdapter<STATE, ACTION> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f127798m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f127799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f127800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Object> f127801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, b> f127802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f127803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Integer> f127804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b0 f127805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f127806l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f127807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f127808b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f127807a == r101.f127807a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f127808b, r101.f127808b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f127807a * 31;
            View r101 = this.f127808b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "PlaceholderPage(position=" + this.f127807a + ", view=" + this.f127808b + ")";
        }

        public b(int r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f127807a = r100;
            this.f127808b = r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.anya.MVIViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        int r101 = getCount();
        if ((r100 instanceof b) == false) goto L19;
        int r102 = ((b) r100).f127807a;
        if (r102 < 0) goto L50;
        if (r102 < r101) goto L9;
        return -2;
    L9:
        if (this.f127800f == true) goto L14;
        if (this.f127804j.contains(Integer.valueOf(r102)) == false) goto L14;
        return -2;
    L14:
        if (this.f127800f == false) goto L51;
        if (r102 != this.f127799e) goto L51;
        return -2;
    L51:
        return r102;
    L50:
        return -2;
    L19:
        Iterator r103 = ((LinkedHashMap) this.f127801g).entrySet().iterator();
    L21:
        if (r103.hasNext() == false) goto L28;
        Object r104 = r103.next();
        if (((Map.Entry) r104).getValue() != r100) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L21;
    L29:
        Map.Entry r106 = (Map.Entry) r104;
        if (r106 == null) goto L32;
        int r107 = ((Number) r106.getKey()).intValue();
        if (r107 < 0) goto L52;
        if (r107 < r101) goto L38;
        return -2;
    L38:
        if (this.f127800f == true) goto L41;
        return super.getItemPosition(r100);
    L41:
        if (r107 == this.f127799e) goto L44;
        return -2;
    L44:
        return super.getItemPosition(r100);
    L52:
        return -2;
    L32:
        return super.getItemPosition(r100);
    L25:
        r105 = false;
        goto L26
    L28:
        r104 = null;
        goto L29
    }

    public final void h(int r100) {
        int r101 = getCount();
        if (r100 < 0) goto L20;
        if (r100 < r101) goto L7;
        return;
    L7:
        if (this.f127800f == false) goto L13;
        if (r100 != this.f127799e) goto L11;
        return;
    L11:
        this.f127799e = r100;
        notifyDataSetChanged();
        return;
    L13:
        if (this.f127802h.containsKey(Integer.valueOf(r100)) == true) goto L16;
        return;
    L16:
        if (this.f127804j.add(Integer.valueOf(r100)) == true) goto L18;
        return;
    L18:
        notifyDataSetChanged();
        return;
    }

    public LazyMVIViewPagerAdapter(GiftMVIVerticalListView r100, Function3 r101) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "createPage");
        super(r100, r101);
        this.f127800f = true;
        this.f127801g = new LinkedHashMap();
        this.f127802h = new LinkedHashMap();
        this.f127803i = new LinkedHashSet();
        this.f127804j = new LinkedHashSet();
        this.f127806l = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.android.anya.MVIViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        if (this.f127800f == true) goto L10;
        Object r102 = super.instantiateItem(r100, r101);
        this.f127801g.put(Integer.valueOf(r101), r102);
        b r103 = this.f127802h.remove(Integer.valueOf(r101));
        if (r103 == null) goto L7;
        r100.removeView(r103.f127808b);
    L7:
        this.f127804j.remove(Integer.valueOf(r101));
        return r102;
    L10:
        if (r101 != this.f127799e) goto L14;
        Object r104 = super.instantiateItem(r100, r101);
        this.f127801g.put(Integer.valueOf(r101), r104);
        b r105 = this.f127802h.remove(Integer.valueOf(r101));
        if (r105 == null) goto L16;
        r100.removeView(r105.f127808b);
        return r104;
    L16:
        return r104;
    L14:
        FrameLayout r106 = new FrameLayout(r100.getContext());
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r100.addView(r106);
        b r107 = new b(r101, r106);
        this.f127802h.put(Integer.valueOf(r101), r107);
        this.f127801g.remove(Integer.valueOf(r101));
        this.f127803i.add(Integer.valueOf(r101));
        return r107;
    }

    @Override // com.bytedance.android.anya.MVIViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        if ((r101 instanceof b) == false) goto L9;
        if (r100 != ((b) r101).f127808b) goto L7;
        return true;
    L7:
        return false;
    L9:
        return super.isViewFromObject(r100, r101);
    }

    @Override // com.bytedance.android.anya.MVIViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if ((r102 instanceof b) == false) goto L5;
        b r103 = (b) r102;
        this.f127802h.remove(Integer.valueOf(r103.f127807a));
        r100.removeView(r103.f127808b);
        return;
    L5:
        Iterator r104 = ((LinkedHashMap) this.f127801g).entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (((Map.Entry) r105).getValue() != r102) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L7;
    L15:
        Map.Entry r107 = (Map.Entry) r105;
        if (r107 == null) goto L18;
        this.f127801g.remove(r107.getKey());
    L18:
        super.destroyItem(r100, r101, r102);
        return;
    L11:
        r106 = false;
        goto L12
    L14:
        r105 = null;
        goto L15
    }
}
