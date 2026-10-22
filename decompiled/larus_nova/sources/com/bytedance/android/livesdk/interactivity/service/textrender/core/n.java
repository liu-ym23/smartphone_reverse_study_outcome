package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PieceType f141028a;

    public abstract b a(String r100, SpannableString r101, b5 r102, yb2.a r103, tb2.c r104, int r105, p r106);

    public n(PieceType r100) {
        Intrinsics.checkNotNullParameter(r100, "pieceType");
        this.f141028a = r100;
    }
}
