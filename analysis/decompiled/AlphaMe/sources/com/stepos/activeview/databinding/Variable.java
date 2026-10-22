package com.stepos.activeview.databinding;

import com.stepos.activeview.databinding.interfaces.OnVariableChangedListener;
import com.stepos.activeview.databinding.model.Binder;
import com.stepos.activeview.databinding.utils.ExpressionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Variable extends Binder implements OnVariableChangedListener {
    public static final int TYPE_INT = 1;
    public static final int TYPE_STRING = 0;
    public String expression;
    public boolean isConst;
    public boolean isSystem;
    private ArrayList<OnVariableChangedListener> mOnVariableChangedListeners;
    public String name;
    public int type;
    public String value;

    public Variable() {
        this(null, null, 0, false, false, null);
    }

    private void updateVariableInEva() throws IllegalArgumentException {
        this.mVariableContainer.getEvaluator().putVariable(this.name, this.value);
    }

    public String getExpression() {
        return this.expression;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isConst() {
        return this.isConst;
    }

    public boolean isSystem() {
        return this.isSystem;
    }

    @Override // com.stepos.activeview.databinding.model.Binder
    public void onBind() {
        if (this.mVariableContainer.evaluate(this.expression) == null || !ExpressionUtils.isReferenceVar(this.expression)) {
            return;
        }
        this.mVariableContainer.registerListener(this.expression, this);
    }

    @Override // com.stepos.activeview.databinding.interfaces.OnVariableChangedListener
    public void onExpressionValueChanged() throws IllegalArgumentException {
        String strEvaluate = this.mVariableContainer.evaluate(this.expression);
        if (strEvaluate != null) {
            setValue(strEvaluate);
        }
    }

    @Override // com.stepos.activeview.databinding.model.Binder
    public void onUnbind() {
        this.mVariableContainer.unregisterListener(this);
    }

    public void registerVariableChangedListener(OnVariableChangedListener onVariableChangedListener) {
        if (this.mOnVariableChangedListeners == null) {
            this.mOnVariableChangedListeners = new ArrayList<>();
        }
        if (this.mOnVariableChangedListeners.contains(onVariableChangedListener)) {
            return;
        }
        this.mOnVariableChangedListeners.add(onVariableChangedListener);
    }

    public void setConst(boolean z4) {
        this.isConst = z4;
    }

    public void setExpression(String str) {
        this.expression = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSystem(boolean z4) {
        this.isSystem = z4;
    }

    public void setType(int i4) {
        this.type = i4;
    }

    public void setValue(String str) throws IllegalArgumentException {
        if (!this.isConst && (!this.value.equals(str))) {
            this.value = str;
            updateVariableInEva();
            ArrayList<OnVariableChangedListener> arrayList = this.mOnVariableChangedListeners;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator it = ((List) this.mOnVariableChangedListeners.clone()).iterator();
            while (it.hasNext()) {
                ((OnVariableChangedListener) it.next()).onExpressionValueChanged();
            }
        }
    }

    public String toString() {
        return "name = " + this.name + " expression= " + this.expression + " type= " + this.type + " isConst= " + this.isConst + " isSystem= " + this.isSystem + " value= " + this.value;
    }

    public void unregisterVariableChangedListener(OnVariableChangedListener onVariableChangedListener) {
        ArrayList<OnVariableChangedListener> arrayList = this.mOnVariableChangedListeners;
        if (arrayList != null) {
            arrayList.remove(onVariableChangedListener);
        }
    }

    public Variable(String str, String str2, int i4, boolean z4, boolean z5, String str3) {
        this.name = str;
        this.expression = str2;
        this.type = i4;
        this.isSystem = z4;
        this.isConst = z5;
        this.value = str3;
    }
}
