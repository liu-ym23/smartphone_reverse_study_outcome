package com.bytedance.android.livesdkapi.interfaces;

import kotlin.Metadata;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/interfaces/ListDialogAbility;", "", "dismissDialog", "", "jumpSubpage", "pageType", "", "listAdapter", "Lme/drakeet/multitype/MultiTypeAdapter;", "refreshSettingItems", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ListDialogAbility {
    void dismissDialog();

    void jumpSubpage(int r100);

    MultiTypeAdapter listAdapter();

    void refreshSettingItems();
}
