package com.stepos.alphame.persona.address.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvDistrict", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTvDistrict", "()Landroid/widget/TextView;", "tvName", "getTvName", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AddressViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvDistrict;
    private final TextView tvName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.tvName = (TextView) itemView.findViewById(R.id.name);
        this.tvDistrict = (TextView) itemView.findViewById(R.id.district);
    }

    public final TextView getTvDistrict() {
        return this.tvDistrict;
    }

    public final TextView getTvName() {
        return this.tvName;
    }
}
