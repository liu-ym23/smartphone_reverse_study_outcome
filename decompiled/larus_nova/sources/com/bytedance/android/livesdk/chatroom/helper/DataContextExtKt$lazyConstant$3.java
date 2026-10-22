package com.bytedance.android.livesdk.chatroom.helper;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.live.datacontext.ConstantMemberConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/bytedance/live/datacontext/ConstantMemberConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DataContextExtKt$lazyConstant$3 extends Lambda implements Function1 {
    public static final DataContextExtKt$lazyConstant$3 INSTANCE = null;

    static {
        INSTANCE = new DataContextExtKt$lazyConstant$3();
    }

    public DataContextExtKt$lazyConstant$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        invoke((ConstantMemberConfig) r100);
        return Unit.INSTANCE;
    }

    public final void invoke(ConstantMemberConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
    }
}
