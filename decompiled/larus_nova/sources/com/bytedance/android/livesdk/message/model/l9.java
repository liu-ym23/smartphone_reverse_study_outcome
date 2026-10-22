package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l9;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "getLinkmicSubtitleSettingStatus", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "getLinkmicSubtitleSettingStatus$annotations", "()V", "linkmicSubtitleSettingStatus", "", "Lcom/bytedance/android/livesdk/message/model/f9;", "getLinkmicChestGameStatusList", "()Ljava/util/List;", "getLinkmicChestGameStatusList$annotations", "linkmicChestGameStatusList", "Lcom/bytedance/android/livesdk/message/model/pc;", "getInteractActingMessage", "()Lcom/bytedance/android/livesdk/message/model/pc;", "getInteractActingMessage$annotations", "interactActingMessage", "", "getWrdsSubKeyFlex", "()Ljava/lang/String;", "wrdsSubKeyFlex", "", "getMessageIdFlex", "()J", "messageIdFlex", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l9 extends vh7.c<l9> {
    public static final a Companion = null;
    public static final String SUB_KEY_CHEST_GAME = "ChestGameSubSyncKey";
    public static final String SUB_KEY_INTERACTACTING = "InteractActingSubSyncKey";
    public static final String SUB_KEY_SUBTITLE = "SubtitleStatusSubSyncKey";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153664a = null;

        public a() {
        }

        static {
            f153664a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153664a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "interact_acting_message")
    pc getInteractActingMessage();

    @FieldName(name = "linkmic_chest_game_status_list")
    List<f9> getLinkmicChestGameStatusList();

    @FieldName(name = "linkmic_subtitle_status")
    com.bytedance.android.livesdk.chatroom.model.interact.q2 getLinkmicSubtitleSettingStatus();

    long getMessageIdFlex();

    String getWrdsSubKeyFlex();
}
