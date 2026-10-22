package com.bytedance.android.livesdkapi.message;

import am3.c;
import com.bytedance.android.live.base.model.message.t;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface IExternalMessageInject {
    void injectAllMessageClz(Map<String, Class<? extends t>> r100);

    void injectMessageDecoder(Map<Class, c> r100);
}
