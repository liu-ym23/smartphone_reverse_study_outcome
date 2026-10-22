package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements s22.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f134311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<IMEmoji> f134312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, IMEmoji> f134313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f134314d;

    @Override // s22.b
    public final List<IMEmoji> getEmojiList() {
        List<IMEmoji> r100 = this.f134312b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public n() {
        this.f134314d = true;
    }

    @Override // s22.b
    public final IMEmoji a(String r100) {
        Map<String, IMEmoji> r101 = this.f134313c;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    @Override // s22.b
    public final void b(String r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.f134314d == false) goto L13;
        if (r100 == null) goto L13;
        IHostBusiness r102 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r102 == null) goto L11;
        IHostIMService r103 = r102.getHostIMService();
        if (r103 == null) goto L11;
        r103.getEmojiVideoPathByName(r100, r101);
        return;
    L11:
        r101.invoke(null);
        return;
    L13:
        r101.invoke(null);
    }
}
