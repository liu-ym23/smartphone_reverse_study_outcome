package z7;

import b8.c;
import b8.d;
import b8.e;
import b8.f;
import b8.g;
import b8.h;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f14275a = a.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, b8.a<?>> f14276b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: z7.a$a, reason: collision with other inner class name */
    public static class C0182a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14277a = new a();
    }

    public a() {
        HashMap<String, b8.a<?>> map = new HashMap<>();
        this.f14276b = map;
        map.put("register_status", new e());
        map.put("un_register_status", new h());
        map.put("push_status", new d());
        map.put("sub_alias_status", new f());
        map.put("sub_tags_status", new g());
        map.put("notification_arrived", new b8.b());
        map.put("private", new c());
        map.put("message", new q7.a());
    }

    public static String a(String str, String str2, String str3, long j10, String str4) {
        String str5 = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str4);
        sb2.append(str5);
        sb2.append(str3);
        sb2.append(j10);
        try {
            return r7.a.a(((MessageDigest) r7.a.f11757b.get()).digest(a0.a.d(5000007L, str2, str, sb2).getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }
}
