package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ProfileViewData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ProfileViewData;", "", "()V", "showDuration", "", "getShowDuration", "()J", "setShowDuration", "(J)V", "source", "", "getSource", "()I", "setSource", "(I)V", "subTitle", "Lcom/bytedance/android/livesdkapi/message/Text;", "getSubTitle", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setSubTitle", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "title", "getTitle", d.f25925o, "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfileViewData implements h {
    public static final Companion Companion = null;
    public static final int SOURCE_AppointmentData = 2;
    public static final int SOURCE_FansclubIntimacyIncreased = 1;
    public static final int SOURCE_Undefined = 0;

    @SerializedName("show_duration")
    protected long showDuration;

    @SerializedName("source")
    protected int source;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected Text subTitle;

    @SerializedName("title")
    protected Text title;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ProfileViewData$Companion;", "", "()V", "SOURCE_AppointmentData", "", "SOURCE_FansclubIntimacyIncreased", "SOURCE_Undefined", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ProfileViewData() {
    }

    public final long getShowDuration() {
        return this.showDuration;
    }

    public final int getSource() {
        return this.source;
    }

    public final Text getSubTitle() {
        return this.subTitle;
    }

    public final Text getTitle() {
        return this.title;
    }

    public ProfileViewData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 2) goto L8;
        this.title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.subTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.showDuration = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L13;
        this.source = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setShowDuration(long r100) {
        this.showDuration = r100;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public final void setSubTitle(Text r100) {
        this.subTitle = r100;
    }

    public final void setTitle(Text r100) {
        this.title = r100;
    }
}
