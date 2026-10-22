package com.bytedance.android.livesdk.quitroom.interceptors;

import android.content.Context;
import com.bytedance.android.live.room.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class NewQuitDialogShowInterceptorImpl implements m32.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f156908a;

    @Override // m32.a
    public final void a() {
        Iterator r100 = ((List) this.f156908a.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((m32.a) r100.next()).a();
        goto L4
    }

    public NewQuitDialogShowInterceptorImpl() {
        this.f156908a = LazyKt.lazy(NewQuitDialogShowInterceptorImpl$interceptors$2.INSTANCE);
    }

    @Override // m32.a
    public final void b(boolean r100) {
        Iterator r101 = ((List) this.f156908a.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((m32.a) r101.next()).b(r100);
        goto L4
    }

    @Override // m32.a
    public final boolean c(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        List r102 = (List) this.f156908a.getValue();
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (((m32.a) r103.next()).c(r100, r101) == true) goto L9;
        return false;
    L13:
        return true;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }
}
