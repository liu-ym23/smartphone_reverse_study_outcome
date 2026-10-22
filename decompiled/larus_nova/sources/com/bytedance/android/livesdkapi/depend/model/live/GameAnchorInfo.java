package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GameAnchorInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameAnchorInfo;", "", "()V", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "isKeyAnchor", "", "()Ljava/lang/Boolean;", "setKeyAnchor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "logCategoryId", "logIsKeyAnchor", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameAnchorInfo implements h {

    @SerializedName("category_id")
    protected String categoryId;

    @SerializedName("is_key_anchor")
    protected Boolean isKeyAnchor;

    public GameAnchorInfo() {
    }

    public GameAnchorInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.categoryId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.isKeyAnchor = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final String logCategoryId() {
        String r100 = this.categoryId;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String logIsKeyAnchor() {
        Boolean r100 = this.isKeyAnchor;
        if (r100 != null) goto L5;
        return "-1";
    L5:
        if (r100.booleanValue() == false) goto L7;
        return "1";
    L7:
        return "0";
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Boolean isKeyAnchor() {
        return this.isKeyAnchor;
    }

    public final void setCategoryId(String r100) {
        this.categoryId = r100;
    }

    public final void setKeyAnchor(Boolean r100) {
        this.isKeyAnchor = r100;
    }
}
