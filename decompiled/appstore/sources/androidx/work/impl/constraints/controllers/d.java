package androidx.work.impl.constraints.controllers;

import androidx.work.NetworkType;
import androidx.work.i;
import androidx.work.impl.model.o;
import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ConstraintController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5528f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5529g = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f5528f = new a(null);
        String r10 = i.i("NetworkMeteredCtrlr");
        q.f(r10, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        f5529g = r10;
    }

    public d(androidx.work.impl.constraints.trackers.g r10) {
        q.g(r10, "tracker");
        super(r10);
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean a(o r10) {
        q.g(r10, "workSpec");
        if (r10.f5679j.d() != NetworkType.METERED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public /* bridge */ /* synthetic */ boolean b(Object r10) {
        return h((androidx.work.impl.constraints.a) r10);
    }

    public boolean h(androidx.work.impl.constraints.a r10) {
        q.g(r10, CommonKey.KEY_VALUE);
        if (r10.a() == true) goto L5;
    L8:
        return true;
    L5:
        if (r10.b() == false) goto L8;
        return false;
    }
}
