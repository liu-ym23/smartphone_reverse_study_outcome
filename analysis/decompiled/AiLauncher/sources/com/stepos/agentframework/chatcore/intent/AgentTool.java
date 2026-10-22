package com.stepos.agentframework.chatcore.intent;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ame.sdk.SkillStoreKt;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJÖ\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010(R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010%\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010(R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010%\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010(R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010(R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010(R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010(R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010(R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010(R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010(R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010(R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010G\u001a\u0004\bH\u0010!\"\u0004\bI\u0010JR\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00105\u001a\u0004\bK\u00107\"\u0004\bL\u00109R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010(R\"\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010G\u001a\u0004\bO\u0010!\"\u0004\bP\u0010JR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bG\u0010SR\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00105\u001a\u0004\bT\u00107\"\u0004\bU\u00109R\"\u0010V\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010%\u001a\u0004\bW\u0010\u001f\"\u0004\bX\u0010(¨\u0006Y"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/e;", "", "", "toolCallId", "logo", "name", "description", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "parameter", "packageName", "", "isFinished", "pluginName", "result", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "toolId", "apiName", "", "likeStatus", "hidden", "displayName", "progressPercent", "", "progressDurationMs", "isUpdate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;IJZ)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;IJZ)Lcom/stepos/agentframework/chatcore/intent/e;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "s", "L", "(Ljava/lang/String;)V", "k", "D", "l", ExifInterface.LONGITUDE_EAST, Const.INTENT_KEY_BACKGROUND_COMMAND, "setDescription", "f", "setContent", "n", "G", "m", "F", "Z", "u", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "o", "H", "r", "K", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "x", "(Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", "t", "M", "c", "w", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "C", "(I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "B", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "z", "q", "J", "p", "()J", "(J)V", "v", "N", "clientRenderSource", "e", "y", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.intent.e, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTool {

    @SerializedName("api_name")
    private String apiName;
    private AppUIData appUIData;
    private transient String clientRenderSource;
    private String content;
    private String description;
    private String displayName;
    private boolean hidden;
    private boolean isFinished;
    private boolean isUpdate;
    private int likeStatus;
    private String logo;
    private String name;
    private String packageName;
    private String parameter;
    private String pluginName;
    private long progressDurationMs;
    private int progressPercent;
    private String result;
    private String toolCallId;
    private String toolId;

    public AgentTool() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, null, 0, false, null, 0, 0L, false, 524287, null);
    }

    public static /* synthetic */ AgentTool b(AgentTool agentTool, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, String str8, String str9, AppUIData appUIData, String str10, String str11, int i10, boolean z11, String str12, int i11, long j10, boolean z12, int i12, Object obj) {
        boolean z13;
        long j11;
        String str13 = (i12 & 1) != 0 ? agentTool.toolCallId : str;
        String str14 = (i12 & 2) != 0 ? agentTool.logo : str2;
        String str15 = (i12 & 4) != 0 ? agentTool.name : str3;
        String str16 = (i12 & 8) != 0 ? agentTool.description : str4;
        String str17 = (i12 & 16) != 0 ? agentTool.content : str5;
        String str18 = (i12 & 32) != 0 ? agentTool.parameter : str6;
        String str19 = (i12 & 64) != 0 ? agentTool.packageName : str7;
        boolean z14 = (i12 & 128) != 0 ? agentTool.isFinished : z10;
        String str20 = (i12 & 256) != 0 ? agentTool.pluginName : str8;
        String str21 = (i12 & 512) != 0 ? agentTool.result : str9;
        AppUIData appUIData2 = (i12 & 1024) != 0 ? agentTool.appUIData : appUIData;
        String str22 = (i12 & 2048) != 0 ? agentTool.toolId : str10;
        String str23 = (i12 & 4096) != 0 ? agentTool.apiName : str11;
        int i13 = (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? agentTool.likeStatus : i10;
        String str24 = str13;
        boolean z15 = (i12 & 16384) != 0 ? agentTool.hidden : z11;
        String str25 = (i12 & 32768) != 0 ? agentTool.displayName : str12;
        int i14 = (i12 & 65536) != 0 ? agentTool.progressPercent : i11;
        boolean z16 = z15;
        long j12 = (i12 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? agentTool.progressDurationMs : j10;
        if ((i12 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0) {
            j11 = j12;
            z13 = agentTool.isUpdate;
        } else {
            z13 = z12;
            j11 = j12;
        }
        return agentTool.a(str24, str14, str15, str16, str17, str18, str19, z14, str20, str21, appUIData2, str22, str23, i13, z16, str25, i14, j11, z13);
    }

    public final void A(boolean z10) {
        this.isFinished = z10;
    }

    public final void B(boolean z10) {
        this.hidden = z10;
    }

    public final void C(int i10) {
        this.likeStatus = i10;
    }

    public final void D(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.logo = str;
    }

    public final void E(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.name = str;
    }

    public final void F(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.packageName = str;
    }

    public final void G(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.parameter = str;
    }

    public final void H(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.pluginName = str;
    }

    public final void I(long j10) {
        this.progressDurationMs = j10;
    }

    public final void J(int i10) {
        this.progressPercent = i10;
    }

    public final void K(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.result = str;
    }

    public final void L(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.toolCallId = str;
    }

    public final void M(String str) {
        this.toolId = str;
    }

    public final void N(boolean z10) {
        this.isUpdate = z10;
    }

    public final AgentTool a(String toolCallId, String logo, String name, String description, String content, String parameter, String packageName, boolean isFinished, String pluginName, String result, AppUIData appUIData, String toolId, String apiName, int likeStatus, boolean hidden, String displayName, int progressPercent, long progressDurationMs, boolean isUpdate) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(logo, "logo");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(packageName, "packageName");
        kotlin.jvm.internal.p.i(pluginName, "pluginName");
        kotlin.jvm.internal.p.i(result, "result");
        return new AgentTool(toolCallId, logo, name, description, content, parameter, packageName, isFinished, pluginName, result, appUIData, toolId, apiName, likeStatus, hidden, displayName, progressPercent, progressDurationMs, isUpdate);
    }

    /* renamed from: c, reason: from getter */
    public final String getApiName() {
        return this.apiName;
    }

    /* renamed from: d, reason: from getter */
    public final AppUIData getAppUIData() {
        return this.appUIData;
    }

    /* renamed from: e, reason: from getter */
    public final String getClientRenderSource() {
        return this.clientRenderSource;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTool)) {
            return false;
        }
        AgentTool agentTool = (AgentTool) other;
        return kotlin.jvm.internal.p.d(this.toolCallId, agentTool.toolCallId) && kotlin.jvm.internal.p.d(this.logo, agentTool.logo) && kotlin.jvm.internal.p.d(this.name, agentTool.name) && kotlin.jvm.internal.p.d(this.description, agentTool.description) && kotlin.jvm.internal.p.d(this.content, agentTool.content) && kotlin.jvm.internal.p.d(this.parameter, agentTool.parameter) && kotlin.jvm.internal.p.d(this.packageName, agentTool.packageName) && this.isFinished == agentTool.isFinished && kotlin.jvm.internal.p.d(this.pluginName, agentTool.pluginName) && kotlin.jvm.internal.p.d(this.result, agentTool.result) && kotlin.jvm.internal.p.d(this.appUIData, agentTool.appUIData) && kotlin.jvm.internal.p.d(this.toolId, agentTool.toolId) && kotlin.jvm.internal.p.d(this.apiName, agentTool.apiName) && this.likeStatus == agentTool.likeStatus && this.hidden == agentTool.hidden && kotlin.jvm.internal.p.d(this.displayName, agentTool.displayName) && this.progressPercent == agentTool.progressPercent && this.progressDurationMs == agentTool.progressDurationMs && this.isUpdate == agentTool.isUpdate;
    }

    /* renamed from: f, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: g, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: h, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((this.toolCallId.hashCode() * 31) + this.logo.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.content.hashCode()) * 31) + this.parameter.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Boolean.hashCode(this.isFinished)) * 31) + this.pluginName.hashCode()) * 31) + this.result.hashCode()) * 31;
        AppUIData appUIData = this.appUIData;
        int iHashCode2 = (iHashCode + (appUIData == null ? 0 : appUIData.hashCode())) * 31;
        String str = this.toolId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.apiName;
        int iHashCode4 = (((((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.likeStatus)) * 31) + Boolean.hashCode(this.hidden)) * 31;
        String str3 = this.displayName;
        return ((((((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.hashCode(this.progressPercent)) * 31) + Long.hashCode(this.progressDurationMs)) * 31) + Boolean.hashCode(this.isUpdate);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getHidden() {
        return this.hidden;
    }

    /* renamed from: j, reason: from getter */
    public final int getLikeStatus() {
        return this.likeStatus;
    }

    /* renamed from: k, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* renamed from: l, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: m, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: n, reason: from getter */
    public final String getParameter() {
        return this.parameter;
    }

    /* renamed from: o, reason: from getter */
    public final String getPluginName() {
        return this.pluginName;
    }

    /* renamed from: p, reason: from getter */
    public final long getProgressDurationMs() {
        return this.progressDurationMs;
    }

    /* renamed from: q, reason: from getter */
    public final int getProgressPercent() {
        return this.progressPercent;
    }

    /* renamed from: r, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: s, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: t, reason: from getter */
    public final String getToolId() {
        return this.toolId;
    }

    public String toString() {
        return "AgentTool(toolCallId=" + this.toolCallId + ", logo=" + this.logo + ", name=" + this.name + ", description=" + this.description + ", content=" + this.content + ", parameter=" + this.parameter + ", packageName=" + this.packageName + ", isFinished=" + this.isFinished + ", pluginName=" + this.pluginName + ", result=" + this.result + ", appUIData=" + this.appUIData + ", toolId=" + this.toolId + ", apiName=" + this.apiName + ", likeStatus=" + this.likeStatus + ", hidden=" + this.hidden + ", displayName=" + this.displayName + ", progressPercent=" + this.progressPercent + ", progressDurationMs=" + this.progressDurationMs + ", isUpdate=" + this.isUpdate + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsUpdate() {
        return this.isUpdate;
    }

    public final void w(String str) {
        this.apiName = str;
    }

    public final void x(AppUIData appUIData) {
        this.appUIData = appUIData;
    }

    public final void y(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.clientRenderSource = str;
    }

    public final void z(String str) {
        this.displayName = str;
    }

    public AgentTool(String toolCallId, String logo, String name, String description, String content, String parameter, String packageName, boolean z10, String pluginName, String result, AppUIData appUIData, String str, String str2, int i10, boolean z11, String str3, int i11, long j10, boolean z12) {
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
        this.apiName = str2;
        this.likeStatus = i10;
        this.hidden = z11;
        this.displayName = str3;
        this.progressPercent = i11;
        this.progressDurationMs = j10;
        this.isUpdate = z12;
        this.clientRenderSource = com.stepos.ailauncher.chat.trace.f.ENTRY_HISTORY;
    }

    public /* synthetic */ AgentTool(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, String str8, String str9, AppUIData appUIData, String str10, String str11, int i10, boolean z11, String str12, int i11, long j10, boolean z12, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? "" : str2, (i12 & 4) != 0 ? "" : str3, (i12 & 8) != 0 ? "" : str4, (i12 & 16) != 0 ? "" : str5, (i12 & 32) != 0 ? "" : str6, (i12 & 64) != 0 ? "" : str7, (i12 & 128) != 0 ? false : z10, (i12 & 256) != 0 ? "" : str8, (i12 & 512) == 0 ? str9 : "", (i12 & 1024) != 0 ? null : appUIData, (i12 & 2048) != 0 ? null : str10, (i12 & 4096) != 0 ? null : str11, (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 0 : i10, (i12 & 16384) != 0 ? false : z11, (i12 & 32768) != 0 ? null : str12, (i12 & 65536) != 0 ? 0 : i11, (i12 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? 0L : j10, (i12 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? false : z12);
    }
}
