package com.stepos.widget.dialog;

import Z8.r;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.widget.R;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00016Bk\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017BO\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0019BO\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u001bJ#\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u00020%2\n\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010)R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010*R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010,R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010-R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010.R\u001c\u00101\u001a\n 0*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010)R\u0014\u00104\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010)R\u0014\u00105\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010)¨\u00067"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter$MultiLineViewHolder;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "Landroid/content/Context;", "context", "", "itemLayoutRes", "", "Landroid/util/Pair;", "", "entries", "", "isMultiSelect", "selectedPosition", "", "selectedPositions", "Landroid/content/DialogInterface$OnClickListener;", "onClickListener", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "onMultiChoiceClickListener", "<init>", "(Landroid/content/DialogInterface;Landroid/content/Context;ILjava/util/List;ZI[ZLandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnMultiChoiceClickListener;)V", "checkedItem", "(Landroid/content/DialogInterface;Landroid/content/Context;ILjava/util/List;ILandroid/content/DialogInterface$OnClickListener;)V", "checkedItems", "(Landroid/content/DialogInterface;Landroid/content/Context;ILjava/util/List;[ZLandroid/content/DialogInterface$OnMultiChoiceClickListener;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter$MultiLineViewHolder;", "getItemCount", "()I", "holder", "position", "LY8/t;", "onBindViewHolder", "(Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter$MultiLineViewHolder;I)V", "Landroid/content/DialogInterface;", "I", "Ljava/util/List;", "Z", "[Z", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnMultiChoiceClickListener;", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "inflater", "Landroid/view/LayoutInflater;", "titleColor", "detailColor", "selectedColor", "MultiLineViewHolder", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDialogMultiLineAdapter extends RecyclerView.Adapter<MultiLineViewHolder> {
    private final int detailColor;
    private final DialogInterface dialog;
    private final List<Pair<String, String>> entries;
    private final LayoutInflater inflater;
    private final boolean isMultiSelect;
    private final int itemLayoutRes;
    private final DialogInterface.OnClickListener onClickListener;
    private final DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener;
    private final int selectedColor;
    private int selectedPosition;
    private final boolean[] selectedPositions;
    private final int titleColor;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter$MultiLineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/stepos/widget/dialog/StepOSCheckableLayout;", "itemView", "<init>", "(Lcom/stepos/widget/dialog/StepOSDialogMultiLineAdapter;Lcom/stepos/widget/dialog/StepOSCheckableLayout;)V", "", "checked", "LY8/t;", "bindChecked", "(Z)V", "applyTextColors", Parameters.ROOT, "Lcom/stepos/widget/dialog/StepOSCheckableLayout;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "detail", "getDetail", "Landroid/widget/CheckBox;", "checkBox", "Landroid/widget/CheckBox;", "Landroid/widget/ImageView;", "checkMark", "Landroid/widget/ImageView;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class MultiLineViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final ImageView checkMark;
        private final TextView detail;
        private final StepOSCheckableLayout root;
        final /* synthetic */ StepOSDialogMultiLineAdapter this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiLineViewHolder(StepOSDialogMultiLineAdapter stepOSDialogMultiLineAdapter, StepOSCheckableLayout itemView) {
            super(itemView);
            kotlin.jvm.internal.p.i(itemView, "itemView");
            this.this$0 = stepOSDialogMultiLineAdapter;
            this.root = itemView;
            View viewFindViewById = itemView.findViewById(R.id.stepos_dialog_multi_line_title);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.stepos_dialog_multi_line_detail);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            this.detail = (TextView) viewFindViewById2;
            this.checkBox = (CheckBox) itemView.findViewById(R.id.stepos_dialog_multi_line_check_box);
            this.checkMark = (ImageView) itemView.findViewById(R.id.stepos_dialog_multi_line_check_mark);
        }

        public final void applyTextColors(boolean checked) {
            TextView textView = this.title;
            StepOSDialogMultiLineAdapter stepOSDialogMultiLineAdapter = this.this$0;
            textView.setTextColor(checked ? stepOSDialogMultiLineAdapter.selectedColor : stepOSDialogMultiLineAdapter.titleColor);
            TextView textView2 = this.detail;
            StepOSDialogMultiLineAdapter stepOSDialogMultiLineAdapter2 = this.this$0;
            textView2.setTextColor(checked ? stepOSDialogMultiLineAdapter2.selectedColor : stepOSDialogMultiLineAdapter2.detailColor);
        }

        public final void bindChecked(boolean checked) {
            this.root.setChecked(checked);
            CheckBox checkBox = this.checkBox;
            if (checkBox != null) {
                checkBox.setChecked(checked);
            }
            ImageView imageView = this.checkMark;
            if (imageView != null) {
                imageView.setVisibility(checked ? 0 : 4);
            }
            this.root.setSelected(checked);
        }

        public final TextView getDetail() {
            return this.detail;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StepOSDialogMultiLineAdapter(DialogInterface dialogInterface, Context context, int i10, List<? extends Pair<String, String>> list, boolean z10, int i11, boolean[] zArr, DialogInterface.OnClickListener onClickListener, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this.dialog = dialogInterface;
        this.itemLayoutRes = i10;
        this.entries = list;
        this.isMultiSelect = z10;
        this.selectedPosition = i11;
        this.selectedPositions = zArr;
        this.onClickListener = onClickListener;
        this.onMultiChoiceClickListener = onMultiChoiceClickListener;
        this.inflater = LayoutInflater.from(context);
        this.titleColor = androidx.core.content.a.c(context, R.color.stepos_dialog_list_item_text);
        this.detailColor = androidx.core.content.a.c(context, R.color.stepos_dialog_list_item_detail_text);
        this.selectedColor = androidx.core.content.a.c(context, R.color.stepos_dialog_list_item_text_selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MultiLineViewHolder multiLineViewHolder, StepOSDialogMultiLineAdapter stepOSDialogMultiLineAdapter, View view) {
        Boolean boolG0;
        int bindingAdapterPosition = multiLineViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        if (!stepOSDialogMultiLineAdapter.isMultiSelect) {
            stepOSDialogMultiLineAdapter.selectedPosition = bindingAdapterPosition;
            DialogInterface.OnClickListener onClickListener = stepOSDialogMultiLineAdapter.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(stepOSDialogMultiLineAdapter.dialog, bindingAdapterPosition);
            }
            stepOSDialogMultiLineAdapter.notifyDataSetChanged();
            return;
        }
        boolean[] zArr = stepOSDialogMultiLineAdapter.selectedPositions;
        boolean z10 = !((zArr == null || (boolG0 = r.g0(zArr, bindingAdapterPosition)) == null) ? false : boolG0.booleanValue());
        boolean[] zArr2 = stepOSDialogMultiLineAdapter.selectedPositions;
        if (zArr2 != null) {
            zArr2[bindingAdapterPosition] = z10;
        }
        multiLineViewHolder.bindChecked(z10);
        multiLineViewHolder.applyTextColors(z10);
        DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = stepOSDialogMultiLineAdapter.onMultiChoiceClickListener;
        if (onMultiChoiceClickListener != null) {
            onMultiChoiceClickListener.onClick(stepOSDialogMultiLineAdapter.dialog, bindingAdapterPosition, z10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.entries.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MultiLineViewHolder holder, int position) {
        kotlin.jvm.internal.p.i(holder, "holder");
        Pair<String, String> pair = this.entries.get(position);
        holder.getTitle().setText((CharSequence) pair.first);
        holder.getDetail().setText((CharSequence) pair.second);
        boolean zD = false;
        if (this.isMultiSelect) {
            boolean[] zArr = this.selectedPositions;
            if (zArr != null) {
                zD = kotlin.jvm.internal.p.d(r.g0(zArr, position), Boolean.TRUE);
            }
        } else if (position == this.selectedPosition) {
            zD = true;
        }
        holder.bindChecked(zD);
        holder.applyTextColors(zD);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.dialog.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSDialogMultiLineAdapter.onBindViewHolder$lambda$0(holder, this, view);
            }
        });
        holder.itemView.setContentDescription(pair.first + " " + pair.second);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MultiLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        kotlin.jvm.internal.p.i(parent, "parent");
        View viewInflate = this.inflater.inflate(this.itemLayoutRes, parent, false);
        kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type com.stepos.widget.dialog.StepOSCheckableLayout");
        return new MultiLineViewHolder(this, (StepOSCheckableLayout) viewInflate);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSDialogMultiLineAdapter(DialogInterface dialog, Context context, int i10, List<? extends Pair<String, String>> entries, int i11, DialogInterface.OnClickListener onClickListener) {
        this(dialog, context, i10, entries, false, i11, null, onClickListener, null);
        kotlin.jvm.internal.p.i(dialog, "dialog");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(entries, "entries");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSDialogMultiLineAdapter(DialogInterface dialog, Context context, int i10, List<? extends Pair<String, String>> entries, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        this(dialog, context, i10, entries, true, -1, checkedItems, null, onMultiChoiceClickListener);
        kotlin.jvm.internal.p.i(dialog, "dialog");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(entries, "entries");
        kotlin.jvm.internal.p.i(checkedItems, "checkedItems");
    }
}
