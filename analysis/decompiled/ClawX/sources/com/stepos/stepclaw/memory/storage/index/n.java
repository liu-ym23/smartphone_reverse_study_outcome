package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f1742b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1743c;

    public /* synthetic */ n(w wVar, String str, int i8) {
        this.f1741a = i8;
        this.f1742b = wVar;
        this.f1743c = str;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1741a) {
            case 0:
                return MemoryIndexManager.C00592.invokeSuspend$lambda$0$3(this.f1742b, this.f1743c);
            default:
                return BM25Index.evictDynamicBeforeDate$lambda$2(this.f1742b, this.f1743c);
        }
    }
}
