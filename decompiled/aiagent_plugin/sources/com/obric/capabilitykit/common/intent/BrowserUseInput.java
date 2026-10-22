package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BrowserIntents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BrowserUseInput implements Parcelable {
    public static final Parcelable.Creator<BrowserUseInput> CREATOR = null;
    private final Boolean clear_first;
    private final Integer index;
    private final String selector;
    private final Boolean submit;
    private final String text;
    private final String value;
    private final String xpath;

    /* JADX INFO: compiled from: BrowserIntents.kt */
    public static final class Creator implements Parcelable.Creator<BrowserUseInput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BrowserUseInput createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            o.e(r14, "parcel");
            if (r14.readInt() != 0) goto L5;
            Integer r4 = null;
        L6:
            String r5 = r14.readString();
            String r6 = r14.readString();
            String r7 = r14.readString();
            String r8 = r14.readString();
            int r11 = 1;
            if (r14.readInt() != 0) goto L10;
            Boolean r9 = null;
        L15:
            if (r14.readInt() != 0) goto L18;
            Boolean r12 = null;
        L22:
            BrowserUseInput r1 = new BrowserUseInput(r4, r5, r6, r7, r8, r9, r12);
            int r2 = Math.min(r0, 0);
            ClassLoader r13 = getClass().getClassLoader();
        L23:
            if (r11 > r2) goto L25;
            r11 = r11 + 1;
        L25:
            if (r11 > r0) goto L27;
            a.a(r14, r13);
            r11 = r11 + 1;
            goto L25
        L27:
            return r1;
        L18:
            if (r14.readInt() == 0) goto L20;
            boolean r3 = true;
        L21:
            r12 = Boolean.valueOf(r3);
            goto L22
        L20:
            r3 = false;
            goto L21
        L10:
            if (r14.readInt() == 0) goto L12;
            boolean r10 = true;
        L13:
            r9 = Boolean.valueOf(r10);
            goto L15
        L12:
            r10 = false;
            goto L13
        L5:
            r4 = Integer.valueOf(r14.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BrowserUseInput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BrowserUseInput[] newArray(int r1) {
            return new BrowserUseInput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BrowserUseInput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ BrowserUseInput copy$default(BrowserUseInput r5, Integer r6, String r7, String r8, String r9, String r10, Boolean r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.index;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.selector;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.text;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.xpath;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.value;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.clear_first;
    L20:
        Boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.submit;
    L23:
        Integer r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Integer component1() {
        return this.index;
    }

    public final String component2() {
        return this.selector;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.xpath;
    }

    public final String component5() {
        return this.value;
    }

    public final Boolean component6() {
        return this.clear_first;
    }

    public final Boolean component7() {
        return this.submit;
    }

    public final BrowserUseInput copy(Integer r9, String r10, String r11, String r12, String r13, Boolean r14, Boolean r15) {
        return new BrowserUseInput(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BrowserUseInput.class) == true) goto L8;
        return false;
    L8:
        BrowserUseInput r6 = (BrowserUseInput) ZeusTransformUtils.preCheckCast(r5, BrowserUseInput.class, "com.obric.aiagent.plugin");
        if (o.a(this.index, r6.index) == true) goto L12;
        return false;
    L12:
        if (o.a(this.selector, r6.selector) == true) goto L15;
        return false;
    L15:
        if (o.a(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (o.a(this.xpath, r6.xpath) == true) goto L21;
        return false;
    L21:
        if (o.a(this.value, r6.value) == true) goto L24;
        return false;
    L24:
        if (o.a(this.clear_first, r6.clear_first) == true) goto L27;
        return false;
    L27:
        if (o.a(this.submit, r6.submit) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.index;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.selector;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.text;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.xpath;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.value;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.clear_first;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.submit;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BrowserUseInput(index=" + this.index + ", selector=" + this.selector + ", text=" + this.text + ", xpath=" + this.xpath + ", value=" + this.value + ", clear_first=" + this.clear_first + ", submit=" + this.submit + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        Integer r0 = this.index;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.selector);
        r3.writeString(this.text);
        r3.writeString(this.xpath);
        r3.writeString(this.value);
        Boolean r1 = this.clear_first;
        if (r1 != null) goto L9;
        r3.writeInt(0);
    L10:
        Boolean r2 = this.submit;
        if (r2 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeInt(r2.booleanValue() ? 1 : 0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r1.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.intValue());
        goto L6
    }

    public BrowserUseInput(Integer r1, String r2, String r3, String r4, String r5, Boolean r6, Boolean r7) {
        this.index = r1;
        this.selector = r2;
        this.text = r3;
        this.xpath = r4;
        this.value = r5;
        this.clear_first = r6;
        this.submit = r7;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final String getSelector() {
        return this.selector;
    }

    public final String getText() {
        return this.text;
    }

    public final String getXpath() {
        return this.xpath;
    }

    public final String getValue() {
        return this.value;
    }

    public final Boolean getClear_first() {
        return this.clear_first;
    }

    public final Boolean getSubmit() {
        return this.submit;
    }
}
