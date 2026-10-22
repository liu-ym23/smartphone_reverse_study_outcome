package com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model;

import com.bytedance.android.livesdk.sharedpref.e;
import d52.c;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseStyleSettingModel<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f133535a;

    public abstract T a();

    public abstract String c();

    public abstract T d(int r100);

    public T b() {
        return (T) d(((Number) ((e) this.f133535a.getValue()).getValue()).intValue());
    }

    public BaseStyleSettingModel() {
        this.f133535a = LazyKt.lazy(new BaseStyleSettingModel$pluginProperty$2(this));
    }
}
