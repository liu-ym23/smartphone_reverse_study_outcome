package com.stepos.common.widget;

import com.stepos.common.widget.ScrollTextView;
import h1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements d.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView.k.a f7196a;

    public u(ScrollTextView.k.a aVar) {
        this.f7196a = aVar;
    }

    @Override // h1.d.l
    public final void a(float f8) {
        ScrollTextView.d dVar = ScrollTextView.k.this.h;
        dVar.removeMessages(0);
        dVar.removeMessages(1);
        dVar.removeMessages(2);
        dVar.sendEmptyMessage(2);
    }
}
