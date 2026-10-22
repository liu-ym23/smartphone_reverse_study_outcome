package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.AnchorOpenGameRoleInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkerGameRole;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/IAnchorGameRoleBridge;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "role", "", "getRole", "()Ljava/lang/Integer;", "setRole", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkerGameRole extends FlexModelBase<IAnchorGameRoleBridge> implements IAnchorGameRoleBridge, vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("role")
    protected Integer role;

    public AnchorLinkerGameRole() {
        super(IAnchorGameRoleBridge.class);
        this.role = 0;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public Integer getRole() {
        return this.role;
    }

    public AnchorLinkerGameRole(am3.g r100) {
        super(IAnchorGameRoleBridge.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.role = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.content = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.role != null) goto L25;
        this.role = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public void setContent(String r100) {
        this.content = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.IAnchorGameRoleBridge
    public void setRole(Integer r100) {
        this.role = r100;
    }
}
