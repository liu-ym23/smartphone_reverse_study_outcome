package com.bytedance.ttnet.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonOptConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11272a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f11273b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f11274c;

    /* JADX INFO: compiled from: JsonOptConfig.java */
    public interface a {
        String a(String r1, String[] r2);
    }

    /* JADX INFO: compiled from: JsonOptConfig.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f11276b;

        public b(String r1, JSONObject r2) {
            this.f11275a = r1;
            this.f11276b = r2;
        }

        public String a() {
            if (TextUtils.isEmpty(this.f11275a) == false) goto L6;
            this.f11275a = this.f11276b.toString();
        L6:
            return this.f11275a;
        }

        public JSONObject b() {
            if (this.f11276b != null) goto L6;
            this.f11276b = new JSONObject(this.f11275a);
        L6:
            return this.f11276b;
        }

        public boolean c() {
            if (TextUtils.isEmpty(this.f11275a) == false) goto L10;
            JSONObject r1 = this.f11276b;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.length() <= 0) goto L9;
        L10:
            return true;
        }
    }

    static {
    }

    public static boolean a() {
        return f11272a;
    }

    public static boolean b() {
        return f11273b;
    }

    public static boolean a(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L10;
        if (((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L17;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L19;
        return false;
    L19:
        return ((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin")).c();
    }

    public static JSONObject b(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L7;
        return new JSONObject((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L11;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.aiagent.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L13;
        return null;
    L13:
        return ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).b();
    }

    public static JSONObject c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L7;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L13;
        return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin")).b().optJSONObject("data");
    L10:
        th = move-exception;
        th.printStackTrace();
    L13:
        return new JSONObject();
    }

    public static String a(Object r4, JSONObject r5, String[] r6) {
        if (r6 != null) goto L5;
    L7:
        String r1 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        if (f11274c == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L18;
        return f11274c.a(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin")).a(), r6);
    L18:
        return r5.optString(r1);
    L5:
        if (r6.length <= 0) goto L7;
        r1 = r6[r6.length - 1];
        goto L9
    }
}
