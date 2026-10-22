package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\u000b\u001a\u00020\fR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/PositionConfig;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "anchor", "", "type", "top", "", "bottom", "offset", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;I)V", "Ljava/lang/Integer;", "toPositionConfigV2", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/PositionConfigV2;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PositionConfig implements IJSBParams {
    public String anchor;
    public Integer bottom;
    public int offset;
    public int top;
    public String type;

    public PositionConfig() {
        this(null, null, 0, null, 0, 31, null);
    }

    public final PositionConfigV2 toPositionConfigV2() {
        String r100 = this.anchor;
        Integer r101 = this.bottom;
        if (r101 == null) goto L5;
        r101.intValue();
        String r102 = "bottom";
    L6:
        String r103 = r102;
        int r104 = this.offset;
        Integer r105 = this.bottom;
        if (r105 == null) goto L9;
        int r106 = r105.intValue();
    L11:
        return new PositionConfigV2(r100, r103, r104, r106, this.type, 0, 0, null, 224, null);
    L9:
        r106 = this.top;
        goto L11
    L5:
        r102 = "top";
        goto L6
    }

    public PositionConfig(String r100, String r101, int r102, Integer r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.anchor = r100;
        this.type = r101;
        this.top = r102;
        this.bottom = r103;
        this.offset = r104;
    }

    public /* synthetic */ PositionConfig(String r100, String r101, int r102, Integer r103, int r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "right";
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = LayoutSizeLargeModeConfig.TYPE_PERCENTAGE;
    L8:
        String r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        int r106 = 70;
    L13:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        Integer r107 = r103;
        if ((r105 & 16) == 0) goto L18;
        int r108 = 2;
    L19:
        this(r100, r111, r106, r107, r108);
        return;
    L18:
        r108 = r104;
        goto L19
    L11:
        r106 = r102;
        goto L13
    }
}
