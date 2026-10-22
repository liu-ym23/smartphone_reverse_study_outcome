package com.bytedance.android.livesdk.interactivity.comment.record.guide.handler;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.RecordGuideContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.comment.record.guide.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f136153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Long, String> f136154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, Observable<String>> f136155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f136156e;

    public d() {
        this.f136153b = "DownloadHandler";
        this.f136154c = new LinkedHashMap();
        this.f136155d = new LinkedHashMap();
        this.f136156e = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.a, com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void b() {
        super.b();
        int r100 = e72.c.f471166a;
        e72.c.a(this.f136156e);
        e72.c.a(CollectionsKt.toMutableList(((LinkedHashMap) this.f136154c).values()));
        ((LinkedHashMap) this.f136155d).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.a, com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void a(RecordGuideContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((LinkedHashMap) this.f136155d).clear();
    }

    public final Observable<String> c(com.bytedance.android.livesdk.interactivity.comment.record.guide.n r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        String r100 = (String) ((LinkedHashMap) this.f136154c).get(Long.valueOf(r110.f136184c.e()));
        if (r100 != null) goto L5;
    L11:
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r101 = r110.f136184c;
        Observable<String> r102 = (Observable) ((LinkedHashMap) this.f136155d).get(Long.valueOf(r101.e()));
        if (r102 != null) goto L17;
        long r103 = r101.e();
        Observable<String> r111 = Observable.create(new c(this, r101, r110, r103)).subscribeOn(Schedulers.io());
        this.f136155d.put(Long.valueOf(r103), r111);
        return r111;
    L17:
        return r102;
    L5:
        if ((!FileUtils.isFileEmpty(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        Observable<String> r104 = Observable.just(r100);
        if (r104 == null) goto L11;
        return r104;
    }
}
