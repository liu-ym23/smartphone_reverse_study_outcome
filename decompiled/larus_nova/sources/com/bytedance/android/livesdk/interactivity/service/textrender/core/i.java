package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface i {
    Drawable a(ITextPieceImage r100, float r101);

    void b(ITextPieceImage r100, float r101, Function1<? super Drawable, Unit> r102);

    boolean c(ITextPieceImage r100);
}
