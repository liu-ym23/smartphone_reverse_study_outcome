package com.bytedance.android.livesdk.followtool.utils;

import com.bytedance.android.live.core.utils.g2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class XTFollowSyncPrefs extends g2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f125348c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g2.d f125349d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g2.c f125350e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g2.d f125351f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g2.c f125352g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g2.d f125353h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g2.f f125354i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final g2.b f125355j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g2.d f125356k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g2.e f125357l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final XTFollowSyncPrefs f125358m = null;

    public XTFollowSyncPrefs() {
        super(null, AnonymousClass1.INSTANCE);
    }

    public final int b() {
        return ((Number) f125350e.b(f125348c[1])).intValue();
    }

    public final int c() {
        return ((Number) f125351f.b(f125348c[2])).intValue();
    }

    public final int d() {
        return ((Number) f125352g.b(f125348c[3])).intValue();
    }

    public final int e() {
        return ((Number) f125353h.b(f125348c[4])).intValue();
    }

    static {
        f125348c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "syncFollowSucToastCnt", "getSyncFollowSucToastCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "anchorDialogCntToday", "getAnchorDialogCntToday()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "anchorDialogCntTotal", "getAnchorDialogCntTotal()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntToday", "getFollowDialogCntToday()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntTotal", "getFollowDialogCntTotal()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntWeek", "getFollowDialogCntWeek()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followDialogCntReset", "getFollowDialogCntReset()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followRelationsDialogCnt", "getFollowRelationsDialogCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(XTFollowSyncPrefs.class, "followRelationsDialogCntWeekDays", "getFollowRelationsDialogCntWeekDays()I", 0))};
        XTFollowSyncPrefs r100 = new XTFollowSyncPrefs();
        f125358m = r100;
        f125349d = new g2.d(r100, "sync_follow_suc_cnt", 0);
        f125350e = new g2.c(r100, "anchor_dialog_cnt_today", 0);
        f125351f = new g2.d(r100, "anchor_dialog_cnt_total", 0);
        f125352g = new g2.c(r100, "follow_dialog_cnt_today", 0);
        f125353h = new g2.d(r100, "follow_dialog_cnt_total", 0);
        f125354i = new g2.f(r100, 0);
        f125355j = new g2.b(r100, "follow_dialog_cnt_reset", 0);
        f125356k = new g2.d(r100, "follow_relations_dialog_cnt", 0);
        f125357l = new g2.e(r100, 0);
    }
}
