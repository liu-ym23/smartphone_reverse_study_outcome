package com.bytedance.ai.model.objects;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/model/objects/AppletChatFeatures;", "", "camera", "Lcom/bytedance/ai/model/objects/AppletChatFeature;", "extraActions", "<init>", "(Lcom/bytedance/ai/model/objects/AppletChatFeature;Lcom/bytedance/ai/model/objects/AppletChatFeature;)V", "getCamera", "()Lcom/bytedance/ai/model/objects/AppletChatFeature;", "getExtraActions", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletChatFeatures {
    private final AppletChatFeature camera;
    private final AppletChatFeature extraActions;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletChatFeatures() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppletChatFeatures copy$default(AppletChatFeatures r100, AppletChatFeature r101, AppletChatFeature r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.camera;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extraActions;
    L9:
        return r100.copy(r101, r102);
    }

    public final AppletChatFeature component1() {
        return this.camera;
    }

    public final AppletChatFeature component2() {
        return this.extraActions;
    }

    public final AppletChatFeatures copy(AppletChatFeature r100, AppletChatFeature r101) {
        return new AppletChatFeatures(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppletChatFeatures) == true) goto L8;
        return false;
    L8:
        AppletChatFeatures r101 = (AppletChatFeatures) r100;
        if (Intrinsics.areEqual(this.camera, r101.camera) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraActions, r101.extraActions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AppletChatFeature r100 = this.camera;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AppletChatFeature r104 = this.extraActions;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AppletChatFeatures(camera=" + this.camera + ", extraActions=" + this.extraActions + ')';
    }

    public final AppletChatFeature getCamera() {
        return this.camera;
    }

    public final AppletChatFeature getExtraActions() {
        return this.extraActions;
    }

    public AppletChatFeatures(AppletChatFeature r100, AppletChatFeature r101) {
        this.camera = r100;
        this.extraActions = r101;
    }

    public /* synthetic */ AppletChatFeatures(AppletChatFeature r100, AppletChatFeature r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
