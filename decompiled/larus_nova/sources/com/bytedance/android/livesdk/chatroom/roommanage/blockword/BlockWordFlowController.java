package com.bytedance.android.livesdk.chatroom.roommanage.blockword;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.x;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.FlowLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ita.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import pn1.e;
import pn1.f;
import zg1.i1;

/* JADX INFO: loaded from: classes7.dex */
public final class BlockWordFlowController implements f {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f111287w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f111288x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f111289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f111290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f111291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f111292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowLayout f111293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f111294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EditText f111295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f111296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f111297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f111298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final pn1.a f111299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<Integer, BlockWordItemViewController> f111300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i1 f111301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f111302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final x f111303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f111304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f111305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f111306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f111307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f111308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f111309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f111310v;

    public static final class BlockWordItemViewController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f111311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f111312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f111313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final pn1.a f111314d;

        public final void a(final ef1.a r100) {
            Intrinsics.checkNotNullParameter(r100, "blockWord");
            this.f111311a.setText(r100.a());
            this.f111312b.setOnClickListener(x0.a(new BlockWordFlowController$BlockWordItemViewController$bind$1(this, r100)));
        }

        public BlockWordItemViewController(View r100, pn1.a r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "blockWordPresenter");
            this.f111313c = r100;
            this.f111314d = r101;
            this.f111311a = (TextView) r100.findViewById(R.id.tv_block_word);
            this.f111312b = r100.findViewById(R.id.btn_block_word_delete);
        }
    }

    public static final class a {
    }

    public static final class b implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockWordFlowController f111315a;

        public b(BlockWordFlowController r100) {
            this.f111315a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L23;
            Context r103 = r100.getContext();
            int r104 = i.f495747a;
            if (NetworkUtils.isNetworkAvailable(r103) == true) goto L8;
            f2.b(R.string.ttlive_core_network_unavailable, 0);
            return false;
        L8:
            String r105 = r100.getText().toString();
            if (r105.length() != 0) goto L11;
            boolean r106 = true;
        L12:
            if (r106 == false) goto L14;
        L22:
            f2.b(R.string.ttlive_live_profile_action_error, 0);
            goto L23
        L14:
            if (StringsKt.isBlank(r105) == true) goto L22;
            String r107 = r100.getText().toString();
            if (r107 == null) goto L21;
            String r108 = StringsKt.trim(r107).toString();
            this.f111315a.f111299k.a(r108);
            r100.setText("");
            return true;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L11:
            r106 = false;
        L23:
            return false;
        }
    }

    public static final class c extends d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockWordFlowController f111316a;

        public c(BlockWordFlowController r100) {
            this.f111316a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            this.f111316a.m(r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockWordFlowController f111317a;

        public d(BlockWordFlowController r100) {
            this.f111317a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            i1 r101 = (i1) r100;
            if (r101 == null) goto L22;
            BlockWordFlowController r102 = this.f111317a;
            r102.f111301m = r101;
            boolean r103 = true;
            if (r101.f571850b == true) goto L9;
            r103 = false;
        L9:
            if (r103 == false) goto L16;
            r102.f111294f.setVisibility(0);
            View r104 = r102.f111298j;
            if ((r104 instanceof NestedScrollView) == true) goto L13;
            r104 = null;
        L13:
            NestedScrollView r105 = (NestedScrollView) r104;
            if (r105 == null) goto L18;
            r105.post(new com.bytedance.android.livesdk.chatroom.roommanage.blockword.a(r102));
        L18:
            if (r102.f111310v == false) goto L21;
            r102.h(r103);
            return;
        L21:
            return;
        L16:
            r102.f111294f.setVisibility(8);
            goto L18
        }
    }

    @Override // pn1.f
    public final void c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
    }

    public final void k() {
        this.f111302n = true;
        this.f111303o.b(xs2.b.a().b(i1.class).subscribe(new d(this)));
    }

    static {
        f111287w = UtilityKotlinExtentionsKt.i(484);
        f111288x = UtilityKotlinExtentionsKt.i(354);
    }

    public final void i() {
        pn1.a r100 = this.f111299k;
        Room r101 = r100.f529948f;
        if (r101 == null) goto L9;
        String r102 = r101.getOwnerUserIdString();
        if (r102 == null) goto L10;
        String r103 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().a(r102);
        long r104 = r100.f529948f.f162599id;
        Disposable r105 = r100.f529943a.getBlockWord(r103, r104).compose(RxUtil.rxSchedulerHelper()).subscribe(new pn1.d(r100), new e(r100));
        r100.f529944b.add(r105);
        return;
    L10:
        return;
    }

    public final void j() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.f158238y0;
        if (r102.getValue().booleanValue() == false) goto L12;
        if (r101 == true) goto L12;
        boolean r103 = true;
    L13:
        View r104 = this.f111290b;
        if (r103 == false) goto L16;
        int r105 = 0;
    L17:
        r104.setVisibility(r105);
        com.bytedance.android.livesdk.sharedpref.f.d(r102, Boolean.FALSE);
        this.f111291c.setOnClickListener(x0.a(new BlockWordFlowController$initView$1(this)));
        this.f111293e.setItemSpacing(UtilityKotlinExtentionsKt.i(8));
        this.f111293e.setLineSpacing(UtilityKotlinExtentionsKt.i(12));
        m("");
        this.f111295g.setHint(this.f111289a.getString(R.string.ttlive_blockword_max_tint, new Object[]{10}));
        this.f111295g.setOnEditorActionListener(this.f111306r);
        this.f111295g.setFilters(new com.bytedance.android.livesdk.chatroom.roommanage.blockword.c[]{new com.bytedance.android.livesdk.chatroom.roommanage.blockword.c(this.f111289a.getString(R.string.ttlive_blockword_input_length_prompt))});
        this.f111295g.addTextChangedListener(this.f111307s);
        r3.c(this.f111291c, s1.B(R.string.ttlive_add_transform), true);
        return;
    L16:
        r105 = 8;
    L12:
        r103 = false;
        goto L13
    L5:
        if (r100.isBroadcastMedia() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void l() {
        i1 r100 = this.f111301m;
        if (r100 != null) goto L5;
    L10:
        this.f111302n = false;
        this.f111299k.f529944b.clear();
        this.f111303o.dispose();
        return;
    L5:
        if (r100.f571850b == false) goto L10;
        if (this.f111310v == false) goto L9;
        h(false);
    L9:
        xs2.b.a().post(new i1(r100.f571849a, false));
        goto L10
    }

    @Override // pn1.f
    public final void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        ExceptionUtils.handleException(s1.getContext(), r100, R.string.ttlive_network_error);
    }

    @Override // pn1.f
    public final void d(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if ((r100 instanceof ApiServerException) == true) goto L5;
        return;
    L5:
        switch(((ApiServerException) r100).getErrorCode()) {
            case 80070: goto L10;
            case 80071: goto L9;
            case 80072: goto L8;
            case 80073: goto L7;
            default: goto L6;
        };
    L6:
        String r101 = "other";
    L11:
        ExceptionUtils.handleException(s1.getContext(), r100, R.string.ttlive_network_error);
        LiveRoomManageAppLogger.C(this.f111304p, r101);
        return;
    L7:
        r101 = "existed";
        goto L11
    L8:
        r101 = "lengthy";
        goto L11
    L9:
        r101 = "illegal";
        goto L11
    L10:
        r101 = "limited";
        goto L11
    }

    @Override // pn1.f
    public final void e(ef1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockWord");
        View r101 = LayoutInflater.from(this.f111289a).inflate(R.layout.ttlive_layout_room_block_word, this.f111293e, false);
        BlockWordItemViewController r102 = new BlockWordItemViewController(r101, this.f111299k);
        this.f111293e.addView(r101);
        r102.a(r100);
        this.f111300l.put(Integer.valueOf(r100.b()), r102);
        t2.a(this.f111289a, this.f111295g);
        LiveRoomManageAppLogger.B(this.f111304p, r100.a());
    }

    @Override // pn1.f
    public final void f(ef1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "blockWord");
        BlockWordItemViewController r101 = this.f111300l.get(Integer.valueOf(r100.b()));
        if (r101 == null) goto L9;
        View r102 = r101.f111313c;
        if (r102 == null) goto L10;
        this.f111300l.remove(Integer.valueOf(r100.b()));
        this.f111293e.removeView(r102);
        LiveRoomManageAppLogger.z(this.f111304p, r100.a());
        return;
    L10:
        return;
    }

    @Override // pn1.f
    public final void g(List<ef1.a> r100) {
        Intrinsics.checkNotNullParameter(r100, BitableAnalytic.LocationClickType.WORDS);
        if (this.f111305q == false) goto L5;
        return;
    L5:
        this.f111305q = true;
        Iterator<T> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ef1.a r102 = (ef1.a) r101.next();
        View r103 = LayoutInflater.from(this.f111289a).inflate(R.layout.ttlive_layout_room_block_word, this.f111293e, false);
        BlockWordItemViewController r104 = new BlockWordItemViewController(r103, this.f111299k);
        this.f111293e.addView(r103);
        r104.a(r102);
        this.f111300l.put(Integer.valueOf(r102.b()), r104);
        goto L7
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = f111288x;
    L5:
        ViewParent r102 = this.f111308t.getParent();
    L6:
        ViewPager r103 = null;
        if (r102 == null) goto L12;
        if ((r102 instanceof ViewPager) == true) goto L10;
        r102 = r102.getParent();
        goto L6
    L10:
        ViewPager r104 = (ViewPager) r102;
    L13:
        if (r104 == null) goto L17;
        ViewGroup r105 = UtilityKotlinExtentionsKt.p(r104);
        if (r105 == null) goto L17;
        a1.k(r105, r101);
    L17:
        ViewParent r106 = this.f111308t.getParent();
    L18:
        if (r106 == null) goto L23;
        if ((r106 instanceof ViewPager) == false) goto L22;
        r103 = (ViewPager) r106;
    L22:
        r106 = r106.getParent();
        goto L18
    L23:
        if (r103 == null) goto L31;
        a1.k(r103, r101);
        return;
    L31:
        return;
    L12:
        r104 = null;
        goto L13
    L4:
        r101 = f111287w;
        goto L5
    }

    public final void m(CharSequence r100) {
        if (r100 == null) goto L4;
        int r101 = r100.length();
    L5:
        this.f111296h.setText("(" + r101 + "/10)");
        if (r101 != 10) goto L8;
        this.f111296h.setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        return;
    L8:
        this.f111296h.setTextColor(ColorProtector.parseColor("#3D000000"));
        return;
    L4:
        r101 = 0;
        goto L5
    }

    @Override // pn1.f
    public final void a(int r100, int r101) {
        String r102 = "(" + r100 + '/' + r101 + ')';
        if (this.f111310v == false) goto L5;
        r102 = "已" + s1.B(R.string.ttlive_blockword_setting) + ' ' + r102;
    L5:
        this.f111292d.setText(r102);
        if (r100 < r101) goto L8;
        this.f111297i.setAlpha(0.5f);
        this.f111291c.setEnabled(false);
        return;
    L8:
        this.f111297i.setAlpha(1.0f);
        this.f111291c.setEnabled(true);
    }

    public BlockWordFlowController(View r100, Room r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f111308t = r100;
        this.f111309u = r102;
        this.f111310v = r103;
        this.f111289a = r100.getContext();
        this.f111290b = r100.findViewById(R.id.block_word_red_dot);
        this.f111291c = r100.findViewById(R.id.btn_add_block_word);
        this.f111292d = (TextView) r100.findViewById(R.id.tv_block_word_count);
        this.f111293e = (FlowLayout) r100.findViewById(R.id.block_word_display_area);
        this.f111294f = r100.findViewById(R.id.block_word_input_area);
        this.f111295g = (EditText) r100.findViewById(R.id.block_word_edit_text);
        this.f111296h = (TextView) r100.findViewById(R.id.tv_input_limit);
        this.f111297i = (ImageView) r100.findViewById(R.id.iv_icon);
        this.f111298j = r100.findViewById(R.id.scroll_container);
        this.f111299k = new pn1.a(this, r101);
        this.f111300l = new HashMap();
        this.f111303o = new x();
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L9;
        com.bytedance.live.datacontext.i<Boolean> r105 = r104.isAnchor();
        if (r105 == null) goto L9;
        Boolean r106 = r105.getValue();
        if (r106 == null) goto L9;
        boolean r107 = r106.booleanValue();
    L10:
        this.f111304p = r107;
        this.f111306r = new b(this);
        this.f111307s = new c(this);
        return;
    L9:
        r107 = false;
        goto L10
    }
}
