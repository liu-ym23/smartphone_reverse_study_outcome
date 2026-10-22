package com.bytedance.android.live.effect.sticker.ui;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f68787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f68788c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L12;
        u r101 = (u) r100;
        if (this.f68786a == r101.f68786a) goto L8;
        return false;
    L8:
        if (this.f68787b == r101.f68787b) goto L10;
        return false;
    L10:
        if (this.f68788c == r101.f68788c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f68786a * 31) + this.f68787b) * 31) + this.f68788c;
    }

    public final String toString() {
        return "TabIconData(unselectedDrawableRes=" + this.f68786a + ", selectedDrawableRes=" + this.f68787b + ", descriptionRes=" + this.f68788c + ")";
    }

    public u() {
        this.f68786a = R.drawable.ttlive_effect_icon_search_unselected;
        this.f68787b = R.drawable.ttlive_effect_icon_search_selected;
        this.f68788c = R.string.ttlive_effect_composer_sticker_tab_search;
    }
}
