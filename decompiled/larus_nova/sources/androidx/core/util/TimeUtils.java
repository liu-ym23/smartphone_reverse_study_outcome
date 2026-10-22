package androidx.core.util;

import com.baidu.mapapi.http.HttpClient;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes17.dex */
public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync = null;

    private TimeUtils() {
    }

    private static int accumField(int r100, int r101, boolean r102, int r103) {
        if (r100 > 99) goto L22;
        if (r102 == false) goto L8;
        if (r103 >= 3) goto L22;
    L8:
        if (r100 > 9) goto L20;
        if (r102 == false) goto L12;
        if (r103 >= 2) goto L20;
    L12:
        if (r102 == true) goto L18;
        if (r100 > 0) goto L18;
        return 0;
    L18:
        return r101 + 1;
    L20:
        return r101 + 2;
    L22:
        return r101 + 3;
    }

    static {
        sFormatSync = new Object();
        sFormatStr = new char[24];
    }

    public static void formatDuration(long r100, StringBuilder r101) {
        Object r102 = sFormatSync;
        monitor-enter(r102);
        int r103 = formatDurationLocked(r100, 0);     // Catch: Throwable -> L8
        r101.append(sFormatStr, 0, r103);     // Catch: Throwable -> L8
        monitor-exit(r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static int formatDurationLocked(long r110, int r111) {
        long r100 = r110;
        if (sFormatStr.length >= r111) goto L5;
        sFormatStr = new char[r111];
    L5:
        char[] r101 = sFormatStr;
        if (r100 != 0) goto L12;
        int r102 = r111 - 1;
    L8:
        if (r102 <= 0) goto L10;
        r101[0] = ' ';
        goto L8
    L10:
        r101[0] = '0';
        return 1;
    L12:
        if (r100 <= 0) goto L14;
        char r103 = '+';
    L15:
        int r112 = (int) (r100 % 1000);
        int r104 = (int) Math.floor(r100 / 1000);
        if (r104 <= 86400) goto L18;
        int r105 = r104 / 86400;
        r104 = r104 - (86400 * r105);
    L20:
        if (r104 <= 3600) goto L22;
        int r106 = r104 / 3600;
        r104 = r104 - (r106 * 3600);
    L24:
        if (r104 <= 60) goto L26;
        int r107 = r104 / 60;
        int r113 = r104 - (r107 * 60);
        int r108 = r107;
    L28:
        if (r111 == 0) goto L48;
        int r109 = accumField(r105, 1, false, 0);
        if (r109 <= 0) goto L32;
        boolean r114 = true;
    L33:
        int r115 = r109 + accumField(r106, 1, r114, 2);
        if (r115 <= 0) goto L36;
        boolean r116 = true;
    L37:
        int r117 = r115 + accumField(r108, 1, r116, 2);
        if (r117 <= 0) goto L40;
        boolean r118 = true;
    L41:
        int r119 = r117 + accumField(r113, 1, r118, 2);
        if (r119 <= 0) goto L44;
        int r120 = 3;
    L45:
        int r121 = r119 + (accumField(r112, 2, true, r120) + 1);
        int r122 = 0;
    L46:
        if (r121 >= r111) goto L49;
        r101[r122] = ' ';
        r122 = r122 + 1;
        r121 = r121 + 1;
    L49:
        r101[r122] = r103;
        int r123 = r122 + 1;
        if (r111 == 0) goto L52;
        boolean r124 = true;
    L53:
        int r125 = printField(r101, r105, Directory.UNIX_ID, r123, false, 0);
        if (r125 == r123) goto L56;
        boolean r126 = true;
    L57:
        if (r124 == false) goto L59;
        int r127 = 2;
    L60:
        int r128 = printField(r101, r106, 'h', r125, r126, r127);
        if (r128 == r123) goto L63;
        boolean r129 = true;
    L64:
        if (r124 == false) goto L66;
        int r130 = 2;
    L67:
        int r131 = printField(r101, r108, 'm', r128, r129, r130);
        if (r131 == r123) goto L70;
        boolean r132 = true;
    L71:
        if (r124 == false) goto L73;
        int r133 = 2;
    L74:
        int r134 = printField(r101, r113, 's', r131, r132, r133);
        if (r124 == false) goto L78;
        if (r134 == r123) goto L78;
        int r135 = 3;
    L79:
        int r136 = printField(r101, r112, 'm', r134, true, r135);
        r101[r136] = 's';
        return r136 + 1;
    L78:
        r135 = 0;
        goto L79
    L73:
        r133 = 0;
        goto L74
    L70:
        r132 = false;
        goto L71
    L66:
        r130 = 0;
        goto L67
    L63:
        r129 = false;
        goto L64
    L59:
        r127 = 0;
        goto L60
    L56:
        r126 = false;
        goto L57
    L52:
        r124 = false;
        goto L53
    L44:
        r120 = 0;
        goto L45
    L40:
        r118 = false;
        goto L41
    L36:
        r116 = false;
        goto L37
    L32:
        r114 = false;
        goto L33
    L48:
        r122 = 0;
        goto L49
    L26:
        r113 = r104;
        r108 = 0;
        goto L28
    L22:
        r106 = 0;
        goto L24
    L18:
        r105 = 0;
        goto L20
    L14:
        r100 = -r100;
        r103 = '-';
        goto L15
    }

    public static void formatDuration(long r100, PrintWriter r101) {
        formatDuration(r100, r101, 0);
    }

    public static void formatDuration(long r100, PrintWriter r101, int r102) {
        Object r103 = sFormatSync;
        monitor-enter(r103);
        int r104 = formatDurationLocked(r100, r102);     // Catch: Throwable -> L7
        r101.print(new String(sFormatStr, 0, r104));     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void formatDuration(long r100, long r101, PrintWriter r102) {
        if (r100 != 0) goto L6;
        r102.print(HttpClient.ENDFLAG);
        return;
    L6:
        formatDuration(r100 - r101, r102, 0);
    }

    private static int printField(char[] r100, int r101, char r102, int r103, boolean r104, int r105) {
        if (r104 == true) goto L4;
        if (r101 > 0) goto L4;
        return r103;
    L4:
        if (r104 == false) goto L8;
        if (r105 < 3) goto L8;
    L9:
        int r106 = r101 / 100;
        r100[r103] = (char) (r106 + 48);
        int r107 = r103 + 1;
        r101 = r101 - (r106 * 100);
    L11:
        if (r104 == false) goto L15;
        if (r105 < 2) goto L15;
    L17:
        int r108 = r101 / 10;
        r100[r107] = (char) (r108 + 48);
        r107 = r107 + 1;
        r101 = r101 - (r108 * 10);
    L18:
        r100[r107] = (char) (r101 + 48);
        int r109 = r107 + 1;
        r100[r109] = r102;
        return r109 + 1;
    L15:
        if (r101 > 9) goto L17;
        if (r103 == r107) goto L18;
    L8:
        if (r101 > 99) goto L9;
        r107 = r103;
        goto L11
    }
}
