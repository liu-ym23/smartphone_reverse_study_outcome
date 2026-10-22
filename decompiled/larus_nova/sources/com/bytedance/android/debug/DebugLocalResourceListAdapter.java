package com.bytedance.android.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/debug/DebugLocalResourceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/debug/DebugLocalResourceListAdapter$AssetHolder;", "Landroid/widget/Filterable;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AssetHolder", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugLocalResourceListAdapter extends RecyclerView.Adapter<AssetHolder> implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f42593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f42594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f42595c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/debug/DebugLocalResourceListAdapter$AssetHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AssetHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f42596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Button f42597b;

        public AssetHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            View r101 = r100.findViewById(R.id.asset_content);
            if (r101 == null) goto L11;
            this.f42596a = (TextView) r101;
            View r102 = r100.findViewById(R.id.delete_file);
            if (r102 == null) goto L9;
            this.f42597b = (Button) r102;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f42598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f42600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f42601d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f42598a == r101.f42598a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f42599b, r101.f42599b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f42600c, r101.f42600c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f42601d, r101.f42601d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f42598a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f42599b;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f42600c;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.f42601d;
            if (r109 == null) goto L14;
            r103 = r109.hashCode();
        L14:
            return r108 + r103;
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public final String toString() {
            return "AssetDebugModel(assetId=" + this.f42598a + ", assetCleanType=" + this.f42599b + ", assetSize=" + this.f42600c + ", md5=" + this.f42601d + ")";
        }

        public a(long r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "assetCleanType");
            Intrinsics.checkNotNullParameter(r102, "assetSize");
            Intrinsics.checkNotNullParameter(r103, "md5");
            this.f42598a = r100;
            this.f42599b = r101;
            this.f42600c = r102;
            this.f42601d = r103;
        }
    }

    public interface b {
        void a(String r100);
    }

    public static final class c extends Filter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DebugLocalResourceListAdapter f42602a;

        public c(DebugLocalResourceListAdapter r100) {
            this.f42602a = r100;
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
            r104.addAll(this.f42602a.f42593a);
            r102.values = r104;
        L19:
            return r102;
        L8:
            ArrayList r105 = new ArrayList();
            Iterator r106 = ((ArrayList) this.f42602a.f42593a).iterator();
        L10:
            if (r106.hasNext() == false) goto L18;
            a r107 = (a) r106.next();
            String r108 = String.valueOf(r107.f42598a) + ": " + r107.f42599b + ": " + r107.f42600c + "kb";
            if (r108 == null) goto L17;
            if (StringsKt.contains$default(StringsKt.trim(r108).toString(), r101, false, 2, null) == false) goto L10;
            r105.add(r107);
            goto L10
        L17:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L18:
            r102.values = r105;
            goto L19
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
            ((ArrayList) this.f42602a.f42594b).clear();
            ((ArrayList) this.f42602a.f42594b).addAll(r106);
        L16:
            ((ArrayList) this.f42602a.f42594b).clear();
        L17:
            this.f42602a.notifyDataSetChanged();
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return new c(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f42594b).size();
    }

    public DebugLocalResourceListAdapter() {
        this.f42593a = new ArrayList();
        this.f42594b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AssetHolder r102 = (AssetHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f42594b, r101);
        String r104 = String.valueOf(r103.f42598a) + ": " + r103.f42599b + ": " + r103.f42600c + "kb";
        if (r104 == null) goto L7;
        String r105 = StringsKt.trim(r104).toString();
        r102.f42596a.setText(r105);
        r102.f42597b.setOnClickListener(new j(r102, r103));
        r102.itemView.setOnClickListener(new k(this, r105));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        return new AssetHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_asset_preview_debug_holder, null));
    }
}
