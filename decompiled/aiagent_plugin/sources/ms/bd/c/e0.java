package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39490a = null;

    static {
        f39490a = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b47604", new byte[]{95, 5, 116, 77, 28, 38, 101}), String.class, "com.obric.aiagent.plugin");
    }

    public static boolean a(Context r27) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r27, Context.class, "com.obric.aiagent.plugin");
        PackageManager r2 = r0.getPackageManager();
        IBinder r4 = null;
        if (r2 == null) goto L17;
        Iterator<ResolveInfo> r3 = r2.queryIntentActivities(new Intent((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9f8693", new byte[]{41, 106, 79, 80, 9, 45, 62, 9, 96, 104, 60, 97, 69, 86, 72, 37, 57, 83, 96, 105, 38, 42, 102, 99, 47, 10}), String.class, "com.obric.aiagent.plugin"), null), 128).iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        ActivityInfo r8 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r3.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).activityInfo;
        if (r8 == null) goto L7;
        Bundle r9 = r8.applicationInfo.metaData;
        if (r9 == null) goto L7;
        if (r9.get((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "735c91", new byte[]{62, 33, 73, 4, 3, 34, 57, 27, 106, 37, 35, 35, 85, 30, 9, 40}), String.class, "com.obric.aiagent.plugin")) == null) goto L7;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L53;
        String r6 = r0.getPackageName();
        if ((com.bytedance.mobsec.metasec.ml.a.a() & 1) != 1) goto L22;
        boolean r1 = true;
    L23:
        if (r1 == true) goto L37;
        String r10 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bb1f81", new byte[]{114, 99, 86, 27, 17, 47, 117, 90}), String.class, "com.obric.aiagent.plugin");
        byte[] r14 = new byte[25];     // Catch: Exception -> L34
        r14[0] = 116;     // Catch: Exception -> L34
        r14[1] = 105;     // Catch: Exception -> L34
        r14[2] = 19;     // Catch: Exception -> L34
        r14[3] = 87;     // Catch: Exception -> L34
        r14[4] = 3;     // Catch: Exception -> L34
        r14[5] = 122;     // Catch: Exception -> L34
        r14[6] = 99;     // Catch: Exception -> L34
        r14[7] = 10;     // Catch: Exception -> L32
        r14[8] = 58;     // Catch: Exception -> L32
        r14[9] = 114;     // Catch: Exception -> L32
        r14[10] = 59;     // Catch: Exception -> L32
        r14[11] = 84;     // Catch: Exception -> L32
        r14[12] = 18;     // Catch: Exception -> L32
        r14[13] = 87;     // Catch: Exception -> L32
        r14[14] = 26;     // Catch: Exception -> L32
        r14[15] = 122;     // Catch: Exception -> L32
        r14[16] = 100;     // Catch: Exception -> L32
        r14[17] = 65;     // Catch: Exception -> L32
        r14[18] = 24;     // Catch: Exception -> L32
        r14[19] = 96;     // Catch: Exception -> L32
        r14[20] = 123;     // Catch: Exception -> L32
        r14[21] = 102;     // Catch: Exception -> L32
        r14[22] = 16;     // Catch: Exception -> L32
        r14[23] = 64;     // Catch: Exception -> L32
        r14[24] = 30;     // Catch: Exception -> L32
        Method r7 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ded13d", r14), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDeclaredMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "32a182", new byte[]{37, 53, 6, 118, 2, 55, 38, 26, 51, 100}), String.class, "com.obric.aiagent.plugin"), new Class[]{String.class});     // Catch: Exception -> L32
        r7.setAccessible(true);     // Catch: Exception -> L32
        r4 = null;
        r4 = (IBinder) ZeusTransformUtils.preCheckCast(r7.invoke(null, new Object[]{r10}), IBinder.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
    L36:
        if (r4 == null) goto L37;
        Parcel r11 = Parcel.obtain();
        Parcel r12 = Parcel.obtain();
        r11.writeInterfaceToken(f39490a);     // Catch: Throwable -> L44
        r11.writeInt(2);     // Catch: Throwable -> L44
        r11.writeString(r6);     // Catch: Throwable -> L44
        r11.writeStrongBinder(new Binder());     // Catch: Throwable -> L44
        if (r4.transact(1598837584, r11, r12, 0) == false) goto L46;
        r12.readException();     // Catch: Throwable -> L44
        r11.recycle();
        r12.recycle();
        boolean r13 = true;
    L47:
        if (r13 == false) goto L70;
        return true;
    L70:
        return false;
    L46:
        r11.recycle();
        r12.recycle();
    L44:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        r11.recycle();
        r12.recycle();
        throw th;
    L32:
        e = e;
        r4 = null;
    L35:
        e.printStackTrace();
    L34:
        e = e;
    L37:
        r13 = false;
        goto L47
    L22:
        r1 = false;
        goto L23
    L53:
        return true;
    L17:
        r5 = false;
        goto L18
    }
}
