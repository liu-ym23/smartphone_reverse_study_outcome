package com.obric.settings;

import android.view.View;
import android.widget.TextView;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallRecordList.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/obric/settings/ViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "createTime", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCreateTime", "()Landroid/widget/TextView;", "duration", "getDuration", "listItem", "Lcom/obric/oui/lisitem/OListItemGeneral;", "getListItem", "()Lcom/obric/oui/lisitem/OListItemGeneral;", "getTag", "", "setTag", "", SimContactsConstants.STR_TAG, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView createTime;
    private final TextView duration;
    private final OListItemGeneral listItem;

    public ViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.listItem = (OListItemGeneral) r2.findViewById(R.id.list_item);
        this.duration = (TextView) r2.findViewById(R.id.duration);
        this.createTime = (TextView) r2.findViewById(R.id.create_time);
    }

    public final OListItemGeneral getListItem() {
        return this.listItem;
    }

    public final TextView getDuration() {
        return this.duration;
    }

    public final TextView getCreateTime() {
        return this.createTime;
    }

    public final void setTag(Object r2) {
        this.itemView.setTag(R.id.list_item, r2);
    }

    public final Object getTag() {
        return this.itemView.getTag(R.id.list_item);
    }
}
