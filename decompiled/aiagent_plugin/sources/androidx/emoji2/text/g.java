package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.core.graphics.q;
import androidx.core.os.n;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: FontRequestEmojiCompatConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends d.c {
    private static final a j = null;

    /* JADX INFO: compiled from: FontRequestEmojiCompatConfig.java */
    public static class a {
        public a() {
        }

        public FontsContractCompat.a a(Context r2, androidx.core.provider.c r3) {
            return FontsContractCompat.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), null, r3);
        }

        public Typeface a(Context r2, FontsContractCompat.b r3) {
            return FontsContractCompat.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), null, new FontsContractCompat.b[]{r3});
        }

        public void a(Context r2, Uri r3, ContentObserver r4) {
            ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r3, false, r4, "com.obric.aiagent.plugin");
        }

        public void a(Context r2, ContentObserver r3) {
            ZeusProviderTransform.unregisterContentObserver(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r3, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: FontRequestEmojiCompatConfig.java */
    private static class b implements d.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d.h f1648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f1649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.core.provider.c f1650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a f1651d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f1652e;
        private Handler f;
        private Executor g;
        private ThreadPoolExecutor h;
        private c i;
        private ContentObserver j;
        private Runnable k;

        b(Context r3, androidx.core.provider.c r4, a r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this.f1652e = new Object();
            androidx.core.util.g.a(r6, "Context cannot be null");
            androidx.core.util.g.a(r4, "FontRequest cannot be null");
            this.f1649b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
            this.f1650c = r4;
            this.f1651d = r5;
        }

        public void a(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            Object r0 = this.f1652e;
            monitor-enter(r0);
            this.g = r4;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.emoji2.text.d.g
        public void a(d.h r2) {
            androidx.core.util.g.a(r2, "LoaderCallback cannot be null");
            Object r0 = this.f1652e;
            monitor-enter(r0);
            this.f1648a = r2;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            a();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        void a() {
            Object r0 = this.f1652e;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f1648a != null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L9:
            if (this.g != null) goto L11;
            ThreadPoolExecutor r1 = androidx.emoji2.text.a.a("emojiCompat");     // Catch: Throwable -> L14
            this.h = r1;     // Catch: Throwable -> L14
            this.g = r1;     // Catch: Throwable -> L14
        L11:
            this.g.execute(new $$Lambda$7phVaJXF_rNJLIrLmyodvETnMBc(this));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
        }

        private FontsContractCompat.b c() {
            FontsContractCompat.a r3 = this.f1651d.a(this.f1649b, this.f1650c);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r3.a() != 0) goto L14;
            FontsContractCompat.b[] r4 = r3.b();
            if (r4 == null) goto L12;
            if (r4.length == 0) goto L12;
            return r4[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r3.a() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        private void a(Uri r6, long r7) {
            Object r0 = this.f1652e;
            monitor-enter(r0);
            final Handler r1 = this.f;     // Catch: Throwable -> L16
            if (r1 != null) goto L8;
            r1 = androidx.emoji2.text.a.a();     // Catch: Throwable -> L16
            this.f = r1;     // Catch: Throwable -> L16
        L8:
            if (this.j != null) goto L11;
            ContentObserver r2 = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$1(this, r1);     // Catch: Throwable -> L16
            this.j = r2;     // Catch: Throwable -> L16
            this.f1651d.a(this.f1649b, r6, r2);     // Catch: Throwable -> L16
        L11:
            if (this.k != null) goto L13;
            this.k = new $$Lambda$g2Gziu0mDvmxkPCu_4Tsm2TBPOg(this);     // Catch: Throwable -> L16
        L13:
            r1.postDelayed(this.k, r7);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        private void d() {
            Object r0 = this.f1652e;
            monitor-enter(r0);
            this.f1648a = null;     // Catch: Throwable -> L17
            ContentObserver r2 = this.j;     // Catch: Throwable -> L17
            if (r2 == null) goto L8;
            this.f1651d.a(this.f1649b, r2);     // Catch: Throwable -> L17
            this.j = null;     // Catch: Throwable -> L17
        L8:
            Handler r3 = this.f;     // Catch: Throwable -> L17
            if (r3 == null) goto L11;
            r3.removeCallbacks(this.k);     // Catch: Throwable -> L17
        L11:
            this.f = null;     // Catch: Throwable -> L17
            ThreadPoolExecutor r4 = this.h;     // Catch: Throwable -> L17
            if (r4 == null) goto L14;
            r4.shutdown();     // Catch: Throwable -> L17
        L14:
            this.g = null;     // Catch: Throwable -> L17
            this.h = null;     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        void b() {
            Object r0 = this.f1652e;
            monitor-enter(r0);
        L60:
            th = move-exception;
            throw th;
        L5:
            if (this.f1648a != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L60
            return;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L60
            FontsContractCompat.b r1 = c();     // Catch: Throwable -> L48
            int r2 = r1.e();     // Catch: Throwable -> L48
            if (r2 != 2) goto L25;
            Object r3 = this.f1652e;     // Catch: Throwable -> L48
            monitor-enter(r3);     // Catch: Throwable -> L48
            c r4 = this.i;     // Catch: Throwable -> L22
            if (r4 == null) goto L20;
            long r5 = r4.a();     // Catch: Throwable -> L22
            if (r5 < 0) goto L20;
            a(r1.a(), r5);     // Catch: Throwable -> L22
            monitor-exit(r3);     // Catch: Throwable -> L22
            return;
        L20:
            monitor-exit(r3);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L25:
            if (r2 != 0) goto L47;
            n.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");     // Catch: Throwable -> L43
            Typeface r6 = this.f1651d.a(this.f1649b, r1);     // Catch: Throwable -> L43
            ByteBuffer r7 = q.a(this.f1649b, null, r1.a());     // Catch: Throwable -> L43
            if (r7 == null) goto L42;
            if (r6 == null) goto L42;
            i r8 = i.a(r6, r7);     // Catch: Throwable -> L43
            n.a();     // Catch: Throwable -> L48
            Object r9 = this.f1652e;     // Catch: Throwable -> L48
            monitor-enter(r9);     // Catch: Throwable -> L48
            d.h r10 = this.f1648a;     // Catch: Throwable -> L38
            if (r10 == null) goto L35;
            r10.a(r8);     // Catch: Throwable -> L38
        L35:
            monitor-exit(r9);     // Catch: Throwable -> L38
            d();     // Catch: Throwable -> L48
            return;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L42:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            n.a();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L47:
            throw new RuntimeException("fetchFonts result is not OK. (" + r2 + ")");     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            monitor-enter(this.f1652e);
            d.h r11 = this.f1648a;     // Catch: Throwable -> L57
            if (r11 == null) goto L54;
            r11.a(th);     // Catch: Throwable -> L57
        L54:
            d();
            return;
        L57:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: FontRequestEmojiCompatConfig.java */
    public static abstract class c {
        public abstract long a();
    }

    public g(Context r3, androidx.core.provider.c r4) {
        super(new b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, j));
    }

    public g a(Executor r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        ((b) ZeusTransformUtils.preCheckCast(a(), b.class, "com.obric.aiagent.plugin")).a(r5);
        return this;
    }

    static {
        j = new a();
    }
}
