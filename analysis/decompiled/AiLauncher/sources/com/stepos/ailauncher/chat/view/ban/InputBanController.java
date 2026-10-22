package com.stepos.ailauncher.chat.view.ban;

import O6.d;
import Ua.C1060i;
import Ua.M;
import Xa.k;
import Xa.u;
import Y8.h;
import Y8.t;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.contract.api.account.IAccountStatusService;
import com.stepos.ailauncher.contract.model.AccountStatus;
import com.stepos.ailauncher.foundation.account.f;
import h8.C4148a;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0018H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00100R\u001d\u00105\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ban/InputBanController;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/ViewGroup;", "mainInput", "LY8/t;", "t", "(Landroid/view/ViewGroup;)V", "LUa/M;", "scope", "l", "(LUa/M;)V", "p", "()V", "Lkotlin/Function0;", "action", "r", "(Lp9/a;)V", "", "m", "()Ljava/lang/String;", "", "s", "()J", "Lcom/stepos/ailauncher/contract/api/account/IAccountStatusService;", "service", "uid", "o", "(Lcom/stepos/ailauncher/contract/api/account/IAccountStatusService;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "banned", "u", "(Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;)V", "q", "endMillis", "v", "(J)V", "w", "Landroid/content/Context;", "Landroid/widget/TextView;", "banNoticeView", "Landroid/widget/TextView;", "Lkotlinx/coroutines/g;", "banTickerJob", "Lkotlinx/coroutines/g;", "LUa/M;", "accountStatusService$delegate", "LY8/h;", "n", "()Lcom/stepos/ailauncher/contract/api/account/IAccountStatusService;", "accountStatusService", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputBanController {
    private static final float BAN_NOTICE_OVERLAP_DP = 12.0f;
    private static final float BAN_NOTICE_SIDE_INSET_DP = 8.0f;
    private static final String TAG_BAN_GATE = "BanGate";

    /* renamed from: accountStatusService$delegate, reason: from kotlin metadata */
    private final h accountStatusService;
    private TextView banNoticeView;
    private g banTickerJob;
    private final Context context;
    private M scope;
    private static final a Companion = new a(null);
    private static final k<AccountStatus.Banned> banDisplay = u.a(null);

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ban/InputBanController$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;", "banned", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/contract/model/AccountStatus$Banned;)V", "c", "", "TAG_BAN_GATE", "Ljava/lang/String;", "", "BAN_NOTICE_OVERLAP_DP", "F", "BAN_NOTICE_SIDE_INSET_DP", "LXa/k;", "banDisplay", "LXa/k;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final void c() {
            InputBanController.banDisplay.setValue(null);
        }

        public final void d(AccountStatus.Banned banned) {
            InputBanController.banDisplay.setValue(banned);
        }

        public a() {
        }
    }

    public InputBanController(Context context) {
        p.i(context, "context");
        this.context = context;
        this.accountStatusService = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.ban.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return InputBanController.k();
            }
        });
    }

    public static final IAccountStatusService k() {
        return (IAccountStatusService) D5.a.INSTANCE.a(IAccountStatusService.class);
    }

    public final void l(M scope) {
        p.i(scope, "scope");
        this.scope = scope;
        C1060i.d(scope, null, null, new InputBanController$bind$1(this, null), 3, null);
    }

    public final String m() {
        String strK;
        try {
            strK = f.INSTANCE.k();
        } catch (Throwable unused) {
        }
        if (strK.length() > 0) {
            return strK;
        }
        return null;
    }

    public final IAccountStatusService n() {
        return (IAccountStatusService) this.accountStatusService.getValue();
    }

    public final void o(IAccountStatusService service, String uid) {
        M m10;
        if (service == null || uid == null || (m10 = this.scope) == null) {
            return;
        }
        C1060i.d(m10, null, null, new InputBanController$refreshBanStatusAsync$1(service, uid, null), 3, null);
    }

    public final void p() {
        w();
        this.scope = null;
    }

    public final void q(AccountStatus.Banned banned) {
        TextView textView = this.banNoticeView;
        if (textView == null) {
            return;
        }
        Long endMillis = banned != null ? banned.getEndMillis() : null;
        long jS = s();
        if (endMillis == null || endMillis.longValue() <= jS) {
            if (textView.getVisibility() == 0) {
                textView.setVisibility(8);
            }
            w();
        } else {
            textView.setText(this.context.getString(R$string.account_banned_notice_countdown, Integer.valueOf(C5685n.f((int) Math.ceil((endMillis.longValue() - jS) / 60000.0d), 1))));
            if (textView.getVisibility() != 0) {
                textView.setVisibility(0);
            }
            v(endMillis.longValue());
        }
    }

    public final void r(InterfaceC5063a<t> action) {
        p.i(action, "action");
        IAccountStatusService iAccountStatusServiceN = n();
        String strM = m();
        AccountStatus accountStatusPeekStatus = (iAccountStatusServiceN == null || strM == null) ? null : iAccountStatusServiceN.peekStatus(strM);
        if (accountStatusPeekStatus instanceof AccountStatus.Banned) {
            AccountStatus.Banned banned = (AccountStatus.Banned) accountStatusPeekStatus;
            Companion.d(banned);
            u(banned);
            o(iAccountStatusServiceN, strM);
            return;
        }
        action.invoke();
        if (iAccountStatusServiceN == null || strM == null) {
            return;
        }
        o(iAccountStatusServiceN, strM);
    }

    public final long s() {
        IAccountStatusService iAccountStatusServiceN = n();
        return iAccountStatusServiceN != null ? iAccountStatusServiceN.serverNow() : System.currentTimeMillis();
    }

    public final void t(ViewGroup mainInput) {
        Drawable drawableMutate;
        p.i(mainInput, "mainInput");
        if (this.banNoticeView != null) {
            return;
        }
        ViewParent parent = mainInput.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        Context context = this.context;
        d dVar = d.INSTANCE;
        int iA = dVar.a(context, 12.0f);
        int iA2 = dVar.a(context, 8.0f);
        int iA3 = dVar.a(context, 16.0f);
        int iA4 = dVar.a(context, 8.0f);
        TextView textView = new TextView(context);
        textView.setPadding(iA3, iA4, iA3, iA4 + iA);
        textView.setTextSize(13.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        int iC = androidx.core.content.a.c(context, R$color.block_float_tips);
        textView.setTextColor(iC);
        textView.setGravity(17);
        Drawable drawableE = androidx.core.content.a.e(context, R$drawable.ic_ban_notice_info);
        if (drawableE == null || (drawableMutate = drawableE.mutate()) == null) {
            drawableMutate = null;
        } else {
            drawableMutate.setTint(iC);
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableMutate, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(dVar.a(context, 6.0f));
        textView.setVisibility(8);
        int iIndexOfChild = viewGroup.indexOfChild(mainInput);
        if (viewGroup instanceof LinearLayout) {
            int iA5 = dVar.a(context, 12.0f) + iA2;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.leftMargin = iA5;
            layoutParams.rightMargin = iA5;
            layoutParams.bottomMargin = -iA;
            viewGroup.addView(textView, iIndexOfChild, layoutParams);
        } else if (viewGroup instanceof ConstraintLayout) {
            int id = mainInput.getId();
            ViewGroup.LayoutParams layoutParams2 = mainInput.getLayoutParams();
            p.g(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
            if (textView.getId() == -1) {
                textView.setId(View.generateViewId());
            }
            ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
            bVar2.f12664t = id;
            bVar2.f12668v = id;
            bVar2.setMarginStart(iA2);
            bVar2.setMarginEnd(iA2);
            bVar2.f12642i = bVar.f12642i;
            bVar2.f12644j = bVar.f12644j;
            ((ViewGroup.MarginLayoutParams) bVar2).topMargin = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            viewGroup.addView(textView, iIndexOfChild, bVar2);
            bVar.f12642i = -1;
            bVar.f12644j = textView.getId();
            bVar.f12672x = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = -iA;
            mainInput.setLayoutParams(bVar);
        } else {
            viewGroup.addView(textView, iIndexOfChild);
        }
        this.banNoticeView = textView;
    }

    public final void u(AccountStatus.Banned banned) {
        Long endMillis = banned.getEndMillis();
        Context context = this.context;
        Toast.makeText(context, context.getString(com.stepos.agentframework.floatcard.R$string.account_banned_no_time), 0).show();
        if (endMillis == null) {
            C4148a.k(TAG_BAN_GATE, "pre-send blocked: banned no-time", false, 4, null);
            return;
        }
        C4148a.k(TAG_BAN_GATE, "pre-send blocked: banned until=" + endMillis + " minutes=" + C5685n.f((int) Math.ceil((endMillis.longValue() - s()) / 60000.0d), 1), false, 4, null);
    }

    public final void v(long endMillis) {
        w();
        M m10 = this.scope;
        if (m10 == null) {
            return;
        }
        this.banTickerJob = C1060i.d(m10, null, null, new InputBanController$startBanTicker$1(this, endMillis, null), 3, null);
    }

    public final void w() {
        g gVar = this.banTickerJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.banTickerJob = null;
    }
}
