package com.bytedance.android.livesdk.end;

import android.view.View;
import com.alipay.sdk.m.x.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b;\u0010<R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00102\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R*\u00105\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R*\u00108\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/\"\u0004\b:\u00101¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/end/LiveEndPageData;", "", "Landroid/view/View;", "content", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "", "topView", "Ljava/lang/String;", "getTopView", "()Ljava/lang/String;", "setTopView", "(Ljava/lang/String;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "", "margins", "Ljava/util/List;", "getMargins", "()Ljava/util/List;", "setMargins", "(Ljava/util/List;)V", "hideViews", "getHideViews", "setHideViews", ControlRule.KEY_EXTRA_DATA, "Ljava/lang/Object;", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "Lkotlin/Function0;", "", d.f25928r, "Lkotlin/jvm/functions/Function0;", "getOnExit", "()Lkotlin/jvm/functions/Function0;", "setOnExit", "(Lkotlin/jvm/functions/Function0;)V", "onUnloadCallback", "getOnUnloadCallback", "setOnUnloadCallback", "onHideFragmentCallback", "getOnHideFragmentCallback", "setOnHideFragmentCallback", "onShowFragmentCallback", "getOnShowFragmentCallback", "setOnShowFragmentCallback", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEndPageData {
    public static final a Companion = null;
    public static final String TAG_APPOINTMENT_V2 = "appointment_v2";
    public static final String TAG_AVATAR = "avatar";
    public static final String TAG_COUNT = "count";
    public static final String TAG_LIVE_TAB = "live_tab";
    public static final String TAG_NAME = "name";
    public static final String TAG_OPEN_PUSH = "open_push";
    public static final String TAG_PREDICTION = "prediction";
    public static final String TAG_RANK = "rank";
    public static final String TAG_RECOMMEND = "recommend";
    public static final String TAG_REPLAY = "replay";
    public static final String TAG_RESERVATION = "reservation";
    public static final String TAG_SUBSCRIPTION = "subscription";
    public static final String TAG_TITLE = "title";
    public static final String TAG_WINDOW = "window";
    private View content;
    private Object extraData;
    private int height;
    private List<String> hideViews;
    private List<Integer> margins;
    private Function0<Unit> onExit;
    private Function0<Unit> onHideFragmentCallback;
    private Function0<Unit> onShowFragmentCallback;
    private Function0<Unit> onUnloadCallback;
    private String topView;
    private int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LiveEndPageData() {
        this.topView = "";
        this.margins = CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 0});
        this.hideViews = new ArrayList();
    }

    public final View getContent() {
        return this.content;
    }

    public final Object getExtraData() {
        return this.extraData;
    }

    public final int getHeight() {
        return this.height;
    }

    public final List<String> getHideViews() {
        return this.hideViews;
    }

    public final List<Integer> getMargins() {
        return this.margins;
    }

    public final Function0<Unit> getOnExit() {
        return this.onExit;
    }

    public final Function0<Unit> getOnHideFragmentCallback() {
        return this.onHideFragmentCallback;
    }

    public final Function0<Unit> getOnShowFragmentCallback() {
        return this.onShowFragmentCallback;
    }

    public final Function0<Unit> getOnUnloadCallback() {
        return this.onUnloadCallback;
    }

    public final String getTopView() {
        return this.topView;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setContent(View r100) {
        this.content = r100;
    }

    public final void setExtraData(Object r100) {
        this.extraData = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setHideViews(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hideViews = r100;
    }

    public final void setMargins(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.margins = r100;
    }

    public final void setOnExit(Function0<Unit> r100) {
        this.onExit = r100;
    }

    public final void setOnHideFragmentCallback(Function0<Unit> r100) {
        this.onHideFragmentCallback = r100;
    }

    public final void setOnShowFragmentCallback(Function0<Unit> r100) {
        this.onShowFragmentCallback = r100;
    }

    public final void setOnUnloadCallback(Function0<Unit> r100) {
        this.onUnloadCallback = r100;
    }

    public final void setTopView(String r100) {
        this.topView = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
