package com.stepos.ailauncher.mcpservice.risk;

import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.E;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementButton;
import com.stepos.ailauncher.mcpservice.risk.q;
import h8.C4148a;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/s;", "", "<init>", "()V", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "buttonId", "", "needsUnlock", "Lcom/stepos/ailauncher/mcpservice/risk/q$c;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/mcpservice/risk/p;Ljava/lang/String;Z)Lcom/stepos/ailauncher/mcpservice/risk/q$c;", "Landroid/content/Context;", "context", "requestId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/UnlockSceneResult;", "LY8/t;", "onResult", "c", "(Landroid/content/Context;Ljava/lang/String;Lp9/l;)V", "TAG", "Ljava/lang/String;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    public static final s INSTANCE = new s();
    private static final String TAG = "UnlockSceneFlow";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnlockSceneResult.values().length];
            try {
                iArr[UnlockSceneResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UnlockSceneResult.ALREADY_UNLOCKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final t d(String str, InterfaceC5074l interfaceC5074l, UnlockSceneResult unlockResult) {
        kotlin.jvm.internal.p.i(unlockResult, "unlockResult");
        C4148a.k(TAG, "keyguard finished | requestId=" + str + ", result=" + unlockResult, false, 4, null);
        int i10 = a.$EnumSwitchMapping$0[unlockResult.ordinal()];
        if (i10 == 1 || i10 == 2) {
            E.INSTANCE.j();
        } else {
            E.INSTANCE.c();
        }
        interfaceC5074l.invoke(unlockResult);
        return t.f7040a;
    }

    public final q.Unlock b(RiskStatementParams params, String buttonId, boolean needsUnlock) {
        Object next;
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(buttonId, "buttonId");
        Iterator<T> it = params.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((RiskStatementButton) next).getId(), buttonId)) {
                break;
            }
        }
        RiskStatementButton riskStatementButton = (RiskStatementButton) next;
        if ((riskStatementButton != null ? riskStatementButton.getStyle() : null) == RiskStatementButton.Style.REJECT) {
            C4148a.k(TAG, "reject | requestId=" + params.getRequestId() + ", buttonId=" + buttonId, false, 4, null);
            return new q.Unlock(UnlockSceneResult.CANCELLED);
        }
        if (needsUnlock) {
            return null;
        }
        C4148a.k(TAG, "already unlocked | requestId=" + params.getRequestId() + ", buttonId=" + buttonId, false, 4, null);
        return new q.Unlock(UnlockSceneResult.ALREADY_UNLOCKED);
    }

    public final void c(Context context, final String requestId, final InterfaceC5074l<? super UnlockSceneResult, t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        com.stepos.ailauncher.mcpservice.risk.a.INSTANCE.f(context, "unlock scene user agree");
        C4148a.k(TAG, "request keyguard | requestId=" + requestId, false, 4, null);
        KeyguardUnlockActivity.INSTANCE.c(context, requestId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.mcpservice.risk.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return s.d(requestId, onResult, (UnlockSceneResult) obj);
            }
        });
    }
}
