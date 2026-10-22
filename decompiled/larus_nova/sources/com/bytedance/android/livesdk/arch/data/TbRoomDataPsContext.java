package com.bytedance.android.livesdk.arch.data;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class TbRoomDataPsContext extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> f103782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> f103783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f103784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TbDataFromType f103785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ILiveToolbarData f103786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PipeType f103787j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/arch/data/TbRoomDataPsContext$PipeType;", "", "Unknown", "EnterRoomToolbar", "EnterMorePanel", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PipeType extends Enum<PipeType> {
        public static final PipeType EnterMorePanel = null;
        public static final PipeType EnterRoomToolbar = null;
        public static final PipeType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PipeType[] f103788a = null;

        static {
            PipeType r100 = new PipeType("Unknown", 0);
            Unknown = r100;
            PipeType r101 = new PipeType("EnterRoomToolbar", 1);
            EnterRoomToolbar = r101;
            PipeType r102 = new PipeType("EnterMorePanel", 2);
            EnterMorePanel = r102;
            f103788a = new PipeType[]{r100, r101, r102};
        }

        public static PipeType valueOf(String r100) {
            return (PipeType) r27.a.a(PipeType.class, r100);
        }

        public static PipeType[] values() {
            return (PipeType[]) f103788a.clone();
        }

        public PipeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.bytedance.android.livesdk.arch.data.c
    public final c b() {
        TbRoomDataPsContext r100 = new TbRoomDataPsContext(getContext(), this.f103791b, this.f103792c, this.f103793d, this.f103784g, this.f103785h, this.f103786i, this.f103787j);
        r100.e(this.f103783f);
        return r100;
    }

    public final void e(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> r100) {
        Intrinsics.checkNotNullParameter(r100, "newToolbarModels");
        ((ArrayList) this.f103782e).clear();
        ArrayList r101 = (ArrayList) this.f103782e;
        r101.addAll(r100);
    }

    public TbRoomDataPsContext(Context r100, MiddlewareRoomContext r101, IRoom r102, DataCenter r103, boolean r104, TbDataFromType r105, ILiveToolbarData r106, PipeType r107) {
        Intrinsics.checkNotNullParameter(r105, "fromType");
        Intrinsics.checkNotNullParameter(r107, "pipeType");
        super(r100, r101, r102, r103);
        this.f103784g = r104;
        this.f103785h = r105;
        this.f103786i = r106;
        this.f103787j = r107;
        ArrayList r108 = new ArrayList();
        this.f103782e = r108;
        this.f103783f = r108;
    }
}
