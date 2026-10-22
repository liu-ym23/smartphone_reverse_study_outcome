package com.stepos.datacenter.vector;

import La.K;
import Ua.AbstractC1067l0;
import Ua.C1056g;
import Ua.C1060i;
import Ua.C1071n0;
import Ua.L0;
import Ua.M;
import Y8.t;
import Z8.X;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.embedding.IEmbedding;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.datacenter.entity.MediaType;
import com.stepos.datacenter.vector.BgeEmbedProvider;
import com.stepos.datacenter.vector.EmbedProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.d;
import kotlinx.coroutines.g;
import p9.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR \u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/stepos/datacenter/vector/BgeEmbedProvider;", "Lcom/stepos/datacenter/vector/EmbedProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_UMID, "()Lkotlinx/coroutines/g;", "Lcom/stepos/datacenter/entity/MediaType;", "mediaType", "", UxipConstants.f30680s, "", "embed", "(Lcom/stepos/datacenter/entity/MediaType;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "appContext", "", Const.INTENT_KEY_PKGNAME, "I", "getDimension", "()I", "dimension", "c", "Ljava/lang/String;", "getModel", "()Ljava/lang/String;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "Ljava/util/Set;", "getSupportedMediaTypes", "()Ljava/util/Set;", "supportedMediaTypes", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BgeEmbedProvider implements EmbedProvider {

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC1067l0 f30093e;

    /* renamed from: f, reason: collision with root package name */
    public static final M f30094f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context appContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int dimension;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String model;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Set<MediaType> supportedMediaTypes;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)[F"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.datacenter.vector.BgeEmbedProvider$embed$2", f = "BgeEmbedProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.datacenter.vector.BgeEmbedProvider$embed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super float[]>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f30099a;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f30101c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f30101c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return BgeEmbedProvider.this.new AnonymousClass2(this.f30101c, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super float[]> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.f30099a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            AlgorithmClient<IEmbedding> bgeEmbedding = AlgorithmClients.INSTANCE.getBgeEmbedding();
            Context context = BgeEmbedProvider.this.appContext;
            kotlin.jvm.internal.p.h(context, "access$getAppContext$p(...)");
            try {
                float[] fArrEmbed = ((IEmbedding) AlgorithmClient.loadAlgorithm$default(bgeEmbedding, context, null, 2, null)).embed(this.f30101c);
                if (fArrEmbed != null && fArrEmbed.length != 0) {
                    return fArrEmbed;
                }
                throw new EmbedFailedException("BGE embed returned empty vector for: " + K.R1(this.f30101c, 50), null, 2, null);
            } catch (CancellationException e10) {
                throw e10;
            } catch (RuntimeException e11) {
                throw new EmbedFailedException("BGE embed IPC failed: " + e11.getMessage(), e11);
            }
        }
    }

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: e7.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BgeEmbedProvider.c(runnable);
            }
        });
        kotlin.jvm.internal.p.h(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        AbstractC1067l0 abstractC1067l0C = C1071n0.c(executorServiceNewSingleThreadExecutor);
        f30093e = abstractC1067l0C;
        f30094f = d.a(L0.b(null, 1, null).plus(abstractC1067l0C));
    }

    public BgeEmbedProvider(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.appContext = context.getApplicationContext();
        this.dimension = 512;
        this.model = "bge-small-zh@v1";
        this.supportedMediaTypes = X.d(MediaType.TEXT);
    }

    public static final Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable, "BGE-AIEngine");
        thread.setDaemon(true);
        return thread;
    }

    public final g d() {
        return C1060i.d(f30094f, null, null, new BgeEmbedProvider$prewarmAsync$1(this, null), 3, null);
    }

    @Override // com.stepos.datacenter.vector.EmbedProvider
    public Object embed(MediaType mediaType, String str, InterfaceC4014c<? super float[]> interfaceC4014c) {
        if (mediaType == MediaType.TEXT) {
            return C1056g.j(f30093e, new AnonymousClass2(str, null), interfaceC4014c);
        }
        throw new UnsupportedMediaTypeException(mediaType);
    }

    @Override // com.stepos.datacenter.vector.EmbedProvider
    public int getDimension() {
        return this.dimension;
    }

    @Override // com.stepos.datacenter.vector.EmbedProvider
    public int getMaxInputChars() {
        return EmbedProvider.b.a(this);
    }

    @Override // com.stepos.datacenter.vector.EmbedProvider
    public String getModel() {
        return this.model;
    }

    @Override // com.stepos.datacenter.vector.EmbedProvider
    public Set<MediaType> getSupportedMediaTypes() {
        return this.supportedMediaTypes;
    }
}
