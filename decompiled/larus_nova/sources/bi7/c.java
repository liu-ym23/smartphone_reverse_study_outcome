package bi7;

import android.app.Application;
import android.content.ClipData;
import android.text.TextUtils;
import ci7.k;
import ci7.l;
import ci7.s;
import ci7.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mi7.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f19145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, s> f19146b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f19147a = null;

        static {
            f19147a = new c(l.a());
        }
    }

    public c(Application r100) {
        HashMap r101 = new HashMap();
        this.f19146b = r101;
        this.f19145a = r100;
        r101.put("scheme", h.g());
        ConcurrentHashMap<Class<?>, di7.d> r102 = w.f23890a;
        ei7.b r103 = (ei7.b) w.b(ei7.b.class);
        if (r103 == null) goto L6;
        r101.put("fission", r103.b());
        return;
    }

    public static List b(ClipData r100) {
        if (r100 == null) goto L16;
        if (r100.getItemCount() <= 0) goto L16;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L7:
        if (r102 >= r100.getItemCount()) goto L14;
        ClipData.Item r103 = r100.getItemAt(r102);
        if (r103 == null) goto L13;
        if (TextUtils.isEmpty(r103.getText()) == true) goto L13;
        r101.add(r103.getText().toString());
    L13:
        r102 = r102 + 1;
        goto L7
    L14:
        return r101;
    L16:
        return Collections.emptyList();
    }

    public final boolean a(ClipData r100) {
        List r101 = b(r100);
        if (mi7.a.a(r101) == false) goto L6;
        mi7.h.f(new mi7.l());
        k.b.f23870a.a(l.a(), "");
        fi7.d.a("", "", r100, false);
        return false;
    L6:
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        String r103 = (String) r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L15;
        s r104 = (s) ((HashMap) this.f19146b).get("scheme");
        if (r104 == null) goto L15;
        boolean r105 = r104.b(this.f19145a, r103, r100);
    L16:
        if (r105 == false) goto L8;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L24;
        k.b.f23870a.a(l.a(), "");
        fi7.d.a("", "", null, false);
    L24:
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L23
        r107.put("is_match", r106);     // Catch: Exception -> L23
        mi7.k.c("check clipboard end", "clipboard_invoke", r107, m.f514108a);     // Catch: Exception -> L23
    L22:
        return r106;
    L15:
        r105 = false;
        goto L16
    L18:
        r106 = false;
        goto L19
    }
}
