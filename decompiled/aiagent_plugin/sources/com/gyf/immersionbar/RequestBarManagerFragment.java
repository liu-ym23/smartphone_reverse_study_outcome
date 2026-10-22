package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestBarManagerFragment extends Fragment {
    private i mDelegate;

    public RequestBarManagerFragment() {
    }

    public g get(Object r2) {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = new i(r2);
    L6:
        return this.mDelegate.a();
    }

    public g get(Activity r3, Dialog r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        if (this.mDelegate != null) goto L6;
        this.mDelegate = new i(r5, r4);
    L6:
        return this.mDelegate.a();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        i r3 = this.mDelegate;
        if (r3 == null) goto L6;
        r3.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration());
        return;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        i r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        i r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.c();
        this.mDelegate = null;
        return;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        i r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }
}
