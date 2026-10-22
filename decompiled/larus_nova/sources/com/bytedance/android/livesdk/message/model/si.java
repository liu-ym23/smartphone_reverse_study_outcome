package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.QuizAnchorStatusMessage")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/si;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/si$a;", "items", "Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class si extends o0 implements vh7.h {

    @SerializedName("items")
    protected List<a> items;

    @ProtoMessage("webcast.data.AnchorHistoryItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/si$a;", "", "", "quizId", "Ljava/lang/String;", "getQuizId", "()Ljava/lang/String;", "setQuizId", "(Ljava/lang/String;)V", "quizTitle", "getQuizTitle", "setQuizTitle", "options", "getOptions", "setOptions", "", "quizStatus", "I", "getQuizStatus", "()I", "setQuizStatus", "(I)V", "", "countDownTime", "J", "getCountDownTime", "()J", "setCountDownTime", "(J)V", "winOption", "getWinOption", "setWinOption", GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplateId", "setTemplateId", "failReason", "getFailReason", "setFailReason", "createTime", "getCreateTime", "setCreateTime", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("countdown_time")
        protected long countDownTime;

        @SerializedName("create_time")
        protected long createTime;

        @SerializedName("fail_reason")
        protected String failReason;

        @SerializedName("options")
        protected String options;

        @SerializedName("quiz_id")
        protected String quizId;

        @SerializedName("quiz_status")
        protected int quizStatus;

        @SerializedName("quiz_title")
        protected String quizTitle;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
        protected String templateId;

        @SerializedName("win_option")
        protected long winOption;

        public a() {
            this.quizId = "";
            this.quizTitle = "";
            this.options = "";
            this.quizStatus = -1;
            this.winOption = -1;
            this.templateId = "";
            this.failReason = "";
        }

        public a(am3.g r100) {
            long r101 = r100.c();
            int r102 = 0;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L16;
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            this.createTime = r100.j();
            goto L3
        L8:
            this.failReason = am3.h.c(r100);
            goto L3
        L9:
            this.templateId = am3.h.c(r100);
            goto L3
        L10:
            this.winOption = r100.j();
            r102 = r102 | 2;
            goto L3
        L11:
            this.countDownTime = r100.j();
            goto L3
        L12:
            this.quizStatus = r100.i();
            r102 = r102 | 1;
            goto L3
        L13:
            this.options = am3.h.c(r100);
            goto L3
        L14:
            this.quizTitle = am3.h.c(r100);
            goto L3
        L15:
            this.quizId = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L16:
            r100.d(r101);
            if (this.quizId != null) goto L20;
            this.quizId = "";
        L20:
            if (this.quizTitle != null) goto L23;
            this.quizTitle = "";
        L23:
            if (this.options != null) goto L26;
            this.options = "";
        L26:
            if ((r102 & 1) != 0) goto L29;
            this.quizStatus = -1;
        L29:
            if ((r102 & 2) != 0) goto L32;
            this.winOption = -1;
        L32:
            if (this.templateId != null) goto L35;
            this.templateId = "";
        L35:
            if (this.failReason != null) goto L60;
            this.failReason = "";
            return;
        }
    }

    public si() {
        this.type = MessageType.PREDICTOR_ANCHOR_STATUS_MESSAGE;
    }

    public final List<a> E() {
        return this.items;
    }

    public si(am3.g r100) {
        this.items = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.items.add(new a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.PREDICTOR_ANCHOR_STATUS_MESSAGE;
    }
}
