package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f140902g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiTypeAdapter f140903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageListScrollManager f140904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SpaceItemDecoration f140905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f140906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f140907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f140908f;

    public static final class a {
    }

    static {
        f140902g = s1.f(8.0f);
    }

    public final void a(IMessageListManager r110) {
        Intrinsics.checkNotNullParameter(r110, "manager");
        Disposable r100 = this.f140907e;
        if (r100 == null) goto L5;
        this.f140906d.remove(r100);
    L5:
        MessageListScrollManager r101 = this.f140904b;
        int r102 = 0;
        if (r101.f140870i == null) goto L26;
        int r103 = r101.f140865d.findFirstVisibleItemPosition();
        View r104 = r101.f140865d.findViewByPosition(r103);
        if (r104 == null) goto L11;
        int r105 = r104.getTop();
    L12:
        IMessageListManager r106 = r101.f140870i;
        if (r106 == null) goto L19;
        b r107 = r106.getConfig();
        if (r107 == null) goto L19;
        l r108 = r107.b();
        if (r108 == null) goto L19;
        r108.f140901g = true;
    L19:
        IMessageListManager.b r109 = new IMessageListManager.b(0);
        r109.f140858a = r103;
        r109.f140859b = r105;
        r109.f140860c = r101.f140863b;
        r109.f140861d = r101.f140864c;
        IMessageListManager r111 = r101.f140870i;
        if (r111 == null) goto L26;
        b r112 = r111.getConfig();
        if (r112 == null) goto L26;
        l r113 = r112.b();
        if (r113 == null) goto L26;
        Intrinsics.checkNotNullParameter(r109, "newStatus");
        r113.f140899e = r109;
        goto L26
    L11:
        r105 = 0;
    L26:
        this.f140903a.f513437a = r110.getMessageList();
        this.f140903a.notifyDataSetChanged();
        MessageListScrollManager r114 = this.f140904b;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "manager");
        r114.f140870i = r110;
        r114.e(MessageListScrollManager.ScrollState.Focus);
        Disposable r115 = r114.f140869h;
        if (r115 == null) goto L29;
        r115.dispose();
    L29:
        l r116 = r110.getConfig().b();
        if (r116 == null) goto L34;
        IMessageListManager.b r117 = r116.f140899e;
        if (r117 == null) goto L34;
        r114.f140865d.scrollToPositionWithOffset(r117.f140858a, r117.f140859b);
        r114.d(r117.f140860c);
        r114.f140864c = r117.f140861d;
    L46:
        MainThreadPostUtils.b(new j(r114, r110));
        Disposable r118 = r110.a().subscribe(new o(this));
        RxUtilKt.c(r118, this.f140906d);
        this.f140907e = r118;
        Unit r119 = Unit.INSTANCE;
        return;
    L34:
        MessageListScrollManager$bind$2$condition$1 r120 = MessageListScrollManager$bind$2$condition$1.INSTANCE;
        List<c> r121 = r110.getMessageList();
        Intrinsics.checkNotNullParameter(r121, "list");
        Intrinsics.checkNotNullParameter(r120, "condition");
        List<c> r122 = r121;
        int r123 = r122.size();
    L35:
        int r124 = -1;
        if (r102 >= r123) goto L42;
        if (r120.invoke(ListProtector.get(r121, r102)).booleanValue() == true) goto L39;
        r102 = r102 + 1;
        goto L35
    L39:
        int r125 = r102 - 1;
    L45:
        r114.d(r125);
        MainThreadPostUtils.b(new i(r114));
        goto L46
    L42:
        if ((!r122.isEmpty()) == false) goto L44;
        r124 = CollectionsKt.getLastIndex(r121);
    L44:
        r125 = r124;
        goto L45
    }

    public final <T> void b(Class<? extends T> r100, me.drakeet.multitype.b<T, ?> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "binder");
        this.f140903a.z2(r100, r101);
    }

    public m(RecyclerView r100, View r101, TextView r102, int r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "hintLayout");
        Intrinsics.checkNotNullParameter(r102, "hintTextView");
        this.f140908f = r100;
        this.f140906d = new CompositeDisposable();
        MultiTypeAdapter r105 = new MultiTypeAdapter();
        this.f140903a = r105;
        SpaceItemDecoration r106 = new SpaceItemDecoration(1, r103, true);
        this.f140905c = r106;
        this.f140904b = new MessageListScrollManager(r100, r101, r102, r104);
        r100.setItemViewCacheSize(4);
        r100.addItemDecoration(r106);
        r100.setAdapter(r105);
    }
}
