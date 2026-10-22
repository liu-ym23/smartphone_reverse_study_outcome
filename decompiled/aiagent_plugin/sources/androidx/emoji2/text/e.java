package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EmojiMetadata.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<androidx.emoji2.text.a.a> f1634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f1636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f1637d;

    static {
        f1634a = new ThreadLocal();
    }

    e(i r2, int r3) {
        this.f1637d = 0;
        this.f1636c = r2;
        this.f1635b = r3;
    }

    public void a(Canvas r10, float r11, float r12, Paint r13) {
        Typeface r0 = this.f1636c.a();
        Typeface r1 = r13.getTypeface();
        r13.setTypeface(r0);
        int r4 = this.f1635b * 2;
        r10.drawText(this.f1636c.d(), r4, 2, r11, r12, r13);
        r13.setTypeface(r1);
    }

    private androidx.emoji2.text.a.a h() {
        ThreadLocal<androidx.emoji2.text.a.a> r0 = f1634a;
        androidx.emoji2.text.a.a r1 = (androidx.emoji2.text.a.a) ZeusTransformUtils.preCheckCast(r0.get(), androidx.emoji2.text.a.a.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new androidx.emoji2.text.a.a();
        r0.set(r1);
    L5:
        this.f1636c.e().a(r1, this.f1635b);
        return r1;
    }

    public int a() {
        return h().a();
    }

    public short b() {
        return h().d();
    }

    public short c() {
        return h().e();
    }

    public short d() {
        return h().c();
    }

    public int e() {
        return this.f1637d;
    }

    public void a(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 2;
    L5:
        this.f1637d = r2;
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public boolean f() {
        return h().b();
    }

    public int a(int r1) {
        return h().a(r1);
    }

    public int g() {
        return h().f();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append(", id:");
        r0.append(Integer.toHexString(a()));
        r0.append(", codepoints:");
        int r1 = g();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(Integer.toHexString(a(r2)));
        r0.append(" ");
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
