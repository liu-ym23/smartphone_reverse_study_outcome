package com.bytedance.android.livesdk.ceremony.viewmodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerLoopListener;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f104996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ITextureViewPlayerController f104997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super List<String>, Unit> f104998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f104999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f105000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InterfaceC1580a f105001f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ceremony.viewmodel.a$a, reason: collision with other inner class name */
    public interface InterfaceC1580a {
        void a(float r100, float r101, float r102, float r103);

        boolean needContinueLoop();

        void onEnd();

        void onFileLoaded(int r100, int r101);

        void onStart();

        void onStop();
    }

    public static final class b implements IPlayerActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f105002a;

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.CC.$default$onFirstFrame(this);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final /* synthetic */ void onReportPlayMetrics(Map r100) {
            IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onEnd() {
            InterfaceC1580a r100 = this.f105002a.f105001f;
            if (r100 == null) goto L6;
            r100.onEnd();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStart() {
            InterfaceC1580a r100 = this.f105002a.f105001f;
            if (r100 == null) goto L6;
            r100.onStart();
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onStop() {
            InterfaceC1580a r100 = this.f105002a.f105001f;
            if (r100 == null) goto L6;
            r100.onStop();
            return;
        }

        public b(a r100) {
            this.f105002a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void onFileLoaded(int r100, int r101) {
            InterfaceC1580a r102 = this.f105002a.f105001f;
            if (r102 == null) goto L6;
            r102.onFileLoaded(r100, r101);
            return;
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
        public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
            InterfaceC1580a r104 = this.f105002a.f105001f;
            if (r104 == null) goto L6;
            r104.a(r100, r101, r102, r103);
            return;
        }
    }

    public static final class c implements IPlayerLoopListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f105003a;

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerLoopListener
        public final boolean needContinueLoop() {
            InterfaceC1580a r100 = this.f105003a.f105001f;
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.needContinueLoop();
        }

        public c(a r100) {
            this.f105003a = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f105004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f105005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f105006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f105007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f105008e;

        public d(a r100, List r101, String r102, boolean r103, boolean r104) {
            this.f105004a = r100;
            this.f105005b = r101;
            this.f105006c = r102;
            this.f105007d = r103;
            this.f105008e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ITextureViewPlayerController r100 = this.f105004a.f104997b;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            ITextureViewPlayerController.DefaultImpls.start$default(r100, this.f105006c, this.f105007d, false, this.f105008e, null, 20, null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a() {
        ITextureViewPlayerController r100 = this.f104997b;
        if (r100 == null) goto L5;
        r100.removePlayerActionListener();
    L5:
        FrameLayout r101 = this.f104996a;
        if (r101 == null) goto L10;
        ITextureViewPlayerController r102 = this.f104997b;
        if (r102 == null) goto L10;
        r102.detachAlphaView(r101);
    L10:
        ITextureViewPlayerController r103 = this.f104997b;
        if (r103 == null) goto L13;
        r103.release();
    L13:
        this.f104996a = null;
        this.f104997b = null;
    }

    public a() {
        this.f104999d = new b(this);
        this.f105000e = new c(this);
    }

    public static void b(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$safePut");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Context r110, FrameLayout r111, String r112, boolean r113, List<MaskSrc> r114, boolean r115, long r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "videoContainer");
        Intrinsics.checkNotNullParameter(r112, "filePath");
        Intrinsics.checkNotNullParameter(r117, "source");
        this.f104996a = r111;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r117, "source");
        Boolean r100 = null;
        if (this.f104997b == null) goto L5;
    L31:
        ITextureViewPlayerController r101 = this.f104997b;
        if (r101 == null) goto L45;
        if (r114 == null) goto L38;
        Iterator<T> r102 = r114.iterator();
    L36:
        if (r102.hasNext() == false) goto L38;
        r101.setMaskSrc((MaskSrc) r102.next());
    L38:
        Function1<? super List<String>, Unit> r103 = this.f104998c;
        if (r103 == null) goto L41;
        r101.setOnElementClickListener(r103);
    L41:
        View r104 = r101.getAlphaView();
        if (r104 == null) goto L44;
        r100 = Boolean.valueOf(r104.postDelayed(new d(this, r114, r112, r113, r115), 1000));
    L44:
        if (r100 == null) goto L45;
        return;
    L45:
        this.f104999d.onEnd();
        Unit r105 = Unit.INSTANCE;
        return;
    L5:
        if ((r110 instanceof FragmentActivity) == false) goto L31;
        ITextureViewPlayerController r106 = ((IGiftServiceExternal) k.n(IGiftServiceExternal.class)).giftPlayControllerManager().createTextureViewPlayer((LifecycleOwner) r110);
        this.f104997b = r106;
        if (r106 == null) goto L9;
        r106.setPlayerActionListener(this.f104999d);
    L9:
        ITextureViewPlayerController r107 = this.f104997b;
        if (r107 == null) goto L12;
        r107.setPlayerLooperListener(this.f105000e);
    L12:
        ITextureViewPlayerController r108 = this.f104997b;
        if (r108 == null) goto L23;
        View r109 = r108.getAlphaView();
        if (r109 == null) goto L23;
        ViewParent r118 = r109.getParent();
        if (r118 == null) goto L23;
        ViewGroup r119 = (ViewGroup) r118;
        ITextureViewPlayerController r120 = this.f104997b;
        if (r120 == null) goto L21;
        View r121 = r120.getAlphaView();
    L22:
        r119.removeView(r121);
        goto L23
    L21:
        r121 = null;
    L23:
        ITextureViewPlayerController r122 = this.f104997b;
        if (r122 == null) goto L26;
        r122.setMonitor(new com.bytedance.android.livesdk.ceremony.viewmodel.b(this, r116, r117));
    L26:
        FrameLayout r123 = this.f104996a;
        if (r123 == null) goto L31;
        ITextureViewPlayerController r124 = this.f104997b;
        if (r124 == null) goto L31;
        r124.attachAlphaView(r123);
        goto L31
    }
}
