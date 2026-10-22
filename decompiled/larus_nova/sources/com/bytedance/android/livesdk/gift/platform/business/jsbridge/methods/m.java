package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.cb;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends wy0.b<cb, LiveRequireGiftEffectLynxViewResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l02.h f129720a;

    public static final class a {
    }

    static {
    }

    @Override // wy0.b
    public final Type k() {
        return TypesJVMKt.getJavaType(Reflection.typeOf(cb.class));
    }

    public m(l02.h r100) {
        Intrinsics.checkNotNullParameter(r100, "effectInfoService");
        this.f129720a = r100;
    }

    @Override // wy0.b
    public final void l(vh7.j r110, CallContext r111) {
        cb r112 = (cb) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callContext");
        l02.h r100 = this.f129720a;
        Integer r113 = r112.getAction();
        if (r113 == null) goto L5;
        int r101 = r113.intValue();
    L6:
        Integer r114 = r112.getType();
        if (r114 == null) goto L9;
        int r102 = r114.intValue();
    L10:
        Boolean r115 = r112.U2();
        if (r115 == null) goto L13;
        boolean r103 = r115.booleanValue();
    L14:
        String r116 = r112.getSchema();
        if (r116 != null) goto L17;
        r116 = "";
    L17:
        String r104 = r116;
        Boolean r117 = r112.I5();
        if (r117 == null) goto L20;
        boolean r105 = r117.booleanValue();
    L21:
        r100.a(r101, r102, r103, r104, r105, r112.getChannel(), r112.i2());
        return;
    L20:
        r105 = false;
        goto L21
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }
}
