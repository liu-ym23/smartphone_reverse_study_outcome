package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_profit.MVTab")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/MVTab;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "()V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MVTab extends FlexModelBase<IMVTab> implements IMVTab, vh7.h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected String f106933id;

    @SerializedName("name")
    protected String name;

    public MVTab() {
        super(IMVTab.class);
        this.f106933id = "";
        this.name = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVTab
    public String getId() {
        return this.f106933id;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVTab
    public String getName() {
        return this.name;
    }

    public MVTab(am3.g r100) {
        super(IMVTab.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.f106933id = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.name = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this.f106933id != null) goto L16;
        this.f106933id = "";
    L16:
        if (this.name != null) goto L28;
        this.name = "";
        return;
    }
}
