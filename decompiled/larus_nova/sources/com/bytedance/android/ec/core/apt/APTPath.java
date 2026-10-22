package com.bytedance.android.ec.core.apt;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.PdpMonitorSetting;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001'B;\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001f\"\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/core/apt/APTPath;", "Ljava/io/Serializable;", "", "invalid", "Llg/g;", "node", "", "savePathInfo", "Lorg/json/JSONObject;", "pathInfo", "Lorg/json/JSONObject;", "getPathInfo", "()Lorg/json/JSONObject;", "setPathInfo", "(Lorg/json/JSONObject;)V", "", "nodes", "Ljava/util/List;", "getNodes", "()Ljava/util/List;", "setNodes", "(Ljava/util/List;)V", "", "pathId", "Ljava/lang/String;", "getPathId", "()Ljava/lang/String;", "", "enterTimeStamp", "Ljava/lang/Long;", "getEnterTimeStamp", "()Ljava/lang/Long;", "quitTimeStamp", "getQuitTimeStamp", "setQuitTimeStamp", "(Ljava/lang/Long;)V", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class APTPath implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -10;

    @SerializedName("enter_timestamp")
    private final Long enterTimeStamp;

    @SerializedName("nodes")
    private volatile List<JSONObject> nodes;

    @SerializedName("path_id")
    private final String pathId;

    @SerializedName("path_info")
    private JSONObject pathInfo;

    @SerializedName("quit_timestamp")
    private Long quitTimeStamp;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public APTPath() {
        this(null, null, null, null, 15, null);
    }

    public final boolean invalid() {
        if (this.enterTimeStamp == null) goto L19;
        long r100 = System.currentTimeMillis() - this.enterTimeStamp.longValue();
        Set<String> r101 = ECProcessMonitor.f45118a;
        if (ECProcessMonitor.f45120c != null) goto L8;
        ECProcessMonitor.f45120c = ECProcessMonitor.h();
    L8:
        PdpMonitorSetting r102 = ECProcessMonitor.f45120c;
        if (r102 == null) goto L13;
        Integer r103 = r102.getInvalidMinute();
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
    L15:
        if (r100 > (((long) (r104 * 60)) * 1000)) goto L20;
        return false;
    L20:
        return true;
    L13:
        r104 = 10;
        goto L15
    L19:
        return true;
    }

    public final Long getEnterTimeStamp() {
        return this.enterTimeStamp;
    }

    public final List<JSONObject> getNodes() {
        return this.nodes;
    }

    public final String getPathId() {
        return this.pathId;
    }

    public final JSONObject getPathInfo() {
        return this.pathInfo;
    }

    public final Long getQuitTimeStamp() {
        return this.quitTimeStamp;
    }

    public final void savePathInfo(g r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        JSONObject r101 = this.pathInfo;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        r100.getClass();
        r101.put("promotion_id", null);
        r101.put("product_id", null);
        Unit r102 = Unit.INSTANCE;
        this.pathInfo = r101;
    }

    public final void setNodes(List<JSONObject> r100) {
        this.nodes = r100;
    }

    public final void setPathInfo(JSONObject r100) {
        this.pathInfo = r100;
    }

    public final void setQuitTimeStamp(Long r100) {
        this.quitTimeStamp = r100;
    }

    public APTPath(List<JSONObject> r100, String r101, Long r102, Long r103) {
        Intrinsics.checkNotNullParameter(r101, "pathId");
        this.nodes = r100;
        this.pathId = r101;
        this.enterTimeStamp = r102;
        this.quitTimeStamp = r103;
    }

    public /* synthetic */ APTPath(List r100, String r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0L;
    L14:
        this(r100, r101, r102, r103);
    }
}
