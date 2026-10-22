package com.stepos.ailauncher.chat.util;

import android.view.View;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.core.view.b0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    public static final void a(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        view.clearFocus();
        b0 b0VarG = N.G(view);
        if (b0VarG != null) {
            b0VarG.a(a0.o.b());
        }
    }

    public static final void b(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        b0 b0VarG = N.G(view);
        if (b0VarG != null) {
            b0VarG.g(a0.o.b());
        }
    }
}
