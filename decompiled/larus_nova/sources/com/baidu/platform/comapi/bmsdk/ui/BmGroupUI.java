package com.baidu.platform.comapi.bmsdk.ui;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmGroupUI extends BmBaseUI {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<BmBaseUI> f32865g;

    private static native boolean nativeAddView(long r100, long r101, int r102);

    private static native boolean nativeRemoveAllViews(long r100);

    private BmGroupUI() {
        super(32, 0);
        this.f32865g = new ArrayList();
    }

    @Override // com.baidu.platform.comapi.bmsdk.ui.BmBaseUI
    public BmBaseUI a(long r100) {
        if (this.nativeInstance != r100) goto L5;
        return this;
    L5:
        Iterator<BmBaseUI> r101 = this.f32865g.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        BmBaseUI r102 = r101.next().a(r100);
        if (r102 == null) goto L7;
        return r102;
    L11:
        return null;
    }

    public boolean a(BmBaseUI r100) {
        return a(r100, -1);
    }

    public BmGroupUI(int r100, long r101) {
        super(r100, r101);
        this.f32865g = new ArrayList();
    }

    public boolean a(BmBaseUI r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 >= 0) goto L7;
    L10:
        this.f32865g.add(r100);
    L12:
        return nativeAddView(getNativeInstance(), r100.getNativeInstance(), r101);
    L7:
        if (r101 >= this.f32865g.size()) goto L10;
        ListProtector.add(this.f32865g, r101, r100);
        goto L12
    }
}
