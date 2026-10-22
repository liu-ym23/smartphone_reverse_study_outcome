package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.interact;

import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f160247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f160248b = null;

    static {
        int[] r100 = new int[PaidSceneViewEntry.values().length];
        f160247a = r100;
        r100[PaidSceneViewEntry.IN_ROOM.ordinal()] = 1;
        r100[PaidSceneViewEntry.FEED_PREVIEW.ordinal()] = 2;
        r100[PaidSceneViewEntry.IM.ordinal()] = 3;
        r100[PaidSceneViewEntry.GENERAL_SEARCH.ordinal()] = 4;
        r100[PaidSceneViewEntry.SEARCH_LIVE.ordinal()] = 5;
        int[] r101 = new int[PaidInteractEntry.values().length];
        f160248b = r101;
        r101[PaidInteractEntry.CONTROL_ENTRY_LANDSCAPE.ordinal()] = 1;
        r101[PaidInteractEntry.CONTROL_PAD_OPEN.ordinal()] = 2;
        r101[PaidInteractEntry.CONTROL_ENTRY_GRAVITY_ORIENTATION.ordinal()] = 3;
        r101[PaidInteractEntry.CONTROL_ENTRY_PAID_LOTTERY.ordinal()] = 4;
        r101[PaidInteractEntry.CONTROL_ENTRY_FANCLUB.ordinal()] = 5;
        r101[PaidInteractEntry.CONTROL_ENTRY_SUBSCRIBE.ordinal()] = 6;
    }
}
