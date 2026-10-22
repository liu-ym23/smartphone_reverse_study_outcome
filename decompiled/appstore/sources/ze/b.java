package ze;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static void a(Bundle r10, StringBuilder r11) {
        Iterator<String> r12 = r10.keySet().iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L46;
        String r14 = r12.next();
        if (r13 == true) goto L8;
        r11.append(", ");
    L8:
        r11.append(r14);
        r11.append('=');
        Object r15 = r10.get(r14);
        if ((r15 instanceof int[]) == false) goto L12;
        r11.append(Arrays.toString((int[]) r15));
    L45:
        r13 = false;
        goto L4
    L12:
        if ((r15 instanceof byte[]) == false) goto L18;
        byte[] r16 = (byte[]) r15;
        if (r16.length >= 102400) goto L16;
        r11.append(Arrays.toString(r16));
        goto L45
    L16:
        r11.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r15 instanceof boolean[]) == false) goto L21;
        r11.append(Arrays.toString((boolean[]) r15));
        goto L45
    L21:
        if ((r15 instanceof short[]) == false) goto L24;
        r11.append(Arrays.toString((short[]) r15));
        goto L45
    L24:
        if ((r15 instanceof long[]) == false) goto L27;
        r11.append(Arrays.toString((long[]) r15));
        goto L45
    L27:
        if ((r15 instanceof float[]) == false) goto L30;
        r11.append(Arrays.toString((float[]) r15));
        goto L45
    L30:
        if ((r15 instanceof double[]) == false) goto L33;
        r11.append(Arrays.toString((double[]) r15));
        goto L45
    L33:
        if ((r15 instanceof String[]) == false) goto L36;
        r11.append(Arrays.toString((String[]) r15));
        goto L45
    L36:
        if ((r15 instanceof CharSequence[]) == false) goto L39;
        r11.append(Arrays.toString((CharSequence[]) r15));
        goto L45
    L39:
        if ((r15 instanceof Parcelable[]) == false) goto L42;
        r11.append(Arrays.toString((Parcelable[]) r15));
        goto L45
    L42:
        if ((r15 instanceof Bundle) == false) goto L44;
        r11.append(b((Bundle) r15));
        goto L45
    L44:
        r11.append(r15);
        goto L45
    }

    public static String b(Bundle r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r11 = new StringBuilder(128);
        r11.append("Bundle[{");
        a(r10, r11);
        r11.append("}]");
        return r11.toString();
    }

    public static void c(Intent r10, StringBuilder r11) {
        String r12 = r10.getAction();
        boolean r13 = false;
        boolean r14 = true;
        if (r12 == null) goto L5;
        r11.append("act=");
        r11.append(r12);
        boolean r15 = false;
    L6:
        Set<String> r16 = r10.getCategories();
        if (r16 == null) goto L18;
        if (r15 == true) goto L10;
        r11.append(TokenParser.SP);
    L10:
        r11.append("cat=[");
        Iterator<String> r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L17;
        String r18 = r17.next();
        if (r14 == true) goto L16;
        r11.append(',');
    L16:
        r11.append(r18);
        r14 = false;
        goto L12
    L17:
        r11.append("]");
        r15 = false;
    L18:
        Uri r19 = r10.getData();
        if (r19 == null) goto L23;
        if (r15 == true) goto L22;
        r11.append(TokenParser.SP);
    L22:
        r11.append("dat=");
        r11.append(e(r19));
        r15 = false;
    L23:
        String r20 = r10.getType();
        if (r20 == null) goto L28;
        if (r15 == true) goto L27;
        r11.append(TokenParser.SP);
    L27:
        r11.append("typ=");
        r11.append(r20);
        r15 = false;
    L28:
        int r21 = r10.getFlags();
        if (r21 == 0) goto L33;
        if (r15 == true) goto L32;
        r11.append(TokenParser.SP);
    L32:
        r11.append("flg=0x");
        r11.append(Integer.toHexString(r21));
        r15 = false;
    L33:
        String r22 = r10.getPackage();
        if (r22 == null) goto L38;
        if (r15 == true) goto L37;
        r11.append(TokenParser.SP);
    L37:
        r11.append("pkg=");
        r11.append(r22);
        r15 = false;
    L38:
        ComponentName r23 = r10.getComponent();
        if (r23 == null) goto L43;
        if (r15 == true) goto L42;
        r11.append(TokenParser.SP);
    L42:
        r11.append("cmp=");
        r11.append(r23.flattenToShortString());
        r15 = false;
    L43:
        Rect r24 = r10.getSourceBounds();
        if (r24 == null) goto L49;
        if (r15 == true) goto L47;
        r11.append(TokenParser.SP);
    L47:
        r11.append("bnds=");
        r11.append(r24.toShortString());
        r15 = false;
    L49:
        if (r10.getClipData() == null) goto L53;
        if (r15 == true) goto L52;
        r11.append(TokenParser.SP);
    L52:
        r11.append("(has clip)");
    L54:
        Bundle r25 = r10.getExtras();
        if (r25 == null) goto L59;
        if (r13 == true) goto L58;
        r11.append(TokenParser.SP);
    L58:
        r11.append("extras={");
        a(r25, r11);
        r11.append('}');
    L59:
        Intent r26 = r10.getSelector();
        if (r26 == null) goto L66;
        r11.append(" sel=");
        c(r26, r11);
        r11.append("}");
        return;
    L66:
        return;
    L53:
        r13 = r15;
        goto L54
    L5:
        r15 = true;
        goto L6
    }

    public static String d(Intent r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r11 = new StringBuilder(128);
        r11.append("Intent { ");
        c(r10, r11);
        r11.append(" }");
        return r11.toString();
    }

    public static String e(Uri r10) {
        Method r11 = Uri.class.getDeclaredMethod("toSafeString", null);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L4 InvocationTargetException -> L6 NoSuchMethodException -> L8
        return (String) r11.invoke(r10, null);
    L4:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r10.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
