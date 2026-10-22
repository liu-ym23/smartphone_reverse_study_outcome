package com.stepos.ailauncher.chat.wake;

import android.content.Context;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/I;", "Lcom/stepos/ailauncher/chat/wake/N1;", "<init>", "()V", "Landroid/content/Context;", "context", "", "source", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I implements N1 {
    public static final I INSTANCE = new I();
    private static final String name = "Login";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockedGateAction.values().length];
            try {
                iArr[LockedGateAction.PROMPT_DIRECTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockedGateAction.NOTICE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LockedGateAction.UNLOCK_THEN_PROMPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Y8.t d(Context it) {
        kotlin.jvm.internal.p.i(it, "it");
        AuthManager.INSTANCE.V(it);
        return Y8.t.f7040a;
    }

    public static final Y8.t e(Context it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
        String string = it.getString(R$string.lock_screen_login_required);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        com.stepos.ailauncher.chat.lockscreen.H.k(h10, it, string, 0L, 4, null);
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public boolean a(Context context, String source) {
        kotlin.jvm.internal.p.i(context, "context");
        AuthManager authManager = AuthManager.INSTANCE;
        if (authManager.U()) {
            return true;
        }
        if (!com.stepos.ailauncher.common.utils.I.INSTANCE.b(context)) {
            C4148a.d("WakeGuard", "Login: no network + not logged, toast check_network", false, 4, null);
            Toast.makeText(C3197a.INSTANCE.a(), R$string.check_network, 0).show();
            return false;
        }
        com.stepos.ailauncher.chat.lockscreen.C c10 = com.stepos.ailauncher.chat.lockscreen.C.INSTANCE;
        LockedGateAction lockedGateActionE = Q1.e(c10.c(context), c10.e(context));
        C4148a.d("WakeGuard", "Login: not logged, action=" + lockedGateActionE + " source=" + source, false, 4, null);
        int i10 = a.$EnumSwitchMapping$0[lockedGateActionE.ordinal()];
        if (i10 == 1) {
            return authManager.V(context);
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            F.INSTANCE.e(context, "login", new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.G
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return I.d((Context) obj);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return I.e((Context) obj);
                }
            });
            return false;
        }
        com.stepos.ailauncher.chat.lockscreen.H h10 = com.stepos.ailauncher.chat.lockscreen.H.INSTANCE;
        String string = context.getString(R$string.lock_screen_login_required);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        com.stepos.ailauncher.chat.lockscreen.H.f(h10, context, string, 0L, 4, null);
        return false;
    }

    @Override // com.stepos.ailauncher.chat.wake.N1
    public String getName() {
        return name;
    }
}
