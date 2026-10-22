package com.bytedance.android.livesdk.chatroom.statuspanel;

import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/statuspanel/AnchorPerfShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Ly6a/h;", "<init>", "()V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfShadowNode extends ShadowNode implements h {
    public AnchorPerfShadowNode() {
        i(this);
    }

    @Override // y6a.h
    public final long c(LayoutNode r100, float r101, MeasureMode r102, float r103, MeasureMode r104) {
        Intrinsics.checkNotNullParameter(r102, "widthMode");
        Intrinsics.checkNotNullParameter(r104, "heightMode");
        return i.a(r101, r103);
    }
}
