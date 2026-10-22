package com.bytedance.android.harmony.channel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022+\u0010\b\u001a'0\u0003R\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", ExifInterface.LONGITUDE_EAST, "Lcom/bytedance/android/harmony/channel/a$a;", "Lcom/bytedance/android/harmony/channel/a;", "Lkotlin/ParameterName;", "name", "channel", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/harmony/channel/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final /* synthetic */ class AbstractChannelClient$createChannel$channel$1 extends FunctionReference implements Function1<a<Object, Object, Object>.C0922a, Unit> {
    public AbstractChannelClient$createChannel$channel$1(a r100) {
        super(1, r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "onChannelClosed";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(a.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "onChannelClosed(Lcom/bytedance/android/harmony/channel/AbstractChannelClient$AbstractChannelImpl;)V";
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a<Object, Object, Object>.C0922a r100) {
        ((a) this.receiver).f58166b.remove(r100.f58173e);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a<Object, Object, Object>.C0922a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
