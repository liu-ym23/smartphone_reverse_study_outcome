package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/h;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "location", "Ljava/util/List;", "b", "()Ljava/util/List;", "allowValue", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "uploadRaw", "I", "d", "()I", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class h {

    @SerializedName("allow_value")
    private final String allowValue;

    @SerializedName("location")
    private final List<String> location;

    @SerializedName("name")
    private final String name;

    @SerializedName("upload_raw")
    private final int uploadRaw;

    public final int hashCode() {
        return (this.location.hashCode() + this.allowValue.hashCode()) + this.uploadRaw;
    }

    public h() {
        this.name = "";
        this.location = CollectionsKt.emptyList();
        this.allowValue = "";
        this.uploadRaw = 1;
    }

    public final String a() {
        return this.allowValue;
    }

    public final List<String> b() {
        return this.location;
    }

    public final String c() {
        return this.name;
    }

    public final int d() {
        return this.uploadRaw;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof h) == true) goto L5;
        return false;
    L5:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.allowValue, r101.allowValue) == true) goto L10;
        return false;
    L10:
        if (this.uploadRaw != r101.uploadRaw) goto L15;
        return true;
    L15:
        return false;
    }
}
