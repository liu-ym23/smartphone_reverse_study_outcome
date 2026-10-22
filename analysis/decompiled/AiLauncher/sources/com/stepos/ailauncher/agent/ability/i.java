package com.stepos.ailauncher.agent.ability;

import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.mcpservice.risk.RiskStatementParams;
import com.stepos.ailauncher.mcpservice.risk.UnlockSceneResult;
import com.stepos.ailauncher.mcpservice.risk.q;
import kotlin.Metadata;
import kotlin.N;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/agent/ability/i;", "", "<init>", "()V", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "", "isPopup", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "LY8/t;", "delegate", "c", "(Lcom/stepos/ailauncher/mcpservice/risk/p;ZLp9/l;)Lp9/l;", "result", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/mcpservice/risk/q;)Ljava/lang/String;", "EVENT_DIALOG_PERMISSION_SHOW", "Ljava/lang/String;", "EVENT_DIALOG_ISLAND_SHOW", "EVENT_CLICK_PERMISSION_DIALOG", "EVENT_CLICK_ISLAND_PERMISSION", "PARAM_PERMISSION_TYPE", "PARAM_CLICK_RESULT", "TAG_REJECT", "TAG_ALLOW_ONCE", "TAG_ALWAYS_ALLOW", "CLICK_ALLOW", "CLICK_ALLOW_ONCE", "CLICK_DENY", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    private static final String CLICK_ALLOW = "allow";
    private static final String CLICK_ALLOW_ONCE = "allow_once";
    private static final String CLICK_DENY = "deny";
    private static final String EVENT_CLICK_ISLAND_PERMISSION = "click_island_permission";
    private static final String EVENT_CLICK_PERMISSION_DIALOG = "click_permission_dialog";
    private static final String EVENT_DIALOG_ISLAND_SHOW = "dialog_island_permission_show";
    private static final String EVENT_DIALOG_PERMISSION_SHOW = "dialog_permission_request_show";
    public static final i INSTANCE = new i();
    private static final String PARAM_CLICK_RESULT = "click_result";
    private static final String PARAM_PERMISSION_TYPE = "permission_type";
    private static final String TAG_ALLOW_ONCE = "allow_once";
    private static final String TAG_ALWAYS_ALLOW = "always_allow";
    private static final String TAG_REJECT = "reject";

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

    public static final Y8.t d(InterfaceC5074l interfaceC5074l, boolean z10, RiskStatementParams riskStatementParams, com.stepos.ailauncher.mcpservice.risk.q result) {
        kotlin.jvm.internal.p.i(result, "result");
        String strB = INSTANCE.b(result);
        if (strB != null) {
            if (z10) {
                N.a(EVENT_CLICK_PERMISSION_DIALOG, null, kotlin.collections.a.m(Y8.j.a(PARAM_PERMISSION_TYPE, riskStatementParams.getTitle()), Y8.j.a(PARAM_CLICK_RESULT, strB)));
            } else {
                N.a(EVENT_CLICK_ISLAND_PERMISSION, null, Q.f(Y8.j.a(PARAM_CLICK_RESULT, strB)));
            }
        }
        interfaceC5074l.invoke(result);
        return Y8.t.f7040a;
    }

    public final String b(com.stepos.ailauncher.mcpservice.risk.q result) {
        if (!(result instanceof q.Chosen)) {
            if (result instanceof q.Unlock) {
                int i10 = a.$EnumSwitchMapping$0[((q.Unlock) result).getResult().ordinal()];
                return (i10 == 1 || i10 == 2) ? CLICK_ALLOW : CLICK_DENY;
            }
            if (kotlin.jvm.internal.p.d(result, q.a.INSTANCE)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        q.Chosen chosen = (q.Chosen) result;
        String buttonId = chosen.getButtonId();
        int iHashCode = buttonId.hashCode();
        if (iHashCode != -1341859401) {
            if (iHashCode != -934710369) {
                if (iHashCode == -77754087 && buttonId.equals(TAG_ALWAYS_ALLOW)) {
                    return CLICK_ALLOW;
                }
            } else if (buttonId.equals(TAG_REJECT)) {
                return CLICK_DENY;
            }
        } else if (buttonId.equals("allow_once")) {
            return "allow_once";
        }
        return chosen.getButtonId();
    }

    public final InterfaceC5074l<com.stepos.ailauncher.mcpservice.risk.q, Y8.t> c(final RiskStatementParams params, final boolean isPopup, final InterfaceC5074l<? super com.stepos.ailauncher.mcpservice.risk.q, Y8.t> delegate) {
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(delegate, "delegate");
        N.a(isPopup ? EVENT_DIALOG_PERMISSION_SHOW : EVENT_DIALOG_ISLAND_SHOW, null, Q.f(Y8.j.a(PARAM_PERMISSION_TYPE, params.getTitle())));
        return new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.ability.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.d(delegate, isPopup, params, (com.stepos.ailauncher.mcpservice.risk.q) obj);
            }
        };
    }
}
