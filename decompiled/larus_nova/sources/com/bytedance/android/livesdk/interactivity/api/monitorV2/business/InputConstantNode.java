package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/InputConstantNode;", "", "", "nodeName", "Ljava/lang/String;", "getNodeName", "()Ljava/lang/String;", "InputLoadTime", "InputPrepareViewTime", "InputShowCostTime", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputConstantNode extends Enum<InputConstantNode> {
    public static final InputConstantNode InputLoadTime = null;
    public static final InputConstantNode InputPrepareViewTime = null;
    public static final InputConstantNode InputShowCostTime = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputConstantNode[] f133341a = null;
    private final String nodeName;

    static {
        InputConstantNode r100 = new InputConstantNode("InputLoadTime", 0, "input_load_cost_time");
        InputLoadTime = r100;
        InputConstantNode r101 = new InputConstantNode("InputPrepareViewTime", 1, "input_prepare_view_cost_time");
        InputPrepareViewTime = r101;
        InputConstantNode r102 = new InputConstantNode("InputShowCostTime", 2, "input_show_cost_time");
        InputShowCostTime = r102;
        f133341a = new InputConstantNode[]{r100, r101, r102};
    }

    public static InputConstantNode valueOf(String r100) {
        return (InputConstantNode) a.a(InputConstantNode.class, r100);
    }

    public static InputConstantNode[] values() {
        return (InputConstantNode[]) f133341a.clone();
    }

    public final String getNodeName() {
        return this.nodeName;
    }

    public InputConstantNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.nodeName = r102;
    }
}
