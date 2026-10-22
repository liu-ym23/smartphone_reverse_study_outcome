package com.bytedance.android.live.search.impl.search;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSearchResultFragment f100778a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    public l(LiveSearchResultFragment r100) {
        this.f100778a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        LiveSearchResultFragment r101 = this.f100778a;
        String r102 = r100.toString();
        if (r101.f100642q == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        View r103 = r101.f100639n;
        if (r103 == null) goto L15;
        if (r103.getVisibility() != 8) goto L15;
        View r104 = r101.f100639n;
        if (r104 == null) goto L24;
        r104.setVisibility(0);
    L24:
        if (TextUtils.equals(r101.f100640o, r102) == true) goto L36;
        r101.f100640o = r102.toString();
        if (TextUtils.isEmpty(r102) == false) goto L30;
        r101.W90();
        return;
    L30:
        if (r101.f100638m == 1) goto L37;
        r101.X90();
        return;
    L37:
        return;
    L36:
        return;
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L24;
        View r105 = r101.f100639n;
        if (r105 == null) goto L24;
        if (r105.getVisibility() != 0) goto L24;
        View r106 = r101.f100639n;
        if (r106 == null) goto L24;
        r106.setVisibility(8);
        goto L24
    }
}
