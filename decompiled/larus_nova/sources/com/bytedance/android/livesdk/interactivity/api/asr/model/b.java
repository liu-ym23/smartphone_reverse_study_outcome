package com.bytedance.android.livesdk.interactivity.api.asr.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.interaction.HistoryTextItem")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/model/b;", "", "", "userId", "J", "", "userName", "Ljava/lang/String;", "", "textType", "I", "extra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("extra")
    public String extra;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE)
    public int textType;

    @SerializedName("user_id")
    public long userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    public String userName;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.textType = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
