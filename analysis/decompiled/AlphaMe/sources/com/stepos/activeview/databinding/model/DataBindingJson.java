package com.stepos.activeview.databinding.model;

import com.stepos.activeview.databinding.interfaces.DataBinding;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DataBindingJson implements DataBinding {
    protected static final String ATTR_NAME_ROTATE3D = "rotate3d";
    protected List<String> mBindingAttrs = new ArrayList();
    private String[] rotate3d;

    @Override // com.stepos.activeview.databinding.interfaces.DataBinding
    public String[] getRotate3d() {
        return this.rotate3d;
    }

    @Override // com.stepos.activeview.databinding.interfaces.DataBinding
    public void setRotate3d(String[] strArr) {
        this.rotate3d = strArr;
        if (strArr == null || strArr.length <= 0 || this.mBindingAttrs.contains(ATTR_NAME_ROTATE3D)) {
            return;
        }
        this.mBindingAttrs.add(ATTR_NAME_ROTATE3D);
    }
}
