package com.google.android.material.datepicker;

import com.stepos.alphame.scene.NewAppEventCollector;
import kotlin.text.Typography;

/* renamed from: com.google.android.material.datepicker.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0428g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10673a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10674b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10675c;

    public /* synthetic */ RunnableC0428g(int i4, long j4, Object obj) {
        this.f10673a = i4;
        this.f10675c = obj;
        this.f10674b = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f10673a;
        long j4 = this.f10674b;
        Object obj = this.f10675c;
        switch (i4) {
            case 0:
                AbstractC0429h abstractC0429h = (AbstractC0429h) obj;
                abstractC0429h.getClass();
                abstractC0429h.f10676a.setError(String.format(abstractC0429h.f10680e, B0.f.C(j4).replace(' ', Typography.nbsp)));
                abstractC0429h.a();
                break;
            default:
                NewAppEventCollector.lambda$onActivityStateChange$0((String) obj, j4);
                break;
        }
    }
}
