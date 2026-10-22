package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import com.bytedance.android.live.base.model.message.PieceType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f141054a = null;

    static {
        int[] r100 = new int[PieceType.values().length];
        f141054a = r100;
        r100[PieceType.STRING.ordinal()] = 1;
        r100[PieceType.USER.ordinal()] = 2;
        r100[PieceType.GIFT.ordinal()] = 3;
        r100[PieceType.PATTERN_REF.ordinal()] = 4;
        r100[PieceType.IMAGE.ordinal()] = 5;
    }
}
