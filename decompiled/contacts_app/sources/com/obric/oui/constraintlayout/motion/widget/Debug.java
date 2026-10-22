package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.obric.contactsdk.loader.ContractKt;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class Debug {
    public Debug() {
    }

    public static void logStack(String r6, String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = HanziToPinyin.Token.SEPARATOR;
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        String r5 = ".(" + r0[r2].getFileName() + SimContactsConstants.ANR_SEP + r0[r2].getLineNumber() + ") " + r0[r2].getMethodName();
        r3 = r3 + HanziToPinyin.Token.SEPARATOR;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(r6, r7 + r3 + r5 + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static void printStack(String r7, int r8) {
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r2 = 1;
        int r9 = Math.min(r8, r0.length - 1);
        String r3 = HanziToPinyin.Token.SEPARATOR;
    L3:
        if (r2 > r9) goto L5;
        StackTraceElement r4 = r0[r2];
        String r5 = ".(" + r0[r2].getFileName() + SimContactsConstants.ANR_SEP + r0[r2].getLineNumber() + ") ";
        r3 = r3 + HanziToPinyin.Token.SEPARATOR;
        System.out.println(r7 + r3 + r5 + r3);
        r2 = r2 + 1;
        goto L3
    }

    public static String getName(View r1) {
        return r1.getContext().getResources().getResourceEntryName(r1.getId());
    L4:
        return "UNKNOWN";
    }

    public static void dumpPoc(Object r11) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ")";
        Class<?> r2 = r11.getClass();
        System.out.println(r1 + "------------- " + r2.getName() + " --------------------");
        Field[] r3 = r2.getFields();
        int r4 = 0;
    L4:
        if (r4 >= r3.length) goto L31;
        Field r6 = r3[r4];
        Object r7 = r6.get(r11);     // Catch: IllegalAccessException -> L33
        if (r6.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r7 instanceof Integer) == false) goto L15;
        if (r7.toString().equals(ContractKt.IM_CUSTOM) == true) goto L30;
    L15:
        if ((r7 instanceof Integer) == false) goto L20;
        if (r7.toString().equals("0") == true) goto L30;
    L20:
        if ((r7 instanceof Float) == false) goto L25;
        if (r7.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r7 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r1 + "    " + r6.getName() + HanziToPinyin.Token.SEPARATOR + r7);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r7.toString().equals("0.5") == false) goto L29;
    L30:
        r4 = r4 + 1;
        goto L4
    L31:
        System.out.println(r1 + "------------- " + r2.getSimpleName() + " --------------------");
    }

    public static String getName(Context r1, int r2) {
        if (r2 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r1.getResources().getResourceEntryName(r2);
    L9:
        return "?" + r2;
    }

    public static String getName(Context r5, int[] r6) {
        String r0 = r6.length + "[";     // Catch: Exception -> L17
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L15;
        StringBuilder r2 = new StringBuilder().append(r0);     // Catch: Exception -> L17
        if (r1 != 0) goto L9;
        String r3 = "";
    L10:
        String r4 = r2.append(r3).toString();     // Catch: Exception -> L17
        String r7 = r5.getResources().getResourceEntryName(r6[r1]);     // Catch: Resources.NotFoundException -> L13 Exception -> L17
    L14:
        r0 = r4 + r7;     // Catch: Exception -> L17
        r1 = r1 + 1;     // Catch: Exception -> L17
    L13:
        r7 = "? " + r6[r1] + HanziToPinyin.Token.SEPARATOR;     // Catch: Exception -> L17
        goto L14
    L9:
        r3 = HanziToPinyin.Token.SEPARATOR;
        goto L10
    L15:
        return r0 + "]";
    L17:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("DEBUG", e.toString());
        return "UNKNOWN";
    }

    public static String getState(MotionLayout r1, int r2) {
        return getState(r1, r2, -1);
    }

    public static String getState(MotionLayout r2, int r3, int r4) {
        if (r3 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r5 = r2.getContext().getResources().getResourceEntryName(r3);
        if (r4 != (-1)) goto L9;
        return r5;
    L9:
        if (r5.length() <= r4) goto L12;
        r5 = r5.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r5.length() <= r4) goto L18;
        int r6 = r5.replaceAll("[^_]", "").length();
        if (r6 > 0) goto L16;
        return r5;
    L16:
        return r5.replaceAll(CharBuffer.allocate((r5.length() - r4) / r6).toString().replace(0, '.') + "_", "_");
    L18:
        return r5;
    }

    public static String getActionType(MotionEvent r5) {
        int r6 = r5.getAction();
        Field[] r0 = MotionEvent.class.getFields();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L15;
        Field r2 = r0[r1];
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L14;
        if (r2.getType().equals(Integer.TYPE) == false) goto L14;
        if (r2.getInt(null) != r6) goto L14;
        return r2.getName();
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getLocation() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        return ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ") " + r0.getMethodName() + "()";
    }

    public static String getLocation2() {
        StackTraceElement r0 = new Throwable().getStackTrace()[2];
        return ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ")";
    }

    public static String getCallFrom(int r2) {
        StackTraceElement r3 = new Throwable().getStackTrace()[r2 + 2];
        return ".(" + r3.getFileName() + SimContactsConstants.ANR_SEP + r3.getLineNumber() + ")";
    }

    public static void dumpLayoutParams(ViewGroup r11, String r12) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r1 = ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ") " + r12 + "  ";
        int r2 = r11.getChildCount();
        System.out.println(r12 + " children " + r2);
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        View r4 = r11.getChildAt(r3);
        System.out.println(r1 + "     " + getName(r4));
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Field[] r6 = r5.getClass().getFields();
        int r7 = 0;
    L6:
        if (r7 >= r6.length) goto L16;
        Field r8 = r6[r7];
        Object r9 = r8.get(r5);     // Catch: IllegalAccessException -> L18
        if (r8.getName().contains("To") == false) goto L15;
        if (r9.toString().equals(ContractKt.IM_CUSTOM) == true) goto L15;
        System.out.println(r1 + "       " + r8.getName() + HanziToPinyin.Token.SEPARATOR + r9);     // Catch: IllegalAccessException -> L18
    L15:
        r7 = r7 + 1;
        goto L6
    L16:
        r3 = r3 + 1;
        goto L3
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r7, String r8) {
        StackTraceElement r0 = new Throwable().getStackTrace()[1];
        String r9 = ".(" + r0.getFileName() + SimContactsConstants.ANR_SEP + r0.getLineNumber() + ") " + r8 + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + r9 + "  " + r7.getClass().getName());
        Field[] r1 = r7.getClass().getFields();
        int r2 = 0;
    L4:
        if (r2 >= r1.length) goto L14;
        Field r3 = r1[r2];
        Object r4 = r3.get(r7);     // Catch: IllegalAccessException -> L16
        String r5 = r3.getName();     // Catch: IllegalAccessException -> L16
        if (r5.contains("To") == false) goto L13;
        if (r4.toString().equals(ContractKt.IM_CUSTOM) == true) goto L13;
        System.out.println(r9 + "       " + r5 + HanziToPinyin.Token.SEPARATOR + r4);     // Catch: IllegalAccessException -> L16
    L13:
        r2 = r2 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r9);
    }
}
