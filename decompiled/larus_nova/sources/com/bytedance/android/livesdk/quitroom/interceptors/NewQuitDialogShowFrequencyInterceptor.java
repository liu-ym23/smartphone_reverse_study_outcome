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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class NewQuitDialogShowFrequencyInterceptor implements m32.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f156902c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f156903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f156904b;

    public static final class a {
    }

    static {
    }

    @Override // m32.a
    public final void b(boolean r100) {
    }

    @Override // m32.a
    public final void a() {
        AbsNewQuitRoomDialogFrequencyController r100 = (AbsNewQuitRoomDialogFrequencyController) this.f156904b.getValue();
        List<Long> r101 = r100.f156901b.a();
        Long r102 = (Long) CollectionsKt.lastOrNull(r101);
        if (r102 == null) goto L5;
        boolean r103 = AbsNewQuitRoomDialogFrequencyController.a(r102.longValue());
    L6:
        long r104 = Calendar.getInstance().getTimeInMillis();
        if (r103 == false) goto L9;
        List r105 = CollectionsKt.toMutableList(r101);
        r105.add(Long.valueOf(r104));
        List<Long> r106 = CollectionsKt.toList(r105);
    L10:
        r100.f156901b.b(r106);
        return;
    L9:
        r106 = CollectionsKt.listOf(Long.valueOf(r104));
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public NewQuitDialogShowFrequencyInterceptor() {
        this.f156903a = LazyKt.lazy(NewQuitDialogShowFrequencyInterceptor$sp$2.INSTANCE);
        this.f156904b = LazyKt.lazy(new NewQuitDialogShowFrequencyInterceptor$impl$2(this));
    }

    @Override // m32.a
    public final boolean c(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AbsNewQuitRoomDialogFrequencyController r102 = (AbsNewQuitRoomDialogFrequencyController) this.f156904b.getValue();
        List<Long> r103 = r102.f156901b.a();
        boolean r104 = true;
        if (r103.size() < r102.f156900a) goto L8;
        Long r105 = (Long) CollectionsKt.lastOrNull(r103);
        if (r105 == null) goto L8;
        r104 = true ^ AbsNewQuitRoomDialogFrequencyController.a(r105.longValue());
    L8:
        ALogger.i("AbsInteractionFragment_QuitDialog_Frequency", "canShow() >>> return " + r104);
        if (v.a() == false) goto L15;
        SimpleDateFormat r106 = new SimpleDateFormat("MM/dd HH:mm:ss.SSS");
        List<Long> r107 = ((AbsNewQuitRoomDialogFrequencyController) this.f156904b.getValue()).f156901b.a();
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L12:
        if (r109.hasNext() == false) goto L14;
        r108.add(r106.format(Long.valueOf(((Number) r109.next()).longValue())));
        goto L12
    L14:
        ALogger.i("AbsInteractionFragment_QuitDialog_Frequency", "canShow() >>> frequency list: " + r108);
    L15:
        return r104;
    }
}
