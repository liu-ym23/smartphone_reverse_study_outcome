package Ha;

import stepai.aios.guiexecutor.api.SystemNavigationAction;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f785a;

    static {
        int[] iArr = new int[SystemNavigationAction.values().length];
        try {
            iArr[SystemNavigationAction.BACK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[SystemNavigationAction.HOME.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[SystemNavigationAction.ENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[SystemNavigationAction.RECENT_APPS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f785a = iArr;
    }
}
