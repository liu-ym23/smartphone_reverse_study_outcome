package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.room.incentiveinfo.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u81.g;
import u81.h;
import vlc.l;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "Lu81/h;", "Lw81/b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", ce.f26391f, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseItemDataChangeMonitor implements h<w81.b>, l, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g<w81.b> f99640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f99641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public vlc.d f99642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f99643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f99644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRoom f99645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f99646g;

    public static final class a {
    }

    static {
    }

    public abstract List<String> d();

    public abstract void e(tlc.d r100);

    @Override // u81.h
    public final void reset() {
        this.f99640a = null;
        this.f99641b.clear();
        vlc.d r100 = this.f99642c;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    @Override // u81.h
    public void a() {
        DataCenter r100 = this.f99644e;
        vlc.d r101 = null;
        if (r100 == null) goto L5;
        r101 = (vlc.d) r100.get("data_message_manager", null);
    L5:
        this.f99642c = r101;
        if (r101 == null) goto L13;
        Iterator<T> r102 = d().iterator();
    L9:
        if (r102.hasNext() == false) goto L23;
        String r103 = (String) r102.next();
        vlc.d r104 = this.f99642c;
        if (r104 == null) goto L9;
        r104.addMessageListener(r103, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r105 = this.f99644e;
        if (r105 == null) goto L22;
        r105.observe("data_message_manager", this);
        return;
    }

    public final Context getContext() {
        return this.f99646g;
    }

    @Override // u81.h
    public final void b(i r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f99640a = r100;
    }

    public final void c(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoBind");
        this.f99641b.add(r100);
    }

    public final void f(w81.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        g<w81.b> r101 = this.f99640a;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r102.equals("data_message_manager") == false) goto L22;
        vlc.d r103 = (vlc.d) r101.getData();
        if (r103 == null) goto L30;
        this.f99642c = r103;
        Iterator<T> r104 = d().iterator();
    L18:
        if (r104.hasNext() == false) goto L31;
        String r105 = (String) r104.next();
        vlc.d r106 = this.f99642c;
        if (r106 == null) goto L18;
        r106.addMessageListener(r105, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L5;
        e(r100);
        return;
    }

    public BaseItemDataChangeMonitor(DataCenter r100, IRoom r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f99644e = r100;
        this.f99645f = r101;
        this.f99646g = r102;
        this.f99641b = new CompositeDisposable();
    }
}
