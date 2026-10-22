package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public interface IComponentScheduler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$LoadBatch;", "", "BASE", "PRELOAD", "FIRST_SCREEN", DiagnoseResult.DIAGNOSE_LEVEL_P0, DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "POTHER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadBatch extends Enum<LoadBatch> {
        public static final LoadBatch BASE = null;
        public static final LoadBatch FIRST_SCREEN = null;
        public static final LoadBatch P0 = null;
        public static final LoadBatch P1 = null;
        public static final LoadBatch P2 = null;
        public static final LoadBatch POTHER = null;
        public static final LoadBatch PRELOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadBatch[] f112849a = null;

        static {
            LoadBatch r100 = new LoadBatch("BASE", 0);
            BASE = r100;
            LoadBatch r101 = new LoadBatch("PRELOAD", 1);
            PRELOAD = r101;
            LoadBatch r102 = new LoadBatch("FIRST_SCREEN", 2);
            FIRST_SCREEN = r102;
            LoadBatch r103 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P0, 3);
            P0 = r103;
            LoadBatch r104 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P1, 4);
            P1 = r104;
            LoadBatch r105 = new LoadBatch(DiagnoseResult.DIAGNOSE_LEVEL_P2, 5);
            P2 = r105;
            LoadBatch r106 = new LoadBatch("POTHER", 6);
            POTHER = r106;
            f112849a = new LoadBatch[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static LoadBatch valueOf(String r100) {
            return (LoadBatch) r27.a.a(LoadBatch.class, r100);
        }

        public static LoadBatch[] values() {
            return (LoadBatch[]) f112849a.clone();
        }

        public LoadBatch(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$LoadMode;", "", "DIRECT", "PREVIEW", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadMode extends Enum<LoadMode> {
        public static final LoadMode DIRECT = null;
        public static final LoadMode PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadMode[] f112850a = null;

        static {
            LoadMode r100 = new LoadMode("DIRECT", 0);
            DIRECT = r100;
            LoadMode r101 = new LoadMode("PREVIEW", 1);
            PREVIEW = r101;
            f112850a = new LoadMode[]{r100, r101};
        }

        public static LoadMode valueOf(String r100) {
            return (LoadMode) r27.a.a(LoadMode.class, r100);
        }

        public static LoadMode[] values() {
            return (LoadMode[]) f112850a.clone();
        }

        public LoadMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentScheduler$SchedulerType;", "", "LOAD_TASK_SCHEDULER", "COMPONENT_X_SCHEDULER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SchedulerType extends Enum<SchedulerType> {
        public static final SchedulerType COMPONENT_X_SCHEDULER = null;
        public static final SchedulerType LOAD_TASK_SCHEDULER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SchedulerType[] f112851a = null;

        static {
            SchedulerType r100 = new SchedulerType("LOAD_TASK_SCHEDULER", 0);
            LOAD_TASK_SCHEDULER = r100;
            SchedulerType r101 = new SchedulerType("COMPONENT_X_SCHEDULER", 1);
            COMPONENT_X_SCHEDULER = r101;
            f112851a = new SchedulerType[]{r100, r101};
        }

        public static SchedulerType valueOf(String r100) {
            return (SchedulerType) r27.a.a(SchedulerType.class, r100);
        }

        public static SchedulerType[] values() {
            return (SchedulerType[]) f112851a.clone();
        }

        public SchedulerType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void b(LoadBatch r100);

        void d(LoadBatch r100, LayerDescriptorList r101);

        void e(LoadBatch r100);
    }

    void a();

    com.bytedance.android.livesdk.widgetdescriptor.priority.c b();

    void c();

    void d();

    void e();

    void f(InteractionComponentManager r100);

    void g();

    void h(boolean r100);

    void i();

    void j();

    void k();

    void l();

    void release();
}
