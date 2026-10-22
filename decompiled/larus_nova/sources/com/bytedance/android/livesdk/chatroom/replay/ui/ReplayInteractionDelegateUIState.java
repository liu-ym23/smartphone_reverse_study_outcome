package com.bytedance.android.livesdk.chatroom.replay.ui;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayInteractionDelegateUIState extends ir1.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f110235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f110236d;

    public ReplayInteractionDelegateUIState() {
        this.f110235c = LazyKt.lazy(ReplayInteractionDelegateUIState$portraitDelegateMap$2.INSTANCE);
        this.f110236d = LazyKt.lazy(ReplayInteractionDelegateUIState$landscapeDelegateMap$2.INSTANCE);
    }
}
