package com.bytedance.android.livesdk.chatroom.helper;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R2\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR2\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/helper/m;", "", "", "", "common", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setCommon", "(Ljava/util/Map;)V", "firstShow", "c", "setFirstShow", "click", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setClick", "<init>", "()V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("click")
    private Map<String, String> click;

    @SerializedName("common")
    private Map<String, String> common;

    @SerializedName("first_show")
    private Map<String, String> firstShow;

    public m() {
    }

    public final Map<String, String> a() {
        return this.click;
    }

    public final Map<String, String> b() {
        return this.common;
    }

    public final Map<String, String> c() {
        return this.firstShow;
    }
}
