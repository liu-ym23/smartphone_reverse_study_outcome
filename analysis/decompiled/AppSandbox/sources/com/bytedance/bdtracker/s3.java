package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class s3 {
    public String a;
    public List<b> b;
    public a c;
    public String d;

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public JSONObject a() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", this.a);
                jSONObject.put("y", this.b);
                jSONObject.put("width", this.c);
                jSONObject.put("height", this.d);
                return jSONObject;
            } catch (JSONException e) {
                LoggerImpl.global().error("FrameModel to json failed", e, new Object[0]);
                return null;
            }
        }

        public String toString() {
            StringBuilder sbA = com.bytedance.bdtracker.a.a("FrameModel{x=");
            sbA.append(this.a);
            sbA.append(", y=");
            sbA.append(this.b);
            sbA.append(", width=");
            sbA.append(this.c);
            sbA.append(", height=");
            sbA.append(this.d);
            sbA.append('}');
            return sbA.toString();
        }
    }

    public static class b {
        public String a;
        public a b;
        public String c;
        public String d;
        public List<String> e;
        public int f;
        public List<String> g;
        public List<b> h;
        public String i;
        public boolean j;
        public List<String> k;

        public b(String str, a aVar, String str2, String str3, List<String> list, int i, List<String> list2, List<b> list3, String str4, boolean z, List<String> list4) {
            this.a = str;
            this.b = aVar;
            this.c = str2;
            this.d = str3;
            this.e = list;
            this.f = i;
            this.g = list2;
            this.h = list3;
            this.i = str4;
            this.j = z;
            this.k = list4;
        }

        public String toString() {
            StringBuilder sbA = com.bytedance.bdtracker.a.a("InfoModel{nodeName='");
            sbA.append(this.a);
            sbA.append('\'');
            sbA.append(", frameModel=");
            sbA.append(this.b);
            sbA.append(", elementPath='");
            sbA.append(this.c);
            sbA.append('\'');
            sbA.append(", elementPathV2='");
            sbA.append(this.d);
            sbA.append('\'');
            sbA.append(", positions=");
            sbA.append(this.e);
            sbA.append(", zIndex=");
            sbA.append(this.f);
            sbA.append(", texts=");
            sbA.append(this.g);
            sbA.append(", children=");
            sbA.append(this.h);
            sbA.append(", href='");
            sbA.append(this.i);
            sbA.append('\'');
            sbA.append(", checkList=");
            sbA.append(this.j);
            sbA.append(", fuzzyPositions=");
            sbA.append(this.k);
            sbA.append('}');
            return sbA.toString();
        }
    }

    public String toString() {
        StringBuilder sbA = com.bytedance.bdtracker.a.a("WebInfoModel{page='");
        sbA.append(this.a);
        sbA.append('\'');
        sbA.append(", info=");
        sbA.append(this.b);
        sbA.append('}');
        return sbA.toString();
    }
}
