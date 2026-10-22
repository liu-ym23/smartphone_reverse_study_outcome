package com.bytedance.android.live.network;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.NameValuePair;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f83798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<NameValuePair> f83799b;

        public final String a() {
            if (TextUtils.isEmpty(this.f83798a) == false) goto L12;
            return "";
        L12:
            URI r100 = b(this.f83798a);     // Catch: Exception -> L11
            if (r100 == null) goto L14;
            return r100.getPath();
        L14:
            return "";
        L15:
            return "";
        }

        public static URI b(String r100) throws RuntimeException {
            if (r100 != null) goto L5;
        L22:
            return null;
        L5:
            if (r100.isEmpty() == true) goto L22;
            return new URI(r100);
        L9:
            return URI.create(r100.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        L12:
            if (r100.isEmpty() == true) goto L28;
            int r101 = r100.indexOf("?");     // Catch: Exception -> L19
            if (r101 <= 0) goto L17;
            r100 = r100.substring(0, r101);     // Catch: Exception -> L19
        L17:
            return URI.create(r100);
        L19:
            e = move-exception;
            throw new RuntimeException(e);
        L28:
            return null;
        }

        public a(String r100, List<NameValuePair> r101) {
            this.f83798a = r100;
            if (r101 != null) goto L6;
            r101 = new ArrayList();
        L6:
            this.f83799b = r101;
        }
    }
}
