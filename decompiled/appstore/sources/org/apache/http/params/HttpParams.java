package org.apache.http.params;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HttpParams {
    HttpParams copy();

    boolean getBooleanParameter(String r10, boolean r11);

    double getDoubleParameter(String r10, double r11);

    int getIntParameter(String r10, int r11);

    long getLongParameter(String r10, long r11);

    Object getParameter(String r10);

    boolean isParameterFalse(String r10);

    boolean isParameterTrue(String r10);

    boolean removeParameter(String r10);

    HttpParams setBooleanParameter(String r10, boolean r11);

    HttpParams setDoubleParameter(String r10, double r11);

    HttpParams setIntParameter(String r10, int r11);

    HttpParams setLongParameter(String r10, long r11);

    HttpParams setParameter(String r10, Object r11);
}
