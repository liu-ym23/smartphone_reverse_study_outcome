package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import vh7.b;
import vh7.j;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(IGuestLinkSettingConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\bV\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010#\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R$\u0010'\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010+\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010/\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R$\u00103\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R$\u00107\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\b\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R$\u0010;\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\b\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R$\u0010?\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\b\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R$\u0010C\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\b\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R$\u0010G\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\b\u001a\u0004\bD\u0010\u0017\"\u0004\bE\u0010\u0019R$\u0010K\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\b\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R$\u0010O\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bN\u0010\b\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R$\u0010S\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\b\u001a\u0004\bP\u0010\u0017\"\u0004\bQ\u0010\u0019R$\u0010W\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bV\u0010\b\u001a\u0004\bT\u0010\u0017\"\u0004\bU\u0010\u0019R$\u0010[\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bZ\u0010\b\u001a\u0004\bX\u0010\u0017\"\u0004\bY\u0010\u0019R$\u0010_\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b^\u0010\b\u001a\u0004\b\\\u0010\u0017\"\u0004\b]\u0010\u0019R$\u0010c\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bb\u0010\b\u001a\u0004\b`\u0010\u0017\"\u0004\ba\u0010\u0019R$\u0010g\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bf\u0010\b\u001a\u0004\bd\u0010\u0017\"\u0004\be\u0010\u0019R$\u0010k\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bj\u0010\b\u001a\u0004\bh\u0010\u0017\"\u0004\bi\u0010\u0019RB\u0010t\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020m\u0018\u00010lj\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020m\u0018\u0001`n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bs\u0010\b\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010x\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\bw\u0010\b\u001a\u0004\bu\u0010\u0004\"\u0004\bv\u0010\u0006¨\u0006z"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfig;", "Lvh7/j;", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "getEnabled$annotations", "()V", "enabled", "getNeedToastAfterEnterRoom", "setNeedToastAfterEnterRoom", "getNeedToastAfterEnterRoom$annotations", "needToastAfterEnterRoom", "", "getFinishChannelDelayInMillis", "()J", "setFinishChannelDelayInMillis", "(J)V", "getFinishChannelDelayInMillis$annotations", "finishChannelDelayInMillis", "", "getGuidePanelSchema", "()Ljava/lang/String;", "setGuidePanelSchema", "(Ljava/lang/String;)V", "getGuidePanelSchema$annotations", "guidePanelSchema", "getGuidePanelUrl", "setGuidePanelUrl", "getGuidePanelUrl$annotations", "guidePanelUrl", "getStartPanelSchema", "setStartPanelSchema", "getStartPanelSchema$annotations", "startPanelSchema", "getStartPanelUrl", "setStartPanelUrl", "getStartPanelUrl$annotations", "startPanelUrl", "getBystanderListSchema", "setBystanderListSchema", "getBystanderListSchema$annotations", "bystanderListSchema", "getBystanderListUrl", "setBystanderListUrl", "getBystanderListUrl$annotations", "bystanderListUrl", "getSettingTitle", "setSettingTitle", "getSettingTitle$annotations", "settingTitle", "getEnterRoomToast", "setEnterRoomToast", "getEnterRoomToast$annotations", "enterRoomToast", "getLinkerPageTitle", "setLinkerPageTitle", "getLinkerPageTitle$annotations", "linkerPageTitle", "getLinkerPageLeftBtnText", "setLinkerPageLeftBtnText", "getLinkerPageLeftBtnText$annotations", "linkerPageLeftBtnText", "getLinkerPageRightBtnText", "setLinkerPageRightBtnText", "getLinkerPageRightBtnText$annotations", "linkerPageRightBtnText", "getWatcherPageTitle", "setWatcherPageTitle", "getWatcherPageTitle$annotations", "watcherPageTitle", "getWatcherPageLeftBtnText", "setWatcherPageLeftBtnText", "getWatcherPageLeftBtnText$annotations", "watcherPageLeftBtnText", "getWatcherPageRightBtnText", "setWatcherPageRightBtnText", "getWatcherPageRightBtnText$annotations", "watcherPageRightBtnText", "getReapplyDoubleCheckTitle", "setReapplyDoubleCheckTitle", "getReapplyDoubleCheckTitle$annotations", "reapplyDoubleCheckTitle", "getReapplyDoubleCheckCancelButtonText", "setReapplyDoubleCheckCancelButtonText", "getReapplyDoubleCheckCancelButtonText$annotations", "reapplyDoubleCheckCancelButtonText", "getReapplyDoubleCheckConfirmButtonText", "setReapplyDoubleCheckConfirmButtonText", "getReapplyDoubleCheckConfirmButtonText$annotations", "reapplyDoubleCheckConfirmButtonText", "getAnchorFinishChannelDoubleCheckTitle", "setAnchorFinishChannelDoubleCheckTitle", "getAnchorFinishChannelDoubleCheckTitle$annotations", "anchorFinishChannelDoubleCheckTitle", "getAnchorFinishChannelDoubleCheckMsg", "setAnchorFinishChannelDoubleCheckMsg", "getAnchorFinishChannelDoubleCheckMsg$annotations", "anchorFinishChannelDoubleCheckMsg", "getLinkerFinishChannelDoubleCheckTitle", "setLinkerFinishChannelDoubleCheckTitle", "getLinkerFinishChannelDoubleCheckTitle$annotations", "linkerFinishChannelDoubleCheckTitle", "getLinkerFinishChannelDoubleCheckMsg", "setLinkerFinishChannelDoubleCheckMsg", "getLinkerFinishChannelDoubleCheckMsg$annotations", "linkerFinishChannelDoubleCheckMsg", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getSeatRatioConfig", "()Ljava/util/Map;", "setSeatRatioConfig", "(Ljava/util/Map;)V", "getSeatRatioConfig$annotations", "seatRatioConfig", "getDisableVideo", "setDisableVideo", "getDisableVideo$annotations", "disableVideo", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGuestLinkSettingConfig extends j<IGuestLinkSettingConfig> {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfig$Companion;", "", "()V", "defaultConfig", "Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfig;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        public final IGuestLinkSettingConfig defaultConfig() {
            Class<?> r100 = ((JsonAdapter) IGuestLinkSettingConfig.class.getAnnotation(JsonAdapter.class)).value();
            ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = b.f554981a;
            Constructor r102 = r101.get(r100);
            if (r102 != null) goto L12;
            r102 = r100.getConstructor(new Class[0]);
            if (r102 == null) goto L11;
            Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
            if (r103 == null) goto L12;
            r102 = r103;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
            if (r104 == null) goto L17;
            IGuestLinkSettingConfig r105 = (IGuestLinkSettingConfig) r104;
            r105.setEnabled(true);
            r105.setNeedToastAfterEnterRoom(true);
            r105.setFinishChannelDelayInMillis(2000);
            r105.setGuidePanelSchema("sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12");
            r105.setGuidePanelUrl("https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/lynx/social_help_page_common_douyin/pages/index/template.js?initialProps=[\"current_user\"\"current_room\"\"linkmic\"]&intro_type=38&action_from=open_panel");
            r105.setStartPanelSchema("sslocal://webcast_lynxview?enable_latch=1&rate_height=320&rate_width=375&gravity=bottom&type=popup&android_soft_input_mode=48");
            r105.setStartPanelUrl("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/dynamic_guest_link_lynx_douyin/pages/config_panel/template.js");
            r105.setBystanderListSchema("sslocal://webcast_lynxview?enable_latch=1&height_percent=58&rate_width=375&gravity=bottom&type=popup&android_soft_input_mode=48");
            r105.setBystanderListUrl("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/dynamic_guest_link_lynx_douyin/pages/guest_link_bystander_list/template.js");
            r105.setSettingTitle("嘉宾奇遇频道");
            r105.setEnterRoomToast("已开启嘉宾奇遇频道");
            r105.setLinkerPageTitle("嘉宾奇遇频道");
            r105.setLinkerPageLeftBtnText("退出频道");
            r105.setLinkerPageRightBtnText("支持TA");
            r105.setWatcherPageTitle("嘉宾奇遇频道");
            r105.setWatcherPageLeftBtnText("上一组");
            r105.setWatcherPageRightBtnText("下一组");
            r105.setReapplyDoubleCheckTitle("是否重新上麦");
            r105.setReapplyDoubleCheckCancelButtonText("暂不上麦");
            r105.setReapplyDoubleCheckConfirmButtonText("重新上麦");
            r105.setAnchorFinishChannelDoubleCheckTitle("中断嘉宾奇遇频道");
            r105.setAnchorFinishChannelDoubleCheckMsg("连线正在进行中，确认中断连线吗？");
            r105.setLinkerFinishChannelDoubleCheckTitle("关闭嘉宾奇遇频道");
            r105.setLinkerFinishChannelDoubleCheckMsg("连线未到结束时间，确认退出连线吗？");
            Pair[] r106 = {TuplesKt.to("width", 360), TuplesKt.to("height", 480)};
            LinkedHashMap r107 = new LinkedHashMap();
            MapsKt.putAll(r107, r106);
            r105.setSeatRatioConfig(r107);
            return r105;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig");
        }
    }

    @JsonAdapter(IGuestLinkSettingConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "anchor_finish_channel_double_check_msg")
        public static /* synthetic */ void getAnchorFinishChannelDoubleCheckMsg$annotations() {
        }

        @FieldName(name = "anchor_finish_channel_double_check_title")
        public static /* synthetic */ void getAnchorFinishChannelDoubleCheckTitle$annotations() {
        }

        @FieldName(name = "bystander_list_scheme")
        public static /* synthetic */ void getBystanderListSchema$annotations() {
        }

        @FieldName(name = "bystander_list_url")
        public static /* synthetic */ void getBystanderListUrl$annotations() {
        }

        @FieldName(name = "disable_video")
        public static /* synthetic */ void getDisableVideo$annotations() {
        }

        @FieldName(name = "enabled")
        public static /* synthetic */ void getEnabled$annotations() {
        }

        @FieldName(name = "enter_room_toast")
        public static /* synthetic */ void getEnterRoomToast$annotations() {
        }

        @FieldName(name = "finish_channel_delay")
        public static /* synthetic */ void getFinishChannelDelayInMillis$annotations() {
        }

        @FieldName(name = "guide_panel_schema")
        public static /* synthetic */ void getGuidePanelSchema$annotations() {
        }

        @FieldName(name = "guide_panel_url")
        public static /* synthetic */ void getGuidePanelUrl$annotations() {
        }

        @FieldName(name = "linker_finish_channel_double_check_msg")
        public static /* synthetic */ void getLinkerFinishChannelDoubleCheckMsg$annotations() {
        }

        @FieldName(name = "linker_finish_channel_double_check_title")
        public static /* synthetic */ void getLinkerFinishChannelDoubleCheckTitle$annotations() {
        }

        @FieldName(name = "linker_page_left_btn_text")
        public static /* synthetic */ void getLinkerPageLeftBtnText$annotations() {
        }

        @FieldName(name = "linker_page_right_btn_text")
        public static /* synthetic */ void getLinkerPageRightBtnText$annotations() {
        }

        @FieldName(name = "linker_page_title")
        public static /* synthetic */ void getLinkerPageTitle$annotations() {
        }

        @FieldName(name = "need_toast_after_enter_room")
        public static /* synthetic */ void getNeedToastAfterEnterRoom$annotations() {
        }

        @FieldName(name = "reapply_double_check_cancel_button_text")
        public static /* synthetic */ void getReapplyDoubleCheckCancelButtonText$annotations() {
        }

        @FieldName(name = "reapply_double_check_confirm_button_text")
        public static /* synthetic */ void getReapplyDoubleCheckConfirmButtonText$annotations() {
        }

        @FieldName(name = "reapply_double_check_title")
        public static /* synthetic */ void getReapplyDoubleCheckTitle$annotations() {
        }

        @FieldName(name = "seat_ratio_config")
        public static /* synthetic */ void getSeatRatioConfig$annotations() {
        }

        @FieldName(name = "settting_title")
        public static /* synthetic */ void getSettingTitle$annotations() {
        }

        @FieldName(name = "start_panel_schema")
        public static /* synthetic */ void getStartPanelSchema$annotations() {
        }

        @FieldName(name = "start_panel_url")
        public static /* synthetic */ void getStartPanelUrl$annotations() {
        }

        @FieldName(name = "watcher_page_left_btn_text")
        public static /* synthetic */ void getWatcherPageLeftBtnText$annotations() {
        }

        @FieldName(name = "watcher_page_right_btn_text")
        public static /* synthetic */ void getWatcherPageRightBtnText$annotations() {
        }

        @FieldName(name = "watcher_page_title")
        public static /* synthetic */ void getWatcherPageTitle$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @FieldName(name = "anchor_finish_channel_double_check_msg")
    String getAnchorFinishChannelDoubleCheckMsg();

    @FieldName(name = "anchor_finish_channel_double_check_title")
    String getAnchorFinishChannelDoubleCheckTitle();

    @FieldName(name = "bystander_list_scheme")
    String getBystanderListSchema();

    @FieldName(name = "bystander_list_url")
    String getBystanderListUrl();

    @FieldName(name = "disable_video")
    boolean getDisableVideo();

    @FieldName(name = "enabled")
    boolean getEnabled();

    @FieldName(name = "enter_room_toast")
    String getEnterRoomToast();

    @FieldName(name = "finish_channel_delay")
    long getFinishChannelDelayInMillis();

    @FieldName(name = "guide_panel_schema")
    String getGuidePanelSchema();

    @FieldName(name = "guide_panel_url")
    String getGuidePanelUrl();

    @FieldName(name = "linker_finish_channel_double_check_msg")
    String getLinkerFinishChannelDoubleCheckMsg();

    @FieldName(name = "linker_finish_channel_double_check_title")
    String getLinkerFinishChannelDoubleCheckTitle();

    @FieldName(name = "linker_page_left_btn_text")
    String getLinkerPageLeftBtnText();

    @FieldName(name = "linker_page_right_btn_text")
    String getLinkerPageRightBtnText();

    @FieldName(name = "linker_page_title")
    String getLinkerPageTitle();

    @FieldName(name = "need_toast_after_enter_room")
    boolean getNeedToastAfterEnterRoom();

    @FieldName(name = "reapply_double_check_cancel_button_text")
    String getReapplyDoubleCheckCancelButtonText();

    @FieldName(name = "reapply_double_check_confirm_button_text")
    String getReapplyDoubleCheckConfirmButtonText();

    @FieldName(name = "reapply_double_check_title")
    String getReapplyDoubleCheckTitle();

    @FieldName(name = "seat_ratio_config")
    Map<String, Integer> getSeatRatioConfig();

    @FieldName(name = "settting_title")
    String getSettingTitle();

    @FieldName(name = "start_panel_schema")
    String getStartPanelSchema();

    @FieldName(name = "start_panel_url")
    String getStartPanelUrl();

    @FieldName(name = "watcher_page_left_btn_text")
    String getWatcherPageLeftBtnText();

    @FieldName(name = "watcher_page_right_btn_text")
    String getWatcherPageRightBtnText();

    @FieldName(name = "watcher_page_title")
    String getWatcherPageTitle();

    @FieldName(name = "anchor_finish_channel_double_check_msg#setter")
    void setAnchorFinishChannelDoubleCheckMsg(String r100);

    @FieldName(name = "anchor_finish_channel_double_check_title#setter")
    void setAnchorFinishChannelDoubleCheckTitle(String r100);

    @FieldName(name = "bystander_list_scheme#setter")
    void setBystanderListSchema(String r100);

    @FieldName(name = "bystander_list_url#setter")
    void setBystanderListUrl(String r100);

    @FieldName(name = "disable_video#setter")
    void setDisableVideo(boolean r100);

    @FieldName(name = "enabled#setter")
    void setEnabled(boolean r100);

    @FieldName(name = "enter_room_toast#setter")
    void setEnterRoomToast(String r100);

    @FieldName(name = "finish_channel_delay#setter")
    void setFinishChannelDelayInMillis(long r100);

    @FieldName(name = "guide_panel_schema#setter")
    void setGuidePanelSchema(String r100);

    @FieldName(name = "guide_panel_url#setter")
    void setGuidePanelUrl(String r100);

    @FieldName(name = "linker_finish_channel_double_check_msg#setter")
    void setLinkerFinishChannelDoubleCheckMsg(String r100);

    @FieldName(name = "linker_finish_channel_double_check_title#setter")
    void setLinkerFinishChannelDoubleCheckTitle(String r100);

    @FieldName(name = "linker_page_left_btn_text#setter")
    void setLinkerPageLeftBtnText(String r100);

    @FieldName(name = "linker_page_right_btn_text#setter")
    void setLinkerPageRightBtnText(String r100);

    @FieldName(name = "linker_page_title#setter")
    void setLinkerPageTitle(String r100);

    @FieldName(name = "need_toast_after_enter_room#setter")
    void setNeedToastAfterEnterRoom(boolean r100);

    @FieldName(name = "reapply_double_check_cancel_button_text#setter")
    void setReapplyDoubleCheckCancelButtonText(String r100);

    @FieldName(name = "reapply_double_check_confirm_button_text#setter")
    void setReapplyDoubleCheckConfirmButtonText(String r100);

    @FieldName(name = "reapply_double_check_title#setter")
    void setReapplyDoubleCheckTitle(String r100);

    @FieldName(name = "seat_ratio_config#setter")
    void setSeatRatioConfig(Map<String, Integer> r100);

    @FieldName(name = "settting_title#setter")
    void setSettingTitle(String r100);

    @FieldName(name = "start_panel_schema#setter")
    void setStartPanelSchema(String r100);

    @FieldName(name = "start_panel_url#setter")
    void setStartPanelUrl(String r100);

    @FieldName(name = "watcher_page_left_btn_text#setter")
    void setWatcherPageLeftBtnText(String r100);

    @FieldName(name = "watcher_page_right_btn_text#setter")
    void setWatcherPageRightBtnText(String r100);

    @FieldName(name = "watcher_page_title#setter")
    void setWatcherPageTitle(String r100);
}
