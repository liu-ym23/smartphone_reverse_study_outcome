package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayLoadingConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "loading_time_out", "", "is_ecommerce_douyin_loading_auto_close", "", "loading_manual_close_time_out", "(IZI)V", "brand_loading_config", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPayLoadingConfig$CJPayBrandLoadingObject;", "CJPayBrandLoadingObject", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLoadingConfig implements CJPayObject, Serializable {
    public CJPayBrandLoadingObject brand_loading_config;
    public boolean is_ecommerce_douyin_loading_auto_close;
    public int loading_manual_close_time_out;
    public int loading_time_out;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayLoadingConfig$CJPayBrandLoadingObject;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "dialog_lottie_url", "", "panel_lottie_dark_url", "panel_lottie_url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayBrandLoadingObject implements CJPayObject, Serializable {
        public String dialog_lottie_url;
        public String panel_lottie_dark_url;
        public String panel_lottie_url;

        public CJPayBrandLoadingObject() {
            this.dialog_lottie_url = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_pay_dialog_loading.json";
            this.panel_lottie_url = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_pay_panel_loading.json";
            this.panel_lottie_dark_url = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_pay_panel_loading_dark.json";
        }
    }

    public CJPayLoadingConfig() {
        this(0, false, 0, 7, null);
    }

    public CJPayLoadingConfig(int r100, boolean r101, int r102) {
        this.loading_time_out = r100;
        this.is_ecommerce_douyin_loading_auto_close = r101;
        this.loading_manual_close_time_out = r102;
        this.brand_loading_config = new CJPayBrandLoadingObject();
    }

    public /* synthetic */ CJPayLoadingConfig(int r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 15;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 60;
    L11:
        this(r100, r101, r102);
    }
}
