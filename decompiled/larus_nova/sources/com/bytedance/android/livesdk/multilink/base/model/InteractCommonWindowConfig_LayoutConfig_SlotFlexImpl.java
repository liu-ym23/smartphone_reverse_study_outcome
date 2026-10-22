package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.linkmic_audience.GetLayoutConfigResponse.Slot")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R+\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R+\u0010%\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/InteractCommonWindowConfig_LayoutConfig_SlotFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/q0$a$d;", "", "<set-?>", "p$delegate", "Ljava/lang/Object;", "getP", "()I", "setP", "(I)V", "p", "", "x$delegate", "getX", "()D", "setX", "(D)V", "x", "y$delegate", "getY", "setY", "y", "w$delegate", "getW", "setW", "w", "h$delegate", "getH", "setH", "h", "", "need_UI$delegate", "getNeed_UI", "()Z", "setNeed_UI", "(Z)V", "need_UI", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommonWindowConfig_LayoutConfig_SlotFlexImpl extends FlexModelBase<q0.a.d> implements q0.a.d, vh7.h {

    @SerializedName("h")
    protected double _$$h;

    @SerializedName("need_UI")
    protected boolean _$$need_UI;

    @SerializedName("p")
    protected int _$$p;

    @SerializedName("w")
    protected double _$$w;

    @SerializedName("x")
    protected double _$$x;

    @SerializedName("y")
    protected double _$$y;

    public InteractCommonWindowConfig_LayoutConfig_SlotFlexImpl() {
        super(q0.a.d.class);
        this._$$need_UI = false;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final double getH() {
        return this._$$h;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final boolean getNeed_UI() {
        return this._$$need_UI;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final int getP() {
        return this._$$p;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final double getW() {
        return this._$$w;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final double getX() {
        return this._$$x;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final double getY() {
        return this._$$y;
    }

    public InteractCommonWindowConfig_LayoutConfig_SlotFlexImpl(am3.g r100) {
        super(q0.a.d.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$need_UI = am3.h.a(r100);
        r102 = r102 | 32;
        goto L3
    L9:
        this._$$h = Double.longBitsToDouble(r100.h());
        r102 = r102 | 16;
        goto L3
    L10:
        this._$$w = Double.longBitsToDouble(r100.h());
        r102 = r102 | 8;
        goto L3
    L11:
        this._$$y = Double.longBitsToDouble(r100.h());
        r102 = r102 | 4;
        goto L3
    L12:
        this._$$x = Double.longBitsToDouble(r100.h());
        r102 = r102 | 2;
        goto L3
    L13:
        this._$$p = r100.i();
        r102 = r102 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 32) != 0) goto L34;
        this._$$need_UI = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public float getH(Integer r100) {
        if (r100 != null) goto L4;
    L12:
        float r101 = (float) getH();
        float r102 = 640.0f;
    L14:
        return r101 / r102;
    L4:
        if (r100.intValue() == 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        Integer r104 = r100;
    L10:
        if (r104 == null) goto L12;
        r104.intValue();
        r101 = (float) getH();
        r102 = r100.intValue();
        goto L14
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public float getW(Integer r100) {
        if (r100 != null) goto L4;
    L12:
        float r101 = (float) getW();
        float r102 = 360.0f;
    L14:
        return r101 / r102;
    L4:
        if (r100.intValue() == 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        Integer r104 = r100;
    L10:
        if (r104 == null) goto L12;
        r104.intValue();
        r101 = (float) getW();
        r102 = r100.intValue();
        goto L14
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public float getX(Integer r100) {
        if (r100 != null) goto L4;
    L12:
        float r101 = (float) getX();
        float r102 = 360.0f;
    L14:
        return r101 / r102;
    L4:
        if (r100.intValue() == 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        Integer r104 = r100;
    L10:
        if (r104 == null) goto L12;
        r104.intValue();
        r101 = (float) getX();
        r102 = r100.intValue();
        goto L14
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public float getY(Integer r100) {
        if (r100 != null) goto L4;
    L12:
        float r101 = (float) getY();
        float r102 = 640.0f;
    L14:
        return r101 / r102;
    L4:
        if (r100.intValue() == 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        Integer r104 = r100;
    L10:
        if (r104 == null) goto L12;
        r104.intValue();
        r101 = (float) getY();
        r102 = r100.intValue();
        goto L14
    L9:
        r104 = null;
        goto L10
    L6:
        r103 = false;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setH(double r100) {
        this._$$h = r100;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setNeed_UI(boolean r100) {
        this._$$need_UI = r100;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setP(int r100) {
        this._$$p = r100;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setW(double r100) {
        this._$$w = r100;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setX(double r100) {
        this._$$x = r100;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.q0.a.d
    public final void setY(double r100) {
        this._$$y = r100;
    }
}
