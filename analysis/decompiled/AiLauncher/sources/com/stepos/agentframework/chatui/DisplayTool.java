package com.stepos.agentframework.chatui;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b<\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001\u001bB\u00ad\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001a\u0010\u0019J¶\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010'R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010$\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010'R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010$\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010'R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010$\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010'R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010'R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010$\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010'R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00104\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u00107R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b8\u0010\u001e\"\u0004\b9\u0010'R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010$\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010'R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010'R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00104\u001a\u0004\bC\u0010\u0019\"\u0004\bD\u00107R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010E\u001a\u0004\bF\u0010 \"\u0004\bG\u0010HR\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00104\u001a\u0004\bI\u0010\u0019\"\u0004\bJ\u00107R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010$\u001a\u0004\bK\u0010\u001e\"\u0004\bL\u0010'¨\u0006N"}, d2 = {"Lcom/stepos/agentframework/chatui/P1;", "", "", "toolCallId", "logo", "name", "description", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "parameter", "packageName", "", "isFinished", "pluginName", "result", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "toolId", "isExpand", "", "toolLikeStatus", "hidden", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;ZIZLjava/lang/String;)V", "k", "()Z", "D", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;ZIZLjava/lang/String;)Lcom/stepos/agentframework/chatui/P1;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "getLogo", "u", "e", "v", "getDescription", "p", "getContent", "o", "f", "x", "getPackageName", "w", "Z", "m", "s", "(Z)V", "getPluginName", "y", Const.INTENT_KEY_BACKGROUND_COMMAND, "z", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "c", "()Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "n", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "B", "l", "r", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "C", "(I)V", "getHidden", "t", Const.INTENT_KEY_UMID, "q", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.P1, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class DisplayTool {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AppUIData appUIData;
    private String content;
    private String description;
    private String displayName;
    private boolean hidden;
    private boolean isExpand;
    private boolean isFinished;
    private String logo;
    private String name;
    private String packageName;
    private String parameter;
    private String pluginName;
    private String result;
    private String toolCallId;
    private String toolId;
    private int toolLikeStatus;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/chatui/P1$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "Lcom/stepos/agentframework/chatui/P1;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/e;)Lcom/stepos/agentframework/chatui/P1;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.P1$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final DisplayTool a(AgentTool tool) {
            AppUIData appUIDataM;
            AppUIData appUIDataE;
            AppUIData appUIDataC;
            kotlin.jvm.internal.p.i(tool, "tool");
            DisplayTool displayTool = new DisplayTool(null, null, null, null, null, null, null, false, null, null, null, null, false, 0, false, null, 65535, null);
            displayTool.A(tool.getToolCallId());
            displayTool.u(tool.getLogo());
            displayTool.v(tool.getName());
            displayTool.p(tool.getDescription());
            displayTool.o(tool.getContent());
            displayTool.x(tool.getParameter());
            displayTool.w(tool.getPackageName());
            displayTool.s(tool.getIsFinished());
            displayTool.y(tool.getPluginName());
            displayTool.z(tool.getResult());
            String clientRenderSource = tool.getClientRenderSource();
            AppUIData appUIData = tool.getAppUIData();
            if (appUIData == null || (appUIDataM = O1.b(appUIData, clientRenderSource)) == null) {
                appUIDataM = TripartiteAppUiCoercion.INSTANCE.m(tool, clientRenderSource);
            }
            displayTool.n(appUIDataM);
            displayTool.B(tool.getToolId());
            displayTool.C(tool.getLikeStatus());
            displayTool.t(tool.getHidden());
            displayTool.q(tool.getDisplayName());
            String name = tool.getName();
            if (La.H.x0(name)) {
                name = null;
            }
            if (name == null) {
                name = tool.getApiName();
            }
            if (displayTool.getAppUIData() == null && (appUIDataC = q4.i.INSTANCE.C(name, tool.getResult(), tool.getParameter())) != null) {
                displayTool.n(appUIDataC);
                displayTool.t(true);
            }
            if (displayTool.getAppUIData() == null && (appUIDataE = q4.i.INSTANCE.E(name, tool.getResult(), tool.getParameter())) != null) {
                displayTool.n(appUIDataE);
                displayTool.t(true);
            }
            return displayTool;
        }

        public Companion() {
        }
    }

    public DisplayTool() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, false, 0, false, null, 65535, null);
    }

    public final void A(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.toolCallId = str;
    }

    public final void B(String str) {
        this.toolId = str;
    }

    public final void C(int i10) {
        this.toolLikeStatus = i10;
    }

    public final boolean D() {
        AppUIData appUIData = this.appUIData;
        return (appUIData == null || appUIData.getUiType() != AppUIData.INSTANCE.c()) && !k();
    }

    public final DisplayTool a(String toolCallId, String logo, String name, String description, String content, String parameter, String packageName, boolean isFinished, String pluginName, String result, AppUIData appUIData, String toolId, boolean isExpand, int toolLikeStatus, boolean hidden, String displayName) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(logo, "logo");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(packageName, "packageName");
        kotlin.jvm.internal.p.i(pluginName, "pluginName");
        kotlin.jvm.internal.p.i(result, "result");
        return new DisplayTool(toolCallId, logo, name, description, content, parameter, packageName, isFinished, pluginName, result, appUIData, toolId, isExpand, toolLikeStatus, hidden, displayName);
    }

    /* renamed from: c, reason: from getter */
    public final AppUIData getAppUIData() {
        return this.appUIData;
    }

    /* renamed from: d, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayTool)) {
            return false;
        }
        DisplayTool displayTool = (DisplayTool) other;
        return kotlin.jvm.internal.p.d(this.toolCallId, displayTool.toolCallId) && kotlin.jvm.internal.p.d(this.logo, displayTool.logo) && kotlin.jvm.internal.p.d(this.name, displayTool.name) && kotlin.jvm.internal.p.d(this.description, displayTool.description) && kotlin.jvm.internal.p.d(this.content, displayTool.content) && kotlin.jvm.internal.p.d(this.parameter, displayTool.parameter) && kotlin.jvm.internal.p.d(this.packageName, displayTool.packageName) && this.isFinished == displayTool.isFinished && kotlin.jvm.internal.p.d(this.pluginName, displayTool.pluginName) && kotlin.jvm.internal.p.d(this.result, displayTool.result) && kotlin.jvm.internal.p.d(this.appUIData, displayTool.appUIData) && kotlin.jvm.internal.p.d(this.toolId, displayTool.toolId) && this.isExpand == displayTool.isExpand && this.toolLikeStatus == displayTool.toolLikeStatus && this.hidden == displayTool.hidden && kotlin.jvm.internal.p.d(this.displayName, displayTool.displayName);
    }

    /* renamed from: f, reason: from getter */
    public final String getParameter() {
        return this.parameter;
    }

    /* renamed from: g, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: h, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.toolCallId.hashCode() * 31) + this.logo.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.content.hashCode()) * 31) + this.parameter.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Boolean.hashCode(this.isFinished)) * 31) + this.pluginName.hashCode()) * 31) + this.result.hashCode()) * 31;
        AppUIData appUIData = this.appUIData;
        int iHashCode2 = (iHashCode + (appUIData == null ? 0 : appUIData.hashCode())) * 31;
        String str = this.toolId;
        int iHashCode3 = (((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isExpand)) * 31) + Integer.hashCode(this.toolLikeStatus)) * 31) + Boolean.hashCode(this.hidden)) * 31;
        String str2 = this.displayName;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getToolId() {
        return this.toolId;
    }

    /* renamed from: j, reason: from getter */
    public final int getToolLikeStatus() {
        return this.toolLikeStatus;
    }

    public final boolean k() {
        return this.hidden || r2.INSTANCE.b(this.name, this.displayName, this.parameter);
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    public final void n(AppUIData appUIData) {
        this.appUIData = appUIData;
    }

    public final void o(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.content = str;
    }

    public final void p(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.description = str;
    }

    public final void q(String str) {
        this.displayName = str;
    }

    public final void r(boolean z10) {
        this.isExpand = z10;
    }

    public final void s(boolean z10) {
        this.isFinished = z10;
    }

    public final void t(boolean z10) {
        this.hidden = z10;
    }

    public String toString() {
        return "DisplayTool(toolCallId=" + this.toolCallId + ", logo=" + this.logo + ", name=" + this.name + ", description=" + this.description + ", content=" + this.content + ", parameter=" + this.parameter + ", packageName=" + this.packageName + ", isFinished=" + this.isFinished + ", pluginName=" + this.pluginName + ", result=" + this.result + ", appUIData=" + this.appUIData + ", toolId=" + this.toolId + ", isExpand=" + this.isExpand + ", toolLikeStatus=" + this.toolLikeStatus + ", hidden=" + this.hidden + ", displayName=" + this.displayName + ")";
    }

    public final void u(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.logo = str;
    }

    public final void v(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.name = str;
    }

    public final void w(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.packageName = str;
    }

    public final void x(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.parameter = str;
    }

    public final void y(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.pluginName = str;
    }

    public final void z(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.result = str;
    }

    public DisplayTool(String toolCallId, String logo, String name, String description, String content, String parameter, String packageName, boolean z10, String pluginName, String result, AppUIData appUIData, String str, boolean z11, int i10, boolean z12, String str2) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(logo, "logo");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(packageName, "packageName");
        kotlin.jvm.internal.p.i(pluginName, "pluginName");
        kotlin.jvm.internal.p.i(result, "result");
        this.toolCallId = toolCallId;
        this.logo = logo;
        this.name = name;
        this.description = description;
        this.content = content;
        this.parameter = parameter;
        this.packageName = packageName;
        this.isFinished = z10;
        this.pluginName = pluginName;
        this.result = result;
        this.appUIData = appUIData;
        this.toolId = str;
        this.isExpand = z11;
        this.toolLikeStatus = i10;
        this.hidden = z12;
        this.displayName = str2;
    }

    public /* synthetic */ DisplayTool(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, String str8, String str9, AppUIData appUIData, String str10, boolean z11, int i10, boolean z12, String str11, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? "" : str5, (i11 & 32) != 0 ? "" : str6, (i11 & 64) != 0 ? "" : str7, (i11 & 128) != 0 ? false : z10, (i11 & 256) != 0 ? "" : str8, (i11 & 512) == 0 ? str9 : "", (i11 & 1024) != 0 ? null : appUIData, (i11 & 2048) != 0 ? null : str10, (i11 & 4096) != 0 ? false : z11, (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 0 : i10, (i11 & 16384) != 0 ? false : z12, (i11 & 32768) != 0 ? null : str11);
    }
}
