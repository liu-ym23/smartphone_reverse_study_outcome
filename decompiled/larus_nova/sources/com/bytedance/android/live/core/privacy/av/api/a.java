package com.bytedance.android.live.core.privacy.av.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/privacy/av/api/a;", "", "", "delayCheckTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "c", "(I)V", "", "useSystemChecker", "Z", "b", "()Z", "d", "(Z)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f65132b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f65133a;

    @SerializedName("delay_check_time")
    private int delayCheckTime;

    @SerializedName("use_system_checker")
    private boolean useSystemChecker;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.privacy.av.api.a$a, reason: collision with other inner class name */
    public static final class C1071a {
    }

    public final void d() {
        this.useSystemChecker = true;
    }

    static {
        f65132b = new a();
    }

    public final void c() {
        this.delayCheckTime = 1000;
    }

    public a() {
        this.f65133a = -1;
    }

    public final int a() {
        return this.delayCheckTime;
    }

    public final boolean b() {
        return this.useSystemChecker;
    }
}
