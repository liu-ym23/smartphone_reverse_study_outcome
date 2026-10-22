package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/h;", "Lcom/bytedance/android/live/liveinteract/hamlet/model/d;", "", "fullBody", "Ljava/lang/Integer;", "getFullBody", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h extends d {

    @SerializedName("fullBody")
    private Integer fullBody;

    public h() {
        super(5);
    }

    public final void b(Integer r100) {
        this.fullBody = r100;
    }
}
