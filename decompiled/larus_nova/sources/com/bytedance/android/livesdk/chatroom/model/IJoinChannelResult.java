package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001bR$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R&\u0010!\u001a\u00060\u0012j\u0002`\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R6\u0010*\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u00102\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\t\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\t\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010@\u001a\u00020:8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b?\u0010\t\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020A8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\t\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010K\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\t\u001a\u0004\bH\u0010\u0005\"\u0004\bI\u0010\u0007R$\u0010R\u001a\u0004\u0018\u00010L8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bQ\u0010\t\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR6\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020T`U8&X§\u0004¢\u0006\f\u0012\u0004\bX\u0010\t\u001a\u0004\bV\u0010WR$\u0010`\u001a\u0004\u0018\u00010Z8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b_\u0010\t\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IJoinChannelResult;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/i0;", "", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "getPrompt$annotations", "()V", EventConstant.Key.RETAIN_PROMPT, "Lcom/bytedance/android/livesdk/chatroom/model/a0;", "getDelegateSetting", "()Lcom/bytedance/android/livesdk/chatroom/model/a0;", "setDelegateSetting", "(Lcom/bytedance/android/livesdk/chatroom/model/a0;)V", "getDelegateSetting$annotations", "delegateSetting", "", "getPayCount", "()J", "setPayCount", "(J)V", "getPayCount$annotations", "payCount", "getLiveCoreSettings", "setLiveCoreSettings", "getLiveCoreSettings$annotations", "liveCoreSettings", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getVersion", "setVersion", "getVersion$annotations", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkedUsers", "()Ljava/util/List;", "setLinkedUsers", "(Ljava/util/List;)V", "getLinkedUsers$annotations", "linkedUsers", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffectKt;", "getMatchEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;", "setMatchEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IMatchEffect;)V", "getMatchEffect$annotations", "matchEffect", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "getCityEffect", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;", "setCityEffect", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ICityEffect;)V", "getCityEffect$annotations", "cityEffect", "", "getApplyType", "()I", "setApplyType", "(I)V", "getApplyType$annotations", "applyType", "", "getPaidLinkmic", "()Z", "setPaidLinkmic", "(Z)V", "getPaidLinkmic$annotations", "paidLinkmic", "getPromptWithEarphone", "setPromptWithEarphone", "getPromptWithEarphone$annotations", "promptWithEarphone", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "setLinkGameInfo", "(Lcom/bytedance/android/livesdk/link/model/c6;)V", "getLinkGameInfo$annotations", "linkGameInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUiInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "getClientUiInfo$annotations", "clientUiInfo", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IJoinChannelResult extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.i0>, com.bytedance.android.livesdk.link.model.bridge.i0 {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106891a = null;

        public a() {
        }

        static {
            f106891a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106891a;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    @FieldName(name = ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    int getApplyType();

    @FieldName(name = "city_effect")
    ICityEffect getCityEffect();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ ClientUIInfo getClientUIInfo();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "delegate_setting")
    a0 getDelegateSetting();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ ICityEffect getICityEffect();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ IMatchEffect getIMatchEffect();

    @FieldName(name = "link_game_info")
    c6 getLinkGameInfo();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    @FieldName(name = "linked_users")
    List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    @FieldName(name = "live_core_settings")
    String getLiveCoreSettings();

    @FieldName(name = "match_effect")
    IMatchEffect getMatchEffect();

    @FieldName(name = "is_paid_linkmic")
    boolean getPaidLinkmic();

    @FieldName(name = "pay_count")
    long getPayCount();

    @FieldName(name = EventConstant.Key.RETAIN_PROMPT)
    String getPrompt();

    @FieldName(name = "prompt_with_earphone")
    String getPromptWithEarphone();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ String getToken();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    @FieldName(name = "version")
    long getVersion();

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ boolean isPaidLinkmic();

    @FieldName(name = "apply_type#setter")
    void setApplyType(int r100);

    @FieldName(name = "city_effect#setter")
    void setCityEffect(ICityEffect r100);

    @FieldName(name = "client_ui_info#setter")
    void setClientUiInfo(ClientUIInfo r100);

    @FieldName(name = "delegate_setting#setter")
    void setDelegateSetting(a0 r100);

    @FieldName(name = "link_game_info#setter")
    void setLinkGameInfo(c6 r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    @FieldName(name = "linked_users#setter")
    void setLinkedUsers(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r100);

    @FieldName(name = "live_core_settings#setter")
    void setLiveCoreSettings(String r100);

    @FieldName(name = "match_effect#setter")
    void setMatchEffect(IMatchEffect r100);

    @FieldName(name = "is_paid_linkmic#setter")
    void setPaidLinkmic(boolean r100);

    @FieldName(name = "pay_count#setter")
    void setPayCount(long r100);

    @FieldName(name = "prompt#setter")
    void setPrompt(String r100);

    @FieldName(name = "prompt_with_earphone#setter")
    void setPromptWithEarphone(String r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.i0
    /* synthetic */ void setToken(String r100);

    @FieldName(name = "version#setter")
    void setVersion(long r100);
}
