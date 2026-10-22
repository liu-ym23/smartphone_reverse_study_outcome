package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002>?R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R.\u0010*\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\t\u001a\u0004\b'\u0010(R\"\u0010.\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\t\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\"\u00102\u001a\u00020\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\t\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\"\u00106\u001a\u00020\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\t\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R$\u0010=\u001a\u0004\u0018\u0001078&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\t\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizInviteMessage;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/w0;", "", "getInviteType", "()I", "setInviteType", "(I)V", "getInviteType$annotations", "()V", "inviteType", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "getBizType$annotations", "bizType", "", "getInviteUid", "()J", "setInviteUid", "(J)V", "getInviteUid$annotations", "inviteUid", "", "getInviteName", "()Ljava/lang/String;", "setInviteName", "(Ljava/lang/String;)V", "getInviteName$annotations", "inviteName", "Lcom/bytedance/android/livesdk/link/model/p;", "getInviteUser", "()Lcom/bytedance/android/livesdk/link/model/p;", "getInviteUser$annotations", "inviteUser", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "getInviteTitle", "setInviteTitle", "getInviteTitle$annotations", "inviteTitle", "getInviteSubTitle", "setInviteSubTitle", "getInviteSubTitle$annotations", "inviteSubTitle", "getWaitSec", "setWaitSec", "getWaitSec$annotations", "waitSec", "Lcom/bytedance/android/livesdk/link/model/h5;", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "getLinkMicBizExtra$annotations", "linkMicBizExtra", "BizInviteType", "InviteSource", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkMicBizInviteMessage extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w0>, com.bytedance.android.livesdk.link.model.bridge.w0 {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizInviteMessage$BizInviteType;", "", "", "type", "I", "getType", "()I", "BizInviteDefault", "BizInviteStart", "BizInviteReStart", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BizInviteType extends Enum<BizInviteType> {
        public static final BizInviteType BizInviteDefault = null;
        public static final BizInviteType BizInviteReStart = null;
        public static final BizInviteType BizInviteStart = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BizInviteType[] f147047a = null;
        private final int type;

        static {
            BizInviteType r100 = new BizInviteType("BizInviteDefault", 0, 0);
            BizInviteDefault = r100;
            BizInviteType r101 = new BizInviteType("BizInviteStart", 1, 1);
            BizInviteStart = r101;
            BizInviteType r102 = new BizInviteType("BizInviteReStart", 2, 2);
            BizInviteReStart = r102;
            f147047a = new BizInviteType[]{r100, r101, r102};
        }

        public static BizInviteType valueOf(String r100) {
            return (BizInviteType) r27.a.a(BizInviteType.class, r100);
        }

        public static BizInviteType[] values() {
            return (BizInviteType[]) f147047a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public BizInviteType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizInviteMessage$InviteSource;", "", "Default", "Start", "Restart", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum InviteSource extends Enum<InviteSource> {
        public static final InviteSource Default = null;
        public static final InviteSource Restart = null;
        public static final InviteSource Start = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InviteSource[] f147048a = null;

        static {
            InviteSource r100 = new InviteSource("Default", 0);
            Default = r100;
            InviteSource r101 = new InviteSource("Start", 1);
            Start = r101;
            InviteSource r102 = new InviteSource("Restart", 2);
            Restart = r102;
            f147048a = new InviteSource[]{r100, r101, r102};
        }

        public static InviteSource valueOf(String r100) {
            return (InviteSource) r27.a.a(InviteSource.class, r100);
        }

        public static InviteSource[] values() {
            return (InviteSource[]) f147048a.clone();
        }

        public InviteSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.w0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.w0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "biz_type")
    Integer getBizType();

    @Override // com.bytedance.android.livesdk.link.model.bridge.w0, yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_name")
    String getInviteName();

    @FieldName(name = "invite_sub_title")
    String getInviteSubTitle();

    @FieldName(name = "invite_title")
    String getInviteTitle();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "invite_uid")
    long getInviteUid();

    @FieldName(name = "invite_user")
    p getInviteUser();

    @FieldName(name = "link_mic_biz_extra")
    h5 getLinkMicBizExtra();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getTags();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    @FieldName(name = "biz_type#setter")
    void setBizType(Integer r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.w0
    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    @FieldName(name = "invite_name#setter")
    void setInviteName(String r100);

    @FieldName(name = "invite_sub_title#setter")
    void setInviteSubTitle(String r100);

    @FieldName(name = "invite_title#setter")
    void setInviteTitle(String r100);

    @FieldName(name = "invite_type#setter")
    void setInviteType(int r100);

    @FieldName(name = "invite_uid#setter")
    void setInviteUid(long r100);

    @FieldName(name = "link_mic_biz_extra#setter")
    void setLinkMicBizExtra(h5 r100);

    @FieldName(name = "wait_sec#setter")
    void setWaitSec(long r100);
}
