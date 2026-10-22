package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int r10);

    NameValuePair getParameterByName(String r10);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
