package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/a;", "Lcom/bytedance/android/live/liveinteract/hamlet/model/d;", "", "code", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "", "msg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a extends d {

    @SerializedName("code")
    private Integer code;

    @SerializedName("msg")
    private String msg;

    public a() {
        super(null);
    }

    public final Integer b() {
        return this.code;
    }

    public final String c() {
        return this.msg;
    }
}
