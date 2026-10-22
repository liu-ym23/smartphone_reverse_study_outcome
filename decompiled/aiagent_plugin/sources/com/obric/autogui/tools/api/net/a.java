package com.obric.autogui.tools.api.net;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: AOHttpClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.tools.api.net.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOHttpClient.kt */
    public interface InterfaceC0861a<T> {
        com.obric.autogui.tools.api.net.b a(Context r1);

        boolean a();

        T c();
    }

    /* JADX INFO: compiled from: AOHttpClient.kt */
    public interface b {
        void a();
    }

    Object a(Context r1, String r2, Object r3, int r4, boolean r5, com.obric.autogui.tools.api.net.a.a r6, d.c.d<? super InterfaceC0861a<b>> r7);

    Object a(String r1, String r2, int r3, d.c.d<? super InterfaceC0861a<String>> r4);

    Object a(String r1, Map<String, String> r2, int r3, d.c.d<? super InterfaceC0861a<String>> r4);

    Object a(String r1, Map<String, String> r2, String r3, int r4, d.c.d<? super InterfaceC0861a<String>> r5);
}
