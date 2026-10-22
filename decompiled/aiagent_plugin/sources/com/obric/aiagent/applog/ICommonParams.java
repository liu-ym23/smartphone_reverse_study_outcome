package com.obric.aiagent.applog;

import java.util.Map;

/* JADX INFO: compiled from: ICommonParams.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ICommonParams {

    /* JADX INFO: compiled from: ICommonParams.kt */
    public interface a {
        void a(String r1, String r2);
    }

    void addCommonParams(String r1, String r2);

    void addParamUpdateListener(String r1, a r2);

    String getCommonParam(String r1);

    void init();

    void putCommonParams(Map<String, String> r1);

    void removeParamUpdateListener(String r1, a r2);
}
