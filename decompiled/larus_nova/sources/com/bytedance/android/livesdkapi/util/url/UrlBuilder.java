package com.bytedance.android.livesdkapi.util.url;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class UrlBuilder {
    private String mEncoding;
    private final List<BasicNameValuePair> mList;
    private String mUrl;

    public String build() {
        if (this.mList.isEmpty() == true) goto L5;
        String r100 = URLEncodedUtils.format(this.mList, this.mEncoding);
        String r101 = this.mUrl;
        if (r101 != null) goto L9;
        return r100;
    L9:
        if (r101.length() == 0) goto L22;
        int r102 = this.mUrl.indexOf(63);
        if (r102 < 0) goto L20;
        if (this.mUrl.indexOf(61, r102) <= 0) goto L18;
        int r103 = r102 + 1;
        return this.mUrl.substring(0, r103) + r100 + "&" + this.mUrl.substring(r103);
    L18:
        return this.mUrl + "&" + r100;
    L20:
        return this.mUrl + "?" + r100;
    L22:
        return r100;
    L5:
        return this.mUrl;
    }

    public UrlBuilder() {
        this.mList = new ArrayList();
        this.mEncoding = "UTF-8";
        this.mUrl = null;
    }

    public String toString() {
        return build();
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public List<BasicNameValuePair> getParamList() {
        return this.mList;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public UrlBuilder(String r100) {
        this.mList = new ArrayList();
        this.mEncoding = "UTF-8";
        this.mUrl = r100;
    }

    public void setEncoding(String r100) {
        this.mEncoding = r100;
    }

    public void setUrl(String r100) {
        this.mUrl = r100;
    }

    public UrlBuilder addParam(String r100, double r101) {
        this.mList.add(new BasicNameValuePair(r100, String.valueOf(r101)));
        return this;
    }

    public UrlBuilder addParam(String r100, int r101) {
        this.mList.add(new BasicNameValuePair(r100, String.valueOf(r101)));
        return this;
    }

    public UrlBuilder addParam(String r100, long r101) {
        this.mList.add(new BasicNameValuePair(r100, String.valueOf(r101)));
        return this;
    }

    public UrlBuilder addParam(String r100, String r101) {
        this.mList.add(new BasicNameValuePair(r100, r101));
        return this;
    }
}
