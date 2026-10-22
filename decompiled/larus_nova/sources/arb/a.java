package arb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16068b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f16069a;

    /* JADX INFO: renamed from: arb.a$a, reason: collision with other inner class name */
    public static final class C0215a implements b {
        public C0215a() {
        }

        @Override // arb.b
        public final void V(Object r100, String r101) {
        }

        @Override // arb.b
        public final void W() {
        }

        @Override // arb.b
        public final boolean X() {
            return false;
        }

        @Override // arb.b
        public final void Y(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "botId");
        }

        @Override // arb.b
        public final void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r100, IItemContainer r101) {
            Intrinsics.checkNotNullParameter(r100, "binderMap");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        }

        @Override // arb.b
        public final String a0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "defaultName");
            return "";
        }

        @Override // arb.b
        public final void b0() {
        }

        @Override // arb.b
        public final void c0(Object r100, String r101, ChatAtModel.a r102) {
        }

        @Override // arb.b
        public final void d0(boolean r100) {
        }

        @Override // arb.b
        public final Drawable e0(Context r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }
    }

    static {
        f16068b = new a();
    }

    @Override // arb.b
    public final void V(Object r100, String r101) {
        this.f16069a.V(r100, r101);
    }

    @Override // arb.b
    public final void W() {
        this.f16069a.W();
    }

    @Override // arb.b
    public final boolean X() {
        return this.f16069a.X();
    }

    @Override // arb.b
    public final void Y(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f16069a.Y(r100, r101);
    }

    @Override // arb.b
    public final void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r100, IItemContainer r101) {
        Intrinsics.checkNotNullParameter(r100, "binderMap");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f16069a.Z(r100, r101);
    }

    @Override // arb.b
    public final String a0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultName");
        return this.f16069a.a0(r100);
    }

    @Override // arb.b
    public final void b0() {
        this.f16069a.b0();
    }

    @Override // arb.b
    public final void c0(Object r100, String r101, ChatAtModel.a r102) {
        this.f16069a.c0(r100, r101, r102);
    }

    @Override // arb.b
    public final void d0(boolean r100) {
        this.f16069a.d0(r100);
    }

    @Override // arb.b
    public final Drawable e0(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f16069a.e0(r100, r101);
    }

    public a() {
        b r100 = (b) ApiUtils.getApi(b.class);
        if (r100 != null) goto L5;
        r100 = new C0215a();
    L5:
        this.f16069a = r100;
    }
}
