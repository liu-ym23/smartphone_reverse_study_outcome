package com.bytedance.android.livesdk.config;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/s01;", "", "", "res_1v6_dynamic", "Ljava/lang/String;", "getRes_1v6_dynamic", "()Ljava/lang/String;", "setRes_1v6_dynamic", "(Ljava/lang/String;)V", "res_1v6_pin", "getRes_1v6_pin", "setRes_1v6_pin", "res_equal_dynamic", "getRes_equal_dynamic", "setRes_equal_dynamic", "res_equal_pin", "getRes_equal_pin", "setRes_equal_pin", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f121172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f121173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f121174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f121175d;

    @SerializedName("res_1v6_dynamic")
    private String res_1v6_dynamic;

    @SerializedName("res_1v6_pin")
    private String res_1v6_pin;

    @SerializedName("res_equal_dynamic")
    private String res_equal_dynamic;

    @SerializedName("res_equal_pin")
    private String res_equal_pin;

    public final String a() {
        if (TextUtils.isEmpty(this.res_equal_dynamic) == true) goto L7;
        String r100 = this.res_equal_dynamic;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this.f121174c;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.res_equal_pin) == true) goto L7;
        String r100 = this.res_equal_pin;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this.f121175d;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.res_1v6_dynamic) == true) goto L7;
        String r100 = this.res_1v6_dynamic;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this.f121172a;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.res_1v6_pin) == true) goto L7;
        String r100 = this.res_1v6_pin;
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return this.f121173b;
    }

    public s01() {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getObjectTosPath());
        r100.append("/obj/live-android/link_integration_guide_sample_1v6_dynamic.png");
        this.f121172a = r100.toString();
        this.f121173b = "https://" + r101.getObjectTosPath() + "/obj/live-android/link_integration_guide_sample_1v6_pin.png";
        this.f121174c = "https://" + r101.getObjectTosPath() + "/obj/live-android/link_integration_guide_sample_equal_dynamic.png";
        this.f121175d = "https://" + r101.getObjectTosPath() + "/obj/live-android/link_integration_guide_sample_equal_pin.png";
    }
}
