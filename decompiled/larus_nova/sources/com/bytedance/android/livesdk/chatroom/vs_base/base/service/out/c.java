package com.bytedance.android.livesdk.chatroom.vs_base.base.service.out;

import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements h, o {
    public c() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nm1.h
    public final <T> Map<String, String> d(DataCenter r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Map<String, String> r102 = null;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r103 = d.a(r100).c(r101);
        if (r103 == null) goto L7;
        Map<String, String> r104 = r103.getMap();
    L8:
        if (r104 == null) goto L9;
        return r104;
    L7:
        r104 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r105 = d.f118008b.c(r101);
        if (r105 == null) goto L13;
        r102 = r105.getMap();
    L13:
        return r102;
    }

    @Override // nm1.h
    public final <T> void a(DataCenter r100, Class<T> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r103 = d.a(r100).c(r101);
        if (r103 == null) goto L7;
        r103.putAll(r102);
        Unit r104 = Unit.INSTANCE;
    L8:
        if (r104 == null) goto L9;
        return;
    L7:
        r104 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r105 = d.f118008b.c(r101);
        if (r105 == null) goto L14;
        r105.putAll(r102);
        Unit r106 = Unit.INSTANCE;
        return;
    }

    @Override // nm1.h
    public final <T> void c(DataCenter r100, Class<T> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r103 = d.a(r100).c(r101);
        if (r103 == null) goto L7;
        r103.a(r102);
        Unit r104 = Unit.INSTANCE;
    L8:
        if (r104 == null) goto L9;
        return;
    L7:
        r104 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r105 = d.f118008b.c(r101);
        if (r105 == null) goto L14;
        r105.a(r102);
        Unit r106 = Unit.INSTANCE;
        return;
    }

    @Override // nm1.c
    public final void f(DataCenter r100, String r101, Map<String, String> r102, Object... r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r103, "args");
        if (r100 == null) goto L5;
        d.a(r100).d(r101, r102, new Object[]{r103});
        return;
    L5:
        d.f118008b.d(r101, r102, new Object[]{r103});
    }

    @Override // nm1.h
    public final void g(DataCenter r100, String r101, Map<String, String> r102, Object... r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r103, "args");
        if (r100 == null) goto L5;
        d.a(r100).e(r101, r102, new Object[]{r103});
        return;
    L5:
        d.f118008b.e(r101, r102, new Object[]{r103});
    }
}
