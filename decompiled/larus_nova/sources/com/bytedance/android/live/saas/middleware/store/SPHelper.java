package com.bytedance.android.live.saas.middleware.store;

import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0001H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010\"\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010#\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/SPHelper;", "Lcom/bytedance/android/live/saas/middleware/store/IMiddlewareSharedPref;", "tableName", "", "(Ljava/lang/String;)V", "mSp", "Lcom/bytedance/ies/utility/SharedPrefHelper;", "getMSp", "()Lcom/bytedance/ies/utility/SharedPrefHelper;", "mSp$delegate", "Lkotlin/Lazy;", "clear", "contains", "", "key", "end", "", "getAll", "", "getBoolean", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "", "put", "any", "", "putEnd", "remove", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SPHelper implements IMiddlewareSharedPref {
    public static final Companion Companion = null;
    private static final Lazy defaultSpHelper$delegate = null;
    private final Lazy mSp$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/SPHelper$Companion;", "", "()V", "defaultSpHelper", "Lcom/bytedance/android/live/saas/middleware/store/SPHelper;", "getDefaultSpHelper", "()Lcom/bytedance/android/live/saas/middleware/store/SPHelper;", "defaultSpHelper$delegate", "Lkotlin/Lazy;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final SPHelper getDefaultSpHelper() {
            return (SPHelper) SPHelper.access$getDefaultSpHelper$cp().getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SPHelper() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final SharedPrefHelper getMSp() {
        return (SharedPrefHelper) this.mSp$delegate.getValue();
    }

    static {
        Companion = new Companion(null);
        defaultSpHelper$delegate = LazyKt.lazy(SPHelper$Companion$defaultSpHelper$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public IMiddlewareSharedPref clear() {
        SharedPrefHelper r100 = getMSp();
        if (r100.f249253b != null) goto L5;
        r100.f249253b = r100.f249252a.edit();
    L5:
        r100.f249253b.clear();
        r100.a();
        return this;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public void end() {
        getMSp().a();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public Map<String, ?> getAll() {
        return getMSp().e();
    }

    public static final /* synthetic */ Lazy access$getDefaultSpHelper$cp() {
        return defaultSpHelper$delegate;
    }

    public SPHelper(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "tableName");
        this.mSp$delegate = LazyKt.lazy(new SPHelper$mSp$2(r100));
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public boolean contains(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return getMSp().f249252a.contains(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public IMiddlewareSharedPref remove(String r100) {
        if (r100 == null) goto L7;
        SharedPrefHelper r101 = getMSp();
        if (r101.f249253b != null) goto L6;
        r101.f249253b = r101.f249252a.edit();
    L6:
        r101.f249253b.remove(r100);
    L7:
        return this;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public boolean getBoolean(String r100, boolean r101) {
        return getMSp().f(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public float getFloat(String r100, float r101) {
        return getMSp().g(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public int getInt(String r100, int r101) {
        return getMSp().h(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public long getLong(String r100, long r101) {
        return getMSp().i(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return getMSp().j(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public Set<String> getStringSet(String r100, Set<String> r101) {
        Set<String> r102 = getMSp().k(r100, r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return new LinkedHashSet();
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public IMiddlewareSharedPref put(String r100, Object r101) {
        if (r100 == null) goto L5;
        if (r101 == null) goto L5;
        getMSp().l(r100, r101);
    L5:
        return this;
    }

    @Override // com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref
    public void putEnd(String r100, Object r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        getMSp().m(r100, r101);
        return;
    L7:
        return;
    }

    public /* synthetic */ SPHelper(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
