package com.bytedance.android.gamecp.business.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.business.comment.adapter.CommentReplyListAdapter;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.android.gamecp.business.comment.data.k;
import com.bytedance.android.gamecp.business.comment.data.s;
import com.bytedance.android.gamecp.business.comment.data.t;
import com.bytedance.android.gamecp.business.view.CommonTitleView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.model.GPTrackAction;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/CommentReplyListView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function0;", "", "action", "setOnGoBackClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentReplyListView extends LinearLayout {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f51838t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f51839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f51840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f51841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentReplyListAdapter f51842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f51843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GamePromoteCommentViewModel f51844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f51845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f51846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f51847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f51848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f51849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f51850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f51852n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f51853o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f51854p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f51855q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f51856r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<Unit> f51857s;

    public static final class a {
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListView f51859a;

        public b(CommentReplyListView r100) {
            this.f51859a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f51859a.f51855q = false;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListView f51860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f51861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f51862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f51863d;

        public c(CommentReplyListView r100, Long r101, ArrayList r102, int r103) {
            this.f51860a = r100;
            this.f51861b = r101;
            this.f51862c = r102;
            this.f51863d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            t r111 = (t) ((com.bytedance.android.gamecp.base.network.response.h) r110).data;
            Long r100 = this.f51861b;
            if (r100 == null) goto L5;
            int r101 = (int) r100.longValue();
        L7:
            if (r101 != 1) goto L70;
            this.f51860a.f51854p = r111.hasMore;
            if ((!this.f51862c.isEmpty()) == false) goto L17;
            int r102 = this.f51862c.size() - 1;
            CommentReplyListAdapter r103 = this.f51860a.f51842d;
            if (r103 == null) goto L13;
            k r104 = r103.B2(r102);
        L14:
            if (r104 == null) goto L17;
            r104.f52046d = this.f51860a.f51854p;
            ListProtector.remove(this.f51862c, r102);
            ListProtector.add(this.f51862c, r102, r104);
            goto L17
        L13:
            r104 = null;
        L17:
            if (this.f51860a.f51851m == 0) goto L19;
        L25:
            List<k> r112 = r111.replyList;
            if (r112 != null) goto L28;
        L109:
            CommentReplyListAdapter r113 = this.f51860a.f51842d;
            if (r113 == null) goto L129;
            r113.F2(this.f51862c);
            return;
        L129:
            return;
        L28:
            if ((!r112.isEmpty()) == true) goto L30;
        L32:
            boolean r105 = false;
        L33:
            if (r105 == true) goto L36;
            r112 = null;
        L36:
            if (r112 == null) goto L109;
            this.f51860a.f51851m += r112.size();
            Iterator<k> r114 = r112.iterator();
        L39:
            if (r114.hasNext() == false) goto L109;
            k r106 = r114.next();
            r106.f52043a = 1;
            ArrayList r107 = this.f51862c;
            ListProtector.add(r107, r107.size() - 1, r106);
            List<s> r108 = r106.childReplyList;
            if (r108 != null) goto L43;
        L51:
            s r109 = r106.replyInfo;
            if (r109 == null) goto L54;
            long r115 = r109.childReplyCount;
        L55:
            List<s> r116 = r106.childReplyList;
            if (r116 == null) goto L58;
            int r117 = r116.size();
        L60:
            if (r115 <= r117) goto L39;
            k r118 = new k();
            r118.f52043a = 4;
            r118.f52047e = true;
            r118.replyInfo = r106.replyInfo;
            List<s> r119 = r106.childReplyList;
            if (r119 == null) goto L64;
            int r120 = r119.size();
        L65:
            r118.f52048f = r120;
            List<s> r121 = r106.childReplyList;
            if (r121 == null) goto L68;
            int r122 = r121.size();
        L69:
            r118.f52049g = r122;
            ArrayList r123 = this.f51862c;
            ListProtector.add(r123, r123.size() - 1, r118);
            goto L39
        L68:
            r122 = 0;
            goto L69
        L64:
            r120 = 0;
            goto L65
        L58:
            r117 = 0;
            goto L60
        L54:
            r115 = 0;
            goto L55
        L43:
            if ((!r108.isEmpty()) == true) goto L46;
            r108 = null;
        L46:
            if (r108 == null) goto L51;
            Iterator<s> r124 = r108.iterator();
        L49:
            if (r124.hasNext() == false) goto L51;
            s r125 = r124.next();
            k r126 = new k();
            r126.f52043a = 2;
            r126.replyInfo = r125;
            ArrayList r127 = this.f51862c;
            ListProtector.add(r127, r127.size() - 1, r126);
            goto L49
        L30:
            if (this.f51862c.size() <= 0) goto L32;
            r105 = true;
            goto L33
        L19:
            if (r111.total <= 0) goto L25;
            k r128 = new k();
            r128.f52043a = 3;
            long r129 = r111.total;
            r128.f52045c = r129;
            this.f51860a.f51853o = r129;
            ArrayList r130 = this.f51862c;
            ListProtector.add(r130, r130.size() - 1, r128);
            View r131 = this.f51860a.f51843e;
            if (r131 == null) goto L25;
            TextView r132 = (TextView) r131.findViewById(R.id.tv_comment_detail_title);
            if (r132 == null) goto L25;
            r132.setText(y0.j(R.string.ttlive_game_promote_comment_reply_total, new Object[]{Long.valueOf(r128.f52045c)}));
            goto L25
        L70:
            List<k> r133 = r111.replyList;
            if (r133 == null) goto L109;
            if ((!r133.isEmpty()) == true) goto L75;
        L79:
            boolean r134 = false;
        L80:
            if (r134 == true) goto L83;
            r133 = null;
        L83:
            if (r133 == null) goto L109;
            int r135 = this.f51863d;
            k r136 = (k) ListProtector.get(this.f51862c, r135);
            Iterator<k> r137 = r133.iterator();
        L86:
            if (r137.hasNext() == false) goto L108;
            k r138 = r137.next();
            r138.f52043a = 2;
            if (r136.f52052j == true) goto L89;
            ListProtector.add(this.f51862c, r135, r138);
            r135 = r135 + 1;
            r136.f52048f++;
            goto L86
        L89:
            CommentReplyListView r139 = this.f51860a;
            ArrayList r140 = this.f51862c;
            int r141 = CommentReplyListView.f51838t;
            r139.getClass();
            int r142 = r135 - 1;
            int r143 = r142 - r136.f52048f;
            boolean r144 = false;
            if (r142 < r143) goto L104;
        L91:
            s r145 = r138.replyInfo;
            if (r145 == null) goto L94;
            String r146 = r145.replyId;
        L95:
            s r147 = ((k) ListProtector.get(r140, r142)).replyInfo;
            if (r147 == null) goto L98;
            String r148 = r147.replyId;
        L100:
            if (TextUtils.equals(r146, r148) == false) goto L102;
            r144 = true;
        L102:
            if (r142 == r143) goto L104;
            r142 = r142 - 1;
            goto L91
        L98:
            r148 = null;
            goto L100
        L94:
            r146 = null;
        L104:
            if (r144 == false) goto L105;
            r136.f52048f++;
            goto L86
        L105:
            ListProtector.add(this.f51862c, r135, r138);
            r135 = r135 + 1;
            r136.f52048f++;
            goto L86
        L108:
            r136.f52047e = r111.hasMore;
            r136.f52050h = false;
            goto L109
        L75:
            if (this.f51863d <= 0) goto L79;
            if (this.f51862c.size() <= this.f51863d) goto L79;
            r134 = true;
            goto L80
        L5:
            r101 = 1;
            goto L7
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentReplyListView f51864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f51865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f51866c;

        public d(CommentReplyListView r100, Long r101, ArrayList r102) {
            this.f51864a = r100;
            this.f51865b = r101;
            this.f51866c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Long r102 = this.f51865b;
            if (r102 == null) goto L5;
            int r103 = (int) r102.longValue();
        L6:
            if (r103 != 1) goto L15;
            CommentReplyListView r104 = this.f51864a;
            r104.f51854p = false;
            if (r104.f51851m == 0) goto L10;
            return;
        L10:
            if (this.f51866c.size() <= 0) goto L17;
            ArrayList r105 = this.f51866c;
            ((k) ListProtector.get(r105, r105.size() - 1)).f52046d = false;
            CommentReplyListAdapter r106 = this.f51864a.f51842d;
            if (r106 == null) goto L18;
            r106.F2(this.f51866c);
            return;
        L18:
            return;
        L17:
            return;
        L15:
            return;
        L5:
            r103 = 1;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.comment.CommentReplyListView$setOnGoBackClickListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class C98641 extends Lambda implements Function0<Unit> {
        public static final C98641 INSTANCE = null;

        static {
            INSTANCE = new C98641();
        }

        public C98641() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public CommentReplyListView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentReplyListView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static final void c(final CommentReplyListView r110) {
        r110.getClass();
        int r100 = com.bytedance.android.gamecp.business.comment.data.i.f52041a;
        String r101 = r110.f51846h;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r110.f51847i;
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        GamePromoteCommentViewModel r105 = r110.f51844f;
        if (r105 == null) goto L16;
        String r106 = r105.getAnchorId();
        if (r106 == null) goto L16;
        String r107 = r106;
    L17:
        GamePromoteCommentViewModel r108 = r110.f51844f;
        if (r108 == null) goto L20;
        int r109 = r108.getPromoteScene();
    L21:
        GamePromoteCommentViewModel r111 = r110.f51844f;
        if (r111 == null) goto L24;
        boolean r112 = r111.isPromoter();
    L25:
        GamePromoteCommentViewModel r113 = r110.f51844f;
        if (r113 == null) goto L33;
        com.bytedance.android.gamecp.business.comment.data.j r114 = r113.getSelectedCommentTag();
        if (r114 == null) goto L33;
        String r115 = r114.tagName;
        if (r115 == null) goto L33;
        String r116 = r115;
    L34:
        GamePromoteCommentViewModel r117 = r110.f51844f;
        if (r117 == null) goto L41;
        com.bytedance.android.gamecp.business.comment.data.j r118 = r117.getSelectedCommentTag();
        if (r118 == null) goto L41;
        Long r119 = r118.commentCount;
        if (r119 == null) goto L41;
        long r120 = r119.longValue();
    L42:
        com.bytedance.android.gamecp.business.comment.data.i.e(r102, r104, r107, "first_level", r109, r112, r116, r120);
        final i r121 = new i(r110.getContext());
        String r122 = r110.f51848j;
        if (r122 != null) goto L45;
        String r123 = "";
    L46:
        r121.a("", r123, r110.f51849k, r110.f51845g, "first_level", r110.f51844f);
        Function1<String, Unit> r124 = new CommentReplyListView$showMainCommentReplyDialog$1(r110, r121);
        Intrinsics.checkNotNullParameter(r124, "action");
        ReplyInputView r125 = r121.f52217a;
        if (r125 == null) goto L50;
        r125.setOnSendClickListener(new ReplyInputDialog$setOnSendClickListener$1(r124));
    L50:
        if (DialogLancet.shouldBlockDialogShow(r121) == false) goto L56;
        DialogLancet.handleBlockedDialogShow(r121);
        return;
    L56:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L53:
        DialogLancet.beforeDialogShow(r121);
        r121.show();
        DialogLancet.afterDialogShow(r121);
        return;
    L45:
        r123 = r122;
    L41:
        r120 = 0;
    L33:
        r116 = "";
        goto L34
    L24:
        r112 = false;
        goto L25
    L20:
        r109 = 0;
    L16:
        r107 = "";
        goto L17
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    public final void setOnGoBackClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f51857s = r100;
        ((CommonTitleView) findViewById(R.id.title_comment_reply_list)).setOnBackClickListener(r100);
    }

    public CommentReplyListView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f51839a = new CompositeDisposable();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.gamecp_layout_game_comment_detail, this, true);
        this.f51840b = r103;
        this.f51845g = "";
        this.f51848j = "";
        this.f51850l = 10;
        this.f51852n = 3;
        this.f51854p = true;
        this.f51857s = CommentReplyListView$dismissAction$1.INSTANCE;
        View r104 = r103.findViewById(R.id.cl_comment_detail_reply_flow_title);
        this.f51843e = r104;
        if (r104 == null) goto L7;
        ConstraintLayout r105 = (ConstraintLayout) r104.findViewById(R.id.cl_comment_order);
        if (r105 == null) goto L7;
        UtilityKotlinExtentionsKt.h(r105);
    L7:
        if (r104 == null) goto L9;
        r104.setPadding(y0.b(0.0f), y0.b(15.0f), y0.b(0.0f), y0.b(12.0f));
    L9:
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setBackgroundColor(y0.c(R.color.gamecp_game_FFFFFF));
        RecyclerView r106 = (RecyclerView) r103.findViewById(R.id.rv_comment_detail_reply_list);
        this.f51841c = r106;
        LinearLayoutManager r107 = new LinearLayoutManager(r100);
        r107.setOrientation(1);
        if (r106 == null) goto L12;
        r106.setLayoutManager(r107);
    L12:
        CommentReplyListAdapter r108 = new CommentReplyListAdapter(r100);
        this.f51842d = r108;
        Function8<Integer, String, Integer, Integer, String, Long, String, String, Unit> r109 = new AnonymousClass1(this, r100);
        Intrinsics.checkNotNullParameter(r109, "action");
        r108.f51894d = r109;
        Function1<Integer, Unit> r110 = new AnonymousClass2(this, r100);
        Intrinsics.checkNotNullParameter(r110, "action");
        r108.f51895e = r110;
        Function3<Integer, String, Boolean, Unit> r111 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r111, "action");
        r108.f51898h = r111;
        Function1<Long, Unit> r112 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r112, "action");
        r108.f51897g = r112;
        if (r106 == null) goto L15;
        r106.setAdapter(r108);
    L15:
        if (r106 == null) goto L17;
        r106.addOnScrollListener(new AnonymousClass5(this));
    L17:
        r108.F2(new ArrayList());
        ((ReplyInputView) findViewById(R.id.input_comment_detail_reply)).setOnInputClickListener(new AnonymousClass6(this));
    }

    public static final void b(CommentReplyListView r100, View r101, Long r110) {
        r100.getClass();
        if (r110 == null) goto L6;
        long r102 = r110.longValue();
        HashMap<String, String> r103 = GamecpTracker.f56755a;
        GamecpTracker.n(r101, GPTrackAction.CLICK, MapsKt.mapOf(TuplesKt.to("evaluation_id", String.valueOf(r102))), null, 0.0f, 56);
        return;
    }

    public /* synthetic */ CommentReplyListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void a(CommentReplyListView r110, View r111, String r112, String r113) {
        r110.getClass();
        HashMap<String, String> r114 = GamecpTracker.f56755a;
        GamecpTracker.r(r111, "comment_report", MapsKt.emptyMap(), new g(), false, 112);
        GamecpTracker.n(r111, GPTrackAction.CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("button", r112), TuplesKt.to("evaluation_id", r113)}), null, 0.0f, 56);
    }

    public final void d(String r100, Long r101, String r102, String r110, int r111) {
        if (this.f51855q == false) goto L5;
        return;
    L5:
        this.f51855q = true;
        if (r101 == null) goto L8;
        int r103 = (int) r101.longValue();
    L9:
        if (r103 == 1) goto L11;
    L13:
        ArrayList r104 = new ArrayList();
        CommentReplyListAdapter r105 = this.f51842d;
        k r106 = null;
        if (r105 == null) goto L23;
        ArrayList<k> r107 = r105.f51892b;
        if (r107 == null) goto L23;
        if ((!r107.isEmpty()) == true) goto L21;
        r107 = null;
    L21:
        if (r107 == null) goto L23;
        r104.addAll(r107);
    L23:
        GamePromoteApi r108 = (GamePromoteApi) bs.e.a().b(GamePromoteApi.class);
        if (r101 == null) goto L26;
        int r109 = (int) r101.longValue();
    L27:
        if (r109 != 1) goto L29;
        int r112 = this.f51850l;
        int r113 = this.f51851m;
    L40:
        HashMap r114 = new HashMap();
        r114.put("game_id", String.valueOf(r100));
        r114.put(GXTemplateKey.GAIAX_LAYER, String.valueOf(r101));
        r114.put("count", String.valueOf(r112));
        r114.put("offset", String.valueOf(r113));
        r114.put("eval_id", String.valueOf(r102));
        if (TextUtils.isEmpty(r110) == true) goto L43;
        r114.put("reply_to_comment_id", String.valueOf(r110));
    L43:
        Observable<com.bytedance.android.gamecp.base.network.response.h<t>> r115 = r108.fetchReplyList(r114);
        if (r115 == null) goto L53;
        Observable<com.bytedance.android.gamecp.base.network.response.h<t>> r116 = r115.observeOn(AndroidSchedulers.mainThread());
        if (r116 == null) goto L54;
        Observable<com.bytedance.android.gamecp.base.network.response.h<t>> r117 = r116.doFinally(new b(this));
        if (r117 == null) goto L55;
        Disposable r118 = r117.subscribe(new c(this, r101, r104, r111), new d(this, r101, r104));
        if (r118 == null) goto L56;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r118, this.f51839a);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L29:
        r112 = this.f51852n;
        CommentReplyListAdapter r119 = this.f51842d;
        if (r119 == null) goto L32;
        r106 = r119.B2(r111);
    L32:
        if (r106 == null) goto L35;
        ListProtector.remove(r104, r111);
        ListProtector.add(r104, r111, r106);
    L35:
        if (((k) ListProtector.get(r104, r111)).f52052j == false) goto L39;
        r112 = r112 + 1;
        if (((k) ListProtector.get(r104, r111)).f52048f != ((k) ListProtector.get(r104, r111)).f52049g) goto L39;
        ((k) ListProtector.get(r104, r111)).f52048f = 0;
    L39:
        r113 = ((k) ListProtector.get(r104, r111)).f52048f;
        goto L40
    L26:
        r109 = 1;
        goto L27
    L11:
        if (this.f51854p == true) goto L13;
        return;
    L8:
        r103 = 1;
        goto L9
    }
}
