package com.bytedance.android.livedress.impl;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(ProfileImageMetaSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livedress/impl/s;", "Lvh7/j;", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s extends vh7.j<s> {

    @JsonAdapter(ProfileImageMetaSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "height")
    int getHeight();

    @FieldName(name = "width")
    int getWidth();
}
