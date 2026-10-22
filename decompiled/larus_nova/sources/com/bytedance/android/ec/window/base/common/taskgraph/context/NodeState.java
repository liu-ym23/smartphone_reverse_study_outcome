package com.bytedance.android.ec.window.base.common.taskgraph.context;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/taskgraph/context/NodeState;", "", "IDLE", "RUNNING", "DONE", "ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NodeState extends Enum<NodeState> {
    public static final NodeState DONE = null;
    public static final NodeState ERROR = null;
    public static final NodeState IDLE = null;
    public static final NodeState RUNNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeState[] f49205a = null;

    static {
        NodeState r100 = new NodeState("IDLE", 0);
        IDLE = r100;
        NodeState r101 = new NodeState("RUNNING", 1);
        RUNNING = r101;
        NodeState r102 = new NodeState("DONE", 2);
        DONE = r102;
        NodeState r103 = new NodeState("ERROR", 3);
        ERROR = r103;
        f49205a = new NodeState[]{r100, r101, r102, r103};
    }

    public static NodeState valueOf(String r100) {
        return (NodeState) a.a(NodeState.class, r100);
    }

    public static NodeState[] values() {
        return (NodeState[]) f49205a.clone();
    }

    public NodeState(String r100, int r101) {
        super(r100, r101);
    }
}
