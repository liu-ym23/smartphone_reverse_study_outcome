package com.bytedance.android.livesdkapi.depend.model.live.vs;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessScreenBarConfigure;", "", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "barType", "I", "getBarType", "()I", "setBarType", "(I)V", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "jumpPrompt", "getJumpPrompt", "setJumpPrompt", "<init>", "()V", "BarType", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BusinessScreenBarConfigure implements h {

    @SerializedName("IsDynamicImg")
    protected int barType;

    @SerializedName("Image")
    protected k image;

    @SerializedName("jump_prompt")
    protected String jumpPrompt;

    @SerializedName("schema")
    protected String schema;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessScreenBarConfigure$BarType;", "", "()V", "ANIMATION", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BarType {
        public static final int ANIMATION = 2;
        public static final BarType INSTANCE = null;

        private BarType() {
        }

        static {
            INSTANCE = new BarType();
        }
    }

    public BusinessScreenBarConfigure() {
        this.schema = "";
        this.jumpPrompt = "";
    }

    public final int getBarType() {
        return this.barType;
    }

    public final k getImage() {
        return this.image;
    }

    public final String getJumpPrompt() {
        return this.jumpPrompt;
    }

    public final String getSchema() {
        return this.schema;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public BusinessScreenBarConfigure(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.image = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.barType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.schema = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.jumpPrompt = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.schema != null) goto L22;
        this.schema = "";
    L22:
        if (this.jumpPrompt != null) goto L40;
        this.jumpPrompt = "";
        return;
    }

    public final void setBarType(int r100) {
        this.barType = r100;
    }

    public final void setImage(k r100) {
        this.image = r100;
    }

    public final void setJumpPrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jumpPrompt = r100;
    }

    public final void setSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema = r100;
    }
}
