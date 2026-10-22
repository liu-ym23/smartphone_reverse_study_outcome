package com.bytedance.android.livesdk.chatroom.vs_base.base.service.impl;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayOrientationControlUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayTetrisDescriptor;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.android.scope.o;
import ir1.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mq1.d0;
import mq1.f0;

/* JADX INFO: loaded from: classes8.dex */
public final class ReplayUIStateService implements o, d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f117904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f117905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lambda f117906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f117907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Lambda f117908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Class<? extends c>, c> f117909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<f0> f117910g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f117910g.clear();
    }

    public final void q() {
        Iterator<f0> r100 = this.f117910g.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().wg();
        goto L4
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public ReplayUIStateService() {
        this.f117904a = 1;
        this.f117905b = ReplayUIStateService$isPad$1.INSTANCE;
        this.f117906c = ReplayUIStateService$isLandScreen$1.INSTANCE;
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == false) goto L8;
        if (FoldScreenUtils.e() == false) goto L8;
    L10:
        int r100 = 0;
    L11:
        this.f117907d = r100;
        this.f117908e = ReplayUIStateService$isFoldOpen$1.INSTANCE;
        this.f117909f = new HashMap();
        this.f117910g = new ArrayList();
        return;
    L8:
        if (((Number) this.f117906c.invoke()).intValue() != 8) goto L10;
        r100 = 4;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.chatroom.vs_base.base.service.impl.ReplayUIStateService$changeLandScreen$1, kotlin.jvm.internal.Lambda] */
    @Override // mq1.d0
    public final void a(final boolean r100) {
        int r101 = ((Number) this.f117906c.invoke()).intValue();
        this.f117906c = new ReplayUIStateService$changeLandScreen$1(r100);
        if (r101 != 8) goto L5;
        boolean r102 = true;
    L6:
        if (r100 == r102) goto L9;
        q();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // mq1.d0
    public final <T extends c> T c(Class<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "ui");
        if (this.f117909f.containsKey(r100) == true) goto L5;
    L6:
        c r101 = r100.newInstance();
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "uiStateService");
        r101.f495438a = this;
        if ((r101 instanceof ReplayOrientationControlUIState) == false) goto L9;
        h(r101.f495439b);
    L9:
        this.f117909f.put(r100, r101);
    L10:
        T r102 = (T) this.f117909f.get(r100);
        if (r102 == null) goto L14;
        return r102;
    L14:
        throw new RuntimeException("是不是传错东西进来了？");
    L5:
        if (this.f117909f.get(r100) != null) goto L10;
        goto L6
    }

    @Override // mq1.d0
    public final void d(boolean r100) {
        boolean r101 = false;
        if (r100 == false) goto L5;
    L7:
        int r102 = this.f117904a;
        this.f117904a = r100 ? 1 : 0;
        if (r102 != 1) goto L10;
        r101 = true;
    L10:
        if (r100 == r101) goto L13;
        q();
        return;
    L13:
        return;
    L5:
        if (this.f117905b.invoke().intValue() == 2) goto L7;
        f(false);
        goto L7
    }

    @Override // mq1.d0
    public final void f(boolean r100) {
        boolean r101 = false;
        if (this.f117904a == 0) goto L5;
    L7:
        int r102 = this.f117907d;
        if (r100 == false) goto L10;
        int r103 = 4;
    L11:
        this.f117907d = r103;
        if (r102 != 4) goto L14;
        r101 = true;
    L14:
        if (r100 == r101) goto L17;
        q();
        return;
    L17:
        return;
    L10:
        r103 = 0;
        goto L11
    L5:
        if (this.f117905b.invoke().intValue() != 0) goto L7;
        r100 = false;
        goto L7
    }

    @Override // mq1.d0
    public final void h(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f117910g.add(r100);
    }

    @Override // mq1.d0
    public final void k(f0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f117910g.remove(r100);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // mq1.d0
    public final void n(boolean r100) {
        if (FoldScreenUtils.f() == true) goto L6;
        this.f117908e = ReplayUIStateService$changeFoldOpen$1.INSTANCE;
        return;
    L6:
        int r101 = ((Number) this.f117908e.invoke()).intValue();
        if (r100 == false) goto L9;
        Lambda r102 = ReplayUIStateService$changeFoldOpen$2.INSTANCE;
    L10:
        this.f117908e = r102;
        if (r101 != 16) goto L13;
        boolean r103 = true;
    L14:
        if (r100 == r103) goto L17;
        q();
        return;
    L17:
        return;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = ReplayUIStateService$changeFoldOpen$3.INSTANCE;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final boolean o(int r100) {
        if ((r100 ^ (((((this.f117904a | this.f117905b.invoke().intValue()) | this.f117907d) | ((Number) this.f117906c.invoke()).intValue()) | ((Number) this.f117908e.invoke()).intValue()) & r100)) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mq1.d0
    public final boolean g(int r100, ReplayTetrisDescriptor<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "vsTetrisDescriptor");
        return o(r100);
    }

    @Override // mq1.d0
    public final boolean i(int r100, ReplayWidgetDescriptor<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "replayWidgetDescriptor");
        return o(r100);
    }

    @Override // mq1.d0
    public final boolean j(int r100, c r101) {
        Intrinsics.checkNotNullParameter(r101, "uiState");
        return o(r100);
    }
}
