package A1;

import D7.N;
import H.h;
import H1.c;
import H4.o;
import L0.f;
import N9.j;
import S0.g;
import a5.d;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.apm.insight.nativecrash.NativeImpl;
import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;
import com.stepos.ability.R;
import com.stepos.common.util.HighContrastRegister;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import dalvik.system.DexFile;
import g0.e;
import g1.AbstractC1451a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import l0.AbstractC1654a;
import org.json.JSONObject;
import v0.C2054a;
import v2.RunnableC2056a;
import w2.AbstractC2095a;
import y0.C2126b;
import z0.C2153a;
import z2.k;
import z2.l;
import z2.r;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f75a;

    public /* synthetic */ a(int i) {
        this.f75a = i;
    }

    /* JADX INFO: Infinite loop detected, blocks: 35, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, Resources.NotFoundException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        DisplayMetrics displayMetrics;
        r rVarI;
        long j5;
        File file;
        String[] list;
        switch (this.f75a) {
            case 0:
                D1.a.b().c();
                return;
            case 1:
                if (F1.a.f533a == null) {
                    synchronized (F1.a.class) {
                        try {
                            if (F1.a.f533a == null) {
                                F1.a.f533a = new F1.a();
                            }
                        } finally {
                        }
                    }
                }
                F1.a.f533a.getClass();
                E1.a.b.execute(new a(6));
                return;
            case 2:
                try {
                    U7.a.j("MemoryNetApi uploadFile begin", new Object[0]);
                    JSONObject jSONObjectD = h.d();
                    jSONObjectD.put("update_version_code", c.d().e().getString("updateVersionCode", ""));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("event_type", "memory_object_monitor");
                    jSONObject.put("hprof_type", c.d().e().getInt("hprof_type", 1));
                    c.d().getClass();
                    jSONObject.put("timestamp", c.d().c != null ? c.d().c.c : System.currentTimeMillis());
                    c.d().getClass();
                    jSONObject.put("timestamp_sid", c.d().c != null ? c.d().c.d : System.currentTimeMillis());
                    HashMap map = new HashMap(2);
                    map.put("header", jSONObjectD.toString());
                    map.put(SettingsConfig.KEY_DATA, jSONObject.toString());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new File(c.d().e().getString("latestFilePath", "")));
                    S0.b.C0("upload_dump");
                    List list2 = C1.a.b;
                    if (list2 != null && list2.size() > 0) {
                        Iterator it = C1.a.b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                B.b bVarUploadFiles = h.g.uploadFiles((String) it.next(), arrayList, map);
                                if (bVarUploadFiles != null) {
                                    String str = new String(bVarUploadFiles.c);
                                    if (TextUtils.isEmpty(str)) {
                                        U7.a.j("MemoryNetApi uploadFile succeed", new Object[0]);
                                        c.d().b();
                                        S0.b.C0("upload_dump_success");
                                        I1.a.a().f791a = false;
                                    } else {
                                        U7.a.j("MemoryNetApi uploadFile failed,message:" + str, new Object[0]);
                                    }
                                } else {
                                    U7.a.j("MemoryNetApi uploadFile failed, response is null", new Object[0]);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                C1.a.e = false;
                return;
            case 3:
                try {
                    List list3 = C1.a.f281a;
                    if (list3 == null || list3.size() <= 0) {
                        return;
                    }
                    Iterator it2 = C1.a.f281a.iterator();
                    while (it2.hasNext()) {
                        B.b bVarDoGet = h.g.doGet(String.format((String) it2.next(), Integer.valueOf(h.d().optInt("aid", 0))), null);
                        if (bVarDoGet != null) {
                            boolean zOptBoolean = new JSONObject(new String(bVarDoGet.c)).optBoolean("should_upload");
                            U7.a.j("uploadCheck with api: shouldUpload " + zOptBoolean, new Object[0]);
                            if (zOptBoolean) {
                                c.d().f();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 4:
                boolean zContains = FragmentTimeAgent.sMethodSet.contains(FragmentTimeAgent.sFragmentName);
                FragmentTimeAgent.sMethodSet.add(FragmentTimeAgent.sFragmentName);
                FragmentTimeAgent.reportStats(zContains, null, 0L, 0L);
                return;
            case 5:
                try {
                    if (FragmentTimeAgent.sOnGlobalLayoutListener == null || FragmentTimeAgent.sRootViewRef == null || FragmentTimeAgent.sRootViewRef.get() == null) {
                        return;
                    }
                    ((View) FragmentTimeAgent.sRootViewRef.get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.sOnGlobalLayoutListener);
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 6:
                try {
                    long j6 = c.d().e().getLong("lastDumpTime", 0L);
                    if (j6 == 0 || System.currentTimeMillis() - j6 <= 259200000) {
                        return;
                    }
                    c.d().b();
                    U7.a.j("memorywidget is deleteCache", new Object[0]);
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            case 7:
                e.a();
                return;
            case 8:
                Iterator it3 = ((CopyOnWriteArraySet) C2054a.d().f6763a).iterator();
                if (it3.hasNext()) {
                    throw B7.a.f(it3);
                }
                return;
            case 9:
                while (true) {
                    try {
                        N0.b bVar = (N0.b) N0.a.b.take();
                        Iterator it4 = N0.a.f1006a.iterator();
                        while (it4.hasNext()) {
                            N0.c cVar = (N0.c) it4.next();
                            try {
                                if (bVar.a()) {
                                    ((g) cVar).b(bVar);
                                } else if (AbstractC1451a.f4467a) {
                                    String str2 = "monitorable invalid. ignored. " + bVar;
                                    if (AbstractC1451a.f4467a) {
                                        Log.w("APM-Monitor", str2);
                                    }
                                }
                            } catch (Throwable th3) {
                                o.g("APM-Monitor", "monitorableHandler " + cVar + " handle monitorable " + bVar + "failed.", th3);
                            }
                        }
                    } catch (Throwable th4) {
                        o.g("APM", "Oh, Damn it!!!", th4);
                    }
                }
            case 10:
                Q1.a.b().a();
                return;
            case 11:
                Q1.a.b().a();
                return;
            case 12:
                B1.c cVar2 = B1.c.b;
                cVar2.o(R.drawable.stepos_fastscroller_color_blue);
                cVar2.o(R.drawable.stepos_action_bar_tab_indicator_color_blue);
                cVar2.o(R.drawable.stepos_guide_left_color_blue);
                cVar2.o(R.drawable.stepos_guide_right_color_blue);
                cVar2.o(R.drawable.stepos_guide_middle_down_color_blue);
                cVar2.o(R.drawable.stepos_guide_middle_up_color_blue);
                cVar2.o(R.drawable.stepos_btn_check_buttonless_on_normal_color_blue);
                cVar2.o(R.drawable.stepos_btn_check_buttonless_on_disable_color_blue);
                cVar2.o(R.drawable.stepos_checkbox_counter_color_blue);
                cVar2.o(R.drawable.stepos_checkbox_counter_pressed_color_blue);
                cVar2.o(R.drawable.stepos_edittext_new_selected_blue);
                cVar2.o(R.drawable.stepos_input_select_handle_color_blue);
                cVar2.o(R.drawable.stepos_progress_primary_color_blue);
                cVar2.o(R.drawable.stepos_progressloading_success_color_blue);
                cVar2.o(R.drawable.stepos_scrubber_primary_vertical_disable_color_blue);
                cVar2.o(R.drawable.stepos_scrubber_primary_vertical_normal_color_blue);
                cVar2.o(R.drawable.stepos_search_edittext_handle_left_color_blue);
                cVar2.o(R.drawable.stepos_search_edittext_handle_right_color_blue);
                cVar2.o(R.drawable.stepos_slider_btn_hover_color_blue);
                cVar2.o(R.drawable.stepos_tab_selected_color_blue);
                cVar2.o(R.drawable.stepos_text_cursor);
                cVar2.o(R.drawable.stepos_text_select_handle_left_color_blue);
                cVar2.o(R.drawable.stepos_text_select_handle_right_color_blue);
                ArrayList arrayList2 = new ArrayList();
                try {
                    Enumeration<String> enumerationEntries = new DexFile(((Application) cVar2.f180a).getPackageCodePath()).entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String strNextElement = enumerationEntries.nextElement();
                        if (strNextElement.contains("com.stepos.contrast")) {
                            Class<?> cls = Class.forName(strNextElement);
                            if (cls.isAnnotationPresent(HighContrastRegister.class)) {
                                arrayList2.add(cls);
                            }
                        }
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    Class cls2 = (Class) it5.next();
                    try {
                        String strRegisterImpl = ((HighContrastRegister) cls2.getAnnotation(HighContrastRegister.class)).registerImpl();
                        d dVar = a5.g.f1643a;
                        dVar.getClass();
                        dVar.h(cls2.getClassLoader(), cls2.getName()).a(strRegisterImpl, new Class[0]).f1642a.invoke(null, null);
                    } catch (Exception e9) {
                        androidx.constraintlayout.core.dsl.a.t(e9, new StringBuilder(""), "HighContrast_Common");
                    }
                }
                return;
            case 13:
                Y.b.a();
                return;
            case 14:
                Resources system = Resources.getSystem();
                float f = Resources.getSystem().getDisplayMetrics().xdpi;
                system.getDisplayMetrics().xdpi = f;
                S0.b.X0().getResources().getDisplayMetrics().xdpi = f;
                ArrayList arrayList3 = N.f399a;
                if (arrayList3 != null) {
                    Iterator it6 = arrayList3.iterator();
                    while (it6.hasNext()) {
                        try {
                            DisplayMetrics displayMetrics2 = (DisplayMetrics) ((Field) it6.next()).get(system);
                            if (displayMetrics2 != null) {
                                displayMetrics2.xdpi = f;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    return;
                }
                N.f399a = new ArrayList();
                Class<?> superclass = system.getClass();
                Field[] declaredFields = superclass.getDeclaredFields();
                while (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                            field.setAccessible(true);
                            try {
                                displayMetrics = (DisplayMetrics) field.get(system);
                            } catch (Exception unused2) {
                                displayMetrics = null;
                            }
                            if (displayMetrics != null) {
                                N.f399a.add(field);
                                displayMetrics.xdpi = f;
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
            case 15:
                SystemClock.uptimeMillis();
                throw null;
            case 16:
                try {
                    Intent intent = new Intent("com.apm.setting.update.action");
                    Application application = h.f711a;
                    intent.putExtra("PROCESS_NAME", D2.b.a());
                    h.f711a.sendBroadcast(intent);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            case 17:
                try {
                    J2.c.f865a.c();
                    return;
                } catch (Throwable th5) {
                    if (h.b) {
                        th5.printStackTrace();
                        AbstractC1654a.f5271a.a("APM_START_ERROR", th5.getMessage() + "\n" + S0.b.m(30, th5));
                    }
                    try {
                        f fVar = L0.d.f925a;
                        fVar.c = false;
                        L0.h hVar = fVar.b;
                        if (hVar != null) {
                            hVar.a(fVar.d);
                            fVar.b.a(fVar.e);
                            return;
                        }
                        return;
                    } catch (Throwable unused4) {
                        return;
                    }
                }
            case 18:
                l.i().d.removeCallbacks(this);
                r rVarI2 = l.i();
                Handler handler = l.i().d;
                Context context = com.apm.insight.g.f2160a;
                rVarI2.a(new RunnableC2056a(handler, 0, 30000L));
                return;
            case 19:
                r rVarI3 = l.i();
                a aVar = AbstractC2095a.f6830a;
                rVarI3.e(aVar);
                if (D2.b.f(com.apm.insight.g.f2160a)) {
                    AbstractC2095a.m();
                }
                if (AbstractC2095a.b > 0) {
                    if (com.stepos.statsrpk.d.l(com.apm.insight.g.f2160a)) {
                        rVarI = l.i();
                        j5 = 15000;
                    } else {
                        rVarI = l.i();
                        j5 = 60000;
                    }
                    rVarI.b(aVar, j5);
                    return;
                }
                return;
            case 20:
                w2.l.a().d();
                return;
            case 21:
                AbstractC2095a.j();
                if (AbstractC2095a.e()) {
                    AbstractC2095a.b = 40;
                    l.i().a(AbstractC2095a.f6830a);
                    return;
                }
                return;
            case 22:
                try {
                    NativeImpl.A();
                    return;
                } catch (Throwable th6) {
                    try {
                        com.apm.insight.b.a(th6);
                        return;
                    } catch (Throwable unused5) {
                        return;
                    }
                }
            case 23:
                try {
                    C2126b c2126b = C2126b.g;
                    while (true) {
                        C2153a c2153a = (C2153a) c2126b.b.poll();
                        if (c2153a == null) {
                            Iterator it7 = C2126b.h.iterator();
                            while (it7.hasNext()) {
                                C2153a c2153a2 = (C2153a) it7.next();
                                C2126b c2126b2 = C2126b.g;
                                CopyOnWriteArraySet copyOnWriteArraySet = c2126b2.c;
                                String str3 = c2153a2.f6925a;
                                String str4 = c2153a2.b;
                                if (!copyOnWriteArraySet.contains(str3)) {
                                    if (h.b) {
                                        Log.d("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"No Leak:" + str4}));
                                    }
                                    C2126b.h.remove(c2153a2);
                                } else if (c2153a2.d.get() == null) {
                                    if (System.currentTimeMillis() - c2153a2.c > 30000) {
                                        c2126b2.c.remove(c2153a2.f6925a);
                                        C2126b.h.remove(c2153a2);
                                        C2126b.a(c2153a2);
                                    } else if (h.b) {
                                        Log.d("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"Wait timeout:" + str4}));
                                    }
                                } else if (h.b) {
                                    Log.d("ApmInsight:ActivityLeakTask", U7.a.e(new String[]{"Wait gc:" + str4}));
                                }
                            }
                            return;
                        }
                        c2126b.c.remove(c2153a.f6925a);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            case 24:
                k.g = true;
                NativeImpl.w();
                return;
            default:
                if (com.stepos.statsrpk.d.l(com.apm.insight.g.f2160a) && (list = (file = new File(j.C(com.apm.insight.g.f2160a), "apminsight/ProcessTrack/")).list()) != null && list.length > 25) {
                    Arrays.sort(list);
                    for (int i = 0; i < list.length - 25; i++) {
                        M.a.u(new File(file, list[i]));
                    }
                    return;
                }
                return;
        }
    }

    public a(h2.g gVar) {
        this.f75a = 15;
    }
}
