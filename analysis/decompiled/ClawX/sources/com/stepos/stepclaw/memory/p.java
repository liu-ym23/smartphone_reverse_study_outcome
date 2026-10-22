package com.stepos.stepclaw.memory;

import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1675a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1676b;

    public /* synthetic */ p(boolean z, int i8) {
        this.f1675a = i8;
        this.f1676b = z;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f1675a;
        boolean z = this.f1676b;
        switch (i8) {
            case 0:
                return MemoryEngine.readStepMemAsString$lambda$2$0(z, (MemoryRecord) obj);
            case 1:
                return MemoryEngine.readStepMemAsString$lambda$2(z, (Map.Entry) obj);
            default:
                return MemoryEngine.readStepMemAsString$lambda$4(z, (MemoryRecord) obj);
        }
    }
}
