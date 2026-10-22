package com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_inject_api/model/share/VsLiveShareType;", "", "SHARE_IM", "SHARE_THIRD", "SHARE_DIALOG", "SHARE_VIDEO2FANSGROUP", "SHARE_TEXT2FANSGROUP", "SHARE_ACTIVITY", "REPORT_DIALOG", "vs-inject-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VsLiveShareType extends Enum<VsLiveShareType> {
    public static final VsLiveShareType REPORT_DIALOG = null;
    public static final VsLiveShareType SHARE_ACTIVITY = null;
    public static final VsLiveShareType SHARE_DIALOG = null;
    public static final VsLiveShareType SHARE_IM = null;
    public static final VsLiveShareType SHARE_TEXT2FANSGROUP = null;
    public static final VsLiveShareType SHARE_THIRD = null;
    public static final VsLiveShareType SHARE_VIDEO2FANSGROUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VsLiveShareType[] f118386a = null;

    static {
        VsLiveShareType r100 = new VsLiveShareType("SHARE_IM", 0);
        SHARE_IM = r100;
        VsLiveShareType r101 = new VsLiveShareType("SHARE_THIRD", 1);
        SHARE_THIRD = r101;
        VsLiveShareType r102 = new VsLiveShareType("SHARE_DIALOG", 2);
        SHARE_DIALOG = r102;
        VsLiveShareType r103 = new VsLiveShareType("SHARE_VIDEO2FANSGROUP", 3);
        SHARE_VIDEO2FANSGROUP = r103;
        VsLiveShareType r104 = new VsLiveShareType("SHARE_TEXT2FANSGROUP", 4);
        SHARE_TEXT2FANSGROUP = r104;
        VsLiveShareType r105 = new VsLiveShareType("SHARE_ACTIVITY", 5);
        SHARE_ACTIVITY = r105;
        VsLiveShareType r106 = new VsLiveShareType("REPORT_DIALOG", 6);
        REPORT_DIALOG = r106;
        f118386a = new VsLiveShareType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static VsLiveShareType valueOf(String r100) {
        return (VsLiveShareType) a.a(VsLiveShareType.class, r100);
    }

    public static VsLiveShareType[] values() {
        return (VsLiveShareType[]) f118386a.clone();
    }

    public VsLiveShareType(String r100, int r101) {
        super(r100, r101);
    }
}
