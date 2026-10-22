package com.bytedance.android.livesdkapi.message.minigame;

import android.text.Spannable;
import com.bytedance.android.livesdkapi.minigame.IMessage;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J5\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\n\u0010%\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/minigame/LiveMessage;", "Lcom/bytedance/android/livesdkapi/minigame/IMessage;", "Ljava/io/Serializable;", "type", "Lcom/bytedance/android/livesdkapi/message/minigame/MiniGameMessageType;", "spannable", "Landroid/text/Spannable;", PushAction$ESubType.KEY_NAME, "", "button", "", "(Lcom/bytedance/android/livesdkapi/message/minigame/MiniGameMessageType;Landroid/text/Spannable;ILjava/lang/String;)V", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "getSpannable", "()Landroid/text/Spannable;", "setSpannable", "(Landroid/text/Spannable;)V", "getSubtype", "()I", "setSubtype", "(I)V", "getType", "()Lcom/bytedance/android/livesdkapi/message/minigame/MiniGameMessageType;", "setType", "(Lcom/bytedance/android/livesdkapi/message/minigame/MiniGameMessageType;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getButtonText", "getMessageSpannable", "getMessageSubType", "getMessageType", "hashCode", "toString", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMessage implements IMessage, Serializable {
    private String button;
    private Spannable spannable;
    private int subtype;
    private MiniGameMessageType type;

    public static /* synthetic */ LiveMessage copy$default(LiveMessage r100, MiniGameMessageType r101, Spannable r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.spannable;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.subtype;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.button;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final MiniGameMessageType component1() {
        return this.type;
    }

    public final Spannable component2() {
        return this.spannable;
    }

    public final int component3() {
        return this.subtype;
    }

    public final String component4() {
        return this.button;
    }

    public final LiveMessage copy(MiniGameMessageType r100, Spannable r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new LiveMessage(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveMessage) == false) goto L14;
        LiveMessage r101 = (LiveMessage) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.spannable, r101.spannable) == true) goto L10;
        return false;
    L10:
        if (this.subtype == r101.subtype) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        MiniGameMessageType r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Spannable r104 = this.spannable;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.subtype) * 31;
        String r107 = this.button;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveMessage(type=" + this.type + ", spannable=" + this.spannable + ", subtype=" + this.subtype + ", button=" + this.button + ")";
    }

    @Override // com.bytedance.android.livesdkapi.minigame.IMessage
    public int getMessageType() {
        return this.type.getCode();
    }

    public final String getButton() {
        return this.button;
    }

    @Override // com.bytedance.android.livesdkapi.minigame.IMessage
    public String getButtonText() {
        return this.button;
    }

    @Override // com.bytedance.android.livesdkapi.minigame.IMessage
    public Spannable getMessageSpannable() {
        return this.spannable;
    }

    @Override // com.bytedance.android.livesdkapi.minigame.IMessage
    public int getMessageSubType() {
        return this.subtype;
    }

    public final Spannable getSpannable() {
        return this.spannable;
    }

    public final int getSubtype() {
        return this.subtype;
    }

    public final MiniGameMessageType getType() {
        return this.type;
    }

    public final void setButton(String r100) {
        this.button = r100;
    }

    public final void setSpannable(Spannable r100) {
        this.spannable = r100;
    }

    public final void setSubtype(int r100) {
        this.subtype = r100;
    }

    public final void setType(MiniGameMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public LiveMessage(MiniGameMessageType r100, Spannable r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.spannable = r101;
        this.subtype = r102;
        this.button = r103;
    }

    public /* synthetic */ LiveMessage(MiniGameMessageType r100, Spannable r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
