package com.tmall.wireless.tangram.support;

import android.view.View;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CellSupport {
    public CellSupport() {
    }

    public void bindView(BaseCell r10, View r11) {
    }

    public abstract boolean isValid(BaseCell r10);

    public void onBindViewException(BaseCell r10, View r11, Exception r12) {
    }

    public void onCellRemoved(BaseCell r10) {
    }

    public void postBindView(BaseCell r10, View r11) {
    }

    public void unBindView(BaseCell r10, View r11) {
    }
}
