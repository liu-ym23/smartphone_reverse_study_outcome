package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.os.Build;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BackProcessResumer$onActivityCreated$1 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ String $activityClassName;

    public BackProcessResumer$onActivityCreated$1(String r100) {
        this.$activityClassName = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        JSONObject r100 = new JSONObject();
        r100.put("activity", this.$activityClassName);
        r100.put(LocationExtraDataTraceLogger.SDK_INT, Build.VERSION.SDK_INT);
        a r101 = a.f42274f;
        r101.getClass();
        r100.put("isBackProcess", false);
        r101.getClass();
        r100.put("numActivities", a.f42273e);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
