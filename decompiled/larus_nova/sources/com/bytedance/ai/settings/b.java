package com.bytedance.ai.settings;

import java.util.List;
import kotlin.collections.CollectionsKt;
import t5.g;
import t5.i;
import t5.m;
import t5.t;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<Integer> f37574a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<Integer> f37575b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a<Boolean> f37576c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a<t> f37577d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a<g> f37578e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a<Integer> f37579f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a<List<String>> f37580g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a<i> f37581h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a<List<String>> f37582i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a<m> f37583j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a<t5.c> f37584k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a<List<String>> f37585l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a<Long> f37586m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a<Integer> f37587n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a<List<String>> f37588o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a<List<String>> f37589p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a<Boolean> f37590q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a<Integer> f37591r = null;

    static {
        d.f37592a.getClass();
        f37574a = new a("downloadType", Integer.valueOf(d.a().resourcesManagerConfig().f()));
        f37575b = new a("frontierServerId", Integer.valueOf(d.a().frontierConfig().a()));
        f37576c = new a("enableToolRuntimeEntry", Boolean.valueOf(d.a().optimizeSettings().a()));
        f37577d = new a("widgetSettingsConfig", d.a().widgetSettingsConfig());
        f37578e = new a("lynxTemplateVerifyConfig", d.a().lynxTemplateVerifyConfig());
        f37579f = new a("geckoHostVersion", Integer.valueOf(d.a().resourcesManagerConfig().d()));
        List<String> r100 = d.a().resourcesManagerConfig().g();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        f37580g = new a("requestWhiteList", r100);
        f37581h = new a("lynxViewReusedConfig", d.a().lynxViewReusedConfig());
        List<String> r101 = d.a().aiBridgeConfig().d();
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        f37582i = new a("aiBridgeConfig", r101);
        f37583j = new a("optimizeSettings", d.a().optimizeSettings());
        f37584k = new a("appletSettings", d.a().appletSettings());
        List<String> r102 = d.a().resourcesManagerConfig().a();
        if (r102 != null) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        f37585l = new a("customDownloadPackageList", r102);
        f37586m = new a("customUpdateInterval", Long.valueOf(d.a().resourcesManagerConfig().h()));
        f37587n = new a("offlineFileVersion", Integer.valueOf(d.a().resourcesManagerConfig().e()));
        List<String> r103 = d.a().resourcesManagerConfig().c();
        if (r103 != null) goto L14;
        r103 = CollectionsKt.emptyList();
    L14:
        f37588o = new a("forceUpdateChannelList", r103);
        List<String> r104 = d.a().resourcesManagerConfig().b();
        if (r104 != null) goto L17;
        r104 = CollectionsKt.emptyList();
    L17:
        f37589p = new a("firstAppPackageList", r104);
        f37590q = new a("embedWebviewDomainVerifyEnabled", Boolean.valueOf(d.a().embedWebviewSettings().a()));
        f37591r = new a("workerOptimized", Integer.valueOf(d.a().resourcesManagerConfig().i()));
    }
}
