package com.bytedance.android.live.gift.tray;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/gift/tray/DialogStatus;", "", "DIALOG_OPEN", "DIALOG_CLOSE", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DialogStatus extends Enum<DialogStatus> {
    public static final DialogStatus DIALOG_CLOSE = null;
    public static final DialogStatus DIALOG_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogStatus[] f69006a = null;

    static {
        DialogStatus r100 = new DialogStatus("DIALOG_OPEN", 0);
        DIALOG_OPEN = r100;
        DialogStatus r101 = new DialogStatus("DIALOG_CLOSE", 1);
        DIALOG_CLOSE = r101;
        f69006a = new DialogStatus[]{r100, r101};
    }

    public static DialogStatus valueOf(String r100) {
        return (DialogStatus) a.a(DialogStatus.class, r100);
    }

    public static DialogStatus[] values() {
        return (DialogStatus[]) f69006a.clone();
    }

    public DialogStatus(String r100, int r101) {
        super(r100, r101);
    }
}
