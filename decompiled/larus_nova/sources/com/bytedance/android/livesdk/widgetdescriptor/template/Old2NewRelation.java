package com.bytedance.android.livesdk.widgetdescriptor.template;

import com.bytedance.android.livesdk.widgetdescriptor.e0;
import j70.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Old2NewRelation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f162475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f162476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f162477c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f162478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f162479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f162480c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 7);
        }

        public /* synthetic */ a(List r100, c r101, int r102) {
            Boolean r103 = null;
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r102 & 4) == 0) goto L11;
            r103 = Boolean.FALSE;
        L11:
            this(r100, r101, r103);
        }

        public a(List<String> r100, c r101, Boolean r102) {
            this.f162478a = r100;
            this.f162479b = r101;
            this.f162480c = r102;
        }
    }

    public Old2NewRelation(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        this.f162477c = r100;
        this.f162475a = LazyKt.lazy(new Old2NewRelation$portraitRelation$2(this));
        this.f162476b = LazyKt.lazy(new Old2NewRelation$landscapeRelation$2(this));
    }
}
