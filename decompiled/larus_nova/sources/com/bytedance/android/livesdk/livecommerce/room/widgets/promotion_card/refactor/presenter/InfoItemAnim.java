package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InfoItemAnim<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f152413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Query f152414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Query f152415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f152416d;

    public static final class a {
    }

    static {
    }

    public abstract void a(T r100, Query r101);

    public abstract boolean b(T r100, T r101);

    public final void c(final T r100) {
        T r101 = this.f152413a;
        if (r101 != null) goto L9;
        a(r100, this.f152414b);
        View r102 = this.f152414b.f450937b;
        if (r102 == null) goto L7;
        r102.setAlpha(1.0f);
    L7:
        this.f152415c.g(4);
        this.f152413a = r100;
        return;
    L9:
        if (b(r101, r100) == true) goto L14;
        a(r100, this.f152414b);
        View r103 = this.f152414b.f450937b;
        if (r103 == null) goto L13;
        r103.setAlpha(1.0f);
    L13:
        this.f152415c.g(4);
        this.f152413a = r100;
        return;
    L14:
        a(this.f152413a, this.f152414b);
        a(r100, this.f152415c);
        Query r104 = this.f152415c;
        r104.g(0);
        View r105 = r104.f();
        Function0<Unit> r106 = new InfoItemAnim$updateData$1(this, r100);
        if (r105.getHeight() <= 0) goto L17;
        r106.invoke();
        return;
    L17:
        r105.addOnLayoutChangeListener(new w(r106, r105));
    }

    public InfoItemAnim(Query r100, Query r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "queryHide");
        Intrinsics.checkNotNullParameter(r101, "queryShow");
        this.f152414b = r100;
        this.f152415c = r101;
        this.f152416d = r102;
    }
}
