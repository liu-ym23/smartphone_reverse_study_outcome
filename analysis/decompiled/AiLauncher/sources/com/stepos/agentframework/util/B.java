package com.stepos.agentframework.util;

import android.view.View;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/util/B;", "Landroid/view/View$OnClickListener;", "", "paddingTime", "Lkotlin/Function1;", "Landroid/view/View;", "LY8/t;", "wrapClick", "<init>", "(Ljava/lang/Long;Lp9/l;)V", "v", "onClick", "(Landroid/view/View;)V", "Ljava/lang/Long;", "Lp9/l;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class B implements View.OnClickListener {
    private final Long paddingTime;
    private final InterfaceC5074l<View, Y8.t> wrapClick;

    /* JADX WARN: Multi-variable type inference failed */
    public B(Long l10, InterfaceC5074l<? super View, Y8.t> wrapClick) {
        kotlin.jvm.internal.p.i(wrapClick, "wrapClick");
        this.paddingTime = l10;
        this.wrapClick = wrapClick;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        if (C2154c.a(this.paddingTime) && v10 != null) {
            this.wrapClick.invoke(v10);
        }
    }
}
