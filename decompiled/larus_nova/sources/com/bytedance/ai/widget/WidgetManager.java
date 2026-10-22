package com.bytedance.ai.widget;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.PendingWidgetPerformanceTracker;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k2.u;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import m5.i1;
import m5.u0;
import m5.y0;

/* JADX INFO: loaded from: classes43.dex */
public final class WidgetManager implements l2.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f37917h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArrayDeque<WeakReference<WidgetManager>> f37918i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f37919j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<com.bytedance.ai.widget.contianer.h, b> f37920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f37921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f37922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<Pair<String, String>> f37923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f37924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WidgetManager$widgetUpdateListener$1 f37925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<com.bytedance.ai.widget.contianer.h> f37926g;

    public static final class a {
        public final synchronized WidgetManager b() {
            monitor-enter(this);
            ArrayDeque<WeakReference<WidgetManager>> r100 = WidgetManager.f37918i;     // Catch: Throwable -> L15
            ListIterator<WeakReference<WidgetManager>> r101 = r100.listIterator(r100.size());     // Catch: Throwable -> L15
        L5:
            if (r101.hasPrevious() == false) goto L12;
            WidgetManager r102 = r101.previous().get();     // Catch: Throwable -> L15
            if (r102 != null) goto L10;
            r101.remove();     // Catch: Throwable -> L15
            goto L5
        L10:
            monitor-exit(this);
            return r102;
        L12:
            monitor-exit(this);
            return null;
        L15:
            th = move-exception;
            throw th;
        }

        public a() {
        }

        public final synchronized com.bytedance.ai.widget.contianer.h a(final View r100) {
            monitor-enter(this);
            Iterator r101 = CollectionsKt.asReversedMutable(WidgetManager.f37918i).iterator();     // Catch: Throwable -> L17
        L4:
            com.bytedance.ai.widget.contianer.h r102 = null;
            if (r101.hasNext() == false) goto L15;
            WidgetManager r103 = (WidgetManager) ((WeakReference) r101.next()).get();     // Catch: Throwable -> L17
            if (r103 == null) goto L12;
            if (r100 == null) goto L12;
            r102 = r103.m(new i(r100));     // Catch: Throwable -> L17
        L12:
            if (r102 == null) goto L4;
            monitor-exit(this);
            return r102;
        L15:
            monitor-exit(this);
            return null;
        L17:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jh\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/ai/widget/WidgetManager$InnerWidgetContext;", "", "messageId", "", "sectionId", "widgetId", PerfLog.PARAM_KEY_CONTEXT_ID, "position", "", "widgetInfo", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "parentRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/ref/WeakReference;)V", "getMessageId", "()Ljava/lang/String;", "getSectionId", "getWidgetId", "getContext", "setContext", "(Ljava/lang/String;)V", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidgetInfo", "()Lcom/bytedance/ai/model/objects/WidgetInfo;", "getParentRef", "()Ljava/lang/ref/WeakReference;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/ref/WeakReference;)Lcom/bytedance/ai/widget/WidgetManager$InnerWidgetContext;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient String f37927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient Integer f37928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient WidgetInfo f37929c;

        @SerializedName(PerfLog.PARAM_KEY_CONTEXT_ID)
        private String context;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient WeakReference<ViewGroup> f37930d;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private final String messageId;

        @SerializedName("widget_id")
        private final String widgetId;

        public b() {
            this(null, null, null, null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37927a, r101.f37927a) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.context, r101.context) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f37928b, r101.f37928b) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f37929c, r101.f37929c) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f37930d, r101.f37930d) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.messageId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f37927a;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.widgetId;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.context;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.f37928b;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            WidgetInfo r116 = this.f37929c;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            WeakReference<ViewGroup> r119 = this.f37930d;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "InnerWidgetContext(messageId=" + this.messageId + ", sectionId=" + this.f37927a + ", widgetId=" + this.widgetId + ", context=" + this.context + ", position=" + this.f37928b + ", widgetInfo=" + this.f37929c + ", parentRef=" + this.f37930d + ')';
        }

        public final String a() {
            return this.messageId;
        }

        public final String getContext() {
            return this.context;
        }

        public b(String r100, String r101, String r102, String r103, Integer r104, WidgetInfo r105, WeakReference<ViewGroup> r106) {
            this.messageId = r100;
            this.f37927a = r101;
            this.widgetId = r102;
            this.context = r103;
            this.f37928b = r104;
            this.f37929c = r105;
            this.f37930d = r106;
        }
    }

    static {
        f37917h = new a();
        f37918i = new ArrayDeque();
    }

    public final void k() {
        Iterator r100 = CollectionsKt.toList(this.f37920a.keySet()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        l((com.bytedance.ai.widget.contianer.h) r100.next());
        goto L4
    }

    @Override // l2.a
    public final void onHostDestroy() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostDestroy");
        k();
        AIManager r100 = AIManager.f37211a;
        WidgetManager$widgetUpdateListener$1 r101 = this.f37925f;
        Intrinsics.checkNotNullParameter(r101, "listener");
        AIManager.f37214d.remove(r101);
        a r102 = f37917h;
        monitor-enter(r102);
        CollectionsKt.removeAll(f37918i, new k(this));     // Catch: Throwable -> L8
        monitor-exit(r102);
        this.f37924e.getClass();
        com.bytedance.ai.widget.cache.a.a();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // l2.a
    public final void onHostHide() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostHide");
        Iterator<T> r100 = this.f37920a.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        WidgetContainer r101 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.h) r100.next());
        r101.onHide();
        r101.onHostHide();
        goto L4
    }

    @Override // l2.a
    public final void onHostShow() {
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onHostShow");
        if (f37919j == true) goto L10;
        Trace.beginSection("initLynx");
        h2.a r100 = f2.b.f475099c;
        if (r100 == null) goto L9;
        Context r101 = r100.f483562a;
        if (r101 == null) goto L9;
        int r102 = AppletLynxViewApi.f36629a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IIvyAIPackageResourceService.f278317a.e(r101);
    L9:
        Trace.endSection();
    L10:
        a r103 = f37917h;
        monitor-enter(r103);
        ArrayDeque<WeakReference<WidgetManager>> r104 = f37918i;     // Catch: Throwable -> L21
        CollectionsKt.removeAll(r104, new j(this));     // Catch: Throwable -> L21
        r104.addLast(new WeakReference(this));     // Catch: Throwable -> L21
        monitor-exit(r103);
        Iterator<T> r105 = this.f37920a.keySet().iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        WidgetContainer r106 = (WidgetContainer) ((com.bytedance.ai.widget.contianer.h) r105.next());
        r106.onHostShow();
        if (r106.f() == false) goto L16;
        r106.onShow();
        goto L16
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.widget.WidgetManager$widgetUpdateListener$1, java.lang.Object] */
    public WidgetManager() {
        this.f37920a = new HashMap();
        this.f37923d = new HashSet();
        this.f37924e = new n();
        ?? r100 = new WidgetManager$widgetUpdateListener$1(this);
        this.f37925f = r100;
        AIManager r101 = AIManager.f37211a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        AIManager.f37214d.add((AIManager.c) r100);
    }

    @Override // l2.a
    public final void a(String r100) {
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onChatHistoryClear convId=" + r100 + " this.convId=" + this.f37921b);
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r100, this.f37921b) == false) goto L10;
        k();
        this.f37926g = null;
        return;
    }

    @Override // l2.a
    public final void c(com.bytedance.ai.widget.contianer.h r100) {
        l(r100);
        r100.m();
    }

    @Override // l2.a
    public final void e(h5.k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.ai.widget.contianer.h r101 = n(r100);
        ViewGroup r102 = null;
        if (r101 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r103 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "onWidgetRecycled msgId=" + r100.a() + " widgetContainer not found, enableCache = " + r100.f483847l, null);
        return;
    L6:
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetRecycled widget=" + r101 + " view=" + r101.realView() + " enableCache = " + r100.f483847l);
        View r105 = r101.realView();
        if (r105 == null) goto L13;
        ViewParent r106 = r105.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L11;
        r102 = (ViewGroup) r106;
    L11:
        if (r102 == null) goto L13;
        r102.removeView(r105);
    L13:
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetRecycled destroy widgetContainer");
        l(r101);
        r101.m();
    }

    @Override // l2.a
    public final void f(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "msgIds");
        com.bytedance.ai.applet.base.log.b r101 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "onWidgetMessageRemoved " + r100);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        String r103 = (String) r102.next();
        Set<com.bytedance.ai.widget.contianer.h> r104 = this.f37920a.keySet();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        com.bytedance.ai.widget.contianer.m r108 = ((com.bytedance.ai.widget.contianer.h) r107).k();
        if (r108 == null) goto L11;
        String r109 = r108.f38019e;
    L13:
        if (Intrinsics.areEqual(r109, r103) == false) goto L7;
        r105.add(r107);
        goto L7
    L11:
        r109 = null;
        goto L13
    L15:
        Iterator r110 = r105.iterator();
    L17:
        if (r110.hasNext() == false) goto L4;
        com.bytedance.ai.widget.contianer.h r111 = (com.bytedance.ai.widget.contianer.h) r110.next();
        com.bytedance.ai.applet.base.log.b r112 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "onWidgetMessageRemoved msgId=" + r103 + ' ' + r111);
        Intrinsics.checkNotNull(r111);
        l(r111);
        goto L17
    }

    @Override // l2.a
    public final void g(final h5.k r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        WidgetInfo r100 = r210.f483841f;
        if (r100 == null) goto L5;
        String r101 = r100.getAppletId();
    L6:
        if (r101 != null) goto L8;
    L23:
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "updateWidget invalid render context " + r210, null);
        return;
    L8:
        if (r100.getWidgetId() == null) goto L23;
        String r103 = r210.f483840e;
        if (r103 != null) goto L16;
        AppletRuntimeManager r104 = AppletRuntimeManager.INSTANCE;
        String r105 = r210.f483837b;
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r104.getClass();
        r103 = AppletRuntimeManager.h(r105);
    L16:
        String r106 = r103;
        com.bytedance.ai.widget.contianer.h r107 = n(r210);
        if (r107 != null) goto L20;
        r107 = m(new e(r210));
    L20:
        if (r107 == null) goto L25;
        r107.o(new com.bytedance.ai.widget.contianer.m(r100.getAppletId(), r100.getWidgetId(), r100.getWidgetData(), r106, r210.f483836a, r210.f483838c, r210.f483839d, r210.f483845j, r210.f483846k, r100.getMixtureCardId(), r210.f483837b, r210.b(), null, r210.f483849n, null, null, null, null, 512000));
        return;
    L25:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // l2.a
    public final void h(Iterable<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleWidgets");
        Iterator<T> r101 = this.f37920a.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        com.bytedance.ai.widget.contianer.h r102 = (com.bytedance.ai.widget.contianer.h) r101.next();
        if (r102.f() == true) goto L7;
        ((WidgetContainer) r102).onHide();
        goto L4
    L7:
        ((WidgetContainer) r102).onShow();
        goto L4
    }

    public final void l(com.bytedance.ai.widget.contianer.h r100) {
        WidgetContainer r101 = (WidgetContainer) r100;
        r101.onDestroy();
        r101.onHostDestroy();
        this.f37920a.remove(r101);
        WeakReference<com.bytedance.ai.widget.contianer.h> r102 = this.f37926g;
        if (r102 == null) goto L5;
        com.bytedance.ai.widget.contianer.h r103 = r102.get();
    L7:
        if (Intrinsics.areEqual(r103, r101) == false) goto L10;
        this.f37926g = null;
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final com.bytedance.ai.widget.contianer.h m(Function1<? super com.bytedance.ai.widget.contianer.h, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Iterator<T> r101 = this.f37920a.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        com.bytedance.ai.widget.contianer.h r103 = (com.bytedance.ai.widget.contianer.h) r102;
        Intrinsics.checkNotNull(r103);
        if (r100.invoke(r103).booleanValue() == false) goto L4;
    L10:
        return (com.bytedance.ai.widget.contianer.h) r102;
    L8:
        r102 = null;
        goto L10
    }

    public final com.bytedance.ai.widget.contianer.h n(h5.k r100) {
        ViewGroup r101 = r100.f483842g;
        if (r101 != null) goto L6;
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "findWidgetContainerForContext: parent is null, cardId=" + r100.a(), null);
        return null;
    L6:
        Iterator<T> r103 = this.f37920a.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        Map.Entry r105 = (Map.Entry) r104;
        Intrinsics.checkNotNull(r105);
        b r106 = (b) r105.getValue();
        if (Intrinsics.areEqual(r106.a(), r100.a()) == false) goto L17;
        WeakReference<ViewGroup> r107 = r106.f37930d;
        if (r107 == null) goto L14;
        ViewGroup r108 = r107.get();
    L15:
        if (r108 != r101) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L8;
    L21:
        Map.Entry r110 = (Map.Entry) r104;
        if (r110 != null) goto L24;
        return null;
    L24:
        return (com.bytedance.ai.widget.contianer.h) r110.getKey();
    L14:
        r108 = null;
    L17:
        r109 = false;
        goto L18
    L20:
        r104 = null;
        goto L21
    }

    @Override // l2.a
    public final Object b(h5.k r210, Continuation<? super AppletWidgetContainer> r211) {
        h5.k r100 = r210;
        if ((r211 instanceof WidgetManager$bindWidget$1) == false) goto L7;
        WidgetManager$bindWidget$1 r101 = (WidgetManager$bindWidget$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (h5.k) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L37:
        AppletWidgetContainer r107 = (AppletWidgetContainer) r103;
        JobKt.ensureActive(r101.getContext());
        if (r107 == null) goto L40;
        WidgetBoxView r108 = r107.f37958z;
    L42:
        if (r108 == null) goto L61;
        HashMap<com.bytedance.ai.widget.contianer.h, b> r109 = this.f37920a;
        String r110 = r100.a();
        String r111 = r100.f483838c;
        if (r111 != null) goto L46;
        String r112 = "";
    L47:
        WidgetInfo r113 = r100.f483841f;
        if (r113 == null) goto L50;
        String r114 = r113.getWidgetId();
    L51:
        Integer r115 = Boxing.boxInt(r100.f483844i);
        WidgetInfo r116 = r100.f483841f;
        ViewGroup r117 = r100.f483842g;
        if (r117 == null) goto L54;
        WeakReference r118 = new WeakReference(r117);
    L55:
        r109.put(r107, new b(r110, r112, r114, "", r115, r116, r118));
        Function1<? super com.bytedance.ai.widget.contianer.h, Unit> r119 = new g(this);
        if (r107.f37985u == null) goto L58;
    L60:
        r107.f37985u = r119;
        goto L61
    L58:
        if (((ConcurrentHashMap) r107.f37983s).isEmpty() == false) goto L60;
        r119.invoke(r107);
        goto L60
    L54:
        r118 = null;
        goto L55
    L50:
        r114 = null;
        goto L51
    L46:
        r112 = r111;
    L61:
        WidgetInfo r120 = r100.f483841f;
        if (r120 == null) goto L64;
        String r121 = r120.getMixtureCardId();
    L66:
        if (com.bytedance.ai.utils.f.g(r121) == false) goto L110;
        WidgetInfo r122 = r100.f483841f;
        if (r122 == null) goto L73;
        String r123 = r122.getAppletId();
        if (r123 == null) goto L73;
        String r124 = r123;
    L74:
        WidgetInfo r125 = r100.f483841f;
        if (r125 == null) goto L80;
        String r126 = r125.getWidgetId();
        if (r126 == null) goto L80;
        String r127 = r126;
    L82:
        if (r124.length() <= 0) goto L84;
        boolean r128 = true;
    L85:
        if (r128 == false) goto L110;
        if (r127.length() > 0) goto L90;
        r106 = false;
    L90:
        if (r106 == false) goto L110;
        String r129 = r100.f483836a;
        Keva r130 = com.bytedance.ai.widget.cache.c.f37950a;
        if (Intrinsics.areEqual(r129, com.bytedance.ai.widget.cache.c.f37952c) == false) goto L110;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "bindWidget: last message is mixture, save it");
        String r131 = r100.f483836a;
        String r132 = r100.f483837b;
        if (r132 != null) goto L96;
        String r133 = "";
    L97:
        String r134 = r100.f483840e;
        if (r134 != null) goto L100;
        String r135 = "";
    L101:
        String r136 = r100.b();
        WidgetInfo r137 = r100.f483841f;
        if (r137 == null) goto L104;
        String r138 = r137.getAppType();
    L105:
        WidgetInfo r139 = r100.f483841f;
        if (r139 == null) goto L108;
        String r140 = r139.getVersionTag();
    L109:
        com.bytedance.ai.widget.cache.c.b(new ConversationWidgetData(r124, r127, r131, r135, r133, r136, null, r138, r140, 64, null));
        goto L110
    L108:
        r140 = null;
        goto L109
    L104:
        r138 = null;
        goto L105
    L100:
        r135 = r134;
        goto L101
    L96:
        r133 = r132;
        goto L97
    L84:
        r128 = false;
    L80:
        r127 = "";
    L73:
        r124 = "";
    L110:
        Trace.endSection();
        com.bytedance.ai.applet.base.log.b r141 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r142 = new StringBuilder("bindWidget: render view's width: ");
        if (r108 == null) goto L113;
        Integer r143 = Boxing.boxInt(r108.getWidth());
    L114:
        r142.append(r143);
        r142.append(", height: ");
        if (r108 == null) goto L117;
        Integer r144 = Boxing.boxInt(r108.getHeight());
    L118:
        r142.append(r144);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", r142.toString());
        return r107;
    L117:
        r144 = null;
        goto L118
    L113:
        r143 = null;
        goto L114
    L64:
        r121 = null;
        goto L66
    L40:
        r108 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Trace.beginSection("bindWidget");
        com.bytedance.ai.applet.base.log.b r145 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "bindWidget msgId=" + r100.f483836a + " parent=" + r100.f483842g + " enableCache=" + r100.f483847l);
        if (f37919j == false) goto L21;
        h2.a r146 = f2.b.f475099c;
        if (r146 == null) goto L21;
        Context r147 = r146.f483562a;
        if (r147 == null) goto L21;
        int r148 = AppletLynxViewApi.f36629a;
        Intrinsics.checkNotNullParameter(r147, PerfLog.PARAM_KEY_CONTEXT_ID);
        IIvyAIPackageResourceService.f278317a.e(r147);
    L21:
        WidgetInfo r149 = r100.f483841f;
        if (r149 == null) goto L27;
        List<com.bytedance.ai.widget.a.C0719a> r150 = com.bytedance.ai.widget.a.f37934a;
        String r151 = com.bytedance.ai.widget.a.a(r149.getAppletId(), r149.getWidgetId());
        if (r151 == null) goto L26;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "degradeWidgetIfNeed " + r149.getWidgetId());
        r149 = WidgetInfo.copy$default(r149, null, r151, null, null, null, null, null, null, null, null, null, null, null, null, 16381, null);
    L26:
        r100.f483841f = r149;
    L27:
        WidgetInfo r152 = r100.f483841f;
        if (r152 != null) goto L30;
    L34:
        r101.L$0 = r100;
        r101.label = 1;
        r103 = j(r100, r101);
        if (r103 != r104) goto L37;
        return r104;
    L30:
        if (Intrinsics.areEqual(r152.getAppType(), "1") == false) goto L34;
        String r153 = r152.getAppletId();
        if (r153 == null) goto L34;
        AIManager r154 = AIManager.f37211a;
        AIManager.f(r153);
    L7:
        r101 = new WidgetManager$bindWidget$1(this, r211);
        goto L8
    }

    @Override // l2.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "convId");
        Intrinsics.checkNotNullParameter(r101, "sectionId");
        this.f37922c = r101;
        this.f37921b = r100;
    }

    public final Object j(final h5.k r310, Continuation<? super AppletWidgetContainer> r311) {
        if ((r311 instanceof WidgetManager$createWidgetContainer$1) == false) goto L7;
        WidgetManager$createWidgetContainer$1 r100 = (WidgetManager$createWidgetContainer$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        AppletWidgetContainer r105 = (AppletWidgetContainer) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L93:
        Trace.endSection();
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        WidgetInfo r106 = r310.f483841f;
        String r107 = null;
        if (r106 == null) goto L17;
        String r108 = r106.getAppletId();
    L18:
        String r109 = "";
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        if (r106 == null) goto L23;
        String r110 = r106.getWidgetId();
    L24:
        if (r110 != null) goto L26;
        r110 = "";
    L26:
        if (r106 == null) goto L28;
        String r111 = r106.getMixtureCardId();
    L29:
        if (r111 == null) goto L32;
        r109 = r111;
    L32:
        final PendingWidgetPerformanceTracker r112 = new PendingWidgetPerformanceTracker(r108, r110, r109, 5);
        r112.d();
        Map<String, Object> r113 = r310.f483846k;
        boolean r114 = false;
        if (r113 == null) goto L35;
        boolean r115 = Intrinsics.areEqual(r113.get("hasFirstFeedShow"), Boxing.boxBoolean(false));
    L36:
        if (r115 == false) goto L43;
        Object r116 = r310.f483846k.get("coldStartTime");
        if ((r116 instanceof Long) == false) goto L40;
        Long r117 = (Long) r116;
    L41:
        if (r117 == null) goto L43;
        r117.longValue();
        r112.f34257o = true;
        goto L43
    L40:
        r117 = null;
    L43:
        ViewGroup r118 = r310.f483842g;
        if (r118 == null) goto L47;
        Context r119 = r118.getContext();
        if (r119 == null) goto L47;
    L52:
        i1 r120 = y0.f512051a;
        final String r121 = r310.a();
        final Map<String, Object> r122 = r310.f483846k;
        WidgetInfo r123 = r310.f483841f;
        if (r123 == null) goto L55;
        String r124 = r123.getMixtureCardId();
    L56:
        final boolean r125 = com.bytedance.ai.utils.f.g(r124);
        Intrinsics.checkNotNullParameter(r121, "traceId");
        final long r126 = System.currentTimeMillis();
        y0.r(new u0(r121, r122, r125, r126));
        h2.a r127 = f2.b.f475099c;
        if (r127 != null) goto L59;
    L97:
        r112.c(AppletPerformanceErrorCode.INTERRUPTED, "createWidgetContainer: application is null");
        return null;
    L59:
        if (r127.f483562a == null) goto L97;
        String r128 = r310.f483837b;
        if (r128 != null) goto L64;
    L65:
        r114 = true;
    L66:
        if (r114 == true) goto L95;
        if (r106 == null) goto L69;
        String r129 = r106.getAppletId();
    L70:
        if (r129 == null) goto L95;
        if (r106.getWidgetId() == null) goto L95;
        Trace.beginSection("createWidgetContainer");
        String r130 = r310.f483840e;
        if (r130 != null) goto L77;
        AppletRuntimeManager r131 = AppletRuntimeManager.INSTANCE;
        String r132 = r310.f483837b;
        r131.getClass();
        r130 = AppletRuntimeManager.h(r132);
    L77:
        String r133 = r130;
        l r134 = y0.f512054d;
        if (r134 == null) goto L80;
        r134.a(new m(r310.f483836a, r310.a(), r310.f483839d, r106.getAppletId(), r106.getWidgetId()));
    L80:
        final AppletWidgetContainer r135 = new AppletWidgetContainer(r119);
        Job r136 = (Job) r100.getContext().get(Job.Key);
        if (r136 == null) goto L83;
        r136.invokeOnCompletion(new f(r310, r112, r135));
    L83:
        u r137 = r310.f483843h;
        if (r137 == null) goto L86;
        Intrinsics.checkNotNullParameter(r137, "widgetLifeObserver");
        ((ArrayList) r135.f37969e).add(r137);
    L86:
        com.bytedance.ai.applet.base.log.b r138 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r139 = new StringBuilder("createWidgetContainer widget=");
        r139.append(r135);
        r139.append(" widgetData=");
        WidgetInfo r140 = r310.f483841f;
        if (r140 == null) goto L89;
        r107 = r140.getWidgetData();
    L89:
        r139.append(r107);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", r139.toString());
        r135.f37966b = r310.f483837b;
        AppletRuntimeManager.INSTANCE.getClass();
        r135.f38008a = AppletRuntimeManager.f36750e;
        r135.r(WidgetContainer.LifecycleEvent.ON_START);
        new WeakReference(this.f37924e);
        com.bytedance.ai.widget.contianer.m r141 = new com.bytedance.ai.widget.contianer.m(r106.getAppletId(), r106.getWidgetId(), r106.getWidgetData(), r133, r310.f483836a, r310.f483838c, r310.f483839d, r310.f483845j, r310.f483846k, r106.getMixtureCardId(), r310.f483837b, r310.b(), r310.f483848m, r310.f483849n, r106.getMcpName(), r106.getFullScreenRefresh(), r106.getEntityId(), r106.getVersionTag(), 131072);
        r100.L$0 = r135;
        r100.label = 1;
        if (r135.y(r141, r112, r100) != r103) goto L92;
        return r103;
    L92:
        r105 = r135;
        goto L93
    L69:
        r129 = null;
    L95:
        String r142 = "createWidgetContainer: invalid render context " + r310;
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", r142, null);
        r112.c(AppletPerformanceErrorCode.INTERRUPTED, r142);
        return null;
    L64:
        if (r128.length() != 0) goto L66;
    L55:
        r124 = null;
    L47:
        com.bytedance.ai.applet.base.log.a.d("WidgetManager", "createWidgetContainer: parent is null", null);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r143 = AppletRuntimeManager.f36749d;
        if (r143 == null) goto L99;
        r119 = r143.currentActivity();
        if (r119 != null) goto L52;
    L99:
        com.bytedance.ai.applet.base.log.a.b("WidgetManager", "createWidgetContainer: currentActivity is null", null);
        r112.c(AppletPerformanceErrorCode.INTERRUPTED, "createWidgetContainer: currentActivity is null");
        return null;
    L35:
        r115 = false;
        goto L36
    L28:
        r111 = null;
        goto L29
    L23:
        r110 = null;
        goto L24
    L17:
        r108 = null;
    L7:
        r100 = new WidgetManager$createWidgetContainer$1(this, r311);
        goto L8
    }

    public final Object i(h5.k r110, String r111, String r112, Continuation<? super com.bytedance.ai.widget.contianer.h> r210) {
        h5.k r100 = r110;
        if ((r210 instanceof WidgetManager$buildLoginWidget$1) == false) goto L7;
        WidgetManager$buildLoginWidget$1 r101 = (WidgetManager$buildLoginWidget$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (h5.k) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        AppletWidgetContainer r106 = (AppletWidgetContainer) r103;
        JobKt.ensureActive(r101.getContext());
        ViewGroup r107 = null;
        if (r106 == null) goto L27;
        WidgetBoxView r108 = r106.f37958z;
    L28:
        if (r108 == null) goto L41;
        HashMap<com.bytedance.ai.widget.contianer.h, b> r109 = this.f37920a;
        String r113 = r100.a();
        String r114 = r100.f483838c;
        if (r114 != null) goto L32;
        r114 = "";
    L32:
        String r115 = r114;
        WidgetInfo r116 = r100.f483841f;
        if (r116 == null) goto L35;
        String r117 = r116.getWidgetId();
    L36:
        Integer r118 = Boxing.boxInt(r100.f483844i);
        WidgetInfo r119 = r100.f483841f;
        ViewGroup r120 = r100.f483842g;
        if (r120 == null) goto L39;
        WeakReference r121 = new WeakReference(r120);
    L40:
        r109.put(r106, new b(r113, r115, r117, "", r118, r119, r121));
        goto L41
    L39:
        r121 = null;
        goto L40
    L35:
        r117 = null;
    L41:
        if (r108 == null) goto L47;
        ViewParent r122 = r108.getParent();
        if ((r122 instanceof ViewGroup) == false) goto L45;
        r107 = (ViewGroup) r122;
    L45:
        if (r107 == null) goto L47;
        r107.removeView(r108);
    L47:
        com.bytedance.ai.applet.base.log.b r123 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "buildLoginWidget: widgetContainer to return: " + r106);
        return r106;
    L27:
        r108 = null;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        com.bytedance.ai.applet.base.log.b r124 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("WidgetManager", "buildLoginWidget: applet: " + r111 + ", widget: " + r112);
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "buildLoginWidget: create widget container.");
        WidgetInfo r125 = r100.f483841f;
        if (r125 != null) goto L17;
    L21:
        r101.L$0 = r100;
        r101.label = 1;
        r103 = j(r100, r101);
        if (r103 != r104) goto L24;
        return r104;
    L17:
        if (Intrinsics.areEqual(r125.getAppType(), "1") == false) goto L21;
        String r126 = r125.getAppletId();
        if (r126 == null) goto L21;
        AIManager r127 = AIManager.f37211a;
        AIManager.f(r126);
    L7:
        r101 = new WidgetManager$buildLoginWidget$1(this, r210);
        goto L8
    }
}
