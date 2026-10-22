package com.bytedance.android.livesdk.interactivity.like.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/api/a;", "", "", "diggScene", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setDiggScene", "(Ljava/lang/String;)V", "getDiggScene$annotations", "()V", "<init>", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("digg_scene")
    private String diggScene;

    public a() {
        this.diggScene = "";
    }

    public final String a() {
        return this.diggScene;
    }
}
