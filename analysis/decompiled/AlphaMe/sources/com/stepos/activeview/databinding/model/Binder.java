package com.stepos.activeview.databinding.model;

import android.view.View;
import com.stepos.activeview.databinding.VariableContainer;
import com.stepos.activeview.databinding.interfaces.IApplyBinding;

/* loaded from: classes.dex */
public abstract class Binder implements IApplyBinding {
    protected VariableContainer mVariableContainer;

    @Override // com.stepos.activeview.databinding.interfaces.IApplyBinding
    public void bind(VariableContainer variableContainer) {
        this.mVariableContainer = variableContainer;
        if (variableContainer != null) {
            onBind();
        }
    }

    public abstract void onBind();

    public abstract void onUnbind();

    @Override // com.stepos.activeview.databinding.interfaces.IApplyBinding
    public void setTarget(View view) {
    }

    @Override // com.stepos.activeview.databinding.interfaces.IApplyBinding
    public void unBind() {
        onUnbind();
    }
}
