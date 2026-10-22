package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/format/model/p;", "", "", "formatLiveEnableContainerUnifyOptimize", "Z", "getFormatLiveEnableContainerUnifyOptimize", "()Z", "setFormatLiveEnableContainerUnifyOptimize", "(Z)V", "avatarInteractiveOpeningChatOptimize", "getAvatarInteractiveOpeningChatOptimize", "setAvatarInteractiveOpeningChatOptimize", "avatarInteractiveEnableHighLightPlay", "getAvatarInteractiveEnableHighLightPlay", "setAvatarInteractiveEnableHighLightPlay", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("avatar_interactive_enable_high_light_play")
    private boolean avatarInteractiveEnableHighLightPlay;

    @SerializedName("avatar_interactive_opening_chat_optimize")
    private boolean avatarInteractiveOpeningChatOptimize;

    @SerializedName("format_live_enable_container_unify_optimize")
    private boolean formatLiveEnableContainerUnifyOptimize;

    public p() {
        this.formatLiveEnableContainerUnifyOptimize = true;
    }
}
