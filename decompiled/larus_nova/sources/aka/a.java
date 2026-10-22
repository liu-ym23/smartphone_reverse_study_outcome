package aka;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f4097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f4098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f4099c;

    static {
    }

    public static Bundle a(String r210, List r211) {
        Intrinsics.checkNotNullParameter(r210, "problemDesc");
        Application r100 = f4097a;
        if (r100 == null) goto L5;
        String r101 = r100.getPackageName();
    L6:
        boolean r102 = false;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L20;
        c r104 = f4099c;
        if (r104 == null) goto L18;
        r104.e("FeedbackSdk", "package name is null");
    L18:
        Bundle r105 = new Bundle();
        r105.putBoolean("success", false);
        r105.putString("error_msg", "package name is null");
        return r105;
    L20:
        Application r106 = f4097a;
        if (r106 == null) goto L42;
        ContentResolver r107 = r106.getContentResolver();
        if (r107 == null) goto L42;
        ArrayList r110 = new ArrayList();
        String r111 = "com.obric.feedback.provider";
        Object[] r112 = {"com.obric.feedback.provider"};
        f06.b r113 = new f06.b();
        g06.a r108 = ApiHookConfig.f245611b.get(240008);
        if (r108 == null) goto L27;
        f06.a[] r109 = r108.f479473i;
    L28:
        f06.a[] r114 = r109;
        int r115 = r114.length;
        int r116 = 0;
    L30:
        if (r116 >= r115) goto L37;
        f06.a r117 = r114[r116];
        int r212 = r116;
        int r213 = r115;
        f06.a[] r214 = r114;
        String r118 = r111;
        Object[] r215 = r112;
        ArrayList r119 = r110;
        d r120 = r117.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r107, r112, "android.content.ContentProviderClient", r113);     // Catch: Exception -> L90
        if (r120.f474982a == true) goto L34;
        r119.add(r117);     // Catch: Exception -> L90
        goto L36
    L34:
        String r121 = null;
    L39:
        if (r120.f474982a == false) goto L41;
        ContentProviderClient r122 = (ContentProviderClient) r120.f474983b;
    L43:
        if (r122 != null) goto L49;
        c r123 = f4099c;
        if (r123 == null) goto L47;
        r123.e("FeedbackSdk", "acquire content provider client failed");
    L47:
        Bundle r124 = new Bundle();
        r124.putBoolean("success", false);
        r124.putString("error_msg", "acquire content provider client failed");
        return r124;
    L49:
        Bundle r125 = new Bundle();
        r125.putString("from_package", r101);
        r125.putString("problem_desc", r210);
        if (r211 == null) goto L53;
        ArrayList<String> r126 = (ArrayList) CollectionsKt.toCollection(r211, new ArrayList());
        if (r126 == null) goto L53;
    L54:
        r125.putStringArrayList("file_path_list", r126);
        b r127 = f4098b;
        if (r127 == null) goto L57;
        String r128 = r127.getUid();
    L58:
        if (r128 != null) goto L60;
    L61:
        r102 = true;
    L62:
        if (r102 == true) goto L67;
        b r129 = f4098b;
        if (r129 == null) goto L66;
        r121 = r129.getUid();
    L66:
        r125.putString("user_id", r121);
    L67:
        b r130 = f4098b;
        if (r130 == null) goto L70;
        r130.getDid();
    L70:
        b r131 = f4098b;
        if (r131 == null) goto L73;
        r131.a();
        long r132 = 86400;
    L74:
        r125.putLong("trace_time_window", r132);
        c r133 = f4099c;
        if (r133 == null) goto L77;
        r133.i("trigger feedback, extras: " + r125);
    L77:
        Bundle r134 = r122.call("trigger_feedback", r210, r125);
        c r135 = f4099c;
        if (r135 == null) goto L81;
        r135.i("trigger feedback result: " + r134);
    L81:
        if (Build.VERSION.SDK_INT < 24) goto L83;
        r122.close();
    L85:
        if (r134 == null) goto L89;
        Set<String> r136 = r134.keySet();
        if (r136 == null) goto L89;
        CollectionsKt.joinToString$default(r136, ",", null, null, 0, null, null, 62, null);
    L89:
        return r134;
    L83:
        r122.release();
        goto L85
    L73:
        r132 = 0;
        goto L74
    L60:
        if (r128.length() != 0) goto L62;
    L57:
        r128 = r121;
    L53:
        r126 = new ArrayList();
        goto L54
    L41:
        r122 = r107.acquireUnstableContentProviderClient(r118);
    L36:
        r116 = r212 + 1;
        r110 = r119;
        r111 = r118;
        r115 = r213;
        r114 = r214;
        r112 = r215;
        goto L30
    L37:
        r118 = r111;
        r121 = null;
        r120 = new d(false, null);
        goto L39
    L27:
        r109 = ApiHookConfig.f245613d;
    L42:
        r121 = null;
        r122 = null;
        goto L43
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }
}
