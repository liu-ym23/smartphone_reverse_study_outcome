package b4b;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.message.actionimpl.MessageReactionHandlerImpl;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import z5c.o2;
import z5c.v2;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements b4b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6b.a f17693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f17694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b f17695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LKUIDialog f17696d;

    public static final class a {
    }

    /* JADX INFO: renamed from: b4b.b$b, reason: collision with other inner class name */
    public static final class C0264b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i7b.a f17698b;

        public C0264b(b r100, i7b.a r101) {
            this.f17697a = r100;
            this.f17698b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L7;
            UICallbackExecutor.executeDelayed(new b4b.e(this.f17697a, this.f17698b), 500);
            Log.i(TitlebarViewModel.LOG_TAG, "Need relocate message after first load!");
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s2b.d f17700b;

        public c(b r100, s2b.d r101) {
            this.f17699a = r100;
            this.f17700b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Chat r101 = (Chat) r100;
            if (r101 == null) goto L8;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = b.l(this.f17699a);
            if (r102 == null) goto L7;
            r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.c(r101));
        L7:
            this.f17700b.f540335d = r101;
            return;
        L8:
            Log.e("MessageListContextFeature", "currentChat observe chat == null");
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17701a;

        public d(b r100) {
            this.f17701a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ThreadTopic r101 = (ThreadTopic) r100;
            if (r101 == null) goto L8;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = b.l(this.f17701a);
            if (r102 == null) goto L9;
            r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.d0(r101));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s2b.d f17702a;

        public e(s2b.d r100) {
            this.f17702a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ChatChatter r101 = (ChatChatter) r100;
            s2b.d r102 = this.f17702a;
            if (r101 == null) goto L5;
            r102.f540333b.getClass();
            r102.f540336e = u2b.d.a(r101);
            return;
        L5:
            r102.getClass();
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s2b.d f17704b;

        public f(b r100, s2b.d r101) {
            this.f17703a = r100;
            this.f17704b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ChatChatter r101 = (ChatChatter) r100;
            if (r101 == null) goto L7;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = b.l(this.f17703a);
            if (r102 == null) goto L7;
            r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.b0(r101));
        L7:
            s2b.d r103 = this.f17704b;
            if (r101 == null) goto L10;
            r103.f540333b.getClass();
            r103.f540337f = u2b.d.a(r101);
            return;
        L10:
            r103.getClass();
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17705a;

        public g(b r100) {
            this.f17705a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r102 = this.f17705a.f17695c;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r102 = null;
        L5:
            LKUIToast.show(r102.getContext(), r101);
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17706a;

        public h(b r100) {
            this.f17706a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r102 = this.f17706a.f17695c;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r102 = null;
        L5:
            h7b.i.b(r102.getContext(), (String) r101.getFirst(), (String) r101.getSecond());
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17707a;

        public i(b r100) {
            this.f17707a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L22;
            b r102 = this.f17707a;
            r102.getClass();
            if (TextUtils.isEmpty(r101) == false) goto L8;
            r102.f17694b.invoke();
            return;
        L8:
            LKUIDialog r103 = r102.f17696d;
            if (r103 != null) goto L11;
        L13:
            boolean r104 = false;
        L14:
            if (r104 == true) goto L23;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r105 = r102.f17695c;
            if (r105 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("env");
            r105 = null;
        L19:
            com.larksuite.component.ui.dialog.d r106 = new com.larksuite.component.ui.dialog.d(r105.getContext());
            r106.k(r101);
            r106.f284132c.titleBold(true);
            r106.f284132c.titleLineCount(3);
            r106.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_ConfirmTip, new b4b.c(r102));
            r106.f284132c.cancelable(false);
            LKUIDialog r107 = r106.i();
            r102.f17696d = r107;
            r107.setOnKeyListener(new b4b.d(r102));
            return;
        L23:
            return;
        L11:
            if (r103.isShowing() != true) goto L13;
            r104 = true;
            goto L14
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17708a;

        public j(b r100) {
            this.f17708a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List r101 = (List) r100;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = b.l(this.f17708a);
            if (r102 == null) goto L6;
            Intrinsics.checkNotNull(r101);
            r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.n(r101));
            return;
        }
    }

    public static final class k<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17709a;

        public k(b r100) {
            this.f17709a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List r101 = (List) r100;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r102 = b.l(this.f17709a);
            if (r102 == null) goto L6;
            Intrinsics.checkNotNull(r101);
            r102.m0(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b.m(r101));
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r100, int r101, Intent r102) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void onDestroy() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100 = this.f17695c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r100 = null;
    L5:
        s2b.d r102 = r100.a();
        if (r102 == null) goto L51;
        z2b.b r103 = r102.f540342k;
        if (r103 == null) goto L52;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.f r104 = TextLayoutRenderExtKt.f412455a;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if ((r103 instanceof w2b.b) == false) goto L20;
        w2b.b r105 = (w2b.b) r103;
        z2b.a r106 = r105.f558083a;
        if ((r106 instanceof com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h) == false) goto L15;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r107 = r105.f558084b.c();
    L21:
        if (r107 == null) goto L56;
        StringBuilder r108 = new StringBuilder("logTextLayoutCacheInfo: ");
        String r109 = "CacheInfo(msgCount: " + r107.f412470a + ", ";
        StringBuilder r110 = new StringBuilder();
        r110.append(r109);
        if (r107.f412471b <= 0) goto L26;
        String r111 = "parseHitRate: " + ((r107.f412472c * 100.0f) / r107.f412471b) + "%, ";
    L27:
        r110.append(r111);
        String r112 = r110.toString();
        StringBuilder r113 = new StringBuilder();
        r113.append(r112);
        if (r107.f412473d <= 0) goto L30;
        String r114 = "renderHitRate: " + ((r107.f412474e * 100.0f) / r107.f412473d) + '%';
    L31:
        r113.append(r114);
        r108.append(r113.toString() + " )");
        Log.i("MessageListContextFeature", r108.toString());
        int r115 = r107.f412473d;
        if (r115 == 0) goto L53;
        int r116 = r107.f412471b;
        if (r116 == 0) goto L57;
        float r117 = r107.f412472c / r116;
        float r118 = r107.f412474e / r115;
        Statistics.sendEvent("im_msg_text_layout_view", s5c.d.b.b(o2.f570270c.a(String.valueOf(r117)), v2.f570390c.a(String.valueOf(r118))).toJson());
        if (r117 >= 0.5f) goto L39;
    L40:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r119 = this.f17695c;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r119 = null;
    L44:
        if (DevEnvUtil.isDebugMode(r119.getContext()) == false) goto L55;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r120 = this.f17695c;
        if (r120 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L49:
        UDToast.show(r101.getContext(), "message text layout cache rate is lower than 0.5f !!! , please check the logs of \"TextLayoutCacheStoreImpl\"");
        return;
    L48:
        r101 = r120;
        goto L49
    L55:
        return;
    L39:
        if (r118 < 0.5f) goto L40;
        return;
    L57:
        return;
    L53:
        return;
    L30:
        r114 = "no render request.";
        goto L31
    L26:
        r111 = "no parse request";
        goto L27
    L56:
        return;
    L15:
        if ((r106 instanceof TextLayoutCacheStoreImpl2) == false) goto L18;
        r107 = r105.f558085c.c();
        goto L21
    L18:
        if ((r106 instanceof w2b.a) == false) goto L20;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r121 = r105.f558084b.c();
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d r122 = r105.f558085c.c();
        r107 = new com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.d(r122.f412470a + r121.f412470a, r122.f412471b + r121.f412471b, r122.f412472c + r121.f412472c, r122.f412473d + r121.f412473d, r121.f412474e + r122.f412474e);
    L20:
        r107 = null;
        goto L21
    L52:
        return;
    }

    public static final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a l(b r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r101 = r100.f17695c;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r101 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r101.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initData");
        Intrinsics.checkNotNullParameter(r100, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r101 = this.f17695c;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r101 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r103 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r101.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
        if (r103 == null) goto L53;
        IMessageListViewModel r104 = r103.f();
        if (r104 == null) goto L53;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r105 = this.f17695c;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r105 = null;
    L13:
        s2b.d r106 = r105.a();
        if ((r106 instanceof s2b.d) == true) goto L17;
        r106 = null;
    L17:
        if (r106 != null) goto L20;
        Log.e("MessageListContextFeature", "chatContext is null");
        return;
    L20:
        mya.i r107 = new mya.i();
        MessageReactionHandlerImpl r108 = new MessageReactionHandlerImpl(r106);
        Intrinsics.checkNotNullParameter(r104, "streamProvider");
        r108.f412600b = r104;
        r107.a(mya.d.class, r108);
        r106.g(r107);
        MutableLiveData<Chat> r109 = r104.getCurrentChat();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r110 = this.f17695c;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r110 = null;
    L23:
        r109.observe(r110.getLifecycleOwner(), new c(this, r106));
        MutableLiveData<ThreadTopic> r111 = r104.getCurrentThreadTopic();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r112 = this.f17695c;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r112 = null;
    L26:
        r111.observe(r112.getLifecycleOwner(), new d(this));
        MutableLiveData<ChatChatter> r113 = r104.getSelfChatterLiveData();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r114 = this.f17695c;
        if (r114 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r114 = null;
    L29:
        r113.observe(r114.getLifecycleOwner(), new e(r106));
        MutableLiveData<ChatChatter> r115 = r104.getP2pChatterLiveData();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r116 = this.f17695c;
        if (r116 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r116 = null;
    L32:
        r115.observe(r116.getLifecycleOwner(), new f(this, r106));
        MutableLiveData<String> r117 = r104.getToastInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r118 = this.f17695c;
        if (r118 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r118 = null;
    L35:
        r117.observe(r118.getLifecycleOwner(), new g(this));
        MutableLiveData<Pair<String, String>> r119 = r104.getDialogInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r120 = this.f17695c;
        if (r120 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r120 = null;
    L38:
        r119.observe(r120.getLifecycleOwner(), new h(this));
        MutableLiveData<String> r121 = r104.getClosePageInfo();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r122 = this.f17695c;
        if (r122 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r122 = null;
    L41:
        r121.observe(r122.getLifecycleOwner(), new i(this));
        MutableLiveData<List<MessageInfo>> r123 = r104.getNewMessageItems();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r124 = this.f17695c;
        if (r124 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r124 = null;
    L44:
        r123.observe(r124.getLifecycleOwner(), new j(this));
        MutableLiveData<List<MessageInfo>> r125 = r104.getNewMessageItemsAppend();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r126 = this.f17695c;
        if (r126 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r126 = null;
    L47:
        r125.observe(r126.getLifecycleOwner(), new k(this));
        MutableLiveData<Boolean> r127 = r104.getNeedRelocateMessage();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r128 = this.f17695c;
        if (r128 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L51:
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(r127, r102.getLifecycleOwner(), new C0264b(this, r100));
        r104.loadFirstPage(r100.f488511k);
        PerfLog.end("message_list_init_with_data", "");
        return;
    L50:
        r102 = r128;
    L53:
        Log.e("MessageListContextFeature", "dataFeature is null");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f17695c = r100;
    }

    public b(t6b.a r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        Intrinsics.checkNotNullParameter(r101, "exitChat");
        this.f17693a = r100;
        this.f17694b = r101;
    }
}
