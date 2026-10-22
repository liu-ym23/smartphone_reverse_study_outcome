package com.stepos.activeview.databinding;

import com.stepos.activeview.databinding.interfaces.IActiveViewApplying;
import com.stepos.activeview.databinding.interfaces.IApplyBinding;
import com.stepos.activeview.views.ActiveView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class BindingContainer implements IActiveViewApplying {
    private ActiveView mActiveView;
    private Map<String, IApplyBinding> mDataBindingWrapperMap = new HashMap();
    private VariableContainer mVariableContainer;

    public BindingContainer(ActiveView activeView, VariableContainer variableContainer) {
        this.mActiveView = activeView;
        this.mVariableContainer = variableContainer;
    }

    public void addDataBinding(String str, IApplyBinding iApplyBinding) {
        if (str == null || iApplyBinding == null) {
            return;
        }
        this.mDataBindingWrapperMap.put(str, iApplyBinding);
    }

    public void clearDataBinding() {
        Map<String, IApplyBinding> map = this.mDataBindingWrapperMap;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.stepos.activeview.databinding.interfaces.IActiveViewApplying
    public void startApplying() {
        if (this.mDataBindingWrapperMap.size() > 0) {
            for (Map.Entry<String, IApplyBinding> entry : this.mDataBindingWrapperMap.entrySet()) {
                String key = entry.getKey();
                IApplyBinding value = entry.getValue();
                value.setTarget(this.mActiveView.getItemViewById(key));
                value.bind(this.mVariableContainer);
            }
        }
    }

    @Override // com.stepos.activeview.databinding.interfaces.IActiveViewApplying
    public void stopApplying() {
        if (this.mDataBindingWrapperMap.size() > 0) {
            Iterator<Map.Entry<String, IApplyBinding>> it = this.mDataBindingWrapperMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().unBind();
            }
        }
    }
}
