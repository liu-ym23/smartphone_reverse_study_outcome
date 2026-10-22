package com.stepos.alphame.persona.address.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.stepos.alphame.R;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.IntKt;
import com.stepos.alphame.utils.RecyclerViewAdapterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "Lcom/stepos/alphame/persona/address/ui/AddressViewHolder;", "listener", "Lcom/stepos/alphame/persona/address/ui/onItemClickListener;", "(Lcom/stepos/alphame/persona/address/ui/onItemClickListener;)V", "getListener", "()Lcom/stepos/alphame/persona/address/ui/onItemClickListener;", "onBindViewHolder", "", "holder", AppSuggestStorable.COLUMN_POSITION, "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "list", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AddressListAdapter extends ListAdapter<AddressEntity, AddressViewHolder> {

    @NotNull
    private static final AddressListAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<AddressEntity>() { // from class: com.stepos.alphame.persona.address.ui.AddressListAdapter$Companion$DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull AddressEntity oldItem, @NotNull AddressEntity newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getName(), newItem.getName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull AddressEntity oldItem, @NotNull AddressEntity newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    @NotNull
    private final onItemClickListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressListAdapter(@NotNull onItemClickListener listener) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(AddressListAdapter this$0, AddressEntity addressEntity, int i4, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onItemClickListener onitemclicklistener = this$0.listener;
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(addressEntity);
        onitemclicklistener.itemClick(view, addressEntity, i4);
    }

    @NotNull
    public final onItemClickListener getListener() {
        return this.listener;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<AddressEntity> list) {
        super.submitList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull AddressViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AddressEntity item = getItem(position);
        AlphaMeLogger.debugLog("Personal", "item " + item);
        holder.getTvName().setText(item.getName());
        holder.getTvDistrict().setText(item.getDistrict());
        holder.itemView.setOnClickListener(new a(this, item, position));
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        RecyclerViewAdapterKt.setItemViewPadding(position, itemView, getCurrentList().size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public AddressViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        AlphaMeLogger.debugLog("Personal", "viewType " + viewType);
        return new AddressViewHolder(IntKt.inflate$default(R.layout.adapter_address_item, parent, false, 2, null));
    }
}
