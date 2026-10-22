package com.chad.library;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = null;

    public static class InnerBrLookup {
        static final SparseArray<String> sKeys = null;

        static {
            SparseArray<String> r10 = new SparseArray(1);
            sKeys = r10;
            r10.put(0, "_all");
        }

        private InnerBrLookup() {
        }
    }

    public static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = null;

        static {
            sKeys = new HashMap(0);
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);
    }

    public DataBinderMapperImpl() {
    }

    public List<d> collectDependencies() {
        ArrayList r10 = new ArrayList(1);
        r10.add(new a());
        return r10;
    }

    public String convertBrIdToString(int r10) {
        return InnerBrLookup.sKeys.get(r10);
    }

    @Override // androidx.databinding.d
    public ViewDataBinding getDataBinder(DataBindingComponent r10, View r11, int r12) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(r12) > 0) goto L5;
        return null;
    L5:
        if (r11.getTag() == null) goto L8;
        return null;
    L8:
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.d
    public int getLayoutId(String r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        Integer r11 = InnerLayoutIdLookup.sKeys.get(r10);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.intValue();
    }

    public ViewDataBinding getDataBinder(DataBindingComponent r10, View[] r11, int r12) {
        if (r11 != null) goto L5;
    L14:
        return null;
    L5:
        if (r11.length == 0) goto L14;
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(r12) <= 0) goto L14;
        if (r11[0].getTag() != null) goto L14;
        throw new RuntimeException("view must have a tag");
    }
}
