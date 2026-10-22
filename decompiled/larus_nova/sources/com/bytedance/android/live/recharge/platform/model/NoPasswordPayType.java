package com.bytedance.android.live.recharge.platform.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/NoPasswordPayType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NOT_USE_NO_PASSWORD", "USE_DY_OR_ZFB_PAY", "USE_ONE_STEP_PAY", "USE_RECHARGE_PANEL", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordPayType extends Enum<NoPasswordPayType> {
    public static final a Companion = null;
    public static final NoPasswordPayType NOT_USE_NO_PASSWORD = null;
    public static final NoPasswordPayType USE_DY_OR_ZFB_PAY = null;
    public static final NoPasswordPayType USE_ONE_STEP_PAY = null;
    public static final NoPasswordPayType USE_RECHARGE_PANEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoPasswordPayType[] f90260a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        NoPasswordPayType r100 = new NoPasswordPayType("NOT_USE_NO_PASSWORD", 0, 0);
        NOT_USE_NO_PASSWORD = r100;
        NoPasswordPayType r101 = new NoPasswordPayType("USE_DY_OR_ZFB_PAY", 1, 1);
        USE_DY_OR_ZFB_PAY = r101;
        NoPasswordPayType r102 = new NoPasswordPayType("USE_ONE_STEP_PAY", 2, 2);
        USE_ONE_STEP_PAY = r102;
        NoPasswordPayType r103 = new NoPasswordPayType("USE_RECHARGE_PANEL", 3, 3);
        USE_RECHARGE_PANEL = r103;
        f90260a = new NoPasswordPayType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static NoPasswordPayType valueOf(String r100) {
        return (NoPasswordPayType) r27.a.a(NoPasswordPayType.class, r100);
    }

    public static NoPasswordPayType[] values() {
        return (NoPasswordPayType[]) f90260a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NoPasswordPayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
