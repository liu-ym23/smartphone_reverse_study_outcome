package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/h;", "", "", "id", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/response/q1;", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "beginTime", "I", "getBeginTime", "()I", "continueTime", "getContinueTime", "Lcom/bytedance/android/ec/model/response/p1;", "eventRule", "Lcom/bytedance/android/ec/model/response/p1;", "getEventRule", "()Lcom/bytedance/android/ec/model/response/p1;", "endDesc", "getEndDesc", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("begin_time")
    private final int beginTime;

    @SerializedName("continue_time")
    private final int continueTime;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("end_desc")
    private final String endDesc;

    @SerializedName("event_rule")
    private final p1 eventRule;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Integer f47949id;

    @SerializedName("options")
    private final List<q1> options;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L20;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f47949id, r101.f47949id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.options, r101.options) == true) goto L12;
        return false;
    L12:
        if (this.beginTime == r101.beginTime) goto L14;
        return false;
    L14:
        if (this.continueTime == r101.continueTime) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.eventRule, r101.eventRule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endDesc, r101.endDesc) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f47949id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.desc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<q1> r107 = this.options;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + this.beginTime) * 31) + this.continueTime) * 31;
        p1 r110 = this.eventRule;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.endDesc;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentSurveyDTO(id=" + this.f47949id + ", desc=" + this.desc + ", options=" + this.options + ", beginTime=" + this.beginTime + ", continueTime=" + this.continueTime + ", eventRule=" + this.eventRule + ", endDesc=" + this.endDesc + ")";
    }

    public h() {
        this.f47949id = null;
        this.desc = null;
        this.options = null;
        this.beginTime = 0;
        this.continueTime = 0;
        this.eventRule = null;
        this.endDesc = null;
    }
}
