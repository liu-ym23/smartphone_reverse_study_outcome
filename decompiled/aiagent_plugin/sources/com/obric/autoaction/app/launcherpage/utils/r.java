package com.obric.autoaction.app.launcherpage.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: GsonUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements TypeAdapterFactory {
    public r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r2, TypeToken<T> r3) {
        String r1 = null;
        Object[] r4 = 0;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (WidgetState.class.isAssignableFrom(r3.getRawType()) == false) goto L9;
        Class<? super T> r5 = r3.getRawType();
        d.h.b.o.c(r5, "getRawType(...)");
        return (TypeAdapter) ZeusTransformUtils.preCheckCast(new q(r5, r1, 2, r4 == true ? 1 : 0), TypeAdapter.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }
}
