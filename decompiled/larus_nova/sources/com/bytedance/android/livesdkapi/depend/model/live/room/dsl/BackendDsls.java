package com.bytedance.android.livesdkapi.depend.model.live.room.dsl;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
public class BackendDsls {

    @SerializedName("dsls")
    public List<BackendDslInfo> cardList;

    public BackendDsls() {
    }
}
