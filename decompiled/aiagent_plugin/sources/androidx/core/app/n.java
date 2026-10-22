package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Person.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CharSequence f1123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IconCompat f1124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f1125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f1126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1127e;
    boolean f;

    /* JADX INFO: compiled from: Person.java */
    static class a {
        static n a(Person r2) {
            b r0 = new b().a(r2.getName());
            if (r2.getIcon() == null) goto L5;
            IconCompat r1 = IconCompat.a(r2.getIcon());
        L7:
            return r0.a(r1).a(r2.getUri()).b(r2.getKey()).a(r2.isBot()).b(r2.isImportant()).a();
        L5:
            r1 = null;
            goto L7
        }

        static Person a(n r2) {
            Person.Builder r0 = new Person.Builder().setName(r2.c());
            if (r2.d() == null) goto L5;
            Icon r1 = r2.d().e();
        L7:
            return r0.setIcon(r1).setUri(r2.e()).setKey(r2.f()).setBot(r2.g()).setImportant(r2.h()).build();
        L5:
            r1 = null;
            goto L7
        }
    }

    /* JADX INFO: compiled from: Person.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CharSequence f1128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IconCompat f1129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f1131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f1132e;
        boolean f;

        public b() {
        }

        public b a(CharSequence r3) {
            this.f1128a = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public b a(IconCompat r1) {
            this.f1129b = r1;
            return this;
        }

        public b a(String r1) {
            this.f1130c = r1;
            return this;
        }

        public b b(String r1) {
            this.f1131d = r1;
            return this;
        }

        public b a(boolean r1) {
            this.f1132e = r1;
            return this;
        }

        public b b(boolean r1) {
            this.f = r1;
            return this;
        }

        public n a() {
            return new n(this);
        }
    }

    n(b r2) {
        this.f1123a = r2.f1128a;
        this.f1124b = r2.f1129b;
        this.f1125c = r2.f1130c;
        this.f1126d = r2.f1131d;
        this.f1127e = r2.f1132e;
        this.f = r2.f;
    }

    public Bundle a() {
        Bundle r0 = new Bundle();
        r0.putCharSequence("name", this.f1123a);
        IconCompat r1 = this.f1124b;
        if (r1 == null) goto L5;
        Bundle r2 = r1.f();
    L6:
        r0.putBundle("icon", r2);
        r0.putString("uri", this.f1125c);
        r0.putString("key", this.f1126d);
        r0.putBoolean("isBot", this.f1127e);
        r0.putBoolean("isImportant", this.f);
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public Person b() {
        return a.a(this);
    }

    public CharSequence c() {
        return this.f1123a;
    }

    public IconCompat d() {
        return this.f1124b;
    }

    public String e() {
        return this.f1125c;
    }

    public String f() {
        return this.f1126d;
    }

    public boolean g() {
        return this.f1127e;
    }

    public boolean h() {
        return this.f;
    }

    public String i() {
        String r0 = this.f1125c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f1123a != null) goto L8;
        return "";
    L8:
        return "name:" + this.f1123a;
    }
}
