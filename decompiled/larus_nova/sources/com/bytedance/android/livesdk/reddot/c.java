package com.bytedance.android.livesdk.reddot;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import j40.l4;
import j40.m4;
import j40.n4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<com.bytedance.android.livesdk.reddot.d> f157089a = null;

    public static final class a implements com.bytedance.android.livesdk.reddot.d {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.reddot.d
        public final boolean a(RedDotDelegate r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "redDotDelegate");
            if (3 == r100.b().getType()) goto L6;
            return true;
        L6:
            if (CollectionUtils.isEmpty(r100.f157077c) == true) goto L8;
            TreeSet<RedDotDelegate> r102 = r100.f157077c;
            if (r102 == null) goto L21;
            Iterator<T> r103 = r102.iterator();
        L16:
            if (r103.hasNext() == false) goto L21;
            RedDotDelegate r104 = (RedDotDelegate) r103.next();
            if (r104.a(false) == false) goto L16;
            ALogger.i("RedDotStrategy", r104 + " - child red show!");
            return true;
        L21:
            ALogger.i("RedDotStrategy", r100 + " - no child dot");
            return false;
        L8:
            if (3 != r100.b().getType()) goto L26;
            return false;
        L26:
            return true;
        }
    }

    public static final class b implements com.bytedance.android.livesdk.reddot.d {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.reddot.d
        public final boolean a(RedDotDelegate r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "redDotDelegate");
            com.bytedance.android.livesdk.reddot.a r102 = r100.f157075a;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("redDot");
        L5:
            int r103 = r102.getType();
            boolean r104 = false;
            if (r103 == 0) goto L14;
            if (r103 != 1) goto L9;
        L13:
            r104 = r100.c().getValue().booleanValue();
        L31:
            boolean r105 = !r104;
            if (r105 == true) goto L34;
            ALogger.i("RedDotStrategy", r100 + "-local");
        L34:
            return r105;
        L9:
            if (r103 == 2) goto L13;
            if (r103 == 3) goto L31;
        L30:
            r104 = true;
            goto L31
        L14:
            Integer r106 = l4.f497259a.getValue();
            if (r106 == null) goto L21;
            if (r106.intValue() != 0) goto L21;
            r104 = r100.c().getValue().booleanValue();
        L21:
            if (r100.c().getValue().booleanValue() == true) goto L30;
            com.bytedance.android.livesdk.sharedpref.e<Integer> r107 = r100.f157079e;
            if (r107 == null) goto L27;
            Integer r108 = r107.getValue();
            if (r108 == null) goto L27;
            int r109 = r108.intValue();
        L29:
            if (r109 < r106.intValue()) goto L31;
        L27:
            r109 = 0;
            goto L29
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.reddot.c$c, reason: collision with other inner class name */
    public static final class C2401c implements com.bytedance.android.livesdk.reddot.d {
        public C2401c() {
        }

        @Override // com.bytedance.android.livesdk.reddot.d
        public final boolean a(RedDotDelegate r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "redDotDelegate");
            if (r101 == false) goto L5;
            return true;
        L5:
            TreeSet<RedDotDelegate> r102 = r100.f157076b;
            if (r102 == null) goto L23;
            Iterator<T> r103 = r102.iterator();
            int r104 = 0;
        L9:
            if (r103.hasNext() == false) goto L23;
            RedDotDelegate r105 = (RedDotDelegate) r103.next();
            if (Intrinsics.areEqual(r105, r100) == true) goto L23;
            if (Intrinsics.areEqual(r105.b(), r100.b()) == true) goto L23;
            if (r105.a(true) == true) goto L19;
            if (r105.f157080f == false) goto L9;
        L19:
            r104 = r104 + 1;
            if (r104 < 3) goto L9;
            ALogger.i("RedDotStrategy", r100 + "-PanelLimit");
            return false;
        L23:
            return true;
        }
    }

    public static final class d implements com.bytedance.android.livesdk.reddot.d {
        public d() {
        }

        @Override // com.bytedance.android.livesdk.reddot.d
        public final boolean a(RedDotDelegate r100, boolean r110) {
            Intrinsics.checkNotNullParameter(r100, "redDotDelegate");
            boolean r101 = true;
            if (r100.b().f157087e != (-1)) goto L6;
            return true;
        L6:
            if (3 != r100.b().getType()) goto L8;
            return true;
        L8:
            int r111 = com.bytedance.android.livesdk.paas.c.b();
            boolean r102 = e.f157090a;
            Context r103 = s1.getContext();
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (e.f157092c == false) goto L19;
            if (e.f157090a == false) goto L13;
        L17:
            boolean r104 = e.f157091b;
        L22:
            if (r104 == false) goto L24;
            Integer r105 = n4.f497271a.getValue();
        L26:
            if (((r111 / 10) - r100.b().f157087e) < r105.intValue()) goto L29;
            r101 = false;
        L29:
            if (r101 == true) goto L31;
            ALogger.i("RedDotStrategy", r100 + "-version");
        L31:
            return r101;
        L24:
            r105 = m4.f497265a.getValue();
            goto L26
        L13:
            if (e.a(r103) != e.b(r103)) goto L15;
            boolean r106 = true;
        L16:
            e.f157091b = r106;
            e.f157090a = true;
            goto L17
        L15:
            r106 = false;
            goto L16
        L19:
            if (e.a(r103) != e.b(r103)) goto L21;
            r104 = true;
            goto L22
        L21:
            r104 = false;
            goto L22
        }
    }

    static {
        b r100 = new b();
        C2401c r101 = new C2401c();
        d r102 = new d();
        a r103 = new a();
        ArrayList<com.bytedance.android.livesdk.reddot.d> r104 = new ArrayList();
        r104.add(r102);
        r104.add(r100);
        r104.add(r101);
        r104.add(r103);
        f157089a = r104;
    }
}
