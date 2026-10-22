package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import xr2.h;

/* JADX INFO: loaded from: classes11.dex */
public final class IconTemplateProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b<?, ?>> f157440b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<IconTemplate, h> f157441a;

    public static final class a {
    }

    public static final class b<H extends IconTemplate, R extends h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<H> f157442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f157443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<H, R> f157444c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Class<H> r100, Class<R> r101, Function1<? super H, ? extends R> r102) {
            Intrinsics.checkNotNullParameter(r100, "hostType");
            Intrinsics.checkNotNullParameter(r101, "revenueType");
            Intrinsics.checkNotNullParameter(r102, "constructor");
            this.f157442a = r100;
            this.f157443b = r101;
            this.f157444c = r102;
        }
    }

    static {
        ArrayList r100 = new ArrayList();
        f157440b = r100;
        r100.add(new b(ICustomIconTemplate.class, xr2.b.class, IconTemplateProvider$Companion$1.INSTANCE));
        r100.add(new b(ITiltedIconTemplate.class, xr2.f.class, IconTemplateProvider$Companion$2.INSTANCE));
        r100.add(new b(ITiltedTempIconTemplate.class, xr2.g.class, IconTemplateProvider$Companion$3.INSTANCE));
    }

    public IconTemplateProvider() {
        this.f157441a = new WeakHashMap();
    }

    public final h a(IconTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        h r101 = (h) ((WeakHashMap) this.f157441a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Iterator<T> r102 = f157440b.iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        b r103 = (b) r102.next();
        if (r103.f157442a.isInstance(r100) == false) goto L7;
        Function r104 = r103.f157444c;
        if (r104 == null) goto L15;
        h r105 = (h) ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r104, 1)).invoke(r100);
        ((WeakHashMap) this.f157441a).put(r100, r105);
        return r105;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type (com.bytedance.android.livesdkapi.sti.framework.IconTemplate) -> com.bytedance.android.livesdk.revenue.sti.IconTemplate");
    L17:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
