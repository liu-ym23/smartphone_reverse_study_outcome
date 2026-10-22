package com.obric.capabilitykit.entity;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityContextHolder;", "", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "init", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class EntityContextHolder {

    @NotNull
    public static final EntityContextHolder INSTANCE = null;
    public static Context context;
    public static String packageName;

    static {
        INSTANCE = new EntityContextHolder();
    }

    private EntityContextHolder() {
    }

    @NotNull
    public final Context getContext() {
        Context r10 = context;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("context");
        return null;
    }

    @NotNull
    public final String getPackageName() {
        String r10 = packageName;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("packageName");
        return null;
    }

    public final void init(@NotNull Context r10) {
        q.g(r10, "context");
        setContext(r10);
        String r11 = r10.getPackageName();
        q.f(r11, "context.packageName");
        setPackageName(r11);
    }

    public final void setContext(@NotNull Context r10) {
        q.g(r10, "<set-?>");
        context = r10;
    }

    public final void setPackageName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        packageName = r10;
    }
}
