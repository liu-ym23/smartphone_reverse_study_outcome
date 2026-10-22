package com.smt.obric.appstore.domain.oapplet;

import android.content.Context;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class GetAllOAppletUseCase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18055b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18056a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final AppInfo a(OAppletInfo r10, Context r11) {
            q.g(r10, "<this>");
            q.g(r11, "context");
            Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
            Object r13 = Result.m35constructorimpl(Boolean.valueOf(q.b(r11.getResources().getConfiguration().getLocales().get(0).getLanguage(), "en")));     // Catch: Throwable -> L5
        L8:
            if (Result.m41isFailureimpl(r13) == false) goto L10;
            r13 = null;
        L10:
            boolean r14 = q.b(r13, Boolean.TRUE);
            AppInfo r15 = new AppInfo();
            if (r14 == false) goto L13;
            String r16 = r10.getLabel_en();
        L14:
            if (r16 != null) goto L16;
            r16 = "";
        L16:
            r15.appName = r16;
            r15.appIcon = r10.getIcon();
            r15.appVersionCode = 0;
            OAppletUtil r17 = OAppletUtil.f18065a;
            r15.appPackageName = r17.j(r10.getPackageName());
            r15.obricPreloadApkFilePath = r17.a(r10.getPackageName());
            if (r10.getInstalled() == false) goto L19;
            int r18 = 128;
        L20:
            r15.appState = r18;
            return r15;
        L19:
            r18 = 32;
            goto L20
        L13:
            r16 = r10.getLabel_cn();
        L5:
            th = move-exception;
            Result.a r19 = Result.Companion;
            r13 = Result.m35constructorimpl(c.a(th));
            goto L8
        }

        public a() {
        }
    }

    static {
        f18055b = new a(null);
    }

    public GetAllOAppletUseCase(Context r10) {
        q.g(r10, "context");
        this.f18056a = r10;
    }

    public static final /* synthetic */ Context a(GetAllOAppletUseCase r10) {
        return r10.f18056a;
    }

    public final Object b(Continuation r10) {
        if ((r10 instanceof GetAllOAppletUseCase$invoke$1) == false) goto L7;
        GetAllOAppletUseCase$invoke$1 r11 = (GetAllOAppletUseCase$invoke$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L17;
        if (r15 != 1) goto L16;
        c.b(r13);     // Catch: Throwable -> L13
    L21:
        Object r16 = Result.m35constructorimpl((List) r13);     // Catch: Throwable -> L13
    L24:
        Throwable r17 = Result.m38exceptionOrNullimpl(r16);
        if (r17 == null) goto L31;
        j.q("[OApplet][GetAllOAppletUseCase] Get deleted sys apps failed", r17);
        return Result.m35constructorimpl(t.i());
    L31:
        return Result.m35constructorimpl((List) r16);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        c.b(r13);
        j.n("[OApplet][GetAllOAppletUseCase]");
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L13
        CoroutineDispatcher r19 = l0.b();     // Catch: Throwable -> L13
        GetAllOAppletUseCase$invoke$2$1 r20 = new GetAllOAppletUseCase$invoke$2$1(this, null);     // Catch: Throwable -> L13
        r11.label = 1;     // Catch: Throwable -> L13
        r13 = h.g(r19, r20, r11);     // Catch: Throwable -> L13
        if (r13 != r14) goto L21;
        return r14;
    L13:
        th = move-exception;
        Result.a r21 = Result.Companion;
        r16 = Result.m35constructorimpl(c.a(th));
    L7:
        r11 = new GetAllOAppletUseCase$invoke$1(this, r10);
        goto L8
    }
}
