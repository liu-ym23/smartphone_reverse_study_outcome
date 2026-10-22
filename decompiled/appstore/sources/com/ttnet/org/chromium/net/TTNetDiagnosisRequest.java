package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TTNetDiagnosisRequest {

    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r10, String r11);
    }

    public static abstract class a {
        public a() {
        }

        public abstract TTNetDiagnosisRequest a();

        public abstract a b(int r10);

        public abstract a c(int r10);

        public abstract a d(List r10);

        public abstract a e(int r10);
    }

    public TTNetDiagnosisRequest() {
    }

    public abstract void a();

    public abstract void b(String r10, String r11);

    public abstract void c();
}
