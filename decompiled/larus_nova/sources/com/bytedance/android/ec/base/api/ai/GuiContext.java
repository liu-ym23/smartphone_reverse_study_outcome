package com.bytedance.android.ec.base.api.ai;

import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/GuiContext;", "", "artifactType", "", "artifactSource", "originMessageId", "uri", "view", "Lcom/bytedance/android/ec/base/api/ai/GuiView;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/base/api/ai/GuiView;)V", "getArtifactSource", "()Ljava/lang/String;", "getArtifactType", "getOriginMessageId", "getUri", "getView", "()Lcom/bytedance/android/ec/base/api/ai/GuiView;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class GuiContext {

    @SerializedName("artifact_source")
    private final String artifactSource;

    @SerializedName("artifact_type")
    private final String artifactType;

    @SerializedName(ConversationConstants.KEY_ORIGIN_MESSAGE_ID)
    private final String originMessageId;

    @SerializedName("uri")
    private final String uri;

    @SerializedName("view")
    private final GuiView view;

    public GuiContext() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GuiContext copy$default(GuiContext r100, String r101, String r102, String r103, String r104, GuiView r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.artifactType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.artifactSource;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.originMessageId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.uri;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.view;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.artifactType;
    }

    public final String component2() {
        return this.artifactSource;
    }

    public final String component3() {
        return this.originMessageId;
    }

    public final String component4() {
        return this.uri;
    }

    public final GuiView component5() {
        return this.view;
    }

    public final GuiContext copy(String r100, String r101, String r110, String r111, GuiView r112) {
        return new GuiContext(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GuiContext) == false) goto L16;
        GuiContext r101 = (GuiContext) r100;
        if (Intrinsics.areEqual(this.artifactType, r101.artifactType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.artifactSource, r101.artifactSource) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originMessageId, r101.originMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.artifactType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.artifactSource;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.originMessageId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.uri;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        GuiView r113 = this.view;
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
        return "GuiContext(artifactType=" + this.artifactType + ", artifactSource=" + this.artifactSource + ", originMessageId=" + this.originMessageId + ", uri=" + this.uri + ", view=" + this.view + ")";
    }

    public final String getArtifactSource() {
        return this.artifactSource;
    }

    public final String getArtifactType() {
        return this.artifactType;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final GuiView getView() {
        return this.view;
    }

    public GuiContext(String r100, String r101, String r102, String r103, GuiView r104) {
        this.artifactType = r100;
        this.artifactSource = r101;
        this.originMessageId = r102;
        this.uri = r103;
        this.view = r104;
    }

    public /* synthetic */ GuiContext(String r100, String r101, String r102, String r103, GuiView r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        GuiView r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
