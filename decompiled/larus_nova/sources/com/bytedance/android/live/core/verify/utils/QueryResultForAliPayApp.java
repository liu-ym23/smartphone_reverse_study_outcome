package com.bytedance.android.live.core.verify.utils;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.utils.v1;
import com.bytedance.android.tools.superkv.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public class QueryResultForAliPayApp implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f66490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f66491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f66492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w80.a f66493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f66494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f66495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f66496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a.g f66497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f66498i;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (this.f66495f == true) goto L5;
        return;
    L5:
        this.f66495f = false;
        Activity r100 = this.f66490a;
        w80.a r101 = this.f66493d;
        String r102 = this.f66491b;
        Bundle r103 = this.f66494e;
        boolean r104 = this.f66492c;
        a.g r105 = this.f66497h;
        boolean r106 = this.f66498i;
        a.b(r100, r101, r102, r103, r104, 0, new HashMap(), r105, r106);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QueryResultForAliPayApp(Activity r100, w80.a r101, String r102, Bundle r103, boolean r104, a.g r105, boolean r106) {
        this.f66490a = r100;
        this.f66491b = r102;
        this.f66494e = r103;
        this.f66492c = r104;
        this.f66493d = r101;
        this.f66497h = r105;
        this.f66498i = r106;
        if ((r100 instanceof LifecycleOwner) == false) goto L5;
        ((LifecycleOwner) r100).getLifecycle().addObserver(this);
    L5:
        this.f66496g = v1.a("webcast_jsb_local_data");
    }
}
