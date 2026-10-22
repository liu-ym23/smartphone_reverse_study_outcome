package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea;", "", "()V", "additionalButton", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea$AdditionalButton;", "payButton", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea$PayButton;", "AdditionalButton", "PayButton", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaymentArea implements h {

    @SerializedName("additional_button")
    public AdditionalButton additionalButton;

    @SerializedName("pay_button")
    public PayButton payButton;

    @ForMain
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea$AdditionalButton;", "", "", "content", "Ljava/lang/String;", "Lpy/k;", "icon", "Lpy/k;", "jumpSchema", "", "avilable", "I", "copyWriting", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AdditionalButton implements h {

        @SerializedName("avilable")
        public int avilable;

        @SerializedName("content")
        public String content;

        @SerializedName("copy_writing")
        public String copyWriting;

        @SerializedName("icon")
        public k icon;

        @SerializedName("jump_schema")
        public String jumpSchema;

        public AdditionalButton() {
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
        public AdditionalButton(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.content = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.icon = f.a(r100, k.class);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.jumpSchema = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.avilable = r100.i();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.copyWriting = am3.h.c(r100);
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea$PayButton;", "", "", "content", "Ljava/lang/String;", "Lpy/k;", "icon", "Lpy/k;", "jumpSchema", "", "avilable", "I", "copyWriting", "clickType", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PayButton implements h {

        @SerializedName("avilable")
        public int avilable;

        @SerializedName("click_type")
        public int clickType;

        @SerializedName("content")
        public String content;

        @SerializedName("copy_writing")
        public String copyWriting;

        @SerializedName("icon")
        public k icon;

        @SerializedName("jump_schema")
        public String jumpSchema;

        public PayButton() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public PayButton(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.clickType = r100.i();
            goto L3
        L8:
            this.copyWriting = am3.h.c(r100);
            goto L3
        L9:
            this.avilable = r100.i();
            goto L3
        L10:
            this.jumpSchema = am3.h.c(r100);
            goto L3
        L11:
            this.icon = f.a(r100, k.class);
            goto L3
        L12:
            this.content = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }
    }

    public PaymentArea() {
    }

    public PaymentArea(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.payButton = new PayButton(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.additionalButton = new AdditionalButton(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
