package com.obric.oui.constraintlayout.core.state;

import com.obric.oui.constraintlayout.core.state.helpers.Facade;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes4.dex */
public interface Reference {
    void apply();

    ConstraintWidget getConstraintWidget();

    Facade getFacade();

    Object getKey();

    void setConstraintWidget(ConstraintWidget r10);

    void setKey(Object r10);
}
