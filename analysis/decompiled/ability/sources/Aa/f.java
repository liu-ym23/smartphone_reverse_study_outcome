package Aa;

import stepai.aios.guiagent.config.ActionType;
import stepai.aios.guiagent.model.TakeoverReasonType;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f169a;

    static {
        int[] iArr = new int[ActionType.values().length];
        try {
            iArr[ActionType.COMPLETE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[ActionType.ABORT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[ActionType.TAKEOVER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f169a = iArr;
        int[] iArr2 = new int[TakeoverReasonType.values().length];
        try {
            iArr2[0] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            TakeoverReasonType takeoverReasonType = TakeoverReasonType.f6034a;
            iArr2[1] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
