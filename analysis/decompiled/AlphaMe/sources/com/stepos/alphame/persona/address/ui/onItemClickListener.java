package com.stepos.alphame.persona.address.ui;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.suggest.AppSuggestStorable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/persona/address/ui/onItemClickListener;", "", "itemClick", "", "view", "Landroid/view/View;", MapController.ITEM_LAYER_TAG, "Lcom/stepos/alphame/persona/address/data/AddressEntity;", AppSuggestStorable.COLUMN_POSITION, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface onItemClickListener {
    void itemClick(@NotNull View view, @NotNull AddressEntity item, int position);
}
