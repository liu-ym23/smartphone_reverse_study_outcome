package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR:\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015RB\u0010\u001d\u001a*\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0012j\u0014\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001e\u0010!\u001a\u00060\u0018j\u0002`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004R\u001a\u0010,\u001a\u00020(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent;", "Lvh7/c;", "", "getFromUid", "()Ljava/lang/String;", "getFromUid$annotations", "()V", "fromUid", "getToUid", "getToUid$annotations", "toUid", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMLinkUsers", "()Ljava/util/List;", "getMLinkUsers$annotations", "mLinkUsers", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getUpdateInfo", "()Ljava/util/Map;", "getUpdateInfo$annotations", "updateInfo", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "getLinkerContentMap$annotations", "linkerContentMap", "getVersion", "()J", "getVersion$annotations", "version", "getExtra", "getExtra$annotations", "extra", "getAckMessage", "getAckMessage$annotations", "ackMessage", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUiInfo$annotations", "clientUiInfo", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerUpdateUserContent extends c<ILinkerUpdateUserContent> {
    public static final Companion Companion = null;
    public static final String KEY_IS_BACKGROUND = "IsBackground";
    public static final String KEY_MC_STATUS_CHANGED = "McStatus";
    public static final String KEY_SILENCE_STATUS = "SilenceStatus";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateUserContent$Companion;", "", "()V", "KEY_IS_BACKGROUND", "", "KEY_MC_STATUS_CHANGED", "KEY_SILENCE_STATUS", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String KEY_IS_BACKGROUND = "IsBackground";
        public static final String KEY_MC_STATUS_CHANGED = "McStatus";
        public static final String KEY_SILENCE_STATUS = "SilenceStatus";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "ack_message")
        public static /* synthetic */ void getAckMessage$annotations() {
        }

        @FieldName(name = "client_ui_info")
        public static /* synthetic */ void getClientUiInfo$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        public static /* synthetic */ void getFromUid$annotations() {
        }

        @FieldName(name = "linker_content_map")
        public static /* synthetic */ void getLinkerContentMap$annotations() {
        }

        @FieldName(name = "linked_users")
        public static /* synthetic */ void getMLinkUsers$annotations() {
        }

        public static /* synthetic */ void getToUid$annotations() {
        }

        @FieldName(name = "update_info")
        public static /* synthetic */ void getUpdateInfo$annotations() {
        }

        @FieldName(name = "version")
        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "ack_message")
    String getAckMessage();

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUiInfo();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "from_open_id")
    String getFromUid();

    @FieldName(name = "linker_content_map")
    Map<Long, g2> getLinkerContentMap();

    @FieldName(name = "linked_users")
    List<k> getMLinkUsers();

    @FieldName(name = "to_open_id")
    String getToUid();

    @FieldName(name = "update_info")
    Map<String, String> getUpdateInfo();

    @FieldName(name = "version")
    long getVersion();
}
