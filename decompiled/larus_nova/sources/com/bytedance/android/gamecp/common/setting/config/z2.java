package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/z2;", "", "", "downloadTriggerType", "I", "getDownloadTriggerType", "()I", "setDownloadTriggerType", "(I)V", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f56753a;

    @SerializedName("download_trigger_type")
    private int downloadTriggerType;

    public final JSONObject a() {
        JSONObject r100 = this.f56753a;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        return r100;
    L11:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        r101.putOpt("download_trigger_type", Integer.valueOf(this.downloadTriggerType));     // Catch: Exception -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L8
    L9:
        this.f56753a = r101;
        Intrinsics.checkNotNull(r101);
        return r101;
    L8:
        r101 = new JSONObject();
        goto L9
    }

    public z2() {
        this.downloadTriggerType = 2;
    }
}
