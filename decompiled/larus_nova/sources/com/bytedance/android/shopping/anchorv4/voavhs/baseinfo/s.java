package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.widget.TextView;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f167982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextElement f167983b;

    public s(InlineLongTitleComponentView r100, TextElement r101) {
        this.f167982a = r100;
        this.f167983b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f167982a.setText(v.a(this.f167983b));
    }
}
