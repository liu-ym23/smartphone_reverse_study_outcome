package com.obric.oui.utils.log;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ud.a;

/* JADX INFO: loaded from: classes4.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final L f17615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Logger f17616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17617c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f17618d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J.\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/obric/oui/utils/log/L$Logger;", "", "flush", "", "writeLog", "tag", "", "level", "", "msg", "e", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Logger {

        public static final class a {
            public static void a(Logger r10) {
                q.g(r10, "this");
            }
        }

        void flush();

        void writeLog(@Nullable String r10, int r11, @NotNull String r12, @Nullable Throwable r13);
    }

    static {
        f17615a = new L();
        f17617c = new a("OUI_SDK", false, 2, null);
        f17618d = 31;
    }

    public L() {
    }

    public static final void a(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 2, r11, null, false, 24, null);
    }

    public static final void b(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 16, r11, null, false, 24, null);
    }

    public static final void c(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 16, r11, r12, false, 16, null);
    }

    public static final void e(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 4, r11, null, false, 24, null);
    }

    public static /* synthetic */ void h(L r10, String r11, int r12, String r13, Throwable r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Throwable r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = false;
    L8:
        r10.g(r11, r12, r13, r18, r15);
    }

    public static final void i(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 1, r11, null, false, 24, null);
    }

    public static final void j(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        h(f17615a, r10, 8, r11, null, false, 24, null);
    }

    public final Logger d() {
        Logger r10 = f17616b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return f17617c;
    }

    public final boolean f(int r10) {
        if ((f17618d & r10) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(String r10, int r11, String r12, Throwable r13, boolean r14) {
        if (f(r11) == false) goto L5;
        return;
    L5:
        if (r14 == true) goto L7;
        d().writeLog(r10, r11, r12, r13);
        return;
    L7:
        Iterator r15 = StringsKt__StringsKt.l0(r12, new String[]{"\n"}, false, 0, 6, null).iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        String r16 = (String) r15.next();
        f17615a.d().writeLog(r10, r11, r16, null);
        goto L9
    }
}
