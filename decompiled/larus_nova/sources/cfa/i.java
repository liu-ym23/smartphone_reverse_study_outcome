package cfa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JX\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;", "", "activateClickTalk", "", "assistantRequestFrom", "", "checkScreenLock", "interruptMovingBackground", "forceUseDefaultDisplay", "forceOpenActivity", "isMicInUse", "<init>", "(ZLjava/lang/String;ZZZZLjava/lang/Boolean;)V", "getActivateClickTalk", "()Z", "getAssistantRequestFrom", "()Ljava/lang/String;", "getCheckScreenLock", "getInterruptMovingBackground", "getForceUseDefaultDisplay", "getForceOpenActivity", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "assistantRequestFromOrDefault", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;ZZZZLjava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("activateClickTalk")
    private final boolean activateClickTalk;

    @SerializedName("assistantRequestFrom")
    private final String assistantRequestFrom;

    @SerializedName("checkScreenLock")
    private final boolean checkScreenLock;

    @SerializedName("forceOpenActivity")
    private final boolean forceOpenActivity;

    @SerializedName("forceUseDefaultDisplay")
    private final boolean forceUseDefaultDisplay;

    @SerializedName("interruptMovingBackground")
    private final boolean interruptMovingBackground;

    @SerializedName("isMicInUse")
    private final Boolean isMicInUse;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.activateClickTalk == r101.activateClickTalk) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assistantRequestFrom, r101.assistantRequestFrom) == true) goto L15;
        return false;
    L15:
        if (this.checkScreenLock == r101.checkScreenLock) goto L18;
        return false;
    L18:
        if (this.interruptMovingBackground == r101.interruptMovingBackground) goto L21;
        return false;
    L21:
        if (this.forceUseDefaultDisplay == r101.forceUseDefaultDisplay) goto L24;
        return false;
    L24:
        if (this.forceOpenActivity == r101.forceOpenActivity) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isMicInUse, r101.isMicInUse) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.activateClickTalk == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        String r103 = this.assistantRequestFrom;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.checkScreenLock == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.interruptMovingBackground == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.forceUseDefaultDisplay == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        if (this.forceOpenActivity == true) goto L26;
        r100 = 1237;
    L26:
        int r113 = (r112 + r100) * 31;
        Boolean r114 = this.isMicInUse;
        if (r114 == null) goto L31;
        r104 = r114.hashCode();
    L31:
        return r113 + r104;
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenWindowActionParams(activateClickTalk=" + this.activateClickTalk + ", assistantRequestFrom=" + this.assistantRequestFrom + ", checkScreenLock=" + this.checkScreenLock + ", interruptMovingBackground=" + this.interruptMovingBackground + ", forceUseDefaultDisplay=" + this.forceUseDefaultDisplay + ", forceOpenActivity=" + this.forceOpenActivity + ", isMicInUse=" + this.isMicInUse + ')';
    }

    public final String a() {
        String r100 = this.assistantRequestFrom;
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return "obric_action_open_window";
    L15:
        return r101;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final boolean b() {
        return this.activateClickTalk;
    }

    public final boolean c() {
        return this.checkScreenLock;
    }

    public final boolean d() {
        return this.forceOpenActivity;
    }

    public final boolean e() {
        return this.forceUseDefaultDisplay;
    }

    public final boolean f() {
        return this.interruptMovingBackground;
    }

    public final Boolean g() {
        return this.isMicInUse;
    }

    public i(int r100) {
        this.activateClickTalk = false;
        this.assistantRequestFrom = null;
        this.checkScreenLock = true;
        this.interruptMovingBackground = true;
        this.forceUseDefaultDisplay = false;
        this.forceOpenActivity = false;
        this.isMicInUse = null;
    }
}
