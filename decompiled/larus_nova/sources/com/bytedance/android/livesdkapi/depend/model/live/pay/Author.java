package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Author;", "", "()V", "authorBasicInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Author$AuthorBasicInfo;", "jumpSchema", "", "type", "", "userInfo", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "AuthorBasicInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Author implements h {

    @SerializedName("author_basic_info")
    public AuthorBasicInfo authorBasicInfo;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("type")
    public int type;

    @SerializedName("user_info")
    public IBaseUser userInfo;

    @ForMain
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Author$AuthorBasicInfo;", "", "", "name", "Ljava/lang/String;", "intorduce", "Lpy/k;", "cover", "Lpy/k;", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AuthorBasicInfo implements h {

        @SerializedName("cover")
        public k cover;

        @SerializedName("intorduce")
        public String intorduce;

        @SerializedName("name")
        public String name;

        public AuthorBasicInfo() {
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
        public AuthorBasicInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.name = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.intorduce = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.cover = f.a(r100, k.class);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    public Author() {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public Author(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.type = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userInfo = f.a(r100, IBaseUser.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.authorBasicInfo = new AuthorBasicInfo(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.jumpSchema = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
