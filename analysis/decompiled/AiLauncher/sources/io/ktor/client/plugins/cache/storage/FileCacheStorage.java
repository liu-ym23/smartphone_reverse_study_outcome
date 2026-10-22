package io.ktor.client.plugins.cache.storage;

import La.D;
import Ua.C1056g;
import Ua.C1060i;
import Ua.I;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.zyql.ai.selector.camera.CustomCameraView;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.n;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\n2\u001e\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u0012H\u0082H¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0018\u0010\u0011J&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0082@¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001d\u0010\u0011J \u0010!\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000fH\u0082@¢\u0006\u0004\b!\u0010\"J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020#H\u0082@¢\u0006\u0004\b\u0010\u0010$J \u0010&\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b(\u0010)J.\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*H\u0096@¢\u0006\u0004\b,\u0010-J,\u0010.\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0*H\u0096@¢\u0006\u0004\b.\u0010-J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b/\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Ljava/io/File;", "directory", "LUa/I;", "dispatcher", "<init>", "(Ljava/io/File;LUa/I;)V", "Lio/ktor/http/Url;", "url", "", "key", "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "readCache", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "transform", "LY8/t;", "updateCache", "(Ljava/lang/String;Lp9/l;Le9/c;)Ljava/lang/Object;", "deleteCache", "caches", "", "writeCacheUnsafe", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "readCacheUnsafe", "Lio/ktor/utils/io/ByteChannel;", "channel", "cache", "writeCache", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "data", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Le9/c;)Ljava/lang/Object;", "findAll", "(Lio/ktor/http/Url;Le9/c;)Ljava/lang/Object;", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "remove", "removeAll", "Ljava/io/File;", "LUa/I;", "Lio/ktor/util/collections/ConcurrentMap;", "Leb/a;", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class FileCacheStorage implements CacheStorage {
    private final File directory;
    private final I dispatcher;
    private final ConcurrentMap<String, InterfaceC4021a> mutexes;

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {252}, m = "deleteCache")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.deleteCache(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {96}, m = "find")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42201(InterfaceC4014c<? super C42201> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.find(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {92}, m = "findAll")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42211(InterfaceC4014c<? super C42211> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.findAll(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {252, 118}, m = "readCache")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42221 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C42221(InterfaceC4014c<? super C42221> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((String) null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {209, 210, 210, 211, 212, 215, 216, 219, 220, 221, 222, 225, 226, 230, 232}, m = "readCache")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache((ByteReadChannel) null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {171, 174, 176}, m = "readCacheUnsafe")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42231 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C42231(InterfaceC4014c<? super C42231> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCacheUnsafe(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {254, CustomCameraView.BUTTON_STATE_ONLY_CAPTURE, CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "remove")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42241 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C42241(InterfaceC4014c<? super C42241> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.remove(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", l = {254, CustomCameraView.BUTTON_STATE_ONLY_CAPTURE, CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ CachedResponseData $data;
        final /* synthetic */ Url $url;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Url url, CachedResponseData cachedResponseData, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$url = url;
            this.$data = cachedResponseData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return FileCacheStorage.this.new AnonymousClass2(this.$url, this.$data, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(4:(1:(6:7|52|8|9|42|43)(2:12|13))(11:14|54|15|16|48|28|(4:31|(2:33|57)(1:58)|34|29)|56|38|(3:41|42|43)|40)|11|46|47)(1:19))(3:20|(1:23)|40)|50|24|(7:27|48|28|(1:29)|56|38|(0))|40|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0173, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0174, code lost:
        
            r1 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0111 A[Catch: all -> 0x0131, TryCatch #0 {all -> 0x0131, blocks: (B:28:0x00fd, B:29:0x010b, B:31:0x0111, B:33:0x0129, B:38:0x0135), top: B:48:0x00fd }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x016b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 378
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileCacheStorage.kt", l = {186, 187, PictureConfig.CHOOSE_REQUEST, 189, 191, 193, 194, 196, 197, 198, 199, 201, 202, 204, 205}, m = "writeCache")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C42251(InterfaceC4014c<? super C42251> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.writeCache(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2", f = "FileCacheStorage.kt", l = {157}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42262 extends SuspendLambda implements p<M, InterfaceC4014c<? super Object>, Object> {
        final /* synthetic */ List<CachedResponseData> $caches;
        final /* synthetic */ String $urlHex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42262(String str, List<CachedResponseData> list, InterfaceC4014c<? super C42262> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$urlHex = str;
            this.$caches = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C42262 c42262 = FileCacheStorage.this.new C42262(this.$urlHex, this.$caches, interfaceC4014c);
            c42262.L$0 = obj;
            return c42262;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<Object> interfaceC4014c) {
            return ((C42262) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            BufferedOutputStream bufferedOutputStream;
            Throwable th;
            Closeable closeable;
            M m10 = (M) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteChannel byteChannel = new ByteChannel(false, 1, null);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(FileCacheStorage.this.directory, this.$urlHex)), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                    try {
                        C1060i.d(m10, null, null, new FileCacheStorage$writeCacheUnsafe$2$1$1(byteChannel, this.$caches, FileCacheStorage.this, null), 3, null);
                        this.L$0 = g9.h.a(m10);
                        this.L$1 = g9.h.a(byteChannel);
                        this.L$2 = bufferedOutputStream2;
                        this.L$3 = g9.h.a(bufferedOutputStream2);
                        this.I$0 = 0;
                        this.label = 1;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            obj = WritingKt.copyTo$default(byteChannel, bufferedOutputStream, 0L, this, 2, null);
                            if (obj == objG) {
                                return objG;
                            }
                            closeable = bufferedOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            closeable = bufferedOutputStream;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = bufferedOutputStream2;
                    }
                } catch (Exception e10) {
                    vc.c logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Exception during saving a cache to a file: " + Y8.d.b(e10));
                    }
                    return t.f7040a;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$2;
                try {
                    C4849c.b(obj);
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        l9.b.a(closeable, th);
                        throw th5;
                    }
                }
            }
            Long lG = C4109a.g(((Number) obj).longValue());
            l9.b.a(closeable, null);
            return lG;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Object> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<Object>) interfaceC4014c);
        }
    }

    public FileCacheStorage(File directory, I dispatcher) {
        kotlin.jvm.internal.p.i(directory, "directory");
        kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
        this.directory = directory;
        this.dispatcher = dispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, null);
        directory.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteCache(java.lang.String r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            eb.a r6 = (eb.InterfaceC4021a) r6
            java.lang.Object r1 = r0.L$1
            eb.a r1 = (eb.InterfaceC4021a) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r7)
            r7 = r6
            r6 = r0
            goto L66
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            kotlin.C4849c.b(r7)
            io.ktor.util.collections.ConcurrentMap<java.lang.String, eb.a> r7 = r5.mutexes
            io.ktor.client.plugins.cache.storage.c r2 = new io.ktor.client.plugins.cache.storage.c
            r2.<init>()
            java.lang.Object r7 = r7.computeIfAbsent(r6, r2)
            eb.a r7 = (eb.InterfaceC4021a) r7
            r0.L$0 = r6
            java.lang.Object r2 = g9.h.a(r7)
            r0.L$1 = r2
            r0.L$2 = r7
            r2 = 0
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r0 = r7.m(r4, r0)
            if (r0 != r1) goto L66
            return r1
        L66:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L77
            java.io.File r5 = r5.directory     // Catch: java.lang.Throwable -> L77
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L77
            boolean r5 = r0.exists()     // Catch: java.lang.Throwable -> L77
            if (r5 == 0) goto L9c
            r0.delete()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
            goto L9c
        L77:
            r5 = move-exception
            goto La4
        L79:
            r5 = move-exception
            vc.c r6 = io.ktor.client.plugins.cache.HttpCacheKt.getLOGGER()     // Catch: java.lang.Throwable -> L77
            boolean r0 = io.ktor.util.logging.LoggerJvmKt.isTraceEnabled(r6)     // Catch: java.lang.Throwable -> L77
            if (r0 == 0) goto L9c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r0.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "Exception during cache deletion in a file: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = Y8.d.b(r5)     // Catch: java.lang.Throwable -> L77
            r0.append(r5)     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L77
            r6.trace(r5)     // Catch: java.lang.Throwable -> L77
        L9c:
            Y8.t r5 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L77
            r7.l(r4)
            Y8.t r5 = Y8.t.f7040a
            return r5
        La4:
            r7.l(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.deleteCache(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4021a deleteCache$lambda$7() {
        return eb.f.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(D.G(url.getUrlString()));
        kotlin.jvm.internal.p.h(bArrDigest, "digest(...)");
        return CryptoKt.hex(bArrDigest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readCache(java.lang.String r10, e9.InterfaceC4014c<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C42221
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C42221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5a
            if (r2 == r5) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r9 = r0.L$2
            eb.a r9 = (eb.InterfaceC4021a) r9
            java.lang.Object r10 = r0.L$1
            eb.a r10 = (eb.InterfaceC4021a) r10
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L3a
            goto L9f
        L3a:
            r10 = move-exception
            goto La7
        L3d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L45:
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$2
            eb.a r2 = (eb.InterfaceC4021a) r2
            java.lang.Object r5 = r0.L$1
            eb.a r5 = (eb.InterfaceC4021a) r5
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r11)
            r11 = r2
            r2 = r10
            r10 = r7
            goto L81
        L5a:
            kotlin.C4849c.b(r11)
            io.ktor.util.collections.ConcurrentMap<java.lang.String, eb.a> r11 = r9.mutexes
            io.ktor.client.plugins.cache.storage.b r2 = new io.ktor.client.plugins.cache.storage.b
            r2.<init>()
            java.lang.Object r11 = r11.computeIfAbsent(r10, r2)
            eb.a r11 = (eb.InterfaceC4021a) r11
            r0.L$0 = r10
            java.lang.Object r2 = g9.h.a(r11)
            r0.L$1 = r2
            r0.L$2 = r11
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r2 = r11.m(r6, r0)
            if (r2 != r1) goto L7f
            goto L9b
        L7f:
            r5 = r11
            r2 = r3
        L81:
            java.lang.Object r7 = g9.h.a(r10)     // Catch: java.lang.Throwable -> La5
            r0.L$0 = r7     // Catch: java.lang.Throwable -> La5
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> La5
            r0.L$1 = r5     // Catch: java.lang.Throwable -> La5
            r0.L$2 = r11     // Catch: java.lang.Throwable -> La5
            r0.I$0 = r2     // Catch: java.lang.Throwable -> La5
            r0.I$1 = r3     // Catch: java.lang.Throwable -> La5
            r0.label = r4     // Catch: java.lang.Throwable -> La5
            java.lang.Object r9 = r9.readCacheUnsafe(r10, r0)     // Catch: java.lang.Throwable -> La5
            if (r9 != r1) goto L9c
        L9b:
            return r1
        L9c:
            r8 = r11
            r11 = r9
            r9 = r8
        L9f:
            java.util.Set r11 = (java.util.Set) r11     // Catch: java.lang.Throwable -> L3a
            r9.l(r6)
            return r11
        La5:
            r10 = move-exception
            r9 = r11
        La7:
            r9.l(r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCache(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4021a readCache$lambda$4() {
        return eb.f.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119 A[Catch: all -> 0x015c, TryCatch #2 {all -> 0x015c, blocks: (B:45:0x014c, B:41:0x0119, B:48:0x0160, B:39:0x0107, B:35:0x00db), top: B:68:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160 A[Catch: all -> 0x015c, TRY_LEAVE, TryCatch #2 {all -> 0x015c, blocks: (B:45:0x014c, B:41:0x0119, B:48:0x0160, B:39:0x0107, B:35:0x00db), top: B:68:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r24v0, types: [io.ktor.client.plugins.cache.storage.FileCacheStorage] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0143 -> B:45:0x014c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readCacheUnsafe(java.lang.String r25, e9.InterfaceC4014c<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCacheUnsafe(java.lang.String, e9.c):java.lang.Object");
    }

    private final Object updateCache(String str, InterfaceC5074l<? super Set<CachedResponseData>, ? extends List<CachedResponseData>> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC4021a interfaceC4021a = (InterfaceC4021a) this.mutexes.computeIfAbsent((ConcurrentMap) str, (InterfaceC5063a) FileCacheStorage$updateCache$mutex$1.INSTANCE);
        n.c(0);
        interfaceC4021a.m(null, interfaceC4014c);
        n.c(1);
        try {
            n.c(3);
            n.c(0);
            Object cacheUnsafe = readCacheUnsafe(str, null);
            n.c(1);
            List<CachedResponseData> listInvoke = interfaceC5074l.invoke((Set) cacheUnsafe);
            n.c(3);
            n.c(0);
            writeCacheUnsafe(str, listInvoke, null);
            n.c(1);
            n.b(1);
            interfaceC4021a.l(null);
            n.a(1);
            return t.f7040a;
        } catch (Throwable th) {
            n.b(1);
            interfaceC4021a.l(null);
            n.a(1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0202, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r1, r9, r0) != r12) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0283, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r4, r6, r0) != r12) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02ff, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r1, r9, r0) != r12) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x038a, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r4, r6, r0) != r12) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x03cf, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r0, r1, 0, 0, r4, 6, null) != r12) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0138 A[PHI: r10 r11
      0x0138: PHI (r10v12 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r10v9 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r10v15 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:42:0x01e5, B:26:0x012d] A[DONT_GENERATE, DONT_INLINE]
      0x0138: PHI (r11v11 io.ktor.utils.io.ByteChannel) = (r11v8 io.ktor.utils.io.ByteChannel), (r11v14 io.ktor.utils.io.ByteChannel) binds: [B:42:0x01e5, B:26:0x012d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c7 A[PHI: r10 r11
      0x01c7: PHI (r10v9 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r10v6 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r10v11 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:39:0x01c3, B:28:0x013c] A[DONT_GENERATE, DONT_INLINE]
      0x01c7: PHI (r11v8 io.ktor.utils.io.ByteChannel) = (r11v5 io.ktor.utils.io.ByteChannel), (r11v10 io.ktor.utils.io.ByteChannel) binds: [B:39:0x01c3, B:28:0x013c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02c9 A[PHI: r1 r10 r11
      0x02c9: PHI (r1v26 io.ktor.utils.io.ByteChannel) = (r1v23 io.ktor.utils.io.ByteChannel), (r1v28 io.ktor.utils.io.ByteChannel) binds: [B:61:0x02c5, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x02c9: PHI (r10v37 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r10v34 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r10v39 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:61:0x02c5, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]
      0x02c9: PHI (r11v31 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r11v28 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r11v33 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:61:0x02c5, B:20:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e5 A[PHI: r1 r10 r11
      0x02e5: PHI (r1v29 io.ktor.utils.io.ByteChannel) = (r1v26 io.ktor.utils.io.ByteChannel), (r1v31 io.ktor.utils.io.ByteChannel) binds: [B:64:0x02e1, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x02e5: PHI (r10v40 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>) = 
      (r10v37 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
      (r10v42 java.util.List<kotlin.Pair<java.lang.String, java.lang.String>>)
     binds: [B:64:0x02e1, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]
      0x02e5: PHI (r11v34 io.ktor.client.plugins.cache.storage.CachedResponseData) = 
      (r11v31 io.ktor.client.plugins.cache.storage.CachedResponseData)
      (r11v36 io.ktor.client.plugins.cache.storage.CachedResponseData)
     binds: [B:64:0x02e1, B:19:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0283 -> B:23:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x038a -> B:16:0x006e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeCache(io.ktor.utils.io.ByteChannel r10, io.ktor.client.plugins.cache.storage.CachedResponseData r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.writeCache(io.ktor.utils.io.ByteChannel, io.ktor.client.plugins.cache.storage.CachedResponseData, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeCacheUnsafe(String str, List<CachedResponseData> list, InterfaceC4014c<Object> interfaceC4014c) {
        return kotlinx.coroutines.d.f(new C42262(str, list, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object find(io.ktor.http.Url r5, java.util.Map<java.lang.String, java.lang.String> r6, e9.InterfaceC4014c<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C42201
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C42201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r6 = r4
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r4 = r0.L$0
            io.ktor.http.Url r4 = (io.ktor.http.Url) r4
            kotlin.C4849c.b(r7)
            goto L52
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.C4849c.b(r7)
            java.lang.String r7 = r4.key(r5)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r4.readCache(r7, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            java.util.Set r7 = (java.util.Set) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
        L5a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L9e
            java.lang.Object r5 = r4.next()
            r7 = r5
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L6e
            return r5
        L6e:
            java.util.Set r0 = r6.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L76:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L9d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map r3 = r7.getVaryKeys()
            java.lang.Object r2 = r3.get(r2)
            boolean r1 = kotlin.jvm.internal.p.d(r2, r1)
            if (r1 != 0) goto L76
            goto L5a
        L9d:
            return r5
        L9e:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.find(io.ktor.http.Url, java.util.Map, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object findAll(io.ktor.http.Url r5, e9.InterfaceC4014c<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage.C42211
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage.C42211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.http.Url r4 = (io.ktor.http.Url) r4
            kotlin.C4849c.b(r6)
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            java.lang.String r6 = r4.key(r5)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readCache(r6, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r4 = Z8.F.r1(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.findAll(io.ktor.http.Url, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(4:(1:(6:13|55|14|15|47|48)(2:18|19))(10:20|51|21|22|34|(4:37|(2:39|58)(1:59)|40|35)|57|43|(3:46|47|48)|45)|17|49|50)(1:25))(3:26|(1:29)|45)|53|30|(2:32|45)(7:33|34|(1:35)|57|43|(0)|45)) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0161, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0162, code lost:
    
        r3 = r4;
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0146 A[Catch: all -> 0x0161, TryCatch #1 {all -> 0x0161, blocks: (B:34:0x0132, B:35:0x0140, B:37:0x0146, B:39:0x015a, B:43:0x0165, B:30:0x0101), top: B:53:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object remove(io.ktor.http.Url r20, java.util.Map<java.lang.String, java.lang.String> r21, e9.InterfaceC4014c<? super Y8.t> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.remove(io.ktor.http.Url, java.util.Map, e9.c):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objDeleteCache = deleteCache(key(url), interfaceC4014c);
        return objDeleteCache == C4063a.g() ? objDeleteCache : t.f7040a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(this.dispatcher, new AnonymousClass2(url, cachedResponseData, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public /* synthetic */ FileCacheStorage(File file, I i10, int i11, kotlin.jvm.internal.i iVar) {
        this(file, (i11 & 2) != 0 ? Y.b() : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x02ee, code lost:
    
        if (r1 != r3) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x03f9, code lost:
    
        if (r1 != r3) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03af A[PHI: r0 r1 r2 r4 r5 r6 r7 r8 r9
      0x03af: PHI (r0v29 int) = (r0v27 int), (r0v30 int) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r1v39 java.lang.Object) = (r1v38 java.lang.Object), (r1v1 java.lang.Object) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r2v12 io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3) = 
      (r2v11 io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3)
      (r2v2 io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$3)
     binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r4v31 io.ktor.util.date.GMTDate) = (r4v28 io.ktor.util.date.GMTDate), (r4v33 io.ktor.util.date.GMTDate) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r5v30 io.ktor.http.HeadersBuilder) = (r5v26 io.ktor.http.HeadersBuilder), (r5v33 io.ktor.http.HeadersBuilder) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r6v27 io.ktor.http.HttpProtocolVersion) = (r6v23 io.ktor.http.HttpProtocolVersion), (r6v30 io.ktor.http.HttpProtocolVersion) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r7v19 io.ktor.http.HttpStatusCode) = (r7v15 io.ktor.http.HttpStatusCode), (r7v22 io.ktor.http.HttpStatusCode) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r8v19 java.lang.String) = (r8v15 java.lang.String), (r8v22 java.lang.String) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]
      0x03af: PHI (r9v18 io.ktor.utils.io.ByteReadChannel) = (r9v16 io.ktor.utils.io.ByteReadChannel), (r9v21 io.ktor.utils.io.ByteReadChannel) binds: [B:64:0x03ab, B:20:0x0193] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0353 -> B:58:0x035d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x04a1 -> B:83:0x04b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readCache(io.ktor.utils.io.ByteReadChannel r28, e9.InterfaceC4014c<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.readCache(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }
}
