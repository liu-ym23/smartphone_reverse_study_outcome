package okhttp3.internal.http;

import com.android.volley.toolbox.HttpClientStack;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String r10) {
        if (r10.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r10.equals(HttpClientStack.HttpPatch.METHOD_NAME) == true) goto L14;
        if (r10.equals("PUT") == true) goto L14;
        if (r10.equals("DELETE") == true) goto L14;
        if (r10.equals("MOVE") == true) goto L14;
        return false;
    }

    public static boolean permitsRequestBody(String r10) {
        if (r10.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals("HEAD") == true) goto L7;
        return true;
    }

    public static boolean redirectsToGet(String r10) {
        return !r10.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(String r10) {
        return r10.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String r10) {
        if (r10.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r10.equals("PUT") == true) goto L14;
        if (r10.equals(HttpClientStack.HttpPatch.METHOD_NAME) == true) goto L14;
        if (r10.equals("PROPPATCH") == true) goto L14;
        if (r10.equals("REPORT") == true) goto L14;
        return false;
    }
}
