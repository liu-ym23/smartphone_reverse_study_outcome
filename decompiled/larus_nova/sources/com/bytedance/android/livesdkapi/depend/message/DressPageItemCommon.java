package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/DressPageItemCommon;", "", "()V", "dressId", "", "expireText", "isSelected", "", "isUnlocked", "schema", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DressPageItemCommon implements h {

    @SerializedName("dress_id")
    public String dressId;

    @SerializedName("expire_text")
    public String expireText;

    @SerializedName("is_selected")
    public boolean isSelected;

    @SerializedName("is_unlocked")
    public boolean isUnlocked;

    @SerializedName("schema")
    public String schema;

    public DressPageItemCommon() {
    }

    public DressPageItemCommon(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.dressId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.expireText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.isSelected = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.isUnlocked = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.schema = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
