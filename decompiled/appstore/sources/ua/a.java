package ua;

import kotlin.jvm.internal.q;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final String a(Headers r10) {
        q.g(r10, "<this>");
        return r10.b("x-tt-logid");
    }
}
