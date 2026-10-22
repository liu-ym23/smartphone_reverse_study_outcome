package com.stepos.core.ota;

import ad.i;
import android.content.res.TypedArray;
import android.view.View;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsActivity;
import com.stepos.aiengine.modelmanager.settings.ModelManagerSettingsActivity;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import d2.i;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import n8.e;
import v0.m0;
import v0.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ConfirmDecisionBus.StageListener, i.e, CallbackToFutureAdapter.b, r, i.c {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7542g;

    public /* synthetic */ d(int i10) {
        this.f7542g = i10;
    }

    public static Object d(StringBuilder sb2, String str, TrackerPayload trackerPayload, String str2) {
        sb2.append(str);
        return trackerPayload.getHeaderMap().get(str2);
    }

    public static String e(int i10, String str, int i11, String str2, String str3) {
        return str + i10 + str2 + i11 + str3;
    }

    public static String f(long j10, String str) {
        return str + j10;
    }

    public static String h(String str, int i10, String str2, String str3) {
        return str + str2 + str3 + i10;
    }

    public static String i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String j(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        return sb2.toString();
    }

    public static StringBuilder k(int i10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder l(String str, long j10, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(j10);
        return sb2;
    }

    public static StringBuilder m(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(z);
        sb2.append(str4);
        return sb2;
    }

    public static Thread n(Runnable runnable, String str, boolean z) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static void o(int i10, String str, String str2, String str3, StringBuilder sb2) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(i10);
        sb2.append(str3);
    }

    public static void p(long j10, String str, String str2, StringBuilder sb2) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(j10);
    }

    public static /* synthetic */ void q(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (!(autoCloseable instanceof TypedArray)) {
                throw new IllegalArgumentException();
            }
            ((TypedArray) autoCloseable).recycle();
            return;
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static void r(String str, String str2, PrintWriter printWriter) {
        printWriter.println(str + str2);
    }

    public static void s(StringBuilder sb2, int i10, String str, long j10) {
        sb2.append(i10);
        sb2.append(str);
        sb2.append(j10);
    }

    public static void t(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    @Override // d2.i.e
    public void a(i.d dVar, d2.i iVar) {
        switch (this.f7542g) {
            case 8:
                dVar.g(iVar);
                break;
            case 9:
                dVar.e(iVar);
                break;
            default:
                dVar.d();
                break;
        }
    }

    @Override // ad.i.c
    public ad.i b(okhttp3.internal.connection.d dVar) {
        return new e();
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
    public Object c(CallbackToFutureAdapter.a aVar) {
        return androidx.work.c.lambda$getForegroundInfoAsync$0(aVar);
    }

    @Override // v0.r
    public m0 g(View view, m0 m0Var) {
        switch (this.f7542g) {
            case 15:
                int i10 = AiEngineSettingsActivity.f5904d;
                n0.b bVarG = m0Var.f13309a.g(519);
                g.c(view);
                view.setPadding(view.getPaddingLeft(), bVarG.f10589b, view.getPaddingRight(), bVarG.f10591d);
                break;
            default:
                int i11 = ModelManagerSettingsActivity.f5907b;
                n0.b bVarG2 = m0Var.f13309a.g(519);
                g.c(view);
                view.setPadding(view.getPaddingLeft(), bVarG2.f10589b, view.getPaddingRight(), bVarG2.f10591d);
                break;
        }
        return m0Var;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
    public void onStage(ConfirmDecisionBus.SubStage subStage) {
        switch (this.f7542g) {
            case 1:
                g.f(subStage, "it");
                break;
            case 2:
                g.f(subStage, "it");
                break;
            case 3:
                g.f(subStage, "it");
                break;
            case 4:
                g.f(subStage, "it");
                break;
            default:
                g.f(subStage, "it");
                break;
        }
    }
}
