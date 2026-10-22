package com.bytedanceos.common.tangram.view;

import android.content.Context;
import androidx.appcompat.widget.p;
import com.bytedanceos.common.ui.widget.BaseAppGroupView;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import z8.a;

/* JADX INFO: loaded from: classes2.dex */
public class TangramAppGroupViewPager extends BaseAppGroupView implements ITangramViewLifeCycle {
    static {
        a.a(11, new int[]{260});
    }

    public TangramAppGroupViewPager(Context r10) {
        super(r10, null);
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        p.a(r10);
        throw null;
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        throw null;
    }

    @Override // com.bytedanceos.common.ui.widget.BaseAppGroupView
    public void submitWhenAppVisible(int r10) {
    }
}
