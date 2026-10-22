package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "background", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "type", "I", "getType", "()I", "", "num", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroNumAtmosphere {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f148475a = 0;

    @SerializedName("background")
    private final ECUrlModel background;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName("num")
    private final String num;

    @SerializedName("type")
    private final int type;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroNumAtmosphere$Companion$IntroNumAtmosphereType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroNumAtmosphereType {
        }
    }

    static {
    }

    public IntroNumAtmosphere() {
        this(null, null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroNumAtmosphere) == false) goto L14;
        IntroNumAtmosphere r101 = (IntroNumAtmosphere) r100;
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.leftIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.background;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.type) * 31;
        String r107 = this.num;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroNumAtmosphere(leftIcon=" + this.leftIcon + ", background=" + this.background + ", type=" + this.type + ", num=" + this.num + ")";
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final ECUrlModel b() {
        return this.leftIcon;
    }

    public final String c() {
        return this.num;
    }

    public final int getType() {
        return this.type;
    }

    public IntroNumAtmosphere(ECUrlModel r100, ECUrlModel r101, int r102, String r103) {
        this.leftIcon = r100;
        this.background = r101;
        this.type = r102;
        this.num = r103;
    }
}
