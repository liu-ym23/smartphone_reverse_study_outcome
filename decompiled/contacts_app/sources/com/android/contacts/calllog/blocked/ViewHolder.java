package com.android.contacts.calllog.blocked;

import android.view.View;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockedCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/android/contacts/calllog/blocked/ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "listItem", "Lcom/android/contacts/calllog/blocked/BlockListItemCardView;", "getListItem", "()Lcom/android/contacts/calllog/blocked/BlockListItemCardView;", "getTag", "", "setTag", "", SimContactsConstants.STR_TAG, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {
    private final BlockListItemCardView listItem;

    public ViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        View r3 = r2.findViewById(R.id.list_item);
        Intrinsics.checkNotNull(r3);
        this.listItem = (BlockListItemCardView) r3;
    }

    public final BlockListItemCardView getListItem() {
        return this.listItem;
    }

    public final void setTag(Object r2) {
        this.itemView.setTag(R.id.list_item, r2);
    }

    public final Object getTag() {
        return this.itemView.getTag(R.id.list_item);
    }
}
