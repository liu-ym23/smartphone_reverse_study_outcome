package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.InitInfoSetting")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0011\u0010\u0011\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/InitInfoSetting;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g0;", "", "scene", "I", "getScene", "()I", "setScene", "(I)V", "uiLayout", "getUiLayout", "setUiLayout", "autoOpen", "getAutoOpen", "setAutoOpen", "", "isValid", "()Z", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitInfoSetting extends FlexModelBase<g0> implements g0, vh7.h {

    @SerializedName("auto_open")
    protected int autoOpen;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("ui_layout")
    protected int uiLayout;

    public InitInfoSetting() {
        super(g0.class);
    }

    public final boolean isValid() {
        if (getScene() == 0) goto L5;
    L10:
        return true;
    L5:
        if (getUiLayout() != 0) goto L10;
        if (getAutoOpen() != 0) goto L10;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public int getAutoOpen() {
        return this.autoOpen;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public int getScene() {
        return this.scene;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public int getUiLayout() {
        return this.uiLayout;
    }

    public InitInfoSetting(am3.g r100) {
        super(g0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.scene = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.uiLayout = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.autoOpen = (int) r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public void setAutoOpen(int r100) {
        this.autoOpen = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public void setScene(int r100) {
        this.scene = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g0
    public void setUiLayout(int r100) {
        this.uiLayout = r100;
    }
}
