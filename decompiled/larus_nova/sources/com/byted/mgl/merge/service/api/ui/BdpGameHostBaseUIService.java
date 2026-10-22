package com.byted.mgl.merge.service.api.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpDatePickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpMultiPickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpNormalPickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.listener.BdpTimePickerCallback;
import com.bytedance.bdp.serviceapi.defaults.ui.model.a;
import com.bytedance.bdp.serviceapi.defaults.ui.model.e;
import com.bytedance.bdp.serviceapi.defaults.ui.model.f;
import com.bytedance.bdp.serviceapi.defaults.ui.model.g;
import ib4.b;
import ib4.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpGameHostBaseUIService extends IBdpService {
    public static final String DATE_PICKER_TYPE_DAY = "day";
    public static final String DATE_PICKER_TYPE_MONTH = "month";
    public static final String DATE_PICKER_TYPE_YEAR = "year";

    /* JADX INFO: loaded from: classes43.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
        public static final int ANIMATION_TYPE_EXIT = 2;
        public static final int ANIMATION_TYPE_FLOAT_STYLE_EXIT = 4;
        public static final int ANIMATION_TYPE_FLOAT_STYLE_IN = 3;
        public static final int ANIMATION_TYPE_IN = 1;
    }

    /* JADX INFO: loaded from: classes43.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DatePickerType {
    }

    b createMultiPicker(Activity r100);

    c createToastView(Context r100);

    String enableAlertBeforeUnload(String r100, String r101, String r102);

    Dialog getBottomMenuDialog(Activity r100, a r101);

    com.bytedance.bdp.serviceapi.defaults.ui.model.b getHostCustomUiConfig();

    Dialog getLoadingDialog(Activity r100, String r101);

    ib4.a getLoadingView(Context r100);

    boolean isPickerShowing();

    void overridePendingTransition(Activity r100, int r101, int r102, int r103, String r104);

    void showActionSheet(Activity r100, String r101, String[] r102, hb4.a r103);

    void showActionSheet(Activity r100, String r101, String[] r102, String r103, String r104, hb4.a r105);

    void showDatePickerView(Activity r100, com.bytedance.bdp.serviceapi.defaults.ui.model.c r101, g r102, BdpDatePickerCallback<String> r103);

    void showModal(Activity r100, e r101, hb4.b r102);

    void showMultiPickerView(Activity r100, String r101, List<List<String>> r102, int[] r103, g r104, BdpMultiPickerCallback r105);

    void showPickerView(Activity r100, String r101, int r102, List<String> r103, g r104, BdpNormalPickerCallback<String> r105);

    void showTimePickerView(Activity r100, f r101, g r102, BdpTimePickerCallback<String> r103);

    boolean updateMultiPickerView(int r100, List r101, int r102);
}
