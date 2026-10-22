package com.stepos.stepclaw.memory.lightmem;

import b5.a0;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionGroup;
import java.io.IOException;
import kotlinx.serialization.internal.EnumDescriptor;
import u6.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1627a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1628b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1629c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(int i8, OfflineEvolutionGroup offlineEvolutionGroup, String str) {
        this.f1628b = i8;
        this.d = offlineEvolutionGroup;
        this.f1629c = str;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1627a) {
            case 0:
                return LightMemClient.logEvolutionGroupsSummary$lambda$1(this.f1628b, (OfflineEvolutionGroup) this.d, (String) this.f1629c);
            case 1:
                return EnumDescriptor.elementDescriptors_delegate$lambda$0(this.f1628b, (String) this.f1629c, (EnumDescriptor) this.d);
            default:
                n nVar = (n) this.d;
                try {
                    nVar.y.n(this.f1628b, (u6.b) this.f1629c);
                } catch (IOException e9) {
                    u6.b bVar = u6.b.d;
                    nVar.a(bVar, bVar, e9);
                }
                return a0.f883a;
        }
    }

    public /* synthetic */ c(int i8, String str, EnumDescriptor enumDescriptor) {
        this.f1628b = i8;
        this.f1629c = str;
        this.d = enumDescriptor;
    }

    public /* synthetic */ c(n nVar, int i8, u6.b bVar) {
        this.d = nVar;
        this.f1628b = i8;
        this.f1629c = bVar;
    }
}
