package com.baidu.mapauto.auth.net.format;

import B0.g;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.http.HttpClient;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7686a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f7687b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f7688c;

    static {
        String string = UUID.randomUUID().toString();
        f7686a = string;
        f7687b = g.n("\r\n--", string, HttpClient.NEWLINE);
        f7688c = g.n("\r\n--", string, "--\r\n");
    }

    public final String a(HashMap map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof File) {
                throw new UnsupportedOperationException();
            }
            if (obj != null) {
                String string = obj.toString();
                AbstractC0351g.C(sb, f7687b, "Content-Disposition: form-data; name=\"", str, "\"\r\n\r\n");
                sb.append(string);
            }
        }
        sb.append(f7688c);
        return sb.toString();
    }
}
