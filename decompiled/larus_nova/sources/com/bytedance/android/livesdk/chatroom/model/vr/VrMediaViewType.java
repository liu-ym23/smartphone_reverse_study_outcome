package com.bytedance.android.livesdk.chatroom.model.vr;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/vr/VrMediaViewType;", "", "TOP", "BOTTOM", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VrMediaViewType extends Enum<VrMediaViewType> {
    public static final VrMediaViewType BOTTOM = null;
    public static final VrMediaViewType TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VrMediaViewType[] f106976a = null;

    static {
        VrMediaViewType r100 = new VrMediaViewType("TOP", 0);
        TOP = r100;
        VrMediaViewType r101 = new VrMediaViewType("BOTTOM", 1);
        BOTTOM = r101;
        f106976a = new VrMediaViewType[]{r100, r101};
    }

    public static VrMediaViewType valueOf(String r100) {
        return (VrMediaViewType) a.a(VrMediaViewType.class, r100);
    }

    public static VrMediaViewType[] values() {
        return (VrMediaViewType[]) f106976a.clone();
    }

    public VrMediaViewType(String r100, int r101) {
        super(r100, r101);
    }
}
