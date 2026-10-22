package com.bytedance.android.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/debug/DebugAssetsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/debug/DebugAssetsListAdapter$AssetHolder;", "Landroid/widget/Filterable;", "<init>", "()V", "AssetHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugAssetsListAdapter extends RecyclerView.Adapter<AssetHolder> implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.live.core.resources.e> f42547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.live.core.resources.e> f42548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f42549c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/debug/DebugAssetsListAdapter$AssetHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AssetHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f42550a;

        public AssetHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            View r101 = r100.findViewById(R.id.asset_content);
            if (r101 == null) goto L7;
            this.f42550a = (TextView) r101;
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public interface a {
        void a(com.bytedance.android.live.core.resources.e r100);
    }

    public static final class b extends Filter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugAssetsListAdapter f42551a;

        public b(DebugAssetsListAdapter r100) {
            this.f42551a = r100;
        }

        @Override // android.widget.Filter
        public final Filter.FilterResults performFiltering(CharSequence r100) {
            String r101 = String.valueOf(r100);
            Filter.FilterResults r102 = new Filter.FilterResults();
            if (r101.length() != 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L8;
            ArrayList r104 = new ArrayList();
            r104.addAll(this.f42551a.f42547a);
            r102.values = r104;
        L15:
            return r102;
        L8:
            ArrayList r105 = new ArrayList();
            Iterator r106 = ((ArrayList) this.f42551a.f42547a).iterator();
        L10:
            if (r106.hasNext() == false) goto L14;
            com.bytedance.android.live.core.resources.e r107 = (com.bytedance.android.live.core.resources.e) r106.next();
            if (StringsKt.contains$default(String.valueOf(r107.getId()) + r107.getName(), r101, false, 2, null) == false) goto L10;
            r105.add(r107);
            goto L10
        L14:
            r102.values = r105;
            goto L15
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.widget.Filter
        public final void publishResults(CharSequence r100, Filter.FilterResults r101) {
            Object r102 = null;
            if (r101 == null) goto L5;
            Object r103 = r101.values;
        L6:
            if (r103 == null) goto L17;
            Object r104 = r101.values;
            if (TypeIntrinsics.isMutableList(r104) == false) goto L11;
            r102 = r104;
        L11:
            List r105 = (List) r102;
            if (r105 == null) goto L16;
            List r106 = r105;
            if ((!r106.isEmpty()) == false) goto L16;
            ((ArrayList) this.f42551a.f42548b).clear();
            ((ArrayList) this.f42551a.f42548b).addAll(r106);
        L16:
            ((ArrayList) this.f42551a.f42548b).clear();
        L17:
            this.f42551a.notifyDataSetChanged();
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return new b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f42548b).size();
    }

    public DebugAssetsListAdapter() {
        this.f42547a = new ArrayList();
        this.f42548b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AssetHolder r102 = (AssetHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = r102.f42550a;
        StringBuilder r104 = new StringBuilder();
        r104.append(String.valueOf(((com.bytedance.android.live.core.resources.e) ListProtector.get(this.f42548b, r101)).getId()));
        r104.append(": ");
        String r105 = ((com.bytedance.android.live.core.resources.e) ListProtector.get(this.f42548b, r101)).getName();
        if (r105 == null) goto L5;
        String r106 = StringsKt.trim(r105).toString();
    L6:
        r104.append(r106);
        r103.setText(r104.toString());
        r102.itemView.setOnClickListener(new com.bytedance.android.debug.a(this, r101));
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new AssetHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_gift_preview_debug_holder, null));
    }
}
