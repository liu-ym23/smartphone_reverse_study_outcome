package com.stepos.widget.preference;

import Y8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/stepos/widget/preference/SwitchPreferenceClickDispatch;", "", "<init>", "()V", "", "consumeOnClick", "()Z", "Lkotlin/Function0;", "LY8/t;", "click", "dispatch", "(Lp9/a;)V", "skipNextOnClick", "Z", "isEnteringClick", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SwitchPreferenceClickDispatch {
    private boolean skipNextOnClick;

    public final boolean consumeOnClick() {
        if (!this.skipNextOnClick) {
            return false;
        }
        this.skipNextOnClick = false;
        return true;
    }

    public final void dispatch(InterfaceC5063a<t> click) {
        p.i(click, "click");
        boolean z10 = this.skipNextOnClick;
        this.skipNextOnClick = true;
        try {
            click.invoke();
        } finally {
            this.skipNextOnClick = z10;
        }
    }

    /* renamed from: isEnteringClick, reason: from getter */
    public final boolean getSkipNextOnClick() {
        return this.skipNextOnClick;
    }
}
