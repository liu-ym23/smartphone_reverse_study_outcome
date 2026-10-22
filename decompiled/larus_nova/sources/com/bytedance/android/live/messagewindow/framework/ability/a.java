package com.bytedance.android.live.messagewindow.framework.ability;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f83055a = null;

    static {
        int[] r100 = new int[ICardLifecycle$State.values().length];
        f83055a = r100;
        r100[ICardLifecycle$State.Initialized.ordinal()] = 1;
        r100[ICardLifecycle$State.Destroyed.ordinal()] = 2;
        r100[ICardLifecycle$State.Created.ordinal()] = 3;
        r100[ICardLifecycle$State.Stored.ordinal()] = 4;
        r100[ICardLifecycle$State.Started.ordinal()] = 5;
        r100[ICardLifecycle$State.Showed.ordinal()] = 6;
        r100[ICardLifecycle$State.Hidden.ordinal()] = 7;
    }
}
