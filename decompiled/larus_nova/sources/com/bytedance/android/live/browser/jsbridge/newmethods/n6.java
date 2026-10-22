package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveHighlightTranscodingResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.highlightTranscoding")
public final class n6 extends w20.z2<w20.ua, LiveHighlightTranscodingResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f63565a;

    public n6() {
    }

    public static final void j(n6 r100, List r101) {
        r100.getClass();
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        if (new PolarisFileWrapper(r103).delete() == true) goto L4;
        ALogger.e("LiveHighlightTranscodingMethod", "delete failed, file path is " + r103);
        goto L4
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r210, CallContext r211) {
        n6 r110 = this;
        final w20.ua r111 = (w20.ua) r210;
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        ICommentService r100 = (ICommentService) jc1.k.f(ICommentService.class);
        Object r112 = null;
        if (r100 == null) goto L5;
        String r101 = r100.getCacheFilePath(getCallContext().getContext());
    L6:
        r110.f63565a = r101;
        final ICommentService r113 = (ICommentService) jc1.k.f(ICommentService.class);
        if (r113 == null) goto L62;
        LiveHighlightTranscodingResultModel r114 = new LiveHighlightTranscodingResultModel();
        final ArrayList r115 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        List<w20.ua.a> r104 = r111.b();
        if (r104 == null) goto L60;
        Iterator<T> r116 = r104.iterator();
    L12:
        if (r116.hasNext() == false) goto L60;
        final w20.ua.a r105 = (w20.ua.a) r116.next();
        String r106 = r105.a();
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        String r107 = r110.f63565a;
        if (r107 == null) goto L32;
        File[] r108 = new PolarisFileWrapper(r107).listFiles();
        if (r108 == null) goto L32;
        int r109 = r108.length;
        int r117 = 0;
    L21:
        if (r117 >= r109) goto L32;
        File r118 = r108[r117];
        if (r106.length() <= 0) goto L25;
        boolean r119 = true;
    L26:
        if (r119 == false) goto L31;
        if (StringsKt.contains$default(r118.getName(), r106, false, 2, r112) == false) goto L31;
        String r120 = r118.getAbsolutePath();
    L34:
        if (r120.length() <= 0) goto L36;
        boolean r121 = true;
    L37:
        if (r121 == false) goto L39;
        LiveHighlightTranscodingResultModel.b r122 = new LiveHighlightTranscodingResultModel.b();
        r122.a(r105.a());
        r122.b(r120);
        Unit r123 = Unit.INSTANCE;
        r103.add(r122);
        final ArrayList r212 = r103;
        ArrayList r124 = r102;
    L59:
        r110 = this;
        r114 = r114;
        r103 = r212;
        r102 = r124;
        r112 = null;
        goto L12
    L39:
        final ArrayList r125 = new ArrayList();
        List<String> r126 = r105.b();
        if (r126 != null) goto L42;
        r126 = CollectionsKt.emptyList();
    L42:
        int r127 = r126.size();
        String[] r128 = new String[r127];
        int r129 = 0;
    L43:
        if (r129 >= r127) goto L45;
        r128[r129] = "";
        r129 = r129 + 1;
        goto L43
    L45:
        int r130 = r126.size();
        int r131 = 0;
    L46:
        if (r131 >= r130) goto L58;
        String r132 = (String) ListProtector.get(r126, r131);
        if (r132 != null) goto L50;
    L53:
        boolean r133 = true;
    L54:
        if (r133 == true) goto L57;
        String r134 = r110.f63565a + File.separator + r131 + "_" + r105.a();
        r115.add(new Pair(r132, r134));
        r128[r131] = r134;
        ListProtector.add(r125, r131, r134);
    L57:
        r131 = r131 + 1;
        goto L46
    L50:
        if (r132.length() == 0) goto L53;
        r133 = false;
        goto L54
    L58:
        final String r135 = r110.f63565a + File.separator + System.currentTimeMillis() + '_' + r105.a() + "_highlight.mp4";
        final ArrayList r136 = r103;
        final ArrayList r137 = r102;
        r212 = r103;
        final ArrayList r213 = r102;
        r124 = r213;
        r124.add(Observable.concat(r113.createDownloadTask(r115), Observable.create(new m6(r128, r135, new LiveHighlightTranscodingMethod$concatVideo$$inlined$let$lambda$1(r125, r105, r135, r136, r115, r137, r113, this, r111), new LiveHighlightTranscodingMethod$concatVideo$$inlined$let$lambda$2(r125, r135, r212, r115, r213, r113, this, r111))).subscribeOn(Schedulers.io())));
        goto L59
    L36:
        r121 = false;
    L31:
        r117 = r117 + 1;
        r108 = r108;
        goto L21
    L25:
        r119 = false;
    L32:
        r120 = "";
    L60:
        Observable.zip(r102, k6.f63504a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(l6.f63543a, new i6(this, r111), new j6(r114, r103, this, r111));
        return;
    L62:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
