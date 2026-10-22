package com.ss.android.http.legacy;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int r10);

    NameValuePair getParameterByName(String r10);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
