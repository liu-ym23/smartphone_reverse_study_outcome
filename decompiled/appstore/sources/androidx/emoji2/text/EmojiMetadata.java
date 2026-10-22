package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class EmojiMetadata {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f3048d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f3051c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    static {
        f3048d = new ThreadLocal();
    }

    public EmojiMetadata(j r10, int r11) {
        this.f3051c = 0;
        this.f3050b = r10;
        this.f3049a = r11;
    }

    public void a(Canvas r10, float r11, float r12, Paint r13) {
        Typeface r14 = this.f3050b.g();
        Typeface r15 = r13.getTypeface();
        r13.setTypeface(r14);
        int r16 = this.f3049a * 2;
        r10.drawText(this.f3050b.c(), r16, 2, r11, r12, r13);
        r13.setTypeface(r15);
    }

    public int b(int r10) {
        return g().h(r10);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f3051c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final androidx.emoji2.text.flatbuffer.a g() {
        ThreadLocal r10 = f3048d;
        androidx.emoji2.text.flatbuffer.a r11 = (androidx.emoji2.text.flatbuffer.a) r10.get();
        if (r11 != null) goto L5;
        r11 = new androidx.emoji2.text.flatbuffer.a();
        r10.set(r11);
    L5:
        this.f3050b.d().j(r11, this.f3049a);
        return r11;
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean r10) {
        if (r10 == false) goto L4;
        int r11 = 2;
    L5:
        this.f3051c = r11;
        return;
    L4:
        r11 = 1;
        goto L5
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        r10.append(", id:");
        r10.append(Integer.toHexString(f()));
        r10.append(", codepoints:");
        int r11 = c();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(Integer.toHexString(b(r12)));
        r10.append(" ");
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }
}
