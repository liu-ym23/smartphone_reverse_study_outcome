package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.AvatarBorderConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IAvatarBorderConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/b;", "Lpy/k;", "avatarBorder", "Lpy/k;", "getAvatarBorder", "()Lpy/k;", "setAvatarBorder", "(Lpy/k;)V", "thumbAvatarBorder", "getThumbAvatarBorder", "setThumbAvatarBorder", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAvatarBorderConfigFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("avatar_border")
    protected py.k avatarBorder;

    @SerializedName("thumb_avatar_border")
    protected py.k thumbAvatarBorder;

    public IAvatarBorderConfigFlexImpl() {
        super(b.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IAvatarBorderConfigFlexImpl(am3.g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.avatarBorder = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.thumbAvatarBorder = vh7.f.a(r100, py.k.class);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.b
    public py.k getAvatarBorder() {
        return this.avatarBorder;
    }

    @Override // com.bytedance.android.live.profit.dress.config.b
    public py.k getThumbAvatarBorder() {
        return this.thumbAvatarBorder;
    }

    public void setAvatarBorder(py.k r100) {
        this.avatarBorder = r100;
    }

    public void setThumbAvatarBorder(py.k r100) {
        this.thumbAvatarBorder = r100;
    }
}
