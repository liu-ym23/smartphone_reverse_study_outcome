package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PathEffectAnimationTasklet f71261a;

    public x(PathEffectAnimationTasklet r100) {
        this.f71261a = r100;
    }

    public final void a() {
        List<HSImageView> r100 = this.f71261a.f71138d;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((HSImageView) r102.next()).setController(null);
        r101.add(Unit.INSTANCE);
        goto L4
    L6:
        Iterator<T> r103 = this.f71261a.f71138d.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        HSImageView r104 = (HSImageView) r103.next();
        FrameLayout r105 = this.f71261a.f71142h;
        if (r105 == null) goto L12;
        r105.removeView(r104);
    L12:
        this.f71261a.f71149o.a(r104);
        goto L8
    L13:
        ((ArrayList) this.f71261a.f71138d).clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
