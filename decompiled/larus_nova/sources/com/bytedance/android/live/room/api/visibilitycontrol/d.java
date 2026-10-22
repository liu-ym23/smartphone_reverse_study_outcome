package com.bytedance.android.live.room.api.visibilitycontrol;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f99163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f99164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f99165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f99166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NextLiveData<Integer> f99167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LiveVisibilityControl.KEY f99168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.room.api.visibilitycontrol.a f99169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f99170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LiveVisibilityControl.Type f99171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LiveVisibilityControl.Style f99172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f99173k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f99174l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f99175m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f99176n;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Integer r100 = this.f99167e.getValue();     // Catch: Exception -> L10
        if (r100 != null) goto L6;
    L8:
        int[] r101 = new int[2];     // Catch: Exception -> L10
        this.f99170h.getLocationOnScreen(r101);     // Catch: Exception -> L10
        int r102 = r101[0];     // Catch: Exception -> L10
        int r103 = r101[1];     // Catch: Exception -> L10
        this.f99164b = r103;     // Catch: Exception -> L10
        this.f99165c = r102;     // Catch: Exception -> L10
        this.f99166d = r102 + this.f99170h.getWidth();     // Catch: Exception -> L10
        this.f99163a = r103 + this.f99170h.getHeight();     // Catch: Exception -> L10
        return;
    L6:
        if (r100.intValue() != 1) goto L8;
        return;
    L10:
        e = move-exception;
        ALogger.e("VSPlayerViewControlItem", "refreshViewPosition:error for" + this.f99168f.name(), e);
    }

    public final LiveVisibilityControl.Type getType() {
        return this.f99171i;
    }

    public d(LiveVisibilityControl.KEY r100, com.bytedance.android.live.room.api.visibilitycontrol.a r101, View r102, LiveVisibilityControl.Type r103, LiveVisibilityControl.Style r104, float r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "style");
        this.f99168f = r100;
        this.f99169g = r101;
        this.f99170h = r102;
        this.f99171i = r103;
        this.f99172j = r104;
        this.f99173k = r105;
        this.f99174l = r106;
        this.f99175m = r107;
        this.f99176n = r110;
        NextLiveData<Integer> r108 = new NextLiveData();
        r108.setValue(0);
        Unit r109 = Unit.INSTANCE;
        this.f99167e = r108;
        a();
    }
}
