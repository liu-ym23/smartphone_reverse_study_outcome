package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f141045b = null;

    static {
        f141045b = new d();
    }

    public d() {
        super(PieceType.PATTERN_REF);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r100, SpannableString r101, b5 r102, yb2.a r103, tb2.c r104, int r105, p r106) {
        Intrinsics.checkNotNullParameter(r100, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r101, "spannable");
        Intrinsics.checkNotNullParameter(r103, "parseConfig");
        Intrinsics.checkNotNullParameter(r104, "renderPiece");
        int r107 = w.b(r104.getType(), r104.getFormat(), r102, r103);
        int r108 = r100.length() + r105;
        r101.setSpan(new ForegroundColorSpan(r107), r105, r108, 17);
        return null;
    }
}
