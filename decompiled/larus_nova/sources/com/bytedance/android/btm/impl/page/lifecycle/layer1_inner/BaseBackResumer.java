package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class BaseBackResumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f42267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResumeFuncOrigin f42268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f42269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42270d;

    public static Set a(Set r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        String r105 = BtmPageRecorder.f42212a;
        PageInfo r106 = BtmPageRecorder.j(r104);
        if (r106 == null) goto L4;
        if (r106.getStep() > r103) goto L9;
        if (r106.getStep() != r103) goto L4;
        r101.add(r104);
        goto L4
    L9:
        r103 = r106.getStep();
        r101.clear();
        r101.add(r104);
        goto L4
    L13:
        return r101;
    }

    public static Set d(Set r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        String r104 = BtmPageRecorder.f42212a;
        PageInfoStack r105 = BtmPageRecorder.k(r103);
        if (r105 == null) goto L8;
        BtmPageLifecycle.State r106 = r105.getPageState();
    L10:
        if (r106 != BtmPageLifecycle.State.CREATED) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r106 = null;
        goto L10
    L12:
        return r101;
    }

    public final boolean i(h r100) {
        ALogger.e(ALogger.f41996d, "BaseBackResumer_tryResumeTopPage", new BaseBackResumer$tryResumeTopPage$1(this));
        d r101 = r100.m(r100.f42358e);
        if (r101 == null) goto L5;
        Object r102 = r101.a();
    L6:
        if (r102 == null) goto L11;
        String r103 = FilterDispatcher.f42296a;
        if (FilterDispatcher.e(r102, this.f42268b) != null) goto L13;
        return true;
    L13:
        return false;
    L11:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public static Set f(h r100, Set r101) {
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if ((r104 instanceof Dialog) == true) goto L7;
        if ((r104 instanceof DialogFragment) == true) goto L11;
        if ((r104 instanceof Fragment) == true) goto L14;
        boolean r105 = r104 instanceof Activity;
        goto L4
    L14:
        r102.add(r104);
        goto L4
    L11:
        r102.add(r104);
        goto L4
    L7:
        r102.clear();
        r102.add(r104);
        return r102;
    L16:
        LinkedHashSet r106 = new LinkedHashSet();
        r106.addAll(r102);
        Iterator r107 = r102.iterator();
    L18:
        if (r107.hasNext() == false) goto L29;
        Object r108 = r107.next();
        if (r100 == null) goto L22;
        d r109 = r100.l(r108);
    L23:
        if (r109 == null) goto L18;
        d r110 = r109.getParentNode();
        if (r110 == null) goto L27;
        Object r111 = r110.a();
    L28:
        TypeIntrinsics.asMutableCollection(r106).remove(r111);
        r109 = r109.getParentNode();
        goto L23
    L27:
        r111 = null;
        goto L28
    L22:
        r109 = null;
        goto L23
    L29:
        return r106;
    }

    public static void g(Object r100, h r101) {
        Map<f<Object>, ResumeFuncOrigin> r102 = r101.f42364k;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        ResumeFuncOrigin r104 = (ResumeFuncOrigin) r103.get(new f(r100));
        if (r104 == null) goto L6;
        FilterDispatcher.f(r100, r104);
        return;
    }

    public final void c(Activity r100, final String r101) {
        final String r102 = r100.getClass().getName();
        String r103 = BtmPageRecorder.f42212a;
        PageInfo r104 = BtmPageRecorder.j(r100);
        final String r105 = "null";
        if (r104 == null) goto L7;
        final String r106 = r104.getPageBtm();
        if (r106 == null) goto L7;
    L8:
        if (r104 == null) goto L12;
        String r107 = r104.getBtmPre();
        if (r107 == null) goto L12;
        r105 = r107;
    L12:
        g.a.a(BtmMonitor.f42161c, this.f42270d, r102, null, new BaseBackResumer$monitorZero$1(r102, r106, r105, r101), 28);
        return;
    L7:
        r106 = "null";
        goto L8
    }

    public void e(Activity r100, final h r110) {
        ALogger.e(ALogger.f41996d, this.f42267a, BaseBackResumer$onActivityPostResumed$1.INSTANCE);
        new LinkedHashSet();
        HashSet r101 = new HashSet(((r110.f42364k.size() * 4) / 3) + 1);
        Iterator r102 = ((LinkedHashMap) r110.f42364k).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        T r104 = ((f) r103.getKey()).get();
        if (r104 == 0) goto L4;
        String r105 = FilterDispatcher.f42296a;
        if (FilterDispatcher.a(r104, (ResumeFuncOrigin) r103.getValue()) != null) goto L4;
        r101.add(r104);
        goto L4
    L10:
        final int r106 = r101.size();
        ALogger r107 = ALogger.f41996d;
        ALogger.e(r107, this.f42267a, new BaseBackResumer$onActivityPostResumed$2$1(r106));
        if (r106 != 0) goto L14;
        c(r100, "filter");
        return;
    L14:
        if (r106 != 1) goto L17;
        g(CollectionsKt.last(r101), r110);
        return;
    L17:
        Set r108 = f(r110, r101);
        final int r109 = r108.size();
        ALogger.e(r107, this.f42267a, new BaseBackResumer$onActivityPostResumed$3$1(r109));
        if (r109 != 0) goto L21;
        c(r100, "removeParent");
        return;
    L21:
        if (r109 != 1) goto L24;
        g(CollectionsKt.last(r108), r110);
        return;
    L24:
        Set r111 = d(r108);
        final int r112 = r111.size();
        ALogger.e(r107, this.f42267a, new BaseBackResumer$onActivityPostResumed$4$1(r112));
        if (r112 == 0) goto L30;
        if (r112 != 1) goto L29;
        g(CollectionsKt.last(r111), r110);
        return;
    L29:
        r108 = r111;
    L30:
        LinkedHashSet r113 = new LinkedHashSet();
        Iterator r114 = r108.iterator();
    L32:
        if (r114.hasNext() == false) goto L38;
        Object r115 = r114.next();
        ResumeFuncOrigin r116 = (ResumeFuncOrigin) ((LinkedHashMap) r110.f42364k).get(new f(r115));
        if (r116 == null) goto L32;
        if (r116.isManual() != true) goto L32;
        r113.add(r115);
        goto L32
    L38:
        final int r117 = r113.size();
        ALogger r118 = ALogger.f41996d;
        ALogger.e(r118, this.f42267a, new BaseBackResumer$onActivityPostResumed$5$1(r117));
        if (r117 == 0) goto L44;
        if (r117 != 1) goto L43;
        g(CollectionsKt.last(r113), r110);
        return;
    L43:
        r108 = r113;
    L44:
        ALogger.e(r118, this.f42267a, new BaseBackResumer$onActivityPostResumed$6(r110));
        d r119 = r110.m(r110.f42358e);
        if (r119 == null) goto L64;
        Object r120 = r119.a();
        if (r120 != null) goto L49;
    L52:
        final Ref.IntRef r121 = new Ref.IntRef();
        r121.element = 1;
        d r122 = r119.j();
    L53:
        if (r122 == null) goto L64;
        if (r121.element > 3) goto L64;
        Object r123 = r122.a();
        if (r123 == null) goto L63;
        if (r108.contains(r123) == false) goto L63;
        ALogger.e(ALogger.f41996d, this.f42267a, new BaseBackResumer$onActivityPostResumed$8(r121));
        g(r123, r110);
        return;
    L63:
        r122 = r122.j();
        r121.element++;
        goto L53
    L49:
        if (r108.contains(r120) == false) goto L52;
        ALogger.e(r118, this.f42267a, BaseBackResumer$onActivityPostResumed$7.INSTANCE);
        g(r120, r110);
        return;
    L64:
        Set r124 = a(r108);
        final int r125 = r124.size();
        ALogger r126 = ALogger.f41996d;
        ALogger.e(r126, this.f42267a, new BaseBackResumer$onActivityPostResumed$9$1(r125));
        if (r125 != 0) goto L68;
        c(r100, "largeStep");
        return;
    L68:
        if (r125 != 1) goto L71;
        String r127 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r124), this.f42268b);
        return;
    L71:
        ALogger.e(r126, this.f42267a, BaseBackResumer$onActivityPostResumed$10.INSTANCE);
        g(CollectionsKt.last(r124), r110);
        b(this, r100, r124);
    }

    public final boolean h(Activity r100, h r101) {
        ALogger.e(ALogger.f41996d, "BaseBackResumer_tryResumeManualPages", new BaseBackResumer$tryResumeManualPages$1(this));
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = ((ArrayList) r101.f42363j).iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        T r104 = ((f) r103.next()).get();
        if (r104 == 0) goto L4;
        String r105 = FilterDispatcher.f42296a;
        if (FilterDispatcher.a(r104, this.f42268b) != null) goto L4;
        r102.add(r104);
        goto L4
    L11:
        if (r102.size() != 1) goto L15;
        String r106 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r102), this.f42268b);
        return true;
    L15:
        if (r102.size() <= 1) goto L18;
        String r107 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r102), this.f42268b);
        b(this, r100, r102);
        return true;
    L18:
        return false;
    }

    public final boolean j(Activity r100, h r101) {
        ALogger.e(ALogger.f41996d, "BaseBackResumer_tryResumeUnManualPages", new BaseBackResumer$tryResumeUnManualPages$1(this));
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = ((ArrayList) r101.f42362i).iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        T r104 = ((f) r103.next()).get();
        if (r104 == 0) goto L4;
        String r105 = FilterDispatcher.f42296a;
        if (FilterDispatcher.a(r104, this.f42268b) != null) goto L4;
        r102.add(r104);
        goto L4
    L11:
        if (r102.size() != 1) goto L15;
        String r106 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r102), this.f42268b);
        return true;
    L15:
        if (r102.size() <= 1) goto L24;
        Set r107 = f(r101, r102);
        if (r107.size() != 1) goto L21;
        String r108 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r107), this.f42268b);
        return true;
    L21:
        if (r107.size() <= 1) goto L33;
        String r109 = FilterDispatcher.f42296a;
        FilterDispatcher.f(CollectionsKt.last(r107), this.f42268b);
        b(this, r100, r107);
        return true;
    L33:
        return false;
    L24:
        return false;
    }

    public BaseBackResumer(ResumeFuncOrigin r100, int r101, int r102) {
        this.f42268b = r100;
        this.f42269c = r101;
        this.f42270d = r102;
        this.f42267a = "BaseBackResumer_resume_new";
    }

    public static void b(BaseBackResumer r100, Activity r101, Set r110) {
        r100.getClass();
        final ArrayList r102 = new ArrayList();
        Iterator r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        Object r103 = r111.next();
        String r104 = BtmPageRecorder.f42212a;
        r102.add(BtmPageRecorder.j(r103));
        goto L4
    L6:
        final String r105 = r101.getClass().getName();
        Lazy r112 = BtmMonitor.f42159a;
        final String r106 = "";
        BtmMonitor.j(r100.f42269c, null, null, new BaseBackResumer$monitorMulti$2(r102), new BaseBackResumer$monitorMulti$3(r105, r106), null, 182);
    }
}
