package com.bytedance.android.livesdk.chatroom.ui;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/s5;", "", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/chatroom/ui/i6;", "extra", "Lcom/bytedance/android/livesdk/chatroom/ui/i6;", "b", "()Lcom/bytedance/android/livesdk/chatroom/ui/i6;", "setExtra", "(Lcom/bytedance/android/livesdk/chatroom/ui/i6;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f114057a;

    @SerializedName("content")
    private String content;

    @SerializedName("extra")
    private i6 extra;

    public s5() {
        this.content = "";
        this.extra = new i6();
    }

    public final String a() {
        return this.content;
    }

    public final i6 b() {
        return this.extra;
    }
}
