package com.obric.download;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yb.a;

/* JADX INFO: loaded from: classes4.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Logger f11854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Logger f11856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final L f11857d = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J.\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/download/L$Logger;", "", "flush", "", "writeLog", "tag", "", "level", "", "msg", "e", "", "sdk_release"}, k = 1, mv = {1, 4, 3})
    public interface Logger {

        public static final class a {
            public static void a(Logger r10) {
            }
        }

        void flush();

        void writeLog(@Nullable String r10, int r11, @NotNull String r12, @Nullable Throwable r13);
    }

    static {
        f11857d = new L();
        f11855b = 31;
    }

    public L() {
    }

    public static final void a(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        e(f11857d, r10, 16, r11, r12, false, 16, null);
    }

    public static final void c(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        e(f11857d, r10, 4, r11, null, false, 24, null);
    }

    public static /* synthetic */ void e(L r10, String r11, int r12, String r13, Throwable r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Throwable r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = false;
    L8:
        r10.d(r11, r12, r13, r18, r15);
    }

    public final Logger b() {
        Logger r10 = f11854a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (f11856c != null) goto L8;
        f11856c = new a("ObricDownloaderLog", false);
    L8:
        return f11856c;
    }

    public final void d(String r10, int r11, String r12, Throwable r13, boolean r14) {
        if (r14 == true) goto L6;
        Logger r15 = b();
        if (r15 == null) goto L12;
        r15.writeLog(r10, r11, r12, r13);
        return;
    L12:
        return;
    L6:
        Iterator r16 = StringsKt__StringsKt.l0(r12, new String[]{"\n"}, false, 0, 6, null).iterator();
    L8:
        if (r16.hasNext() == false) goto L19;
        String r17 = (String) r16.next();
        Logger r18 = f11857d.b();
        if (r18 == null) goto L8;
        r18.writeLog(r10, r11, r17, null);
        goto L8
    }
}
