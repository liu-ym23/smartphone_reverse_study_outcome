package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
class GetRequest {
    private static final Pattern RANGE_HEADER_PATTERN = null;
    private static final Pattern URL_PATTERN = null;
    public final boolean partial;
    public final long rangeOffset;
    public final String uri;

    static {
        RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
        URL_PATTERN = Pattern.compile("GET /(.*) HTTP");
    }

    public GetRequest(String r10) {
        Preconditions.checkNotNull(r10);
        long r11 = findRangeOffset(r10);
        this.rangeOffset = Math.max(0, r11);
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        this.partial = r12;
        this.uri = findUri(r10);
        return;
    L5:
        r12 = false;
        goto L6
    }

    private long findRangeOffset(String r10) {
        Matcher r11 = RANGE_HEADER_PATTERN.matcher(r10);
        if (r11.find() == true) goto L5;
        return -1;
    L5:
        return Long.parseLong(r11.group(1));
    }

    private String findUri(String r10) {
        Matcher r11 = URL_PATTERN.matcher(r10);
        if (r11.find() == false) goto L7;
        return r11.group(1);
    L7:
        throw new IllegalArgumentException("Invalid request `" + r10 + "`: url not found!");
    }

    public static GetRequest read(InputStream r10) throws IOException {
        BufferedReader r11 = new BufferedReader(new InputStreamReader(r10, "UTF-8"));
        StringBuilder r12 = new StringBuilder();
    L3:
        String r13 = r11.readLine();
        if (TextUtils.isEmpty(r13) == true) goto L7;
        r12.append(r13);
        r12.append('\n');
        goto L3
    L7:
        return new GetRequest(r12.toString());
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.rangeOffset + ", partial=" + this.partial + ", uri='" + this.uri + "'}";
    }
}
