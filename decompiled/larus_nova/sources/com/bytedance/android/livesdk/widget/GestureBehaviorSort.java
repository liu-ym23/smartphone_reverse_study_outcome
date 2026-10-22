package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class GestureBehaviorSort {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            y r102 = (y) ((WeakReference) r100).get();
            if (r102 == null) goto L9;
            f0 r103 = r102.getConfig();
            if (r103 == null) goto L9;
            Priority r104 = r103.getPriority();
            if (r104 == null) goto L9;
        L10:
            Integer r105 = Integer.valueOf(r104.ordinal());
            y r106 = (y) ((WeakReference) r101).get();
            if (r106 == null) goto L17;
            f0 r107 = r106.getConfig();
            if (r107 == null) goto L17;
            Priority r108 = r107.getPriority();
            if (r108 == null) goto L17;
        L19:
            return ComparisonsKt.compareValues(r105, Integer.valueOf(r108.ordinal()));
        L17:
            r108 = Priority.Unknown;
        L9:
            r104 = Priority.Unknown;
            goto L10
        }
    }

    static {
    }

    @JvmStatic
    public static final ArrayList<WeakReference<y>> a(List<? extends WeakReference<y>> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        List r111 = CollectionsKt.sortedWith(r110, new a());
        ALogger.i("GestureBehaviorSort", "排序后的behavior：" + CollectionsKt.joinToString$default(r111, null, null, null, 0, null, GestureBehaviorSort$sort$1.INSTANCE, 31, null));
        return new ArrayList(r111);
    }
}
