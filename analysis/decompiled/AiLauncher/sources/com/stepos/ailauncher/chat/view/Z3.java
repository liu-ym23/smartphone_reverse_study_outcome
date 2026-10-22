package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.Color;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.MarkwonHelper;
import kotlin.Metadata;
import v8.C5671a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/view/Z3;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "c", "(Landroid/content/Context;)V", Const.INTENT_KEY_PKGNAME, "", "e", "(Landroid/content/Context;)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z3 {
    public static final Z3 INSTANCE = new Z3();

    public static final void d(int i10, int i11, int i12, C5671a.C0540a builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.Q(i10).P(true).x(i11).y(Color.parseColor("#26FFFFFF")).R(i10).D(Color.parseColor("#26FFFFFF")).L(0).M(0).N(new float[]{1.25f, 1.125f, 1.0625f, 1.0f, 1.0f, 1.0f}).S(i12).T(1);
    }

    public final void b() {
        MarkwonHelper.y0(null);
    }

    public final void c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        final int iE = e(context);
        final int iA = O6.d.INSTANCE.a(context, 16.0f);
        MarkwonHelper.n(iE);
        final int i10 = MarkwonHelper.DEFAULT_THEMATIC_BREAK_COLOR;
        MarkwonHelper.u0(MarkwonHelper.DEFAULT_THEMATIC_BREAK_COLOR);
        MarkwonHelper.t0(iE);
        MarkwonHelper.y0(new MarkwonHelper.q() { // from class: com.stepos.ailauncher.chat.view.Y3
            @Override // com.stepos.agentframework.uikit.MarkwonHelper.q
            public final void a(C5671a.C0540a c0540a) {
                Z3.d(iE, iA, i10, c0540a);
            }
        });
    }

    public final int e(Context context) {
        return C2760a4.INSTANCE.b(context, true);
    }
}
