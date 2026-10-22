package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.os.Message;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnetuploader.uploader.api.UploadCode;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements IMessageListManager, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f140880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f140881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner<IMessageListManager.a> f140882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<c> f140883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Deque<c> f140884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f140885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f140886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f140887h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final PropertyOwner a() {
        PropertyOwner<IMessageListManager.a> r100 = this.f140882c;
        r100.getClass();
        return r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final PublishSubject b() {
        l r100 = this.f140887h.b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f140896b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final int c() {
        l r100 = this.f140887h.b();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f140895a;
    }

    public final int d() {
        l r100 = this.f140887h.b();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f140897c;
    }

    public final PublishSubject e() {
        l r100 = this.f140887h.b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f140898d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final b getConfig() {
        return this.f140887h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager
    public final List<c> getMessageList() {
        return this.f140883d;
    }

    public g(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f140887h = r100;
        this.f140880a = new WeakHandler(this);
        this.f140882c = new PropertyOwner(new IMessageListManager.a(IMessageListManager.MessageChangeType.RELOAD_ALL, 0, 0, 0, null, 30));
        this.f140883d = new ArrayList();
        this.f140884e = new ArrayDeque();
        this.f140885f = new CompositeDisposable();
        this.f140886g = new AtomicBoolean();
    }

    public final void f(c r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f140885f.isDisposed() == false) goto L8;
        pm0.a r101 = om0.c.c();
        if (r101 == null) goto L41;
        r101.i("MessageListManager", "MessageListManager insertMessage failed for disposed");
        return;
    L41:
        return;
    L8:
        List<d> r102 = this.f140887h.getInterceptors();
        Object r103 = null;
        if (r102 == null) goto L17;
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((d) r105).a(r100) == false) goto L12;
        r103 = r105;
    L16:
        r103 = (d) r103;
    L17:
        if (r103 == null) goto L20;
        return;
    L20:
        if (((ArrayDeque) this.f140884e).size() > this.f140887h.a().getMaxCount()) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == true) goto L35;
        if (((ArrayDeque) this.f140884e).size() <= this.f140887h.a().getMaxCount()) goto L31;
        ((ArrayDeque) this.f140884e).pollFirst();
    L31:
        if (r100.b() == false) goto L33;
        ((ArrayDeque) this.f140884e).addFirst(r100);
        goto L35
    L33:
        ((ArrayDeque) this.f140884e).addLast(r100);
    L35:
        if (this.f140886g.compareAndSet(false, true) == false) goto L42;
        this.f140880a.sendEmptyMessageDelayed(UploadCode.TT_UPLOAD_SERVER_DISK_NOT_ENOUGH, this.f140887h.d().a());
        return;
    L42:
        return;
    L22:
        if (this.f140887h.a().a() == false) goto L24;
        r106 = true;
        goto L25
    }

    public final void g(IMessageListManager.a r100) {
        l r101 = this.f140887h.b();
        if (r101 == null) goto L5;
        r101.onEvent(r100);
    L5:
        this.f140882c.a(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        if (r210.what != 20113) goto L54;
        e r100 = this.f140887h.d();
        int r101 = r100.c();
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L8:
        if (r103 >= r101) goto L28;
        c r104 = null;
        if (((ArrayDeque) this.f140884e).isEmpty() == false) goto L13;
    L25:
        if (r104 == null) goto L27;
        r102.add(r104);
    L27:
        r103 = r103 + 1;
        goto L8
    L13:
        if (((ArrayList) this.f140883d).isEmpty() == false) goto L24;
        Iterator r105 = ((ArrayDeque) this.f140884e).iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        Object r110 = r105.next();
        if ((!((c) r110).c()) == false) goto L16;
    L21:
        c r111 = (c) r110;
        if (r111 == null) goto L25;
        ((ArrayDeque) this.f140884e).remove(r111);
        r104 = r111;
        goto L25
    L20:
        r110 = null;
        goto L21
    L24:
        r104 = (c) ((ArrayDeque) this.f140884e).pollFirst();
        goto L25
    L28:
        Iterator r106 = r102.iterator();
    L30:
        if (r106.hasNext() == false) goto L41;
        c r112 = (c) r106.next();
        if (((ArrayList) this.f140883d).size() <= this.f140887h.c().getMaxCount()) goto L40;
        int r107 = this.f140887h.c().a();
        if (this.f140887h.c().b() == true) goto L36;
        ((ArrayList) this.f140883d).subList(0, r107).clear();
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.REMOVE_RANGE, 0, 0, r107, null, 18));
        goto L40
    L36:
        List<c> r108 = this.f140883d;
        hb2.a r109 = hb2.a.f484484b;
        if (((ArrayList) r108).contains(r109) == true) goto L39;
        ListProtector.add(this.f140883d, 0, r109);
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INSERT_ITEM, 0, 0, 0, r109, 12));
    L39:
        ((ArrayList) this.f140883d).subList(1, r107 + 1).clear();
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.REMOVE_RANGE, 0, 1, r107, null, 18));
    L40:
        ((ArrayList) this.f140883d).add(r112);
        g(new IMessageListManager.a(IMessageListManager.MessageChangeType.INSERT_BOTTOM, ((ArrayList) this.f140883d).size() - 1, 0, 0, r112, 12));
        goto L30
    L41:
        r100.b();
        this.f140880a.sendEmptyMessageDelayed(UploadCode.TT_UPLOAD_SERVER_DISK_NOT_ENOUGH, r100.a());
        return;
    }
}
