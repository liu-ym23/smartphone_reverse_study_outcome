package com.stepos.stepclaw.memory.upload;

import b4.c;
import p5.l;
import t3.d;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1755a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MemoryUploadClient f1756b;

    public /* synthetic */ a(MemoryUploadClient memoryUploadClient, int i8) {
        this.f1755a = i8;
        this.f1756b = memoryUploadClient;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f1755a;
        MemoryUploadClient memoryUploadClient = this.f1756b;
        switch (i8) {
            case 0:
                return MemoryUploadClient.httpClient$lambda$0(memoryUploadClient, (d) obj);
            default:
                return MemoryUploadClient.httpClient$lambda$0$0(memoryUploadClient, (c) obj);
        }
    }
}
