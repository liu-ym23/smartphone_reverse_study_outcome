package com.bytedance.android.anya;

import android.view.View;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import kotlin.jvm.internal.FunctionReference;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIListItem<STATE extends MVIState<?>, ACTION extends p> extends BaseMVIView<STATE, ACTION> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FunctionReference f41532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FunctionReference f41533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f41534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public STATE f41535k;

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void f() {
        this.f41532h = new BaseMVIListItem$internalDetach$1(this);
        this.f41533i = new BaseMVIListItem$internalDetach$2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.FunctionReference] */
    public final int p() {
        return ((Number) this.f41533i.invoke()).intValue();
    }

    public BaseMVIListItem(View r100, STATE r101) {
        this.f41534j = r100;
        this.f41535k = r101;
        this.f41532h = new BaseMVIListItem$getLayoutPosition$1(this);
        this.f41533i = new BaseMVIListItem$getAdapterPosition$1(this);
    }
}
