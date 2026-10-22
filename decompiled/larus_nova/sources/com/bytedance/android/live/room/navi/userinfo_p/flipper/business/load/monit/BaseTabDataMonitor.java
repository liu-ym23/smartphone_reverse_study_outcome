package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s91.f;
import vlc.l;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "Ls91/b;", "Ls91/f;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTabDataMonitor implements s91.b<f>, l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s91.a<f> f99993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f99994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f99995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f99996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataContext f99997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f99998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f99999g;

    public void d(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public void g() {
        this.f99996d = null;
    }

    @Override // s91.b
    public void reset() {
        this.f99993a = null;
        this.f99994b.clear();
        vlc.d r100 = this.f99995c;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this);
    L5:
        this.f99998f.removeObserver(this);
        g();
    }

    @Override // s91.b
    public void a() {
        DataCenter r100 = this.f99998f;
        vlc.d r101 = null;
        if (r100 == null) goto L5;
        r101 = (vlc.d) r100.get("data_message_manager", null);
    L5:
        this.f99995c = r101;
        if (r101 == null) goto L15;
        List<String> r102 = c();
        if (r102 == null) goto L24;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L26;
        String r104 = (String) r103.next();
        vlc.d r105 = this.f99995c;
        if (r105 == null) goto L11;
        r105.addMessageListener(r104, this);
        goto L11
    L26:
        return;
    L24:
        return;
    L15:
        DataCenter r106 = this.f99998f;
        if (r106 == null) goto L25;
        r106.observe("data_message_manager", this);
        return;
    }

    public List<String> c() {
        return this.f99996d;
    }

    @Override // s91.b
    public final void b(o91.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f99993a = r100;
    }

    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        s91.a<f> r101 = this.f99993a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public void f(KVData r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getKey();
    L5:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.hashCode() == (-1434292000)) goto L11;
        return;
    L11:
        if (r101.equals("data_message_manager") == false) goto L23;
        vlc.d r102 = (vlc.d) r100.getData();
        if (r102 != null) goto L15;
        return;
    L15:
        this.f99995c = r102;
        List<String> r103 = c();
        if (r103 == null) goto L29;
        Iterator<T> r104 = r103.iterator();
    L19:
        if (r104.hasNext() == false) goto L32;
        String r105 = (String) r104.next();
        vlc.d r106 = this.f99995c;
        if (r106 == null) goto L19;
        r106.addMessageListener(r105, this);
        goto L19
    L32:
        return;
    L29:
        return;
    L23:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        f((KVData) r100);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L5;
        d(r100);
        return;
    }

    public BaseTabDataMonitor(DataContext r100, DataCenter r101, IRoom r102) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f99997e = r100;
        this.f99998f = r101;
        this.f99999g = r102;
        this.f99994b = new CompositeDisposable();
    }
}
