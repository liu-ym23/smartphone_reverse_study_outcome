package com.obric.structure.omvvm.core.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u001d\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0014J#\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/structure/omvvm/core/viewmodel/QViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mBagOfTags", "", "", "", "mCleared", "", "close", "", "obj", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCleared", "setTagIfAbsent", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QViewModel extends ViewModel {
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;

    public QViewModel() {
        this.mBagOfTags = new HashMap();
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.mCleared = true;
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        Iterator<Object> r1 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        close(r1.next());     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public <T> T setTagIfAbsent(String r5, T r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        Object r1 = this.mBagOfTags.get(r5);     // Catch: Throwable -> L16
        if (r1 != null) goto L7;
        Map<String, Object> r2 = this.mBagOfTags;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L16
        r2.put(r5, r6);     // Catch: Throwable -> L16
    L7:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        if (r1 == null) goto L13;
        r6 = (T) r1;
    L13:
        if (this.mCleared == false) goto L15;
        close(r6);
    L15:
        return r6;
    L16:
        th = move-exception;
        throw th;
    }

    public <T> T getTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, Object> r0 = this.mBagOfTags;
        monitor-enter(r0);
        T r1 = (T) this.mBagOfTags.get(r2);
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final void close(Object r1) {
        if ((r1 instanceof Closeable) == false) goto L11;
        ((Closeable) r1).close();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
