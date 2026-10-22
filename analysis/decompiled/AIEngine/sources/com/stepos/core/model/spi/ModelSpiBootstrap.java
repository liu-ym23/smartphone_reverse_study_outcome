package com.stepos.core.model.spi;

import android.content.Context;
import android.util.Log;
import b7.d;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelSpiBootstrap {
    public static final ModelSpiBootstrap INSTANCE = new ModelSpiBootstrap();
    private static final String TAG = "ModelSpiBootstrap";

    private ModelSpiBootstrap() {
    }

    public final void initialize(Context context) {
        g.f(context, "context");
        Iterator it = ServiceLoader.load(d.class, context.getClassLoader()).iterator();
        g.e(it, "iterator(...)");
        int i10 = 0;
        while (it.hasNext()) {
            d dVar = (d) it.next();
            try {
                dVar.initialize(context);
                i10++;
                Log.i(TAG, "IModelInitializer OK: " + dVar.getClass().getName());
            } catch (Exception e10) {
                Log.e(TAG, "IModelInitializer failed: ".concat(dVar.getClass().getName()), e10);
            }
        }
        if (i10 == 0) {
            Log.w(TAG, "No IModelInitializer implementations found via ServiceLoader");
        }
    }
}
