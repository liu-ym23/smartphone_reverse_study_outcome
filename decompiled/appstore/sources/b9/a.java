package b9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f5944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f5945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f5946c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f5947d = null;

    static {
        f5944a = new boolean[]{false, false, false, false};
        f5945b = new ArrayList();
        f5946c = Arrays.asList(new Integer[]{21, 10003, 10004});
        f5947d = Arrays.asList(new Integer[]{21, 10003});
    }

    public static boolean a(JSONObject r10) {
        boolean[] r11 = new boolean[4];
        c(r11, r10, "dline", f5944a);
        return r11[3];
    }

    public static boolean b(JSONObject r10) {
        boolean[] r11 = new boolean[4];
        c(r11, r10, "dline", f5944a);
        return r11[1];
    }

    public static void c(boolean[] r10, JSONObject r11, String r12, boolean[] r13) {
        if (r11 == null) goto L15;
        JSONArray r14 = r11.optJSONArray(r12);
        if (r14 == null) goto L15;
        int r15 = Math.min(r10.length, r11.length());
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L14;
        boolean r17 = true;
        if (r14.optInt(r16) == 1) goto L13;
        r17 = false;
    L13:
        r10[r16] = r17;
        r16 = r16 + 1;
        goto L8
    L14:
        return;
    L15:
        System.arraycopy(r13, 0, r10, 0, Math.max(r10.length, r13.length));
    }
}
