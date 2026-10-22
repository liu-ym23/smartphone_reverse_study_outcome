package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.syncdata.RoomChannelSyncModel;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelRtcExtInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.larus.nova.R;
import com.ttnetuploader.uploader.api.UploadCode;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements s22.a, vlc.l, com.bytedance.android.livesdk.log.filter.n, vlc.h {
    public static final String E = null;
    public final User A;
    public final String B;
    public final List<User> C;
    public final boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s22.e f134271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g f134272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g f134273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f134274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<Boolean> f134275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner<String> f134276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<List<py.k>> f134277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<Long> f134278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner<User> f134279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner<List<User>> f134280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PropertyOwner<Boolean> f134281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PropertyOwner<Boolean> f134282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PropertyOwner<Boolean> f134283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PropertyOwner<String> f134284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RoomChannelSyncModel f134285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f134286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f134287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f134288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f134289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f134290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f134291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SecretChatInfo f134292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FansChannelCreateInfo f134293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f134294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f134295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f134296z;

    public static final class a {
    }

    public c() {
        throw null;
    }

    static {
        E = s1.B(R.string.ttlive_room_channel_name_default);
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final long B() {
        PropertyOwner<Long> r100 = this.f134278h;
        r100.getClass();
        return r100.f64752a.longValue();
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final boolean c() {
        PropertyOwner<Boolean> r100 = this.f134275e;
        r100.getClass();
        return r100.f64752a.booleanValue();
    }

    @Override // s22.a
    public final PropertyOwner d() {
        PropertyOwner<Boolean> r100 = this.f134282l;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final PropertyOwner d0() {
        PropertyOwner<Long> r100 = this.f134278h;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final PropertyOwner g() {
        PropertyOwner<List<User>> r100 = this.f134280j;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final PropertyOwner getChannelName() {
        PropertyOwner<String> r100 = this.f134276f;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final PropertyOwner getOwner() {
        PropertyOwner<User> r100 = this.f134279i;
        r100.getClass();
        return r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final String i() {
        PropertyOwner<String> r100 = this.f134276f;
        r100.getClass();
        return r100.f64752a;
    }

    @Override // s22.a
    public final PropertyOwner j() {
        PropertyOwner<Boolean> r100 = this.f134281k;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final boolean k() {
        if (this.f134275e.f64752a.booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.D == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final String p() {
        PropertyOwner<User> r100 = this.f134279i;
        r100.getClass();
        String r101 = com.bytedance.android.live.base.model.user.o.a(r100.f64752a);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final String q() {
        PropertyOwner<User> r100 = this.f134279i;
        r100.getClass();
        return r100.f64752a.getIdStr();
    }

    @Override // s22.a
    public final PropertyOwner t() {
        PropertyOwner<List<py.k>> r100 = this.f134277g;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final PropertyOwner v() {
        PropertyOwner<Boolean> r100 = this.f134275e;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final boolean w() {
        if (this.f134275e.f64752a.booleanValue() == false) goto L5;
    L12:
        return true;
    L5:
        if (this.f134295y == true) goto L7;
    L11:
        return false;
    L7:
        if (this.f134283m.f64752a.booleanValue() == false) goto L11;
        if (this.f134294x == true) goto L11;
        goto L11
    }

    @Override // s22.a
    public final PropertyOwner z() {
        PropertyOwner<Boolean> r100 = this.f134283m;
        r100.getClass();
        return r100;
    }

    @Override // s22.a
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g A() {
        return this.f134272b;
    }

    @Override // s22.a
    public final FansChannelCreateInfo C() {
        return this.f134293w;
    }

    @Override // s22.a
    public final String a() {
        return this.B;
    }

    @Override // s22.a
    public final long b() {
        return this.f134289s;
    }

    @Override // s22.a
    public final boolean e() {
        return this.f134294x;
    }

    @Override // s22.a
    public final long f() {
        return this.f134290t;
    }

    @Override // s22.a
    public final long getChannelId() {
        return this.f134286p;
    }

    @Override // s22.a
    public final long getMaxMemberCount() {
        return this.f134287q;
    }

    @Override // s22.a
    public final com.bytedance.android.livesdk.interactivity.service.messagelist.g h() {
        return this.f134273c;
    }

    @Override // s22.a
    public final User m() {
        return this.A;
    }

    @Override // s22.a
    public final SecretChatInfo n() {
        return this.f134292v;
    }

    @Override // s22.a
    public final long o() {
        return this.f134291u;
    }

    @Override // s22.a
    public final PropertyOwner<String> r() {
        return this.f134284n;
    }

    @Override // s22.a
    public final boolean s() {
        return this.f134295y;
    }

    @Override // com.bytedance.android.livesdk.log.filter.n
    public final long u() {
        return this.f134286p;
    }

    @Override // s22.a
    public final boolean x() {
        return this.f134296z;
    }

    @Override // s22.a
    public final long y() {
        return this.f134288r;
    }

    public final void D(s22.e r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        int r101 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f133003a;
        Intrinsics.checkNotNullParameter(this, "channel");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("remove item success, channelInfo is " + com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a(this));
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r102 = this.f134272b;
        r102.getClass();
        pm0.a r103 = om0.c.c();
        if (r103 == null) goto L5;
        r103.i("MessageListManager", "MessageListManager dispose");
    L5:
        r102.f140885f.dispose();
        r102.f140880a.removeMessages(UploadCode.TT_UPLOAD_SERVER_DISK_NOT_ENOUGH);
        r102.f140886g.set(false);
        this.f134274d.dispose();
        r100.mo8239getIMManager().removeMessageListener(this);
        this.f134271a = null;
    }

    @Override // s22.a
    public final void l(long r100) {
        this.f134291u = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k) == false) goto L12;
        boolean r101 = true;
        if (((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.k) r100).getRoleType() == 1) goto L9;
        r101 = false;
    L9:
        if (this.f134275e.f64752a.booleanValue() == r101) goto L41;
        this.f134275e.a(Boolean.valueOf(r101));
        f2.b(R.string.ttlive_chat_channel_toast_role_manager, 0);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.k(this);
        return;
    L41:
        return;
    L12:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o) == false) goto L15;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o r102 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.o) r100;
        E(r102.getChannelName(), null, r102.G(), r102.H(), r102.P());
        return;
    L15:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m) == false) goto L23;
        long r103 = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.message.m) r100).G();
        SecretChatInfo r104 = this.f134292v;
        if (r104 == null) goto L20;
        r104.setStatus(r103);
    L20:
        if (r103 != 2) goto L44;
        this.f134281k.a(Boolean.FALSE);
        return;
    L44:
        return;
    L23:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) == false) goto L25;
    L36:
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r105 = g62.a.a(r100);
        if (r105 != null) goto L39;
        return;
    L39:
        this.f134272b.f(r105);
        return;
    L25:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) == true) goto L36;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p) == true) goto L36;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n) == true) goto L36;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == true) goto L36;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) == true) goto L36;
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) == true) goto L36;
    }

    @Override // vlc.h
    public final void onFirstMessage(List<tlc.d> r110, boolean r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (this.f134271a != null) goto L7;
        return;
    L7:
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r112 = this.f134272b;
        if (r112.f140881b == false) goto L10;
    L13:
        boolean r113 = true;
    L14:
        if (r113 == false) goto L16;
        return;
    L16:
        boolean r114 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f132986e;
        ArrayList r100 = new ArrayList();
        Iterator<T> r115 = r110.iterator();
    L17:
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r101 = null;
        if (r115.hasNext() == false) goto L40;
        tlc.d r102 = (tlc.d) r115.next();
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.g) == false) goto L22;
    L36:
        r101 = g62.a.a(r102);
    L37:
        if (r101 == null) goto L17;
        r100.add(r101);
        goto L17
    L22:
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d) == true) goto L36;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p) == true) goto L36;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.n) == true) goto L36;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.b) == true) goto L36;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h) == true) goto L36;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.i) == false) goto L37;
        if (r114 == false) goto L37;
        r101 = g62.a.a(r102);
        goto L37
    L40:
        if (r100.isEmpty() == false) goto L42;
        return;
    L42:
        com.bytedance.android.livesdk.interactivity.service.messagelist.g r116 = this.f134272b;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r100, "messages");
        if (r116.f140885f.isDisposed() == false) goto L46;
        return;
    L46:
        if (r116.f140881b == true) goto L89;
        ArrayList r117 = new ArrayList();
        Iterator r103 = r100.iterator();
    L50:
        if (r103.hasNext() == false) goto L68;
        Object r104 = r103.next();
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r105 = (com.bytedance.android.livesdk.interactivity.service.messagelist.c) r104;
        List<com.bytedance.android.livesdk.interactivity.service.messagelist.d> r106 = r116.f140887h.getInterceptors();
        if (r106 == null) goto L61;
        Iterator<T> r107 = r106.iterator();
    L55:
        if (r107.hasNext() == false) goto L59;
        Object r108 = r107.next();
        if (((com.bytedance.android.livesdk.interactivity.service.messagelist.d) r108).a(r105) == false) goto L55;
    L60:
        com.bytedance.android.livesdk.interactivity.service.messagelist.d r109 = (com.bytedance.android.livesdk.interactivity.service.messagelist.d) r108;
    L62:
        if (r109 != null) goto L64;
        boolean r118 = true;
    L65:
        if (r118 == false) goto L50;
        r117.add(r104);
        goto L50
    L64:
        r118 = false;
        goto L65
    L59:
        r108 = null;
        goto L60
    L61:
        r109 = null;
        goto L62
    L68:
        if (r117.isEmpty() == true) goto L90;
        r116.f140881b = true;
        int r119 = r117.size();
        List r120 = r117;
        if (r119 <= r116.f140887h.c().getMaxCount()) goto L73;
        r120 = CollectionsKt.takeLast(r117, r116.f140887h.c().getMaxCount());
    L73:
        ((ArrayList) r116.f140883d).addAll(r120);
        r116.g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INIT_LIST, 0, 0, 0, null, 30));
        return;
    L90:
        return;
    L89:
        return;
    L10:
        if ((!((ArrayList) r112.f140883d).isEmpty()) == true) goto L13;
        r113 = false;
        goto L14
    }

    public final void E(String r100, List<? extends py.k> r101, long r102, User r103, List<? extends User> r110) {
        boolean r104 = true;
        if (r100 != null) goto L5;
    L9:
        if (r101 == null) goto L16;
        if (r101.size() <= 0) goto L16;
        if ((!Intrinsics.areEqual(r101, this.f134277g.f64752a)) == false) goto L16;
        this.f134277g.a(r101);
    L16:
        if (r102 > 0) goto L18;
    L20:
        boolean r105 = false;
        if (r110 == null) goto L41;
        List<User> r106 = this.f134280j.f64752a;
        if (r110.size() != r106.size()) goto L38;
        List<? extends User> r107 = r110;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        r108.add(com.bytedance.android.live.base.model.user.o.a((User) r109.next()));
        goto L27
    L29:
        List r111 = CollectionsKt.toList(r108);
        List<User> r112 = r106;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L31:
        if (r114.hasNext() == false) goto L33;
        r113.add(com.bytedance.android.live.base.model.user.o.a((User) r114.next()));
        goto L31
    L33:
        List r115 = CollectionsKt.toList(r113);
        if (r111.containsAll(r115) == false) goto L38;
        if (r115.containsAll(r111) == false) goto L38;
    L39:
        if (r104 == true) goto L41;
        this.f134280j.a(r110);
        int r116 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f133003a;
        Intrinsics.checkNotNullParameter(this, "chatChannel");
        StringBuilder r117 = new StringBuilder("update userList, channelId is ");
        r117.append(this.f134286p);
        r117.append(", size is ");
        PropertyOwner<List<User>> r118 = this.f134280j;
        r118.getClass();
        r117.append(r118.f64752a.size());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r117.toString());
    L38:
        r104 = false;
    L41:
        if (r103 == null) goto L51;
        User r119 = this.f134279i.f64752a;
        if (r119 == null) goto L46;
        Intrinsics.checkNotNullParameter(r103, "$this$secUidExt");
        String r120 = r103.getCastSecUid();
        Intrinsics.checkNotNullParameter(r119, "$this$secUidExt");
        r105 = TextUtils.equals(r120, r119.getCastSecUid());
    L46:
        if (r105 == true) goto L52;
        this.f134279i.a(r103);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.k(this);
        return;
    L52:
        return;
    L51:
        return;
    L18:
        if (r102 == this.f134278h.f64752a.longValue()) goto L20;
        this.f134278h.a(Long.valueOf(r102));
        int r121 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f133003a;
        Intrinsics.checkNotNullParameter(this, "chatChannel");
        StringBuilder r122 = new StringBuilder("update count, channelId is ");
        r122.append(this.f134286p);
        r122.append(", count is ");
        PropertyOwner<Long> r123 = this.f134278h;
        r123.getClass();
        r122.append(r123.f64752a.longValue());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r122.toString());
        goto L20
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if ((!Intrinsics.areEqual(r100, this.f134276f.f64752a)) == false) goto L9;
        this.f134276f.a(r100);
        goto L9
    }

    public c(long r110, String r111, long r112, long r113, long r210, long r211, SecretChatInfo r212, FansChannelCreateInfo r213, boolean r214, boolean r215, boolean r216, User r217, RoomChannelRtcExtInfo r310, boolean r311, String r312, List r313, String r314, long r315, List r316, User r317, boolean r318, boolean r410) {
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r312, "channelName");
        Intrinsics.checkNotNullParameter(r313, "avatarThumb");
        Intrinsics.checkNotNullParameter(r316, "topUserList");
        Intrinsics.checkNotNullParameter(r317, "ownerUser");
        this.f134286p = r110;
        this.f134287q = r112;
        this.f134288r = r113;
        this.f134289s = r210;
        this.f134290t = r211;
        this.f134291u = 0;
        this.f134292v = r212;
        this.f134293w = r213;
        this.f134294x = r214;
        this.f134295y = r215;
        this.f134296z = r216;
        this.A = r217;
        this.B = r314;
        this.C = r316;
        this.D = r410;
        int r100 = g62.j.f480144a;
        g62.b r101 = new g62.b();
        g62.e r102 = new g62.e();
        g62.d r103 = new g62.d();
        List r104 = CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.interactivity.service.messagelist.d[]{new j62.a(), new j62.b()});
        boolean r114 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f132982a;
        this.f134272b = new com.bytedance.android.livesdk.interactivity.service.messagelist.g(new g62.c(r104, r101, r103, r102, new com.bytedance.android.livesdk.interactivity.service.messagelist.l()));
        this.f134273c = new com.bytedance.android.livesdk.interactivity.service.messagelist.g(new g62.g(new g62.f(), new g62.h(), new g62.i()));
        this.f134274d = new CompositeDisposable();
        if (r310 == null) goto L5;
        Object r105 = new sh6.d(r310);
    L6:
        new PropertyOwner(r105);
        this.f134275e = new PropertyOwner(Boolean.valueOf(r311));
        this.f134276f = new PropertyOwner(r312);
        this.f134277g = new PropertyOwner(r313);
        this.f134278h = new PropertyOwner(Long.valueOf(r315));
        this.f134279i = new PropertyOwner(r317);
        this.f134280j = new PropertyOwner(r316);
        this.f134281k = new PropertyOwner(Boolean.valueOf(r318));
        this.f134282l = new PropertyOwner(Boolean.FALSE);
        this.f134283m = new PropertyOwner(Boolean.TRUE);
        this.f134284n = new PropertyOwner("");
        return;
    L5:
        r105 = sh6.a.f541970a;
        goto L6
    }
}
