package com.ss.android.pushmanager.app;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ApiException extends IOException {
    int httpStatus;

    public ApiException(String r10, int r11) {
        super(r10);
        this.httpStatus = r11;
    }
}
