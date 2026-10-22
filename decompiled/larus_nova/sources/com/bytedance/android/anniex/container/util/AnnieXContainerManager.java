package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import com.bytedance.android.anniex.utils.ThreadSafeFixedSizeFIFOMap;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.x;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0004J.\u0010\u001b\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u0018j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019`\u001aJ\"\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010'R'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R'\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00190.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104RC\u00108\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00190\u0018j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0019`\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010*\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/bytedance/android/anniex/container/util/AnnieXContainerManager;", "", "Lia/c;", "self", "", "bdxTag", "", "clearTopActivity", KtvSubElement.CONTAINER, "", "isTopContainer", "instanceId", "pureTemplateUrl", "putTemplateUrlFromEngineHashCode", "putAliveTemplateUrlFromEngineHashCode", "schemaUrl", "getPureTemplateUrl", "addContainer", "containerId", "isNestingDollScene", "closeContainerById", "release", "removeContainerById", "getContainerById", "Ljava/util/LinkedHashMap;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/LinkedHashMap;", "getAllContainer", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "launchMode", "triggerNestingDoll", "saveTemplateUrlFromEngineHashCode", "", "hashCode", "Lia/a;", "containerProxy", "saveContainerProxyFromEngineHashCode", "removeContainerProxyFromEngineHashCode", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/anniex/utils/ThreadSafeFixedSizeFIFOMap;", "engineUrlMap$delegate", "Lkotlin/Lazy;", "getEngineUrlMap", "()Lcom/bytedance/android/anniex/utils/ThreadSafeFixedSizeFIFOMap;", "engineUrlMap", "Ljava/util/concurrent/ConcurrentHashMap;", "engineAliveUrlMap$delegate", "getEngineAliveUrlMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "engineAliveUrlMap", "aliveContainerProxyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "containerMap$delegate", "getContainerMap", "()Ljava/util/LinkedHashMap;", "containerMap", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXContainerManager {
    public static final AnnieXContainerManager INSTANCE = null;
    public static final String TAG = "AnnieXContainerManager";
    private static final ConcurrentHashMap<Integer, WeakReference<ia.a>> aliveContainerProxyMap = null;
    private static final Lazy containerMap$delegate = null;
    private static final Lazy engineAliveUrlMap$delegate = null;
    private static final Lazy engineUrlMap$delegate = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40611a = null;

        static {
            int[] r100 = new int[LaunchMode.values().length];
            r100[LaunchMode.REMOVE_SAME_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LaunchMode.CLEAR_TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f40611a = r100;
        }
    }

    public static final class b implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t36.d f40612a;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "clearTopEvent";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            JSONObject r100 = new JSONObject();
            r100.put("new_url", this.f40612a.getOriginUrl());
            return r100;
        }

        public b(t36.d r100) {
            this.f40612a = r100;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f40613a;

        public c(String r100) {
            this.f40613a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            String r101 = AnnieXContainerManager.access$getPureTemplateUrl(AnnieXContainerManager.INSTANCE, this.f40613a);
            if (r101 == null) goto L5;
            r100.onNext(r101);
        L5:
            r100.onComplete();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f40614a;

        public d(String r100) {
            this.f40614a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            AnnieXContainerManager r102 = AnnieXContainerManager.INSTANCE;
            AnnieXContainerManager.access$putTemplateUrlFromEngineHashCode(r102, this.f40614a, r101);
            AnnieXContainerManager.access$putAliveTemplateUrlFromEngineHashCode(r102, this.f40614a, r101);
        }
    }

    private AnnieXContainerManager() {
    }

    static {
        INSTANCE = new AnnieXContainerManager();
        engineUrlMap$delegate = LazyKt.lazy(AnnieXContainerManager$engineUrlMap$2.INSTANCE);
        engineAliveUrlMap$delegate = LazyKt.lazy(AnnieXContainerManager$engineAliveUrlMap$2.INSTANCE);
        aliveContainerProxyMap = new ConcurrentHashMap();
        containerMap$delegate = LazyKt.lazy(AnnieXContainerManager$containerMap$2.INSTANCE);
    }

    private final LinkedHashMap<String, WeakReference<ia.c>> getContainerMap() {
        return (LinkedHashMap) containerMap$delegate.getValue();
    }

    public final ConcurrentHashMap<String, String> getEngineAliveUrlMap() {
        return (ConcurrentHashMap) engineAliveUrlMap$delegate.getValue();
    }

    public final ThreadSafeFixedSizeFIFOMap<String, String> getEngineUrlMap() {
        return (ThreadSafeFixedSizeFIFOMap) engineUrlMap$delegate.getValue();
    }

    public final LinkedHashMap<String, WeakReference<ia.c>> getAllContainer() {
        return getContainerMap();
    }

    private final String getPureTemplateUrl(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L14
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L7;
    L12:
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L14
        return new Uri.Builder().scheme(r104.getScheme()).authority(r104.getAuthority()).path(r104.getPath()).build().toString();
    L7:
        if (UriProtector.getQueryParameter(r103, "url") == null) goto L10;
        r100 = UriProtector.getQueryParameter(r103, "url");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L14
        goto L12
    L10:
        if (UriProtector.getQueryParameter(r103, "surl") == null) goto L12;
        r100 = UriProtector.getQueryParameter(r103, "surl");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L19;
        r101 = r106;
    L19:
        return (String) r101;
    }

    @JvmStatic
    public static final boolean isTopContainer(ia.c r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Set<Map.Entry<String, WeakReference<ia.c>>> r101 = INSTANCE.getAllContainer().entrySet();
        ia.c r102 = null;
        if ((!r101.isEmpty()) == true) goto L6;
        r101 = null;
    L6:
        if (r101 == null) goto L13;
        Map.Entry r103 = (Map.Entry) CollectionsKt.last(r101);
        if (r103 == null) goto L13;
        WeakReference r104 = (WeakReference) r103.getValue();
        if (r104 == null) goto L13;
        r102 = (ia.c) r104.get();
    L13:
        return Intrinsics.areEqual(r102, r100);
    }

    public final void addContainer(ia.c r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        String r101 = r100.getBDXTag();
        if (r101 == null) goto L5;
        INSTANCE.triggerNestingDoll(r101, r100.getBDXLaunchMode(), r100);
    L5:
        getContainerMap().put(r100.getContainerId(), new WeakReference(r100));
    }

    public final ia.c getContainerById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        WeakReference<ia.c> r101 = getContainerMap().get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }

    public final void removeContainerProxyFromEngineHashCode(int r100) {
        if (r100 != (-1)) goto L5;
        return;
    L5:
        aliveContainerProxyMap.remove(Integer.valueOf(r100));
    }

    public static final /* synthetic */ String access$getPureTemplateUrl(AnnieXContainerManager r100, String r101) {
        return r100.getPureTemplateUrl(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void clearTopActivity(ia.c r100, String r101) {
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);
        if (r103 == null) goto L9;
        w26.e r104 = (w26.e) r103.n0(w26.e.class);
        if (r104 == null) goto L9;
        Boolean r105 = r104.q0();
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        if (r106 == true) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r100.getViewType(), "page") == true) goto L15;
        return;
    L15:
        List r107 = CollectionsKt.asReversed(CollectionsKt.toList(getContainerMap().entrySet()));
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L16:
        Object r110 = null;
        if (r109.hasNext() == false) goto L33;
        ia.c r111 = (ia.c) ((WeakReference) ((Map.Entry) r109.next()).getValue()).get();
        if (Intrinsics.areEqual(r111, r100) == true) goto L28;
        if (r111 == null) goto L22;
        String r112 = r111.getBDXTag();
    L24:
        if (Intrinsics.areEqual(r112, r101) == false) goto L28;
        if (Intrinsics.areEqual(r111.getViewType(), "page") == false) goto L28;
        r108.add(r111);
    L34:
        r108.remove(r100);
        if (r111 != null) goto L37;
        return;
    L37:
        t36.d r113 = r111.getCurrentSchema();
        if (r113 == null) goto L40;
        Uri r114 = r113.getOriginUrl();
    L41:
        String.valueOf(r114);
        WeakReference<Context> r115 = r111.getWeakContext();
        if (r115 == null) goto L44;
        Context r116 = r115.get();
    L46:
        if ((r116 instanceof Activity) == false) goto L48;
        Activity r117 = (Activity) r116;
    L49:
        if (r117 != null) goto L51;
        return;
    L51:
        x r118 = x.f246571a;
        LinkedList<Activity> r119 = x.f246573c;
        Activity[] r120 = (Activity[]) r119.toArray(new Activity[r119.size()]);
        if (r120 == null) goto L55;
        List r121 = ArraysKt.reversed(r120);
        if (r121 == null) goto L55;
    L56:
        ArrayList r122 = new ArrayList();
        Context r123 = r100.getWeakContext().get();
        if ((r123 instanceof Activity) == false) goto L59;
        r110 = (Activity) r123;
    L59:
        Iterator r124 = r121.iterator();
    L61:
        if (r124.hasNext() == false) goto L68;
        Activity r125 = (Activity) r124.next();
        if (Intrinsics.areEqual(r117, r125) == true) goto L64;
        if (Intrinsics.areEqual(r125, r110) == true) goto L61;
        r122.add(r125);
        goto L61
    L64:
        r122.add(r125);
    L68:
        Iterator r126 = r108.iterator();
    L70:
        if (r126.hasNext() == false) goto L72;
        INSTANCE.closeContainerById(((ia.c) r126.next()).getContainerId(), true);
        goto L70
    L72:
        Iterator r127 = r122.iterator();
    L74:
        if (r127.hasNext() == false) goto L89;
        Activity r128 = (Activity) r127.next();
        boolean r129 = false;
        if (r128 != null) goto L78;
    L80:
        boolean r130 = false;
    L81:
        if (r130 == true) goto L74;
        if (r128 != null) goto L84;
    L86:
        if (r129 == true) goto L74;
        if (r128 == null) goto L74;
        r128.finish();
        goto L74
    L84:
        if (r128.isDestroyed() != true) goto L86;
        r129 = true;
        goto L86
    L78:
        if (r128.isFinishing() != true) goto L80;
        r130 = true;
        goto L81
    L89:
        t36.d r131 = r100.getCurrentSchema();
        if (r131 != null) goto L92;
        return;
    L92:
        if (Intrinsics.areEqual((Boolean) new y36.a(r131, "send_clear_top_event", Boolean.FALSE).f565862b, Boolean.TRUE) == false) goto L118;
        r100.sendEvent(new b(r131));
        return;
    L118:
        return;
    L55:
        r121 = new LinkedList();
        goto L56
    L48:
        r117 = null;
        goto L49
    L44:
        r116 = null;
        goto L46
    L40:
        r114 = null;
        goto L41
    L22:
        r112 = null;
    L28:
        if (r111 == null) goto L31;
        r110 = r111.getViewType();
    L31:
        if (Intrinsics.areEqual(r110, "page") == false) goto L16;
        r108.add(r111);
        goto L16
    L33:
        r111 = null;
    L9:
        r106 = true;
        goto L10
    }

    private final void putAliveTemplateUrlFromEngineHashCode(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L18;
        return;
    L18:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        getEngineAliveUrlMap().put(r100, r101);     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i(TAG, "parse url failure " + r105.getMessage() + ",url is :" + r101, null, 12);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    private final void putTemplateUrlFromEngineHashCode(String r100, String r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L18;
        return;
    L18:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        ThreadSafeFixedSizeFIFOMap<String, String> r104 = getEngineUrlMap();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L12
        r104.put(r100, r101);     // Catch: Throwable -> L12
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L20;
        HybridLogger r107 = HybridLogger.f246343a;
        HybridLogger.i(TAG, "parse url failure " + r106.getMessage() + ",url is :" + r101, null, 12);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L4:
        if (r101.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    public final boolean closeContainerById(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        WeakReference<ia.c> r102 = getContainerMap().remove(r100);
        if (r102 == null) goto L5;
        ia.c r103 = r102.get();
    L6:
        if (r103 == null) goto L37;
        r103.close();
        Map<String, Map<Class<?>, Object>> r104 = x26.a.f562251a;
        w26.g r105 = (w26.g) x26.a.a(w26.g.class);
        if (r105 == null) goto L14;
        w26.e r106 = (w26.e) r105.n0(w26.e.class);
        if (r106 == null) goto L14;
        Boolean r107 = r106.Q();
        if (r107 == null) goto L14;
        boolean r108 = r107.booleanValue();
    L15:
        if (r108 == true) goto L17;
    L20:
        w26.g r109 = (w26.g) x26.a.a(w26.g.class);
        if (r109 == null) goto L27;
        w26.e r110 = (w26.e) r109.n0(w26.e.class);
        if (r110 == null) goto L27;
        Boolean r111 = r110.K();
        if (r111 == null) goto L27;
        boolean r112 = r111.booleanValue();
    L28:
        if (r112 == true) goto L30;
    L35:
        r103.release();
        return true;
    L30:
        if (Intrinsics.areEqual(r103.getViewType(), "page") == false) goto L32;
    L33:
        if (r101 == true) goto L35;
        return true;
    L32:
        if (Intrinsics.areEqual(r103.getViewType(), "popup") == false) goto L35;
    L27:
        r112 = true;
        goto L28
    L17:
        if ((r103 instanceof AnnieXFlowPageContainer) == false) goto L20;
        if (r101 == true) goto L20;
        return true;
    L14:
        r108 = true;
        goto L15
    L37:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    public final boolean removeContainerById(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
        WeakReference<ia.c> r102 = getContainerMap().remove(r100);
        if (r102 == null) goto L5;
        ia.c r103 = r102.get();
    L6:
        if (r103 == null) goto L11;
        if (r101 == false) goto L13;
        r103.release();
        return true;
    L13:
        return true;
    L11:
        return false;
    L5:
        r103 = null;
        goto L6
    }

    public final void saveContainerProxyFromEngineHashCode(int r100, ia.a r101) {
        Intrinsics.checkNotNullParameter(r101, "containerProxy");
        if (r100 != (-1)) goto L5;
        return;
    L5:
        com.bytedance.android.anniex.assemble.a.h();
        aliveContainerProxyMap.put(Integer.valueOf(r100), new WeakReference(r101));
    }

    public final void saveTemplateUrlFromEngineHashCode(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "instanceId");
        Intrinsics.checkNotNullParameter(r101, "schemaUrl");
        Observable.create(new c(r101)).subscribeOn(Schedulers.io()).subscribe(new d(r100));
    }

    public static final /* synthetic */ void access$putAliveTemplateUrlFromEngineHashCode(AnnieXContainerManager r100, String r101, String r102) {
        r100.putAliveTemplateUrlFromEngineHashCode(r101, r102);
    }

    public static final /* synthetic */ void access$putTemplateUrlFromEngineHashCode(AnnieXContainerManager r100, String r101, String r102) {
        r100.putTemplateUrlFromEngineHashCode(r101, r102);
    }

    public final void triggerNestingDoll(String r100, LaunchMode r101, ia.c r102) {
        Intrinsics.checkNotNullParameter(r100, "bdxTag");
        Intrinsics.checkNotNullParameter(r101, "launchMode");
        int r103 = a.f40611a[r101.ordinal()];
        if (r103 != 1) goto L5;
        ArrayList r104 = new ArrayList();
        Iterator<Map.Entry<String, WeakReference<ia.c>>> r105 = getContainerMap().entrySet().iterator();
    L20:
        if (r105.hasNext() == false) goto L47;
        Map.Entry<String, WeakReference<ia.c>> r106 = r105.next();
        ia.c r107 = r106.getValue().get();
        if (r107 == null) goto L24;
        String r108 = r107.getBDXTag();
    L26:
        if (Intrinsics.areEqual(r108, r100) == false) goto L20;
        Map<String, Map<Class<?>, Object>> r109 = x26.a.f562251a;
        w26.g r110 = (w26.g) x26.a.a(w26.g.class);
        if (r110 == null) goto L34;
        w26.e r111 = (w26.e) r110.n0(w26.e.class);
        if (r111 == null) goto L34;
        Boolean r112 = r111.I1();
        if (r112 == null) goto L34;
        boolean r113 = r112.booleanValue();
    L35:
        if (r113 == true) goto L36;
        r104.add(r106.getKey());
        goto L20
    L36:
        ia.c r114 = r106.getValue().get();
        if (r114 == null) goto L39;
        Context r115 = r114.getSystemContext();
    L40:
        if (r102 == null) goto L42;
        Context r116 = r102.getSystemContext();
    L44:
        if (Intrinsics.areEqual(r115, r116) == true) goto L20;
        r104.add(r106.getKey());
        goto L20
    L42:
        r116 = null;
        goto L44
    L39:
        r115 = null;
    L34:
        r113 = true;
        goto L35
    L24:
        r108 = null;
        goto L26
    L47:
        Iterator r117 = r104.iterator();
    L49:
        if (r117.hasNext() == false) goto L67;
        closeContainerById((String) r117.next(), true);
        goto L49
    L67:
        return;
    L5:
        if (r103 != 2) goto L66;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        clearTopActivity(r102, r100);     // Catch: Throwable -> L13
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L13
    L15:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L51;
        HybridLogger r122 = HybridLogger.f246343a;
        HybridLogger.i(TAG, "clearTopActivity error:" + r121.getMessage(), null, 12);
        return;
    L51:
        return;
    L10:
        r119 = null;
    L13:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static /* synthetic */ boolean closeContainerById$default(AnnieXContainerManager r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.closeContainerById(r101, r102);
    }

    public static /* synthetic */ boolean removeContainerById$default(AnnieXContainerManager r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = true;
    L6:
        return r100.removeContainerById(r101, r102);
    }

    public static /* synthetic */ void triggerNestingDoll$default(AnnieXContainerManager r100, String r101, LaunchMode r102, ia.c r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.triggerNestingDoll(r101, r102, r103);
    }
}
