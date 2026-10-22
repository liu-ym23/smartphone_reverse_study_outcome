package com.stepos.datacenter.vector;

import Ua.C1056g;
import Ua.Y;
import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.usearch.VectorUSearchWrapper;
import e7.VectorStoreConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/datacenter/vector/VectorStoreManager;", "", "Lcom/stepos/usearch/VectorUSearchWrapper;", "wrapper", "Le7/q;", "config", "<init>", "(Lcom/stepos/usearch/VectorUSearchWrapper;Le7/q;)V", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "id", "LY8/t;", "f", "(JLe9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/usearch/VectorUSearchWrapper;", Const.INTENT_KEY_PKGNAME, "Le7/q;", "c", "Z", "initialized", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VectorStoreManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static volatile VectorStoreManager f30114d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final VectorUSearchWrapper wrapper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final VectorStoreConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile boolean initialized;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/datacenter/vector/VectorStoreManager$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Le7/q;", "config", "Lcom/stepos/datacenter/vector/VectorStoreManager;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Le7/q;)Lcom/stepos/datacenter/vector/VectorStoreManager;", "", "TAG", "Ljava/lang/String;", "instance", "Lcom/stepos/datacenter/vector/VectorStoreManager;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.VectorStoreManager$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final VectorStoreManager a(Context context, VectorStoreConfig config) {
            VectorStoreManager vectorStoreManager;
            int i10;
            p.i(context, "context");
            p.i(config, "config");
            VectorStoreManager vectorStoreManager2 = VectorStoreManager.f30114d;
            if (vectorStoreManager2 != null) {
                return vectorStoreManager2;
            }
            synchronized (this) {
                vectorStoreManager = VectorStoreManager.f30114d;
                if (vectorStoreManager == null) {
                    int metric = config.getMetric();
                    if (metric != 0) {
                        i10 = 1;
                        if (metric != 1) {
                            i10 = 2;
                        }
                    } else {
                        i10 = 0;
                    }
                    int i11 = i10;
                    Context applicationContext = context.getApplicationContext();
                    p.h(applicationContext, "getApplicationContext(...)");
                    vectorStoreManager = new VectorStoreManager(new VectorUSearchWrapper(applicationContext, config.getDimension(), i11, 24, 128, 64, 0, 0, null, null, 960, null), config, null);
                    VectorStoreManager.f30114d = vectorStoreManager;
                }
            }
            return vectorStoreManager;
        }

        public Companion() {
        }
    }

    public /* synthetic */ VectorStoreManager(VectorUSearchWrapper vectorUSearchWrapper, VectorStoreConfig vectorStoreConfig, i iVar) {
        this(vectorUSearchWrapper, vectorStoreConfig);
    }

    public final Object f(long j10, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objP = this.wrapper.p(j10, interfaceC4014c);
        return objP == C4063a.g() ? objP : t.f7040a;
    }

    public final Object g(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new VectorStoreManager$initialize$2(this, null), interfaceC4014c);
    }

    /* renamed from: h, reason: from getter */
    public final boolean getInitialized() {
        return this.initialized;
    }

    public VectorStoreManager(VectorUSearchWrapper vectorUSearchWrapper, VectorStoreConfig vectorStoreConfig) {
        this.wrapper = vectorUSearchWrapper;
        this.config = vectorStoreConfig;
    }
}
