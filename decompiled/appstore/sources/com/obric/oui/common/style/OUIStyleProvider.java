package com.obric.oui.common.style;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public class OUIStyleProvider implements IOUIStyleProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13055d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final sc.a f13056e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUILayoutHelper f13057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OUIAlphaHelper f13058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OUIEffectHelper f13059c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f13055d = new a(null);
        f13056e = new sc.a();
    }

    public OUIStyleProvider(Context r10, AttributeSet r11, int r12, int r13) {
        q.g(r10, "context");
        this.f13057a = new OUILayoutHelper(r10, r11, r12, r13);
        this.f13058b = new OUIAlphaHelper(r10, r11, r12, r13);
    }

    public final void a(View r10) {
        q.g(r10, "owner");
        this.f13057a.E(r10);
        this.f13058b.j(r10);
        this.f13059c = new OUIEffectHelper(r10);
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUIAlpha getAlphaHelper() {
        return this.f13058b;
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public OUIEffectHelper getEffectHelper() {
        OUIEffectHelper r10 = this.f13059c;
        if (r10 != null) goto L6;
        q.y("mOUIEffectHelper");
        return null;
    L6:
        return r10;
    }

    @Override // com.obric.oui.common.style.IOUIStyleProvider
    public IOUILayout getLayoutHelper() {
        return this.f13057a;
    }
}
