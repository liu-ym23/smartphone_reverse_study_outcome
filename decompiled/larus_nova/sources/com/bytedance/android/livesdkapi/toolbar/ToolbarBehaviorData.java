package com.bytedance.android.livesdkapi.toolbar;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/toolbar/ToolbarBehaviorData;", "", "", "behaviorMappingName", "Ljava/lang/String;", "getBehaviorMappingName", "()Ljava/lang/String;", "", "isFold", "Z", "()Z", "isFromMsg", "", "id", "I", "getId", "()I", ControlRule.KEY_EXTRA_DATA, "getExtraData", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "<init>", "(Ljava/lang/String;ZZILjava/lang/String;Lpy/k;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarBehaviorData {
    private final String behaviorMappingName;
    private final String extraData;
    private final k icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f162655id;
    private final boolean isFold;
    private final boolean isFromMsg;

    public final String getBehaviorMappingName() {
        return this.behaviorMappingName;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final k getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.f162655id;
    }

    public final boolean isFold() {
        return this.isFold;
    }

    public final boolean isFromMsg() {
        return this.isFromMsg;
    }

    public ToolbarBehaviorData(String r100, boolean r101, boolean r102, int r103, String r104, k r105) {
        Intrinsics.checkNotNullParameter(r100, "behaviorMappingName");
        Intrinsics.checkNotNullParameter(r104, ControlRule.KEY_EXTRA_DATA);
        this.behaviorMappingName = r100;
        this.isFold = r101;
        this.isFromMsg = r102;
        this.f162655id = r103;
        this.extraData = r104;
        this.icon = r105;
    }

    public /* synthetic */ ToolbarBehaviorData(String r100, boolean r101, boolean r110, int r111, String r112, k r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        int r102 = -1;
    L7:
        if ((r114 & 16) == 0) goto L9;
        r112 = "";
    L9:
        this(r100, r101, r110, r102, r112, r113);
        return;
    L5:
        r102 = r111;
        goto L7
    }
}
