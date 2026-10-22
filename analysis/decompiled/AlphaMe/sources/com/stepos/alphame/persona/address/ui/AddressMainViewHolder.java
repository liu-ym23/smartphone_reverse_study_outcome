package com.stepos.alphame.persona.address.ui;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/AddressMainViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mainAddressSelected", "Landroid/widget/RadioButton;", "kotlin.jvm.PlatformType", "getMainAddressSelected", "()Landroid/widget/RadioButton;", "mainDistrict", "Landroid/widget/TextView;", "getMainDistrict", "()Landroid/widget/TextView;", "mainName", "getMainName", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AddressMainViewHolder extends RecyclerView.ViewHolder {
    private final RadioButton mainAddressSelected;
    private final TextView mainDistrict;
    private final TextView mainName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressMainViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.mainName = (TextView) itemView.findViewById(R.id.main_name);
        this.mainDistrict = (TextView) itemView.findViewById(R.id.main_district);
        this.mainAddressSelected = (RadioButton) itemView.findViewById(R.id.main_address_select);
    }

    public final RadioButton getMainAddressSelected() {
        return this.mainAddressSelected;
    }

    public final TextView getMainDistrict() {
        return this.mainDistrict;
    }

    public final TextView getMainName() {
        return this.mainName;
    }
}
