package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.favorite.NAFavorite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f7954a;

    /* renamed from: b, reason: collision with root package name */
    private NAFavorite f7955b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7956c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7957d = false;

    /* renamed from: e, reason: collision with root package name */
    private Vector<String> f7958e = null;

    /* renamed from: f, reason: collision with root package name */
    private Vector<String> f7959f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7960g = false;

    /* renamed from: h, reason: collision with root package name */
    private d f7961h;

    /* renamed from: i, reason: collision with root package name */
    private c f7962i;

    public class b implements Comparator<String> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        private long f7964a;

        /* renamed from: b, reason: collision with root package name */
        private long f7965b;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            return this.f7965b - this.f7964a > 1000;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f7965b = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.f7964a = System.currentTimeMillis();
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        private String f7967a;

        /* renamed from: b, reason: collision with root package name */
        private long f7968b;

        /* renamed from: c, reason: collision with root package name */
        private long f7969c;

        private d() {
            this.f7968b = 5000L;
            this.f7969c = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return TextUtils.isEmpty(this.f7967a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f7967a = str;
            this.f7969c = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f7967a;
        }
    }

    private a() {
        this.f7961h = new d();
        this.f7962i = new c();
    }

    public static a f() {
        if (f7954a == null) {
            synchronized (a.class) {
                try {
                    if (f7954a == null) {
                        a aVar = new a();
                        f7954a = aVar;
                        aVar.g();
                    }
                } finally {
                }
            }
        }
        return f7954a;
    }

    private boolean g() {
        if (this.f7955b == null) {
            NAFavorite nAFavorite = new NAFavorite();
            this.f7955b = nAFavorite;
            if (nAFavorite.b() == 0) {
                this.f7955b = null;
                return false;
            }
            h();
            i();
        }
        return true;
    }

    private void h() {
        this.f7956c = false;
        this.f7957d = false;
    }

    private boolean i() {
        if (this.f7955b == null) {
            return false;
        }
        String str = SysOSUtil.getModuleFileName() + "/";
        this.f7955b.a(1);
        return this.f7955b.a(str, "fav_poi", "fifo", 10, 501, -1);
    }

    public static boolean j() {
        NAFavorite nAFavorite;
        a aVar = f7954a;
        return (aVar == null || (nAFavorite = aVar.f7955b) == null || !nAFavorite.d()) ? false : true;
    }

    public synchronized int a(String str, FavSyncPoi favSyncPoi) {
        if (this.f7955b == null) {
            return 0;
        }
        if (str != null && !str.equals("") && favSyncPoi != null) {
            h();
            ArrayList<String> arrayListD = d();
            if ((arrayListD != null ? arrayListD.size() : 0) + 1 > 500) {
                return -2;
            }
            if (arrayListD != null && arrayListD.size() > 0) {
                Iterator<String> it = arrayListD.iterator();
                while (it.hasNext()) {
                    FavSyncPoi favSyncPoiB = b(it.next());
                    if (favSyncPoiB != null && str.equals(favSyncPoiB.f7945b)) {
                        return -1;
                    }
                }
            }
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    favSyncPoi.f7945b = str;
                    String strValueOf = String.valueOf(System.currentTimeMillis());
                    String str2 = strValueOf + "_" + favSyncPoi.hashCode();
                    favSyncPoi.f7951h = strValueOf;
                    favSyncPoi.f7944a = str2;
                    jSONObject.put("bdetail", favSyncPoi.f7952i);
                    jSONObject.put("uspoiname", favSyncPoi.f7945b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", favSyncPoi.f7946c.getDoubleX());
                    jSONObject2.put("y", favSyncPoi.f7946c.getDoubleY());
                    jSONObject.put("pt", jSONObject2);
                    jSONObject.put("ncityid", favSyncPoi.f7948e);
                    jSONObject.put("npoitype", favSyncPoi.f7950g);
                    jSONObject.put("uspoiuid", favSyncPoi.f7949f);
                    jSONObject.put("addr", favSyncPoi.f7947d);
                    jSONObject.put("addtimesec", favSyncPoi.f7951h);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("Fav_Sync", jSONObject);
                    jSONObject3.put("Fav_Content", favSyncPoi.f7953j);
                    if (!this.f7955b.a(str2, jSONObject3.toString())) {
                        return 0;
                    }
                    h();
                    return 1;
                } catch (JSONException unused) {
                    return 0;
                }
            } finally {
                j();
            }
        }
        return -1;
    }

    public void b() {
        a aVar = f7954a;
        if (aVar != null) {
            NAFavorite nAFavorite = aVar.f7955b;
            if (nAFavorite != null) {
                nAFavorite.c();
                f7954a.f7955b = null;
            }
            f7954a = null;
        }
    }

    public boolean c(String str) {
        return (this.f7955b == null || str == null || str.equals("") || !this.f7955b.b(str)) ? false : true;
    }

    public ArrayList<String> d() {
        if (this.f7955b == null) {
            return null;
        }
        if (this.f7956c && this.f7958e != null) {
            return new ArrayList<>(this.f7958e);
        }
        try {
            Bundle bundle = new Bundle();
            this.f7955b.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.f7958e;
                if (vector == null) {
                    this.f7958e = new Vector<>();
                } else {
                    vector.clear();
                }
                for (String str : stringArray) {
                    if (!str.equals("data_version")) {
                        this.f7958e.add(str);
                    }
                }
                if (this.f7958e.size() > 0) {
                    try {
                        Collections.sort(this.f7958e, new b());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    this.f7956c = true;
                }
            } else {
                Vector<String> vector2 = this.f7958e;
                if (vector2 != null) {
                    vector2.clear();
                    this.f7958e = null;
                }
            }
            Vector<String> vector3 = this.f7958e;
            if (vector3 == null || vector3.size() == 0) {
                return null;
            }
            return new ArrayList<>(this.f7958e);
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<String> e() {
        String strA;
        if (this.f7955b == null) {
            return null;
        }
        if (this.f7957d && this.f7959f != null) {
            return new ArrayList<>(this.f7959f);
        }
        try {
            Bundle bundle = new Bundle();
            this.f7955b.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                Vector<String> vector = this.f7959f;
                if (vector == null) {
                    this.f7959f = new Vector<>();
                } else {
                    vector.clear();
                }
                for (int i4 = 0; i4 < stringArray.length; i4++) {
                    if (!stringArray[i4].equals("data_version") && (strA = this.f7955b.a(stringArray[i4])) != null && !strA.equals("")) {
                        this.f7959f.add(stringArray[i4]);
                    }
                }
                if (this.f7959f.size() > 0) {
                    try {
                        Collections.sort(this.f7959f, new b());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    this.f7957d = true;
                }
            } else {
                Vector<String> vector2 = this.f7959f;
                if (vector2 != null) {
                    vector2.clear();
                    this.f7959f = null;
                }
            }
            Vector<String> vector3 = this.f7959f;
            if (vector3 != null && !vector3.isEmpty()) {
                return new ArrayList<>(this.f7959f);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String c() throws JSONException {
        String strA;
        if (this.f7962i.a() && !this.f7961h.c() && !this.f7961h.b()) {
            return this.f7961h.a();
        }
        this.f7962i.c();
        if (this.f7955b == null) {
            return null;
        }
        ArrayList<String> arrayListE = e();
        JSONObject jSONObject = new JSONObject();
        if (arrayListE != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayListE.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null && !next.equals("data_version") && (strA = this.f7955b.a(next)) != null && !strA.equals("")) {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strA).optJSONObject("Fav_Sync");
                        jSONObjectOptJSONObject.put(Action.KEY_ATTRIBUTE, next);
                        jSONArray.put(i4, jSONObjectOptJSONObject);
                        i4++;
                    }
                }
                if (i4 > 0) {
                    jSONObject.put("favcontents", jSONArray);
                    jSONObject.put("favpoinum", i4);
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        this.f7962i.b();
        this.f7961h.a(jSONObject.toString());
        return this.f7961h.a();
    }

    public FavSyncPoi b(String str) {
        if (this.f7955b != null && str != null && !str.equals("")) {
            try {
                if (!c(str)) {
                    return null;
                }
                FavSyncPoi favSyncPoi = new FavSyncPoi();
                String strA = this.f7955b.a(str);
                if (strA != null && !strA.equals("")) {
                    JSONObject jSONObject = new JSONObject(strA);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("Fav_Sync");
                    String strOptString = jSONObject.optString("Fav_Content");
                    favSyncPoi.f7945b = jSONObjectOptJSONObject.optString("uspoiname");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("pt");
                    favSyncPoi.f7946c = new Point(jSONObjectOptJSONObject2.optInt("x"), jSONObjectOptJSONObject2.optInt("y"));
                    favSyncPoi.f7948e = jSONObjectOptJSONObject.optString("ncityid");
                    favSyncPoi.f7949f = jSONObjectOptJSONObject.optString("uspoiuid");
                    favSyncPoi.f7950g = jSONObjectOptJSONObject.optInt("npoitype");
                    favSyncPoi.f7947d = jSONObjectOptJSONObject.optString("addr");
                    favSyncPoi.f7951h = jSONObjectOptJSONObject.optString("addtimesec");
                    favSyncPoi.f7952i = jSONObjectOptJSONObject.optBoolean("bdetail");
                    favSyncPoi.f7953j = strOptString;
                    favSyncPoi.f7944a = str;
                    return favSyncPoi;
                }
                return null;
            } catch (NullPointerException e4) {
                e4.printStackTrace();
            } catch (JSONException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized boolean b(String str, FavSyncPoi favSyncPoi) {
        boolean z4 = false;
        if (this.f7955b != null && str != null && !str.equals("") && favSyncPoi != null) {
            if (!c(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uspoiname", favSyncPoi.f7945b);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", favSyncPoi.f7946c.getDoubleX());
                jSONObject2.put("y", favSyncPoi.f7946c.getDoubleY());
                jSONObject.put("pt", jSONObject2);
                jSONObject.put("ncityid", favSyncPoi.f7948e);
                jSONObject.put("npoitype", favSyncPoi.f7950g);
                jSONObject.put("uspoiuid", favSyncPoi.f7949f);
                jSONObject.put("addr", favSyncPoi.f7947d);
                String strValueOf = String.valueOf(System.currentTimeMillis());
                favSyncPoi.f7951h = strValueOf;
                jSONObject.put("addtimesec", strValueOf);
                jSONObject.put("bdetail", false);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Fav_Sync", jSONObject);
                jSONObject3.put("Fav_Content", favSyncPoi.f7953j);
                h();
                NAFavorite nAFavorite = this.f7955b;
                if (nAFavorite != null) {
                    if (nAFavorite.b(str, jSONObject3.toString())) {
                        z4 = true;
                    }
                }
                return z4;
            } catch (JSONException unused) {
                return false;
            }
        }
        return false;
    }

    public synchronized boolean a(String str) {
        if (this.f7955b == null) {
            return false;
        }
        if (str != null && !str.equals("")) {
            if (!c(str)) {
                return false;
            }
            h();
            return this.f7955b.c(str);
        }
        return false;
    }

    public synchronized boolean a() {
        if (this.f7955b == null) {
            return false;
        }
        h();
        boolean zA = this.f7955b.a();
        j();
        return zA;
    }
}
