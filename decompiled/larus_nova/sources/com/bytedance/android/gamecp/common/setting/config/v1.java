package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/v1;", "", "", "tipStyle", "I", "getTipStyle", "()I", "setTipStyle", "(I)V", "", "downloadLimit", FaceService.girlLabel, "d", "()F", "setDownloadLimit", "(F)V", "", "toastContent", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setToastContent", "(Ljava/lang/String;)V", "dialogContent", "c", "setDialogContent", "dialogBtn1Text", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDialogBtn1Text", "dialogBtn2Text", "b", "setDialogBtn2Text", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v1 {

    @SerializedName("game_promote_download_dialog_btn1_text")
    private String dialogBtn1Text;

    @SerializedName("game_promote_download_dialog_btn2_text")
    private String dialogBtn2Text;

    @SerializedName("game_promote_download_dialog_content")
    private String dialogContent;

    @SerializedName("game_promote_download_pkg_limit")
    private float downloadLimit;

    @SerializedName("game_promote_download_tips_style")
    private int tipStyle;

    @SerializedName("game_promote_download_toast_content")
    private String toastContent;

    public v1() {
        this.tipStyle = 4;
        this.downloadLimit = 1024.0f;
        this.toastContent = "当前为非Wi-Fi环境，请注意流量消耗";
        this.dialogContent = "游戏安装包大小为 %s MB，是否继续使用流量下载？";
        this.dialogBtn1Text = "稍后使用Wi-Fi网络";
        this.dialogBtn2Text = "下载";
    }

    public final String a() {
        return this.dialogBtn1Text;
    }

    public final String b() {
        return this.dialogBtn2Text;
    }

    public final String c() {
        return this.dialogContent;
    }

    public final float d() {
        return this.downloadLimit;
    }

    public final String e() {
        return this.toastContent;
    }
}
