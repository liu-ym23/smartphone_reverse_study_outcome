package com.baidu.platform.comapi.bmsdk.ui;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class BmGroupUI extends BmBaseUI {

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<BmBaseUI> f8725g;

    private BmGroupUI() {
        super(32, 0L);
        this.f8725g = new ArrayList<>();
    }

    private static native boolean nativeAddView(long j4, long j5, int i4);

    private static native boolean nativeRemoveAllViews(long j4);

    @Override // com.baidu.platform.comapi.bmsdk.ui.BmBaseUI
    public BmBaseUI a(long j4) {
        if (this.nativeInstance == j4) {
            return this;
        }
        Iterator<BmBaseUI> it = this.f8725g.iterator();
        while (it.hasNext()) {
            BmBaseUI bmBaseUIA = it.next().a(j4);
            if (bmBaseUIA != null) {
                return bmBaseUIA;
            }
        }
        return null;
    }

    public BmGroupUI(int i4, long j4) {
        super(i4, j4);
        this.f8725g = new ArrayList<>();
    }

    public boolean a(BmBaseUI bmBaseUI) {
        return a(bmBaseUI, -1);
    }

    public boolean a(BmBaseUI bmBaseUI, int i4) {
        if (bmBaseUI == null) {
            return false;
        }
        if (i4 >= 0 && i4 < this.f8725g.size()) {
            this.f8725g.add(i4, bmBaseUI);
        } else {
            this.f8725g.add(bmBaseUI);
        }
        return nativeAddView(getNativeInstance(), bmBaseUI.getNativeInstance(), i4);
    }
}
