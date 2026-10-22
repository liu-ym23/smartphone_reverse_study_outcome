package com.stepos.core.model.inference;

import b7.k;
import gc.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.m;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Preprocessor implements x6.d {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Preprocessor";
    private long lastProcessTimeMs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final String processImagePath(c.d dVar, k kVar) {
        return dVar.f13407b;
    }

    private final c.e processMixed(c.e eVar, k kVar) {
        List<v6.c> list = eVar.f13409b;
        ArrayList arrayList = new ArrayList(m.Z(list, 10));
        for (Object objProcessText : list) {
            if (objProcessText instanceof c.g) {
                objProcessText = processText((c.g) objProcessText, kVar);
            }
            arrayList.add(objProcessText);
        }
        return new c.e(arrayList, eVar.f13410c, eVar.f13411d);
    }

    private final boolean validateAudio(c.a aVar) {
        return !(aVar.f13386b.length == 0) && aVar.f13387c > 0;
    }

    private final boolean validateImage(c.C0155c c0155c) {
        return !c0155c.f13396b.isRecycled();
    }

    private final boolean validateImagePath(c.d dVar) {
        return !q.t0(dVar.f13407b) && new File(dVar.f13407b).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean validateMixed(v6.c.e r5) {
        /*
            r4 = this;
            java.util.List<v6.c> r0 = r5.f13409b
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L59
            java.util.List<v6.c> r5 = r5.f13409b
            r0 = 1
            if (r5 == 0) goto L16
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L16
        L14:
            r4 = r0
            goto L56
        L16:
            java.util.Iterator r5 = r5.iterator()
        L1a:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L14
            java.lang.Object r2 = r5.next()
            v6.c r2 = (v6.c) r2
            boolean r3 = r2 instanceof v6.c.g
            if (r3 == 0) goto L31
            v6.c$g r2 = (v6.c.g) r2
            boolean r2 = r4.validateText(r2)
            goto L53
        L31:
            boolean r3 = r2 instanceof v6.c.C0155c
            if (r3 == 0) goto L3c
            v6.c$c r2 = (v6.c.C0155c) r2
            boolean r2 = r4.validateImage(r2)
            goto L53
        L3c:
            boolean r3 = r2 instanceof v6.c.d
            if (r3 == 0) goto L47
            v6.c$d r2 = (v6.c.d) r2
            boolean r2 = r4.validateImagePath(r2)
            goto L53
        L47:
            boolean r3 = r2 instanceof v6.c.a
            if (r3 == 0) goto L52
            v6.c$a r2 = (v6.c.a) r2
            boolean r2 = r4.validateAudio(r2)
            goto L53
        L52:
            r2 = r0
        L53:
            if (r2 != 0) goto L1a
            r4 = r1
        L56:
            if (r4 == 0) goto L59
            return r0
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.model.inference.Preprocessor.validateMixed(v6.c$e):boolean");
    }

    private final boolean validateText(c.g gVar) {
        return !q.t0(gVar.f13416b);
    }

    public long getProcessTimeMs() {
        return this.lastProcessTimeMs;
    }

    @Override // x6.d
    public Object process(Object input, k modelConfig) {
        g.f(input, "input");
        g.f(modelConfig, "modelConfig");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (input instanceof c.g) {
            input = processText((c.g) input, modelConfig);
        } else if (input instanceof c.C0155c) {
            input = processImage((c.C0155c) input, modelConfig);
        } else if (input instanceof c.a) {
            input = processAudio((c.a) input, modelConfig);
        } else if (input instanceof c.d) {
            input = processImagePath((c.d) input, modelConfig);
        } else if (input instanceof c.e) {
            input = processMixed((c.e) input, modelConfig);
        }
        this.lastProcessTimeMs = System.currentTimeMillis() - jCurrentTimeMillis;
        return input;
    }

    public boolean validate(Object input, k modelConfig) {
        g.f(input, "input");
        g.f(modelConfig, "modelConfig");
        if (input instanceof c.g) {
            return validateText((c.g) input);
        }
        if (input instanceof c.C0155c) {
            return validateImage((c.C0155c) input);
        }
        if (input instanceof c.a) {
            return validateAudio((c.a) input);
        }
        if (input instanceof c.d) {
            return validateImagePath((c.d) input);
        }
        if (input instanceof c.e) {
            return validateMixed((c.e) input);
        }
        return false;
    }

    private final c.a processAudio(c.a aVar, k kVar) {
        return aVar;
    }

    private final Object processImage(c.C0155c c0155c, k kVar) {
        return c0155c;
    }

    private final c.g processText(c.g gVar, k kVar) {
        return gVar;
    }
}
