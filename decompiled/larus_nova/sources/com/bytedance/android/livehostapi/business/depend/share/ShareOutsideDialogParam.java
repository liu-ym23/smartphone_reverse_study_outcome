package com.bytedance.android.livehostapi.business.depend.share;

import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/ShareOutsideDialogParam;", "", "Lpy/k;", "shareCardIcon", "Lpy/k;", "getShareCardIcon", "()Lpy/k;", "setShareCardIcon", "(Lpy/k;)V", "", "shareCardTitle", "Ljava/lang/String;", "getShareCardTitle", "()Ljava/lang/String;", "setShareCardTitle", "(Ljava/lang/String;)V", "posterShareBackground", "getPosterShareBackground", "setPosterShareBackground", "toastBackground", "getToastBackground", "setToastBackground", "<init>", "()V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareOutsideDialogParam {
    private k posterShareBackground;
    private k shareCardIcon;
    private String shareCardTitle;
    private k toastBackground;

    public ShareOutsideDialogParam() {
    }

    public final k getPosterShareBackground() {
        return this.posterShareBackground;
    }

    public final k getShareCardIcon() {
        return this.shareCardIcon;
    }

    public final String getShareCardTitle() {
        return this.shareCardTitle;
    }

    public final k getToastBackground() {
        return this.toastBackground;
    }

    public final void setPosterShareBackground(k r100) {
        this.posterShareBackground = r100;
    }

    public final void setShareCardIcon(k r100) {
        this.shareCardIcon = r100;
    }

    public final void setShareCardTitle(String r100) {
        this.shareCardTitle = r100;
    }

    public final void setToastBackground(k r100) {
        this.toastBackground = r100;
    }
}
