package com.bytedance.android.livesdk.interactivity.comment.share.model;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class b {

    @SerializedName("extra")
    public String extra;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public String itemType;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("schema")
    public String schema;

    public b() {
    }

    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        r100.put("room_id", String.valueOf(this.roomId));
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, this.itemType);
        r100.put("item_id", this.itemId);
        if (TextUtils.isEmpty(this.extra) == true) goto L6;
        r100.put("extra", this.extra);
    L6:
        if (TextUtils.isEmpty(this.schema) == true) goto L8;
        r100.put("schema", this.schema);
    L8:
        return r100;
    }
}
