package com.bytedance.retrofit2;

import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Retrofit {

    @Nullable
    private static volatile CopyOnWriteArrayList<Interceptor> sCommonInterceptors;

    @Nullable
    private final ICacheServer cacheServer;
    private final List<CallAdapter.Factory> callAdapterFactories;
    private final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    private final List<Converter.Factory> converterFactories;
    private final Executor httpExecutor;
    private final List<Interceptor> interceptors;
    private final Endpoint server;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache;
    private final ConcurrentHashMap<Method, Object> serviceMethodCacheNew;
    private final boolean validateEagerly;

    public static final class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Nullable
        private ICacheServer cacheServer;
        private final List<CallAdapter.Factory> callAdapterFactories;

        @Nullable
        private Executor callbackExecutor;

        @Nullable
        private Client.Provider clientProvider;
        private final List<Converter.Factory> converterFactories;

        @Nullable
        private Endpoint endpoint;

        @Nullable
        private Executor httpExecutor;
        private final List<Interceptor> interceptors;
        private final Platform platform;
        private boolean validateEagerly;

        static {
        }

        Builder(Platform r2) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = r2;
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Retrofit r5) {
            this.interceptors = new CopyOnWriteArrayList();
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = Platform.get();
            this.clientProvider = Retrofit.access$000(r5);
            this.endpoint = Retrofit.access$100(r5);
            int r0 = 1;
            int r1 = 1;
        L4:
            if (r1 >= (Retrofit.access$200(r5).size() - this.platform.defaultConverterFactoriesSize())) goto L6;
            this.interceptors.add((Interceptor) Retrofit.access$200(r5).get(r1));
            r1 = r1 + 1;
            goto L4
        L6:
            int r2 = Retrofit.access$300(r5).size() - this.platform.defaultConverterFactoriesSize();
        L7:
            if (r0 >= r2) goto L9;
            this.converterFactories.add((Converter.Factory) Retrofit.access$300(r5).get(r0));
            r0 = r0 + 1;
            goto L7
        L9:
            int r3 = Retrofit.access$400(r5).size() - this.platform.defaultCallAdapterFactoriesSize();
            int r4 = 0;
        L10:
            if (r4 >= r3) goto L12;
            this.callAdapterFactories.add((CallAdapter.Factory) Retrofit.access$400(r5).get(r4));
            r4 = r4 + 1;
            goto L10
        L12:
            this.httpExecutor = Retrofit.access$500(r5);
            this.callbackExecutor = Retrofit.access$600(r5);
            this.validateEagerly = Retrofit.access$700(r5);
            this.cacheServer = Retrofit.access$800(r5);
        }

        public Builder client(Client.Provider r2) {
            return provider((Client.Provider) Utils.checkNotNull(r2, "provider == null"));
        }

        public Builder provider(Client.Provider r2) {
            this.clientProvider = (Client.Provider) Utils.checkNotNull(r2, "provider == null");
            return this;
        }

        public Builder addInterceptor(Interceptor r2) {
            Interceptor r3 = (Interceptor) Utils.checkNotNull(r2, "interceptor == null");
            this.interceptors.add(r3);
            return this;
        }

        public Builder removeInterceptor(Interceptor r2) {
            Interceptor r3 = (Interceptor) Utils.checkNotNull(r2, "interceptor == null");
            this.interceptors.remove(r3);
            return this;
        }

        public Builder setEndpoint(String r2) {
            if (r2 == null) goto L8;
            if (r2.trim().length() == 0) goto L8;
            this.endpoint = Endpoints.newFixedEndpoint(r2);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }

        public Builder setEndpoint(Endpoint r1) {
            if (r1 == null) goto L6;
            this.endpoint = r1;
            return this;
        L6:
            throw new NullPointerException("Endpoint may not be null.");
        }

        public Builder addConverterFactory(Converter.Factory r3) {
            this.converterFactories.add((Converter.Factory) Utils.checkNotNull(r3, "factory == null"));
            return this;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r3) {
            this.callAdapterFactories.add((CallAdapter.Factory) Utils.checkNotNull(r3, "factory == null"));
            return this;
        }

        public Builder callbackExecutor(Executor r2) {
            this.callbackExecutor = (Executor) Utils.checkNotNull(r2, "executor == null");
            return this;
        }

        public Builder httpExecutor(Executor r2) {
            this.httpExecutor = (Executor) Utils.checkNotNull(r2, "httpExecutor == null");
            return this;
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean r1) {
            this.validateEagerly = r1;
            return this;
        }

        public Builder cacheServer(ICacheServer r1) {
            this.cacheServer = r1;
            return this;
        }

        public Retrofit build() {
            if (this.endpoint == null) goto L26;
            if (this.clientProvider == null) goto L24;
            if (this.httpExecutor == null) goto L22;
            Executor r0 = this.callbackExecutor;
            if (r0 != null) goto L11;
            r0 = this.platform.defaultCallbackExecutor();
        L11:
            Executor r8 = r0;
            ArrayList r6 = new ArrayList(this.callAdapterFactories);
            r6.addAll(this.platform.defaultCallAdapterFactories(r8));
            ArrayList r5 = new ArrayList((this.converterFactories.size() + 1) + this.platform.defaultConverterFactoriesSize());
            r5.add(new BuiltInConverters());
            r5.addAll(this.converterFactories);
            r5.addAll(this.platform.defaultConverterFactories());
            if (Retrofit.access$900() == null) goto L20;
            Iterator r1 = Retrofit.access$900().iterator();
        L15:
            if (r1.hasNext() == false) goto L20;
            Interceptor r2 = (Interceptor) r1.next();
            if (this.interceptors.contains(r2) == true) goto L15;
            this.interceptors.add(r2);
        L20:
            return new Retrofit(this.endpoint, this.clientProvider, this.interceptors, r5, r6, this.httpExecutor, r8, this.validateEagerly, this.cacheServer);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }
    }

    static /* synthetic */ Client.Provider access$000(Retrofit r0) {
        return r0.clientProvider;
    }

    static /* synthetic */ Endpoint access$100(Retrofit r0) {
        return r0.server;
    }

    static /* synthetic */ List access$200(Retrofit r0) {
        return r0.interceptors;
    }

    static /* synthetic */ List access$300(Retrofit r0) {
        return r0.converterFactories;
    }

    static /* synthetic */ List access$400(Retrofit r0) {
        return r0.callAdapterFactories;
    }

    static /* synthetic */ Executor access$500(Retrofit r0) {
        return r0.httpExecutor;
    }

    static /* synthetic */ Executor access$600(Retrofit r0) {
        return r0.callbackExecutor;
    }

    static /* synthetic */ boolean access$700(Retrofit r0) {
        return r0.validateEagerly;
    }

    static /* synthetic */ ICacheServer access$800(Retrofit r0) {
        return r0.cacheServer;
    }

    static /* synthetic */ CopyOnWriteArrayList access$900() {
        return sCommonInterceptors;
    }

    Retrofit(Endpoint r11, Client.Provider r12, List<Interceptor> r13, List<Converter.Factory> r14, List<CallAdapter.Factory> r15, Executor r16, Executor r17, boolean r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    Retrofit(Endpoint r2, Client.Provider r3, List<Interceptor> r4, List<Converter.Factory> r5, List<CallAdapter.Factory> r6, Executor r7, Executor r8, boolean r9, @Nullable ICacheServer r10) {
        this.serviceMethodCache = new ConcurrentHashMap();
        this.serviceMethodCacheNew = new ConcurrentHashMap();
        this.server = r2;
        this.clientProvider = r3;
        this.interceptors = r4;
        this.converterFactories = Collections.unmodifiableList(r5);
        this.callAdapterFactories = Collections.unmodifiableList(r6);
        this.httpExecutor = r7;
        this.callbackExecutor = r8;
        this.validateEagerly = r9;
        this.cacheServer = r10;
    }

    public static void setCommonInterceptor(CopyOnWriteArrayList<Interceptor> r0) {
        sCommonInterceptors = r0;
    }

    public <T> T create(final Class<T> r4) {
        Utils.validateServiceInterface(r4);
        if (this.validateEagerly == false) goto L6;
        eagerlyValidateMethods(r4);
    L6:
        return (T) Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new AnonymousClass1(this, r4));
    }

    private void eagerlyValidateMethods(Class<?> r6) {
        Platform r0 = Platform.get();
        Method[] r7 = r6.getDeclaredMethods();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Method r3 = r7[r2];
        if (r0.isDefaultMethod(r3) == true) goto L9;
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L9;
        loadServiceMethod(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    }

    ServiceMethod<?> loadServiceMethod(Method r4) {
        if (RetrofitConfig.isLoadServiceMethodOptOpen() == true) goto L5;
        ServiceMethod<?> r0 = this.serviceMethodCache.get(r4);
        if (r0 != null) goto L9;
        Map<Method, ServiceMethod<?>> r1 = this.serviceMethodCache;
        monitor-enter(r1);
        ServiceMethod<?> r2 = this.serviceMethodCache.get(r4);     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        r2 = ServiceMethod.parseAnnotations(this, r4, new RetrofitMetrics(false));     // Catch: Throwable -> L19
        this.serviceMethodCache.put(r4, r2);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L19:
        th = move-exception;
        throw th;
    L9:
        if ((r0 instanceof HttpServiceMethod) == false) goto L11;
        ((HttpServiceMethod) r0).requestFactory.setRetrofitMetrics(new RetrofitMetrics(true));
    L11:
        return r0;
    L5:
        return loadServiceMethodNew(r4);
    }

    ServiceMethod<?> loadServiceMethodNew(Method r4) {
        Object r0 = this.serviceMethodCacheNew.get(r4);
        if ((r0 instanceof ServiceMethod) == true) goto L5;
        if (r0 != null) goto L22;
        Object r1 = new Object();
        monitor-enter(r1);
        r0 = this.serviceMethodCacheNew.putIfAbsent(r4, r1);     // Catch: Throwable -> L19
        if (r0 != null) goto L17;
        ServiceMethod<?> r2 = ServiceMethod.parseAnnotations(this, r4, new RetrofitMetrics(false));     // Catch: Throwable -> L19
        this.serviceMethodCacheNew.put(r4, r2);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r0);
        ServiceMethod<?> r3 = (ServiceMethod) this.serviceMethodCacheNew.get(r4);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r3;
    L26:
        th = move-exception;
        throw th;
    L5:
        if ((r0 instanceof HttpServiceMethod) == false) goto L8;
        ((HttpServiceMethod) r0).requestFactory.setRetrofitMetrics(new RetrofitMetrics(true));
    L8:
        return (ServiceMethod) r0;
    }

    public Client.Provider clientProvider() {
        return this.clientProvider;
    }

    public Executor httpExecutor() {
        return this.httpExecutor;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @Nullable
    public ICacheServer cacheServer() {
        return this.cacheServer;
    }

    public Endpoint server() {
        return this.server;
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public CallAdapter<?, ?> callAdapter(Type r2, Annotation[] r3) {
        return nextCallAdapter(null, r2, r3);
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory r5, Type r6, Annotation[] r7) {
        Utils.checkNotNull(r6, "returnType == null");
        Utils.checkNotNull(r7, "annotations == null");
        int r0 = this.callAdapterFactories.indexOf(r5) + 1;
        int r1 = this.callAdapterFactories.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        CallAdapter<?, ?> r3 = this.callAdapterFactories.get(r2).get(r6, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r8 = new StringBuilder("Could not locate call adapter for ").append(r6).append(".\n");
        if (r5 == null) goto L14;
        r8.append("  Skipped:");
        int r9 = 0;
    L11:
        if (r9 >= r0) goto L13;
        r8.append("\n   * ").append(this.callAdapterFactories.get(r9).getClass().getName());
        r9 = r9 + 1;
        goto L11
    L13:
        r8.append('\n');
    L14:
        r8.append("  Tried:");
        int r10 = this.callAdapterFactories.size();
    L15:
        if (r0 >= r10) goto L18;
        r8.append("\n   * ").append(this.callAdapterFactories.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r8.toString());
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> Converter<T, TypedOutput> requestBodyConverter(Type r2, Annotation[] r3, Annotation[] r4) {
        return nextRequestBodyConverter(null, r2, r3, r4);
    }

    public <T> Converter<T, TypedOutput> nextRequestBodyConverter(@Nullable Converter.Factory r5, Type r6, Annotation[] r7, Annotation[] r8) {
        Utils.checkNotNull(r6, "type == null");
        Utils.checkNotNull(r7, "parameterAnnotations == null");
        Utils.checkNotNull(r8, "methodAnnotations == null");
        int r0 = this.converterFactories.indexOf(r5) + 1;
        int r1 = this.converterFactories.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        Converter<T, TypedOutput> r3 = (Converter<T, TypedOutput>) this.converterFactories.get(r2).requestBodyConverter(r6, r7, r8, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r9 = new StringBuilder("Could not locate RequestBody converter for ").append(r6).append(".\n");
        if (r5 == null) goto L14;
        r9.append("  Skipped:");
        int r10 = 0;
    L11:
        if (r10 >= r0) goto L13;
        r9.append("\n   * ").append(this.converterFactories.get(r10).getClass().getName());
        r10 = r10 + 1;
        goto L11
    L13:
        r9.append('\n');
    L14:
        r9.append("  Tried:");
        int r11 = this.converterFactories.size();
    L15:
        if (r0 >= r11) goto L18;
        r9.append("\n   * ").append(this.converterFactories.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r9.toString());
    }

    public <T> Converter<TypedInput, T> responseBodyConverter(Type r2, Annotation[] r3) {
        return nextResponseBodyConverter(null, r2, r3);
    }

    public <T> Converter<TypedInput, T> nextResponseBodyConverter(@Nullable Converter.Factory r5, Type r6, Annotation[] r7) {
        Utils.checkNotNull(r6, "type == null");
        Utils.checkNotNull(r7, "annotations == null");
        int r0 = this.converterFactories.indexOf(r5) + 1;
        int r1 = this.converterFactories.size();
        int r2 = r0;
    L3:
        if (r2 >= r1) goto L8;
        Converter<TypedInput, T> r3 = (Converter<TypedInput, T>) this.converterFactories.get(r2).responseBodyConverter(r6, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        StringBuilder r8 = new StringBuilder("Could not locate TypedInput converter for ").append(r6).append(".\n");
        if (r5 == null) goto L14;
        r8.append("  Skipped:");
        int r9 = 0;
    L11:
        if (r9 >= r0) goto L13;
        r8.append("\n   * ").append(this.converterFactories.get(r9).getClass().getName());
        r9 = r9 + 1;
        goto L11
    L13:
        r8.append('\n');
    L14:
        r8.append("  Tried:");
        int r10 = this.converterFactories.size();
    L15:
        if (r0 >= r10) goto L18;
        r8.append("\n   * ").append(this.converterFactories.get(r0).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r8.toString());
    }

    public <T> Converter<T, Object> objectConverter(Type r4, Annotation[] r5) {
        Utils.checkNotNull(r4, "type == null");
        Utils.checkNotNull(r5, "annotations == null");
        int r0 = this.converterFactories.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Converter<T, Object> r2 = (Converter<T, Object>) this.converterFactories.get(r1).objectConverter(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> Converter<T, String> stringConverter(Type r4, Annotation[] r5) {
        Utils.checkNotNull(r4, "type == null");
        Utils.checkNotNull(r5, "annotations == null");
        int r0 = this.converterFactories.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Converter<T, String> r2 = (Converter<T, String>) this.converterFactories.get(r1).stringConverter(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public <T> Converter<T, Header> headerConverter(Type r4, Annotation[] r5) {
        Utils.checkNotNull(r4, "type == null");
        Utils.checkNotNull(r5, "annotations == null");
        int r0 = this.converterFactories.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Converter<T, Header> r2 = (Converter<T, Header>) this.converterFactories.get(r1).headerConverter(r4, r5, this);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }
}
