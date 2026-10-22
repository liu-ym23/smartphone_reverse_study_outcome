package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdminRecordPermissionChanger f115404a;

    public a(AdminRecordPermissionChanger r100) {
        this.f115404a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        AdminRecordPermissionChanger r101 = this.f115404a;
        if (((Boolean) r100).booleanValue() == true) goto L7;
        ALogger.i(r101.f115344a, "管理员权限被下掉了");
        Function1<Boolean, Unit> r102 = r101.f115348e;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke(Boolean.FALSE);
        return;
    L9:
        return;
    L7:
        r101.getClass();
    }
}
