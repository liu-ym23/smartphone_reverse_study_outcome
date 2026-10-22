package org.threeten.bp.format;

import androidx.lifecycle.p;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f23205a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f23206a = null;

        static {
            f23206a = a();
        }

        public static d a() {
            p.a(d.a(), null, new f());
            return (d) d.a().get();
        }
    }

    static {
        f23205a = new AtomicReference();
    }

    public d() {
    }

    public static /* synthetic */ AtomicReference a() {
        return f23205a;
    }

    public static d b() {
        return a.f23206a;
    }

    public abstract String c(TemporalField r10, long r11, TextStyle r12, Locale r13);

    public abstract Iterator d(TemporalField r10, TextStyle r11, Locale r12);
}
