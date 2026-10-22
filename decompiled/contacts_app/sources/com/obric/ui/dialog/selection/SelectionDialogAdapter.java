package com.obric.ui.dialog.selection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionDialogAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rJ\u0014\u0010\u0018\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u0019J \u0010\u001a\u001a\u00020\u000e2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/ui/dialog/selection/SelectionDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/ui/dialog/selection/SelectionDialogAdapter$DialogItemViewHolder;", "context", "Landroid/content/Context;", "selectionType", "Lcom/obric/ui/dialog/selection/SelectionType;", "(Landroid/content/Context;Lcom/obric/ui/dialog/selection/SelectionType;)V", "items", "", "Lcom/obric/ui/dialog/selection/SelectionDialogItemData;", "onItemClickListener", "Lkotlin/Function2;", "", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "setItems", "", "setOnItemClickListener", "listener", "DialogItemViewHolder", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionDialogAdapter extends RecyclerView.Adapter<DialogItemViewHolder> {
    private final Context context;
    private final List<SelectionDialogItemData> items;
    private Function2<? super SelectionDialogItemData, ? super Integer, Unit> onItemClickListener;
    private final SelectionType selectionType;

    /* JADX INFO: compiled from: SelectionDialogAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/obric/ui/dialog/selection/SelectionDialogAdapter$DialogItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/obric/ui/dialog/selection/SelectionDialogAdapter;Landroid/view/View;)V", "bind", "", "item", "Lcom/obric/ui/dialog/selection/SelectionDialogItemData;", "showDivider", "show", "", "toggleCheckState", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DialogItemViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SelectionDialogAdapter this$0;

        public DialogItemViewHolder(SelectionDialogAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.this$0 = r2;
            super(r3);
        }

        public final void bind(SelectionDialogItemData r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            OSelectionItemView r3 = (OSelectionItemView) r1;
            r3.setTitle(r2.getTitle());
            r3.setSubtitle(r2.getSubTitle());
            r3.setChecked(r2.isChecked());
        }

        public final void showDivider(boolean r2) {
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            ((OSelectionItemView) r1).showDivider(r2);
        }

        public final boolean toggleCheckState() {
            View r1 = this.itemView;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.dialog.v2.selection.OSelectionItemView");
            OSelectionItemView r2 = (OSelectionItemView) r1;
            r2.toggleCheckState();
            return r2.isChecked();
        }
    }

    /* JADX INFO: compiled from: SelectionDialogAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SelectionType.values().length];
            r0[SelectionType.MULTI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SelectionType.SINGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SelectionType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$lQRpDOxaN6oc3K4XFjjHOHIkO5Y(SelectionDialogItemData r0, DialogItemViewHolder r1, SelectionDialogAdapter r2, int r3, View r4) {
        onBindViewHolder$lambda$1(r0, r1, r2, r3, r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((DialogItemViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public SelectionDialogAdapter(Context r2, SelectionType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "selectionType");
        this.context = r2;
        this.selectionType = r3;
        this.items = new ArrayList();
    }

    public final void setItems(List<SelectionDialogItemData> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public final void selectItem(int r3) {
        SelectionDialogItemData r0 = (SelectionDialogItemData) CollectionsKt.getOrNull(this.items, r3);
        if (r0 == null) goto L5;
        r0.setChecked(true);
    L5:
        notifyItemChanged(r3);
    }

    public final void setOnItemClickListener(Function2<? super SelectionDialogItemData, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.onItemClickListener = r2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DialogItemViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        OSelectionItemView r5 = new OSelectionItemView(this.context, null, 2, null);
        SelectionType r6 = this.selectionType;
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 == 1) goto L11;
        if (r7 != 2) goto L6;
        OSelectionItemView.Companion.CheckStyle r8 = OSelectionItemView.Companion.CheckStyle.ICON;
    L12:
        r5.setCheckStyle(r8);
        return new DialogItemViewHolder(this, r5);
    L6:
        if (r7 != 3) goto L9;
        r8 = OSelectionItemView.Companion.CheckStyle.NONE;
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r8 = OSelectionItemView.Companion.CheckStyle.CHECKBOX;
        goto L12
    }

    public void onBindViewHolder(final DialogItemViewHolder r4, final int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        final SelectionDialogItemData r0 = this.items.get(r5);
        r4.bind(r0);
        r4.showDivider(false);
        r4.itemView.setOnClickListener(new SelectionDialogAdapter$$ExternalSyntheticLambda0(r0, r4, this, r5));
    }

    private static final void onBindViewHolder$lambda$1(SelectionDialogItemData r0, DialogItemViewHolder r1, SelectionDialogAdapter r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r0, "$item");
        Intrinsics.checkNotNullParameter(r1, "$holder");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r0.setChecked(r1.toggleCheckState());
        Function2<? super SelectionDialogItemData, ? super Integer, Unit> r5 = r2.onItemClickListener;
        if (r5 == null) goto L6;
        r5.invoke(r0, Integer.valueOf(r3));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
