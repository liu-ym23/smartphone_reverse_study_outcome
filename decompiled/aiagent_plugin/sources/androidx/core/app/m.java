package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NotificationCompatJellybean.java */
/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f1120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f1122d = null;

    static {
        f1119a = new Object();
        f1122d = new Object();
    }

    public static SparseArray<Bundle> a(List<Bundle> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        SparseArray<Bundle> r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L10;
        Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(r7.get(r3), Bundle.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        if (r2 != null) goto L8;
        r2 = new SparseArray();
    L8:
        r2.put(r3, r4);
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        return r2;
    }

    public static Bundle a(Notification r6) {
        Object r0 = f1119a;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (f1121c == false) goto L33;
        monitor-exit(r0);     // Catch: Throwable -> L29
        return null;
    L33:
    L22:
        e = move-exception;
        a("NotificationCompat", "Unable to access notification extras", e);     // Catch: Throwable -> L29
    L26:
        f1121c = true;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return null;
    L24:
        e = move-exception;
        a("NotificationCompat", "Unable to access notification extras", e);     // Catch: Throwable -> L29
        goto L26
    L10:
        if (f1120b != null) goto L17;
        Field r3 = Notification.class.getDeclaredField("extras");     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        if (Bundle.class.isAssignableFrom(r3.getType()) == true) goto L16;
        a("NotificationCompat", "Notification.extras field is not of type Bundle");     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        f1121c = true;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return null;
    L16:
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        f1120b = r3;     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
    L17:
        Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(f1120b.get(r6), Bundle.class, "com.obric.aiagent.plugin");     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        if (r4 != null) goto L20;
        r4 = new Bundle();     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
        f1120b.set(r6, r4);     // Catch: NoSuchFieldException -> L22 IllegalAccessException -> L24 Throwable -> L29
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return r4;
    }

    public static Bundle a(Notification.Builder r3, k.a r4) {
        IconCompat r0 = r4.a();
        if (r0 == null) goto L5;
        int r1 = r0.b();
    L6:
        r3.addAction(r1, r4.b(), r4.c());
        Bundle r5 = new Bundle(r4.d());
        if (r4.g() == null) goto L10;
        r5.putParcelableArray("android.support.remoteInputs", a(r4.g()));
    L10:
        if (r4.j() == null) goto L12;
        r5.putParcelableArray("android.support.dataRemoteInputs", a(r4.j()));
    L12:
        r5.putBoolean("android.support.allowGeneratedReplies", r4.e());
        return r5;
    L5:
        r1 = 0;
        goto L6
    }

    static Bundle a(k.a r4) {
        Bundle r0 = new Bundle();
        IconCompat r1 = r4.a();
        if (r1 == null) goto L5;
        int r2 = r1.b();
    L6:
        r0.putInt("icon", r2);
        r0.putCharSequence(DBDefinition.TITLE, r4.b());
        r0.putParcelable("actionIntent", r4.c());
        if (r4.d() == null) goto L9;
        Bundle r3 = new Bundle(r4.d());
    L10:
        r3.putBoolean("android.support.allowGeneratedReplies", r4.e());
        r0.putBundle("extras", r3);
        r0.putParcelableArray("remoteInputs", a(r4.g()));
        r0.putBoolean("showsUserInterface", r4.k());
        r0.putInt("semanticAction", r4.h());
        return r0;
    L9:
        r3 = new Bundle();
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    private static Bundle a(p r5) {
        Bundle r0 = new Bundle();
        r0.putString("resultKey", r5.a());
        r0.putCharSequence("label", r5.b());
        r0.putCharSequenceArray("choices", r5.c());
        r0.putBoolean("allowFreeFormInput", r5.f());
        r0.putBundle("extras", r5.h());
        Set<String> r6 = r5.d();
        if (r6 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r6.isEmpty() == true) goto L11;
        ArrayList<String> r1 = new ArrayList(r6.size());
        Iterator<String> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r1.add((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        r0.putStringArrayList("allowedDataTypes", r1);
        goto L11
    }

    private static Bundle[] a(p[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Bundle[] r0 = new Bundle[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = a(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
