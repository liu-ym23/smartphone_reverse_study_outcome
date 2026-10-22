package com.stepos.common.app;

import O6.r;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.common.R$drawable;
import com.stepos.common.util.HighContrastRegister;
import dalvik.system.DexFile;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private static final String SCAN_REGISTER_PACKAGE = "com.stepos.contrast";
    private static final String TAG = "HighContrast_Common";
    private static a sInstance;
    private Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.stepos.common.app.a$a, reason: collision with other inner class name */
    public class RunnableC0346a implements Runnable {
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            a.sInstance.g();
        }
    }

    public a(Application application) {
        this.mContext = application;
    }

    public static void c(Application application) {
        if (application != null && sInstance == null) {
            sInstance = new a(application);
            Log.i(TAG, "sInstance init success");
            new Thread(new RunnableC0346a()).start();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("init return application is null :");
            sb2.append(application == null);
            Log.i(TAG, sb2.toString());
        }
    }

    public void d(int i10) throws Resources.NotFoundException {
        this.mContext.getResources().getResourceName(i10);
    }

    public final void e() throws Resources.NotFoundException {
        d(R$drawable.stepos_fastscroller_color_blue);
        d(R$drawable.stepos_action_bar_tab_indicator_color_blue);
        d(R$drawable.stepos_guide_left_color_blue);
        d(R$drawable.stepos_guide_right_color_blue);
        d(R$drawable.stepos_guide_middle_down_color_blue);
        d(R$drawable.stepos_guide_middle_up_color_blue);
        d(R$drawable.stepos_btn_check_buttonless_on_normal_color_blue);
        d(R$drawable.stepos_btn_check_buttonless_on_disable_color_blue);
        d(R$drawable.stepos_checkbox_counter_color_blue);
        d(R$drawable.stepos_checkbox_counter_pressed_color_blue);
        d(R$drawable.stepos_edittext_new_selected_blue);
        d(R$drawable.stepos_input_select_handle_color_blue);
        d(R$drawable.stepos_progress_primary_color_blue);
        d(R$drawable.stepos_progressloading_success_color_blue);
        d(R$drawable.stepos_scrubber_primary_vertical_disable_color_blue);
        d(R$drawable.stepos_scrubber_primary_vertical_normal_color_blue);
        d(R$drawable.stepos_search_edittext_handle_left_color_blue);
        d(R$drawable.stepos_search_edittext_handle_right_color_blue);
        d(R$drawable.stepos_slider_btn_hover_color_blue);
        d(R$drawable.stepos_tab_selected_color_blue);
        d(R$drawable.stepos_text_cursor);
        d(R$drawable.stepos_text_select_handle_left_color_blue);
        d(R$drawable.stepos_text_select_handle_right_color_blue);
    }

    public final List<Class> f() throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> enumerationEntries = new DexFile(this.mContext.getPackageCodePath()).entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.contains(SCAN_REGISTER_PACKAGE)) {
                    Class<?> cls = Class.forName(strNextElement);
                    if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                        arrayList.add(cls);
                    }
                }
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    public final void g() throws Resources.NotFoundException {
        e();
        for (Class cls : f()) {
            try {
                r.a(cls).a(((HighContrastRegister) cls.getAnnotation(HighContrastRegister.class)).registerImpl(), new Class[0]).a(null, new Object[0]);
            } catch (Exception e10) {
                Log.e(TAG, "" + e10.getMessage());
            }
        }
    }
}
