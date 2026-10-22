package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f78466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseGuestLinkMainPageDialog f78467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f78468c;

    public a(View r100, BaseGuestLinkMainPageDialog r101, Ref.FloatRef r102) {
        this.f78466a = r100;
        this.f78467b = r101;
        this.f78468c = r102;
    }

    public final void a() {
        float r100 = this.f78466a.getMeasuredWidth() - (this.f78466a.getPaddingLeft() + this.f78466a.getPaddingRight());
        float r101 = r100 / this.f78468c.element;
        ALogger.d("BaseGuestLinkMainPageDialog", "initPageBackground, mClipStrategy info, playContainerWidth: " + r100 + ", playContainerHeight: " + r101 + ", sx: " + (this.f78466a.getX() + this.f78466a.getPaddingLeft()) + ", sy: " + this.f78466a.getY());
        View r102 = this.f78467b.f78422f;
        if (r102 == null) goto L5;
        a1.k(r102, (int) r101);
    L5:
        this.f78467b.A = new vi0.a(this.f78466a.getX() + this.f78466a.getPaddingLeft(), this.f78466a.getY(), r100, r101);
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
