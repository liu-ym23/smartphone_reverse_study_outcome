package com.bytedance.android.livedress.impl;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livedress/impl/ProfileImageMetaSerializableObjectImpl;", "Lcom/bytedance/android/livedress/impl/s;", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "<init>", "()V", "Adapter", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfileImageMetaSerializableObjectImpl implements s {

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livedress/impl/ProfileImageMetaSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ProfileImageMetaSerializableObjectImpl.class);
        }
    }

    public ProfileImageMetaSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.livedress.impl.s
    public final int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.android.livedress.impl.s
    public final int getWidth() {
        return this.width;
    }
}
