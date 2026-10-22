package com.stepos.datacenter.api;

import Ua.C1060i;
import Ua.Y;
import android.content.Context;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.api.DataCenter;
import com.stepos.datacenter.vector.BgeEmbedProvider;
import com.stepos.datacenter.vector.VectorStoreManager;
import e7.VectorStoreConfig;
import e7.o;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/datacenter/api/LifecycleOps;", "", "<init>", "()V", "Ljava/io/File;", "dataRoot", "Le7/o;", Const.INTENT_KEY_UMID, "(Ljava/io/File;)Le7/o;", "Landroid/content/Context;", "context", "Le7/q;", "config", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Le7/q;)V", "e", "(Le7/q;)V", "", "dimension", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/Integer;)V", "c", "(Landroid/content/Context;)V", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleOps {

    /* renamed from: a, reason: collision with root package name */
    public static final LifecycleOps f29881a = new LifecycleOps();

    public final void a(Context context, VectorStoreConfig config) {
        p.i(context, "context");
        if (config != null) {
            BgeEmbedProvider bgeEmbedProvider = new BgeEmbedProvider(context);
            a.f29973a.b(bgeEmbedProvider);
            bgeEmbedProvider.d();
        }
        DataCenter.Companion companion = DataCenter.INSTANCE;
        companion.setAppContext$sdk_release(context.getApplicationContext());
        com.stepos.datacenter.core.a aVarA = com.stepos.datacenter.core.a.INSTANCE.a(context);
        if (companion.getInstance$sdk_release() == null) {
            synchronized (companion) {
                if (companion.getInstance$sdk_release() == null) {
                    companion.setInstance$sdk_release(new DataCenter(aVarA));
                    LifecycleOps lifecycleOps = f29881a;
                    Context applicationContext = context.getApplicationContext();
                    p.h(applicationContext, "getApplicationContext(...)");
                    lifecycleOps.c(applicationContext);
                    if (config != null) {
                        lifecycleOps.e(config);
                    }
                }
            }
        }
        d(Y6.b.a(context));
        Context applicationContext2 = context.getApplicationContext();
        p.h(applicationContext2, "getApplicationContext(...)");
        b(applicationContext2, config != null ? Integer.valueOf(config.getDimension()) : null);
    }

    public final void b(Context context, Integer dimension) {
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new LifecycleOps$initAmeProviderAsync$1(context, dimension, null), 3, null);
    }

    public final void c(Context context) {
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new LifecycleOps$initFullTextSearch$1(context, null), 3, null);
    }

    public final o d(File dataRoot) {
        p.i(dataRoot, "dataRoot");
        DataCenter.Companion companion = DataCenter.INSTANCE;
        o vectorRegistry$sdk_release = companion.getVectorRegistry$sdk_release();
        if (vectorRegistry$sdk_release != null && p.d(vectorRegistry$sdk_release.getRootDir(), dataRoot)) {
            return vectorRegistry$sdk_release;
        }
        o oVar = new o(dataRoot);
        oVar.i();
        companion.setVectorRegistry$sdk_release(oVar);
        Log.d("DataCenter", "VectorRegistry initialized at " + dataRoot.getAbsolutePath());
        return oVar;
    }

    public final void e(VectorStoreConfig config) {
        p.i(config, "config");
        DataCenter.Companion companion = DataCenter.INSTANCE;
        Context appContext$sdk_release = companion.getAppContext$sdk_release();
        if (appContext$sdk_release == null) {
            throw new IllegalStateException("DataCenter.init must be called before initVectorStore");
        }
        VectorStoreManager vectorStoreManagerA = VectorStoreManager.INSTANCE.a(appContext$sdk_release, config);
        companion.setVectorStoreManager$sdk_release(vectorStoreManagerA);
        companion.setVectorStoreEnabled$sdk_release(true);
        C1060i.d(kotlinx.coroutines.d.a(Y.b()), null, null, new LifecycleOps$initVectorStore$1(vectorStoreManagerA, config, null), 3, null);
    }
}
