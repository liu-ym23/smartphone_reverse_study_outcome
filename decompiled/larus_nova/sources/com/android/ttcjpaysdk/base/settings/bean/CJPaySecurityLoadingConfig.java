package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bdpay.security.loading.data.CJPaySecurityLoadingConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "experiment", "Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig$CJPaySecurityLoadingExperiment;", "CJPaySecurityLoadingExperiment", "CJPaySecurityLoadingExperimentObject", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySecurityLoadingConfig implements CJPayObject, Serializable {
    public CJPaySecurityLoadingExperiment experiment;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig$CJPaySecurityLoadingExperiment;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", CJPaySecurityLoadingConstant.CJ_PAY_SECURITY_LOADING_BREATHE_STYLE, "Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig$CJPaySecurityLoadingExperimentObject;", "getDarkModeBreathe", "isDarkMode", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPaySecurityLoadingExperiment implements CJPayObject, Serializable {
        public CJPaySecurityLoadingExperimentObject breathe;

        public CJPaySecurityLoadingExperiment() {
            this.breathe = new CJPaySecurityLoadingExperimentObject();
        }

        public final CJPaySecurityLoadingExperimentObject getDarkModeBreathe(boolean r100) {
            if (r100 == false) goto L5;
            CJPaySecurityLoadingExperimentObject r101 = this.breathe;
            r101.panel_repeat_gif = r101.panel_repeat_gif_dark;
            return r101;
        L5:
            return this.breathe;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPaySecurityLoadingConfig$CJPaySecurityLoadingExperimentObject;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "dialog_repeat_gif", "", "dialog_repeat_gif_dark", "dialog_repeat_round_gif", "panel_repeat_gif", "panel_repeat_gif_dark", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPaySecurityLoadingExperimentObject implements CJPayObject, Serializable {
        public String dialog_repeat_gif;
        public String dialog_repeat_gif_dark;
        public String dialog_repeat_round_gif;
        public String panel_repeat_gif;
        public String panel_repeat_gif_dark;

        public CJPaySecurityLoadingExperimentObject() {
            this.dialog_repeat_gif = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_breathe_dialog_repeat.gif";
            this.dialog_repeat_round_gif = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_breathe_dialog_round.gif";
            this.panel_repeat_gif = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_breathe_panel_repeat.gif";
            this.panel_repeat_gif_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_breathe_panel_repeat_dark.gif";
            this.dialog_repeat_gif_dark = "https://lf3-static.bytednsdoc.com/obj/eden-cn/zly_zvp_fhwqj/ljhwZthlaukjlkulzlp/android/cj_breathe_dialog_repeat_dark.gif";
        }
    }

    public CJPaySecurityLoadingConfig() {
        this.experiment = new CJPaySecurityLoadingExperiment();
    }
}
