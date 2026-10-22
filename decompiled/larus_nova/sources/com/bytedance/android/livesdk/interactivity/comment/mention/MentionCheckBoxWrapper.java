package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class MentionCheckBoxWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f135263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f135264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f135265c;

    public interface a {
        void a(boolean r100);
    }

    public final void a() {
        this.f135263a = !this.f135263a;
        Iterator r100 = ((List) this.f135264b.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).a(this.f135263a);
        goto L4
    }

    public MentionCheckBoxWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f135265c = r100;
        this.f135264b = LazyKt.lazy(MentionCheckBoxWrapper$listeners$2.INSTANCE);
    }
}
