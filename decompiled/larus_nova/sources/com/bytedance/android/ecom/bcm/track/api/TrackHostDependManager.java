package com.bytedance.android.ecom.bcm.track.api;

import er.c;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TrackHostDependManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f51060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f51061b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f51062c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TrackHostDependManager f51063d = null;

    static {
        f51060a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(TrackHostDependManager.class), "settingDepend", "getSettingDepend()Lcom/bytedance/android/btm/api/depend/ISettingDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(TrackHostDependManager.class), "experimentDepend", "getExperimentDepend()Lcom/bytedance/android/ecom/bcm/track/api/inner/IExperimentDepend;"))};
        f51063d = new TrackHostDependManager();
        f51061b = new c(TrackHostDependManager$settingDepend$2.INSTANCE);
        f51062c = new c(TrackHostDependManager$experimentDepend$2.INSTANCE);
    }

    public TrackHostDependManager() {
    }
}
