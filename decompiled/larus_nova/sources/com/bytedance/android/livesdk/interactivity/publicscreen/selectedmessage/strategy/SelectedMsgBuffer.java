package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.common.utils.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.SelectedMsgViewManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class SelectedMsgBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f139437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<f<?>> f139438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<f<?>> f139439c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/strategy/SelectedMsgBuffer$DropReason;", "", "OVER_TIME", "BUFFER_SIZE_LIMIT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DropReason extends Enum<DropReason> {
        public static final DropReason BUFFER_SIZE_LIMIT = null;
        public static final DropReason OVER_TIME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DropReason[] f139440a = null;

        static {
            DropReason r100 = new DropReason("OVER_TIME", 0);
            OVER_TIME = r100;
            DropReason r101 = new DropReason("BUFFER_SIZE_LIMIT", 1);
            BUFFER_SIZE_LIMIT = r101;
            f139440a = new DropReason[]{r100, r101};
        }

        public static DropReason valueOf(String r100) {
            return (DropReason) r27.a.a(DropReason.class, r100);
        }

        public static DropReason[] values() {
            return (DropReason[]) f139440a.clone();
        }

        public DropReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a(f<?> r100, DropReason r101);

        void b(f<?> r100, int r101);
    }

    public SelectedMsgBuffer(SelectedMsgViewManager r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedDataSource");
        this.f139437a = new ArrayList();
        this.f139438b = new ArrayDeque();
        this.f139439c = new PriorityQueue(11, new d());
    }

    public final List<f<?>> a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "updateInfo");
        final ArrayList r101 = new ArrayList();
        int r102 = r100.f139455a;
        final Ref.IntRef r103 = new Ref.IntRef();
        r103.element = r102;
        if (r102 <= 0) goto L22;
        Function1<f<?>, Unit> r104 = new SelectedMsgBuffer$pollWithAiMessage$1(r101, r103);
        f<?> r105 = (f) ((PriorityQueue) this.f139439c).poll();
        if (r105 == null) goto L9;
        r104.invoke2(r105);
    L9:
        if (r103.element <= 0) goto L16;
        if ((!((ArrayDeque) this.f139438b).isEmpty()) == false) goto L16;
        f<?> r106 = (f) ((ArrayDeque) this.f139438b).poll();
        if (r106 == null) goto L9;
        r104.invoke2(r106);
    L16:
        if (r103.element <= 0) goto L22;
        if ((!this.f139439c.isEmpty()) == false) goto L22;
        f<?> r107 = (f) ((PriorityQueue) this.f139439c).poll();
        if (r107 == null) goto L16;
        r104.invoke2(r107);
    L22:
        return r101;
    }

    public final void b(f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = SelectedMsgABHelper.b().messageBufferSize;
        k.a(this.f139438b, r101, r100, new SelectedMsgBuffer$push$1(this));
    }
}
