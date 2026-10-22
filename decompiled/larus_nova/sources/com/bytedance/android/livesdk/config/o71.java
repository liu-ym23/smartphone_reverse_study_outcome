package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/config/o71;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "", "eventList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setEventList", "(Ljava/util/List;)V", "blackList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBlackList", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o71 {

    @SerializedName("black_list")
    private List<String> blackList;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("event_list")
    private List<String> eventList;

    public o71() {
        this.enable = true;
        this.eventList = CollectionsKt.emptyList();
        this.blackList = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.blackList;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.eventList;
    }
}
