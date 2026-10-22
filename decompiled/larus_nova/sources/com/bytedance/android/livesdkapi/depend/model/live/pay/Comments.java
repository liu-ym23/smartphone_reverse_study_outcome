package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments;", "", "()V", "count", "", "hasmore", "", "jumpSchema", "", "texts", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments$TextInfo;", "title", "TextInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Comments implements h {

    @SerializedName("count")
    public int count;

    @SerializedName("hasMore")
    public boolean hasmore;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("texts")
    public List<TextInfo> texts;

    @SerializedName("title")
    public String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments$TextInfo;", "", "()V", "commentId", "", "commentIdStr", "", "createTimeStamp", "diggCount", "", "text", "userInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments$TextInfo$UserInfo;", "UserInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @ForMain
    public static final class TextInfo implements h {

        @SerializedName("comment_id")
        public long commentId;

        @SerializedName("comment_id_str")
        public String commentIdStr;

        @SerializedName("create_time_stamp")
        public long createTimeStamp;

        @SerializedName("digg_count")
        public int diggCount;

        @SerializedName("text")
        public String text;

        @SerializedName("user_info")
        public UserInfo userInfo;

        @ForMain
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments$TextInfo$UserInfo;", "", "", "userId", "J", "", "name", "Ljava/lang/String;", "Lpy/k;", "avatar", "Lpy/k;", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class UserInfo implements h {

            @SerializedName("avatar")
            public k avatar;

            @SerializedName("name")
            public String name;

            @SerializedName("user_id")
            public long userId;

            public UserInfo() {
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
            public UserInfo(g r100) {
                long r101 = r100.c();
            L3:
                int r102 = r100.f();
                if (r102 == (-1)) goto L15;
                if (r102 != 1) goto L8;
                this.userId = r100.j();
                goto L3
            L8:
                if (r102 != 2) goto L10;
                this.name = am3.h.c(r100);
                goto L3
            L10:
                if (r102 != 3) goto L11;
                this.avatar = f.a(r100, k.class);
                goto L3
            L11:
                am3.h.e(r100);
                goto L3
            L15:
                r100.d(r101);
            }
        }

        public TextInfo() {
        }

        public TextInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.commentIdStr = am3.h.c(r100);
            goto L3
        L8:
            this.createTimeStamp = r100.j();
            goto L3
        L9:
            this.diggCount = r100.i();
            goto L3
        L10:
            this.text = am3.h.c(r100);
            goto L3
        L11:
            this.userInfo = new UserInfo(r100);
            goto L3
        L12:
            this.commentId = r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }
    }

    public Comments() {
    }

    public Comments(g r100) {
        this.texts = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.count = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.hasmore = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.jumpSchema = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.texts.add(new TextInfo(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
