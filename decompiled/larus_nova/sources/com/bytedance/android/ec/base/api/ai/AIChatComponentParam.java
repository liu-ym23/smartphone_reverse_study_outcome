package com.bytedance.android.ec.base.api.ai;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J7\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatComponentParam;", "", "", "component1", "", "component2", "component3", "component4", "conversationId", "useMainConv", "enterFrom", "enterMethod", "copy", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getConversationId", "()Ljava/lang/String;", "Z", "getUseMainConv", "()Z", "getEnterFrom", "getEnterMethod", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatComponentParam {
    public static final a Companion = null;
    public static final AIChatComponentParam DEFAULT = null;
    private final String conversationId;
    private final String enterFrom;
    private final String enterMethod;
    private final boolean useMainConv;

    public static final class a {
        public a() {
        }
    }

    public AIChatComponentParam() {
        this(null, false, null, null, 15, null);
    }

    public static /* synthetic */ AIChatComponentParam copy$default(AIChatComponentParam r100, String r101, boolean r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.useMainConv;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.enterFrom;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.enterMethod;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final boolean component2() {
        return this.useMainConv;
    }

    public final String component3() {
        return this.enterFrom;
    }

    public final String component4() {
        return this.enterMethod;
    }

    public final AIChatComponentParam copy(String r100, boolean r101, String r102, String r103) {
        return new AIChatComponentParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIChatComponentParam) == false) goto L14;
        AIChatComponentParam r101 = (AIChatComponentParam) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L8;
        return false;
    L8:
        if (this.useMainConv == r101.useMainConv) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.useMainConv;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterFrom;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.enterMethod;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatComponentParam(conversationId=" + this.conversationId + ", useMainConv=" + this.useMainConv + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ")";
    }

    static {
        Companion = new a();
        DEFAULT = new AIChatComponentParam(null, true, null, null, 13, null);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final boolean getUseMainConv() {
        return this.useMainConv;
    }

    public AIChatComponentParam(String r100, boolean r101, String r102, String r103) {
        this.conversationId = r100;
        this.useMainConv = r101;
        this.enterFrom = r102;
        this.enterMethod = r103;
    }

    public /* synthetic */ AIChatComponentParam(String r100, boolean r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
