package com.stepos.ability.beaninternal.ability;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u0003H\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/AiActivityWidgetInfo;", "", "toolName", "", "params", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getToolName", "()Ljava/lang/String;", "setToolName", "(Ljava/lang/String;)V", "getParams", "setParams", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AiActivityWidgetInfo {
    private String params;
    private String toolName;

    /* JADX WARN: Multi-variable type inference failed */
    public AiActivityWidgetInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AiActivityWidgetInfo copy$default(AiActivityWidgetInfo aiActivityWidgetInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiActivityWidgetInfo.toolName;
        }
        if ((i & 2) != 0) {
            str2 = aiActivityWidgetInfo.params;
        }
        return aiActivityWidgetInfo.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final AiActivityWidgetInfo copy(String toolName, String params) {
        k.f(toolName, "toolName");
        k.f(params, "params");
        return new AiActivityWidgetInfo(toolName, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiActivityWidgetInfo)) {
            return false;
        }
        AiActivityWidgetInfo aiActivityWidgetInfo = (AiActivityWidgetInfo) other;
        return k.b(this.toolName, aiActivityWidgetInfo.toolName) && k.b(this.params, aiActivityWidgetInfo.params);
    }

    public final String getParams() {
        return this.params;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public int hashCode() {
        return this.params.hashCode() + (this.toolName.hashCode() * 31);
    }

    public final void setParams(String str) {
        k.f(str, "<set-?>");
        this.params = str;
    }

    public final void setToolName(String str) {
        k.f(str, "<set-?>");
        this.toolName = str;
    }

    public String toString() {
        return "AiActivityWidgetInfo(toolName=" + this.toolName + ", params=<redacted>, hasParams=" + (this.params.length() > 0) + ")";
    }

    public AiActivityWidgetInfo(String toolName, String params) {
        k.f(toolName, "toolName");
        k.f(params, "params");
        this.toolName = toolName;
        this.params = params;
    }

    public /* synthetic */ AiActivityWidgetInfo(String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
