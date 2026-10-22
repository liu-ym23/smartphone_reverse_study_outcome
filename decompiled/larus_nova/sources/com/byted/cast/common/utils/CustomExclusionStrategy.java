package com.byted.cast.common.utils;

import android.text.TextUtils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class CustomExclusionStrategy implements ExclusionStrategy {
    private List<String> mSkipFileds;

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> r100) {
        return false;
    }

    public CustomExclusionStrategy() {
        this.mSkipFileds = new ArrayList();
    }

    public void addAll(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        this.mSkipFileds.clear();
        this.mSkipFileds.addAll(r100);
        return;
    }

    @Override // com.google.gson.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes r100) {
        Iterator<String> r101 = this.mSkipFileds.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        if (TextUtils.equals(r100.getName(), r102) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
