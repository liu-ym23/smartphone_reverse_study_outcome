package me;

import android.icu.text.Transliterator;
import android.text.TextUtils;
import com.bytedanceos.common.toolbox.i;
import java.util.ArrayList;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f22271c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Transliterator f22272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Transliterator f22273b;

    /* JADX INFO: renamed from: me.a$a, reason: collision with other inner class name */
    public static class C0317a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22276c;

        public C0317a() {
        }

        public C0317a(int r10, String r11, String r12) {
            this.f22274a = r10;
            this.f22275b = r11;
            this.f22276c = r12;
        }
    }

    public a() {
        this.f22272a = Transliterator.getInstance("Han-Latin/Names; Latin-Ascii; Any-Upper");     // Catch: RuntimeException -> L5
        this.f22273b = Transliterator.getInstance("Latin-Ascii");     // Catch: RuntimeException -> L5
        return;
    L5:
        i.k("HanziToPinyin", "Han-Latin/Names transliterator data is missing, HanziToPinyin is disabled");
    }

    public static a c() {
        if (f22271c != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22271c != null) goto L11;
        f22271c = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f22271c;
    }

    public final void a(StringBuilder r10, ArrayList r11, int r12) {
        String r13 = r10.toString();
        r11.add(new C0317a(r12, r13, r13));
        r10.setLength(0);
    }

    public ArrayList b(String r10) {
        ArrayList r11 = new ArrayList();
        if (d() == true) goto L5;
    L31:
        return r11;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L31;
        int r12 = r10.length();
        StringBuilder r13 = new StringBuilder();
        C0317a r14 = new C0317a();
        int r15 = 1;
        int r16 = 0;
    L8:
        if (r16 >= r12) goto L29;
        char r17 = r10.charAt(r16);
        if (Character.isSpaceChar(r17) == true) goto L12;
        e(r17, r14);
        int r18 = r14.f22274a;
        if (r18 == 2) goto L18;
        if (r15 != r18) goto L23;
    L25:
        r13.append(r14.f22276c);
    L26:
        r15 = r14.f22274a;
    L27:
        r16 = r16 + 1;
        goto L8
    L23:
        if (r13.length() <= 0) goto L25;
        a(r13, r11, r15);
        goto L25
    L18:
        if (r13.length() <= 0) goto L20;
        a(r13, r11, r15);
    L20:
        r11.add(r14);
        r14 = new C0317a();
        goto L26
    L12:
        if (r13.length() <= 0) goto L14;
        a(r13, r11, r15);
    L14:
        e(TokenParser.SP, r14);
        r11.add(r14);
        r14 = new C0317a();
        goto L27
    L29:
        if (r13.length() <= 0) goto L31;
        a(r13, r11, r15);
        goto L31
    }

    public boolean d() {
        if (this.f22272a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e(char r10, C0317a r11) {
        String r12 = Character.toString(r10);
        r11.f22275b = r12;
        if (r10 >= 128) goto L7;
        r11.f22274a = 1;
        r11.f22276c = r12;
        return;
    L7:
        if (r10 >= 592) goto L9;
    L19:
        r11.f22274a = 1;
        Transliterator r13 = this.f22273b;
        if (r13 == null) goto L23;
        r12 = r13.transliterate(r12);
    L23:
        r11.f22276c = r12;
        return;
    L9:
        if (7680 <= r10) goto L11;
    L13:
        r11.f22274a = 2;
        String r14 = this.f22272a.transliterate(r12);
        r11.f22276c = r14;
        if (TextUtils.isEmpty(r14) == false) goto L16;
    L17:
        r11.f22274a = 1;
        r11.f22276c = r11.f22275b;
        return;
    L16:
        if (TextUtils.equals(r11.f22275b, r11.f22276c) == true) goto L17;
        return;
    L11:
        if (r10 >= 7935) goto L13;
        goto L13
    }
}
