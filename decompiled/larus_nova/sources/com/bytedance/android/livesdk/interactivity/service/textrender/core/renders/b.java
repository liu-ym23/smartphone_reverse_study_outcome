package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f141041b = null;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r100, SpannableString r101, b5 r102, yb2.a r103, tb2.c r104, int r105, p r106) {
        Intrinsics.checkNotNullParameter(r100, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r101, "spannable");
        Intrinsics.checkNotNullParameter(r103, "parseConfig");
        Intrinsics.checkNotNullParameter(r104, "renderPiece");
        return null;
    }

    static {
        f141041b = new b();
    }

    public b() {
        super(PieceType.HEART);
    }
}
