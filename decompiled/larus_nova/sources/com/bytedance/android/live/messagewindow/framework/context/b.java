package com.bytedance.android.live.messagewindow.framework.context;

import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f83087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f83088b = null;

    static {
        int[] r100 = new int[ICardLifecycle$State.values().length];
        f83087a = r100;
        r100[ICardLifecycle$State.Created.ordinal()] = 1;
        r100[ICardLifecycle$State.Stored.ordinal()] = 2;
        r100[ICardLifecycle$State.Started.ordinal()] = 3;
        r100[ICardLifecycle$State.Showed.ordinal()] = 4;
        r100[ICardLifecycle$State.Hidden.ordinal()] = 5;
        r100[ICardLifecycle$State.Destroyed.ordinal()] = 6;
        int[] r101 = new int[CardAnimState.State.values().length];
        f83088b = r101;
        r101[CardAnimState.State.START.ordinal()] = 1;
        r101[CardAnimState.State.END.ordinal()] = 2;
    }
}
