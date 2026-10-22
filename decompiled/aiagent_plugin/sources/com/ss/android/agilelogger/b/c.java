package com.ss.android.agilelogger.b;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: ObjectToStringUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static String a(Bundle r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Bundle[{");
        a(r2, r0);
        r0.append("}]");
        return r0.toString();
    }

    public static String a(Intent r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(128);
        r0.append("Intent { ");
        a(r2, r0);
        r0.append(" }");
        return r0.toString();
    }

    private static void a(Bundle r12, StringBuilder r13) {
        Iterator<String> r7 = r12.keySet().iterator();
        boolean r8 = true;
    L4:
        if (r7.hasNext() == false) goto L46;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (r8 == true) goto L8;
        r13.append(", ");
    L8:
        r13.append(r9).append('=');
        Object r10 = r12.get(r9);
        if ((r10 instanceof int[]) == false) goto L12;
        r13.append(Arrays.toString((int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r10, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin")));
    L45:
        r8 = false;
        goto L4
    L12:
        if ((r10 instanceof byte[]) == false) goto L18;
        if (((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin")).length >= 102400) goto L16;
        r13.append(Arrays.toString((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r10, byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin")));
        goto L45
    L16:
        r13.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r10 instanceof boolean[]) == false) goto L21;
        r13.append(Arrays.toString((boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r10, boolean[].class, "com.obric.aiagent.plugin"), boolean[].class, "com.obric.aiagent.plugin")));
        goto L45
    L21:
        if ((r10 instanceof short[]) == false) goto L24;
        r13.append(Arrays.toString((short[]) ZeusTransformUtils.preCheckCast((short[]) ZeusTransformUtils.preCheckCast(r10, short[].class, "com.obric.aiagent.plugin"), short[].class, "com.obric.aiagent.plugin")));
        goto L45
    L24:
        if ((r10 instanceof long[]) == false) goto L27;
        r13.append(Arrays.toString((long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r10, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin")));
        goto L45
    L27:
        if ((r10 instanceof float[]) == false) goto L30;
        r13.append(Arrays.toString((float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r10, float[].class, "com.obric.aiagent.plugin"), float[].class, "com.obric.aiagent.plugin")));
        goto L45
    L30:
        if ((r10 instanceof double[]) == false) goto L33;
        r13.append(Arrays.toString((double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r10, double[].class, "com.obric.aiagent.plugin"), double[].class, "com.obric.aiagent.plugin")));
        goto L45
    L33:
        if ((r10 instanceof String[]) == false) goto L36;
        r13.append(Arrays.toString((String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r10, String[].class, "com.obric.aiagent.plugin"), String[].class, "com.obric.aiagent.plugin")));
        goto L45
    L36:
        if ((r10 instanceof CharSequence[]) == false) goto L39;
        r13.append(Arrays.toString((CharSequence[]) ZeusTransformUtils.preCheckCast((CharSequence[]) ZeusTransformUtils.preCheckCast(r10, CharSequence[].class, "com.obric.aiagent.plugin"), CharSequence[].class, "com.obric.aiagent.plugin")));
        goto L45
    L39:
        if ((r10 instanceof Parcelable[]) == false) goto L42;
        r13.append(Arrays.toString((Parcelable[]) ZeusTransformUtils.preCheckCast((Parcelable[]) ZeusTransformUtils.preCheckCast(r10, Parcelable[].class, "com.obric.aiagent.plugin"), Parcelable[].class, "com.obric.aiagent.plugin")));
        goto L45
    L42:
        if (ZeusTransformUtils.instanceOf(r10, Bundle.class) == false) goto L44;
        r13.append(a((Bundle) ZeusTransformUtils.preCheckCast(r10, Bundle.class, "com.obric.aiagent.plugin")));
        goto L45
    L44:
        r13.append(r10);
        goto L45
    }

    private static void a(Intent r7, StringBuilder r8) {
        String r0 = r7.getAction();
        boolean r1 = true;
        boolean r2 = false;
        if (r0 == null) goto L5;
        r8.append("act=").append(r0);
        boolean r3 = false;
    L6:
        Set<String> r4 = r7.getCategories();
        if (r4 == null) goto L18;
        if (r3 == true) goto L10;
        r8.append(' ');
    L10:
        r8.append("cat=[");
        Iterator<String> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (r1 == true) goto L16;
        r8.append(',');
    L16:
        r8.append(r6);
        r1 = false;
        goto L12
    L17:
        r8.append("]");
        r3 = false;
    L18:
        Uri r9 = r7.getData();
        if (r9 == null) goto L36;
        if (r3 == true) goto L22;
        r8.append(' ');
    L22:
        r8.append("dat=");
        if (Build.VERSION.SDK_INT < 14) goto L25;
        r8.append(a(r9));
    L35:
        r3 = false;
        goto L36
    L25:
        String r10 = r9.getScheme();
        if (r10 != null) goto L28;
        r8.append(r9);
        goto L35
    L28:
        if (r10.equalsIgnoreCase("tel") == false) goto L31;
        r8.append("tel:xxx-xxx-xxxx");
        goto L35
    L31:
        if (r10.equalsIgnoreCase("smsto") == false) goto L33;
        r8.append("smsto:xxx-xxx-xxxx");
        goto L35
    L33:
        r8.append(r9);
    L36:
        String r11 = r7.getType();
        if (r11 == null) goto L41;
        if (r3 == true) goto L40;
        r8.append(' ');
    L40:
        r8.append("typ=").append(r11);
        r3 = false;
    L41:
        int r12 = r7.getFlags();
        if (r12 == 0) goto L46;
        if (r3 == true) goto L45;
        r8.append(' ');
    L45:
        r8.append("flg=0x").append(Integer.toHexString(r12));
        r3 = false;
    L46:
        String r13 = r7.getPackage();
        if (r13 == null) goto L51;
        if (r3 == true) goto L50;
        r8.append(' ');
    L50:
        r8.append("pkg=").append(r13);
        r3 = false;
    L51:
        ComponentName r14 = r7.getComponent();
        if (r14 == null) goto L56;
        if (r3 == true) goto L55;
        r8.append(' ');
    L55:
        r8.append("cmp=").append(r14.flattenToShortString());
        r3 = false;
    L56:
        Rect r15 = r7.getSourceBounds();
        if (r15 == null) goto L62;
        if (r3 == true) goto L60;
        r8.append(' ');
    L60:
        r8.append("bnds=").append(r15.toShortString());
        r3 = false;
    L62:
        if (Build.VERSION.SDK_INT >= 16) goto L64;
    L68:
        r2 = r3;
    L69:
        Bundle r16 = r7.getExtras();
        if (r16 == null) goto L75;
        if (r2 == true) goto L73;
        r8.append(' ');
    L73:
        r8.append("extras={");
        a(r16, r8);
        r8.append('}');
    L75:
        if (Build.VERSION.SDK_INT < 15) goto L83;
        Intent r17 = r7.getSelector();
        if (r17 == null) goto L84;
        r8.append(" sel=");
        a(r17, r8);
        r8.append("}");
        return;
    L84:
        return;
    L83:
        return;
    L64:
        if (r7.getClipData() == null) goto L68;
        if (r3 == true) goto L67;
        r8.append(' ');
    L67:
        r8.append("(has clip)");
        goto L69
    L5:
        r3 = true;
        goto L6
    }

    private static String a(Uri r4) {
        if (Build.VERSION.SDK_INT < 14) goto L13;
        Method r0 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L6 InvocationTargetException -> L8 NoSuchMethodException -> L10
        return (String) ZeusTransformUtils.preCheckCast(r0.invoke(r4, new Object[0]), String.class, "com.obric.aiagent.plugin");
    L6:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r4.toString();
    }
}
