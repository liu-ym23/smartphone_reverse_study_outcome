package org.apache.http.params;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;
    private final Map<String, Object> parameters;

    public BasicHttpParams() {
        this.parameters = new ConcurrentHashMap();
    }

    public void clear() {
        this.parameters.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams r10 = (BasicHttpParams) super.clone();
        copyParams(r10);
        return r10;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams copy() {
        return (HttpParams) clone();
    L5:
        throw new UnsupportedOperationException("Cloning not supported");
    }

    public void copyParams(HttpParams r10) {
        Iterator<Map.Entry<String, Object>> r11 = this.parameters.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, Object> r12 = r11.next();
        r10.setParameter(r12.getKey(), r12.getValue());
        goto L4
    }

    @Override // org.apache.http.params.AbstractHttpParams, org.apache.http.params.HttpParamsNames
    public Set<String> getNames() {
        return new HashSet(this.parameters.keySet());
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String r10) {
        return this.parameters.get(r10);
    }

    public boolean isParameterSet(String r10) {
        if (getParameter(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isParameterSetLocally(String r10) {
        if (this.parameters.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String r10) {
        if (this.parameters.containsKey(r10) == false) goto L6;
        this.parameters.remove(r10);
        return true;
    L6:
        return false;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String r10, Object r11) {
        if (r10 != null) goto L4;
        return this;
    L4:
        if (r11 == null) goto L6;
        this.parameters.put(r10, r11);
    L7:
        return this;
    L6:
        this.parameters.remove(r10);
        goto L7
    }

    public void setParameters(String[] r10, Object r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        setParameter(r10[r13], r11);
        r13 = r13 + 1;
        goto L3
    }

    public String toString() {
        return "[parameters=" + this.parameters + "]";
    }
}
