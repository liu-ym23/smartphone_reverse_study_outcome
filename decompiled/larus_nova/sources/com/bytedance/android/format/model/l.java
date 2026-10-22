package com.bytedance.android.format.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/android/format/model/l;", "", "", "bgColor", "Ljava/lang/String;", "getBgColor", "()Ljava/lang/String;", "bgImg", "getBgImg", "endTime", "getEndTime", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "extraType", "getExtraType", "id", "getId", "openSchema", "getOpenSchema", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "roomType", "getRoomType", "showChance", "getShowChance", "size", "getSize", DyPayConstant.KEY_START_TIME, "getStartTime", "text", "getText", "version", "getVersion", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_img")
    private final String bgImg;

    @SerializedName("end_time")
    private final String endTime;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("extra_type")
    private final String extraType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f51352id;

    @SerializedName("open_schema")
    private final String openSchema;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName(IPerformanceManager.Params.room_type)
    private final String roomType;

    @SerializedName("show_chance")
    private final Integer showChance;

    @SerializedName("size")
    private final String size;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final String startTime;

    @SerializedName("text")
    private final String text;

    @SerializedName("version")
    private final String version;

    public static final class a {
    }

    static {
    }

    public l() {
    }
}
