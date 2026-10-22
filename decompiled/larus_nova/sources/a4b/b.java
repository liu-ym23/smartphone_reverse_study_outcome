package a4b;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import b3b.e;
import b3b.f;
import b3b.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.StickerMessageLoader$preLoadStickMessageFavoriteStatus$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatbase.l;
import com.ss.android.lark.chatwindow.view.photopreview.OperateListenerImpl;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.i0;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s2b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b f1821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f1822b;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a F() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) this.f1821a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a G() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) this.f1821a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // b3b.f, b3b.a, com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC4810a
    public Context getContext() {
        return this.f1821a.getContext();
    }

    @Override // b3b.e
    public final Map<String, String> h() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r100 = G();
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.n0();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return MapsKt.emptyMap();
    }

    public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f1821a = r100;
    }

    @Override // b3b.o
    public final void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r101 = F();
        if (r101 == null) goto L6;
        r101.retrySendMessage(r100);
        return;
    }

    @Override // b3b.t
    public final void E(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        IMessageListViewModel r101 = this.f1821a.f();
        if (r101 == null) goto L6;
        r101.updatePreviewByMessageId(r100);
        return;
    }

    @Override // b3b.d
    public final void K6(y6b.a<? extends v5b.a<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        IMessageListComponent.e r101 = this.f1821a.getDependency();
        if (r101 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r102 = r101.a();
        if (r102 == null) goto L9;
        r102.i(r100);
        return;
    L9:
        return;
    }

    @Override // b3b.a, q5b.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r101 = F();
        if (r101 == null) goto L8;
        s2b.e r102 = r101.getUIModel();
        if (r102 == null) goto L9;
        r102.e(r100);
        return;
    L9:
        return;
    }

    @Override // q5b.a
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r101 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) this.f1821a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r101 == null) goto L9;
        g r102 = r101.C();
        if (r102 == null) goto L9;
        List<Object> r103 = r102.h();
        if (r103 == null) goto L9;
        Object r104 = CollectionsKt.lastOrNull(r103);
    L11:
        if ((r104 instanceof y6b.a) == true) goto L13;
    L15:
        boolean r105 = false;
    L16:
        Log.d("MessageCallbackImpl", "isLastMessage:" + r105 + ",msgId:" + r100);
        return r105;
    L13:
        if (Intrinsics.areEqual(r100, ((y6b.a) r104).getId()) == false) goto L15;
        r105 = true;
    L9:
        r104 = null;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.model.preload.a.InterfaceC4810a
    public final void f(y6b.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r101 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) this.f1821a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r101 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.a r102 = r101.getAdapter();
        if (r102 == null) goto L9;
        r102.Y0(r100);
        return;
    L9:
        return;
    }

    @Override // p4b.b
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r101 = F();
        if (r101 == null) goto L9;
        MessageInfo r102 = r101.getMessageInfoById(r100);
        if (r102 == null) goto L10;
        Message r103 = r102.getMessage();
        Message r104 = h0.f(r102);
        ChatCoreModule.a().getMergeForwardDependnecy().b(this.f1821a.getContext(), r100, r103, r104);
        return;
    L10:
        return;
    }

    @Override // b3b.g
    public final boolean j(y6b.b r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.f566455d;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L19;
        Chat r103 = r102.getCurrentChat();
        if (r103 != null) goto L11;
        return false;
    L11:
        if (r103.isP2PChat() == false) goto L13;
        r101 = r100.f566454c;
    L13:
        IMessageListComponent.e r104 = this.f1821a.getDependency();
        if (r104 == null) goto L20;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r105 = r104.a();
        if (r105 == null) goto L21;
        String r106 = r100.f566452a;
        Intrinsics.checkNotNull(r101);
        return r105.f(r106, r101, r100.f566473v);
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    @Override // b3b.c
    public final void k(String r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r101 = F();
        if (r101 == null) goto L6;
        r101.H5(r100);
        return;
    }

    @Override // q5b.a
    public final void l(String r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r101 = G();
        if (r101 == null) goto L6;
        r101.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y(r100));
        return;
    }

    @Override // b3b.h
    public final void q(String r100) {
        h r101 = this.f1822b;
        if (r101 == null) goto L6;
        r101.q(r100);
        return;
    }

    @Override // p4b.a
    public final void u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        IMessageListViewModel r101 = this.f1821a.f();
        if (r101 == null) goto L18;
        MessageInfo r102 = r101.getMessageInfoById(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getMessage().getType() == Message.Type.FOLDER) goto L10;
        return;
    L10:
        Message r103 = r102.getMessage();
        vab.b r104 = ChatCoreModule.a().getFileDetailDependency();
        Context r105 = this.f1821a.getContext();
        IMessageListViewModel r106 = this.f1821a.f();
        if (r106 == null) goto L15;
        MutableLiveData<Chat> r107 = r106.getCurrentChat();
        if (r107 == null) goto L15;
        Chat r108 = r107.getValue();
    L16:
        ((xtb.a) r104).e(r105, r103, r108);
        return;
    L15:
        r108 = null;
        goto L16
    }

    @Override // b3b.r
    public final void y(String r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r101 = G();
        if (r101 == null) goto L6;
        r101.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.y(r100));
        return;
    }

    @Override // b3b.b
    public final List<String> y0(int r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r101 = F();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.y0(r100);
    }

    @Override // com.ss.android.lark.chat.utils.SystemContentUtil.a
    public final void B(String r100, List<GroupRecallEntity> r101) {
        IMessageListViewModel r102 = this.f1821a.f();
        if (r102 == null) goto L6;
        IMessageListViewModel.recallMembers$default(r102, r100, null, r101, 2, null);
        return;
    }

    @Override // b3b.p
    public final void C(final String r100, final StickerContentVO r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "stickerContentVO");
        IMessageListViewModel r102 = this.f1821a.f();
        if (r102 == null) goto L6;
        l<f5b.b> r103 = r102.stream();
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "stickerContentVO");
        Intrinsics.checkNotNullParameter(r103, "stream");
        final WeakReference r104 = new WeakReference(r103);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new StickerMessageLoader$preLoadStickMessageFavoriteStatus$1(r100, r101, r104));
        return;
    }

    @Override // b3b.r
    public final void d(View r100, y6b.a<v5b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "messageVO");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = G();
        if (r102 == null) goto L6;
        r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.z(r100, r101));
        return;
    }

    @Override // q5b.a
    public final void e(int r100, boolean r101) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a r102 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a) this.f1821a.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.a.class);
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // b3b.m
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter("", "autoTranslateLanguageByForward");
        IMessageListViewModel r102 = this.f1821a.f();
        if (r102 == null) goto L9;
        MessageInfo r103 = r102.getMessageInfoById(r101);
        if (r103 == null) goto L10;
        Message r104 = r103.getMessage();
        Message r105 = h0.f(r103);
        Context r106 = this.f1821a.getContext();
        l1.a r107 = new l1.a();
        r107.f410298e = r100;
        r107.f410309p = r103.getId();
        r107.f410311r = r104;
        r107.f410297d = true;
        r107.f410312s = r105;
        r107.f410315v = "";
        ReplyInThreadUtil.c(r106, new l1(r107), this.f1821a.getFragment());
        return;
    L10:
        return;
    }

    @Override // b3b.s
    public final void p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "url");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = G();
        if (r102 == null) goto L6;
        r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.a0(r100, r101));
        return;
    }

    @Override // b3b.j
    public final void r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageCid");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L6;
        r102.cancelUploadMediaMsg(r100, r101);
        return;
    }

    @Override // b3b.q
    public final void t(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = G();
        if (r102 == null) goto L6;
        r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.r(r100, r101));
        return;
    }

    @Override // b3b.a
    public final void x(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L8;
        s2b.e r103 = r102.getUIModel();
        if (r103 == null) goto L9;
        r103.g(r100, r101);
        return;
    L9:
        return;
    }

    @Override // b3b.k
    public final void z(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "fromSource");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L9;
        MessageInfo r103 = r102.getMessageInfoById(r100);
        if (r103 == null) goto L10;
        ChatCoreModule.a().getChatDependency().h(this.f1821a.getContext(), r103.getId(), r101);
        ChatHitPoint.a("replyCount");
        return;
    L10:
        return;
    }

    @Override // b3b.b
    public final void z0(String r100, String r101) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L6;
        r102.rm(r100, r101);
        return;
    }

    @Override // q5b.a
    public final void m(v5b.c r100, AppCompatImageView r101, r5b.a r102) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r103 = G();
        if (r103 == null) goto L6;
        r103.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.u(r100, r101, r102));
        return;
    }

    @Override // b3b.e
    public final void o(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r103 = G();
        if (r103 == null) goto L6;
        r103.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.x(r100, r101, r102));
        return;
    }

    @Override // b3b.i
    public final void v(View r100, PhotoItem r101, boolean r102) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r103 = G();
        if (r103 == null) goto L6;
        r103.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.q(r100, r101, r102));
        return;
    }

    @Override // a3b.b
    public final void w(String r100, String r101, Long r102) {
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L20;
        if (r101 != null) goto L12;
    L13:
        r103 = true;
    L14:
        if (r103 == true) goto L20;
        IMessageListViewModel r105 = this.f1821a.f();
        if (r105 == null) goto L22;
        r105.sendSignRequest(r100, r101, r102);
        return;
    L22:
        return;
    L12:
        if (r101.length() != 0) goto L14;
    L20:
        Log.i(TitlebarViewModel.LOG_TAG, "personal sign is null or userId is null");
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @Override // b3b.n
    public final void P3(String r100, String r101, RichText r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "content");
        IMessageListComponent.e r104 = this.f1821a.getDependency();
        if (r104 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r105 = r104.a();
        if (r105 == null) goto L9;
        r105.k(r100, r101, r102, r103);
        return;
    L9:
        return;
    }

    @Override // q5b.a
    public final void a(View r110, List<Image> r111, Image r112, String r210) {
        FragmentActivity r100 = this.f1821a.getActivity();
        Scene r101 = Scene.Chat;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r102 = F();
        if (r102 == null) goto L5;
        Chat r103 = r102.getCurrentChat();
    L6:
        List r104 = com.ss.android.lark.widget.photo.preview.utils.d.c(i0.b(r111), r210);
        int r105 = PhotoUtilsNew.g(r104, (PhotoItem) ListProtector.get(com.ss.android.lark.widget.photo.preview.utils.d.c(Collections.singletonList(i0.a(r112)), r210), 0));
        if (r103 != null) goto L9;
        Log.e("CardImageClickHandler", "onCardImageClick: chat is null, return");
        return;
    L9:
        boolean r106 = y0.a(r103);
        boolean r107 = y0.b(r103);
        boolean r108 = y0.c(r103);
        boolean r113 = y0.d(r103);
        boolean r114 = y0.a(r103);
        boolean r115 = y0.e(r103);
        if (r103.isSecret() == false) goto L12;
    L14:
        boolean r116 = false;
    L15:
        ArrayList r117 = new ArrayList(r104);
        int r109 = k.f446736a;
        k.c r118 = k.a.a(r117, r105, r110);
        r118.c(AVMDLDataLoader.KeyIsThreadPoolIdleTTLSecond);
        r118.i(r114);
        r118.o(r116);
        r118.f(new OperateListenerImpl(r103.getId()));
        r118.m(r113);
        r118.l(r107);
        r118.n(r107);
        r118.h(r108);
        r118.j(true);
        r118.p(false);
        r118.g(r106);
        r118.e(!r115);
        r118.q(Biz.Messenger, r101, 7);
        r118.r(r100);
        return;
    L12:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("translate.message.image.viewer.enable") == false) goto L14;
        r116 = true;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    @Override // b3b.i
    public final void n(View r100, String r101, List<? extends Object> r102, int r103) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r104 = G();
        if (r104 == null) goto L6;
        r104.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.v(r100, r101, r102, r103));
        return;
    }

    @Override // b3b.l
    public final void D(String r100, String r101, String r102, Integer r103, Boolean r104, Fragment r105) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "threadId");
        l1.a r106 = new l1.a();
        r106.f410298e = r101;
        boolean r107 = false;
        r106.f410308o = false;
        if (r102 == null) goto L5;
        r106.f410305l = r102;
    L5:
        if (r103 == null) goto L7;
        r106.f410299f = r103.intValue();
    L7:
        if (r104 == null) goto L9;
        r106.f410295b = r104.booleanValue();
    L9:
        s2b.d r108 = this.f1821a.a();
        if (r108 != null) goto L12;
    L14:
        if (r107 == false) goto L20;
        s2b.d r109 = this.f1821a.a();
        if (r109 == null) goto L20;
        MergeForwardContent r110 = r109.F8();
        if (r110 == null) goto L20;
        r106.f410309p = r110.getMessageId();
        r106.f410313t = r110;
        r106.f410308o = true;
    L20:
        r106.A = "chat";
        l1 r111 = new l1(r106);
        Context r112 = this.f1821a.getContext();
        Intrinsics.checkNotNull(r111);
        ReplyInThreadUtil.c(r112, r111, r105);
        return;
    L12:
        if (r108.e0() != true) goto L14;
        r107 = true;
        goto L14
    }

    @Override // b3b.i
    public final void s(View r110, ActivityTransitionLauncher.LocationInfo r111, PhotoItem r112, boolean r113, boolean r114, int r115, Message.SourceType r116) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r100 = G();
        if (r100 == null) goto L6;
        r100.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.p(r110, r111, r112, r113, r114, r115, r116));
        return;
    }
}
