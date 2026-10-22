package com.stepos.alphame.persona.common.list;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/alphame/persona/common/list/PersonalCommonSingleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btSelect", "Landroid/widget/RadioButton;", "kotlin.jvm.PlatformType", "getBtSelect", "()Landroid/widget/RadioButton;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersonalCommonSingleViewHolder extends RecyclerView.ViewHolder {
    private final RadioButton btSelect;
    private final TextView tvTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCommonSingleViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.tvTitle = (TextView) itemView.findViewById(R.id.title);
        this.btSelect = (RadioButton) itemView.findViewById(R.id.bt_select);
    }

    public final RadioButton getBtSelect() {
        return this.btSelect;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }
}
