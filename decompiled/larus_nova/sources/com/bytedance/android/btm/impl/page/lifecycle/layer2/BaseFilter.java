package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.b;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseFilter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f42288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f42289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f42290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f42291g;

    public BaseFilter() {
        this.f42285a = "BaseFilter_onResumed";
        this.f42286b = "BaseFilter_isResumeFiltered";
        this.f42287c = "BaseFilter_onPaused";
        this.f42288d = "BaseFilter_isPauseFiltered";
        this.f42289e = "BaseFilter_onDestroyed";
        this.f42290f = "BaseFilter_pausePrePage";
        this.f42291g = "BaseFilter_onResumedDirectly";
    }

    public final void c(T r100) {
        final String r101 = r100.getClass().getName();
        String r102 = BtmPageRecorder.f42212a;
        PageInfoStack r103 = BtmPageRecorder.k(r100);
        if (r103 == null) goto L6;
        BtmPageLifecycleCallbackV2.c(r100, r103);
        ALogger.f(ALogger.f41996d, this.f42289e, new BaseFilter$onDestroyed$1(r101));
        return;
    }

    public ResumeFilterReason b(T r100, final ResumeFuncOrigin r101) {
        final String r102 = r100.getClass().getName();
        ALogger r103 = ALogger.f41996d;
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$1(r102, r101));
        String r104 = BtmPageRecorder.f42212a;
        PageInfoStack r105 = BtmPageRecorder.k(r100);
        if (r105 == null) goto L44;
        if (r105.getPageState() != BtmPageLifecycle.State.RESUMED) goto L8;
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$2(r102));
        return ResumeFilterReason.PageStateDuplicate;
    L8:
        boolean r106 = b.f42122a;
        if (b.b().isAppBackground() == false) goto L13;
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$3(r102));
        return ResumeFilterReason.AppBackground;
    L13:
        if (CollectionsKt.contains(b.b().i(), d.f42499a.getActivity(r100)) == true) goto L16;
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$4(r102));
        return ResumeFilterReason.NotTopActivity;
    L16:
        final h r107 = PageWoods.a(r100);
        if (r107 != null) goto L19;
    L41:
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$6(r102));
        return null;
    L19:
        if (r107.f42359f == false) goto L41;
        String r108 = r107.f42358e;
        if (r108 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == true) goto L41;
        ALogger.f(r103, this.f42286b, new BaseFilter$isResumeFiltered$5(r102, r107));
        if (BtmSetting.f42469d.c().b().o() != 1) goto L36;
        f<Object> r110 = new f(r100);
        ResumeFuncOrigin r111 = (ResumeFuncOrigin) ((LinkedHashMap) r107.f42364k).get(r110);
        if (r111 != null) goto L33;
    L34:
        r107.f42364k.put(r110, r101);
    L40:
        return ResumeFilterReason.ExecuteActivityResume;
    L33:
        if (r111.isManual() == true) goto L40;
    L36:
        if (r101.isManual() == false) goto L38;
        List<f<Object>> r112 = r107.f42363j;
        ArrayList r113 = (ArrayList) r112;
        r113.add(new f(r100));
        goto L40
    L38:
        List<f<Object>> r114 = r107.f42362i;
        ArrayList r115 = (ArrayList) r114;
        r115.add(new f(r100));
        goto L40
    L23:
        if (r108.length() == 0) goto L26;
        r109 = false;
        goto L27
    L44:
        return ResumeFilterReason.InfoStackNull;
    }

    public final void d(T r100, final PauseFuncOrigin r101) {
        final String r102 = r100.getClass().getName();
        ALogger r103 = ALogger.f41996d;
        ALogger.f(r103, this.f42287c, new BaseFilter$onPaused$1(r102, r101));
        final String r104 = r100.getClass().getName();
        ALogger.f(r103, this.f42288d, new BaseFilter$isPauseFiltered$1(r104, r101));
        String r105 = BtmPageRecorder.f42212a;
        PageInfoStack r106 = BtmPageRecorder.k(r100);
        if (r106 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == false) goto L12;
        ALogger.f(r103, this.f42287c, new BaseFilter$onPaused$2(r102));
        return;
    L12:
        boolean r108 = BtmPageLifecycleCallbackV2.f42312a;
        PageInfoStack r109 = BtmPageRecorder.k(r100);
        if (r109 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        BtmPageLifecycleCallbackV2.d(r100, r109, r101);
        return;
    L5:
        if (r106.getPageState() == BtmPageLifecycle.State.RESUMED) goto L7;
        ALogger.f(r103, this.f42288d, new BaseFilter$isPauseFiltered$2(r104));
        goto L8
    L7:
        ALogger.f(r103, this.f42288d, new BaseFilter$isPauseFiltered$3(r104));
        r107 = false;
        goto L9
    }

    public final ResumeFilterReason e(T r100, ResumeFuncOrigin r101) {
        final String r102 = r100.getClass().getName();
        ALogger r103 = ALogger.f41996d;
        ALogger.f(r103, this.f42285a, new BaseFilter$onResumed$1(r102));
        ResumeFilterReason r104 = b(r100, r101);
        if (r104 == null) goto L5;
        return r104;
    L5:
        f(r100, r101);
        ALogger.f(r103, this.f42285a, new BaseFilter$onResumed$2(r102));
        return null;
    }

    public final void f(T r100, final ResumeFuncOrigin r101) {
        final String r102 = r100.getClass().getName();
        ALogger r103 = ALogger.f41996d;
        ALogger.f(r103, this.f42291g, new BaseFilter$onResumedDirectly$1(r102, r101));
        final String r104 = r100.getClass().getName();
        ALogger.f(r103, this.f42290f, new BaseFilter$pausePrePage$1(r104));
        Object r105 = com.bytedance.android.btm.impl.page.b.f42256b;
        if (r105 == null) goto L11;
        String r106 = BtmPageRecorder.f42212a;
        PageInfoStack r107 = BtmPageRecorder.k(r105);
        if (r107 == null) goto L7;
        BtmPageLifecycle.State r108 = r107.getPageState();
    L9:
        if (r108 != BtmPageLifecycle.State.RESUMED) goto L11;
        boolean r109 = BtmPageLifecycleCallbackV2.f42312a;
        BtmPageLifecycleCallbackV2.d(r105, r107, PauseFuncOrigin.PausePre);
        goto L11
    L7:
        r108 = null;
    L11:
        h r110 = PageWoods.a(r100);
        if (r110 == null) goto L33;
        Iterator<T> r111 = r110.n().iterator();
    L16:
        if (r111.hasNext() == false) goto L33;
        com.bytedance.android.btm.impl.page.model.d r112 = (com.bytedance.android.btm.impl.page.model.d) r111.next();
        if (r112.i() == false) goto L16;
        Object r113 = r112.a();
        if (Intrinsics.areEqual(r113, r100) == true) goto L16;
        String r114 = BtmPageRecorder.f42212a;
        PageInfoStack r115 = BtmPageRecorder.k(r113);
        if (r115 == null) goto L26;
        BtmPageLifecycle.State r116 = r115.getPageState();
    L28:
        if (r116 != BtmPageLifecycle.State.RESUMED) goto L16;
        boolean r117 = BtmPageLifecycleCallbackV2.f42312a;
        if (r113 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        BtmPageLifecycleCallbackV2.d(r113, r115, PauseFuncOrigin.PausePre);
        goto L16
    L26:
        r116 = null;
    L33:
        boolean r118 = BtmPageLifecycleCallbackV2.f42312a;
        String r119 = BtmPageRecorder.f42212a;
        PageInfoStack r120 = BtmPageRecorder.k(r100);
        if (r120 != null) goto L36;
        Intrinsics.throwNpe();
    L36:
        BtmPageLifecycleCallbackV2.e(r100, r120, r101);
    }

    public static void a(Object r100, h r101, BufferBtm r102) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (BtmSetting.f42469d.c().b().L() == 1) goto L7;
        return;
    L7:
        if (r101 == null) goto L9;
        com.bytedance.android.btm.impl.page.model.d r103 = r101.l(r100);
    L10:
        if (r103 != null) goto L12;
        return;
    L12:
        if (r102.getTreeId().length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r103.d(), r102.getTreeId()) == false) goto L24;
        com.bytedance.android.btm.impl.page.model.d r105 = r101.m(r102.getNodeId());
        if ((!Intrinsics.areEqual(r105, r103)) == false) goto L25;
        r103.g(r105);
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r104 = false;
        goto L15
    L9:
        r103 = null;
        goto L10
    }
}
