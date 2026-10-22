package com.stepos.activeview.databinding.interfaces;

import android.view.View;
import com.stepos.activeview.databinding.VariableContainer;

/* loaded from: classes.dex */
public interface IApplyBinding {
    void bind(VariableContainer variableContainer);

    void setTarget(View view);

    void unBind();
}
