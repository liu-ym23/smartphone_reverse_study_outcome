package com.bytedance.android.ec.store.view;

import android.view.View;
import com.larus.nova.R;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class m<T> implements Comparator<T> {
    public m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(mq.b.b(((View) r100).getTag(R.id.tag_view_priority), 0)), Integer.valueOf(mq.b.b(((View) r101).getTag(R.id.tag_view_priority), 0)));
    }
}
