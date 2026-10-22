package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: MetadataRepo.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.emoji2.text.a.b f1656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f1657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f1658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Typeface f1659d;

    /* JADX INFO: compiled from: MetadataRepo.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray<a> f1660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f1661b;

        private a() {
            this(1);
        }

        a(int r2) {
            this.f1660a = new SparseArray(r2);
        }

        a a(int r2) {
            SparseArray<a> r1 = this.f1660a;
            if (r1 != null) goto L6;
            return null;
        L6:
            return (a) ZeusTransformUtils.preCheckCast(r1.get(r2), a.class, "com.obric.aiagent.plugin");
        }

        final e a() {
            return this.f1661b;
        }

        void a(e r3, int r4, int r5) {
            a r0 = a(r3.a(r4));
            if (r0 != null) goto L5;
            r0 = new a();
            this.f1660a.put(r3.a(r4), r0);
        L5:
            if (r5 <= r4) goto L7;
            r0.a(r3, r4 + 1, r5);
            return;
        L7:
            r0.f1661b = r3;
        }
    }

    private i(Typeface r2, androidx.emoji2.text.a.b r3) {
        this.f1659d = r2;
        this.f1656a = r3;
        this.f1658c = new a(1024);
        this.f1657b = new char[r3.b() * 2];
        a(r3);
    }

    public static i a(Typeface r1, ByteBuffer r2) {
        n.a("EmojiCompat.MetadataRepo.create");     // Catch: Throwable -> L5
        i r0 = new i(r1, h.a(r2));     // Catch: Throwable -> L5
        n.a();
        return r0;
    L5:
        th = move-exception;
        n.a();
        throw th;
    }

    private void a(androidx.emoji2.text.a.b r6) {
        int r7 = r6.b();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        e r1 = new e(this, r0);
        Character.toChars(r1.a(), this.f1657b, r0 * 2);
        a(r1);
        r0 = r0 + 1;
        goto L3
    }

    Typeface a() {
        return this.f1659d;
    }

    int b() {
        return this.f1656a.a();
    }

    a c() {
        return this.f1658c;
    }

    public char[] d() {
        return this.f1657b;
    }

    public androidx.emoji2.text.a.b e() {
        return this.f1656a;
    }

    void a(e r5) {
        androidx.core.util.g.a(r5, "emoji metadata cannot be null");
        if (r5.g() <= 0) goto L5;
        boolean r0 = true;
    L6:
        androidx.core.util.g.a(r0, "invalid metadata codepoint length");
        this.f1658c.a(r5, 0, r5.g() - 1);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
