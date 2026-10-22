package cb8;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.FrozenTrackNode;
import com.larus.bmhome.block.holder.content.lynx.IvyPluginViewPool;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.interceptor.ErrorEnum;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.bmhome.utils.z1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class t1 extends bd8.b implements bd8.d {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public Message H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ExpandCardViewMode f23066J;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final of8.l f23067l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f23068m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f23069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ExpandCardViewMode f23070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public hk9.a f23071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f23073r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f23074s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<Integer, Drawable> f23075t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<Integer, Drawable> f23076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f23077v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f23078w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f23079x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.a0 f23080y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f23081z;

    @Override // bd8.b
    public final void C() {
        this.f23073r = false;
        this.f23074s = false;
        this.H = null;
        this.I = -1;
        this.f23068m = false;
        hk9.a r100 = this.f23071p;
        if (r100 == null) goto L5;
        r100.setBackground(null);
    L5:
        this.f23070o = ExpandCardViewMode.NORMAL;
        ((LinkedHashMap) this.f23075t).clear();
        ((LinkedHashMap) this.f23076u).clear();
        hk9.a r101 = this.f23071p;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        hk9.a r102 = this.f23071p;
        if (r102 == null) goto L11;
        ExposeXTrackerExtKt.e(r102);
    L11:
        this.f23072q = false;
    }

    @Override // bd8.b
    public final void E() {
        z2.f365865a.w3();
    }

    public final de8.c K() {
        return (de8.c) this.B.getValue();
    }

    public final com.larus.bmhome.chat.component.cvs.y L() {
        return (com.larus.bmhome.chat.component.cvs.y) this.f23081z.getValue();
    }

    public final va8.p M() {
        return (va8.p) this.E.getValue();
    }

    public final u7 N() {
        return (u7) this.f23079x.getValue();
    }

    @Override // bd8.b
    public final void z() {
        Message r100 = this.H;
        if (r100 == null) goto L8;
        com.larus.bmhome.chat.api.a0 r101 = this.f23080y;
        if (r101 == null) goto L9;
        r101.a(r100, this.f18691c, this.f18693e);
        return;
    L9:
        return;
    }

    public final Integer O() {
        de8.c r100 = K();
        if (r100 == null) goto L6;
        Integer r101 = r100.m();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Object r102 = (RecyclerView.Adapter) this.f23077v.getValue();
        if ((r102 instanceof ry8.d) == false) goto L9;
        ry8.d r103 = (ry8.d) r102;
    L10:
        if (r103 == null) goto L13;
        return r103.r2();
    L13:
        return null;
    L9:
        r103 = null;
        goto L10
    }

    public t1(of8.l r100) {
        Intrinsics.checkNotNullParameter(r100, "blockLongClickHandler");
        super(false, 10);
        this.f23067l = r100;
        ExpandCardViewMode r101 = ExpandCardViewMode.NORMAL;
        this.f23070o = r101;
        this.f23075t = new LinkedHashMap();
        this.f23076u = new LinkedHashMap();
        this.f23077v = LazyKt.lazy(new m0(this));
        this.f23078w = LazyKt.lazy(new o0(this));
        this.f23079x = LazyKt.lazy(new p0(this));
        this.f23080y = ILegacyChatUiServiceDelegate.f297164b.r8();
        this.f23081z = LazyKt.lazy(new q0(this));
        this.A = LazyKt.lazy(new r0(this));
        this.B = LazyKt.lazy(new s0(this));
        this.C = LazyKt.lazy(new t0(this));
        this.D = LazyKt.lazy(new v0(this));
        this.E = LazyKt.lazy(new w0(this));
        this.F = LazyKt.lazy(new x0(this));
        this.G = LazyKt.lazy(new n0(this));
        this.I = -1;
        this.f23066J = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int J(Message r110) {
        Context r100 = getContext();
        int r101 = 0;
        boolean r102 = false;
        r102 = false;
        r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        com.larus.bmhome.chat.layout.widget.handler.w r103 = com.larus.bmhome.chat.layout.widget.handler.w.f305213a;
        com.larus.bmhome.chat.layout.item.i r104 = this.f18692d;
        Integer r105 = null;
        if (r104 == null) goto L8;
        Integer r106 = Integer.valueOf(r104.getBoxType());
    L9:
        de8.c r107 = K();
        if (r107 == null) goto L12;
        Integer r108 = r107.m();
    L14:
        if (r108 == null) goto L16;
        boolean r109 = true;
    L17:
        Boolean r111 = Boolean.valueOf(r109);
        IChatMessageShareAbility r112 = (IChatMessageShareAbility) this.f23078w.getValue();
        if (r112 != null) goto L20;
    L22:
        boolean r113 = false;
    L23:
        Fragment r114 = this.f18691c;
        if ((r114 instanceof xe8.a) == false) goto L26;
        xe8.a r115 = (xe8.a) r114;
    L27:
        if (r115 == null) goto L33;
        ChatBubbleParams r116 = r115.Mz();
        if (r116 == null) goto L33;
        if (r116.f296840a != true) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L47;
        Lazy r118 = z1.f315157a;
        com.larus.bmhome.chat.layout.item.i r119 = this.f18692d;
        if (r119 == null) goto L47;
        int r120 = r119.getBoxType();
        de8.c r121 = K();
        if (r121 == null) goto L40;
        r105 = r121.m();
    L40:
        IChatMessageShareAbility r122 = (IChatMessageShareAbility) this.f23078w.getValue();
        if (r122 != null) goto L43;
    L45:
        r101 = z1.g(r120, r105, r102, com.larus.bmhome.chat.bean.d.J0(r110), Integer.valueOf(z1.e(this.f18691c)));
        goto L47
    L43:
        if (r122.H1() != true) goto L45;
        r102 = true;
    L47:
        return com.larus.bmhome.chat.layout.widget.handler.w.c(r103, r100, r110, r106, r111, r113, false, Integer.valueOf(r101), this.f18692d, 32);
    L33:
        r117 = false;
        goto L34
    L26:
        r115 = null;
        goto L27
    L20:
        if (r112.H1() != true) goto L22;
        r113 = true;
        goto L23
    L16:
        r109 = false;
        goto L17
    L12:
        r108 = null;
        goto L14
    L8:
        r106 = null;
        goto L9
    }

    public final void P(int r110) {
        boolean r100 = true;
        if (this.f23073r == false) goto L54;
    L35:
        hk9.a r101 = this.f23071p;
        if (r101 == null) goto L57;
        Message r102 = this.H;
        Drawable r103 = null;
        if (r102 == null) goto L46;
        Regex r104 = com.larus.bmhome.chat.bean.d.f297444a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Map<String, String> r105 = r102.getBusinessExt();
        if (r105 == null) goto L42;
        String r106 = r105.get("show_dash_border");
    L44:
        if (Intrinsics.areEqual(r106, "1") != true) goto L46;
    L47:
        if (r100 == true) goto L49;
    L52:
        r101.setBackground(r103);
        return;
    L49:
        if (((LinkedHashMap) this.f23076u).get(Integer.valueOf(r110)) != null) goto L51;
        Map<Integer, Drawable> r107 = this.f23076u;
        Integer r108 = Integer.valueOf(r110);
        GradientDrawable r109 = new GradientDrawable();
        r109.setShape(0);
        r109.setCornerRadius(r110);
        r109.setColor(0);
        r109.setStroke(c7.b(Float.valueOf(1.5f)), ContextCompat.getColor(r101.getContext(), v19.c.b(R.attr.larus_neutral_transparent_2, r101.getContext(), R.color.larus_neutral_transparent_2)), c7.c(3), c7.c(3));
        r107.put(r108, r109);
    L51:
        r103 = (Drawable) ((LinkedHashMap) this.f23076u).get(Integer.valueOf(r110));
        goto L52
    L42:
        r106 = null;
    L46:
        r100 = false;
        goto L47
    L57:
        return;
    L54:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L12
        BaseCompositeTextCell<?> r112 = this.f18694f;     // Catch: Throwable -> L12
        if (r112 != null) goto L7;
    L9:
        boolean r113 = false;
    L10:
        Object r114 = Result.m9449constructorimpl(Boolean.valueOf(r113));     // Catch: Throwable -> L12
    L14:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r114) == false) goto L18;
        r114 = r115;
    L18:
        if (((Boolean) r114).booleanValue() == true) goto L20;
    L22:
        boolean r116 = false;
    L23:
        if (r116 == true) goto L35;
        hk9.a r117 = this.f23071p;
        if (r117 != null) goto L28;
        return;
    L28:
        if (((LinkedHashMap) this.f23075t).get(Integer.valueOf(r110)) != null) goto L33;
        Drawable r118 = com.larus.utils.e1.j(r117, c7.c(Integer.valueOf(r110)), v19.c.b(R.attr.larus_base_2_overlay, r117.getContext(), R.color.larus_base_2_overlay));
        IFlowThemeConfigProvider r119 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r119 == null) goto L32;
        ThemeConfigScene r120 = ThemeConfigScene.CHAT;
        ThemeColorKey r121 = ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r122 = AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE;
        boolean r123 = v19.h.f552477a;
        r119.g(r118, r121, r120, r122, Boolean.valueOf(v19.h.b(r117.getContext())));
    L32:
        this.f23075t.put(Integer.valueOf(r110), r118);
    L33:
        r117.setBackground((Drawable) ((LinkedHashMap) this.f23075t).get(Integer.valueOf(r110)));
        return;
    L20:
        if (z2.f365865a.getObricWindowMessageBubbleConfig().getEnable() == false) goto L22;
        r116 = true;
        goto L23
    L7:
        if (s1a.a.e(r112.e()) != true) goto L9;
        r113 = true;
    L12:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean Q(Message r100) {
        if (O() == null) goto L43;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.im.bean.message.a.b0(r100) == true) goto L8;
    L34:
        boolean r101 = false;
    L35:
        if (r101 == false) goto L44;
        return true;
    L44:
        return false;
    L8:
        if (r100.getContentType() == 8) goto L34;
        if (r100.getContentType() == 100) goto L34;
        if ((!((ArrayList) com.larus.im.bean.message.a.R(r100)).isEmpty()) == true) goto L34;
        ArrayList r102 = (ArrayList) com.larus.im.bean.message.a.A(r100);
        if (r102.isEmpty() == true) goto L34;
        if (r102.isEmpty() == true) goto L33;
        Iterator r103 = r102.iterator();
    L23:
        if (r103.hasNext() == false) goto L33;
        Block r104 = (Block) r103.next();
        if (r104.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L27;
    L30:
        boolean r105 = true;
    L31:
        if (r105 == true) goto L23;
    L27:
        if (r104.getBlockType() == BlockType.BLOCK_TYPE_LOADING.getValue()) goto L30;
        r105 = false;
    L33:
        r101 = true;
        goto L35
    L43:
        return false;
    }

    @Override // bd8.d
    public final JSONObject m(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "message");
        JSONObject r101 = new JSONObject();
        u1.c(r100, r101, this.f23071p);
        return r101;
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [cb8.n] */
    /* JADX WARN: Type inference failed for: r14v4, types: [cb8.a0] */
    /* JADX WARN: Type inference failed for: r15v11, types: [cb8.b0] */
    /* JADX WARN: Type inference failed for: r4v16, types: [cb8.z] */
    /* JADX WARN: Type inference failed for: r5v0, types: [cb8.f] */
    /* JADX WARN: Type inference failed for: r5v24, types: [cb8.z0] */
    /* JADX WARN: Type inference failed for: r6v2, types: [cb8.r] */
    /* JADX WARN: Type inference failed for: r6v8, types: [cb8.a1] */
    @Override // bd8.b
    public final void w(Message r410, int r411, ec8.b r412) {
        Intrinsics.checkNotNullParameter(r410, "message");
        com.larus.bmhome.chat.layout.item.i r100 = this.f18692d;
        if ((r100 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L5;
        com.larus.bmhome.chat.layout.item.l r101 = (com.larus.bmhome.chat.layout.item.l) r100;
    L6:
        if (r101 == null) goto L8;
        r101.setOnLongClickListener(new y0(this));
    L8:
        Intrinsics.checkNotNullParameter(r410, "message");
        Message r102 = this.H;
        if (r102 == null) goto L11;
        String r103 = r102.getMessageId();
    L13:
        if (Intrinsics.areEqual(r103, r410.getMessageId()) == true) goto L15;
        this.f23073r = false;
        this.f23074s = false;
    L15:
        this.H = r410;
        if (this.f23072q == true) goto L20;
        hk9.a r104 = this.f23071p;
        if (r104 == null) goto L20;
        ExposeXTrackerExtKt.b(r104, new c(this));
        this.f23072q = true;
    L20:
        this.I = r411;
        va8.t r105 = (va8.t) this.A.getValue();
        if (r105 == null) goto L23;
        boolean r106 = r105.H1();
    L24:
        boolean r107 = com.larus.bmhome.chat.bean.d.J0(r410);
        Lazy r108 = z1.f315157a;
        com.larus.bmhome.chat.layout.item.i r109 = this.f18692d;
        if (r109 == null) goto L27;
        int r110 = r109.getBoxType();
    L28:
        com.larus.bmhome.chat.layout.item.i r111 = this.f18692d;
        if (r111 == null) goto L31;
        Integer r112 = r111.getImmerseBgColor();
    L32:
        boolean r113 = z1.b(r110, r112);
        if (r113 != true) goto L41;
        if (r106 == false) goto L37;
        if (r107 == true) goto L37;
        ExpandCardViewMode r114 = ExpandCardViewMode.EXPAND_SHARE;
    L49:
        this.f23066J = r114;
        if (com.larus.bmhome.chat.bean.d.Q0(r410) == false) goto L52;
    L55:
        boolean r115 = true;
    L56:
        Intrinsics.checkNotNullParameter(r410, "<this>");
        if (com.larus.im.bean.message.a.b0(r410) == false) goto L80;
        Intrinsics.checkNotNullParameter(r410, "<this>");
        List r116 = vd9.r.a(r410);
        if ((r116 instanceof Collection) == true) goto L62;
    L64:
        Iterator r117 = r116.iterator();
    L66:
        if (r117.hasNext() == false) goto L80;
        BlockContent r118 = ((Block) r117.next()).getContent();
        if (r118 == null) goto L77;
        SearchRichMediaBlock r119 = r118.getRichMediaBlock();
        if (r119 == null) goto L77;
        Integer r120 = r119.scene;
        if (r120 == null) goto L77;
        if (r120.intValue() != 2) goto L77;
        boolean r121 = true;
    L78:
        if (r121 == false) goto L66;
        boolean r122 = true;
    L81:
        if (r122 == false) goto L98;
        com.larus.bmhome.chat.layout.item.i r123 = this.f18692d;
        if ((r123 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L85;
        com.larus.bmhome.chat.layout.item.l r124 = (com.larus.bmhome.chat.layout.item.l) r123;
    L86:
        if (r124 == null) goto L88;
        r124.setupDisableBoxBackground(true);
    L88:
        com.larus.bmhome.chat.layout.item.i r125 = this.f18692d;
        if ((r125 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L91;
        com.larus.bmhome.chat.layout.item.l r126 = (com.larus.bmhome.chat.layout.item.l) r125;
    L92:
        if (r126 == null) goto L94;
        r126.setupDisableUpdateBoxWidth(true);
    L94:
        this.f23073r = true;
        P(0);
        hk9.a r127 = this.f23071p;
        if (r127 == null) goto L139;
        r127.setPadding(0, 0, 0, 0);
    L139:
        hk9.a r128 = this.f23071p;
        if (r128 == null) goto L146;
        int r129 = J(r410);
        com.larus.bmhome.chat.layout.item.i r130 = this.f18692d;
        if (r130 == null) goto L144;
        int r131 = r130.getMaxWidth();
    L145:
        r128.b(cd8.a.class, new cd8.a(r129, r131));
        goto L146
    L144:
        r131 = -1;
    L146:
        ug8.g r132 = ug8.g.f550040a;
        Intrinsics.checkNotNullParameter(r410, "message");
        ug8.h r133 = ug8.g.f550047h;
        if (r133 != null) goto L352;
        Message r134 = r410;
    L160:
        List<Block> r135 = com.larus.im.bean.message.a.f(r134);
        ArrayList r136 = new ArrayList();
        Iterator<T> r137 = r135.iterator();
    L162:
        if (r137.hasNext() == false) goto L166;
        Object r138 = r137.next();
        if (com.larus.bmhome.clarification.w.a((Block) r138) == true) goto L162;
        r136.add(r138);
        goto L162
    L166:
        po8.p r139 = u1.a(this);
        if (r139 == null) goto L169;
        DeepThinkFoldStatus r140 = r139.getDeepThinkFoldStatus();
    L170:
        Lazy r141 = qg8.b.f532877a;
        com.larus.bmhome.chat.api.q0 r142 = this.f18693e;
        IChatMessageShareAbility r143 = (IChatMessageShareAbility) this.f23078w.getValue();
        u7 r144 = N();
        com.larus.bmhome.chat.component.collection.o r145 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r145 != null) goto L173;
    L175:
        boolean r146 = false;
    L176:
        DeepThinkFoldStatus r147 = qg8.b.d(r134, r142, r143, r144, r146);
        if (r140 == null) goto L180;
        if (r140 == r147) goto L180;
        boolean r148 = true;
    L181:
        if (r148 == false) goto L184;
    L202:
        boolean r149 = true;
    L204:
        hk9.a r150 = this.f23071p;
        if (r150 == null) goto L338;
        kc8.n0 r151 = new kc8.n0(new kc8.m0(new n(this), new f(this)), new kc8.o0(J(r134), new r(this)));
        boolean r152 = Q(r134);
        int r153 = kc8.v0.f502580p;
        kc8.v0.a r154 = new kc8.v0.a();
        r154.f502603h = new d0(this);
        r154.f502596a = Boolean.valueOf(r152);
        r154.f502598c = false;
        r154.f502600e = Boolean.FALSE;
        r154.f502605j = new f0(this);
        r154.f502606k = new g0(this);
        if (r152 == false) goto L209;
        RectF r155 = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    L210:
        r154.f502602g = r155;
        r154.f502607l = new jh8.a(new h0(this));
        kc8.v0 r156 = r154.a();
        int r157 = kc8.y.f502619J;
        kc8.y.a r158 = new kc8.y.a();
        r158.f502653h = new i0(this);
        r158.f502654i = new k0(this);
        r158.f502655j = new l0(this);
        r158.f502656k = new y(this);
        r158.f502657l = new j0(this);
        r158.f502658m = new u0(this);
        Message r413 = r134;
        r158.f502659n = new kc8.j(new f1(this), new i1(this), new j1(this), new k1(this), new l1(this), new d(this), new e(this), new g(this), new h(this), new i(this), new j(this), new k(this), new l(this));
        com.larus.bmhome.chat.layout.item.i r159 = this.f18692d;
        if (r159 == null) goto L213;
        Integer r160 = Integer.valueOf(r159.getBoxType());
    L214:
        r158.f502664s = r160;
        va8.p r161 = M();
        if (r161 == null) goto L219;
        Fragment r162 = r161.M();
        if (r162 == null) goto L219;
        FrozenTrackNode r163 = by7.h.d(r162);
    L220:
        r158.f502651f = r163;
        r158.A = this.f18693e;
        va8.p r164 = M();
        if (r164 == null) goto L223;
        RecyclerView r165 = r164.Ly();
    L224:
        r158.f502652g = r165;
        r158.f502671z = (RecyclerView.Adapter) this.f23077v.getValue();
        r158.f502650e = Long.valueOf(de8.d.a(K()));
        r158.f502666u = O();
        com.larus.bmhome.chat.component.collection.o r166 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r166 == null) goto L227;
        Boolean r167 = Boolean.valueOf(r166.i0());
    L228:
        r158.f502662q = r167;
        IChatMessageShareAbility r168 = (IChatMessageShareAbility) this.f23078w.getValue();
        if (r168 == null) goto L231;
        Boolean r169 = Boolean.valueOf(r168.H1());
    L232:
        r158.f502663r = r169;
        r158.f502660o = new m(this);
        r158.f502661p = new o(this);
        r158.f502668w = Integer.valueOf(r411);
        com.larus.bmhome.chat.api.q0 r170 = this.f18693e;
        if (r170 == null) goto L235;
        com.larus.bmhome.chat.api.q0.a r171 = r170.getProvider();
    L236:
        r158.f502669x = r171;
        r158.f502670y = (AttachReceiver) this.f18697i.getValue();
        com.larus.bmhome.chat.api.q0 r172 = this.f18693e;
        if (r172 == null) goto L240;
        LruSet<String> r173 = r172.E7();
        if (r173 == null) goto L240;
    L241:
        r158.B = r173;
        com.larus.bmhome.chat.layout.item.i r174 = this.f18692d;
        if (r174 == null) goto L244;
        Boolean r175 = Boolean.valueOf(r174.getUseSubscribedColor());
    L245:
        r158.f502665t = r175;
        r158.f502667v = new p();
        r158.f502649d = new q(this);
        r158.f502646a = new s(this);
        r158.f502648c = new t(this);
        r158.C = this.f18691c;
        Function2<? super Integer, ? super Integer, Unit> r176 = new u(this);
        Intrinsics.checkNotNullParameter(r176, "value");
        r158.E = r176;
        r158.f502647b = new v(this);
        Function4<? super Integer, ? super Integer, ? super Interpolator, ? super Integer, Unit> r177 = new w(this);
        Intrinsics.checkNotNullParameter(r177, "value");
        r158.F = r177;
        r158.G = new x(this);
        r158.D = this.f23067l;
        final kc8.y r178 = r158.a();
        int r179 = kc8.b.f502424y;
        kc8.b.a r180 = new kc8.b.a();
        r180.f502450b = r178;
        r180.f502455g = new kc8.x(Integer.valueOf(android.R.color.transparent));
        r180.f502458j = new kc8.p(null);
        IChatMessageShareAbility r181 = (IChatMessageShareAbility) this.f23078w.getValue();
        if (r181 != null) goto L248;
    L250:
        boolean r182 = false;
    L251:
        if (r182 == true) goto L287;
        Regex r183 = com.larus.bmhome.chat.bean.d.f297444a;
        Message r184 = r413;
        Intrinsics.checkNotNullParameter(r184, "<this>");
        Map<String, String> r185 = r184.getExt();
        if (r185 == null) goto L257;
        String r186 = r185.get("source_share");
        if (r186 == null) goto L257;
        boolean r187 = com.larus.utils.o0.d(r186);
    L258:
        if (r187 == false) goto L261;
    L288:
        boolean r188 = true;
    L289:
        r180.f502471w = new kc8.v(Boolean.valueOf(r188));
        r180.f502452d = r151;
        r180.f502449a = r156;
        r180.f502453e = new kc8.k0(this.f23066J, 14);
        r180.f502454f = new kc8.t0(this.f23066J);
        com.larus.bmhome.chat.api.q0 r189 = this.f18693e;
        if (r189 == null) goto L292;
        final com.larus.bmhome.chat.api.q0.a r190 = r189.getProvider();
    L293:
        if (r190 == null) goto L295;
        com.larus.bmhome.chat.component.cvs.y r191 = r190.u0();
    L296:
        com.larus.bmhome.chat.api.q0 r192 = this.f18693e;
        if (r192 == null) goto L301;
        Function0<Fragment> r193 = r192.getHostFragment();
        if (r193 == null) goto L301;
        Fragment r210 = r193.invoke();
    L303:
        if (r191 == null) goto L305;
        n1 r211 = new n1(r191);
    L306:
        ?? r194 = new z0(r190);
        if (r190 == null) goto L309;
        LifecycleCoroutineScope r212 = r190.F9();
    L310:
        if (r190 == null) goto L314;
        qd8.b r195 = r190.H9();
        if (r195 == null) goto L314;
        o1 r213 = new o1(r195);
    L315:
        if (r190 == null) goto L319;
        zd8.b r196 = r190.P9();
        if (r196 == null) goto L319;
        p1 r214 = new p1(r196);
    L320:
        ?? r197 = new a1(this);
        if (r190 == null) goto L323;
        q1 r215 = new q1(r190);
    L324:
        if (r190 == null) goto L326;
        r1 r310 = new r1(r190, this);
    L327:
        r180.f502460l = new kc8.q(r210, null, r211, r194, r212, r213, r214, r197, r215, r310, this.f18693e, null, 4102);
        com.larus.bmhome.chat.component.collection.o r198 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r198 == null) goto L332;
        boolean r199 = true;
        if (r198.i0() != true) goto L332;
    L333:
        r180.f502463o = new kc8.u0(Boolean.valueOf(r199), new b1(this));
        eh8.c r200 = (eh8.c) bd8.c.a(this, eh8.c.class);
        if (r200 == null) goto L336;
        IvyPluginViewPool r201 = r200.Yy();
    L337:
        r180.f502465q = new kc8.h0(r201, new d1(this));
        r180.f502466r = new kc8.i(new c1(this));
        r180.f502467s = new kc8.l0(new z(this), 2);
        r180.f502468t = new kc8.x0(null, null, null, new a0(this), new b0(this), 7);
        r180.f502469u = new kc8.m(false, new c0(this), 2);
        r180.f502470v = new kc8.w0(ToolBlockInteractType.OpenFloatingPage, ToolBlockInitStatus.Fold, new com.larus.bmhome.block.presentation.a(this.f18691c, new e0(r178)));
        r150.b(kc8.b.class, r180.a());
    L339:
        hk9.a r202 = this.f23071p;
        if (r202 == null) goto L342;
        int r203 = ra8.a.f536852a;
        ra8.a.d(r202, r136, new kc8.f(r184, null, false, true, new s1(this), null, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_RANGE_SIZE), r149);
    L342:
        com.larus.bmhome.chat.api.a0 r204 = this.f23080y;
        if (r204 == null) goto L346;
        r204.a(r410, this.f18691c, this.f18693e);
    L346:
        this.f23068m = r115;
        this.f23069n = com.larus.bmhome.chat.bean.d.j0(r410);
        this.f23070o = this.f23066J;
        return;
    L336:
        r201 = null;
    L332:
        r199 = false;
        goto L333
    L326:
        r310 = null;
        goto L327
    L323:
        r215 = null;
    L319:
        r214 = null;
    L314:
        r213 = null;
        goto L315
    L309:
        r212 = null;
        goto L310
    L305:
        r211 = null;
    L301:
        r210 = null;
        goto L303
    L295:
        r191 = null;
        goto L296
    L292:
        r190 = null;
        goto L293
    L261:
        if (com.larus.platform.service.p1.f365785a.j() == false) goto L288;
        String r205 = r184.getSectionId();
        com.larus.bmhome.chat.component.cvs.y r206 = L();
        if (r206 == null) goto L268;
        wc9.e r207 = r206.h();
        if (r207 == null) goto L268;
        String r208 = r207.B;
    L270:
        if (Intrinsics.areEqual(r205, r208) == false) goto L288;
        u7 r209 = N();
        if (r209 == null) goto L286;
        List<Message> r216 = r209.zj();
        if (r216 == null) goto L286;
        Iterator<T> r217 = r216.iterator();
    L279:
        if (r217.hasNext() == false) goto L286;
        Message r218 = (Message) r217.next();
        if (Intrinsics.areEqual(r218.getMessageId(), r184.getMessageId()) == true) goto L286;
        if (com.larus.bmhome.chat.bean.d.G0(r218) == false) goto L279;
    L286:
        r188 = false;
    L268:
        r208 = null;
    L257:
        r187 = false;
        goto L258
    L287:
        r184 = r413;
        goto L288
    L248:
        if (r181.H1() != true) goto L250;
        r182 = true;
        goto L251
    L244:
        r175 = null;
    L240:
        r173 = new LruSet(1);
        goto L241
    L235:
        r171 = null;
        goto L236
    L231:
        r169 = null;
        goto L232
    L227:
        r167 = null;
        goto L228
    L223:
        r165 = null;
    L219:
        r163 = null;
        goto L220
    L213:
        r160 = null;
        goto L214
    L209:
        r155 = new RectF(c7.b(16), c7.b(12), c7.b(16), c7.b(12));
        goto L210
    L338:
        r184 = r134;
        goto L339
    L184:
        if (this.f23068m != r115) goto L202;
        if (this.f23070o != this.f23066J) goto L202;
        if (this.f23069n != com.larus.bmhome.chat.bean.d.j0(r134)) goto L202;
        CopyOnWriteArraySet<String> r219 = com.larus.bmhome.chat.markdown.imagegroup.c.f307050a;
        String r220 = r134.getMessageId();
        String r1100 = "";
        if (r220 != null) goto L196;
        r220 = "";
    L196:
        if (com.larus.bmhome.chat.markdown.imagegroup.c.a(r220) == false) goto L203;
        String r221 = r134.getMessageId();
        if (r221 == null) goto L201;
        r1100 = r221;
    L201:
        Intrinsics.checkNotNullParameter(r1100, "forceRefreshId");
        com.larus.bmhome.chat.markdown.imagegroup.c.f307050a.remove(r1100);
        goto L202
    L203:
        r149 = false;
    L180:
        r148 = false;
        goto L181
    L173:
        if (r145.i0() != true) goto L175;
        r146 = true;
        goto L176
    L169:
        r140 = null;
        goto L170
    L352:
        Pair<Message, ErrorEnum> r222 = r133.b(r410);     // Catch: Exception -> L156
        Message r223 = r222.component1();     // Catch: Exception -> L156
        if (r222.component2() != null) goto L350;
        r223 = r410;
    L159:
        r134 = r223;
        goto L160
    L350:
        ug8.g.c(r410);     // Catch: Exception -> L153
    L153:
        e = e;
    L158:
        FLogger.f375446a.e("MarkdownRenderInterceptorManager", "render message error, current latest message id : " + ug8.g.f550048i + ' ', e);
    L156:
        e = e;
        r223 = r410;
        goto L158
    L91:
        r126 = null;
        goto L92
    L85:
        r124 = null;
        goto L86
    L98:
        if (of8.j.a(r410) == false) goto L108;
        com.larus.bmhome.chat.layout.item.i r224 = this.f18692d;
        if ((r224 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L102;
        com.larus.bmhome.chat.layout.item.l r225 = (com.larus.bmhome.chat.layout.item.l) r224;
    L103:
        if (r225 == null) goto L105;
        r225.setupDisableBoxBackground(true);
    L105:
        this.f23073r = true;
        P(0);
        hk9.a r226 = this.f23071p;
        if (r226 == null) goto L139;
        r226.setPadding(0, 0, 0, 0);
        goto L139
    L102:
        r225 = null;
        goto L103
    L108:
        boolean r227 = Q(r410);
        Intrinsics.checkNotNullParameter(r410, "<this>");
        Map<String, String> r1101 = r410.getBusinessExt();
        if (r1101 == null) goto L111;
        String r1102 = r1101.get("show_dash_border");
    L112:
        boolean r1103 = Intrinsics.areEqual(r1102, "1");
        com.larus.bmhome.chat.layout.item.i r1104 = this.f18692d;
        if ((r1104 instanceof com.larus.bmhome.chat.layout.item.l) == false) goto L115;
        com.larus.bmhome.chat.layout.item.l r1105 = (com.larus.bmhome.chat.layout.item.l) r1104;
    L116:
        if (r1105 == null) goto L118;
        r1105.setupDisableBoxBackground(r1103);
    L118:
        if (r227 == true) goto L122;
        if (r1103 == true) goto L122;
        boolean r1106 = false;
    L123:
        this.f23073r = r1106;
        if (r227 == false) goto L126;
        int r1107 = 0;
    L127:
        P(r1107);
        if (r227 == false) goto L132;
        hk9.a r228 = this.f23071p;
        if (r228 == null) goto L139;
        r228.setPadding(0, 0, 0, 0);
        goto L139
    L132:
        Intrinsics.checkNotNullParameter(r410, "<this>");
        if (vd9.r.a(r410).isEmpty() == false) goto L135;
        int r229 = i5.q();
    L136:
        hk9.a r1108 = this.f23071p;
        if (r1108 == null) goto L139;
        r1108.setPadding(r229, r229, r229, r229);
        goto L139
    L135:
        r229 = 0;
        goto L136
    L126:
        r1107 = i5.q();
    L122:
        r1106 = true;
        goto L123
    L115:
        r1105 = null;
        goto L116
    L111:
        r1102 = null;
    L77:
        r121 = false;
        goto L78
    L62:
        if (r116.isEmpty() == false) goto L64;
    L80:
        r122 = false;
        goto L81
    L52:
        if (com.larus.bmhome.chat.bean.d.j0(r410) == false) goto L55;
        r115 = false;
    L37:
        if (r106 == true) goto L40;
        if (r107 == false) goto L40;
        r114 = ExpandCardViewMode.EXPAND_PIC;
    L40:
        r114 = ExpandCardViewMode.EXPAND;
        goto L49
    L41:
        if (r113 == true) goto L349;
        if (r106 == false) goto L45;
        if (r107 == true) goto L45;
        r114 = ExpandCardViewMode.NORMAL_SHARE;
    L45:
        if (r106 == true) goto L48;
        if (r107 == false) goto L48;
        r114 = ExpandCardViewMode.NORMAL_PIC;
    L48:
        r114 = ExpandCardViewMode.NORMAL;
        goto L49
    L349:
        throw new NoWhenBranchMatchedException();
    L31:
        r112 = null;
        goto L32
    L27:
        r110 = 0;
        goto L28
    L23:
        r106 = false;
        goto L24
    L11:
        r103 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    @Override // bd8.b
    public final List<View> x(int r100, Context r101, BaseMessageListCell<?> r102, com.larus.bmhome.chat.layout.item.i r103, com.larus.bmhome.chat.api.q0 r104, Fragment r105) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f23072q = false;
        int r106 = ra8.a.f536852a;
        hk9.a r107 = ra8.a.a(r101);
        this.f23071p = r107;
        r107.setOrientation(1);
        if (r103 == null) goto L6;
        r103.addView(r107, r100, new LinearLayout.LayoutParams(-2, -2));
    L6:
        return CollectionsKt.listOf(r107);
    }
}
