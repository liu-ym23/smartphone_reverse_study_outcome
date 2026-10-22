package com.bytedance.android.live.liveinteract.banner;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/ActivityContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/b;", "", "toString", "", "other", "", "equals", "", "hashCode", "activityName", "Ljava/lang/String;", "getActivityName", "()Ljava/lang/String;", "iconType", "getIconType", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ActivityContent extends FlexModelBase<com.bytedance.android.livesdk.multilink.base.model.b> implements com.bytedance.android.livesdk.multilink.base.model.b, h {

    @SerializedName("activity_name")
    protected String activityName;

    @SerializedName("icon_type")
    protected String iconType;

    public ActivityContent() {
        super(com.bytedance.android.livesdk.multilink.base.model.b.class);
        this.activityName = "";
        this.iconType = "";
    }

    public String toString() {
        return "ActivityContent(activityName='" + getActivityName() + "', iconType='" + getIconType() + "')";
    }

    public int hashCode() {
        String r100 = getActivityName();
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + getIconType().hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.b
    public String getActivityName() {
        return this.activityName;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.b
    public String getIconType() {
        return this.iconType;
    }

    public ActivityContent(g r100) {
        super(com.bytedance.android.livesdk.multilink.base.model.b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.activityName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.iconType = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.activityName != null) goto L16;
        this.activityName = "";
    L16:
        if (this.iconType != null) goto L28;
        this.iconType = "";
        return;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(ActivityContent.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        ActivityContent r101 = (ActivityContent) r100;
        if ((!Intrinsics.areEqual(getActivityName(), r101.getActivityName())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getIconType(), r101.getIconType())) == false) goto L17;
        return false;
    L17:
        return true;
    }
}
