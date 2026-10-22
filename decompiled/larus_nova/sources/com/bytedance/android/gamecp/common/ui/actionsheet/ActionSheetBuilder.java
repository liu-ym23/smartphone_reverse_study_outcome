package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public final class ActionSheetBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f56959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bv.b f56960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bv.a f56961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<a> f56962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super Dialog, ? super View, Unit> f56963e;

    public final e a() {
        return new e(this.f56960b, this.f56961c, this.f56962d, this.f56959a, this.f56963e);
    }

    public ActionSheetBuilder() {
        this.f56963e = ActionSheetBuilder$initTrack$1.INSTANCE;
    }
}
