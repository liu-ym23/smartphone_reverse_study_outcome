package com.obric.aiagent.assistant_card.provider_core.bean;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import com.obric.aiagent.assistant_card.provider_core.a.d;
import com.obric.aiagent.assistant_card.provider_core.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemoteCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RemoteViews f16370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<CardAction> f16371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16373e;
    private final String f;
    private final long g;
    private final int h;
    private final int i;

    /* JADX INFO: compiled from: RemoteCard.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<CardAction> f16374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RemoteViews f16375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f16376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f16377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f16378e;
        private int f;

        public a(Context r3, int r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            this.f16375b = new RemoteViews(r5.getPackageName(), r4);
            this.f16376c = d.a(r5);
            this.f16378e = -1;
            this.f = -1;
        }

        public final a a(d.h.a.b<? super RemoteViews, x> r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "config");
            r4.invoke(this.f16375b);
            return this;
        }

        public final a a() {
            this.f16377d = true;
            return this;
        }

        public final a a(int r1) {
            this.f16378e = r1;
            return this;
        }

        public final a b(int r1) {
            this.f = r1;
            return this;
        }

        public final a a(int r2, String r3, JSONObject r4) {
            o.e(r3, "actionName");
            com.obric.aiagent.assistant_card.provider_core.bean.a r0 = com.obric.aiagent.assistant_card.provider_core.bean.a.f16359a;
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            a(r0, r2, r3, r5);
            return this;
        L5:
            r5 = null;
            goto L6
        }

        public final c b() {
            return new c(this.f16375b, this.f16374a, this.f16376c, this.f16377d, com.obric.aiagent.assistant_card.provider_core.b.f16338a.a(), com.obric.aiagent.assistant_card.provider_core.b.f16338a.b(), this.f16378e, this.f);
        }

        private final void a(com.obric.aiagent.assistant_card.provider_core.bean.a r2, int r3, String r4, String r5) {
            c().add(new CardAction(r2.getType(), r3, r4, r5));
        }

        private final List<CardAction> c() {
            if (this.f16374a != null) goto L5;
            this.f16374a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L5:
            List<CardAction> r3 = this.f16374a;
            o.a(r3);
            return r3;
        }
    }

    /* JADX INFO: compiled from: RemoteCard.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final a a(Context r2, int r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            return new a(r1, r3);
        }
    }

    static {
        f16369a = new b(null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16370b, r10.f16370b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f16371c, r10.f16371c) == true) goto L15;
        return false;
    L15:
        if (this.f16372d == r10.f16372d) goto L18;
        return false;
    L18:
        if (this.f16373e == r10.f16373e) goto L21;
        return false;
    L21:
        if (o.a(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        RemoteViews r0 = this.f16370b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<CardAction> r4 = this.f16371c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((((((((r3 + r1) * 31) + Boolean.hashCode(this.f16372d)) * 31) + Boolean.hashCode(this.f16373e)) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RemoteCard(view=" + this.f16370b + ", actions=" + this.f16371c + ", isNightMode=" + this.f16372d + ", concernNightMode=" + this.f16373e + ", appVersionName=" + this.f + ", appVersionCode=" + this.g + ", roundAngle=" + this.h + ", scrollViewId=" + this.i + ')';
    }

    public c(RemoteViews r3, List<CardAction> r4, boolean r5, boolean r6, String r7, long r8, int r10, int r11) {
        List<CardAction> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "appVersionName");
        this.f16370b = r3;
        this.f16371c = r9;
        this.f16372d = r5;
        this.f16373e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
    }

    public final Bundle a(Boolean r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable("remote_views", (Parcelable) ZeusTransformUtils.preCheckCast(this.f16370b, Parcelable.class, "com.obric.aiagent.plugin"));
        r0.putString("remote_actions", e.f16336a.a().toJson(this.f16371c));
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        r0.putBoolean("is_night_mode", r6);
        r0.putBoolean("concern_night_Mode", this.f16373e);
        r0.putString("app_version_name", this.f);
        r0.putLong("app_version_code", this.g);
        r0.putInt("round_angle", this.h);
        r0.putInt("scroll_view", this.i);
        return r0;
    L5:
        r6 = this.f16372d;
        goto L6
    }
}
