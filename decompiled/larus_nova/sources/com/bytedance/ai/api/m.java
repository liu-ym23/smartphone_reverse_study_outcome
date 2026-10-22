package com.bytedance.ai.api;

import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface m {
    void onServerAction(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105, String r106, String r107, Long r108, Integer r110, Function1<? super String, Boolean> r111);

    void onUIAction(String r100, String r101, String r102, String r103, String r104, Map<String, String> r105, String r106, String r107, Long r108, Integer r110, Function1<? super String, Boolean> r111);
}
