package cfa;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u000b\u0010\u0015¨\u0006("}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;", "", DBDefinition.TASK_ID, "", "sourceFrom", "referenceMsgId", "referenceMsgContent", "startWithAsr", "force", "", "isAppInnerCall", "isAutoOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getTaskId", "()Ljava/lang/String;", "getSourceFrom", "getReferenceMsgId", "getReferenceMsgContent", "getStartWithAsr", "getForce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "startWithAsrEnabled", "default", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenAdditionInputPanelActionParams;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("force")
    private final Boolean force;

    @SerializedName("is_app_inner_call")
    private final Boolean isAppInnerCall;

    @SerializedName("is_auto_open")
    private final Boolean isAutoOpen;

    @SerializedName("reference_msg_content")
    private final String referenceMsgContent;

    @SerializedName("reference_msg_id")
    private final String referenceMsgId;

    @SerializedName("source_from")
    private final String sourceFrom;

    @SerializedName("start_with_asr")
    private final String startWithAsr;

    @SerializedName("task_id")
    private final String taskId;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referenceMsgId, r101.referenceMsgId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceMsgContent, r101.referenceMsgContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startWithAsr, r101.startWithAsr) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.force, r101.force) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isAppInnerCall, r101.isAppInnerCall) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isAutoOpen, r101.isAutoOpen) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sourceFrom;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.referenceMsgId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.referenceMsgContent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.startWithAsr;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.force;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isAppInnerCall;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isAutoOpen;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenAdditionInputPanelActionParams(taskId=" + this.taskId + ", sourceFrom=" + this.sourceFrom + ", referenceMsgId=" + this.referenceMsgId + ", referenceMsgContent=" + this.referenceMsgContent + ", startWithAsr=" + this.startWithAsr + ", force=" + this.force + ", isAppInnerCall=" + this.isAppInnerCall + ", isAutoOpen=" + this.isAutoOpen + ')';
    }

    public final Boolean a() {
        return this.force;
    }

    public final String b() {
        return this.referenceMsgContent;
    }

    public final String c() {
        return this.referenceMsgId;
    }

    public final String d() {
        return this.sourceFrom;
    }

    public final String e() {
        return this.taskId;
    }

    public final Boolean f() {
        return this.isAppInnerCall;
    }

    public final Boolean g() {
        return this.isAutoOpen;
    }

    public d(int r100) {
        this.taskId = null;
        this.sourceFrom = null;
        this.referenceMsgId = null;
        this.referenceMsgContent = null;
        this.startWithAsr = null;
        this.force = null;
        this.isAppInnerCall = null;
        this.isAutoOpen = null;
    }

    public static boolean h(d r100) {
        String r101 = r100.startWithAsr;
        if (r101 == null) goto L7;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L7;
        String r103 = r102.toLowerCase(Locale.ROOT);
    L8:
        if (r103 == null) goto L28;
        int r104 = r103.hashCode();
        if (r104 == 48) goto L25;
        if (r104 != 49) goto L14;
        String r105 = "1";
    L22:
        r103.equals(r105);
        goto L28
    L14:
        if (r104 != 3569038) goto L16;
        r105 = "true";
        goto L22
    L16:
        if (r104 != 97196323) goto L28;
        if (r103.equals("false") == false) goto L28;
    L27:
        return false;
    L25:
        if (r103.equals("0") == true) goto L27;
    L28:
        return true;
    L7:
        r103 = null;
        goto L8
    }
}
