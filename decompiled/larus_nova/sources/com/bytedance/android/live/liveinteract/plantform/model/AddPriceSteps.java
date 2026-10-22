package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/AddPriceSteps;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/c;", "", "component1", "component2", "component3", "leftClosedInterval", "rightClosedInterval", "step", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getLeftClosedInterval", "()J", "getRightClosedInterval", "getStep", "<init>", "(JJJ)V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AddPriceSteps extends FlexModelBase<com.bytedance.android.livesdk.multilink.base.model.c> implements com.bytedance.android.livesdk.multilink.base.model.c, vh7.h {

    @SerializedName("left_closed_interval")
    protected long leftClosedInterval;

    @SerializedName("right_closed_interval")
    protected long rightClosedInterval;

    @SerializedName("step")
    protected long step;

    public AddPriceSteps(long r100, long r101, long r102) {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        this.leftClosedInterval = r100;
        this.rightClosedInterval = r101;
        this.step = r102;
    }

    public static /* synthetic */ AddPriceSteps copy$default(AddPriceSteps r100, long r101, long r110, long r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.leftClosedInterval;
    L5:
        long r102 = r101;
        if ((r112 & 2) == 0) goto L8;
        r110 = r100.rightClosedInterval;
    L8:
        long r103 = r110;
        if ((r112 & 4) == 0) goto L12;
        r111 = r100.step;
    L12:
        return r100.copy(r102, r103, r111);
    }

    public final long component1() {
        return this.leftClosedInterval;
    }

    public final long component2() {
        return this.rightClosedInterval;
    }

    public final long component3() {
        return this.step;
    }

    public final AddPriceSteps copy(long r100, long r110, long r111) {
        return new AddPriceSteps(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AddPriceSteps) == false) goto L12;
        AddPriceSteps r101 = (AddPriceSteps) r100;
        if (this.leftClosedInterval == r101.leftClosedInterval) goto L8;
        return false;
    L8:
        if (this.rightClosedInterval == r101.rightClosedInterval) goto L10;
        return false;
    L10:
        if (this.step == r101.step) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = this.leftClosedInterval;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.rightClosedInterval;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.step;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public String toString() {
        return "AddPriceSteps(leftClosedInterval=" + this.leftClosedInterval + ", rightClosedInterval=" + this.rightClosedInterval + ", step=" + this.step + ")";
    }

    public AddPriceSteps() {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        this.leftClosedInterval = 0;
        this.rightClosedInterval = 0;
        this.step = 0;
    }

    public final long getLeftClosedInterval() {
        return this.leftClosedInterval;
    }

    public final long getRightClosedInterval() {
        return this.rightClosedInterval;
    }

    public final long getStep() {
        return this.step;
    }

    public AddPriceSteps(am3.g r100) {
        super(com.bytedance.android.livesdk.multilink.base.model.c.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.leftClosedInterval = r100.j();
        r101 = r101 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.rightClosedInterval = r100.j();
        r101 = r101 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this.step = r100.j();
        r101 = r101 | 4;
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L19;
        this.leftClosedInterval = 0;
    L19:
        if ((r101 & 2) != 0) goto L22;
        this.rightClosedInterval = 0;
    L22:
        if ((r101 & 4) != 0) goto L37;
        this.step = 0;
        return;
    }

    public /* synthetic */ AddPriceSteps(long r100, long r101, long r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        long r102 = 0;
    L7:
        if ((r111 & 2) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r111 & 4) == 0) goto L13;
        long r113 = 0;
    L14:
        this(r102, r103, r113);
        return;
    L13:
        r113 = r110;
        goto L14
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
