package com.byted.cast.sdk.utils;

import android.os.Build;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class CompatibleManager {
    public static final String[] MODEL_LIST_FC_MODE_NEED_UPDATE_IN_TORCH = null;
    public static final String[] MODEL_LIST_UNSUPPORTED_TORCH = null;
    private static final String TAG = "CompatibleManager";
    private STATE mIsNeedUpdateFCModeWithTorch;
    private STATE mIsSupportTorch;

    /* JADX INFO: renamed from: com.byted.cast.sdk.utils.CompatibleManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CompatibleManagerHolder {
        public static final CompatibleManager instance = null;

        private CompatibleManagerHolder() {
        }

        static {
            instance = new CompatibleManager(null);
        }
    }

    public static final enum STATE extends Enum<STATE> {
        private static final /* synthetic */ STATE[] $VALUES = null;
        public static final STATE NO = null;
        public static final STATE UNKNOWN = null;
        public static final STATE YES = null;

        static {
            STATE r100 = new STATE("UNKNOWN", 0);
            UNKNOWN = r100;
            STATE r101 = new STATE("YES", 1);
            YES = r101;
            STATE r102 = new STATE("NO", 2);
            NO = r102;
            $VALUES = new STATE[]{r100, r101, r102};
        }

        public static STATE[] values() {
            return (STATE[]) $VALUES.clone();
        }

        public static STATE valueOf(String r100) {
            return (STATE) a.a(STATE.class, r100);
        }

        private STATE(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        MODEL_LIST_FC_MODE_NEED_UPDATE_IN_TORCH = new String[]{"GT-I9260"};
        MODEL_LIST_UNSUPPORTED_TORCH = new String[]{"GT-I9260"};
    }

    private STATE _isNeedUpdateFCModeWithTorch() {
        String[] r100 = MODEL_LIST_FC_MODE_NEED_UPDATE_IN_TORCH;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        if (r100[r102].equalsIgnoreCase(Build.MODEL) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return STATE.YES;
    L10:
        return STATE.NO;
    }

    private STATE _isSupportTorch() {
        String[] r100 = MODEL_LIST_UNSUPPORTED_TORCH;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        if (r100[r102].equalsIgnoreCase(Build.MODEL) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return STATE.NO;
    L10:
        return STATE.YES;
    }

    public boolean isNeedUpdateFCModeWithTorch() {
        if (this.mIsNeedUpdateFCModeWithTorch != STATE.UNKNOWN) goto L6;
        this.mIsNeedUpdateFCModeWithTorch = _isNeedUpdateFCModeWithTorch();
    L6:
        if (this.mIsNeedUpdateFCModeWithTorch != STATE.YES) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isSupportTorch() {
        if (this.mIsSupportTorch != STATE.UNKNOWN) goto L6;
        this.mIsSupportTorch = _isSupportTorch();
    L6:
        if (this.mIsSupportTorch != STATE.YES) goto L8;
        return true;
    L8:
        return false;
    }

    private CompatibleManager() {
        STATE r100 = STATE.UNKNOWN;
        this.mIsNeedUpdateFCModeWithTorch = r100;
        this.mIsSupportTorch = r100;
    }

    public static CompatibleManager getInstance() {
        return CompatibleManagerHolder.instance;
    }

    public /* synthetic */ CompatibleManager(AnonymousClass1 r100) {
        this();
    }
}
