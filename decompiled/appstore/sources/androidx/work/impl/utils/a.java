package androidx.work.impl.utils;

import android.app.Application;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5791a = null;

    static {
        f5791a = new a();
    }

    public a() {
    }

    @DoNotInline
    @NotNull
    public final String a() {
        String r10 = Application.getProcessName();
        kotlin.jvm.internal.q.f(r10, "getProcessName()");
        return r10;
    }
}
