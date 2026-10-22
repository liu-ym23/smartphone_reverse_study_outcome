package com.bytedance.android.ec.base.api.ai;

import com.heytap.mcssdk.constant.b;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J=\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIStateLogRequest;", "", "", "component1", "component2", "component3", "component4", "component5", b.f276376z, "bizTaskId", "content", "source", "pageId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", "getBizTaskId", "getContent", "getSource", "getPageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIStateLogRequest {
    public static final a Companion = null;
    public static final String SOURCE_PAGE = "page";
    public static final String SOURCE_USER = "user";
    private final String appKey;
    private final String bizTaskId;
    private final String content;
    private final String pageId;
    private final String source;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ AIStateLogRequest copy$default(AIStateLogRequest r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.appKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bizTaskId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.source;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.pageId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.bizTaskId;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.source;
    }

    public final String component5() {
        return this.pageId;
    }

    public final AIStateLogRequest copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, b.f276376z);
        Intrinsics.checkNotNullParameter(r101, "bizTaskId");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "source");
        return new AIStateLogRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIStateLogRequest) == false) goto L16;
        AIStateLogRequest r101 = (AIStateLogRequest) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTaskId, r101.bizTaskId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.appKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizTaskId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.source;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.pageId;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AIStateLogRequest(appKey=" + this.appKey + ", bizTaskId=" + this.bizTaskId + ", content=" + this.content + ", source=" + this.source + ", pageId=" + this.pageId + ")";
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getBizTaskId() {
        return this.bizTaskId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getSource() {
        return this.source;
    }

    public AIStateLogRequest(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, b.f276376z);
        Intrinsics.checkNotNullParameter(r101, "bizTaskId");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.appKey = r100;
        this.bizTaskId = r101;
        this.content = r102;
        this.source = r103;
        this.pageId = r104;
    }

    public /* synthetic */ AIStateLogRequest(String r100, String r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = "page";
    L5:
        String r103 = r110;
        if ((r112 & 16) == 0) goto L8;
        r111 = null;
    L8:
        this(r100, r101, r102, r103, r111);
    }
}
