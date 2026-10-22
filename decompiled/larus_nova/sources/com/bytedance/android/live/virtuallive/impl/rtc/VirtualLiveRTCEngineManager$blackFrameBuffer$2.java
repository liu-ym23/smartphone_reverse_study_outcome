package com.bytedance.android.live.virtuallive.impl.rtc;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class VirtualLiveRTCEngineManager$blackFrameBuffer$2 extends Lambda implements Function0<ByteBuffer> {
    public static final VirtualLiveRTCEngineManager$blackFrameBuffer$2 INSTANCE = null;

    static {
        INSTANCE = new VirtualLiveRTCEngineManager$blackFrameBuffer$2();
    }

    public VirtualLiveRTCEngineManager$blackFrameBuffer$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ByteBuffer invoke2() {
        ByteBuffer r100 = ByteBuffer.allocateDirect(384);
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 256) goto L6;
        r100.put((byte) 0);
        r102 = r102 + 1;
        goto L4
    L6:
        int r103 = 0;
    L8:
        if (r103 >= 64) goto L10;
        r100.put((byte) 128);
        r103 = r103 + 1;
    L10:
        if (r101 >= 64) goto L12;
        r100.put((byte) 128);
        r101 = r101 + 1;
        goto L10
    L12:
        r100.rewind();
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ByteBuffer invoke() {
        return invoke2();
    }
}
