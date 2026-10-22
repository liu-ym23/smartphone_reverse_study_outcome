package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListViewHolder;", "Lbc0/c;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListAdapter extends RecyclerView.Adapter<TuningButtonListViewHolder> implements bc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ac0.a> f70479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bc0.a f70480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f70481c;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f70482a = null;

        static {
            f70482a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((ac0.a) r100).getType().getValue() - ((ac0.a) r101).getType().getValue();
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f70483a = null;

        static {
            f70483a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((ac0.a) r100).getType().getValue() - ((ac0.a) r101).getType().getValue();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f70479a).size();
    }

    @Override // bc0.c
    public final void j0(ac0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonData");
        Iterator r101 = ((ArrayList) this.f70479a).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (((ac0.a) r102).getType() != r100.getType()) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L13:
        if (((ac0.a) r102) != null) goto L21;
        ((ArrayList) this.f70479a).add(r100);
        CollectionsKt.sortWith(this.f70479a, a.f70482a);
        notifyDataSetChanged();
        return;
    L21:
        return;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L13
    }

    public final void y2(List<ac0.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "buttonList");
        ((ArrayList) this.f70479a).clear();
        ((ArrayList) this.f70479a).addAll(r100);
        CollectionsKt.sortWith(this.f70479a, b.f70483a);
        notifyDataSetChanged();
    }

    public TuningButtonListAdapter(bc0.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tuningButtonCallback");
        this.f70480b = r100;
        this.f70481c = r101;
        this.f70479a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        TuningButtonListViewHolder r102 = (TuningButtonListViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        ac0.a r103 = (ac0.a) ListProtector.get(this.f70479a, r101);
        r102.f70494a = r103;
        TextView r104 = (TextView) r102.f70495b.getValue();
        if (r104 == null) goto L8;
        if (r103 == null) goto L6;
        String r105 = r103.f2529b;
    L7:
        r104.setText(r105);
        goto L8
    L6:
        r105 = null;
    L8:
        Switch r106 = (Switch) r102.f70497d.getValue();
        if (r106 == null) goto L14;
        if (r103 == null) goto L12;
        boolean r107 = r103.f2530c;
    L13:
        r106.setChecked(r107);
        goto L14
    L12:
        r107 = false;
    L14:
        Switch r108 = (Switch) r102.f70497d.getValue();
        if (r108 == null) goto L21;
        if (r103 == null) goto L18;
        float r109 = r103.f2532e;
    L19:
        r108.setAlpha(r109);
        goto L21
    L18:
        r109 = 1.0f;
    L21:
        if (r102.f70499f.a() == true) goto L23;
        return;
    L23:
        if ((r101 % 2) == 0) goto L29;
        View r110 = (View) r102.f70498e.getValue();
        if (r110 == null) goto L30;
        r110.setVisibility(0);
        return;
    L30:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_ktv_common_switch_button_item_layout, r100, false);
        if (this.f70481c == false) goto L7;
        TextView r103 = (TextView) r102.findViewById(R.id.btn_list_item_title);
        if (r103 == null) goto L7;
        r103.setTextSize(13.0f);
    L7:
        Unit r104 = Unit.INSTANCE;
        return new TuningButtonListViewHolder(r102, this.f70480b);
    }

    @Override // bc0.c
    public final void m2(Function1<? super ac0.a, Unit> r110, TuningButtonType r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "preHandleButtonData");
        Intrinsics.checkNotNullParameter(r111, "tuningButtonType");
        Iterator r100 = ((ArrayList) this.f70479a).iterator();
        boolean r101 = false;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L12;
        Object r103 = r100.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r111 == ((ac0.a) r103).getType()) goto L13;
        r102 = r104;
    L13:
        int r113 = ((ArrayList) this.f70479a).size();
        if (r102 < 0) goto L37;
        if (r113 <= r102) goto L35;
        ac0.a r114 = new ac0.a(((ac0.a) ListProtector.get(this.f70479a, r102)).getType(), ((ac0.a) ListProtector.get(this.f70479a, r102)).f2529b, ((ac0.a) ListProtector.get(this.f70479a, r102)).f2530c, ((ac0.a) ListProtector.get(this.f70479a, r102)).f2531d, ((ac0.a) ListProtector.get(this.f70479a, r102)).f2532e, 32);
        r110.invoke(ListProtector.get(this.f70479a, r102));
        if (r112 == true) goto L31;
        ac0.a r115 = (ac0.a) ListProtector.get(this.f70479a, r102);
        if (r114.f2530c == r115.f2530c) goto L22;
    L29:
        r101 = true;
    L30:
        if (r101 == true) goto L31;
        return;
    L22:
        if (r114.f2532e != r115.f2532e) goto L29;
        if ((!Intrinsics.areEqual(r114.f2529b, r115.f2529b)) == true) goto L29;
        if (r114.getType() != r115.getType()) goto L29;
        if (r114.f2531d == r115.f2531d) goto L30;
    L31:
        notifyItemChanged(r102);
        return;
    L35:
        return;
    L37:
        return;
    L12:
        r102 = -1;
        goto L13
    }
}
