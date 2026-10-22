package com.stepos.aiengine.modelmanager.pref;

import com.stepos.core.common.notification.LiveNotification;
import com.stepos.core.download.ModelFlowMeta;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public static final ActionMode f5896a;

    /* renamed from: b, reason: collision with root package name */
    public static final ActionMode f5897b;

    /* renamed from: c, reason: collision with root package name */
    public static final ActionMode f5898c;

    /* renamed from: d, reason: collision with root package name */
    public static final ActionMode f5899d;

    /* renamed from: e, reason: collision with root package name */
    public static final ActionMode f5900e;
    public static final ActionMode h;

    /* renamed from: j, reason: collision with root package name */
    public static final ActionMode f5901j;

    /* renamed from: k, reason: collision with root package name */
    public static final ActionMode f5902k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ ActionMode[] f5903l;

    static {
        ActionMode actionMode = new ActionMode(ModelFlowMeta.PLAN_NONE, 0);
        f5896a = actionMode;
        ActionMode actionMode2 = new ActionMode("INSTALL", 1);
        f5897b = actionMode2;
        ActionMode actionMode3 = new ActionMode("UPDATE", 2);
        f5898c = actionMode3;
        ActionMode actionMode4 = new ActionMode("RESUME", 3);
        f5899d = actionMode4;
        ActionMode actionMode5 = new ActionMode(LiveNotification.EVENT_PROGRESS, 4);
        f5900e = actionMode5;
        ActionMode actionMode6 = new ActionMode("INSTALLING", 5);
        h = actionMode6;
        ActionMode actionMode7 = new ActionMode("UNINSTALL", 6);
        f5901j = actionMode7;
        ActionMode actionMode8 = new ActionMode("RETRY", 7);
        f5902k = actionMode8;
        ActionMode[] actionModeArr = {actionMode, actionMode2, actionMode3, actionMode4, actionMode5, actionMode6, actionMode7, actionMode8};
        f5903l = actionModeArr;
        a.a(actionModeArr);
    }

    public ActionMode() {
        throw null;
    }

    public static ActionMode valueOf(String str) {
        return (ActionMode) Enum.valueOf(ActionMode.class, str);
    }

    public static ActionMode[] values() {
        return (ActionMode[]) f5903l.clone();
    }
}
