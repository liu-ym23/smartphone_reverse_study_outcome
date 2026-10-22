package com.stepos.common;

import B7.a;
import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u00018B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\"¨\u00069"}, d2 = {"Lcom/stepos/common/FunctionCall;", "", "api_id", "", "api_name", "arguments", HintConstants.AUTOFILL_HINT_NAME, "plugin", "plugin_icon", "plugin_icon_uri", "plugin_id", "plugin_name", "plugin_type", "", "toolId", "content", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getApi_id", "()Ljava/lang/String;", "getApi_name", "getArguments", "()Ljava/lang/Object;", "getName", "getPlugin", "getPlugin_icon", "getPlugin_icon_uri", "getPlugin_id", "getPlugin_name", "getPlugin_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToolId", "setToolId", "(Ljava/lang/String;)V", "getContent", "setContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/common/FunctionCall;", "equals", "", "other", "hashCode", "toString", "Arguments", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FunctionCall {
    private final String api_id;
    private final String api_name;
    private final Object arguments;
    private String content;
    private final String name;
    private final String plugin;
    private final String plugin_icon;
    private final String plugin_icon_uri;
    private final String plugin_id;
    private final String plugin_name;
    private final Integer plugin_type;
    private String toolId;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/stepos/common/FunctionCall$Arguments;", "", "q", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getQ", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Arguments {
        private final String q;

        public Arguments(String q5) {
            k.f(q5, "q");
            this.q = q5;
        }

        public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = arguments.q;
            }
            return arguments.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getQ() {
            return this.q;
        }

        public final Arguments copy(String q5) {
            k.f(q5, "q");
            return new Arguments(q5);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Arguments) && k.b(this.q, ((Arguments) other).q);
        }

        public final String getQ() {
            return this.q;
        }

        public int hashCode() {
            return this.q.hashCode();
        }

        public String toString() {
            return a.m("Arguments(q=", this.q, ")");
        }
    }

    public FunctionCall() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ FunctionCall copy$default(FunctionCall functionCall, String str, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = functionCall.api_id;
        }
        if ((i & 2) != 0) {
            str2 = functionCall.api_name;
        }
        if ((i & 4) != 0) {
            obj = functionCall.arguments;
        }
        if ((i & 8) != 0) {
            str3 = functionCall.name;
        }
        if ((i & 16) != 0) {
            str4 = functionCall.plugin;
        }
        if ((i & 32) != 0) {
            str5 = functionCall.plugin_icon;
        }
        if ((i & 64) != 0) {
            str6 = functionCall.plugin_icon_uri;
        }
        if ((i & 128) != 0) {
            str7 = functionCall.plugin_id;
        }
        if ((i & 256) != 0) {
            str8 = functionCall.plugin_name;
        }
        if ((i & 512) != 0) {
            num = functionCall.plugin_type;
        }
        if ((i & 1024) != 0) {
            str9 = functionCall.toolId;
        }
        if ((i & 2048) != 0) {
            str10 = functionCall.content;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str8;
        Integer num2 = num;
        String str14 = str6;
        String str15 = str7;
        String str16 = str4;
        String str17 = str5;
        return functionCall.copy(str, str2, obj, str3, str16, str17, str14, str15, str13, num2, str11, str12);
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

    public final FunctionCall copy(String api_id, String api_name, Object arguments, String name, String plugin, String plugin_icon, String plugin_icon_uri, String plugin_id, String plugin_name, Integer plugin_type, String toolId, String content) {
        return new FunctionCall(api_id, api_name, arguments, name, plugin, plugin_icon, plugin_icon_uri, plugin_id, plugin_name, plugin_type, toolId, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCall)) {
            return false;
        }
        FunctionCall functionCall = (FunctionCall) other;
        return k.b(this.api_id, functionCall.api_id) && k.b(this.api_name, functionCall.api_name) && k.b(this.arguments, functionCall.arguments) && k.b(this.name, functionCall.name) && k.b(this.plugin, functionCall.plugin) && k.b(this.plugin_icon, functionCall.plugin_icon) && k.b(this.plugin_icon_uri, functionCall.plugin_icon_uri) && k.b(this.plugin_id, functionCall.plugin_id) && k.b(this.plugin_name, functionCall.plugin_name) && k.b(this.plugin_type, functionCall.plugin_type) && k.b(this.toolId, functionCall.toolId) && k.b(this.content, functionCall.content);
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
        return iHashCode11 + (str10 != null ? str10.hashCode() : 0);
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setToolId(String str) {
        this.toolId = str;
    }

    public String toString() {
        String str = this.api_id;
        String str2 = this.api_name;
        Object obj = this.arguments;
        String str3 = this.name;
        String str4 = this.plugin;
        String str5 = this.plugin_icon;
        String str6 = this.plugin_icon_uri;
        String str7 = this.plugin_id;
        String str8 = this.plugin_name;
        Integer num = this.plugin_type;
        String str9 = this.toolId;
        String str10 = this.content;
        StringBuilder sbW = a.w("FunctionCall(api_id=", str, ", api_name=", str2, ", arguments=");
        sbW.append(obj);
        sbW.append(", name=");
        sbW.append(str3);
        sbW.append(", plugin=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str4, ", plugin_icon=", str5, ", plugin_icon_uri=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str6, ", plugin_id=", str7, ", plugin_name=");
        sbW.append(str8);
        sbW.append(", plugin_type=");
        sbW.append(num);
        sbW.append(", toolId=");
        return androidx.appfunctions.metadata.a.p(sbW, str9, ", content=", str10, ")");
    }

    public FunctionCall(String str, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10) {
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
    }

    public /* synthetic */ FunctionCall(String str, String str2, Object obj, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : obj, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10);
    }
}
