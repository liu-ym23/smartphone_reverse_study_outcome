package com.bytedance.android.live.messagewindow.framework.process;

import com.bytedance.android.live.room.api.messagewindow.process.MsgWindowAdjustSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements h71.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<MsgWindowAdjustSource, h71.a> f83136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f83137b;

    public c() {
        this.f83136a = new HashMap();
        this.f83137b = new CompositeDisposable();
    }

    @Override // h71.b
    public final HashMap<MsgWindowAdjustSource, h71.a> k() {
        return this.f83136a;
    }
}
