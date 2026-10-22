package com.bytedance.android.livesdk.widget.ui.subscribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.vip.e;
import com.bytedance.android.live.profit.vip.h;
import com.bytedance.android.live.profit.vip.l;
import com.bytedance.android.live.profit.vip.m;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.event.ISendCommentEvent;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jf2.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import uv2.d;
import uv2.f;
import xs2.b;

/* JADX INFO: loaded from: classes11.dex */
public final class SubscribeSelectPanel extends RelativeLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f162193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f162194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f162195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f162196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiTypeAdapter f162197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f162198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f162199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f162200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f162201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f162202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f162203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f162204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f162205m;

    public static final class a {
    }

    static {
    }

    private final int getHorSpaceOffset() {
        if (this.f162204l != (-1)) goto L6;
        int r100 = (s1.y() - s1.f(32.0f)) - (this.f162200h * s1.f(80.0f));
        int r101 = this.f162200h;
        this.f162204l = r100 / (r101 * (r101 - 1));
    L6:
        return this.f162204l;
    }

    private final RecyclerView.ItemDecoration getItemDecoration() {
        return new AnonymousClass1(this);
    }

    public final String getMessageSource() {
        return this.f162205m;
    }

    public static final /* synthetic */ int b(SubscribeSelectPanel r100) {
        return r100.getHorSpaceOffset();
    }

    private final void setItemsData(h r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
        if (r100.f89134b == 2) goto L7;
        boolean r102 = true;
    L8:
        this.f162201i = r102;
        m r103 = r100.f89139g;
        this.f162203k = r103;
        this.f162202j = r100.f89140h;
        if (r103 == null) goto L16;
        String r104 = r103.f89157a;
        if (r104 == null) goto L16;
        TextView r105 = this.f162194b;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("notMemberTextView");
    L15:
        r105.setText(r104);
    L16:
        m r106 = this.f162203k;
        if (r106 == null) goto L24;
        String r107 = r106.f89159c;
        if (r107 == null) goto L24;
        Button r108 = this.f162195c;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("jumpToSubscribeBtn");
    L23:
        r108.setText(r107);
    L24:
        m r109 = this.f162203k;
        if (r109 == null) goto L33;
        boolean r110 = r109.f89158b;
        Button r111 = this.f162195c;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("jumpToSubscribeBtn");
    L29:
        if (r110 == false) goto L31;
        int r112 = 0;
    L32:
        r111.setVisibility(r112);
        goto L33
    L31:
        r112 = 8;
    L33:
        RelativeLayout r113 = this.f162193a;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("notMemberView");
    L37:
        if (this.f162201i == false) goto L39;
        r101 = 8;
    L39:
        r113.setVisibility(r101);
        MultiTypeAdapter r114 = this.f162197e;
        if (r114 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L42:
        r114.f513437a = r100.f89133a;
        MultiTypeAdapter r115 = this.f162197e;
        if (r115 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L45:
        r115.notifyDataSetChanged();
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // jf2.c
    public final void a(l r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (this.f162198f == null) goto L39;
        com.bytedance.android.live.profit.privilege.a r100 = yt0.c.i();
        if (r100 == null) goto L14;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isInDanmakuMode();
        if (r101 == null) goto L14;
        if (r101.getValue().booleanValue() != true) goto L14;
        f2.b(R.string.ttlive_subscribe_emoji_danmu_send_fail, 0);
        return;
    L14:
        if (this.f162201i == false) goto L16;
        LinkedHashMap r102 = new LinkedHashMap();
        if (r110.f89150d == null) goto L23;
        String r103 = "1";
    L24:
        r102.put("is_exclusive_emoji", r103);
        HashMap r111 = new HashMap();
        String r104 = this.f162205m;
        if (r104 == null) goto L27;
        String r105 = (String) r111.put("message_source", r104);
    L27:
        b r106 = b.a();
        long r107 = r110.f89147a;
        int r108 = (int) r110.f89149c;
        boolean r109 = r110.f89152f;
        ISendCommentEvent.Sender r112 = ISendCommentEvent.Sender.CommentWidget;
        j r113 = this.f162198f;
        if (r113 == null) goto L30;
        Object r114 = r113.g();
    L31:
        r106.post(new c0(r107, r108, r109, r112, r102, r114, r111));
        j r115 = this.f162198f;
        if (r115 == null) goto L38;
        r115.dismissDialog();
        return;
    L38:
        return;
    L30:
        r114 = null;
        goto L31
    L23:
        r103 = "0";
        goto L24
    L16:
        if (this.f162202j == false) goto L18;
        int r116 = R.string.ttlive_emoji_cannot_use;
    L19:
        f2.b(r116, 0);
        return;
    L18:
        r116 = R.string.ttlive_subscribe_emoji_member_send_fail;
        goto L19
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 4;
    L5:
        this.f162200h = r101;
        this.f162193a = (RelativeLayout) findViewById(R.id.subscribe_not_member);
        this.f162194b = (TextView) findViewById(R.id.subscribe_not_member_tv);
        Button r102 = (Button) findViewById(R.id.subscribe_not_member_btn);
        this.f162195c = r102;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("jumpToSubscribeBtn");
    L8:
        r102.setOnClickListener(new f(this));
        this.f162196d = (RecyclerView) findViewById(R.id.subscribe_emoji_list);
        MultiTypeAdapter r103 = new MultiTypeAdapter();
        r103.z2(l.class, new com.bytedance.android.livesdk.viewholder.j(this));
        Unit r104 = Unit.INSTANCE;
        this.f162197e = r103;
        RecyclerView r105 = this.f162196d;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        MultiTypeAdapter r106 = this.f162197e;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L14:
        r105.setAdapter(r106);
        r105.setLayoutManager(new SSGridLayoutManager(r105.getContext(), this.f162200h, 1));
        r105.addItemDecoration(getItemDecoration());
        r105.setHasFixedSize(true);
        com.bytedance.android.live.profit.privilege.a r107 = yt0.c.i();
        e r108 = yt0.c.l();
        if (r108 == null) goto L28;
        com.bytedance.live.datacontext.m<? extends h> r109 = r108.getSubscribeInfo();
        if (r109 == null) goto L28;
        h r110 = r109.getValue();
        if (r110 == null) goto L28;
        MultiTypeAdapter r111 = this.f162197e;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("multiAdapter");
    L24:
        if (r111.f513437a.isEmpty() == false) goto L28;
        if ((!r110.f89133a.isEmpty()) == false) goto L28;
        setItemsData(r110);
    L28:
        if (r108 == null) goto L36;
        com.bytedance.live.datacontext.m<? extends h> r112 = r108.getSubscribeInfo();
        if (r112 == null) goto L36;
        Observable<? extends h> r113 = r112.a();
        if (r113 == null) goto L36;
        Disposable r114 = r113.subscribe(new d(this));
        if (r114 == null) goto L36;
        RxUtilKt.c(r114, this.f162199g);
    L36:
        if (r107 == null) goto L45;
        com.bytedance.live.datacontext.m<Boolean> r115 = r107.isInDanmakuMode();
        if (r115 == null) goto L46;
        Observable<Boolean> r116 = r115.a();
        if (r116 == null) goto L47;
        Disposable r117 = r116.subscribe(new uv2.e(this));
        if (r117 == null) goto L48;
        RxUtilKt.c(r117, this.f162199g);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public final void setOnSubscribeEmojiSendListener(j r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f162198f = r100;
    }

    public SubscribeSelectPanel(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f162205m = r101;
        this.f162199g = new CompositeDisposable();
        this.f162200h = 4;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_subscribe_select_panel, this);
        this.f162204l = -1;
    }

    public static final /* synthetic */ void c(SubscribeSelectPanel r100, h r101) {
        r100.setItemsData(r101);
    }
}
