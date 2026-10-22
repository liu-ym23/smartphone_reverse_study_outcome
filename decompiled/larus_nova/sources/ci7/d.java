package ci7;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static ClipData b(Context r110) {
        ClipData r100 = null;
        if (ki7.c.b(l.a()) == true) goto L101;
        boolean r101 = true;
        if (r110 != null) goto L99;
        Pair<Boolean, ClipData> r102 = new Pair(Boolean.TRUE, null);
    L104:
        StringBuilder r103 = new StringBuilder("start to get clipboard data : ");     // Catch: Exception -> L67
        r103.append(r102.first);     // Catch: Exception -> L67
        r103.append(" ,cache clip data: ");     // Catch: Exception -> L67
        if (r102.second != null) goto L59;
        boolean r104 = true;
    L60:
        r103.append(r104);     // Catch: Exception -> L67
        mi7.i r105 = new mi7.i("clipboard_invoke", r103.toString(), null, mi7.m.f514108a);     // Catch: Exception -> L67
        IExecutor r106 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L67
        if (r106 != null) goto L106;
    L103:
        goto L69
    L106:
        r106.executeWithSingleThread(r105);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L67
        goto L103
    L59:
        r104 = false;
    L69:
        if (((Boolean) r102.first).booleanValue() == false) goto L97;
        ZlinkDependAbility r107 = p.f23879a;
        if (r107 != null) goto L73;
        boolean r108 = false;
    L75:
        if (r108 == false) goto L81;
        hi7.a r111 = (hi7.a) z.a(hi7.a.class);
        if (r111 == null) goto L80;
        mi7.c.a("zlink_get_clipboard", new JSONObject());
        return r111.a();
    L80:
        return null;
    L81:
        ClipboardManager r112 = g.g(r110);
        if (r112 != null) goto L109;
    L95:
        return r100;
    L109:
        f.f23862a = true;     // Catch: Throwable -> L93
        hi7.b r109 = (hi7.b) z.a(hi7.b.class);     // Catch: Throwable -> L93
        StringBuilder r113 = new StringBuilder("getClipBoardContent, compliance == null? ");     // Catch: Throwable -> L93
        if (r109 == null) goto L88;
        r101 = false;
    L88:
        r113.append(r101);     // Catch: Throwable -> L93
        mi7.e.a("ClipboardUtils", r113.toString());     // Catch: Throwable -> L93
        mi7.c.a("zlink_get_clipboard", new JSONObject());     // Catch: Throwable -> L93
        if (r109 == null) goto L91;
        r100 = r109.b();     // Catch: Throwable -> L93
    L108:
        goto L95
    L91:
        r100 = g.c(r112);     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        th.printStackTrace();
        goto L95
    L73:
        r108 = r107.getEnableClipboardOutside();
        goto L75
    L97:
        return (ClipData) r102.second;
    L99:
        ClipboardManager r114 = g.g(r110);     // Catch: Exception -> L54
        if (r114 != null) goto L18;
        r102 = g.h(r110);     // Catch: Exception -> L54
        goto L104
    L18:
        if (g.e(r114) == true) goto L20;
        e.a(r110);     // Catch: Exception -> L54
        r102 = new Pair(Boolean.FALSE, null);     // Catch: Exception -> L54
        goto L104
    L20:
        if (Build.VERSION.SDK_INT < 26) goto L48;
        ClipDescription r115 = g.d(r114);     // Catch: Exception -> L54
        if (r115 != null) goto L24;
        r102 = g.h(r110);     // Catch: Exception -> L54
        goto L104
    L24:
        long r116 = r115.getTimestamp();     // Catch: Exception -> L54
        int r117 = e.f23861a;     // Catch: Exception -> L54
        mi7.g.a(r110).getClass();     // Catch: Exception -> L54
        if (mi7.g.f514094a != null) goto L28;
    L30:
        long r118 = 0;
    L32:
        if (r116 != r118) goto L43;
        mi7.g.a(r110).getClass();     // Catch: Exception -> L54
        String r119 = "";
        if (mi7.g.f514094a == null) goto L39;
        if (TextUtils.isEmpty("KEY_LAST_CB_D_EEROR_TTCB_CONTENT") == true) goto L39;
        r119 = mi7.g.f514094a.getString("KEY_LAST_CB_D_EEROR_TTCB_CONTENT", "");     // Catch: Exception -> L54
    L39:
        if (r119.isEmpty() == true) goto L41;
        ClipData r120 = ClipData.newPlainText("ttcb", r119);     // Catch: Exception -> L54
    L42:
        boolean r121 = false;
    L49:
        if (r121 == false) goto L51;
        e.a(r110);     // Catch: Exception -> L54
    L51:
        r102 = new Pair(Boolean.valueOf(r121), r120);     // Catch: Exception -> L54
        goto L104
    L41:
        r120 = null;
        goto L42
    L43:
        mi7.g.a(r110).getClass();     // Catch: Exception -> L54
        if (mi7.g.f514094a == null) goto L48;
        if (TextUtils.isEmpty("KEY_LAST_CLIPBOARD_TIME_STAMP") == true) goto L48;
        SharedPreferences.Editor r122 = mi7.g.f514094a.edit();     // Catch: Exception -> L54
        r122.putLong("KEY_LAST_CLIPBOARD_TIME_STAMP", r116);     // Catch: Exception -> L54
        r122.apply();     // Catch: Exception -> L54
        goto L48
    L28:
        if (TextUtils.isEmpty("KEY_LAST_CLIPBOARD_TIME_STAMP") == true) goto L30;
        r118 = mi7.g.f514094a.getLong("KEY_LAST_CLIPBOARD_TIME_STAMP", -1);     // Catch: Exception -> L54
    L48:
        r120 = null;
        r121 = true;
    L54:
        r102 = g.h(r110);
        goto L104
    L101:
        mi7.j r123 = new mi7.j("clipboard_invoke", "forbid to check clipboard", new JSONObject(), mi7.m.f514108a);     // Catch: Exception -> L98
        IExecutor r124 = (IExecutor) z.a(IExecutor.class);     // Catch: Exception -> L98
        if (r124 != null) goto L111;
    L100:
        goto L10
    L111:
        r124.executeWithSingleThread(r123);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L98
    L10:
        return null;
    }

    public static void a(Context r100, String r101, ClipData r102) {
        if (ki7.c.b(r100) == false) goto L5;
        return;
    L5:
        ZlinkDependAbility r103 = p.f23879a;
        if (r103 != null) goto L8;
        boolean r104 = false;
    L9:
        if (r104 == false) goto L13;
        hi7.a r105 = (hi7.a) z.a(hi7.a.class);
        if (r105 == null) goto L15;
        r105.c(r100, r101, r102);
        return;
    L15:
        return;
    L13:
        g.a(r100, r101, r102);
        return;
    L8:
        r104 = r103.getEnableClipboardOutside();
        goto L9
    }
}
