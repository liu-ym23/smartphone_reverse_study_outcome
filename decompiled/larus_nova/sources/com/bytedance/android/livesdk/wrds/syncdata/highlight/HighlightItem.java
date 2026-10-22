package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.HighlightItem")
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0007fghijklB\u0007¢\u0006\u0004\be\u0010KR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010G\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bG\u0010\u0004\u0012\u0004\bJ\u0010K\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR0\u0010U\u001a\u0010\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020T\u0018\u00010S8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010d\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006m"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "", "", "itemId", "J", "getItemId", "()J", "setItemId", "(J)V", "version", "getVersion", "setVersion", "endTime", "getEndTime", "setEndTime", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$g;", "position", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$g;", "getPosition", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$g;", "setPosition", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$g;)V", "", "dataType", "I", "getDataType", "()I", "setDataType", "(I)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$b;", "appointmentData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$b;", "getAppointmentData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$b;", "setAppointmentData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$b;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$a;", "answerData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$a;", "getAnswerData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$a;", "setAnswerData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$a;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$c;", "commentData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$c;", "getCommentData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$c;", "setCommentData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$c;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$f;", "videoData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$f;", "getVideoData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$f;", "setVideoData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$f;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$e;", "microAppData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$e;", "getMicroAppData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$e;", "setMicroAppData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$e;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataCommonPictureText;", "commonPictureTextData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataCommonPictureText;", "getCommonPictureTextData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataCommonPictureText;", "setCommonPictureTextData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataCommonPictureText;)V", "showTime", "getShowTime", "setShowTime", "getShowTime$annotations", "()V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$d;", "imData", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$d;", "getImData", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$d;", "setImData", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$d;)V", "", "", "buriedPoint", "Ljava/util/Map;", "getBuriedPoint", "()Ljava/util/Map;", "setBuriedPoint", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "getUniqueKey", "()Ljava/lang/String;", "uniqueKey", "<init>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", ce.f26391f, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightItem implements h {

    @SerializedName("answer_data")
    protected a answerData;

    @SerializedName("appointment_data")
    protected b appointmentData;

    @SerializedName("buried_point")
    protected Map<String, String> buriedPoint;

    @SerializedName("comment_data")
    protected c commentData;

    @SerializedName("common_picture_text_data")
    protected HighlightDataCommonPictureText commonPictureTextData;

    @SerializedName("data_type")
    protected int dataType;

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig highlightAreaPriorityConfig;

    @SerializedName("im_common_data")
    protected d imData;

    @SerializedName("item_id")
    protected long itemId;

    @SerializedName("micro_app_data")
    protected e microAppData;

    @SerializedName("position")
    protected g position;
    private transient long showTime;

    @SerializedName("version")
    protected long version;

    @SerializedName("video_data")
    protected f videoData;

    @ProtoMessage("webcast.im.HighlightDataAnswer")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\b¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$a;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "answerId", "J", "b", "()J", "setAnswerId", "(J)V", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, RXScreenCaptureService.KEY_INDEX, "setQuestion", "answer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnswer", "audienceNumber", "d", "setAudienceNumber", "audienceNumberStr", "e", "setAudienceNumberStr", "nickName", "h", "setNickName", "anchorId", "getAnchorId", "setAnchorId", "commenterId", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "setCommenterId", "(Ljava/lang/Long;)V", "questionMsgId", ce.f26395j, "setQuestionMsgId", "answerMsgId", "c", "setAnswerMsgId", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "common", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", ce.f26391f, "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "AnswerOpenId", "getAnswerOpenId", "setAnswerOpenId", "CommenterOpenId", "getCommenterOpenId", "setCommenterOpenId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends com.bytedance.android.livesdk.wrds.syncdata.highlight.a implements h {

        @SerializedName("answer_open_id")
        protected String AnswerOpenId;

        @SerializedName("commenter_open_id")
        protected String CommenterOpenId;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient long f162526a;

        @SerializedName("anchor_id")
        protected long anchorId;

        @SerializedName("answer")
        protected String answer;

        @SerializedName("answer_id")
        protected long answerId;

        @SerializedName("answer_msg_id")
        protected long answerMsgId;

        @SerializedName("audience_number")
        protected long audienceNumber;

        @SerializedName("audience_number_str")
        protected String audienceNumberStr;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient boolean f162527b;

        @SerializedName("commenter_id")
        protected Long commenterId;

        @SerializedName("pin_common")
        protected PinCommon common;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_QUESTION)
        protected String question;

        @SerializedName("question_msg_id")
        protected long questionMsgId;

        @SerializedName("scene")
        protected String scene;

        public a() {
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final String getCommentContent() {
            return null;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getMessageId() {
            return 0;
        }

        public final String a() {
            return this.answer;
        }

        public final long b() {
            return this.answerId;
        }

        public final long c() {
            return this.answerMsgId;
        }

        public final long d() {
            return this.audienceNumber;
        }

        public final String e() {
            return this.audienceNumberStr;
        }

        public final Long f() {
            return this.commenterId;
        }

        public final PinCommon g() {
            return this.common;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a, com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getReviewingTime() {
            return this.f162526a;
        }

        public final String h() {
            return this.nickName;
        }

        public final String i() {
            return this.question;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a, com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final boolean isReviewing() {
            return this.f162527b;
        }

        public final long j() {
            return this.questionMsgId;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L27;
            if (r102 != 255) goto L8;
            this.common = new PinCommon(r100);
            goto L3
        L8:
            if (r102 != 5001) goto L10;
            this.AnswerOpenId = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 5002) goto L11;
            this.CommenterOpenId = am3.h.c(r100);
            goto L3
        L11:
            switch(r102) {
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                default: goto L12;
            };
        L13:
            this.answerMsgId = r100.j();
            goto L3
        L14:
            this.questionMsgId = r100.j();
            goto L3
        L15:
            this.commenterId = Long.valueOf(r100.j());
            goto L3
        L16:
            this.anchorId = r100.j();
            goto L3
        L17:
            this.nickName = am3.h.c(r100);
            goto L3
        L18:
            this.audienceNumberStr = am3.h.c(r100);
            goto L3
        L19:
            this.audienceNumber = r100.j();
            goto L3
        L20:
            this.answer = am3.h.c(r100);
            goto L3
        L21:
            this.question = am3.h.c(r100);
            goto L3
        L22:
            this.answerId = r100.j();
            goto L3
        L23:
            this.scene = am3.h.c(r100);
            goto L3
        L12:
            am3.h.e(r100);
            goto L3
        L27:
            r100.d(r101);
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a
        public final void setReviewing(boolean r100) {
            this.f162527b = r100;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a
        public final void setReviewingTime(long r100) {
            this.f162526a = r100;
        }
    }

    @ProtoMessage("webcast.im.HighlightDataAppointment")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R*\u0010.\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010%\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R$\u00107\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R$\u0010:\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019R$\u0010=\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$b;", "", "", "time", "J", ce.f26391f, "()J", "setTime", "(J)V", "", "isDemotion", "Z", ce.f26395j, "()Z", "setDemotion", "(Z)V", "anchorUid", "getAnchorUid", "setAnchorUid", "", "anchorOpenId", "Ljava/lang/String;", "getAnchorOpenId", "()Ljava/lang/String;", "setAnchorOpenId", "(Ljava/lang/String;)V", "currentNumber", "b", "setCurrentNumber", "timeText", RXScreenCaptureService.KEY_INDEX, "setTimeText", "appointmentId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAppointmentId", "", "scheduleTime", "I", "getScheduleTime", "()I", "setScheduleTime", "(I)V", "scheduleDate", "getScheduleDate", "setScheduleDate", "", "scheduleWeekdays", "Ljava/util/List;", "f", "()Ljava/util/List;", "setScheduleWeekdays", "(Ljava/util/List;)V", "duration", "d", "setDuration", "dateString", "c", "setDateString", "timeString", "h", "setTimeString", "hasRedPackage", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "setHasRedPackage", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("anchor_open_id")
        protected String anchorOpenId;

        @SerializedName("anchor_uid")
        protected long anchorUid;

        @SerializedName("appointment_id")
        protected long appointmentId;

        @SerializedName("current_number")
        protected long currentNumber;

        @SerializedName("date_text")
        protected String dateString;

        @SerializedName("show_duration")
        protected int duration;

        @IgnoreProtoFieldCheck
        @SerializedName("has_red_packet")
        protected Boolean hasRedPackage;

        @SerializedName("demotion")
        protected boolean isDemotion;

        @SerializedName("scheduled_date")
        protected int scheduleDate;

        @SerializedName("scheduled_time")
        protected int scheduleTime;

        @SerializedName("scheduled_weekdays")
        protected List<Integer> scheduleWeekdays;

        @SerializedName("appointment_timestamp")
        protected long time;

        @SerializedName("time_text")
        protected String timeString;

        @SerializedName("text")
        protected String timeText;

        public b() {
        }

        public final long a() {
            return this.appointmentId;
        }

        public final long b() {
            return this.currentNumber;
        }

        public final String c() {
            return this.dateString;
        }

        public final int d() {
            return this.duration;
        }

        public final Boolean e() {
            return this.hasRedPackage;
        }

        public final List<Integer> f() {
            return this.scheduleWeekdays;
        }

        public final long g() {
            return this.time;
        }

        public final String h() {
            return this.timeString;
        }

        public final String i() {
            return this.timeText;
        }

        public final boolean j() {
            return this.isDemotion;
        }

        public b(am3.g r100) {
            this.scheduleWeekdays = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L23;
            if (r102 != 5000) goto L7;
            this.anchorOpenId = am3.h.c(r100);
            goto L3
        L7:
            switch(r102) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                default: goto L8;
            };
        L9:
            this.hasRedPackage = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L10:
            this.timeString = am3.h.c(r100);
            goto L3
        L11:
            this.dateString = am3.h.c(r100);
            goto L3
        L12:
            this.duration = r100.i();
            goto L3
        L13:
            this.scheduleWeekdays.add(Integer.valueOf(r100.i()));
            goto L3
        L14:
            this.scheduleDate = r100.i();
            goto L3
        L15:
            this.scheduleTime = r100.i();
            goto L3
        L16:
            this.appointmentId = r100.j();
            goto L3
        L17:
            this.timeText = am3.h.c(r100);
            goto L3
        L18:
            this.currentNumber = r100.j();
            goto L3
        L19:
            this.anchorUid = r100.j();
            goto L3
        L20:
            this.isDemotion = am3.h.a(r100);
            goto L3
        L21:
            this.time = r100.j();
            goto L3
        L8:
            am3.h.e(r100);
            goto L3
        L23:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.HighlightDataComment")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\"\u0010\u0018\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$c;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "chatId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setChatId", "(J)V", "content", "d", "setContent", "nickName", "e", "setNickName", "commenterId", "CommenterOpenId", "messageId", "getMessageId", "setMessageId", "preId", "f", "setPreId", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "common", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "c", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c extends com.bytedance.android.livesdk.wrds.syncdata.highlight.a implements h {

        @SerializedName("commenter_open_id")
        protected String CommenterOpenId;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient long f162528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public transient boolean f162529b;

        @SerializedName("chat_id")
        protected long chatId;

        @SerializedName("commenter_id")
        protected long commenterId;

        @SerializedName("pin_common")
        protected PinCommon common;

        @SerializedName("content")
        protected String content;

        @SerializedName("msg_id")
        protected long messageId;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName("pre_id")
        protected long preId;

        @SerializedName("scene")
        protected String scene;

        public c() {
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final String getCommentContent() {
            return null;
        }

        public final String b() {
            o0.a r100 = o0.f58946a;
            Long r101 = Long.valueOf(this.commenterId);
            String r102 = this.CommenterOpenId;
            r100.getClass();
            return o0.a.g(r101, r102);
        }

        public final long a() {
            return this.chatId;
        }

        public final PinCommon c() {
            return this.common;
        }

        public final String d() {
            return this.content;
        }

        public final String e() {
            return this.nickName;
        }

        public final long f() {
            return this.preId;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getMessageId() {
            return this.messageId;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a, com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getReviewingTime() {
            return this.f162528a;
        }

        public final String getScene() {
            return this.scene;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a, com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final boolean isReviewing() {
            return this.f162529b;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L20;
            if (r102 != 255) goto L8;
            this.common = new PinCommon(r100);
            goto L3
        L8:
            if (r102 != 5000) goto L9;
            this.CommenterOpenId = am3.h.c(r100);
            goto L3
        L9:
            switch(r102) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L11:
            this.preId = r100.j();
            goto L3
        L12:
            this.messageId = r100.j();
            goto L3
        L13:
            this.commenterId = r100.j();
            goto L3
        L14:
            this.nickName = am3.h.c(r100);
            goto L3
        L15:
            this.content = am3.h.c(r100);
            goto L3
        L16:
            this.chatId = r100.j();
            goto L3
        L17:
            this.scene = am3.h.c(r100);
            goto L3
        L10:
            am3.h.e(r100);
            goto L3
        L20:
            r100.d(r101);
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a
        public final void setReviewing(boolean r100) {
            this.f162529b = r100;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.a
        public final void setReviewingTime(long r100) {
            this.f162528a = r100;
        }
    }

    @ProtoMessage("webcast.im.HighlightDataImCommon")
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$d;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "pinId", "J", "getPinId", "()J", "setPinId", "(J)V", "messageId", "getMessageId", "setMessageId", "title", "d", com.alipay.sdk.m.x.d.f25925o, "Lcom/bytedance/android/livesdkapi/message/Text;", "displayText", "Lcom/bytedance/android/livesdkapi/message/Text;", "b", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "common", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "style", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "c", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "setStyle", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends com.bytedance.android.livesdk.wrds.syncdata.highlight.a implements h {

        @SerializedName("pin_common")
        protected PinCommon common;

        @SerializedName("display_text")
        protected Text displayText;

        @SerializedName("msg_id")
        protected long messageId;

        @SerializedName("pin_id")
        protected long pinId;

        @SerializedName("scene")
        protected String scene;

        @SerializedName("picture_text_style")
        protected PictureTextStyle style;

        @SerializedName("title")
        protected String title;

        public d() {
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final String getCommentContent() {
            return null;
        }

        public final PinCommon a() {
            return this.common;
        }

        public final Text b() {
            return this.displayText;
        }

        public final PictureTextStyle c() {
            return this.style;
        }

        public final String d() {
            return this.title;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getMessageId() {
            return this.messageId;
        }

        public final long getPinId() {
            return this.pinId;
        }

        public final String getScene() {
            return this.scene;
        }

        public d(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L27;
            if (r102 != 1) goto L8;
            this.scene = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.pinId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.messageId = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.title = am3.h.c(r100);
            goto L3
        L14:
            if (r102 != 5) goto L16;
            this.displayText = _Text_ProtoDecoder.decodeStatic(r100);
            goto L3
        L16:
            if (r102 != 100) goto L18;
            this.style = new PictureTextStyle(r100);
            goto L3
        L18:
            if (r102 != 255) goto L19;
            this.common = new PinCommon(r100);
            goto L3
        L19:
            am3.h.e(r100);
            goto L3
        L27:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.HighlightDataMicroApp")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$e;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "pinId", "J", "getPinId", "()J", "setPinId", "(J)V", "messageId", "getMessageId", "setMessageId", "microAppAvatar", "b", "setMicroAppAvatar", "microAppName", "d", "setMicroAppName", "commentContent", "getCommentContent", "setCommentContent", "schema", "f", "setSchema", "nickName", "e", "setNickName", "microAppId", "c", "setMicroAppId", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "common", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e extends com.bytedance.android.livesdk.wrds.syncdata.highlight.a implements h {

        @SerializedName("micro_app_introduction")
        protected String commentContent;

        @SerializedName("pin_common")
        protected PinCommon common;

        @SerializedName("msg_id")
        protected long messageId;

        @SerializedName("micro_app_avatar")
        protected String microAppAvatar;

        @SerializedName("micro_app_id")
        protected String microAppId;

        @SerializedName("micro_app_name")
        protected String microAppName;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName("pin_id")
        protected long pinId;

        @SerializedName("scene")
        protected String scene;

        @SerializedName("schema")
        protected String schema;

        public e() {
        }

        public final PinCommon a() {
            return this.common;
        }

        public final String b() {
            return this.microAppAvatar;
        }

        public final String c() {
            return this.microAppId;
        }

        public final String d() {
            return this.microAppName;
        }

        public final String e() {
            return this.nickName;
        }

        public final String f() {
            return this.schema;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final String getCommentContent() {
            return this.commentContent;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getMessageId() {
            return this.messageId;
        }

        public final long getPinId() {
            return this.pinId;
        }

        public e(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L19;
            if (r102 != 255) goto L7;
            this.common = new PinCommon(r100);
            goto L3
        L7:
            switch(r102) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                default: goto L8;
            };
        L9:
            this.nickName = am3.h.c(r100);
            goto L3
        L10:
            this.schema = am3.h.c(r100);
            goto L3
        L11:
            this.commentContent = am3.h.c(r100);
            goto L3
        L12:
            this.microAppName = am3.h.c(r100);
            goto L3
        L13:
            this.microAppAvatar = am3.h.c(r100);
            goto L3
        L14:
            this.microAppId = am3.h.c(r100);
            goto L3
        L15:
            this.messageId = r100.j();
            goto L3
        L16:
            this.pinId = r100.j();
            goto L3
        L17:
            this.scene = am3.h.c(r100);
            goto L3
        L8:
            am3.h.e(r100);
            goto L3
        L19:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.HighlightDataVideo")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u000bR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$f;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "videoPinId", "J", ce.f26391f, "()J", "setVideoPinId", "(J)V", "url", "f", "setUrl", "itemId", "b", "setItemId", "itemType", "getItemType", "setItemType", "title", "e", com.alipay.sdk.m.x.d.f25925o, "nickName", "c", "setNickName", "messageId", "getMessageId", "setMessageId", "role", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "common", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f extends com.bytedance.android.livesdk.wrds.syncdata.highlight.a implements h {

        @SerializedName("pin_common")
        protected PinCommon common;

        @SerializedName("item_id")
        protected long itemId;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
        protected long itemType;

        @SerializedName("msg_id")
        protected long messageId;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName("role")
        protected long role;

        @SerializedName("scene")
        protected String scene;

        @SerializedName("title")
        protected String title;

        @SerializedName("url")
        protected String url;

        @SerializedName("video_pin_id")
        protected long videoPinId;

        public f() {
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final String getCommentContent() {
            return null;
        }

        public final String d() {
            long r100 = this.role;
            if (r100 != 1) goto L6;
            return "anchor";
        L6:
            if (r100 != 2) goto L8;
            return "guest";
        L8:
            return "";
        }

        public final PinCommon a() {
            return this.common;
        }

        public final long b() {
            return this.itemId;
        }

        public final String c() {
            return this.nickName;
        }

        public final String e() {
            return this.title;
        }

        public final String f() {
            return this.url;
        }

        public final long g() {
            return this.videoPinId;
        }

        @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
        public final long getMessageId() {
            return this.messageId;
        }

        public final String getScene() {
            return this.scene;
        }

        public f(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L19;
            if (r102 != 255) goto L7;
            this.common = new PinCommon(r100);
            goto L3
        L7:
            switch(r102) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                default: goto L8;
            };
        L9:
            this.role = r100.j();
            goto L3
        L10:
            this.messageId = r100.j();
            goto L3
        L11:
            this.nickName = am3.h.c(r100);
            goto L3
        L12:
            this.title = am3.h.c(r100);
            goto L3
        L13:
            this.itemType = r100.j();
            goto L3
        L14:
            this.itemId = r100.j();
            goto L3
        L15:
            this.url = am3.h.c(r100);
            goto L3
        L16:
            this.videoPinId = r100.j();
            goto L3
        L17:
            this.scene = am3.h.c(r100);
            goto L3
        L8:
            am3.h.e(r100);
            goto L3
        L19:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.Position")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem$g;", "", "", "x", "D", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()D", "c", "(D)V", "y", "b", "d", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g implements h {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("position_x")
        protected double f162530x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("position_y")
        protected double f162531y;

        public g() {
        }

        public final double a() {
            return this.f162530x;
        }

        public final double b() {
            return this.f162531y;
        }

        public g(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.f162530x = Double.longBitsToDouble(r100.h());
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.f162531y = Double.longBitsToDouble(r100.h());
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void c(double r100) {
            this.f162530x = r100;
        }

        public final void d(double r100) {
            this.f162531y = r100;
        }
    }

    public HighlightItem() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getShowTime$annotations() {
    }

    public final String getUniqueKey() {
        long r100 = 0;
        if (this.dataType != HighlightDataType.Comment.getDataType()) goto L9;
        c r101 = this.commentData;
        if (r101 == null) goto L34;
        Intrinsics.checkNotNull(r101);
        r100 = r101.messageId;
    L34:
        return String.valueOf(r100);
    L9:
        if (this.dataType != HighlightDataType.Answer.getDataType()) goto L15;
        a r102 = this.answerData;
        if (r102 == null) goto L35;
        Intrinsics.checkNotNull(r102);
        r100 = r102.answerId;
    L35:
        return String.valueOf(r100);
    L15:
        if (this.dataType != HighlightDataType.Video.getDataType()) goto L21;
        f r103 = this.videoData;
        if (r103 == null) goto L36;
        Intrinsics.checkNotNull(r103);
        r100 = r103.messageId;
    L36:
        return String.valueOf(r100);
    L21:
        if (this.dataType != HighlightDataType.MicroApp.getDataType()) goto L27;
        e r104 = this.microAppData;
        if (r104 == null) goto L37;
        Intrinsics.checkNotNull(r104);
        r100 = r104.messageId;
    L37:
        return String.valueOf(r100);
    L27:
        if (this.dataType != HighlightDataType.Im.getDataType()) goto L33;
        d r105 = this.imData;
        if (r105 == null) goto L38;
        Intrinsics.checkNotNull(r105);
        r100 = r105.messageId;
    L38:
        return String.valueOf(r100);
    L33:
        return String.valueOf(hashCode());
    }

    public final a getAnswerData() {
        return this.answerData;
    }

    public final b getAppointmentData() {
        return this.appointmentData;
    }

    public final Map<String, String> getBuriedPoint() {
        return this.buriedPoint;
    }

    public final c getCommentData() {
        return this.commentData;
    }

    public final HighlightDataCommonPictureText getCommonPictureTextData() {
        return this.commonPictureTextData;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this.highlightAreaPriorityConfig;
    }

    public final d getImData() {
        return this.imData;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final e getMicroAppData() {
        return this.microAppData;
    }

    public final g getPosition() {
        return this.position;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public final long getVersion() {
        return this.version;
    }

    public final f getVideoData() {
        return this.videoData;
    }

    public HighlightItem(am3.g r110) {
        this.buriedPoint = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L52;
        if (r101 != 1) goto L8;
        this.itemId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.version = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.endTime = r110.j();
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.position = new g(r110);
        goto L3
    L14:
        if (r101 != 5) goto L16;
        this.highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r110);
        goto L3
    L16:
        if (r101 != 100) goto L18;
        this.dataType = r110.i();
        goto L3
    L18:
        if (r101 != 199) goto L20;
        this.commonPictureTextData = new HighlightDataCommonPictureText(r110);
        goto L3
    L20:
        if (r101 != 200) goto L21;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L30:
        int r105 = r110.f();
        if (r105 == (-1)) goto L37;
        if (r105 != 1) goto L33;
        r103 = am3.h.c(r110);
        goto L30
    L33:
        if (r105 != 2) goto L34;
        r104 = am3.h.c(r110);
        goto L30
    L34:
        am3.h.e(r110);
        goto L30
    L37:
        r110.d(r102);
        Map<String, String> r106 = this.buriedPoint;
        if (r103 == null) goto L44;
        if (r104 == null) goto L42;
        r106.put(r103, r104);
        goto L3
    L42:
        throw new IllegalStateException("Value must not be null");
    L44:
        throw new IllegalStateException("Key must not be null");
    L21:
        switch(r101) {
            case 102: goto L28;
            case 103: goto L27;
            case 104: goto L26;
            case 105: goto L25;
            case 106: goto L24;
            case 107: goto L23;
            default: goto L22;
        };
    L23:
        this.imData = new d(r110);
        goto L3
    L24:
        this.microAppData = new e(r110);
        goto L3
    L25:
        this.videoData = new f(r110);
        goto L3
    L26:
        this.commentData = new c(r110);
        goto L3
    L27:
        this.answerData = new a(r110);
        goto L3
    L28:
        this.appointmentData = new b(r110);
        goto L3
    L22:
        am3.h.e(r110);
        goto L3
    L52:
        r110.d(r100);
    }

    public final void setAnswerData(a r100) {
        this.answerData = r100;
    }

    public final void setAppointmentData(b r100) {
        this.appointmentData = r100;
    }

    public final void setBuriedPoint(Map<String, String> r100) {
        this.buriedPoint = r100;
    }

    public final void setCommentData(c r100) {
        this.commentData = r100;
    }

    public final void setCommonPictureTextData(HighlightDataCommonPictureText r100) {
        this.commonPictureTextData = r100;
    }

    public final void setDataType(int r100) {
        this.dataType = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r100) {
        this.highlightAreaPriorityConfig = r100;
    }

    public final void setImData(d r100) {
        this.imData = r100;
    }

    public final void setItemId(long r100) {
        this.itemId = r100;
    }

    public final void setMicroAppData(e r100) {
        this.microAppData = r100;
    }

    public final void setPosition(g r100) {
        this.position = r100;
    }

    public final void setShowTime(long r100) {
        this.showTime = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }

    public final void setVideoData(f r100) {
        this.videoData = r100;
    }
}
