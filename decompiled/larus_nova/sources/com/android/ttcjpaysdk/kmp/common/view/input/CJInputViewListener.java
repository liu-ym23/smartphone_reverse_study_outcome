package com.android.ttcjpaysdk.kmp.common.view.input;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/input/CJInputViewListener;", "", "onInputTextChange", "", "text", "", "onInputRightArrowClick", "onLeftTitleListItemSelect", MapController.ITEM_LAYER_TAG, "Lcom/android/ttcjpaysdk/kmp/common/view/input/CJInputListItem;", "onAmountChange", "amount", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CJInputViewListener {
    void onAmountChange(String r100);

    void onInputRightArrowClick();

    void onInputTextChange(String r100);

    void onLeftTitleListItemSelect(CJInputListItem r100);
}
