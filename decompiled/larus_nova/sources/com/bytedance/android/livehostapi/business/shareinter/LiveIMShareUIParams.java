package com.bytedance.android.livehostapi.business.shareinter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareUIParams;", "", "()V", "avatarHeight", "", "avatarWidth", "dayNightMode", "enableElderlyMode", "", "textSizePixel", "getAvatarHeight", "getAvatarWidth", "getDayNightMode", "getEnableElderlyMode", "getTextSizePixel", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIMShareUIParams {
    private int avatarHeight;
    private int avatarWidth;
    private int dayNightMode;
    private boolean enableElderlyMode;
    private int textSizePixel;

    public LiveIMShareUIParams() {
        this.avatarWidth = -1;
        this.avatarHeight = -1;
        this.textSizePixel = -1;
        this.enableElderlyMode = true;
    }

    public final int getAvatarHeight() {
        return this.avatarHeight;
    }

    public final int getAvatarWidth() {
        return this.avatarWidth;
    }

    public final int getDayNightMode() {
        return this.dayNightMode;
    }

    public final boolean getEnableElderlyMode() {
        return this.enableElderlyMode;
    }

    public final int getTextSizePixel() {
        return this.textSizePixel;
    }
}
