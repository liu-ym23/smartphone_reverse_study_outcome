package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.HonorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILiveplaysHonorInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/ja;", "", "honorScene$delegate", "Ljava/lang/Object;", "getHonorScene", "()I", "honorScene", "honorType$delegate", "getHonorType", "honorType", "duration$delegate", "getDuration", "duration", "", "playEndTimestamp$delegate", "getPlayEndTimestamp", "()J", "playEndTimestamp", "", "body$delegate", "getBody", "()Ljava/lang/String;", ContainerPosition.BODY, "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILiveplaysHonorInfoFlexImpl extends FlexModelBase<ja> implements ja, vh7.h {

    @SerializedName(ContainerPosition.BODY)
    protected String _$$body;

    @SerializedName("duration")
    protected int _$$duration;

    @SerializedName("honor_scene")
    protected int _$$honorScene;

    @SerializedName("honor_type")
    protected int _$$honorType;

    @SerializedName("play_end_timestamp")
    protected long _$$playEndTimestamp;

    public ILiveplaysHonorInfoFlexImpl() {
        super(ja.class);
        this._$$body = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.ja
    public final String getBody() {
        return this._$$body;
    }

    @Override // com.bytedance.android.livesdk.message.model.ja
    public final int getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.message.model.ja
    public final int getHonorScene() {
        return this._$$honorScene;
    }

    @Override // com.bytedance.android.livesdk.message.model.ja
    public final int getHonorType() {
        return this._$$honorType;
    }

    @Override // com.bytedance.android.livesdk.message.model.ja
    public final long getPlayEndTimestamp() {
        return this._$$playEndTimestamp;
    }

    public ILiveplaysHonorInfoFlexImpl(am3.g r100) {
        super(ja.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$honorScene = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$honorType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$body = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$duration = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$playEndTimestamp = r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$body != null) goto L43;
        this._$$body = "";
        return;
    }
}
