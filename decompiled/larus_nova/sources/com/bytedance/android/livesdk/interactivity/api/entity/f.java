package com.bytedance.android.livesdk.interactivity.api.entity;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.w7;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public abstract class f<T extends t> {
    public PSMessageAction A;
    public long B;
    public u42.b C;
    public Map<String, String> D;
    public boolean E;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f133140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f133141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f133142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f133143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f133144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f133145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f133146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f133147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MessageSceneType f133148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Spannable f133149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h80.c<DisplayTimeRecorder> f133150k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PublicAreaBadgeInfo f133151l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f133152m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, String> f133153n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f133154o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f133155p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f133156q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f133157r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f133158s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f133159t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f133160u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f133161v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f133162w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f133163x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f133164y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PSMessagePriority f133165z;

    public f() {
        throw null;
    }

    public void C() {
    }

    public void F(tb2.b r100) {
    }

    public DisplayTimeRecorder I() {
        return null;
    }

    public boolean d() {
        return false;
    }

    public Spannable f() {
        return null;
    }

    public abstract Spannable g();

    public String h() {
        return null;
    }

    public void i(HashMap<String, String> r100) {
    }

    public MessageIdentity n() {
        return null;
    }

    public com.bytedance.android.livesdk.interactivity.api.publicscreen.i s() {
        return null;
    }

    public abstract IBaseUser x();

    public boolean z() {
        return false;
    }

    public final boolean A() {
        if (jc1.k.f(IMiddlewareUserService.class) != null) goto L7;
        return false;
    L7:
        return TextUtils.equals(y(), ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n());
    }

    public final h80.c<DisplayTimeRecorder> D() {
        if (this.f133150k != null) goto L6;
        this.f133150k = h80.c.c(I());
    L6:
        return this.f133150k;
    }

    public int k() {
        int r100 = MessageCommonColorUtil.f133766a;
        MessageSceneType r101 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    public final com.bytedance.android.live.base.model.data.b l() {
        T r100 = this.f133141b;
        if ((r100 instanceof m4) == true) goto L5;
        return null;
    L5:
        return ((m4) r100).getStatusInfo();
    }

    public Spannable m() {
        if (this.f133149j != null) goto L6;
        this.f133149j = f();
    L6:
        return this.f133149j;
    }

    public final long o() {
        T r100 = this.f133141b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getMessageId();
    }

    public Long p() {
        T r100 = this.f133141b;
        if (r100 == null) goto L7;
        return Long.valueOf(r100.getReceiveTime());
    L7:
        return 0L;
    }

    public Spannable q() {
        if (this.f133149j != null) goto L6;
        this.f133149j = f();
    L6:
        return this.f133149j;
    }

    public int r() {
        int r100 = MessageCommonColorUtil.f133766a;
        MessageSceneType r101 = MessageSceneType.DEFAULT;
        return MessageCommonColorUtil.d();
    }

    public final long u() {
        if (this.f133141b.getBaseMessage() == null) goto L10;
        if (this.f133141b.getBaseMessage().getPriorityScore() == 0) goto L10;
        return this.f133141b.getBaseMessage().getPriorityScore();
    L10:
        return this.f133143d;
    }

    public IPublicAreaCommon v() {
        if (w7.f160656a.getValue().booleanValue() == false) goto L8;
        T r100 = this.f133141b;
        if ((r100 instanceof u3) == false) goto L8;
        return ((u3) r100).getOrInitPublicAreaCommon();
    L8:
        return null;
    }

    public tb2.d w() {
        return new tb2.d();
    }

    public final String e() {
        C();
        return null;
    }

    public yb2.a j() {
        yb2.a r100 = w.a();
        IBaseUser r101 = null;
        if (jc1.k.f(IRoomContextService.class) != null) goto L5;
    L7:
        IBaseUser r102 = null;
    L9:
        if (jc1.k.f(IMiddlewareUserService.class) == null) goto L11;
        r101 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b();
    L11:
        if (r101 == null) goto L16;
        if (r102 != null) goto L14;
    L15:
        r102 = r101;
        goto L16
    L14:
        if (TextUtils.equals(r101.getIdString(), r102.getIdString()) == false) goto L15;
    L16:
        r100.f567062a = r();
        r100.f567065d = k();
        r100.f567064c = k();
        r100.f567063b = k();
        int r103 = MessageCommonColorUtil.f133766a;
        MessageSceneType r104 = MessageSceneType.DEFAULT;
        r100.f567066e = MessageCommonColorUtil.d();
        C();
        r100.f567071j = false;
        if (r102 == null) goto L19;
        r100.f567068g = r102.getIdString();
        r100.f567069h = r102.getWebcastUid();
        r100.f567070i = r102.getNickName();
    L19:
        return r100;
    L5:
        if (((IRoomContextService) jc1.k.f(IRoomContextService.class)).getRoomDataContext(null, 0).getUser() == null) goto L7;
        r102 = ((IRoomContextService) jc1.k.f(IRoomContextService.class)).getRoomDataContext(null, 0).getUser();
        goto L9
    }

    public PersonalizedDisplayInfo t() {
        if (v() != null) goto L5;
        return null;
    L5:
        if (v().getPersonalizedInfo() != null) goto L7;
        return null;
    L7:
        return v().getPersonalizedInfo();
    }

    public final String y() {
        if (x() != null) goto L7;
        return "";
    L7:
        return x().getIdString();
    }

    public Boolean B() {
        return Boolean.FALSE;
    }

    public int getType() {
        return this.f133142c;
    }

    public boolean E(g52.c r100) {
        if (x() != null) goto L6;
        return false;
    L6:
        UserProfileEvent r101 = new UserProfileEvent(x());
        r101.setClickUserPosition("comment_area");
        xs2.b.a().post(r101);
        J("default_user");
        return true;
    }

    public boolean G(Context r110) {
        if (x() != null) goto L6;
        return false;
    L6:
        String r100 = gm2.q.b(x());
        T r111 = this.f133141b;
        if (r111 != null) goto L9;
        long r101 = 0;
    L10:
        long r102 = r101;
        u22.m r112 = new u22.m(r100);
        r112.f548441l = OpenInputSource.LongPressMessage;
        r112.f548436g = System.currentTimeMillis();
        boolean r103 = TextUtils.equals(y(), this.f133145f);
        String r104 = y();
        if (x() != null) goto L13;
        String r105 = null;
    L14:
        u22.m.a r106 = new u22.m.a("message", r103, r104, 2, r100, r102, r105);
        r106.f548454k = this.f133141b.isFromOtherIntercomRoom();
        r106.f548453j = x();
        r106.a("message_type", this.f133141b.getMessageMethod());
        r106.a("is_reply_user_show", "0");
        r112.f548434e = r106;
        xs2.b.a().post(r112);
        return true;
    L13:
        r105 = x().getWebcastUid();
        goto L14
    L9:
        r101 = r111.getMessageId();
        goto L10
    }

    public final void J(String r100) {
        HashMap<String, String> r101 = new HashMap();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.a(r101, this.f133141b);
        Map<String, String> r102 = this.D;
        if (r102 == null) goto L5;
        r101.putAll(r102);
    L5:
        i(r101);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.b(this.f133141b.getMessageMethod(), r100, r101);
    }

    public final void c(tb2.d r100) {
        if (this.f133141b != null) goto L5;
        return;
    L5:
        if (x() == null) goto L25;
        MessageIdentity r101 = n();
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L18;
        if (r101 == null) goto L18;
        final py.k r103 = r101.getIdentityLabel();
    L19:
        if (r103 == null) goto L21;
        r100.a(new b(this, r103));
        return;
    L21:
        IBaseUser r104 = x();
        C();
        r100.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r104, null, true, this.f133144e));
        return;
    L18:
        r103 = null;
        goto L19
    L10:
        if (r101.getShowIdentity() != 1) goto L12;
        r102 = true;
        goto L14
    }

    public f(T r100, int r101) {
        this.f133140a = "默认优先级";
        this.f133143d = 0;
        this.f133146g = false;
        this.f133147h = false;
        this.f133148i = MessageSceneType.PUBLIC_SCREEN;
        this.f133151l = null;
        this.f133152m = new HashMap();
        this.f133153n = new HashMap();
        this.f133154o = 0L;
        this.f133155p = 0L;
        this.f133156q = 0L;
        this.f133157r = null;
        this.f133158s = 0;
        this.f133159t = System.nanoTime();
        this.f133160u = 0;
        this.f133162w = 0;
        this.f133163x = false;
        this.f133164y = false;
        this.f133165z = PSMessagePriority.NORMAL;
        this.A = PSMessageAction.UNKNOW;
        this.B = 0;
        this.C = null;
        this.D = null;
        this.f133141b = r100;
        this.f133142c = r101;
    }

    public f(T r100, MessageSceneType r101) {
        this(r100, 0);
        this.f133148i = r101;
    }

    public f(T r100, MessageSceneType r101, int r102) {
        this(r100, r102);
        this.f133148i = r101;
    }

    public void H(View r100, g52.c r101, final TextMessageRenderViewHolder r102, WeakReference r103) {
        ALogger.d("PSOperatePanel", "onViewClickStandardize");
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.b(this.f133141b) == false) goto L19;
        if (com.bytedance.android.livesdk.interactivity.api.q.a() == null) goto L19;
        if (com.bytedance.android.livesdk.interactivity.api.q.a().e(this.f133141b, r100, new c(this, r102)) == false) goto L14;
        this.f133147h = true;
        if (r101 == null) goto L11;
        ((TextMessageWidget) r101).Aq();
    L11:
        J("audience_action_sheet");
        Function1 r104 = (Function1) r103.get();
        if (r104 == null) goto L26;
        r104.invoke(Boolean.TRUE);
        return;
    L26:
        return;
    L14:
        this.f133147h = false;
        boolean r105 = E(r101);
        Function1 r106 = (Function1) r103.get();
        if (r106 == null) goto L28;
        r106.invoke(Boolean.valueOf(r105));
        return;
    L28:
        return;
    L19:
        if (jc1.k.f(IInteractivityInjectService.class) == null) goto L21;
        ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).openPSOperatePanel(this.f133141b, r100.getContext(), null, new e(this, r103, r101));
    L24:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p.d(this, "content");
        return;
    L21:
        boolean r107 = E(r101);
        Function1 r108 = (Function1) r103.get();
        if (r108 == null) goto L24;
        r108.invoke(Boolean.valueOf(r107));
        goto L24
    }
}
