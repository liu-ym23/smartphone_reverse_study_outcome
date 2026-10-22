package com.stepos.alphame.persona.common.list;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.address.ui.a;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.IntKt;
import com.stepos.alphame.utils.RecyclerViewAdapterKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0016\u0010\"\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001bH\u0007J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/stepos/alphame/persona/common/list/PersonalCommonListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "_selectedIndex", "", "<set-?>", "", "Lcom/stepos/alphame/persona/common/list/PersonalCommonEntity;", "data", "getData", "()Ljava/util/List;", "setData$app_release", "(Ljava/util/List;)V", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "selectedIndex", "getSelectedIndex", "()I", "getItemCount", "getItemViewType", AppSuggestStorable.COLUMN_POSITION, "initSelectedIndex", "", "dataList", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "updatePreSelectedItem", "currentViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersonalCommonListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int _selectedIndex;

    @NotNull
    private List<PersonalCommonEntity> data;

    @NotNull
    private final RecyclerView recyclerView;

    public PersonalCommonListAdapter(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this._selectedIndex = -1;
        this.data = new ArrayList();
    }

    private final void initSelectedIndex(List<PersonalCommonEntity> dataList) {
        int size = dataList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (dataList.get(i4).isChecked()) {
                this._selectedIndex = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PersonalCommonListAdapter this$0, int i4, PersonalCommonSingleViewHolder singleHolder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(singleHolder, "$singleHolder");
        this$0.updatePreSelectedItem(i4, singleHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(PersonalCommonListAdapter this$0, int i4, PersonalCommonDoubleViewHolder doubleHolder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(doubleHolder, "$doubleHolder");
        this$0.updatePreSelectedItem(i4, doubleHolder);
    }

    private final void updatePreSelectedItem(int position, RecyclerView.ViewHolder currentViewHolder) {
        if (get_selectedIndex() != position) {
            if (get_selectedIndex() >= 0) {
                this.data.get(get_selectedIndex()).setChecked(false);
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(get_selectedIndex());
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                notifyItemChanged(get_selectedIndex());
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof PersonalCommonSingleViewHolder) {
                ((PersonalCommonSingleViewHolder) viewHolderFindViewHolderForAdapterPosition).getBtSelect().setChecked(false);
            } else if (viewHolderFindViewHolderForAdapterPosition instanceof PersonalCommonDoubleViewHolder) {
                ((PersonalCommonDoubleViewHolder) viewHolderFindViewHolderForAdapterPosition).getBtSelect().setChecked(false);
            }
            this._selectedIndex = position;
            if (currentViewHolder instanceof PersonalCommonSingleViewHolder) {
                ((PersonalCommonSingleViewHolder) currentViewHolder).getBtSelect().setChecked(true);
            } else if (currentViewHolder instanceof PersonalCommonDoubleViewHolder) {
                ((PersonalCommonDoubleViewHolder) currentViewHolder).getBtSelect().setChecked(true);
            }
            if (get_selectedIndex() >= 0) {
                this.data.get(get_selectedIndex()).setChecked(true);
            }
        }
    }

    @NotNull
    public final List<PersonalCommonEntity> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        PersonalCommonEntity personalCommonEntity = this.data.get(position);
        AlphaMeLogger.debugLog("Personal", "viewType " + personalCommonEntity.getType());
        return personalCommonEntity.getType();
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* renamed from: getSelectedIndex, reason: from getter */
    public final int get_selectedIndex() {
        return this._selectedIndex;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PersonalCommonEntity personalCommonEntity = this.data.get(position);
        AlphaMeLogger.debugLog("Personal", "item " + personalCommonEntity);
        if (personalCommonEntity.getType() == CommonEntityType.SINGLE.getType()) {
            PersonalCommonSingleViewHolder personalCommonSingleViewHolder = (PersonalCommonSingleViewHolder) holder;
            personalCommonSingleViewHolder.getTvTitle().setText(personalCommonEntity.getTitle());
            personalCommonSingleViewHolder.getBtSelect().setChecked(personalCommonEntity.isChecked());
            if (personalCommonEntity.isChecked()) {
                this._selectedIndex = personalCommonSingleViewHolder.getAdapterPosition();
            }
            personalCommonSingleViewHolder.itemView.setOnClickListener(new a(this, position, personalCommonSingleViewHolder, 1));
        } else {
            PersonalCommonDoubleViewHolder personalCommonDoubleViewHolder = (PersonalCommonDoubleViewHolder) holder;
            personalCommonDoubleViewHolder.getTvTitle().setText(personalCommonEntity.getTitle());
            personalCommonDoubleViewHolder.getTvContent().setText(personalCommonEntity.getContent());
            personalCommonDoubleViewHolder.getBtSelect().setChecked(personalCommonEntity.isChecked());
            if (personalCommonEntity.isChecked()) {
                this._selectedIndex = personalCommonDoubleViewHolder.getAdapterPosition();
            }
            personalCommonDoubleViewHolder.itemView.setOnClickListener(new a(this, position, personalCommonDoubleViewHolder, 2));
        }
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        RecyclerViewAdapterKt.setItemViewPadding(position, itemView, this.data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AlphaMeLogger.debugLog("Personal", "viewType " + viewType);
        return viewType == CommonEntityType.DOUBLE.getType() ? new PersonalCommonDoubleViewHolder(IntKt.inflate$default(R.layout.adapter_personal_common_double_item, parent, false, 2, null)) : new PersonalCommonSingleViewHolder(IntKt.inflate$default(R.layout.adapter_personal_common_single_item, parent, false, 2, null));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<PersonalCommonEntity> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        initSelectedIndex(this.data);
        notifyDataSetChanged();
    }

    public final void setData$app_release(@NotNull List<PersonalCommonEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }
}
