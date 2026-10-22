package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001=R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRB\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\t\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010.\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\t\u001a\u0004\b+\u0010,R.\u00101\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\t\u001a\u0004\b/\u0010,R$\u00105\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\t\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR$\u0010<\u001a\u0004\u0018\u0001068&@&X§\u000e¢\u0006\u0012\u0012\u0004\b;\u0010\t\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullDataEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "getOptions", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "setOptions", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;)V", "getOptions$annotations", "()V", "options", "", "getStreamData", "()Ljava/lang/String;", "setStreamData", "(Ljava/lang/String;)V", "getStreamData$annotations", "streamData", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getHlsDataUnencrypted", "()Ljava/util/Map;", "setHlsDataUnencrypted", "(Ljava/util/Map;)V", "getHlsDataUnencrypted$annotations", "hlsDataUnencrypted", "", "getKind", "()I", "setKind", "(I)V", "getKind$annotations", "kind", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getExtension", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "setExtension", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;)V", "getExtension$annotations", "extension", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPlayInfo;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getHls", "()Ljava/util/List;", "getHls$annotations", TTVideoEngineInterface.FORMAT_TYPE_HLS, "getFlv", "getFlv$annotations", "flv", "getCodec", "setCodec", "getCodec$annotations", "codec", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "getDisplay", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;", "setDisplay", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$IDisplay;)V", "getDisplay$annotations", "display", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPullData extends c<IPullData>, IPullDataEx {
    public static final int COMPOUND_SCENE = 2;
    public static final Companion Companion = null;
    public static final int MAIN_SCENE = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData$Companion;", "", "()V", "COMPOUND_SCENE", "", "MAIN_SCENE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int COMPOUND_SCENE = 2;
        public static final int MAIN_SCENE = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "codec")
        public static /* synthetic */ void getCodec$annotations() {
        }

        @FieldName(name = "display")
        public static /* synthetic */ void getDisplay$annotations() {
        }

        @FieldName(name = "extension")
        public static /* synthetic */ void getExtension$annotations() {
        }

        @FieldName(name = "Flv")
        public static /* synthetic */ void getFlv$annotations() {
        }

        @FieldName(name = "Hls")
        public static /* synthetic */ void getHls$annotations() {
        }

        @FieldName(name = "hls_data_unencrypted")
        public static /* synthetic */ void getHlsDataUnencrypted$annotations() {
        }

        @FieldName(name = "kind")
        public static /* synthetic */ void getKind$annotations() {
        }

        @FieldName(name = "options")
        public static /* synthetic */ void getOptions$annotations() {
        }

        @FieldName(name = MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
        public static /* synthetic */ void getStreamData$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "codec")
    String getCodec();

    @FieldName(name = "display")
    ILiveCoreSDKData.IDisplay getDisplay();

    @FieldName(name = "extension")
    IExtension getExtension();

    @FieldName(name = "Flv")
    List<IPlayInfo> getFlv();

    @FieldName(name = "Hls")
    List<IPlayInfo> getHls();

    @FieldName(name = "hls_data_unencrypted")
    Map<String, String> getHlsDataUnencrypted();

    @FieldName(name = "kind")
    int getKind();

    @FieldName(name = "options")
    IOptions getOptions();

    @FieldName(name = MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
    String getStreamData();

    @FieldName(name = "codec#setter")
    void setCodec(String r100);

    @FieldName(name = "display#setter")
    void setDisplay(ILiveCoreSDKData.IDisplay r100);

    @FieldName(name = "extension#setter")
    void setExtension(IExtension r100);

    @FieldName(name = "hls_data_unencrypted#setter")
    void setHlsDataUnencrypted(Map<String, String> r100);

    @FieldName(name = "kind#setter")
    void setKind(int r100);

    @FieldName(name = "options#setter")
    void setOptions(IOptions r100);

    @FieldName(name = "stream_data#setter")
    void setStreamData(String r100);
}
