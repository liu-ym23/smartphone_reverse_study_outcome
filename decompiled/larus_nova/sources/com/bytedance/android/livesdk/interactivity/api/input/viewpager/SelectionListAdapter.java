package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "PageSelectionViewHolder", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SelectionListAdapter extends RecyclerView.Adapter<PageSelectionViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super Integer, ? super c, Unit> f133267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f133268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<Integer> f133269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f133270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f133271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f133272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<c> f133273g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0096\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public class PageSelectionViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f133274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectionListAdapter f133275b;

        public void T3(boolean r100) {
            if (r100 == false) goto L5;
            ((TextView) this.itemView.findViewById(R.id.section_title)).setTextColor(this.f133275b.f133270d);
            return;
        L5:
            ((TextView) this.itemView.findViewById(R.id.section_title)).setTextColor(this.f133275b.f133271e);
        }

        public PageSelectionViewHolder(SelectionListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f133275b = r100;
            super(r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectionListAdapter f133276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PageSelectionViewHolder f133278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f133279d;

        public a(SelectionListAdapter r100, int r101, PageSelectionViewHolder r102, c r103) {
            this.f133276a = r100;
            this.f133277b = r101;
            this.f133278c = r102;
            this.f133279d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SelectionListAdapter r101 = this.f133276a;
            int r102 = r101.f133268b;
            if (r102 != this.f133277b) goto L5;
            return;
        L5:
            r101.f133269c.remove(Integer.valueOf(r102));
            SelectionListAdapter r103 = this.f133276a;
            RecyclerView.ViewHolder r104 = r103.f133272f.findViewHolderForLayoutPosition(r103.f133268b);
            if ((r104 instanceof PageSelectionViewHolder) == true) goto L8;
            r104 = null;
        L8:
            PageSelectionViewHolder r105 = (PageSelectionViewHolder) r104;
            if (r105 == null) goto L11;
            r105.T3(false);
        L12:
            SelectionListAdapter r106 = this.f133276a;
            int r107 = this.f133277b;
            int r108 = r106.f133273g.size();
            if (r107 < 0) goto L17;
            if (r108 <= r107) goto L17;
            ((c) ListProtector.get(r106.f133273g, r107)).c();
        L17:
            this.f133278c.T3(true);
            SelectionListAdapter r109 = this.f133276a;
            r109.f133268b = this.f133278c.getAdapterPosition();
            SelectionListAdapter r110 = this.f133276a;
            r110.f133269c.add(Integer.valueOf(r110.f133268b));
            Function2<? super Integer, ? super c, Unit> r111 = this.f133276a.f133267a;
            if (r111 == null) goto L20;
            Unit r112 = r111.invoke(Integer.valueOf(this.f133278c.getAdapterPosition()), this.f133279d);
        L20:
            SelectionListAdapter r113 = this.f133276a;
            int r114 = this.f133277b;
            int r115 = r113.f133273g.size();
            if (r114 < 0) goto L27;
            if (r115 <= r114) goto L26;
            ((c) ListProtector.get(r113.f133273g, r114)).b();
            return;
        L26:
            return;
        L27:
            return;
        L11:
            SelectionListAdapter r116 = this.f133276a;
            int r117 = r116.f133268b;
            r116.notifyItemChanged(r117, ListProtector.get(r116.f133273g, r117));
            goto L12
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f133273g.size();
    }

    public PageSelectionViewHolder z2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PageSelectionViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_normal_item_section, r100, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectionListAdapter(RecyclerView r100, List<? extends c> r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f133272f = r100;
        this.f133273g = r101;
        this.f133269c = new LinkedHashSet();
        this.f133270d = ColorProtector.parseColor("#161823");
        this.f133271e = ColorProtector.parseColor("#99161823");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((PageSelectionViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100);
    }

    public final void y2(PageSelectionViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        c r102 = (c) ListProtector.get(this.f133273g, r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "selection");
        r100.f133274a = r102;
        r100.T3(r100.f133275b.f133269c.contains(Integer.valueOf(r100.getAdapterPosition())));
        TextView r103 = (TextView) r100.itemView.findViewById(R.id.section_title);
        c r104 = r100.f133274a;
        if (r104 == null) goto L5;
        CharSequence r105 = r104.a();
    L6:
        r103.setText(r105);
        r100.itemView.setOnClickListener(new a(this, r101, r100, r102));
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        PageSelectionViewHolder r103 = (PageSelectionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.isEmpty() == false) goto L5;
        y2(r103, r101);
        return;
    L5:
        r103.T3(this.f133269c.contains(Integer.valueOf(r101)));
    }
}
