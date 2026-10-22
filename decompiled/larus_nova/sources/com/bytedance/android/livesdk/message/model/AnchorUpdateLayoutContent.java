package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AnchorUpdateLayoutContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0005R\u0016\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/h6;", "", "updateLayoutType", "I", "", "_updateUserID", "J", "get_updateUserID$livemessage_api_saasRelease", "()J", "set_updateUserID$livemessage_api_saasRelease", "(J)V", "", "_updateOpenUserID", "Ljava/lang/String;", "get_updateOpenUserID$livemessage_api_saasRelease", "()Ljava/lang/String;", "set_updateOpenUserID$livemessage_api_saasRelease", "(Ljava/lang/String;)V", "anchorUILayout", "anchorLayoutRange", "operatorOpenId", "getOperatorOpenId", "getUpdateUserID", "updateUserID", "<init>", "()V", "AnchorLayoutRange", "AnchorUILayout", "UpdateAnchorLayoutType", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorUpdateLayoutContent extends FlexModelBase<h6> implements h6, vh7.h {

    @SerializedName("update_open_user_id")
    protected String _updateOpenUserID;

    @SerializedName("update_user_id")
    protected long _updateUserID;

    @SerializedName("anchor_layout_range")
    public int anchorLayoutRange;

    @SerializedName("anchor_ui_layout")
    public int anchorUILayout;

    @SerializedName("operator_open_id")
    protected String operatorOpenId;

    @SerializedName("layout_type")
    public int updateLayoutType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent$AnchorLayoutRange;", "", "AnchorLayoutRangeMyRoom", "AnchorLayoutRangeAllRoom", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnchorLayoutRange extends Enum<AnchorLayoutRange> {
        public static final AnchorLayoutRange AnchorLayoutRangeAllRoom = null;
        public static final AnchorLayoutRange AnchorLayoutRangeMyRoom = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorLayoutRange[] f153550a = null;

        static {
            AnchorLayoutRange r100 = new AnchorLayoutRange("AnchorLayoutRangeMyRoom", 0);
            AnchorLayoutRangeMyRoom = r100;
            AnchorLayoutRange r101 = new AnchorLayoutRange("AnchorLayoutRangeAllRoom", 1);
            AnchorLayoutRangeAllRoom = r101;
            f153550a = new AnchorLayoutRange[]{r100, r101};
        }

        public static AnchorLayoutRange valueOf(String r100) {
            return (AnchorLayoutRange) r27.a.a(AnchorLayoutRange.class, r100);
        }

        public static AnchorLayoutRange[] values() {
            return (AnchorLayoutRange[]) f153550a.clone();
        }

        public AnchorLayoutRange(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent$AnchorUILayout;", "", "AnchorUILayout2V2Equal", "AnchorUILayout1V3", "AnchorUILayoutSmall", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnchorUILayout extends Enum<AnchorUILayout> {
        public static final AnchorUILayout AnchorUILayout1V3 = null;
        public static final AnchorUILayout AnchorUILayout2V2Equal = null;
        public static final AnchorUILayout AnchorUILayoutSmall = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorUILayout[] f153551a = null;

        static {
            AnchorUILayout r100 = new AnchorUILayout("AnchorUILayout2V2Equal", 0);
            AnchorUILayout2V2Equal = r100;
            AnchorUILayout r101 = new AnchorUILayout("AnchorUILayout1V3", 1);
            AnchorUILayout1V3 = r101;
            AnchorUILayout r102 = new AnchorUILayout("AnchorUILayoutSmall", 2);
            AnchorUILayoutSmall = r102;
            f153551a = new AnchorUILayout[]{r100, r101, r102};
        }

        public static AnchorUILayout valueOf(String r100) {
            return (AnchorUILayout) r27.a.a(AnchorUILayout.class, r100);
        }

        public static AnchorUILayout[] values() {
            return (AnchorUILayout[]) f153551a.clone();
        }

        public AnchorUILayout(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AnchorUpdateLayoutContent$UpdateAnchorLayoutType;", "", "UpdateAnchorLayoutTypeUnknown", "EnlargeAllStream", "UnEnlargeAllStream", "EnlargeMyStream", "UnEnlargeMyStream", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum UpdateAnchorLayoutType extends Enum<UpdateAnchorLayoutType> {
        public static final UpdateAnchorLayoutType EnlargeAllStream = null;
        public static final UpdateAnchorLayoutType EnlargeMyStream = null;
        public static final UpdateAnchorLayoutType UnEnlargeAllStream = null;
        public static final UpdateAnchorLayoutType UnEnlargeMyStream = null;
        public static final UpdateAnchorLayoutType UpdateAnchorLayoutTypeUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateAnchorLayoutType[] f153552a = null;

        static {
            UpdateAnchorLayoutType r100 = new UpdateAnchorLayoutType("UpdateAnchorLayoutTypeUnknown", 0);
            UpdateAnchorLayoutTypeUnknown = r100;
            UpdateAnchorLayoutType r101 = new UpdateAnchorLayoutType("EnlargeAllStream", 1);
            EnlargeAllStream = r101;
            UpdateAnchorLayoutType r102 = new UpdateAnchorLayoutType("UnEnlargeAllStream", 2);
            UnEnlargeAllStream = r102;
            UpdateAnchorLayoutType r103 = new UpdateAnchorLayoutType("EnlargeMyStream", 3);
            EnlargeMyStream = r103;
            UpdateAnchorLayoutType r104 = new UpdateAnchorLayoutType("UnEnlargeMyStream", 4);
            UnEnlargeMyStream = r104;
            f153552a = new UpdateAnchorLayoutType[]{r100, r101, r102, r103, r104};
        }

        public static UpdateAnchorLayoutType valueOf(String r100) {
            return (UpdateAnchorLayoutType) r27.a.a(UpdateAnchorLayoutType.class, r100);
        }

        public static UpdateAnchorLayoutType[] values() {
            return (UpdateAnchorLayoutType[]) f153552a.clone();
        }

        public UpdateAnchorLayoutType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AnchorUpdateLayoutContent() {
        super(h6.class);
        this._updateOpenUserID = "";
        this.operatorOpenId = "";
    }

    public final String getUpdateUserID() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this._updateUserID);
        String r102 = this._updateOpenUserID;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public final String getOperatorOpenId() {
        return this.operatorOpenId;
    }

    public final String get_updateOpenUserID$livemessage_api_saasRelease() {
        return this._updateOpenUserID;
    }

    public final long get_updateUserID$livemessage_api_saasRelease() {
        return this._updateUserID;
    }

    public AnchorUpdateLayoutContent(am3.g r100) {
        super(h6.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.updateLayoutType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._updateUserID = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.anchorUILayout = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.anchorLayoutRange = r100.i();
        goto L3
    L14:
        if (r102 != 5000) goto L16;
        this._updateOpenUserID = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5001) goto L17;
        this.operatorOpenId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
        if (this._updateOpenUserID != null) goto L28;
        this._updateOpenUserID = "";
    L28:
        if (this.operatorOpenId != null) goto L52;
        this.operatorOpenId = "";
        return;
    }

    public final void set_updateOpenUserID$livemessage_api_saasRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this._updateOpenUserID = r100;
    }

    public final void set_updateUserID$livemessage_api_saasRelease(long r100) {
        this._updateUserID = r100;
    }
}
