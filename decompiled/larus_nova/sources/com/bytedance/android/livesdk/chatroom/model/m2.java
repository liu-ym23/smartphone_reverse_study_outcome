package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/m2;", "", "", "titleDesc", "Ljava/lang/String;", "getTitleDesc", "()Ljava/lang/String;", "setTitleDesc", "(Ljava/lang/String;)V", "contentCountDesc", "getContentCountDesc", "setContentCountDesc", "animationDesc", "getAnimationDesc", "setAnimationDesc", "contentAmountDesc", "getContentAmountDesc", "setContentAmountDesc", "beforeUnpackDesc", "getBeforeUnpackDesc", "setBeforeUnpackDesc", "successUnpackDesc", "getSuccessUnpackDesc", "setSuccessUnpackDesc", "failUnpackDesc", "getFailUnpackDesc", "setFailUnpackDesc", "Lpy/k;", AdBaseConstants.DownloadAdRuntimeDependKey.AD_RUNTIME_ABILITY_IMAGE, "Lpy/k;", "getAdImage", "()Lpy/k;", "setAdImage", "(Lpy/k;)V", "imDesc", "getImDesc", "setImDesc", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m2 implements vh7.h {

    @SerializedName("ad_image")
    protected py.k adImage;

    @SerializedName("animation_desc")
    protected String animationDesc;

    @SerializedName("before_unpack_desc")
    protected String beforeUnpackDesc;

    @SerializedName("content_amount_desc")
    protected String contentAmountDesc;

    @SerializedName("content_count_desc")
    protected String contentCountDesc;

    @SerializedName("fail_unpack_desc")
    protected String failUnpackDesc;

    @SerializedName("im_desc")
    protected String imDesc;

    @SerializedName("success_unpack_desc")
    protected String successUnpackDesc;

    @SerializedName("title_desc")
    protected String titleDesc;

    public m2() {
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public m2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.imDesc = am3.h.c(r100);
        goto L3
    L8:
        this.adImage = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        this.failUnpackDesc = am3.h.c(r100);
        goto L3
    L10:
        this.successUnpackDesc = am3.h.c(r100);
        goto L3
    L11:
        this.beforeUnpackDesc = am3.h.c(r100);
        goto L3
    L12:
        this.animationDesc = am3.h.c(r100);
        goto L3
    L13:
        this.contentAmountDesc = am3.h.c(r100);
        goto L3
    L14:
        this.contentCountDesc = am3.h.c(r100);
        goto L3
    L15:
        this.titleDesc = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }
}
