package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001#R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\t\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizReplyMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/x0;", "", "getInviteType", "()I", "setInviteType", "(I)V", "getInviteType$annotations", "()V", "inviteType", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "getBizType$annotations", "bizType", "getRepCode", "setRepCode", "getRepCode$annotations", "repCode", "Lcom/bytedance/android/livesdk/link/model/h5;", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "getLinkMicBizExtra$annotations", "linkMicBizExtra", "", "getRejectPrompts", "()Ljava/lang/String;", "setRejectPrompts", "(Ljava/lang/String;)V", "getRejectPrompts$annotations", "rejectPrompts", "ReplyType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkMicBizReplyMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.x0>, com.bytedance.android.livesdk.link.model.bridge.x0 {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizReplyMessage$ReplyType;", "", "Undefined", "Accept", "Reject", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ReplyType extends Enum<ReplyType> {
        public static final ReplyType Accept = null;
        public static final ReplyType Reject = null;
        public static final ReplyType Undefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReplyType[] f147049a = null;

        static {
            ReplyType r100 = new ReplyType("Undefined", 0);
            Undefined = r100;
            ReplyType r101 = new ReplyType("Accept", 1);
            Accept = r101;
            ReplyType r102 = new ReplyType("Reject", 2);
            Reject = r102;
            f147049a = new ReplyType[]{r100, r101, r102};
        }

        public static ReplyType valueOf(String r100) {
            return (ReplyType) r27.a.a(ReplyType.class, r100);
        }

        public static ReplyType[] values() {
            return (ReplyType[]) f147049a.clone();
        }

        public ReplyType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.x0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.x0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "biz_type")
    Integer getBizType();

    @Override // com.bytedance.android.livesdk.link.model.bridge.x0, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "battle_config_setting")
    h5 getLinkMicBizExtra();

    @FieldName(name = "reject_prompts")
    String getRejectPrompts();

    @FieldName(name = "rep_code")
    Integer getRepCode();

    @FieldName(name = "biz_type#setter")
    void setBizType(Integer r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.x0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "invite_type#setter")
    void setInviteType(int r100);

    @FieldName(name = "battle_config_setting#setter")
    void setLinkMicBizExtra(h5 r100);

    @FieldName(name = "reject_prompts#setter")
    void setRejectPrompts(String r100);

    @FieldName(name = "rep_code#setter")
    void setRepCode(Integer r100);
}
