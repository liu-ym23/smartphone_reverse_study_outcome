package com.bytedance.android.livesdk.gift.platform.core.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/h;", "", "", "groupCount", "I", "getGroupCount", "()I", "setGroupCount", "(I)V", "", "groupText", "Ljava/lang/String;", "getGroupText", "()Ljava/lang/String;", "setGroupText", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements Comparable<h>, vh7.h {

    @SerializedName("group_count")
    protected int groupCount;

    @SerializedName("group_text")
    protected String groupText;

    public static final class a {
    }

    static {
    }

    public h() {
    }

    public h(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.groupCount = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.groupText = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    @Override // java.lang.Comparable
    public final int compareTo(h r100) {
        h r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return this.groupCount - r101.groupCount;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (r101.groupCount == this.groupCount) goto L7;
        return false;
    L7:
        if (TextUtils.equals(r101.groupText, this.groupText) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
