package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import tb2.c;

/* JADX INFO: loaded from: classes17.dex */
public class Debug {
    public Debug() {
    }

    public static String getLoc() {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        return ".(" + r100.getFileName() + ":" + r100.getLineNumber() + ") " + r100.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        return ".(" + r100.getFileName() + ":" + r100.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement r100 = new Throwable().getStackTrace()[2];
        return ".(" + r100.getFileName() + ":" + r100.getLineNumber() + ")";
    }

    public static void dumpPoc(Object r110) {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        String r101 = ".(" + r100.getFileName() + ":" + r100.getLineNumber() + ")";
        Class<?> r102 = r110.getClass();
        System.out.println(r101 + "------------- " + r102.getName() + " --------------------");
        Field[] r103 = r102.getFields();
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L31;
        Field r105 = r103[r104];
        Object r106 = r105.get(r110);     // Catch: IllegalAccessException -> L33
        if (r105.getName().startsWith("layout_constraint") == false) goto L30;
        if ((r106 instanceof Integer) == false) goto L15;
        if (r106.toString().equals("-1") == true) goto L30;
    L15:
        if ((r106 instanceof Integer) == false) goto L20;
        if (r106.toString().equals("0") == true) goto L30;
    L20:
        if ((r106 instanceof Float) == false) goto L25;
        if (r106.toString().equals("1.0") == true) goto L30;
    L25:
        if ((r106 instanceof Float) == true) goto L27;
    L29:
        System.out.println(r101 + LineContent.FOUR_SPACE + r105.getName() + " " + r106);     // Catch: IllegalAccessException -> L33
        goto L30
    L27:
        if (r106.toString().equals("0.5") == false) goto L29;
    L30:
        r104 = r104 + 1;
        goto L4
    L31:
        System.out.println(r101 + "------------- " + r102.getSimpleName() + " --------------------");
    }

    public static String getActionType(MotionEvent r100) {
        int r101 = r100.getAction();
        Field[] r102 = MotionEvent.class.getFields();
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L15;
        Field r104 = r102[r103];
        if (Modifier.isStatic(r104.getModifiers()) == false) goto L14;
        if (r104.getType().equals(Integer.TYPE) == false) goto L14;
        if (r104.getInt(null) != r101) goto L14;
        return r104.getName();
    L14:
        r103 = r103 + 1;
        goto L4
    L15:
        return "---";
    }

    public static String getCallFrom(int r100) {
        StackTraceElement r101 = new Throwable().getStackTrace()[r100 + 2];
        return ".(" + r101.getFileName() + ":" + r101.getLineNumber() + ")";
    }

    public static String getName(View r100) {
        return r100.getContext().getResources().getResourceEntryName(r100.getId());
    L4:
        return "UNKNOWN";
    }

    public static void dumpLayoutParams(ViewGroup r110, String r111) {
        StackTraceElement r100 = new Throwable().getStackTrace()[1];
        String r101 = ".(" + r100.getFileName() + ":" + r100.getLineNumber() + ") " + r111 + c.DEFAULT_TEXT;
        int r102 = r110.getChildCount();
        System.out.println(r111 + " children " + r102);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        View r104 = r110.getChildAt(r103);
        System.out.println(r101 + "     " + getName(r104));
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Field[] r106 = r105.getClass().getFields();
        int r107 = 0;
    L6:
        if (r107 >= r106.length) goto L16;
        Field r108 = r106[r107];
        Object r109 = r108.get(r105);     // Catch: IllegalAccessException -> L18
        if (r108.getName().contains("To") == false) goto L15;
        if (r109.toString().equals("-1") == true) goto L15;
        System.out.println(r101 + "       " + r108.getName() + " " + r109);     // Catch: IllegalAccessException -> L18
    L15:
        r107 = r107 + 1;
        goto L6
    L16:
        r103 = r103 + 1;
        goto L3
    }

    public static String getName(Context r100, int[] r101) {
        String r102 = r101.length + "[";     // Catch: Exception -> L17
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L15;
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L17
        r104.append(r102);     // Catch: Exception -> L17
        if (r103 != 0) goto L9;
        String r105 = "";
    L10:
        r104.append(r105);     // Catch: Exception -> L17
        String r106 = r104.toString();     // Catch: Exception -> L17
        String r107 = r100.getResources().getResourceEntryName(r101[r103]);     // Catch: Resources.NotFoundException -> L13 Exception -> L17
    L14:
        r102 = r106 + r107;     // Catch: Exception -> L17
        r103 = r103 + 1;     // Catch: Exception -> L17
    L13:
        r107 = "? " + r101[r103] + " ";     // Catch: Exception -> L17
        goto L14
    L9:
        r105 = " ";
        goto L10
    L15:
        return r102 + "]";
    L17:
        e = move-exception;
        e.toString();
        return "UNKNOWN";
    }

    public static String getState(MotionLayout r100, int r101) {
        if (r101 != (-1)) goto L7;
        return "UNDEFINED";
    L7:
        return r100.getContext().getResources().getResourceEntryName(r101);
    }

    public static void printStack(String r100, int r101) {
        StackTraceElement[] r102 = new Throwable().getStackTrace();
        int r103 = 1;
        int r104 = Math.min(r101, r102.length - 1);
        String r105 = " ";
    L3:
        if (r103 > r104) goto L5;
        StackTraceElement r106 = r102[r103];
        String r107 = ".(" + r102[r103].getFileName() + ":" + r102[r103].getLineNumber() + ") ";
        r105 = r105 + " ";
        System.out.println(r100 + r105 + r107 + r105);
        r103 = r103 + 1;
        goto L3
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams r100, String r101) {
        StackTraceElement r102 = new Throwable().getStackTrace()[1];
        String r103 = ".(" + r102.getFileName() + ":" + r102.getLineNumber() + ") " + r101 + c.DEFAULT_TEXT;
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + r103 + c.DEFAULT_TEXT + r100.getClass().getName());
        Field[] r104 = r100.getClass().getFields();
        int r105 = 0;
    L4:
        if (r105 >= r104.length) goto L14;
        Field r106 = r104[r105];
        Object r107 = r106.get(r100);     // Catch: IllegalAccessException -> L16
        String r108 = r106.getName();     // Catch: IllegalAccessException -> L16
        if (r108.contains("To") == false) goto L13;
        if (r107.toString().equals("-1") == true) goto L13;
        System.out.println(r103 + "       " + r108 + " " + r107);     // Catch: IllegalAccessException -> L16
    L13:
        r105 = r105 + 1;
        goto L4
    L14:
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + r103);
    }

    public static String getName(Context r100, int r101) {
        if (r101 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r100.getResources().getResourceEntryName(r101);
    L9:
        return "?" + r101;
    }

    public static void logStack(String r100, String r101, int r102) {
        StackTraceElement[] r103 = new Throwable().getStackTrace();
        int r104 = 1;
        int r105 = Math.min(r102, r103.length - 1);
        String r106 = " ";
    L3:
        if (r104 > r105) goto L5;
        StackTraceElement r107 = r103[r104];
        StringBuilder r108 = new StringBuilder(".(");
        r108.append(r103[r104].getFileName());
        r108.append(":");
        r108.append(r103[r104].getLineNumber());
        r108.append(") ");
        r108.append(r103[r104].getMethodName());
        r106 = r106 + " ";
        r104 = r104 + 1;
        goto L3
    }
}
