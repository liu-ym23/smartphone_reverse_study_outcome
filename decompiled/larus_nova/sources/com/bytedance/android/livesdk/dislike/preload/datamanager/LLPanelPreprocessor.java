package com.bytedance.android.livesdk.dislike.preload.datamanager;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveFeedbackManager;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.DislikeOptionsBottomDialog;
import com.bytedance.android.livesdk.dislike.m;
import com.bytedance.android.livesdk.dislike.preload.loader.LPPanelOriginDataLoader;
import com.bytedance.android.livesdk.dislike.preload.loader.b;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LLPanelPreprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f122175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActionsManager f122176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f122177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LPPanelOriginDataLoader f122178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f122179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.dislike.preload.loader.watchlater.a f122180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f122181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f122182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f122183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f122184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Room f122185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f122186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f122187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f122188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bundle f122189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Fragment f122190p;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LLPanelPreprocessor f122191a;

        @Override // com.bytedance.android.livesdk.dislike.m
        public final String a() {
            return this.f122191a.a().V0;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void b() {
            this.f122191a.a().ia0();
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final boolean c() {
            DislikeOptionsBottomDialog r100 = this.f122191a.a();
            if (r100.ea0() == false) goto L9;
            ILiveFeedbackManager r101 = r100.R;
            if (r101 == null) goto L9;
            if (r101.enableOptionsStyle() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void dismiss() {
            this.f122191a.a().dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public Context getContext() {
            return this.f122191a.getContext();
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void refreshData() {
            LPPanelOriginDataLoader r100 = this.f122191a.f122178d;
            r100.f122195e = true;
            r100.f();
        }

        public a(LLPanelPreprocessor r100) {
            this.f122191a = r100;
        }
    }

    public final DislikeOptionsBottomDialog a() {
        return (DislikeOptionsBottomDialog) this.f122175a.getValue();
    }

    public final Context getContext() {
        return this.f122183i;
    }

    public LLPanelPreprocessor(Context r100, DataCenter r101, Room r102, String r110, String r111, boolean r112, Bundle r113, Fragment r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f122183i = r100;
        this.f122184j = r101;
        this.f122185k = r102;
        this.f122186l = r110;
        this.f122187m = r111;
        this.f122188n = r112;
        this.f122189o = r113;
        this.f122190p = r114;
        this.f122175a = LazyKt.lazy(new LLPanelPreprocessor$dialog$2(this));
        a r103 = new a(this);
        if (r110 != null) goto L5;
        String r104 = "";
    L6:
        if (r111 != null) goto L8;
        String r105 = "";
    L9:
        this.f122176b = new ActionsManager(r103, r102, r104, r105, r101);
        Lazy r106 = LazyKt.lazy(new LLPanelPreprocessor$session$2(this));
        this.f122177c = r106;
        this.f122178d = new LPPanelOriginDataLoader((com.bytedance.android.livesdk.dislike.preload.context.a) r106.getValue());
        this.f122179e = new b((com.bytedance.android.livesdk.dislike.preload.context.a) r106.getValue());
        this.f122180f = new com.bytedance.android.livesdk.dislike.preload.loader.watchlater.a((com.bytedance.android.livesdk.dislike.preload.context.a) r106.getValue());
        this.f122181g = new CompositeDisposable();
        this.f122182h = LazyKt.lazy(new LLPanelPreprocessor$loaders$2(this));
        return;
    L8:
        r105 = r111;
        goto L9
    L5:
        r104 = r110;
        goto L6
    }
}
