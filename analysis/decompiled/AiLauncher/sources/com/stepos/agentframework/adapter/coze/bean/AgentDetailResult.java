package com.stepos.agentframework.adapter.coze.bean;

import androidx.annotation.Keep;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.args.ModelDownloaderBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult;", "", "code", "", "data", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data;", "detail", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Detail;", "msg", "", "<init>", "(ILcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Detail;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data;", "getDetail", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Detail;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "Data", "Detail", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AgentDetailResult {
    private final int code;
    private final Data data;
    private final Detail detail;
    private final String msg;

    @Keep
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001:\babcdefghBç\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017¢\u0006\u0004\b#\u0010$J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017HÆ\u0003J\t\u0010S\u001a\u00020\u0019HÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017HÆ\u0003J\t\u0010U\u001a\u00020\u001cHÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017HÆ\u0003J\u0095\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u00052\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017HÆ\u0001J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010_\u001a\u00020\u0007HÖ\u0001J\t\u0010`\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b=\u0010:R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bA\u0010:R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010(R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bD\u0010:¨\u0006i"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data;", "", "background_image_info", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo;", "bot_id", "", "bot_mode", "", "create_time", "default_user_input_type", "description", "icon_url", "knowledge", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$Knowledge;", "media_config", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$MediaConfig;", "model_info", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo;", "name", "onboarding_info", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$OnboardingInfo;", "owner_user_id", "plugin_info_list", "", "prompt_info", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$PromptInfo;", "shortcut_commands", "suggest_reply_info", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$SuggestReplyInfo;", "update_time", "variables", "version", "voice_info_list", "workflow_info_list", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$WorkflowInfo;", "<init>", "(Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$Knowledge;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$MediaConfig;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$OnboardingInfo;Ljava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$PromptInfo;Ljava/util/List;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$SuggestReplyInfo;ILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBackground_image_info", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo;", "getBot_id", "()Ljava/lang/String;", "getBot_mode", "()I", "getCreate_time", "getDefault_user_input_type", "getDescription", "getIcon_url", "getKnowledge", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$Knowledge;", "getMedia_config", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$MediaConfig;", "getModel_info", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo;", "getName", "getOnboarding_info", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$OnboardingInfo;", "getOwner_user_id", "getPlugin_info_list", "()Ljava/util/List;", "getPrompt_info", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$PromptInfo;", "getShortcut_commands", "getSuggest_reply_info", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$SuggestReplyInfo;", "getUpdate_time", "getVariables", "getVersion", "getVoice_info_list", "getWorkflow_info_list", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "BackgroundImageInfo", "Knowledge", "MediaConfig", "ModelInfo", "OnboardingInfo", "PromptInfo", "SuggestReplyInfo", "WorkflowInfo", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data {
        private final BackgroundImageInfo background_image_info;
        private final String bot_id;
        private final int bot_mode;
        private final int create_time;
        private final String default_user_input_type;
        private final String description;
        private final String icon_url;
        private final Knowledge knowledge;
        private final MediaConfig media_config;
        private final ModelInfo model_info;
        private final String name;
        private final OnboardingInfo onboarding_info;
        private final String owner_user_id;
        private final List<Object> plugin_info_list;
        private final PromptInfo prompt_info;
        private final List<Object> shortcut_commands;
        private final SuggestReplyInfo suggest_reply_info;
        private final int update_time;
        private final List<Object> variables;
        private final String version;
        private final List<Object> voice_info_list;
        private final List<WorkflowInfo> workflow_info_list;

        @Keep
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo;", "", "mobile_background_image", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage;", "web_background_image", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage;", "<init>", "(Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage;)V", "getMobile_background_image", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage;", "getWeb_background_image", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "MobileBackgroundImage", "WebBackgroundImage", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BackgroundImageInfo {
            private final MobileBackgroundImage mobile_background_image;
            private final WebBackgroundImage web_background_image;

            @Keep
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002 !B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage;", "", "canvas_position", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$CanvasPosition;", "gradient_position", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$GradientPosition;", "image_url", "", "origin_image_url", "theme_color", "<init>", "(Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$CanvasPosition;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$GradientPosition;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanvas_position", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$CanvasPosition;", "getGradient_position", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$GradientPosition;", "getImage_url", "()Ljava/lang/String;", "getOrigin_image_url", "getTheme_color", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "CanvasPosition", "GradientPosition", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class MobileBackgroundImage {
                private final CanvasPosition canvas_position;
                private final GradientPosition gradient_position;
                private final String image_url;
                private final String origin_image_url;
                private final String theme_color;

                @Keep
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$CanvasPosition;", "", "<init>", "()V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final class CanvasPosition {
                }

                @Keep
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$MobileBackgroundImage$GradientPosition;", "", "<init>", "()V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final class GradientPosition {
                }

                public MobileBackgroundImage(CanvasPosition canvasPosition, GradientPosition gradientPosition, String image_url, String origin_image_url, String theme_color) {
                    p.i(image_url, "image_url");
                    p.i(origin_image_url, "origin_image_url");
                    p.i(theme_color, "theme_color");
                    this.canvas_position = canvasPosition;
                    this.gradient_position = gradientPosition;
                    this.image_url = image_url;
                    this.origin_image_url = origin_image_url;
                    this.theme_color = theme_color;
                }

                public static /* synthetic */ MobileBackgroundImage copy$default(MobileBackgroundImage mobileBackgroundImage, CanvasPosition canvasPosition, GradientPosition gradientPosition, String str, String str2, String str3, int i10, Object obj) {
                    if ((i10 & 1) != 0) {
                        canvasPosition = mobileBackgroundImage.canvas_position;
                    }
                    if ((i10 & 2) != 0) {
                        gradientPosition = mobileBackgroundImage.gradient_position;
                    }
                    if ((i10 & 4) != 0) {
                        str = mobileBackgroundImage.image_url;
                    }
                    if ((i10 & 8) != 0) {
                        str2 = mobileBackgroundImage.origin_image_url;
                    }
                    if ((i10 & 16) != 0) {
                        str3 = mobileBackgroundImage.theme_color;
                    }
                    String str4 = str3;
                    String str5 = str;
                    return mobileBackgroundImage.copy(canvasPosition, gradientPosition, str5, str2, str4);
                }

                /* renamed from: component1, reason: from getter */
                public final CanvasPosition getCanvas_position() {
                    return this.canvas_position;
                }

                /* renamed from: component2, reason: from getter */
                public final GradientPosition getGradient_position() {
                    return this.gradient_position;
                }

                /* renamed from: component3, reason: from getter */
                public final String getImage_url() {
                    return this.image_url;
                }

                /* renamed from: component4, reason: from getter */
                public final String getOrigin_image_url() {
                    return this.origin_image_url;
                }

                /* renamed from: component5, reason: from getter */
                public final String getTheme_color() {
                    return this.theme_color;
                }

                public final MobileBackgroundImage copy(CanvasPosition canvas_position, GradientPosition gradient_position, String image_url, String origin_image_url, String theme_color) {
                    p.i(image_url, "image_url");
                    p.i(origin_image_url, "origin_image_url");
                    p.i(theme_color, "theme_color");
                    return new MobileBackgroundImage(canvas_position, gradient_position, image_url, origin_image_url, theme_color);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof MobileBackgroundImage)) {
                        return false;
                    }
                    MobileBackgroundImage mobileBackgroundImage = (MobileBackgroundImage) other;
                    return p.d(this.canvas_position, mobileBackgroundImage.canvas_position) && p.d(this.gradient_position, mobileBackgroundImage.gradient_position) && p.d(this.image_url, mobileBackgroundImage.image_url) && p.d(this.origin_image_url, mobileBackgroundImage.origin_image_url) && p.d(this.theme_color, mobileBackgroundImage.theme_color);
                }

                public final CanvasPosition getCanvas_position() {
                    return this.canvas_position;
                }

                public final GradientPosition getGradient_position() {
                    return this.gradient_position;
                }

                public final String getImage_url() {
                    return this.image_url;
                }

                public final String getOrigin_image_url() {
                    return this.origin_image_url;
                }

                public final String getTheme_color() {
                    return this.theme_color;
                }

                public int hashCode() {
                    CanvasPosition canvasPosition = this.canvas_position;
                    int iHashCode = (canvasPosition == null ? 0 : canvasPosition.hashCode()) * 31;
                    GradientPosition gradientPosition = this.gradient_position;
                    return ((((((iHashCode + (gradientPosition != null ? gradientPosition.hashCode() : 0)) * 31) + this.image_url.hashCode()) * 31) + this.origin_image_url.hashCode()) * 31) + this.theme_color.hashCode();
                }

                public String toString() {
                    return "MobileBackgroundImage(canvas_position=" + this.canvas_position + ", gradient_position=" + this.gradient_position + ", image_url=" + this.image_url + ", origin_image_url=" + this.origin_image_url + ", theme_color=" + this.theme_color + ")";
                }
            }

            @Keep
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002 !B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage;", "", "canvas_position", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$CanvasPosition;", "gradient_position", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$GradientPosition;", "image_url", "", "origin_image_url", "theme_color", "<init>", "(Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$CanvasPosition;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$GradientPosition;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanvas_position", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$CanvasPosition;", "getGradient_position", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$GradientPosition;", "getImage_url", "()Ljava/lang/String;", "getOrigin_image_url", "getTheme_color", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "CanvasPosition", "GradientPosition", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class WebBackgroundImage {
                private final CanvasPosition canvas_position;
                private final GradientPosition gradient_position;
                private final String image_url;
                private final String origin_image_url;
                private final String theme_color;

                @Keep
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$CanvasPosition;", "", "<init>", "()V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final class CanvasPosition {
                }

                @Keep
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$BackgroundImageInfo$WebBackgroundImage$GradientPosition;", "", "<init>", "()V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final class GradientPosition {
                }

                public WebBackgroundImage(CanvasPosition canvasPosition, GradientPosition gradientPosition, String image_url, String origin_image_url, String theme_color) {
                    p.i(image_url, "image_url");
                    p.i(origin_image_url, "origin_image_url");
                    p.i(theme_color, "theme_color");
                    this.canvas_position = canvasPosition;
                    this.gradient_position = gradientPosition;
                    this.image_url = image_url;
                    this.origin_image_url = origin_image_url;
                    this.theme_color = theme_color;
                }

                public static /* synthetic */ WebBackgroundImage copy$default(WebBackgroundImage webBackgroundImage, CanvasPosition canvasPosition, GradientPosition gradientPosition, String str, String str2, String str3, int i10, Object obj) {
                    if ((i10 & 1) != 0) {
                        canvasPosition = webBackgroundImage.canvas_position;
                    }
                    if ((i10 & 2) != 0) {
                        gradientPosition = webBackgroundImage.gradient_position;
                    }
                    if ((i10 & 4) != 0) {
                        str = webBackgroundImage.image_url;
                    }
                    if ((i10 & 8) != 0) {
                        str2 = webBackgroundImage.origin_image_url;
                    }
                    if ((i10 & 16) != 0) {
                        str3 = webBackgroundImage.theme_color;
                    }
                    String str4 = str3;
                    String str5 = str;
                    return webBackgroundImage.copy(canvasPosition, gradientPosition, str5, str2, str4);
                }

                /* renamed from: component1, reason: from getter */
                public final CanvasPosition getCanvas_position() {
                    return this.canvas_position;
                }

                /* renamed from: component2, reason: from getter */
                public final GradientPosition getGradient_position() {
                    return this.gradient_position;
                }

                /* renamed from: component3, reason: from getter */
                public final String getImage_url() {
                    return this.image_url;
                }

                /* renamed from: component4, reason: from getter */
                public final String getOrigin_image_url() {
                    return this.origin_image_url;
                }

                /* renamed from: component5, reason: from getter */
                public final String getTheme_color() {
                    return this.theme_color;
                }

                public final WebBackgroundImage copy(CanvasPosition canvas_position, GradientPosition gradient_position, String image_url, String origin_image_url, String theme_color) {
                    p.i(image_url, "image_url");
                    p.i(origin_image_url, "origin_image_url");
                    p.i(theme_color, "theme_color");
                    return new WebBackgroundImage(canvas_position, gradient_position, image_url, origin_image_url, theme_color);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof WebBackgroundImage)) {
                        return false;
                    }
                    WebBackgroundImage webBackgroundImage = (WebBackgroundImage) other;
                    return p.d(this.canvas_position, webBackgroundImage.canvas_position) && p.d(this.gradient_position, webBackgroundImage.gradient_position) && p.d(this.image_url, webBackgroundImage.image_url) && p.d(this.origin_image_url, webBackgroundImage.origin_image_url) && p.d(this.theme_color, webBackgroundImage.theme_color);
                }

                public final CanvasPosition getCanvas_position() {
                    return this.canvas_position;
                }

                public final GradientPosition getGradient_position() {
                    return this.gradient_position;
                }

                public final String getImage_url() {
                    return this.image_url;
                }

                public final String getOrigin_image_url() {
                    return this.origin_image_url;
                }

                public final String getTheme_color() {
                    return this.theme_color;
                }

                public int hashCode() {
                    CanvasPosition canvasPosition = this.canvas_position;
                    int iHashCode = (canvasPosition == null ? 0 : canvasPosition.hashCode()) * 31;
                    GradientPosition gradientPosition = this.gradient_position;
                    return ((((((iHashCode + (gradientPosition != null ? gradientPosition.hashCode() : 0)) * 31) + this.image_url.hashCode()) * 31) + this.origin_image_url.hashCode()) * 31) + this.theme_color.hashCode();
                }

                public String toString() {
                    return "WebBackgroundImage(canvas_position=" + this.canvas_position + ", gradient_position=" + this.gradient_position + ", image_url=" + this.image_url + ", origin_image_url=" + this.origin_image_url + ", theme_color=" + this.theme_color + ")";
                }
            }

            public BackgroundImageInfo(MobileBackgroundImage mobileBackgroundImage, WebBackgroundImage webBackgroundImage) {
                this.mobile_background_image = mobileBackgroundImage;
                this.web_background_image = webBackgroundImage;
            }

            public static /* synthetic */ BackgroundImageInfo copy$default(BackgroundImageInfo backgroundImageInfo, MobileBackgroundImage mobileBackgroundImage, WebBackgroundImage webBackgroundImage, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    mobileBackgroundImage = backgroundImageInfo.mobile_background_image;
                }
                if ((i10 & 2) != 0) {
                    webBackgroundImage = backgroundImageInfo.web_background_image;
                }
                return backgroundImageInfo.copy(mobileBackgroundImage, webBackgroundImage);
            }

            /* renamed from: component1, reason: from getter */
            public final MobileBackgroundImage getMobile_background_image() {
                return this.mobile_background_image;
            }

            /* renamed from: component2, reason: from getter */
            public final WebBackgroundImage getWeb_background_image() {
                return this.web_background_image;
            }

            public final BackgroundImageInfo copy(MobileBackgroundImage mobile_background_image, WebBackgroundImage web_background_image) {
                return new BackgroundImageInfo(mobile_background_image, web_background_image);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BackgroundImageInfo)) {
                    return false;
                }
                BackgroundImageInfo backgroundImageInfo = (BackgroundImageInfo) other;
                return p.d(this.mobile_background_image, backgroundImageInfo.mobile_background_image) && p.d(this.web_background_image, backgroundImageInfo.web_background_image);
            }

            public final MobileBackgroundImage getMobile_background_image() {
                return this.mobile_background_image;
            }

            public final WebBackgroundImage getWeb_background_image() {
                return this.web_background_image;
            }

            public int hashCode() {
                MobileBackgroundImage mobileBackgroundImage = this.mobile_background_image;
                int iHashCode = (mobileBackgroundImage == null ? 0 : mobileBackgroundImage.hashCode()) * 31;
                WebBackgroundImage webBackgroundImage = this.web_background_image;
                return iHashCode + (webBackgroundImage != null ? webBackgroundImage.hashCode() : 0);
            }

            public String toString() {
                return "BackgroundImageInfo(mobile_background_image=" + this.mobile_background_image + ", web_background_image=" + this.web_background_image + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$Knowledge;", "", "knowledge_infos", "", "<init>", "(Ljava/util/List;)V", "getKnowledge_infos", "()Ljava/util/List;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Knowledge {
            private final List<Object> knowledge_infos;

            public Knowledge(List<? extends Object> list) {
                this.knowledge_infos = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Knowledge copy$default(Knowledge knowledge, List list, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    list = knowledge.knowledge_infos;
                }
                return knowledge.copy(list);
            }

            public final List<Object> component1() {
                return this.knowledge_infos;
            }

            public final Knowledge copy(List<? extends Object> knowledge_infos) {
                return new Knowledge(knowledge_infos);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Knowledge) && p.d(this.knowledge_infos, ((Knowledge) other).knowledge_infos);
            }

            public final List<Object> getKnowledge_infos() {
                return this.knowledge_infos;
            }

            public int hashCode() {
                List<Object> list = this.knowledge_infos;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }

            public String toString() {
                return "Knowledge(knowledge_infos=" + this.knowledge_infos + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$MediaConfig;", "", "is_voice_call_closed", "", "<init>", "(Z)V", "()Z", "component1", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MediaConfig {
            private final boolean is_voice_call_closed;

            public MediaConfig(boolean z10) {
                this.is_voice_call_closed = z10;
            }

            public static /* synthetic */ MediaConfig copy$default(MediaConfig mediaConfig, boolean z10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    z10 = mediaConfig.is_voice_call_closed;
                }
                return mediaConfig.copy(z10);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIs_voice_call_closed() {
                return this.is_voice_call_closed;
            }

            public final MediaConfig copy(boolean is_voice_call_closed) {
                return new MediaConfig(is_voice_call_closed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MediaConfig) && this.is_voice_call_closed == ((MediaConfig) other).is_voice_call_closed;
            }

            public int hashCode() {
                return Boolean.hashCode(this.is_voice_call_closed);
            }

            public final boolean is_voice_call_closed() {
                return this.is_voice_call_closed;
            }

            public String toString() {
                return "MediaConfig(is_voice_call_closed=" + this.is_voice_call_closed + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001'B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo;", "", "cache_type", "", "context_round", "", "max_tokens", "model_id", ModelDownloaderBundle.KEY_MODEL_NAME, "parameters", "Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo$Parameters;", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo$Parameters;D)V", "getCache_type", "()Ljava/lang/String;", "getContext_round", "()I", "getMax_tokens", "getModel_id", "getModel_name", "getParameters", "()Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo$Parameters;", "getTemperature", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "component7", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "Parameters", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ModelInfo {
            private final String cache_type;
            private final int context_round;
            private final int max_tokens;
            private final String model_id;
            private final String model_name;
            private final Parameters parameters;
            private final double temperature;

            @Keep
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$ModelInfo$Parameters;", "", "<init>", "()V", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Parameters {
            }

            public ModelInfo(String cache_type, int i10, int i11, String model_id, String model_name, Parameters parameters, double d10) {
                p.i(cache_type, "cache_type");
                p.i(model_id, "model_id");
                p.i(model_name, "model_name");
                p.i(parameters, "parameters");
                this.cache_type = cache_type;
                this.context_round = i10;
                this.max_tokens = i11;
                this.model_id = model_id;
                this.model_name = model_name;
                this.parameters = parameters;
                this.temperature = d10;
            }

            public static /* synthetic */ ModelInfo copy$default(ModelInfo modelInfo, String str, int i10, int i11, String str2, String str3, Parameters parameters, double d10, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    str = modelInfo.cache_type;
                }
                if ((i12 & 2) != 0) {
                    i10 = modelInfo.context_round;
                }
                if ((i12 & 4) != 0) {
                    i11 = modelInfo.max_tokens;
                }
                if ((i12 & 8) != 0) {
                    str2 = modelInfo.model_id;
                }
                if ((i12 & 16) != 0) {
                    str3 = modelInfo.model_name;
                }
                if ((i12 & 32) != 0) {
                    parameters = modelInfo.parameters;
                }
                if ((i12 & 64) != 0) {
                    d10 = modelInfo.temperature;
                }
                double d11 = d10;
                String str4 = str3;
                Parameters parameters2 = parameters;
                return modelInfo.copy(str, i10, i11, str2, str4, parameters2, d11);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCache_type() {
                return this.cache_type;
            }

            /* renamed from: component2, reason: from getter */
            public final int getContext_round() {
                return this.context_round;
            }

            /* renamed from: component3, reason: from getter */
            public final int getMax_tokens() {
                return this.max_tokens;
            }

            /* renamed from: component4, reason: from getter */
            public final String getModel_id() {
                return this.model_id;
            }

            /* renamed from: component5, reason: from getter */
            public final String getModel_name() {
                return this.model_name;
            }

            /* renamed from: component6, reason: from getter */
            public final Parameters getParameters() {
                return this.parameters;
            }

            /* renamed from: component7, reason: from getter */
            public final double getTemperature() {
                return this.temperature;
            }

            public final ModelInfo copy(String cache_type, int context_round, int max_tokens, String model_id, String model_name, Parameters parameters, double temperature) {
                p.i(cache_type, "cache_type");
                p.i(model_id, "model_id");
                p.i(model_name, "model_name");
                p.i(parameters, "parameters");
                return new ModelInfo(cache_type, context_round, max_tokens, model_id, model_name, parameters, temperature);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ModelInfo)) {
                    return false;
                }
                ModelInfo modelInfo = (ModelInfo) other;
                return p.d(this.cache_type, modelInfo.cache_type) && this.context_round == modelInfo.context_round && this.max_tokens == modelInfo.max_tokens && p.d(this.model_id, modelInfo.model_id) && p.d(this.model_name, modelInfo.model_name) && p.d(this.parameters, modelInfo.parameters) && Double.compare(this.temperature, modelInfo.temperature) == 0;
            }

            public final String getCache_type() {
                return this.cache_type;
            }

            public final int getContext_round() {
                return this.context_round;
            }

            public final int getMax_tokens() {
                return this.max_tokens;
            }

            public final String getModel_id() {
                return this.model_id;
            }

            public final String getModel_name() {
                return this.model_name;
            }

            public final Parameters getParameters() {
                return this.parameters;
            }

            public final double getTemperature() {
                return this.temperature;
            }

            public int hashCode() {
                return (((((((((((this.cache_type.hashCode() * 31) + Integer.hashCode(this.context_round)) * 31) + Integer.hashCode(this.max_tokens)) * 31) + this.model_id.hashCode()) * 31) + this.model_name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + Double.hashCode(this.temperature);
            }

            public String toString() {
                return "ModelInfo(cache_type=" + this.cache_type + ", context_round=" + this.context_round + ", max_tokens=" + this.max_tokens + ", model_id=" + this.model_id + ", model_name=" + this.model_name + ", parameters=" + this.parameters + ", temperature=" + this.temperature + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$OnboardingInfo;", "", "prologue", "", "suggested_questions", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getPrologue", "()Ljava/lang/String;", "getSuggested_questions", "()Ljava/util/List;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnboardingInfo {
            private final String prologue;
            private final List<String> suggested_questions;

            public OnboardingInfo(String str, List<String> list) {
                this.prologue = str;
                this.suggested_questions = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OnboardingInfo copy$default(OnboardingInfo onboardingInfo, String str, List list, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = onboardingInfo.prologue;
                }
                if ((i10 & 2) != 0) {
                    list = onboardingInfo.suggested_questions;
                }
                return onboardingInfo.copy(str, list);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPrologue() {
                return this.prologue;
            }

            public final List<String> component2() {
                return this.suggested_questions;
            }

            public final OnboardingInfo copy(String prologue, List<String> suggested_questions) {
                return new OnboardingInfo(prologue, suggested_questions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnboardingInfo)) {
                    return false;
                }
                OnboardingInfo onboardingInfo = (OnboardingInfo) other;
                return p.d(this.prologue, onboardingInfo.prologue) && p.d(this.suggested_questions, onboardingInfo.suggested_questions);
            }

            public final String getPrologue() {
                return this.prologue;
            }

            public final List<String> getSuggested_questions() {
                return this.suggested_questions;
            }

            public int hashCode() {
                String str = this.prologue;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<String> list = this.suggested_questions;
                return iHashCode + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                return "OnboardingInfo(prologue=" + this.prologue + ", suggested_questions=" + this.suggested_questions + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$PromptInfo;", "", HighlightArgsBundle.KEY_PROMPT, "", "prompt_mode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPrompt", "()Ljava/lang/String;", "getPrompt_mode", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PromptInfo {
            private final String prompt;
            private final String prompt_mode;

            public PromptInfo(String prompt, String prompt_mode) {
                p.i(prompt, "prompt");
                p.i(prompt_mode, "prompt_mode");
                this.prompt = prompt;
                this.prompt_mode = prompt_mode;
            }

            public static /* synthetic */ PromptInfo copy$default(PromptInfo promptInfo, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = promptInfo.prompt;
                }
                if ((i10 & 2) != 0) {
                    str2 = promptInfo.prompt_mode;
                }
                return promptInfo.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getPrompt() {
                return this.prompt;
            }

            /* renamed from: component2, reason: from getter */
            public final String getPrompt_mode() {
                return this.prompt_mode;
            }

            public final PromptInfo copy(String prompt, String prompt_mode) {
                p.i(prompt, "prompt");
                p.i(prompt_mode, "prompt_mode");
                return new PromptInfo(prompt, prompt_mode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PromptInfo)) {
                    return false;
                }
                PromptInfo promptInfo = (PromptInfo) other;
                return p.d(this.prompt, promptInfo.prompt) && p.d(this.prompt_mode, promptInfo.prompt_mode);
            }

            public final String getPrompt() {
                return this.prompt;
            }

            public final String getPrompt_mode() {
                return this.prompt_mode;
            }

            public int hashCode() {
                return (this.prompt.hashCode() * 31) + this.prompt_mode.hashCode();
            }

            public String toString() {
                return "PromptInfo(prompt=" + this.prompt + ", prompt_mode=" + this.prompt_mode + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$SuggestReplyInfo;", "", "customized_prompt", "", "reply_mode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCustomized_prompt", "()Ljava/lang/String;", "getReply_mode", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SuggestReplyInfo {
            private final String customized_prompt;
            private final String reply_mode;

            public SuggestReplyInfo(String customized_prompt, String reply_mode) {
                p.i(customized_prompt, "customized_prompt");
                p.i(reply_mode, "reply_mode");
                this.customized_prompt = customized_prompt;
                this.reply_mode = reply_mode;
            }

            public static /* synthetic */ SuggestReplyInfo copy$default(SuggestReplyInfo suggestReplyInfo, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = suggestReplyInfo.customized_prompt;
                }
                if ((i10 & 2) != 0) {
                    str2 = suggestReplyInfo.reply_mode;
                }
                return suggestReplyInfo.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getCustomized_prompt() {
                return this.customized_prompt;
            }

            /* renamed from: component2, reason: from getter */
            public final String getReply_mode() {
                return this.reply_mode;
            }

            public final SuggestReplyInfo copy(String customized_prompt, String reply_mode) {
                p.i(customized_prompt, "customized_prompt");
                p.i(reply_mode, "reply_mode");
                return new SuggestReplyInfo(customized_prompt, reply_mode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestReplyInfo)) {
                    return false;
                }
                SuggestReplyInfo suggestReplyInfo = (SuggestReplyInfo) other;
                return p.d(this.customized_prompt, suggestReplyInfo.customized_prompt) && p.d(this.reply_mode, suggestReplyInfo.reply_mode);
            }

            public final String getCustomized_prompt() {
                return this.customized_prompt;
            }

            public final String getReply_mode() {
                return this.reply_mode;
            }

            public int hashCode() {
                return (this.customized_prompt.hashCode() * 31) + this.reply_mode.hashCode();
            }

            public String toString() {
                return "SuggestReplyInfo(customized_prompt=" + this.customized_prompt + ", reply_mode=" + this.reply_mode + ")";
            }
        }

        @Keep
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Data$WorkflowInfo;", "", "description", "", "icon_url", "id", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon_url", "getId", "getName", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WorkflowInfo {
            private final String description;
            private final String icon_url;
            private final String id;
            private final String name;

            public WorkflowInfo(String description, String icon_url, String id, String name) {
                p.i(description, "description");
                p.i(icon_url, "icon_url");
                p.i(id, "id");
                p.i(name, "name");
                this.description = description;
                this.icon_url = icon_url;
                this.id = id;
                this.name = name;
            }

            public static /* synthetic */ WorkflowInfo copy$default(WorkflowInfo workflowInfo, String str, String str2, String str3, String str4, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = workflowInfo.description;
                }
                if ((i10 & 2) != 0) {
                    str2 = workflowInfo.icon_url;
                }
                if ((i10 & 4) != 0) {
                    str3 = workflowInfo.id;
                }
                if ((i10 & 8) != 0) {
                    str4 = workflowInfo.name;
                }
                return workflowInfo.copy(str, str2, str3, str4);
            }

            /* renamed from: component1, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            /* renamed from: component2, reason: from getter */
            public final String getIcon_url() {
                return this.icon_url;
            }

            /* renamed from: component3, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component4, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final WorkflowInfo copy(String description, String icon_url, String id, String name) {
                p.i(description, "description");
                p.i(icon_url, "icon_url");
                p.i(id, "id");
                p.i(name, "name");
                return new WorkflowInfo(description, icon_url, id, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WorkflowInfo)) {
                    return false;
                }
                WorkflowInfo workflowInfo = (WorkflowInfo) other;
                return p.d(this.description, workflowInfo.description) && p.d(this.icon_url, workflowInfo.icon_url) && p.d(this.id, workflowInfo.id) && p.d(this.name, workflowInfo.name);
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getIcon_url() {
                return this.icon_url;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                return (((((this.description.hashCode() * 31) + this.icon_url.hashCode()) * 31) + this.id.hashCode()) * 31) + this.name.hashCode();
            }

            public String toString() {
                return "WorkflowInfo(description=" + this.description + ", icon_url=" + this.icon_url + ", id=" + this.id + ", name=" + this.name + ")";
            }
        }

        public Data(BackgroundImageInfo backgroundImageInfo, String bot_id, int i10, int i11, String default_user_input_type, String str, String icon_url, Knowledge knowledge, MediaConfig mediaConfig, ModelInfo modelInfo, String name, OnboardingInfo onboardingInfo, String owner_user_id, List<? extends Object> plugin_info_list, PromptInfo prompt_info, List<? extends Object> shortcut_commands, SuggestReplyInfo suggest_reply_info, int i12, List<? extends Object> list, String version, List<? extends Object> list2, List<WorkflowInfo> list3) {
            p.i(bot_id, "bot_id");
            p.i(default_user_input_type, "default_user_input_type");
            p.i(icon_url, "icon_url");
            p.i(name, "name");
            p.i(owner_user_id, "owner_user_id");
            p.i(plugin_info_list, "plugin_info_list");
            p.i(prompt_info, "prompt_info");
            p.i(shortcut_commands, "shortcut_commands");
            p.i(suggest_reply_info, "suggest_reply_info");
            p.i(version, "version");
            this.background_image_info = backgroundImageInfo;
            this.bot_id = bot_id;
            this.bot_mode = i10;
            this.create_time = i11;
            this.default_user_input_type = default_user_input_type;
            this.description = str;
            this.icon_url = icon_url;
            this.knowledge = knowledge;
            this.media_config = mediaConfig;
            this.model_info = modelInfo;
            this.name = name;
            this.onboarding_info = onboardingInfo;
            this.owner_user_id = owner_user_id;
            this.plugin_info_list = plugin_info_list;
            this.prompt_info = prompt_info;
            this.shortcut_commands = shortcut_commands;
            this.suggest_reply_info = suggest_reply_info;
            this.update_time = i12;
            this.variables = list;
            this.version = version;
            this.voice_info_list = list2;
            this.workflow_info_list = list3;
        }

        public static /* synthetic */ Data copy$default(Data data, BackgroundImageInfo backgroundImageInfo, String str, int i10, int i11, String str2, String str3, String str4, Knowledge knowledge, MediaConfig mediaConfig, ModelInfo modelInfo, String str5, OnboardingInfo onboardingInfo, String str6, List list, PromptInfo promptInfo, List list2, SuggestReplyInfo suggestReplyInfo, int i12, List list3, String str7, List list4, List list5, int i13, Object obj) {
            List list6;
            List list7;
            BackgroundImageInfo backgroundImageInfo2 = (i13 & 1) != 0 ? data.background_image_info : backgroundImageInfo;
            String str8 = (i13 & 2) != 0 ? data.bot_id : str;
            int i14 = (i13 & 4) != 0 ? data.bot_mode : i10;
            int i15 = (i13 & 8) != 0 ? data.create_time : i11;
            String str9 = (i13 & 16) != 0 ? data.default_user_input_type : str2;
            String str10 = (i13 & 32) != 0 ? data.description : str3;
            String str11 = (i13 & 64) != 0 ? data.icon_url : str4;
            Knowledge knowledge2 = (i13 & 128) != 0 ? data.knowledge : knowledge;
            MediaConfig mediaConfig2 = (i13 & 256) != 0 ? data.media_config : mediaConfig;
            ModelInfo modelInfo2 = (i13 & 512) != 0 ? data.model_info : modelInfo;
            String str12 = (i13 & 1024) != 0 ? data.name : str5;
            OnboardingInfo onboardingInfo2 = (i13 & 2048) != 0 ? data.onboarding_info : onboardingInfo;
            String str13 = (i13 & 4096) != 0 ? data.owner_user_id : str6;
            List list8 = (i13 & b.THRESHOLD) != 0 ? data.plugin_info_list : list;
            BackgroundImageInfo backgroundImageInfo3 = backgroundImageInfo2;
            PromptInfo promptInfo2 = (i13 & 16384) != 0 ? data.prompt_info : promptInfo;
            List list9 = (i13 & 32768) != 0 ? data.shortcut_commands : list2;
            SuggestReplyInfo suggestReplyInfo2 = (i13 & 65536) != 0 ? data.suggest_reply_info : suggestReplyInfo;
            int i16 = (i13 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? data.update_time : i12;
            List list10 = (i13 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? data.variables : list3;
            String str14 = (i13 & 524288) != 0 ? data.version : str7;
            List list11 = (i13 & 1048576) != 0 ? data.voice_info_list : list4;
            if ((i13 & 2097152) != 0) {
                list7 = list11;
                list6 = data.workflow_info_list;
            } else {
                list6 = list5;
                list7 = list11;
            }
            return data.copy(backgroundImageInfo3, str8, i14, i15, str9, str10, str11, knowledge2, mediaConfig2, modelInfo2, str12, onboardingInfo2, str13, list8, promptInfo2, list9, suggestReplyInfo2, i16, list10, str14, list7, list6);
        }

        /* renamed from: component1, reason: from getter */
        public final BackgroundImageInfo getBackground_image_info() {
            return this.background_image_info;
        }

        /* renamed from: component10, reason: from getter */
        public final ModelInfo getModel_info() {
            return this.model_info;
        }

        /* renamed from: component11, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component12, reason: from getter */
        public final OnboardingInfo getOnboarding_info() {
            return this.onboarding_info;
        }

        /* renamed from: component13, reason: from getter */
        public final String getOwner_user_id() {
            return this.owner_user_id;
        }

        public final List<Object> component14() {
            return this.plugin_info_list;
        }

        /* renamed from: component15, reason: from getter */
        public final PromptInfo getPrompt_info() {
            return this.prompt_info;
        }

        public final List<Object> component16() {
            return this.shortcut_commands;
        }

        /* renamed from: component17, reason: from getter */
        public final SuggestReplyInfo getSuggest_reply_info() {
            return this.suggest_reply_info;
        }

        /* renamed from: component18, reason: from getter */
        public final int getUpdate_time() {
            return this.update_time;
        }

        public final List<Object> component19() {
            return this.variables;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBot_id() {
            return this.bot_id;
        }

        /* renamed from: component20, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final List<Object> component21() {
            return this.voice_info_list;
        }

        public final List<WorkflowInfo> component22() {
            return this.workflow_info_list;
        }

        /* renamed from: component3, reason: from getter */
        public final int getBot_mode() {
            return this.bot_mode;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCreate_time() {
            return this.create_time;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDefault_user_input_type() {
            return this.default_user_input_type;
        }

        /* renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: component7, reason: from getter */
        public final String getIcon_url() {
            return this.icon_url;
        }

        /* renamed from: component8, reason: from getter */
        public final Knowledge getKnowledge() {
            return this.knowledge;
        }

        /* renamed from: component9, reason: from getter */
        public final MediaConfig getMedia_config() {
            return this.media_config;
        }

        public final Data copy(BackgroundImageInfo background_image_info, String bot_id, int bot_mode, int create_time, String default_user_input_type, String description, String icon_url, Knowledge knowledge, MediaConfig media_config, ModelInfo model_info, String name, OnboardingInfo onboarding_info, String owner_user_id, List<? extends Object> plugin_info_list, PromptInfo prompt_info, List<? extends Object> shortcut_commands, SuggestReplyInfo suggest_reply_info, int update_time, List<? extends Object> variables, String version, List<? extends Object> voice_info_list, List<WorkflowInfo> workflow_info_list) {
            p.i(bot_id, "bot_id");
            p.i(default_user_input_type, "default_user_input_type");
            p.i(icon_url, "icon_url");
            p.i(name, "name");
            p.i(owner_user_id, "owner_user_id");
            p.i(plugin_info_list, "plugin_info_list");
            p.i(prompt_info, "prompt_info");
            p.i(shortcut_commands, "shortcut_commands");
            p.i(suggest_reply_info, "suggest_reply_info");
            p.i(version, "version");
            return new Data(background_image_info, bot_id, bot_mode, create_time, default_user_input_type, description, icon_url, knowledge, media_config, model_info, name, onboarding_info, owner_user_id, plugin_info_list, prompt_info, shortcut_commands, suggest_reply_info, update_time, variables, version, voice_info_list, workflow_info_list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return p.d(this.background_image_info, data.background_image_info) && p.d(this.bot_id, data.bot_id) && this.bot_mode == data.bot_mode && this.create_time == data.create_time && p.d(this.default_user_input_type, data.default_user_input_type) && p.d(this.description, data.description) && p.d(this.icon_url, data.icon_url) && p.d(this.knowledge, data.knowledge) && p.d(this.media_config, data.media_config) && p.d(this.model_info, data.model_info) && p.d(this.name, data.name) && p.d(this.onboarding_info, data.onboarding_info) && p.d(this.owner_user_id, data.owner_user_id) && p.d(this.plugin_info_list, data.plugin_info_list) && p.d(this.prompt_info, data.prompt_info) && p.d(this.shortcut_commands, data.shortcut_commands) && p.d(this.suggest_reply_info, data.suggest_reply_info) && this.update_time == data.update_time && p.d(this.variables, data.variables) && p.d(this.version, data.version) && p.d(this.voice_info_list, data.voice_info_list) && p.d(this.workflow_info_list, data.workflow_info_list);
        }

        public final BackgroundImageInfo getBackground_image_info() {
            return this.background_image_info;
        }

        public final String getBot_id() {
            return this.bot_id;
        }

        public final int getBot_mode() {
            return this.bot_mode;
        }

        public final int getCreate_time() {
            return this.create_time;
        }

        public final String getDefault_user_input_type() {
            return this.default_user_input_type;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getIcon_url() {
            return this.icon_url;
        }

        public final Knowledge getKnowledge() {
            return this.knowledge;
        }

        public final MediaConfig getMedia_config() {
            return this.media_config;
        }

        public final ModelInfo getModel_info() {
            return this.model_info;
        }

        public final String getName() {
            return this.name;
        }

        public final OnboardingInfo getOnboarding_info() {
            return this.onboarding_info;
        }

        public final String getOwner_user_id() {
            return this.owner_user_id;
        }

        public final List<Object> getPlugin_info_list() {
            return this.plugin_info_list;
        }

        public final PromptInfo getPrompt_info() {
            return this.prompt_info;
        }

        public final List<Object> getShortcut_commands() {
            return this.shortcut_commands;
        }

        public final SuggestReplyInfo getSuggest_reply_info() {
            return this.suggest_reply_info;
        }

        public final int getUpdate_time() {
            return this.update_time;
        }

        public final List<Object> getVariables() {
            return this.variables;
        }

        public final String getVersion() {
            return this.version;
        }

        public final List<Object> getVoice_info_list() {
            return this.voice_info_list;
        }

        public final List<WorkflowInfo> getWorkflow_info_list() {
            return this.workflow_info_list;
        }

        public int hashCode() {
            BackgroundImageInfo backgroundImageInfo = this.background_image_info;
            int iHashCode = (((((((((backgroundImageInfo == null ? 0 : backgroundImageInfo.hashCode()) * 31) + this.bot_id.hashCode()) * 31) + Integer.hashCode(this.bot_mode)) * 31) + Integer.hashCode(this.create_time)) * 31) + this.default_user_input_type.hashCode()) * 31;
            String str = this.description;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon_url.hashCode()) * 31;
            Knowledge knowledge = this.knowledge;
            int iHashCode3 = (iHashCode2 + (knowledge == null ? 0 : knowledge.hashCode())) * 31;
            MediaConfig mediaConfig = this.media_config;
            int iHashCode4 = (iHashCode3 + (mediaConfig == null ? 0 : mediaConfig.hashCode())) * 31;
            ModelInfo modelInfo = this.model_info;
            int iHashCode5 = (((iHashCode4 + (modelInfo == null ? 0 : modelInfo.hashCode())) * 31) + this.name.hashCode()) * 31;
            OnboardingInfo onboardingInfo = this.onboarding_info;
            int iHashCode6 = (((((((((((((iHashCode5 + (onboardingInfo == null ? 0 : onboardingInfo.hashCode())) * 31) + this.owner_user_id.hashCode()) * 31) + this.plugin_info_list.hashCode()) * 31) + this.prompt_info.hashCode()) * 31) + this.shortcut_commands.hashCode()) * 31) + this.suggest_reply_info.hashCode()) * 31) + Integer.hashCode(this.update_time)) * 31;
            List<Object> list = this.variables;
            int iHashCode7 = (((iHashCode6 + (list == null ? 0 : list.hashCode())) * 31) + this.version.hashCode()) * 31;
            List<Object> list2 = this.voice_info_list;
            int iHashCode8 = (iHashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
            List<WorkflowInfo> list3 = this.workflow_info_list;
            return iHashCode8 + (list3 != null ? list3.hashCode() : 0);
        }

        public String toString() {
            return "Data(background_image_info=" + this.background_image_info + ", bot_id=" + this.bot_id + ", bot_mode=" + this.bot_mode + ", create_time=" + this.create_time + ", default_user_input_type=" + this.default_user_input_type + ", description=" + this.description + ", icon_url=" + this.icon_url + ", knowledge=" + this.knowledge + ", media_config=" + this.media_config + ", model_info=" + this.model_info + ", name=" + this.name + ", onboarding_info=" + this.onboarding_info + ", owner_user_id=" + this.owner_user_id + ", plugin_info_list=" + this.plugin_info_list + ", prompt_info=" + this.prompt_info + ", shortcut_commands=" + this.shortcut_commands + ", suggest_reply_info=" + this.suggest_reply_info + ", update_time=" + this.update_time + ", variables=" + this.variables + ", version=" + this.version + ", voice_info_list=" + this.voice_info_list + ", workflow_info_list=" + this.workflow_info_list + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/AgentDetailResult$Detail;", "", "logid", "", "<init>", "(Ljava/lang/String;)V", "getLogid", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Detail {
        private final String logid;

        public Detail(String logid) {
            p.i(logid, "logid");
            this.logid = logid;
        }

        public static /* synthetic */ Detail copy$default(Detail detail, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = detail.logid;
            }
            return detail.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLogid() {
            return this.logid;
        }

        public final Detail copy(String logid) {
            p.i(logid, "logid");
            return new Detail(logid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Detail) && p.d(this.logid, ((Detail) other).logid);
        }

        public final String getLogid() {
            return this.logid;
        }

        public int hashCode() {
            return this.logid.hashCode();
        }

        public String toString() {
            return "Detail(logid=" + this.logid + ")";
        }
    }

    public AgentDetailResult(int i10, Data data, Detail detail, String msg) {
        p.i(data, "data");
        p.i(detail, "detail");
        p.i(msg, "msg");
        this.code = i10;
        this.data = data;
        this.detail = detail;
        this.msg = msg;
    }

    public static /* synthetic */ AgentDetailResult copy$default(AgentDetailResult agentDetailResult, int i10, Data data, Detail detail, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = agentDetailResult.code;
        }
        if ((i11 & 2) != 0) {
            data = agentDetailResult.data;
        }
        if ((i11 & 4) != 0) {
            detail = agentDetailResult.detail;
        }
        if ((i11 & 8) != 0) {
            str = agentDetailResult.msg;
        }
        return agentDetailResult.copy(i10, data, detail, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final Detail getDetail() {
        return this.detail;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final AgentDetailResult copy(int code, Data data, Detail detail, String msg) {
        p.i(data, "data");
        p.i(detail, "detail");
        p.i(msg, "msg");
        return new AgentDetailResult(code, data, detail, msg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentDetailResult)) {
            return false;
        }
        AgentDetailResult agentDetailResult = (AgentDetailResult) other;
        return this.code == agentDetailResult.code && p.d(this.data, agentDetailResult.data) && p.d(this.detail, agentDetailResult.detail) && p.d(this.msg, agentDetailResult.msg);
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final Detail getDetail() {
        return this.detail;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.data.hashCode()) * 31) + this.detail.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "AgentDetailResult(code=" + this.code + ", data=" + this.data + ", detail=" + this.detail + ", msg=" + this.msg + ")";
    }
}
