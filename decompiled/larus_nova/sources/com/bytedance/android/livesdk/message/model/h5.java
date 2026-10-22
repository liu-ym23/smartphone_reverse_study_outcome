package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/h5;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdk/message/model/h5$a;", "floatWindow", "Lcom/bytedance/android/livesdk/message/model/h5$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h5 extends o0 implements vh7.h {

    @SerializedName("float_window")
    public a floatWindow;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/h5$a;", "", "", "id", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "", "title", "Ljava/lang/String;", "d", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "text", "c", "setText", "createTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCreateTime", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("create_time")
        protected Long createTime;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        protected Long f153651id;

        @SerializedName("text")
        protected String text;

        @SerializedName("title")
        protected String title;

        public a() {
            this.f153651id = 0L;
            this.title = "";
            this.text = "";
            this.createTime = 0L;
        }

        public final Long a() {
            return this.createTime;
        }

        public final Long b() {
            return this.f153651id;
        }

        public final String c() {
            return this.text;
        }

        public final String d() {
            return this.title;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.f153651id = Long.valueOf(r100.j());
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.title = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.text = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.createTime = Long.valueOf(r100.j());
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.f153651id != null) goto L22;
            this.f153651id = 0L;
        L22:
            if (this.title != null) goto L25;
            this.title = "";
        L25:
            if (this.text != null) goto L28;
            this.text = "";
        L28:
            if (this.createTime != null) goto L46;
            this.createTime = 0L;
            return;
        }
    }

    public h5() {
        this.type = MessageType.GAME_ROOM_SUGGESTION_MESSAGE;
    }

    public h5(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.floatWindow = new a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.GAME_ROOM_SUGGESTION_MESSAGE;
    }
}
