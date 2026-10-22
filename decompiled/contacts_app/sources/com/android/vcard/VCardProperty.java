package com.android.vcard;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class VCardProperty {
    private static final String LOG_TAG = "vCard";
    private byte[] mByteValue;
    private List<String> mGroupList;
    private String mName;
    private Map<String, Collection<String>> mParameterMap;
    private String mRawValue;
    private List<String> mValueList;

    public VCardProperty() {
        this.mParameterMap = new HashMap();
    }

    public void setName(String r4) {
        String r0 = this.mName;
        if (r0 == null) goto L5;
        Log.w(LOG_TAG, String.format("Property name is re-defined (existing: %s, requested: %s", new Object[]{r0, r4}));
    L5:
        this.mName = r4;
    }

    public void addGroup(String r2) {
        if (this.mGroupList != null) goto L5;
        this.mGroupList = new ArrayList();
    L5:
        this.mGroupList.add(r2);
    }

    public void setParameter(String r2, String r3) {
        this.mParameterMap.clear();
        addParameter(r2, r3);
    }

    public void addParameter(String r2, String r3) {
        if (this.mParameterMap.containsKey(r2) == false) goto L5;
        Collection<String> r0 = this.mParameterMap.get(r2);
    L10:
        r0.add(r3);
        return;
    L5:
        if (r2.equals(VCardConstants.PARAM_TYPE) == false) goto L7;
        r0 = new HashSet();
    L8:
        this.mParameterMap.put(r2, r0);
        goto L10
    L7:
        r0 = new ArrayList();
        goto L8
    }

    public void setRawValue(String r1) {
        this.mRawValue = r1;
    }

    public void setValues(String... r1) {
        this.mValueList = Arrays.asList(r1);
    }

    public void setValues(List<String> r1) {
        this.mValueList = r1;
    }

    public void addValues(String... r2) {
        List<String> r0 = this.mValueList;
        if (r0 != null) goto L5;
        this.mValueList = Arrays.asList(r2);
        return;
    L5:
        r0.addAll(Arrays.asList(r2));
    }

    public void addValues(List<String> r2) {
        List<String> r0 = this.mValueList;
        if (r0 != null) goto L5;
        this.mValueList = new ArrayList(r2);
        return;
    L5:
        r0.addAll(r2);
    }

    public void setByteValue(byte[] r1) {
        this.mByteValue = r1;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getGroupList() {
        return this.mGroupList;
    }

    public Map<String, Collection<String>> getParameterMap() {
        return this.mParameterMap;
    }

    public Collection<String> getParameters(String r1) {
        return this.mParameterMap.get(r1);
    }

    public String getRawValue() {
        return this.mRawValue;
    }

    public List<String> getValueList() {
        return this.mValueList;
    }

    public byte[] getByteValue() {
        return this.mByteValue;
    }
}
