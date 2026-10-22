package com.bytedance.android.ec.window.base.common.taskgraph.context;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/taskgraph/context/NodeType;", "", "LINK", "COLLECTOR", "SOURCE", EffectConstants.NORMAL, "SINK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType COLLECTOR = null;
    public static final NodeType LINK = null;
    public static final NodeType NORMAL = null;
    public static final NodeType SINK = null;
    public static final NodeType SOURCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f49206a = null;

    static {
        NodeType r100 = new NodeType("LINK", 0);
        LINK = r100;
        NodeType r101 = new NodeType("COLLECTOR", 1);
        COLLECTOR = r101;
        NodeType r102 = new NodeType("SOURCE", 2);
        SOURCE = r102;
        NodeType r103 = new NodeType(EffectConstants.NORMAL, 3);
        NORMAL = r103;
        NodeType r104 = new NodeType("SINK", 4);
        SINK = r104;
        f49206a = new NodeType[]{r100, r101, r102, r103, r104};
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) a.a(NodeType.class, r100);
    }

    public static NodeType[] values() {
        return (NodeType[]) f49206a.clone();
    }

    public NodeType(String r100, int r101) {
        super(r100, r101);
    }
}
