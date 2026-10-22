package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/ui/uistate/ReplayDialogUIStyle;", "", "BottomStyle", "RightStyle", "RightBottomStyle", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayDialogUIStyle extends Enum<ReplayDialogUIStyle> {
    public static final ReplayDialogUIStyle BottomStyle = null;
    public static final ReplayDialogUIStyle RightBottomStyle = null;
    public static final ReplayDialogUIStyle RightStyle = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplayDialogUIStyle[] f118168a = null;

    static {
        ReplayDialogUIStyle r100 = new ReplayDialogUIStyle("BottomStyle", 0);
        BottomStyle = r100;
        ReplayDialogUIStyle r101 = new ReplayDialogUIStyle("RightStyle", 1);
        RightStyle = r101;
        ReplayDialogUIStyle r102 = new ReplayDialogUIStyle("RightBottomStyle", 2);
        RightBottomStyle = r102;
        f118168a = new ReplayDialogUIStyle[]{r100, r101, r102};
    }

    public static ReplayDialogUIStyle valueOf(String r100) {
        return (ReplayDialogUIStyle) r27.a.a(ReplayDialogUIStyle.class, r100);
    }

    public static ReplayDialogUIStyle[] values() {
        return (ReplayDialogUIStyle[]) f118168a.clone();
    }

    public ReplayDialogUIStyle(String r100, int r101) {
        super(r100, r101);
    }
}
