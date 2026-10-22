package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/AddDressPrompt;", "", "()V", "addDressVersion", "", "Ljava/lang/Long;", "hasAddDress", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AddDressPrompt implements h {

    @SerializedName("add_dress_version")
    public Long addDressVersion;

    @SerializedName("has_add_dress")
    public boolean hasAddDress;

    public AddDressPrompt() {
        this.addDressVersion = 0L;
    }

    public AddDressPrompt(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.hasAddDress = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.addDressVersion = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.addDressVersion != null) goto L25;
        this.addDressVersion = 0L;
        return;
    }
}
