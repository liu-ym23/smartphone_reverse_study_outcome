package Ha;

import stepai.aios.guiexecutor.input.UserInputStatus;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f783a;

    static {
        int[] iArr = new int[UserInputStatus.values().length];
        try {
            iArr[UserInputStatus.TIMEOUT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[UserInputStatus.CANCELLED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[UserInputStatus.VALIDATION_FAILED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f783a = iArr;
    }
}
