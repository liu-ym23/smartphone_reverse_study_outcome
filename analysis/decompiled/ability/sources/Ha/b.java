package Ha;

import stepai.aios.guiexecutor.api.TargetType;
import stepai.aios.guiexecutor.api.TouchAction;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f784a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[TouchAction.values().length];
        try {
            iArr[TouchAction.TAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[TouchAction.LONG_PRESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[TouchAction.DOUBLE_TAP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f784a = iArr;
        int[] iArr2 = new int[TargetType.values().length];
        try {
            iArr2[TargetType.COORDINATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[TargetType.ELEMENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[TargetType.BOUNDS.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        b = iArr2;
    }
}
