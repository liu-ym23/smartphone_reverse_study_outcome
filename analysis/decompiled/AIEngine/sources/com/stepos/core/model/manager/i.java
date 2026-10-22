package com.stepos.core.model.manager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.d;
import androidx.emoji2.text.g;
import androidx.work.impl.WorkDatabase;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.cloudsdk.ICloudListener;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Lambda;
import m7.a;
import xd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7456a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7457b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7458c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7459d;

    public /* synthetic */ i(Object obj, Object obj2, Object obj3, int i10) {
        this.f7456a = i10;
        this.f7457b = obj;
        this.f7458c = obj2;
        this.f7459d = obj3;
    }

    /* JADX WARN: Type inference failed for: r7v15, types: [kotlin.jvm.internal.Lambda, zb.a] */
    @Override // java.lang.Runnable
    public final void run() {
        ICloudListener.ResultCode resultCodeApplyInputStream;
        switch (this.f7456a) {
            case 0:
                ModelCacheImpl.remove$lambda$28$lambda$27((String) this.f7457b, (ModelCacheImpl) this.f7458c, (b7.a) this.f7459d);
                return;
            case 1:
                ModelConfirmFlow.tryAttach$lambda$10$lambda$9((ModelConfirmFlow) this.f7457b, (e6.a) this.f7458c, (ModelFlowStage) this.f7459d);
                return;
            case 2:
                ModelConfirmFlow.postStage$lambda$84((ModelConfirmFlow) this.f7457b, (List) this.f7458c, (ModelFlowStage) this.f7459d);
                return;
            case 3:
                com.stepos.cloudsdk.a aVar = (com.stepos.cloudsdk.a) this.f7458c;
                String str = (String) this.f7457b;
                ICloudListener iCloudListener = (ICloudListener) this.f7459d;
                aVar.getClass();
                try {
                    InputStream inputStreamA = aVar.a(str);
                    if (inputStreamA != null) {
                        resultCodeApplyInputStream = iCloudListener.applyInputStream(str, inputStreamA);
                        a4.a.k("CloudClientImpl", "notifyListeners: applyInputStream result=".concat(resultCodeApplyInputStream.f6417a));
                    } else {
                        resultCodeApplyInputStream = ICloudListener.ResultCode.FILE_NOT_EXIST;
                        Log.e("CloudSDK_".concat("CloudClientImpl"), "notifyListeners: failed to open file stream for key=" + str);
                    }
                    aVar.c(str, resultCodeApplyInputStream);
                    return;
                } catch (Exception e10) {
                    Log.e("CloudSDK_".concat("CloudClientImpl"), ai.onnxruntime.a.k("notifyListeners: listener callback failed for key=", str), e10);
                    aVar.c(str, ICloudListener.ResultCode.INNER_ERROR);
                    return;
                }
            case 4:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f7457b;
                CallbackToFutureAdapter.a aVar2 = (CallbackToFutureAdapter.a) this.f7458c;
                ?? r72 = (Lambda) this.f7459d;
                if (atomicBoolean.get()) {
                    return;
                }
                try {
                    aVar2.a(r72.invoke());
                    return;
                } catch (Throwable th) {
                    aVar2.b(th);
                    return;
                }
            case 5:
                EmojiCompatInitializer.b bVar = (EmojiCompatInitializer.b) this.f7457b;
                d.i iVar = (d.i) this.f7458c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f7459d;
                try {
                    androidx.emoji2.text.g gVarA = androidx.emoji2.text.a.a(bVar.f1922a);
                    if (gVarA == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    g.b bVar2 = (g.b) gVarA.f1939a;
                    synchronized (bVar2.f1962d) {
                        bVar2.f1964f = threadPoolExecutor;
                    }
                    gVarA.f1939a.a(new androidx.emoji2.text.e(iVar, threadPoolExecutor));
                    return;
                } catch (Throwable th2) {
                    iVar.a(th2);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 6:
                m7.a aVar3 = (m7.a) this.f7458c;
                String str2 = (String) this.f7457b;
                a.b bVar3 = (a.b) this.f7459d;
                try {
                    if (aVar3.f10503f.get(str2) == bVar3) {
                        bVar3.f10513d = aVar3.f10501d.invoke().longValue();
                        bVar3.f10510a = aVar3.f10500c.invoke().longValue();
                        bVar3.f10511b = false;
                    }
                    return;
                } finally {
                    bVar3.f10514e.set(false);
                }
            case 7:
                ((n7.b) this.f7457b).lambda$onReceive$0((Context) this.f7458c, (Intent) this.f7459d);
                return;
            case 8:
                WorkDatabase workDatabase = (WorkDatabase) this.f7458c;
                String str3 = (String) this.f7457b;
                androidx.work.impl.b bVar4 = (androidx.work.impl.b) this.f7459d;
                ArrayList arrayListG = workDatabase.w().g(str3);
                int size = arrayListG.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayListG.get(i10);
                    i10++;
                    androidx.work.impl.utils.a.a(bVar4, (String) obj);
                }
                return;
            default:
                h.a.C0173a c0173a = (h.a.C0173a) this.f7457b;
                xd.d dVar = (xd.d) this.f7458c;
                xd.r rVar = (xd.r) this.f7459d;
                h.a aVar4 = h.a.this;
                if (aVar4.f13796b.isCanceled()) {
                    dVar.a(aVar4, new IOException("Canceled"));
                    return;
                } else {
                    dVar.b(aVar4, rVar);
                    return;
                }
        }
    }

    public /* synthetic */ i(Object obj, String str, Object obj2, int i10) {
        this.f7456a = i10;
        this.f7458c = obj;
        this.f7457b = str;
        this.f7459d = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ i(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.a aVar, zb.a aVar2) {
        this.f7456a = 4;
        this.f7457b = atomicBoolean;
        this.f7458c = aVar;
        this.f7459d = (Lambda) aVar2;
    }
}
