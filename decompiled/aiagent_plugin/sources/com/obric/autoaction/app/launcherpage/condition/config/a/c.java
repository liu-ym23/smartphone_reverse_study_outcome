package com.obric.autoaction.app.launcherpage.condition.config.a;

import android.text.TextUtils;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.condition.config.condition.AutoCondition;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionListCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends AutoCondition> f22946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f22947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f22948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<Integer, CharSequence> f22949d;

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        o.e(r1, "newItem");
        return r1;
    }

    public c(Class<? extends AutoCondition> r3, CharSequence r4, boolean r5, d.h.a.b<? super Integer, ? extends CharSequence> r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b<Integer, CharSequence> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r7, "displayText");
        o.e(r8, "provideEllipsizeText");
        this.f22946a = r3;
        this.f22947b = r7;
        this.f22948c = r5;
        this.f22949d = r8;
    }

    public final Class<? extends AutoCondition> a() {
        return this.f22946a;
    }

    public final boolean b() {
        return this.f22948c;
    }

    public final d.h.a.b<Integer, CharSequence> c() {
        return this.f22949d;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).f22946a, this.f22946a) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(h r6) {
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.aiagent.plugin");
        o.e(r7, "other");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L6;
        return false;
    L6:
        if (TextUtils.equals(((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f22947b, this.f22947b) == true) goto L8;
        return false;
    L8:
        if (((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f22948c != this.f22948c) goto L12;
        return true;
    L12:
        return false;
    }
}
