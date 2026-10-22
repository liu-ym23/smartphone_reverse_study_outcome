package com.bytedance.android.livesdk.widget.board;

import com.bytedance.android.livesdk.model.ExpressionSection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f161456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f161457b;

    public c(e r100, ArrayList r101) {
        this.f161456a = r100;
        this.f161457b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        int r102 = this.f161456a.f161469j;
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= this.f161457b.size()) goto L13;
        ExpressionSection r103 = (ExpressionSection) ListProtector.get(this.f161457b, this.f161456a.f161469j);
        if (r101.booleanValue() == true) goto L9;
        return;
    L9:
        if ((r103 instanceof uv2.c) == false) goto L15;
        ((uv2.c) r103).g(ExpressionSection.EnterType.DRAW);
        return;
    L15:
        return;
    }
}
