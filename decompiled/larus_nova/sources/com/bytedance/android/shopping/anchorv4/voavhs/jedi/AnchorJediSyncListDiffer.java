package com.bytedance.android.shopping.anchorv4.voavhs.jedi;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class AnchorJediSyncListDiffer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f169919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends T> f169920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListUpdateCallback f169921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<T> f169922d;

    public AnchorJediSyncListDiffer(JediListUpdateCallback r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mUpdateCallback");
        Intrinsics.checkNotNullParameter(r101, "mConfig");
        this.f169921c = r100;
        this.f169922d = r101;
        this.f169920b = CollectionsKt.emptyList();
    }

    public final synchronized T a(int r100, boolean r101) {
        monitor-enter(this);
        List<? extends T> r102 = this.f169920b;     // Catch: Throwable -> L13
        if (r100 >= r102.size()) goto L10;
        if (r100 < 0) goto L10;
        T r103 = (T) ListProtector.get(r102, r100);
        monitor-exit(this);
        return r103;
    L10:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(final List<? extends T> r100, Function0<Unit> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "newList");     // Catch: Throwable -> L22
        int r102 = this.f169919a + 1;     // Catch: Throwable -> L22
        this.f169919a = r102;     // Catch: Throwable -> L22
        final List<? extends T> r103 = this.f169920b;     // Catch: Throwable -> L22
        if (r100 != r103) goto L6;
    L20:
        monitor-exit(this);
        return;
    L6:
        if (r100.isEmpty() == false) goto L11;
        int r104 = r103.size();     // Catch: Throwable -> L22
        this.f169920b = CollectionsKt.emptyList();     // Catch: Throwable -> L22
        this.f169921c.onRemoved(0, r104);     // Catch: Throwable -> L22
        if (r101 == null) goto L20;
        Unit r105 = r101.invoke();     // Catch: Throwable -> L22
        goto L20
    L11:
        if (r103.isEmpty() == false) goto L15;
        this.f169920b = r100;     // Catch: Throwable -> L22
        this.f169921c.onInserted(0, r100.size());     // Catch: Throwable -> L22
        if (r101 == null) goto L20;
        Unit r106 = r101.invoke();     // Catch: Throwable -> L22
        goto L20
    L15:
        DiffUtil.DiffResult r107 = DiffUtil.calculateDiff(new AnchorJediSyncListDiffer$submitList$result$1(this, r103, r100));     // Catch: Throwable -> L22
        if (this.f169919a != r102) goto L20;
        this.f169920b = r100;     // Catch: Throwable -> L22
        r107.dispatchUpdatesTo(this.f169921c);     // Catch: Throwable -> L22
        if (r101 == null) goto L20;
        Unit r108 = r101.invoke();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
