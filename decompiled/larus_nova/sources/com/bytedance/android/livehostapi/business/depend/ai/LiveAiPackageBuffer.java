package com.bytedance.android.livehostapi.business.depend.ai;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.slice.SliceInitService;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/ai/LiveAiPackageBuffer;", "", HTTP.CONTENT_RANGE_BYTES, "", "directBuffer", "Ljava/nio/ByteBuffer;", "size", "", "readonly", "", "descriptionJson", "", "([BLjava/nio/ByteBuffer;IZLjava/lang/String;)V", "getBytes", "()[B", "getDescriptionJson", "()Ljava/lang/String;", "getDirectBuffer", "()Ljava/nio/ByteBuffer;", "getReadonly", "()Z", "getSize", "()I", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAiPackageBuffer {
    private final byte[] bytes;
    private final String descriptionJson;
    private final ByteBuffer directBuffer;
    private final boolean readonly;
    private final int size;

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final String getDescriptionJson() {
        return this.descriptionJson;
    }

    public final ByteBuffer getDirectBuffer() {
        return this.directBuffer;
    }

    public final boolean getReadonly() {
        return this.readonly;
    }

    public final int getSize() {
        return this.size;
    }

    public LiveAiPackageBuffer(byte[] r100, ByteBuffer r101, int r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "descriptionJson");
        this.bytes = r100;
        this.directBuffer = r101;
        this.size = r102;
        this.readonly = r103;
        this.descriptionJson = r104;
    }

    public /* synthetic */ LiveAiPackageBuffer(byte[] r100, ByteBuffer r101, int r102, boolean r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r111 = SliceInitService.DEFAULT_SWITCH;
    L9:
        this(r100, r101, r102, r103, r111);
        return;
    L5:
        r103 = r110;
        goto L7
    }
}
