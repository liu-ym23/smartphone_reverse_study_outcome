package Ha;

import stepai.aios.guiexecutor.api.TaskAction;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f788a;

    static {
        int[] iArr = new int[TaskAction.values().length];
        try {
            iArr[TaskAction.COMPLETE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[TaskAction.ABORT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f788a = iArr;
    }
}
