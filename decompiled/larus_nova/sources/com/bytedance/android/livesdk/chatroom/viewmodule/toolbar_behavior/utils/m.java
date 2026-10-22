package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f117417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f117418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ToolbarBroadcastFunction f117419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ToolbarBroadcastFunction f117420d;

    public m(Function1 r100, long r101, ToolbarBroadcastFunction r102, ToolbarBroadcastFunction r103) {
        this.f117417a = r100;
        this.f117418b = r101;
        this.f117419c = r102;
        this.f117420d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f117417a.invoke(Boolean.FALSE);
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        ALogger.e("ToolbarBroadcastStatus", String.format("%d change %s to %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f117418b), this.f117419c.name(), this.f117420d.name()}, 3)), (Throwable) r100);
        f2.b(R.string.ttlive_switch_toolbar_function, 1);
    }
}
