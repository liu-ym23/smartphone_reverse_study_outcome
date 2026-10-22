package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.FilterWord")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/FilterWordToutiao;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isSelected", "", "()Z", "setSelected", "(Z)V", "name", "getName", "setName", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterWordToutiao implements h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected String f162582id;

    @SerializedName("is_selected")
    protected boolean isSelected;

    @SerializedName("name")
    protected String name;

    public FilterWordToutiao() {
    }

    public FilterWordToutiao(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.f162582id = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isSelected = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.name = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getId() {
        return this.f162582id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setId(String r100) {
        this.f162582id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSelected(boolean r100) {
        this.isSelected = r100;
    }
}
