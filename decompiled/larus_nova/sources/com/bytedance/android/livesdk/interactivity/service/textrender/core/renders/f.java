package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f141048b = null;

    static {
        f141048b = new f();
    }

    public f() {
        super(PieceType.UNKNOWN);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r100, SpannableString r101, b5 r102, yb2.a r103, tb2.c r104, int r105, p r106) {
        Intrinsics.checkNotNullParameter(r100, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r101, "spannable");
        Intrinsics.checkNotNullParameter(r103, "parseConfig");
        Intrinsics.checkNotNullParameter(r104, "renderPiece");
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.f141058b == false) goto L9;
        pm0.a r107 = om0.c.c();
        if (r107 == null) goto L10;
        r107.i("ttlive_render_engine", "got unknown piece: " + r104);
        return null;
    L10:
        return null;
    L9:
        return null;
    }
}
