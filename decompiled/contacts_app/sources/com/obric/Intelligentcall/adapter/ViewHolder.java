package com.obric.Intelligentcall.adapter;

import android.view.View;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.SettingsTrailingView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntelligentListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/obric/Intelligentcall/adapter/ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "listItem", "Lcom/obric/oui/lisitem/OListItemSettings;", "getListItem", "()Lcom/obric/oui/lisitem/OListItemSettings;", "trailingView", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", "getTag", "", "setTag", "", SimContactsConstants.STR_TAG, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {
    private final OListItemSettings listItem;
    private final SettingsTrailingView trailingView;

    public ViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        View r3 = r2.findViewById(R.id.list_item);
        Intrinsics.checkNotNull(r3);
        OListItemSettings r4 = (OListItemSettings) r3;
        this.listItem = r4;
        this.trailingView = r4.getSettingsTrailingView();
    }

    public final OListItemSettings getListItem() {
        return this.listItem;
    }

    public final SettingsTrailingView getTrailingView() {
        return this.trailingView;
    }

    public final void setTag(Object r2) {
        this.itemView.setTag(R.id.list_item, r2);
    }

    public final Object getTag() {
        return this.itemView.getTag(R.id.list_item);
    }
}
