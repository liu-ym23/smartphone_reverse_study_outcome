package com.bytedance.android.btm.impl.page.model;

import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001DB\t\b\u0002¢\u0006\u0004\bB\u0010:J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\t\u001a\u00020\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nJ,\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R*\u00103\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b3\u00104\u0012\u0004\b9\u0010:\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/bytedance/android/btm/impl/page/model/PageInfoStack;", "Ljava/io/Serializable;", "Lxc/a;", "", "getBtmPre", "sourceBtm", "", "contains", "Lcom/bytedance/android/btm/impl/page/model/PageInfo;", "current", "Ljava/util/concurrent/LinkedBlockingDeque;", "all", "", "page", "newPageBtm", "back", "sourceBtmToken", "", "onFEJump", "toString", "isStackEmpty", SVGRenderEngine.SAVE, "data", "parse", "TAG_CLASS_PREFIX", "Ljava/lang/String;", "TAG_ONFEJUMP", "stack", "Ljava/util/concurrent/LinkedBlockingDeque;", "Lcom/bytedance/android/btm/api/PageProp;", "pageProp", "Lcom/bytedance/android/btm/api/PageProp;", "getPageProp", "()Lcom/bytedance/android/btm/api/PageProp;", "setPageProp", "(Lcom/bytedance/android/btm/api/PageProp;)V", "isContainer", "Z", "()Z", "setContainer", "(Z)V", "Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;", "nativeState", "Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;", "getNativeState", "()Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;", "setNativeState", "(Lcom/bytedance/android/btm/api/BtmPageLifecycle$State;)V", "pageState", "getPageState", "setPageState", "userVisibleHint", "Ljava/lang/Boolean;", "getUserVisibleHint", "()Ljava/lang/Boolean;", "setUserVisibleHint", "(Ljava/lang/Boolean;)V", "userVisibleHint$annotations", "()V", "", "resumeElapsedRealtime", "J", "getResumeElapsedRealtime", "()J", "setResumeElapsedRealtime", "(J)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class PageInfoStack implements Serializable, xc.a<PageInfoStack> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cd.c f42328a = null;
    private static final long serialVersionUID = 20211213;
    private final String TAG_CLASS_PREFIX;
    private final String TAG_ONFEJUMP;
    private boolean isContainer;
    private BtmPageLifecycle.State nativeState;
    private PageProp pageProp;
    private BtmPageLifecycle.State pageState;
    private long resumeElapsedRealtime;
    private LinkedBlockingDeque<PageInfo> stack;
    private Boolean userVisibleHint;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KProperty[] f42329a = null;

        static {
            f42329a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "pageInfoFactory", "getPageInfoFactory()Lcom/bytedance/android/btm/impl/page/model/PageInfoFactory;"))};
        }

        public a() {
        }

        public static g a() {
            return (g) PageInfoStack.access$getPageInfoFactory$cp().getValue(PageInfoStack.Companion, f42329a[0]);
        }
    }

    @Deprecated(message = "")
    public static /* synthetic */ void userVisibleHint$annotations() {
    }

    static {
        Companion = new a();
        f42328a = new cd.c(PageInfoStack$Companion$pageInfoFactory$2.INSTANCE);
    }

    public final PageInfo current() {
        if ((!this.stack.isEmpty()) == false) goto L7;
        return this.stack.getLast();
    L7:
        if (BtmSetting.f42469d.c().b().E() != 1) goto L20;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.stack.isEmpty() == false) goto L14;
        Companion.getClass();     // Catch: Throwable -> L17
        PageInfo r100 = a.a().create();     // Catch: Throwable -> L17
        this.stack.putLast(r100);     // Catch: Throwable -> L17
        ALogger.f41996d.b("PageInfoStack", false, PageInfoStack$current$1$1.INSTANCE);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r100;
    L14:
        PageInfo r101 = this.stack.getLast();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r101;
    L20:
        Companion.getClass();
        PageInfo r102 = a.a().create();
        this.stack.putLast(r102);
        return r102;
    }

    public final boolean isStackEmpty() {
        return this.stack.isEmpty();
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        r100.put("isContainer", this.isContainer);     // Catch: Throwable -> L19
        r100.put("native_state", this.nativeState);     // Catch: Throwable -> L19
        r100.put("page_state", this.pageState);     // Catch: Throwable -> L19
        PageProp r101 = this.pageProp;     // Catch: Throwable -> L19
        if (r101 == null) goto L8;
        String r102 = r101.save();     // Catch: Throwable -> L19
        if (r102 == null) goto L8;
    L9:
        r100.put("page_prop", r102);     // Catch: Throwable -> L19
        r100.put("resume_elapsed_realtime", this.resumeElapsedRealtime);     // Catch: Throwable -> L19
        JSONArray r103 = new JSONArray();     // Catch: Throwable -> L19
        Iterator<T> r104 = this.stack.iterator();     // Catch: Throwable -> L18
    L12:
        if (r104.hasNext() == false) goto L15;
        r103.put(((PageInfo) r104.next()).save());     // Catch: Throwable -> L18
    L15:
        r100.put("stack", r103);     // Catch: Throwable -> L19
    L8:
        r102 = SliceInitService.DEFAULT_SWITCH;
    L17:
        return r100.toString();
    }

    private PageInfoStack() {
        this.TAG_CLASS_PREFIX = "PageInfoStack_";
        this.TAG_ONFEJUMP = "PageInfoStack_onFEJump";
        this.stack = new LinkedBlockingDeque();
        BtmPageLifecycle.State r100 = BtmPageLifecycle.State.INITIALIZED;
        this.nativeState = r100;
        this.pageState = r100;
    }

    public final String getBtmPre() {
        return current().getBtmPre();
    }

    @Override // xc.a
    public String save() {
        return toString();
    }

    public static final /* synthetic */ cd.c access$getPageInfoFactory$cp() {
        return f42328a;
    }

    public final LinkedBlockingDeque<PageInfo> all() {
        return this.stack;
    }

    public final BtmPageLifecycle.State getNativeState() {
        return this.nativeState;
    }

    public final PageProp getPageProp() {
        return this.pageProp;
    }

    public final BtmPageLifecycle.State getPageState() {
        return this.pageState;
    }

    public final long getResumeElapsedRealtime() {
        return this.resumeElapsedRealtime;
    }

    public final Boolean getUserVisibleHint() {
        return this.userVisibleHint;
    }

    public final boolean isContainer() {
        return this.isContainer;
    }

    public /* synthetic */ PageInfoStack(DefaultConstructorMarker r100) {
        this();
    }

    public static final /* synthetic */ LinkedBlockingDeque access$getStack$p(PageInfoStack r100) {
        return r100.stack;
    }

    public static final /* synthetic */ void access$setPageInfoFactory$cp(cd.c r100) {
        f42328a = r100;
    }

    public final boolean contains(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Iterator<PageInfo> r102 = this.stack.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r102.next().getBtmPre(), r100) == false) goto L13;
        return true;
    L17:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // xc.a
    public PageInfoStack parse(String r110) {
        JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L10
        this.isContainer = r100.optBoolean("isContainer");     // Catch: Exception -> L10
        this.nativeState = BtmPageLifecycle.State.valueOf(r100.optString("native_state"));     // Catch: Exception -> L10
        this.pageState = BtmPageLifecycle.State.valueOf(r100.optString("page_state"));     // Catch: Exception -> L10
        this.pageProp = new PageProp(null, false, false, false, null, 31, null).parse(r100.optString("page_prop"));     // Catch: Exception -> L10
        this.resumeElapsedRealtime = r100.optLong("resume_elapsed_realtime");     // Catch: Exception -> L10
        LinkedBlockingDeque<PageInfo> r111 = new LinkedBlockingDeque();     // Catch: Exception -> L10
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "stack");     // Catch: Throwable -> L9
        int r102 = r101.length();     // Catch: Throwable -> L9
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L7;
        Companion.getClass();     // Catch: Throwable -> L9
        r111.add(a.a().create().parse(JSONArrayProtectorUtils.getString(r101, r103)));     // Catch: Throwable -> L9
        r103 = r103 + 1;
    L7:
        this.stack = r111;     // Catch: Exception -> L10
    L8:
        return this;
    }

    public final void setContainer(boolean r100) {
        this.isContainer = r100;
    }

    public final void setNativeState(BtmPageLifecycle.State r100) {
        this.nativeState = r100;
    }

    public final void setPageProp(PageProp r100) {
        this.pageProp = r100;
    }

    public final void setPageState(BtmPageLifecycle.State r100) {
        this.pageState = r100;
    }

    public final void setResumeElapsedRealtime(long r100) {
        this.resumeElapsedRealtime = r100;
    }

    public final void setUserVisibleHint(Boolean r100) {
        this.userVisibleHint = r100;
    }

    @Override // xc.a
    public /* bridge */ /* synthetic */ Object parse(String r100) {
        return parse(r100);
    }

    public static final /* synthetic */ void access$setStack$p(PageInfoStack r100, LinkedBlockingDeque r101) {
        r100.stack = r101;
    }

    public final void onFEJump(Object r110, final String r111, final boolean r112, String r113) {
        final String r100 = r110.getClass().getName();
        ALogger r101 = ALogger.f41996d;
        ALogger.j(r101, this.TAG_ONFEJUMP, new AnonymousClass1(this, r100, r111, r112));
        if (r112 == true) goto L5;
    L8:
        boolean r102 = BtmPageLifecycleCallbackV2.f42312a;
        BtmPageLifecycleCallbackV2.d(r110, this, PauseFuncOrigin.HybridJump);
        if (r112 == true) goto L11;
    L13:
        Companion.getClass();
        PageInfo r114 = a.a().create();
        PageProp r103 = this.pageProp;
        if (r103 == null) goto L16;
        boolean r104 = r103.getAuto();
    L17:
        PageProp r105 = this.pageProp;
        if (r105 == null) goto L20;
        boolean r106 = r105.getSingleton();
    L21:
        PageProp r107 = this.pageProp;
        if (r107 == null) goto L24;
        boolean r108 = r107.getReuse();
    L25:
        r114.setProp(new PageProp(r111, r104, r106, r108, r113), r110, this);
        this.stack.putLast(r114);
    L26:
        BtmPageLifecycleCallbackV2.e(r110, this, ResumeFuncOrigin.HybridRegister);
        return;
    L24:
        r108 = false;
        goto L25
    L20:
        r106 = false;
        goto L21
    L16:
        r104 = true;
        goto L17
    L11:
        if (this.stack.size() <= 1) goto L13;
        this.stack.removeLast();
        goto L26
    L5:
        if (this.stack.size() != 1) goto L8;
        ALogger.j(r101, this.TAG_ONFEJUMP, new AnonymousClass2(r100));
    }

    public static /* synthetic */ void onFEJump$default(PageInfoStack r100, Object r101, String r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r105 & 8) == 0) goto L8;
        r104 = null;
    L8:
        r100.onFEJump(r101, r102, r103, r104);
    }
}
