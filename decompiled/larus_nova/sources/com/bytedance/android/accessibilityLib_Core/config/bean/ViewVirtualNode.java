package com.bytedance.android.accessibilityLib_Core.config.bean;

import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ClassType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ConfigType;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.LabelMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.SelectMode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ViewVirtualNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f38151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f38152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f38155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f38156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<com.bytedance.android.accessibilityLib_Core.config.remote.dsl.b> f38157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h[] f38158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f38159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f38160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SelectMode f38161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LabelMode f38162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f38163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f38164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ConfigType f38165o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f38166p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f38167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f38168r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ClassType f38169s;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "viewid = " + this.f38152b + " ,layoutId = " + this.f38151a + ", nextviewid = null,viewidentify = null, sAppModeStr = " + this.f38168r + ",sClassType = " + this.f38169s.getValue();
    }

    public ViewVirtualNode() {
        this.f38153c = -1;
        this.f38154d = LazyKt.lazy(ViewVirtualNode$accessibilityNodeInfo$2.INSTANCE);
        this.f38161k = SelectMode.Default;
        this.f38162l = LabelMode.Append;
        this.f38165o = ConfigType.Normal;
        this.f38166p = "";
        this.f38168r = "";
        this.f38169s = ClassType.Default;
    }
}
