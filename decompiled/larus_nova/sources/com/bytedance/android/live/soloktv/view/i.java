package com.bytedance.android.live.soloktv.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView f101831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownTextView.a f101832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f101833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f101834d;

    public i(CountDownTextView r100, com.bytedance.android.live.soloktv.fragment.o r101) {
        this.f101831a = r100;
        this.f101832b = r101;
        this.f101833c = 3;
        this.f101834d = 0;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (r101 != null) goto L6;
    L10:
        this.f101831a.setText(String.valueOf(this.f101833c - r101.longValue()));
        CountDownTextView.a r102 = this.f101832b;
        if (r102 == null) goto L13;
        CountDownTextView r103 = this.f101831a;
        r101.longValue();
        r102.b(r103);
    L13:
        long r104 = this.f101833c - this.f101834d;
        if (r101.longValue() != r104) goto L19;
        CountDownTextView.a r105 = this.f101832b;
        if (r105 == null) goto L20;
        r105.a(this.f101831a);
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (r101.longValue() != 0) goto L10;
        CountDownTextView.a r106 = this.f101832b;
        if (r106 == null) goto L10;
        r106.c(this.f101831a);
        goto L10
    }
}
