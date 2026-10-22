package com.bytedance.android.live.wallet.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/wallet/model/m;", "", "", "verifyType", "Ljava/lang/Integer;", "getVerifyType", "()Ljava/lang/Integer;", "setVerifyType", "(Ljava/lang/Integer;)V", "", "sceneCode", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSceneCode", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m {

    @SerializedName("scene_code")
    private String sceneCode;

    @SerializedName("verify_type")
    private Integer verifyType;

    public static final class a {
    }

    static {
    }

    public m() {
    }

    public final boolean a() {
        Integer r100 = this.verifyType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 3) goto L8;
        return true;
    }

    public final boolean c() {
        Integer r100 = this.verifyType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 5) goto L8;
        return true;
    }

    public final boolean d() {
        Integer r100 = this.verifyType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 4) goto L8;
        return true;
    }

    public final boolean e() {
        Integer r100 = this.verifyType;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.verifyType;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.intValue() != 3) goto L13;
    L14:
        return true;
    L6:
        if (r100.intValue() == 2) goto L14;
        goto L7
    }

    public final String b() {
        return this.sceneCode;
    }
}
