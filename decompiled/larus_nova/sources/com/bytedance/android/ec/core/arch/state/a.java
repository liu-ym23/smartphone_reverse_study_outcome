package com.bytedance.android.ec.core.arch.state;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.arch.state.b;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Channel<Function1<S, S>> f43860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel<Function1<S, Unit>> f43861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<S> f43862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile S f43863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f43864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f43865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineContext f43866g;

    /* JADX WARN: Multi-variable type inference failed */
    public a(b r100, CoroutineScope r101) {
        EmptyCoroutineContext r102 = EmptyCoroutineContext.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "initialState");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "contextOverride");
        this.f43865f = r101;
        this.f43866g = r102;
        this.f43860a = ChannelKt.Channel(Integer.MAX_VALUE);
        this.f43861b = ChannelKt.Channel(Integer.MAX_VALUE);
        MutableLiveData<S> r103 = new MutableLiveData();
        r103.setValue(r100);
        Unit r104 = Unit.INSTANCE;
        this.f43862c = r103;
        this.f43863d = r100;
        this.f43864e = r103;
        BuildersKt.launch$default(r101, Dispatchers.getIO().plus(r102), null, new CoroutinesStateStore$setupTriggerFlushQueues$1(this, null), 2, null);
    }
}
