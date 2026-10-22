package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes.dex */
public interface HttpStack {
    HttpResponse performRequest(Request<?> r10, Map<String, String> r11) throws IOException, AuthFailureError;
}
