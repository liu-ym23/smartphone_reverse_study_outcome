package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchRoomImInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomImInfo;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomImInfo extends FlexModelBase<IMatchRoomImInfo> implements IMatchRoomImInfo, h {

    @SerializedName("icon")
    protected k icon;

    @SerializedName("title")
    protected String title;

    public MatchRoomImInfo() {
        super(IMatchRoomImInfo.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public MatchRoomImInfo(g r100) {
        super(IMatchRoomImInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.icon = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.title = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo
    public k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo
    public void setIcon(k r100) {
        this.icon = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo
    public void setTitle(String r100) {
        this.title = r100;
    }
}
