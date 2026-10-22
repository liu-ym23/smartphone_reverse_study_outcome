package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/a;", "", "", "newChatId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setNewChatId", "(J)V", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    protected long newChatId;

    public a() {
    }

    public final long a() {
        return this.newChatId;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.newChatId = r100.j();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
