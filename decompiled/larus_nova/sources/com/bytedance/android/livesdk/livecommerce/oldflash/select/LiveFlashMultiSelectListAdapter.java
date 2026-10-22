package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.checkbox.ECCheckBox;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/select/LiveFlashMultiSelectListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashMultiSelectListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f149709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f149710b;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f149711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECCheckBox f149712b;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f149711a = (TextView) r100.findViewById(R.id.tv_content_header);
            this.f149712b = (ECCheckBox) r100.findViewById(R.id.ec_checkbox);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFlashMultiSelectListAdapter f149713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f149714b;

        public c(LiveFlashMultiSelectListAdapter r100, k r101) {
            this.f149713a = r100;
            this.f149714b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f149713a.f149710b.invoke(this.f149714b.f149736a);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f149709a).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveFlashMultiSelectListAdapter(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickCallback");
        this.f149710b = r100;
        this.f149709a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        k r102 = (k) ListProtector.get(this.f149709a, r101);
        if ((r100 instanceof b) == false) goto L11;
        b r103 = (b) r100;
        TextView r104 = r103.f149711a;
        r104.setText(r102.f149736a);
        Context r105 = r104.getContext();
        if (r102.f149737b == false) goto L7;
        int r106 = R.color.ec_color_FE2C55;
    L8:
        r104.setTextColor(th.a.a(r105, r106));
        r103.f149712b.setChecked(r102.f149737b);
        r100.itemView.setOnClickListener(new c(this, r102));
        return;
    L7:
        r106 = R.color.ec_color_black_161823;
        goto L8
    L11:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.f149709a, r101)).getClass().getName()).toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L11;
        Context r102 = r100.getContext();
        if (r102 == null) goto L7;
        Context r103 = th.a.e(r102, true);
    L9:
        return new b(LayoutInflater.from(r103).inflate(R.layout.ec_item_multi_select, r100, false));
    L7:
        r103 = null;
        goto L9
    L11:
        throw new IllegalStateException(("Invalid type " + r101).toString());
    }
}
