package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001aR\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/o0;", "Lvh7/c;", "", "", "getAction", "()J", "setAction", "(J)V", "getAction$annotations", "()V", "action", "", "getTips", "()Ljava/lang/String;", "getTips$annotations", "tips", "Lcom/bytedance/android/live/base/model/message/o0$b;", "getExtraInfo", "()Lcom/bytedance/android/live/base/model/message/o0$b;", "getExtraInfo$annotations", "extraInfo", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getPublicAreaCommon$annotations", "publicAreaCommon", "b", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o0 extends vh7.c<o0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/o0$b;", "Lvh7/c;", "", "getBanInfoUrl", "()Ljava/lang/String;", "getBanInfoUrl$annotations", "()V", "banInfoUrl", "", "getReasonNo", "()J", "getReasonNo$annotations", "reasonNo", "Lcom/bytedance/android/live/base/model/message/a5;", "getTitle", "()Lcom/bytedance/android/live/base/model/message/a5;", "getTitle$annotations", "title", "getViolationReason", "getViolationReason$annotations", "violationReason", "getIllegalText", "getIllegalText$annotations", "illegalText", "getSource", "getSource$annotations", "source", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "ban_info_url")
        String getBanInfoUrl();

        @FieldName(name = "content")
        a5 getIllegalText();

        @FieldName(name = "reason_no")
        long getReasonNo();

        @FieldName(name = "source")
        String getSource();

        @FieldName(name = "title")
        a5 getTitle();

        @FieldName(name = "violation_reason")
        a5 getViolationReason();
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "action")
    long getAction();

    @FieldName(name = "extra")
    b getExtraInfo();

    @FieldName(name = "public_area_common")
    IPublicAreaCommon getPublicAreaCommon();

    @FieldName(name = "tips")
    String getTips();

    @FieldName(name = "action#setter")
    void setAction(long r100);
}
