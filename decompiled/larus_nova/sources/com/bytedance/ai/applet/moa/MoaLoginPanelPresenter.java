package com.bytedance.ai.applet.moa;

import com.bytedance.ai.api.model.view.WidgetEvent;
import com.bytedance.mt.protector.impl.UriProtector;
import k2.u;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class MoaLoginPanelPresenter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f34821b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ai.applet.login.f f34822a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34823a = null;

        static {
            int[] r100 = new int[MoaLoginPanelType.values().length];
            r100[MoaLoginPanelType.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MoaLoginPanelType.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f34823a = r100;
        }
    }

    public static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f34824a = null;

        static {
            f34824a = new c();
        }

        public c() {
        }

        @Override // k2.u
        public final void a() {
        }

        @Override // k2.u
        public final void b() {
        }

        @Override // k2.u
        public final void c() {
        }

        @Override // k2.u
        public final void onDestroy() {
        }

        @Override // k2.u
        public void onEvent(WidgetEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // k2.u
        public final void onStart() {
        }
    }

    static {
    }

    public MoaLoginPanelPresenter() {
    }

    public final void b() {
        com.bytedance.ai.applet.login.f r100 = this.f34822a;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.f34822a = null;
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return "";
    L12:
        return UriProtector.parse("sslocal://webview").buildUpon().appendQueryParameter("url", r100).build().toString();
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final Object c(o r110, u2.j r111, MoaLoginPanelType r112, Function0<Unit> r113, Continuation<? super Result<Unit>> r114) {
        if ((r114 instanceof MoaLoginPanelPresenter$show$1) == false) goto L7;
        MoaLoginPanelPresenter$show$1 r100 = (MoaLoginPanelPresenter$show$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L18:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        MainCoroutineDispatcher r104 = Dispatchers.getMain().getImmediate();
        MoaLoginPanelPresenter$show$2 r116 = new MoaLoginPanelPresenter$show$2(this, r110, r111, r112, r113, null);
        r100.label = 1;
        r102 = BuildersKt.withContext(r104, r116, r100);
        if (r102 != r115) goto L18;
        return r115;
    L7:
        r100 = new MoaLoginPanelPresenter$show$1(this, r114);
        goto L8
    }
}
