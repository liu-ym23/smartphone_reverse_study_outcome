package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.flatbuffer.b f3098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f3099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f3101d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray f3102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EmojiMetadata f3103b;

        public a() {
            this(1);
        }

        public a a(int r10) {
            SparseArray r11 = this.f3102a;
            if (r11 != null) goto L6;
            return null;
        L6:
            return (a) r11.get(r10);
        }

        public final EmojiMetadata b() {
            return this.f3103b;
        }

        public void c(EmojiMetadata r10, int r11, int r12) {
            a r13 = a(r10.b(r11));
            if (r13 != null) goto L5;
            r13 = new a();
            this.f3102a.put(r10.b(r11), r13);
        L5:
            if (r12 <= r11) goto L7;
            r13.c(r10, r11 + 1, r12);
            return;
        L7:
            r13.f3103b = r10;
        }

        public a(int r10) {
            this.f3102a = new SparseArray(r10);
        }
    }

    public j(Typeface r10, androidx.emoji2.text.flatbuffer.b r11) {
        this.f3101d = r10;
        this.f3098a = r11;
        this.f3100c = new a(1024);
        this.f3099b = new char[r11.k() * 2];
        a(r11);
    }

    public static j b(Typeface r10, ByteBuffer r11) {
        androidx.core.os.g.a("EmojiCompat.MetadataRepo.create");     // Catch: Throwable -> L5
        j r12 = new j(r10, MetadataListReader.b(r11));     // Catch: Throwable -> L5
        androidx.core.os.g.b();
        return r12;
    L5:
        th = move-exception;
        androidx.core.os.g.b();
        throw th;
    }

    public final void a(androidx.emoji2.text.flatbuffer.b r10) {
        int r11 = r10.k();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        EmojiMetadata r13 = new EmojiMetadata(this, r12);
        Character.toChars(r13.f(), this.f3099b, r12 * 2);
        h(r13);
        r12 = r12 + 1;
        goto L3
    }

    public char[] c() {
        return this.f3099b;
    }

    public androidx.emoji2.text.flatbuffer.b d() {
        return this.f3098a;
    }

    public int e() {
        return this.f3098a.l();
    }

    public a f() {
        return this.f3100c;
    }

    public Typeface g() {
        return this.f3101d;
    }

    public void h(EmojiMetadata r10) {
        androidx.core.util.e.h(r10, "emoji metadata cannot be null");
        if (r10.c() <= 0) goto L5;
        boolean r11 = true;
    L6:
        androidx.core.util.e.b(r11, "invalid metadata codepoint length");
        this.f3100c.c(r10, 0, r10.c() - 1);
        return;
    L5:
        r11 = false;
        goto L6
    }
}
