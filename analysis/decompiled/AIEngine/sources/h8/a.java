package h8;

import android.content.res.Resources;
import android.util.Log;
import com.stepos.aiengine.R;
import com.stepos.common.util.HighContrastRegister;
import dalvik.system.DexFile;
import java.util.ArrayList;
import java.util.Enumeration;
import l8.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException, ClassNotFoundException {
        b bVar = b.f9373b;
        bVar.a(R.drawable.stepos_fastscroller_color_blue);
        bVar.a(R.drawable.stepos_action_bar_tab_indicator_color_blue);
        bVar.a(R.drawable.stepos_guide_left_color_blue);
        bVar.a(R.drawable.stepos_guide_right_color_blue);
        bVar.a(R.drawable.stepos_guide_middle_down_color_blue);
        bVar.a(R.drawable.stepos_guide_middle_up_color_blue);
        bVar.a(R.drawable.stepos_btn_check_buttonless_on_normal_color_blue);
        bVar.a(R.drawable.stepos_btn_check_buttonless_on_disable_color_blue);
        bVar.a(R.drawable.stepos_checkbox_counter_color_blue);
        bVar.a(R.drawable.stepos_checkbox_counter_pressed_color_blue);
        bVar.a(R.drawable.stepos_edittext_new_selected_blue);
        bVar.a(R.drawable.stepos_input_select_handle_color_blue);
        bVar.a(R.drawable.stepos_progress_primary_color_blue);
        bVar.a(R.drawable.stepos_progressloading_success_color_blue);
        bVar.a(R.drawable.stepos_scrubber_primary_vertical_disable_color_blue);
        bVar.a(R.drawable.stepos_scrubber_primary_vertical_normal_color_blue);
        bVar.a(R.drawable.stepos_search_edittext_handle_left_color_blue);
        bVar.a(R.drawable.stepos_search_edittext_handle_right_color_blue);
        bVar.a(R.drawable.stepos_slider_btn_hover_color_blue);
        bVar.a(R.drawable.stepos_tab_selected_color_blue);
        bVar.a(R.drawable.stepos_text_cursor);
        bVar.a(R.drawable.stepos_text_select_handle_left_color_blue);
        bVar.a(R.drawable.stepos_text_select_handle_right_color_blue);
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> enumerationEntries = new DexFile(bVar.f9374a.getPackageCodePath()).entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.contains("com.stepos.contrast")) {
                    Class<?> cls = Class.forName(strNextElement);
                    if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                        arrayList.add(cls);
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Class cls2 = (Class) obj;
            try {
                String strRegisterImpl = ((HighContrastRegister) cls2.getAnnotation(HighContrastRegister.class)).registerImpl();
                e.a aVar = e.f10353a;
                aVar.getClass();
                aVar.a(cls2.getClassLoader(), cls2.getName()).a(strRegisterImpl, new Class[0]).a(null, new Object[0]);
            } catch (Exception e11) {
                Log.e("HighContrast_Common", "" + e11.getMessage());
            }
        }
    }
}
