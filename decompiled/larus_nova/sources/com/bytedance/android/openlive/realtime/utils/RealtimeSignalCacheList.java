package com.bytedance.android.openlive.realtime.utils;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\fH\u0007J\u001e\u0010\r\u001a\u00020\n2\u0014\b\u0001\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\fH\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0007R,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/openlive/realtime/utils/RealtimeSignalCacheList;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "<set-?>", "", "list", "getList", "()Ljava/util/List;", "deleteExpired", "", "dropTask", "Lkotlin/Function0;", "init", "initialValueProvider", "insertItem", "insertTask", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RealtimeSignalCacheList<T> {
    private volatile List<? extends T> list;

    public final List<T> getList() {
        monitor-enter(this);
        List<? extends T> r100 = this.list;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public RealtimeSignalCacheList() {
        this.list = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ List access$getList$p(RealtimeSignalCacheList r100) {
        return r100.getList();
    }

    public final void deleteExpired(final Function0<? extends List<? extends T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dropTask");
        Schedulers.io().scheduleDirect(new AnonymousClass1(this, r100));
    }

    public final void init(final Function0<? extends List<? extends T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "initialValueProvider");
        Schedulers.io().scheduleDirect(new RunnableC102641(this, r100));
    }

    public final void insertItem(final Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "insertTask");
        Schedulers.io().scheduleDirect(new RunnableC102651(this, r100));
    }

    public static final /* synthetic */ void access$setList$p(RealtimeSignalCacheList r100, List r101) {
        r100.list = r101;
    }
}
