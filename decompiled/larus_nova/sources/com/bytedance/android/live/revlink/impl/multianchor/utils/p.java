package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f94951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f94952b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f94953c = null;

    static {
        int[] r100 = new int[UILayout.values().length];
        f94951a = r100;
        r100[UILayout.FULL.ordinal()] = 1;
        r100[UILayout.Enlarge.ordinal()] = 2;
        int[] r101 = new int[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.values().length];
        f94952b = r101;
        r101[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal()] = 1;
        r101[IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UnEnlargeAllStream.ordinal()] = 2;
        int[] r102 = new int[IAnchorUpdateLayoutContent.AnchorLayoutRange.values().length];
        f94953c = r102;
        r102[IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom.ordinal()] = 1;
        r102[IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom.ordinal()] = 2;
    }
}
