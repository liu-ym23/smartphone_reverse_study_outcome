package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class MessageListScrollManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollState f140862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f140863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f140864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmoothLinearLayoutManager f140865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnonymousClass3 f140866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AnonymousClass4 f140867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f140868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f140869h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IMessageListManager f140870i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f140871j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f140872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RecyclerView f140873l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f140874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f140875n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/messagelist/MessageListScrollManager$ScrollState;", "", "AutoScroll", "Focus", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScrollState extends Enum<ScrollState> {
        public static final ScrollState AutoScroll = null;
        public static final ScrollState Focus = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollState[] f140878a = null;

        static {
            ScrollState r100 = new ScrollState("AutoScroll", 0);
            AutoScroll = r100;
            ScrollState r101 = new ScrollState("Focus", 1);
            Focus = r101;
            f140878a = new ScrollState[]{r100, r101};
        }

        public static ScrollState valueOf(String r100) {
            return (ScrollState) r27.a.a(ScrollState.class, r100);
        }

        public static ScrollState[] values() {
            return (ScrollState[]) f140878a.clone();
        }

        public ScrollState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageListScrollManager f140879a;

        public a(MessageListScrollManager r100) {
            this.f140879a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101.getAction() == 1) goto L5;
            return false;
        L5:
            if (this.f140879a.f140873l.canScrollVertically(1) == true) goto L7;
            this.f140879a.e(ScrollState.AutoScroll);
            return false;
        L7:
            this.f140879a.e(ScrollState.Focus);
            MessageListScrollManager.a(this.f140879a);
            return false;
        }
    }

    public static final class b {
    }

    static {
    }

    public static final void a(MessageListScrollManager r100) {
        int r101 = r100.f140865d.findLastVisibleItemPosition();
        if (r101 <= r100.f140863b) goto L13;
        IMessageListManager r102 = r100.f140870i;
        if (r102 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r103 = r102.getConfig();
        if (r103 == null) goto L11;
        l r104 = r103.b();
        if (r104 == null) goto L11;
        r104.a(Math.max(r104.f140895a - (r101 - r100.f140863b), 0));
    L11:
        r100.d(r101);
        return;
    }

    public final void c(boolean r100) {
        if (r100 == true) goto L4;
        e(ScrollState.Focus);
    L4:
        if (r100 == true) goto L6;
        return;
    L6:
        if (this.f140872k == false) goto L10;
        this.f140873l.addOnScrollListener(this.f140866e);
        this.f140873l.setOnFlingListener(this.f140867f);
        this.f140873l.setOnTouchListener(this.f140868g);
        this.f140872k = false;
        return;
    }

    public final void d(int r100) {
        this.f140863b = Math.max(r100, 0);
    }

    public final void e(ScrollState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r101 = h.f140888a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f140862a = r100;
        IMessageListManager r102 = this.f140870i;
        if (r102 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r103 = r102.getConfig();
        if (r103 == null) goto L21;
        l r104 = r103.b();
        if (r104 == null) goto L21;
        r104.f140901g = false;
        r104.a(0);
    L21:
        RecyclerView.Adapter r105 = this.f140873l.getAdapter();
        if (r105 == null) goto L29;
        int r106 = r105.getItemCount() - 1;
        this.f140873l.scrollToPosition(r106);
        d(r106);
        return;
    L29:
        return;
    L5:
        if (r101 != 2) goto L30;
        this.f140862a = r100;
        IMessageListManager r107 = this.f140870i;
        if (r107 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.messagelist.b r108 = r107.getConfig();
        if (r108 == null) goto L26;
        l r109 = r108.b();
        if (r109 == null) goto L27;
        r109.f140901g = true;
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onEvent(IMessageListManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IMessageListManager.MessageChangeType r101 = r100.getType();
        int r102 = h.f140889b[r101.ordinal()];
        if (r102 != 1) goto L5;
        int r103 = r100.f140854b;
        int r104 = this.f140863b;
        if (r103 > r104) goto L20;
        d(r104 + 1);
        return;
    L20:
        return;
    L5:
        if (r102 != 2) goto L21;
        int r105 = this.f140863b;
        int r106 = r100.f140856d;
        if (r105 < r106) goto L10;
        d(r105 - (r106 - r100.f140855c));
        return;
    L10:
        int r107 = r100.f140855c;
        if (r105 < r107) goto L18;
        d(r107);
        return;
    L18:
        return;
    }

    public static final void b(MessageListScrollManager r100, int r101) {
        if (r101 < 300) goto L6;
        r100.getClass();
        r100.e(ScrollState.AutoScroll);
    L6:
        if (r101 > 0) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L37:
        r100.f140874m.setVisibility(8);
        r100.f140875n.setText("");
        return;
    L14:
        if (r100.f140864c == false) goto L16;
        boolean r103 = true;
    L28:
        if ((!r103) == true) goto L37;
        TextView r104 = r100.f140875n;
        Object[] r105 = new Object[1];
        if (r101 > 99) goto L33;
        String r106 = String.valueOf(r101);
    L34:
        r105[0] = r106;
        r104.setText(s1.C(R.string.ttlive_auto_scroll_message_list_hint, r105));
        if (r100.f140874m.getVisibility() == 0) goto L42;
        MainThreadPostUtils.b(new k(r100));
        return;
    L42:
        return;
    L33:
        r106 = "99+";
        goto L34
    L16:
        int r107 = r100.f140865d.getItemCount();
        int r108 = 0;
        int r109 = 0;
    L17:
        if (r108 >= r107) goto L23;
        View r110 = r100.f140865d.findViewByPosition(r108);
        if (r110 == null) goto L21;
        r109 = (r109 + r110.getHeight()) + m.f140902g;
    L21:
        r108 = r108 + 1;
        goto L17
    L23:
        if (r109 < r100.f140873l.getHeight()) goto L25;
        r103 = true;
    L26:
        r100.f140864c = r103;
        goto L28
    L25:
        r103 = false;
        goto L26
    L8:
        if (r100.f140862a == ScrollState.AutoScroll) goto L11;
        r102 = false;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.bytedance.android.livesdk.interactivity.service.messagelist.MessageListScrollManager$3] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.bytedance.android.livesdk.interactivity.service.messagelist.MessageListScrollManager$4] */
    public MessageListScrollManager(RecyclerView r100, View r101, TextView r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "hintLayout");
        Intrinsics.checkNotNullParameter(r102, "hintTextView");
        this.f140873l = r100;
        this.f140874m = r101;
        this.f140875n = r102;
        this.f140862a = ScrollState.Focus;
        this.f140871j = true;
        this.f140872k = true;
        r101.setOnClickListener(x0.a(new AnonymousClass1(this)));
        SmoothLinearLayoutManager r104 = new SmoothLinearLayoutManager(r100.getContext());
        r104.p(r103);
        Unit r105 = Unit.INSTANCE;
        this.f140865d = r104;
        this.f140866e = new AnonymousClass3(this);
        this.f140867f = new AnonymousClass4(this);
        this.f140868g = new a(this);
        r100.setItemAnimator(null);
        r100.setLayoutManager(r104);
    }
}
