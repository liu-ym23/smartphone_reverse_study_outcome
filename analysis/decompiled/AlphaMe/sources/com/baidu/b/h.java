package com.baidu.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    private static String f4888b;

    /* renamed from: a, reason: collision with root package name */
    c f4889a;

    /* renamed from: c, reason: collision with root package name */
    private Context f4890c;

    /* renamed from: d, reason: collision with root package name */
    private a.C0007a f4891d;

    /* renamed from: e, reason: collision with root package name */
    private com.baidu.b.b.c f4892e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f4893a = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};

        /* renamed from: b, reason: collision with root package name */
        private String f4894b;

        /* renamed from: c, reason: collision with root package name */
        private String f4895c;

        /* renamed from: d, reason: collision with root package name */
        private String f4896d;

        /* renamed from: e, reason: collision with root package name */
        private long f4897e;

        /* renamed from: f, reason: collision with root package name */
        private String f4898f;

        /* renamed from: g, reason: collision with root package name */
        private int f4899g = 1;

        public String b() {
            String str = this.f4895c;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            AbstractC0831a.h(sb, this.f4894b, Consts.SPLITTER_DETAIL, str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.f4896d);
            }
            if (!TextUtils.isEmpty(this.f4898f)) {
                sb.append(this.f4898f);
            }
            return sb.toString().trim();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4899g == aVar.f4899g && this.f4894b.equals(aVar.f4894b) && this.f4895c.equals(aVar.f4895c) && this.f4896d.equals(aVar.f4896d)) {
                String str = this.f4898f;
                String str2 = aVar.f4898f;
                if (str == str2) {
                    return true;
                }
                if (str != null && str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f4894b, this.f4895c, this.f4896d, this.f4898f, Integer.valueOf(this.f4899g)});
        }

        public String a() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.f4894b);
                jSONObject.put("v270fk", this.f4895c);
                jSONObject.put("cck", this.f4896d);
                jSONObject.put("vsk", this.f4899g);
                jSONObject.put("ctk", this.f4897e);
                jSONObject.put("ek", this.f4898f);
                return jSONObject.toString();
            } catch (JSONException e4) {
                com.baidu.b.f.c.a(e4);
                return null;
            }
        }
    }

    public h(Context context, com.baidu.b.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.f4890c = context.getApplicationContext();
        a.C0007a c0007aA = aVar.b().a("bohrium");
        this.f4891d = c0007aA;
        c0007aA.a();
        this.f4889a = cVar;
        a(aVar);
    }

    public static void b(String str) {
        f4888b = str;
    }

    private static String d(String str) {
        try {
            return new com.baidu.b.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.b.a.a().a(str.getBytes(Constants.UTF_8_CODE)));
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public a a() {
        a aVar;
        a.d dVar = new a.d();
        dVar.f4747a = true;
        List listA = this.f4892e.a();
        Collections.sort(listA, com.baidu.b.b.a.f4736a);
        List<b> listB = this.f4889a.b(this.f4890c);
        if (listB == null) {
            return null;
        }
        for (b bVar : listB) {
            if (!bVar.f4735d && bVar.f4734c) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    a.e eVarA = ((com.baidu.b.b.a) it.next()).a(bVar.f4732a.packageName, dVar);
                    if (eVarA != null && eVarA.b() && (aVar = eVarA.f4748a) != null) {
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    public a c(String str) throws NoSuchAlgorithmException {
        String strA = com.baidu.b.d.b.a(("com.baidu" + a(this.f4890c)).getBytes(), true);
        a aVar = new a();
        aVar.f4897e = System.currentTimeMillis();
        aVar.f4899g = 1;
        aVar.f4894b = strA;
        aVar.f4895c = ExifInterface.LONGITUDE_EAST;
        aVar.f4896d = d(strA);
        aVar.f4898f = "RO";
        return aVar;
    }

    public a a(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        a aVar = new a();
        aVar.f4897e = System.currentTimeMillis();
        aVar.f4899g = 1;
        try {
            int i4 = 0;
            aVar.f4895c = fVar.f4879b.substring(0, 1);
            aVar.f4894b = fVar.f4878a;
            aVar.f4896d = d(fVar.f4878a);
            String[] strArr = a.f4893a;
            int length = strArr.length;
            while (true) {
                if (i4 >= length) {
                    String str = fVar.f4879b;
                    if (str != null && str.length() >= 2) {
                        aVar.f4898f = fVar.f4879b.substring(1);
                    }
                } else {
                    if (strArr[i4].equals(aVar.f4895c)) {
                        break;
                    }
                    i4++;
                }
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("dik", "");
            String strOptString2 = jSONObject.optString("cck", "");
            long jOptLong = jSONObject.optLong("ctk", 0L);
            int iOptInt = jSONObject.optInt("vsk", 1);
            String strOptString3 = jSONObject.optString("ek", "");
            String strOptString4 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            if (!TextUtils.isEmpty(strOptString)) {
                a aVar = new a();
                aVar.f4894b = strOptString;
                aVar.f4896d = strOptString2;
                aVar.f4897e = jOptLong;
                aVar.f4899g = iOptInt;
                aVar.f4898f = strOptString3;
                aVar.f4895c = strOptString4;
                return aVar;
            }
        } catch (Exception e4) {
            com.baidu.b.f.c.a(e4);
        }
        return null;
    }

    public static a a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String strD = d(str);
                long jCurrentTimeMillis = System.currentTimeMillis();
                a aVar = new a();
                aVar.f4894b = str;
                aVar.f4896d = strD;
                aVar.f4897e = jCurrentTimeMillis;
                aVar.f4899g = 1;
                aVar.f4898f = str3;
                aVar.f4895c = str2;
                return aVar;
            } catch (Exception e4) {
                com.baidu.b.f.c.a(e4);
            }
        }
        return null;
    }

    private String a(Context context) {
        String str = f4888b;
        return TextUtils.isEmpty(str) ? "123456" : str;
    }

    private void a(com.baidu.b.e.a aVar) {
        com.baidu.b.b.c cVar = new com.baidu.b.b.c(new com.baidu.b.a());
        a.C0005a c0005a = new a.C0005a();
        c0005a.f4741a = this.f4890c;
        c0005a.f4742b = aVar;
        a.c cVar2 = new a.c();
        for (com.baidu.b.b.a aVar2 : cVar.a()) {
            aVar2.a(c0005a);
            aVar2.a(cVar2);
        }
        this.f4892e = cVar;
    }
}
