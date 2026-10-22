package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.QuizBeginMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ui;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/ui$a;", "mQuizInfoList", "Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "setMQuizInfoList", "(Ljava/util/List;)V", "", "quizID", "J", "getQuizID", "()J", "setQuizID", "(J)V", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ui extends o0 implements vh7.h {

    @SerializedName("quizInfos")
    protected List<a> mQuizInfoList;

    @SerializedName("quizID")
    protected long quizID;

    @SerializedName("status")
    protected int status;

    @ProtoMessage("webcast.im.AllQuizInfo")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ui$a;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", DyPayConstant.KEY_START_TIME, "b", "setStartTime", "duration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDuration", "status", "c", "setStatus", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("duration")
        protected long duration;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        protected long f153700id;

        @SerializedName(DyPayConstant.KEY_START_TIME)
        protected long startTime;

        @SerializedName("status")
        protected long status;

        @SerializedName("title")
        protected String title;

        public a() {
            this.title = "";
        }

        public final long a() {
            return this.duration;
        }

        public final long b() {
            return this.startTime;
        }

        public final long c() {
            return this.status;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.f153700id = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.title = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.startTime = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.duration = r100.j();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.status = r100.j();
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
            if (this.title != null) goto L43;
            this.title = "";
            return;
        }
    }

    public ui() {
        this.status = -1;
        this.type = MessageType.GAME_GUESS_PREDICTOR_START_MESSAGE;
    }

    public final List<a> E() {
        return this.mQuizInfoList;
    }

    public ui(am3.g r100) {
        this.mQuizInfoList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.quizID = r100.j();
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.status = r100.i();
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.mQuizInfoList.add(new a(r100));
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & true) == true) goto L20;
        this.status = -1;
    L20:
        this.type = MessageType.GAME_GUESS_PREDICTOR_START_MESSAGE;
    }
}
