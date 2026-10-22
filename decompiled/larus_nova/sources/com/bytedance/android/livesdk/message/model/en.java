package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/en;", "", "", "red", "I", "c", "()I", "setRed", "(I)V", "green", "b", "setGreen", "blue", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBlue", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class en implements vh7.h {

    @SerializedName("blue")
    protected int blue;

    @SerializedName("green")
    protected int green;

    @SerializedName("red")
    protected int red;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof en) == false) goto L12;
        en r101 = (en) r100;
        if (this.red == r101.red) goto L8;
        return false;
    L8:
        if (this.green == r101.green) goto L10;
        return false;
    L10:
        if (this.blue == r101.blue) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.red * 31) + this.green) * 31) + this.blue;
    }

    public final String toString() {
        return "VideoColor(red=" + this.red + ", green=" + this.green + ", blue=" + this.blue + ")";
    }

    public en() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public final int a() {
        return this.blue;
    }

    public final int b() {
        return this.green;
    }

    public final int c() {
        return this.red;
    }

    public en(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        this.red = r100.i();
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.green = r100.i();
        r102 = r102 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this.blue = r100.i();
        r102 = r102 | 4;
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L19;
        this.red = 0;
    L19:
        if ((r102 & 2) != 0) goto L22;
        this.green = 0;
    L22:
        if ((r102 & 4) != 0) goto L37;
        this.blue = 0;
        return;
    }
}
