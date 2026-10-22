package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends AbsPSHighlightComp {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f133437i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f133438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a.C2108a f133439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f133440h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<? extends View> f133441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function1<? super C2108a, Unit> f133442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f133443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final n f133444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Context f133445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final DataCenter f133446f;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.f$a$a, reason: collision with other inner class name */
        public static final class C2108a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Function0<Unit> f133447a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Function0<Unit> f133448b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Function0<Unit> f133449c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final AbsPSHighlightComp f133450d;

            public C2108a(AbsPSHighlightComp r100) {
                Intrinsics.checkNotNullParameter(r100, "comp");
                this.f133450d = r100;
            }
        }

        public a(String r100, n r101, Context r102, DataCenter r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f133443c = r100;
            this.f133444d = r101;
            this.f133445e = r102;
            this.f133446f = r103;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void k() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void m(FailReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void n(InterruptReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public final View getView() {
        Function0<? extends View> r100 = this.f133440h.f133441a;
        if (r100 == null) goto L7;
        View r101 = r100.invoke();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f133438f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void j() {
        a.C2108a r100 = this.f133439g;
        if (r100 == null) goto L7;
        Function0<Unit> r101 = r100.f133449c;
        if (r101 == null) goto L7;
        Unit r102 = r101.invoke();
    L7:
        ((Map) this.f133402a.getValue()).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void l() {
        a.C2108a r100 = this.f133439g;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f133448b;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void o() {
        a.C2108a r100 = this.f133439g;
        if (r100 == null) goto L8;
        Function0<Unit> r101 = r100.f133447a;
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke();
        return;
    L9:
        return;
    }

    public f(String r100, n r101, Context r102, DataCenter r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r104, "builder");
        super(r100, r101, r103);
        this.f133440h = r104;
        this.f133438f = new View(r102);
        Function1<? super a.C2108a, Unit> r105 = r104.f133442b;
        if (r105 == null) goto L5;
        a.C2108a r106 = new a.C2108a(this);
        r105.invoke(r106);
    L6:
        this.f133439g = r106;
        return;
    L5:
        r106 = null;
        goto L6
    }
}
