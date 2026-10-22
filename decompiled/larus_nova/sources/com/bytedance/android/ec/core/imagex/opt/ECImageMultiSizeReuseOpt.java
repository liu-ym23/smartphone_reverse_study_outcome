package com.bytedance.android.ec.core.imagex.opt;

import android.util.LruCache;
import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class ECImageMultiSizeReuseOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f44765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f44767c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f44768d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ECImageMultiSizeReuseOpt f44769e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$CacheType;", "", "REUSE_THUMB_CACHE", "REUSE_CACHE", "PRELOAD_REUSE_CACHE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType PRELOAD_REUSE_CACHE = null;
        public static final CacheType REUSE_CACHE = null;
        public static final CacheType REUSE_THUMB_CACHE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CacheType[] f44770a = null;

        static {
            CacheType r100 = new CacheType("REUSE_THUMB_CACHE", 0);
            REUSE_THUMB_CACHE = r100;
            CacheType r101 = new CacheType("REUSE_CACHE", 1);
            REUSE_CACHE = r101;
            CacheType r102 = new CacheType("PRELOAD_REUSE_CACHE", 2);
            PRELOAD_REUSE_CACHE = r102;
            f44770a = new CacheType[]{r100, r101, r102};
        }

        public static CacheType valueOf(String r100) {
            return (CacheType) r27.a.a(CacheType.class, r100);
        }

        public static CacheType[] values() {
            return (CacheType[]) f44770a.clone();
        }

        public CacheType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u001b\b\u0002\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache;", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$c;", "Lkotlin/collections/HashMap;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageRequest", "Lcom/bytedance/android/ec/core/imagex/r;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "onlyFrescoCacheEmpty", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$b;", "getBitmapCache", "Lcom/facebook/cache/common/CacheKey;", "cacheKey", "key", "value", "Ljava/lang/ref/Reference;", "Lcom/facebook/imagepipeline/image/CloseableStaticBitmap;", "bitmapRef", "", "putCache", "removeCache", "Ljava/util/concurrent/locks/ReadWriteLock;", "lock", "Ljava/util/concurrent/locks/ReadWriteLock;", "com/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache$a", "lru", "Lcom/bytedance/android/ec/core/imagex/opt/ECImageMultiSizeReuseOpt$InnerLruCache$a;", "", "maxSize", "I", "<init>", "(I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerLruCache extends HashMap<String, List<? extends c>> {
        private final ReadWriteLock lock;
        private final a lru;
        private final int maxSize;

        public static final class a extends LruCache<CacheKey, Pair<? extends String, ? extends c>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InnerLruCache f44771a;

            public a(InnerLruCache r100, int r101) {
                this.f44771a = r100;
                super(r101);
            }

            @Override // android.util.LruCache
            public final void entryRemoved(boolean r100, CacheKey r101, Pair<? extends String, ? extends c> r102, Pair<? extends String, ? extends c> r103) {
                CacheKey r104 = r101;
                Pair<? extends String, ? extends c> r105 = r102;
                if (r105 == null) goto L5;
                String r106 = r105.getFirst();
            L6:
                if (r100 == false) goto L11;
                if (r104 == null) goto L12;
                if (r106 == null) goto L13;
                InnerLruCache.access$removeCache(this.f44771a, r106, r104);
                return;
            L13:
                return;
            L12:
                return;
            L11:
                return;
            L5:
                r106 = null;
                goto L6
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, List<c>>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<List<c>> values() {
            return getValues();
        }

        public InnerLruCache(int r100) {
            this.maxSize = r100;
            this.lock = new ReentrantReadWriteLock();
            this.lru = new a(this, r100);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return false;
        L7:
            return containsKey((String) r100);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r100) {
            if ((r100 instanceof List) == true) goto L7;
            return false;
        L7:
            return containsValue((List) r100);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ List<c> get(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return get((String) r100);
        }

        public final b getBitmapCache(CacheKey r100) {
            Pair<? extends String, ? extends c> r101 = this.lru.get(r100);
            if (r101 == null) goto L14;
            c r102 = r101.getSecond();
            if (r102 == null) goto L14;
            Reference<CloseableStaticBitmap> r103 = r102.f44781a;
            if (r103 == null) goto L9;
            CloseableStaticBitmap r104 = r103.get();
        L10:
            if (r104 != null) goto L12;
        L13:
            r102.f44781a = null;
            goto L14
        L12:
            if (r104.isClosed() == true) goto L13;
        L15:
            if (r104 != null) goto L17;
        L20:
            return null;
        L17:
            if (i.a(r104) != true) goto L20;
            return new b(r104);
        L9:
            r104 = null;
        L14:
            r104 = null;
            goto L15
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ List<c> remove(Object r100) {
            if ((r100 instanceof String) == true) goto L7;
            return null;
        L7:
            return remove((String) r100);
        }

        public /* bridge */ boolean containsKey(String r100) {
            return super.containsKey(r100);
        }

        public /* bridge */ boolean containsValue(List r100) {
            return super.containsValue(r100);
        }

        public /* bridge */ List get(String r100) {
            return (List) super.get(r100);
        }

        public /* bridge */ List remove(String r100) {
            return (List) super.remove(r100);
        }

        public final void a(String r100, CacheKey r101) {
            this.lock.writeLock().lock();
            List<c> r102 = get(r100);     // Catch: Throwable -> L22
            if (r102 == null) goto L14;
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L22
            Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L22
        L7:
            if (r104.hasNext() == false) goto L15;
            Object r105 = r104.next();     // Catch: Throwable -> L22
            if (((c) r105).f44785e == r101) goto L11;
            boolean r106 = true;
        L12:
            if (r106 == false) goto L7;
            r103.add(r105);     // Catch: Throwable -> L22
            goto L7
        L11:
            r106 = false;
        L15:
            if (r103 != null) goto L17;
        L20:
            this.lock.writeLock().unlock();
            return;
        L17:
            if ((!r103.isEmpty()) == false) goto L19;
            put(r100, r103);     // Catch: Throwable -> L22
            goto L20
        L19:
            remove(r100);     // Catch: Throwable -> L22
            goto L20
        L14:
            r103 = null;
        L22:
            th = move-exception;
            this.lock.writeLock().unlock();
            throw th;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
            if (r100 == null) goto L4;
            boolean r102 = r100 instanceof String;
        L5:
            if (r102 == true) goto L8;
            return r101;
        L8:
            return getOrDefault((String) r100, (List) r101);
        L4:
            r102 = true;
            goto L5
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r100, Object r101) {
            boolean r102 = true;
            if (r100 == null) goto L5;
            boolean r103 = r100 instanceof String;
        L6:
            if (r103 == false) goto L13;
            if (r101 == null) goto L9;
            r102 = r101 instanceof List;
        L9:
            if (r102 == true) goto L12;
            return false;
        L12:
            return remove((String) r100, (List) r101);
        L13:
            return false;
        L5:
            r103 = true;
            goto L6
        }

        public final void removeCache(String r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            a(r100, r101.f44785e);
        }

        public /* bridge */ List getOrDefault(String r100, List r101) {
            return (List) super.getOrDefault(r100, r101);
        }

        public /* bridge */ boolean remove(String r100, List r101) {
            return super.remove(r100, r101);
        }

        public static final /* synthetic */ void access$removeCache(InnerLruCache r100, String r101, CacheKey r102) {
            r100.a(r101, r102);
        }

        public final b getBitmapCache(ImageRequest r100, com.bytedance.android.ec.core.imagex.r r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "imageRequest");
            CacheKey r103 = ECImageMultiSizeReuseOpt.a(ECImageMultiSizeReuseOpt.f44769e, r100, r101);
            if (r102 == false) goto L18;
            CloseableReference<CloseableImage> r104 = null;
            CloseableReference<CloseableImage> r105 = Fresco.getImagePipelineFactory().getImagePipeline().getCachedImage(r103);     // Catch: Throwable -> L14
        L12:
            th = th;
            r104 = r105;
        L15:
            CloseableReference.closeSafely(r104);
            throw th;
        L7:
            if (CloseableReference.isValid(r105) == false) goto L11;
            b r106 = new b(null);     // Catch: Throwable -> L12
            CloseableReference.closeSafely(r105);
            return r106;
        L11:
            CloseableReference.closeSafely(r105);
        L14:
            th = th;
        L18:
            return getBitmapCache(r103);
        }

        public final void putCache(String r100, c r101, Reference<CloseableStaticBitmap> r110) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.lock.writeLock().lock();
            List<c> r102 = get(r100);     // Catch: Throwable -> L46
            if (r102 != null) goto L6;
            r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L46
        L6:
            ArrayList r103 = new ArrayList();     // Catch: Throwable -> L46
            Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L46
        L8:
            if (r104.hasNext() == false) goto L12;
            Object r105 = r104.next();     // Catch: Throwable -> L46
            if ((true ^ Intrinsics.areEqual(((c) r105).f44785e, r101.f44785e)) == false) goto L8;
            r103.add(r105);     // Catch: Throwable -> L46
            goto L8
        L12:
            List r106 = CollectionsKt.toMutableList(r103);     // Catch: Throwable -> L46
            if (r101.f44783c == 0) goto L17;
            if (r101.f44784d == 0) goto L17;
        L35:
            if (r110 == null) goto L43;
            CloseableStaticBitmap r107 = r110.get();     // Catch: Throwable -> L46
            if (r107 == null) goto L43;
            if (r107.isClosed() == true) goto L43;
            if (r107.isThumbCache() == true) goto L43;
            Intrinsics.checkNotNullParameter(r110, "imageRef");     // Catch: Throwable -> L46
            r101.f44781a = r110;     // Catch: Throwable -> L46
        L43:
            r106.add(r101);     // Catch: Throwable -> L46
            put(r100, r106);     // Catch: Throwable -> L46
            this.lru.put(r101.f44785e, new Pair(r100, r101));     // Catch: Throwable -> L46
            this.lock.writeLock().unlock();
            return;
        L17:
            if (r106.size() >= r102.size()) goto L35;
            Iterator<T> r108 = r102.iterator();     // Catch: Throwable -> L46
        L20:
            if (r108.hasNext() == false) goto L31;
            Object r109 = r108.next();     // Catch: Throwable -> L46
            c r111 = (c) r109;     // Catch: Throwable -> L46
            if (Intrinsics.areEqual(r111.f44785e, r101.f44785e) == true) goto L24;
        L28:
            boolean r112 = false;
        L29:
            if (r112 == false) goto L20;
        L32:
            c r113 = (c) r109;     // Catch: Throwable -> L46
            if (r113 == null) goto L35;
            r101 = r113;
            goto L35
        L24:
            if (r111.f44783c <= 0) goto L28;
            if (r111.f44784d <= 0) goto L28;
            r112 = true;
            goto L29
        L31:
            r109 = null;
        L46:
            th = move-exception;
            this.lock.writeLock().unlock();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void putCache$default(InnerLruCache r100, String r101, c r102, Reference r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L5;
            r103 = null;
        L5:
            r100.putCache(r101, r102, r103);
        }
    }

    public static final class a implements ReadOnlyProperty<Object, com.bytedance.android.shopping.api.image.b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f44772g = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LazyFastSDKSettings f44773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.android.shopping.api.image.b f44774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f44775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f44776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f44777e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function2 f44778f;

        static {
            f44772g = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "value", "getValue()Ljava/lang/Object;", 0))};
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.shopping.api.image.b, java.lang.Object] */
        @Override // kotlin.properties.ReadOnlyProperty
        public final com.bytedance.android.shopping.api.image.b getValue(Object r100, KProperty<?> r101) {
            Intrinsics.checkNotNullParameter(r100, "thisRef");
            Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            if (this.f44774b != null) goto L5;
            LazyFastSDKSettings r102 = this.f44773a;
            KProperty<?>[] r103 = f44772g;
            if (r102.getValue(this, r103[0]) == this.f44776d) goto L15;
            this.f44774b = this.f44773a.getValue(this, r103[0]);
            if (ColdLaunchExpFilter.f45205e.b(this.f44775c) == true) goto L15;
            return this.f44774b;
        L15:
            return null;
        L5:
            if (ColdLaunchExpFilter.f45205e.b(this.f44775c) == false) goto L8;
            return null;
        L8:
            return this.f44774b;
        }

        public a(final com.bytedance.android.shopping.api.image.b r100, Function0 r110, ImageXSettingKt$lazyImageXSettingsOrNull$4 r111) {
            final String r101 = "ec_image_multi_size_reuse_config";
            this.f44775c = "ec_image_multi_size_reuse_config";
            this.f44776d = r100;
            this.f44777e = r110;
            this.f44778f = r111;
            this.f44773a = new LazyFastSDKSettings("ec_image_multi_size_reuse_config", r100, null, r110, r111, new ECImageMultiSizeReuseOpt$$special$$inlined$lazyImageXSettingsOrNull$1$1(r101, r100));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CloseableStaticBitmap f44779a;

        public b(CloseableStaticBitmap r100) {
            this.f44779a = r100;
        }
    }

    public static final class c implements com.bytedance.android.shopping.api.image.q {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f44780g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Reference<CloseableStaticBitmap> f44781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f44782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f44783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f44784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CacheKey f44785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.bytedance.android.shopping.api.image.q f44786f;

        public static final class a {
            public static c a(String r100, int r101, int r102, CacheKey r110, com.bytedance.android.shopping.api.image.q r111) {
                Intrinsics.checkNotNullParameter(r100, "realUrl");
                Intrinsics.checkNotNullParameter(r110, "requestCacheKey");
                Intrinsics.checkNotNullParameter(r111, "imageXUrlParams");
                if ((r111 instanceof c) == true) goto L5;
                com.bytedance.android.shopping.api.image.q r103 = null;
            L6:
                c r104 = (c) r103;
                if (r104 == null) goto L12;
                com.bytedance.android.shopping.api.image.q r105 = r104.f44786f;
                if (r105 == null) goto L12;
                com.bytedance.android.shopping.api.image.q r106 = r105;
            L14:
                return new c(r100, r101, r102, r110, r106);
            L12:
                r106 = r111;
                goto L14
            L5:
                r103 = r111;
                goto L6
            }
        }

        static {
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final int a() {
            return this.f44786f.a();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final com.bytedance.android.shopping.api.image.n b() {
            return this.f44786f.b();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String c() {
            return this.f44786f.c();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final com.bytedance.android.shopping.api.image.n d() {
            return this.f44786f.d();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final int e() {
            return this.f44786f.e();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final boolean f(String r100, String r101) {
            return this.f44786f.f(r100, r101);
        }

        @Override // com.bytedance.android.shopping.api.image.q
        public final String g() {
            return this.f44786f.g();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getDomain() {
            return this.f44786f.getDomain();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getFlag() {
            return this.f44786f.getFlag();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getFormat() {
            return this.f44786f.getFormat();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getImageUri() {
            return this.f44786f.getImageUri();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getOriginUrl() {
            return this.f44786f.getOriginUrl();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final com.bytedance.android.shopping.api.image.n getQuality() {
            return this.f44786f.getQuality();
        }

        @Override // com.bytedance.android.shopping.api.image.r
        public final com.bytedance.android.shopping.api.image.u getQuery() {
            return this.f44786f.getQuery();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String getServiceId() {
            return this.f44786f.getServiceId();
        }

        @Override // com.bytedance.android.shopping.api.image.r
        public final Pair<Integer, Integer> h() {
            return this.f44786f.h();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final String i() {
            return this.f44786f.i();
        }

        @Override // com.bytedance.android.shopping.api.image.r
        public final boolean isHierarchical() {
            return this.f44786f.isHierarchical();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final boolean j() {
            return this.f44786f.j();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final Integer k() {
            return this.f44786f.k();
        }

        @Override // com.bytedance.android.shopping.api.image.s
        public final String l() {
            return this.f44786f.l();
        }

        @Override // com.bytedance.android.shopping.api.image.o
        public final boolean m() {
            return this.f44786f.m();
        }

        @Override // com.bytedance.android.shopping.api.image.r
        public final com.bytedance.android.shopping.api.image.t n() {
            return this.f44786f.n();
        }

        public final void o() {
            ECImageMultiSizeReuseOpt r100 = ECImageMultiSizeReuseOpt.f44769e;
            r100.getClass();
            String r101 = getImageUri();
            if (r101 == null) goto L8;
            InnerLruCache r102 = r100.h();
            if (r102 == null) goto L9;
            r102.removeCache(r101, this);
            Unit r103 = Unit.INSTANCE;
            return;
        L9:
            return;
        }

        public c(String r100, int r101, int r102, CacheKey r103, com.bytedance.android.shopping.api.image.q r104) {
            this.f44782b = r100;
            this.f44783c = r101;
            this.f44784d = r102;
            this.f44785e = r103;
            this.f44786f = r104;
        }
    }

    static {
        f44765a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECImageMultiSizeReuseOpt.class, "config", "getConfig()Lcom/bytedance/android/shopping/api/image/ECImageMultiReuseModel;", 0))};
        f44769e = new ECImageMultiSizeReuseOpt();
        f44766b = LazyKt.lazy(ECImageMultiSizeReuseOpt$innerRequestCache$2.INSTANCE);
        f44767c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ECImageMultiSizeReuseOpt$enable$2.INSTANCE);
        com.bytedance.android.shopping.api.image.b r100 = new com.bytedance.android.shopping.api.image.b(null);
        ECImageMultiSizeReuseOpt$config$2 r101 = ECImageMultiSizeReuseOpt$config$2.INSTANCE;
        ImageXSettingKt$lazyImageXSettingsOrNull$4 r102 = new ImageXSettingKt$lazyImageXSettingsOrNull$4(null);
        if (z.b() == false) goto L5;
        ReadOnlyProperty r103 = new a(r100, r101, r102);
    L6:
        f44768d = r103;
        return;
    L5:
        r103 = com.bytedance.android.ec.core.opt.ab.h.b("ec_image_multi_size_reuse_config", r100, null, r101, r102);
        goto L6
    }

    public ECImageMultiSizeReuseOpt() {
    }

    public static boolean g() {
        return ((Boolean) f44767c.getValue()).booleanValue();
    }

    public final com.bytedance.android.shopping.api.image.b f() {
        return (com.bytedance.android.shopping.api.image.b) f44768d.getValue(this, f44765a[0]);
    }

    public final InnerLruCache h() {
        if (f() != null) goto L7;
        return null;
    L7:
        return (InnerLruCache) f44766b.getValue();
    }

    public final boolean j() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r100 = f();
        if (r100 == null) goto L7;
        Boolean r101 = r100.h();
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final boolean k() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r100 = f();
        if (r100 == null) goto L7;
        Boolean r101 = r100.i();
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final boolean l() {
        if (g() == false) goto L11;
        com.bytedance.android.shopping.api.image.b r100 = f();
        if (r100 == null) goto L7;
        Boolean r101 = r100.j();
    L9:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public static b c(CacheKey r100) {
        if (r100 == null) goto L4;
        f44769e.getClass();
        return ((InnerLruCache) f44766b.getValue()).getBitmapCache(r100);
    L4:
        return null;
    }

    public static void n(final com.bytedance.android.ec.core.imagex.u r100, final ImageRequest r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        Executor r102 = AsyncWorker.f44549a;
        com.bytedance.android.ec.core.imagex.common.g.a(false, false, new ECImageMultiSizeReuseOpt$recordPreloadCache$1(r100, r101), 3);
        return;
    L8:
        return;
    }

    public final Pair<CacheType, c> e(com.bytedance.android.ec.core.imagex.r r110, com.bytedance.android.shopping.api.image.q r111) {
        Intrinsics.checkNotNullParameter(r110, "callerContext");
        Intrinsics.checkNotNullParameter(r111, "imageXUrlParams");
        com.bytedance.android.shopping.api.image.b r100 = f();
        Pair<CacheType, c> r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (k() == false) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L169;
        if (com.bytedance.android.ec.core.imagex.common.l.b(r100, r110, r111) == false) goto L169;
        String r103 = r111.i();
        if (r103 == null) goto L167;
        Map<String, com.bytedance.android.shopping.api.image.o0> r104 = r100.k();
        if (r104 == null) goto L21;
        com.bytedance.android.shopping.api.image.o0 r105 = r104.get(r103);
    L22:
        if (r105 == null) goto L167;
        String r106 = r111.getImageUri();
        if (r106 == null) goto L29;
        InnerLruCache r107 = f44769e.h();
        if (r107 == null) goto L29;
        List<c> r108 = r107.get(r106);
    L30:
        boolean r109 = r111.m();
        if (k() == false) goto L43;
        int r112 = t.f44897a;
        Intrinsics.checkNotNullParameter(r100, "$this$ignoreCheckReuseOpt");
        if (r110 == null) goto L39;
        String r113 = r110.f44943f;
        if (r113 == null) goto L39;
        HashSet<String> r114 = r100.b();
        if (r114 == null) goto L39;
        Boolean r115 = Boolean.valueOf(r114.contains(r113));
    L41:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == true) goto L43;
        boolean r116 = true;
    L45:
        if (l() == false) goto L57;
        int r117 = t.f44897a;
        Intrinsics.checkNotNullParameter(r100, "$this$ignoreCheckThumbOpt");
        if (r110 == null) goto L53;
        String r118 = r110.f44943f;
        if (r118 == null) goto L53;
        HashSet<String> r119 = r100.d();
        if (r119 == null) goto L53;
        Boolean r120 = Boolean.valueOf(r119.contains(r118));
    L55:
        if (Intrinsics.areEqual(r120, Boolean.TRUE) == true) goto L57;
        boolean r121 = true;
    L58:
        List<c> r122 = r108;
        if (r122 != null) goto L61;
    L64:
        boolean r123 = true;
    L65:
        if (r123 == true) goto L164;
        if (r116 == true) goto L68;
        if (r121 == true) goto L68;
        return null;
    L68:
        int r124 = r108.size() - 1;
        c r125 = null;
        c r126 = null;
    L69:
        if (r124 < 0) goto L158;
        c r127 = (c) CollectionsKt.getOrNull(r108, r124);
        if (r127 == null) goto L157;
        if (Intrinsics.areEqual(r127.g(), r111.g()) == true) goto L75;
        if (r127.f44783c == 0) goto L157;
        if (r127.f44784d == 0) goto L157;
        if (r116 == true) goto L83;
        if (r121 == false) goto L157;
    L83:
        String r128 = r127.getFormat();
        String r129 = r111.getFormat();
        if (Intrinsics.areEqual(r128, "image") == false) goto L89;
        if (Intrinsics.areEqual(r129, "image") == false) goto L89;
    L128:
        boolean r130 = true;
    L130:
        if (r130 == false) goto L157;
        boolean r131 = r127.m();
        if (r116 == false) goto L142;
        if (r125 != null) goto L142;
        if (r131 == true) goto L141;
        if (r109 == true) goto L142;
        if (Intrinsics.areEqual(r127.i(), r111.i()) == false) goto L142;
        if (b(r127, r111, true) == false) goto L142;
    L141:
        r125 = r127;
    L142:
        if (r121 == false) goto L157;
        if (r125 != null) goto L157;
        if (Intrinsics.areEqual(r127.i(), r111.i()) == true) goto L153;
        HashSet<String> r132 = r105.a();
        if (r132 == null) goto L157;
        if (CollectionsKt.contains(r132, r127.i()) != true) goto L157;
    L153:
        if (r126 != null) goto L155;
    L156:
        r126 = r127;
        goto L157
    L155:
        if (b(r127, r126, false) == false) goto L157;
    L89:
        if (Intrinsics.areEqual(r128, "image") == false) goto L91;
    L129:
        r130 = false;
        goto L130
    L91:
        if (Intrinsics.areEqual(r129, "image") == true) goto L129;
        TmplConvConfig r133 = TmplConvConfig.f44993k;
        com.bytedance.android.shopping.api.image.p0 r134 = r133.b();
        if (r134 == null) goto L100;
        HashSet<String> r135 = r134.d();
        if (r135 == null) goto L100;
        if (CollectionsKt.contains(r135, r128) != true) goto L100;
        boolean r136 = true;
    L101:
        com.bytedance.android.shopping.api.image.p0 r137 = r133.b();
        if (r137 == null) goto L108;
        HashSet<String> r138 = r137.d();
        if (r138 == null) goto L108;
        if (CollectionsKt.contains(r138, r129) != true) goto L108;
        boolean r139 = true;
    L109:
        if (r136 != r139) goto L129;
        com.bytedance.android.shopping.api.image.p0 r140 = r133.b();
        if (r140 == null) goto L118;
        HashSet<String> r141 = r140.a();
        if (r141 == null) goto L118;
        if (CollectionsKt.contains(r141, r128) != true) goto L118;
        boolean r142 = true;
    L119:
        com.bytedance.android.shopping.api.image.p0 r143 = r133.b();
        if (r143 == null) goto L126;
        HashSet<String> r144 = r143.a();
        if (r144 == null) goto L126;
        if (CollectionsKt.contains(r144, r129) != true) goto L126;
        boolean r145 = true;
    L127:
        if (r142 != r145) goto L129;
    L126:
        r145 = false;
    L118:
        r142 = false;
    L108:
        r139 = false;
    L100:
        r136 = false;
        goto L101
    L75:
        return r101;
    L157:
        r124 = r124 - 1;
        r101 = null;
        goto L69
    L158:
        if (r125 != null) goto L160;
        if (r126 != null) goto L163;
        return null;
    L163:
        return new Pair(CacheType.REUSE_THUMB_CACHE, r126);
    L160:
        return new Pair(CacheType.REUSE_CACHE, r125);
    L164:
        return null;
    L61:
        if (r122.isEmpty() == true) goto L64;
        r123 = false;
    L53:
        r120 = null;
    L57:
        r121 = false;
    L39:
        r115 = null;
    L43:
        r116 = false;
    L29:
        r108 = null;
        goto L30
    L21:
        r105 = null;
    L167:
        return null;
    L169:
        return null;
    L8:
        if (l() == true) goto L11;
        r102 = false;
        goto L12
    }

    public static final CacheKey a(ECImageMultiSizeReuseOpt r100, ImageRequest r101, Object r102) {
        r100.getClass();
        CacheKeyFactory r103 = Fresco.getImagePipelineFactory().getImagePipeline().getCacheKeyFactory();
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r101.getPostprocessor() == null) goto L11;
        return r103.getPostprocessedBitmapCacheKey(r101, r102);
    L11:
        return r103.getBitmapCacheKey(r101, r102);
    }

    public static boolean b(c r100, com.bytedance.android.shopping.api.image.q r101, boolean r102) {
        int r103 = r100.f44783c;
        int r104 = r100.f44784d;
        Pair r105 = i(r100, r103, r104);
        int r106 = ((Number) r105.component1()).intValue();
        int r107 = ((Number) r105.component2()).intValue();
        Pair r108 = i(r101, r103, r104);
        int r109 = ((Number) r108.component1()).intValue();
        int r110 = ((Number) r108.component2()).intValue();
        byte r111 = -1;
        if (r109 != 0) goto L8;
        if (r110 != 0) goto L8;
        if (r106 != 0) goto L17;
        if (r107 != 0) goto L17;
    L15:
        byte r112 = 0;
    L18:
        Integer r113 = r100.getQuality().getValue();
        int r114 = 100;
        Integer r115 = null;
        if (r113 == null) goto L25;
        int r116 = r113.intValue();
        if (r116 > 0) goto L24;
        r116 = 100;
    L24:
        Integer r117 = Integer.valueOf(r116);
    L26:
        Integer r118 = r101.getQuality().getValue();
        if (r118 == null) goto L32;
        int r119 = r118.intValue();
        if (r119 <= 0) goto L31;
        r114 = r119;
    L31:
        r115 = Integer.valueOf(r114);
    L32:
        if (r117 == null) goto L40;
        if (r115 == null) goto L40;
        if (r117.intValue() <= r115.intValue()) goto L38;
        r111 = 1;
        goto L40
    L38:
        if (Intrinsics.areEqual(r117, r115) == false) goto L40;
        r111 = 0;
    L40:
        if (r102 == false) goto L44;
        if (r112 < 0) goto L44;
        if (r111 < 0) goto L44;
        return true;
    L44:
        if (r102 == true) goto L49;
        if (r112 > 0) goto L48;
        if (r112 != 0) goto L49;
        if (r111 < 0) goto L49;
    L48:
        return true;
    L49:
        return false;
    L25:
        r117 = null;
    L17:
        r112 = -1;
    L8:
        if (r106 != 0) goto L11;
        if (r107 != 0) goto L11;
    L16:
        r112 = 1;
    L11:
        if (r106 <= 0) goto L17;
        if (r109 <= 0) goto L17;
        if (r106 < r109) goto L17;
        if (r106 != r109) goto L16;
        goto L15
    }

    public static b d(ImageRequest r100, com.bytedance.android.ec.core.imagex.r r101, boolean r102) {
        if (r100 == null) goto L4;
        f44769e.getClass();
        return ((InnerLruCache) f44766b.getValue()).getBitmapCache(r100, r101, r102);
    L4:
        return null;
    }

    public static Pair i(com.bytedance.android.shopping.api.image.q r100, int r101, int r102) {
        Integer r103 = r100.d().getValue();
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.intValue();
    L6:
        Integer r106 = r100.b().getValue();
        if (r106 == null) goto L9;
        r104 = r106.intValue();
    L9:
        if (r105 <= 0) goto L15;
        if (r104 <= 0) goto L15;
        int r107 = (r104 * r101) / r102;
        int r108 = (r102 * r105) / r101;
        if (r107 > r105) goto L22;
        return new Pair(Integer.valueOf(r107), Integer.valueOf(r104));
    L22:
        return new Pair(Integer.valueOf(r105), Integer.valueOf(r108));
    L15:
        if (r105 > 0) goto L23;
        if (r104 <= 0) goto L20;
        return new Pair(Integer.valueOf((r101 * r104) / r102), Integer.valueOf(r104));
    L20:
        return new Pair(Integer.valueOf(r105), Integer.valueOf(r104));
    L23:
        return new Pair(Integer.valueOf(r105), Integer.valueOf((r102 * r105) / r101));
    L5:
        r105 = 0;
        goto L6
    }

    public final void m(final com.bytedance.android.ec.core.imagex.u r110, final ImageRequest r111, ImageInfo r112) {
        Intrinsics.checkNotNullParameter(r110, "imageCallerContext");
        Intrinsics.checkNotNullParameter(r111, "imageRequest");
        Intrinsics.checkNotNullParameter(r112, "image");
        final String r100 = r111.getSourceUri().toString();
        Map<String, String> r101 = r111.getCustomParam();
        if (r101 == null) goto L5;
        String r102 = r101.get("ec_use_multi_image_size_cache");
    L7:
        if (Intrinsics.areEqual(r102, "1") == false) goto L9;
        com.bytedance.android.shopping.api.image.q r103 = r110.A;
    L10:
        final com.bytedance.android.shopping.api.image.q r104 = r103;
        if (r104 == null) goto L23;
        final int r105 = r112.getWidth();
        final int r106 = r112.getHeight();
        if (j() == true) goto L15;
    L20:
        final WeakReference r107 = null;
    L21:
        Executor r113 = AsyncWorker.f44549a;
        com.bytedance.android.ec.core.imagex.common.g.a(false, false, new ECImageMultiSizeReuseOpt$recordCache$1(r105, r106, r104, r111, r110, r100, r107), 3);
        return;
    L15:
        if ((r112 instanceof CloseableStaticBitmap) == true) goto L17;
        r112 = null;
    L17:
        CloseableStaticBitmap r114 = (CloseableStaticBitmap) r112;
        if (r114 == null) goto L20;
        r107 = new WeakReference(r114);
        goto L21
    L23:
        return;
    L9:
        r103 = r110.n();
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
