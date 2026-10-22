package com.bytedance.applet.impl;

import com.bytedance.ai.api.OperateResult;
import com.larus.platform.api.MusicOperateResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191890a = null;

        static {
            int[] r100 = new int[MusicOperateResult.values().length];
            r100[MusicOperateResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MusicOperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MusicOperateResult.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f191890a = r100;
        }
    }

    public static final OperateResult a(MusicOperateResult r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f191890a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return OperateResult.CANCEL;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return OperateResult.REJECT;
    L13:
        return OperateResult.SUCCESS;
    }
}
