package com.bytedance.android.livesdkapi.depend.live.gift;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/gift/SuperResolutionModel;", "", "videoWidth", "", "videoHeight", "openSR", "", "effectId", "", "videoAssetType", "(IIZJI)V", "getEffectId", "()J", "getOpenSR", "()Z", "resultCode", "getResultCode", "()I", "setResultCode", "(I)V", "getVideoAssetType", "getVideoHeight", "getVideoWidth", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SuperResolutionModel {
    private final long effectId;
    private final boolean openSR;
    private int resultCode;
    private final int videoAssetType;
    private final int videoHeight;
    private final int videoWidth;

    public final long getEffectId() {
        return this.effectId;
    }

    public final boolean getOpenSR() {
        return this.openSR;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final int getVideoAssetType() {
        return this.videoAssetType;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setResultCode(int r100) {
        this.resultCode = r100;
    }

    public SuperResolutionModel(int r100, int r101, boolean r102, long r103, int r104) {
        this.videoWidth = r100;
        this.videoHeight = r101;
        this.openSR = r102;
        this.effectId = r103;
        this.videoAssetType = r104;
    }

    public /* synthetic */ SuperResolutionModel(int r100, int r101, boolean r110, long r111, int r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        boolean r102 = false;
    L6:
        this(r100, r101, r102, r111, r112);
        return;
    L5:
        r102 = r110;
        goto L6
    }
}
