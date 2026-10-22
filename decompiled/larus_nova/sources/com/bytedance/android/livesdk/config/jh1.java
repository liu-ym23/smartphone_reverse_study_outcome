package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/jh1;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "condition", "Ljava/util/List;", "b", "()Ljava/util/List;", DyPayConstant.KEY_START_TIME, "e", "endTime", "d", "Lcom/bytedance/android/livesdk/config/kh1;", "contents", "c", "challenges", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class jh1 {

    @SerializedName("challenges")
    private final List<kh1> challenges;

    @SerializedName("conditions")
    private final List<String> condition;

    @SerializedName("contents")
    private final List<kh1> contents;

    @SerializedName("end_time")
    private final String endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final String startTime;

    @SerializedName("type")
    private final String type;

    public static final class a {
    }

    static {
    }

    public jh1() {
        List<String> r100 = CollectionsKt.emptyList();
        List<kh1> r101 = CollectionsKt.emptyList();
        List<kh1> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("", "type");
        Intrinsics.checkNotNullParameter(r100, "condition");
        Intrinsics.checkNotNullParameter("", DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter("", "endTime");
        Intrinsics.checkNotNullParameter(r101, "contents");
        Intrinsics.checkNotNullParameter(r102, "challenges");
        this.type = "";
        this.condition = r100;
        this.startTime = "";
        this.endTime = "";
        this.contents = r101;
        this.challenges = r102;
    }

    public final List<kh1> a() {
        return this.challenges;
    }

    public final List<String> b() {
        return this.condition;
    }

    public final List<kh1> c() {
        return this.contents;
    }

    public final String d() {
        return this.endTime;
    }

    public final String e() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }
}
