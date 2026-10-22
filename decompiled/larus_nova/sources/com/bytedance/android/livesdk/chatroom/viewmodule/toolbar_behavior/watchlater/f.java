package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.livesdkapi.depend.model.live.ILLPanelWidget;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f117454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<List<ILLPanelWidget>, Unit> f117455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f117456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f117457d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (this.f117454a == r101.f117454a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f117455b, r101.f117455b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f117456c, r101.f117456c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f117457d, r101.f117457d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f117454a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Function1<List<ILLPanelWidget>, Unit> r102 = this.f117455b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        CompositeDisposable r106 = this.f117456c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f117457d;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "LLPanelRequestParams(roomId=" + this.f117454a + ", onSuccess=" + this.f117455b + ", cd=" + this.f117456c + ", requestTag=" + this.f117457d + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(long r100, Function1<? super List<ILLPanelWidget>, Unit> r101, CompositeDisposable r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "cd");
        Intrinsics.checkNotNullParameter(r103, "requestTag");
        this.f117454a = r100;
        this.f117455b = r101;
        this.f117456c = r102;
        this.f117457d = r103;
    }
}
