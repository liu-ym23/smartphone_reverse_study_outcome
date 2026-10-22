package com.android.server.am;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ServiceRecordSmtEx {
    static final List<String> FORGROUND_SERVICE_SPECIAL_LIST = null;

    public ServiceRecordSmtEx() {
    }

    static {
        FORGROUND_SERVICE_SPECIAL_LIST = Arrays.asList(new String[]{"com.tencent.mm", "com.ss.android.lark", "com.tencent.mobileqq"});
    }
}
