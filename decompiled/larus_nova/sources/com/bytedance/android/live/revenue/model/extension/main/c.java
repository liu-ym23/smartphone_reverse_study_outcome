package com.bytedance.android.live.revenue.model.extension.main;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/c;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "getGroupLiveData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGroupLiveData;", "getGroupLiveData$annotations", "()V", "groupLiveData", "Lcom/bytedance/android/live/revenue/model/extension/main/b;", "getGiftPanelTopperTray", "()Lcom/bytedance/android/live/revenue/model/extension/main/b;", "getGiftPanelTopperTray$annotations", "giftPanelTopperTray", "Lcom/bytedance/android/live/revenue/model/extension/main/a;", "getEnterGiftAnimation", "()Lcom/bytedance/android/live/revenue/model/extension/main/a;", "getEnterGiftAnimation$annotations", "enterGiftAnimation", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface c extends e<IRoomOthersData>, IRoomOthersData {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "enter_gift_animation")
    com.bytedance.android.live.revenue.model.extension.main.a getEnterGiftAnimation();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "gift_panel_topper_tray")
    b getGiftPanelTopperTray();

    @FieldName(name = "group_live_data")
    IGroupLiveData getGroupLiveData();
}
