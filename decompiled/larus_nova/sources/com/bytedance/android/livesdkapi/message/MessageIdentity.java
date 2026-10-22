package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/MessageIdentity;", "", "", "showIdentity", "I", "getShowIdentity", "()I", "setShowIdentity", "(I)V", "Lpy/k;", "identityLabel", "Lpy/k;", "getIdentityLabel", "()Lpy/k;", "setIdentityLabel", "(Lpy/k;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MessageIdentity implements h {

    @SerializedName("identity_label")
    protected k identityLabel;

    @SerializedName("show_identity")
    protected int showIdentity;

    public MessageIdentity() {
    }

    public final k getIdentityLabel() {
        return this.identityLabel;
    }

    public final int getShowIdentity() {
        return this.showIdentity;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public MessageIdentity(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.showIdentity = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.identityLabel = f.a(r100, k.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setIdentityLabel(k r100) {
        this.identityLabel = r100;
    }

    public final void setShowIdentity(int r100) {
        this.showIdentity = r100;
    }
}
