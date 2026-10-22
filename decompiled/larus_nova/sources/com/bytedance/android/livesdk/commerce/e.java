package com.bytedance.android.livesdk.commerce;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/e;", "", "", "id", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setId", "(J)V", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public class e {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f119646id;

    @SerializedName("text")
    private String text;

    public e() {
        this.text = "";
    }

    public final long a() {
        return this.f119646id;
    }

    public final String b() {
        return this.text;
    }
}
