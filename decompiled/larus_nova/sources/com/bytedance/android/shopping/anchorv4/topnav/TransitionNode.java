package com.bytedance.android.shopping.anchorv4.topnav;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/topnav/TransitionNode;", "Ljava/io/Serializable;", "sliceKey", "", "reverse", "", "start", "", "end", "startEdge", "endEdge", "(Ljava/lang/String;ZFFFF)V", "getEnd", "()F", "getEndEdge", "getReverse", "()Z", "getSliceKey", "()Ljava/lang/String;", "getStart", "getStartEdge", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionNode implements Serializable {

    @SerializedName("end")
    private final float end;

    @SerializedName("end_edge")
    private final float endEdge;

    @SerializedName("reverse")
    private final boolean reverse;

    @SerializedName(SlcElement.KEY_SLICE_KEY)
    private final String sliceKey;

    @SerializedName("start")
    private final float start;

    @SerializedName("start_edge")
    private final float startEdge;

    public TransitionNode() {
        this(null, false, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getEndEdge() {
        return this.endEdge;
    }

    public final boolean getReverse() {
        return this.reverse;
    }

    public final String getSliceKey() {
        return this.sliceKey;
    }

    public final float getStart() {
        return this.start;
    }

    public final float getStartEdge() {
        return this.startEdge;
    }

    public TransitionNode(String r100, boolean r101, float r102, float r103, float r104, float r105) {
        this.sliceKey = r100;
        this.reverse = r101;
        this.start = r102;
        this.end = r103;
        this.startEdge = r104;
        this.endEdge = r105;
    }

    public /* synthetic */ TransitionNode(String r100, boolean r101, float r102, float r103, float r104, float r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = false;
    L9:
        float r105 = 0.0f;
        if ((r111 & 4) == 0) goto L12;
        float r106 = 0.0f;
    L14:
        if ((r111 & 8) == 0) goto L16;
        float r107 = 0.0f;
    L18:
        if ((r111 & 16) == 0) goto L20;
        float r108 = 0.0f;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L9
    }
}
