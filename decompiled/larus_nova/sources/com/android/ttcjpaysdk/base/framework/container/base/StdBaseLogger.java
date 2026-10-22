package com.android.ttcjpaysdk.base.framework.container.base;

import cd4.p;
import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import id4.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jd4.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u001c\u0010\u0011\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0000J\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bJ(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\f2\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000bJ\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R*\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdBaseLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "Lid4/c;", ShortVideoSegments.KEY_PROP_PROVIDER, "", "bindContextProvider", "getContextProvider", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "cjContext", "setCJContext", "getCJContext", "", "", "", "getCommonParams", "key", "value", "addCommonParams", "", "params", "Lorg/json/JSONObject;", "Lcom/android/ttcjpaysdk/base/framework/container/base/StdBaseLogger$ILoggerParamsProvider;", "addAllowInheritLoggerProvider", "logger", "inheritToLogger", "getAllCommonParams", "eventName", "onEvent", "release", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "defaultCJContext", "commonParams", "Ljava/util/Map;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allowInheritLoggerProviderList", "Ljava/util/ArrayList;", "contextProvider", "Lid4/c;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReleased", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "ICJContextDepend", "ILoggerParamsProvider", "base-context_release"}, k = 1, mv = {1, 6, 0})
public class StdBaseLogger implements MvpLogger {
    private ArrayList<ILoggerParamsProvider> allowInheritLoggerProviderList;
    private CJContext cjContext;
    private final Map<String, Object> commonParams;
    private c contextProvider;
    private CJContext defaultCJContext;
    private final AtomicBoolean hasReleased;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdBaseLogger$ICJContextDepend;", "Ljd4/a;", "Lcom/bytedance/caijing/sdk/infra/base/core/CJContext;", "getCJContext", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public interface ICJContextDepend extends a {
        CJContext getCJContext();

        @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
        /* synthetic */ void release();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/base/StdBaseLogger$ILoggerParamsProvider;", "Lcd4/p;", "", "", "", "getParams", "base-context_release"}, k = 1, mv = {1, 6, 0})
    public interface ILoggerParamsProvider extends p {
        Map<String, Object> getParams();

        @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
        /* synthetic */ void release();
    }

    public final Map<String, Object> getAllCommonParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(getCommonParams());
        ArrayList<ILoggerParamsProvider> r101 = this.allowInheritLoggerProviderList;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map<String, Object> r103 = ((ILoggerParamsProvider) r102.next()).getParams();
        if (r103 == null) goto L6;
        r100.putAll(r103);
    L10:
        return r100;
    }

    public final CJContext getCJContext() {
        CJContext r100 = this.cjContext;
        if (r100 != null) goto L13;
        c r101 = this.contextProvider;
        if (r101 == null) goto L9;
        ICJContextDepend r102 = (ICJContextDepend) r101.getCtx(ICJContextDepend.class);
        if (r102 == null) goto L9;
        CJContext r103 = r102.getCJContext();
    L10:
        if (r103 == null) goto L12;
        return r103;
    L12:
        return this.defaultCJContext;
    L9:
        r103 = null;
        goto L10
    L13:
        return r100;
    }

    public void release() {
        this.hasReleased.set(true);
        this.contextProvider = null;
        ArrayList<ILoggerParamsProvider> r100 = this.allowInheritLoggerProviderList;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.allowInheritLoggerProviderList = null;
    }

    public StdBaseLogger() {
        Set<String> r100 = CJContext.f202254w;
        this.defaultCJContext = CJContext.c.a("default", "", "", new ConcurrentHashMap());
        this.commonParams = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("app_version", CJEnv.i())});
        this.hasReleased = new AtomicBoolean(false);
    }

    public Map<String, Object> getCommonParams() {
        return this.commonParams;
    }

    public final c getContextProvider() {
        return this.contextProvider;
    }

    public final void addAllowInheritLoggerProvider(ILoggerParamsProvider r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        if (this.allowInheritLoggerProviderList != null) goto L5;
        this.allowInheritLoggerProviderList = new ArrayList();
    L5:
        ArrayList<ILoggerParamsProvider> r101 = this.allowInheritLoggerProviderList;
        if (r101 != null) goto L8;
        return;
    L8:
        if ((!r101.contains(r100)) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        r101.add(r100);
        return;
    }

    public final void addCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Iterator<String> r102 = r100.keys();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();     // Catch: Throwable -> L9
        this.commonParams.put(r103, r100.opt(r103));     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L18;
        CJLogger.c("StdBaseLogger", "addCommonParams error", r105);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void bindContextProvider(c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.contextProvider = r100;
    }

    public final void inheritToLogger(StdBaseLogger r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        ArrayList<ILoggerParamsProvider> r101 = this.allowInheritLoggerProviderList;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r100.addAllowInheritLoggerProvider((ILoggerParamsProvider) r102.next());
        goto L6
    L10:
        return;
    }

    public final void setCJContext(CJContext r100) {
        Intrinsics.checkNotNullParameter(r100, "cjContext");
        this.cjContext = r100;
    }

    public final void addCommonParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.commonParams.putAll(r100);
    }

    public final void addCommonParams(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.commonParams.put(r100, r101);
    }

    public final void onEvent(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (this.hasReleased.get() == false) goto L6;
        CJLogger.e("StdBaseLogger", "onEvent error, logger has released");
        return;
    L6:
        Map<String, Object> r102 = getAllCommonParams();
        if (r101 == null) goto L9;
        r102.putAll(r101);
    L9:
        r102.put("report_event_timestamp", Long.valueOf(System.currentTimeMillis()));
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, Object> r105 = r104.next();
        Object r106 = r105.getValue();
        if (r106 == null) goto L11;
        r103.put(r105.getKey(), r106);
        goto L11
    L15:
        CJReporter.h(CJReporter.f202294a, getCJContext(), r100, r102, null, 56);
        CJReporter.o(getCJContext(), r100, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onEvent$default(StdBaseLogger r100, String r101, Map r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = new LinkedHashMap();
    L6:
        r100.onEvent(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
    }
}
