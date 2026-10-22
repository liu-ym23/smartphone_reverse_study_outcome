package com.obric.ui.dialog.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.button.OButton;
import com.obric.oui.utils.StyleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/ui/dialog/action/ActionDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/ui/dialog/action/ActionDialogAdapter$SheetItemViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "items", "", "Lcom/obric/ui/dialog/action/ActionDialogItemData;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "", "SheetItemViewHolder", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActionDialogAdapter extends RecyclerView.Adapter<SheetItemViewHolder> {
    private final Context context;
    private final List<ActionDialogItemData> items;

    /* JADX INFO: compiled from: ActionDialogAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/ui/dialog/action/ActionDialogAdapter$SheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/obric/ui/dialog/action/ActionDialogAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/ui/dialog/action/ActionDialogItemData;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class SheetItemViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ActionDialogAdapter this$0;

        public SheetItemViewHolder(ActionDialogAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
        }

        public final void bind(ActionDialogItemData r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            View r1 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(r1, "itemView");
            if ((r1 instanceof OButton) == false) goto L6;
            ((OButton) r1).setText(r2.getTitle());
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SheetItemViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public ActionDialogAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.items = new ArrayList();
    }

    public final void setItems(List<ActionDialogItemData> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.items.get(r1).getButtonStyle().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SheetItemViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new SheetItemViewHolder(this, (OButton) StyleUtil.createWidgetWithStyle(this.context, ActionDialogAdapterKt.toStyleRes(r3), ActionDialogAdapter$onCreateViewHolder$view$1.INSTANCE));
    }

    public void onBindViewHolder(SheetItemViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        ActionDialogItemData r1 = this.items.get(r3);
        r2.bind(r1);
        r2.itemView.setOnClickListener(r1.getOnClickListener());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
