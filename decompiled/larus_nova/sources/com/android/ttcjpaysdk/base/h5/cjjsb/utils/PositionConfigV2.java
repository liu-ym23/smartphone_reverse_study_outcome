package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0002\u0010\rR\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/PositionConfigV2;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "horizontalAnchor", "", "verticalAnchor", "horizontalOffset", "", "verticalOffset", "offsetType", "topSafeOffset", "bottomSafeOffset", "safeOffsetType", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;IILjava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PositionConfigV2 implements CJPayObject, Serializable {
    public int bottomSafeOffset;
    public String horizontalAnchor;
    public int horizontalOffset;
    public String offsetType;
    public String safeOffsetType;
    public int topSafeOffset;
    public String verticalAnchor;
    public int verticalOffset;

    public PositionConfigV2() {
        this(null, null, 0, 0, null, 0, 0, null, 255, null);
    }

    public PositionConfigV2(String r100, String r101, int r102, int r103, String r104, int r105, int r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "horizontalAnchor");
        Intrinsics.checkNotNullParameter(r101, "verticalAnchor");
        Intrinsics.checkNotNullParameter(r104, "offsetType");
        Intrinsics.checkNotNullParameter(r107, "safeOffsetType");
        this.horizontalAnchor = r100;
        this.verticalAnchor = r101;
        this.horizontalOffset = r102;
        this.verticalOffset = r103;
        this.offsetType = r104;
        this.topSafeOffset = r105;
        this.bottomSafeOffset = r106;
        this.safeOffsetType = r107;
    }

    public /* synthetic */ PositionConfigV2(String r110, String r111, int r112, int r113, String r114, int r115, int r116, String r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 1) == 0) goto L5;
        String r100 = "right";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r101 = "top";
    L10:
        int r102 = 0;
        if ((r118 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = 70;
    L18:
        int r105 = r118 & 16;
        String r106 = LayoutSizeLargeModeConfig.TYPE_PERCENTAGE;
        if (r105 == 0) goto L21;
        String r107 = LayoutSizeLargeModeConfig.TYPE_PERCENTAGE;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r108 = 0;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r102 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r106 = r117;
    L34:
        this(r100, r101, r103, r104, r107, r108, r102, r106);
        return;
    L25:
        r108 = r115;
        goto L27
    L21:
        r107 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
