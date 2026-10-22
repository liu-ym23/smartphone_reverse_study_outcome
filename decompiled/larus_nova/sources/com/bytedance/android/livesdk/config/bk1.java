package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/bk1;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class bk1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f119877d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f119878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f119879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f119880c;

    @SerializedName("enable")
    private boolean enable;

    public static final class a {
    }

    static {
        boolean r100 = tb1.c.f545229a;
        f119877d = "lf1-webcastcdn-tos.douyinstatic.com";
    }

    public bk1() {
        this.enable = true;
        StringBuilder r100 = new StringBuilder("https://");
        String r101 = f119877d;
        r100.append(r101);
        r100.append("/obj/live-android/anchor_leave_tip.webp");
        this.f119878a = r100.toString();
        this.f119879b = "https://" + r101 + "/obj/live-android/link_toolbar_icon_matching_38px.webp";
        this.f119880c = "https://" + r101 + "/obj/live-android/link_toolbar_icon_waiting_38px.webp";
    }

    public final boolean a() {
        return this.enable;
    }
}
