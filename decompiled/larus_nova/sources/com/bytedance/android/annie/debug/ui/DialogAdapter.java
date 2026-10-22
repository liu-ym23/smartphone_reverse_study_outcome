package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/annie/debug/ui/DialogAdapter$ViewHolder;", "ViewHolder", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class DialogAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DialogItem> f39420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f39421b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/DialogAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f39422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f39423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f39424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f39425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Switch f39426e;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f39422a = (ViewGroup) r100.findViewById(R.id.info_layout);
            this.f39423b = (TextView) r100.findViewById(R.id.value);
            this.f39424c = (TextView) r100.findViewById(R.id.label);
            this.f39425d = (TextView) r100.findViewById(R.id.title);
            this.f39426e = (Switch) r100.findViewById(R.id.switch_btn);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<DialogItem> r100 = this.f39420a;
        Intrinsics.checkNotNull(r100);
        return r100.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogAdapter(List<? extends DialogItem> r100, Context r101) {
        this.f39420a = r100;
        this.f39421b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        List<DialogItem> r103 = this.f39420a;
        Intrinsics.checkNotNull(r103);
        DialogItem r104 = (DialogItem) ListProtector.get(r103, r101);
        if (r104.getType() != DialogItem.ItemType.DUMMY_TITLE) goto L6;
        TextView r105 = r102.f39425d;
        r105.setText(r104.f39427a);
        r105.setVisibility(0);
        return;
    L6:
        if (r104.f39430d == null) goto L8;
    L10:
        r102.f39422a.setVisibility(0);
        String r106 = r104.f39427a;
        if (r106 == null) goto L13;
        r102.f39424c.setText(r106);
        r102.f39424c.setVisibility(0);
    L13:
        String r107 = r104.f39428b;
        if (r107 == null) goto L16;
        r102.f39423b.setText(r107);
        r102.f39423b.setVisibility(0);
    L16:
        View.OnClickListener r108 = r104.f39430d;
        if (r108 == null) goto L19;
        r102.f39422a.setOnClickListener(r108);
    L19:
        CompoundButton.OnCheckedChangeListener r109 = r104.f39431e;
        if (r109 == null) goto L22;
        r102.f39426e.setVisibility(0);
        r102.f39426e.setChecked(r104.f39429c);
        r102.f39426e.setOnCheckedChangeListener(r109);
    L22:
        r102.f39422a.setOnLongClickListener(new c(r104, this));
        return;
    L8:
        if (r104.getType() == DialogItem.ItemType.SWITCH) goto L10;
        r104.f39430d = new b(r104, this);
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.annie_debug_dialog_map_item, r100, false));
    }
}
