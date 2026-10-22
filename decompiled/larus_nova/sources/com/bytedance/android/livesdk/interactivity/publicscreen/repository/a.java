package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final <T> void a(Collection<T> r100, T r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addIf");
        Intrinsics.checkNotNullParameter(r102, "predicate");
        if (r102.invoke().booleanValue() == false) goto L6;
        r100.add(r101);
        return;
    }

    public static final void b(d r100, Collection<String> r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r101, "methods");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.addMessageListener((String) r103.next(), r102);
        goto L4
    }
}
