package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/f0;", "", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f0 implements vh7.h {

    @SerializedName("cancel_button_text")
    protected String _$$cancelText;

    @SerializedName("confirm_button_text")
    protected String _$$confirmText;

    @SerializedName("confirm_type")
    protected long _$$confirmType;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("title")
    protected String _$$title;

    public f0() {
        this._$$title = "";
        this._$$text = "";
        this._$$cancelText = "";
        this._$$confirmText = "";
        this._$$confirmType = 0;
    }

    public final String a() {
        return this._$$cancelText;
    }

    public final String b() {
        return this._$$confirmText;
    }

    public final long c() {
        return this._$$confirmType;
    }

    public final String d() {
        return this._$$text;
    }

    public final String e() {
        return this._$$title;
    }

    public f0(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this._$$title = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$text = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this._$$cancelText = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this._$$confirmText = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this._$$confirmType = r100.i();
        r102 = r102 | true;
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this._$$title != null) goto L24;
        this._$$title = "";
    L24:
        if (this._$$text != null) goto L27;
        this._$$text = "";
    L27:
        if (this._$$cancelText != null) goto L30;
        this._$$cancelText = "";
    L30:
        if (this._$$confirmText != null) goto L33;
        this._$$confirmText = "";
    L33:
        if ((r102 & true) == true) goto L54;
        this._$$confirmType = 0;
        return;
    }
}
