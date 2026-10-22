package com.bytedance.ai.lynx;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry;", "", "<init>", "()V", "TAG", "", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/lynx/AISDKLynxBehaviorRegistry$Provider;", "taggedBehaviors", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/lynx/tasm/behavior/Behavior;", "registerProvider", "", ShortVideoSegments.KEY_PROP_PROVIDER, "registerBehavior", "tag", "behavior", "tryRegisterBehavior", "", "unregisterBehavior", "unregisterProvider", "addBehaviors", "behaviors", "", "addBehavior", "getExtraBehaviors", "Provider", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AISDKLynxBehaviorRegistry {
    public static final AISDKLynxBehaviorRegistry INSTANCE = null;
    private static final String TAG = "AISDKLynxBehaviorRegistry";
    private static final CopyOnWriteArrayList<a> providers = null;
    private static final ConcurrentHashMap<String, com.lynx.tasm.behavior.a> taggedBehaviors = null;

    public interface a {
        List<com.lynx.tasm.behavior.a> a();
    }

    private AISDKLynxBehaviorRegistry() {
    }

    public static /* synthetic */ List a(List r100) {
        return addBehaviors$lambda$0(r100);
    }

    private static final List addBehaviors$lambda$0(List r100) {
        return r100;
    }

    static {
        INSTANCE = new AISDKLynxBehaviorRegistry();
        providers = new CopyOnWriteArrayList();
        taggedBehaviors = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final List<com.lynx.tasm.behavior.a> getExtraBehaviors() {
        CopyOnWriteArrayList<a> r100 = providers;
        if (r100.isEmpty() == true) goto L5;
    L8:
        ConcurrentHashMap<String, com.lynx.tasm.behavior.a> r101 = taggedBehaviors;
        ArrayList r102 = new ArrayList(r101.size() + 8);
        r102.addAll(r101.values());
        Iterator<T> r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        a r104 = (a) r103.next();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        Object r106 = Result.m9449constructorimpl(r104.a());     // Catch: Throwable -> L14
    L16:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        com.bytedance.ai.utils.g.f37637a.e(TAG, "provider.getBehaviors failed: " + r104, r107);
        r106 = CollectionsKt.emptyList();
    L20:
        r102.addAll((List) r106);
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L21:
        return r102;
    L5:
        if (taggedBehaviors.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final a addBehavior(com.lynx.tasm.behavior.a r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        return addBehaviors(CollectionsKt.listOf(r100));
    }

    @JvmStatic
    public static final a addBehaviors(final List<? extends com.lynx.tasm.behavior.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "behaviors");
        a r101 = new com.bytedance.ai.lynx.a(r100);
        registerProvider(r101);
        return r101;
    }

    @JvmStatic
    public static final void registerProvider(a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        CopyOnWriteArrayList<a> r101 = providers;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @JvmStatic
    public static final void unregisterBehavior(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        taggedBehaviors.remove(r100);
    }

    @JvmStatic
    public static final void unregisterProvider(a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        providers.remove(r100);
    }

    @JvmStatic
    public static final void registerBehavior(String r100, com.lynx.tasm.behavior.a r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        taggedBehaviors.put(r100, r101);
    }

    @JvmStatic
    public static final boolean tryRegisterBehavior(String r100, com.lynx.tasm.behavior.a r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        if (taggedBehaviors.putIfAbsent(r100, r101) != null) goto L5;
        return true;
    L5:
        return false;
    }
}
