package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2.a;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class o2<BEHAVIOR, DATA extends b, EXTRA extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, BEHAVIOR> f116618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<DATA, EXTRA, BEHAVIOR> f116619b;

    public static class a {
        public a() {
        }
    }

    public interface b {
        String c();
    }

    public abstract BEHAVIOR b(DATA r100, EXTRA r101, BEHAVIOR r102);

    /* JADX WARN: Multi-variable type inference failed */
    public o2(Function2<? super DATA, ? super EXTRA, ? extends BEHAVIOR> r100) {
        Intrinsics.checkNotNullParameter(r100, "behaviorFactory");
        this.f116619b = r100;
        this.f116618a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized BEHAVIOR a(DATA r100, EXTRA r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "data");     // Catch: Throwable -> L13
        if (this.f116618a.containsKey(r100.c()) == false) goto L6;
        Object r102 = ((LinkedHashMap) this.f116618a).get(r100.c());     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L13
        BEHAVIOR r103 = (BEHAVIOR) b(r100, r101, r102);
    L11:
        monitor-exit(this);
        return r103;
    L6:
        BEHAVIOR r104 = this.f116619b.invoke(r100, r101);     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        this.f116618a.put(r100.c(), r104);     // Catch: Throwable -> L13
        r103 = r104;
        goto L11
    L10:
        r103 = null;
    L13:
        th = move-exception;
        throw th;
    }
}
