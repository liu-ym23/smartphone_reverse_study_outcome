package com.bytedance.android.ec.sdk.plugin.initializer;

import com.bytedance.android.shopping.commentv3.utils.CommentPreloadHelper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends com.bytedance.android.ec.sdk.initalizer.a {
    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object b() {
        return Boxing.boxBoolean(m53.a.b());
    }

    public d() {
    }

    @Override // com.bytedance.android.ec.sdk.initalizer.a
    public final Object c(Continuation<? super Unit> r100) {
        if (m53.a.b() == false) goto L6;
        CommentPreloadHelper.b(null);
        com.bytedance.android.shopping.anchorv3.commentv2.b.a();
    L6:
        return Unit.INSTANCE;
    }
}
