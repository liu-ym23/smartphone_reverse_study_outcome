package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.AddDressPrompt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AddKTVDressContent;", "", "()V", "addDressPrompt", "Lcom/bytedance/android/livesdkapi/depend/message/AddDressPrompt;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AddKTVDressContent implements vh7.h {

    @SerializedName("add_dress_prompt")
    public AddDressPrompt addDressPrompt;

    public AddKTVDressContent() {
    }

    public AddKTVDressContent(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.addDressPrompt = new AddDressPrompt(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
