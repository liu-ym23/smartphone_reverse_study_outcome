package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.xclient.gdid.jni.Native;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static Object a(int r100, Object r101, Object r102, Object r103) {
        return d.a().a(r100, r101, r102, r103);
    }

    public static String a(Context r100) {
        return com.baidu.xclient.gdid.jni.c.a(r100).j();
    }

    public static String a(String r100) {
        return d.a().a(r100);
    }

    public static JSONObject a() {
        return d.a().c();
    }

    public static void a(Context r100, String r101, String r102) {
        d.a().a(r100, r101, r102);
    }

    public static void a(Context r100, String r101, String r102, HashMap<String, String> r103) {
        d.a().a(r100, r101, r102, r103);
    }

    public static void a(HashMap<String, String> r100) {
        d.a().a(r100);
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        return new Native().ac(r100, r101);
    }

    public static String b() {
        return d.a().e();
    }

    public static String b(Context r100) {
        return com.baidu.xclient.gdid.jni.c.a(r100).i();
    }

    public static String b(String r100) {
        return d.a().b(r100);
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        return new Native().dc(r100, r101);
    }

    public static String c(Context r100) {
        return (String) com.baidu.xclient.gdid.j.d.c(r100).first;
    }

    public static void c() {
        d.a().b();
    }

    public static String d(Context r100) {
        return "";
    }

    public static String e(Context r100) {
        return com.baidu.xclient.gdid.jni.c.a(r100).h();
    }

    public static boolean f(Context r100) {
        return TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(r100).a());
    }

    public static String g(Context r100) {
        return com.baidu.xclient.gdid.jni.c.a(r100).f();
    }

    public static String h(Context r100) {
        return com.baidu.xclient.gdid.jni.c.a(r100).g();
    }
}
