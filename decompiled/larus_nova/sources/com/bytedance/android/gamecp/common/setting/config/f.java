package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR.\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/f;", "", "", "", "useShellAtyName", "Ljava/util/List;", "getUseShellAtyName", "()Ljava/util/List;", "setUseShellAtyName", "(Ljava/util/List;)V", "usePreviousAtyName", "getUsePreviousAtyName", "setUsePreviousAtyName", "useShellPath", "getUseShellPath", "setUseShellPath", "", "checkShellFocusTime", "J", "getCheckShellFocusTime", "()J", "setCheckShellFocusTime", "(J)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("check_shell_focus_time")
    private long checkShellFocusTime;

    @SerializedName("use_previous_aty_name")
    private List<String> usePreviousAtyName;

    @SerializedName("use_shell_aty_name")
    private List<String> useShellAtyName;

    @SerializedName("use_double_check_aty_path")
    private List<? extends List<String>> useShellPath;

    public f() {
        this.useShellAtyName = CollectionsKt.listOf("OpenSchemaRelayActivity");
        this.usePreviousAtyName = CollectionsKt.listOf("DeepLinkHandlerActivity");
        this.useShellPath = CollectionsKt.listOf(CollectionsKt.listOf(new String[]{"DeepLinkHandlerActivity", "VideoRecordNewActivity"}));
        this.checkShellFocusTime = 1000;
    }
}
