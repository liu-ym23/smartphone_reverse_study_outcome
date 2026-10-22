package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import hh1.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f112890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f112891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RoomContext f112892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f112893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f112894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f112895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Room f112896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EnterRoomExtra f112897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LiveMode f112898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f112899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.room.h.b f112900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<w0> f112901l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w0 f112902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f112903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public io1.b f112904o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.utils.e f112905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Fragment f112906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f112907r;

    public final Bundle a() {
        return this.f112906q.getArguments();
    }

    public final DataCenter b() {
        DataCenter r100 = this.f112891b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r100;
    }

    public final Room c() {
        Room r100 = this.f112896g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        return r100;
    }

    public final RoomContext d() {
        RoomContext r100 = this.f112892c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L5:
        return r100;
    }

    public final Activity getActivity() {
        return this.f112906q.getActivity();
    }

    public final void e(View r100) {
        Runnable r101 = this.f112899j;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        r100.post(r101);
    L6:
        this.f112899j = null;
        return;
    }

    public a(Fragment r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f112906q = r100;
        this.f112907r = r101;
        this.f112890a = true;
        this.f112898i = LiveMode.VIDEO;
        this.f112901l = new ArrayList();
    }
}
