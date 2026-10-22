package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class VSToolbarConfigData extends FlexModelBase<IVSToolbarConfigData> implements IVSToolbarConfigData {
    public static final int STATE_CLOSE_ALL = 0;
    public static final int STATE_OPEN_ALL = 3;
    public static final int STATE_OPEN_LANDSCAPE_ONLY = 2;
    public static final int STATE_OPEN_PORTRAIT_ONLY = 1;
    public static final int TYPE_ACTIVITY = 3;
    public static final int TYPE_CART = 4;
    public static final int TYPE_GIFT = 5;
    public static final int TYPE_HASH_TAG = 1;
    public static final int TYPE_INPUT = 6;
    public static final int TYPE_MORE = 0;
    public static final int TYPE_VOTE = 2;
    public static final int TYPE_VS_OPERATION = 7;
    public static final int TYPE_VS_QUICK_SHOT = 11;
    public static final int TYPE_VS_SHARE = 9;
    public static final int TYPE_VS_TOPIC = 8;

    @SerializedName("bottom_icon")
    k bottomIcon;

    @SerializedName("display_type")
    int displayType;

    @SerializedName("dynamic_bottom_icon")
    k dynamicBottomIcon;

    @SerializedName("dynamic_icon")
    k dynamicIcon;

    @SerializedName("icon")
    k icon;

    @SerializedName("icon_vertical")
    public k iconVertical;

    @SerializedName("jump_schema")
    String schema;

    @SerializedName("toast_list")
    public List<TopicToast> toastList;

    @SerializedName("toolbar_type")
    public int type;

    public VSToolbarConfigData() {
        super(IVSToolbarConfigData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getBottomIcon() {
        return this.bottomIcon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public int getDisplayType() {
        return this.displayType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getDynamicBottomIcon() {
        return this.dynamicBottomIcon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getDynamicIcon() {
        return this.dynamicIcon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public int getToolbarType() {
        return this.type;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getVerticalIcon() {
        return this.iconVertical;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setDisplayType(int r100) {
        this.displayType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setToolbarType(int r100) {
        this.type = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setVerticalIcon(k r100) {
        this.iconVertical = r100;
    }

    public VSToolbarConfigData(int r100, k r101, String r102) {
        super(IVSToolbarConfigData.class);
        this.type = r100;
        this.icon = r101;
        this.schema = r102;
    }
}
