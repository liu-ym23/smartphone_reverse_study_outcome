package com.bytedance.android.ec.model.response;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.larus.trace.CopyContentTypeString;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/model/response/ExtendInfoContent;", "Ljava/io/Serializable;", "", "type", "I", "getType", "()I", "Lcom/bytedance/android/ec/model/response/ExtendInfoTable;", CopyContentTypeString.TABLE, "Lcom/bytedance/android/ec/model/response/ExtendInfoTable;", "getTable", "()Lcom/bytedance/android/ec/model/response/ExtendInfoTable;", "", "duration", "J", "getDuration", "()J", "Lcom/bytedance/android/ec/model/response/d0;", "trackInfo", "Lcom/bytedance/android/ec/model/response/d0;", "getTrackInfo", "()Lcom/bytedance/android/ec/model/response/d0;", "", "", "eventParam", "Ljava/util/Map;", "getEventParam", "()Ljava/util/Map;", "setEventParam", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ExtendInfoContent implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_TABLE = 1;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("event_param")
    private Map<String, String> eventParam;

    @SerializedName(CopyContentTypeString.TABLE)
    private final ExtendInfoTable table;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final d0 trackInfo;

    @SerializedName("type")
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ExtendInfoContent() {
        this.duration = 5000;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Map<String, String> getEventParam() {
        return this.eventParam;
    }

    public final ExtendInfoTable getTable() {
        return this.table;
    }

    public final d0 getTrackInfo() {
        return this.trackInfo;
    }

    public final int getType() {
        return this.type;
    }

    public final void setEventParam(Map<String, String> r100) {
        this.eventParam = r100;
    }
}
