package ci7;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g {
    public static void b(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101800);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r110, r111, "void", r112);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        r110.clearPrimaryClip();
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ClipData c(ClipboardManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    public static ClipDescription d(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean e(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101805);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.hasPrimaryClip();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static ClipboardManager g(Context r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        return (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
    L7:
        th = move-exception;
        mi7.e.d(6, "ClipboardUtils", "Can't create handler inside thread that has not called Looper.prepare() ", th);
        if (Looper.myLooper() != null) goto L15;
        Looper.prepare();
        return (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
    L15:
        return null;
    }

    public static Pair<Boolean, ClipData> h(Context r100) {
        e.a(r100);
        mi7.g.a(r100).getClass();
        if (mi7.g.f514094a == null) goto L8;
        if (TextUtils.isEmpty("KEY_LAST_CLIPBOARD_TIME_STAMP") == true) goto L8;
        SharedPreferences.Editor r101 = mi7.g.f514094a.edit();
        r101.putLong("KEY_LAST_CLIPBOARD_TIME_STAMP", -1);
        r101.apply();
    L8:
        return new Pair(Boolean.TRUE, null);
    }

    public static void f(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void i(ClipboardManager r100, ClipData r101) {
        if (r100 == null) goto L18;
        hi7.b r102 = (hi7.b) z.a(hi7.b.class);
        StringBuilder r103 = new StringBuilder("setPrimaryClip, compliance == null? ");
        if (r102 != null) goto L6;
        boolean r104 = true;
    L7:
        r103.append(r104);
        mi7.e.a("ClipboardUtils", r103.toString());
        if (r102 == null) goto L10;
        r102.a();
        return;
    L10:
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L13
        f(r100, r101);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        return;
    L6:
        r104 = false;
        goto L7
    }

    public static void a(Context r100, String r101, ClipData r102) {
        if (TextUtils.isEmpty(r101) == true) goto L48;
        if (r102 == null) goto L49;
        ClipboardManager r103 = g(r100);
        if (r103 != null) goto L10;
        return;
    L10:
        if (r102.getItemCount() <= 0) goto L30;
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L13:
        if (r105 >= r102.getItemCount()) goto L25;
        ClipData.Item r106 = r102.getItemAt(r105);
        if (r106 == null) goto L23;
        if (r106.getText() != null) goto L20;
    L22:
        r104.add(r106);
        goto L23
    L20:
        if (r101.equals(r106.getText().toString()) == false) goto L22;
    L23:
        r105 = r105 + 1;
        goto L13
    L25:
        if (r104.size() <= 0) goto L30;
        ClipData r107 = new ClipData(r102.getDescription(), (ClipData.Item) ListProtector.get(r104, 0));
        int r108 = 1;
    L28:
        if (r108 >= r104.size()) goto L42;
        r107.addItem((ClipData.Item) ListProtector.get(r104, r108));
        r108 = r108 + 1;
    L42:
        if (r107 == null) goto L34;
        i(r103, r107);     // Catch: Throwable -> L40
    L41:
        return;
    L34:
        if (r102.getItemCount() <= 0) goto L41;
        if (Build.VERSION.SDK_INT < 28) goto L38;
        b(r103);     // Catch: Throwable -> L40
        goto L41
    L38:
        i(r103, ClipData.newPlainText("", ""));     // Catch: Throwable -> L40
    L50:
        return;
    L30:
        r107 = null;
        goto L42
    L49:
        return;
    }
}
