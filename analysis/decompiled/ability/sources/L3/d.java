package L3;

import com.stepos.ability.commoninternal.AbilityType;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f932a;

    static {
        int[] iArr = new int[AbilityType.values().length];
        try {
            iArr[AbilityType.LOCAL_MCP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[AbilityType.LOCAL_APP_FUNCTIONS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[AbilityType.REMOTE_MCP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[AbilityType.UNKNOWN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f932a = iArr;
    }
}
