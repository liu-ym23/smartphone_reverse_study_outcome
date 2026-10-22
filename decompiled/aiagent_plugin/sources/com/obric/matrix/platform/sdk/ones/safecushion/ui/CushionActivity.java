package com.obric.matrix.platform.sdk.ones.safecushion.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.obric.matrix.platform.sdk.ones.safecushion.c;
import com.obric.matrix.platform.sdk.ones.safecushion.d;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: CushionActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CushionActivity extends GeneratePluginActivity {
    public static final a Companion = null;
    private static final String TAG = "CushionActivity";
    public Map<Integer, View> _$_findViewCache;
    private final b controller;
    private final com.obric.matrix.platform.sdk.ones.safecushion.b.b flagHelper;
    private final com.obric.matrix.platform.sdk.ones.safecushion.a.b repairHandler;

    /* JADX INFO: compiled from: CushionActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: CushionActivity.kt */
    private final class b implements com.obric.matrix.platform.sdk.ones.safecushion.ui.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CushionActivity f33736a;

        public b(CushionActivity r3) {
            this.f33736a = (CushionActivity) ZeusTransformUtils.wrapperContextForParams(r3, CushionActivity.class, "com.obric.aiagent.plugin");
        }

        public String a() {
            String r0 = CushionActivity.access$getFlagHelper$p(this.f33736a).e();
            if (r0 != null) goto L6;
            return "repair";
        L6:
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int r5) {
        Map<Integer, View> r0 = this._$_findViewCache;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r5)), View.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        View r2 = findViewById(r5);
        if (r2 == null) goto L7;
        r0.put(Integer.valueOf(r5), r2);
        return r2;
    L7:
        return null;
    L9:
        return r1;
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public CushionActivity() {
        this._$_findViewCache = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.flagHelper = new com.obric.matrix.platform.sdk.ones.safecushion.b.b();
        this.repairHandler = new com.obric.matrix.platform.sdk.ones.safecushion.a.b();
        this.controller = new b(this);
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.safecushion.b access$getConfig(CushionActivity r2) {
        return ((CushionActivity) ZeusTransformUtils.wrapperContextForParams(r2, CushionActivity.class, "com.obric.aiagent.plugin")).getConfig();
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.safecushion.b.b access$getFlagHelper$p(CushionActivity r2) {
        return ((CushionActivity) ZeusTransformUtils.wrapperContextForParams(r2, CushionActivity.class, "com.obric.aiagent.plugin")).flagHelper;
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.safecushion.a.b access$getRepairHandler$p(CushionActivity r2) {
        return ((CushionActivity) ZeusTransformUtils.wrapperContextForParams(r2, CushionActivity.class, "com.obric.aiagent.plugin")).repairHandler;
    }

    private final com.obric.matrix.platform.sdk.ones.safecushion.b getConfig() {
        return c.f33723a.a().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r5) {
        super/*android.app.Activity*/.onCreate(r5);
        com.obric.matrix.platform.sdk.ones.safecushion.ui.b r6 = getConfig().c();
        if (r6 != null) goto L6;
        com.obric.matrix.platform.sdk.ones.internal.b.b.e(TAG, "onCreate: uiProvider is null, finish", null, 4, null);
        finish();
        return;
    L6:
        d.f33728a.a();
        setContentView(r6.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), (com.obric.matrix.platform.sdk.ones.safecushion.ui.a) ZeusTransformUtils.preCheckCast(this.controller, com.obric.matrix.platform.sdk.ones.safecushion.ui.a.class, "com.obric.aiagent.plugin")));
        this.flagHelper.b(this.controller.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        com.obric.matrix.platform.sdk.ones.safecushion.ui.b r0 = getConfig().c();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
