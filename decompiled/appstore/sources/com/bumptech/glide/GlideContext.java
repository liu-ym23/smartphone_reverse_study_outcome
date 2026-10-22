package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GlideContext extends ContextWrapper {

    @VisibleForTesting
    static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS = null;
    private final ArrayPool arrayPool;
    private final List<RequestListener<Object>> defaultRequestListeners;
    private final RequestOptions defaultRequestOptions;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory;
    private final boolean isLoggingRequestOriginsEnabled;
    private final int logLevel;
    private final Registry registry;

    static {
        DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    }

    public GlideContext(@NonNull Context r10, @NonNull ArrayPool r11, @NonNull Registry r12, @NonNull ImageViewTargetFactory r13, @NonNull RequestOptions r14, @NonNull Map<Class<?>, TransitionOptions<?, ?>> r15, @NonNull List<RequestListener<Object>> r16, @NonNull Engine r17, boolean r18, int r19) {
        super(r10.getApplicationContext());
        this.arrayPool = r11;
        this.registry = r12;
        this.imageViewTargetFactory = r13;
        this.defaultRequestOptions = r14;
        this.defaultRequestListeners = r16;
        this.defaultTransitionOptions = r15;
        this.engine = r17;
        this.isLoggingRequestOriginsEnabled = r18;
        this.logLevel = r19;
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> buildImageViewTarget(@NonNull ImageView r10, @NonNull Class<X> r11) {
        return this.imageViewTargetFactory.buildTarget(r10, r11);
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public RequestOptions getDefaultRequestOptions() {
        return this.defaultRequestOptions;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(@NonNull Class<T> r10) {
        TransitionOptions<?, T> r11 = (TransitionOptions) this.defaultTransitionOptions.get(r10);
        if (r11 != null) goto L10;
        Iterator<Map.Entry<Class<?>, TransitionOptions<?, ?>>> r12 = this.defaultTransitionOptions.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        Map.Entry<Class<?>, TransitionOptions<?, ?>> r13 = r12.next();
        if (r13.getKey().isAssignableFrom(r10) == false) goto L6;
        r11 = (TransitionOptions) r13.getValue();
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        return (TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS;
    }

    @NonNull
    public Engine getEngine() {
        return this.engine;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    public boolean isLoggingRequestOriginsEnabled() {
        return this.isLoggingRequestOriginsEnabled;
    }
}
