package f2;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/* renamed from: f2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0702g {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f16790a = ThreadLocal.withInitial(new Supplier() { // from class: f2.f
        @Override // java.util.function.Supplier
        public final Object get() {
            return C0702g.a();
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static a f16791b;

    /* renamed from: f2.g$a */
    public interface a {
        boolean a(String str, int i5);
    }

    private static void A(String str, String str2, int i5) {
        switch (i5) {
            case 2:
                Log.v(str, str2);
                break;
            case 3:
                Log.d(str, str2);
                break;
            case 4:
                Log.i(str, str2);
                break;
            case 5:
                Log.w(str, str2);
                break;
            case 6:
            case 7:
                Log.e(str, str2);
                break;
        }
    }

    private static void B(String str, String str2, int i5) {
        int i6 = 0;
        while (i6 < str2.length()) {
            int iMin = Math.min(i6 + 3000, str2.length());
            A(str, str2.substring(i6, iMin), i5);
            i6 = iMin;
        }
    }

    private static void C(String str, String str2, int i5) {
        if (str2.length() <= 3000) {
            A(str, str2, i5);
        } else if (str2.length() >= 3000000) {
            B(str, str2.substring(0, 3000000), i5);
        } else {
            B(str, str2, i5);
        }
    }

    public static void D(String str, int i5) {
        try {
            I(str, i5, '<', 64);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void E(String str, int i5) {
        try {
            I(str, i5, '>', 64);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void F(String str, int i5) {
        try {
            I(str, i5, '$', 64);
            G(str, i5);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void G(String str, int i5) {
        try {
            if (d(str, i5)) {
                A(str, "\n", i5);
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static String H(UsageEvents.Event event, boolean z5) {
        try {
            return "time:" + t(event.getTimeStamp(), z5) + "| type:" + u(s(event.getEventType())) + "|\tpackage:" + u(event.getPackageName()) + "|\tclass:" + event.getClassName() + ";";
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static void I(String str, int i5, char c6, int i6) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append(c6);
            }
            if (d(str, i5)) {
                A(str, sb.toString(), i5);
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void J(String str, int i5, Object obj) {
        try {
            if (d(str, i5)) {
                A(str, " Result = " + obj, i5);
                D(str, i5);
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void K(String str, int i5) {
        try {
            I(str, i5, '*', 64);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void L(a aVar) {
        f16791b = aVar;
    }

    public static void M(String str, String str2) {
        N(str, str2, true);
    }

    public static void N(String str, String str2, boolean z5) {
        try {
            if (d(str, 2)) {
                if (z5) {
                    C(str, str2, 2);
                } else {
                    Log.v(str, str2);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void O(String str, String str2) {
        P(str, str2, true);
    }

    public static void P(String str, String str2, boolean z5) {
        try {
            if (d(str, 5)) {
                if (z5) {
                    C(str, str2, 5);
                } else {
                    Log.w(str, str2);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static /* synthetic */ SimpleDateFormat a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static void b(String str, String str2) {
        c(str, str2, true);
    }

    public static void c(String str, String str2, boolean z5) {
        try {
            if (d(str, 3)) {
                if (z5) {
                    C(str, str2, 3);
                } else {
                    Log.d(str, str2);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static boolean d(String str, int i5) {
        a aVar = f16791b;
        if (aVar == null) {
            return false;
        }
        return aVar.a(str, i5);
    }

    public static String e(float[] fArr) {
        StringBuilder sb = new StringBuilder();
        if (fArr == null || fArr.length == 0) {
            sb.append("empty");
            return sb.toString();
        }
        int length = fArr.length;
        if (length == 1) {
            sb.append("{");
            sb.append("[");
            sb.append(fArr[0]);
            sb.append("]");
            sb.append("}");
            return sb.toString();
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (i5 == 0) {
                sb.append("{");
                sb.append("[");
                sb.append(fArr[i5]);
                sb.append("]");
                sb.append(",");
            } else if (i5 == length - 1) {
                sb.append("[");
                sb.append(fArr[i5]);
                sb.append("]");
                sb.append("}");
            } else {
                sb.append("[");
                sb.append(fArr[i5]);
                sb.append("]");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String f(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr == null || iArr.length == 0) {
            sb.append("empty");
            return sb.toString();
        }
        int length = iArr.length;
        if (length == 1) {
            sb.append("{");
            sb.append("[");
            sb.append(iArr[0]);
            sb.append("]");
            sb.append("}");
            return sb.toString();
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (i5 == 0) {
                sb.append("{");
                sb.append("[");
                sb.append(iArr[i5]);
                sb.append("]");
                sb.append(",");
            } else if (i5 == length - 1) {
                sb.append("[");
                sb.append(iArr[i5]);
                sb.append("]");
                sb.append("}");
            } else {
                sb.append("[");
                sb.append(iArr[i5]);
                sb.append("]");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String g(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        if (jArr == null || jArr.length == 0) {
            sb.append("empty");
            return sb.toString();
        }
        int length = jArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            long j5 = jArr[i5];
            if (i5 == 0 && i5 == length - 1) {
                sb.append("{");
                sb.append("[");
                sb.append(j5);
                sb.append("]");
                sb.append("}");
            } else if (i5 == 0) {
                sb.append("{");
                sb.append("[");
                sb.append(j5);
                sb.append("]");
                sb.append(",");
            } else if (i5 == length - 1) {
                sb.append("[");
                sb.append(j5);
                sb.append("]");
                sb.append("}");
            } else {
                sb.append("[");
                sb.append(j5);
                sb.append("]");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static <T> String h(T[] tArr) {
        StringBuilder sb = new StringBuilder();
        if (tArr == null || tArr.length == 0) {
            sb.append("empty");
            return sb.toString();
        }
        int length = tArr.length;
        if (length == 1) {
            sb.append("{");
            sb.append("[");
            sb.append(tArr[0]);
            sb.append("]");
            sb.append("}");
            return sb.toString();
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (i5 == 0) {
                sb.append("{");
                sb.append("[");
                sb.append(tArr[i5]);
                sb.append("]");
                sb.append(",");
            } else if (i5 == length - 1) {
                sb.append("[");
                sb.append(tArr[i5]);
                sb.append("]");
                sb.append("}");
            } else {
                sb.append("[");
                sb.append(tArr[i5]);
                sb.append("]");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String i(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Set<String> setKeySet = bundle.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle{ ");
        for (String str : setKeySet) {
            sb.append("<" + str + ":");
            Object obj = bundle.get(str);
            sb.append((obj instanceof Map ? m((Map) obj) : obj instanceof List ? k((List) obj) : obj instanceof int[] ? f((int[]) obj) : obj instanceof long[] ? g((long[]) obj) : obj instanceof Object[] ? h((Object[]) obj) : obj instanceof Bundle ? i((Bundle) obj) : obj == null ? "null" : obj.toString()) + ">; ");
        }
        sb.append(" }");
        return sb.toString();
    }

    public static String j(Intent intent) {
        if (intent == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Intent { action = " + intent.getAction() + " ");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            sb.append(i(extras));
        }
        sb.append(" }");
        return sb.toString();
    }

    public static <T> String k(List<T> list) {
        StringBuilder sb = new StringBuilder();
        if (list == null || list.isEmpty()) {
            sb.append("empty");
            return sb.toString();
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            T t5 = list.get(i5);
            if (i5 == 0) {
                sb.append(t5 != null ? t5.toString() : "null");
            } else {
                sb.append(" # ");
                sb.append(t5 != null ? t5.toString() : "null");
            }
        }
        return sb.toString();
    }

    public static <T> String l(Set<T> set) {
        StringBuilder sb = new StringBuilder();
        if (set == null || set.isEmpty()) {
            sb.append("empty");
            return sb.toString();
        }
        Iterator<T> it = set.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            T next = it.next();
            if (i5 == 0) {
                sb.append(next != null ? next.toString() : "null");
            } else {
                sb.append(" # ");
                sb.append(next != null ? next.toString() : "null");
            }
            i5++;
        }
        return sb.toString();
    }

    public static <K, V> String m(Map<K, V> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null || map.isEmpty()) {
            sb.append("empty");
            return sb.toString();
        }
        int i5 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            String string = key == null ? "empty" : key.toString();
            V value = entry.getValue();
            String string2 = value == null ? "empty" : value.toString();
            if (i5 == 0) {
                sb.append(string);
                sb.append(":");
                sb.append(string2);
            } else {
                sb.append(" # ");
                sb.append(string);
                sb.append(":");
                sb.append(string2);
            }
            i5++;
        }
        return sb.toString();
    }

    public static void n(String str, int i5) {
        if (d(str, i5)) {
            A(str, w(), i5);
        }
    }

    public static String o(Throwable th) {
        if (th == null) {
            return null;
        }
        return th + "\n" + x(th);
    }

    public static void p(String str, String str2) {
        q(str, str2, true);
    }

    public static void q(String str, String str2, boolean z5) {
        try {
            if (d(str, 6)) {
                if (z5) {
                    C(str, str2, 6);
                } else {
                    Log.e(str, str2);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    public static void r(String str, Throwable th) {
        try {
            if (d(str, 6)) {
                A(str, o(th), 6);
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }

    private static String s(int i5) {
        switch (i5) {
            case 0:
                return "NONE";
            case 1:
                return "ACTIVITY_RESUMED";
            case 2:
                return "ACTIVITY_PAUSED";
            case 3:
                return "END_OF_DAY";
            case 4:
                return "CONTINUE_PREVIOUS_DAY";
            case 5:
                return "CONFIGURATION_CHANGE";
            case 6:
                return "SYSTEM_INTERACTION";
            case 7:
                return "USER_INTERACTION";
            case 8:
                return "SHORTCUT_INVOCATION";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return "CHOOSER_ACTION";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return "NOTIFICATION_SEEN";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return "STANDBY_BUCKET_CHANGED";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return "NOTIFICATION_INTERRUPTION";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return "SLICE_PINNED_PRIV";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return "SLICE_PINNED";
            case 15:
                return "SCREEN_INTERACTIVE";
            case 16:
                return "SCREEN_NON_INTERACTIVE";
            case 17:
                return "KEYGUARD_SHOWN";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                return "KEYGUARD_HIDDEN";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                return "FOREGROUND_SERVICE_START";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return "FOREGROUND_SERVICE_STOP";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return "CONTINUING_FOREGROUND_SERVICE";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return "ROLLOVER_FOREGROUND_SERVICE";
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return "ACTIVITY_STOPPED";
            case 24:
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
            default:
                return "UNKNOWN_TYPE_" + i5;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                return "DEVICE_SHUTDOWN";
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                return "DEVICE_STARTUP";
            case 28:
                return "USER_UNLOCKED";
            case 29:
                return "USER_STOPPED";
            case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                return "LOCUS_ID_SET";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                return "APP_COMPONENT_USED";
        }
    }

    public static String t(long j5, boolean z5) {
        if (!z5) {
            return Long.toString(j5);
        }
        return "\"" + f16790a.get().format(Long.valueOf(j5)) + "\"";
    }

    private static String u(String str) {
        return v(str, 32);
    }

    private static String v(String str, int i5) {
        return String.format("%1$-" + i5 + "s", str);
    }

    public static String w() {
        return Log.getStackTraceString(new Exception("dump stack"));
    }

    public static String x(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void y(String str, String str2) {
        z(str, str2, true);
    }

    public static void z(String str, String str2, boolean z5) {
        try {
            if (d(str, 4)) {
                if (z5) {
                    C(str, str2, 4);
                } else {
                    Log.i(str, str2);
                }
            }
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        }
    }
}
