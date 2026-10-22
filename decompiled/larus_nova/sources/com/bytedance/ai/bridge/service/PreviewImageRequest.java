package com.bytedance.ai.bridge.service;

import e3.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/service/PreviewImageRequest;", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "bridgeName", "", "urls", "", "current", "showmenu", "", "<init>", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "getBridgeContext", "()Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "getBridgeName", "()Ljava/lang/String;", "getUrls", "()Ljava/util/List;", "getCurrent", "getShowmenu", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewImageRequest {
    private final d bridgeContext;
    private final String bridgeName;
    private final String current;
    private final boolean showmenu;
    private final List<String> urls;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreviewImageRequest copy$default(PreviewImageRequest r100, d r101, String r102, List r103, String r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bridgeContext;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.bridgeName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.urls;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.current;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.showmenu;
    L17:
        d r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final d component1() {
        return this.bridgeContext;
    }

    public final String component2() {
        return this.bridgeName;
    }

    public final List<String> component3() {
        return this.urls;
    }

    public final String component4() {
        return this.current;
    }

    public final boolean component5() {
        return this.showmenu;
    }

    public final PreviewImageRequest copy(d r100, String r101, List<String> r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r110, "urls");
        return new PreviewImageRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewImageRequest) == true) goto L8;
        return false;
    L8:
        PreviewImageRequest r101 = (PreviewImageRequest) r100;
        if (Intrinsics.areEqual(this.bridgeContext, r101.bridgeContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bridgeName, r101.bridgeName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urls, r101.urls) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.current, r101.current) == true) goto L21;
        return false;
    L21:
        if (this.showmenu == r101.showmenu) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.bridgeContext.hashCode() * 31) + this.bridgeName.hashCode()) * 31) + this.urls.hashCode()) * 31;
        String r101 = this.current;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showmenu == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PreviewImageRequest(bridgeContext=" + this.bridgeContext + ", bridgeName=" + this.bridgeName + ", urls=" + this.urls + ", current=" + this.current + ", showmenu=" + this.showmenu + ')';
    }

    public final d getBridgeContext() {
        return this.bridgeContext;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final String getCurrent() {
        return this.current;
    }

    public final boolean getShowmenu() {
        return this.showmenu;
    }

    public final List<String> getUrls() {
        return this.urls;
    }

    public PreviewImageRequest(d r100, String r101, List<String> r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r102, "urls");
        this.bridgeContext = r100;
        this.bridgeName = r101;
        this.urls = r102;
        this.current = r103;
        this.showmenu = r104;
    }
}
