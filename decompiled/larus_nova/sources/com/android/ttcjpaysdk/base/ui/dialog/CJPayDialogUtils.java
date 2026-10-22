package com.android.ttcjpaysdk.base.ui.dialog;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayDialogUtils {
    public CJPayDialogUtils() {
    }

    public static CJPayDialogBuilder getDefaultBuilder(Activity r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        CJPayDialogBuilder r101 = new CJPayDialogBuilder();
        r101.setLeftBtnStr("").setLeftBtnColor(ContextCompat.getColor(r100, R.color.cj_pay_color_new_blue)).setLeftBtnBold(false).setLeftBtnListener(null).setRightBtnStr("").setRightBtnColor(ContextCompat.getColor(r100, R.color.cj_pay_color_new_blue)).setRightBtnBold(false).setRightBtnListener(null).setSingleBtnStr("").setSingleBtnColor(ContextCompat.getColor(r100, R.color.cj_pay_color_new_blue)).setSingleBtnBold(false).setSingleBtnListener(null).setWidth(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME).setHeight(0).setThemeResId(R.style.CJ_Pay_Dialog_With_Layer).setTitle("").setSubTitle("").setSubtitleColor(-1).setContent("").setContentColor(-1).setActivity(r100).setTitleBold(false);
        return r101;
    }

    private static View getDyDialogContentView(Activity r100) {
        if ("en".equals(CJPayHostInfo.languageTypeStr) == false) goto L5;
        int r101 = R.layout.cj_pay_view_dy_standard_en_dialog_layout;
    L7:
        if (CJPaySettingsManager.getInstance().isDegradeDialogStyle() == true) goto L18;
    L14:
        th = move-exception;
        CJReporter r102 = CJReporter.f202294a;
        CJReporter.m(CJPayCallBackCenter.getInstance().getCjContext(), "context_theme_wrapper_exception", 1, th);
        return LayoutInflater.from(r100).inflate(r101, null);
    L9:
        if (CJPayThemeManager.getInstance().isThemeDark(r100) == false) goto L11;
        ContextThemeWrapper r103 = new ContextThemeWrapper(r100.getApplication(), R.style.CJ_Pay_Theme_Apply_Dark);     // Catch: Throwable -> L14
    L12:
        return LayoutInflater.from(r103).inflate(r101, null);
    L11:
        r103 = new ContextThemeWrapper(r100.getApplication(), R.style.CJ_Pay_Theme_Apply_Light);     // Catch: Throwable -> L14
        goto L12
    L18:
        return LayoutInflater.from(r100).inflate(r101, null);
    L5:
        r101 = R.layout.cj_pay_view_dy_standard_dialog_layout;
        goto L7
    }

    public static CJPayCommonDialog.DialogBuilder getDyStandardBuilder(Activity r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        CJPayCommonDialog.DialogBuilder r100 = new CJPayCommonDialog.DialogBuilder(r110);
        r100.setLeftText("").setLeftColor(CJPayThemeUtils.getColor(r110, R.attr.cj_pay_text_secondary, R.color.cj_pay_color_gray_161823_opacity_75)).setLeftIsBold(false).setLeftListener(null).setRightText("").setRightColor(CJPayThemeUtils.getColor(r110, R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823)).setRightIsBold(true).setRightListener(null).setSingleText("").setSingleColor(CJPayThemeUtils.getColor(r110, R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823)).setSingleIsBold(true).setSingleListener(null).setContentView(getDyDialogContentView(r110)).setDialogWidth(280).setTitle("").setTitleColor(CJPayThemeUtils.getColor(r110, R.attr.cj_pay_text_primary, R.color.cj_pay_color_black_161823)).setContent("").setContentColor(CJPayThemeUtils.getColor(r110, R.attr.cj_pay_text_secondary, R.color.cj_pay_color_gray_161823_opacity_75)).setTitleIsBold(true).setContentIsBold(false);
        return r100;
    }

    public static CJPayCommonDialog initDialog(CJPayCommonDialog.Builder r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.build();
    }

    public static CJPayCommonDialog initDialog(CJPayDialogBuilder r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.build();
    }
}
