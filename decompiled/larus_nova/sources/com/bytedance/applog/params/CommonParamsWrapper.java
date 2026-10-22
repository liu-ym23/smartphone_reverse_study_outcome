package com.bytedance.applog.params;

import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.log.n;
import com.bytedance.applog.params.lifecycle.LifecycleValueObserver;
import com.bytedance.applog.priority.PriorityWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082 J!\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0082 J!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0082 J\u0019\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0082 J)\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0082 J!\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0082 J#\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0082 ¨\u0006\u0017"}, d2 = {"Lcom/bytedance/applog/params/CommonParamsWrapper;", "Lcom/bytedance/applog/params/b;", "Lcom/bytedance/applog/params/c;", "", "istHashCode", "", "nativeInit", "biz", "configJson", "nativeSetRuleConfig", "event", "params", "nativeHandleEvent", "capability", "", "nativeBizSetCacheCapability", "nativeBizClear", "keyValueJsonString", "contextJsonString", "nativeBizSet", "key", "nativeBizRemove", "nativeBizGet", "params_release"}, k = 1, mv = {1, 6, 0})
public final class CommonParamsWrapper implements b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f192553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f192554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, com.bytedance.applog.params.a> f192555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, LifecycleValueObserver>> f192556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f192557f;

    public static final class a extends com.bytedance.applog.log.b<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonParamsWrapper f192558b;

        public a(CommonParamsWrapper r100) {
            this.f192558b = r100;
        }

        @Override // com.bytedance.applog.log.b
        public final Boolean a(Object[] r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            PriorityWrapper.f192577j.b(new Object[0]);
            CommonParamsWrapper r101 = this.f192558b;
            CommonParamsWrapper.c(r101, r101.f192552a);
            return Boolean.TRUE;
        }
    }

    private final native void nativeBizClear(String r100, String r101);

    private final native String nativeBizGet(String r100, String r101, String r102);

    private final native int nativeBizRemove(String r100, String r101, String r102);

    private final native void nativeBizSet(String r100, String r101, String r102, String r103);

    private final native void nativeBizSetCacheCapability(String r100, String r101, int r102);

    private final native String nativeHandleEvent(String r100, String r101, String r102);

    private final native int nativeInit(String r100);

    private final native int nativeSetRuleConfig(String r100, String r101, String r102);

    @Override // com.bytedance.applog.params.c
    public final void a() {
        this.f192557f.b(new Object[0]);
        NativeLogWrapper.a();
    }

    public CommonParamsWrapper(String r100) {
        Intrinsics.checkNotNullParameter(r100, "applogHashCode");
        this.f192552a = r100;
        this.f192553b = CollectionsKt.listOf("CommonParamsWrapper");
        this.f192554c = new AtomicBoolean(true);
        this.f192555d = new HashMap();
        this.f192556e = new ConcurrentHashMap();
        this.f192557f = new a(this);
    }

    public static final /* synthetic */ void c(CommonParamsWrapper r100, String r101) {
        r100.nativeInit(r101);
    }

    @Override // com.bytedance.applog.params.c
    public final String b(String r100, rw3.e r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "paramsJsonString");
        String r102 = "";
        if (this.f192554c.get() == false) goto L5;
        return "";
    L5:
        String r103 = this.f192552a;
        String r104 = (String) r101.load();
        if (r104 == null) goto L9;
        r102 = r104;
    L9:
        String r105 = nativeHandleEvent(r103, r100, r102);
        if (r105.length() <= 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        n.w().h(this.f192553b, "event:{} had append some params!!", new Object[]{r100});
    L15:
        return r105;
    L12:
        r106 = false;
        goto L13
    }
}
