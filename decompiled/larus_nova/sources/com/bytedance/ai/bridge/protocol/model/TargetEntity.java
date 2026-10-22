package com.bytedance.ai.bridge.protocol.model;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "", "scope", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "instance", "", "<init>", "(Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;Ljava/lang/String;)V", "getScope", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "getTarget", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "getInstance", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Scope", "Target", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TargetEntity {

    @SerializedName("instance")
    private final String instance;

    @SerializedName("scope")
    private final Scope scope;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final Target target;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "System", "View", "Main", "Floating", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scope extends Enum<Scope> {

        @SerializedName("floating")
        public static final Scope Floating = null;

        @SerializedName(PullConfiguration.PROCESS_NAME_MAIN)
        public static final Scope Main = null;

        @SerializedName(CameraParam.TYPE_SYSTEM_CAMERA)
        public static final Scope System = null;

        @SerializedName("view")
        public static final Scope View = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scope[] f36071a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36072b = null;

        public static EnumEntries<Scope> getEntries() {
            return f36072b;
        }

        static {
            Scope r100 = new Scope("System", 0);
            System = r100;
            Scope r101 = new Scope("View", 1);
            View = r101;
            Scope r102 = new Scope("Main", 2);
            Main = r102;
            Scope r103 = new Scope("Floating", 3);
            Floating = r103;
            Scope[] r104 = {r100, r101, r102, r103};
            f36071a = r104;
            f36072b = EnumEntriesKt.enumEntries(r104);
        }

        public static Scope[] values() {
            return (Scope[]) f36071a.clone();
        }

        public static Scope valueOf(String r100) {
            return (Scope) a.a(Scope.class, r100);
        }

        public Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/TargetEntity$Target;", "", "text", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "Bridge", "InstanceId", "Self", "Current", CancelRetainContactInfoFunctions.All, "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Target extends Enum<Target> {

        @SerializedName("all")
        public static final Target All = null;

        @SerializedName("bridge")
        public static final Target Bridge = null;

        @SerializedName("current")
        public static final Target Current = null;

        @SerializedName("with_instance_id")
        public static final Target InstanceId = null;

        @SerializedName("self")
        public static final Target Self = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Target[] f36073a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f36074b = null;
        private final String text;

        public static EnumEntries<Target> getEntries() {
            return f36074b;
        }

        static {
            Target r100 = new Target("Bridge", 0, "bridge");
            Bridge = r100;
            Target r101 = new Target("InstanceId", 1, "with_instance_id");
            InstanceId = r101;
            Target r102 = new Target("Self", 2, "self");
            Self = r102;
            Target r103 = new Target("Current", 3, "current");
            Current = r103;
            Target r104 = new Target(CancelRetainContactInfoFunctions.All, 4, "all");
            All = r104;
            Target[] r105 = {r100, r101, r102, r103, r104};
            f36073a = r105;
            f36074b = EnumEntriesKt.enumEntries(r105);
        }

        public static Target[] values() {
            return (Target[]) f36073a.clone();
        }

        public final String getText() {
            return this.text;
        }

        public static Target valueOf(String r100) {
            return (Target) a.a(Target.class, r100);
        }

        public Target(String r100, int r101, String r102) {
            super(r100, r101);
            this.text = r102;
        }
    }

    public TargetEntity() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TargetEntity) == true) goto L8;
        return false;
    L8:
        TargetEntity r101 = (TargetEntity) r100;
        if (this.scope == r101.scope) goto L12;
        return false;
    L12:
        if (this.target == r101.target) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instance, r101.instance) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Scope r100 = this.scope;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Target r104 = this.target;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.instance;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TargetEntity(scope=" + this.scope + ", target=" + this.target + ", instance=" + this.instance + ')';
    }

    public final String a() {
        return this.instance;
    }

    public final Scope b() {
        return this.scope;
    }

    public final Target c() {
        return this.target;
    }

    public TargetEntity(Scope r100, Target r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.scope = r100;
        this.target = r101;
        this.instance = null;
    }
}
