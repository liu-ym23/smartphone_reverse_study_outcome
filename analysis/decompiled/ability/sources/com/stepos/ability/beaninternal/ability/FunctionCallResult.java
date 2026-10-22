package com.stepos.ability.beaninternal.ability;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "", "success", "", "content", "", "structuredContent", "errorCode", "", "errorMsg", "meta", "", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/Object;ILjava/lang/String;Ljava/util/Map;)V", "getSuccess", "()Z", "getContent", "()Ljava/lang/String;", "getStructuredContent", "()Ljava/lang/Object;", "getErrorCode", "()I", "getErrorMsg", "getMeta", "()Ljava/util/Map;", "setMeta", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FunctionCallResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final int errorCode;
    private final String errorMsg;
    private Map<String, ? extends Object> meta;
    private final Object structuredContent;
    private final boolean success;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nJJ\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¨\u0006\u000f"}, d2 = {"Lcom/stepos/ability/beaninternal/ability/FunctionCallResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "ok", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "content", "", "structuredContent", "meta", "", "error", "errorCode", "", "errorMsg", "beanInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionCallResult error$default(Companion companion, int i, String str, String str2, Object obj, Map map, int i6, Object obj2) {
            if ((i6 & 4) != 0) {
                str2 = null;
            }
            if ((i6 & 8) != 0) {
                obj = null;
            }
            if ((i6 & 16) != 0) {
                map = null;
            }
            return companion.error(i, str, str2, obj, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FunctionCallResult ok$default(Companion companion, String str, Object obj, Map map, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.ok(str, obj, map);
        }

        public final FunctionCallResult error(int errorCode, String errorMsg, String content, Object structuredContent, Map<String, ? extends Object> meta) {
            return new FunctionCallResult(false, content, structuredContent, errorCode, errorMsg, meta);
        }

        public final FunctionCallResult ok(String content, Object structuredContent, Map<String, ? extends Object> meta) {
            return new FunctionCallResult(true, content, structuredContent, 0, null, meta);
        }

        private Companion() {
        }
    }

    public FunctionCallResult(boolean z10, String str, Object obj, int i, String str2, Map<String, ? extends Object> map) {
        this.success = z10;
        this.content = str;
        this.structuredContent = obj;
        this.errorCode = i;
        this.errorMsg = str2;
        this.meta = map;
    }

    public static /* synthetic */ FunctionCallResult copy$default(FunctionCallResult functionCallResult, boolean z10, String str, Object obj, int i, String str2, Map map, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            z10 = functionCallResult.success;
        }
        if ((i6 & 2) != 0) {
            str = functionCallResult.content;
        }
        if ((i6 & 4) != 0) {
            obj = functionCallResult.structuredContent;
        }
        if ((i6 & 8) != 0) {
            i = functionCallResult.errorCode;
        }
        if ((i6 & 16) != 0) {
            str2 = functionCallResult.errorMsg;
        }
        if ((i6 & 32) != 0) {
            map = functionCallResult.meta;
        }
        String str3 = str2;
        Map map2 = map;
        return functionCallResult.copy(z10, str, obj, i, str3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    /* renamed from: component4, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Map<String, Object> component6() {
        return this.meta;
    }

    public final FunctionCallResult copy(boolean success, String content, Object structuredContent, int errorCode, String errorMsg, Map<String, ? extends Object> meta) {
        return new FunctionCallResult(success, content, structuredContent, errorCode, errorMsg, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FunctionCallResult)) {
            return false;
        }
        FunctionCallResult functionCallResult = (FunctionCallResult) other;
        return this.success == functionCallResult.success && k.b(this.content, functionCallResult.content) && k.b(this.structuredContent, functionCallResult.structuredContent) && this.errorCode == functionCallResult.errorCode && k.b(this.errorMsg, functionCallResult.errorMsg) && k.b(this.meta, functionCallResult.meta);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Map<String, Object> getMeta() {
        return this.meta;
    }

    public final Object getStructuredContent() {
        return this.structuredContent;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Object obj = this.structuredContent;
        int iA = a.a(this.errorCode, (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31, 31);
        String str2 = this.errorMsg;
        int iHashCode3 = (iA + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, ? extends Object> map = this.meta;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final void setMeta(Map<String, ? extends Object> map) {
        this.meta = map;
    }

    public String toString() {
        return "FunctionCallResult(success=" + this.success + ", content=" + this.content + ", structuredContent=" + this.structuredContent + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", meta=" + this.meta + ")";
    }

    public /* synthetic */ FunctionCallResult(boolean z10, String str, Object obj, int i, String str2, Map map, int i6, e eVar) {
        this(z10, str, obj, i, str2, (i6 & 32) != 0 ? null : map);
    }
}
