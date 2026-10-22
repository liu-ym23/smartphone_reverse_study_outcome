package com.bytedance.android.livesdk.revenue.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ldc2/c$b;", "p1", "Lcom/bytedance/android/livesdk/revenue/message/e$a;", AbsMethodDelegate.TAG_INVOKE, "(Ldc2/c$b;)Lcom/bytedance/android/livesdk/revenue/message/e$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RevWrdsSettingItemImpl$onValueChangedWithVersion$1 extends FunctionReferenceImpl implements Function1<dc2.c.b<Object>, e.a<Object>> {
    public static final RevWrdsSettingItemImpl$onValueChangedWithVersion$1 INSTANCE = null;

    static {
        INSTANCE = new RevWrdsSettingItemImpl$onValueChangedWithVersion$1();
    }

    public RevWrdsSettingItemImpl$onValueChangedWithVersion$1() {
        super(1, o.class, "toRevType", "toRevType(Lcom/bytedance/android/livesdk/interactivity/service/wrds/WRDSSettingItem$ValueWithVersion;)Lcom/bytedance/android/livesdk/revenue/message/IRevWrdsSettingItem$ValueWithVersion;", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e.a<Object> invoke2(dc2.c.b<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        long r101 = r100.f467858a;
        return new e.a(r100.f467859b);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e.a<Object> invoke(dc2.c.b<Object> r100) {
        return invoke2(r100);
    }
}
