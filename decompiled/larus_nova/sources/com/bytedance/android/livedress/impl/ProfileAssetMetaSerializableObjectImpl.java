package com.bytedance.android.livedress.impl;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livedress/impl/ProfileAssetMetaSerializableObjectImpl;", "Lcom/bytedance/android/livedress/impl/p;", "Lcom/bytedance/android/livedress/impl/s;", "borderEnterWebp", "Lcom/bytedance/android/livedress/impl/s;", "a0", "()Lcom/bytedance/android/livedress/impl/s;", "P5", "(Lcom/bytedance/android/livedress/impl/s;)V", "borderLoopWebp", "u5", "F5", "panelExitWebp", "P4", "o9", "<init>", "()V", "Adapter", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfileAssetMetaSerializableObjectImpl implements p {

    @SerializedName("border_begin.webp")
    private s borderEnterWebp;

    @SerializedName("border_loop.webp")
    private s borderLoopWebp;

    @SerializedName("exit_anim.webp")
    private s panelExitWebp;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livedress/impl/ProfileAssetMetaSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ProfileAssetMetaSerializableObjectImpl.class);
        }
    }

    public ProfileAssetMetaSerializableObjectImpl() {
        this.borderEnterWebp = (s) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(s.class);
        this.borderLoopWebp = (s) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(s.class);
        this.panelExitWebp = (s) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(s.class);
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final s P4() {
        return this.panelExitWebp;
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final s a0() {
        return this.borderEnterWebp;
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final s u5() {
        return this.borderLoopWebp;
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final void F5(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.borderLoopWebp = r100;
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final void P5(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.borderEnterWebp = r100;
    }

    @Override // com.bytedance.android.livedress.impl.p
    public final void o9(s r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.panelExitWebp = r100;
    }
}
