package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.BattleGetPanelListResponse.AutoMatchInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010!\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR+\u0010%\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAutoMatchInfoPanelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/f0;", "Lcom/bytedance/android/livesdk/link/model/d0;", "<set-?>", "config$delegate", "Ljava/lang/Object;", "getConfig", "()Lcom/bytedance/android/livesdk/link/model/d0;", "setConfig", "(Lcom/bytedance/android/livesdk/link/model/d0;)V", "config", "", "mainTitle$delegate", "getMainTitle", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "mainTitle", "subTitle$delegate", "getSubTitle", "setSubTitle", "subTitle", "", "waitSec$delegate", "getWaitSec", "()J", "setWaitSec", "(J)V", "waitSec", "accelerateLimit$delegate", "getAccelerateLimit", "setAccelerateLimit", "accelerateLimit", "defaultWaitLimit$delegate", "getDefaultWaitLimit", "setDefaultWaitLimit", "defaultWaitLimit", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAutoMatchInfoPanelFlexImpl extends FlexModelBase<f0> implements f0, vh7.h {

    @SerializedName("accelerate_limit")
    protected long _$$accelerateLimit;

    @SerializedName("config")
    protected d0 _$$config;

    @SerializedName("default_wait_limit")
    protected long _$$defaultWaitLimit;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    protected String _$$mainTitle;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String _$$subTitle;

    @SerializedName("wait_sec")
    protected long _$$waitSec;

    public IAutoMatchInfoPanelFlexImpl() {
        super(f0.class);
        this._$$mainTitle = "";
        this._$$subTitle = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final long getAccelerateLimit() {
        return this._$$accelerateLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final d0 getConfig() {
        return this._$$config;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final long getDefaultWaitLimit() {
        return this._$$defaultWaitLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final String getMainTitle() {
        return this._$$mainTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final long getWaitSec() {
        return this._$$waitSec;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.link.model.d0, java.lang.Object] */
    public IAutoMatchInfoPanelFlexImpl(am3.g r100) {
        super(f0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$mainTitle = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$subTitle = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$waitSec = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._$$accelerateLimit = r100.j();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this._$$config = vh7.f.a(r100, d0.class);
        goto L3
    L16:
        if (r102 != 7) goto L17;
        this._$$defaultWaitLimit = r100.j();
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$mainTitle != null) goto L28;
        this._$$mainTitle = "";
    L28:
        if (this._$$subTitle != null) goto L52;
        this._$$subTitle = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final void setAccelerateLimit(long r100) {
        this._$$accelerateLimit = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final void setConfig(d0 r100) {
        this._$$config = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final void setDefaultWaitLimit(long r100) {
        this._$$defaultWaitLimit = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final void setMainTitle(String r100) {
        this._$$mainTitle = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0
    public final void setSubTitle(String r100) {
        this._$$subTitle = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.f0, af2.a
    public final void setWaitSec(long r100) {
        this._$$waitSec = r100;
    }
}
