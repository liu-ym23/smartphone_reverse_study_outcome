package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/RecommendPopupAssetBlock;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", SocialConstants.PARAM_APP_DESC, "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "Lkotlin/collections/ArrayList;", "title", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecommendPopupAssetBlock implements CJPayObject, Serializable {
    public ArrayList<UIComponent> desc;
    public ArrayList<UIComponent> title;

    public RecommendPopupAssetBlock() {
    }
}
