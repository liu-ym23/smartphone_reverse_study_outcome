package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends View implements v32.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v32.a> f137906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f137907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f137908c;

    @Override // v32.b
    public abstract /* synthetic */ View getTapView();

    public abstract /* synthetic */ View getView();

    @Override // v32.b
    public void clear() {
        Iterator<T> r100 = this.f137906a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((v32.a) r100.next()).clear();
        goto L4
    }

    @Override // v32.b
    public void init() {
        Iterator<T> r100 = this.f137906a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((v32.a) r100.next()).b(this.f137908c);
        goto L4
    }

    @Override // v32.b
    public void load() {
        Iterator<T> r100 = this.f137906a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((v32.a) r100.next()).load();
        goto L4
    }

    @Override // v32.b
    public void unload() {
        Iterator<T> r100 = this.f137906a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((v32.a) r100.next()).unload();
        goto L4
    }

    public final List<v32.a> getControllerList() {
        return this.f137906a;
    }

    public final DataCenter getDataCenter() {
        return this.f137908c;
    }

    public final boolean getHasReportDiggDisable() {
        return this.f137907b;
    }

    @Override // v32.b
    public final void c(v32.a r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        ((ArrayList) this.f137906a).add(r100);
    }

    public final void setHasReportDiggDisable(boolean r100) {
        this.f137907b = r100;
    }

    public a(Context r100, DataCenter r101) {
        super(r100);
        this.f137908c = r101;
        this.f137906a = new ArrayList();
    }
}
