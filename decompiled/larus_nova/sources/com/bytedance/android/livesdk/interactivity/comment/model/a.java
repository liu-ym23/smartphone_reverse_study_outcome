package com.bytedance.android.livesdk.interactivity.comment.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.interaction.GetInterestKpListResponse.InterestKpMeta")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\b\u0010\t\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/model/a;", "", "", "id", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "kp", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setKp", "(Ljava/lang/String;)V", "getKp$annotations", "()V", "<init>", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f135313id;

    /* JADX INFO: renamed from: kp, reason: collision with root package name */
    @SerializedName("interest_kp")
    protected String f135314kp;

    public a() {
    }

    public final int hashCode() {
        long r100 = this.f135313id;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final long a() {
        return this.f135313id;
    }

    public final String b() {
        return this.f135314kp;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.f135313id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.f135314kp = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        long r102 = this.f135313id;
        if ((r100 instanceof a) == true) goto L15;
        r100 = null;
    L15:
        a r103 = (a) r100;
        if (r103 != null) goto L18;
    L20:
        return false;
    L18:
        if (r102 != r103.f135313id) goto L20;
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
