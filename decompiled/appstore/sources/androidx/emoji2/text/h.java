package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class h extends EmojiCompat.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f3086j = null;

    public static class a {
        public a() {
        }

        public Typeface a(Context r10, FontsContractCompat.b r11) {
            return FontsContractCompat.a(r10, null, new FontsContractCompat.b[]{r11});
        }

        public FontsContractCompat.a b(Context r10, q.c r11) {
            return FontsContractCompat.b(r10, null, r11);
        }

        public void c(Context r10, ContentObserver r11) {
            r10.getContentResolver().unregisterContentObserver(r11);
        }
    }

    public static class b implements EmojiCompat.MetadataRepoLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f3087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q.c f3088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f3089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f3090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handler f3091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f3092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThreadPoolExecutor f3093g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public EmojiCompat.f f3094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ContentObserver f3095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Runnable f3096j;

        public b(Context r10, q.c r11, a r12) {
            this.f3090d = new Object();
            androidx.core.util.e.h(r10, "Context cannot be null");
            androidx.core.util.e.h(r11, "FontRequest cannot be null");
            this.f3087a = r10.getApplicationContext();
            this.f3088b = r11;
            this.f3089c = r12;
        }

        public final void a() {
            Object r10 = this.f3090d;
            monitor-enter(r10);
            this.f3094h = null;     // Catch: Throwable -> L8
            ContentObserver r11 = this.f3095i;     // Catch: Throwable -> L8
            if (r11 == null) goto L10;
            this.f3089c.c(this.f3087a, r11);     // Catch: Throwable -> L8
            this.f3095i = null;     // Catch: Throwable -> L8
        L10:
            Handler r12 = this.f3091e;     // Catch: Throwable -> L8
            if (r12 == null) goto L13;
            r12.removeCallbacks(this.f3096j);     // Catch: Throwable -> L8
        L13:
            this.f3091e = null;     // Catch: Throwable -> L8
            ThreadPoolExecutor r13 = this.f3093g;     // Catch: Throwable -> L8
            if (r13 == null) goto L16;
            r13.shutdown();     // Catch: Throwable -> L8
        L16:
            this.f3092f = null;     // Catch: Throwable -> L8
            this.f3093g = null;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void b() {
            Object r10 = this.f3090d;
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.f3094h != null) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L8
            FontsContractCompat.b r11 = d();     // Catch: Throwable -> L20
            int r12 = r11.b();     // Catch: Throwable -> L20
            if (r12 != 2) goto L22;
            Object r13 = this.f3090d;     // Catch: Throwable -> L20
            monitor-enter(r13);     // Catch: Throwable -> L20
            monitor-exit(r13);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L22:
            if (r12 != 0) goto L46;
            androidx.core.os.g.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");     // Catch: Throwable -> L39
            Typeface r14 = this.f3089c.a(this.f3087a, r11);     // Catch: Throwable -> L39
            ByteBuffer r15 = androidx.core.graphics.j.a(this.f3087a, null, r11.d());     // Catch: Throwable -> L39
            if (r15 == null) goto L42;
            if (r14 == null) goto L42;
            j r16 = j.b(r14, r15);     // Catch: Throwable -> L39
            androidx.core.os.g.b();     // Catch: Throwable -> L20
            Object r17 = this.f3090d;     // Catch: Throwable -> L20
            monitor-enter(r17);     // Catch: Throwable -> L20
            EmojiCompat.f r18 = this.f3094h;     // Catch: Throwable -> L32
            if (r18 == null) goto L34;
            r18.b(r16);     // Catch: Throwable -> L32
        L34:
            monitor-exit(r17);     // Catch: Throwable -> L32
            a();     // Catch: Throwable -> L20
            return;
        L32:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L42:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            androidx.core.os.g.b();     // Catch: Throwable -> L20
            throw th;     // Catch: Throwable -> L20
        L46:
            throw new RuntimeException("fetchFonts result is not OK. (" + r12 + ")");     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            monitor-enter(this.f3090d);
            EmojiCompat.f r19 = this.f3094h;     // Catch: Throwable -> L52
            if (r19 == null) goto L54;
            r19.a(th);     // Catch: Throwable -> L52
        L54:
            a();
            return;
        L52:
            th = move-exception;
            throw th;
        }

        public void c() {
            Object r10 = this.f3090d;
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.f3094h != null) goto L11;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.f3092f != null) goto L13;
            ThreadPoolExecutor r11 = androidx.emoji2.text.b.b("emojiCompat");     // Catch: Throwable -> L8
            this.f3093g = r11;     // Catch: Throwable -> L8
            this.f3092f = r11;     // Catch: Throwable -> L8
        L13:
            this.f3092f.execute(new i(this));     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
        }

        public final FontsContractCompat.b d() {
            FontsContractCompat.a r10 = this.f3089c.b(this.f3087a, this.f3088b);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r10.c() != 0) goto L14;
            FontsContractCompat.b[] r11 = r10.b();
            if (r11 == null) goto L12;
            if (r11.length == 0) goto L12;
            return r11[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r10.c() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        public void e(Executor r10) {
            Object r11 = this.f3090d;
            monitor-enter(r11);
            this.f3092f = r10;     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.f r10) {
            androidx.core.util.e.h(r10, "LoaderCallback cannot be null");
            Object r11 = this.f3090d;
            monitor-enter(r11);
            this.f3094h = r10;     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            c();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f3086j = new a();
    }

    public h(Context r10, q.c r11) {
        super(new b(r10, r11, f3086j));
    }

    public h c(Executor r10) {
        ((b) a()).e(r10);
        return this;
    }
}
