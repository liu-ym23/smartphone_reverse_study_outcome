package com.bytedance.android.livesdk.room.Task.execute;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdk.room.Task.base.LiveTask;
import java.util.Comparator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        LiveTaskType r102 = ((LiveTask) r100).d();
        int[] r103 = c.f157605a;
        int r104 = r103[r102.ordinal()];
        int r105 = 0;
        if (r104 == 1) goto L12;
        if (r104 == 2) goto L11;
        if (r104 == 3) goto L10;
        if (r104 != 4) goto L9;
        int r106 = 3;
    L13:
        Integer r107 = Integer.valueOf(r106);
        int r108 = r103[((LiveTask) r101).d().ordinal()];
        if (r108 == 1) goto L24;
        if (r108 == 2) goto L22;
        if (r108 == 3) goto L21;
        if (r108 != 4) goto L20;
        r105 = 3;
        goto L24
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r105 = 2;
        goto L24
    L22:
        r105 = 1;
    L24:
        return ComparisonsKt.compareValues(r107, Integer.valueOf(r105));
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        r106 = 2;
        goto L13
    L11:
        r106 = 1;
        goto L13
    L12:
        r106 = 0;
        goto L13
    }
}
