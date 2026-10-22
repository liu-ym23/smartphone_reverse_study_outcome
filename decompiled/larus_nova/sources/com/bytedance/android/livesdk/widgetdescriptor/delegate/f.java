package com.bytedance.android.livesdk.widgetdescriptor.delegate;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerProgressServiceContext f162372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Portrait6thDelegate$adaptRightCardForProgressBar$1 f162373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f162374c;

    public f(PlayerProgressServiceContext r100, Portrait6thDelegate$adaptRightCardForProgressBar$1 r101, ViewGroup r102) {
        this.f162372a = r100;
        this.f162373b = r101;
        this.f162374c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Portrait6thDelegate$adaptRightCardForProgressBar$1 r102 = this.f162373b;
        PlayerProgressServiceContext r103 = this.f162372a;
        if (r103 == null) goto L9;
        m<Boolean> r104 = r103.getVsRoomEnableSeek();
        if (r104 == null) goto L9;
        boolean r105 = true;
        if (r104.getValue().booleanValue() != true) goto L9;
    L10:
        r102.invoke(r105, this.f162374c);
        return;
    L9:
        r105 = false;
        goto L10
    }
}
