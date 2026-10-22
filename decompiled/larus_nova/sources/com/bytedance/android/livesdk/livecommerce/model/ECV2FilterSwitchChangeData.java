package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.FilterSwitchChangeData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2FilterSwitchChangeData;", "", "()V", "enable", "", "upIcon", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2FilterSwitchChangeData$UpIcon;", "UpIcon", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2FilterSwitchChangeData {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("up_icon")
    public UpIcon upIcon;

    @ProtoMessage("live.UpIcon")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2FilterSwitchChangeData$UpIcon;", "", "()V", "name", "", "publicScreenNotice", "upDesc", "upIconUrl", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UpIcon {

        @SerializedName("name")
        public String name;

        @SerializedName("public_screen_notice")
        public String publicScreenNotice;

        @SerializedName("up_desc")
        public String upDesc;

        @SerializedName("up_icon")
        public String upIconUrl;

        public UpIcon() {
        }
    }

    public ECV2FilterSwitchChangeData() {
    }
}
