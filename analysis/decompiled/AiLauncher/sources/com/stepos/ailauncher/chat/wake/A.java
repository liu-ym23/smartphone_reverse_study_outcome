package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.AuthManager;
import h8.C4148a;
import java.util.Locale;
import k5.C4814a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/A;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    public static final A INSTANCE = new A();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LockScreenDirectEntryRequirement.values().length];
            try {
                iArr[LockScreenDirectEntryRequirement.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockScreenDirectEntryRequirement.AGENT_SWITCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LockScreenDirectEntryRequirement.ALLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LockedGateAction.values().length];
            try {
                iArr2[LockedGateAction.PROMPT_DIRECTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[LockedGateAction.NOTICE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LockedGateAction.UNLOCK_THEN_PROMPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Y8.t e(String str, Context unlockedContext) {
        kotlin.jvm.internal.p.i(unlockedContext, "unlockedContext");
        I.INSTANCE.a(unlockedContext, str);
        return Y8.t.f7040a;
    }

    public static final Y8.t f(String str, Context unlockedContext) {
        kotlin.jvm.internal.p.i(unlockedContext, "unlockedContext");
        C3115e.INSTANCE.a(unlockedContext, str);
        return Y8.t.f7040a;
    }

    public static final Y8.t g(int i10, Context it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
        String string = it.getString(i10);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        com.stepos.ailauncher.chat.lockscreen.H.k(h10, it, string, 0L, 4, null);
        return Y8.t.f7040a;
    }

    public final boolean d(Context context) {
        final int i10;
        InterfaceC5074l<? super Context, Y8.t> interfaceC5074l;
        kotlin.jvm.internal.p.i(context, "context");
        AuthManager authManager = AuthManager.INSTANCE;
        LockScreenDirectEntryRequirement lockScreenDirectEntryRequirementD = Q1.d(authManager.U(), authManager.K());
        if (lockScreenDirectEntryRequirementD == LockScreenDirectEntryRequirement.ALLOW) {
            return true;
        }
        boolean zB = com.stepos.ailauncher.common.utils.I.INSTANCE.b(context);
        com.stepos.ailauncher.chat.lockscreen.C c10 = com.stepos.ailauncher.chat.lockscreen.C.INSTANCE;
        LockedGateAction lockedGateActionC = Q1.c(lockScreenDirectEntryRequirementD, c10.c(context), c10.e(context), zB);
        C4148a.d("WakeGuard", "LockScreenDirectEntry: requirement=" + lockScreenDirectEntryRequirementD + " action=" + lockedGateActionC + " network=" + zB, false, 4, null);
        int[] iArr = a.$EnumSwitchMapping$0;
        int i11 = iArr[lockScreenDirectEntryRequirementD.ordinal()];
        if (i11 == 1) {
            i10 = R$string.lock_screen_login_required;
        } else {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("ALLOW handled before feedback");
            }
            i10 = R$string.lock_screen_agent_disabled;
        }
        int i12 = iArr[lockScreenDirectEntryRequirementD.ordinal()];
        final String str = C4814a.LOCK_SCREEN_LONG_CLICK;
        if (i12 == 1) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return A.e(str, (Context) obj);
                }
            };
        } else {
            if (i12 != 2) {
                if (i12 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("ALLOW handled before feedback");
            }
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.y
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return A.f(str, (Context) obj);
                }
            };
        }
        int i13 = a.$EnumSwitchMapping$1[lockedGateActionC.ordinal()];
        if (i13 == 1) {
            int i14 = iArr[lockScreenDirectEntryRequirementD.ordinal()];
            if (i14 == 1) {
                return I.INSTANCE.a(context, C4814a.LOCK_SCREEN_LONG_CLICK);
            }
            if (i14 == 2) {
                return C3115e.INSTANCE.a(context, C4814a.LOCK_SCREEN_LONG_CLICK);
            }
            if (i14 == 3) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (i13 == 2) {
            com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
            String string = context.getString(i10);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            com.stepos.ailauncher.chat.lockscreen.H.f(h10, context, string, 0L, 4, null);
            return false;
        }
        if (i13 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        F f10 = F.INSTANCE;
        String lowerCase = lockScreenDirectEntryRequirementD.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        f10.e(context, "direct_" + lowerCase, interfaceC5074l, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return A.g(i10, (Context) obj);
            }
        });
        return false;
    }
}
