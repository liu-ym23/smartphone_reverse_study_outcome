package com.obric.anim;

import androidx.transition.Transition;
import com.android.contacts.common.SimContactsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEAAnim.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/anim/TransitionEx;", "", SimContactsConstants.STR_TAG, "", "transition", "Landroidx/transition/Transition;", "(Ljava/lang/String;Landroidx/transition/Transition;)V", "getTag", "()Ljava/lang/String;", "getTransition", "()Landroidx/transition/Transition;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionEx {
    private final String tag;
    private final Transition transition;

    public TransitionEx(String r2, Transition r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, "transition");
        this.tag = r2;
        this.transition = r3;
    }

    public final String getTag() {
        return this.tag;
    }

    public final Transition getTransition() {
        return this.transition;
    }
}
