package a4;

import android.app.Application;
import android.content.res.Resources;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.util.HighContrastRegister;
import dalvik.system.DexFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f191c;

    public /* synthetic */ o(int i) {
        this.f191c = i;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DisplayMetrics displayMetrics;
        int i = 0;
        switch (this.f191c) {
            case 0:
                try {
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (j.c()) {
                        j.a().d();
                    }
                    return;
                } finally {
                    Trace.endSection();
                }
            case 1:
                Resources system = Resources.getSystem();
                float f5 = Resources.getSystem().getDisplayMetrics().xdpi;
                system.getDisplayMetrics().xdpi = f5;
                p5.f.x().getResources().getDisplayMetrics().xdpi = f5;
                ArrayList arrayList = id.k.f5964b;
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        try {
                            DisplayMetrics displayMetrics2 = (DisplayMetrics) ((Field) obj).get(system);
                            if (displayMetrics2 != null) {
                                displayMetrics2.xdpi = f5;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    return;
                }
                id.k.f5964b = new ArrayList();
                Class<?> superclass = system.getClass();
                Field[] declaredFields = superclass.getDeclaredFields();
                while (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                            field.setAccessible(true);
                            try {
                                displayMetrics = (DisplayMetrics) field.get(system);
                            } catch (Exception unused) {
                                displayMetrics = null;
                            }
                            if (displayMetrics != null) {
                                id.k.f5964b.add(field);
                                displayMetrics.xdpi = f5;
                            }
                        }
                    }
                    superclass = superclass.getSuperclass();
                    if (superclass == null) {
                        return;
                    } else {
                        declaredFields = superclass.getDeclaredFields();
                    }
                }
                return;
            case 2:
                return;
            default:
                a1.g gVar = a1.g.f17g;
                gVar.x(R.drawable.stepos_fastscroller_color_blue);
                gVar.x(R.drawable.stepos_action_bar_tab_indicator_color_blue);
                gVar.x(R.drawable.stepos_guide_left_color_blue);
                gVar.x(R.drawable.stepos_guide_right_color_blue);
                gVar.x(R.drawable.stepos_guide_middle_down_color_blue);
                gVar.x(R.drawable.stepos_guide_middle_up_color_blue);
                gVar.x(R.drawable.stepos_btn_check_buttonless_on_normal_color_blue);
                gVar.x(R.drawable.stepos_btn_check_buttonless_on_disable_color_blue);
                gVar.x(R.drawable.stepos_checkbox_counter_color_blue);
                gVar.x(R.drawable.stepos_checkbox_counter_pressed_color_blue);
                gVar.x(R.drawable.stepos_edittext_new_selected_blue);
                gVar.x(R.drawable.stepos_input_select_handle_color_blue);
                gVar.x(R.drawable.stepos_progress_primary_color_blue);
                gVar.x(R.drawable.stepos_progressloading_success_color_blue);
                gVar.x(R.drawable.stepos_scrubber_primary_vertical_disable_color_blue);
                gVar.x(R.drawable.stepos_scrubber_primary_vertical_normal_color_blue);
                gVar.x(R.drawable.stepos_search_edittext_handle_left_color_blue);
                gVar.x(R.drawable.stepos_search_edittext_handle_right_color_blue);
                gVar.x(R.drawable.stepos_slider_btn_hover_color_blue);
                gVar.x(R.drawable.stepos_tab_selected_color_blue);
                gVar.x(R.drawable.stepos_text_cursor);
                gVar.x(R.drawable.stepos_text_select_handle_left_color_blue);
                gVar.x(R.drawable.stepos_text_select_handle_right_color_blue);
                ArrayList arrayList2 = new ArrayList();
                try {
                    Enumeration<String> enumerationEntries = new DexFile(((Application) gVar.f19f).getPackageCodePath()).entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String strNextElement = enumerationEntries.nextElement();
                        if (strNextElement.contains("com.stepos.contrast")) {
                            Class<?> cls = Class.forName(strNextElement);
                            if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                                arrayList2.add(cls);
                            }
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    Class cls2 = (Class) obj2;
                    try {
                        String strRegisterImpl = ((HighContrastRegister) cls2.getAnnotation(HighContrastRegister.class)).registerImpl();
                        u9.d dVar = u9.g.f14265a;
                        dVar.getClass();
                        dVar.a(cls2.getClassLoader(), cls2.getName()).a(strRegisterImpl, new Class[0]).f14264a.invoke(null, null);
                    } catch (Exception e12) {
                        Log.e("HighContrast_Common", "" + e12.getMessage());
                    }
                }
                return;
        }
    }

    private final void a() {
    }
}
