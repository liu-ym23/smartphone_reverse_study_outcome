package bo7;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import oo7.k;
import oo7.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f19869a;

    /* JADX INFO: renamed from: bo7.a$a, reason: collision with other inner class name */
    public static class C0322a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f19870a = null;

        static {
            f19870a = new a();
        }
    }

    public a() {
        this.f19869a = m.a();
    }

    public final LinkedHashMap<String, Boolean> a(String r100) {
        String r101 = this.f19869a.b(r100, "");
        LinkedHashMap<String, Boolean> r102 = new LinkedHashMap();
        if (TextUtils.isEmpty(r101) == false) goto L18;
        return r102;
    L18:
        JSONArray r103 = new JSONArray(r101);     // Catch: Throwable -> L17
        int r104 = 0;
    L7:
        if (r104 >= r103.length()) goto L16;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r103, r104);     // Catch: Throwable -> L17
        JSONArray r106 = r105.names();     // Catch: Throwable -> L17
        if (r106 == null) goto L15;
        int r107 = 0;
    L12:
        if (r107 >= r106.length()) goto L15;
        String r108 = JSONArrayProtectorUtils.getString(r106, r107);     // Catch: Throwable -> L17
        r102.put(r108, Boolean.valueOf(JSONObjectProtectorUtils.getBoolean(r105, r108)));     // Catch: Throwable -> L17
        r107 = r107 + 1;
    L15:
        r104 = r104 + 1;
    L16:
        return r102;
    }

    public final void b(String r100, boolean r101) {
        k.a("ShareCacheManager", "updateSaveAlbumMediaCache : " + r100 + " valid is " + r101);
        LinkedHashMap<String, Boolean> r102 = a("hidden_image_path_list");     // Catch: Throwable -> L19
        if (r102.containsKey(r100) == true) goto L6;
    L8:
        r102.put(r100, Boolean.valueOf(r101));     // Catch: Throwable -> L19
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L19
        Iterator<Map.Entry<String, Boolean>> r104 = r102.entrySet().iterator();     // Catch: Throwable -> L19
        if (r102.size() > 20) goto L11;
    L13:
        Iterator<Map.Entry<String, Boolean>> r105 = r102.entrySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, Boolean> r106 = r105.next();     // Catch: Throwable -> L19
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L19
        r107.put(r106.getKey(), r106.getValue());     // Catch: Throwable -> L19
        r103.put(r107);     // Catch: Throwable -> L19
        goto L15
    L17:
        this.f19869a.c("hidden_image_path_list", r103.toString());     // Catch: Throwable -> L19
        return;
    L11:
        if (r104.hasNext() == false) goto L13;
        r102.remove(r104.next().getKey());     // Catch: Throwable -> L19
        goto L13
    L6:
        if (r102.get(r100).booleanValue() != r101) goto L8;
        return;
    L19:
        th = move-exception;
        k.c("ShareCacheManager", "updateSaveAlbumMediaCache : " + th.toString());
    }
}
