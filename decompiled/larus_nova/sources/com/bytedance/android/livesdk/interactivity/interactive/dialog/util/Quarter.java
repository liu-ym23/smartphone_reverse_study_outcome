package com.bytedance.android.livesdk.interactivity.interactive.dialog.util;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/util/Quarter;", "", "LEFT_TOP", "LEFT_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Quarter extends Enum<Quarter> {
    public static final Quarter LEFT_BOTTOM = null;
    public static final Quarter LEFT_TOP = null;
    public static final Quarter RIGHT_BOTTOM = null;
    public static final Quarter RIGHT_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Quarter[] f137350a = null;

    static {
        Quarter r100 = new Quarter("LEFT_TOP", 0);
        LEFT_TOP = r100;
        Quarter r101 = new Quarter("LEFT_BOTTOM", 1);
        LEFT_BOTTOM = r101;
        Quarter r102 = new Quarter("RIGHT_TOP", 2);
        RIGHT_TOP = r102;
        Quarter r103 = new Quarter("RIGHT_BOTTOM", 3);
        RIGHT_BOTTOM = r103;
        f137350a = new Quarter[]{r100, r101, r102, r103};
    }

    public static Quarter valueOf(String r100) {
        return (Quarter) a.a(Quarter.class, r100);
    }

    public static Quarter[] values() {
        return (Quarter[]) f137350a.clone();
    }

    public Quarter(String r100, int r101) {
        super(r100, r101);
    }
}
