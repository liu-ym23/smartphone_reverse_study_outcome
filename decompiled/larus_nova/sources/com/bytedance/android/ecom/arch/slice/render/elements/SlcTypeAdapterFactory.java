package com.bytedance.android.ecom.arch.slice.render.elements;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcActionTypeAdapter;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.ISlcElement;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/SlcTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcTypeAdapterFactory implements TypeAdapterFactory {
    public SlcTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Type r102 = r101.getType();
        if (r102 != null) goto L6;
        return null;
    L6:
        if (ISlcElement.class.equals(r102) == true) goto L16;
        if (SlcElement.class.equals(r102) == true) goto L16;
        if (IAction.class.equals(r102) == true) goto L18;
        if (SlcCommonAction.class.equals(r102) == true) goto L18;
        return null;
    L18:
        return new SlcActionTypeAdapter(r100);
    L16:
        return new SlcElementTypeAdapter(r100, r100.getDelegateAdapter(this, TypeToken.get(SlcElement.class)));
    }
}
