package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f85638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f85639b = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f85638a = r100;
        r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
        int[] r101 = new int[LiveMode.values().length];
        f85639b = r101;
        r101[LiveMode.SCREEN_RECORD.ordinal()] = 1;
        r101[LiveMode.THIRD_PARTY.ordinal()] = 2;
    }
}
