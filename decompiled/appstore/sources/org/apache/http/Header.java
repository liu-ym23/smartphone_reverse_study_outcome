package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
