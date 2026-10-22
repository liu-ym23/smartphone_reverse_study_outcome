package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/g41;", "", "", "enable", "Z", "b", "()Z", "", "", "supportEntrance", "Ljava/util/List;", "c", "()Ljava/util/List;", "drawNextFix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g41 {

    @SerializedName("draw_next_fix")
    private final boolean drawNextFix;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("support_entrance")
    private final List<String> supportEntrance;

    public g41() {
        this.supportEntrance = CollectionsKt.emptyList();
        this.drawNextFix = true;
    }

    public final boolean a() {
        return this.drawNextFix;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.supportEntrance;
    }
}
