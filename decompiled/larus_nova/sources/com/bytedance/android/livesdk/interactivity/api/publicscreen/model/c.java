package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/c;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "", "userTag", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUserTag", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("user")
    protected IBaseUser user;

    @SerializedName("user_tag")
    protected List<String> userTag;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public c(am3.g r100) {
        this.userTag = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.userTag.add(am3.h.c(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final IBaseUser a() {
        return this.user;
    }

    public final List<String> b() {
        return this.userTag;
    }
}
