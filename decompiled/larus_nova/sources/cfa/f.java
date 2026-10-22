package cfa;

import com.google.gson.annotations.SerializedName;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\t\u0010\u0011¨\u0006\""}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "", "startWithAsr", "", "content", "sourceFrom", "force", "", "isAppInnerCall", "isAutoOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getStartWithAsr", "()Ljava/lang/String;", "getContent", "getSourceFrom", "getForce", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "startWithAsrEnabled", "default", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenNewTaskPanelActionParams;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("content")
    private final String content;

    @SerializedName("force")
    private final Boolean force;

    @SerializedName("is_app_inner_call")
    private final Boolean isAppInnerCall;

    @SerializedName("is_auto_open")
    private final Boolean isAutoOpen;

    @SerializedName("source_from")
    private final String sourceFrom;

    @SerializedName("start_with_asr")
    private final String startWithAsr;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.startWithAsr, r101.startWithAsr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceFrom, r101.sourceFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.force, r101.force) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAppInnerCall, r101.isAppInnerCall) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isAutoOpen, r101.isAutoOpen) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.startWithAsr;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sourceFrom;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.force;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isAppInnerCall;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isAutoOpen;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "OpenNewTaskPanelActionParams(startWithAsr=" + this.startWithAsr + ", content=" + this.content + ", sourceFrom=" + this.sourceFrom + ", force=" + this.force + ", isAppInnerCall=" + this.isAppInnerCall + ", isAutoOpen=" + this.isAutoOpen + ')';
    }

    public final String a() {
        return this.content;
    }

    public final Boolean b() {
        return this.force;
    }

    public final String c() {
        return this.sourceFrom;
    }

    public final Boolean d() {
        return this.isAppInnerCall;
    }

    public final Boolean e() {
        return this.isAutoOpen;
    }

    public f(int r100) {
        this.startWithAsr = null;
        this.content = null;
        this.sourceFrom = null;
        this.force = null;
        this.isAppInnerCall = null;
        this.isAutoOpen = null;
    }

    public static boolean f(f r100) {
        String r101 = r100.startWithAsr;
        if (r101 == null) goto L7;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L7;
        String r103 = r102.toLowerCase(Locale.ROOT);
    L9:
        if (r103 == null) goto L29;
        int r104 = r103.hashCode();
        if (r104 != 48) goto L13;
        String r105 = "0";
    L20:
        r103.equals(r105);
        return false;
    L13:
        if (r104 == 49) goto L25;
        if (r104 == 3569038) goto L22;
        if (r104 != 97196323) goto L32;
        r105 = "false";
        goto L20
    L32:
        return false;
    L22:
        if (r103.equals("true") == false) goto L33;
    L27:
        return true;
    L33:
        return false;
    L25:
        if (r103.equals("1") == true) goto L27;
        return false;
    L29:
        return false;
    L7:
        r103 = null;
        goto L9
    }
}
