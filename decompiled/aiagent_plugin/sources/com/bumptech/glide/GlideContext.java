package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.request.target.ViewTarget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlideContext extends ContextWrapper {
    static final h<?, ?> DEFAULT_TRANSITION_OPTIONS = null;
    private final com.bumptech.glide.load.engine.a.b arrayPool;
    private final List<com.bumptech.glide.request.g<Object>> defaultRequestListeners;
    private com.bumptech.glide.request.h defaultRequestOptions;
    private final Glide.a defaultRequestOptionsFactory;
    private final Map<Class<?>, h<?, ?>> defaultTransitionOptions;
    private final k engine;
    private final com.bumptech.glide.request.target.f imageViewTargetFactory;
    private final boolean isLoggingRequestOriginsEnabled;
    private final int logLevel;
    private final f registry;

    static {
        DEFAULT_TRANSITION_OPTIONS = new b();
    }

    public GlideContext(Context r3, com.bumptech.glide.load.engine.a.b r4, f r5, com.bumptech.glide.request.target.f r6, Glide.a r7, Map<Class<?>, h<?, ?>> r8, List<com.bumptech.glide.request.g<Object>> r9, k r10, boolean r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r14 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        Glide.a r15 = (Glide.a) ZeusTransformUtils.wrapperContextForParams(r7, Glide.a.class, "com.obric.aiagent.plugin");
        Map<Class<?>, h<?, ?>> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        List<com.bumptech.glide.request.g<Object>> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.arrayPool = r14;
        this.registry = r5;
        this.imageViewTargetFactory = r6;
        this.defaultRequestOptionsFactory = r15;
        this.defaultRequestListeners = r17;
        this.defaultTransitionOptions = r16;
        this.engine = r10;
        this.isLoggingRequestOriginsEnabled = r11;
        this.logLevel = r12;
    }

    public List<com.bumptech.glide.request.g<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized com.bumptech.glide.request.h getDefaultRequestOptions() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.defaultRequestOptions != null) goto L6;
        this.defaultRequestOptions = (com.bumptech.glide.request.h) ZeusTransformUtils.preCheckCast(this.defaultRequestOptionsFactory.a().i(), com.bumptech.glide.request.h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L6:
        com.bumptech.glide.request.h r0 = this.defaultRequestOptions;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public <T> h<?, T> getDefaultTransitionOptions(Class<T> r6) {
        h<?, T> r0 = (h) ZeusTransformUtils.preCheckCast(this.defaultTransitionOptions.get(r6), h.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, h<?, ?>>> r5 = this.defaultTransitionOptions.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Class) ZeusTransformUtils.preCheckCast(r1.getKey(), Class.class, "com.obric.aiagent.plugin")).isAssignableFrom(r6) == false) goto L6;
        r0 = (h) ZeusTransformUtils.preCheckCast(r1.getValue(), h.class, "com.obric.aiagent.plugin");
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        return (h<?, T>) DEFAULT_TRANSITION_OPTIONS;
    }

    public <X> ViewTarget<ImageView, X> buildImageViewTarget(ImageView r1, Class<X> r2) {
        return this.imageViewTargetFactory.a(r1, r2);
    }

    public k getEngine() {
        return this.engine;
    }

    public f getRegistry() {
        return this.registry;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public com.bumptech.glide.load.engine.a.b getArrayPool() {
        return this.arrayPool;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.isLoggingRequestOriginsEnabled;
    }
}
