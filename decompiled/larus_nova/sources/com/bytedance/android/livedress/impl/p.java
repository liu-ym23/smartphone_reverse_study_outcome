package com.bytedance.android.livedress.impl;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(ProfileAssetMetaSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livedress/impl/p;", "Lvh7/j;", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.j<p> {

    @JsonAdapter(ProfileAssetMetaSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "border_loop.webp#setter")
    void F5(s r100);

    @FieldName(name = "exit_anim.webp")
    s P4();

    @FieldName(name = "border_begin.webp#setter")
    void P5(s r100);

    @FieldName(name = "border_begin.webp")
    s a0();

    @FieldName(name = "exit_anim.webp#setter")
    void o9(s r100);

    @FieldName(name = "border_loop.webp")
    s u5();
}
