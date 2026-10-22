package com.bytedance.android.livesdk.quitroom.interceptors;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class NewQuitDialogShowRejectInterceptor implements m32.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f156909c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f156910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f156911b;

    public static final class a {
    }

    static {
    }

    @Override // m32.a
    public final void a() {
    }

    public NewQuitDialogShowRejectInterceptor() {
        this.f156910a = LazyKt.lazy(new NewQuitDialogShowRejectInterceptor$sp$2(this));
        this.f156911b = LazyKt.lazy(new NewQuitDialogShowRejectInterceptor$impl$2(this));
    }

    @Override // m32.a
    public final void b(boolean r100) {
        com.bytedance.android.livesdk.quitroom.interceptors.a r101 = (com.bytedance.android.livesdk.quitroom.interceptors.a) this.f156911b.getValue();
        if (r100 == true) goto L5;
        r101.f156917c.b(CollectionsKt.emptyList());
        return;
    L5:
        r101.getClass();
        long r102 = Calendar.getInstance().getTimeInMillis();
        List r103 = CollectionsKt.toMutableList(r101.f156917c.a());
        r103.add(Long.valueOf(r102));
        List<Long> r104 = CollectionsKt.toList(r103);
        r101.f156917c.b(r104);
    }

    @Override // m32.a
    public final boolean c(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.quitroom.interceptors.a r102 = (com.bytedance.android.livesdk.quitroom.interceptors.a) this.f156911b.getValue();
        List<Long> r103 = r102.f156917c.a();
        boolean r104 = true;
        if (r103.size() >= r102.f156915a) goto L6;
    L19:
        ALogger.i("AbsInteractionFragment_QuitDialog_Reject", "canShow() >>> return " + r104);
        if (v.a() == false) goto L26;
        SimpleDateFormat r105 = new SimpleDateFormat("MM/dd HH:mm:ss.SSS");
        List<Long> r106 = ((com.bytedance.android.livesdk.quitroom.interceptors.a) this.f156911b.getValue()).f156917c.a();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L23:
        if (r108.hasNext() == false) goto L25;
        r107.add(r105.format(Long.valueOf(((Number) r108.next()).longValue())));
        goto L23
    L25:
        ALogger.i("AbsInteractionFragment_QuitDialog_Reject", "canShow() >>> continuous reject list: " + r107);
    L26:
        return r104;
    L6:
        if (r103.size() != r102.f156915a) goto L16;
        Long r109 = (Long) CollectionsKt.lastOrNull(r103);
        if (r109 != null) goto L10;
    L12:
        boolean r110 = false;
    L13:
        if (r110 == false) goto L19;
    L18:
        r104 = false;
        goto L19
    L10:
        if (Calendar.getInstance().getTimeInMillis() > (r109.longValue() + TimeUnit.DAYS.toMillis(7))) goto L12;
        r110 = true;
        goto L13
    L16:
        if (r103.size() >= r102.f156916b) goto L18;
        goto L18
    }
}
