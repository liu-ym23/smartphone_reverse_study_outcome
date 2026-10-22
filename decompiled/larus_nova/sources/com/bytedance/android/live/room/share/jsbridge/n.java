package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements fa1.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f100319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f100320b;

    @Override // fa1.a.b
    public final void b() {
        q.j(this.f100319a, this.f100320b, true, "");
    }

    public n(q r100, CallContext r101) {
        this.f100319a = r100;
        this.f100320b = r101;
    }

    @Override // fa1.a.b
    public final void a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "btnText");
        Intrinsics.checkNotNullParameter(r103, "packageName");
        q r104 = this.f100319a;
        CallContext r105 = this.f100320b;
        r104.getClass();
        if (StringUtils.isEmpty(r100) == false) goto L5;
    L16:
        q.j(this.f100319a, this.f100320b, false, r100);
        return;
    L5:
        if (StringUtils.isEmpty(r101) == true) goto L16;
        if (StringUtils.isEmpty(r102) == true) goto L16;
        if (StringUtils.isEmpty(r103) == true) goto L16;
        AlertDialog.Builder r106 = new AlertDialog.Builder(r105.getContext());
        r106.setMessage(r101);
        r106.setPositiveButton(r102, new o(r105, r103));
        r106.setNegativeButton(R.string.ttlive_cancel, p.f100323a);
        AlertDialog r107 = r106.create();
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r107);
        goto L16
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L15:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        goto L16
    }
}
