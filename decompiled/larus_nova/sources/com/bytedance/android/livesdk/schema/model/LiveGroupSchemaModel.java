package com.bytedance.android.livesdk.schema.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.p.e;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/LiveGroupSchemaModel;", "Lcom/bytedance/android/livesdk/schema/interfaces/BaseSchemaModel;", "Landroid/os/Parcelable;", "group_Id", "", e.f25671s, "(Ljava/lang/String;Ljava/lang/String;)V", "getGroup_Id", "()Ljava/lang/String;", "getMethod", "describeContents", "", "getSchemaHost", "writeToParcel", "", Argument.OUT, "Landroid/os/Parcel;", "flags", "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGroupSchemaModel extends BaseSchemaModel implements Parcelable {
    public static final Parcelable.Creator<LiveGroupSchemaModel> CREATOR = null;
    public static final Companion Companion = null;

    @SerializedName("group_Id")
    private final String group_Id;

    @SerializedName(e.f25671s)
    private final String method;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/schema/model/LiveGroupSchemaModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/android/livesdk/schema/model/LiveGroupSchemaModel;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel
    public String getSchemaHost() {
        return SchemaHandlerHostConstants.LIVE_GROUP_SCHEMA_HOST;
    }

    static {
        Companion = new Companion(null);
        CREATOR = new LiveGroupSchemaModel$Companion$CREATOR$1();
    }

    public final String getGroup_Id() {
        return this.group_Id;
    }

    public final String getMethod() {
        return this.method;
    }

    public LiveGroupSchemaModel(String r100, String r101) {
        this.group_Id = r100;
        this.method = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.group_Id);
        r100.writeString(this.method);
    }
}
