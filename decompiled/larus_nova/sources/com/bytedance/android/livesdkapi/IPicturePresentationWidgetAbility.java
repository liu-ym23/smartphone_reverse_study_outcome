package com.bytedance.android.livesdkapi;

import android.content.Intent;
import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/IPicturePresentationWidgetAbility;", "Lcom/bytedance/android/livesdk/ability/IAbility;", "isPickingImage", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPicturePresentationWidgetAbility extends IAbility {
    boolean isPickingImage();

    void onActivityResult(int r100, int r101, Intent r102);
}
