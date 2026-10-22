package com.bytedance.android.live.room.api.experience.context;

import com.bytedance.android.live.room.api.experience.service.IPlatformExpService;
import com.bytedance.live.datacontext.DataContext;
import d61.a;
import i61.b;
import java.util.List;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/context/PlatformExpRoomContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Ld61/a;", "Lf61/a;", "workshop", "Lf61/a;", "getWorkshop", "()Lf61/a;", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PlatformExpRoomContext extends DataContext implements a {
    private final f61.a workshop;

    public abstract /* synthetic */ e61.a getDispatch();

    public abstract /* synthetic */ List<b> getProducers();

    public PlatformExpRoomContext() {
        this.workshop = ((IPlatformExpService) k.n(IPlatformExpService.class)).provideWorkshop(this);
    }

    @Override // d61.a
    public f61.a getWorkshop() {
        return this.workshop;
    }
}
