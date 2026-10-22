package com.stepos.alphame.persona.address.ui;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.IntKt;
import com.stepos.alphame.utils.RecyclerViewAdapterKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0016\u0010)\u001a\u00020\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100!H\u0007J\u0006\u0010+\u001a\u00020\u001fJ\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressMainListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/alphame/persona/address/ui/AddressMainViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "autoLearningState", "", "listener", "Lcom/stepos/alphame/persona/address/ui/onItemClickListener;", "(Landroidx/recyclerview/widget/RecyclerView;ZLcom/stepos/alphame/persona/address/ui/onItemClickListener;)V", "_selectedIndex", "", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "()Z", "<set-?>", "", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "data", "getData", "()Ljava/util/List;", "setData$app_release", "(Ljava/util/List;)V", "getListener", "()Lcom/stepos/alphame/persona/address/ui/onItemClickListener;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "selectedIndex", "getSelectedIndex", "()I", "getItemCount", "initSelectedIndex", "", "dataList", "", "onBindViewHolder", "holder", AppSuggestStorable.COLUMN_POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "updateItemWhenRequestCurrentLocation", "updatePreSelectedItem", "currentViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AddressMainListAdapter extends RecyclerView.Adapter<AddressMainViewHolder> {
    private int _selectedIndex;
    private final boolean autoLearningState;

    @NotNull
    private List<AddressEntity> data;

    @NotNull
    private final onItemClickListener listener;

    @NotNull
    private final RecyclerView recyclerView;

    public AddressMainListAdapter(@NotNull RecyclerView recyclerView, boolean z4, @NotNull onItemClickListener listener) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.recyclerView = recyclerView;
        this.autoLearningState = z4;
        this.listener = listener;
        this._selectedIndex = -1;
        this.data = new ArrayList();
    }

    private final void initSelectedIndex(List<AddressEntity> dataList) {
        int size = dataList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (dataList.get(i4).isChecked()) {
                this._selectedIndex = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(AddressMainListAdapter this$0, int i4, AddressMainViewHolder holder, AddressEntity item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.updatePreSelectedItem(i4, holder);
        onItemClickListener onitemclicklistener = this$0.listener;
        Intrinsics.checkNotNull(view);
        onitemclicklistener.itemClick(view, item, i4);
    }

    private final void updatePreSelectedItem(int position, RecyclerView.ViewHolder currentViewHolder) {
        try {
            AlphaMeLogger.debugLog("Personal", "selected index " + this._selectedIndex);
            if (get_selectedIndex() != position) {
                this.data.get(get_selectedIndex()).setChecked(false);
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(get_selectedIndex());
                if (viewHolderFindViewHolderForAdapterPosition == null) {
                    AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "not visible, notify update");
                    notifyItemChanged(get_selectedIndex());
                } else if (viewHolderFindViewHolderForAdapterPosition instanceof AddressMainViewHolder) {
                    ((AddressMainViewHolder) viewHolderFindViewHolderForAdapterPosition).getMainAddressSelected().setChecked(false);
                }
                this._selectedIndex = position;
                if (currentViewHolder instanceof AddressMainViewHolder) {
                    ((AddressMainViewHolder) currentViewHolder).getMainAddressSelected().setChecked(true);
                }
                this.data.get(get_selectedIndex()).setChecked(true);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final boolean getAutoLearningState() {
        return this.autoLearningState;
    }

    @NotNull
    public final List<AddressEntity> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @NotNull
    public final onItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* renamed from: getSelectedIndex, reason: from getter */
    public final int get_selectedIndex() {
        return this._selectedIndex;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<AddressEntity> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        initSelectedIndex(this.data);
        notifyDataSetChanged();
    }

    public final void setData$app_release(@NotNull List<AddressEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final void updateItemWhenRequestCurrentLocation() {
        try {
            AlphaMeLogger.debugLog("Personal", "updateItemWhenRequestCurrentLocation");
            if (get_selectedIndex() != 1) {
                this.data.get(get_selectedIndex()).setChecked(false);
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(get_selectedIndex());
                if (viewHolderFindViewHolderForAdapterPosition == null) {
                    notifyItemChanged(get_selectedIndex());
                } else if (viewHolderFindViewHolderForAdapterPosition instanceof AddressMainViewHolder) {
                    ((AddressMainViewHolder) viewHolderFindViewHolderForAdapterPosition).getMainAddressSelected().setChecked(false);
                }
                this._selectedIndex = 1;
                this.data.get(get_selectedIndex()).setChecked(true);
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = this.recyclerView.findViewHolderForAdapterPosition(get_selectedIndex());
                if (viewHolderFindViewHolderForAdapterPosition2 == null || !(viewHolderFindViewHolderForAdapterPosition2 instanceof AddressMainViewHolder)) {
                    notifyItemChanged(get_selectedIndex());
                } else {
                    ((AddressMainViewHolder) viewHolderFindViewHolderForAdapterPosition2).getMainAddressSelected().setChecked(true);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final AddressMainViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final AddressEntity addressEntity = this.data.get(position);
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "onBindViewHolder item " + addressEntity);
        if (this.autoLearningState && addressEntity.getType() == PersonalDataType.AUTO.getType()) {
            holder.getMainName().setText(ApplicationImpl.getApplication().getString(R.string.automatic_learning_address));
            holder.getMainDistrict().setText(TextUtils.isEmpty(addressEntity.getName()) ? ApplicationImpl.getApplication().getString(R.string.learning) : addressEntity.getName());
        } else {
            holder.getMainName().setText(addressEntity.getName());
            holder.getMainDistrict().setText(addressEntity.getDistrict());
        }
        holder.getMainAddressSelected().setChecked(addressEntity.isChecked());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.alphame.persona.address.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressMainListAdapter.onBindViewHolder$lambda$0(this.f11198a, position, holder, addressEntity, view);
            }
        });
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        RecyclerViewAdapterKt.setItemViewPadding(position, itemView, this.data.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public AddressMainViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AlphaMeLogger.debugLog("Personal", "viewType " + viewType);
        return new AddressMainViewHolder(IntKt.inflate$default(R.layout.adapter_main_address_item, parent, false, 2, null));
    }
}
