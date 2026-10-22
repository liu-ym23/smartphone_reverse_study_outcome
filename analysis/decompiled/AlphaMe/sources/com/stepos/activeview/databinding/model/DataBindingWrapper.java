package com.stepos.activeview.databinding.model;

import android.view.View;
import com.stepos.activeview.databinding.interfaces.DataBinding;
import com.stepos.activeview.databinding.interfaces.OnVariableChangedListener;
import com.stepos.activeview.databinding.utils.ExpressionUtils;
import com.stepos.activeview.json.Element;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DataBindingWrapper extends Binder implements DataBinding {
    private DataBindingJson mDataBindingJson;
    protected Element mElement;
    private OnVariableChangedListener mRotateListener;
    protected WeakReference<View> mTarget;

    public DataBindingWrapper(Element element) {
        this.mElement = element;
        this.mDataBindingJson = element.getDataBinding();
    }

    private void bindAttr(String str) {
        if ("rotate3d".equals(str)) {
            setRotate3d(getRotate3d());
            updateRotate3d();
        }
    }

    private float[] getRotate3dValue() {
        String[] rotate3d = getRotate3d();
        float[] fArr = new float[3];
        String str = rotate3d[0];
        String strEvaluate = this.mVariableContainer.evaluate(str);
        if (strEvaluate != null) {
            str = strEvaluate;
        }
        try {
            fArr[0] = Double.valueOf(str).floatValue();
        } catch (NumberFormatException unused) {
        }
        String str2 = rotate3d[1];
        String strEvaluate2 = this.mVariableContainer.evaluate(str);
        if (strEvaluate2 != null) {
            str2 = strEvaluate2;
        }
        try {
            fArr[1] = Double.valueOf(str2).floatValue();
        } catch (NumberFormatException unused2) {
        }
        String str3 = rotate3d[2];
        String strEvaluate3 = this.mVariableContainer.evaluate(str3);
        if (strEvaluate3 != null) {
            str3 = strEvaluate3;
        }
        try {
            fArr[2] = Double.valueOf(str3).floatValue();
        } catch (NumberFormatException unused3) {
        }
        return fArr;
    }

    private void unbindAttr(String str) {
        OnVariableChangedListener onVariableChangedListener;
        if (!"rotate3d".equals(str) || (onVariableChangedListener = this.mRotateListener) == null) {
            return;
        }
        this.mVariableContainer.unregisterListener(onVariableChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRotate3d() {
        View view = this.mTarget.get();
        if (view != null) {
            float[] rotate3dValue = getRotate3dValue();
            view.setRotationX(rotate3dValue[0]);
            view.setRotationY(rotate3dValue[1]);
            view.setRotation(rotate3dValue[2]);
        }
    }

    @Override // com.stepos.activeview.databinding.interfaces.DataBinding
    public String[] getRotate3d() {
        return this.mDataBindingJson.getRotate3d();
    }

    @Override // com.stepos.activeview.databinding.model.Binder
    public void onBind() {
        if (this.mDataBindingJson == null) {
            return;
        }
        Iterator it = new ArrayList(this.mDataBindingJson.mBindingAttrs).iterator();
        while (it.hasNext()) {
            bindAttr((String) it.next());
        }
    }

    @Override // com.stepos.activeview.databinding.model.Binder
    public void onUnbind() {
        DataBindingJson dataBindingJson = this.mDataBindingJson;
        if (dataBindingJson == null) {
            return;
        }
        Iterator<String> it = dataBindingJson.mBindingAttrs.iterator();
        while (it.hasNext()) {
            unbindAttr(it.next());
        }
    }

    @Override // com.stepos.activeview.databinding.interfaces.DataBinding
    public void setRotate3d(String[] strArr) {
        String str = strArr[0];
        if (this.mVariableContainer.evaluate(str) != null && ExpressionUtils.isReferenceVar(str)) {
            if (this.mRotateListener == null) {
                this.mRotateListener = new OnVariableChangedListener() { // from class: com.stepos.activeview.databinding.model.DataBindingWrapper.1
                    @Override // com.stepos.activeview.databinding.interfaces.OnVariableChangedListener
                    public void onExpressionValueChanged() {
                        DataBindingWrapper.this.updateRotate3d();
                    }
                };
            }
            this.mVariableContainer.registerListener(str, this.mRotateListener);
        }
        String str2 = strArr[1];
        if (this.mVariableContainer.evaluate(str2) != null && ExpressionUtils.isReferenceVar(str)) {
            if (this.mRotateListener == null) {
                this.mRotateListener = new OnVariableChangedListener() { // from class: com.stepos.activeview.databinding.model.DataBindingWrapper.2
                    @Override // com.stepos.activeview.databinding.interfaces.OnVariableChangedListener
                    public void onExpressionValueChanged() {
                        DataBindingWrapper.this.updateRotate3d();
                    }
                };
            }
            this.mVariableContainer.registerListener(str2, this.mRotateListener);
        }
        String str3 = strArr[2];
        if (this.mVariableContainer.evaluate(str3) != null && ExpressionUtils.isReferenceVar(str3)) {
            if (this.mRotateListener == null) {
                this.mRotateListener = new OnVariableChangedListener() { // from class: com.stepos.activeview.databinding.model.DataBindingWrapper.3
                    @Override // com.stepos.activeview.databinding.interfaces.OnVariableChangedListener
                    public void onExpressionValueChanged() {
                        DataBindingWrapper.this.updateRotate3d();
                    }
                };
            }
            this.mVariableContainer.registerListener(str3, this.mRotateListener);
        }
        this.mDataBindingJson.setRotate3d(strArr);
        this.mElement.setRotate3d(getRotate3dValue());
    }

    @Override // com.stepos.activeview.databinding.model.Binder, com.stepos.activeview.databinding.interfaces.IApplyBinding
    public void setTarget(View view) {
        this.mTarget = new WeakReference<>(view);
    }
}
