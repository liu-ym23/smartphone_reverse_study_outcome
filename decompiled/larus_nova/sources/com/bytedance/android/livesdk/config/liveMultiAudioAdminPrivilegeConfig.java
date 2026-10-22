package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/liveMultiAudioAdminPrivilegeConfig;", "", "()V", "open", "", "getOpen", "()Z", "setOpen", "(Z)V", "privileges", "", "", "getPrivileges", "()Ljava/util/List;", "setPrivileges", "(Ljava/util/List;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class liveMultiAudioAdminPrivilegeConfig {

    @SerializedName("open")
    private boolean open;

    @SerializedName("privileges")
    private List<Integer> privileges;

    public liveMultiAudioAdminPrivilegeConfig() {
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final List<Integer> getPrivileges() {
        return this.privileges;
    }

    public final void setOpen(boolean r100) {
        this.open = r100;
    }

    public final void setPrivileges(List<Integer> r100) {
        this.privileges = r100;
    }
}
