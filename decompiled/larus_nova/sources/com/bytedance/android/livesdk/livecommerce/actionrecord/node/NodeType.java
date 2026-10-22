package com.bytedance.android.livesdk.livecommerce.actionrecord.node;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/node/NodeType;", "", GXAnimation.STATE_START, "INFO", "SINGLE_NODE", "ERROR", "FAILURE", "SUCCESS", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType ERROR = null;
    public static final NodeType FAILURE = null;
    public static final NodeType INFO = null;
    public static final NodeType SINGLE_NODE = null;
    public static final NodeType START = null;
    public static final NodeType SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f147645a = null;

    static {
        NodeType r100 = new NodeType(GXAnimation.STATE_START, 0);
        START = r100;
        NodeType r101 = new NodeType("INFO", 1);
        INFO = r101;
        NodeType r102 = new NodeType("SINGLE_NODE", 2);
        SINGLE_NODE = r102;
        NodeType r103 = new NodeType("ERROR", 3);
        ERROR = r103;
        NodeType r104 = new NodeType("FAILURE", 4);
        FAILURE = r104;
        NodeType r105 = new NodeType("SUCCESS", 5);
        SUCCESS = r105;
        f147645a = new NodeType[]{r100, r101, r102, r103, r104, r105};
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) a.a(NodeType.class, r100);
    }

    public static NodeType[] values() {
        return (NodeType[]) f147645a.clone();
    }

    public NodeType(String r100, int r101) {
        super(r100, r101);
    }
}
