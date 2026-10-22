package com.stepos.common;

import androidx.annotation.Keep;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b2\b\u0087\b\u0018\u00002\u00020\u0001:\u0001BB\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\rHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010%R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010%¨\u0006C"}, d2 = {"Lcom/stepos/common/FunctionCall;", "", "api_id", "", "api_name", "arguments", "name", "plugin", "plugin_icon", "plugin_icon_uri", "plugin_id", "plugin_name", "plugin_type", "", "toolId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "hidden", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getApi_id", "()Ljava/lang/String;", "getApi_name", "getArguments", "()Ljava/lang/Object;", "getName", "getPlugin", "getPlugin_icon", "getPlugin_icon_uri", "getPlugin_id", "getPlugin_name", "getPlugin_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToolId", "setToolId", "(Ljava/lang/String;)V", "getContent", "setContent", "getHidden", "()Z", "setHidden", "(Z)V", "getDisplayName", "setDisplayName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/stepos/common/FunctionCall;", "equals", "other", "hashCode", "toString", "Arguments", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FunctionCall {
    private final String api_id;
    private final String api_name;
    private final Object arguments;
    private String content;
    private String displayName;
    private boolean hidden;
    private final String name;
    private final String plugin;
    private final String plugin_icon;
    private final String plugin_icon_uri;
    private final String plugin_id;
    private final String plugin_name;
    private final Integer plugin_type;
    private String toolId;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/common/FunctionCall$Arguments;", "", "q", "", "<init>", "(Ljava/lang/String;)V", "getQ", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Arguments {
        private final String q;

        public Arguments(String q10) {
            p.i(q10, "q");
            this.q = q10;
        }

        public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = arguments.q;
            }
            return arguments.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQ() {
            return this.q;
        }

        public final Arguments copy(String q10) {
            p.i(q10, "q");
            return new Arguments(q10);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Arguments) && p.d(this.q, ((Arguments) other).q);
        }

        public final String getQ() {
            return this.q;
        }

        public int hashCode() {
            return this.q.hashCode();
        }

        public String toString() {
            return "Arguments(q=" + this.q + ")";
        }
    }

    public FunctionCall() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, 16383, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getApi_id() {
        return this.api_id;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getPlugin_type() {
        return this.plugin_type;
    }

    /* renamed from: component11, reason: from getter */
    public final String getToolId() {
        return this.toolId;
    }

    /* renamed from: component12, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getHidden() {
        return this.hidden;
    }

    /* renamed from: component14, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getApi_name() {
        return this.api_name;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getArguments() {
        return this.arguments;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPlugin() {
        return this.plugin;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPlugin_icon() {
        return this.plugin_icon;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPlugin_icon_uri() {
        return this.plugin_icon_uri;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPlugin_id() {
        return this.plugin_id;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPlugin_name() {
        return this.plugin_name;
    }

    public final FunctionCall copy(String api_id, String api_name, Object arguments, String name, String plugin, String plugin_icon, String plugin_icon_uri, String plugin_id, String plugin_name, Integer plugin_type, String toolId, String content, boolean hidden, String displayName) {
        return new FunctionCall(api_id, api_name, arguments, name, plugin, plugin_icon, plugin_icon_uri, plugin_id, plugin_name, plugin_type, toolId, content, hidden, displayName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCall)) {
            return false;
        }
        FunctionCall functionCall = (FunctionCall) other;
        return p.d(this.api_id, functionCall.api_id) && p.d(this.api_name, functionCall.api_name) && p.d(this.arguments, functionCall.arguments) && p.d(this.name, functionCall.name) && p.d(this.plugin, functionCall.plugin) && p.d(this.plugin_icon, functionCall.plugin_icon) && p.d(this.plugin_icon_uri, functionCall.plugin_icon_uri) && p.d(this.plugin_id, functionCall.plugin_id) && p.d(this.plugin_name, functionCall.plugin_name) && p.d(this.plugin_type, functionCall.plugin_type) && p.d(this.toolId, functionCall.toolId) && p.d(this.content, functionCall.content) && this.hidden == functionCall.hidden && p.d(this.displayName, functionCall.displayName);
    }

    public final String getApi_id() {
        return this.api_id;
    }

    public final String getApi_name() {
        return this.api_name;
    }

    public final Object getArguments() {
        return this.arguments;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlugin() {
        return this.plugin;
    }

    public final String getPlugin_icon() {
        return this.plugin_icon;
    }

    public final String getPlugin_icon_uri() {
        return this.plugin_icon_uri;
    }

    public final String getPlugin_id() {
        return this.plugin_id;
    }

    public final String getPlugin_name() {
        return this.plugin_name;
    }

    public final Integer getPlugin_type() {
        return this.plugin_type;
    }

    public final String getToolId() {
        return this.toolId;
    }

    public int hashCode() {
        String str = this.api_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.api_name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj = this.arguments;
        int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.plugin;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.plugin_icon;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.plugin_icon_uri;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.plugin_id;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.plugin_name;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.plugin_type;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str9 = this.toolId;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.content;
        int iHashCode12 = (((iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31) + Boolean.hashCode(this.hidden)) * 31;
        String str11 = this.displayName;
        return iHashCode12 + (str11 != null ? str11.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final void setHidden(boolean z10) {
        this.hidden = z10;
    }

    public final void setToolId(String str) {
        this.toolId = str;
    }

    public String toString() {
        return "FunctionCall(api_id=" + this.api_id + ", api_name=" + this.api_name + ", arguments=" + this.arguments + ", name=" + this.name + ", plugin=" + this.plugin + ", plugin_icon=" + this.plugin_icon + ", plugin_icon_uri=" + this.plugin_icon_uri + ", plugin_id=" + this.plugin_id + ", plugin_name=" + this.plugin_name + ", plugin_type=" + this.plugin_type + ", toolId=" + this.toolId + ", content=" + this.content + ", hidden=" + this.hidden + ", displayName=" + this.displayName + ")";
    }

    public FunctionCall(String str, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, boolean z10, String str11) {
        this.api_id = str;
        this.api_name = str2;
        this.arguments = obj;
        this.name = str3;
        this.plugin = str4;
        this.plugin_icon = str5;
        this.plugin_icon_uri = str6;
        this.plugin_id = str7;
        this.plugin_name = str8;
        this.plugin_type = num;
        this.toolId = str9;
        this.content = str10;
        this.hidden = z10;
        this.displayName = str11;
    }

    public /* synthetic */ FunctionCall(String str, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, boolean z10, String str11, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : obj, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : num, (i10 & 1024) != 0 ? null : str9, (i10 & 2048) != 0 ? null : str10, (i10 & 4096) != 0 ? false : z10, (i10 & b.THRESHOLD) != 0 ? null : str11);
    }
}
