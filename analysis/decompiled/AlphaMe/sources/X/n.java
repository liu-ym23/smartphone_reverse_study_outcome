package X;

import Z2.I;
import android.content.Context;
import android.content.res.Resources;
import android.os.Trace;
import android.util.Log;
import com.stepos.alphame.R;
import com.stepos.common.util.HighContrastRegister;
import dalvik.system.DexFile;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2072a;

    public /* synthetic */ n(int i4) {
        this.f2072a = i4;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        switch (this.f2072a) {
            case 0:
                try {
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (j.f2054k != null) {
                        j.a().c();
                    }
                    return;
                } finally {
                    Trace.endSection();
                }
            case 1:
                B0.e eVar = B0.e.f140d;
                eVar.k(R.drawable.stepos_fastscroller_color_blue);
                eVar.k(R.drawable.stepos_action_bar_tab_indicator_color_blue);
                eVar.k(R.drawable.stepos_guide_left_color_blue);
                eVar.k(R.drawable.stepos_guide_right_color_blue);
                eVar.k(R.drawable.stepos_guide_middle_down_color_blue);
                eVar.k(R.drawable.stepos_guide_middle_up_color_blue);
                eVar.k(R.drawable.stepos_btn_check_buttonless_on_normal_color_blue);
                eVar.k(R.drawable.stepos_btn_check_buttonless_on_disable_color_blue);
                eVar.k(R.drawable.stepos_checkbox_counter_color_blue);
                eVar.k(R.drawable.stepos_checkbox_counter_pressed_color_blue);
                eVar.k(R.drawable.stepos_edittext_new_selected_blue);
                eVar.k(R.drawable.stepos_input_select_handle_color_blue);
                eVar.k(R.drawable.stepos_progress_primary_color_blue);
                eVar.k(R.drawable.stepos_progressloading_success_color_blue);
                eVar.k(R.drawable.stepos_scrubber_primary_vertical_disable_color_blue);
                eVar.k(R.drawable.stepos_scrubber_primary_vertical_normal_color_blue);
                eVar.k(R.drawable.stepos_search_edittext_handle_left_color_blue);
                eVar.k(R.drawable.stepos_search_edittext_handle_right_color_blue);
                eVar.k(R.drawable.stepos_slider_btn_hover_color_blue);
                eVar.k(R.drawable.stepos_tab_selected_color_blue);
                eVar.k(R.drawable.stepos_text_cursor);
                eVar.k(R.drawable.stepos_text_select_handle_left_color_blue);
                eVar.k(R.drawable.stepos_text_select_handle_right_color_blue);
                ArrayList arrayList = new ArrayList();
                try {
                    Enumeration<String> enumerationEntries = new DexFile(((Context) eVar.f143c).getPackageCodePath()).entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String strNextElement = enumerationEntries.nextElement();
                        if (strNextElement.contains("com.stepos.contrast")) {
                            Class<?> cls = Class.forName(strNextElement);
                            if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                                arrayList.add(cls);
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Class cls2 = (Class) it.next();
                    try {
                        String strRegisterImpl = ((HighContrastRegister) cls2.getAnnotation(HighContrastRegister.class)).registerImpl();
                        androidx.room.z zVar = m2.i.f13574a;
                        zVar.getClass();
                        zVar.c(cls2.getClassLoader(), cls2.getName()).b(strRegisterImpl, new Class[0]).f13573a.invoke(null, new Object[0]);
                    } catch (Exception e5) {
                        Log.e("HighContrast_Common", "" + e5.getMessage());
                    }
                }
                return;
            default:
                try {
                    Iterator it2 = A3.m.f114e.keySet().iterator();
                    while (it2.hasNext()) {
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it2.next();
                        if (scheduledThreadPoolExecutor.isShutdown()) {
                            it2.remove();
                        } else {
                            scheduledThreadPoolExecutor.purge();
                        }
                    }
                    return;
                } catch (Throwable th) {
                    I.D(th);
                    E3.c.a(th);
                    return;
                }
        }
    }
}
