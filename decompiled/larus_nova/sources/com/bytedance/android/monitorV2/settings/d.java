package com.bytedance.android.monitorV2.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/d;", "", "", "", "urlBlockList", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "setUrlBlockList", "([Ljava/lang/String;)V", "", "stayDuration", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setStayDuration", "(J)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f163219a = null;

    @SerializedName("stay_duration")
    private long stayDuration;

    @SerializedName("url_blocklist")
    private String[] urlBlockList;

    public static final class a {
    }

    static {
        f163219a = new d();
    }

    public d() {
        this.urlBlockList = new String[0];
        this.stayDuration = 2000;
    }

    public final long a() {
        return this.stayDuration;
    }

    public final String[] b() {
        return this.urlBlockList;
    }
}
