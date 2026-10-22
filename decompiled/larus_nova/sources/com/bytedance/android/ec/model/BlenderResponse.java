package com.bytedance.android.ec.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/BlenderResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "data", "Lorg/json/JSONObject;", Segment.JsonKey.START, "", "msg", "", "(Lorg/json/JSONObject;Ljava/lang/Integer;Ljava/lang/String;)V", "getData", "()Lorg/json/JSONObject;", "getMsg", "()Ljava/lang/String;", "rawJson", "getSt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "checkResValid", "", "getRawJson", "setRawJson", "", "json", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class BlenderResponse extends CommerceBaseResponse {

    @SerializedName("data")
    private final JSONObject data;

    @SerializedName("msg")
    private final String msg;
    private JSONObject rawJson;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    @SerializedName(Segment.JsonKey.START)
    private final Integer f47847st;

    public BlenderResponse() {
        this(null, null, null, 7, null);
    }

    public final boolean checkResValid() {
        Integer r100 = this.f47847st;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 0) goto L8;
        return true;
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final JSONObject getRawJson() {
        return this.rawJson;
    }

    public final Integer getSt() {
        return this.f47847st;
    }

    public final void setRawJson(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.rawJson = r100;
    }

    public BlenderResponse(JSONObject r100, Integer r101, String r102) {
        this.data = r100;
        this.f47847st = r101;
        this.msg = r102;
    }

    public /* synthetic */ BlenderResponse(JSONObject r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
