package com.bytedance.android.ec.adapter.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public interface i {
    long a(@IUxTracerAdapter$Companion$Scene String r100);

    void b();

    Object getArgument(String r100);

    void getSingleTimeStamp(String r100);

    void setBeforeReportCallback(Function0<Unit> r100);
}
