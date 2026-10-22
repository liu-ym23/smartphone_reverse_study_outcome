package com.android.ttcjpaysdk.base.ui.component.input;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/input/CJInputViewListener;", "", "onAmountChange", "", "amount", "", "onInputRightArrowClick", "onInputTextChange", "text", "onLeftTitleListItemSelect", MapController.ITEM_LAYER_TAG, "Lcom/android/ttcjpaysdk/base/ui/component/input/CJInputListItem;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJInputViewListener {
    void onAmountChange(String r100);

    void onInputRightArrowClick();

    void onInputTextChange(String r100);

    void onLeftTitleListItemSelect(CJInputListItem r100);
}
