package org.commonmark.ext.gfm.tables;

import Yb.g;

/* loaded from: classes5.dex */
public class TableCell extends g {

    /* renamed from: f, reason: collision with root package name */
    public boolean f37767f;

    /* renamed from: g, reason: collision with root package name */
    public Alignment f37768g;

    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public Alignment m() {
        return this.f37768g;
    }

    public boolean n() {
        return this.f37767f;
    }

    public void o(Alignment alignment) {
        this.f37768g = alignment;
    }

    public void p(boolean z10) {
        this.f37767f = z10;
    }
}
